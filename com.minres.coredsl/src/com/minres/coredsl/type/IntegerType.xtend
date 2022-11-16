package com.minres.coredsl.type

import org.eclipse.xtend.lib.annotations.Data

@Data
class IntegerType extends CoreDslType {
	public static val IntegerType bool = new IntegerType(1, false);

	boolean isSigned;

	new(int bitSize, boolean isSigned) {
		super(bitSize);
		this.isSigned = isSigned;
	}

	override isPrimitiveType() { return true; }
	override isScalarType() { return true; }
	override isIntegerType() { return true; }
	
	override toString() { return isSigned ? '''signed<«bitSize»>''' : '''unsigned<«bitSize»>'''; }
}
