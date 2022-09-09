/*
 * generated by Xtext 2.26.0
 */
package com.minres.coredsl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class CoreDslLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public CoreDslLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:

	//	String text(Greeting ele) {
	//		return "A greeting to " + ele.getName();
	//	}
	//
	//	String image(Greeting ele) {
	//		return "Greeting.gif";
	//	}
}