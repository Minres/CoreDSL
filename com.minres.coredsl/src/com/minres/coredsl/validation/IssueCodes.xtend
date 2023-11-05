package com.minres.coredsl.validation

class IssueCodes {
	private new() {
	}

	public static val SyntaxError = 'org.eclipse.xtext.diagnostics.Diagnostic.Syntax';
	public static val LinkingError = 'org.eclipse.xtext.diagnostics.Diagnostic.Linking';

	public static val _prefix = "com.minres.coredsl."

	// utility issues
	public static val DebugInfo = _prefix + 'DebugInfo';
	public static val UnsupportedLanguageFeature = _prefix + 'UnsupportedLanguageFeature';
	public static val InternalCompilerError = _prefix + 'InternalCompilerError';

	// type issues
	public static val InvalidIntegerTypeSize = _prefix + 'InvalidIntegerTypeSize';

	// isa issues
	public static val DuplicateIsaStateElement = _prefix + 'DuplicateIsaStateElement';
	public static val MismatchingIsaStateElementSignatures = _prefix + 'MismatchingIsaStateElementSignatures';
	public static val MultipleIdenticalProvides = _prefix + 'MultipleIdenticalProvides';
	public static val CyclicInstructionSetInheritance = _prefix + 'CyclicInstructionSetInheritance';
	public static val InvalidIsaParameterAssignmentInitializer = _prefix + 'InvalidIsaParameterAssignmentInitializer';
	public static val InvalidIsaParameterAssignmentExpression = _prefix + 'InvalidIsaParameterAssignmentExpression';
	public static val InvalidIsaParameterAssignmentOperator = _prefix + 'InvalidIsaParameterAssignmentOperator';
	public static val InvalidIsaParameterAssignmentTarget = _prefix + 'InvalidIsaParameterAssignmentTarget';
	public static val InvalidIsaParameterDeclaration = _prefix + 'InvalidIsaParameterDeclaration';
	public static val InvalidIsaParameterType = _prefix + 'InvalidIsaParameterType';
	public static val UnassignedIsaParameter = _prefix + 'UnassignedIsaParameter';
	public static val IndeterminableIsaStateElementValue = _prefix + 'IndeterminableIsaStateElementValue';
	public static val IndeterminableIsaStateElementType = _prefix + 'IndeterminableIsaStateElementType';
	public static val InvalidIsaStateElementValue = _prefix + 'InvalidIsaStateElementValue';
	public static val InvalidIsaStateElementType = _prefix + 'InvalidIsaStateElementType';
	
	// attribute issues
	public static val UnknownAttribute = _prefix + 'UnknownAttribute';
	public static val InvalidAttributePlacement = _prefix + 'InvalidAttributePlacement';
	public static val InvalidAttributeParameters = _prefix + 'InvalidAttributeParameters';
	public static val UnexpectedInstructionSize = _prefix + 'UnexpectedInstructionSize';
	
	// function issues
	public static val MissingFunctionBody = _prefix + 'MissingFunctionBody';
	public static val ExternFunctionWithBody = _prefix + 'ExternFunctionWithBody';
	public static val MissingReturnStatement = _prefix + 'MissingReturnStatement';

	// constant expression issues
	public static val InvalidConstantExpressionNode = _prefix + 'InvalidConstantExpressionNode';
	public static val InvalidConstantExpressionIdentifier = _prefix + 'InvalidConstantExpressionIdentifier';
	public static val DivisionByZero = _prefix + 'DivisionByZero';

	// declaration issues
	public static val StorageClassSpecifierOnLocalVariable = _prefix + 'StorageClassSpecifierOnLocalVariable';
	public static val AliasLocalVariable = _prefix + 'AliasLocalVariable';
	public static val MultipleStorageClassSpecifiers = _prefix + 'MultipleStorageClassSpecifiers';
	public static val DuplicateQualifier = _prefix + 'DuplicateQualifier';
	public static val UninitializedConstant = _prefix + 'UninitializedConstant';
	public static val UninitializedAlias = _prefix + 'UninitializedAlias';
	public static val VoidDeclaration = _prefix + 'VoidDeclaration';
	public static val MultidimensionalAddressSpace = _prefix + 'MultidimensionalAddressSpace';
	public static val InvalidArraySize = _prefix + 'InvalidArraySize';
	public static val ArraySizeIsZero = _prefix + 'ArraySizeIsZero';
	public static val ReferenceParameterDeclaration = _prefix + 'ReferenceParameterDeclaration';
	public static val InvalidListInitializer = _prefix + 'InvalidListInitializer';
	public static val InvalidAliasSource = _prefix + 'InvalidAliasSource';
	public static val InvalidAliasConstness = _prefix + 'InvalidAliasConstness';
	
	// statement issues
	public static val UnreachableCode = _prefix + 'UnreachableCode';
	public static val InvalidStatementExpression = _prefix + 'InvalidStatementExpression';
	public static val ReturnStatementOutsideFunction = _prefix + 'ReturnStatementOutsideFunction';
	public static val ReturnWithValueInVoidFunction = _prefix + 'ReturnWithValueInVoidFunction';
	public static val ReturnWithoutValueInNonVoidFunction = _prefix + 'ReturnWithoutValueInNonVoidFunction';
	public static val ReturnTypeNotConvertible = _prefix + 'ReturnTypeNotConvertible';
	public static val NonScalarCondition = _prefix + 'NonScalarCondition';
	public static val SwitchConditionTypeInvalid = _prefix + 'SwitchConditionTypeInvalid';
	public static val SwitchMultipleDefaultSections = _prefix + 'SwitchMultipleDefaultSections';
	public static val SwitchDuplicateCaseSection = _prefix + 'SwitchDuplicateCaseSection';
	public static val SwitchCaseConditionOutOfRange = _prefix + 'SwitchCaseConditionOutOfRange';
	public static val StrayControlFlowStatement = _prefix + 'StrayControlFlowStatement';
	public static val InvalidSpawnStatementPlacement = _prefix + 'InvalidSpawnStatementPlacement';
	
	// expression issues
	public static val ValidConstantAssignment = _prefix + 'ValidConstantAssignment';
	public static val InvalidAssignmentTarget = _prefix + 'InvalidAssignmentTarget';
	public static val InvalidAssignmentType = _prefix + 'InvalidAssignmentType';
	public static val InvalidOperationType = _prefix + 'InvalidOperationType';
	public static val InvalidCast = _prefix + 'InvalidCast';
	public static val IdentityCast = _prefix + 'IdentityCast';
	public static val IncompatibleOptionTypes = _prefix + 'IncompatibleOptionTypes';
	public static val ReferenceToFunction = _prefix + 'ReferenceToFunction';
	public static val InvalidFunction = _prefix + 'InvalidFunction';
	public static val InvalidArgumentCount = _prefix + 'InvalidArgumentCount';
	public static val InvalidArgumentType = _prefix + 'InvalidArgumentType';
	public static val NonIndexableExpression = _prefix + 'NonIndexableExpression';
	public static val InvalidIndexType = _prefix + 'InvalidIndexType';
	public static val InvalidRangePattern = _prefix + 'InvalidRangePattern';
	public static val ShiftAlwaysZero = _prefix + 'ShiftAlwaysZero';
	public static val UnknownIntrinsicFunction = _prefix + 'UnknownIntrinsicFunction';
	public static val InvalidIntrinsicFunction = _prefix + 'InvalidIntrinsicFunction';
	public static val InvalidMemberAccessTarget = _prefix + 'InvalidMemberAccessTarget';
	public static val SizeOfNotExact = _prefix + 'SizeOfNotExact';
	public static val IndexOutOfRange = _prefix + 'IndexOutOfRange';
	public static val IncompleteType = _prefix + 'IncompleteType';
}
