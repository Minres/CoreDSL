package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.ISA
import java.util.LinkedHashMap
import java.util.Map
import java.util.Set
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.ModelExtensions.*

class AnalysisContext {

	public val ValidationMessageAcceptor acceptor;

	public val Map<Declaration, StorageClass> storageClasses = new LinkedHashMap();

	/** Maps each ISA to a set of names declared within it and its parents */
	public val Map<ISA, Set<String>> exposedDeclarations = new LinkedHashMap();
	public val Map<ISA, ElaborationContext> elaborationResults = new LinkedHashMap();

	new(ValidationMessageAcceptor acceptor) {
		this.acceptor = acceptor;
	}

	def getStorageClass(Declaration declaration) {
		return storageClasses.get(declaration);
	}

	def getStorageClass(Declarator declarator) {
		val result = storageClasses.get(declarator.declaration);
		return result !== null ? result : StorageClass.unknown;
	}

	def boolean isIsaParameter(Declaration declaration) {
		return getStorageClass(declaration) === StorageClass.param;
	}

	def boolean isIsaParameter(Declarator declarator) {
		return isIsaParameter(declarator.declaration);
	}
}
