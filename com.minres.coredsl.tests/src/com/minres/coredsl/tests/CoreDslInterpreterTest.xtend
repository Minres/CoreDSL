/*
 * generated by Xtext 2.10.0
 */
package com.minres.coredsl.tests

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.interpreter.EvaluationContext
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension com.minres.coredsl.interpreter.CoreDSLInterpreter.*
import static extension com.minres.coredsl.util.ModelUtil.*
import java.math.BigInteger
import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(CoreDslInjectorProvider)
class CoreDslInterpreterTest {

    @Inject extension ParseHelper<DescriptionContent> parseHelper

    @Inject ValidationTestHelper validator

    @Test
    def void simpleConstants() {
        val content = '''
        InstructionSet Test {
            architectural_state {
                int a = 42;
                int b = a + 5;
                int XLEN = a + b;
                [[is_pc]] int PC ;
                int Xreg[XLEN];
                float Freg[a];
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
        val constants = content.definitions.get(0).stateDeclarations
        val rootContext = EvaluationContext.root
        val values  = constants.flatMap[declaration |
            declaration.init.map[initDecl|
                initDecl.declarator.evaluate(rootContext)
            ]
        ].toList
        assertTrue(values.get(0).value instanceof BigInteger)
        assertEquals((values.get(0).value as BigInteger).intValue, 42)
        
        assertTrue(values.get(1).value instanceof BigInteger)
        assertEquals((values.get(1).value as BigInteger).intValue, 47)
        
        assertTrue(values.get(2).value instanceof BigInteger)
        assertEquals((values.get(2).value as BigInteger).intValue, 89)
    }
    

}
