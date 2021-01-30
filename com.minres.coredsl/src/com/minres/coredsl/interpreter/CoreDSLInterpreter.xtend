package com.minres.coredsl.interpreter

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BitValue
import com.minres.coredsl.coreDsl.BoolConstant
import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.CharacterConstant
import com.minres.coredsl.coreDsl.ConditionalExpression
import com.minres.coredsl.coreDsl.DataTypes
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DirectDeclarator
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.FloatingConstant
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.InitDeclarator
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.Postfix
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.PrimaryExpression
import com.minres.coredsl.coreDsl.StringLiteral
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.Variable
import com.minres.coredsl.typing.DataType
import com.minres.coredsl.util.BigDecimalWithSize
import com.minres.coredsl.util.BigIntegerWithRadix
import java.math.BigInteger
import static extension com.minres.coredsl.typing.TypeProvider.*
import java.math.BigDecimal

class CoreDSLInterpreter {

    /* TODO: 
     * 
     * 
     */
     
    def static Value evaluate(DirectDeclarator decl, EvaluationContext ctx){
        if(decl.eContainer instanceof InitDeclarator){
            (decl.eContainer as InitDeclarator).initializer.expr.valueFor(ctx)
        }    
    }
    
    def static dispatch Value valueFor(TypeSpecifier e, EvaluationContext ctx) {
        return new Value(e.typeFor, null)
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
        switch(e.op){
            case "||", case "&&", 
            case "==", case "!=", case "<", case ">", case "<=", case ">=": new Value(boolType, null)
            case '|', case "&", case "^",
            case "<<", case ">>": {
                val l = e.left.valueFor(ctx)
                l.type.isIntegral ? l : null
            }
            case '+', case '-',
            case '*', case '/': {
                val l = e.left.valueFor(ctx)
                val r = e.right.valueFor(ctx)
                !l.isComputable(r)? null : switch(e.op){
                case '+': new Value(l.type, l.value.add_(r.value))
                case '-': new Value(l.type, l.value.sub_(r.value))
                case '*': new Value(l.type, l.value.mul_(r.value))
                case '/': new Value(l.type, l.value.div_(r.value))
                }
            }
            case '%': {
                val l = e.left.valueFor(ctx)
                val r = e.right.valueFor(ctx)
                l.type.isIntegral && l.type.isIntegral ? new Value(l.type, l.value.mod_(r.value)) : null
            }
            default: null
        }
    }

    def static dispatch Value valueFor(CastExpression e, EvaluationContext ctx) {
        return e.type.valueFor(ctx)
    }

    def static dispatch Value valueFor(PrefixExpression e, EvaluationContext ctx) {
        switch(e.op){
            case "++",
            case "--": e.left.valueFor(ctx)
            case "~": e.left.valueFor(ctx)
            case "!": new Value(boolType, e.left.valueFor(ctx).value)
            case "sizeof": new Value(new DataType(DataTypes.INT, DataTypes.UNSIGNED, 32), -1) // TODO: fix it
            default: // missing 'case "&", case "*", case "+" , case "-":'
                null
        }
    }

    def static dispatch Value valueFor(PostfixExpression e, EvaluationContext ctx) {
        switch(e.right.op){
            case ".",
            case "->":e.right.valueFor(ctx)
            default:
                e.left.valueFor(ctx)?:e.right.valueFor(ctx)
        }
    }

    def static dispatch Value valueFor(Postfix e, EvaluationContext ctx) {
        if(e.right!==null)
            switch(e.right.op){
                case ".", case "->": return e.right.valueFor(ctx)
            }
        switch(e.op){
            case ".", case "->":e.declarator.valueFor(ctx)
            default:
                null
        }
    }

    def static dispatch Value valueFor(PrimaryExpression e, EvaluationContext ctx) {
        if(e.constant !== null) {
            e.constant.valueFor(ctx)
        } else if(e.ref !== null ){
            e.ref.valueFor(ctx)
        } else
            return null
    }
    
    def static dispatch Value valueFor(Variable e, EvaluationContext ctx) {
        null
    }

    def static dispatch Value valueFor(FunctionDefinition e, EvaluationContext ctx) {
        e.type.valueFor(ctx)
    }

    def static dispatch Value valueFor(DirectDeclarator e, EvaluationContext ctx) {
        if (e.eContainer instanceof InitDeclarator) {
            (e.eContainer as InitDeclarator).initializer.expr.valueFor(ctx)
        } else
            null
    }

    def static dispatch Value valueFor(BitField e, EvaluationContext ctx) {
        new Value( new DataType(DataTypes.INT, DataTypes.UNSIGNED, e.left.value.intValue), null) // bitfield cannot be evaluated
    }

    def static dispatch Value valueFor(BitValue e, EvaluationContext ctx) {
        new Value( new DataType(DataTypes.INT, DataTypes.UNSIGNED, 1), 0)
    }

    def static dispatch Value valueFor(IntegerConstant e, EvaluationContext ctx) {
        new Value(e.typeFor, e.value as BigIntegerWithRadix)
    }

    def static dispatch Value valueFor(FloatingConstant e, EvaluationContext ctx) {
        new Value(e.typeFor, e.value as BigDecimalWithSize)
    }

    def static dispatch Value valueFor(BoolConstant e, EvaluationContext ctx) {
        new Value(boolType, e.isValue?1:0)
    }

    def static dispatch Value valueFor(CharacterConstant e, EvaluationContext ctx) {
        new Value(new DataType(DataTypes.CHAR, DataTypes.SIGNED, 8), BigInteger.valueOf(e.value.charAt(0)))
    }
    
    def static dispatch Value valueFor(StringLiteral e, EvaluationContext ctx) {
        new Value(new DataType(DataTypes.CHAR, DataTypes.SIGNED, 0), null)
    }
    
    def static boolean isComparable(Value left, Value right){
        true
    }

    def static boolean isAssignable(Value to, Value from){
        true
    }
    
    def static boolean isComputable(Value left, Value right){
        left.type==right.type
    }
    
    def static dispatch Number add_(BigDecimal a, BigDecimal b){
        a.add(b)
    }
    def static dispatch Number add_(BigInteger a, BigInteger b){
        a.add(b)
    }
    def static dispatch Number sub_(BigDecimal a, BigDecimal b){
        a.subtract(b)
    }
    def static dispatch Number sub_(BigInteger a, BigInteger b){
        a.subtract(b)
    }
    def static dispatch Number mul_(BigDecimal a, BigDecimal b){
        a.multiply(b)
    }
    def static dispatch Number mul_(BigInteger a, BigInteger b){
        a.multiply(b)
    }
    def static dispatch Number div_(BigDecimal a, BigDecimal b){
        a.divide(b)
    }
    def static dispatch Number div_(BigInteger a, BigInteger b){
        a.divide(b)
    }
    def static dispatch Number mod_(BigDecimal a, BigDecimal b){
        null
    }
    def static dispatch Number mod_(BigInteger a, BigInteger b){
        a.mod(b)
    }
}
