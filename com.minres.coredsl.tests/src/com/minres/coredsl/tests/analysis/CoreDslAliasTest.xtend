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
class CoreDslAliasTest {
	
	@Inject extension CoreDslTestHelper testHelper;
	
	@Test
	def void arrayIndex() {
		// valid: first and last register
//		'''
//			Core C {
//				architectural_state {
//					register unsigned int X[32];
//					unsigned int& Y = X[0];
//					unsigned int& Z = X[31];
//				}
//			}
//		'''
//		.testProgram()
//		.run();
		
		// error: register index out of range
		'''
			Core C {
				architectural_state {
					register unsigned int X[32];
					unsigned int& Y = X[-1];
					unsigned int& Z = X[32];
				}
			}
		'''
		.testProgram()
		.expectWarning(IssueCodes.IndexOutOfRange, 4)
		.expectWarning(IssueCodes.IndexOutOfRange, 5)
		.run();
		
		// valid: first and last byte of memory
		'''
			Core C {
				architectural_state {
					extern unsigned char MEM[0x10000];
					unsigned char& Y = MEM[0x0000];
					unsigned char& Z = MEM[0xffff];
				}
			}
		'''
		.testProgram()
		.run();
		
		// error: memory index out of range
		'''
			Core C {
				architectural_state {
					extern unsigned char MEM[0x10000];
					unsigned char& Y = MEM[-1];
					unsigned char& Z = MEM[0x10000];
				}
			}
		'''
		.testProgram()
		.expectWarning(IssueCodes.IndexOutOfRange, 4)
		.expectWarning(IssueCodes.IndexOutOfRange, 5)
		.run();
	}
	
	@Test
	def void arrayRange() {
		// valid: first and last registers
		'''
			Core C {
				architectural_state {
					register unsigned int X[32];
					unsigned int& Y[4] = X[0:3];
					unsigned int& Z[4] = X[31:28];
				}
			}
		'''
		.testProgram()
		.run();
		
		// error: register ranges out of range
		'''
			Core C {
				architectural_state {
					register unsigned int X[32];
					unsigned int& Y[4] = X[-1:2];
					unsigned int& Z[4] = X[32:29];
				}
			}
		'''
		.testProgram()
		.expectWarning(IssueCodes.IndexOutOfRange, 4)
		.expectWarning(IssueCodes.IndexOutOfRange, 5)
		.run();
		
		// valid: first and last bytes of memory
		'''
			Core C {
				architectural_state {
					extern unsigned char MEM[0x10000];
					unsigned char& Y[0x100] = MEM[0x0000:0x00ff];
					unsigned char& Z[0x100] = MEM[0xffff:0xff00];
				}
			}
		'''
		.testProgram()
		.run();
		
		// error: memory ranges out of range
		'''
			Core C {
				architectural_state {
					extern unsigned char MEM[0x10000];
					unsigned char& Y[0x100] = MEM[-1:0x00fe];
					unsigned char& Z[0x100] = MEM[0x10000:0xff01];
				}
			}
		'''
		.testProgram()
		.expectWarning(IssueCodes.IndexOutOfRange, 4)
		.expectWarning(IssueCodes.IndexOutOfRange, 5)
		.run();
	}
	
	@Test
	def void bitRange() {
		// valid: first and last bits
		'''
			Core C {
				architectural_state {
					register unsigned<128> X;
					unsigned int& Y = X[0:31];
					unsigned int& Z = X[127:96];
				}
			}
		'''
		.testProgram()
		.run();
		
		// error: bit ranges out of range
		'''
			Core C {
				architectural_state {
					register unsigned<128> X;
					unsigned int& Y = X[-1:30];
					unsigned int& Z = X[128:97];
				}
			}
		'''
		.testProgram()
		.expectWarning(IssueCodes.IndexOutOfRange, 4)
		.expectWarning(IssueCodes.IndexOutOfRange, 5)
		.run();
		
		// valid: first and last bit
		'''
			Core C {
				architectural_state {
					register unsigned int EFLAGS;
					bool &ZF = EFLAGS[0];
					bool &SF = EFLAGS[31];
				}
			}
		'''
		.testProgram()
		.run();
		
		// valid: first and last bit
		'''
			Core C {
				architectural_state {
					register unsigned int EFLAGS;
					bool &ZF = EFLAGS[-1];
					bool &SF = EFLAGS[32];
				}
			}
		'''
		.testProgram()
		.expectWarning(IssueCodes.IndexOutOfRange, 4)
		.expectWarning(IssueCodes.IndexOutOfRange, 5)
		.run();
	}
	
	@Test
	def void constness() {
		// valid: const alias to const source
		'''
			Core C {
				architectural_state {
					const register unsigned int EAX;
					const unsigned short& AX = EAX[15:0];
				}
			}
		'''
		.testProgram()
		.run();
		
		// valid: const alias to non-const source
		'''
			Core C {
				architectural_state {
					register unsigned int EAX;
					const unsigned short& AX = EAX[15:0];
				}
			}
		'''
		.testProgram()
		.run();
		
		// error: non-const alias to const source
		'''
			Core C {
				architectural_state {
					const register unsigned int EAX;
					unsigned short& AX = EAX[15:0];
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidAliasConstness, 4)
		.run();
	}
	
	@Test
	def void declaration() {
		// error: local alias
		'''
			Core C {
				architectural_state {
					register int x;
				}
				functions {
					void testFunc() {
						int &y = x;
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.AliasLocalVariable, 7)
		.run();
		
		// error: uninitialized alias
		'''
			Core C {
				architectural_state {
					int &x;
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.UninitializedAlias, 3)
		.run();
		
		// error: alias with list initializer
		'''
			Core C {
				architectural_state {
					register int x1;
					register int x2;
					int &X[1] = {x1, x2};
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidListInitializer, 5)
		.run();
	}
	
	@Test
	def void source() {
		// error: alias to param
		'''
			Core C {
				architectural_state {
					int XLEN = 32;
					int &x = XLEN;
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidAliasSource, 4)
		.run();
		
		// error: alias to function
		'''
			Core C {
				architectural_state {
					int &x = testFunc;
				}
				functions {
					void testFunc() {}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidAliasSource, 3)
		.expectError(IssueCodes.ReferenceToFunction, 3)
		.run();
		
		// error: invalid alias init expression
		'''
			Core C {
				architectural_state {
					unsigned int &x = 0xffffffff;
					unsigned long &y = x :: x;
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidAliasSource, 3)
		.expectError(IssueCodes.InvalidAliasSource, 4)
		.run();
	}
}
