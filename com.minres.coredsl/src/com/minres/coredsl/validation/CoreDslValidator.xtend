/*
 * generated by Xtext 2.10.0
 */
package com.minres.coredsl.validation

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.typehandling.ExpressionTypeProvider
import com.minres.coredsl.typehandling.ExpressionUtilsProvider
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.validation.Check

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class CoreDslValidator extends AbstractCoreDslValidator {
	
	@Inject extension ExpressionTypeProvider
	
	@Inject extension ExpressionUtilsProvider

	protected static val ISSUE_CODE_PREFIX = "com.minres.coredsl."
	public static val FORWARD_REFERENCE = ISSUE_CODE_PREFIX + "ForwardReference"
	public static val TYPE_MISMATCH = ISSUE_CODE_PREFIX + "TypeMismatch"
	public static val SHADOWING_NAME = ISSUE_CODE_PREFIX + "NameShadow"
	
//	static val typeLookup = newHashMap(
//		DataType.NONE ->"undefined",
//		DataType.UNSIGNED ->"unsigned",
//		DataType.SIGNED ->"signed",
//		DataType.FLOAT ->"float",
//		DataType.DOUBLE ->"double",
//		DataType.QUAD ->"quad",
//		DataType.BOOLEAN ->"bool"
//	)
//	val integerTypes=<DataType>newArrayList(DataType.SIGNED, DataType.UNSIGNED)
//	val arithemeticTypes=<DataType>newArrayList(DataType.SIGNED, DataType.UNSIGNED, DataType.FLOAT, DataType.DOUBLE, DataType.QUAD)
	
//	@Check
//	def checkType(Expression e) {
//        switch(e){
//            BooleanExpr:{
//            	checkExpectedType(e.left, DataType.BOOLEAN, CoreDslPackage.Literals.BOOLEAN_EXPR__LEFT)
//            	checkExpectedType(e.right, DataType.BOOLEAN, CoreDslPackage.Literals.BOOLEAN_EXPR__LEFT)
//            } 
//            BitExpr: {
//            	checkExpectedSame(e.left.typeFor, e.right.typeFor, CoreDslPackage.Literals.BIT_EXPR)
//	        		
//    		}
//            ComparisonExpr:
//            	checkExpectedSame(e.left.typeFor, e.right.typeFor, CoreDslPackage.Literals.COMPARISON_EXPR)
//            ShiftExpr: {
//            	checkExpectedType(e.left, integerTypes, CoreDslPackage.Literals.SHIFT_EXPR__LEFT)
//            	checkExpectedType(e.right, DataType.UNSIGNED, CoreDslPackage.Literals.SHIFT_EXPR__RIGHT)
//    		}
//            AdditionExpr: {
//            	checkExpectedType(e.left, arithemeticTypes, CoreDslPackage.Literals.ADDITION_EXPR__LEFT)
//            	checkExpectedType(e.right, arithemeticTypes, CoreDslPackage.Literals.ADDITION_EXPR__RIGHT)
//            	checkExpectedSame(e.left.typeFor, e.right.typeFor, CoreDslPackage.Literals.ADDITION_EXPR)
//    		}
//            MultiplicationExpr: {
//            	checkExpectedType(e.left, arithemeticTypes, CoreDslPackage.Literals.MULTIPLICATION_EXPR__LEFT)
//            	checkExpectedType(e.right, arithemeticTypes, CoreDslPackage.Literals.MULTIPLICATION_EXPR__RIGHT)
//            	checkExpectedSame(e.left.typeFor, e.right.typeFor, CoreDslPackage.Literals.MULTIPLICATION_EXPR)
//    		}
//            UnitaryExpr:{
//            	if(e.op=='!')
//            		checkExpectedType(e.expr, DataType.BOOLEAN, CoreDslPackage.Literals.UNITARY_EXPR__EXPR)
//            	else if(e.op=='~')
//            		checkExpectedType(e.expr,integerTypes, CoreDslPackage.Literals.UNITARY_EXPR__EXPR)
//            	else
//            		checkExpectedType(e.expr, arithemeticTypes, CoreDslPackage.Literals.UNITARY_EXPR__EXPR)
//    		} 
//            TypeConv:
//            	checkExpectedType(e.expr, integerTypes, CoreDslPackage.Literals.TYPE_CONV__EXPR)
//        }
//	}
//
//	@Check
//	def checkDupicateName(Assignment e) {
//		val symbols=symbolsDefinedBefore( e, e.to)
//		val res = symbols.filter[ if(it instanceof Variable) it.name.equals(e.to.name) else if(it instanceof RValue) it.name.equals(e.to.name) else false]
//		if(res.size>0)
//			warning("The name '"+e.to.name+"' shadows and existing declaration which might lead to gneration issues",
//				CoreDslPackage.Literals.SCALAR_ASSIGNMENT__TO,
//				SHADOWING_NAME
//			)
//	}
		
//	@Check
//	def checkForwardReferences(ValueRef e) {
//		val symbols=symbolsDefinedBefore( e.eContainer, e)
//		val res = symbols.filter[it === e.value]
//		if(res.size==0)
//			error("Forward references are not allowed",
//				CoreDslPackage.Literals.VALUE_REF__VALUE,
//				FORWARD_REFERENCE
//			)
//	}
		
//	def checkExpectedType(Expression expression, DataType expectedType, EReference reference) {
//		val actualType = getTypeAndCheckNotNull(expression, reference)
//		if (actualType != expectedType)
//			error(
//				"expected type " + typeLookup.get(expectedType) + ", but but the actual type is " + typeLookup.get(actualType),
//				reference,
//				TYPE_MISMATCH
//			)
//	}
//
//	def checkExpectedType(Expression expression, List<DataType> expectedTypes, EReference reference) {
//		val actualType = getTypeAndCheckNotNull(expression, reference)
//		if (expectedTypes.filter[it==actualType].empty)
//			error(
//				"expected a type of [" + expectedTypes.map[typeLookup.get(it)].join(", ") + "], but the actual type is " + typeLookup.get(actualType),
//				reference,
//				TYPE_MISMATCH
//			)
//	}

//	def checkExpectedSame(DataType left, DataType right, EClass clazz) {
//		if (right !== null && left !== null && right != left) {
//			error("expected the same type on both sides, but left is " + typeLookup.get(left) + " and right is " + typeLookup.get(right), clazz.getEIDAttribute(), TYPE_MISMATCH)
//		}
//	}

//	def private DataType getTypeAndCheckNotNull(Expression exp, EReference reference) {
//		val type = exp?.typeFor
//		if (type === null)
//			error("null type", reference, TYPE_MISMATCH)
//		return type;
//	}
}
