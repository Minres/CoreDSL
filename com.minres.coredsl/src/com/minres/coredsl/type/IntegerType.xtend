package com.minres.coredsl.type

import org.eclipse.xtend.lib.annotations.Data
import com.minres.coredsl.util.CompilerAssertion

@Data
class IntegerType extends CoreDslType {
	public static val IntegerType bool = new IntegerType(1, false);
	public static val IntegerType octet = new IntegerType(8, false);
	
	def static IntegerType signed(int bitSize) { return new IntegerType(bitSize, true); }
	def static IntegerType unsigned(int bitSize) { return new IntegerType(bitSize, false); }

	boolean isSigned;

	new(int bitSize, boolean isSigned) {
		super(bitSize);
		this.isSigned = isSigned;
		
		CompilerAssertion.assertThat(bitSize > 0, "Integer types must be at least one bit long");
	}

	override isPrimitiveType() { return true; }
	override isScalarType() { return true; }
	override isIntegerType() { return true; }
	
	override toString() { return isSigned ? '''signed<«bitSize»>''' : '''unsigned<«bitSize»>'''; }
}
