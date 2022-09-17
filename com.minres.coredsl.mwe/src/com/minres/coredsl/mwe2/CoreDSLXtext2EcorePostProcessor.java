package com.minres.coredsl.mwe2;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;

@SuppressWarnings("all")
public class CoreDSLXtext2EcorePostProcessor implements IXtext2EcorePostProcessor {
  @Override
  public void process(final GeneratedMetamodel metamodel) {
    this.process(metamodel.getEPackage());
  }
  
  public void process(final EPackage p) {
    Iterable<EEnum> _filter = Iterables.<EEnum>filter(p.getEClassifiers(), EEnum.class);
    for (final EEnum c : _filter) {
      String _name = c.getName();
      boolean _equals = Objects.equal(_name, "StorageClassSpecifier");
      if (_equals) {
        this.handle(c);
      }
    }
  }
  
  public boolean handle(final EEnum e) {
    boolean _xblockexpression = false;
    {
      final Consumer<EEnumLiteral> _function = (EEnumLiteral it) -> {
        int _value = it.getValue();
        int _plus = (_value + 1);
        it.setValue(_plus);
      };
      e.getELiterals().forEach(_function);
      final EEnumLiteral paramLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
      paramLiteral.setName("param");
      paramLiteral.setLiteral("PARAM");
      paramLiteral.setValue(0);
      e.getELiterals().add(0, paramLiteral);
      final EEnumLiteral aliasLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
      aliasLiteral.setName("alias");
      aliasLiteral.setLiteral("ALIAS");
      aliasLiteral.setValue(0);
      EList<EEnumLiteral> _eLiterals = e.getELiterals();
      _xblockexpression = _eLiterals.add(aliasLiteral);
    }
    return _xblockexpression;
  }
}
