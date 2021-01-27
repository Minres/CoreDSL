package com.minres.coredsl.typing

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
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.PrimaryExpression
import com.minres.coredsl.coreDsl.StringLiteral
import com.minres.coredsl.util.BigDecimalWithSize
import com.minres.coredsl.util.BigIntegerWithRadix
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.Postfix
import com.minres.coredsl.coreDsl.Variable

class TypeProvider {

    /* TODO: 
     * * sub typing
     * 
     */
    public static val boolType = new DataType(DataTypes.BOOL,  null, 1)

    def static Boolean isIntegral(DataType dt) {
        switch (dt.type) {
            case DataTypes.BOOL,
            case DataTypes.CHAR,
            case DataTypes.SHORT,
            case DataTypes.INT,
            case DataTypes.LONG: true
            default: false
        }
    }
 
    def static dispatch DataType typeFor(TypeSpecifier e) {
        return new DataType(null, null, 0)
    }

    def dispatch static DataType typeFor(Expression e) {
        return null
    }

    def static dispatch DataType typeFor(AssignmentExpression e) {
        return e.assignments.last.typeFor
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
            case "sizeof": new DataType(DataTypes.INT, DataTypes.UNSIGNED, 32)
            default: // missing 'case "&", case "*", case "+" , case "-":'
                null
        }
    }

    def static dispatch DataType typeFor(PostfixExpression e) {
        switch(e.right.op){
            case ".",
            case "->":e.right.typeFor
            default:
                e.left.typeFor?:e.right.typeFor
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

    def static dispatch DataType typeFor(BitField e) {
        new DataType(DataTypes.INT, DataTypes.UNSIGNED, e.left.value.intValue)
    }

    def static dispatch DataType typeFor(BitValue e) {
        new DataType(DataTypes.INT, DataTypes.UNSIGNED, 1)
    }

    def static dispatch DataType typeFor(IntegerConstant e) {
        val value = e.value as BigIntegerWithRadix
        val type = if(value.size>64) DataTypes.LONG
        else if(value.size>32) DataTypes.INT
        else if(value.size>16) DataTypes.SHORT
        else if(value.size>8) DataTypes.CHAR
        new DataType(type,  value.type==BigIntegerWithRadix.TYPE.UNSIGNED?DataTypes.UNSIGNED:DataTypes.SIGNED, value.size)
    }

    def static dispatch DataType typeFor(FloatingConstant e) {
        val value = e.value as BigDecimalWithSize
        val type=value.size==32?DataTypes.FLOAT : DataTypes.DOUBLE
        new DataType(type, null, value.size)
    }

    def static dispatch DataType typeFor(BoolConstant e) {
        boolType
    }

    def static dispatch DataType typeFor(CharacterConstant e) {
        new DataType(DataTypes.CHAR, DataTypes.SIGNED, 1)
    }
    
    def static dispatch DataType typeFor(StringLiteral e) {
        new DataType(DataTypes.CHAR, DataTypes.UNSIGNED, 0)
    }
    def static boolean isComparable(DataType left, DataType right){
        true
    }

    def static boolean isAssignable(DataType to, DataType from){
        true
    }
    
    def static boolean isComputable(DataType left, DataType right){
        left==right
    }
}
