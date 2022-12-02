package com.minres.coredsl.interpreter

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BitValue
import com.minres.coredsl.coreDsl.BoolConstant
import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.ConditionalExpression
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.EntityReference
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.ExpressionInitializer
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.FunctionCallExpression
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.IndexAccessExpression
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.MemberAccessExpression
import com.minres.coredsl.coreDsl.NamedEntity
import com.minres.coredsl.coreDsl.ParenthesisExpression
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.StringConstant
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.typing.DataType
import com.minres.coredsl.util.BigIntegerWithRadix
import java.math.BigDecimal
import java.math.BigInteger

import static extension com.minres.coredsl.typing.TypeProvider.*
import static extension com.minres.coredsl.util.ModelUtil.*

class CoreDSLInterpreter {

    def static Value evaluate(Declarator decl, EvaluationContext ctx) {
        val context = ctx.definitionContext
        if (context === null) {
            if (decl.initializer instanceof ExpressionInitializer)
                return (decl.initializer as ExpressionInitializer).value.valueFor(ctx)
            else
                return null
        }
        val assignmentValues = context.allStateDeclarations
                .flatMap[it.declaration.declarators]
            	.filter[it== decl && it.initializer !== null && it.initializer instanceof ExpressionInitializer]
            	.map[(it.initializer as ExpressionInitializer).value] +
            context.allStateAssignments
                .map[it.expression as AssignmentExpression]
                .filter[
                    val x = it.target.primary.target
                    x === decl
                ]
                .map[it.value]
        assignmentValues.size > 0? assignmentValues.last.valueFor(ctx ): null
    }

    def static dispatch Value valueFor(TypeSpecifier e, EvaluationContext ctx) {
        return new Value(e.typeFor(ctx.definitionContext), null)
    }

    def dispatch static Value valueFor(Expression e, EvaluationContext ctx) {
        return null
    }

    def static dispatch Value valueFor(AssignmentExpression e, EvaluationContext ctx) {
        return e.value.valueFor(ctx)
    }

    def static dispatch Value valueFor(ConditionalExpression e, EvaluationContext ctx) {
        return e.condition.valueFor(ctx).value != 0 ? e.thenExpression.valueFor(ctx) : e.elseExpression.valueFor(ctx)
    }

    def static dispatch Value valueFor(InfixExpression e, EvaluationContext ctx) {
        switch (e.operator) {
            case "||",
            case "&&",
            case "==",
            case "!=",
            case "<",
            case ">",
            case "<=",
            case ">=":
                new Value(boolType, null)
            case '|',
            case "&",
            case "^",
            case "<<",
            case ">>": {
                val l = e.left.valueFor(ctx)
                l.type.isIntegral ? l : null
            }
            case '+',
            case '-',
            case '*',
            case '/': {
                val l = e.left.valueFor(ctx)
                val r = e.right.valueFor(ctx)
                !l.isComputable(r)
                    ? null
                    : switch (e.operator) {
                    case '+': new Value(l.type, l.value.add(r.value))
                    case '-': new Value(l.type, l.value.sub(r.value))
                    case '*': new Value(l.type, l.value.mul(r.value))
                    case '/': new Value(l.type, l.value.div(r.value))
                }
            }
            case '%': {
                val l = e.left.valueFor(ctx)
                val r = e.right.valueFor(ctx)
                l.type.isIntegral && l.type.isIntegral ? new Value(l.type, l.value.mod(r.value)) : null
            }
            default:
                null
        }
    }

    def static dispatch Value valueFor(CastExpression e, EvaluationContext ctx) {
        return e.targetType.valueFor(ctx)
    }

    def static dispatch Value valueFor(PrefixExpression e, EvaluationContext ctx) {
        switch (e.operator) {
            case "++",
            case "--":
                e.operand.valueFor(ctx)
            case "~":
                e.operand.valueFor(ctx)
            case "!":
                new Value(boolType, e.operand.valueFor(ctx).value)
            default: // missing 'case "&", case "*", case "+" , case "-":'
                null
        }
    }

    def static dispatch Value valueFor(PostfixExpression e, EvaluationContext ctx) {
        // postfix increment/decrement is not supported in constant expressions, because it has side effects
        return null;
    }

    def static dispatch Value valueFor(FunctionCallExpression e, EvaluationContext ctx) {
        // postfix increment/decrement is not supported in constant expressions, because it can have side effects
        return null;
    }

    def static dispatch Value valueFor(IndexAccessExpression e, EvaluationContext ctx) {
        // TODO do we want to support this?
        return null;
    }

    def static dispatch Value valueFor(MemberAccessExpression e, EvaluationContext ctx) {
        // TODO do we want to support this?
        return null;
    }

    def static dispatch Value valueFor(ParenthesisExpression e, EvaluationContext ctx) {
        return e.inner.valueFor(ctx);
    }

    def static dispatch Value valueFor(EntityReference e, EvaluationContext ctx) {
        return e.target.valueFor(ctx);
    }

    def static dispatch Value valueFor(NamedEntity e, EvaluationContext ctx) {
        null
    }

    def static dispatch Value valueFor(FunctionDefinition e, EvaluationContext ctx) {
        e.returnType.valueFor(ctx)
    }

    def static dispatch Value valueFor(Declarator e, EvaluationContext ctx) {
        ctx.getValue(e) ?: calculateValue(e, ctx)
    }

    private static def Value calculateValue(Declarator e, EvaluationContext ctx) {
        if (ctx.definitionContext !== null) {
        	
        	// gather all assignments to this declarator
            val assignments = ctx.definitionContext.allDefinitions.filter [
                if (it instanceof ExpressionStatement) {
                	val expr = it.expression
                    if(expr instanceof AssignmentExpression) {
                        val entityRef = expr.target
                        if (entityRef instanceof EntityReference) {
                            return entityRef.target === e
                        }
                    }
                }
                return false
            ].map[(it as ExpressionStatement).expression as AssignmentExpression].toList
            
            if (assignments.size > 0) {
                val assignment = assignments.last;
                val res = assignment.value.valueFor(ctx)
                return ctx.newValue(e, res);
            }
        }
        if (e.initializer !== null) {
            if (e.initializer instanceof ExpressionInitializer) {
                val initializer = e.initializer as ExpressionInitializer;
                return ctx.newValue(e, initializer.value.valueFor(ctx))
            } else if (e.eContainer.eContainer.eContainer instanceof ISA) {
                val directDecl = ctx.definitionContext.effectiveDeclarator(e.name)
                return directDecl.evaluate(ctx);
            }
        }
        null
    }

    def static dispatch Value valueFor(BitField e, EvaluationContext ctx) {
        new Value(new DataType(DataType.Type.INTEGRAL_UNSIGNED, e.endIndex.value.intValue - e.startIndex.value.intValue + 1), null) // bitfield cannot be evaluated
    }

    def static dispatch Value valueFor(BitValue e, EvaluationContext ctx) {
        new Value(new DataType(DataType.Type.INTEGRAL_UNSIGNED, 1), 0)
    }

    def static dispatch Value valueFor(IntegerConstant e, EvaluationContext ctx) {
        new Value(e.typeFor(ctx.definitionContext), e.value as BigIntegerWithRadix)
    }

    def static dispatch Value valueFor(BoolConstant e, EvaluationContext ctx) {
        new Value(boolType, e.isValue ? 1 : 0)
    }

    def static dispatch Value valueFor(StringConstant e, EvaluationContext ctx) {
        new Value(new DataType(DataType.Type.INTEGRAL_SIGNED, 0), null)
    }

    def static boolean isComparable(Value left, Value right) {
        true
    }

    def static boolean isAssignable(Value to, Value from) {
        true
    }

    def static boolean isComputable(Value left, Value right) {
        left !== null && right !== null && left.type == right.type
    }

    def static Number add(Number a, Number b) {
        if (a instanceof BigDecimal && b instanceof BigDecimal)
            (a as BigDecimal).add(b as BigDecimal)
        else if (a instanceof BigInteger && b instanceof BigInteger)
            (a as BigInteger).add(b as BigInteger)
        else
            null
    }

    def static Number sub(Number a, Number b) {
        if (a instanceof BigDecimal && b instanceof BigDecimal)
            (a as BigDecimal).subtract(b as BigDecimal)
        else if (a instanceof BigInteger && b instanceof BigInteger)
            (a as BigInteger).subtract(b as BigInteger)
        else
            null
    }

    def static Number mul(Number a, Number b) {
        if (a instanceof BigDecimal && b instanceof BigDecimal)
            (a as BigDecimal).multiply(b as BigDecimal)
        else if (a instanceof BigInteger && b instanceof BigInteger)
            (a as BigInteger).multiply(b as BigInteger)
        else
            null
    }

    def static Number div(Number a, Number b) {
        if (a instanceof BigDecimal && b instanceof BigDecimal)
            (a as BigDecimal).divide(b as BigDecimal)
        else if (a instanceof BigInteger && b instanceof BigInteger)
            (a as BigInteger).divide(b as BigInteger)
        else
            null
    }

    def static Number mod(Number a, Number b) {
        if (a instanceof BigDecimal && b instanceof BigDecimal)
            (a as BigDecimal).mod(b as BigDecimal)
        else if (a instanceof BigInteger && b instanceof BigInteger)
            (a as BigInteger).mod(b as BigInteger)
        else
            null
    }
}
