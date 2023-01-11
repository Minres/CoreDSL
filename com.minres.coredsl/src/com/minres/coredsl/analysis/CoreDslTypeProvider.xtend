package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.BoolTypeSpecifier
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.EnumTypeSpecifier
import com.minres.coredsl.coreDsl.IntegerSignedness
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.coreDsl.StructTypeSpecifier
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.UnionTypeSpecifier
import com.minres.coredsl.coreDsl.VoidTypeSpecifier
import com.minres.coredsl.type.CoreDslType
import com.minres.coredsl.type.ErrorType
import com.minres.coredsl.type.IntegerType
import com.minres.coredsl.type.VoidType
import com.minres.coredsl.validation.IssueCodes
import java.math.BigInteger

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

		// TODO don't check two places for the value
		var size = ctx.calculatedValues.get(specifier.size);
		if(size === null) size = CoreDslConstantExpressionEvaluator.evaluate(ctx, specifier.size);
		if(size === null) return ErrorType.indeterminate;
		if(size === ConstantValue.invalid) return ErrorType.invalid;

		try {
			val exactSize = size.value.intValueExact();

			if(exactSize <= 0) {
				ctx.acceptError('Integer type size must be greater than 0', specifier,
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

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, VoidTypeSpecifier spec) {
		return VoidType.instance;
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, EnumTypeSpecifier spec) {
		if(spec.target === null) return ErrorType.invalid;
		return ctx.getUserTypeInstance(spec.target);
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, StructTypeSpecifier spec) {
		if(spec.target === null) return ErrorType.invalid;
		return ctx.getUserTypeInstance(spec.target);
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, UnionTypeSpecifier spec) {
		if(spec.target === null) return ErrorType.invalid;
		return ctx.getUserTypeInstance(spec.target);
	}

	def static dispatch CoreDslType getSpecifiedType(ElaborationContext ctx, TypeSpecifier spec) {
		ctx.acceptError(spec.class.simpleName + " is currently not supported", spec.eContainer,
			spec.eContainingFeature, -1, IssueCodes.UnsupportedLanguageFeature);

		return ErrorType.invalid;
	}

	def static boolean canTypeHoldValue(CoreDslType type, BigInteger value) {
		return canImplicitlyConvert(getSmallestTypeForValue(value), type);
	}

	def static IntegerType getSmallestTypeForValue(BigInteger value) {
		val valueSigned = value.signum < 0;
		val valueBits = value.bitLength + (valueSigned ? 1 : 0);
		return new IntegerType(Math.max(valueBits, 1), valueSigned);
	}

	def static IntegerType getSmallestCommonType(IntegerType a, IntegerType b) {
		val signed = a.signed || b.signed;
		val aSize = signed && !a.signed ? a.bitSize + 1 : a.bitSize;
		val bSize = signed && !b.signed ? b.bitSize + 1 : b.bitSize;
		return new IntegerType(Math.max(aSize, bSize), signed);
	}

	def static dispatch boolean canImplicitlyConvert(IntegerType from, IntegerType to) {
		if(from.bitSize > to.bitSize) return false;
		if(from.signed && !to.signed) return false;
		if(!from.signed && to.signed && from.bitSize == to.bitSize) return false;
		return true;
	}

	// error was reported on a nested node already
	def static dispatch boolean canImplicitlyConvert(ErrorType from, CoreDslType to) {
		return true;
	}

	// error was reported on a nested node already
	def static dispatch boolean canImplicitlyConvert(CoreDslType from, ErrorType to) {
		return true;
	}

	// fallback for invalid conversions
	def static dispatch boolean canImplicitlyConvert(CoreDslType from, CoreDslType to) {
		return false;
	}

	def static dispatch boolean canExplicitlyConvert(IntegerType from, IntegerType to) {
		return true;
	}

	// error was reported on a nested node already
	def static dispatch boolean canExplicitlyConvert(ErrorType from, CoreDslType to) {
		return true;
	}

	// error was reported on a nested node already
	def static dispatch boolean canExplicitlyConvert(CoreDslType from, ErrorType to) {
		return true;
	}

	// fallback for invalid conversions
	def static dispatch boolean canExplicitlyConvert(CoreDslType from, CoreDslType to) {
		return false;
	}
}
