package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.BoolTypeSpecifier
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.EntityReference
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.ExpressionInitializer
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.type.CoreDslType
import com.minres.coredsl.type.ErrorType
import com.minres.coredsl.validation.IssueCodes
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.ModelExtensions.*
import static extension com.minres.coredsl.util.ModelUtil.*

class CoreDslElaborator {
	private new() {}
	
	static class ConstantDefinitionInfo {
		public val String name;
		public val List<TypeSpecifier> types = new ArrayList;
		public val List<Declarator> declarators = new ArrayList;
		public val List<Expression> assignments = new ArrayList;
		
		public var CoreDslType calculatedType;
		public var ConstantValue calculatedValue;
		public var Integer calculatedBitSize;
		
		new(String name) {
			this.name = name;
		}
	}
	
	// note: only ever report errors within the lexical scope of the root ISA passed here
	static def void elaborate(ISA isa, ValidationMessageAcceptor acceptor) {
		val ctx = new AnalysisContext(isa, acceptor);
		
		buildElaborationOrder(ctx, isa);
		
		collectConstants(ctx);
		calculateConstantValues(ctx);
		mergeConstantDeclarations(ctx);
		validateConstantDeclarations(ctx);
		
	}

	/**
	 * Populates the context's {@link AnalysisContext#elaborationOrder elaborationOrder} list.
	 */
	private static def dispatch void buildElaborationOrder(AnalysisContext ctx, CoreDef core) {
		for(iset : core.providedInstructionSets) {
			buildElaborationOrder(ctx, iset);
		}
		ctx.elaborationOrder.add(core);
	}

	/**
	 * Populates the context's {@link AnalysisContext#elaborationOrder elaborationOrder} list.
	 */
	private static def dispatch void buildElaborationOrder(AnalysisContext ctx, InstructionSet iset) {
		
		// check for cyclic inheritance
		if(ctx.currentInheritanceStack.contains(iset)) {
			// only report the error once (when partial elaboration is run for this instruction set)
			if(iset != ctx.root) return;
			
			val stack = ctx.currentInheritanceStack;
			val chain = stack.subList(stack.indexOf(iset), stack.size) + #[iset];
			
			ctx.acceptor.acceptError(
				'Cyclic instruction set inheritance: ' + chain.map[it.name].join(' -> '),
				iset, CoreDslPackage.Literals.INSTRUCTION_SET__SUPER_TYPE,
				-1, IssueCodes.CyclicInstructionSetInheritance);
			return;
		}
		
		ctx.currentInheritanceStack.push(iset);
		{
			if(iset.superType !== null)
				buildElaborationOrder(ctx, iset.superType);
			
			if(!ctx.elaborationOrder.contains(iset))
				ctx.elaborationOrder.add(iset);
		}
		ctx.currentInheritanceStack.pop();
	}

	private static def void registerDeclarator(AnalysisContext ctx, Declarator declarator) {
		val name = declarator.name;
		val typeSpecifier = declarator.typeSpecifier;
		if(!ctx.constantDefinitions.containsKey(name))
			ctx.constantDefinitions.put(name, new ConstantDefinitionInfo(name));
		
		val constant = ctx.constantDefinitions.get(name);
		constant.declarators.add(declarator);
		constant.types.add(typeSpecifier);
		
		switch(typeSpecifier) {
			IntegerTypeSpecifier | BoolTypeSpecifier: {}
			
			default: {
				ctx.acceptor.acceptError(
					'ISA level declarations may only use integer types',
					declarator.declaration, CoreDslPackage.Literals.DECLARATION__TYPE,
					-1, IssueCodes.InvalidIsaConstantType);
			}
		}
		
		if(declarator.initializer !== null) {
			val initializer = declarator.initializer;
			val expression = switch initializer { ExpressionInitializer: initializer.value };
			if(expression === null) {
				ctx.acceptor.acceptError(
					'ISA level declarations may only use expression initializers',
					declarator, CoreDslPackage.Literals.DECLARATOR__INITIALIZER,
					-1, IssueCodes.InvalidIsaConstantAssignmentInitializer);
				return;
			}
			
			constant.assignments.add(expression);
		}
	}
		
	private static def void registerAssignment(AnalysisContext ctx, ExpressionStatement statement) {
		val expression = statement.expression;
		val assignment = switch expression { AssignmentExpression: expression };
		
		if(assignment === null) {
			ctx.acceptor.acceptError(
				'Only assignment expressions are allowed in ISA level expression statements',
				statement, CoreDslPackage.Literals.EXPRESSION_STATEMENT__EXPRESSION,
				-1, IssueCodes.InvalidIsaConstantAssignmentExpression);
			return;
		}
		
		if(assignment.operator != '=') {
			ctx.acceptor.acceptError(
				'Only regular assignments are allowed on ISA level constants',
				assignment, CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR,
				-1, IssueCodes.InvalidIsaConstantAssignmentOperator);
			return;
		}
		
		// If someone knows an easier way to perform all of these type checks
		// without repeating the if below, let me know. I just wish the `as`
		// operator worked like it does in C#.
		val assignmentTarget = assignment.target;
		val entityReference = switch assignmentTarget { EntityReference: assignmentTarget };
		val referenceTarget = entityReference?.target;
		val declarator =  switch referenceTarget { Declarator: referenceTarget };
		val name = declarator?.name;
		val info = ctx.constantDefinitions.get(name);
		
		if(declarator === null || info === null || !info.declarators.contains(declarator)) {
			// invalid assignment target
			ctx.acceptor.acceptError(
				'ISA level assignment must assign to an ISA constant',
				assignment, CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__TARGET,
				-1, IssueCodes.InvalidIsaConstantAssignmentTarget);
			return;
		}
		
		info.assignments.add(assignment.value);
	}

	/**
	 * Registers all declarators and assignments within the {@code architectural_state} sections from the elaboration order.
	 */
	private static def void collectConstants(AnalysisContext ctx) {
		for(isa : ctx.elaborationOrder) {
			for(declarator : isa.declaredConstants) {
				ctx.registerDeclarator(declarator);
			}
			for(statement : isa.assignments) {
				ctx.registerAssignment(statement);
			}
		}
	}
	
	private static def boolean consolidateValues(AnalysisContext ctx, ConstantDefinitionInfo constant, ConstantValue value) {
		if(constant.calculatedValue == value) return true;
		if(constant.calculatedValue === null) {
			constant.calculatedValue = value;
			return true;
		}

		val errorNodes = constant.assignments
			.map[it.eContainer]
			.filter[it.parentOfType(ISA) == ctx.root];

		for(node : errorNodes) {
			switch(node) {
				Declarator: {
					ctx.acceptor.acceptError(
						'Multiple mismatching ISA constant definitions',
						node, CoreDslPackage.Literals.DECLARATOR__TEQUALS,
						-1, IssueCodes.MismatchingIsaConstantValues);
				}
				AssignmentExpression: {
					ctx.acceptor.acceptError(
						'Multiple mismatching ISA constant definitions',
						node, CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR,
						-1, IssueCodes.MismatchingIsaConstantValues);
				}
			}
		}
		
		return false;
	}
	
	private static def boolean consolidateTypes(AnalysisContext ctx, ConstantDefinitionInfo constant, CoreDslType type) {
		if(constant.calculatedType == type) return true;
		if(constant.calculatedType === null) {
			constant.calculatedType = type;
			return true;
		}

		val errorDeclarators = constant.declarators
			.filter[it.parentOfType(ISA) == ctx.root];

		for(declarator : errorDeclarators) {
			ctx.acceptor.acceptError(
				'ISA constant ' + declarator.name + ' was declared multiple times with different types',
				declarator, CoreDslPackage.Literals.NAMED_ENTITY__NAME,
				-1, IssueCodes.MismatchingIsaConstantTypes);
		}
		
		return false;
	}
	
	private static class CalculationJob {
		public val EObject node;
		public val ConstantDefinitionInfo constant;
		
		new(EObject node, ConstantDefinitionInfo constant) {
			this.node = node;
			this.constant = constant;
		}
	}
	
	/*
	 * Basic idea: Type sizes and constant values can depend on each other,
	 * so we treat all type sizes as implicit constants. For each constant
	 * assignment expression and each declarator a "job" is generated. A job
	 * either determines the size of a type or the value of an expression.
	 * 
	 * The implementation starts off knowing none of the values and tries to
	 * execute every job. A job can either succeed (if all required values
	 * are already available), or fail -- either because the expression is
	 * invalid, or because it depends on some other value that has not been
	 * determined yet.
	 * 
	 * The solver iterates until either all jobs have been completed, or an
	 * iteration did not generate any new results. In the latter case, the
	 * appropriate errors are generated.
	 */
	private static def void calculateConstantValues(AnalysisContext ctx) {
		val errorJobs = new HashSet<CalculationJob>;
		val finishedJobs = new HashSet<CalculationJob>;
		val remainingJobs = ctx.constantDefinitions
			.values()
			.flatMap[constant|
				(constant.assignments + constant.types)
				.map[new CalculationJob(it, constant)]]
			.toSet();
		
		var continue = true;
		
		while(continue && !remainingJobs.empty) {
			for(job : remainingJobs) {
				val node = job.node;
				switch(node) {
					Expression: {
						val value = CoreDslConstantExpressionEvaluator.evaluate(ctx, node);
						
						if(value.isValid) {
							finishedJobs.add(job);
							if(consolidateValues(ctx, job.constant, value)) {
								ctx.acceptor.acceptInfo(
									'Evaluates to ' + value.value,
									node.eContainer, node.eContainingFeature,
									-1, IssueCodes.DebugInfo);
							}
						}
						else if(value.status == ConstantValue.StatusCode.invalid) {
							finishedJobs.add(job);
							errorJobs.add(job);
						}
					}
					
					TypeSpecifier: {
						val type = CoreDslTypeProvider.getSpecifiedType(ctx, node);
						
						if(type.isValid) {
							finishedJobs.add(job);
							if(consolidateTypes(ctx, job.constant, type)) {
								ctx.acceptor.acceptInfo(
									'Type has size ' + type.bitSize,
									node.eContainer, node.eContainingFeature,
									-1, IssueCodes.DebugInfo);
							}
						}
						else if((type as ErrorType).errorCode == ErrorType.ErrorCode.invalid) {
							finishedJobs.add(job);
							errorJobs.add(job);
						}
					}
				}
			}
			
			// no more progress -> either done or deadlock
			if(finishedJobs.empty)
				continue = false;
			
			remainingJobs.removeAll(finishedJobs);
			finishedJobs.clear();
		}
		
		// do not report errors on instruction sets, as they may be incomplete
		if(!ctx.isPartialAnalysis) {
			val constants = ctx.constantDefinitions.values;
			val constantsWithoutAssignments = constants.filter[it.assignments.empty];
			
			for(constant : constantsWithoutAssignments) {
				val errorDeclarators = constant.declarators.filter[it.parentOfType(ISA) == ctx.root];
				
				for(declarator : errorDeclarators) {
					ctx.acceptor.acceptError(
						'Constant is never assigned',
						declarator, CoreDslPackage.Literals.NAMED_ENTITY__NAME,
						-1, IssueCodes.IndeterminableIsaConstantValue);
				}
			}
			
			val failedValueJobs = remainingJobs.filter[it.node instanceof Expression].toList();
			for(job : failedValueJobs.filter[it.node.parentOfType(ISA) == ctx.root]) {
				switch(job.node.eContainer) {
					ExpressionInitializer: {
						ctx.acceptor.acceptError(
							errorJobs.contains(job)
							? 'Constant value can not be determined'
							: 'Constant value can not be determined because it depends on another indeterminable constant',
							job.node.eContainer.eContainer, CoreDslPackage.Literals.NAMED_ENTITY__NAME,
							-1, IssueCodes.IndeterminableIsaConstantValue);
					}
					AssignmentExpression: {
						ctx.acceptor.acceptError(
							errorJobs.contains(job)
							? 'Constant value can not be determined'
							: 'Constant value can not be determined because it depends on another indeterminable constant',
							job.node.eContainer, CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__VALUE,
							-1, IssueCodes.IndeterminableIsaConstantValue);
					}
				}
			}
			
			val failedTypeJobs = remainingJobs.filter[it.node instanceof TypeSpecifier].toList();
			for(job : failedTypeJobs) {
				val declarator = job.constant.declarators.findFirst[it.typeSpecifier == job.node];
				ctx.acceptor.acceptError(
					errorJobs.contains(job)
					? 'Constant type can not be determined'
					: 'Constant type can not be determined because it depends on another indeterminable constant',
					declarator, CoreDslPackage.Literals.NAMED_ENTITY__NAME,
					-1, IssueCodes.IndeterminableIsaConstantValue);
			}
			
			val failedValueConstants = constants.filter[it.calculatedValue === null].map[it.name].toList();
			if(!failedValueConstants.empty) {
				ctx.acceptor.acceptError(
					'Some constants could not be calculated: ' + failedValueConstants.join(', '),
					ctx.root, CoreDslPackage.Literals.ISA__NAME,
					-1, IssueCodes.IndeterminableIsaConstantValue);
			}
			
			val failedTypeConstants = constants.filter[it.calculatedType === null].map[it.name].toList();
			if(!failedTypeConstants.empty) {
				ctx.acceptor.acceptError(
					'The type of some constants could not be calculated: ' + failedTypeConstants.join(', '),
					ctx.root, CoreDslPackage.Literals.ISA__NAME,
					-1, IssueCodes.IndeterminableIsaConstantValue);
			}
		}
		
		// TODO
		// evaluate the right hand sides of all assignments
		// -> report cyclic dependencies: x=y; y=x;
		// -> how do we handle breakable cycles? x=y; y=x; x=1;
		//   -> fixpoint solver?
		// make sure all assignments to the same constant result in the same value
		// store the calculated values in the ConstantDefinitionInfo object
	}
	
	private static def void mergeConstantDeclarations(AnalysisContext ctx) {
		// TODO
		// evaluate integer type widths
		// make sure all types of each constant are equal
		// make sure no two declarations are in the same ISA scope
	}
	
	private static def void validateConstantDeclarations(AnalysisContext ctx) {
		// TODO
		// make sure only primitive types (and enums?) are used
		// make sure all calculated values can fit into their respective constant's type
	}
	
}
