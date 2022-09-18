package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.Attribute
import com.minres.coredsl.coreDsl.BoolTypeSpecifier
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DeclarationStatement
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.EntityReference
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.coreDsl.TypeQualifier
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.VoidTypeSpecifier
import com.minres.coredsl.util.CompilerAssertion
import com.minres.coredsl.validation.IssueCodes
import com.minres.coredsl.validation.KnownAttributes.AttributeUsage
import java.util.HashSet
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.ModelExtensions.*

class CoreDslAnalyzer {

	def static void analyze(DescriptionContent desc, ValidationMessageAcceptor acceptor) {
		val ctx = new AnalysisContext(acceptor);

		for (isa : desc.definitions) {
			analyzeIsaArchState(ctx, isa);
			val ectx = CoreDslElaborator.elaborate(ctx, isa);
			ctx.elaborationResults.put(isa, ectx);
		}
	}

	def private static dispatch void analyzeIsaArchState(AnalysisContext ctx, InstructionSet iset) {
		if(ctx.exposedDeclarations.containsKey(iset)) return;

		val declaredNames = new HashSet<String>();
		ctx.exposedDeclarations.put(iset, declaredNames);

		if(iset.superType !== null) {
			if(!ctx.exposedDeclarations.containsKey(iset.superType)) {
				analyzeIsaArchState(ctx, iset.superType);
			}
			declaredNames.addAll(ctx.exposedDeclarations.get(iset.superType));
		}

		analyzeIsaArchStateBody(ctx, iset, declaredNames);
	}

	def private static dispatch void analyzeIsaArchState(AnalysisContext ctx, CoreDef core) {
		val declaredNames = new HashSet<String>();

		for (iset : core.providedInstructionSets) {
			if(!ctx.exposedDeclarations.containsKey(iset)) {
				analyzeIsaArchState(ctx, iset);
			}
			declaredNames.addAll(ctx.exposedDeclarations.get(iset));
		}

		analyzeIsaArchStateBody(ctx, core, declaredNames);
	}

	def static analyzeIsaArchStateBody(AnalysisContext ctx, ISA isa, HashSet<String> declaredNames) {
		for (statement : isa.archStateBody) {
			switch (statement) {
				DeclarationStatement: {
					analyzeDeclaration(ctx, statement.declaration, true);

					for (decl : statement.declaration.declarators) {
						if(!declaredNames.add(decl.name)) {
							ctx.acceptor.acceptError(
								'An ISA state element with the name ' + decl.name + ' has already been declared', decl,
								CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.DuplicateIsaStateElement);
						}
					}
				}
				ExpressionStatement: {
					val assignment = statement.expression.castOrNull(AssignmentExpression);

					if(assignment === null) {
						ctx.acceptor.acceptError(
							'Only assignment expressions are allowed in ISA level expression statements', statement,
							CoreDslPackage.Literals.EXPRESSION_STATEMENT__EXPRESSION, -1,
							IssueCodes.InvalidIsaParameterAssignmentExpression);
						return;
					}

					if(assignment.operator != '=') {
						ctx.acceptor.acceptError(
							'Only regular assignments (=) are allowed in ISA level expression statements', assignment,
							CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR, -1,
							IssueCodes.InvalidIsaParameterAssignmentOperator);
						return;
					}

					val entityReference = assignment.target.castOrNull(EntityReference);
					val declarator = entityReference?.target.castOrNull(Declarator);

					if(declarator === null || !ctx.isIsaParameter(declarator) || declarator.isConst) {
						ctx.acceptor.acceptError('ISA level assignment must assign to a non-constant ISA parameter',
							assignment, CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__TARGET, -1,
							IssueCodes.InvalidIsaParameterAssignmentTarget);
						return;
					}

					analyzeConstantExpression(ctx, assignment.value);
				}
			}
		}
	}

	def static analyzeDeclaration(AnalysisContext ctx, Declaration declaration, boolean isIsaStateElement) {
		analyzeTypeSpecifier(ctx, declaration.type);

		if(declaration.type instanceof VoidTypeSpecifier) {
			ctx.acceptor.acceptError("Identifiers may not be declared as type void", declaration,
				CoreDslPackage.Literals.DECLARATION__TYPE, -1, IssueCodes.VoidDeclaration);
		}

		val seenQualifiers = new HashSet();
		for (var i = 0; i < declaration.qualifiers.size; i++) {
			val qualifier = declaration.qualifiers.get(i);
			if(!seenQualifiers.add(qualifier)) {
				ctx.acceptor.acceptError("Duplicate qualifier " + qualifier.literal, declaration,
					CoreDslPackage.Literals.DECLARATION__QUALIFIERS, i, IssueCodes.DuplicateQualifier);
			}
		}

		val storageClassSpecifiers = declaration.storage;
		var storageClass = StorageClass.invalid;
		switch (storageClassSpecifiers.size()) {
			case 0: {
				val hasNonAliasDeclarator = declaration.declarators.findFirst[!it.alias] !== null;
				val hasAliasDeclarator = declaration.declarators.findFirst[it.alias] !== null;

				if(hasNonAliasDeclarator && hasAliasDeclarator) {
					ctx.acceptor.acceptError("A declaration may not mix non-alias and alias declarators", declaration,
						CoreDslPackage.Literals.DECLARATION__DECLARATORS, -1, IssueCodes.MixedAliasnessDeclaration);
				} else {
					storageClass = hasAliasDeclarator ? StorageClass.alias : StorageClass.param;
					if(hasAliasDeclarator) {
						storageClass = StorageClass.alias;
					} else {
						storageClass = isIsaStateElement ? StorageClass.param : StorageClass.local;
					}
				}
			}
			case 1: {
				if(isIsaStateElement) {
					switch (storageClassSpecifiers.get(0)) {
						case EXTERN: storageClass = StorageClass.extern
						case REGISTER: storageClass = StorageClass.register
						default: CompilerAssertion.fail("Invalid storage class specifier")
					}
				} else {
					ctx.acceptor.acceptError("Storage class specifiers are only allowed on ISA level declarations",
						declaration, CoreDslPackage.Literals.DECLARATION__STORAGE, -1,
						IssueCodes.StorageClassSpecifierOnLocalVariable);
				}
			}
			default: {
				ctx.acceptor.acceptError("A declaration may not specify more than one storage class", declaration,
					CoreDslPackage.Literals.DECLARATION__STORAGE, 1 /* show it on the second specifier */ ,
					IssueCodes.MultipleStorageClassSpecifiers);
			}
		}
		ctx.storageClasses.put(declaration, storageClass);

		if(storageClass === StorageClass.param) {
			if(!(declaration.type instanceof IntegerTypeSpecifier || declaration.type instanceof BoolTypeSpecifier)) {
				ctx.acceptor.acceptError("ISA parameters may only have integer types (signed, unsigned, bool)",
					declaration, CoreDslPackage.Literals.DECLARATION__TYPE, -1, IssueCodes.InvalidIsaParameterType);
			}

			for (var i = 0; i < declaration.qualifiers.size; i++) {
				val qualifier = declaration.qualifiers.get(i);
				if(qualifier === TypeQualifier.VOLATILE) {
					ctx.acceptor.acceptError("ISA parameters may not be declared as volatile", declaration,
						CoreDslPackage.Literals.DECLARATION__QUALIFIERS, i, IssueCodes.InvalidIsaParameterDeclaration);
				}
			}
		}

		for (declarator : declaration.declarators) {
			analyzeDeclarator(ctx, declarator, isIsaStateElement);
		}
	}

	def static analyzeAttribute(AnalysisContext ctx, Attribute attribute, AttributeUsage usage) {
		// TODO
	}

	def static analyzeDeclarator(AnalysisContext ctx, Declarator declarator, boolean isIsaStateElement) {
		if(declarator.isConst && declarator.initializer === null) {
			ctx.acceptor.acceptError("An identifier declared as const must be initialized", declarator,
				CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.UninitializedConstant);
		}

		if(declarator.isAlias) {
			if(!isIsaStateElement) {
				ctx.acceptor.acceptError("A local variable may not be declared as alias", declarator,
					CoreDslPackage.Literals.DECLARATOR__ALIAS, -1, IssueCodes.AliasLocalVariable);
			}

			if(declarator.initializer === null) {
				ctx.acceptor.acceptError("An identifier declared as alias must be initialized", declarator,
					CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.UninitializedAlias);
			}
		}

		if(!declarator.dimensions.empty && ctx.isIsaParameter(declarator)) {
			ctx.acceptor.acceptError("An ISA parameter may not be declared as an array", declarator,
				CoreDslPackage.Literals.DECLARATOR__DIMENSIONS, 1, IssueCodes.InvalidIsaParameterDeclaration);
		}

		for (attribute : declarator.attributes) {
			analyzeAttribute(ctx, attribute, AttributeUsage.declaration);
		}
	}

	def private static dispatch void analyzeTypeSpecifier(AnalysisContext ctx, IntegerTypeSpecifier spec) {
		// TODO
		if(spec.size !== null) analyzeConstantExpression(ctx, spec.size);
	}

	def private static dispatch void analyzeTypeSpecifier(AnalysisContext ctx, VoidTypeSpecifier spec) {
		// TODO
	}

	def private static dispatch void analyzeTypeSpecifier(AnalysisContext ctx, TypeSpecifier spec) {
		// TODO
	}

	def private static dispatch void analyzeConstantExpression(AnalysisContext ctx, Expression expr) {
		// TODO check that only visible parameters are used
	}
}
