/*
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class CoreDslStandaloneSetup extends CoreDslStandaloneSetupGenerated {

	def static void doSetup() {
		new CoreDslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
