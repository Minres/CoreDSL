/*
 * generated by Xtext 2.26.0
 */
package com.minres.coredsl.web

import com.google.inject.Guice
import com.google.inject.Injector
import com.minres.coredsl.CoreDslRuntimeModule
import com.minres.coredsl.CoreDslStandaloneSetup
import com.minres.coredsl.ide.CoreDslIdeModule
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages in web applications.
 */
class CoreDslWebSetup extends CoreDslStandaloneSetup {
	
	override Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new CoreDslRuntimeModule, new CoreDslIdeModule, new CoreDslWebModule))
	}
	
}
