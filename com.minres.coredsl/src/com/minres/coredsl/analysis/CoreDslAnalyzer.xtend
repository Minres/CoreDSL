package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.*
import com.minres.coredsl.util.CompilerAssertion
import com.minres.coredsl.validation.IssueCodes
import com.minres.coredsl.validation.KnownAttributes.AttributeUsage
import java.util.HashSet
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.ModelExtensions.*
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.FunctionCallExpression
import com.minres.coredsl.coreDsl.CompoundStatement
import com.minres.coredsl.type.CoreDslType
import java.math.BigInteger
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.UserTypeDeclaration

class CoreDslAnalyzer {

	def static void analyze(DescriptionContent desc, ValidationMessageAcceptor acceptor) {
		val ctx = new AnalysisContext(acceptor, desc);

		for (isa : desc.definitions) {
			preAnalyzeIsaArchState(ctx, isa);
			val ectx = CoreDslElaborator.elaborate(ctx, isa);
			ctx.elaborationResults.put(isa, ectx);
		}

		for (ectx : ctx.elaborationResults.values) {
			analyzeIsa(ectx, ectx.root);
		}
	}

	// /////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////// Pre-analyzers ////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////
	// The preAnalyze* methods are run before evaluation. They are therefore only run
	// once for each syntax node.
	def private static dispatch void preAnalyzeIsaArchState(AnalysisContext ctx, InstructionSet iset) {
		if(ctx.exposedDeclarations.containsKey(iset)) return;

		val declaredNames = new HashSet<String>();
		ctx.exposedDeclarations.put(iset, declaredNames);

		if(iset.superType !== null) {
			if(!ctx.exposedDeclarations.containsKey(iset.superType)) {
				preAnalyzeIsaArchState(ctx, iset.superType);
			}
			declaredNames.addAll(ctx.exposedDeclarations.get(iset.superType));
		}

		preAnalyzeIsaArchStateBody(ctx, iset, declaredNames);
	}

	def private static dispatch void preAnalyzeIsaArchState(AnalysisContext ctx, CoreDef core) {
		val declaredNames = new HashSet<String>();

		for (iset : core.providedInstructionSets) {
			if(!ctx.exposedDeclarations.containsKey(iset)) {
				preAnalyzeIsaArchState(ctx, iset);
			}
			declaredNames.addAll(ctx.exposedDeclarations.get(iset));
		}

		preAnalyzeIsaArchStateBody(ctx, core, declaredNames);
	}

	def static preAnalyzeIsaArchStateBody(AnalysisContext ctx, ISA isa, HashSet<String> declaredNames) {
		for (statement : isa.archStateBody) {
			switch (statement) {
				DeclarationStatement: {
					preAnalyzeDeclaration(ctx, statement.declaration, true);

					for (decl : statement.declaration.declarators) {
						if(!declaredNames.add(decl.name)) {
							ctx.acceptError(
								'An ISA state element with the name ' + decl.name + ' has already been declared', decl,
								CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.DuplicateIsaStateElement);
						}
					}
				}
				ExpressionStatement: {
					val assignment = statement.expression.castOrNull(AssignmentExpression);

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

					val entityReference = assignment.target.castOrNull(EntityReference);
					val declarator = entityReference?.target.castOrNull(Declarator);

					if(declarator === null || !ctx.isIsaParameter(declarator) || declarator.isConst) {
						ctx.acceptError('ISA level assignment must assign to a non-constant ISA parameter', assignment,
							CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__TARGET, -1,
							IssueCodes.InvalidIsaParameterAssignmentTarget);
						return;
					}
				}
			}
		}
	}

	def static preAnalyzeDeclaration(AnalysisContext ctx, Declaration declaration, boolean isIsaStateElement) {
		// preAnalyzeTypeSpecifier(ctx, declaration.type);
		if(declaration.type instanceof VoidTypeSpecifier) {
			ctx.acceptError("Identifiers may not be declared as type void", declaration,
				CoreDslPackage.Literals.DECLARATION__TYPE, -1, IssueCodes.VoidDeclaration);
		}

		val seenQualifiers = new HashSet();
		for (var i = 0; i < declaration.qualifiers.size; i++) {
			val qualifier = declaration.qualifiers.get(i);
			if(!seenQualifiers.add(qualifier)) {
				ctx.acceptError("Duplicate qualifier " + qualifier.literal, declaration,
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
					ctx.acceptError("A declaration may not mix non-alias and alias declarators", declaration,
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
					ctx.acceptError("Storage class specifiers are only allowed on ISA level declarations", declaration,
						CoreDslPackage.Literals.DECLARATION__STORAGE, -1,
						IssueCodes.StorageClassSpecifierOnLocalVariable);
				}
			}
			default: {
				ctx.acceptError("A declaration may not specify more than one storage class", declaration,
					CoreDslPackage.Literals.DECLARATION__STORAGE, 1 /* show it on the second specifier */ ,
					IssueCodes.MultipleStorageClassSpecifiers);
			}
		}
		ctx.storageClasses.put(declaration, storageClass);

		if(storageClass === StorageClass.param) {
			if(!(declaration.type instanceof IntegerTypeSpecifier || declaration.type instanceof BoolTypeSpecifier)) {
				ctx.acceptError("ISA parameters may only have integer types (signed, unsigned, bool)", declaration,
					CoreDslPackage.Literals.DECLARATION__TYPE, -1, IssueCodes.InvalidIsaParameterType);
			}

			for (var i = 0; i < declaration.qualifiers.size; i++) {
				val qualifier = declaration.qualifiers.get(i);
				if(qualifier === TypeQualifier.VOLATILE) {
					ctx.acceptError("ISA parameters may not be declared as volatile", declaration,
						CoreDslPackage.Literals.DECLARATION__QUALIFIERS, i, IssueCodes.InvalidIsaParameterDeclaration);
				}
			}
		}

		for (declarator : declaration.declarators) {
			preAnalyzeDeclarator(ctx, declarator, isIsaStateElement);
		}
	}

	def static preAnalyzeAttribute(AnalysisContext ctx, Attribute attribute, AttributeUsage usage) {
		// TODO
	}

	def static preAnalyzeDeclarator(AnalysisContext ctx, Declarator declarator, boolean isIsaStateElement) {
		if(declarator.isConst && declarator.initializer === null) {
			ctx.acceptError("An identifier declared as const must be initialized", declarator,
				CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.UninitializedConstant);
		}

		if(declarator.isAlias) {
			if(!isIsaStateElement) {
				ctx.acceptError("A local variable may not be declared as alias", declarator,
					CoreDslPackage.Literals.DECLARATOR__ALIAS, -1, IssueCodes.AliasLocalVariable);
			}

			if(declarator.initializer === null) {
				ctx.acceptError("An identifier declared as alias must be initialized", declarator,
					CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.UninitializedAlias);
			}
		}

		if(!declarator.dimensions.empty && ctx.isIsaParameter(declarator)) {
			ctx.acceptError("An ISA parameter may not be declared as an array", declarator,
				CoreDslPackage.Literals.DECLARATOR__DIMENSIONS, 1, IssueCodes.InvalidIsaParameterDeclaration);
		}

		for (attribute : declarator.attributes) {
			preAnalyzeAttribute(ctx, attribute, AttributeUsage.declaration);
		}
	}

	// /////////////////////////////////////////////////////////////////////////
	// ////////////////////////////// Top level ////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////
	// The analyze* methods may run multiple times for different elaboration contexts.
	def static dispatch void analyzeIsa(ElaborationContext ctx, CoreDef core) {
		analyzeIsaShared(ctx, core);
		for (iset : core.providedInstructionSets) {
			analyzeIsa(ctx, iset);
		}
	}

	def static dispatch void analyzeIsa(ElaborationContext ctx, InstructionSet iset) {
		analyzeIsaShared(ctx, iset);
		if(iset.superType !== null) {
			analyzeIsa(ctx, iset.superType);
		}
	}

	def private static void analyzeIsaShared(ElaborationContext ctx, ISA isa) {
		// architectural state
		for (statement : isa.archStateBody) {
			analyzeStatement(ctx, statement);
		}

		// types
		for (typeDecl : isa.types) {
			analyzeTypeDeclaration(ctx, typeDecl);
		}

		// functions
		for (function : isa.functions) {
			analyzeFunction(ctx, function);
		}

		// instructions
		for (instruction : isa.instructions) {
			analyzeInstruction(ctx, instruction);
		}
	}

	def static analyzeFunction(ElaborationContext ctx, FunctionDefinition definition) {
		// TODO attributes, parameters?
		// val isReturnTerminated = definition.body.isReturnTerminated;
		// val returnType = analyzeTypeSpecifier(ctx, definition.returnType);
		analyzeStatement(ctx, definition.body);
	}

	def static dispatch boolean isReturnTerminated(CompoundStatement statement) {
		return statement.statements.size > 0 && statement.statements.last.isReturnTerminated;
	}

	def static dispatch boolean isReturnTerminated(IfStatement statement) {
		return statement.elseBody !== null && statement.thenBody.isReturnTerminated &&
			statement.elseBody.isReturnTerminated
	}

	def static dispatch boolean isReturnTerminated(Statement statement) { return false; }

	def static analyzeInstruction(ElaborationContext ctx, Instruction instruction) {
	}

	// //////////////////////////////////////////////////////////////////////////
	// ////////////////////////////// Statements ////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////
	def static dispatch void analyzeStatement(ElaborationContext ctx, CompoundStatement statement) {
		for (nested : statement.statements) {
			analyzeStatement(ctx, nested);
		}
	}

	def static dispatch void analyzeStatement(ElaborationContext ctx, DeclarationStatement statement) {
		analyzeDeclaration(ctx, statement.declaration);
	}

	def private static boolean isStatementExpression(Expression expression) {
		switch (expression) {
			case AssignmentExpression:
				return true
			case FunctionCallExpression:
				return true
			case PrefixExpression: {
				switch ((expression as PrefixExpression).operand) {
					case '++': return true
					case '--': return true
				}
			}
			case PostfixExpression: {
				switch ((expression as PostfixExpression).operand) {
					case '++': return true
					case '--': return true
				}
			}
		}

		return false;
	}

	/**
	 * 1. The expression must be a statement expression. <i>(InvalidStatementExpression)</i>
	 */
	def static dispatch void analyzeStatement(ElaborationContext ctx, ExpressionStatement statement) {
		val expression = statement.expression;
		analyzeExpression(ctx, expression);

		if(!isStatementExpression(expression)) {
			ctx.acceptError("Invalid expression in expression statement", statement,
				CoreDslPackage.Literals.EXPRESSION_STATEMENT__EXPRESSION, -1, IssueCodes.InvalidStatementExpression);
		}
	}

	/**
	 * 1. The condition must be an expression with a scalar type. <i>(NonScalarCondition)</i>
	 */
	def static dispatch void analyzeStatement(ElaborationContext ctx, IfStatement statement) {
		val conditionType = analyzeExpression(ctx, statement.condition);

		if(!conditionType.isScalarType) {
			ctx.acceptError("The condition must be a scalar type", statement,
				CoreDslPackage.Literals.IF_STATEMENT__CONDITION, -1, IssueCodes.NonScalarCondition);
		}

		analyzeStatement(ctx, statement.thenBody);

		if(statement.elseBody !== null)
			analyzeStatement(ctx, statement.elseBody);
	}

	/**
	 * 1. The switch condition must be an expression with an integer type <i>(SwitchConditionTypeInvalid)</i><br>
	 * 2. At most one default section may be present <i>(SwitchMultipleDefaultSections)</i><br>
	 * 3. At most one case section may be present for each given value <i>(SwitchDuplicateCaseSection)</i><br>
	 * 4. Each case section's value must be representable by the type of the switch condition <i>(SwitchCaseConditionOutOfRange)</i>
	 */
	def static dispatch void analyzeStatement(ElaborationContext ctx, SwitchStatement statement) {
		val conditionType = analyzeExpression(ctx, statement.condition);

		var defaultFound = false;
		val valuesFound = new HashSet<BigInteger>();

		if(!conditionType.isIntegerType) {
			ctx.acceptError("The switch condition must be an integer expression", statement,
				CoreDslPackage.Literals.SWITCH_STATEMENT__CONDITION, -1, IssueCodes.SwitchConditionTypeInvalid);
		}

		for (section : statement.sections) {
			if(section instanceof CaseSection) {
				val caseCondition = CoreDslConstantExpressionEvaluator.evaluate(ctx, section.condition);
				if(caseCondition.isValid) {
					if(!valuesFound.add(caseCondition.value)) {
						ctx.acceptError("Multiple case sections with condition " + caseCondition.value, section,
							CoreDslPackage.Literals.CASE_SECTION__TCASE, -1, IssueCodes.SwitchDuplicateCaseSection);
					}
					if(!CoreDslTypeProvider.canTypeHoldValue(conditionType, caseCondition.value)) {
						ctx.acceptError(
							"The value " + caseCondition.value + " can not be represented by condition type " +
								conditionType, section, CoreDslPackage.Literals.CASE_SECTION__TCASE, -1,
							IssueCodes.SwitchCaseConditionOutOfRange);
					}
				}
			} else {
				if(defaultFound) {
					ctx.acceptError("Multiple default sections", section,
						CoreDslPackage.Literals.DEFAULT_SECTION__TDEFAULT, -1,
						IssueCodes.SwitchMultipleDefaultSections);
				}
				defaultFound = true;
			}

			for (stmt : section.body) {
				analyzeStatement(ctx, stmt)
			}
		}
	}

	/**
	 * 1. The continue statement must be contained within a loop statement. <i>(StrayControlFlowStatement)</i>
	 */
	def static dispatch void analyzeStatement(ElaborationContext ctx, ContinueStatement statement) {
		if(statement.ancestorOfType(LoopStatement) === null) {
			ctx.acceptError("Unexpected continue statement", statement, null, -1, IssueCodes.StrayControlFlowStatement);
		}
	}

	/**
	 * 1. The break statement must be contained within a loop or switch statement. <i>(StrayControlFlowStatement)</i>
	 */
	def static dispatch void analyzeStatement(ElaborationContext ctx, BreakStatement statement) {
		if(statement.ancestorOfType(LoopStatement) === null && statement.ancestorOfType(SwitchStatement) === null) {
			ctx.acceptError("Unexpected break statement", statement, null, -1, IssueCodes.StrayControlFlowStatement);
		}
	}

	/**
	 * 1. Return statements may only occur within functions <i>(ReturnStatementOutsideFunction)</i><br>
	 * 2. If the function's return type is void, the return statement must not declare a value <i>(ReturnWithValueInVoidFunction)</i><br>
	 * 3. If the function's return type is not void, the return statement must declare a value <i>(ReturnWithoutValueInNonVoidFunction)</i><br>
	 * 4. The type of the return statement's value expression must be implicitly convertible to the function's return type <i>(ReturnTypeNotConvertible)</i>
	 */
	def static dispatch void analyzeStatement(ElaborationContext ctx, ReturnStatement statement) {
		val function = statement.ancestorOfType(FunctionDefinition);
		val returnType = analyzeTypeSpecifier(ctx, function?.returnType);
		val valueType = statement.value !== null ? analyzeExpression(ctx, statement.value) : null;

		if(function === null) {
			ctx.acceptError("Return statement is only valid in a function", statement,
				CoreDslPackage.Literals.RETURN_STATEMENT__TRETURN, -1, IssueCodes.ReturnStatementOutsideFunction);
		} else if(returnType.isVoid && statement.value !== null) {
			ctx.acceptError("Void functions may not return a value", statement,
				CoreDslPackage.Literals.RETURN_STATEMENT__TRETURN, -1, IssueCodes.ReturnWithValueInVoidFunction);
		} else if(!returnType.isVoid && statement.value === null) {
			ctx.acceptError("Non-void functions must return a value", statement,
				CoreDslPackage.Literals.RETURN_STATEMENT__TRETURN, -1, IssueCodes.ReturnWithoutValueInNonVoidFunction);
		} else if(!CoreDslTypeProvider.canImplicitlyConvert(valueType, returnType)) {
			ctx.acceptError("Cannot convert from " + valueType + " to " + returnType, statement,
				CoreDslPackage.Literals.RETURN_STATEMENT__TRETURN, -1, IssueCodes.ReturnTypeNotConvertible);
		}
	}

	/**
	 * 1. The condition must be an expression with a scalar type. <i>(NonScalarCondition)</i>
	 */
	def static dispatch void analyzeStatement(ElaborationContext ctx, WhileLoop statement) {
		val conditionType = analyzeExpression(ctx, statement.condition);

		if(!conditionType.isScalarType) {
			ctx.acceptError("The condition must be a scalar type", statement,
				CoreDslPackage.Literals.LOOP_STATEMENT__CONDITION, -1, IssueCodes.NonScalarCondition);
		}

		analyzeStatement(ctx, statement.body);
	}

	/**
	 * 1. The condition must be an expression with a scalar type. <i>(NonScalarCondition)</i><br>
	 * 2. If present, the start expression must be a statement expression. <i>(InvalidStatementExpression)</i><br>
	 * 3. All loop expressions must be statement expressions. <i>(InvalidStatementExpression)</i>
	 */
	def static dispatch void analyzeStatement(ElaborationContext ctx, ForLoop statement) {
		val conditionType = analyzeExpression(ctx, statement.condition);

		if(!conditionType.isScalarType) {
			ctx.acceptError("The condition must be a scalar type", statement,
				CoreDslPackage.Literals.LOOP_STATEMENT__CONDITION, -1, IssueCodes.NonScalarCondition);
		}

		if(statement.startDeclaration !== null) {
			analyzeDeclaration(ctx, statement.startDeclaration);
		}

		if(statement.startExpression !== null) {
			analyzeExpression(ctx, statement.startExpression);
			if(!isStatementExpression(statement.startExpression)) {
				ctx.acceptError("Invalid expression in expression statement", statement,
					CoreDslPackage.Literals.FOR_LOOP__START_EXPRESSION, -1, IssueCodes.InvalidStatementExpression);
			}
		}

		for (var i = 0; i < statement.loopExpressions.size; i++) {
			val expression = statement.loopExpressions.get(i);
			analyzeExpression(ctx, expression);
			if(!isStatementExpression(expression)) {
				ctx.acceptError("Invalid expression in expression statement", statement,
					CoreDslPackage.Literals.FOR_LOOP__LOOP_EXPRESSIONS, i, IssueCodes.InvalidStatementExpression);
			}
		}

		analyzeStatement(ctx, statement.body);
	}

	/**
	 * 1. The condition must be an expression with a scalar type. <i>(NonScalarCondition)</i>
	 */
	def static dispatch void analyzeStatement(ElaborationContext ctx, DoLoop statement) {
		val conditionType = analyzeExpression(ctx, statement.condition);

		if(!conditionType.isScalarType) {
			ctx.acceptError("The condition must be a scalar type", statement,
				CoreDslPackage.Literals.LOOP_STATEMENT__CONDITION, -1, IssueCodes.NonScalarCondition);
		}

		analyzeStatement(ctx, statement.body);
	}

	def static dispatch void analyzeStatement(ElaborationContext ctx, Statement statement) {
		// TODO spawn statement
		ctx.acceptInfo("Analysis for this node is not supported yet", statement, null, -1,
			IssueCodes.UnsupportedLanguageFeature);
	}

	// ////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////// Declarations ////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////
	def static CoreDslType analyzeTypeDeclaration(ElaborationContext ctx, UserTypeDeclaration declaration) {
	}

	def static CoreDslType analyzeTypeSpecifier(ElaborationContext ctx, TypeSpecifier typeSpecifier) {
	}

	def static void analyzeDeclaration(ElaborationContext ctx, Declaration declaration) {
	}

	def static void analyzeDeclarator(ElaborationContext ctx, Declarator declarator) {
	}

	// ///////////////////////////////////////////////////////////////////////////
	// ////////////////////////////// Expressions ////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////
	def static dispatch CoreDslType analyzeExpression(ElaborationContext ctx, Expression expression) {
		ctx.acceptInfo("Analysis for this node is not supported yet", expression, null, -1,
			IssueCodes.UnsupportedLanguageFeature);
		return null;
	}
}
