package com.minres.coredsl.tests;

import com.google.inject.Inject
import com.minres.coredsl.analysis.CoreDslAnalyzer
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.Statement
import com.minres.coredsl.validation.ValidationMessageSink
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource.Diagnostic
import org.eclipse.xtext.diagnostics.AbstractDiagnostic
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.validation.Issue.IssueImpl
import org.junit.jupiter.api.^extension.ExtendWith

import static org.junit.jupiter.api.Assertions.*

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslTestHelper {

	@Inject extension ParseHelper<DescriptionContent> parseHelper;

	def String buildProgramFromFunction(CharSequence str) {
		return '''
			InstructionSet TestISA {
			    functions {
			        «str»
			    }
			}
		''';
	}

	def String buildProgramFromStatements(CharSequence str) {
		return '''
			InstructionSet TestISA {
			    functions {
			    	void testFunc() {
			    		«str»
			    	}
			    }
			}
		''';
	}

	def String buildProgramFromInstruction(CharSequence str) {
		return '''
			InstructionSet TestISA {
			    instructions {
			        «str»
			    }
			}
		''';
	}

	def Instruction parseAsInstruction(CharSequence str) {
		return str.buildProgramFromInstruction().parse().definitions.get(0).instructions.get(0);
	}

	def FunctionDefinition parseAsFunction(CharSequence str) {
		return str.buildProgramFromFunction().parse().definitions.get(0).functions.get(0);
	}

	def EList<Statement> parseAsStatements(CharSequence str) {
		return str.buildProgramFromStatements().parse().definitions.get(0).functions.get(0).body.statements;
	}

	def Statement parseAsStatement(CharSequence str) {
		return str.parseAsStatements().get(0);
	}

	def testProgram(CharSequence program) {
		return createTestCase(program);
	}

	def testFunction(CharSequence function) {
		return createTestCase(function.buildProgramFromFunction());
	}

	def testStatements(CharSequence statements) {
		return createTestCase(statements.buildProgramFromStatements());
	}

	def testInstruction(CharSequence instruction) {
		return createTestCase(instruction.buildProgramFromInstruction());
	}

	def private createTestCase(CharSequence program) {
		return new TestCase(program, program.parse());
	}

	private static class IssueDescription {
		val Severity severity;
		val String code;

		new(Severity severity, String issueCode) {
			this.severity = severity;
			this.code = issueCode;
		}
	}

	static class TestCase {
		final CharSequence program;
		final DescriptionContent tree;
		final List<IssueDescription> expectedIssues = new ArrayList();

		boolean checkDiagnosticsOnly;
		boolean hasRun;

		new(CharSequence program, DescriptionContent treer) {
			this.program = program;
			this.tree = tree;
		}

		def diagnosticsOnly() {
			checkDiagnosticsOnly = true;
			return this;
		}

		def expectIssue(Severity severity, String code) {
			expectedIssues.add(new IssueDescription(severity, code));
			return this;
		}

		def expectError(String code) {
			return expectIssue(Severity.ERROR, code);
		}

		def expectWarning(String code) {
			return expectIssue(Severity.WARNING, code);
		}

		def run() {
			if(hasRun) return;
			hasRun = true;

			println("====================================");
			println(program);

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

			val actualIssues = issues.sortBy[it.severity].sortBy[it.code];
			val expectedIssues = expectedIssues.sortBy[it.severity].sortBy[it.code];

			println("Issues:");
			for (issue : actualIssues) {
				println('''  «issue.severity»: «issue.code» («issue.message»)''');
			}
			println("Expected:");
			for (issue : expectedIssues) {
				println('''  «issue.severity»: «issue.code»''');
			}
			println();

			assertEquals(expectedIssues.size, actualIssues.size);
			for (var i = 0; i < Math.min(expectedIssues.size, actualIssues.size); i++) {
				assertEquals(expectedIssues.get(i).severity, actualIssues.get(i).severity);
				assertEquals(expectedIssues.get(i).code, actualIssues.get(i).code);
			}
		}

		// adapted from DiagnosticConverterImpl.convertResourceDiagnostic
		private def convertDiagnostic(Diagnostic diagnostic, Severity severity) {
			val issue = new IssueImpl();

			issue.syntaxError = diagnostic instanceof XtextSyntaxDiagnostic;
			issue.severity = severity;
			issue.lineNumber = diagnostic.line
			issue.column = diagnostic.column;
			issue.message = diagnostic.message;

			if(diagnostic instanceof org.eclipse.xtext.diagnostics.Diagnostic) {
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
	}
}
