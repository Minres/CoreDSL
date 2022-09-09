package com.minres.coredsl.analysis

import org.eclipse.xtext.validation.ValidationMessageAcceptor
import java.util.Map
import com.minres.coredsl.coreDsl.ISA
import java.util.HashMap
import java.util.Set

class AnalysisContext {
	
	public val ValidationMessageAcceptor acceptor;
	
	/** Maps each ISA to a set of names declared within it and its parents */
	public val Map<ISA, Set<String>> exposedDeclarations = new HashMap();
	public val Map<ISA, ElaborationContext> elaborationResults = new HashMap();
	
	new(ValidationMessageAcceptor acceptor) {
		this.acceptor = acceptor;
	}
}