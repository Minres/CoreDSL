/*
 * generated by Xtext 2.10.0
 */
package com.minres.coredsl.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertEquals
import static extension com.minres.coredsl.typing.TypeProvider.resolveType
import com.minres.coredsl.typing.IntegerType
import static org.junit.Assert.assertNotNull
import com.minres.coredsl.tests.util.TestHelper

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslIntegerTypeSpecifierTest {

	@Inject ValidationTestHelper validator
	@Inject extension TestHelper helper

	def validateTypeSpecifier(String source, int expectedBitSize, boolean expectedSigned) {
		val typeSpec = source.parseAsTypeSpecifier();

		val issues = validator.validate(typeSpec)
		for (iss : issues)
			println(iss)

		assertTrue(issues.empty)

		val type = typeSpec.resolveType() as IntegerType

		assertNotNull(type)
		assertEquals(expectedBitSize, type.bitSize)
		assertEquals(expectedSigned, type.signed)
	}

	@Test
	def void shorthandSpecifiers() {
		validateTypeSpecifier("char", 8, true);
		validateTypeSpecifier("short", 16, true);
		validateTypeSpecifier("int", 32, true);
		validateTypeSpecifier("long", 64, true);
	}

	@Test
	def void signedShorthandSpecifiers() {
		validateTypeSpecifier("signed char", 8, true);
		validateTypeSpecifier("signed short", 16, true);
		validateTypeSpecifier("signed int", 32, true);
		validateTypeSpecifier("signed long", 64, true);
	}

	@Test
	def void unsignedShorthandSpecifiers() {
		validateTypeSpecifier("unsigned char", 8, false);
		validateTypeSpecifier("unsigned short", 16, false);
		validateTypeSpecifier("unsigned int", 32, false);
		validateTypeSpecifier("unsigned long", 64, false);
	}

	@Test
	def void explicitlySizedSignedSpecifiers() {
		validateTypeSpecifier("signed<1>", 1, true);
		validateTypeSpecifier("signed<4>", 4, true);
		validateTypeSpecifier("signed<11>", 11, true);
		validateTypeSpecifier("signed<32>", 32, true);
		validateTypeSpecifier("signed<128>", 128, true);
	}

	@Test
	def void explicitlySizedUnsignedSpecifiers() {
		validateTypeSpecifier("unsigned<1>", 1, false);
		validateTypeSpecifier("unsigned<4>", 4, false);
		validateTypeSpecifier("unsigned<11>", 11, false);
		validateTypeSpecifier("unsigned<32>", 32, false);
		validateTypeSpecifier("unsigned<128>", 128, false);
	}
}
