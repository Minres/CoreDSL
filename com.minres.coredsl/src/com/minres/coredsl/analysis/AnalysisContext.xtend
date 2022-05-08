package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InstructionSet
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.Stack
import org.eclipse.xtext.validation.ValidationMessageAcceptor

class AnalysisContext {
	public val ISA root;
	public val ValidationMessageAcceptor acceptor;

	public val CoreDef core;

	public val Stack<InstructionSet> currentInheritanceStack = new Stack;
	public val List<ISA> elaborationOrder = new ArrayList;

	public val Map<String, CoreDslElaborator.ConstantDefinitionInfo> constantDefinitions = new HashMap;

	new(ISA root, ValidationMessageAcceptor acceptor) {
		this.root = root;
		this.core = root instanceof CoreDef ? root : null;
		this.acceptor = acceptor;
	}

	def boolean isPartialAnalysis() {
		return core === null;
	}
}
