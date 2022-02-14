/*
 * generated by Xtext 2.10.0
 */
package com.minres.coredsl.tests

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.DescriptionContent
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertNotNull
import static org.junit.jupiter.api.Assertions.assertTrue

import static extension com.minres.coredsl.typing.TypeProvider.*
import static extension com.minres.coredsl.util.ModelUtil.*

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslTypeTest {

    @Inject extension ParseHelper<DescriptionContent> parseHelper

    @Inject ValidationTestHelper validator
    
    @Test
    def void deferedConstantDefinition() {
        val content = '''
        InstructionSet TestISA {
            architectural_state {
                unsigned int XLEN;
                unsigned<XLEN>  X[32];
            }
        }
        Core TestCore provides TestISA {
            architectural_state {
                XLEN=32;
            }
        }
        '''.parse
        val issues = validator.validate(content)
        for (iss : issues)
            println(iss)
        assertTrue(issues.isEmpty())
        val decl = content.definitions.get(0).stateDeclarations.get(1).init.get(0).declarator
        assertEquals("X", decl.name)
        val dataType = decl.typeFor(content.definitions.last)
        assertNotNull(dataType)
        assertEquals(32, dataType.size)
    }
}
