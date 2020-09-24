package com.minres.coredsl.typehandling

import com.minres.coredsl.coreDsl.AdditionExpr
import com.minres.coredsl.coreDsl.BitExpr
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BooleanExpr
import com.minres.coredsl.coreDsl.ComparisonExpr
import com.minres.coredsl.coreDsl.Constant
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.Function
import com.minres.coredsl.coreDsl.MultiplicationExpr
import com.minres.coredsl.coreDsl.NumberLiteral
import com.minres.coredsl.coreDsl.Scalar
import com.minres.coredsl.coreDsl.TypeConv
import com.minres.coredsl.coreDsl.UnitaryExpr
import com.minres.coredsl.coreDsl.ValueRef
import com.minres.coredsl.coreDsl.Variable
import org.eclipse.emf.ecore.EObject
import com.minres.coredsl.coreDsl.ShiftExpr
import java.util.List
import com.minres.coredsl.coreDsl.ConditionalStmt
import org.eclipse.xtext.EcoreUtil2
import com.minres.coredsl.coreDsl.IndexedVariable
import com.minres.coredsl.coreDsl.RegisterVariable
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.Operation
import com.minres.coredsl.coreDsl.Statement
import com.minres.coredsl.coreDsl.ScalarAssignment
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.Register
import com.minres.coredsl.coreDsl.RegAttribute
import com.minres.coredsl.coreDsl.RegisterAlias

class ExpressionUtilsProvider {
    enum Determination {
		HOST,
		TARGET
	}

	def Boolean isDetermined(Expression e) {
		switch (e) {
			BooleanExpr:
				return e.left.isDetermined && e.right.isDetermined
			BitExpr:
				return e.left.isDetermined && e.right.isDetermined
			ComparisonExpr:
				return e.left.isDetermined && e.right.isDetermined
			ShiftExpr:
				return e.left.isDetermined && e.right.isDetermined
			AdditionExpr:
				return e.left.isDetermined && e.right.isDetermined
			MultiplicationExpr:
				return e.left.isDetermined && e.right.isDetermined
			UnitaryExpr:
				return e.expr.isDetermined
			TypeConv:
				return e.expr.isDetermined
			NumberLiteral:
				return true
			Function:
				switch(e.name){
					case 'sext',
					case 'zext',
					case 'shll',
					case 'shrl',
					case 'shra':{
						return e.args.get(0).isDetermined	
					}
					case 'choose': {
						return e.args.get(1).isDetermined && e.args.get(2).isDetermined 
					}
					default:{
						return if (e.args.size > 0)
							e.args.map[Expression a|a.isDetermined].reduce[p1, p2|p1 && p2]
						else
							false
					}
				}
			ValueRef:
				return e.value.isDetermined
			default:
				return false
		}
	}

	def boolean isDetermined(EObject e) {
		switch (e) {
			BitField: return true
			Constant: return true
			Scalar: return e.determined
			RegisterVariable: return e.isPc
			Variable: return false
			default: return false
		}
	}
	
	def boolean isPc(RegisterVariable register){
		switch(register){
			Register:return register.attributes.findFirst[it === RegAttribute.PC] !== null
			RegisterAlias: return (register.original as Register).attributes.findFirst[it === RegAttribute.PC] !== null
			default: return false
		}
	}
    
	def dispatch List<EObject> symbolsDefinedBefore(EObject cont, EObject o){
		cont.eContainer.symbolsDefinedBefore(o.eContainer)
	}

	def dispatch List<EObject>  symbolsDefinedBefore(ConditionalStmt stmt, EObject o){
		if(stmt.cond === o){
			return stmt.eContainer.symbolsDefinedBefore(o.eContainer)
		} else	if(stmt.thenStmts.contains(o)){
	  		val res = <EObject>newArrayList()
	  		res.addAll(stmt.thenStmts.localsDefinedBefore(o))
	  		res.addAll(stmt.eContainer.symbolsDefinedBefore(o.eContainer))
			return res
		} else if(stmt.elseStmts.size>0){
	  		val res = <EObject>newArrayList()
	  		res.addAll(stmt.elseStmts.localsDefinedBefore(o))
	  		res.addAll(stmt.eContainer.symbolsDefinedBefore(o.eContainer))
			return res
		}
	}

	def dispatch List<EObject>  symbolsDefinedBefore(Operation oper, EObject o){
	  	val isa = oper.parentOfType(ISA) as ISA
	  	val inst = oper.eContainer as Instruction
	  	val res = <EObject>newArrayList()
	  	res.addAll(oper.statements.localsDefinedBefore(o))
	  	res.addAll(isa.allOfType(IndexedVariable).toList)
	  	res.addAll(isa.allOfType(RegisterVariable).toList)
	  	res.addAll(isa.allOfType(Constant).toList)
	  	res.addAll(EcoreUtil2.getAllContentsOfType(inst, BitField))
		return res
	}

	def private List<EObject> localsDefinedBefore(List<Statement> list, EObject o){
		val idx = list.indexOf(o)
		return <EObject>newArrayList(list.subList(0, idx).filter(typeof(ScalarAssignment)).map[ScalarAssignment a| a.to])
	}
	
	def <T extends EObject> T parentOfType(EObject obj, Class<T> clazz){
		if(obj.eContainer===null)
			return null
		if(clazz.isInstance(obj.eContainer))
			return obj.eContainer as T
		return obj.eContainer.parentOfType(clazz)
	}
	
 	def <T extends EObject> Iterable<T> allOfType(ISA isa, Class<T> clazz){
		if(isa.eIsProxy) 
			EcoreUtil2.resolveAll(isa)		
		switch(isa){
			CoreDef:{
				if(isa.contributingType === null)
					return EcoreUtil2.getAllContentsOfType(isa, clazz)
				else
					return EcoreUtil2.getAllContentsOfType(isa, clazz) +  isa.contributingType.map[it.allOfType(clazz)].flatten
			}
			InstructionSet: {
				if(isa.superType === null)
					return EcoreUtil2.getAllContentsOfType(isa, clazz)
				else {
					return EcoreUtil2.getAllContentsOfType(isa, clazz) +  isa.superType.allOfType(clazz)				
				}
			}
		}
	}
    
}