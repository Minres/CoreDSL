package com.minres.coredsl.naming

import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.eclipse.emf.ecore.EObject
import com.google.inject.Inject

class CoreDslNameProvider extends IQualifiedNameProvider.AbstractImpl {
	
	@Inject IQualifiedNameConverter qualifiedNameConverter

	override QualifiedName getFullyQualifiedName(EObject obj) {
//		if(obj instanceof InstructionSet){
//			val name = obj.name
//			println("Name is "+name)
//		}
		var String name = SimpleAttributeResolver.NAME_RESOLVER.apply(obj)
		if(name === null || name.length() === 0) return null
		return qualifiedNameConverter.toQualifiedName(name)
	}
	
}
