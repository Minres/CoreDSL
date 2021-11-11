package com.minres.coredsl.tests.util

import com.minres.coredsl.services.CoreDslGrammarAccess
import org.eclipse.xtext.resource.IResourceFactory
import com.minres.coredsl.coreDsl.TypeSpecifier
import java.io.ByteArrayInputStream
import java.util.Collections
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ParserRule
import org.eclipse.emf.ecore.EObject
import com.minres.coredsl.coreDsl.CompoundStatement
import javax.inject.Inject
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.Constant
import com.minres.coredsl.coreDsl.IntegerConstant

class TestHelper {
	@Inject CoreDslGrammarAccess grammarAccess
	@Inject IResourceFactory resourceFactory

	def <T extends EObject> T parseAs(CharSequence source, ParserRule rule) {
		// https://github.com/eclipse/xtext-core/commit/0745d5a43d70b2a18b9fe828afbef564fcd06782
		val resource = resourceFactory.createResource(URI.createURI("dummy://test.core_desc")) as XtextResource;
		resource.entryPoint = rule
		resource.load(new ByteArrayInputStream(source.toString().getBytes()), Collections.EMPTY_MAP)
		resource.contents.get(0) as T
	}

	def TypeSpecifier parseAsTypeSpecifier(CharSequence source) {
		source.parseAs(grammarAccess.typeSpecifierRule)
	}

	def CompoundStatement parseAsCompoundStatement(CharSequence source) {
		source.parseAs(grammarAccess.compoundStatementRule)
	}

	def CompoundStatement parseAsBlock(CharSequence source) {
		'''{«source»}'''.parseAsCompoundStatement()
	}

	def Expression parseAsExpression(CharSequence source) {
		source.parseAs(grammarAccess.conditionalExpressionRule)
	}

	def Constant parseAsConstant(CharSequence source) {
		source.parseAs(grammarAccess.constantRule)
	}

	def IntegerConstant parseAsIntegerConstant(CharSequence source) {
		source.parseAs(grammarAccess.integerConstantRule)
	}
}
