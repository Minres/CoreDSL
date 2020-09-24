package com.minres.coredsl.naming;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;

@SuppressWarnings("all")
public class CoreDslNameProvider extends IQualifiedNameProvider.AbstractImpl {
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Override
  public QualifiedName getFullyQualifiedName(final EObject obj) {
    String name = SimpleAttributeResolver.NAME_RESOLVER.apply(obj);
    if (((name == null) || (name.length() == 0))) {
      return null;
    }
    return this.qualifiedNameConverter.toQualifiedName(name);
  }
}
