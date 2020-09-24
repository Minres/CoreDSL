package com.minres.coredsl.converter;

import java.math.BigInteger;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

import com.google.inject.Inject;

public class CoreDslTerminalConverters extends DefaultTerminalConverters {
        @Inject
        private NATURALValueConverter binaryValueConverter;
        
        @ValueConverter(rule = "NATURAL")
        public IValueConverter<BigInteger> NATURAL() {
                return binaryValueConverter;
        }

}