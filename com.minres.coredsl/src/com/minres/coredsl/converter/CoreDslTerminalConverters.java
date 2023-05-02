package com.minres.coredsl.converter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

import com.google.inject.Inject;
import com.minres.coredsl.util.TypedBigInteger;

public class CoreDslTerminalConverters extends DefaultTerminalConverters {
    @Inject
    private INTEGERValueConverter intValueConverter;

    @Inject
    private BOOLEANValueConverter boolValueConverter;

    @ValueConverter(rule = "INTEGER")
    public IValueConverter<TypedBigInteger> INTEGER() {
        return intValueConverter;
    }

    @ValueConverter(rule = "BOOLEAN")
    public IValueConverter<Boolean> BOOLEAN() {
        return boolValueConverter;
    }

}