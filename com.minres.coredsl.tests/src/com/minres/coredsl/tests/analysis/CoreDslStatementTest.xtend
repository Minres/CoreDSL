package com.minres.coredsl.tests.analysis

import com.google.inject.Inject
import com.minres.coredsl.tests.CoreDslInjectorProvider
import com.minres.coredsl.tests.CoreDslTestHelper
import com.minres.coredsl.validation.IssueCodes
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslStatementTest {
	
	@Inject extension CoreDslTestHelper testHelper;

	@Test
	def void compoundStatement() {
		'''
			{
				{}
				{}
			}
		'''.testStatements().run();
		
		'''
			{
				{}
				return;
				{}
			}
		'''.testStatements()
		.expectWarning(IssueCodes.UnreachableCode, 4)
		.run();
		
		'''
			{
				{}
				{return;}
				{}
			}
		'''.testStatements()
		.expectWarning(IssueCodes.UnreachableCode, 4)
		.run();
		
		'''
			{
				{}
				if(true) return;
				else return;
				{}
			}
		'''.testStatements()
		.expectWarning(IssueCodes.UnreachableCode, 5)
		.run();
	}
}
