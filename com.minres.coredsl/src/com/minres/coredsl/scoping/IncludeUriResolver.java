package com.minres.coredsl.scoping;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

import com.google.inject.Inject;
import com.minres.coredsl.coreDsl.Import;

public class IncludeUriResolver extends ImportUriResolver {
	
    @Inject
    IResourceDescription.Manager descriptionManager;

    @Override
	public String resolve(EObject object) {
		if(object instanceof Import) {
			Import imp = (Import)object;
            URI uri = URI.createURI(imp.getImportURI());
            if(!uri.isRelative()) return imp.getImportURI();
            try {
                URI includedUri = uri.resolve(imp.eResource().getURI());
                if(!includedUri.isFile() || new File(includedUri.toFileString()).exists())
                	return includedUri.toString();
            } catch (IllegalArgumentException e) {}
            for (Map.Entry<String, URI> element : EcorePlugin.getPlatformResourceMap().entrySet()) {
                try {
                	URI includedUri = uri.resolve(element.getValue());
                	return includedUri.toString();
                } catch (IllegalArgumentException e1) { }
            }
            String currentPath = "";
			try {
				currentPath = new File(".").getCanonicalPath();
			} catch (IOException e) {}
            URI includedUri = uri.resolve(URI.createFileURI(currentPath + "/"));
        	return includedUri.toString();
		}
		return getResolver().apply(object);
	}

	@Override
	public EStructuralFeature getAttribute(EObject object) {
		return getResolver().getAttribute(object);
	}
	
}