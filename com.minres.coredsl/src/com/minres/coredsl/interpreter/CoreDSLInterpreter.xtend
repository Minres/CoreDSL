package com.minres.coredsl.interpreter

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BitValue
import com.minres.coredsl.coreDsl.BoolConstant
import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.CharacterConstant
import com.minres.coredsl.coreDsl.ConditionalExpression
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.FloatConstant
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.InitDeclarator
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.StringLiteral
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.typing.DataType
import com.minres.coredsl.util.BigDecimalWithSize
import com.minres.coredsl.util.BigIntegerWithRadix
import java.math.BigDecimal
import java.math.BigInteger

import static extension com.minres.coredsl.typing.TypeProvider.*
import static extension com.minres.coredsl.util.ModelUtil.*
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.FunctionCallExpression
import com.minres.coredsl.coreDsl.ArrayAccessExpression
import com.minres.coredsl.coreDsl.MemberAccessExpression
import com.minres.coredsl.coreDsl.ParenthesisExpression
import com.minres.coredsl.coreDsl.StringConstant
import com.minres.coredsl.coreDsl.ExpressionInitializer
import com.minres.coredsl.coreDsl.NamedEntity
import com.minres.coredsl.coreDsl.EntityReference
import org.eclipse.xtext.parser.packrat.tokens.AssignmentToken.End

class CoreDSLInterpreter {

    /* TODO: 
     * 
     * 
     */
    def static Value evaluate(Declarator decl, EvaluationContext ctx) {
        if (decl.eContainer instanceof InitDeclarator) {
            val context = ctx.definitionContext
            if (context === null) {
                val initDecl = (decl.eContainer as InitDeclarator)
                if (initDecl.initializer instanceof ExpressionInitializer)
                    return (initDecl.initializer as ExpressionInitializer).expr.valueFor(ctx)
                else
                    return null
            }
            val stmts = switch (context) {
                CoreDef: {
                    context.allDefinitions
                }
                InstructionSet: {
                    context.allDefinitions
                }
            }.toList
            val assignments = stmts.filter[it instanceof ExpressionStatement].map [
                (it as ExpressionStatement).expr 
            ]
            val declAssignment = assignments.filter [
                it.left instanceof EntityReference && (it.left as EntityReference).target == decl
            ].last
            if (declAssignment === null) {
                val initDecl = (decl.eContainer as InitDeclarator)
                if (initDecl.initializer instanceof ExpressionInitializer)
                    return (initDecl.initializer as ExpressionInitializer).expr.valueFor(ctx)
                else
                    return null
            } else
                (declAssignment as AssignmentExpression).assignments.get(0).right.valueFor(ctx)
        } else
            null
    }

    def static dispatch Value valueFor(TypeSpecifier e, EvaluationContext ctx) {
        return new Value(e.typeFor(ctx.definitionContext), null)
    }

    def dispatch static Value valueFor(Expression e, EvaluationContext ctx) {
        return null
    }

    def static dispatch Value valueFor(AssignmentExpression e, EvaluationContext ctx) {
        return e.assignments.last.valueFor(ctx)
    }

    def static dispatch Value valueFor(ConditionalExpression e, EvaluationContext ctx) {
        return e.left.valueFor(ctx)
    }

    def static dispatch Value valueFor(InfixExpression e, EvaluationContext ctx) {
        switch (e.op) {
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
                    : switch (e.op) {
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
        return e.type.valueFor(ctx)
    }

    def static dispatch Value valueFor(PrefixExpression e, EvaluationContext ctx) {
        switch (e.op) {
            case "++",
            case "--":
                e.left.valueFor(ctx)
            case "~":
                e.left.valueFor(ctx)
            case "!":
                new Value(boolType, e.left.valueFor(ctx).value)
            case "sizeof":
                new Value(new DataType(DataType.Type.INTEGRAL_UNSIGNED, 32), -1) // TODO: fix it
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

    def static dispatch Value valueFor(ArrayAccessExpression e, EvaluationContext ctx) {
        // TODO do we want to support this?
        return null;
    }

    def static dispatch Value valueFor(MemberAccessExpression e, EvaluationContext ctx) {
        // TODO do we want to support this?
        return null;
    }

    def static dispatch Value valueFor(ParenthesisExpression e, EvaluationContext ctx) {
        return e.left.valueFor(ctx);
    }

    def static dispatch Value valueFor(EntityReference e, EvaluationContext ctx) {
        return e.target.valueFor(ctx);
    }

    def static dispatch Value valueFor(NamedEntity e, EvaluationContext ctx) {
        null
    }

    def static dispatch Value valueFor(FunctionDefinition e, EvaluationContext ctx) {
        e.type.valueFor(ctx)
    }

    def static dispatch Value valueFor(Declarator e, EvaluationContext ctx) {
        ctx.getValue(e) ?: calculateValue(e, ctx)
    }

    private static def Value calculateValue(Declarator e, EvaluationContext ctx) {
        if (ctx.definitionContext !== null) {
        	
        	// gather all assignments to this declarator
            val assignments = ctx.definitionContext.allDefinitions.filter [
                if (it instanceof ExpressionStatement) {
                	val expr = it.expr
                    if(expr instanceof AssignmentExpression) {
                        val entityRef = expr.left
                        if (entityRef instanceof EntityReference) {
                            return expr.assignments.size > 0 && entityRef.target === e
                        }
                    }
                }
                return false
            ].map[(it as ExpressionStatement).expr as AssignmentExpression].toList
            
            if (assignments.size > 0) {
                val assignment = assignments.last;
                val res = assignment.assignments.findFirst[! (right instanceof EntityReference)].right.valueFor(ctx)
                return ctx.newValue(e, res);
            }
        }
        if (e.eContainer instanceof InitDeclarator) {
            val initDecl = e.eContainer as InitDeclarator;
            if (initDecl.initializer instanceof ExpressionInitializer) {
                val initializer = initDecl.initializer as ExpressionInitializer;
                return ctx.newValue(e, initializer.expr.valueFor(ctx))
            } else if (e.eContainer.eContainer.eContainer instanceof ISA) {
                val directDecl = ctx.definitionContext.effectiveDeclarator(e.name)
                return directDecl.evaluate(ctx);
            }
        }
        null
    }

    def static dispatch Value valueFor(BitField e, EvaluationContext ctx) {
        new Value(new DataType(DataType.Type.INTEGRAL_UNSIGNED, e.left.value.intValue), null) // bitfield cannot be evaluated
    }

    def static dispatch Value valueFor(BitValue e, EvaluationContext ctx) {
        new Value(new DataType(DataType.Type.INTEGRAL_UNSIGNED, 1), 0)
    }

    def static dispatch Value valueFor(IntegerConstant e, EvaluationContext ctx) {
        new Value(e.typeFor(ctx.definitionContext), e.value as BigIntegerWithRadix)
    }

    def static dispatch Value valueFor(FloatConstant e, EvaluationContext ctx) {
        new Value(e.typeFor(ctx.definitionContext), e.value as BigDecimalWithSize)
    }

    def static dispatch Value valueFor(BoolConstant e, EvaluationContext ctx) {
        new Value(boolType, e.isValue ? 1 : 0)
    }

    def static dispatch Value valueFor(CharacterConstant e, EvaluationContext ctx) {
        new Value(new DataType(DataType.Type.INTEGRAL_SIGNED, 8), BigInteger.valueOf(e.value.charAt(0)))
    }

    def static dispatch Value valueFor(StringConstant e, EvaluationContext ctx) {
        new Value(new DataType(DataType.Type.INTEGRAL_SIGNED, 0), null)
    }

    def static dispatch Value valueFor(StringLiteral e, EvaluationContext ctx) {
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
