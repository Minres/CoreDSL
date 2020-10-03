package com.minres.coredsl.util

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.ConditionalExpression
import com.minres.coredsl.coreDsl.CoreDslFactory
import com.minres.coredsl.coreDsl.DataTypes
import com.minres.coredsl.coreDsl.DirectDeclarator
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.InitDeclarator
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.PrimaryExpression
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.FloatingConstant
import com.minres.coredsl.coreDsl.BoolConstant
import com.minres.coredsl.coreDsl.CharacterConstant
import com.minres.coredsl.converter.BigDecimalWithSize
import com.minres.coredsl.converter.BigIntegerWithRadix
import com.minres.coredsl.coreDsl.Declaration

class TypeProvider {

    def static dispatch TypeSpecifier typeOf(PrimaryExpression e) {
        if(e.constant !== null) {
            
        } else if(e.ref !== null ){
            
        } else
            return null
    }
    
    def static dispatch TypeSpecifier typeOf(PostfixExpression e) {
        return null
    }

    def static dispatch TypeSpecifier typeOf(PrefixExpression e) {
        return null
    }

    def static dispatch TypeSpecifier typeOf(CastExpression e) {
        return null
    }

    def static dispatch TypeSpecifier typeOf(InfixExpression e) {
        return null
    }

    def static dispatch TypeSpecifier typeOf(AssignmentExpression e) {
        return null
    }

    def static dispatch TypeSpecifier typeOf(ConditionalExpression e) {
        return null
    }

    def dispatch static TypeSpecifier typeOf(Expression e) {
        return null
    }

    def static dispatch TypeSpecifier typeOf(FunctionDefinition e) {
        return e.type as TypeSpecifier
    }

    def static dispatch TypeSpecifier typeOf(DirectDeclarator e) {
        if (e.eContainer instanceof InitDeclarator && e.eContainer.eContainer instanceof Declaration) {
            var decl = e.eContainer.eContainer as Declaration
            return decl.type
        }
        return null
    }

    def static dispatch TypeSpecifier typeOf(BitField e) {
        val elem = CoreDslFactory.eINSTANCE.createPodSpecifier
        elem.dataType.add(DataTypes.UNSIGNED)
        return elem as TypeSpecifier
    }

    def static dispatch TypeSpecifier typeOf(IntegerConstant e) {
        val value = e.value as BigIntegerWithRadix
        val elem = CoreDslFactory.eINSTANCE.createPodSpecifier
        elem.dataType.add(value.type==BigIntegerWithRadix.TYPE.UNSIGNED?DataTypes.UNSIGNED:DataTypes.SIGNED)
        if(value.size>64)      elem.dataType.addAll(DataTypes.LONG, DataTypes.LONG)
        else if(value.size>64) elem.dataType.add(DataTypes.LONG)
        else if(value.size>32) elem.dataType.add(DataTypes.INT)
        else if(value.size>16) elem.dataType.add(DataTypes.SHORT)
        else if(value.size>8) elem.dataType.add(DataTypes.CHAR)
        return elem as TypeSpecifier
    }

    def static dispatch TypeSpecifier typeOf(FloatingConstant e) {
        val value = e.value as BigDecimalWithSize
        val elem = CoreDslFactory.eINSTANCE.createPodSpecifier
        switch(value.size==32){
            case 32:elem.dataType.add(DataTypes.FLOAT)
            default:elem.dataType.add(DataTypes.DOUBLE)
        } 
        return elem as TypeSpecifier
    }

    def static dispatch TypeSpecifier typeOf(BoolConstant e) {
        val elem = CoreDslFactory.eINSTANCE.createPodSpecifier
        elem.dataType.add(DataTypes.UNSIGNED)
        elem.dataType.add(DataTypes.INT)
        return elem as TypeSpecifier
    }

    def static dispatch TypeSpecifier typeOf(CharacterConstant e) {
        val elem = CoreDslFactory.eINSTANCE.createPodSpecifier
        elem.dataType.add(DataTypes.CHAR)
        return elem as TypeSpecifier
    }
    
    def static boolean isComparable(TypeSpecifier left, TypeSpecifier right){
        return true
    }

    def static boolean isAssignable(TypeSpecifier to, TypeSpecifier from){
        return true
    }
}
