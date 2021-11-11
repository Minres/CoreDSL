package com.minres.coredsl.util;

import java.math.BigInteger;

import com.minres.coredsl.typing.IntegerType;
import com.minres.coredsl.typing.TypeProvider;

public class TypedBigInteger extends BigInteger {
	private static final long serialVersionUID = 6852722515036502950L;
	
	public final IntegerType type;
	
	public TypedBigInteger(String digits, int radix) {
		super(digits, radix);
		type = getSmallestTypeFor(this);
	}
	
	public TypedBigInteger(BigInteger value) {
		super(value.toByteArray());
		type = getSmallestTypeFor(this);
	}
	
	public TypedBigInteger(BigInteger value, int size, boolean signed) {
		super(value.toByteArray());
		type = new IntegerType(size, signed);
		
		IntegerType actualType = getSmallestTypeFor(value);
		if(!TypeProvider.isImplicitlyConvertibleTo(actualType, type))
			throw new NumberFormatException(value + " does not fit into a " + size + " bit " + (signed ? "signed" : "unsigned") + " integer");
	}
	
	public static IntegerType getSmallestTypeFor(BigInteger value) {
		int size = value.bitLength();
		boolean isNegative = value.compareTo(ZERO) < 0;
		return new IntegerType(isNegative ? size + 1 : size, isNegative);
	}
	
	public static TypedBigInteger fromBigInteger(BigInteger value) {
		if(value instanceof TypedBigInteger) return (TypedBigInteger)value;
		return new TypedBigInteger(value);
	}
	
	public static TypedBigInteger fromVerilogLiteral(String digits, int radix, int size, boolean signed) {
		BigInteger value = new BigInteger(digits, radix);
		IntegerType actualType = getSmallestTypeFor(value);
		
		if(actualType.bitSize > size)
			throw new NumberFormatException(value.toString(radix) + " does not fit into a " + size + " bit " + (signed ? "signed" : "unsigned") + " integer");
		
		if(actualType.bitSize < size || size == 0)
			return new TypedBigInteger(value, size, signed);

		// if we get here, the msb must be set.
		assert value.testBit(size - 1);

		// if the literal is signed, perform a reinterpret_cast to the signed type.
		// this is done by subtracting the msb twice, as it is now counted negative.
		if(signed) {
			return new TypedBigInteger(value.subtract(ONE.shiftLeft(size)), size, signed);
		}
		
		// example:
		// 3'b101  = 5
		// 3'sb101 = -3
		// difference: 8 (1<<3)
		
		return new TypedBigInteger(value, size, signed);
	}
}
