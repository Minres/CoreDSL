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
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.ExpressionInitializer
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.StructTypeDeclaration
import com.minres.coredsl.coreDsl.UnionTypeDeclaration
import com.minres.coredsl.type.CompositeType
import com.minres.coredsl.type.CoreDslType
import com.minres.coredsl.type.EnumType
import com.minres.coredsl.type.ErrorType
import com.minres.coredsl.type.IntegerType
import com.minres.coredsl.util.CompilerAssertion
import com.minres.coredsl.validation.IssueCodes
import java.math.BigInteger
import java.util.ArrayList
import java.util.HashSet
import java.util.Set
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.DataExtensions.*
import static extension com.minres.coredsl.util.ModelExtensions.*
import com.minres.coredsl.type.AddressSpaceType

class CoreDslElaborator {

	/**
	 * The elaboration phase should produce the following results:
	 * - storage classes of all ISA level declarations
	 * - storage classes of all members of user declared types
	 * - types of all ISA level declarations (register, extern, param, alias)
	 * - types of all members of user declared types
	 * - values of all ISA parameters
	 * - reset values for all register and extern declarations
	 * - values of all enum members
	 */
	def static ElaborationContext elaborate(ISA isa, ValidationMessageAcceptor acceptor) {
		val ctx = new ElaborationContext(isa, acceptor);

		buildElaborationOrder(ctx, isa);
		gatherCalculationJobs(ctx);
		processCalculationQueue(ctx);
		handleFailedJobs(ctx);
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

	def private static void gatherCalculationJobs(ElaborationContext ctx) {
		for (isa : ctx.elaborationOrder) {
			gatherCalculationJobs(ctx, isa);
		}
	}

	def private static void gatherCalculationJobs(ElaborationContext ctx, ISA isa) {
		val exposedNames = initExposedNames(ctx, isa);

		for (statement : isa.archStateBody) {
			switch (statement) {
				DeclarationStatement: processIsaLevelDeclaration(ctx, statement.declaration, exposedNames)
				ExpressionStatement: processIsaLevelAssignment(ctx, statement)
			}
		}

		for (typeDecl : isa.typeDeclarations) {
			switch (typeDecl) {
				EnumTypeDeclaration: processEnumTypeDeclaration(ctx, typeDecl)
				CompositeTypeDeclaration: processCompositeTypeDeclaration(ctx, typeDecl)
			}
		}
	}

	def private static void processIsaLevelDeclaration(ElaborationContext ctx, Declaration declaration,
		Set<String> exposedNames) {
		determineStorageClasses(ctx, declaration);

		enqueueDeclarationTypeJob(ctx, declaration);

		for (declarator : declaration.declarators) {
			if(!exposedNames.add(declarator.name)) {
				ctx.acceptError('An identifier with the name ' + declarator.name + ' has already been declared',
					declarator, CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.DuplicateIsaStateElement);
			}

			if(!ctx.declInfo.containsKey(declarator.name)) {
				ctx.declInfo.put(declarator.name, new ElaborationContext.ElaborationDeclarationInfo(declarator.name));
			}

			val info = ctx.declInfo.get(declarator.name);
			info.declarators.add(declarator);

			if(declarator.initializer instanceof ExpressionInitializer && !declarator.isAlias) {
				val expr = (declarator.initializer as ExpressionInitializer).value;
				info.assignments.add(expr);

				enqueueAssignmentEvaluationJob(ctx, info, expr);
			}

			if(!declarator.dimensions.empty) {
				enqueueArrayDeclaratorJob(ctx, declarator);
			}
		}
	}

	def private static void processIsaLevelAssignment(ElaborationContext ctx, ExpressionStatement statement) {
		val analysisContext = ctx.analysisContext;

		val assignment = statement.expression.castOrNull(AssignmentExpression);
		val reference = assignment?.target.castOrNull(EntityReference);
		val declarator = reference?.target.castOrNull(Declarator);

		// TODO report errors in analyzer instead, so they are properly forwarded to deriving ISAs
		if(assignment === null) {
			ctx.acceptError('Only assignment expressions are allowed in ISA level expression statements', statement,
				CoreDslPackage.Literals.EXPRESSION_STATEMENT__EXPRESSION, -1,
				IssueCodes.InvalidIsaParameterAssignmentExpression);
			return;
		}

		if(assignment.operator != '=') {
			ctx.acceptError('Only regular assignments (=) are allowed in ISA level expression statements', assignment,
				CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR, -1,
				IssueCodes.InvalidIsaParameterAssignmentOperator);
		}
		
		if(reference?.target.eIsProxy) {
			// linking error
			return;
		}

		if(declarator === null || analysisContext.getStorageClass(declarator) !== StorageClass.param ||
			declarator.isConst) {
			ctx.acceptError('ISA level assignment must assign to a non-constant ISA parameter', assignment,
				CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__TARGET, -1,
				IssueCodes.InvalidIsaParameterAssignmentTarget);
			return;
		}

		if(declarator !== null) {
			val info = ctx.declInfo.get(declarator.name)
			if(info !== null) {
				info.assignments.add(assignment.value);
				enqueueAssignmentEvaluationJob(ctx, info, assignment.value);
			}
		}
	}

	def private static void processEnumTypeDeclaration(ElaborationContext ctx, EnumTypeDeclaration typeDecl) {
		val analysisContext = ctx.analysisContext;
		for (member : typeDecl.members) {
			if(!ctx.declInfo.containsKey(member.name)) {
				ctx.declInfo.put(member.name, new ElaborationContext.ElaborationDeclarationInfo(member.name));
			}

			val info = ctx.declInfo.get(member.name);
			info.declarators.add(member);

			analysisContext.setStorageClass(member, StorageClass.enumConstant);
			enqueueEnumMemberValueJob(ctx, typeDecl, member);

			if(member.initializer instanceof ExpressionInitializer) {
				val expr = (member.initializer as ExpressionInitializer).value;
				info.assignments.add(expr);
			}
		}

		enqueueTypeDeclarationJob(ctx, typeDecl);
	}

	def static processCompositeTypeDeclaration(ElaborationContext ctx, CompositeTypeDeclaration typeDecl) {
		val analysisContext = ctx.analysisContext;
		for (declaration : typeDecl.members) {
			for (member : declaration.declarators) {
				analysisContext.setStorageClass(member, StorageClass.field);
			}

			enqueueDeclarationTypeJob(ctx, declaration);
		}

		enqueueTypeDeclarationJob(ctx, typeDecl);
	}

	def private static dispatch initExposedNames(ElaborationContext ctx, InstructionSet iset) {
		if(ctx.areExposedNamesSet(iset))
			return ctx.getExposedNames(iset);

		val exposedNames = new HashSet<String>();
		ctx.setExposedNames(iset, exposedNames);

		if(iset.superType !== null) {
			val superNames = ctx.getExposedNames(iset.superType);
			CompilerAssertion.assertThat(superNames !== null,
				"Super instruction set must be analyzed before the deriving instruction set");
			exposedNames.addAll(superNames);
		}

		return exposedNames;
	}

	def private static dispatch initExposedNames(ElaborationContext ctx, CoreDef core) {
		if(ctx.areExposedNamesSet(core))
			return ctx.getExposedNames(core);

		val exposedNames = new HashSet<String>();
		ctx.setExposedNames(core, exposedNames);

		for (iset : core.providedInstructionSets) {
			val isetNames = ctx.getExposedNames(iset);
			CompilerAssertion.assertThat(isetNames !== null,
				"Provided instruction set must be analyzed before the providing core");
			exposedNames.addAll(isetNames);
		}

		return exposedNames;
	}

	def private static determineStorageClasses(ElaborationContext ctx, Declaration declaration) {
		val analysisContext = ctx.analysisContext;
		val storageClassSpecifiers = declaration.storage;
		var storageClass = StorageClass.invalid;
		switch (storageClassSpecifiers.size()) {
			case 0: {
				for (declarator : declaration.declarators) {
					if(declarator.isAlias) {
						analysisContext.setStorageClass(declarator, StorageClass.alias);
					} else {
						analysisContext.setStorageClass(declarator, StorageClass.param);
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
			analysisContext.setStorageClass(declarator, storageClass);
		}
	}

	def private static void enqueueDeclarationTypeJob(ElaborationContext ctx, Declaration declaration) {
		val analysisContext = ctx.analysisContext;
		ctx.calculationQueue.add([ failed |
			val type = CoreDslTypeProvider.getSpecifiedType(analysisContext, declaration.type);
			if(type.isIndeterminate && !failed) return false;

			for (declarator : declaration.declarators) {
				// array declarators have their own job, so we don't set their type here
				if(declarator.dimensions.empty) {
					analysisContext.setDeclaredType(declarator, type);
				}
			}

			return true;
		]);
	}

	def private static void enqueueArrayDeclaratorJob(ElaborationContext ctx, Declarator declarator) {
		val analysisContext = ctx.analysisContext;
		ctx.calculationQueue.add([ failed |
			var CoreDslType type;
			if(analysisContext.isSpecifiedTypeSet(declarator.type)) {
				type = analysisContext.getSpecifiedType(declarator.type);
			} else if(failed) {
				type = ErrorType.indeterminate;
			} else {
				return false;
			}

			// process size specifiers from right (innermost) to left (outermost)
			for (var i = declarator.dimensions.size - 1; i >= 0; i--) {
				val expression = declarator.dimensions.get(i);
				val value = CoreDslConstantExpressionEvaluator.evaluate(analysisContext, expression);

				if(value.isValid) {
					if(value.value < BigInteger.ZERO) {
						type = AddressSpaceType.ofUnknownSize(type);
					} else {
						type = new AddressSpaceType(type, value.value);
					}
				} else if(failed) {
					type = AddressSpaceType.ofUnknownSize(type);
				} else {
					return false;
				}
			}

			analysisContext.setDeclaredType(declarator, type);

			return true;
		]);
	}

	def private static void enqueueAssignmentEvaluationJob(ElaborationContext ctx,
		ElaborationContext.ElaborationDeclarationInfo info, Expression expression) {
		val analysisContext = ctx.analysisContext;
		ctx.calculationQueue.add([ failed |
			val value = CoreDslConstantExpressionEvaluator.evaluate(analysisContext, expression);
			if(value.isIndeterminate && !failed) return false;

			if(info.isEffectiveAssignment(expression)) {
				for (declarator : info.declarators) {
					analysisContext.setConstantValue(declarator, value);
				}
			}

			return true;
		]);
	}

	def private static void enqueueEnumMemberValueJob(ElaborationContext ctx, EnumTypeDeclaration typeDecl,
		Declarator member) {
		val analysisContext = ctx.analysisContext;
		if(member.initializer instanceof ExpressionInitializer) {
			val initializer = member.initializer as ExpressionInitializer;

			// calculate member value based on initializer
			ctx.calculationQueue.add([ failed |
				val value = CoreDslConstantExpressionEvaluator.evaluate(analysisContext, initializer.value);
				if(value.isIndeterminate && !failed) return false;

				analysisContext.setConstantValue(member, value);

				return true;
			]);
		} else {
			val memberIndex = typeDecl.members.indexOf(member);
			CompilerAssertion.assertThat(memberIndex >= 0, "Member does not belong to this enum");

			for (var i = memberIndex - 1; i >= 0; i--) {
				val predecessor = typeDecl.members.get(i);
				if(predecessor.initializer instanceof ExpressionInitializer) {

					// calculate value based on predecessor and offset
					val offset = BigInteger.valueOf(memberIndex - i);
					ctx.calculationQueue.add([ failed |
						if(!analysisContext.isConstantValueSet(predecessor)) {
							if(failed) {
								analysisContext.setConstantValue(member, ConstantValue.indeterminate);
								return true;
							} else {
								return false;
							}
						}

						val predecessorValue = analysisContext.getConstantValue(predecessor);
						if(predecessorValue.isInvalid || failed && predecessorValue.isIndeterminate) {
							analysisContext.setConstantValue(member, predecessorValue);
							return true;
						}

						CompilerAssertion.assertThat(predecessorValue.isValid,
							"Value should never be set as indeterminate unless the failed flag is set");

						val value = new ConstantValue(predecessorValue.value + offset);
						analysisContext.setConstantValue(member, value);

						return true;
					]);

					return;
				}
			}

			// no predecessor with initializer found -> member index is used as value
			analysisContext.setConstantValue(member, new ConstantValue(memberIndex));
		}
	}

	def private static dispatch void enqueueTypeDeclarationJob(ElaborationContext ctx, EnumTypeDeclaration typeDecl) {
		val analysisContext = ctx.analysisContext;
		ctx.calculationQueue.add([ failed |

			// find the smallest integer type able to hold all enum values
			var intType = IntegerType.unsigned(1);
			for (member : typeDecl.members) {
				if(analysisContext.isConstantValueSet(member)) {
					val value = analysisContext.getConstantValue(member);
					if(value.isValid) {
						intType = CoreDslTypeProvider.getSmallestCommonType(intType,
							CoreDslTypeProvider.getSmallestTypeForValue(value.value));
					}
				} else if(!failed) {
					return false;
				}
			}

			val enumType = new EnumType(typeDecl, intType);
			analysisContext.setUserTypeInstance(typeDecl, enumType);

			for (member : typeDecl.members) {
				analysisContext.setDeclaredType(member, enumType);
			}

			return true;
		]);
	}

	def private static dispatch void enqueueTypeDeclarationJob(ElaborationContext ctx, StructTypeDeclaration typeDecl) {
		val analysisContext = ctx.analysisContext;
		ctx.calculationQueue.add([ failed |
			val members = typeDecl.members.flatMap[it.declarators].toList();
			val fieldOffsets = new ArrayList(members.size);

			// TODO consider field alignment
			var totalSize = BigInteger.ZERO;
			for (member : members) {
				if(analysisContext.isDeclaredTypeSet(member)) {
					val type = analysisContext.getDeclaredType(member);
					fieldOffsets.add(totalSize);

					// ignore invalid members
					if(type.isValid) {
						totalSize += BigInteger.valueOf(type.bitSize);
					}
				} else if(!failed) {
					return false;
				}
			}

			for (var i = 0; i < members.size; i++) {
				analysisContext.setFieldOffset(members.get(i), new ConstantValue(fieldOffsets.get(i)));
			}

			var structType = new CompositeType(typeDecl, members, totalSize.intValueExact());
			analysisContext.setUserTypeInstance(typeDecl, structType);

			return true;
		]);
	}

	def private static dispatch void enqueueTypeDeclarationJob(ElaborationContext ctx, UnionTypeDeclaration typeDecl) {
		val analysisContext = ctx.analysisContext;
		ctx.calculationQueue.add([ failed |
			val members = typeDecl.members.flatMap[it.declarators].toList();

			var maxSize = BigInteger.ZERO;
			for (member : members) {
				if(analysisContext.isDeclaredTypeSet(member)) {
					val type = analysisContext.getDeclaredType(member);

					// ignore invalid members
					if(type.isValid) {
						maxSize = maxSize.max(BigInteger.valueOf(type.bitSize));
					}
				} else if(!failed) {
					return false;
				}
			}

			for (member : members) {
				analysisContext.setFieldOffset(member, new ConstantValue(BigInteger.ZERO));
			}

			var unionType = new CompositeType(typeDecl, members, maxSize.intValueExact());
			analysisContext.setUserTypeInstance(typeDecl, unionType);

			return true;
		]);
	}

	def private static void processCalculationQueue(ElaborationContext ctx) {
		var completed = new ArrayList();
		ctx.calculationQueue.removeAll(null, null);

		while(true) {
			for (job : ctx.calculationQueue) {
				if(job.tryCalculate(false))
					completed.add(job);
			}

			if(completed.empty) {
				// No new results, so we're done
				// Everything left in the queue is indeterminate
				return;
			} else {
				ctx.calculationQueue.removeAll(completed);
				completed.clear();
			}
		}
	}

	def static handleFailedJobs(ElaborationContext ctx) {
		for (failedJob : ctx.calculationQueue) {
			if(!failedJob.tryCalculate(true)) {
				CompilerAssertion.fail("failed to clean up failed job");
			}
		}
	}

	def private static void validateResults(ElaborationContext ctx) {
		if(ctx.isPartialElaboration) return;

		val analysisContext = ctx.analysisContext;

		val unassignedParameters = new ArrayList();
		val indeterminableValues = new ArrayList();
		val invalidValues = new ArrayList();
		val indeterminableTypes = new ArrayList();
		val invalidTypes = new ArrayList();

		for (info : ctx.declInfo.values) {
			val effectiveDeclarator = info.declarators.last;

			if(info.assignments.empty) {
				if(analysisContext.getStorageClass(info.declarators.get(0)) === StorageClass.param) {
					unassignedParameters.add(info.name);
				}
			} else {
				val value = analysisContext.getConstantValue(effectiveDeclarator);
				if(value.isInvalid) invalidValues.add(info.name);
				if(value.isIndeterminate) indeterminableValues.add(info.name);
			}

			val type = analysisContext.getDeclaredType(effectiveDeclarator);
			if(type.isInvalid) invalidTypes.add(info.name);
			if(type.isIncomplete) indeterminableTypes.add(info.name);
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

		val type = CoreDslTypeProvider.getSpecifiedType(ctx.analysisContext, declarator.type);
		string += type;

		if(declarator.isAlias) {
			string += '&';
		}
		return string;
	}

	def private static void checkDuplicateDeclarations(ElaborationContext ctx) {
		val analysisContext = ctx.analysisContext;
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
				} else if(analysisContext.getStorageClass(info.declarators.get(0)) === StorageClass.param) {
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
