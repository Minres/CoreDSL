package com.minres.coredsl.scoping

import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.CompoundStatement
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DeclarationStatement
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.EntityReference
import com.minres.coredsl.coreDsl.EnumTypeDeclaration
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.ForLoop
import com.minres.coredsl.coreDsl.FunctionCallExpression
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.IntrinsicExpression
import com.minres.coredsl.coreDsl.MemberAccessExpression
import com.minres.coredsl.coreDsl.NamedEntity
import com.minres.coredsl.coreDsl.ParenthesisExpression
import com.minres.coredsl.coreDsl.StructTypeDeclaration
import com.minres.coredsl.coreDsl.StructTypeSpecifier
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.UnionTypeDeclaration
import com.minres.coredsl.coreDsl.UnionTypeSpecifier
import com.minres.coredsl.coreDsl.UserTypeDeclaration
import java.util.HashSet
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes

import static extension com.minres.coredsl.util.DataExtensions.*
import static extension com.minres.coredsl.util.ModelExtensions.*
import com.minres.coredsl.coreDsl.IndexAccessExpression

class CoreDslScopeProvider extends AbstractCoreDslScopeProvider {
// Possible references:
//   InstructionSet.superType
//   CoreDef.providedInstructionSets
//   StructTypeSpecifier.target
//   UnionTypeSpecifier.target
//   EnumTypeSpecifier.target
//   MemberAccessExpression.declarator
//   EntityReference.target
	override IScope getScope(EObject context, EReference reference) {

		//println('''Trying to resolve «reference.EType.name» «(reference.eContainer as EClass).name».«reference.name» on «context.eClass.name»''');

		switch (reference) {
			case CoreDslPackage.Literals.ISA__PROVIDED_INSTRUCTION_SETS,
			case CoreDslPackage.Literals.INSTRUCTION_SET__SUPER_TYPE: {
				return getIsaScope(context, reference);
			}
			case CoreDslPackage.Literals.STRUCT_TYPE_SPECIFIER__TARGET: {
				return getStructTypeScope(context);
			}
			case CoreDslPackage.Literals.UNION_TYPE_SPECIFIER__TARGET: {
				return getUnionTypeScope(context);
			}
			case CoreDslPackage.Literals.ENUM_TYPE_SPECIFIER__TARGET: {
				return getEnumTypeScope(context);
			}
			case CoreDslPackage.Literals.MEMBER_ACCESS_EXPRESSION__DECLARATOR: {
				return getMemberScope(context);
			}
			case CoreDslPackage.Literals.ENTITY_REFERENCE__TARGET: {
				return getNamedEntityScope(context, null);
			}
		}

		return IScope.NULLSCOPE;
	}

	def private IScope getIsaScope(EObject context, EReference reference) {
		val importedScope = super.getScope(context, reference);
		val description = context.ancestorOfTypeOrSelf(DescriptionContent);
		return Scopes.scopeFor(description.definitions.filter(InstructionSet), importedScope);
	}

	def private static Iterable<UserTypeDeclaration> getTypeScope(EObject context) {
		return context.ancestorOfTypeOrSelf(ISA).elaborationOrder.flatMap[it.typeDeclarations];
	}

	def private static IScope getStructTypeScope(EObject context) {
		return Scopes.scopeFor(getTypeScope(context).filter(StructTypeDeclaration));
	}

	def private static IScope getUnionTypeScope(EObject context) {
		return Scopes.scopeFor(getTypeScope(context).filter(UnionTypeDeclaration));
	}

	def private static IScope getEnumTypeScope(EObject context) {
		return Scopes.scopeFor(getTypeScope(context).filter(EnumTypeDeclaration));
	}

	/**
	 * Finds the type specifier determining the type of the expression, if such a specifier exists.
	 * Applicable to entity references targeting a declarator, member accesses, function calls and type casts.
	 * */
	def private static TypeSpecifier findTypeSpecifier(Expression expression) {
		switch (expression) {
			ParenthesisExpression: {
				return findTypeSpecifier(expression.inner);
			}
			EntityReference: {
				val declarator = expression.target.castOrNull(Declarator);
				return declarator?.type;
			}
			MemberAccessExpression: {
				val declarator = expression.declarator;
				return declarator?.type;
			}
			IndexAccessExpression: {
				return findTypeSpecifier(expression.target);
			}
			FunctionCallExpression: {
				val function = expression.target.castOrNull(FunctionDefinition);
				return function?.returnType;
			}
			CastExpression: {
				return expression.targetType;
			}
		}
	}

	/**
	 * Returns the members of the specified type, or null if it is not a composite type
	 */
	def private static Iterable<Declarator> getTypeMembers(TypeSpecifier typeSpecifier) {
		switch (typeSpecifier) {
			StructTypeSpecifier: {
				val typeDeclaration = typeSpecifier.target;
				if(typeDeclaration === null) return null;

				return typeDeclaration.members.flatMap[it.declarators];
			}
			UnionTypeSpecifier: {
				val typeDeclaration = typeSpecifier.target;
				if(typeDeclaration === null) return null

				return typeDeclaration.members.flatMap[it.declarators];
			}
			default: {
				return null;
			}
		}
	}

	def private static IScope getTypeMemberScope(TypeSpecifier typeSpecifier) {
		val members = getTypeMembers(typeSpecifier);
		return members !== null ? Scopes.scopeFor(members) : IScope.NULLSCOPE;
	}

	def private static IScope getMemberScope(EObject context) {
		val memberAccess = context.castOrNull(MemberAccessExpression);
		if(memberAccess === null) return IScope.NULLSCOPE;

		val typeSpecifier = findTypeSpecifier(memberAccess.target);
		if(typeSpecifier === null) return IScope.NULLSCOPE;

		return getTypeMemberScope(typeSpecifier);
	}

	def private static IScope getParentNamedEntityScope(EObject context) {
		return getNamedEntityScope(context.eContainer, context);
	}

	def private static dispatch IScope getNamedEntityScope(ForLoop context, EObject child) {
		if(child !== null && child.eContainingFeature === CoreDslPackage.Literals.FOR_LOOP__START_DECLARATION) {
			return getParentNamedEntityScope(context);
		}

		if(context.startDeclaration !== null) {
			return Scopes.scopeFor(context.startDeclaration.declarators, getParentNamedEntityScope(context));
		} else {
			return Scopes.scopeFor(#[], getParentNamedEntityScope(context));
		}
	}

	def private static dispatch IScope getNamedEntityScope(Declaration context, EObject child) {
		if(child == context.type) return getParentNamedEntityScope(context);
		return Scopes.scopeFor(context.declarators.takeWhile[it !== child], getParentNamedEntityScope(context));
	}

	def private static Iterable<NamedEntity> getDeclarationsTransitive(InstructionSet iset) {
		return getDeclarationsTransitive(iset, new HashSet());
	}

	def private static Iterable<NamedEntity> getDeclarationsTransitive(InstructionSet isa,
		HashSet<InstructionSet> seen) {
		if(!seen.add(isa)) return #[]; // recursion error
		
		val declarations = isa.archStateBody.filter(DeclarationStatement).flatMap[it.declaration.declarators];
		val enumMembers = isa.typeDeclarations.filter(EnumTypeDeclaration).flatMap[it.members];
		val functions = isa.functions;
		
		val entities = declarations + enumMembers + functions;
		return isa.superType !== null ? entities + getDeclarationsTransitive(isa.superType) : entities;
	}

	def private static dispatch IScope getInheritedScope(CoreDef core) {
		val declarations = core.providedInstructionSets.flatMap[getDeclarationsTransitive(it)];
		val seen = new HashSet();
		return Scopes.scopeFor(declarations.filter[seen.add(it)]);
	}

	def private static dispatch IScope getInheritedScope(InstructionSet iset) {
		if(iset.superType !== null)
			return Scopes.scopeFor(getDeclarationsTransitive(iset.superType))
		val declarations = iset.providedInstructionSets.flatMap[getDeclarationsTransitive(it)];
		val seen = new HashSet();
		return Scopes.scopeFor(declarations.filter[seen.add(it)]);
	}

	def private static dispatch IScope getNamedEntityScope(ISA context, EObject child) {
		val declarations = context.archStateBody //
		.takeWhile[it !== child] //
		.filter(DeclarationStatement) //
		.flatMap[it.declaration.declarators];
		val enumMembers = context.typeDeclarations.filter(EnumTypeDeclaration).flatMap[it.members];
		return Scopes.scopeFor(declarations + enumMembers + context.functions, getInheritedScope(context));
	}

	def private static dispatch IScope getNamedEntityScope(CompoundStatement context, EObject child) {
		val newDeclarations = context.statements //
		.takeWhile[it !== child] //
		.filter(DeclarationStatement) //
		.flatMap[it.declaration.declarators];
		return Scopes.scopeFor(newDeclarations, getParentNamedEntityScope(context));
	}

	def private static dispatch IScope getNamedEntityScope(FunctionDefinition context, EObject child) {
		return Scopes.scopeFor(context.parameters.flatMap[it.declarators], getParentNamedEntityScope(context));
	}

	def private static dispatch IScope getNamedEntityScope(Instruction context, EObject child) {
		return Scopes.scopeFor(context.encoding.fields.filter(BitField), getParentNamedEntityScope(context));
	}

	def private static dispatch IScope getNamedEntityScope(IntrinsicExpression context, EObject child) {
		if((context.function == 'offsetof' || context.function == 'bitoffsetof') && context.arguments.size == 2 && child === context.arguments.get(1)) {
			val arg1 = context.arguments.get(0);
			val arg2 = context.arguments.get(1);
			if(arg2 instanceof EntityReference) {
				switch (arg1) {
					Expression: {
						val typeSpecifier = findTypeSpecifier(arg1);
						if(typeSpecifier === null) return IScope.NULLSCOPE;

						return getTypeMemberScope(typeSpecifier);
					}
					TypeSpecifier: {
						return getTypeMemberScope(arg1);
					}
				}
			}
			return IScope.NULLSCOPE;
		}
		return getParentNamedEntityScope(context);
	}

	def private static dispatch IScope getNamedEntityScope(EObject context, EObject child) {
		return getParentNamedEntityScope(context);
	}
}
