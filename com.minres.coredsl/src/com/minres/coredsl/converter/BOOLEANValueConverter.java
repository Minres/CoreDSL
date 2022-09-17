package com.minres.coredsl.converter;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class BOOLEANValueConverter extends AbstractLexerBasedConverter<Boolean> {
    @Override
    protected String toEscapedString(Boolean value) {
        return Boolean.toString(value);
    }

    @Override
    protected void assertValidValue(Boolean value) {
        super.assertValidValue(value);
    }

    @Override
    public Boolean toValue(String string, INode node) throws ValueConverterException {
        if (Strings.isEmpty(string))
            throw new ValueConverterException("Couldn't convert empty string to an booolean value.", node, null);
        try {
            boolean value = Boolean.parseBoolean(string);
            return Boolean.valueOf(value);
        } catch (NumberFormatException e) {
            throw new ValueConverterException("Couldn't convert '" + string + "' to an booolean value.", node, e);
        }
    }

}