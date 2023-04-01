package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.AlwaysBlock
import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BoolConstant
import com.minres.coredsl.coreDsl.BoolTypeSpecifier
import com.minres.coredsl.coreDsl.BreakStatement
import com.minres.coredsl.coreDsl.CaseSection
import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.CompositeTypeDeclaration
import com.minres.coredsl.coreDsl.CompoundStatement
import com.minres.coredsl.coreDsl.ConcatenationExpression
import com.minres.coredsl.coreDsl.ConditionalExpression
import com.minres.coredsl.coreDsl.ContinueStatement
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DeclarationStatement
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.DoLoop
import com.minres.coredsl.coreDsl.EmptyStatement
import com.minres.coredsl.coreDsl.Encoding
import com.minres.coredsl.coreDsl.EntityReference
import com.minres.coredsl.coreDsl.EnumTypeDeclaration
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.ExpressionInitializer
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.ForLoop
import com.minres.coredsl.coreDsl.FunctionCallExpression
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.IfStatement
import com.minres.coredsl.coreDsl.IndexAccessExpression
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.IntegerSignedness
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.coreDsl.IntrinsicExpression
import com.minres.coredsl.coreDsl.ListInitializer
import com.minres.coredsl.coreDsl.LoopStatement
import com.minres.coredsl.coreDsl.MemberAccessExpression
import com.minres.coredsl.coreDsl.ParenthesisExpression
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.ReturnStatement
import com.minres.coredsl.coreDsl.SpawnStatement
import com.minres.coredsl.coreDsl.Statement
import com.minres.coredsl.coreDsl.SwitchStatement
import com.minres.coredsl.coreDsl.TypeQualifier
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.UserTypeDeclaration
import com.minres.coredsl.coreDsl.VoidTypeSpecifier
import com.minres.coredsl.coreDsl.WhileLoop
import com.minres.coredsl.type.ArrayType
import com.minres.coredsl.type.CompositeType
import com.minres.coredsl.type.CoreDslType
import com.minres.coredsl.type.ErrorType
import com.minres.coredsl.type.FunctionType
import com.minres.coredsl.type.IntegerType
import com.minres.coredsl.util.CompilerAssertion
import com.minres.coredsl.util.TypedBigInteger
import com.minres.coredsl.validation.IssueCodes
import java.math.BigInteger
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.DataExtensions.*
import static extension com.minres.coredsl.util.ModelExtensions.*
import com.minres.coredsl.type.AddressSpaceType

class CoreDslAnalyzer {
	public static var boolean emitDebugInfo = false;

	def static AnalysisResults analyze(DescriptionContent desc, ValidationMessageAcceptor acceptor) {
		val results = new AnalysisResults(desc);

		for (isa : desc.definitions) {
			try {
				val ctx = CoreDslElaborator.elaborate(isa, acceptor);
				results.results.put(isa, ctx.analysisContext);
				analyzeIsa(ctx.analysisContext, ctx.root);
			} catch(Exception e) {
				acceptor.acceptError("An internal error occurred during analysis: " + e, isa,
					CoreDslPackage.Literals.ISA__NAME, -1, IssueCodes.InternalCompilerError)
			}
		}

		return results;
	}

	// /////////////////////////////////////////////////////////////////////////
	// ////////////////////////////// Top level ////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////
	def static dispatch void analyzeIsa(AnalysisContext ctx, CoreDef core) {
		for (iset : core.providedInstructionSets) {
			analyzeIsa(ctx, iset);
		}
		analyzeIsaShared(ctx, core);
	}

	def static dispatch void analyzeIsa(AnalysisContext ctx, InstructionSet iset) {
		if(iset.superType !== null) {
			analyzeIsa(ctx, iset.superType);
		}
		analyzeIsaShared(ctx, iset);
	}

	def private static void analyzeIsaShared(AnalysisContext ctx, ISA isa) {
		// types
		for (typeDecl : isa.typeDeclarations) {
			analyzeTypeDeclaration(ctx, typeDecl);
		}

		// architectural state
		for (statement : isa.archStateBody) {
			analyzeStatement(ctx, statement);
		}

		// functions
		for (function : isa.functions) {
			analyzeFunction(ctx, function);
		}

		// instructions
		for (instruction : isa.instructions) {
			analyzeInstruction(ctx, instruction);
		}

		// always blocks
		for (alwaysBlock : isa.alwaysBlocks) {
			analyzeAlwaysBlock(ctx, alwaysBlock);
		}
	}

	/**
	 * 1. If the function is marked 'extern', it must not specify a body. <i>(ExternFunctionWithBody)</i><br>
	 * 2. If the function is not marked 'extern', it must specify a body. <i>(MissingFunctionBody)</i><br>
	 * 3. If the function is not marked 'extern' and its return type is not void, all execution paths must end with a return statement. <i>(MissingReturnStatement)</i><br>
	 */
	def static analyzeFunction(AnalysisContext ctx, FunctionDefinition definition) {
		val returnType = analyzeTypeSpecifier(ctx, definition.returnType);
		val parameterTypes = definition.parameters.map[analyzeFunctionParameter(ctx, it)];

		ctx.setFunctionSignature(definition, new FunctionType(returnType, parameterTypes));

		if(definition.isExtern) {
			if(definition.body !== null) {
				ctx.acceptError("Extern function declaration must not specify an implementation", definition,
					CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.ExternFunctionWithBody);
			}

		} else {
			if(definition.body === null) {
				ctx.acceptError("Non-extern function declaration must specify an implementation", definition,
					CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.MissingFunctionBody);
			} else {
				analyzeStatement(ctx, definition.body);

				if(!returnType.isVoid && !isReturnTerminated(definition.body)) {
					ctx.acceptError("Not all execution paths return a value", definition,
						CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.MissingReturnStatement);
				}
			}
		}
	}

	/**
	 * 1. Function parameters may not be declared as aliases. <i>(ReferenceParameterDeclaration)</i><br>
	 * <br>
	 * In addition, all semantic restrictions for regular declarations must be fulfilled.
	 * @see CoreDslAnalyzer#analyzeDeclaration(AnalysisContext, Declaration) 
	 */
	def static CoreDslType analyzeFunctionParameter(AnalysisContext ctx, Declaration parameter) {
		CompilerAssertion.assertThat(parameter.declarators.size == 1,
			"Parameter declaration must have exactly one declarator");

		analyzeDeclaration(ctx, parameter, false);

		val declarator = parameter.declarators.get(0);

		if(declarator.isAlias) {
			ctx.acceptError("Function parameters may not be passed by reference", declarator,
				CoreDslPackage.Literals.DECLARATOR__ALIAS, -1, IssueCodes.ReferenceParameterDeclaration);
		}

		return ctx.getDeclaredType(declarator);
	}

	def static dispatch boolean isReturnTerminated(CompoundStatement statement) {
		return statement.statements.size > 0 && statement.statements.last.isReturnTerminated;
	}

	def static dispatch boolean isReturnTerminated(IfStatement statement) {
		return statement.elseBody !== null && statement.thenBody.isReturnTerminated &&
			statement.elseBody.isReturnTerminated
	}

	def static dispatch boolean isReturnTerminated(ReturnStatement statement) { return true; }

	def static dispatch boolean isReturnTerminated(Statement statement) { return false; }

	def static analyzeInstruction(AnalysisContext ctx, Instruction instruction) {
		analyzeInstructionEncoding(ctx, instruction.encoding);
		analyzeStatement(ctx, instruction.behavior);
	}

	def static analyzeInstructionEncoding(AnalysisContext ctx, Encoding encoding) {
		val highestAccessedBits = new HashMap<String, Integer>();

		for (field : encoding.fields.filter(BitField)) {
			var int highestAccessedBit = highestAccessedBits.getOrDefault(field.name, 0);

			val startIndexValue = CoreDslConstantExpressionEvaluator.evaluate(ctx, field.startIndex);
			val endIndexValue = CoreDslConstantExpressionEvaluator.evaluate(ctx, field.endIndex);

			highestAccessedBit = Math.max(highestAccessedBit, startIndexValue.value.intValue);
			highestAccessedBit = Math.max(highestAccessedBit, endIndexValue.value.intValue);

			highestAccessedBits.put(field.name, highestAccessedBit);
		}

		for (field : encoding.fields.filter(BitField)) {
			val type = IntegerType.unsigned(highestAccessedBits.get(field.name) + 1);

			if(!ctx.isDeclaredTypeSet(field)) {
				ctx.setDeclaredType(field, type);
			}
		}
	}

	def static analyzeAlwaysBlock(AnalysisContext ctx, AlwaysBlock alwaysBlock) {
		analyzeStatement(ctx, alwaysBlock.behavior);
	}

	// //////////////////////////////////////////////////////////////////////////
	// ////////////////////////////// Statements ////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////
	def static dispatch void analyzeStatement(AnalysisContext ctx, EmptyStatement statement) {
	}
	
	def static dispatch void analyzeStatement(AnalysisContext ctx, CompoundStatement statement) {
		var unreachable = false;
		for (nested : statement.statements) {
			analyzeStatement(ctx, nested);

			if(unreachable) {
				ctx.acceptWarning("Unreachable code", nested, null, -1, IssueCodes.UnreachableCode)
			}

			if(isReturnTerminated(nested)) {
				unreachable = true;
			}
		}
	}

	def static dispatch void analyzeStatement(AnalysisContext ctx, DeclarationStatement statement) {
		val isIsaStateElement = statement.eContainer instanceof ISA;
		analyzeDeclaration(ctx, statement.declaration, isIsaStateElement);
	}

	def private static boolean isStatementExpression(Expression expression) {
		switch (expression) {
			AssignmentExpression:
				return true
			FunctionCallExpression:
				return true
			PrefixExpression: {
				switch (expression.operator) {
					case '++': return true
					case '--': return true
				}
			}
			PostfixExpression: {
				switch (expression.operator) {
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
	def static dispatch void analyzeStatement(AnalysisContext ctx, ExpressionStatement statement) {
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
	def static dispatch void analyzeStatement(AnalysisContext ctx, IfStatement statement) {
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
	 * 1. The switch condition must be an expression with an integer type. <i>(SwitchConditionTypeInvalid)</i><br>
	 * 2. At most one default section may be present. <i>(SwitchMultipleDefaultSections)</i><br>
	 * 3. At most one case section may be present for each given value. <i>(SwitchDuplicateCaseSection)</i><br>
	 * 4. Each case section's value must be representable by the type of the switch condition. <i>(SwitchCaseConditionOutOfRange)</i>
	 */
	def static dispatch void analyzeStatement(AnalysisContext ctx, SwitchStatement statement) {
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
	def static dispatch void analyzeStatement(AnalysisContext ctx, ContinueStatement statement) {
		if(statement.ancestorOfType(LoopStatement) === null) {
			ctx.acceptError("Unexpected continue statement", statement, null, -1, IssueCodes.StrayControlFlowStatement);
		}
	}

	/**
	 * 1. The break statement must be contained within a loop or switch statement. <i>(StrayControlFlowStatement)</i>
	 */
	def static dispatch void analyzeStatement(AnalysisContext ctx, BreakStatement statement) {
		if(statement.ancestorOfType(LoopStatement) === null && statement.ancestorOfType(SwitchStatement) === null) {
			ctx.acceptError("Unexpected break statement", statement, null, -1, IssueCodes.StrayControlFlowStatement);
		}
	}

	/**
	 * 1. Return statements may only occur within functions. <i>(ReturnStatementOutsideFunction)</i><br>
	 * 2. If the function's return type is void, the return statement must not declare a value. <i>(ReturnWithValueInVoidFunction)</i><br>
	 * 3. If the function's return type is not void, the return statement must declare a value. <i>(ReturnWithoutValueInNonVoidFunction)</i><br>
	 * 4. The type of the return statement's value expression must be implicitly convertible to the function's return type. <i>(ReturnTypeNotConvertible)</i>
	 */
	def static dispatch void analyzeStatement(AnalysisContext ctx, ReturnStatement statement) {
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
		} else if(valueType !== null && !CoreDslTypeProvider.canImplicitlyConvert(valueType, returnType)) {
			ctx.acceptError("Cannot convert from " + valueType + " to " + returnType, statement,
				CoreDslPackage.Literals.RETURN_STATEMENT__TRETURN, -1, IssueCodes.ReturnTypeNotConvertible);
		}
	}

	/**
	 * 1. The condition must be an expression with a scalar type. <i>(NonScalarCondition)</i>
	 */
	def static dispatch void analyzeStatement(AnalysisContext ctx, WhileLoop statement) {
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
	def static dispatch void analyzeStatement(AnalysisContext ctx, ForLoop statement) {

		if(statement.startDeclaration !== null) {
			analyzeDeclaration(ctx, statement.startDeclaration, false);
		}

		if(statement.startExpression !== null) {
			analyzeExpression(ctx, statement.startExpression);
			if(!isStatementExpression(statement.startExpression)) {
				ctx.acceptError("Invalid expression in expression statement", statement,
					CoreDslPackage.Literals.FOR_LOOP__START_EXPRESSION, -1, IssueCodes.InvalidStatementExpression);
			}
		}
		
		if(statement.condition !== null) {
			val conditionType = analyzeExpression(ctx, statement.condition);
			if(!conditionType.isScalarType) {
				ctx.acceptError("The condition must be a scalar type", statement,
					CoreDslPackage.Literals.LOOP_STATEMENT__CONDITION, -1, IssueCodes.NonScalarCondition);
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
	def static dispatch void analyzeStatement(AnalysisContext ctx, DoLoop statement) {
		val conditionType = analyzeExpression(ctx, statement.condition);

		if(!conditionType.isScalarType) {
			ctx.acceptError("The condition must be a scalar type", statement,
				CoreDslPackage.Literals.LOOP_STATEMENT__CONDITION, -1, IssueCodes.NonScalarCondition);
		}

		analyzeStatement(ctx, statement.body);
	}

	def static dispatch void analyzeStatement(AnalysisContext ctx, SpawnStatement statement) {
		analyzeStatement(ctx, statement.body);
	}

	def static dispatch void analyzeStatement(AnalysisContext ctx, Statement statement) {
		ctx.acceptInfo("Analysis for this node is not supported yet", statement, null, -1,
			IssueCodes.UnsupportedLanguageFeature);
	}

	// ////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////// Declarations ////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////
	def static dispatch CoreDslType analyzeTypeDeclaration(AnalysisContext ctx, EnumTypeDeclaration declaration) {
		for (member : declaration.members) {
			val initializer = member.initializer;
			switch (initializer) {
				ListInitializer: {
					ctx.acceptError("Enum members must not use list initializers", initializer, null, 1,
						IssueCodes.InvalidListInitializer);
				}
			}
		}
	}

	def static dispatch CoreDslType analyzeTypeDeclaration(AnalysisContext ctx, CompositeTypeDeclaration declaration) {
		if(ctx.isUserTypeInstanceSet(declaration))
			return ctx.getUserTypeInstance(declaration);
		
		val fields = new ArrayList<Declarator>();
		var int bitSize = 0;

		for (decl : declaration.members) {
			analyzeDeclaration(ctx, decl, false);

			for (field : decl.declarators) {
				fields.add(field);
				ctx.setFieldOffset(field, new ConstantValue(bitSize));

				// TODO alignment?
				val type = ctx.getDeclaredType(field);
				if(type.isValid) {
					bitSize += type.bitSize;
				}
			}
		}

		if(bitSize <= 0) bitSize = 1;

		val compositeType = new CompositeType(declaration, fields, bitSize);
		return ctx.setUserTypeInstance(declaration as UserTypeDeclaration, compositeType);
	}

	def static CoreDslType analyzeTypeSpecifier(AnalysisContext ctx, TypeSpecifier typeSpecifier) {
		return CoreDslTypeProvider.getSpecifiedType(ctx, typeSpecifier);
	}

	def static void analyzeDeclaration(AnalysisContext ctx, Declaration declaration, boolean isIsaStateElement) {
		if(declaration.type instanceof VoidTypeSpecifier) {
			ctx.acceptError("Declarations may not use type void", declaration,
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

		if(declaration.storage.size > 1) {
			ctx.acceptError("A declaration may not specify more than one storage class", declaration,
				CoreDslPackage.Literals.DECLARATION__STORAGE, 1 /* show it on the second specifier */ ,
				IssueCodes.MultipleStorageClassSpecifiers);
		}

		if(isIsaStateElement && declaration.declarators.any[ctx.getStorageClass(it) === StorageClass.param]) {
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

		val declarationType = analyzeTypeSpecifier(ctx, declaration.type);

		for (declarator : declaration.declarators) {
			analyzeDeclarator(ctx, declarator, declarationType, isIsaStateElement);
		}

		if(!isIsaStateElement && !declaration.storage.empty) {
			ctx.acceptError("Storage class specifiers are only allowed on ISA level declarations", declaration,
				CoreDslPackage.Literals.DECLARATION__STORAGE, -1, IssueCodes.StorageClassSpecifierOnLocalVariable);
		}
	}

	/**
	 * 1. Const declarators must be initialized. <i>(UninitializedConstant)</i><br>
	 * 2. Alias declarators must fulfill additional requirements.<br>
	 * 3a. If the declarator uses an expression initializer, the expression's type must be implicitly convertible to the declarator's type. <i>(InvalidAssignmentType)</i><br>
	 * 3b. If an array declarator uses a list initializer, the number of elements in the array type must match the number of elements in the initializer,
	 *     and all elements must be implicitly convertible to array's element type. <i>(InvalidAssignmentType)</i><br>
	 * 4. ISA parameters must not be declared as arrays. <i>(InvalidIsaParameterDeclaration)</i><br>
	 * 5. ISA level declarations (address spaces) must not be multidimensional. <i>(MultidimensionalAddressSpace)</i><br>
	 * 6. Array dimension specifiers must be non-negative constant values. <i>(InvalidArraySize)</i><br>
	 * 7. [Warning] Array dimension specifiers should not be zero. <i>(InvalidArraySize)</i>
	 * 
	 * @see CoreDslAnalyzer#analyzeAliasDeclarator(AnalysisContext, Declarator, CoreDslType, boolean)
	 */
	def static void analyzeDeclarator(AnalysisContext ctx, Declarator declarator, CoreDslType declarationType,
		boolean isIsaStateElement) {
		var type = declarationType;

		// storage class of state elements and type members has already been set during elaboration
		if(!isIsaStateElement && !declarator.isUserTypeMember) {
			ctx.setStorageClass(declarator, StorageClass.local);
		}

		// do this first because it may modify the type
		if(!declarator.dimensions.empty) {
			if(declarator.isIsaParameter) {
				ctx.acceptError("An ISA parameter may not be declared as an array", declarator,
					CoreDslPackage.Literals.DECLARATOR__DIMENSIONS, 1, IssueCodes.InvalidIsaParameterDeclaration);
			}
			
			val isAddressSpace = isIsaStateElement;
			
			if(isAddressSpace && declarator.dimensions.size > 1) {
				ctx.acceptError("Multidimensional address spaces are not allowed", declarator,
					CoreDslPackage.Literals.DECLARATOR__DIMENSIONS, declarator.dimensions.size - 2, IssueCodes.MultidimensionalAddressSpace);
			}

			// rightmost size specifier is the innermost one, so process them in reverse order
			for (var i = declarator.dimensions.size() - 1; i >= 0; i--) {
				val size = CoreDslConstantExpressionEvaluator.evaluate(ctx, declarator.dimensions.get(i));
				if(size.isValid) {
					if(size.value < BigInteger.ZERO) {
						type = isAddressSpace ? AddressSpaceType.ofUnknownSize(type) : ArrayType.ofUnknownSize(type);
						ctx.acceptError("Negative array size is invalid", declarator,
							CoreDslPackage.Literals.DECLARATOR__DIMENSIONS, i, IssueCodes.InvalidArraySize);
					} else {
						if(size.value == BigInteger.ZERO) {
							ctx.acceptWarning("Array size is zero", declarator,
								CoreDslPackage.Literals.DECLARATOR__DIMENSIONS, i, IssueCodes.ArraySizeIsZero);
						}
						else if(!isAddressSpace && !size.value.isInIntegerRange) {
							ctx.acceptWarning("Array size is greater than Integer.MAX_VALUE", declarator,
								CoreDslPackage.Literals.DECLARATOR__DIMENSIONS, i, IssueCodes.InvalidArraySize);
							type = ArrayType.ofUnknownSize(type);
						}
						type = isAddressSpace ? new AddressSpaceType(type, size.value) : new ArrayType(type, size.value.intValueExact);
					}
				} else {
					type = isAddressSpace ? AddressSpaceType.ofUnknownSize(type) : ArrayType.ofUnknownSize(type);
					if(!ctx.isPartialAnalysis) {
						ctx.acceptError("Unable to determine array size", declarator,
							CoreDslPackage.Literals.DECLARATOR__DIMENSIONS, i, IssueCodes.InvalidArraySize);
					}
				}
			}
		}

		// type of state elements and type members has already been set during elaboration
		if(!isIsaStateElement && !declarator.isUserTypeMember) {
			ctx.setDeclaredType(declarator, type);
		}

		if(declarator.isConst && declarator.initializer === null) {
			ctx.acceptError("An identifier declared as const must be initialized", declarator,
				CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.UninitializedConstant);
		}

		if(declarator.isAlias) {
			analyzeAliasDeclarator(ctx, declarator, type, isIsaStateElement);
		} else if(declarator.initializer !== null) {
			var initializer = declarator.initializer;
			if(initializer instanceof ExpressionInitializer) {
				val valueType = analyzeExpression(ctx, initializer.value);
				if(!CoreDslTypeProvider.canImplicitlyConvert(valueType, type)) {
					ctx.acceptError("Cannot implicitly convert " + valueType + " to " + type, declarator,
						CoreDslPackage.Literals.DECLARATOR__TEQUALS, -1, IssueCodes.InvalidAssignmentType);
				}
			} else if(type.isArrayType) {
				val listInitializer = initializer as ListInitializer;
				val arrayType = type as ArrayType;
				if (!arrayType.isUnknownSize && arrayType.count != listInitializer.initializers.size)
					ctx.acceptError("List initializer size does not match array size", declarator,
						CoreDslPackage.Literals.DECLARATOR__TEQUALS, -1, IssueCodes.InvalidAssignmentType);
				for (subInitializer : listInitializer.initializers) {
					if(subInitializer instanceof ExpressionInitializer) {
						val valueType = analyzeExpression(ctx, subInitializer.value);
						if(!CoreDslTypeProvider.canImplicitlyConvert(valueType, arrayType.elementType)) {
							ctx.acceptError("Cannot implicitly convert " + valueType + " to " + arrayType.elementType, declarator,
							CoreDslPackage.Literals.DECLARATOR__TEQUALS, -1, IssueCodes.InvalidAssignmentType);
						}
						if(isIsaStateElement) {
							CoreDslConstantExpressionEvaluator.evaluate(ctx, subInitializer.value);
						}
					} else {
						ctx.acceptError("Nested list initializers are unsupported", declarator,
							CoreDslPackage.Literals.DECLARATOR__TEQUALS, -1, IssueCodes.UnsupportedLanguageFeature);
					}
				}
			} else if(type.isStructType) {
				// TODO list initializers
				ctx.acceptError("List initializers are currently unsupported ", declarator,
					CoreDslPackage.Literals.DECLARATOR__TEQUALS, -1, IssueCodes.UnsupportedLanguageFeature);
			} else if(!type.isError) {
				ctx.acceptError("Cannot use list initializer to initialize value of type " + type, declarator,
					CoreDslPackage.Literals.DECLARATOR__TEQUALS, -1, IssueCodes.InvalidListInitializer);
			}
		}
	}

	/**
	 * 1. Only ISA state elements may be declared as aliases. <i>(AliasLocalVariable)</i><br>
	 * 2. The declarator must be initialized with an expression. <i>(UninitializedAlias, InvalidListInitializer)</i><br>
	 * 3. The expression's type must exactly match the declared type of the alias. <i>(InvalidAssignmentType)</i><br>
	 * 4. The initialization expression must be a valid alias source.
	 * 
	 * @see CoreDslAnalyzer#analyzeAliasSource(AnalysisContext, Declarator, Expression)
	 */
	def static analyzeAliasDeclarator(AnalysisContext ctx, Declarator declarator, CoreDslType type,
		boolean isIsaStateElement) {
		CompilerAssertion.assertThat(declarator.isAlias, "analyzeAliasDeclarator called with non-alias declarator");

		if(!isIsaStateElement) {
			ctx.acceptError("A local variable may not be declared as alias", declarator,
				CoreDslPackage.Literals.DECLARATOR__ALIAS, -1, IssueCodes.AliasLocalVariable);
		}

		val initializer = declarator.initializer;
		switch initializer {
			ExpressionInitializer: {
				// analyzeExpression must run before analyzeAliasSource
				val valueType = analyzeExpression(ctx, initializer.value);

				// being implicitly convertible is not good enough for alias assignments,
				// because the alias and its source must have exactly matching bit patterns
				if(valueType.isValid && valueType != type) {
					ctx.acceptError("Alias must be initialized with exactly the same type it is declared as",
						declarator, CoreDslPackage.Literals.DECLARATOR__TEQUALS, -1, IssueCodes.InvalidAssignmentType);
				}

				analyzeAliasSource(ctx, declarator, (declarator.initializer as ExpressionInitializer).value);
			}
			ListInitializer: {
				ctx.acceptError("An identifier declared as alias must not use a list initializer", declarator,
					CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.InvalidListInitializer);
			}
			default: {
				ctx.acceptError("An identifier declared as alias must be initialized", declarator,
					CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.UninitializedAlias);
			}
		}
	}

	/**
	 * 1. The alias source must be an identifier followed by any number of index or range accesses. <i>(InvalidAliasSource)</i><br>
	 * 2. The identifier must refer to a declarator with storage class 'extern' or 'register'. <i>(InvalidAliasSource)</i><br>
	 * 3. Index and range accesses must be in range [0, elementCount). <i>(IndexOutOfRange)</i>
	 * 
	 * @see CoreDslAnalyzer#checkIndexAccessBounds(AnalysisContext, BigInteger, int, IndexAccessExpression, EStructuralFeature)
	 */
	def static void analyzeAliasSource(AnalysisContext ctx, Declarator declarator, Expression expression) {
		// this assumes that the entire expression subtree has already been analyzed,
		// so that ctx.getExpressionValue and ctx.getExpressionType don't throw.
		switch expression {
			EntityReference: {
				val target = expression.target;
				if(target instanceof Declarator) {
					val storage = ctx.getStorageClass(target);
					switch storage {
						// case alias, // TODO allow this (and update doc comment)
						case extern,
						case register: {
							// valid
						}
						default: {
							ctx.acceptError(
								"Cannot define an alias to " + target.name + " because it has storage class " + storage,
								declarator, CoreDslPackage.Literals.DECLARATOR__TEQUALS, -1,
								IssueCodes.InvalidAliasSource);
						}
					}
				} else {
					ctx.acceptError("Cannot define an alias to " + target.name +
						" because it does not refer to a declarator", declarator,
						CoreDslPackage.Literals.DECLARATOR__TEQUALS, -1, IssueCodes.InvalidAliasSource);
				}
			}
			IndexAccessExpression: {
				analyzeAliasSource(ctx, declarator, expression.target);
				val targetType = ctx.getExpressionType(expression.target);
				val indexValue = ctx.getExpressionValue(expression.index);
				
				if(!targetType.isValid) return;

				if(indexValue.isValid) {
					if(targetType instanceof AddressSpaceType) {
						if(!targetType.isUnknownSize) {
							checkIndexAccessBounds(ctx, indexValue.value, targetType.count, expression,
								CoreDslPackage.Literals.INDEX_ACCESS_EXPRESSION__INDEX);
						}
					} else if(targetType instanceof IntegerType) {
						checkIndexAccessBounds(ctx, indexValue.value, BigInteger.valueOf(targetType.bitSize), expression,
							CoreDslPackage.Literals.INDEX_ACCESS_EXPRESSION__INDEX);
					} else {
						// error should already have been reported by analyzeExpression
					}
				}

				if(expression.endIndex !== null) {
					val endIndexValue = ctx.getExpressionValue(expression.endIndex);

					if(endIndexValue.isValid) {
						if(targetType instanceof AddressSpaceType) {
							checkIndexAccessBounds(ctx, endIndexValue.value, targetType.count, expression,
								CoreDslPackage.Literals.INDEX_ACCESS_EXPRESSION__END_INDEX);
						} else if(targetType instanceof IntegerType) {
							checkIndexAccessBounds(ctx, endIndexValue.value, BigInteger.valueOf(targetType.bitSize), expression,
								CoreDslPackage.Literals.INDEX_ACCESS_EXPRESSION__END_INDEX);
						} else {
							// error should already have been reported by analyzeExpression
						}
					}
				}
			}
			default: {
				ctx.acceptError("Alias source must be an identifier followed by any number of index or range accesses",
					expression, null, -1, IssueCodes.InvalidAliasSource);
			}
		}
	}

	/**
	 * 1. The index value must not be negative. <i>(IndexOutOfRange)</i><br>
	 * 2. The index value must not be greater than or equal to the element count. <i>(IndexOutOfRange)</i><br>
	 */
	def private static void checkIndexAccessBounds(AnalysisContext ctx, BigInteger value, BigInteger elementCount,
		IndexAccessExpression expression, EStructuralFeature feature) {
		if(value < BigInteger.ZERO) {
			ctx.acceptError("Index out of range (" + value + " < 0)", expression, feature, -1,
				IssueCodes.IndexOutOfRange);
		} else if(value >= elementCount) {
			ctx.acceptError("Index out of range (" + value + " >= " + elementCount + ")", expression,
				feature, -1, IssueCodes.IndexOutOfRange);
		}
	}

	// ///////////////////////////////////////////////////////////////////////////
	// ////////////////////////////// Expressions ////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////
	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, BoolConstant expression) {
		return ctx.setExpressionType(expression, IntegerType.bool);
	}

	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, IntegerConstant expression) {
		val value = expression.value as TypedBigInteger;
		var type = new IntegerType(value.size, value.signed);
		
		if(!ctx.isExpressionValueSet(expression))
			ctx.setExpressionValue(expression, new ConstantValue(value));
		
		return ctx.setExpressionType(expression, type);
	}

	/**
	 * 1. The type of the right-hand side expression must be implicitly convertible to the type of the left-hand side expression. <i>(InvalidAssignmentType)</i><br>
	 * 2. If a compound assignment operator is used, both types must be integer types. <i>(InvalidOperationType)</i><br>
	 * 3. The left-hand side expression must be assignable. <i>(InvalidAssignmentTarget)</i>
	 * @see CoreDslAnalyzer#analyzeAssignmentTarget(AnalysisContext, Expression)
	 */
	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, AssignmentExpression expression) {
		var targetType = analyzeExpression(ctx, expression.target);
		var valueType = analyzeExpression(ctx, expression.value);

		analyzeAssignmentTarget(ctx, expression.target);

		if(!CoreDslTypeProvider.canImplicitlyConvert(valueType, targetType)) {
			ctx.acceptError("Cannot implicitly convert " + valueType + " to " + targetType, expression,
				CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidAssignmentType);
		}

		if(expression.operator != '=' && (!targetType.isIntegerType || ! valueType.isIntegerType)) {
			ctx.acceptError(
				"Cannot combine " + valueType + " and " + targetType + " with the " +
					expression.operator.substring(0, 1) + " operator", expression,
				CoreDslPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
		}

		return ctx.setExpressionType(expression, targetType);
	}

	def static dispatch void analyzeAssignmentTarget(AnalysisContext ctx, EntityReference expression) {
		switch (expression.target) {
			FunctionDefinition: {
				ctx.acceptError("Cannot assign to function", expression, null, -1, IssueCodes.InvalidAssignmentTarget);
			}
			BitField: {
				ctx.acceptError("Cannot assign to encoding parameter", expression, null, -1,
					IssueCodes.InvalidAssignmentTarget);
			}
			Declarator: {
				var declarator = expression.target as Declarator;
				val isIsaLevelAssignment = expression.ancestorOfType(ExpressionStatement)?.eContainer instanceof ISA;

				if(declarator.isConst || declarator.isIsaParameter && !isIsaLevelAssignment) {
					ctx.acceptError("Cannot assign to constant", expression, null, -1,
						IssueCodes.InvalidAssignmentTarget);
				}
			}
			default: {
				CompilerAssertion.fail("Invalid entity reference");
			}
		}
	}

	def static dispatch void analyzeAssignmentTarget(AnalysisContext ctx, IndexAccessExpression expression) {
		analyzeAssignmentTarget(ctx, expression.target);
	}

	def static dispatch void analyzeAssignmentTarget(AnalysisContext ctx, MemberAccessExpression expression) {
		analyzeAssignmentTarget(ctx, expression.target);
		if(expression.declarator.isConst) {
			ctx.acceptError("Cannot assign constant field '" + expression.declarator.name + "'", expression,
				CoreDslPackage.Literals.MEMBER_ACCESS_EXPRESSION__DECLARATOR, -1, IssueCodes.InvalidAssignmentTarget)
		}
	}

	def static dispatch void analyzeAssignmentTarget(AnalysisContext ctx, Expression expression) {
		ctx.acceptError("Invalid assignment target", expression, null, -1, IssueCodes.InvalidAssignmentTarget);
	}

	/**
	 * 1. The value type must be convertible to the target type. <i>(InvalidCast)</i><br>
	 * 2. A signedness cast can only be applied to integer type expressions. <i>(InvalidCast)</i><br>
	 * 3. [Warning] The target type should be different from the value type. <i>(IdentityCast)</i>
	 */
	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, CastExpression expression) {
		val valueType = analyzeExpression(ctx, expression.operand);
		if(expression.targetType !== null) {
			val targetType = analyzeTypeSpecifier(ctx, expression.targetType);
			if(!CoreDslTypeProvider.canExplicitlyConvert(valueType, targetType)) {
				ctx.acceptError("Cannot cast from " + valueType + " to " + targetType, expression,
					CoreDslPackage.Literals.CAST_EXPRESSION__TARGET_TYPE, -1, IssueCodes.InvalidCast);
			}
			if(targetType.equals(valueType)) {
				ctx.acceptWarning("Identity cast does nothing", expression,
					CoreDslPackage.Literals.CAST_EXPRESSION__TARGET_TYPE, -1, IssueCodes.IdentityCast);
			}
			return ctx.setExpressionType(expression, targetType);
		} else {
			if(!valueType.isIntegerType) {
				ctx.acceptError("Cannot apply signedness cast to non-integer value", expression,
					CoreDslPackage.Literals.CAST_EXPRESSION__SIGNEDNESS, -1, IssueCodes.InvalidCast);
				return ctx.setExpressionType(expression, ErrorType.invalid);
			} else {
				val intType = valueType as IntegerType;
				val toSigned = expression.signedness == IntegerSignedness.SIGNED;
				if(toSigned == intType.signed) {
					ctx.acceptWarning("Identity cast does nothing", expression,
						CoreDslPackage.Literals.CAST_EXPRESSION__SIGNEDNESS, -1, IssueCodes.IdentityCast);
				}
				return ctx.setExpressionType(expression, new IntegerType(intType.bitSize, toSigned));
			}
		}
	}

	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, ConcatenationExpression expression) {
		val parts = expression.parts.map[analyzeExpression(ctx, it)];
		var width = 0;

		for (part : parts) {
			if(part.isError) return ctx.setExpressionType(expression, ErrorType.invalid);
			width += part.bitSize;
		}

		return ctx.setExpressionType(expression, new IntegerType(width, false));
	}

	/**
	 * 1. The condition must be an expression with a scalar type. <i>(NonScalarCondition)</i><br>
	 * 2. One of the two options' type has to be implicitly convertible to the other one. <i>(IncompatibleOptionTypes)</i>
	 */
	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, ConditionalExpression expression) {
		val conditionType = analyzeExpression(ctx, expression.condition);
		val thenType = analyzeExpression(ctx, expression.thenExpression);
		val elseType = analyzeExpression(ctx, expression.elseExpression);

		if(!conditionType.isScalarType) {
			ctx.acceptError("The condition must be a scalar type", expression,
				CoreDslPackage.Literals.CONDITIONAL_EXPRESSION__CONDITION, -1, IssueCodes.NonScalarCondition);
		}

		if(thenType.isError) return ctx.setExpressionType(expression, thenType);
		if(elseType.isError) return ctx.setExpressionType(expression, elseType);

		if(thenType == elseType) {
			return ctx.setExpressionType(expression, thenType);
		}

		if(thenType.isIntegerType && elseType.isIntegerType) {
			val type = CoreDslTypeProvider.getSmallestCommonType(thenType as IntegerType, elseType as IntegerType);
			return ctx.setExpressionType(expression, type);
		}

		ctx.acceptError("Incompatible option types: " + thenType + " and " + elseType, expression,
			CoreDslPackage.Literals.CONDITIONAL_EXPRESSION__TCOLON, -1, IssueCodes.IncompatibleOptionTypes);
		return ctx.setExpressionType(expression, ErrorType.invalid);
	}

	/**
	 * 1. The entity reference may not reference a function. <i>(ReferenceToFunction)</i>
	 * @see CoreDslAnalyzer#_analyzeExpression(AnalysisContext, FunctionCallExpression)
	 */
	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, EntityReference expression) {
		if(expression.target instanceof FunctionDefinition) {
			ctx.acceptError("Function used like a variable", expression, null, -1, IssueCodes.ReferenceToFunction);
			return ctx.setExpressionType(expression, ErrorType.invalid);
		}

		if(!ctx.isDeclaredTypeSet(expression.target))
			return ctx.setExpressionType(expression, ErrorType.invalid);

		val type = ctx.getDeclaredType(expression.target);
		// ctx.acceptInfo("Type: " + type, expression, null, -1, IssueCodes.DebugInfo);
		return ctx.setExpressionType(expression, type);
	}

	/**
	 * 1. The target must be an EntityReference pointing to a function definition. <i>(InvalidFunction)</i><br>
	 * 2. The number of arguments must match the number of parameters of the function. <i>(InvalidArgumentCount)</i><br>
	 * 3. Each argument must be implicitly convertible to the corresponding parameter's type. <i>(InvalidArgumentType)</i>
	 */
	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, FunctionCallExpression expression) {
		var function = expression.target.castOrNull(EntityReference)?.target.castOrNull(FunctionDefinition);
		var arguments = expression.arguments.map[analyzeExpression(ctx, it)];

		if(function === null) {
			ctx.acceptError("Expected a function name", expression,
				CoreDslPackage.Literals.FUNCTION_CALL_EXPRESSION__TARGET, -1, IssueCodes.InvalidFunction);
			return ctx.setExpressionType(expression, ErrorType.invalid);
		}

		var functionType = ctx.getFunctionSignature(function);

		if(functionType.paramTypes.size !== arguments.size) {
			ctx.acceptError("Incorrect argument count. Expected " + functionType.paramTypes.size + ", got " +
				arguments.size, expression, CoreDslPackage.Literals.FUNCTION_CALL_EXPRESSION__TARGET, -1,
				IssueCodes.InvalidArgumentCount);
			return ctx.setExpressionType(expression, functionType.returnType);
		}

		for (var i = 0; i < arguments.size; i++) {
			val paramType = functionType.paramTypes.get(i);
			val argType = arguments.get(i);
			if(!CoreDslTypeProvider.canImplicitlyConvert(argType, paramType)) {
				ctx.acceptError("Cannot convert " + argType + " to " + paramType, expression,
					CoreDslPackage.Literals.FUNCTION_CALL_EXPRESSION__ARGUMENTS, i, IssueCodes.InvalidArgumentType);
			}
		}

		return ctx.setExpressionType(expression, functionType.returnType);
	}

	/**
	 * 1. The target must be an expression with an array or integer type. <i>(NonIndexableExpression)</i><br>
	 * 2. The index must be an expression with an integer type. <i>(InvalidIndexType)</i><br>
	 * 3. If present, the end index must be an expression with an integer type. <i>(InvalidIndexType)</i><br>
	 * 4. If an end index is present, the two indices must follow one of the patterns described <a href="https://github.com/Minres/CoreDSL/wiki/Expressions#range-operator">here</a>. <i>(InvalidRangePattern)</i>
	 * @see CoreDslAnalyzer#getRangeSize(AnalysisContext, Expression, Expression)
	 */
	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, IndexAccessExpression expression) {
		val targetType = analyzeExpression(ctx, expression.target);
		val indexType = analyzeExpression(ctx, expression.index);

		var CoreDslType elementType;
		if(targetType instanceof ArrayType) {
			elementType = targetType.elementType;
		} else if(targetType instanceof AddressSpaceType) {
			elementType = targetType.elementType;
		} else if(targetType instanceof IntegerType) {
			elementType = IntegerType.bool;
		} else {
			ctx.acceptError("Cannot index into " + targetType, expression,
				CoreDslPackage.Literals.INDEX_ACCESS_EXPRESSION__TARGET, -1, IssueCodes.NonIndexableExpression);
			elementType = ErrorType.invalid;
		}

		if(!indexType.isIntegerType) {
			ctx.acceptError("Index must have an integer type", expression,
				CoreDslPackage.Literals.INDEX_ACCESS_EXPRESSION__INDEX, -1, IssueCodes.InvalidIndexType);
		}

		if(expression.endIndex !== null) {
			val endIndexType = analyzeExpression(ctx, expression.endIndex);

			if(!endIndexType.isIntegerType) {
				ctx.acceptError("Index must have an integer type", expression,
					CoreDslPackage.Literals.INDEX_ACCESS_EXPRESSION__END_INDEX, -1, IssueCodes.InvalidIndexType);
			}

			val elementCount = getRangeSize(ctx, expression.index, expression.endIndex);
			if(elementCount === null) {
				ctx.acceptError("Invalid range pattern", expression,
					CoreDslPackage.Literals.INDEX_ACCESS_EXPRESSION__TCOLON, -1, IssueCodes.InvalidRangePattern);
				return ctx.setExpressionType(expression, ErrorType.invalid);
			}
			
			val totalSize = BigInteger.valueOf(elementType.bitSize) * elementCount;
			
			if(!totalSize.isInIntegerRange) {
				ctx.acceptError('The combined size of the selected elements must not exceed Integer.MAX_VALUE', expression,
					CoreDslPackage.Literals.INDEX_ACCESS_EXPRESSION__TCOLON, -1, IssueCodes.InvalidIntegerTypeSize);
					return ctx.setExpressionType(expression, ErrorType.invalid);
			}
			
			val intType = elementType.isValid ? new IntegerType(totalSize.intValueExact, false) : ErrorType.invalid;
			return ctx.setExpressionType(expression, intType);
		} else {
			return ctx.setExpressionType(expression, elementType);
		}
	}

	/**
	 * Implements the patterns described <a href="https://github.com/Minres/CoreDSL/wiki/Expressions#range-operator">here</a>.
	 */
	def static BigInteger getRangeSize(AnalysisContext ctx, Expression start, Expression end) {
		if(start instanceof EntityReference && end instanceof InfixExpression ||
			start instanceof InfixExpression && end instanceof EntityReference) {
			val reference = start instanceof EntityReference ? start : end as EntityReference;
			val infix = start instanceof InfixExpression ? start : end as InfixExpression;

			val entity = reference.target;
			val left = infix.left;
			val right = infix.right;

			if(infix.operator.isOneOf('+', '-') && left instanceof EntityReference &&
				(left as EntityReference).target === entity) {
				val difference = CoreDslConstantExpressionEvaluator.tryEvaluate(ctx, right);

				if(difference.isValid) {
					return difference.value.abs() + BigInteger.ONE;
				}
			}
		} else {
			val startValue = CoreDslConstantExpressionEvaluator.tryEvaluate(ctx, start);
			val endValue = CoreDslConstantExpressionEvaluator.tryEvaluate(ctx, end);

			if(startValue.isValid && endValue.isValid) {
				return (endValue.value - startValue.value).abs() + BigInteger.ONE;
			}
		}

		return null;
	}

	/**
	 * <b>Operator ||, &amp;&amp;</b><br>
	 * 1. Both operands must have scalar types.<br>
	 * 2. Result type is unsigned&lt;1&gt;.<br>
	 * <br> 
	 * <b>Operator |, ^, &amp;</b><br>
	 * 1. Both operands must have integer types.<br>
	 * 2. Result type is signed if at least one of the operands is signed.<br>
	 * 3. Result type has the size of the larger operand.<br>
	 * <br>
	 * <b>Operator ==, !=</b><br>
	 * 1. Both operands must have integer types <b>OR</b> both operands must have the same type.<br>
	 * 2. Result type is unsigned&lt;1&gt;.<br>
	 * <br>
	 * <b>Operator &lt;, &gt;, &lt;=, &gt;=</b><br>
	 * 1. Both operands must have integer types.<br>
	 * 2. Result type is unsigned&lt;1&gt;.<br>
	 * <br>
	 * <b>Operator &lt;&lt;, &gt;&gt;</b><br>
	 * 1. Both operands must have integer types.<br>
	 * 2. Result type is the type of the left operand.<br>
	 * 3. [Warning] Shift amount should not be greater than the left operand's bit size.<br>
	 * <br>
	 * <b>Operator +</b><br>
	 * 1. Both operands must have integer types.<br>
	 * <br>
	 * <b>Operator -</b><br>
	 * 1. Both operands must have integer types.<br>
	 * <br>
	 * <b>Operator *</b><br>
	 * 1. Both operands must have integer types.<br>
	 * <br>
	 * <b>Operator /</b><br>
	 * 1. Both operands must have integer types.<br>
	 * <br>
	 * <b>Operator %</b><br>
	 * 1. Both operands must have integer types.<br>
	 */
	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, InfixExpression expression) {
		val leftType = analyzeExpression(ctx, expression.left);
		val rightType = analyzeExpression(ctx, expression.right);

		val leftInt = leftType.castOrNull(IntegerType);
		val rightInt = rightType.castOrNull(IntegerType);

		if(leftType.isInvalid || rightType.isInvalid) return ctx.setExpressionType(expression, ErrorType.invalid);
		if(leftType.isIndeterminate || rightType.isIndeterminate)
			return ctx.setExpressionType(expression, ErrorType.indeterminate);

		switch (expression.operator) {
			case '||',
			case '&&': {
				if(!leftType.isScalarType || !rightType.isScalarType) {
					ctx.acceptError("Logical operators are only valid on scalar types", expression,
						CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
				}

				return ctx.setExpressionType(expression, IntegerType.bool);
			}
			case '|',
			case '^',
			case '&': {
				if(!leftType.isIntegerType || !rightType.isIntegerType) {
					ctx.acceptError("Bitwise operators are only valid on integer types", expression,
						CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
					return ctx.setExpressionType(expression, ErrorType.invalid);
				}

				return ctx.setExpressionType(expression,
					new IntegerType(Math.max(leftInt.bitSize, rightInt.bitSize), leftInt.signed || rightInt.signed));
			}
			case '==',
			case '!=': {
				if(leftType != rightType && !leftType.isIntegerType || !rightType.isIntegerType) {
					ctx.acceptError(
						"Equality comparisons are only valid on integer types or two operands of the same type",
						expression, CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1,
						IssueCodes.InvalidOperationType);
				}

				return ctx.setExpressionType(expression, IntegerType.bool);
			}
			case '<',
			case '>',
			case '<=',
			case '>=': {
				if(!leftType.isIntegerType || !rightType.isIntegerType) {
					ctx.acceptError("Magnitude comparisons are only valid on integer types", expression,
						CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
				}

				return ctx.setExpressionType(expression, IntegerType.bool);
			}
			case '<<',
			case '>>': {
				if(!leftType.isIntegerType || !rightType.isIntegerType) {
					ctx.acceptError("Shifts are only valid on integer types", expression,
						CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
					return ctx.setExpressionType(expression, ErrorType.invalid);
				}

				val shiftAmount = CoreDslConstantExpressionEvaluator.tryEvaluate(ctx, expression.right);
				if(shiftAmount.isValid && shiftAmount.value >= BigInteger.valueOf(leftType.bitSize)) {
					ctx.acceptWarning(
						"Shift expression always evaluates to zero; Please cast the left operand to a wider type before shifting",
						expression, CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.ShiftAlwaysZero);
				}

				return ctx.setExpressionType(expression, leftType);
			}
			case '+': {
				if(!leftType.isIntegerType || !rightType.isIntegerType) {
					ctx.acceptError("Addition is only valid on integer types", expression,
						CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
					return ctx.setExpressionType(expression, ErrorType.invalid);
				}

				var int width;
				if(leftInt.signed == rightInt.signed) {
					width = Math.max(leftInt.bitSize, rightInt.bitSize) + 1;
				} else {
					if(leftInt.signed) {
						width = Math.max(leftInt.bitSize, rightInt.bitSize + 1) + 1;
					} else {
						width = Math.max(leftInt.bitSize + 1, rightInt.bitSize) + 1;
					}
				}

				return ctx.setExpressionType(expression, new IntegerType(width, leftInt.signed || rightInt.signed));
			}
			case '-': {
				if(!leftType.isIntegerType || !rightType.isIntegerType) {
					ctx.acceptError("Subtraction is only valid on integer types", expression,
						CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
					return ctx.setExpressionType(expression, ErrorType.invalid);
				}

				var int width;
				if(leftInt.signed == rightInt.signed) {
					width = Math.max(leftInt.bitSize, rightInt.bitSize) + 1;
				} else {
					if(leftInt.signed) {
						width = Math.max(leftInt.bitSize, rightInt.bitSize + 1) + 1;
					} else {
						width = Math.max(leftInt.bitSize + 1, rightInt.bitSize) + 1;
					}
				}

				return ctx.setExpressionType(expression, IntegerType.signed(width));
			}
			case '*': {
				if(!leftType.isIntegerType || !rightType.isIntegerType) {
					ctx.acceptError("Multiplication is only valid on integer types", expression,
						CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
					return ctx.setExpressionType(expression, ErrorType.invalid);
				}

				return ctx.setExpressionType(expression,
					new IntegerType(leftInt.bitSize + rightInt.bitSize, leftInt.signed || rightInt.signed));
			}
			case '/': {
				if(!leftType.isIntegerType || !rightType.isIntegerType) {
					ctx.acceptError("Division is only valid on integer types", expression,
						CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
					return ctx.setExpressionType(expression, ErrorType.invalid);
				}

				val int width = rightInt.signed ? leftInt.bitSize + 1 : leftInt.bitSize;
				return ctx.setExpressionType(expression, new IntegerType(width, leftInt.signed || rightInt.signed));
			}
			case '%': {
				if(!leftType.isIntegerType || !rightType.isIntegerType) {
					ctx.acceptError("Remainder is only valid on integer types", expression,
						CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
					return ctx.setExpressionType(expression, ErrorType.invalid);
				}

				var int width;
				if(leftInt.signed == rightInt.signed) {
					width = Math.min(leftInt.bitSize, rightInt.bitSize);
				} else {
					if(leftInt.signed) {
						width = Math.min(leftInt.bitSize, rightInt.bitSize + 1);
					} else {
						width = Math.min(leftInt.bitSize, rightInt.bitSize - 1);
					}
				}

				if(width == 0) width = 1;
				return ctx.setExpressionType(expression, new IntegerType(width, leftInt.signed));
			}
		}
	}

	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, IntrinsicExpression expression) {
		val argumentCount = expression.arguments.size();
		val argumentTypes = new ArrayList(expression.arguments.length);
		for (argument : expression.arguments) {
			switch (argument) {
				TypeSpecifier: {
					argumentTypes.add(analyzeTypeSpecifier(ctx, argument));
				}
				Expression: {
					argumentTypes.add(analyzeExpression(ctx, argument));
				}
			}
		}

		switch (expression.function) {
			case 'bitsizeof',
			case 'sizeof': {
				if(argumentCount !== 1) {
					ctx.acceptError(expression.function + ' expects exactly one argument', expression,
						CoreDslPackage.Literals.INTRINSIC_EXPRESSION__FUNCTION, -1, IssueCodes.InvalidArgumentCount);
					return ctx.setExpressionType(expression, ErrorType.invalid);
				} else {
					val value = CoreDslConstantExpressionEvaluator.evaluate(ctx, expression);
					if(value.isError) return ErrorType.indeterminate;
					val type = CoreDslTypeProvider.getSmallestTypeForValue(value.value);
					return ctx.setExpressionType(expression, type);
				}
			}
			default: {
				ctx.acceptError('Unknown intrinsic function ' + expression.function, expression,
					CoreDslPackage.Literals.INTRINSIC_EXPRESSION__FUNCTION, -1, IssueCodes.UnknownIntrinsicFunction);
				return ctx.setExpressionType(expression, ErrorType.invalid);
			}
		}
	}

	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, MemberAccessExpression expression) {
		val member = expression.declarator;

		if(member === null || member.eIsProxy)
			return ctx.setExpressionType(expression, ErrorType.invalid);

		return ctx.setExpressionType(expression, ctx.getDeclaredType(member));
	}

	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, ParenthesisExpression expression) {
		return ctx.setExpressionType(expression, analyzeExpression(ctx, expression.inner));
	}

	/**
	 * 1. The operand must have an integer type.<br>
	 * 2. Result type is the same as the operand type.<br>
	 * 3. The operand must be a valid assignment target.<br>
	 */
	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, PostfixExpression expression) {
		var operandType = analyzeExpression(ctx, expression.operand);
		analyzeAssignmentTarget(ctx, expression.operand);

		CompilerAssertion.assertThat(expression.operator.isOneOf('++', '--'),
			"Invalid postfix operator: " + expression.operator);

		if(!operandType.isIntegerType && !operandType.isError) {
			ctx.acceptError("Increment and decrement operators are only valid on integer types", expression,
				CoreDslPackage.Literals.POSTFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
		}

		return ctx.setExpressionType(expression, operandType);
	}

	/**
	 * <b>Operator ++, --</b><br>
	 * 1. The operand must have an integer type.<br>
	 * 2. Result type is the same as the operand type.<br>
	 * 3. The operand must be a valid assignment target.<br>
	 * <br>
	 * <b>Operator ~</b><br>
	 * 1. The operand must have an integer type.<br>
	 * 2. Result type is the same as the operand type.<br>
	 * <br>
	 * <b>Operator +</b><br>
	 * 1. The operand must have an integer type.<br>
	 * 2. Result type is the same as the operand type.<br>
	 * <br>
	 * <b>Operator -</b><br>
	 * 1. The operand must have an integer type.<br>
	 * 2. Result type is a signed integer with a width one larger than the operand.<br>
	 * <br>
	 * <b>Operator !</b><br>
	 * 1. The operand must have a scalar type.<br>
	 * 2. Result type is unsigned&lt;1&gt;.
	 */
	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, PrefixExpression expression) {
		var operandType = analyzeExpression(ctx, expression.operand);

		switch (expression.operator) {
			case '++',
			case '--': {
				analyzeAssignmentTarget(ctx, expression.operand);

				if(!operandType.isIntegerType && !operandType.isError) {
					ctx.acceptError("Increment and decrement operators are only valid on integer types", expression,
						CoreDslPackage.Literals.PREFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
				}

				return ctx.setExpressionType(expression, operandType);
			}
			case '~': {
				if(!operandType.isIntegerType && !operandType.isError) {
					ctx.acceptError("Bitwise negation is only valid on integer types", expression,
						CoreDslPackage.Literals.PREFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
				}

				return ctx.setExpressionType(expression, operandType);
			}
			case '+': {
				if(!operandType.isIntegerType && !operandType.isError) {
					ctx.acceptError("Unary plus is only valid on integer types", expression,
						CoreDslPackage.Literals.PREFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
				}

				return ctx.setExpressionType(expression, operandType);
			}
			case '-': {
				if(!operandType.isIntegerType && !operandType.isError) {
					ctx.acceptError("Unary minus is only valid on integer types", expression,
						CoreDslPackage.Literals.PREFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
				}

				val intType = operandType as IntegerType;
				return ctx.setExpressionType(expression, IntegerType.signed(intType.bitSize + 1));
			}
			case '!': {
				if(!operandType.isScalarType && !operandType.isError) {
					ctx.acceptError("Logical not is only valid on scalar types", expression,
						CoreDslPackage.Literals.PREFIX_EXPRESSION__OPERATOR, -1, IssueCodes.InvalidOperationType);
				}

				return ctx.setExpressionType(expression, IntegerType.bool);
			}
			default: {
				CompilerAssertion.fail("Invalid prefix operator: " + expression.operator);
				return null;
			}
		}
	}

	def static dispatch CoreDslType analyzeExpression(AnalysisContext ctx, Expression expression) {
		ctx.acceptInfo("Analysis for this node is not supported yet", expression, null, -1,
			IssueCodes.UnsupportedLanguageFeature);
		return ctx.setExpressionType(expression, ErrorType.indeterminate);
	}
}
