package com.minres.coredsl.util

import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DeclarationStatement
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.EnumTypeDeclaration
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.StructTypeDeclaration
import com.minres.coredsl.coreDsl.TypeQualifier
import com.minres.coredsl.coreDsl.UnionTypeDeclaration
import com.minres.coredsl.coreDsl.UserTypeDeclaration
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import org.eclipse.emf.ecore.EObject

import static extension com.minres.coredsl.util.DataExtensions.*

abstract class ModelExtensions {
	private new() {
	}

	static def <T extends EObject> T ancestorOfType(EObject obj, Class<T> type) {
		return ancestorOfTypeOrSelf(obj.eContainer, type);
	}

	static def <T extends EObject> T ancestorOfTypeOrSelf(EObject obj, Class<T> type) {
		var cur = obj;
		while(cur !== null) {
			if(type.isInstance(cur)) return cur as T;
			cur = cur.eContainer;
		}
		return null;
	}

	static def boolean isDescendantOf(EObject obj, EObject potentialAncestor) {
		return isDescendantOf(obj.eContainer, potentialAncestor);
	}

	static def boolean isDescendantOfOrSelf(EObject obj, EObject potentialAncestor) {
		var cur = obj;
		while(cur !== null) {
			if(cur === potentialAncestor) return true;
			cur = cur.eContainer;
		}
		return false;
	}

	// Declaration extensions
	static def isVolatile(Declaration decl) {
		return decl !== null && decl.qualifiers.contains(TypeQualifier.VOLATILE);
	}

	static def isConst(Declaration decl) {
		return decl !== null && decl.qualifiers.contains(TypeQualifier.CONST);
	}

	static def isIsaStateElement(Declaration decl) {
		return decl !== null && decl.eContainer instanceof DeclarationStatement &&
			decl.eContainer.eContainer instanceof ISA;
	}

	static def isIsaParameter(Declaration decl) {
		return decl.isIsaStateElement && decl.storage.empty && decl.declarators.findFirst[it.isAlias] === null;
	}

	// Declarator extensions
	static def isUserTypeMember(Declarator decl) {
		return decl.ancestorOfType(UserTypeDeclaration) !== null;
	}

	static def isStructMember(Declarator decl) {
		return decl.ancestorOfType(StructTypeDeclaration) !== null;
	}

	static def isUnionMember(Declarator decl) {
		return decl.ancestorOfType(UnionTypeDeclaration) !== null;
	}

	static def isEnumMember(Declarator decl) {
		return decl.eContainer instanceof EnumTypeDeclaration;
	}

	static def getDeclaration(Declarator decl) {
		return decl.eContainer.castOrNull(Declaration);
	}

	static def getType(Declarator decl) {
		return decl.declaration?.type;
	}

	static def isVolatile(Declarator decl) {
		return decl.declaration.isVolatile;
	}

	static def isConst(Declarator decl) {
		return decl.declaration.isConst;
	}

	static def isIsaStateElement(Declarator decl) {
		return decl.declaration.isIsaStateElement;
	}

	static def isIsaParameter(Declarator decl) {
		return decl.declaration.isIsaParameter;
	}

	// ISA extensions
	static def getElaborationOrder(ISA isa) {
		var order = new ArrayList();
		getElaborationOrder(isa, order, new HashSet());
		return order;
	}

	private static def dispatch void getElaborationOrder(InstructionSet iset, List<ISA> order, HashSet<ISA> seen) {
		if(!seen.add(iset)) return;
		if(iset.superType !== null) getElaborationOrder(iset.superType, order, seen);
		order.add(iset);
	}

	private static def dispatch void getElaborationOrder(CoreDef core, List<ISA> order, HashSet<ISA> seen) {
		for (iset : core.providedInstructionSets) {
			getElaborationOrder(iset, order, seen);
		}
		order.add(core);
	}
}
