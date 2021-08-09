/*
 * generated by Xtext 2.10.0
 */
package com.minres.coredsl.tests

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.CompoundStatement
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.DirectDeclarator
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.FloatingConstant
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.PrimaryExpression
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertFalse
import static org.junit.jupiter.api.Assertions.assertTrue

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslTerminalsTest {

    @Inject extension ParseHelper<DescriptionContent> parseHelper

    @Inject ValidationTestHelper validator

    def CharSequence addBehaviorContext(CharSequence str) '''
        InstructionSet TestISA {
            architectural_state { 
                [[is_pc]] int PC ;
                int Xreg[32];
                float Freg[32];
            }
            instructions {
            	FOO {
            		encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b1111011;  
            		args_disass: "{name(rd)}, {name(rs1)}, {name(rs2)}";
            		behavior: {
            			«str»
            		}
            	}
            }
        }
    '''

    def assertIssues(CharSequence str) {
        val content = addBehaviorContext(str).parse
        val issues = validator.validate(content)
        assertFalse(issues.isEmpty())
    }

    @Test
    def void parseIntLiterals() {
        val content = addBehaviorContext('''
            unsigned c;
            unsigned<6> v;
            // C syntax
            c = 42;
            c = 0x2A;
            c = 052;
            c = 0b101010;
            
            // Verilog syntax
            v = 6'd42;
            v = 6'h2a;
            v = 6'o52;
            v = 6'b101010;
         	''').parse
        validator.assertNoErrors(content)

        val compound = ((content.definitions.get(0) as InstructionSet).instructions.get(0).behavior as CompoundStatement)
        for (el : compound.items) {
            if (el instanceof ExpressionStatement) {
                val expr = el.expr.expressions.get(0) as AssignmentExpression
                val rhs = (expr.assignments.get(0).right as PrimaryExpression).constant as IntegerConstant
                assertEquals(rhs.value.intValue, 42)
            }
        }
    }

    @Test
    def void parseIntLiteralSuffixes() {
        val content = addBehaviorContext('''
            unsigned u32;
            unsigned long u64;
            unsigned long long u128;
            long i64;
            long long i128;
            u32 = 42u;
            u32 = 42U;
            
            i64 = 42l;
            i64 = 42L;
            i128 = 42ll;
            i128 = 42LL;
            
            u64 = 42ul;
            u128 = 42ull;
            // u64 = 42lu;  // currently not supported
            // u128 = 42llu; // ditto
         	''').parse
        validator.assertNoErrors(content)

        val compound = ((content.definitions.get(0) as InstructionSet).instructions.get(0).behavior as CompoundStatement)
        for (el : compound.items.subList(3, compound.items.size())) {
            if (el instanceof ExpressionStatement) {
                val expr = el.expr.expressions.get(0) as AssignmentExpression
                // val lhsName = (expr.left as PrimaryExpression).ref.name;
                val rhs = (expr.assignments.get(0).right as PrimaryExpression).constant as IntegerConstant
                val intValue = rhs.value.intValue
                assertEquals(intValue, 42)
            // FIXME: cannot check size and signedness, because the BigIntegerWithRadix class is not accessible here -- why?
            }
        }

        assertIssues("int i = 6'd42u;") // Verilog syntax cannot have the suffix
        assertIssues("int i = 6'd42ul;")
        assertIssues("int i = 42uu;")
        assertIssues("int i = 42lul;")
        assertIssues("int i = 42ulu;")
//		assertIssues("int i = 42lL;") // TODO: The INTEGERValueConverter currently does not handle this case -- does it matter?
        assertIssues("int i = 42lll;")
    }

    @Test
    def void parseFloatLiterals() {
        val content = addBehaviorContext('''
            double d, d1, d0;
            float f;
            long double ld;
            
            d = 3.14;
            d = 0.314e1;
            d = 0.0314e+2;
            d = 3140.e-3;
            d1 = 1.;
            d1 = 1.e0;
            d0 = 0.0;
            
            f = 3.14f;
            f = 3.14F;
            ld = 3.14l;
            ld = 3.14L;
        ''').parse
        validator.assertNoErrors(content)

        val compound = ((content.definitions.get(0) as InstructionSet).instructions.get(0).behavior as CompoundStatement)
        for (el : compound.items.subList(3, compound.items.size())) {
            if (el instanceof ExpressionStatement) {
                val expr = el.expr.expressions.get(0) as AssignmentExpression
                val lhsName = ((expr.left as PrimaryExpression).ref as DirectDeclarator).name;
                val rhs = (expr.assignments.get(0).right as PrimaryExpression).constant as FloatingConstant
                val floatValue = rhs.value.doubleValue
                if (lhsName == "d" || lhsName == "f" || lhsName == "ld")
                    assertTrue(Math.abs(floatValue - 3.14) < 1e-6)
                else if (lhsName == "d1")
                    assertTrue(floatValue == 1.0)
                else
                    assertTrue(floatValue == 0.0)
            }
        }
    }

    @Test
    def void parseBoolLiterals() {
        val content = addBehaviorContext('''
            bool b;
            b = true;
            b = false;
        ''').parse
        validator.assertNoErrors(content)
    }

    @Test
    def void parseCharLiterals() {
        val content = addBehaviorContext('''
            char c;
            c = 'a';
            c = '9';
            c = '"';
            c = '\'';
            c = '\\';
            c = L'x';
            c = u'x';
            c = U'x';
        ''').parse
        validator.assertNoErrors(content)

    // TODO: Currently, this only checks whether the syntax is accepted. No handling of encoding and escape sequences is done.
    }

    @Test
    def void parseStringLiterals() {
        val content = addBehaviorContext('''
            char *str;
            str = "hello world 1";
            str = u8"hello world 2";
            str = u"hello world 3";
            str = U"hello world 4";
            str = L"hello world 5";
        ''').parse
        validator.assertNoErrors(content)

    // TODO: Currently, this only checks whether the syntax is accepted. No handling of encoding and escape sequences is done.
    }

    @Test
    def void parseSingleCharIdentifiers() {
        // this test is here because the encoding prefixes for char- and string literals may clobber normal identifiers
        var alphabet = "abcdefghijklmnopqrstuvwxyz"
        alphabet += alphabet.toUpperCase
        for (var i = 0; i < alphabet.length; i++) {
            val c = alphabet.charAt(i);
            val content = addBehaviorContext('''int «c»;''').parse
            val issues = validator.validate(content)
            if (! issues.isEmpty) {
                println("Problematic identifier: " + c)
                for (issue : issues)
                    println(issue)
            }
            validator.assertNoErrors(content)
        }
    }
}
