/*
 * generated by Xtext 2.10.0
 */
package com.minres.coredsl.validation

import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.PrimaryExpression

import static extension com.minres.coredsl.typing.TypeProvider.*
import org.eclipse.xtext.validation.Check
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.Attribute
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.validation.KnownAttributes.AttributeUsage
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EStructuralFeature

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class CoreDslValidator extends AbstractCoreDslValidator {

	/*TODO: 
	 * * check for cycles in structs
	 * * check for member selection
	 * * check for return statements
	 * * check for duplicate fields
	 * 
	 */
	protected static val ISSUE_CODE_PREFIX = "com.minres.coredsl."
	public static val TYPE_MISMATCH = ISSUE_CODE_PREFIX + "TypeMismatch"
	public static val TYPE_ILLEGAL = ISSUE_CODE_PREFIX + "TypeIllegal"
	public static val ILLEGAL_ATTRIBUTE = ISSUE_CODE_PREFIX + "IllegalAttribute"
	public static val INVALID_ATTRIBUTE_PARAMETERS = ISSUE_CODE_PREFIX + "InvalidAttributeParameters"

	// @Check
	def checkType(Expression e) {
		switch (e) {
			case PrimaryExpression,
			case PostfixExpression,
			case PrefixExpression:
				if (e.typeFor === null)
					error(
						"incompatible types used",
						// TODO this doesn't necessarily make sense as a location
						CoreDslPackage.Literals.EXPRESSION__LEFT,
						TYPE_MISMATCH
					)
			case CastExpression: {
				if ((e as CastExpression).type.typeFor === null)
					error(
						"illegal type used",
						CoreDslPackage.Literals.CAST_EXPRESSION__TYPE,
						TYPE_ILLEGAL
					)
			}
			case InfixExpression: {
				val infix = e as InfixExpression
				switch (infix.op) {
					case '<',
					case '>',
					case '<=',
					case '>=',
					case '==',
					case '!=':
						if (!e.left.typeFor.isComparable((e as InfixExpression).right.typeFor))
							error(
								"incompatible types used",
								CoreDslPackage.Literals.INFIX_EXPRESSION__OP,
								TYPE_MISMATCH
							)
					case '||',
					case '&&',
					case '<<',
					case '>>',
					case '+',
					case '-',
					case '*',
					case '/',
					case '%',
					case '|',
					case '^',
					case '&':
						if (!e.left.typeFor.isComputable((e as InfixExpression).right.typeFor))
							error(
								"incompatible types used",
								CoreDslPackage.Literals.INFIX_EXPRESSION__OP,
								TYPE_MISMATCH
							)
					default: {
					} // '::'
				}
			}
//            case ConditionalExpression: {
//            }
//            case AssignmentExpression: {
//            }
		}
	}
	
	def checkAttributes(EList<Attribute> attributes, KnownAttributes.AttributeUsage expectedUsage, EStructuralFeature feature) {
		for(Attribute attribute : attributes) {
			val info = KnownAttributes.byName(attribute.type);
			
			if(info === null || !info.allowedUsage.contains(expectedUsage))
				error("unexpected attribute '" + attribute.type + "'", feature, ILLEGAL_ATTRIBUTE);
			
			if(attribute.parameters.size() !== info.paramCount)
				error("attribute '" + info.name + "' requires exactly " + info.paramCount + " parameter(s)", feature, INVALID_ATTRIBUTE_PARAMETERS);
		}
	}

	@Check
	def checkAttributeNames(ISA isa) {
		checkAttributes(isa.commonInstructionAttributes, KnownAttributes.AttributeUsage.instruction, CoreDslPackage.Literals.ISA__COMMON_INSTRUCTION_ATTRIBUTES);
	}

	@Check
	def checkAttributeNames(Instruction instr) {
		checkAttributes(instr.attributes, KnownAttributes.AttributeUsage.instruction, CoreDslPackage.Literals.INSTRUCTION__ATTRIBUTES);
	}

	@Check
	def checkAttributeNames(Declaration decl) {
		checkAttributes(decl.attributes, KnownAttributes.AttributeUsage.declaration, CoreDslPackage.Literals.DECLARATOR__ATTRIBUTES);
	}

	@Check
	def checkAttributeNames(Declarator decl) {
		checkAttributes(decl.attributes, KnownAttributes.AttributeUsage.declaration, CoreDslPackage.Literals.DECLARATOR__ATTRIBUTES);
	}

	@Check
	def checkAttributeNames(FunctionDefinition decl) {
		checkAttributes(decl.attributes, KnownAttributes.AttributeUsage.function, CoreDslPackage.Literals.FUNCTION_DEFINITION__ATTRIBUTES);
	}
}
