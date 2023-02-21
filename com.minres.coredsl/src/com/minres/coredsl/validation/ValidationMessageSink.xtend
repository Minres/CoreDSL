package com.minres.coredsl.validation

import java.util.ArrayList
import java.util.Collections
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.validation.Issue.IssueImpl
import org.eclipse.xtext.validation.ValidationMessageAcceptor

class ValidationMessageSink implements ValidationMessageAcceptor {
	final List<Issue> issues = new ArrayList();
	final List<Issue> issuesReadOnly = Collections.unmodifiableList(issues);

	def getIssues() {
		return issuesReadOnly;
	}

	// loosely adapted from DiagnosticConverterImpl.getLocationData
	def private accept(Severity severity, String message, EObject object, EStructuralFeature feature, int index,
		String code, String[] issueData) {
		val INode parserNode = NodeModelUtils.getNode(object);

		if(parserNode === null) {
			// report at document start
			accept(severity, message, object, 0, 1, code, issueData);
			return;
		}
		
		var startOffset = parserNode.offset;
		var endOffset = parserNode.endOffset;
		
		if(feature !== null) {
			val featureNodes = NodeModelUtils.findNodesForFeature(object, feature);
			if(index < 0) {
				startOffset = featureNodes.get(0).offset;
				endOffset = featureNodes.last.endOffset;
			}
			if(index < featureNodes.size) {
				val childNode = featureNodes.get(index);
				startOffset = childNode.offset;
				endOffset = childNode.endOffset;
			}
		}
		
		accept(severity, message, object, startOffset, endOffset - startOffset, code, issueData);
	}

	def private accept(Severity severity, String message, EObject object, int offset, int length, String code,
		String[] issueData) {
		val issue = new IssueImpl();

		issue.severity = severity;
		issue.message = message;
		issue.code = code;
		issue.data = issueData;
		issue.syntaxError = code == IssueCodes.SyntaxError;

		val node = NodeModelUtils.getNode(object);
		val startLocation = NodeModelUtils.getLineAndColumn(node, offset);
		val endLocation = NodeModelUtils.getLineAndColumn(node, offset + length);

		issue.offset = offset;
		issue.length = length;
		issue.lineNumber = startLocation.line;
		issue.column = startLocation.column;
		issue.lineNumberEnd = endLocation.line;
		issue.columnEnd = endLocation.column;

		issues.add(issue);
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
