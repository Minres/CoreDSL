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
import com.minres.coredsl.type.EnumType
import com.minres.coredsl.type.ErrorType
import com.minres.coredsl.type.IntegerType
import com.minres.coredsl.type.VoidType
import com.minres.coredsl.validation.IssueCodes
import java.math.BigInteger

abstract class CoreDslTypeProvider {
	private new() {
	}

	def static CoreDslType getSpecifiedType(AnalysisContext ctx, TypeSpecifier typeSpecifier) {
		if(ctx.isSpecifiedTypeSet(typeSpecifier))
			return ctx.getSpecifiedType(typeSpecifier);

		val type = calculateSpecifiedType(ctx, typeSpecifier);

		if(!type.isIndeterminate)
			ctx.setSpecifiedType(typeSpecifier, type);

		return type;
	}

	def private static CoreDslType calculateSpecifiedType(AnalysisContext ctx, TypeSpecifier typeSpecifier) {
		switch (typeSpecifier) {
			VoidTypeSpecifier: {
				return VoidType.instance;
			}
			BoolTypeSpecifier: {
				return IntegerType.bool;
			}
			IntegerTypeSpecifier: {
				val signed = typeSpecifier.signedness !== IntegerSignedness.UNSIGNED;
				if(typeSpecifier.size === null) {
					switch (typeSpecifier.shorthand) {
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

				val size = CoreDslConstantExpressionEvaluator.evaluate(ctx, typeSpecifier.size);
				if(size === ConstantValue.indeterminate) return ErrorType.indeterminate;
				if(size === ConstantValue.invalid) return ErrorType.invalid;

				try {
					val exactSize = size.value.intValueExact();

					if(exactSize <= 0) {
						ctx.acceptError('Integer type size must be greater than 0', typeSpecifier,
							CoreDslPackage.Literals.INTEGER_TYPE_SPECIFIER__SIZE, -1,
							IssueCodes.InvalidIntegerTypeSize);
						return ErrorType.invalid;
					}

					return new IntegerType(exactSize, signed);
				} catch(ArithmeticException e) {
					ctx.acceptError('Integer type size must not exceed Integer.MAX_VALUE', typeSpecifier,
						CoreDslPackage.Literals.INTEGER_TYPE_SPECIFIER__SIZE, -1, IssueCodes.InvalidIntegerTypeSize);
					return ErrorType.invalid;
				}
			}
			EnumTypeSpecifier: {
				if(typeSpecifier.target === null || typeSpecifier.target.eIsProxy)
					return ErrorType.invalid;

				if(!ctx.isUserTypeInstanceSet(typeSpecifier.target))
					return ErrorType.indeterminate;

				return ctx.getUserTypeInstance(typeSpecifier.target);
			}
			StructTypeSpecifier: {
				if(typeSpecifier.target === null || typeSpecifier.target.eIsProxy)
					return ErrorType.invalid;

				if(!ctx.isUserTypeInstanceSet(typeSpecifier.target))
					return ErrorType.indeterminate;

				return ctx.getUserTypeInstance(typeSpecifier.target);
			}
			UnionTypeSpecifier: {
				if(typeSpecifier.target === null || typeSpecifier.target.eIsProxy)
					return ErrorType.invalid;

				if(!ctx.isUserTypeInstanceSet(typeSpecifier.target))
					return ErrorType.indeterminate;

				return ctx.getUserTypeInstance(typeSpecifier.target);
			}
			default: {
				ctx.acceptError(typeSpecifier.class.simpleName + " is currently not supported", typeSpecifier, null, -1,
					IssueCodes.UnsupportedLanguageFeature);

				return ErrorType.invalid;
			}
		}
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
	
	def private static boolean canImplicitlyConvert(IntegerType from, IntegerType to) {
			if(from.bitSize > to.bitSize) return false;
			if(from.signed && !to.signed) return false;
			if(!from.signed && to.signed && from.bitSize == to.bitSize) return false;
			return true;
	}

	def static boolean canImplicitlyConvert(CoreDslType from, CoreDslType to) {
		// allow all conversions involving error types to avoid follow-up errors
		if(from.isError || to.isError) return true;

		if(from.isIntegerType && to.isIntegerType) {
			return canImplicitlyConvert(from as IntegerType, to as IntegerType);
		}

		if(from.isIntegerType && to.isEnumType) {
			return canImplicitlyConvert(from as IntegerType, (to as EnumType).baseType);
		}

		if(from.isEnumType && to.isIntegerType) {
			return canImplicitlyConvert((from as EnumType).baseType, to as IntegerType);
		}

		return false;
	}

	def static boolean canExplicitlyConvert(CoreDslType from, CoreDslType to) {
		// allow all conversions involving error types to avoid follow-up errors
		if(from.isError || to.isError) return true;

		if(from.isIntegerType && to.isIntegerType) return true;

		return false;
	}
}
