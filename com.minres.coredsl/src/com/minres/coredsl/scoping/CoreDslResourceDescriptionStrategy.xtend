package com.minres.coredsl.scoping

import com.google.inject.Inject
import java.util.HashMap
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.scoping.impl.ImportUriResolver
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.emf.ecore.EObject
import com.minres.coredsl.coreDsl.DescriptionContent

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
        val uris = newArrayList()
        model.imports.forEach[uris.add(uriResolver.apply(it))]
        val userData = new HashMap<String,String>
        userData.put(INCLUDES, uris.join(","))
        acceptor.accept(EObjectDescription.create(QualifiedName.create(model.eResource.URI.toString), model, userData))
    }
}