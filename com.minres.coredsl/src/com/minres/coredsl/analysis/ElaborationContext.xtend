package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.util.CompilerAssertion
import java.util.ArrayList
import java.util.HashMap
import java.util.LinkedList
import java.util.List
import java.util.Map
import java.util.Set
import java.util.Stack
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.ModelExtensions.*

class ElaborationContext extends ProxyMessageAcceptor {

	static class ElaborationDeclarationInfo {
		public val String name;
		public val List<Declarator> declarators = new ArrayList();
		public val List<Expression> assignments = new ArrayList();

		new(String name) {
			this.name = name;
		}
		
		def isEffectiveAssignment(Expression expression) {
			return !assignments.empty && assignments.last() === expression;
		}
	}
	
	static interface CalculationJob {
		/** @returns true, if the job was successful and can be removed from the queue */
		def boolean tryCalculate(boolean failed);
	}

	public val ISA root;
	public val boolean isPartialElaboration;
	public val AnalysisContext analysisContext;

	public val List<ISA> elaborationOrder = new ArrayList();
	public val Stack<InstructionSet> currentInheritanceStack = new Stack();

	public val Map<String, ElaborationDeclarationInfo> declInfo = new HashMap();
	public val List<CalculationJob> calculationQueue = new LinkedList();
	public val Map<ISA, Set<String>> exposedNames = new HashMap();

	new(ISA root, ValidationMessageAcceptor acceptor) {
		super(acceptor, root, root, CoreDslPackage.Literals.ISA__NAME, -1);
		this.root = root;
		isPartialElaboration = root instanceof InstructionSet;
		analysisContext = new AnalysisContext(root, acceptor);
	}

	def isInElaborationScope(EObject obj) {
		return obj.ancestorOfType(ISA) == root;
	}

	def areExposedNamesSet(ISA isa) {
		return exposedNames.containsKey(isa);
	}

	def getExposedNames(ISA isa) {
		val result = exposedNames.get(isa);
		CompilerAssertion.assertThat(result !== null, "Exposed names for ISA " + isa.name + " have not been set");
		return result;
	}

	def setExposedNames(ISA isa, Set<String> names) {
		CompilerAssertion.assertThat(!areExposedNamesSet(isa),
			"Exposed names for ISA " + isa.name + " have already been set");
		exposedNames.put(isa, names);
	}
}
