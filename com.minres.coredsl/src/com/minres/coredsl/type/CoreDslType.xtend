package com.minres.coredsl.type

import org.eclipse.xtend.lib.annotations.Data

@Data
abstract class CoreDslType {
	int bitSize;
	
	def isPrimitiveType() { return false; }
	def isIntegerType() { return false; }
	def isFloatType() { return false; }
	def isStructType() { return false; }
	def isUnionType() { return false; }
	def isEnumType() { return false; }
	
	def isValid() { return bitSize >= 0; }
	def isError() { return bitSize < 0; }
	def isInvalid() { return this == ErrorType.invalid; }
	def isIndeterminate() { return this == ErrorType.indeterminate; }
}
