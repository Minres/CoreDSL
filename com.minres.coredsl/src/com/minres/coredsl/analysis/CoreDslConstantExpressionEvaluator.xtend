package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.ConditionalExpression
import com.minres.coredsl.coreDsl.EntityReference
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.IntrinsicExpression
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.validation.IssueCodes
import java.math.BigInteger

import static extension com.minres.coredsl.util.ModelUtil.*

class CoreDslConstantExpressionEvaluator {
	private new() {}

	static def dispatch ConstantValue evaluate(AnalysisContext ctx, Expression node) {
		
		if(node.parentOfType(ISA) == ctx.root) {
			ctx.acceptor.acceptError(
				node.class.simpleName + ' is not allowed in constant expression',
				node.eContainer, node.eContainingFeature,
				-1, IssueCodes.InvalidConstantExpressionNode);
		}
		
		return ConstantValue.invalid;
	}

	static def dispatch ConstantValue evaluate(AnalysisContext ctx, EntityReference node) {
		val value = ctx.constantDefinitions.get(node.target.name).calculatedValue;
		if (value !== null) return value;
		return ConstantValue.indeterminate;
	}

	static def dispatch ConstantValue evaluate(AnalysisContext ctx, IntegerConstant node) {
		return new ConstantValue(node.value);
	}

	static def dispatch ConstantValue evaluate(AnalysisContext ctx, IntrinsicExpression node) {
		switch (node.function) {
			case "sizeof",
			case "bitsizeof": {
				val inBytes = node.function == "sizeof";
				
				if (node.arguments.size != 1)
					return ConstantValue.invalid;
				
				val argument = node.arguments.get(0);
				switch(argument) {
					
					TypeSpecifier: {
						val type = CoreDslTypeProvider.getSpecifiedType(ctx, argument);
						
						if(type.invalid) return ConstantValue.invalid;
						if(type.indeterminate) return ConstantValue.indeterminate;
						
						val size = inBytes ? (type.bitSize + 7) / 8 : type.bitSize;
						return new ConstantValue(BigInteger.valueOf(size));
					}
					
					EntityReference: {
						val name = argument.target.name;
						
						val constant = ctx.constantDefinitions.get(name);
						if(constant === null) return ConstantValue.invalid;
						
						val type = constant.calculatedType; 
						if(type === null) return ConstantValue.indeterminate;
						
						val size = inBytes ? (type.bitSize + 7) / 8 : type.bitSize;
						return new ConstantValue(BigInteger.valueOf(size));
					}
					
					default: {
						return ConstantValue.invalid;
					}
				}
			}
			
			default: {
				// TODO
				return ConstantValue.invalid;
			}
		}
	}

	static def dispatch ConstantValue evaluate(AnalysisContext ctx, InfixExpression node) {
		val l = evaluate(ctx, node.left);
		val r = evaluate(ctx, node.right);

		if(l.invalid || r.invalid) return ConstantValue.invalid;
		if(l.indeterminate || r.indeterminate) return ConstantValue.indeterminate;

		return switch (node.operator) {
			case '+': new ConstantValue(l.value + r.value)
			case '-': new ConstantValue(l.value - r.value)
			case '*': new ConstantValue(l.value * r.value)
			case '/': new ConstantValue(l.value / r.value)
			case '%': new ConstantValue(l.value % r.value)
			default: ConstantValue.invalid
		}
	}
	
	static def dispatch ConstantValue evaluate(AnalysisContext ctx, ConditionalExpression node) {
		val condition = evaluate(ctx, node.condition);
		
		if(condition.invalid) return ConstantValue.invalid;
		if(condition.indeterminate) return ConstantValue.indeterminate;
		
		return condition.value != BigInteger.ZERO
			? evaluate(ctx, node.thenExpression)
			: evaluate(ctx, node.elseExpression);
	}
}
