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
	public static val DuplicateStorageClassSpecifier = _prefix + 'DuplicateStorageClassSpecifier';
	public static val DuplicateQualifier = _prefix + 'DuplicateQualifier';
	public static val UninitializedConstant = _prefix + 'UninitializedConstant';
	public static val VoidDeclaration = _prefix + 'VoidDeclaration';
}
