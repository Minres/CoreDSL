package com.minres.coredsl.converter;

import java.math.BigInteger;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;


public class INTEGERValueConverter extends AbstractLexerBasedConverter<BigInteger> {
	@Override
	protected String toEscapedString(BigInteger value) {
		return value.toString();
	}

	@Override
	protected void assertValidValue(BigInteger value) {
		super.assertValidValue(value);
		if (value.compareTo(BigInteger.ZERO)==-1)
			throw new ValueConverterException(getRuleName() + "-value may not be negative (value: " + value + ").", null, null);
	}

	@Override
	public BigInteger toValue(String string, INode node) throws ValueConverterException {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to an integer value.", node, null);
		try {
			String s = string.toLowerCase().replaceAll("_", "");
			int size = 32;
			BigIntegerWithRadix.TYPE type = BigIntegerWithRadix.TYPE.SIGNED;
			if(string.contains("u")) type =BigIntegerWithRadix.TYPE.UNSIGNED;
			if(string.endsWith("ll")) size=128;
			else if(string.endsWith("l")) size=64;
			if(s.contains("'")) {
				String[] token = s.split("/'/");
				size = Integer.parseInt(token[0]);
				if(token[1].startsWith("h")){
					return new BigIntegerWithRadix(string.substring(2), 16, size, type);
				} else if(token[1].startsWith("b")){
					return new BigIntegerWithRadix(string.substring(2), 2, size, type);
				} else if(token[1].startsWith("o")){
					return new BigIntegerWithRadix(s, 8, size, type);
				}else 
					return new BigIntegerWithRadix(s, 10, size, type);
			} else {
				if(s.startsWith("0x")){
					return new BigIntegerWithRadix(string.substring(2), 16, size, type);
				} else if(s.startsWith("0b")){
					return new BigIntegerWithRadix(string.substring(2), 2, size, type);
				} else if(s.length()>1 && s.startsWith("0")){
					return new BigIntegerWithRadix(s, 8, size, type);
				}else 
					return new BigIntegerWithRadix(s, 10, size, type);
			}
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to an integer value.", node, e);
		}
	}

}