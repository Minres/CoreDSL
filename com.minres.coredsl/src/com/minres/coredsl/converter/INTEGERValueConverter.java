package com.minres.coredsl.converter;

import java.math.BigInteger;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

import com.minres.coredsl.util.TypedBigInteger;

public class INTEGERValueConverter extends AbstractLexerBasedConverter<TypedBigInteger> {
	@Override
	protected String toEscapedString(TypedBigInteger value) {
		return value.toString();
	}

	@Override
	protected void assertValidValue(TypedBigInteger value) {
		super.assertValidValue(value);
		if (value.compareTo(BigInteger.ZERO) == -1)
			throw new ValueConverterException(getRuleName() + "-value may not be negative (value: " + value + ").",
					null, null);
	}

	@Override
	public TypedBigInteger toValue(String string, INode node) throws ValueConverterException {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to an integer value.", node, null);
		try {
			String s = string.toLowerCase();

			if (string.contains("'")) {
				// Verilog-style literal <size>'<signed><radix><value>
				String[] parts = s.split("'");
				int size = Integer.parseInt(parts[0]);
				boolean signed = parts[1].charAt(0) == 's';
				char radixChar = parts[1].charAt(signed ? 1 : 0);
				String digits = parts[1].substring(signed ? 2 : 1);

				// TODO handle the case where the sign bit is set (6'sd42)
				
				if (size == 0)
					throw new ValueConverterException("Size of verilog-style literal must not be zero", node, null);

				switch (radixChar) {
				case 'h':
					// hexadecimal
					return new TypedBigInteger(digits, 16, size, signed);
				case 'b':
					// binary
					return new TypedBigInteger(digits, 2, size, signed);
				case 'o':
					// octal
					return new TypedBigInteger(digits, 8, size, signed);
				case 'd':
					// decimal
					return new TypedBigInteger(digits, 10, size, signed);
				default:
					throw new ValueConverterException("Invalid radix char in verilog-style literal: " + radixChar, node, null);
				}
			}
			else {
				if (s.length() > 1 && s.charAt(0) == '0') {
					switch (s.charAt(1)) {
					case 'x':
						// hexadecimal
						return new TypedBigInteger(string.substring(2), 16);
					case 'b':
						// binary
						return new TypedBigInteger(string.substring(2), 2);
					default:
						// octal
						return new TypedBigInteger(s, 8);
					}
				}
				else {
					// decimal
					return new TypedBigInteger(s, 10);
				}
			}
		}
		catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to an integer value.", node, e);
		}
	}

}