package com.minres.coredsl.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	private static final Pattern literalPattern = Pattern.compile(""
			+ "^(?:(?<vstyle>\n"
			+ " (?<vsize>[0-9]+)'(?<vsigned>s)?(?:\n"
			+ "  d(?<vddigits>[0-9]+)|\n"
			+ "  b(?<vbdigits>[01]+)|\n"
			+ "  o(?<vodigits>[0-7]+)|\n"
			+ "  h(?<vhdigits>[0-9a-f]+)))|\n"
			+ "(?<cstyle>(?:\n"
			+ " (?<cddigits>(?:[1-9](?:_?[0-9])*|0))|\n"
			+ " 0b(?<cbdigits>[01](?:_?[01])*)|\n"
			+ " 0(?<codigits>[0-7](?:_?[0-7])*)|\n"
			+ " 0x(?<chdigits>[0-9a-f](?:_?[0-9a-f])*))))?$",
	 Pattern.COMMENTS | Pattern.CASE_INSENSITIVE);

	@Override
	public TypedBigInteger toValue(String string, INode node) throws ValueConverterException {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to an integer value.", node, null);
		
		Matcher matcher = literalPattern.matcher(string);
        
        if (!matcher.find())
			throw new ValueConverterException("The string '" + string + "' is not a valid integer literal.", node, null);
		
		try {
			if(matcher.group("vstyle") != null) {
				int size = Integer.parseInt(matcher.group("vsize"));
				boolean signed = matcher.group("vsigned") != null;
				
				if(signed && size == 0)
					throw new ValueConverterException("signed<0> is not a valid type", node, null);
				
				if(matcher.group("vddigits") != null)
					return TypedBigInteger.fromVerilogLiteral(matcher.group("vddigits").replace("_", ""), 10, size, signed);

				if(matcher.group("vhdigits") != null)
					return TypedBigInteger.fromVerilogLiteral(matcher.group("vhdigits").replace("_", ""), 16, size, signed);

				if(matcher.group("vbdigits") != null)
					return TypedBigInteger.fromVerilogLiteral(matcher.group("vbdigits").replace("_", ""), 2, size, signed);

				if(matcher.group("vodigits") != null)
					return TypedBigInteger.fromVerilogLiteral(matcher.group("vodigits").replace("_", ""), 8, size, signed);

				// huh?
			}
			
			if(matcher.group("cstyle") != null) {
				if(matcher.group("cddigits") != null)
					return new TypedBigInteger(matcher.group("cddigits").replace("_", ""), 10);
				
				if(matcher.group("chdigits") != null)
					return new TypedBigInteger(matcher.group("chdigits").replace("_", ""), 16);
				
				if(matcher.group("cbdigits") != null)
					return new TypedBigInteger(matcher.group("cbdigits").replace("_", ""), 2);
				
				if(matcher.group("codigits") != null)
					return new TypedBigInteger(matcher.group("codigits").replace("_", ""), 8);
				
				// huh?
			}
			
			// how did we even get here?
			throw new ValueConverterException("This should be unreachable.", node, null);
			
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to an integer value.", node, e);
		}
	}
}
