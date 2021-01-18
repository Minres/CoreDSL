package com.minres.coredsl.converter;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

import com.google.inject.Inject;

public class CoreDslTerminalConverters extends DefaultTerminalConverters {
        @Inject
        private FLOATValueConverter floatValueConverter;
        
        @Inject
        private INTEGERValueConverter intValueConverter;
        
        @Inject
        private BOOLEANValueConverter boolValueConverter;

        @ValueConverter(rule = "FLOAT")
        public IValueConverter<BigDecimal> FLOAT() {
                return floatValueConverter;
        }

        @ValueConverter(rule = "INTEGER")
        public IValueConverter<BigInteger> INTEGER() {
                return intValueConverter;
        }

        @ValueConverter(rule = "BOOLEAN")
        public IValueConverter<Boolean> BOOLEAN() {
                return boolValueConverter;
        }

}