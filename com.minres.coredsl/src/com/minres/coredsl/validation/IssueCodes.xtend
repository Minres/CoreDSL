package com.minres.coredsl.validation

class IssueCodes {
	private new() {}
	
	public static val SyntaxError = 'org.eclipse.xtext.diagnostics.Diagnostic.Syntax';
	
	public static val _prefix = "com.minres.coredsl."
	
	// utility issues
	public static val DebugInfo = _prefix + 'DebugInfo';
	
	// type issues
	public static val InvalidIntegerTypeSize = _prefix + 'InvalidIntegerTypeSize';
	
	// elaboration issues
	public static val CyclicInstructionSetInheritance = _prefix + 'CyclicInstructionSetInheritance';
	public static val InvalidIsaConstantAssignmentInitializer = _prefix + 'InvalidIsaConstantAssignmentInitializer';
	public static val InvalidIsaConstantAssignmentExpression = _prefix + 'InvalidIsaConstantAssignmentExpression';
	public static val InvalidIsaConstantAssignmentOperator = _prefix + 'InvalidIsaConstantAssignmentOperator';
	public static val InvalidIsaConstantAssignmentTarget = _prefix + 'InvalidIsaConstantAssignmentTarget';
	public static val InvalidIsaConstantType = _prefix + 'InvalidIsaConstantType';
	public static val IndeterminableIsaConstantValue = _prefix + 'IndeterminableIsaConstantValue';
	public static val IndeterminableIsaConstantType = _prefix + 'IndeterminableIsaConstantType';
	public static val MismatchingIsaConstantValues = _prefix + 'MismatchingIsaConstantValues';
	public static val MismatchingIsaConstantTypes = _prefix + 'MismatchingIsaConstantTypes';
	
	public static val InvalidConstantExpressionNode = _prefix + 'InvalidConstantExpressionNode';
}
