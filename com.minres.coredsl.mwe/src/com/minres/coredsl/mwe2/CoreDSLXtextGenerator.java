package com.minres.coredsl.mwe2;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.xtext.generator.XtextGenerator;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
 
@SuppressWarnings("restriction")
public class CoreDSLXtextGenerator extends XtextGenerator {
     
    @SuppressWarnings("deprecation")
    public CoreDSLXtextGenerator() {
        new XtextStandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new XtextRuntimeModule() {
                    @Override
                    public void configureIXtext2EcorePostProcessor(Binder binder) {
                    binder.bind(org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor.class).to(com.minres.coredsl.mwe2.CoreDSLXtext2EcorePostProcessor.class);
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
    }
 
}