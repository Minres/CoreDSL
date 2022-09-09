package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.Attribute
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
import com.minres.coredsl.coreDsl.StorageClassSpecifier
import com.minres.coredsl.coreDsl.TypeQualifier
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.validation.IssueCodes
import com.minres.coredsl.validation.KnownAttributes.AttributeUsage
import java.util.HashSet
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.ModelExtensions.*
import com.minres.coredsl.coreDsl.BoolTypeSpecifier
import com.minres.coredsl.coreDsl.VoidTypeSpecifier

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

					if(declarator === null || !declarator.isParameter || declarator.isConst) {
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

		for (declarator : declaration.declarators) {
			analyzeDeclarator(ctx, declarator, isIsaStateElement);
		}

		for (attribute : declaration.attributes) {
			analyzeAttribute(ctx, attribute, AttributeUsage.declaration);
		}

		if(!isIsaStateElement) {
			if(declaration.storage.size > 0) {
				ctx.acceptor.acceptError("Storage class specifiers are only allowed on ISA level declarations",
					declaration, CoreDslPackage.Literals.DECLARATION__STORAGE, -1,
					IssueCodes.StorageClassSpecifierOnLocalVariable);
			}
		} else {
			if(declaration.isParameter) {
				if(!(declaration.type instanceof IntegerTypeSpecifier ||
					declaration.type instanceof BoolTypeSpecifier)) {
					ctx.acceptor.acceptError("ISA parameters may only have integer types (signed, unsigned, bool)",
						declaration, CoreDslPackage.Literals.DECLARATION__TYPE, -1, IssueCodes.InvalidIsaParameterType);
				}

				for (var i = 0; i < declaration.qualifiers.size; i++) {
					val qualifier = declaration.qualifiers.get(i);
					if(qualifier === TypeQualifier.VOLATILE) {
						ctx.acceptor.acceptError("ISA parameters may not be declared as volatile", declaration,
							CoreDslPackage.Literals.DECLARATION__QUALIFIERS, i,
							IssueCodes.InvalidIsaParameterDeclaration);
					}
				}
			}
		}

		val seenQualifiers = new HashSet();
		for (var i = 0; i < declaration.qualifiers.size; i++) {
			val qualifier = declaration.qualifiers.get(i);
			if(!seenQualifiers.add(qualifier)) {
				ctx.acceptor.acceptError("Duplicate qualifier " + qualifier.literal, declaration,
					CoreDslPackage.Literals.DECLARATION__QUALIFIERS, i, IssueCodes.DuplicateQualifier);
			}
		}

		val seenStorage = new HashSet();
		for (var i = 0; i < declaration.storage.size; i++) {
			val storage = declaration.storage.get(i);
			if(!seenStorage.add(storage)) {
				ctx.acceptor.acceptError("Duplicate storage class specifier " + storage.literal, declaration,
					CoreDslPackage.Literals.DECLARATION__STORAGE, i, IssueCodes.DuplicateStorageClassSpecifier);
			}
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

		if(declarator.isParameter) {
			if(declarator.isAlias) {
				ctx.acceptor.acceptError("An ISA parameter may not be declared as an alias", declarator,
					CoreDslPackage.Literals.DECLARATOR__ALIAS, -1, IssueCodes.InvalidIsaParameterDeclaration);
			}
			if(!declarator.dimensions.empty) {
				ctx.acceptor.acceptError("An ISA parameter may not be declared as an array", declarator,
					CoreDslPackage.Literals.DECLARATOR__DIMENSIONS, 1, IssueCodes.InvalidIsaParameterDeclaration);
			}
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
