package com.minres.coredsl.validation

import org.eclipse.xtext.validation.ValidationMessageAcceptor
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.validation.Issue
import java.util.List
import java.util.ArrayList
import org.eclipse.xtext.validation.Issue.IssueImpl
import org.eclipse.xtext.diagnostics.Severity
import java.util.Collections

class ValidationMessageSink implements ValidationMessageAcceptor {
	final List<Issue> issues = new ArrayList();
	final List<Issue> issuesReadOnly = Collections.unmodifiableList(issues);
	
	def getIssues() {
		return issuesReadOnly;
	}
	
	def private accept(Severity severity, String message, String code) {
		val issue = new IssueImpl();
		issue.severity = severity;
		issue.message = message;
		issue.code = code;
		issue.syntaxError = code == IssueCodes.SyntaxError;
		issues.add(issue);
	}
	
	override acceptError(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		accept(Severity.ERROR, message, code);
	}
	
	override acceptError(String message, EObject object, int offset, int length, String code, String... issueData) {
		accept(Severity.ERROR, message, code);
	}
	
	override acceptInfo(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		accept(Severity.INFO, message, code);
	}
	
	override acceptInfo(String message, EObject object, int offset, int length, String code, String... issueData) {
		accept(Severity.INFO, message, code);
	}
	
	override acceptWarning(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		accept(Severity.WARNING, message, code);
	}
	
	override acceptWarning(String message, EObject object, int offset, int length, String code, String... issueData) {
		accept(Severity.WARNING, message, code);
	}
}