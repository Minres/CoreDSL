package com.minres.coredsl.converter;

import java.math.BigInteger;

public class BigIntegerWithRadix extends BigInteger {

	/**
	 * 
	 */
	private static final long serialVersionUID = -791774651890225679L;
	
	private int radix;
	
	private int size=0;
	
	public BigIntegerWithRadix(String val, int radix, int size) {
		super(val, radix);
		this.radix=radix;
		this.size=size;
	}

	public BigIntegerWithRadix(String val, int radix) {
		super(val, radix);
		this.radix=radix;
	}

	public int getRadix() {
		return radix;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		if(size>0) {
			if(radix==2)
				return Integer.toString(size)+"'b"+super.toString(radix);
			else if(radix==8)
				return Integer.toString(size)+"'o"+super.toString(radix);
			else if(radix==16)	
				return Integer.toString(size)+"'h"+super.toString(radix);
			else
				return Integer.toString(size)+"'d"+super.toString(radix);
		} else {
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

}
