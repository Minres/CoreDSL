package com.minres.coredsl.util;

import java.math.BigInteger;

public class BigIntegerWithRadix extends BigInteger {

	public enum TYPE { UNDEF, SIGNED, UNSIGNED};
	/**
	 * 
	 */
	private static final long serialVersionUID = -791774651890225679L;
	
	private int radix;
	
	private int size=0;
	
	private TYPE type=TYPE.UNDEF;
	
	public BigIntegerWithRadix(String val, int radix, int size, TYPE type) {
		super(val, radix);
		this.radix=radix;
		this.size=size;
		this.type = type;
	}

	public int getRadix() {
		return radix;
	}

	public int getSize() {
		return size;
	}

	public TYPE getType() {
		return type;
	}

	@Override
	public String toString() {
		return toString(radix);
	}
	@Override
	public String toString(int radix) {
		switch(size) {
		case 8:
		case 16:
		case 32:
		case 64:
			if(radix==2)
				return String.format("0b%1$" + size + "s", super.toString(radix)).replace(' ', '0');
			else if(radix==8)
				return "0"+super.toString(radix);
			else if(radix==16)	
				return "0x"+super.toString(radix);
			else
				return super.toString(radix);
		default:		
			if(radix==2)
				return Integer.toString(size)+"'b"+super.toString(2);
			else if(radix==8)
				return Integer.toString(size)+"'o"+super.toString(8);
			else if(radix==16)	
				return Integer.toString(size)+"'h"+super.toString(16);
			else
				return Integer.toString(size)+"'d"+super.toString(radix);
		}
	}
	
	public String toCString() {
		return toCString(radix);
	}
	public String toCString(int radix) {
		switch(size) {
		case 8:
		case 16:
		case 32:
		case 64:
			if(radix==2)
				return String.format("0b%1$" + size + "s", super.toString(2)).replace(' ', '0');
			else if(radix==8)
				return "0"+super.toString(8);
			else if(radix==16)	
				return "0x"+super.toString(16);
			else
				return super.toString(radix);
		default:
			return String.format("0b%1$" + size + "s", super.toString(2)).replace(' ', '0');
		}
	}
}
