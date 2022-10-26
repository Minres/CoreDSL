package com.minres.coredsl.analysis

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.ModelExtensions.*

class ProxyMessageAcceptor implements ValidationMessageAcceptor {
	protected val ValidationMessageAcceptor baseAcceptor;
	protected val EObject lexicalScope;
	protected val EObject reportObject;
	protected val EStructuralFeature reportFeature;
	protected val int reportIndex;

	new(ValidationMessageAcceptor baseAcceptor, EObject lexicalScope, EObject reportObject,
		EStructuralFeature reportFeature, int reportIndex) {
		this.baseAcceptor = baseAcceptor;
		this.lexicalScope = lexicalScope;
		this.reportObject = reportObject;
		this.reportFeature = reportFeature;
		this.reportIndex = reportIndex;
	}

	def isInScope(EObject object) {
		return object.isDescendantOfOrSelf(lexicalScope);
	}

	def getErrorDescription(EObject object) {
		return "Error";
	}

	def buildLocationDescription(String message, EObject object, EStructuralFeature feature, int index) {
		val fileName = object.eResource.URI.lastSegment();
		val featureNodes = NodeModelUtils.findNodesForFeature(object, feature);
		var INode node = null;
		if(featureNodes.size > 0) {
			if(index < 0 || index >= featureNodes.size) {
				node = featureNodes.get(0);
			} else {
				node = featureNodes.get(index);
			}
		}

		return index >= 0
			? '''«getErrorDescription(object)» at «fileName»:«node.startLine» (on «object.eClass.name».«feature.name»[«index»])''' : '''«getErrorDescription(object)» at «fileName»:«node.startLine» (on «object.eClass.name».«feature.name»)'''
	}

	def buildLocationDescription(String message, EObject object, int offset, int length) {
		val fileName = object.eResource.URI.lastSegment();

		return '''«getErrorDescription(object)» in «fileName» at offset «offset»'''
	}

	def acceptFallback(Severity severity, String message, EObject object, EStructuralFeature feature, int index,
		String code, String[] issueData) {
		val text = '''«buildLocationDescription(message, object, feature, index)»: «message»''';

		acceptDirect(severity, text, reportObject, reportFeature, reportIndex, code, issueData);
	}

	def acceptFallback(Severity severity, String message, EObject object, int offset, int length, String code,
		String[] issueData) {
		val text = '''«buildLocationDescription(message, object, offset, length)»: «message»''';

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
		if(isInScope(object)) {
			acceptDirect(severity, message, object, feature, index, code, issueData);
		} else {
			acceptFallback(severity, message, object, feature, index, code, issueData);
		}
	}

	def accept(Severity severity, String message, EObject object, int offset, int length, String code,
		String[] issueData) {
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
