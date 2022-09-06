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
	public static val MultipleIdenticalProvides = _prefix + 'MultipleIdenticalProvides';
	public static val CyclicInstructionSetInheritance = _prefix + 'CyclicInstructionSetInheritance';
	public static val InvalidIsaParameterAssignmentInitializer = _prefix + 'InvalidIsaParameterAssignmentInitializer';
	public static val InvalidIsaParameterAssignmentExpression = _prefix + 'InvalidIsaParameterAssignmentExpression';
	public static val InvalidIsaParameterAssignmentOperator = _prefix + 'InvalidIsaParameterAssignmentOperator';
	public static val InvalidIsaParameterAssignmentTarget = _prefix + 'InvalidIsaParameterAssignmentTarget';
	public static val InvalidIsaParameterType = _prefix + 'InvalidIsaParameterType';
	public static val IndeterminableIsaParameterValue = _prefix + 'IndeterminableIsaParameterValue';
	public static val IndeterminableIsaParameterType = _prefix + 'IndeterminableIsaParameterType';
	public static val MismatchingIsaParameterValues = _prefix + 'MismatchingIsaParameterValues';
	public static val MismatchingIsaParameterTypes = _prefix + 'MismatchingIsaParameterTypes';
	
	public static val InvalidConstantExpressionNode = _prefix + 'InvalidConstantExpressionNode';
}
