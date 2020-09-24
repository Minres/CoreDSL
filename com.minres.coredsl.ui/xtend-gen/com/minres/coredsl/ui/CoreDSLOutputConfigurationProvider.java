package com.minres.coredsl.ui;

import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;

@SuppressWarnings("all")
public class CoreDSLOutputConfigurationProvider extends OutputConfigurationProvider {
  @Override
  public Set<OutputConfiguration> getOutputConfigurations(final Resource resource) {
    final Set<OutputConfiguration> cfgs = super.getOutputConfigurations(resource);
    return cfgs;
  }
  
  @Override
  public Set<OutputConfiguration> getOutputConfigurations() {
    Set<OutputConfiguration> ret = super.getOutputConfigurations();
    final OutputConfiguration tmplInput = new OutputConfiguration("tmpl-in");
    tmplInput.setDescription("Template Input Folder");
    tmplInput.setOutputDirectory("./template");
    tmplInput.setOverrideExistingResources(false);
    tmplInput.setCreateOutputDirectory(false);
    tmplInput.setCleanUpDerivedResources(false);
    tmplInput.setSetDerivedProperty(false);
    tmplInput.setKeepLocalHistory(Boolean.valueOf(true));
    ret.add(tmplInput);
    return ret;
  }
}
