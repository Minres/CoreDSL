/*
 * generated by Xtext 2.10.0
 */
package com.minres.coredsl.ui.outline

import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.Encoding
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.Statement
import com.minres.coredsl.coreDsl.Variable
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import com.minres.coredsl.coreDsl.CoreDslPackage

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 */
class CoreDslOutlineTreeProvider extends DefaultOutlineTreeProvider {

	def void _createChildren(DocumentRootNode outlineNode, DescriptionContent model) {
		model.definitions.forEach [
			createNode(outlineNode, it)
		]
	}

	def void _createChildren(IOutlineNode parentNode, InstructionSet modelElement) {
		val image = imageDispatcher.invoke(modelElement.declarations)
		if(modelElement.superType !==null)
		  	createEObjectNode(parentNode, modelElement.superType);
		if(modelElement.declarations.size>0)
		createEStructuralFeatureNode(parentNode, modelElement, CoreDslPackage.Literals.ISA__DECLARATIONS,
			image, "State", false)
		if(modelElement.functions.size>0)
		createEStructuralFeatureNode(parentNode, modelElement, CoreDslPackage.Literals.ISA__FUNCTIONS,
			image, "Functions", false)
		if(modelElement.instructions.size>0)
		createEStructuralFeatureNode(parentNode, modelElement, CoreDslPackage.Literals.ISA__INSTRUCTIONS,
			image, "Instructions", false)
	}

	def void _createChildren(IOutlineNode parentNode, CoreDef modelElement) {
		val image = imageDispatcher.invoke(modelElement.declarations)
		if(modelElement.contributingType.size>0)
      	createEStructuralFeatureNode(parentNode, modelElement, CoreDslPackage.Literals.CORE_DEF__CONTRIBUTING_TYPE, 
	        image, "Contributing", false)
		if(modelElement.declarations.size>0)
		createEStructuralFeatureNode(parentNode, modelElement, CoreDslPackage.Literals.ISA__DECLARATIONS,
			image, "State", false)
		if(modelElement.functions.size>0)
		createEStructuralFeatureNode(parentNode, modelElement, CoreDslPackage.Literals.ISA__FUNCTIONS,
			image, "Functions", false)
		if(modelElement.instructions.size>0)
		createEStructuralFeatureNode(parentNode, modelElement, CoreDslPackage.Literals.ISA__INSTRUCTIONS,
			image, "Instructions", false)
	}

	def void _createChildren(IOutlineNode parentNode, Instruction stmt) {
		createNode(parentNode, stmt.encoding)
		createNode(parentNode, stmt.behavior)
	}

	def boolean _isLeaf(Variable variable) {
		return true;
	}

	def boolean _isLeaf(Encoding bitField) {
		return true;
	}

	def boolean _isLeaf(Declaration decls) {
		return true;
	}

	def boolean _isLeaf(Statement decls) {
		return true;
	}
}
