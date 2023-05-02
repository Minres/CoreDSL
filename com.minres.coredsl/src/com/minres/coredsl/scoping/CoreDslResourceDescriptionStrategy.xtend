package com.minres.coredsl.scoping

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.DescriptionContent
import java.util.HashMap
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.scoping.impl.ImportUriResolver
import org.eclipse.xtext.util.IAcceptor

class CoreDslResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
   
    public  static final String INCLUDES = "includes"

    @Inject
    ImportUriResolver uriResolver

    override createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
        if(eObject instanceof DescriptionContent) {
            this.createEObjectDescriptionForModel(eObject, acceptor)
            return true
        }
        else {
            super.createEObjectDescriptions(eObject, acceptor)
        }
    }

    def void createEObjectDescriptionForModel(DescriptionContent model, IAcceptor<IEObjectDescription> acceptor) {
        val userData = new HashMap<String,String>
        userData.put(INCLUDES, model.imports.map[uriResolver.apply(it)].join(","))
        
        val name = QualifiedName.create(model.eResource.URI.toString());
        acceptor.accept(EObjectDescription.create(name, model, userData));
    }
}