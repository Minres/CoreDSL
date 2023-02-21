package com.minres.coredsl.tests;

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.Statement
import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.^extension.ExtendWith

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
	
	def private generateTestName() {
		val method = new Throwable().stackTrace.get(2).methodName;
		testCount++;
		return '''«method» «testCount»''';
	}

	def private createTestCase(String name, CharSequence program) {
		return new CoreDslTestCase(name, program, program.parse());
	}
}
