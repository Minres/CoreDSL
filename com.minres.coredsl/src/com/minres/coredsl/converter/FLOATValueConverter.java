package com.minres.coredsl.converter;

import java.math.BigDecimal;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

import com.minres.coredsl.util.BigDecimalWithSize;

public class FLOATValueConverter extends AbstractLexerBasedConverter<BigDecimal> {

    @Override
    protected String toEscapedString(BigDecimal value) {
        return value.toString();
    }

    @Override
    protected void assertValidValue(BigDecimal value) {
        super.assertValidValue(value);
    }

    @Override
    public BigDecimal toValue(String string, INode node) throws ValueConverterException {
        if (Strings.isEmpty(string))
            throw new ValueConverterException("Couldn't convert empty string to a float value.", node, null);
        try {
            String s = string.toLowerCase().replaceAll("_", "");
            int size = 64;
            if (s.endsWith("l") | s.endsWith("L")) {
                size = 128;
                s = s.substring(0, s.length() - 1);
            } else if (s.endsWith("f") | s.endsWith("F")) {
                size = 32;
                s = s.substring(0, s.length() - 1);
            }
            return new BigDecimalWithSize(s, size);
        } catch (NumberFormatException e) {
            throw new ValueConverterException("Couldn't convert '" + string + "' to a float value.", node, e);
        }
    }

}