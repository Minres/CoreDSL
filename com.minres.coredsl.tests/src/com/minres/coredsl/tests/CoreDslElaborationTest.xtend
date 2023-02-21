package com.minres.coredsl.tests

import com.google.inject.Inject
import com.minres.coredsl.validation.IssueCodes
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslElaborationTest {
	
	@Inject extension CoreDslTestHelper testHelper;

	@Test
	def void valid() {
		'''
			InstructionSet A {
				architectural_state {
					int x;
				}
			}
			Core X provides A {
				architectural_state {
					x = 1;
				}
			}
		'''.testProgram().run();
		'''
			InstructionSet Base {
				architectural_state {
					int x;
				}
			}
			InstructionSet A extends Base {}
			InstructionSet B extends Base {}
			Core X provides A, B {
				architectural_state {
					x = 1;
				}
			}
		'''.testProgram().run();
		'''
			InstructionSet A {
				architectural_state {
					register int x;
					int &y = x;
				}
			}
			Core X provides A {}
		'''.testProgram().run();
	}

	@Test
	def void duplicateIsaStateElement1() {
		// error, warning: duplicate parameter within the same instruction set
		'''
			InstructionSet A {
				architectural_state {
					int x;
					int x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.expectWarning(IssueCodes.DuplicateIsaStateElement)
		.run();
		// error, warning: duplicate parameter in derived instruction set
		'''
			InstructionSet A {
				architectural_state {
					int x;
				}
			}
			InstructionSet B extends A {
				architectural_state {
					int x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.expectWarning(IssueCodes.DuplicateIsaStateElement)
		.run();
		// error, warning: duplicate parameter in core definition
		'''
			InstructionSet A {
				architectural_state {
					int x;
				}
			}
			Core X provides A {
				architectural_state {
					int x = 32;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.expectWarning(IssueCodes.DuplicateIsaStateElement)
		.run();

		// error, error: duplicate register within the same instruction set
		'''
			InstructionSet A {
				architectural_state {
					register int x;
					register int x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.run();
		// error, error: duplicate register in derived instruction set
		'''
			InstructionSet A {
				architectural_state {
					register int x;
				}
			}
			InstructionSet B extends A {
				architectural_state {
					register int x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.run();
		// error, error: duplicate register in core definition
		'''
			InstructionSet A {
				architectural_state {
					register int x;
				}
			}
			Core X provides A {
				architectural_state {
					register int x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.run();

		// error, error: duplicate extern within the same instruction set
		'''
			InstructionSet A {
				architectural_state {
					extern int x;
					extern int x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.run();
		// error, error: duplicate extern in derived instruction set
		'''
			InstructionSet A {
				architectural_state {
					extern int x;
				}
			}
			InstructionSet B extends A {
				architectural_state {
					extern int x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.run();
		// error, error: duplicate extern in core definition
		'''
			InstructionSet A {
				architectural_state {
					extern int x;
				}
			}
			Core X provides A {
				architectural_state {
					extern int x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.run();
	}

	@Test
	def void duplicateIsaStateElement2() {
		// warning: conflicting parameters visible from the same core
		'''
			InstructionSet A {
				architectural_state {
					int x;
				}
			}
			InstructionSet B {
				architectural_state {
					int x;
				}
			}
			Core X provides A, B {
				architectural_state {
					x = 1;
				}
			}
		'''.testProgram()
		.expectWarning(IssueCodes.DuplicateIsaStateElement)
		.run();
		// error: conflicting registers visible from the same core
		'''
			InstructionSet A {
				architectural_state {
					register int x;
				}
			}
			InstructionSet B {
				architectural_state {
					register int x;
				}
			}
			Core X provides A, B {}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.run();
		// error: conflicting externs visible from the same core
		'''
			InstructionSet A {
				architectural_state {
					extern int x;
				}
			}
			InstructionSet B {
				architectural_state {
					extern int x;
				}
			}
			Core X provides A, B {}
		'''.testProgram()
		.expectError(IssueCodes.DuplicateIsaStateElement)
		.run();
	}

	@Test
	def void mismatchingSignatures() {
		// error: conflicting storage class (param, register)
		'''
			InstructionSet A {
				architectural_state {
					int x = 1;
				}
			}
			InstructionSet B {
				architectural_state {
					register int x;
				}
			}
			Core X provides A, B {}
		'''.testProgram()
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures)
		.run();
		// error: conflicting storage class (param, extern)
		'''
			InstructionSet A {
				architectural_state {
					int x = 1;
				}
			}
			InstructionSet B {
				architectural_state {
					extern int x;
				}
			}
			Core X provides A, B {}
		'''.testProgram()
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures)
		.run();
		// error: conflicting storage class (register, extern)
		'''
			InstructionSet A {
				architectural_state {
					register int x;
				}
			}
			InstructionSet B {
				architectural_state {
					extern int x;
				}
			}
			Core X provides A, B {}
		'''.testProgram()
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures)
		.run();

		// error: conflicting const qualifier
		'''
			InstructionSet A {
				architectural_state {
					const int x = 1;
				}
			}
			InstructionSet B {
				architectural_state {
					int x = 1;
				}
			}
			Core X provides A, B {}
		'''.testProgram()
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures)
		.run();
		// error: conflicting volatile qualifier
		'''
			InstructionSet A {
				architectural_state {
					volatile extern int x;
				}
			}
			InstructionSet B {
				architectural_state {
					extern int x;
				}
			}
			Core X provides A, B {}
		'''.testProgram()
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures)
		.run();

		// error: conflicting types
		'''
			InstructionSet A {
				architectural_state {
					signed int x = 1;
				}
			}
			InstructionSet B {
				architectural_state {
					unsigned int x = 1;
				}
			}
			Core X provides A, B {}
		'''.testProgram()
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures)
		.run();
		// error: conflicting types
		'''
			InstructionSet A {
				architectural_state {
					unsigned<32> x = 1;
				}
			}
			InstructionSet B {
				architectural_state {
					unsigned<33> x = 1;
				}
			}
			Core X provides A, B {}
		'''.testProgram()
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures)
		.run();
	}

	@Test
	def void invalidParameterDeclaration() {
		// error: array parameter
		'''
			InstructionSet A {
				architectural_state {
					int x[16];
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.InvalidIsaParameterDeclaration)
		.run();
	}

	@Test
	def void validParameters() {
		// warning: duplicate, but compatible parameter declarations
		'''
			InstructionSet A {
				architectural_state {
					int x;
				}
			}
			InstructionSet B {
				architectural_state {
					int x = 1;
				}
			}
			Core C provides A, B {}
		'''.testProgram()
		.expectWarning(IssueCodes.DuplicateIsaStateElement)
		.run();
		
		// warning: duplicate, but compatible parameter declarations
		'''
			InstructionSet A {
				architectural_state {
					int x = 1;
				}
			}
			InstructionSet B {
				architectural_state {
					int x;
				}
			}
			Core C provides A, B {}
		'''.testProgram()
		.expectWarning(IssueCodes.DuplicateIsaStateElement)
		.run();
	}

	@Test
	def void errorValues() {
		// error: unassigned parameter
		'''
			InstructionSet A {
				architectural_state {
					int x;
				}
			}
			Core X provides A {}
		'''.testProgram()
		.expectError(IssueCodes.UnassignedIsaParameter)
		.run();
		// error: dependency on unassigned value
		'''
			InstructionSet A {
				architectural_state {
					int x;
					int y;
				}
			}
			Core X provides A {
				architectural_state {
					y = x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.UnassignedIsaParameter)
		.expectError(IssueCodes.IndeterminableIsaStateElementValue)
		.run();
		// error: cyclic value dependency
		'''
			InstructionSet A {
				architectural_state {
					int x;
					int y;
				}
			}
			Core X provides A {
				architectural_state {
					x = y;
					y = x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.IndeterminableIsaStateElementValue)
		.run();
	}

	@Test
	def void errorTypes() {
		// error: void type
		'''
			InstructionSet A {
				architectural_state {
					extern void x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.VoidDeclaration)
		.run();
		// error: non-integral parameter type
		'''
			InstructionSet A {
				architectural_state {
					struct T { int f; }
					struct T x;
				}
			}
		'''.testProgram()
		.expectError(IssueCodes.InvalidIsaParameterType)
		.run();
		// error: cyclic type-value dependency
		'''
			InstructionSet A {
				architectural_state {
					int x;
					extern unsigned<x> y;
					x = bitsizeof(y);
				}
			}
			Core X provides A {}
		'''.testProgram()
		.expectError(IssueCodes.IndeterminableIsaStateElementType)
		.expectError(IssueCodes.IndeterminableIsaStateElementValue)
		.run();
	}
}
