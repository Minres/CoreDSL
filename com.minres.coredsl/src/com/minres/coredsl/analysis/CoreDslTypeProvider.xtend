package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.BoolTypeSpecifier
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.IntegerSignedness
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.type.ErrorType
import com.minres.coredsl.type.IntegerType
import com.minres.coredsl.validation.IssueCodes

class CoreDslTypeProvider {
	private new() {}
	
	static def dispatch getSpecifiedType(AnalysisContext ctx, IntegerTypeSpecifier specifier) {
		if(specifier.size !== null) {
			val size = CoreDslConstantExpressionEvaluator.evaluate(ctx, specifier.size);
			
			if(size.invalid) return ErrorType.invalid;
			if(size.indeterminate) return ErrorType.indeterminate;
			
			try {
				val isSigned = specifier.signedness === IntegerSignedness.SIGNED;
				val exactSize = size.value.intValueExact();
				
				if(exactSize < 0) {
					ctx.acceptor.acceptError(
						'Integer type size must not be negative',
						specifier, CoreDslPackage.Literals.INTEGER_TYPE_SPECIFIER__SIZE,
						-1, IssueCodes.InvalidIntegerTypeSize);
					return ErrorType.invalid;
				}
				
				if(exactSize == 0 && isSigned) {
					ctx.acceptor.acceptError(
						'signed<0> is not a valid type',
						specifier, CoreDslPackage.Literals.INTEGER_TYPE_SPECIFIER__SIZE,
						-1, IssueCodes.InvalidIntegerTypeSize);
					return ErrorType.invalid;
				}
				
				return new IntegerType(exactSize, isSigned);
			}
			catch(ArithmeticException e) {
				ctx.acceptor.acceptError(
					'Integer type size must not exceed Integer.MAX_VALUE',
					specifier, CoreDslPackage.Literals.INTEGER_TYPE_SPECIFIER__SIZE,
					-1, IssueCodes.InvalidIntegerTypeSize);
				return ErrorType.invalid;
			}
		}
		
		val isSigned = specifier.signedness !== IntegerSignedness.UNSIGNED;
		val size = switch(specifier.shorthand) {
			case CHAR: 8
			case SHORT: 16
			case INT: 32
			case LONG: 64
		};
		
		return new IntegerType(size, isSigned);
	}
	
	static def dispatch getSpecifiedType(AnalysisContext ctx, BoolTypeSpecifier specifier) {
		return IntegerType.bool;
	}
	
	static def dispatch getSpecifiedType(AnalysisContext ctx, TypeSpecifier specifier) {
		// TODO implement the rest
		return ErrorType.invalid;
	}
}
