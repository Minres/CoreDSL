package com.minres.coredsl.converter

import com.minres.coredsl.util.TypedBigInteger
import java.util.regex.Pattern
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.conversion.ValueConverterException
import java.math.BigInteger

class IntegerValueConverter extends AbstractLexerBasedConverter<TypedBigInteger> {
	static Pattern numberPattern = Pattern.compile('''
		^(?:
		0b(?<bin>[_01]+)|
		0(?<oct>[0-7]+)|
		(?<dec>0|[1-9][_0-9]*)|
		0x(?<hex>[_0-9a-f]+)|
		(?<vsize>\d+)'(?<vsigned>s)?(?:
		b(?<vbin>[_0-1]+)|
		o(?<voct>[_0-7]+)|
		d(?<vdec>[_0-9]+)|
		h(?<vhex>[_0-9a-f]+)
		))$
	''', Pattern.CASE_INSENSITIVE + Pattern.COMMENTS);

	def TypedBigInteger tryParseBigInteger(String digits, INode node, int radix, int size,
		boolean signed) throws ValueConverterException {
		try {
			if(digits === null) return null;

			var value = size >= 0 ? new TypedBigInteger(digits.replace("_", ""), radix, size, signed) : new TypedBigInteger(digits.replace("_", ""), radix);

			if(signed && value.bitLength == size) {
				value = new TypedBigInteger(value - BigInteger.ONE.shiftLeft(value.bitLength), radix, size, signed);
			}

			// TODO test this with negative numbers
			if(size == 0 || size > 0 && value.bitLength > size) {
				throw new ValueConverterException('''Value «value» does not fit into «size» bits''', node, null);
			}

			return value;
		} catch(NumberFormatException e) {
			throw new ValueConverterException("Malformed integer literal", node, e);
		}
	}

	def TypedBigInteger tryParseBigInteger(String digits, INode node, int radix) throws ValueConverterException {
		return tryParseBigInteger(digits, node, radix, -1, false);
	}

	override toValue(String string, INode node) throws ValueConverterException {
		val matcher = numberPattern.matcher(string);
		if(!matcher.find())
			throw new ValueConverterException("Malformed integer literal: " + string, node, null);
		val vsize = matcher.group('vsize');

		if(vsize === null) {
			val value =
				matcher.group('bin')?.tryParseBigInteger(node, 2) ?:
				matcher.group('oct')?.tryParseBigInteger(node, 8) ?:
				matcher.group('dec')?.tryParseBigInteger(node, 10) ?:
				matcher.group('hex')?.tryParseBigInteger(node, 16);
			
			if(value === null) throw new ValueConverterException("Failed to convert integer literal: " + string, node, null);

			return value;
		} else {
			val signed = matcher.group('vsigned') !== null;
			val size = Integer.parseInt(vsize);
			val value =
				matcher.group('vbin')?.tryParseBigInteger(node, 2, size, signed) ?:
				matcher.group('voct')?.tryParseBigInteger(node, 8, size, signed) ?:
				matcher.group('vdec')?.tryParseBigInteger(node, 10, size, signed) ?:
				matcher.group('vhex')?.tryParseBigInteger(node, 16, size, signed);
			
			if(value === null) throw new ValueConverterException("Failed to convert integer literal: " + string, node, null);
			
			return value;
		}
	}
}
