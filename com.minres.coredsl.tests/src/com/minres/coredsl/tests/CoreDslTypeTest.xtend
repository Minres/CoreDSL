/*
 * generated by Xtext 2.10.0
 */
package com.minres.coredsl.tests

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.DescriptionContent
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue

import static extension com.minres.coredsl.typing.TypeProvider.*

@RunWith(XtextRunner)
@InjectWith(CoreDslInjectorProvider)
class CoreDslTypeTest {

    @Inject extension ParseHelper<DescriptionContent> parseHelper

    @Inject ValidationTestHelper validator
    
    @Test
    def void deferedConstantDefinition() {
        val content = '''
        InstructionSet TestISA {
            constants {
                unsigned XLEN;
            }
            registers { 
                unsigned<XLEN>  X[32];
            }
        }
        Core TestCore provides TestISA {
            constants {
                unsigned XLEN=32;
            }
        }
        '''.parse
        val issues = validator.validate(content)
        for (iss : issues)
            println(iss)
        assertTrue(issues.isEmpty())
        val decl = content.definitions.get(0).regs.get(0).init.get(0).declarator
        assertEquals("X", decl.name)
        val dataType = decl.typeFor(content.definitions.last)
        assertNotNull(dataType)
        assertEquals(32, dataType.size)
    }
}
