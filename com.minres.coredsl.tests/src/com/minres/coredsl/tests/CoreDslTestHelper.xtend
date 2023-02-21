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
import java.util.regex.Pattern

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslTestHelper {

	@Inject extension ParseHelper<DescriptionContent> parseHelper;
	var int testCount;

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
	
	def private generateTestName() {
		val method = new Throwable().stackTrace.get(2).methodName;
		testCount++;
		return '''«method» «testCount»''';
	}
	
	def testProgram(CharSequence program) {
		return testProgram(program, generateTestName());
	}
	
	def testFunction(CharSequence program) {
		return testFunction(program, generateTestName());
	}
	
	def testStatements(CharSequence program) {
		return testStatements(program, generateTestName());
	}
	
	def testInstruction(CharSequence program) {
		return testInstruction(program, generateTestName());
	}

	def testProgram(CharSequence program, String name) {
		return createTestCase(name, program);
	}

	def testFunction(CharSequence function, String name) {
		return createTestCase(name, function.buildProgramFromFunction());
	}

	def testStatements(CharSequence statements, String name) {
		return createTestCase(name, statements.buildProgramFromStatements());
	}

	def testInstruction(CharSequence instruction, String name) {
		return createTestCase(name, instruction.buildProgramFromInstruction());
	}

	def private createTestCase(String name, CharSequence program) {
		return new TestCase(name, program, program.parse());
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

	static class TestCase {
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
			
			for(var i = 0; i < lines.length; i++) {
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
				}
				else {
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
		def private static convertDiagnostic(Diagnostic diagnostic, Severity severity) {
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
