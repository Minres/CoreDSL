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
}


























