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
}
