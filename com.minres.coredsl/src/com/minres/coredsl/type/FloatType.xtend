package com.minres.coredsl.type

import org.eclipse.xtend.lib.annotations.Data

@Data
class FloatType extends CoreDslType {
	public static val FloatType singlePrecision = new FloatType(32);
	public static val FloatType doublePrecision = new FloatType(64);

	new(int bitSize) {
		super(bitSize);
	}

	override isPrimitiveType() { return true; }
	override isScalarType() { return true; }
	override isFloatType() { return true; }
	
	override toString() { return bitSize == 64 ? 'double' : 'float'; }
}
