package com.minres.coredsl.scoping

import com.google.common.base.Splitter
import com.google.inject.Inject
import com.google.inject.Provider
import com.minres.coredsl.coreDsl.CoreDslPackage
import java.io.File
import java.util.LinkedHashSet
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider
import org.eclipse.xtext.util.IResourceScopeCache
import org.eclipse.emf.common.util.WrappedException
import com.minres.coredsl.validation.XtCoreDslValidator
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic

class CoreDslGlobalScopeProvider extends ImportUriGlobalScopeProvider {
    
    static final Splitter SPLITTER = Splitter.on(',');

    @Inject
    IResourceDescription.Manager descriptionManager;

    @Inject
    IResourceScopeCache cache;

    @Inject
    XtCoreDslValidator validator;
    
    override protected getImportedUris(Resource resource) {
        return cache.get(CoreDslGlobalScopeProvider.getSimpleName(), resource, new Provider<LinkedHashSet<URI>>() {
            override get() {
                val uniqueImportURIs = collectImportUris(resource, new LinkedHashSet<URI>(5))
                val uriIter = uniqueImportURIs.iterator()
                while(uriIter.hasNext()) {
                    if (!EcoreUtil2.isValidUri(resource, uriIter.next()))
                        uriIter.remove()
                }
                return uniqueImportURIs
            }

            def LinkedHashSet<URI> collectImportUris(Resource resource, LinkedHashSet<URI> uniqueImportURIs) {
                val resourceDescription = descriptionManager.getResourceDescription(resource)
                val models = resourceDescription.getExportedObjectsByType(CoreDslPackage.Literals.DESCRIPTION_CONTENT)
                models.forEach[
                    val userData = getUserData(CoreDslResourceDescriptionStrategy.INCLUDES)
                    if(userData !== null && userData.length>0) {
                        SPLITTER.split(userData).forEach[uri |
                            var includedUri = URI.createURI(uri)
                            try {
                                includedUri = includedUri.resolve(resource.URI)                            
                            } catch(IllegalArgumentException e) {
                                val currentPath = new File(".").getCanonicalPath();
                                includedUri = includedUri.resolve(URI::createFileURI(currentPath+"/"))
                            }
                            if(uniqueImportURIs.add(includedUri)) {
                                try {
                                    collectImportUris(resource.getResourceSet().getResource(includedUri, true), uniqueImportURIs)
                                } catch(WrappedException e) {
                                    /* just ignore it */
                                    resource.errors.add(new ScopeProviderDiagnostic(e.cause.message))
                                    //validator.acceptWarning("Could not find file", it.EObjectOrProxy, CoreDslPackage.Literals.IMPORT__IMPORT_URI, 0, "", "")
                                }
                            }
                        ]
                    }
                ]
                return uniqueImportURIs
            }
        });
    }}