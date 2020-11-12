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
			if(string.contains("'")) {
				// Verilog-style literal <size>'<radix><value>
				String s = string.toLowerCase();
				if(s.contains("u") || s.contains("l"))
					throw new ValueConverterException("Verilog literals cannot have 'u' and 'l' suffixes", node, null);
				
				String[] token = s.split("'");
				int size = Integer.parseInt(token[0]);
				String lit = token[1].substring(1);
				switch (token[1].charAt(0)) {
					case 'h': return new BigIntegerWithRadix(lit, 16, size, BigIntegerWithRadix.TYPE.UNDEF);
					case 'b': return new BigIntegerWithRadix(lit, 2, size, BigIntegerWithRadix.TYPE.UNDEF);
					case 'o': return new BigIntegerWithRadix(lit, 8, size, BigIntegerWithRadix.TYPE.UNDEF);
					default: return new BigIntegerWithRadix(lit, 10, size, BigIntegerWithRadix.TYPE.UNDEF);
				}
			} else {
				// C-style literal
				BigIntegerWithRadix.TYPE type = BigIntegerWithRadix.TYPE.SIGNED;
				if(string.contains("u") || string.contains("U"))
					type = BigIntegerWithRadix.TYPE.UNSIGNED;

				int size = 32;
				if(string.endsWith("ll") || string.endsWith("LL")) 
					size = 128;
				else if(string.endsWith("l") || string.endsWith("L")) 
					size = 64;
				
				String s = string.toLowerCase().replaceAll("[ul]", "");
				
				if(s.startsWith("0x")){
					return new BigIntegerWithRadix(string.substring(2), 16, size, type);
				} else if(s.startsWith("0b")){
					return new BigIntegerWithRadix(string.substring(2), 2, size, type);
				} else if(s.length()>1 && s.startsWith("0")){
					return new BigIntegerWithRadix(s, 8, size, type);
				} else {
					return new BigIntegerWithRadix(s, 10, size, type);
				}
			}
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to an integer value.", node, e);
		}
	}

}