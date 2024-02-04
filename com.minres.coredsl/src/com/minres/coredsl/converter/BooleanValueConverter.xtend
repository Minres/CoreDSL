package com.minres.coredsl.converter

import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter
import org.eclipse.xtext.nodemodel.INode

class BooleanValueConverter extends AbstractLexerBasedConverter<Boolean> {

	override toValue(String string, INode node) throws ValueConverterException {
		try {
			return Boolean.parseBoolean(string);
		} catch(NumberFormatException e) {
			throw new ValueConverterException('''Malformed boolean literal: «string»''', node, e);
		}
	}
}
