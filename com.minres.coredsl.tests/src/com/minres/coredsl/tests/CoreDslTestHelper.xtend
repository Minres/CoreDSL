package com.minres.coredsl.tests;

import com.google.inject.Inject
import com.minres.coredsl.analysis.CoreDslAnalyzer
import com.minres.coredsl.coreDsl.DescriptionContent
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.^extension.ExtendWith

import static com.minres.coredsl.analysis.CoreDslAnalyzer.*

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslTestHelper {

	@Inject ParseHelper<DescriptionContent> parseHelper;
	var int testCount;

	// decorators
	def static buildProgramFromFunction(CharSequence code) {
		return '''
			InstructionSet TestISA {
				functions {
					«code»
				}
			}
		''';
	}

	def static buildProgramFromStatements(CharSequence code) {
		return '''
			InstructionSet TestISA {
				functions {
					void testFunc() {
						«code»
					}
				}
			}
		''';
	}

	def static buildProgramFromInstruction(CharSequence code) {
		return '''
			InstructionSet TestISA {
				instructions {
					«code»
				}
			}
		''';
	}

	// selectors
	def static selectFunctionFromProgram(DescriptionContent desc) {
		return desc.definitions.get(0).functions.get(0);
	}

	def static selectStatementsFromProgram(DescriptionContent desc) {
		return desc.definitions.get(0).functions.get(0).body.statements;
	}

	def static selectInstructionFromProgram(DescriptionContent desc) {
		return desc.definitions.get(0).instructions.get(0);
	}

	// parse helpers
	def parse(CharSequence code) {
		return parse(code, [it], [it]);
	}

	def parseAsFunction(CharSequence code) {
		return parse(code, [buildProgramFromFunction], [selectFunctionFromProgram]);
	}

	def parseAsStatements(CharSequence code) {
		return parse(code, [buildProgramFromStatements], [selectStatementsFromProgram]);
	}

	def parseAsInstruction(CharSequence code) {
		return parse(code, [buildProgramFromInstruction], [selectInstructionFromProgram]);
	}

	def parseAsStatement(CharSequence code) {
		return code.parseAsStatements().get(0);
	}

	def private <T> parse(CharSequence code, (CharSequence)=>CharSequence decorator,
		(DescriptionContent)=>T rootSelector) {
		val program = decorator.apply(code);
		val model = parseHelper.parse(program);
		val root = rootSelector.apply(model);
		return root;
	}

	// test helpers
	def testProgram(CharSequence program) {
		return test(program, generateTestName(), [it], [it]);
	}

	def testFunction(CharSequence code) {
		return test(code, generateTestName(), [buildProgramFromFunction], [selectFunctionFromProgram]);
	}

	def testStatements(CharSequence code) {
		return test(code, generateTestName(), [buildProgramFromStatements], [selectStatementsFromProgram]);
	}

	def testInstruction(CharSequence code) {
		return test(code, generateTestName(), [buildProgramFromInstruction], [selectInstructionFromProgram]);
	}

	def private generateTestName() {
		val method = new Throwable().stackTrace.get(2).methodName;
		testCount++;
		return '''«method» «testCount»''';
	}

	def private <T> test(CharSequence code, String name, (CharSequence)=>CharSequence decorator,
		(DescriptionContent)=>T rootSelector) {

		CoreDslAnalyzer.emitDebugInfo = false;
		val program = decorator.apply(code);
		val model = parseHelper.parse(program);
		val root = rootSelector.apply(model);
		return new CoreDslTestCase<T>(name, program, model, root);
	}
}
