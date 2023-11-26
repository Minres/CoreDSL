package com.minres.coredsl.converter

import org.eclipse.xtext.common.services.DefaultTerminalConverters
import com.minres.coredsl.util.TypedBigInteger
import org.eclipse.xtext.conversion.IValueConverter
import com.google.inject.Inject
import org.eclipse.xtext.conversion.ValueConverter

class CoreDslTerminalConverters extends DefaultTerminalConverters {
    @Inject
    IntegerValueConverter intValueConverter;

    @Inject
    BooleanValueConverter boolValueConverter;

    @ValueConverter(rule = "INTEGER")
    def IValueConverter<TypedBigInteger> INTEGER() { return intValueConverter; }

    @ValueConverter(rule = "BOOLEAN")
    def IValueConverter<Boolean> BOOLEAN() { return boolValueConverter; }
}