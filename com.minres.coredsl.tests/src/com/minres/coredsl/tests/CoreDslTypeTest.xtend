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
import com.minres.coredsl.coreDsl.IntegerSignedness
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.coreDsl.IntegerSizeShorthand

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
                unsigned int FLEN;
                int CSR_SIZE;
                unsigned<XLEN> X[32];
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
        val xlen_type = content.definitions.get(0).declarations.get(0).declaration.type;
        assertTrue(xlen_type instanceof IntegerTypeSpecifier);
        assertEquals(IntegerSignedness.UNSIGNED, (xlen_type as IntegerTypeSpecifier).signedness)
        assertEquals(IntegerSizeShorthand.INT, (xlen_type as IntegerTypeSpecifier).shorthand)
        val flen_type = content.definitions.get(0).declarations.get(1).declaration.type;
        assertTrue(flen_type instanceof IntegerTypeSpecifier);
        assertEquals(IntegerSignedness.UNSIGNED, (flen_type as IntegerTypeSpecifier).signedness)
        assertEquals(IntegerSizeShorthand.INT, (flen_type as IntegerTypeSpecifier).shorthand)
        val csr_size_type = content.definitions.get(0).declarations.get(2).declaration.type;
        assertTrue(csr_size_type instanceof IntegerTypeSpecifier);
        assertEquals(IntegerSignedness.SIGNED, (csr_size_type as IntegerTypeSpecifier).signedness)
        assertEquals(IntegerSizeShorthand.INT, (csr_size_type as IntegerTypeSpecifier).shorthand)
        val decl = content.definitions.get(0).declarations.get(3).declaration.declarators.get(0)
        assertEquals("X", decl.name)
        val dataType = decl.typeFor(content.definitions.last)
        assertNotNull(dataType)
        assertEquals(32, dataType.size)
    }
}
