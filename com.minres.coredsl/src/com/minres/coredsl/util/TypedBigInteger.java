package com.minres.coredsl.util;

import java.math.BigInteger;

public class TypedBigInteger extends BigInteger {
	private static final long serialVersionUID = -2568538931532373089L;

	final int radix;
	final int size;
	final boolean signed;

	public TypedBigInteger(String digits, int radix) {
		super(digits, radix);
		this.radix = radix;
		this.signed = signum() < 0;
		this.size = Math.max(signed ? bitLength() + 1 : bitLength(), 1);
	}

	public TypedBigInteger(String digits, int radix, int size, boolean signed) {
		super(digits, radix);
		this.radix = radix;
		this.size = Math.max(size, 1);
		this.signed = signed;
	}

	public TypedBigInteger(BigInteger value, int radix) {
		super(value.toByteArray());
		this.radix = radix;
		this.signed = signum() < 0;
		this.size = Math.max(signed ? bitLength() + 1 : bitLength(), 1);
	}

	public TypedBigInteger(BigInteger value, int radix, int size, boolean signed) {
		super(value.toByteArray());
		this.radix = radix;
		this.size = Math.max(size, 1);
		this.signed = signed;
	}

	public int getRadix() {
		return radix;
	}

	public int getSize() {
		return size;
	}

	public boolean isSigned() {
		return signed;
	}
}
