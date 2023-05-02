/*
 * generated by Xtext 2.10.0
 */
package com.minres.coredsl.tests

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.DescriptionContent
import java.io.FileReader
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

import static extension com.google.common.io.CharStreams.*

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslLoadTest {

	@Inject extension ParseHelper<DescriptionContent> parseHelper

    @Inject ValidationTestHelper validator
    
    def void loadFile(String fileName) {
    	val content = new FileReader(fileName).readLines.join('\n').parse
        validator.assertNoErrors(content)
    }

	//@Test
	def void introSyntax() {
		loadFile('inputs/intro_syntax.core_desc')
	}
	
	//@Test
	def void introTypes() {
		loadFile('inputs/intro_types.core_desc')
	}
	
	//@Test
	def void introConcurrency() {
		loadFile('inputs/intro_concurrency.core_desc')
	}
}
