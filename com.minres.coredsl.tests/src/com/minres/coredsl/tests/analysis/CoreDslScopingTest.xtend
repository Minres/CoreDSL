package com.minres.coredsl.tests.analysis

import com.google.inject.Inject
import com.minres.coredsl.tests.CoreDslInjectorProvider
import com.minres.coredsl.tests.CoreDslTestHelper
import com.minres.coredsl.validation.IssueCodes
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslScopingTest {
	
	@Inject extension CoreDslTestHelper testHelper;
	
	@Test
	def void isaLevel() {
		// use before declaration: initializer
		'''
			Core C {
				architectural_state {
					unsigned int Y = Y;
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidIsaStateElementValue, 1)
		// the linking error is what we are really checking for, the one above may change
		.expectError(IssueCodes.LinkingError, 3)
		.run();
		
		// use before declaration: multiple initializers
		'''
			Core C {
				architectural_state {
					unsigned int Y = X, X = 5;
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidIsaStateElementValue, 1)
		// the linking error is what we are really checking for, the one above may change
		.expectError(IssueCodes.LinkingError, 3)
		.run();
		
		// use before declaration: use in type
		'''
			Core C {
				architectural_state {
					unsigned<X> X = 32;
					unsigned<bitsizeof(Y)> Y = 32;
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidIsaStateElementType, 1)
		// the linking errors are what we are really checking for, the one above may change
		.expectError(IssueCodes.LinkingError, 3)
		.expectError(IssueCodes.LinkingError, 4)
		.run();
	}
	
	@Test
	def void enums() {
		// access to enum members
		'''
			Core C {
				architectural_state {
					unsigned int X = 0;
					unsigned int Y = x;
					
					enum E {
						x = X
					}
				}
			}
		'''
		.testProgram()
		.run();
		
		'''
			Core C {
				architectural_state {
					unsigned int X = 0;
					
					enum E {
						x = X
					}
				}
			}
		'''
		.testProgram()
		.run();
	}
	
	@Test
	def void compoundStatement() {
		// use before declaration: initializer
		'''
			unsigned int y = y;
		'''
		.testStatements()
		.expectError(IssueCodes.LinkingError, 1)
		.run();
		
		// use before declaration: multiple initializers
		'''
			unsigned int y = x, x = 5;
		'''
		.testStatements()
		.expectError(IssueCodes.LinkingError, 1)
		.run();
		
		// use before declaration: use in type
		'''
			unsigned<X> X = 32;
			unsigned<bitsizeof(Y)> Y = 32;
		'''
		.testStatements()
		.expectError(IssueCodes.LinkingError, 1)
		.expectError(IssueCodes.LinkingError, 2)
		.run();
	}
	
	@Test
	def void forLoop() {
		// invalid access
		'''
			for(int x = x;;) {
				x = x;
			}
		'''
		.testStatements()
		.expectError(IssueCodes.LinkingError, 1)
		.run();
		
		// valid access
		'''
			int y = 0;
			for(int x = y; x < 10; x++) x = x;
		'''
		.testStatements()
		.run();
		
		// access to outer scope
		'''
			int x;
			for(x = 0; x < 10; x++) x = x;
		'''
		.testStatements()
		.run();
	}
}
