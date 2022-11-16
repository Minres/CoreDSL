package com.minres.coredsl.validation

class IssueCodes {
	private new() {
	}

	public static val SyntaxError = 'org.eclipse.xtext.diagnostics.Diagnostic.Syntax';

	public static val _prefix = "com.minres.coredsl."

	// utility issues
	public static val DebugInfo = _prefix + 'DebugInfo';
	public static val UnsupportedLanguageFeature = _prefix + 'UnsupportedLanguageFeature';

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
	public static val MixedAliasnessDeclaration = _prefix + 'MixedAliasnessDeclaration';
	public static val VoidDeclaration = _prefix + 'VoidDeclaration';
	
	// statement issues
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
}
