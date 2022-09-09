package com.minres.coredsl.util

import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.StorageClassSpecifier
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.TypeQualifier
import org.eclipse.emf.ecore.EObject

abstract class ModelExtensions {
	private new() {}
	
	static def <T extends EObject> castOrNull(EObject obj, Class<T> type) {
		if(type.isInstance(obj)) return obj as T;
		return null;
	}
	
    static def <T extends EObject> T parentOfType(EObject obj, Class<T> type) {
    	var cur = obj.eContainer;
    	while(cur !== null) {
    		if(type.isInstance(cur)) return cur as T;
    		cur = cur.eContainer;
    	}
    	return null;
    }
	
	// Declaration extensions
	
	static def getStorageClassSpecifier(Declaration declaration) {
		val storage = declaration.storage;
		if(storage.size() > 1) return null; // invalid
		if(storage.size() == 0) return StorageClassSpecifier.PARAM;
		return storage.get(0);
	}
	
	static def isParameter(Declaration decl) {
		return !decl.isRegister && !decl.isExtern;
	}
	
	static def isRegister(Declaration decl) {
		return decl.storage.contains(StorageClassSpecifier.REGISTER);
	}
	
	static def isExtern(Declaration decl) {
		return decl.storage.contains(StorageClassSpecifier.EXTERN);
	}
	
	static def isVolatile(Declaration decl) {
		return decl.qualifiers.contains(TypeQualifier.VOLATILE);
	}
	
	static def isConst(Declaration decl) {
		return decl.qualifiers.contains(TypeQualifier.CONST);
	}
	
	// Declarator extensions
	
	static def getStorageClassSpecifier(Declarator declarator) {
		return declarator.declaration.storageClassSpecifier;
	}
	
	static def getDeclaration(Declarator decl) {
		return (decl.eContainer as Declaration);
	}
	
	static def getType(Declarator decl) {
		return decl.declaration.type;
	}
	
	static def isParameter(Declarator decl) {
		return decl.declaration.isParameter;
	}
	
	static def isRegister(Declarator decl) {
		return decl.declaration.isRegister;
	}
	
	static def isExtern(Declarator decl) {
		return decl.declaration.isExtern;
	}
	
	static def isVolatile(Declarator decl) {
		return decl.declaration.isVolatile;
	}
	
	static def isConst(Declarator decl) {
		return decl.declaration.isConst;
	}
	
}