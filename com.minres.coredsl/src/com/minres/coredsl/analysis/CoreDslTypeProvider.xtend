package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.BoolTypeSpecifier
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.FloatSizeShorthand
import com.minres.coredsl.coreDsl.FloatTypeSpecifier
import com.minres.coredsl.coreDsl.IntegerSignedness
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.coreDsl.StructTypeSpecifier
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.UnionTypeSpecifier
import com.minres.coredsl.coreDsl.VoidTypeSpecifier
import com.minres.coredsl.type.CompositeType
import com.minres.coredsl.type.CoreDslType
import com.minres.coredsl.type.ErrorType
import com.minres.coredsl.type.FloatType
import com.minres.coredsl.type.IntegerType
import com.minres.coredsl.type.VoidType
import com.minres.coredsl.validation.IssueCodes

abstract class CoreDslTypeProvider {
	private new() {
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, IntegerTypeSpecifier specifier) {
		val signed = specifier.signedness !== IntegerSignedness.UNSIGNED;
		if(specifier.size === null) {
			switch (specifier.shorthand) {
				case CHAR:
					return new IntegerType(8, signed)
				case SHORT:
					return new IntegerType(16, signed)
				case INT:
					return new IntegerType(32, signed)
				case LONG:
					return new IntegerType(64, signed)
			}
		}

		val size = ctx.calculatedValues.get(specifier.size);
		if(size === null) return ErrorType.indeterminate;
		if(size === ConstantValue.invalid) return ErrorType.invalid;

		try {
			val exactSize = size.value.intValueExact();

			if(exactSize < 0) {
				ctx.acceptError('Integer type size must not be negative', specifier,
					CoreDslPackage.Literals.INTEGER_TYPE_SPECIFIER__SIZE, -1, IssueCodes.InvalidIntegerTypeSize);
				return ErrorType.invalid;
			}

			if(exactSize == 0 && signed) {
				ctx.acceptError('signed<0> is not a valid type', specifier,
					CoreDslPackage.Literals.INTEGER_TYPE_SPECIFIER__SIZE, -1, IssueCodes.InvalidIntegerTypeSize);
				return ErrorType.invalid;
			}

			return new IntegerType(exactSize, signed);
		} catch(ArithmeticException e) {
			ctx.acceptError('Integer type size must not exceed Integer.MAX_VALUE', specifier,
				CoreDslPackage.Literals.INTEGER_TYPE_SPECIFIER__SIZE, -1, IssueCodes.InvalidIntegerTypeSize);
			return ErrorType.invalid;
		}
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, BoolTypeSpecifier spec) {
		return IntegerType.bool;
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, FloatTypeSpecifier spec) {
		return spec.shorthand === FloatSizeShorthand.DOUBLE ? FloatType.doublePrecision : FloatType.singlePrecision;
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, VoidTypeSpecifier spec) {
		return VoidType.instance;
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, StructTypeSpecifier spec) {
		if(spec.target === null) return ErrorType.invalid;
		return new CompositeType(spec.target);
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, UnionTypeSpecifier spec) {
		if(spec.target === null) return ErrorType.invalid;
		return new CompositeType(spec.target);
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, TypeSpecifier spec) {
		ctx.acceptError(spec.class.simpleName + " is currently not supported", spec.eContainer,
			spec.eContainingFeature, -1, IssueCodes.UnsupportedLanguageFeature);

		return ErrorType.invalid;
	}
}
