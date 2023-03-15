package com.minres.coredsl.type

import org.eclipse.xtend.lib.annotations.Data

@Data
abstract class CoreDslType {
	int bitSize;
	
	def isFunctionType() { return false; }
	def isPrimitiveType() { return false; }
	def isScalarType() { return false; } // primitive and pointer
	def isIntegerType() { return false; }
	def isFloatType() { return false; }
	def isStructType() { return false; }
	def isUnionType() { return false; }
	def isArrayType() { return false; }
	def isEnumType() { return false; }
	def isVoid() { return false; }
	
	def isValid() { return bitSize >= 0; }
	def isError() { return bitSize < 0; }
	def isInvalid() { return this == ErrorType.invalid; }
	def isIndeterminate() { return this == ErrorType.indeterminate; }
	def isIncomplete() { return this.isIndeterminate; }
}
