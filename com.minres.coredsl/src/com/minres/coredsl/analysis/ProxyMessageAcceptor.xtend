package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.validation.IssueCodes
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.ModelExtensions.*

class ProxyMessageAcceptor implements ValidationMessageAcceptor {
	static val forwardDebugInfo = false;

	protected val ValidationMessageAcceptor baseAcceptor;
	protected val EObject lexicalScope;
	protected val EObject reportObject;
	protected val EStructuralFeature reportFeature;
	protected val int reportIndex;
	protected var int suspensionDepth;

	new(ValidationMessageAcceptor baseAcceptor, EObject lexicalScope, EObject reportObject,
		EStructuralFeature reportFeature, int reportIndex) {
		this.baseAcceptor = baseAcceptor;
		this.lexicalScope = lexicalScope;
		this.reportObject = reportObject;
		this.reportFeature = reportFeature;
		this.reportIndex = reportIndex;
	}

	def void suspendReporting() { suspensionDepth++; }

	def void resumeReporting() { suspensionDepth++; }

	def boolean isReportingSuspended() { return suspensionDepth > 0; }

	def isInScope(EObject object) {
		return object.isDescendantOfOrSelf(lexicalScope);
	}

	def buildForwardedErrorDescription(Severity severity, String message, EObject object, EStructuralFeature feature, int index) {
		val featureNodes = NodeModelUtils.findNodesForFeature(object, feature);
		var INode node = null;
		if(featureNodes.size > 0) {
			if(index < 0 || index >= featureNodes.size) {
				node = featureNodes.get(0);
			} else {
				node = featureNodes.get(index);
			}
		}

		return buildForwardedErrorDescription(severity, message, object, node, node.startLine);
	}

	def buildForwardedErrorDescription(Severity severity, String message, EObject object, int offset, int length) {
		val node = NodeModelUtils.getNode(object);
		val lineAndColumn = NodeModelUtils.getLineAndColumn(node, offset);
		return buildForwardedErrorDescription(severity, message, object, node, lineAndColumn.line);
	}

	def private buildForwardedErrorDescription(Severity severity, String message, EObject object, INode node, int line) {
		val sb = new StringBuilder()

		switch (severity) {
			case Severity.ERROR: {
				sb.append("Error");
			}
			case Severity.WARNING: {
				sb.append("Warning");
			}
			case Severity.INFO: {
				sb.append("Info");
			}
			default: {
				sb.append("???");
			}
		}

		val isSameFile = object.eResource === reportObject.eResource;
		if(!isSameFile) {
			val fileName = object.eResource.URI.lastSegment();
			sb.append(" in file '").append(fileName).append("'");
		}

		sb.append(" on line ").append(line);

		val iset = object.ancestorOfTypeOrSelf(InstructionSet);
		val declarator = object.ancestorOfTypeOrSelf(Declarator);
		val function = object.ancestorOfTypeOrSelf(FunctionDefinition);
		val instruction = object.ancestorOfTypeOrSelf(Instruction);

		if(iset !== null) {
			if(declarator !== null) {
				if(declarator.isIsaStateElement) {
					sb.append(" in declaration of ").append(iset.name).append(".").append(declarator.name);
				} else {
					sb.append(" in declaration of ").append(declarator.name);
				}
			}

			if(function !== null) {
				sb.append(" in function ").append(iset.name).append(".").append(function.name);
			} else if(instruction !== null) {
				sb.append(" in instruction ").append(iset.name).append(".").append(instruction.name);
			}
			else if(declarator === null) {
				sb.append(" in instruction set ").append(iset.name);
			}
		} else {
			if(declarator !== null) {
				sb.append(" in declaration of ").append(declarator.name);
			}

			if(function !== null) {
				sb.append(" in function ").append(iset.name).append(".").append(function.name);
			} else if(instruction !== null) {
				sb.append(" in instruction ").append(iset.name).append(".").append(instruction.name);
			}
		}

		return sb.append(": ").append(message).toString();
	}

	def acceptFallback(Severity severity, String message, EObject object, EStructuralFeature feature, int index,
		String code, String[] issueData) {
		if(!forwardDebugInfo && code == IssueCodes.DebugInfo) return;

		val text = buildForwardedErrorDescription(severity, message, object, feature, index);

		acceptDirect(severity, text, reportObject, reportFeature, reportIndex, code, issueData);
	}

	def acceptFallback(Severity severity, String message, EObject object, int offset, int length, String code,
		String[] issueData) {
		if(!forwardDebugInfo && code == IssueCodes.DebugInfo) return;

		val text = buildForwardedErrorDescription(severity, message, object, offset, length);

		acceptDirect(severity, text, reportObject, reportFeature, reportIndex, code, issueData);
	}

	def acceptDirect(Severity severity, String message, EObject object, EStructuralFeature feature, int index,
		String code, String[] issueData) {
		switch (severity) {
			case ERROR: {
				baseAcceptor.acceptError(message, object, feature, index, code, issueData);
			}
			case INFO: {
				baseAcceptor.acceptInfo(message, object, feature, index, code, issueData);
			}
			case WARNING: {
				baseAcceptor.acceptWarning(message, object, feature, index, code, issueData);
			}
			default: {
			}
		}
	}

	def acceptDirect(Severity severity, String message, EObject object, int offset, int length, String code,
		String[] issueData) {
		switch (severity) {
			case ERROR: {
				baseAcceptor.acceptError(message, object, offset, length, code, issueData);
			}
			case INFO: {
				baseAcceptor.acceptInfo(message, object, offset, length, code, issueData);
			}
			case WARNING: {
				baseAcceptor.acceptWarning(message, object, offset, length, code, issueData);
			}
			default: {
			}
		}
	}

	def accept(Severity severity, String message, EObject object, EStructuralFeature feature, int index, String code,
		String[] issueData) {
		if(isReportingSuspended()) return;
		if(isInScope(object)) {
			acceptDirect(severity, message, object, feature, index, code, issueData);
		} else {
			acceptFallback(severity, message, object, feature, index, code, issueData);
		}
	}

	def accept(Severity severity, String message, EObject object, int offset, int length, String code,
		String[] issueData) {
		if(isReportingSuspended()) return;
		if(isInScope(object)) {
			acceptDirect(severity, message, object, offset, length, code, issueData);
		} else {
			acceptFallback(severity, message, object, offset, length, code, issueData);
		}
	}

	override acceptError(String message, EObject object, EStructuralFeature feature, int index, String code,
		String... issueData) {
		accept(Severity.ERROR, message, object, feature, index, code, issueData);
	}

	override acceptError(String message, EObject object, int offset, int length, String code, String... issueData) {
		accept(Severity.ERROR, message, object, offset, length, code, issueData);
	}

	override acceptInfo(String message, EObject object, EStructuralFeature feature, int index, String code,
		String... issueData) {
		accept(Severity.INFO, message, object, feature, index, code, issueData);
	}

	override acceptInfo(String message, EObject object, int offset, int length, String code, String... issueData) {
		accept(Severity.INFO, message, object, offset, length, code, issueData);
	}

	override acceptWarning(String message, EObject object, EStructuralFeature feature, int index, String code,
		String... issueData) {
		accept(Severity.WARNING, message, object, feature, index, code, issueData);
	}

	override acceptWarning(String message, EObject object, int offset, int length, String code, String... issueData) {
		accept(Severity.WARNING, message, object, offset, length, code, issueData);
	}
}
