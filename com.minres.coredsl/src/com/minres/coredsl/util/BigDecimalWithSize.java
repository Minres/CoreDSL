package com.minres.coredsl.util;

import java.math.BigDecimal;

public class BigDecimalWithSize extends BigDecimal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -791774651890225679L;
	
	private int size=0;
	
	public BigDecimalWithSize(String val, int size) {
		super(val);
		this.size=size;
	}

	public BigDecimalWithSize(String val) {
		super(val);
		this.size=64;
	}

	public int getSize() {
		return size;
	}


}
