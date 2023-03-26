package com.minres.coredsl.tests

import com.minres.coredsl.analysis.AnalysisContext
import com.minres.coredsl.analysis.AnalysisResults
import com.minres.coredsl.analysis.CoreDslAnalyzer
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.validation.IssueCodes
import com.minres.coredsl.validation.ValidationMessageSink
import java.util.ArrayList
import java.util.List
import java.util.regex.Pattern
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.diagnostics.AbstractDiagnostic
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic
import org.eclipse.xtext.validation.Issue.IssueImpl

import static org.junit.jupiter.api.Assertions.*

import static extension com.minres.coredsl.util.ModelExtensions.*

class CoreDslTestCase<TRoot> {
	final static Pattern newLinePattern = Pattern.compile("\r?\n");

	final String name;
	final CharSequence program;
	final DescriptionContent model;
	final TRoot root;
	final int prologLines;
	final List<IssueDescription> expectedIssues = new ArrayList();
	final List<Expectation<?>> semanticExpectations = new ArrayList();

	boolean checkDiagnosticsOnly;
	boolean isGenericSyntaxTest;
	boolean hasRun;

	new(String name, CharSequence program, DescriptionContent tree, TRoot root) {
		this.name = name;
		this.program = program;
		this.model = tree;
		this.root = root;

		var prologLines = 0;
		switch (root) {
			EList<?>: {
				val node = NodeModelUtils.getNode(root.get(0) as EObject);
				prologLines = NodeModelUtils.getLineAndColumn(node, node.offset).line - 1;
			}
			EObject: {
				val node = NodeModelUtils.getNode(root);
				prologLines = NodeModelUtils.getLineAndColumn(node, node.offset).line - 1;
			}
		}
		this.prologLines = prologLines;
	}

	def diagnosticsOnly() {
		checkDiagnosticsOnly = true;
		return this;
	}

	def expectIssue(Severity severity, String code, int line) {
		expectedIssues.add(new IssueDescription(severity, code, line + prologLines));
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

	def expectSyntaxErrors() {
		isGenericSyntaxTest = true;
		return this;
	}
	
	def private findIsa(String name) {
		val isa = model.definitions.findFirst[it.name == name];
		if(isa === null) throw new Exception("No ISA found with name " + name);
		return isa;
	}
	
	def private findDeclarator(String name) {
		return model.descendantsOfType(Declarator).findFirst[it.name == name];
	}
	
	def private findEObject(Class<? extends EObject> type, int line) {
		return model.descendantsOfType(type).findFirst[it.syntaxNode.startLine === line + prologLines];
	}
	
	def expect((TRoot, AnalysisResults)=>boolean expectation, String description) {
		semanticExpectations.add(new UserExpectation<TRoot>(root, expectation, description));
		return this;
	}
	
	def expect((TRoot)=>boolean expectation, String description) {
		return expect([root, results | expectation.apply(root)], description);
	}
	
	def <T extends EObject> expect(Class<T> type, int line, (T, AnalysisResults)=>boolean expectation, String description) {
		val obj = findEObject(type, line);
		semanticExpectations.add(new UserExpectation<T>(obj as T, expectation, description));
		return this;
	}
	
	def <T extends EObject> expect(Class<T> type, int line, (T)=>boolean expectation, String description) {
		return expect(type, line, [root, results | expectation.apply(root)], description);
	}
	
	def expect(String isaName, (TRoot, AnalysisContext)=>boolean expectation, String description) {
		val isa = findIsa(isaName);
		semanticExpectations.add(new UserExpectation<TRoot>(root, [root, results | expectation.apply(root, results.results.get(isa))], description));
		return this;
	}

	def expectType(String isaName, (TRoot)=>EObject objectLocator, Object expectedType) {
		semanticExpectations.add(new TypeExpectation<TRoot>(findIsa(isaName), root, objectLocator, String.valueOf(expectedType)));
		return this;
	}

	def expectType(String isaName, String declaratorName, Object expectedType) {
		return expectType(isaName, [findDeclarator(declaratorName)], expectedType);
	}

	def expectType(String isaName, Class<? extends EObject> type, int line, Object expectedType) {
		return expectType(isaName, [findEObject(type, line)], expectedType);
	}

	def expectValue(String isaName, (TRoot)=>EObject objectLocator, Object expectedValue) {
		semanticExpectations.add(new ValueExpectation<TRoot>(findIsa(isaName), root, objectLocator, String.valueOf(expectedValue)));
		return this;
	}

	def expectValue(String isaName, String declaratorName, Object expectedValue) {
		return expectValue(isaName, [findDeclarator(declaratorName)], expectedValue);
	}

	def expectValue(String isaName, Class<? extends EObject> type, int line, Object expectedValue) {
		return expectValue(isaName, [findEObject(type, line)], expectedValue);
	}

	def private printProgram() {
		val lines = newLinePattern.split(program);
		val digits = String.valueOf(lines.length).length;
		val format = '''%«digits»d| %s''';

		for (var i = 0; i < lines.length; i++) {
			println(String.format(format, i + 1, lines.get(i).replace("\t", "  ")));
		}
	}

	def private printHeader() {
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

		val diagnosticsErrors = model.eResource.errors.map[convertDiagnostic(it, Severity.ERROR)];
		val diagnosticsWarnings = model.eResource.warnings.map[convertDiagnostic(it, Severity.WARNING)];

		var issues = new ArrayList();
		issues.addAll(diagnosticsErrors);
		issues.addAll(diagnosticsWarnings);

		var AnalysisResults results = null;

		if(!checkDiagnosticsOnly) {
			val sink = new ValidationMessageSink();
			results = CoreDslAnalyzer.analyze(model, sink);
			issues.addAll(sink.issues);
		}

		val actualIssues = issues.sortBy[it.severity].sortBy[it.code].sortBy[it.lineNumber];
		val expectedIssues = expectedIssues.sortBy[it.severity].sortBy[it.code].sortBy[it.lineNumber];

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
		if(isGenericSyntaxTest) {
			println('''  Any syntax errors''')
		}
		println();

		if(isGenericSyntaxTest) {
			if(!expectedIssues.empty)
				throw new Exception(
					"Invalid test case definition: cannot test for arbitrary syntax errors and specific errors simultaneously");
			assertNotEquals(0, actualIssues.size);
			for (issue : actualIssues) {
				assertEquals(IssueCodes.SyntaxError, issue.code);
			}
			return;
		}

		assertEquals(expectedIssues.size, actualIssues.size);
		for (var i = 0; i < Math.min(expectedIssues.size, actualIssues.size); i++) {
			val expected = expectedIssues.get(i);
			val actual = actualIssues.get(i);

			assertEquals(expected.severity, actual.severity);
			assertEquals(expected.code, actual.code);
			if(expected.lineNumber >= 0)
				assertEquals(expected.lineNumber, actual.lineNumber);
		}

		if(!semanticExpectations.empty) {
			println("Semantic expectations:");

			var allFulfilled = true;

			for (expectation : semanticExpectations) {
				allFulfilled = expectation.check(results) && allFulfilled;
			}

			if(!allFulfilled) {
				println("Not all semantic expectations were fulfilled");
				println();
				fail();
			}
			else {
				println();
			}
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

	private static abstract class Expectation<TRoot> {
		def abstract boolean check(AnalysisResults results)
	}
	
	private static final class UserExpectation<TRoot> extends Expectation<TRoot> {
		val TRoot root;
		val (TRoot, AnalysisResults)=>boolean expectation;
		val String description;

		new(TRoot root, (TRoot, AnalysisResults)=>boolean expectation, String description) {
			this.root = root;
			this.expectation = expectation;
			this.description = description;
		}
		
		override check(AnalysisResults results) {
			try {
				if(expectation.apply(root, results)) {
					println('''  «description»''');
					return true;
				}
				else {
					println('''  Expectation failed: «description»''');
					return true;
				}
			} catch(Exception e) {
				println("  " + e.class.simpleName + ": " + e.message);
				return false;
			}
		}
	}

	private static final class TypeExpectation<TRoot> extends Expectation<TRoot> {
		val ISA isa;
		val TRoot root;
		val (TRoot)=>EObject objectLocator;
		val String expectedType;

		new(ISA isa, TRoot root, (TRoot)=>EObject objectLocator, String expectedType) {
			this.isa = isa;
			this.root = root;
			this.objectLocator = objectLocator;
			this.expectedType = expectedType;
		}

		override check(AnalysisResults results) {
			val ctx = results.results.get(isa);
			try {
				val object = objectLocator.apply(root);
				val description = object.shortDescription;

				if(!ctx._isTypeSet(object)) {
					println('''  «description»: Expected type «expectedType», but no type was set''');
					return false;
				}

				val actualType = ctx._getType(object).toString();

				if(actualType != expectedType) {
					println('''  «description»: Expected type «expectedType», but got «actualType»''');
					return false;
				}

				println('''  «description»: Got the expected type «actualType»''');
				return true;
			} catch(Exception e) {
				println("  " + e.class.simpleName + ": " + e.message);
				return false;
			}
		}
	}

	private static final class ValueExpectation<TRoot> extends Expectation<TRoot> {
		val ISA isa;
		val TRoot root;
		val (TRoot)=>EObject objectLocator;
		val String expectedValue;

		new(ISA isa, TRoot root, (TRoot)=>EObject objectLocator, String expectedValue) {
			this.isa = isa;
			this.root = root;
			this.objectLocator = objectLocator;
			this.expectedValue = expectedValue;
		}

		override check(AnalysisResults results) {
			val ctx = results.results.get(isa);
			try {
				val object = objectLocator.apply(root);
				val description = object.shortDescription;

				if(!ctx._isValueSet(object)) {
					println('''  «description»: Expected value «expectedValue», but no value was set''');
					return false;
				}

				val actualValue = ctx._getValue(object).toString();

				if(actualValue != expectedValue) {
					println('''  «description»: Expected value «expectedValue», but got «actualValue»''');
					return false;
				}

				println('''  «description»: Got the expected value «actualValue»''');
				return true;
			} catch(Exception e) {
				println("  " + e.class.simpleName + ": " + e.message);
				return false;
			}
		}
	}
}
