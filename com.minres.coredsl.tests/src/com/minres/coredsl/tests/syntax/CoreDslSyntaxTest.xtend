package com.minres.coredsl.tests.syntax

import com.google.inject.Inject
import com.minres.coredsl.tests.CoreDslInjectorProvider
import com.minres.coredsl.tests.CoreDslTestCase
import com.minres.coredsl.tests.CoreDslTestHelper
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslSyntaxTest {
	
	@Inject extension CoreDslTestHelper testHelper;

	def private testProgramForValidSyntax(CharSequence code) {
		code.testProgram().runTestForValidSyntax();
	}

	def private testStatementsForValidSyntax(CharSequence code) {
		code.testStatements().runTestForValidSyntax();
	}

	def private testProgramForSyntaxErrors(CharSequence code) {
		code.testProgram().runTestForSyntaxErrors();
	}

	def private testStatementsForSyntaxErrors(CharSequence code) {
		code.testStatements().runTestForSyntaxErrors();
	}

	def private runTestForValidSyntax(CoreDslTestCase<?> testCase) {
		testCase
		.diagnosticsOnly()
		.run();
	}
	
	def private runTestForSyntaxErrors(CoreDslTestCase<?> testCase) {
		testCase
		.diagnosticsOnly()
		.expectSyntaxErrors()
		.run();
	}
	
	@Test
	def void parseDescriptionContentValid() {
		// empty description (test disabled because xtext refuses to even parse this)
		//''' '''
		//.testProgram()
		//.diagnosticsOnly()
		//.run();
		
		// one core definition, no imports
		'''
			Core A {}
		'''
		.testProgramForValidSyntax();

		// one instruction set, no imports
		'''
			InstructionSet A {}
		'''
		.testProgramForValidSyntax();

		// multiple definitions, no imports
		'''
			InstructionSet A {}
			Core B {}
			InstructionSet C {}
			Core D {}
		'''
		.testProgramForValidSyntax();

		// one core definition, imports
		'''
			import "a.core_desc"
			import "b.core_desc"
			Core A {}
		'''
		.testProgramForValidSyntax();

		// one instruction set, imports
		'''
			import "a.core_desc"
			import "b.core_desc"
			InstructionSet A {}
		'''
		.testProgramForValidSyntax();

		// multiple definitions, imports
		'''
			import "a.core_desc"
			import "b.core_desc"
			InstructionSet A {}
			Core B {}
			InstructionSet C {}
			Core D {}
		'''
		.testProgramForValidSyntax();

		// all on the same line
		'''import "a.core_desc" import "b.core_desc" Core A {}'''
		.testProgramForValidSyntax();
	}

	@Test
	def void parseDescriptionContentInvalid() {
		// import after definition
		'''
			Core A {}
			import "a.core_desc"
		'''
		.testProgramForSyntaxErrors();
	}

	@Test
	def void parseInstructionSetValid() {
		// empty instruction set
		'''
			InstructionSet A {}
		'''
		.testProgramForValidSyntax();

		// inheritance
		'''
			InstructionSet B extends A {}
		'''
		.testProgramForValidSyntax();

		// single section
		'''
			InstructionSet A { architectural_state { int x; } }
			InstructionSet B { functions { void x() {} } }
			InstructionSet C { instructions { x { encoding: 0; behavior: {} } } }
		'''
		.testProgramForValidSyntax();

		// section permutations
		'''
			InstructionSet AFI {
				architectural_state { int x; }
				functions { void x() {} }
				instructions { x { encoding: 0; behavior: {} } }
			}
			InstructionSet AIF {
				architectural_state { int x; }
				instructions { x { encoding: 0; behavior: {} } }
				functions { void x() {} }	
			}
			InstructionSet FAI {
				functions { void x() {} }
				architectural_state { int x; }
				instructions { x { encoding: 0; behavior: {} } }
			}
			InstructionSet FIA {
				functions { void x() {} }
				instructions { x { encoding: 0; behavior: {} } }
				architectural_state { int x; }
			}
			InstructionSet IAF {
				instructions { x { encoding: 0; behavior: {} } }
				architectural_state { int x; }
				functions { void x() {} }
			}
			InstructionSet IFA {
				instructions { x { encoding: 0; behavior: {} } }
				functions { void x() {} }
				architectural_state { int x; }
			}
		'''
		.testProgramForValidSyntax();
	}

	@Test
	def void parseInstructionSetInvalid() {
		// empty sections
		testProgramForSyntaxErrors('''InstructionSet A { architectural_state {} }''');
		testProgramForSyntaxErrors('''InstructionSet A { functions {} }''');
		testProgramForSyntaxErrors('''InstructionSet A { instructions {} }''');
		
		// multiple inheritance
		testProgramForSyntaxErrors('''InstructionSet A extends B, C {}''');
		
		// provides keyword
		testProgramForSyntaxErrors('''InstructionSet A provides B {}''');
	}

	@Test
	def void parseCoreDefValid() {
		// empty core
		'''
			Core A {}
		'''
		.testProgramForValidSyntax();

		// provides one
		'''
			Core A provides B {}
		'''
		.testProgramForValidSyntax();

		// provides multiple
		'''
			Core A provides B, C, D {}
		'''
		.testProgramForValidSyntax();

		// single section
		'''
			Core A { architectural_state { int x; } }
			Core B { functions { void x() {} } }
			Core C { instructions { x { encoding: 0; behavior: {} } } }
		'''
		.testProgramForValidSyntax();

		// section permutations
		'''
			Core AFI {
				architectural_state { int x; }
				functions { void x() {} }
				instructions { x { encoding: 0; behavior: {} } }
			}
			Core AIF {
				architectural_state { int x; }
				instructions { x { encoding: 0; behavior: {} } }
				functions { void x() {} }
			}
			Core FAI {
				functions { void x() {} }
				architectural_state { int x; }
				instructions { x { encoding: 0; behavior: {} } }
			}
			Core FIA {
				functions { void x() {} }
				instructions { x { encoding: 0; behavior: {} } }
				architectural_state { int x; }
			}
			Core IAF {
				instructions { x { encoding: 0; behavior: {} } }
				architectural_state { int x; }
				functions { void x() {} }
			}
			Core IFA {
				instructions { x { encoding: 0; behavior: {} } }
				functions { void x() {} }
				architectural_state { int x; }
			}
		'''
		.testProgramForValidSyntax();
	}

	@Test
	def void parseCoreDefInvalid() {
		// empty sections
		testProgramForSyntaxErrors('''Core A { architectural_state {} }''');
		testProgramForSyntaxErrors('''Core B { functions {} }''');
		testProgramForSyntaxErrors('''Core C { instructions {} }''');

		// extends keyword
		testProgramForSyntaxErrors('''Core A extends B {}''');
	}

	@Test
	def void parseInstructionValid() {
		// without assembly
		'''
			x {
				encoding: 0;
				behavior: {}
			}
		'''
		.testInstruction()
		.diagnosticsOnly()
		.run();

		// with assembly
		'''
			x {
				encoding: 0;
				assembly: "";
				behavior: {}
			}
		'''
		.testInstruction()
		.diagnosticsOnly()
		.run();

		// complex encoding
		'''
			x {
				encoding: 1 :: 4'hf :: 0x2 :: 0b101010 :: 0777 :: fld[0:3];
				behavior: {}
			}
		'''
		.testInstruction()
		.diagnosticsOnly()
		.run();

		// non-compound statement behavior
		'''
			x {
				encoding: 0;
				behavior: x = 5;
			}
		'''
		.testInstruction()
		.diagnosticsOnly()
		.run();
	}
	
	@Test
	def void parseInstructionInvalid() {
		// invalid permutations
		val instructions = #[
			'_ { }',
			'e { encoding: 11; }',
			'a { assembly: ""; }',
			'b { behavior: {} }',
			'be { behavior: {} encoding: 11; }',
			'eba { encoding: 11; behavior: {} assembly: ""; }',
			'aeb { assembly: ""; encoding: 11; behavior: {} }',
			'abe { assembly: ""; behavior: {} encoding: 11; }',
			'bea { behavior: {} encoding: 11; assembly: ""; }',
			'bae { behavior: {} assembly: ""; encoding: 11; }'
		];
		for (inst : instructions) {
			testProgramForSyntaxErrors('''Core A { instructions { «inst» } }''');
		}
	}

	@Test
	def void parseDeclarationsValid() {
		'''
			// single declarator
			int i;
			
			// multiple declarators
			int i, j, k;
			
			// single init declarator
			int i = 10;
			
			// multiple init declarators
			int i = 10, j = 20, k = 30;
			
			// mixed regular and init declarators
			int i, j = 20, k;
		'''
		.testStatements()
		.diagnosticsOnly()
		.run();
	}

	@Test
	def void parseTypeSpecifiersValid() {
		'''
			signed<32> i;
			unsigned<XLEN> i;
			
			char i;
			signed char i;
			unsigned char i;
			
			short i;
			signed short i;
			unsigned short i;
			
			int i;
			signed int i;
			unsigned int i;
			
			long i;
			signed long i;
			unsigned long i;
			
			bool i;
		'''
		.testStatements()
		.diagnosticsOnly()
		.run();
	}

	@Test
	def void parseTypeSpecifiersInvalid() {
		testStatementsForSyntaxErrors('''signed i;''');
		testStatementsForSyntaxErrors('''unsigned i;''');
	}

	@Test
	def void parseIfStatementValid() {
		'''
			if(false);
			
			if(false) {}
			
			if(false) if(true);
			
			if(false);
			else;
			
			if(false) {}
			else {}
			
			if(false);
			else if(true);
			else;
			
			if(false) {}
			else if(true) {}
			else {}
			
			if((((false))));
		'''
		.testStatements()
		.diagnosticsOnly()
		.run();
	}

	@Test
	def void parseIfStatementInvalid() {
		// else must follow an if statement
		'''
			{
				else;
			}
		'''
		.testStatementsForSyntaxErrors();

		// parentheses are required
		'''
			if false {}
		'''
		.testStatementsForSyntaxErrors();

		// then statement is required
		'''
			{
				if(false)
			}
		'''
		.testStatementsForSyntaxErrors();

		// else statement is required if else keyword is present
		'''
			{
				if(false);
				else
			}
		'''
		.testStatementsForSyntaxErrors();
	}

	@Test
	def void parseSwitchStatementValid() {
		'''
			// no sections
			switch(1) { }
			
			// simple default
			switch(1) { default: }
			
			// complex switch expression
			switch((((1)))) { default: }
			
			// multiple defaults
			switch(1) { default: default: default: }
			
			// simple case
			switch(1) { case 0: }
			
			// complex case expression
			switch(1) { case (((0))): }
			
			// default last
			switch(1) { case 0: case 1: default: }
			
			// default in between
			switch(1) { case 0: default: case 1: }
			
			// default first
			switch(1) { default: case 0: case 1: }
			
			// mixed sections, multiple defaults
			switch(1) { default: case 0: default: case 1: default: }
			
			// one section, one statement
			switch(1) { case 0: {} }
			
			// one section, multiple statements
			switch(1) { case 0: {};; }
			
			// multiple sections, at most one statement each
			switch(1) { case 0: case 1: ; default: {} }
			
			// multiple sections, multiple statements
			switch(1) { case 0: case 1: ;;; default: {};; }
			
		'''
		.testStatementsForValidSyntax();
	}

	@Test
	def void parseSwitchStatementInvalid() {
		// parentheses are required
		testStatementsForSyntaxErrors('''switch 5 { default: }''');

		// switch body is required
		testStatementsForSyntaxErrors('''switch(5);''');

		// case needs a condition
		testStatementsForSyntaxErrors('''switch(5) { case: }''');

		// default must not have a condition
		testStatementsForSyntaxErrors('''switch(5) { default 0: }''');
	}

	@Test
	def void parseLoopValid() {
		'''
			// simple while
			while(true) {}
			
			// while without compound
			while(true);
			
			// while with complex condition
			while((((true)))) {}
			
			// simple do
			do {} while(true);
			
			// do without compound
			do ; while(true);
			
			// do with complex condition
			do {} while((((true))));
			
			// simple for
			for(;;) {}
			
			// for without compound
			for(;;);
			
			// for with complex condition
			for(;(((true)));) {}
			
			// for with single init declaration
			for(int i = 0;;) {}
			
			// for with multiple init declarations
			for(int i, j = 0, k;;) {}
			
			// for with single init assignment
			for(i = 0;;) {}
			
			// for with single init assignment (increment)
			for(i++;;) {}
			
			// for with single increment assignment
			for(;;i = 7) {}
			
			// for with multiple increment assignments
			for(;;i = 7, j++, --k) {}
			
		'''
		.testStatementsForValidSyntax();
	}

	@Test
	def void parseLoopInvalid() {
		// while parentheses are required
		testStatementsForSyntaxErrors('''while true {}''');

		// do parentheses are required
		testStatementsForSyntaxErrors('''do {} while true;''');
		
		// do while is required
		testStatementsForSyntaxErrors('''do {}''');
	}
	
    @Test
    def void parseIdentifiersValid() {
		'''
			int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
			int A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
			
			int _;
			_ = a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r+s+t+u+v+w+x+y+z;
			_ = A+B+C+D+E+F+G+H+I+J+K+L+M+N+O+P+Q+R+S+T+U+V+W+X+Y+Z;
			
			int x0, x1, x2, x3, x4, x5, x6, x7, x8, x9;
			_ = x0+x1+x2+x3+x4+x5+x6+x7+x8+x9;
		'''
		.testStatementsForValidSyntax();
    }

    @Test
    def void parseLiteralsValid() {
		'''
			int _;
			
			// C syntax
			_ = 42;
			_ = 0x2A;
			_ = 052;
			_ = 0b101010;
			
			// Verilog syntax
			_ = 6'd42;
			_ = 6'h2a;
			_ = 6'o52;
			_ = 6'b101010;
			_ = 6'sd42;
			
			// bool literals
			_ = false;
			_ = true;
		'''
		.testStatementsForValidSyntax();
    }

    @Test
    def void parsePrePostfixValid() {
        '''
            int _;
            
            // C syntax
            _ = ~(unsigned<32>)1;
            _ = ~((unsigned<32>)1);
        '''
        .testStatementsForValidSyntax();
    }

}
