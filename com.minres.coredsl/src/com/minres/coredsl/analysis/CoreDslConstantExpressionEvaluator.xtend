package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.EntityReference
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.IntrinsicExpression
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.validation.IssueCodes
import java.math.BigInteger

import static extension com.minres.coredsl.util.ModelExtensions.*

class CoreDslConstantExpressionEvaluator {

	def static dispatch ConstantValue evaluate(ElaborationContext ctx, EntityReference expression) {
		val declarator = expression.target.castOrNull(Declarator);

		if(declarator === null || !ctx.actx.isIsaParameter(declarator)) {
			ctx.acceptError("Identifiers in constant expressions may only refer to ISA parameters", expression,
				CoreDslPackage.Literals.ENTITY_REFERENCE__TARGET, -1, IssueCodes.InvalidConstantExpressionIdentifier);
			return ConstantValue.invalid;
		}

		val value = ctx.getCalculatedValue(declarator);
		return value !== null ? value : ConstantValue.indeterminate;
	}

	def static dispatch ConstantValue evaluate(ElaborationContext ctx, IntegerConstant expression) {
		return new ConstantValue(expression.value);
	}

	def static dispatch ConstantValue evaluate(ElaborationContext ctx, InfixExpression expression) {
		val left = evaluate(ctx, expression.left);
		val right = evaluate(ctx, expression.right);

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
				ctx.acceptError("Infix expression " + expression.operator +
					" is currently unsupported in constant expressions", expression,
					CoreDslPackage.Literals.INFIX_EXPRESSION__OPERATOR, -1, IssueCodes.UnsupportedLanguageFeature);
			}
		}

		return ConstantValue.invalid;
	}

	private def static ConstantValue getTypeSize(ElaborationContext ctx, TypeSpecifier specifier, boolean inBytes) {
		val type = CoreDslTypeProvider.getSpecifiedType(ctx, specifier);
		if(type.isInvalid) return ConstantValue.invalid;
		if(type.isIndeterminate) return ConstantValue.indeterminate;
		return new ConstantValue(inBytes ? (type.bitSize + 7) / 8 : type.bitSize);
	}

	def static dispatch ConstantValue evaluate(ElaborationContext ctx, IntrinsicExpression expression) {
		switch (expression.function) {
			case 'bitsizeof',
			case 'sizeof': {
				val inBytes = expression.function == 'sizeof';
				if(expression.arguments.size() != 1) {
					// TODO error
				} else {
					val arg = expression.arguments.get(0);
					switch (arg) {
						TypeSpecifier: {
							return getTypeSize(ctx, arg, inBytes);
						}
						EntityReference: {
							val declarator = arg.target.castOrNull(Declarator);
							if(declarator !== null) {
								return getTypeSize(ctx, declarator.type, inBytes);
							} else {
								// TODO error
							}
						}
						default: {
							// TODO error
						}
					}
				}
			}
			default: {
				ctx.acceptError('intrinsic function ' + expression.function + ' is not allowed in constant expression',
					expression.eContainer, expression.eContainingFeature, -1, IssueCodes.InvalidConstantExpressionNode);
			}
		}
		return ConstantValue.invalid;
	}

	def static dispatch ConstantValue evaluate(ElaborationContext ctx, Expression expression) {
		ctx.acceptError(expression.eClass.name + ' is not allowed in constant expression', expression.eContainer,
			expression.eContainingFeature, -1, IssueCodes.InvalidConstantExpressionNode);

		return ConstantValue.invalid;
	}

}
