package com.minres.coredsl.tests.analysis

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.ExpressionInitializer
import com.minres.coredsl.coreDsl.Statement
import com.minres.coredsl.tests.CoreDslInjectorProvider
import com.minres.coredsl.tests.CoreDslTestHelper
import com.minres.coredsl.type.IntegerType
import com.minres.coredsl.validation.IssueCodes
import java.math.BigInteger
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

import static extension com.minres.coredsl.util.DataExtensions.*
import static extension com.minres.coredsl.util.ModelExtensions.*
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.FunctionCallExpression
import com.minres.coredsl.coreDsl.IndexAccessExpression
import com.minres.coredsl.type.ErrorType

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslExpressionTest {

	@Inject extension CoreDslTestHelper testHelper;
	
	def (EList<Statement>) => EObject initializerOf(String name) {
		return [
			it.flatMap[it.descendantsOfType(Declarator)]
			  .findFirst[it.name == name]
			  ?.initializer.castOrNull(ExpressionInitializer)
			  ?.value
		]
	}
	
	def (DescriptionContent) => EObject progInitializerOf(String name) {
		return [
			it.descendantsOfType(Declarator)
			  .findFirst[it.name == name]
			  ?.initializer.castOrNull(ExpressionInitializer)
			  ?.value
		]
	}
	
	@Test
	def booleanLiterals() {
		'''
			int a = true;
			int b = false;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(1), 0)
		.run();
	}

	@Test
	def void intLiteralsCStyle() {
		'''
			int a = 0b0;
			int b = 0B1;
			int c = 0B10;
			int d = 0b0011;
			int e = 0b0101010;
			unsigned<65> f = 0b1_00000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.unsigned(2), 2)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.unsigned(2), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.unsigned(6), 42)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.unsigned(65), BigInteger.ONE.shiftLeft(64))
		.run();
		
		'''
			int a = 00;
			int b = 01;
			int c = 02;
			int d = 0003;
			int e = 0052;
			unsigned<65> f = 02000000000000000000000;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.unsigned(2), 2)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.unsigned(2), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.unsigned(6), 42)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.unsigned(65), BigInteger.ONE.shiftLeft(64))
		.run();
		
		'''
			int a = 0;
			int b = 1;
			int c = 2;
			int d = 3;
			int e = 42;
			unsigned<65> f = 18_446_744_073_709_551_616;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.unsigned(2), 2)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.unsigned(2), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.unsigned(6), 42)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.unsigned(65), BigInteger.ONE.shiftLeft(64))
		.run();
		
		'''
			int a = 0x0;
			int b = 0X1;
			int c = 0x2;
			int d = 0X002a;
			int e = 0x002A;
			unsigned<65> f = 0x1_0000_0000_0000_0000;
			unsigned int g = 0xDeadBeef;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.unsigned(2), 2)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.unsigned(6), 42)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.unsigned(6), 42)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.unsigned(65), BigInteger.ONE.shiftLeft(64))
		.expectTypeAndValue(null, initializerOf('g'), IntegerType.unsigned(32), Integer.toUnsignedLong(0xdeadbeef))
		.run();
	}
	
	@Test
	def intLiteralsVerilogStyleUnsignedValid() {
		'''
			int a = 1'b0;
			int b = 1'b1;
			int c = 2'b1;
			int d = 3'b0011;
			int e = 6'b0101010;
			unsigned<65> f = 65'b1_00000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.unsigned(2), 1)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.unsigned(3), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.unsigned(6), 42)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.unsigned(65), BigInteger.ONE.shiftLeft(64))
		.run();
		
		'''
			int a = 1'o0;
			int b = 1'o1;
			int c = 2'o1;
			int d = 3'o003;
			int e = 6'o52;
			unsigned<65> f = 65'o2000000000000000000000;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.unsigned(2), 1)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.unsigned(3), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.unsigned(6), 42)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.unsigned(65), BigInteger.ONE.shiftLeft(64))
		.run();
		
		'''
			int a = 1'd0;
			int b = 1'd1;
			int c = 2'd1;
			int d = 3'd003;
			int e = 6'd42;
			unsigned<65> f = 65'd18_446_744_073_709_551_616;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.unsigned(2), 1)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.unsigned(3), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.unsigned(6), 42)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.unsigned(65), BigInteger.ONE.shiftLeft(64))
		.run();
		
		'''
			int a = 1'h0;
			int b = 1'h1;
			int c = 2'h1;
			int d = 3'h003;
			int e = 6'h2a;
			unsigned<65> f = 65'h1_0000_0000_0000_0000;
			unsigned int g = 32'hDeadBeef;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.unsigned(2), 1)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.unsigned(3), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.unsigned(6), 42)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.unsigned(65), BigInteger.ONE.shiftLeft(64))
		.expectTypeAndValue(null, initializerOf('g'), IntegerType.unsigned(32), Integer.toUnsignedLong(0xdeadbeef))
		.run();
	}
	
	@Test
	def intLiteralsVerilogStyleUnsignedInvalid() {
		'''
			int a = 0'b0;
		'''
		.testStatements()
		.expectSyntaxErrors()
		.run();
		
		'''
			int a = 1'b10;
		'''
		.testStatements()
		.expectSyntaxErrors()
		.run();
		
		'''
			int a = 2'o4;
		'''
		.testStatements()
		.expectSyntaxErrors()
		.run();
		
		'''
			int a = 3'd8;
		'''
		.testStatements()
		.expectSyntaxErrors()
		.run();
		
		'''
			int a = 5'h20;
		'''
		.testStatements()
		.expectSyntaxErrors()
		.run();
	}
	
	@Test
	def intLiteralsVerilogStyleSignedValid() {
		'''
			int a = 1'sb0;
			int b = 1'sb1;
			int c = 2'sb1;
			int d = 3'sb0011;
			int e = 6'sb0101010;
			signed<65> f = 65'sb1_00000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.signed(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.signed(1), -1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.signed(2), 1)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.signed(3), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.signed(6), -22)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.signed(65), -BigInteger.ONE.shiftLeft(64))
		.run();
		
		'''
			int a = 1'so0;
			int b = 1'so1;
			int c = 2'so1;
			int d = 3'so003;
			int e = 6'so52;
			signed<65> f = 65'so2000000000000000000000;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.signed(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.signed(1), -1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.signed(2), 1)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.signed(3), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.signed(6), -22)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.signed(65), -BigInteger.ONE.shiftLeft(64))
		.run();
		
		'''
			int a = 1'sd0;
			int b = 1'sd1;
			int c = 2'sd1;
			int d = 3'sd003;
			int e = 6'sd42;
			signed<65> f = 65'sd18_446_744_073_709_551_616;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.signed(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.signed(1), -1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.signed(2), 1)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.signed(3), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.signed(6), -22)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.signed(65), -BigInteger.ONE.shiftLeft(64))
		.run();
		
		'''
			int a = 1'sh0;
			int b = 1'sh1;
			int c = 2'sh1;
			int d = 3'sh003;
			int e = 6'sh2a;
			signed<65> f = 65'sh1_0000_0000_0000_0000;
			int g = 32'shDeadBeef;
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.signed(1), 0)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.signed(1), -1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.signed(2), 1)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.signed(3), 3)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.signed(6), -22)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.signed(65), -BigInteger.ONE.shiftLeft(64))
		.expectTypeAndValue(null, initializerOf('g'), IntegerType.signed(32), 0xdeadbeef)
		.run();
	}
	
	@Test
	def intLiteralsVerilogStyleSignedInvalid() {
		'''
			int a = 0'sb0;
		'''
		.testStatements()
		.expectSyntaxErrors()
		.run();
		
		'''
			int a = 1'sb10;
		'''
		.testStatements()
		.expectSyntaxErrors()
		.run();
		
		'''
			int a = 2'so4;
		'''
		.testStatements()
		.expectSyntaxErrors()
		.run();
		
		'''
			int a = 3'sd8;
		'''
		.testStatements()
		.expectSyntaxErrors()
		.run();
		
		'''
			int a = 5'sh20;
		'''
		.testStatements()
		.expectSyntaxErrors()
		.run();
	}
	
	@Test
	def intrinsicSizeOfValid() {
		'''
			int a = bitsizeof(1'b0);
			int b = bitsizeof(8'b101010);
			int c = bitsizeof(24'd0);
			
			signed<14> d = bitsizeof(c);
			int e = bitsizeof(d);
			
			int f = bitsizeof(int);
			int g = bitsizeof(unsigned<1337>);
		'''
		.testStatements()
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(4), 8)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.unsigned(5), 24)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.unsigned(6), 32)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.unsigned(4), 14)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.unsigned(6), 32)
		.expectTypeAndValue(null, initializerOf('g'), IntegerType.unsigned(11), 1337)
		.run();
		
		'''
			int a = sizeof(1'b0);
			int b = sizeof(8'b101010);
			int c = sizeof(24'b101010);
			
			signed<14> d = sizeof(c);
			int e = sizeof(d);
			
			int f = sizeof(int);
			int g = sizeof(unsigned<1337>);
		'''
		.testStatements()
		.expectWarning(IssueCodes.SizeOfNotExact, 1)
		.expectWarning(IssueCodes.SizeOfNotExact, 6)
		.expectWarning(IssueCodes.SizeOfNotExact, 9)
		.expectTypeAndValue(null, initializerOf('a'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('b'), IntegerType.unsigned(1), 1)
		.expectTypeAndValue(null, initializerOf('c'), IntegerType.unsigned(2), 3)
		.expectTypeAndValue(null, initializerOf('d'), IntegerType.unsigned(3), 4)
		.expectTypeAndValue(null, initializerOf('e'), IntegerType.unsigned(2), 2)
		.expectTypeAndValue(null, initializerOf('f'), IntegerType.unsigned(3), 4)
		.expectTypeAndValue(null, initializerOf('g'), IntegerType.unsigned(8), 168)
		.run();
	}
	
	@Test
	def intrinsicSizeOfInvalid() {
		'''
			int a = bitsizeof();
			int b = bitsizeof(1, 2);
		'''
		.testStatements()
		.expectError(IssueCodes.InvalidArgumentCount, 1)
		.expectError(IssueCodes.InvalidArgumentCount, 2)
		.run();
		
		'''
			int a = sizeof();
			int b = sizeof(1, 2);
		'''
		.testStatements()
		.expectError(IssueCodes.InvalidArgumentCount, 1)
		.expectError(IssueCodes.InvalidArgumentCount, 2)
		.run();
		
		'''
			Core X {
				architectural_state {
					int x = bitsizeof(255 + 1);
					int y = sizeof(255 + 1);
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidIsaStateElementValue, 1)
		.expectError(IssueCodes.UnsupportedSizeOfDuringElaboration, 3)
		.expectError(IssueCodes.UnsupportedSizeOfDuringElaboration, 4)
		.run();
	}

	@Test
	def castExpression() {
		'''
			long a = (int)0;
			long b = (int)0x100000000;
		'''
		.testStatements()
		.expectType(null, initializerOf('a'), IntegerType.signed(32))
		.expectType(null, initializerOf('b'), IntegerType.signed(32))
		.run();
		
		'''
			long a = (unsigned int)0;
			long b = (unsigned int)0x100000000;
		'''
		.testStatements()
		.expectType(null, initializerOf('a'), IntegerType.unsigned(32))
		.expectType(null, initializerOf('b'), IntegerType.unsigned(32))
		.run();
		
		'''
			long a = (signed<14>)0;
			long b = (unsigned<14>)0;
		'''
		.testStatements()
		.expectType(null, initializerOf('a'), IntegerType.signed(14))
		.expectType(null, initializerOf('b'), IntegerType.unsigned(14))
		.run();
		
		'''
			long a = (signed)(unsigned int)0;
			long b = (unsigned)(signed int)0;
		'''
		.testStatements()
		.expectType(null, initializerOf('a'), IntegerType.signed(32))
		.expectType(null, initializerOf('b'), IntegerType.unsigned(32))
		.run();
		
		
		'''
			long a = (signed)(signed int)0;
			long b = (unsigned)(unsigned int)0;
			long c = (signed int)(signed int)0;
			long d = (unsigned int)(unsigned int)0;
		'''
		.testStatements()
		.expectType(null, initializerOf('a'), IntegerType.signed(32))
		.expectType(null, initializerOf('b'), IntegerType.unsigned(32))
		.expectType(null, initializerOf('c'), IntegerType.signed(32))
		.expectType(null, initializerOf('d'), IntegerType.unsigned(32))
		.expectWarning(IssueCodes.IdentityCast, 1)
		.expectWarning(IssueCodes.IdentityCast, 2)
		.expectWarning(IssueCodes.IdentityCast, 3)
		.expectWarning(IssueCodes.IdentityCast, 4)
		.run();
	}

	@Test
	def concatenationExpression() {
		'''
			unsigned<1> u1;
			unsigned<2> u2;
			unsigned<4> u4;
			signed<1> s1;
			signed<2> s2;
			signed<4> s4;
			
			long a = u1 :: u2 :: u4;
			long b = s1 :: s2 :: s4;
		'''
		.testStatements()
		.expectType(null, initializerOf('a'), IntegerType.unsigned(7))
		.expectType(null, initializerOf('b'), IntegerType.unsigned(7))
		.run();
	}

	@Test
	def conditionalExpression() {
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
						
						bool b1 = t ? 1 : 0;
						bool b2 = a ? 1 : 0;
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.NonScalarCondition, 12)
		.expectError(IssueCodes.NonScalarCondition, 13)
		.run();
		
		'''
			unsigned<16> u16;
			unsigned<32> u32;
			signed<16> s16;
			signed<32> s32;
			
			long a = true ? u32 : u32;
			long b = true ? s32 : s32;
			long c = true ? u16 : u32;
			long d = true ? u32 : u16;
			long e = true ? s16 : s32;
			long f = true ? s32 : s16;
			
			long g = true ? s32 : u16;
			long h = true ? u16 : s32;
			
			long i = true ? s16 : u32;
			long j = true ? u32 : s16;
		'''
		.testStatements()
		.expectType(null, initializerOf('a'), IntegerType.unsigned(32))
		.expectType(null, initializerOf('b'), IntegerType.signed(32))
		.expectType(null, initializerOf('c'), IntegerType.unsigned(32))
		.expectType(null, initializerOf('d'), IntegerType.unsigned(32))
		.expectType(null, initializerOf('e'), IntegerType.signed(32))
		.expectType(null, initializerOf('f'), IntegerType.signed(32))
		.expectType(null, initializerOf('g'), IntegerType.signed(32))
		.expectType(null, initializerOf('h'), IntegerType.signed(32))
		.expectType(null, initializerOf('i'), IntegerType.signed(33))
		.expectType(null, initializerOf('j'), IntegerType.signed(33))
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
						
						struct T t1 = true ? t : t;
						struct T t2 = true ? t : 0;
						struct T t3 = true ? 0 : t;
						
						int a1[1] = true ? a : a;
						int a2[1] = true ? a : 0;
						int a3[1] = true ? 0 : a;
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.IncompatibleOptionTypes, 13)
		.expectError(IssueCodes.IncompatibleOptionTypes, 14)
		.expectError(IssueCodes.IncompatibleOptionTypes, 17)
		.expectError(IssueCodes.IncompatibleOptionTypes, 18)
		.run();
	}
	
	@Test
	def entityReference() {
		'''
			int x = testFunc;
		'''
		.testStatements()
		.expectError(IssueCodes.ReferenceToFunction, 1)
		.run();
	}
	
	@Test
	def functionCallExpression() {
		'''
			InstructionSet TestISA {
				functions {
					signed<42> double(signed<41> value) {
						return value + value;
					}
						
					void testFunc() {
						double();
						double(5);
						double((long)0);
						double(1, 2);
					}
				}
			}
		'''
		.testProgram()
		.expectType(null, FunctionCallExpression, 8, IntegerType.signed(42))
		.expectType(null, FunctionCallExpression, 9, IntegerType.signed(42))
		.expectType(null, FunctionCallExpression, 10, IntegerType.signed(42))
		.expectType(null, FunctionCallExpression, 11, IntegerType.signed(42))
		.expectError(IssueCodes.InvalidArgumentCount, 8)
		.expectError(IssueCodes.InvalidArgumentType, 10)
		.expectError(IssueCodes.InvalidArgumentCount, 11)
		.run();
		
		'''
			int a;
			a();
			a(17);
		'''
		.testStatements()
		.expectError(IssueCodes.InvalidFunction, 2)
		.expectError(IssueCodes.InvalidFunction, 3)
		.run();
	}
	
	@Test
	def indexAccessExpression() {
		'''
			InstructionSet TestISA {
				architectural_state {
					extern unsigned char mem[4];
				}
				functions {
					void testFunc() {
						unsigned char arr[4];
						unsigned<4> val;
						int i = 1;
						long v;
						
						v = mem[0];
						v = mem[3:1];
						v = mem[i:i-1];
						
						v = arr[0];
						v = arr[3:1];
						v = arr[i:i-1];
						
						v = val[0];
						v = val[3:1];
						v = val[i:i-1];
					}
				}
			}
		'''
		.testProgram()
		.expectType(null, IndexAccessExpression, 12, IntegerType.unsigned(8))
		.expectType(null, IndexAccessExpression, 13, IntegerType.unsigned(24))
		.expectType(null, IndexAccessExpression, 14, IntegerType.unsigned(16))
		.expectType(null, IndexAccessExpression, 16, IntegerType.unsigned(8))
		.expectType(null, IndexAccessExpression, 17, IntegerType.unsigned(24))
		.expectType(null, IndexAccessExpression, 18, IntegerType.unsigned(16))
		.expectType(null, IndexAccessExpression, 20, IntegerType.unsigned(1))
		.expectType(null, IndexAccessExpression, 21, IntegerType.unsigned(3))
		.expectType(null, IndexAccessExpression, 22, IntegerType.unsigned(2))
		.run();
		
		'''
			unsigned char a[4];
			long v1 = a[0];
			long v2 = a[3];
			long v3 = a[-1];
			long v4 = a[4];
		'''
		.testStatements()
		.expectType(null, initializerOf('v1'), IntegerType.unsigned(8))
		.expectType(null, initializerOf('v2'), IntegerType.unsigned(8))
		.expectType(null, initializerOf('v3'), IntegerType.unsigned(8))
		.expectType(null, initializerOf('v4'), IntegerType.unsigned(8))
		.run();
		
		'''
			unsigned char a[4];
			long v1 = a[0:3];
			long v2 = a[3:0];
			long v3 = a[0:1];
			long v4 = a[3:2];
		'''
		.testStatements()
		.expectType(null, initializerOf('v1'), IntegerType.unsigned(32))
		.expectType(null, initializerOf('v2'), IntegerType.unsigned(32))
		.expectType(null, initializerOf('v3'), IntegerType.unsigned(16))
		.expectType(null, initializerOf('v4'), IntegerType.unsigned(16))
		.run();
		
		'''
			unsigned char a[4];
			long v1 = a[a];
			long v2 = a[0:a];
			long v3 = a[a:0];
		'''
		.testStatements()
		.expectError(IssueCodes.InvalidIndexType, 2)
		.expectError(IssueCodes.InvalidIndexType, 3)
		.expectError(IssueCodes.InvalidIndexType, 4)
		.run();
		
		'''
			unsigned char a[4];
			int i = 1;
			
			long v1 = a[i];
			long v2 = a[i:i];
			long v3 = a[i:i+1];
			long v4 = a[i:i-1];
			long v5 = a[i+1:i];
			long v6 = a[i-1:i];
		'''
		.testStatements()
		.expectType(null, initializerOf('v1'), IntegerType.unsigned(8))
		.expectType(null, initializerOf('v2'), IntegerType.unsigned(8))
		.expectType(null, initializerOf('v3'), IntegerType.unsigned(16))
		.expectType(null, initializerOf('v4'), IntegerType.unsigned(16))
		.expectType(null, initializerOf('v5'), IntegerType.unsigned(16))
		.expectType(null, initializerOf('v6'), IntegerType.unsigned(16))
		.run();
		
		'''
			Core TestISA {
				functions {	
					void testFunc() {
						unsigned char a[4];
						int i = 1, j = 1;
						
						long v1 = a[0:i];
						long v2 = a[i:0];
						long v3 = a[i:j];
						long v4 = a[i:1+i];
						long v5 = a[i:1-i];
						long v6 = a[1+i:i];
						long v7 = a[1-i:i];
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidRangePattern, 7)
		.expectError(IssueCodes.InvalidRangePattern, 8)
		.expectError(IssueCodes.InvalidRangePattern, 9)
		.expectError(IssueCodes.InvalidRangePattern, 10)
		.expectError(IssueCodes.InvalidRangePattern, 11)
		.expectError(IssueCodes.InvalidRangePattern, 12)
		.expectError(IssueCodes.InvalidRangePattern, 13)
		.run();
	}
	
	@Test
	def logicOperators() {
		'''
			long v1 = true || false;
			long v2 = 1 || 0;
			long v3 = 42 || 720;
			long v4 = -1 || 0xfffffffffffffffffffff;
			
			long v5 = true && false;
			long v6 = 1 && 0;
			long v7 = 42 && 720;
			long v8 = -1 && 0xfffffffffffffffffffff;
		'''
		.testStatements()
		.expectType(null, initializerOf('v1'), IntegerType.bool)
		.expectType(null, initializerOf('v2'), IntegerType.bool)
		.expectType(null, initializerOf('v3'), IntegerType.bool)
		.expectType(null, initializerOf('v4'), IntegerType.bool)
		.expectType(null, initializerOf('v5'), IntegerType.bool)
		.expectType(null, initializerOf('v6'), IntegerType.bool)
		.expectType(null, initializerOf('v7'), IntegerType.bool)
		.expectType(null, initializerOf('v8'), IntegerType.bool)
		.run();
		
		'''
			int a[4];
			long v1 = a || false;
			long v2 = true || a;
			long v3 = a || a;
			
			long v4 = a && false;
			long v5 = true && a;
			long v6 = a && a;
		'''
		.testStatements()
		.expectError(IssueCodes.InvalidOperationType, 2)
		.expectError(IssueCodes.InvalidOperationType, 3)
		.expectError(IssueCodes.InvalidOperationType, 4)
		.expectError(IssueCodes.InvalidOperationType, 6)
		.expectError(IssueCodes.InvalidOperationType, 7)
		.expectError(IssueCodes.InvalidOperationType, 8)
		.expectType(null, initializerOf('v1'), IntegerType.bool)
		.expectType(null, initializerOf('v2'), IntegerType.bool)
		.expectType(null, initializerOf('v3'), IntegerType.bool)
		.expectType(null, initializerOf('v4'), IntegerType.bool)
		.expectType(null, initializerOf('v5'), IntegerType.bool)
		.expectType(null, initializerOf('v6'), IntegerType.bool)
		.run();
	}
	
	@Test
	def bitwiseOperators() {
		'''
			long v1 = true | false;
			long v2 = 6'h33 | 15'h7755;
			long v3 = 8'shff | 8'haa;
			
			long v4 = true & false;
			long v5 = 6'h33 & 15'h7755;
			long v6 = 8'shff & 8'haa;
			
			long v7 = true ^ false;
			long v8 = 6'h33 ^ 15'h7755;
			long v9 = 8'shff ^ 8'haa;
		'''
		.testStatements()
		.expectType(null, initializerOf('v1'), IntegerType.bool)
		.expectType(null, initializerOf('v2'), IntegerType.unsigned(15))
		.expectType(null, initializerOf('v3'), IntegerType.signed(8))
		.expectType(null, initializerOf('v4'), IntegerType.bool)
		.expectType(null, initializerOf('v5'), IntegerType.unsigned(15))
		.expectType(null, initializerOf('v6'), IntegerType.signed(8))
		.expectType(null, initializerOf('v7'), IntegerType.bool)
		.expectType(null, initializerOf('v8'), IntegerType.unsigned(15))
		.expectType(null, initializerOf('v9'), IntegerType.signed(8))
		.run();
		
		'''
			int a[4];
			long v1 = a | false;
			long v2 = true | a;
			long v3 = a | a;
			
			long v4 = a & false;
			long v5 = true & a;
			long v6 = a & a;
			
			long v7 = a ^ false;
			long v8 = true ^ a;
			long v9 = a ^ a;
		'''
		.testStatements()
		.expectError(IssueCodes.InvalidOperationType, 2)
		.expectError(IssueCodes.InvalidOperationType, 3)
		.expectError(IssueCodes.InvalidOperationType, 4)
		.expectError(IssueCodes.InvalidOperationType, 6)
		.expectError(IssueCodes.InvalidOperationType, 7)
		.expectError(IssueCodes.InvalidOperationType, 8)
		.expectError(IssueCodes.InvalidOperationType, 10)
		.expectError(IssueCodes.InvalidOperationType, 11)
		.expectError(IssueCodes.InvalidOperationType, 12)
		.expectType(null, initializerOf('v1'), ErrorType.invalid)
		.expectType(null, initializerOf('v2'), ErrorType.invalid)
		.expectType(null, initializerOf('v3'), ErrorType.invalid)
		.expectType(null, initializerOf('v4'), ErrorType.invalid)
		.expectType(null, initializerOf('v5'), ErrorType.invalid)
		.expectType(null, initializerOf('v6'), ErrorType.invalid)
		.expectType(null, initializerOf('v7'), ErrorType.invalid)
		.expectType(null, initializerOf('v8'), ErrorType.invalid)
		.expectType(null, initializerOf('v9'), ErrorType.invalid)
		.run();
	}
	
	@Test
	def equalityComparison() {
		'''
			long v1 = true == false;
			long v2 = 6'd42 == 15'd720;
			long v3 = 8'shff == 8'hff;
			
			long v4 = true != false;
			long v5 = 6'd42 != 15'd720;
			long v6 = 8'shff != 8'hff;
		'''
		.testStatements()
		.expectType(null, initializerOf('v1'), IntegerType.bool)
		.expectType(null, initializerOf('v2'), IntegerType.bool)
		.expectType(null, initializerOf('v3'), IntegerType.bool)
		.expectType(null, initializerOf('v4'), IntegerType.bool)
		.expectType(null, initializerOf('v5'), IntegerType.bool)
		.expectType(null, initializerOf('v6'), IntegerType.bool)
		.run();
		
		'''
			int a[4];
			long v1 = a == false;
			long v2 = true == a;
			long v3 = a == a;
			
			long v4 = a != false;
			long v5 = true != a;
			long v6 = a != a;
		'''
		.testStatements()
		.expectError(IssueCodes.InvalidOperationType, 2)
		.expectError(IssueCodes.InvalidOperationType, 3)
		.expectError(IssueCodes.InvalidOperationType, 6)
		.expectError(IssueCodes.InvalidOperationType, 7)
		.expectType(null, initializerOf('v1'), IntegerType.bool)
		.expectType(null, initializerOf('v2'), IntegerType.bool)
		.expectType(null, initializerOf('v3'), IntegerType.bool)
		.expectType(null, initializerOf('v4'), IntegerType.bool)
		.expectType(null, initializerOf('v5'), IntegerType.bool)
		.expectType(null, initializerOf('v6'), IntegerType.bool)
		.run();
		
		'''
			InstructionSet TestISA {
				architectural_state {
					extern unsigned char mem[4];
				}
				functions {
					void testFunc() {
						bool equal = mem == mem;
					}
				}
			}
		'''
		.testProgram()
		.expectError(IssueCodes.InvalidOperationType, 7)
		.run();
	}
	
	@Test
	def magnitudeComparison() {
		'''
			long v1 = 6'd42 < 15'd720;
			long v2 = 8'shff < 8'hff;
			
			long v3 = 6'd42 > 15'd720;
			long v4 = 8'shff > 8'hff;
			
			long v5 = 6'd42 <= 15'd720;
			long v6 = 8'shff <= 8'hff;
			
			long v7 = 6'd42 >= 15'd720;
			long v8 = 8'shff >= 8'hff;
		'''
		.testStatements()
		.expectType(null, initializerOf('v1'), IntegerType.bool)
		.expectType(null, initializerOf('v2'), IntegerType.bool)
		.expectType(null, initializerOf('v3'), IntegerType.bool)
		.expectType(null, initializerOf('v4'), IntegerType.bool)
		.expectType(null, initializerOf('v5'), IntegerType.bool)
		.expectType(null, initializerOf('v6'), IntegerType.bool)
		.expectType(null, initializerOf('v7'), IntegerType.bool)
		.expectType(null, initializerOf('v8'), IntegerType.bool)
		.run();
		
		'''
			int a[4];
			long v1 = a < 0;
			long v2 = 0 < a;
			long v3 = a < a;
			
			long v4 = a > 0;
			long v5 = 0 > a;
			long v6 = a > a;
			
			long v7 = a <= 0;
			long v8 = 0 <= a;
			long v9 = a <= a;
			
			long v10 = a >= 0;
			long v11 = 0 >= a;
			long v12 = a >= a;
		'''
		.testStatements()
		.expectError(IssueCodes.InvalidOperationType, 2)
		.expectError(IssueCodes.InvalidOperationType, 3)
		.expectError(IssueCodes.InvalidOperationType, 4)
		.expectError(IssueCodes.InvalidOperationType, 6)
		.expectError(IssueCodes.InvalidOperationType, 7)
		.expectError(IssueCodes.InvalidOperationType, 8)
		.expectError(IssueCodes.InvalidOperationType, 10)
		.expectError(IssueCodes.InvalidOperationType, 11)
		.expectError(IssueCodes.InvalidOperationType, 12)
		.expectError(IssueCodes.InvalidOperationType, 14)
		.expectError(IssueCodes.InvalidOperationType, 15)
		.expectError(IssueCodes.InvalidOperationType, 16)
		.expectType(null, initializerOf('v1'), IntegerType.bool)
		.expectType(null, initializerOf('v2'), IntegerType.bool)
		.expectType(null, initializerOf('v3'), IntegerType.bool)
		.expectType(null, initializerOf('v4'), IntegerType.bool)
		.expectType(null, initializerOf('v5'), IntegerType.bool)
		.expectType(null, initializerOf('v6'), IntegerType.bool)
		.expectType(null, initializerOf('v7'), IntegerType.bool)
		.expectType(null, initializerOf('v8'), IntegerType.bool)
		.expectType(null, initializerOf('v9'), IntegerType.bool)
		.expectType(null, initializerOf('v10'), IntegerType.bool)
		.expectType(null, initializerOf('v11'), IntegerType.bool)
		.expectType(null, initializerOf('v12'), IntegerType.bool)
		.run();
	}
}


























