package com.minres.coredsl.tests.analysis

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.IndexAccessExpression
import com.minres.coredsl.tests.CoreDslInjectorProvider
import com.minres.coredsl.tests.CoreDslTestHelper
import com.minres.coredsl.type.ErrorType
import com.minres.coredsl.type.IntegerType
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 4)
		.expectWarning(IssueCodes.DuplicateIsaStateElement, 1)
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 8)
		.expectWarning(IssueCodes.DuplicateIsaStateElement, 6)
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 8)
		.expectWarning(IssueCodes.DuplicateIsaStateElement, 6)
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 4)
		.expectError(IssueCodes.DuplicateIsaStateElement, 1)
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 8)
		.expectError(IssueCodes.DuplicateIsaStateElement, 6)
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 8)
		.expectError(IssueCodes.DuplicateIsaStateElement, 6)
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 4)
		.expectError(IssueCodes.DuplicateIsaStateElement, 1)
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 8)
		.expectError(IssueCodes.DuplicateIsaStateElement, 6)
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 8)
		.expectError(IssueCodes.DuplicateIsaStateElement, 6)
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
		.expectWarning(IssueCodes.DuplicateIsaStateElement, 11)
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 11)
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
		.expectError(IssueCodes.DuplicateIsaStateElement, 11)
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
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures, 11)
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
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures, 11)
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
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures, 11)
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
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures, 11)
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
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures, 11)
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
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures, 11)
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
		.expectError(IssueCodes.MismatchingIsaStateElementSignatures, 11)
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
		.expectError(IssueCodes.InvalidIsaParameterDeclaration, 3)
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
		.expectWarning(IssueCodes.DuplicateIsaStateElement, 11)
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
		.expectWarning(IssueCodes.DuplicateIsaStateElement, 11)
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
		.expectError(IssueCodes.UnassignedIsaParameter, 6)
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
		.expectError(IssueCodes.UnassignedIsaParameter, 7)
		.expectError(IssueCodes.IndeterminableIsaStateElementValue, 7)
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
		.expectError(IssueCodes.IndeterminableIsaStateElementValue, 7)
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
		.expectError(IssueCodes.VoidDeclaration, 3)
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
		.expectError(IssueCodes.InvalidIsaParameterType, 4)
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
		.expectError(IssueCodes.IndeterminableIsaStateElementType, 8)
		.expectError(IssueCodes.IndeterminableIsaStateElementValue, 8)
		.run();
	}

	@Test
	def void aliasAssignmentWithIndeterminateType() {
		// Regression test for https://github.com/Minres/CoreDSL/issues/79
		// The alias initialization used to be flagged as invalid because the type
		// of X was indeterminate during partial elaboration of the instruction set
		'''
			InstructionSet A {
			    architectural_state {
			        unsigned int XLEN;
			        register unsigned<XLEN> X[32];
			        unsigned<XLEN>& ZERO = X[0];
			    }
			}
			Core X provides A {
				architectural_state {
					XLEN = 32;
				}
			}
		'''.testProgram()
		.run();
		// When a core doesn't define XLEN, the follow-up errors should be reported as well
		'''
			InstructionSet A {
			    architectural_state {
			        unsigned int XLEN;
			        register unsigned<XLEN> X[32];
			        unsigned<XLEN>& ZERO = X[0];
			    }
			}
			Core X provides A {}
		'''.testProgram()
		.expectError(IssueCodes.UnassignedIsaParameter, 8)
		.expectError(IssueCodes.IndeterminableIsaStateElementType, 8)
		.run();
	}

	@Test
	def void addressableTypes() {
		// This test checks the current limitation that address space range accesses
		// cannot have a combined total size greater than Integer.MAX_VALUE.
		'''
			Core X {
				architectural_state {
					extern unsigned char MEMORY[0x10000000000000000];
					unsigned char& HIGH_MEMORY[0x100000000] = MEMORY[0xffffffff00000000:0xffffffffffffffff];
					unsigned char& FIRST_BYTE = MEMORY[0];
				}
			}
		'''.testProgram()
		.expectType("X", "MEMORY", "address space unsigned<8>[18446744073709551616]")
		.expectType("X", IndexAccessExpression, 4, ErrorType.invalid)
		.expectType("X", IndexAccessExpression, 5, IntegerType.octet)
		.expectError(IssueCodes.InvalidIntegerTypeSize, 4)
		.run();
	}
}
