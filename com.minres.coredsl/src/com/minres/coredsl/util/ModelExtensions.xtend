package com.minres.coredsl.util

import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.TypeQualifier
import org.eclipse.emf.ecore.EObject

abstract class ModelExtensions {
	private new() {
	}

	static def <T extends EObject> castOrNull(EObject obj, Class<T> type) {
		if(type.isInstance(obj)) return obj as T;
		return null;
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

	static def <T> boolean isOneOf(T value, T... options) {
		return options.contains(value);
	}

	// Declaration extensions
	static def isVolatile(Declaration decl) {
		return decl.qualifiers.contains(TypeQualifier.VOLATILE);
	}

	static def isConst(Declaration decl) {
		return decl.qualifiers.contains(TypeQualifier.CONST);
	}

	// Declarator extensions
	static def getDeclaration(Declarator decl) {
		return (decl.eContainer as Declaration);
	}

	static def getType(Declarator decl) {
		return decl.declaration.type;
	}

	static def isVolatile(Declarator decl) {
		return decl.declaration.isVolatile;
	}

	static def isConst(Declarator decl) {
		return decl.declaration.isConst;
	}
}
