package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.EntityReference
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.IntrinsicExpression
import com.minres.coredsl.coreDsl.ParenthesisExpression
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.validation.IssueCodes
import java.math.BigInteger

import static extension com.minres.coredsl.util.DataExtensions.*
import static extension com.minres.coredsl.util.ModelExtensions.*
import com.minres.coredsl.coreDsl.PrefixExpression

class CoreDslConstantExpressionEvaluator {

	def static ConstantValue tryEvaluate(AnalysisContext ctx, Expression expression) {
		return evaluate(ctx, expression, true);
	}

	def static ConstantValue evaluate(AnalysisContext ctx, Expression expression) {
		return evaluate(ctx, expression, false);
	}

	def private static ConstantValue evaluate(AnalysisContext ctx, Expression expression, boolean suppressErrors) {
		if(ctx.isExpressionValueSet(expression))
			return ctx.getExpressionValue(expression);

		val value = evaluateImpl(ctx, expression, suppressErrors);

		if(!value.isIndeterminate)
			ctx.setExpressionValue(expression, value);

		return value;
	}

	def private static dispatch ConstantValue evaluateImpl(AnalysisContext ctx, EntityReference expression,
		boolean suppressErrors) {
		val declarator = expression.target.castOrNull(Declarator);

		if(declarator !== null && !ctx.isStorageClassSet(declarator))
			return ConstantValue.indeterminate;

		if(declarator === null ||
			!ctx.getStorageClass(declarator).isOneOf(StorageClass.param, StorageClass.enumConstant)) {
			if(!suppressErrors) {
				ctx.acceptError(
					"Identifiers in constant expressions may only refer to ISA parameters or enum constants",
					expression, CoreDslPackage.Literals.ENTITY_REFERENCE__TARGET, -1,
					IssueCodes.InvalidConstantExpressionIdentifier);
			}
			return ConstantValue.invalid;
		}

		if(ctx.isConstantValueSet(declarator))
			return ctx.getConstantValue(declarator);

		return ConstantValue.indeterminate;
	}

	def private static dispatch ConstantValue evaluateImpl(AnalysisContext ctx, IntegerConstant expression,
		boolean suppressErrors) {
		return new ConstantValue(expression.value);
	}

	def private static dispatch ConstantValue evaluateImpl(AnalysisContext ctx, ParenthesisExpression expression,
		boolean suppressErrors) {
		return evaluateImpl(ctx, expression.inner, suppressErrors);
	}

	def private static dispatch ConstantValue evaluateImpl(AnalysisContext ctx, InfixExpression expression,
		boolean suppressErrors) {
		val left = evaluate(ctx, expression.left, suppressErrors);
		val right = evaluate(ctx, expression.right, suppressErrors);

		if(left.isInvalid || right.isInvalid) return ConstantValue.invalid;
		if(left.isIndeterminate || right.isIndeterminate) return ConstantValue.indeterminate;

		switch (expression.operator) {
			case '+':
				return new ConstantValue(left.value + right.value)
			case '-':
				return new ConstantValue(left.value - right.value)
			case '*':
				return new ConstantValue(left.value * right.value)
			case '/': {
				if(right.value != BigInteger.ZERO)
					return new ConstantValue(left.value / right.value);

				ctx.acceptError("Division by zero", expression, CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1,
					IssueCodes.DivisionByZero);
			}
			default: {
				if(!suppressErrors) {
					ctx.acceptError("Infix expression " + expression.operator +
						" is currently unsupported in constant expressions", expression,
						CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.UnsupportedLanguageFeature);
				}
			}
		}

		return ConstantValue.invalid;
	}

	def private static ConstantValue getTypeSize(AnalysisContext ctx, TypeSpecifier specifier, boolean inBytes) {
		val type = CoreDslTypeProvider.getSpecifiedType(ctx, specifier);
		if(type.isInvalid) return ConstantValue.invalid;
		if(type.isIndeterminate) return ConstantValue.indeterminate;
		return new ConstantValue(inBytes ? (type.bitSize + 7) / 8 : type.bitSize);
	}

	def private static dispatch ConstantValue evaluateImpl(AnalysisContext ctx, IntrinsicExpression expression,
		boolean suppressErrors) {
		switch (expression.function) {
			case 'bitsizeof',
			case 'sizeof': {
				val inBytes = expression.function == 'sizeof';
				if(expression.arguments.size() === 1) {
					val arg = expression.arguments.get(0);
					switch (arg) {
						TypeSpecifier: {
							return getTypeSize(ctx, arg, inBytes);
						}
						EntityReference: {
							val declarator = arg.target.castOrNull(Declarator);
							if(declarator !== null) {
								return getTypeSize(ctx, declarator.type, inBytes);
							}
						}
						Expression: {
							// TODO
						}
					}
				}
			}
			default: {
				if(!suppressErrors) {
					ctx.acceptError('intrinsic function ' + expression.function +
						' is not allowed in constant expression', expression.eContainer, expression.eContainingFeature,
						-1, IssueCodes.InvalidConstantExpressionNode);
				}
				return ConstantValue.invalid;
			}
		}
		return ConstantValue.invalid;
	}

	def private static dispatch ConstantValue evaluateImpl(AnalysisContext ctx, PrefixExpression expression,
		boolean suppressErrors) {
		switch (expression.operator) {
			case '-': {
				val operand = evaluateImpl(ctx, expression.operand, suppressErrors);
				if(operand.isError) return operand;
				return new ConstantValue(operand.value.negate());
			}
			default: {
				if(!suppressErrors) {
					ctx.acceptError('prefix operator ' + expression.operator + ' is not allowed in constant expression',
						expression.eContainer, expression.eContainingFeature, -1,
						IssueCodes.InvalidConstantExpressionNode);
				}
				return ConstantValue.invalid;
			}
		}
	}

	def private static dispatch ConstantValue evaluateImpl(AnalysisContext ctx, Expression expression,
		boolean suppressErrors) {
		if(!suppressErrors) {
			ctx.acceptError(expression.eClass.name + ' is not allowed in constant expression', expression, null, -1,
				IssueCodes.InvalidConstantExpressionNode);
		}
		return ConstantValue.invalid;
	}
}
