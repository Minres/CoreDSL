package com.minres.coredsl.validation

class IssueCodes {
	public static val ISSUE_CODE_PREFIX = "com.minres.coredsl."
	
	// errors
	public static val TYPE_MISMATCH = ISSUE_CODE_PREFIX + "TypeMismatch"
	public static val TYPE_ILLEGAL = ISSUE_CODE_PREFIX + "TypeIllegal"
	public static val ILLEGAL_ATTRIBUTE = ISSUE_CODE_PREFIX + "IllegalAttribute"
	public static val INVALID_ATTRIBUTE_PARAMETERS = ISSUE_CODE_PREFIX + "InvalidAttributeParameters"
	public static val UNSUPPORTED_LANGUAGE_FEATURE = ISSUE_CODE_PREFIX + "UnsupportedLanguageFeature"
	
	// warnings
	public static val NEGATIVE_INT_LITERAL = ISSUE_CODE_PREFIX + "NegativeIntLiteral"
}