package com.minres.coredsl.tests.analysis

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.IfStatement
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.tests.CoreDslInjectorProvider
import com.minres.coredsl.tests.CoreDslTestHelper
import com.minres.coredsl.type.IntegerType
import com.minres.coredsl.validation.IssueCodes
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslStatementTest {

	@Inject extension CoreDslTestHelper testHelper;

	@Test
	def void compoundStatement() {
		'''
			{
				{}
				{}
			}
		'''
		.testStatements()
		.run();
		
		'''
			{
				{}
				return;
				{}
			}
		'''
		.testStatements()
		.expectWarning(IssueCodes.UnreachableCode, 4)
		.run();
		
		'''
			{
				{}
				{return;}
				{}
			}
		'''
		.testStatements()
		.expectWarning(IssueCodes.UnreachableCode, 4)
		.run();
		
		'''
			{
				{}
				if(true) return;
				else return;
				{}
			}
		'''
		.testStatements()
		.expectWarning(IssueCodes.UnreachableCode, 5)
		.run();
	}

	@Test
	def void expressionStatement() {
		'''
			int arr[1];
			int x = 0;
			
			0;
			x;
			sizeof(x);
			(0);
			(int)0;
			0::0;
			0?0:0;
			0+0;
			arr[0];
			-0;
			+0;
			~0;
			!0;
		'''
		.testStatements()
		.expectError(IssueCodes.InvalidStatementExpression, 4)
		.expectError(IssueCodes.InvalidStatementExpression, 5)
		.expectError(IssueCodes.InvalidStatementExpression, 6)
		.expectError(IssueCodes.InvalidStatementExpression, 7)
		.expectError(IssueCodes.InvalidStatementExpression, 8)
		.expectError(IssueCodes.InvalidStatementExpression, 9)
		.expectError(IssueCodes.InvalidStatementExpression, 10)
		.expectError(IssueCodes.InvalidStatementExpression, 11)
		.expectError(IssueCodes.InvalidStatementExpression, 12)
		.expectError(IssueCodes.InvalidStatementExpression, 13)
		.expectError(IssueCodes.InvalidStatementExpression, 14)
		.expectError(IssueCodes.InvalidStatementExpression, 15)
		.expectError(IssueCodes.InvalidStatementExpression, 16)
		.run();
		
		'''
			int arr[1];
			int x;
			
			x = 0;
			++x;
			--x;
			x++;
			x--;
			testFunc();
		'''
		.testStatements()
		.run();
	}

	@Test
	def void ifStatement() {
		'''
			if(true)
			if(true){}
			else{}
		'''
		.testStatements()
		.expect(IfStatement, 1, [it.elseBody === null], "The outer if statement has no else branch")
		.expect(IfStatement, 2, [it.elseBody !== null], "The inner if statement has an else branch")
		.run();
		
		'''
			InstructionSet TestISA {
				architectural_state {
					struct T {
						int f;
					}
				}
				functions {
					void testFunc() {
						struct T t;
						int a[1];
						
						if(t);
						if(a);
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.NonScalarCondition, 12)
		.expectError(IssueCodes.NonScalarCondition, 13)
		.run();
		
		'''
			if(true);
			if(false);
			if(0);
			if(1);
		'''
		.testStatements()
		.run();
	}

	@Test
	def void switchStatement() {
		'''
			switch(0) {}
			
			bool b = true;
			switch(b) {
				case true: break;
				case false: break;
			}
			
			int i = 42;
			switch(i) {
				case -1: break;
				case 42: break;
				default: break;
			}
		'''
		.testStatements()
		.run();
		
		'''
			InstructionSet TestISA {
				architectural_state {
					struct T {
						int f;
					}
				}
				functions {
					void testFunc() {
						struct T t;
						int a[1];
						
						switch(t) {}
						switch(a) {}
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.SwitchConditionTypeInvalid, 12)
		.expectError(IssueCodes.SwitchConditionTypeInvalid, 13)
		.run();
		
		'''
			switch(0) {
				default: break;
				default: break;
				default: break;
			}
		'''
		.testStatements()
		.expectError(IssueCodes.SwitchMultipleDefaultSections, 3)
		.expectError(IssueCodes.SwitchMultipleDefaultSections, 4)
		.run();
		
		'''
			switch(0) {
				case 0: break;
				case 1 - 1: break;
				case 0 * 25: break;
			}
		'''
		.testStatements()
		.expectType(null, IntegerConstant, 1, IntegerType.bool)
		.expectValue(null, InfixExpression, 3, 0)
		.expectValue(null, InfixExpression, 4, 0)
		.expectError(IssueCodes.SwitchDuplicateCaseSection, 3)
		.expectError(IssueCodes.SwitchDuplicateCaseSection, 4)
		.run();
		
		'''
			switch(0) {
				case -1: break;
				case 0: break;
				case 1: break;
				case 2: break;
			}
		'''
		.testStatements()
		.expectType(null, IntegerConstant, 1, IntegerType.bool)
		.expectError(IssueCodes.SwitchCaseConditionOutOfRange, 2)
		.expectError(IssueCodes.SwitchCaseConditionOutOfRange, 5)
		.run();
	}

	@Test
	def void whileLoop() {
		'''
			InstructionSet TestISA {
				architectural_state {
					struct T {
						int f;
					}
				}
				functions {
					void testFunc() {
						struct T t;
						int a[1];
						
						while(t);
						while(a);
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.NonScalarCondition, 12)
		.expectError(IssueCodes.NonScalarCondition, 13)
		.run();
		
		'''
			while(true);
			while(false);
			while(0);
			while(1);
		'''
		.testStatements()
		.run();
	}

	@Test
	def void doLoop() {
		'''
			InstructionSet TestISA {
				architectural_state {
					struct T {
						int f;
					}
				}
				functions {
					void testFunc() {
						struct T t;
						int a[1];
						
						do ; while(t);
						do ; while(a);
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.NonScalarCondition, 12)
		.expectError(IssueCodes.NonScalarCondition, 13)
		.run();
		
		'''
			do ; while(true);
			do ; while(false);
			do ; while(0);
			do ; while(1);
		'''
		.testStatements()
		.run();
	}

	@Test
	def void forLoop() {
		'''
			InstructionSet TestISA {
				architectural_state {
					struct T {
						int f;
					}
				}
				functions {
					void testFunc() {
						struct T t;
						int a[1];
						
						for(;t;);
						for(;a;);
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.NonScalarCondition, 12)
		.expectError(IssueCodes.NonScalarCondition, 13)
		.run();
		
		'''
			for(;true;);
			for(;false;);
			for(;0;);
			for(;1;);
		'''
		.testStatements()
		.run();
		
		'''
			for(0;;);
			for(;;0, 0);
		'''
		.testStatements()
		.expectError(IssueCodes.InvalidStatementExpression, 1)
		.expectError(IssueCodes.InvalidStatementExpression, 2)
		.expectError(IssueCodes.InvalidStatementExpression, 2)
		.run();
	}

	@Test
	def void breakContinueStatement() {
		'''
			void test() {
				break;
				continue;
			}
		'''
		.testFunction()
		.expectError(IssueCodes.StrayControlFlowStatement, 2)
		.expectError(IssueCodes.StrayControlFlowStatement, 3)
		.run();
		
		'''
			TEST {
				encoding: 0;
				behavior: {
					break;
					continue;
				}
			}
		'''
		.testInstruction()
		.expectError(IssueCodes.StrayControlFlowStatement, 4)
		.expectError(IssueCodes.StrayControlFlowStatement, 5)
		.run();
		
		'''
			Core X {
				always {
					TEST {
						break;
						continue;
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.StrayControlFlowStatement, 4)
		.expectError(IssueCodes.StrayControlFlowStatement, 5)
		.run();
		
		'''
			switch(0) {
				default:
					break;
					continue;
			}
		'''
		.testStatements()
		.expectError(IssueCodes.StrayControlFlowStatement, 4)
		.run();
		
		'''
			while(0) {
				break;
				continue;
			}
		'''
		.testStatements()
		.run();
		
		'''
			do {
				break;
				continue;
			} while(0);
		'''
		.testStatements()
		.run();
		
		'''
			for(;;) {
				break;
				continue;
			}
		'''
		.testStatements()
		.run();
	}

	@Test
	def void returnStatement() {
		'''
			TEST {
				encoding: 0;
				behavior: {
					return;
				}
			}
		'''
		.testInstruction()
		.expectError(IssueCodes.ReturnStatementOutsideFunction, 4)
		.run();
		
		'''
			Core X {
				always {
					TEST {
						return;
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.ReturnStatementOutsideFunction, 4)
		.run();
		
		'''
			void test1() {
				return;
			}
			
			int test2() {
				return;
			}
			
			void test3() {
				return 0;
			}
			
			char test4() {
				return 128;
			}
		'''
		.testFunction()
		.expectError(IssueCodes.ReturnWithoutValueInNonVoidFunction, 6)
		.expectError(IssueCodes.ReturnWithValueInVoidFunction, 10)
		.expectError(IssueCodes.ReturnTypeNotConvertible, 14)
		.run();
	}
}
