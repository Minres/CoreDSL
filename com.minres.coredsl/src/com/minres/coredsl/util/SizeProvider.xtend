package com.minres.coredsl.util

import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BoolConstant
import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.CharacterConstant
import com.minres.coredsl.coreDsl.ConditionalExpression
import com.minres.coredsl.coreDsl.DirectDeclarator
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.FloatingConstant
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.PrimaryExpression

class SizeProvider {

    def static dispatch Integer sizeOf(PrimaryExpression e) {
        return null
    }
    
    def static dispatch Integer sizeOf(PostfixExpression e) {
        return null
    }

    def static dispatch Integer sizeOf(PrefixExpression e) {
        return null
    }

    def static dispatch Integer sizeOf(CastExpression e) {
        return null
    }

    def static dispatch Integer sizeOf(InfixExpression e) {
        return null
    }

    def static dispatch Integer sizeOf(AssignmentExpression e) {
        return null
    }

    def static dispatch Integer sizeOf(ConditionalExpression e) {
        return null
    }

    def dispatch static Integer sizeOf(Expression e) {
        return null
    }

    def static dispatch Integer sizeOf(FunctionDefinition e) {
        return null
    }

    def static dispatch Integer sizeOf(DirectDeclarator e) {
        return null
    }

    def static dispatch Integer sizeOf(BitField e) {
        return null
    }

    def static dispatch Integer sizeOf(IntegerConstant e) {
        return null
    }

    def static dispatch Integer sizeOf(FloatingConstant e) {
        return null
    }

    def static dispatch Integer sizeOf(BoolConstant e) {
        return null
    }

    def static dispatch Integer sizeOf(CharacterConstant e) {
        return null
    }
}
