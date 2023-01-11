package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.CompositeTypeDeclaration
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DeclarationStatement
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.EntityReference
import com.minres.coredsl.coreDsl.EnumTypeDeclaration
import com.minres.coredsl.coreDsl.ExpressionInitializer
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.util.CompilerAssertion
import com.minres.coredsl.validation.IssueCodes
import java.util.ArrayList
import java.util.HashSet
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.DataExtensions.*
import static extension com.minres.coredsl.util.ModelExtensions.*

class CoreDslElaborator {

	/**
	 * The elaboration phase should produce the following results:
	 * - storage classes of all ISA level declarations
	 * - storage classes of all members of user declared types
	 * - types of all ISA level declarations (register, extern, param)
	 * - types of all members of user declared types
	 * - values of all ISA parameters
	 * - reset values for all register and extern declarations
	 * - values of all enum members
	 * 
	 * The elaboration phase does NOT do the following things:
	 * - 
	 */
	def static ElaborationContext elaborate(ISA isa, ValidationMessageAcceptor acceptor,
		ElaborationContext.SharedResultsCache sharedCache) {
		val ctx = new ElaborationContext(isa, acceptor, sharedCache);

		buildElaborationOrder(ctx, isa);
		traverseElaborationOrder(ctx);
		calculateExpressionValues(ctx);
		validateResults(ctx);
		checkDuplicateDeclarations(ctx);

		return ctx;
	}

	/**
	 * Populates the context's {@link AnalysisContext#elaborationOrder elaborationOrder} list.
	 */
	def private static dispatch void buildElaborationOrder(ElaborationContext ctx, CoreDef core) {
		val providedInstructionSets = new HashSet();

		for (var i = 0; i < core.providedInstructionSets.length; i++) {
			val iset = core.providedInstructionSets.get(i);
			if(providedInstructionSets.add(iset)) {
				buildElaborationOrder(ctx, iset);
			} else {
				ctx.acceptError(
					'Core provides the instruction set ' + iset.name + ' multiple times',
					core,
					CoreDslPackage.Literals.CORE_DEF__PROVIDED_INSTRUCTION_SETS,
					i,
					IssueCodes.MultipleIdenticalProvides
				);
			}
		}

		ctx.elaborationOrder.add(core);
	}

	/**
	 * Populates the context's {@link AnalysisContext#elaborationOrder elaborationOrder} list.
	 */
	def private static dispatch void buildElaborationOrder(ElaborationContext ctx, InstructionSet iset) {

		// check for cyclic inheritance
		if(ctx.currentInheritanceStack.contains(iset)) {
			// only report the error once (when partial elaboration is run for this instruction set)
			if(iset != ctx.root) return;

			val stack = ctx.currentInheritanceStack;
			val chain = stack.subList(stack.indexOf(iset), stack.size) + #[iset];

			ctx.acceptError('Cyclic instruction set inheritance: ' + chain.map[it.name].join(' -> '), iset,
				CoreDslPackage.Literals.INSTRUCTION_SET__SUPER_TYPE, -1, IssueCodes.CyclicInstructionSetInheritance);

			return;
		}

		if(iset.superType !== null) {
			ctx.currentInheritanceStack.push(iset);
			buildElaborationOrder(ctx, iset.superType);
			ctx.currentInheritanceStack.pop();
		}

		if(!ctx.elaborationOrder.contains(iset))
			ctx.elaborationOrder.add(iset);
	}

	def private static void traverseElaborationOrder(ElaborationContext ctx) {
		for (isa : ctx.elaborationOrder) {
			traverseElaborationOrder(ctx, isa);
		}

		ctx.gatherPhaseDone = true;
	}

	def private static dispatch initExposedNames(ElaborationContext ctx, InstructionSet iset) {
		if(ctx.sharedCache.areExposedNamesSet(iset))
			return ctx.sharedCache.getExposedNames(iset);

		val exposedNames = new HashSet<String>();
		ctx.sharedCache.setExposedNames(iset, exposedNames);

		if(iset.superType !== null) {
			val superNames = ctx.sharedCache.getExposedNames(iset.superType);
			CompilerAssertion.assertThat(superNames !== null, "super type has not been pre-analyzed");
			exposedNames.addAll(superNames);
		}
		
		return exposedNames;
	}

	def private static dispatch initExposedNames(ElaborationContext ctx, CoreDef core) {
		val exposedNames = new HashSet<String>();
		ctx.sharedCache.setExposedNames(core, exposedNames);

		for (iset : core.providedInstructionSets) {
			val isetNames = ctx.sharedCache.getExposedNames(iset);
			CompilerAssertion.assertThat(isetNames !== null, "provided instruction set has not been pre-analyzed");
			exposedNames.addAll(isetNames);
		}
		
		return exposedNames;
	}

	def private static determineStorageClasses(ElaborationContext ctx, Declaration declaration) {

		val storageClassSpecifiers = declaration.storage;
		var storageClass = StorageClass.invalid;
		switch (storageClassSpecifiers.size()) {
			case 0: {
				for (declarator : declaration.declarators) {
					if(declarator.isAlias) {
						ctx.sharedCache.setStorageClass(declarator, StorageClass.alias);
					} else {
						ctx.sharedCache.setStorageClass(declarator, StorageClass.param);
					}
				}
				return;
			}
			case 1: {
				switch (storageClassSpecifiers.get(0)) {
					case EXTERN: storageClass = StorageClass.extern
					case REGISTER: storageClass = StorageClass.register
					default: CompilerAssertion.fail("Invalid storage class specifier")
				}
			}
		}

		for (declarator : declaration.declarators) {
			ctx.sharedCache.setStorageClass(declarator, storageClass);
		}
	}

	def private static void traverseElaborationOrder(ElaborationContext ctx, ISA isa) {
		val exposedNames = initExposedNames(ctx, isa);

		for (statement : isa.archStateBody) {
			switch (statement) {
				DeclarationStatement: {
					determineStorageClasses(ctx, statement.declaration);

					val type = statement.declaration.type;
					if(type instanceof IntegerTypeSpecifier && (type as IntegerTypeSpecifier).size !== null) {
						ctx.calculationQueue.add((type as IntegerTypeSpecifier).size);
					}

					for (decl : statement.declaration.declarators) {
						if(!exposedNames.add(decl.name)) {
							ctx.acceptError(
								'An identifier with the name ' + decl.name + ' has already been declared', decl,
								CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.DuplicateIsaStateElement);
						}

						if(!ctx.declInfo.containsKey(decl.name)) {
							ctx.declInfo.put(decl.name, new ElaborationContext.ElaborationDeclarationInfo(decl.name));
						}

						val info = ctx.declInfo.get(decl.name);
						info.declarators.add(decl);

						if(decl.initializer instanceof ExpressionInitializer && !decl.isAlias) {
							val expr = (decl.initializer as ExpressionInitializer).value;
							ctx.calculationQueue.add(expr);
							info.assignments.add(expr);
						}
					}
				}
				
				ExpressionStatement: {
					val assignment = statement.expression.castOrNull(AssignmentExpression);
					val reference = assignment?.target.castOrNull(EntityReference);
					val declarator = reference?.target.castOrNull(Declarator);

					// TODO report errors in analyzer instead, so they are properly forwarded to deriving ISAs

					if(assignment === null) {
						ctx.acceptError('Only assignment expressions are allowed in ISA level expression statements',
							statement, CoreDslPackage.Literals.EXPRESSION_STATEMENT__EXPRESSION, -1,
							IssueCodes.InvalidIsaParameterAssignmentExpression);
						return;
					}

					if(assignment.operator != '=') {
						ctx.acceptError('Only regular assignments (=) are allowed in ISA level expression statements',
							assignment, CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR, -1,
							IssueCodes.InvalidIsaParameterAssignmentOperator);
						return;
					}

					if(declarator === null || !ctx.sharedCache.isIsaParameter(declarator) || declarator.isConst) {
						ctx.acceptError('ISA level assignment must assign to a non-constant ISA parameter', assignment,
							CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__TARGET, -1,
							IssueCodes.InvalidIsaParameterAssignmentTarget);
						return;
					}

					if(declarator !== null) {
						val info = ctx.declInfo.get(declarator.name)
						if(info !== null) {
							ctx.calculationQueue.add(assignment.value);
							info.assignments.add(assignment.value);
						}
					}
				}
			}
		}

		for (type : isa.types) {
			switch (type) {
				EnumTypeDeclaration: {
					for (decl : type.members) {
						if(!ctx.declInfo.containsKey(decl.name)) {
							ctx.declInfo.put(decl.name, new ElaborationContext.ElaborationDeclarationInfo(decl.name));
						}

						val info = ctx.declInfo.get(decl.name);
						info.declarators.add(decl);

						if(decl.initializer instanceof ExpressionInitializer) {
							val expr = (decl.initializer as ExpressionInitializer).value;
							ctx.calculationQueue.add(expr);
							info.assignments.add(expr);
						}
					}
				}
				CompositeTypeDeclaration: {
					for (declaration : type.members) {
						for (decl : declaration.declarators) {
							val name = type.name + '.' + decl.name;

							if(!ctx.declInfo.containsKey(name)) {
								ctx.declInfo.put(name, new ElaborationContext.ElaborationDeclarationInfo(name));
							}

							val info = ctx.declInfo.get(name);
							info.declarators.add(decl);

							if(decl.initializer instanceof ExpressionInitializer) {
								val expr = (decl.initializer as ExpressionInitializer).value;
								ctx.calculationQueue.add(expr);
								info.assignments.add(expr);
							}
						}
					}
				}
			}
		}
	}

	def private static void calculateExpressionValues(ElaborationContext ctx) {
		var completed = new ArrayList();

		while(true) {
			for (expression : ctx.calculationQueue) {
				val result = CoreDslConstantExpressionEvaluator.evaluate(ctx, expression);
				// Both valid and invalid results are recorded (invalid means that an
				// unrecoverable error occurred, so we don't need to retry)
				if(!result.isIndeterminate) {
					completed.add(expression);
					ctx.calculatedValues.put(expression, result);
				}
			}

			if(completed.empty) {
				// No new results, so we're done
				// Everything left in the queue is indeterminate
				if(!ctx.calculationQueue.empty) {
					// TODO emit errors
				}

				return;
			} else {
				ctx.calculationQueue.removeAll(completed);
				completed.clear();
			}
		}
	}

	def private static void validateResults(ElaborationContext ctx) {
		if(ctx.isPartialElaboration) return;

		val unassignedParameters = new ArrayList();
		val indeterminableValues = new ArrayList();
		val invalidValues = new ArrayList();
		val indeterminableTypes = new ArrayList();
		val invalidTypes = new ArrayList();

		for (info : ctx.declInfo.values) {
			if(info.assignments.empty) {
				if(ctx.sharedCache.isIsaParameter(info.declarators.get(0))) {
					unassignedParameters.add(info.name);
				}
			} else {
				val value = ctx.getCalculatedValue(info.name);
				if(value.isIndeterminate) indeterminableValues.add(info.name);
				if(value.isInvalid) invalidValues.add(info.name);
			}

			val type = ctx.getCalculatedType(info.name);
			if(type.isIndeterminate) indeterminableTypes.add(info.name);
			if(type.isInvalid) invalidTypes.add(info.name);
		}

		if(!unassignedParameters.empty) {
			ctx.acceptError("The following ISA parameters are never assigned: " + unassignedParameters.join(', '),
				ctx.root, CoreDslPackage.Literals.ISA__NAME, -1, IssueCodes.UnassignedIsaParameter);
		}

		if(!indeterminableValues.empty) {
			ctx.acceptError(
				"The values of the following state elements could not be determined because they depend on other indeterminable values: " +
					indeterminableValues.join(', '), ctx.root, CoreDslPackage.Literals.ISA__NAME, -1,
				IssueCodes.IndeterminableIsaStateElementValue);
		}

		if(!invalidValues.empty) {
			ctx.acceptError("The values of the following state elements could not be determined: " +
				invalidValues.join(', '), ctx.root, CoreDslPackage.Literals.ISA__NAME, -1,
				IssueCodes.InvalidIsaStateElementValue);
		}

		if(!indeterminableTypes.empty) {
			ctx.acceptError(
				"The types of the following state elements could not be determined because they depend on other indeterminable values: " +
					indeterminableTypes.join(', '), ctx.root, CoreDslPackage.Literals.ISA__NAME, -1,
				IssueCodes.IndeterminableIsaStateElementType);
		}

		if(!invalidTypes.empty) {
			ctx.acceptError("The types of the following state elements could not be determined: " +
				invalidTypes.join(', '), ctx.root, CoreDslPackage.Literals.ISA__NAME, -1,
				IssueCodes.InvalidIsaStateElementType);
		}
	}

	def private static String getSignatureString(Declarator declarator, ElaborationContext ctx) {
		var string = '';

		if(declarator.isConst) {
			string += 'const ';
		}

		if(declarator.isVolatile) {
			string += 'volatile ';
		}

		val storage = declarator.declaration?.storage;
		if(storage !== null && storage.length > 0) {
			val class = storage.length > 1 ? 'error' : storage.get(0);
			string += class + ' ';
		}

		val type = CoreDslTypeProvider.getSpecifiedType(ctx, declarator.type);
		string += type;

		if(declarator.isAlias) {
			string += '&';
		}
		return string;
	}

	def private static void checkDuplicateDeclarations(ElaborationContext ctx) {
		for (info : ctx.declInfo.values.filter[it.declarators.size > 1]) {
			val signatures = info.declarators.map[it.getSignatureString(ctx)];
			val declaringIsas = info.declarators.map[it.ancestorOfType(ISA).name].join(', ');
			if(signatures.length > 0) {
				val signature = signatures.get(0);
				if(signatures.filter[it != signature].size > 0) {
					ctx.acceptError(
						"ISA state element " + info.name +
							" has been declared multiple times with mismatching signatures (in " + declaringIsas + ")",
						ctx.root, CoreDslPackage.Literals.ISA__NAME, -1,
						IssueCodes.MismatchingIsaStateElementSignatures);
				} else if(ctx.sharedCache.isIsaParameter(info.declarators.get(0))) {
					ctx.acceptWarning(
						"ISA parameter " + info.name + " has been declared multiple times (in " + declaringIsas + ")",
						ctx.root, CoreDslPackage.Literals.ISA__NAME, -1, IssueCodes.DuplicateIsaStateElement);
				} else {
					ctx.acceptError(
						"ISA state element " + info.name + " has been declared multiple times (in " +
							declaringIsas + ")", ctx.root, CoreDslPackage.Literals.ISA__NAME, -1,
						IssueCodes.DuplicateIsaStateElement);
				}
			}
		}
	}
}
