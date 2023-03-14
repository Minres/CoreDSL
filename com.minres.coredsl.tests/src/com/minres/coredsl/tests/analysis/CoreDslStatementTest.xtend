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

	@Test
	def void expressionStatement() {
		'''
			int arr[1];
			int x = 0;
			
			0;
			x;
			sizeof(x);
			(0);
			(int)0;
			0::0;
			0?0:0;
			0+0;
			arr[0];
			-0;
			+0;
			~0;
			!0;
		'''.testStatements()
		.expectError(IssueCodes.InvalidStatementExpression, 4)
		.expectError(IssueCodes.InvalidStatementExpression, 5)
		.expectError(IssueCodes.InvalidStatementExpression, 6)
		.expectError(IssueCodes.InvalidStatementExpression, 7)
		.expectError(IssueCodes.InvalidStatementExpression, 8)
		.expectError(IssueCodes.InvalidStatementExpression, 9)
		.expectError(IssueCodes.InvalidStatementExpression, 10)
		.expectError(IssueCodes.InvalidStatementExpression, 11)
		.expectError(IssueCodes.InvalidStatementExpression, 12)
		.expectError(IssueCodes.InvalidStatementExpression, 13)
		.expectError(IssueCodes.InvalidStatementExpression, 14)
		.expectError(IssueCodes.InvalidStatementExpression, 15)
		.expectError(IssueCodes.InvalidStatementExpression, 16)
		.run();
		
		'''
			int arr[1];
			int x;
			
			x = 0;
			++x;
			--x;
			x++;
			x--;
			testFunc();
		'''.testStatements()
		.run();
	}
}
