package com.minres.coredsl.typing

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BitValue
import com.minres.coredsl.coreDsl.BoolConstant
import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.CharacterConstant
import com.minres.coredsl.coreDsl.CompositeTypeSpecifier
import com.minres.coredsl.coreDsl.ConditionalExpression
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.EnumTypeSpecifier
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.FloatConstant
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.StringLiteral
import com.minres.coredsl.coreDsl.Encoding
import com.minres.coredsl.coreDsl.Field
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.Constant
import com.minres.coredsl.util.BigDecimalWithSize
import com.minres.coredsl.util.BigIntegerWithRadix

import static extension com.minres.coredsl.interpreter.CoreDSLInterpreter.*
import static extension com.minres.coredsl.util.ModelUtil.*
import com.minres.coredsl.interpreter.EvaluationContext
import java.math.BigInteger
import com.minres.coredsl.coreDsl.FunctionCallExpression
import com.minres.coredsl.coreDsl.MemberAccessExpression
import com.minres.coredsl.coreDsl.ArrayAccessExpression
import com.minres.coredsl.coreDsl.VoidTypeSpecifier
import com.minres.coredsl.coreDsl.FloatTypeSpecifier
import com.minres.coredsl.coreDsl.FloatSizeShorthand
import com.minres.coredsl.coreDsl.BoolTypeSpecifier
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.coreDsl.IntegerSignedness
import com.minres.coredsl.coreDsl.ParenthesisExpression
import com.minres.coredsl.coreDsl.StringConstant
import com.minres.coredsl.coreDsl.InitDeclarator
import com.minres.coredsl.coreDsl.NamedEntity
import com.minres.coredsl.coreDsl.EntityReference

class TypeProvider {

    /* TODO: 
     * * sub typing
     * 
     */
    public static val boolType = new DataType(DataType.Type.INTEGRAL_SIGNED, 1)

	def static Boolean isAligned(DataType dt) {
    	dt.size==8 || dt.size==16 || dt.size==32 || dt.size==64 || dt.size==128
    }

    def static Boolean isIntegral(DataType dt) {
		dt.size > 0 && (dt.type == DataType.Type.INTEGRAL_SIGNED || dt.type==DataType.Type.INTEGRAL_UNSIGNED)
    }
 
    def static DataType typeFor(TypeSpecifier e) {
        e.typeFor(e.parentOfType(ISA))
    }
 
    def static DataType typeFor(Declarator e) {
        e.typeFor(e.parentOfType(ISA))
    }
 
    def static DataType typeFor(Expression e) {
        e.typeFor(e.parentOfType(ISA))
    }
 
    def static DataType typeFor(Constant e) {
        e.typeFor(e.parentOfType(ISA))
    }

    def static dispatch DataType typeFor(CompositeTypeSpecifier e, ISA ctx) {
        return new DataType(DataType.Type.COMPOSITE, 0)
    }

    def static dispatch DataType typeFor(EnumTypeSpecifier e, ISA ctx) {
        return new DataType(DataType.Type.INTEGRAL_SIGNED, 32)
    }
    
    def static dispatch DataType typeFor(VoidTypeSpecifier e, ISA ctx) {
		return new DataType(DataType.Type.VOID, 0)    	
    }
    
    def static dispatch DataType typeFor(FloatTypeSpecifier e, ISA ctx) {
    	if(e.shorthand == FloatSizeShorthand.DOUBLE)
    		return new DataType(DataType.Type.FLOAT, 64)
    	return new DataType(DataType.Type.FLOAT, 32) 
    }
    
    def static dispatch DataType typeFor(BoolTypeSpecifier e, ISA ctx) {
    	return new DataType(DataType.Type.INTEGRAL_SIGNED, 1) 
    }

    def static dispatch DataType typeFor(IntegerTypeSpecifier e, ISA ctx) {
        val isUnsigned = e.signedness == IntegerSignedness.UNSIGNED;   
        if (e.size !== null) {
            val sizeValue = e.size.valueFor(EvaluationContext.root(ctx))
            if(sizeValue === null || !(sizeValue.value instanceof BigInteger)) return null
            val sizeInt = (sizeValue.value as BigInteger).intValue
            return isUnsigned
                ? new DataType(DataType.Type.INTEGRAL_UNSIGNED, sizeInt)
                : new DataType(DataType.Type.INTEGRAL_SIGNED, sizeInt)
        } else {
			switch(e.shorthand) {
				case CHAR: {
                    return isUnsigned
                        ? new DataType(DataType.Type.INTEGRAL_UNSIGNED, 8)
                        : new DataType(DataType.Type.INTEGRAL_SIGNED, 8)
				}
				case SHORT: {
                    return isUnsigned
                        ? new DataType(DataType.Type.INTEGRAL_UNSIGNED, 16)
                        : new DataType(DataType.Type.INTEGRAL_SIGNED, 16)
				}
				case INT: {
                	return isUnsigned
                    	? new DataType(DataType.Type.INTEGRAL_UNSIGNED, 32)
                    	: new DataType(DataType.Type.INTEGRAL_SIGNED, 32)
				}
				case LONG: {
                	return isUnsigned
	                    ? new DataType(DataType.Type.INTEGRAL_UNSIGNED, 64)
                    	: new DataType(DataType.Type.INTEGRAL_SIGNED, 64)
				}
			}
        }
        
        return null;
    }

    def static dispatch DataType typeFor(AssignmentExpression e, ISA ctx) {
        return e.assignments.last.right.typeFor(ctx)
    }

    def static dispatch DataType typeFor(ConditionalExpression e, ISA ctx) {
        return e.left.typeFor(ctx)
    }

    def static dispatch DataType typeFor(InfixExpression e, ISA ctx) {
        switch(e.op){
            case "||", case "&&", 
            case "==", case "!=", case "<", case ">", case "<=", case ">=": boolType
            case '|', case "&", case "^": {
                val l = e.left.typeFor(ctx)
                val r = e.right.typeFor(ctx)
                l !==null && r!==null && l.isIntegral && l.type== r.type? 
                	new DataType(l.type, l.size>r.size?l.size:r.size) : null
            }
            case "<<", case ">>": {
                val l = e.left.typeFor(ctx)
                l !==null && l.isIntegral ? l : null
            }
            case '+', case '-',
            case '*', case '/': {
                val l = e.left.typeFor(ctx)
                l == e.right.typeFor(ctx) ? l : null
            }
            case '%': {
                val l = e.left.typeFor(ctx)
                l.isIntegral && l == e.right.typeFor(ctx) ? l : null
            }
            default: null
        }
    }

    def static dispatch DataType typeFor(CastExpression e, ISA ctx) {
        return e.type.typeFor(ctx)
    }

    def static dispatch DataType typeFor(PrefixExpression e, ISA ctx) {
        switch(e.op){
            case "++",
            case "--": e.left.typeFor(ctx)
            case "~": e.left.typeFor(ctx)
            case "!": boolType
            case "sizeof": new DataType(DataType.Type.INTEGRAL_UNSIGNED, 32)
            default: // missing 'case "&", case "*", case "+" , case "-":'
                null
        }
    }

    def static dispatch DataType typeFor(PostfixExpression e, ISA ctx) {
        return e.left.typeFor(ctx);
    }

    def static dispatch DataType typeFor(FunctionCallExpression e, ISA ctx) {
        return e.left.typeFor(ctx);
    }

    def static dispatch DataType typeFor(ArrayAccessExpression e, ISA ctx) {
        return e.left.typeFor(ctx);
    }

    def static dispatch DataType typeFor(MemberAccessExpression e, ISA ctx) {
        return e.declarator.typeFor(ctx);
    }

    def static dispatch DataType typeFor(ParenthesisExpression e, ISA ctx) {
        return e.left.typeFor(ctx);
    }
    
    def static dispatch DataType typeFor(EntityReference e, ISA ctx) {
        return e.target.typeFor(ctx);
    }
    
    def static dispatch DataType typeFor(NamedEntity e, ISA ctx) {
        null
    }

    def static dispatch DataType typeFor(FunctionDefinition e, ISA ctx) {
        e.type.typeFor(ctx)
    }

    def static dispatch DataType typeFor(Declarator e, ISA ctx) {
        if (e.eContainer instanceof InitDeclarator && e.eContainer.eContainer instanceof Declaration) {
            var decl = e.eContainer.eContainer as Declaration
            decl.type.typeFor(ctx)
        } else
            null
    }

    def static dispatch DataType  typeFor(Encoding list, ISA ctx) {
        var size=0
        for(Field f:list.fields)
            switch(f){
                BitField:{size += f.left.value.intValue-f.right.value.intValue+1}
                BitValue:{size += (f.value as BigIntegerWithRadix).size}
            }
        new DataType(DataType.Type.INTEGRAL_UNSIGNED, size)
    }

    def static dispatch DataType typeFor(BitField e, ISA ctx) {
        new DataType(DataType.Type.INTEGRAL_UNSIGNED, e.left.value.intValue + 1)
    }

    def static dispatch DataType typeFor(BitValue e, ISA ctx) {
        new DataType(DataType.Type.INTEGRAL_UNSIGNED, (e.value as BigIntegerWithRadix).size)
    }

    def static dispatch DataType typeFor(IntegerConstant e, ISA ctx) {
        val value = e.value as BigIntegerWithRadix
        new DataType(value.type==BigIntegerWithRadix.TYPE.UNSIGNED?DataType.Type.INTEGRAL_UNSIGNED:DataType.Type.INTEGRAL_SIGNED, value.size)
    }

    def static dispatch DataType typeFor(FloatConstant e, ISA ctx) {
        new DataType(DataType.Type.FLOAT, (e.value as BigDecimalWithSize).size)
    }

    def static dispatch DataType typeFor(BoolConstant e, ISA ctx) {
        boolType
    }

    def static dispatch DataType typeFor(CharacterConstant e, ISA ctx) {
        new DataType(DataType.Type.INTEGRAL_SIGNED, 8)
    }
    
    def static dispatch DataType typeFor(StringConstant e, ISA ctx) {
        new DataType(DataType.Type.INTEGRAL_SIGNED, 0)
    }
    
    def static dispatch DataType typeFor(StringLiteral e, ISA ctx) {
        new DataType(DataType.Type.INTEGRAL_SIGNED, 0)
    }
    
    def static boolean isComparable(DataType left, DataType right){
        if (left.size > 0 && right.size > 0) {
            if (left.type == DataType.Type.FLOAT && right.type == DataType.Type.FLOAT)
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
                if (to.type == DataType.Type.FLOAT && from.type == DataType.Type.FLOAT)
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
