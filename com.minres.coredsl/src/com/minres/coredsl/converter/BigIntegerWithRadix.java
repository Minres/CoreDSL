package com.minres.coredsl.converter;

import java.math.BigInteger;

public class BigIntegerWithRadix extends BigInteger {

	/**
	 * 
	 */
	private static final long serialVersionUID = -791774651890225679L;
	
	private int radix;
	
	public BigIntegerWithRadix(String val, int radix) {
		super(val, radix);
		this.radix=radix;
	}

	public int getRadix() {
		return radix;
	}

	@Override
	public String toString() {
		if(radix==2)
			return "0b"+super.toString(radix);
		else if(radix==8)
			return "0"+super.toString(radix);
		else if(radix==16)	
			return "0x"+super.toString(radix);
		else
			return super.toString(radix);

	}

}
