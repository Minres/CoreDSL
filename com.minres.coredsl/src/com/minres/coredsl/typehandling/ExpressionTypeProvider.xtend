package com.minres.coredsl.typehandling

import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.BooleanExpr
import com.minres.coredsl.coreDsl.BitExpr
import com.minres.coredsl.coreDsl.ComparisonExpr
import com.minres.coredsl.coreDsl.AdditionExpr
import com.minres.coredsl.coreDsl.MultiplicationExpr
import com.minres.coredsl.coreDsl.UnitaryExpr
import com.minres.coredsl.coreDsl.TypeConv
import com.minres.coredsl.coreDsl.Function
import com.minres.coredsl.coreDsl.NumberLiteral
import com.minres.coredsl.coreDsl.ValueRef
import com.minres.coredsl.coreDsl.RegisterFile
import com.minres.coredsl.coreDsl.AddressSpace
import com.minres.coredsl.coreDsl.Register
import com.minres.coredsl.coreDsl.RegisterAlias
import com.minres.coredsl.coreDsl.Scalar
import com.minres.coredsl.coreDsl.Constant
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.DataType
import com.minres.coredsl.coreDsl.ShiftExpr

class ExpressionTypeProvider {
	
	def dispatch DataType typeFor(Expression e){
        switch(e){
            BooleanExpr: return DataType.BOOLEAN
            BitExpr: {
				val leftType=e.left.typeFor
				if(e.op=="<<" || e.op==">>") return e.left.typeFor
	            if(leftType == e.right.typeFor && (leftType==DataType.SIGNED || leftType==DataType.UNSIGNED)) 
	            	return leftType
	        	else
	        		return DataType.NONE
    		}
            ComparisonExpr: return DataType.BOOLEAN
            ShiftExpr: {
				val leftType=e.left.typeFor
	            if(leftType == e.right.typeFor && (leftType==DataType.SIGNED || leftType==DataType.UNSIGNED)) 
	            	return leftType
	        	else
	        		return DataType.NONE
	        		
    		}
            AdditionExpr: {
				val leftType=e.left.typeFor
	            if(leftType == e.right.typeFor && leftType!=DataType.BOOLEAN && leftType!=DataType.NONE) 
	            	return leftType
	        	else
	        		return DataType.NONE
    		}
            MultiplicationExpr: {
				val leftType=e.left.typeFor
	            if(leftType == e.right.typeFor && leftType!=DataType.BOOLEAN && leftType!=DataType.NONE) 
	            	return leftType
	        	else
	        		return DataType.NONE
    		}
            UnitaryExpr:
            	if(e.op=='!')
            		return DataType.BOOLEAN
            	else if(e.expr.typeFor==DataType.SIGNED)
            		return DataType.SIGNED 
            	else if(e.expr.typeFor==DataType.UNSIGNED)
            		return DataType.UNSIGNED
            	else
            		return DataType.NONE 
            TypeConv: return e.type
            Function: return DataType.UNSIGNED
            NumberLiteral: return DataType.UNSIGNED
            default:       return DataType.NONE
        }
	}
	
	def dispatch DataType typeFor(ValueRef e){
		val ref = e.value
		switch (ref) {
			RegisterFile: return DataType.UNSIGNED
			AddressSpace: return DataType.UNSIGNED
			Register: return DataType.UNSIGNED
			RegisterAlias: return DataType.UNSIGNED
			Scalar: return DataType.UNSIGNED
			Constant: return DataType.UNSIGNED
			BitField: if(ref.type!=DataType.NONE) return ref.type else return DataType.UNSIGNED
			default: DataType.NONE
		}			
	}
}