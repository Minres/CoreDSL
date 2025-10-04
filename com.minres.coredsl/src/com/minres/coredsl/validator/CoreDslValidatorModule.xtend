package com.minres.coredsl.validator

import com.google.inject.Binder
import com.minres.coredsl.CoreDslRuntimeModule
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.scoping.impl.ImportUriResolver
import com.minres.coredsl.scoping.IncludeUriResolver

/** 
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all") class CoreDslValidatorModule extends CoreDslRuntimeModule {
    override void configure(Binder binder) {
        super.configure(binder);
        binder.bind(IFileSystemAccess2)
            .to(JavaIoFileSystemAccess)
        binder.bind(ImportUriResolver).to(IncludeUriResolver);
    }

}
