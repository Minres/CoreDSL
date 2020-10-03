package com.minres.coredsl.util;

import com.google.common.collect.Iterables;
import com.minres.coredsl.coreDsl.CoreDef;
import com.minres.coredsl.coreDsl.ISA;
import com.minres.coredsl.coreDsl.InstructionSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ModelUtil {
  public static <T extends EObject> Object parentOfType(final EObject obj, final Class<T> clazz) {
    EObject _eContainer = obj.eContainer();
    boolean _tripleEquals = (_eContainer == null);
    if (_tripleEquals) {
      return null;
    }
    boolean _isInstance = clazz.isInstance(obj.eContainer());
    if (_isInstance) {
      return obj.eContainer();
    }
    return ModelUtil.<T>parentOfType(obj.eContainer(), clazz);
  }
  
  public static <T extends EObject> Iterable<T> allOfType(final ISA isa, final Class<T> clazz) {
    boolean _eIsProxy = isa.eIsProxy();
    if (_eIsProxy) {
      EcoreUtil2.resolveAll(isa);
    }
    boolean _matched = false;
    if (isa instanceof CoreDef) {
      _matched=true;
      EList<InstructionSet> _contributingType = ((CoreDef)isa).getContributingType();
      boolean _tripleEquals = (_contributingType == null);
      if (_tripleEquals) {
        return EcoreUtil2.<T>getAllContentsOfType(isa, clazz);
      } else {
        List<T> _allContentsOfType = EcoreUtil2.<T>getAllContentsOfType(isa, clazz);
        final Function1<InstructionSet, Iterable<T>> _function = (InstructionSet it) -> {
          return ModelUtil.<T>allOfType(it, clazz);
        };
        Iterable<T> _flatten = Iterables.<T>concat(ListExtensions.<InstructionSet, Iterable<T>>map(((CoreDef)isa).getContributingType(), _function));
        return Iterables.<T>concat(_allContentsOfType, _flatten);
      }
    }
    if (!_matched) {
      if (isa instanceof InstructionSet) {
        _matched=true;
        InstructionSet _superType = ((InstructionSet)isa).getSuperType();
        boolean _tripleEquals = (_superType == null);
        if (_tripleEquals) {
          return EcoreUtil2.<T>getAllContentsOfType(isa, clazz);
        } else {
          List<T> _allContentsOfType = EcoreUtil2.<T>getAllContentsOfType(isa, clazz);
          Iterable<T> _allOfType = ModelUtil.<T>allOfType(((InstructionSet)isa).getSuperType(), clazz);
          return Iterables.<T>concat(_allContentsOfType, _allOfType);
        }
      }
    }
    return null;
  }
}
