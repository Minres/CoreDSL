package com.minres.coredsl.ui

import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.generator.OutputConfigurationProvider

class CoreDSLOutputConfigurationProvider extends OutputConfigurationProvider {
	
	override
	 Set<OutputConfiguration> getOutputConfigurations(Resource resource) {
		val cfgs = super.getOutputConfigurations(resource)
		return cfgs
	}
	
	override Set<OutputConfiguration> getOutputConfigurations() {
		var ret = super.outputConfigurations
		val OutputConfiguration tmplInput = new OutputConfiguration("tmpl-in");
		tmplInput.setDescription("Template Input Folder");
		tmplInput.setOutputDirectory("./template");
		tmplInput.setOverrideExistingResources(false);
		tmplInput.setCreateOutputDirectory(false);
		tmplInput.setCleanUpDerivedResources(false);
		tmplInput.setSetDerivedProperty(false);
		tmplInput.setKeepLocalHistory(true);
		ret.add(tmplInput)
		return ret
	}
	
}