package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.ISA
import java.util.LinkedHashMap
import java.util.Map
import org.eclipse.xtext.validation.ValidationMessageAcceptor

class AnalysisContext extends ProxyMessageAcceptor {
	public val DescriptionContent root;

	public val Map<ISA, ElaborationContext> elaborationResults = new LinkedHashMap();

	new(ValidationMessageAcceptor acceptor, DescriptionContent root) {
		super(acceptor, root, null, null, -1);
		this.root = root;
	}
}
