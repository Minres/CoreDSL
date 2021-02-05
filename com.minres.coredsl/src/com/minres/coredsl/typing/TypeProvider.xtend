package com.minres.coredsl.typing

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BitValue
import com.minres.coredsl.coreDsl.BoolConstant
import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.CharacterConstant
import com.minres.coredsl.coreDsl.CompositeType
import com.minres.coredsl.coreDsl.ConditionalExpression
import com.minres.coredsl.coreDsl.DataTypes
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DirectDeclarator
import com.minres.coredsl.coreDsl.EnumType
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
import com.minres.coredsl.coreDsl.PrimitiveType
import com.minres.coredsl.coreDsl.StringLiteral
import com.minres.coredsl.coreDsl.Variable
import com.minres.coredsl.util.BigDecimalWithSize
import com.minres.coredsl.util.BigIntegerWithRadix

import static extension com.minres.coredsl.interpreter.CoreDSLInterpreter.*
import com.minres.coredsl.interpreter.EvaluationContext
import java.math.BigInteger
import com.minres.coredsl.coreDsl.Encoding
import com.minres.coredsl.coreDsl.Field

class TypeProvider {

    /* TODO: 
     * * sub typing
     * 
     */
    public static val boolType = new DataType(DataType.INTEGRAL_SIGNED, 1)

    def static Boolean isIntegral(DataType dt) {
        if (dt.size > 0) {
            return switch (dt.type) {
                case DataTypes.BOOL,
                case DataTypes.CHAR,
                case DataTypes.SHORT,
                case DataTypes.INT,
                case DataTypes.LONG: true
                default: false
            }
        }
        return false
    }
 
    def static dispatch DataType typeFor(CompositeType e) {
        return new DataType(0, 0)
    }

    def static dispatch DataType typeFor(EnumType e) {
        return new DataType(DataType.INTEGRAL_SIGNED, 32)
    }

    def static dispatch DataType typeFor(PrimitiveType e) {
        if (e.dataType.findFirst[it == DataTypes.FLOAT] !== null)
            return new DataType(DataType.FLOAT, 32)
        val longCount = e.dataType.filter[it === DataTypes.LONG].size
        if (e.dataType.findFirst[it === DataTypes.DOUBLE] !== null)
            return longCount == 1 ? new DataType(DataType.FLOAT, 80) : new DataType(DataType.FLOAT, 64)
        if (e.dataType.findFirst[it === DataTypes.BOOL] !== null)
            return new DataType(DataType.INTEGRAL_SIGNED, 1)
        val isUnsigned = e.dataType.findFirst[it === DataTypes.UNSIGNED] !== null
        if (e.size.size > 0) {
            val sizeValue = e.size.get(0).valueFor(EvaluationContext.root)
            if(sizeValue === null || !(sizeValue.value instanceof BigInteger)) return null
            val sizeInt = (sizeValue.value as BigInteger).intValue
            return isUnsigned
                ? new DataType(DataType.INTEGRAL_UNSIGNED, sizeInt)
                : new DataType(DataType.INTEGRAL_SIGNED, sizeInt)
        } else {
            if (longCount == 2)
                return isUnsigned
                    ? new DataType(DataType.INTEGRAL_UNSIGNED, 128)
                    : new DataType(DataType.INTEGRAL_SIGNED, 128)
            else if (longCount == 1)
                return isUnsigned
                    ? new DataType(DataType.INTEGRAL_UNSIGNED, 128)
                    : new DataType(DataType.INTEGRAL_SIGNED, 128)
            else if (longCount == 0) {
                if (e.dataType.findFirst[it === DataTypes.SHORT] !== null)
                    return isUnsigned
                        ? new DataType(DataType.INTEGRAL_UNSIGNED, 16)
                        : new DataType(DataType.INTEGRAL_SIGNED, 16)
                if (e.dataType.findFirst[it === DataTypes.CHAR] !== null)
                    return isUnsigned
                        ? new DataType(DataType.INTEGRAL_UNSIGNED, 8)
                        : new DataType(DataType.INTEGRAL_SIGNED, 8)
                if (e.dataType.findFirst[it === DataTypes.INT] !== null)
                    return isUnsigned
                        ? new DataType(DataType.INTEGRAL_UNSIGNED, 32)
                        : new DataType(DataType.INTEGRAL_SIGNED, 32)
            }
        }
        return new DataType(0, 0)
    }

    def dispatch static DataType typeFor(Expression e) {
        val types =  e.expressions.map[expr|expr.typeFor]
        val first = types.findFirst[it===null]
        if(first !== null)
            return null
        return types.head
    }

    def static dispatch DataType typeFor(AssignmentExpression e) {
        return e.assignments.last.right.typeFor
    }

    def static dispatch DataType typeFor(ConditionalExpression e) {
        return e.left.typeFor
    }

    def static dispatch DataType typeFor(InfixExpression e) {
        switch(e.op){
            case "||", case "&&", 
            case "==", case "!=", case "<", case ">", case "<=", case ">=": boolType
            case '|', case "&", case "^",
            case "<<", case ">>": {
                val l = e.left.typeFor
                l.isIntegral ? l : null
            }
            case '+', case '-',
            case '*', case '/': {
                val l = e.left.typeFor
                l == e.right.typeFor ? l : null
            }
            case '%': {
                val l = e.left.typeFor
                l.isIntegral && l == e.right.typeFor ? l : null
            }
            default: null
        }
    }

    def static dispatch DataType typeFor(CastExpression e) {
        return e.type.typeFor
    }

    def static dispatch DataType typeFor(PrefixExpression e) {
        switch(e.op){
            case "++",
            case "--": e.left.typeFor
            case "~": e.left.typeFor
            case "!": boolType
            case "sizeof": new DataType(DataType.INTEGRAL_UNSIGNED, 32)
            default: // missing 'case "&", case "*", case "+" , case "-":'
                null
        }
    }

    def static dispatch DataType typeFor(PostfixExpression e) {
        switch(e.postOp.op){
            case ".",
            case "->":e.postOp.typeFor
            default:
                e.left.typeFor?:e.postOp.typeFor
        }
    }

    def static dispatch DataType typeFor(Postfix e) {
        if(e.right!==null)
            switch(e.right.op){
                case ".", case "->": return e.right.typeFor
            }
        switch(e.op){
            case ".", case "->":e.declarator.typeFor
            default:
                null
        }
    }

    def static dispatch DataType typeFor(PrimaryExpression e) {
        if(e.constant !== null) {
            e.constant.typeFor
        } else if(e.ref !== null ){
            e.ref.typeFor
        } else
            return null
    }
    
    def static dispatch DataType typeFor(Variable e) {
        null
    }

    def static dispatch DataType typeFor(FunctionDefinition e) {
        e.type.typeFor
    }

    def static dispatch DataType typeFor(DirectDeclarator e) {
        if (e.eContainer instanceof InitDeclarator && e.eContainer.eContainer instanceof Declaration) {
            var decl = e.eContainer.eContainer as Declaration
            decl.type.typeFor
        } else
            null
    }

    def static dispatch DataType  typeFor(Encoding list) {
        var size=0
        for(Field f:list.fields)
            switch(f){
                BitField:{size += f.left.value.intValue-f.right.value.intValue+1}
                BitValue:{size += f.name.length-1}
            }
        new DataType(DataType.INTEGRAL_UNSIGNED, size)
    }

    def static dispatch DataType typeFor(BitField e) {
        new DataType(DataType.INTEGRAL_UNSIGNED, e.left.value.intValue)
    }

    def static dispatch DataType typeFor(BitValue e) {
        new DataType(DataType.INTEGRAL_UNSIGNED, e.name.length-1)
    }

    def static dispatch DataType typeFor(IntegerConstant e) {
        val value = e.value as BigIntegerWithRadix
        new DataType(value.type==BigIntegerWithRadix.TYPE.UNSIGNED?DataType.INTEGRAL_UNSIGNED:DataType.INTEGRAL_SIGNED, value.size)
    }

    def static dispatch DataType typeFor(FloatingConstant e) {
        new DataType(DataType.FLOAT, (e.value as BigDecimalWithSize).size)
    }

    def static dispatch DataType typeFor(BoolConstant e) {
        boolType
    }

    def static dispatch DataType typeFor(CharacterConstant e) {
        new DataType(DataType.INTEGRAL_SIGNED, 8)
    }
    
    def static dispatch DataType typeFor(StringLiteral e) {
        new DataType(DataType.INTEGRAL_SIGNED, 0)
    }
    def static boolean isComparable(DataType left, DataType right){
        if (left.size > 0 && right.size > 0) {
            if ((left.type == DataTypes.FLOAT || left.type == DataTypes.DOUBLE) &&
                (right.type == DataTypes.FLOAT || right.type == DataTypes.DOUBLE))
                return true
            if (left.type == right.type)
                return true
        }
        return false
    }

    def static boolean isAssignable(DataType to, DataType from){
        if (to !== null && from !== null) {
            if (to.type == from.type && to.size == from.size)
                return true
            if (to.size > 0 && from.size > 0) {
                if ((to.type == DataTypes.FLOAT || to.type == DataTypes.DOUBLE) &&
                    (from.type == DataTypes.FLOAT || from.type == DataTypes.DOUBLE))
                    return true
                if (to.isIntegral && from.isIntegral)
                    return (to.type == from.type) || (to.size == from.size)
            }
        }
        return false
    }
    
    def static boolean isComputable(DataType left, DataType right){
        left.isAssignable(right)
    }
    
}
