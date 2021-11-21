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
import com.minres.coredsl.coreDsl.DirectDeclarator
import com.minres.coredsl.coreDsl.EnumTypeSpecifier
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.FloatConstant
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.InitDeclarator
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.Postfix
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.PrimaryExpression
import com.minres.coredsl.coreDsl.StringLiteral
import com.minres.coredsl.coreDsl.Encoding
import com.minres.coredsl.coreDsl.Field
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.Constant
import com.minres.coredsl.coreDsl.Variable
import com.minres.coredsl.util.BigDecimalWithSize

import static extension com.minres.coredsl.interpreter.CoreDSLInterpreter.*
import static extension com.minres.coredsl.util.ModelUtil.*
import com.minres.coredsl.interpreter.EvaluationContext
import java.math.BigInteger
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.coreDsl.IntegerSignedness
import com.minres.coredsl.coreDsl.FloatTypeSpecifier
import com.minres.coredsl.util.TypedBigInteger

class TypeProvider {

	/* TODO: 
	 * * sub typing
	 * 
	 */
	public static val boolType = new IntegerType(1, false)

	def static boolean isPowerOfTwo(int x) {
		return((x.bitwiseAnd(x - 1)) == 0)
	}

	def static boolean isAligned(DataType dt) {
		val intType = dt as IntegerType
		return intType !== null && intType.bitSize >= 8 && isPowerOfTwo(intType.bitSize)
	}

	def static boolean isIntegral(DataType dt) {
		return dt instanceof IntegerType
	}

	def static boolean isSignedInteger(DataType dt) {
		return dt.isIntegral &&(dt as IntegerType).signed
	}

	def static boolean isUnsignedInteger(DataType dt) {
		return dt.isIntegral && !(dt as IntegerType).signed
	}

	def static boolean isFloat(DataType dt) {
		return dt instanceof FloatType
	}

	def static boolean isNumeric(DataType dt) {
		return dt.isIntegral || dt.isFloat
	}

	def static DataType resolveType(TypeSpecifier e) {
		e.resolveType(e.parentOfType(ISA))
	}

	def static DataType resolveType(DirectDeclarator e) {
		e.resolveType(e.parentOfType(ISA))
	}

	def static DataType resolveType(Expression e) {
		e.resolveType(e.parentOfType(ISA))
	}

	def static DataType resolveType(Constant e) {
		e.resolveType(e.parentOfType(ISA))
	}

	def static dispatch DataType resolveType(CompositeTypeSpecifier e, ISA ctx) {
		return new CompositeType()
	}

	def static dispatch DataType resolveType(EnumTypeSpecifier e, ISA ctx) {
		return new IntegerType(32, true)
	}

	def static dispatch DataType resolveType(FloatTypeSpecifier e, ISA ctx) {
		switch(e.shorthand) {
			case FLOAT: return new FloatType(32)
			case DOUBLE: return new FloatType(64)
		}
	}

	def static dispatch DataType resolveType(IntegerTypeSpecifier e, ISA ctx) {
		val signed = e.signedness === null || e.signedness === IntegerSignedness.SIGNED;
		if(e.size === null) {
			switch(e.shorthand) {
				case CHAR: return new IntegerType(8, signed)
				case SHORT: return new IntegerType(16, signed)
				case INT: return new IntegerType(32, signed)
				case LONG: return new IntegerType(64, signed)
			}
		}

		val sizeValue = e.size.valueFor(EvaluationContext.root(ctx));
		if(sizeValue === null || !(sizeValue.value instanceof BigInteger)) return null
		if(signed && (sizeValue.value as BigInteger).bitLength == 0) return null // signed<0> is invalid
		return new IntegerType((sizeValue.value as BigInteger).intValue, signed)
	}

	def dispatch static DataType resolveType(Expression e, ISA ctx) {
		val types = e.expressions.map[expr|expr.resolveType(ctx)]
		val first = types.findFirst[it === null]
		if(first !== null)
			return null
		return types.head
	}

	def static dispatch DataType resolveType(AssignmentExpression e, ISA ctx) {
		return e.assignments.last.right.resolveType(ctx)
	}

	def static dispatch DataType resolveType(ConditionalExpression e, ISA ctx) {
		return e.left.resolveType(ctx)
	}

	// https://github.com/Minres/CoreDSL/wiki/Expressions#arithmetic-type-rules
	def static dispatch DataType resolveType(InfixExpression e, ISA ctx) {
		switch(e.op) {
			case "||",
			case "&&",
			case "==",
			case "!=",
			case "<",
			case ">",
			case "<=",
			case ">=":
				return boolType
				
			case '|',
			case "&",
			case "^": {
				val l = e.left.resolveType(ctx)
				val r = e.right.resolveType(ctx)

				if(l === null || r === null) return null

				if(l.isIntegral && r.isIntegral) {
					val li = l as IntegerType
					val ri = l as IntegerType
					
					return new IntegerType(Math.max(li.bitSize, ri.bitSize), li.signed || ri.signed)
				}
			}
			
			case "<<",
			case ">>": {
				val l = e.left.resolveType(ctx)
				val r = e.right.resolveType(ctx)

				if(l === null || r === null) return null

				if(l.isIntegral && r.isIntegral) {
					return l
				}
			}
			
			case '+',
			case '-': {
				val l = e.left.resolveType(ctx)
				val r = e.right.resolveType(ctx)
				
				if(l === null || r === null) return null
				
				if(l.isIntegral && r.isIntegral) {
					val li = l as IntegerType
					val ri = r as IntegerType
					
					if(li.signed == ri.signed)
						return new IntegerType(Math.max(li.bitSize, ri.bitSize) + 1, li.signed || e.op == '-')
					
					val int signedWidth = li.signed ? li.bitSize : ri.bitSize;
					val int unsignedWidth = li.signed ? ri.bitSize : li.bitSize;
					
					val int resultWidth = signedWidth > unsignedWidth ? signedWidth + 1 : unsignedWidth + 2
					return new IntegerType(resultWidth, true)
				}
			}
			
			case '*': {
				val l = e.left.resolveType(ctx)
				val r = e.right.resolveType(ctx)
				
				if(l === null || r === null) return null
				
				if(l.isIntegral && r.isIntegral) {
					val li = l as IntegerType
					val ri = r as IntegerType
					
					return new IntegerType(li.bitSize + ri.bitSize, li.signed || ri.signed)
				}
			}
			
			case '/': {
				val l = e.left.resolveType(ctx)
				val r = e.right.resolveType(ctx)
				
				if(l === null || r === null) return null
				
				if(l.isIntegral && r.isIntegral) {
					val li = l as IntegerType
					val ri = r as IntegerType
					
					return new IntegerType(ri.signed ? li.bitSize + 1 : li.bitSize, li.signed || ri.signed)
				}
			}
			
			case '%': {
				val l = e.left.resolveType(ctx)
				val r = e.right.resolveType(ctx)
				
				if(l === null || r === null) return null
				
				if(l.isIntegral && r.isIntegral) {
					val li = l as IntegerType
					val ri = r as IntegerType
					
					if(li.signed == ri.signed)
						return new IntegerType(Math.min(li.bitSize, ri.bitSize), li.signed)
					
					return new IntegerType(Math.min(li.bitSize, li.signed ? ri.bitSize + 1 : ri.bitSize - 1), li.signed)
				}
			}
		}
		
		return null
	}

	def static dispatch DataType resolveType(CastExpression e, ISA ctx) {
		return e.type.resolveType(ctx)
	}

	def static dispatch DataType resolveType(PrefixExpression e, ISA ctx) {
		switch(e.op) {
			case "++",
			case "--": {
				val l = e.left.resolveType(ctx)
				
				if(l === null || !l.isIntegral) return null
				
				return l
			}
			
			case "~": {
				val l = e.left.resolveType(ctx)
				
				if(l === null || !l.isIntegral) return null
				
				return l
			}
			
			case "!":
				return boolType
				
			case "+": {
				val l = e.left.resolveType(ctx)
				
				if(l === null || !l.isIntegral) return null
				
				return l
			}
			
			case "-": {
				val l = e.left.resolveType(ctx)
				
				if(l === null || !l.isIntegral) return null
				
				val li = l as IntegerType
				return li.signed ? li : new IntegerType(li.bitSize + 1, true)
			}
			
			case "sizeof":
				// TODO determine the actual size here and only return as many bits as needed.
				// TODO does this return the size in bits or bytes?
				new IntegerType(32, false)
			
			default: // TODO missing case "&", case "*"
				return null
		}
	}

	def static dispatch DataType resolveType(PostfixExpression e, ISA ctx) {
		switch(e.postOp.op) {
			case ".",
			case "->":
				e.postOp.resolveType(ctx)
			default:
				e.left.resolveType(ctx) ?: e.postOp.resolveType(ctx)
		}
	}

	def static dispatch DataType resolveType(Postfix e, ISA ctx) {
		if(e.right !== null)
			switch(e.right.op) {
				case ".",
				case "->": return e.right.resolveType(ctx)
			}
		switch(e.op) {
			case ".",
			case "->":
				e.declarator.resolveType(ctx)
			default:
				null
		}
	}

	def static dispatch DataType resolveType(PrimaryExpression e, ISA ctx) {
		if(e.constant !== null) {
			e.constant.resolveType(ctx)
		} else if(e.ref !== null) {
			e.ref.resolveType(ctx)
		} else if(e.left !== null) {
			e.left.resolveType(ctx)
		} else if(e.literal.size > 0) {
			throw new UnsupportedOperationException
		} else
			return null
	}

	def static dispatch DataType resolveType(Variable e, ISA ctx) {
		null
	}

	def static dispatch DataType resolveType(FunctionDefinition e, ISA ctx) {
		e.type.resolveType(ctx)
	}

	def static dispatch DataType resolveType(DirectDeclarator e, ISA ctx) {
		if(e.eContainer instanceof InitDeclarator && e.eContainer.eContainer instanceof Declaration) {
			var decl = e.eContainer.eContainer as Declaration
			decl.type.resolveType(ctx)
		} else
			null
	}

	def static dispatch DataType resolveType(Encoding list, ISA ctx) {
		var size = 0
		for(Field f : list.fields)
			switch(f) {
				BitField: {
					size += f.left.value.intValue - f.right.value.intValue + 1
				}
				BitValue: {
					size += (f.value as TypedBigInteger).type.bitSize
				}
			}
		new IntegerType(size, false)
	}

	def static dispatch DataType resolveType(BitField e, ISA ctx) {
		new IntegerType(e.left.value.intValue + 1, false)
	}

	def static dispatch DataType resolveType(BitValue e, ISA ctx) {
		new IntegerType((e.value as TypedBigInteger).type.bitSize, false)
	}

	def static dispatch DataType resolveType(IntegerConstant e, ISA ctx) {
		return (e.value as TypedBigInteger).type
	}

	def static dispatch DataType resolveType(FloatConstant e, ISA ctx) {
		new FloatType((e.value as BigDecimalWithSize).size)
	}

	def static dispatch DataType resolveType(BoolConstant e, ISA ctx) {
		boolType
	}

	def static dispatch DataType resolveType(CharacterConstant e, ISA ctx) {
		new IntegerType(0, false)
	}

	def static dispatch DataType resolveType(StringLiteral e, ISA ctx) {
		new ReferenceOrPointerType(new IntegerType(8, false))
	}

	def static boolean isImplicitlyConvertibleTo(IntegerType from, IntegerType to) {
		// implicit casts with the same signedness must not truncate the value
		if(to.signed == from.signed)
			return to.bitSize >= from.bitSize

		// implicit cast from unsigned to signed type requires at least one extra bit
		if(to.signed && !from.signed)
			return to.bitSize > from.bitSize

		// implicit cast from signed type to unsigned type is always invalid
		return false
	}

	def static boolean isImplicitlyConvertibleTo(DataType from, DataType to) {
		if(from === null || to === null) return false
		if(from == to) return true
		if(from.isIntegral && to.isIntegral) {
			return isImplicitlyConvertibleTo(from as IntegerType, to as IntegerType)
		}
		if(to.isFloat) {
			// TODO can integer types be implicitly cast to float types?
			//if(from.isIntegral) return true
			if(from.isFloat)
				return (to as FloatType).bitSize >= (from as FloatType).bitSize 
		}
		return false
	}

	def static boolean isExplicitlyConvertibleTo(DataType from, DataType to) {
		if(from.isImplicitlyConvertibleTo(to)) return true
		if(from.isNumeric && to.isNumeric) return true
		return false
	}

	def static boolean isAssignableTo(DataType from, DataType to) {
		return from.isImplicitlyConvertibleTo(to)
	}
}
