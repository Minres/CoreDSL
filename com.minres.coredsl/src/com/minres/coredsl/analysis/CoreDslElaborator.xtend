package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.DeclarationStatement
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.EntityReference
import com.minres.coredsl.coreDsl.ExpressionInitializer
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.validation.IssueCodes
import java.util.ArrayList
import java.util.HashSet

import static extension com.minres.coredsl.util.ModelExtensions.*

class CoreDslElaborator {

	def static ElaborationContext elaborate(AnalysisContext actx, ISA isa) {
		val ctx = new ElaborationContext(isa, actx);

		buildElaborationOrder(ctx, isa);
		gatherDeclarationsAndAssignments(ctx);
		calculateExpressionValues(ctx);
		validateResults(ctx);
		checkDuplicateDeclarations(ctx);

		// TODO check that declarations are compatible
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

	def private static void gatherDeclarationsAndAssignments(ElaborationContext ctx) {
		for (isa : ctx.elaborationOrder) {
			gatherDeclarationsAndAssignments(ctx, isa);
		}

		ctx.gatherPhaseDone = true;
	}

	def private static void gatherDeclarationsAndAssignments(ElaborationContext ctx, ISA isa) {
		for (stmt : isa.archStateBody) {
			switch (stmt) {
				DeclarationStatement: {
					val type = stmt.declaration.type;
					if(type instanceof IntegerTypeSpecifier && (type as IntegerTypeSpecifier).size !== null) {
						ctx.calculationQueue.add((type as IntegerTypeSpecifier).size);
					}

					for (decl : stmt.declaration.declarators) {
						if(!ctx.declInfo.containsKey(decl.name)) {
							ctx.declInfo.put(decl.name, new ElaborationContext.IsaStateDeclarationInfo(decl.name));
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
					val assignment = stmt.expression.castOrNull(AssignmentExpression);
					val reference = assignment?.target.castOrNull(EntityReference);
					val declarator = reference?.target.castOrNull(Declarator);

					// No errors need to be emitted if this checks fails, because
					// those are handled by the analyzer.
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
				if(ctx.actx.isIsaParameter(info.declarators.get(0))) {
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

	def private static String getSignatureString(Declarator declarator, ElaborationContext ctx,
		boolean isIsaStateElement) {
		var string = '';

		if(declarator.isConst) {
			string += 'const ';
		}
		if(declarator.isVolatile) {
			string += 'volatile ';
		}

		string += ctx.actx.getStorageClass(declarator).name + ' ';

		val type = CoreDslTypeProvider.getSpecifiedType(ctx, declarator.type);
		string += type;

		if(declarator.isAlias) {
			string += '&';
		}
		return string;
	}

	def private static void checkDuplicateDeclarations(ElaborationContext ctx) {
		for (info : ctx.declInfo.values.filter[it.declarators.size > 1]) {
			val signatures = info.declarators.map[it.getSignatureString(ctx, true)];
			val declaringIsas = info.declarators.map[it.ancestorOfType(ISA).name].join(', ');
			if(signatures.length > 0) {
				val signature = signatures.get(0);
				if(signatures.filter[it != signature].size > 0) {
					ctx.acceptError(
						"ISA state element " + info.name +
							" has been declared multiple times with mismatching signatures (in " + declaringIsas + ")",
						ctx.root, CoreDslPackage.Literals.ISA__NAME, -1,
						IssueCodes.MismatchingIsaStateElementSignatures);
				} else if(ctx.actx.isIsaParameter(info.declarators.get(0))) {
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
