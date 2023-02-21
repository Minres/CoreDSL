package com.minres.coredsl.tests

import com.minres.coredsl.analysis.CoreDslAnalyzer
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.validation.ValidationMessageSink
import java.util.ArrayList
import java.util.List
import java.util.regex.Pattern
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.diagnostics.AbstractDiagnostic
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic
import org.eclipse.xtext.validation.Issue.IssueImpl

import static org.junit.jupiter.api.Assertions.*

class CoreDslTestCase {
	final static Pattern newLinePattern = Pattern.compile("\r?\n");

	final String name;
	final CharSequence program;
	final DescriptionContent tree;
	final List<IssueDescription> expectedIssues = new ArrayList();

	boolean checkDiagnosticsOnly;
	boolean hasRun;

	new(String name, CharSequence program, DescriptionContent tree) {
		this.name = name;
		this.program = program;
		this.tree = tree;
	}

	def diagnosticsOnly() {
		checkDiagnosticsOnly = true;
		return this;
	}

	def expectIssue(Severity severity, String code, int line) {
		expectedIssues.add(new IssueDescription(severity, code, line));
		return this;
	}

	def expectError(String code, int line) {
		return expectIssue(Severity.ERROR, code, line);
	}

	def expectWarning(String code, int line) {
		return expectIssue(Severity.WARNING, code, line);
	}

	def expectError(String code) {
		return expectError(code, -1);
	}

	def expectWarning(String code) {
		return expectWarning(code, -1);
	}

	private def printProgram() {
		val lines = newLinePattern.split(program);
		val digits = String.valueOf(lines.length).length;
		val format = '''%«digits»d| %s''';

		for (var i = 0; i < lines.length; i++) {
			println(String.format(format, i + 1, lines.get(i)));
		}
	}

	private def printHeader() {
		println("========================================");
		println(String.format('''%«20+name.length/2»s''', name));
		println("========================================");
		printProgram();
		println();
	}

	def run() {
		if(hasRun) return;
		hasRun = true;

		printHeader();

		val diagnosticsErrors = tree.eResource.errors.map[convertDiagnostic(it, Severity.ERROR)];
		val diagnosticsWarnings = tree.eResource.warnings.map[convertDiagnostic(it, Severity.WARNING)];

		var issues = new ArrayList();
		issues.addAll(diagnosticsErrors);
		issues.addAll(diagnosticsWarnings);

		if(!checkDiagnosticsOnly) {
			val sink = new ValidationMessageSink();
			CoreDslAnalyzer.analyze(tree, sink);
			issues.addAll(sink.issues);
		}

		val actualIssues = issues.sortBy[it.lineNumber].sortBy[it.severity].sortBy[it.code];
		val expectedIssues = expectedIssues.sortBy[it.lineNumber].sortBy[it.severity].sortBy[it.code];

		println("Issues:");
		for (issue : actualIssues) {
			println('''  «issue.severity»: «issue.code» [line «issue.lineNumber»] («issue.message»)''');
		}
		println("Expected:");
		for (issue : expectedIssues) {
			if(issue.lineNumber >= 0) {
				println('''  «issue.severity»: «issue.code» [line «issue.lineNumber»]''');
			} else {
				println('''  «issue.severity»: «issue.code»''');
			}
		}
		println();

		assertEquals(expectedIssues.size, actualIssues.size);
		for (var i = 0; i < Math.min(expectedIssues.size, actualIssues.size); i++) {
			val expected = expectedIssues.get(i);
			val actual = actualIssues.get(i);

			assertEquals(expected.severity, actual.severity);
			assertEquals(expected.code, actual.code);
			if(expected.lineNumber >= 0)
				assertEquals(expected.lineNumber, actual.lineNumber);
		}
	}

	// adapted from DiagnosticConverterImpl.convertResourceDiagnostic
	def private static convertDiagnostic(Resource.Diagnostic diagnostic, Severity severity) {
		val issue = new IssueImpl();

		issue.syntaxError = diagnostic instanceof XtextSyntaxDiagnostic;
		issue.severity = severity;
		issue.lineNumber = diagnostic.line
		issue.column = diagnostic.column;
		issue.message = diagnostic.message;

		if(diagnostic instanceof Diagnostic) {
			issue.offset = diagnostic.offset;
			issue.length = diagnostic.length;
		}

		if(diagnostic instanceof AbstractDiagnostic) {
			issue.uriToProblem = diagnostic.uriToProblem;
			issue.code = diagnostic.code;
			issue.data = diagnostic.data;
			issue.lineNumberEnd = diagnostic.lineEnd;
			issue.columnEnd = diagnostic.columnEnd;
		}

		return issue;
	}
	
	private static class IssueDescription {
		val Severity severity;
		val String code;
		val int lineNumber;

		new(Severity severity, String issueCode, int lineNumber) {
			this.severity = severity;
			this.code = issueCode;
			this.lineNumber = lineNumber;
		}
	}
}
