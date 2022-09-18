package com.minres.coredsl.analysis

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
import java.util.Stack
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.ModelExtensions.*

class ElaborationContext {
	static class IsaStateDeclarationInfo {
		public val String name;
		public val List<Declarator> declarators = new ArrayList();
		public val List<Expression> assignments = new ArrayList();

		new(String name) {
			this.name = name;
		}
	}

	public val AnalysisContext actx;
	public val ValidationMessageAcceptor acceptor;

	public val ISA root;
	public val boolean isPartialElaboration;
	public val List<ISA> elaborationOrder = new ArrayList();
	public val Stack<InstructionSet> currentInheritanceStack = new Stack();

	public val Map<String, IsaStateDeclarationInfo> declInfo = new HashMap();
	public val List<Expression> calculationQueue = new LinkedList();
	public val Map<Expression, ConstantValue> calculatedValues = new HashMap();
	public var gatherPhaseDone = false;

	new(ISA root, AnalysisContext actx) {
		this.root = root;
		this.actx = actx;
		this.acceptor = actx.acceptor;
		isPartialElaboration = root instanceof InstructionSet;
	}

	def isInElaborationScope(EObject obj) {
		return obj.parentOfType(ISA) == root;
	}

	def getCalculatedValue(Declarator declarator) {
		return getCalculatedValue(declarator.name);
	}

	def getCalculatedValue(String name) {
		CompilerAssertion.assertThat(gatherPhaseDone,
			"Calculated results may not be accessed before the gathering phase finishes");
		val info = declInfo.get(name);
		val expression = info?.assignments.last();
		val result = calculatedValues.get(expression);
		return result !== null ? result : ConstantValue.indeterminate;
	}

	def getCalculatedType(String name) {
		CompilerAssertion.assertThat(gatherPhaseDone,
			"Calculated results may not be accessed before the gathering phase finishes");
		val info = declInfo.get(name);
		val declarator = info?.declarators.last();
		return CoreDslTypeProvider.getSpecifiedType(this, declarator.type);
	}
}
