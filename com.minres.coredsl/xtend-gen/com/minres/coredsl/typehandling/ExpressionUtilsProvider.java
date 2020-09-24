package com.minres.coredsl.typehandling;

import com.google.common.collect.Iterables;
import com.minres.coredsl.coreDsl.AdditionExpr;
import com.minres.coredsl.coreDsl.BitExpr;
import com.minres.coredsl.coreDsl.BitField;
import com.minres.coredsl.coreDsl.BooleanExpr;
import com.minres.coredsl.coreDsl.ComparisonExpr;
import com.minres.coredsl.coreDsl.ConditionalStmt;
import com.minres.coredsl.coreDsl.Constant;
import com.minres.coredsl.coreDsl.CoreDef;
import com.minres.coredsl.coreDsl.Expression;
import com.minres.coredsl.coreDsl.Function;
import com.minres.coredsl.coreDsl.ISA;
import com.minres.coredsl.coreDsl.IndexedVariable;
import com.minres.coredsl.coreDsl.Instruction;
import com.minres.coredsl.coreDsl.InstructionSet;
import com.minres.coredsl.coreDsl.MultiplicationExpr;
import com.minres.coredsl.coreDsl.NumberLiteral;
import com.minres.coredsl.coreDsl.Operation;
import com.minres.coredsl.coreDsl.RegAttribute;
import com.minres.coredsl.coreDsl.Register;
import com.minres.coredsl.coreDsl.RegisterAlias;
import com.minres.coredsl.coreDsl.RegisterVariable;
import com.minres.coredsl.coreDsl.Scalar;
import com.minres.coredsl.coreDsl.ScalarAssignment;
import com.minres.coredsl.coreDsl.ShiftExpr;
import com.minres.coredsl.coreDsl.Statement;
import com.minres.coredsl.coreDsl.TypeConv;
import com.minres.coredsl.coreDsl.UnitaryExpr;
import com.minres.coredsl.coreDsl.ValueRef;
import com.minres.coredsl.coreDsl.Variable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ExpressionUtilsProvider {
  public enum Determination {
    HOST,
    
    TARGET;
  }
  
  public Boolean isDetermined(final Expression e) {
    boolean _matched = false;
    if (e instanceof BooleanExpr) {
      _matched=true;
      return Boolean.valueOf(((this.isDetermined(((BooleanExpr)e).getLeft())).booleanValue() && (this.isDetermined(((BooleanExpr)e).getRight())).booleanValue()));
    }
    if (!_matched) {
      if (e instanceof BitExpr) {
        _matched=true;
        return Boolean.valueOf(((this.isDetermined(((BitExpr)e).getLeft())).booleanValue() && (this.isDetermined(((BitExpr)e).getRight())).booleanValue()));
      }
    }
    if (!_matched) {
      if (e instanceof ComparisonExpr) {
        _matched=true;
        return Boolean.valueOf(((this.isDetermined(((ComparisonExpr)e).getLeft())).booleanValue() && (this.isDetermined(((ComparisonExpr)e).getRight())).booleanValue()));
      }
    }
    if (!_matched) {
      if (e instanceof ShiftExpr) {
        _matched=true;
        return Boolean.valueOf(((this.isDetermined(((ShiftExpr)e).getLeft())).booleanValue() && (this.isDetermined(((ShiftExpr)e).getRight())).booleanValue()));
      }
    }
    if (!_matched) {
      if (e instanceof AdditionExpr) {
        _matched=true;
        return Boolean.valueOf(((this.isDetermined(((AdditionExpr)e).getLeft())).booleanValue() && (this.isDetermined(((AdditionExpr)e).getRight())).booleanValue()));
      }
    }
    if (!_matched) {
      if (e instanceof MultiplicationExpr) {
        _matched=true;
        return Boolean.valueOf(((this.isDetermined(((MultiplicationExpr)e).getLeft())).booleanValue() && (this.isDetermined(((MultiplicationExpr)e).getRight())).booleanValue()));
      }
    }
    if (!_matched) {
      if (e instanceof UnitaryExpr) {
        _matched=true;
        return this.isDetermined(((UnitaryExpr)e).getExpr());
      }
    }
    if (!_matched) {
      if (e instanceof TypeConv) {
        _matched=true;
        return this.isDetermined(((TypeConv)e).getExpr());
      }
    }
    if (!_matched) {
      if (e instanceof NumberLiteral) {
        _matched=true;
        return Boolean.valueOf(true);
      }
    }
    if (!_matched) {
      if (e instanceof Function) {
        _matched=true;
        String _name = ((Function)e).getName();
        if (_name != null) {
          switch (_name) {
            case "sext":
            case "zext":
            case "shll":
            case "shrl":
            case "shra":
              return this.isDetermined(((Function)e).getArgs().get(0));
            case "choose":
              return Boolean.valueOf(((this.isDetermined(((Function)e).getArgs().get(1))).booleanValue() && (this.isDetermined(((Function)e).getArgs().get(2))).booleanValue()));
            default:
              Boolean _xifexpression = null;
              int _size = ((Function)e).getArgs().size();
              boolean _greaterThan = (_size > 0);
              if (_greaterThan) {
                final Function1<Expression, Boolean> _function = (Expression a) -> {
                  return this.isDetermined(a);
                };
                final Function2<Boolean, Boolean, Boolean> _function_1 = (Boolean p1, Boolean p2) -> {
                  return Boolean.valueOf(((p1).booleanValue() && (p2).booleanValue()));
                };
                _xifexpression = IterableExtensions.<Boolean>reduce(ListExtensions.<Expression, Boolean>map(((Function)e).getArgs(), _function), _function_1);
              } else {
                _xifexpression = Boolean.valueOf(false);
              }
              return _xifexpression;
          }
        } else {
          Boolean _xifexpression = null;
          int _size = ((Function)e).getArgs().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            final Function1<Expression, Boolean> _function = (Expression a) -> {
              return this.isDetermined(a);
            };
            final Function2<Boolean, Boolean, Boolean> _function_1 = (Boolean p1, Boolean p2) -> {
              return Boolean.valueOf(((p1).booleanValue() && (p2).booleanValue()));
            };
            _xifexpression = IterableExtensions.<Boolean>reduce(ListExtensions.<Expression, Boolean>map(((Function)e).getArgs(), _function), _function_1);
          } else {
            _xifexpression = Boolean.valueOf(false);
          }
          return _xifexpression;
        }
      }
    }
    if (!_matched) {
      if (e instanceof ValueRef) {
        _matched=true;
        return Boolean.valueOf(this.isDetermined(((ValueRef)e).getValue()));
      }
    }
    return Boolean.valueOf(false);
  }
  
  public boolean isDetermined(final EObject e) {
    boolean _matched = false;
    if (e instanceof BitField) {
      _matched=true;
      return true;
    }
    if (!_matched) {
      if (e instanceof Constant) {
        _matched=true;
        return true;
      }
    }
    if (!_matched) {
      if (e instanceof Scalar) {
        _matched=true;
        return ((Scalar)e).isDetermined();
      }
    }
    if (!_matched) {
      if (e instanceof RegisterVariable) {
        _matched=true;
        return this.isPc(((RegisterVariable)e));
      }
    }
    if (!_matched) {
      if (e instanceof Variable) {
        _matched=true;
        return false;
      }
    }
    return false;
  }
  
  public boolean isPc(final RegisterVariable register) {
    boolean _matched = false;
    if (register instanceof Register) {
      _matched=true;
      final Function1<RegAttribute, Boolean> _function = (RegAttribute it) -> {
        return Boolean.valueOf((it == RegAttribute.PC));
      };
      RegAttribute _findFirst = IterableExtensions.<RegAttribute>findFirst(((Register)register).getAttributes(), _function);
      return (_findFirst != null);
    }
    if (!_matched) {
      if (register instanceof RegisterAlias) {
        _matched=true;
        Variable _original = ((RegisterAlias)register).getOriginal();
        final Function1<RegAttribute, Boolean> _function = (RegAttribute it) -> {
          return Boolean.valueOf((it == RegAttribute.PC));
        };
        RegAttribute _findFirst = IterableExtensions.<RegAttribute>findFirst(((Register) _original).getAttributes(), _function);
        return (_findFirst != null);
      }
    }
    return false;
  }
  
  protected List<EObject> _symbolsDefinedBefore(final EObject cont, final EObject o) {
    return this.symbolsDefinedBefore(cont.eContainer(), o.eContainer());
  }
  
  protected List<EObject> _symbolsDefinedBefore(final ConditionalStmt stmt, final EObject o) {
    Expression _cond = stmt.getCond();
    boolean _tripleEquals = (_cond == o);
    if (_tripleEquals) {
      return this.symbolsDefinedBefore(stmt.eContainer(), o.eContainer());
    } else {
      boolean _contains = stmt.getThenStmts().contains(o);
      if (_contains) {
        final ArrayList<EObject> res = CollectionLiterals.<EObject>newArrayList();
        res.addAll(this.localsDefinedBefore(stmt.getThenStmts(), o));
        res.addAll(this.symbolsDefinedBefore(stmt.eContainer(), o.eContainer()));
        return res;
      } else {
        int _size = stmt.getElseStmts().size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          final ArrayList<EObject> res_1 = CollectionLiterals.<EObject>newArrayList();
          res_1.addAll(this.localsDefinedBefore(stmt.getElseStmts(), o));
          res_1.addAll(this.symbolsDefinedBefore(stmt.eContainer(), o.eContainer()));
          return res_1;
        }
      }
    }
    return null;
  }
  
  protected List<EObject> _symbolsDefinedBefore(final Operation oper, final EObject o) {
    ISA _parentOfType = this.<ISA>parentOfType(oper, ISA.class);
    final ISA isa = ((ISA) _parentOfType);
    EObject _eContainer = oper.eContainer();
    final Instruction inst = ((Instruction) _eContainer);
    final ArrayList<EObject> res = CollectionLiterals.<EObject>newArrayList();
    res.addAll(this.localsDefinedBefore(oper.getStatements(), o));
    res.addAll(IterableExtensions.<IndexedVariable>toList(this.<IndexedVariable>allOfType(isa, IndexedVariable.class)));
    res.addAll(IterableExtensions.<RegisterVariable>toList(this.<RegisterVariable>allOfType(isa, RegisterVariable.class)));
    res.addAll(IterableExtensions.<Constant>toList(this.<Constant>allOfType(isa, Constant.class)));
    res.addAll(EcoreUtil2.<BitField>getAllContentsOfType(inst, BitField.class));
    return res;
  }
  
  private List<EObject> localsDefinedBefore(final List<Statement> list, final EObject o) {
    final int idx = list.indexOf(o);
    final Function1<ScalarAssignment, Scalar> _function = (ScalarAssignment a) -> {
      return a.getTo();
    };
    return CollectionLiterals.<EObject>newArrayList(((EObject[])Conversions.unwrapArray(IterableExtensions.<ScalarAssignment, Scalar>map(Iterables.<ScalarAssignment>filter(list.subList(0, idx), ScalarAssignment.class), _function), EObject.class)));
  }
  
  public <T extends EObject> T parentOfType(final EObject obj, final Class<T> clazz) {
    EObject _eContainer = obj.eContainer();
    boolean _tripleEquals = (_eContainer == null);
    if (_tripleEquals) {
      return null;
    }
    boolean _isInstance = clazz.isInstance(obj.eContainer());
    if (_isInstance) {
      EObject _eContainer_1 = obj.eContainer();
      return ((T) _eContainer_1);
    }
    return this.<T>parentOfType(obj.eContainer(), clazz);
  }
  
  public <T extends EObject> Iterable<T> allOfType(final ISA isa, final Class<T> clazz) {
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
          return this.<T>allOfType(it, clazz);
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
          Iterable<T> _allOfType = this.<T>allOfType(((InstructionSet)isa).getSuperType(), clazz);
          return Iterables.<T>concat(_allContentsOfType, _allOfType);
        }
      }
    }
    return null;
  }
  
  public List<EObject> symbolsDefinedBefore(final EObject stmt, final EObject o) {
    if (stmt instanceof ConditionalStmt) {
      return _symbolsDefinedBefore((ConditionalStmt)stmt, o);
    } else if (stmt instanceof Operation) {
      return _symbolsDefinedBefore((Operation)stmt, o);
    } else if (stmt != null) {
      return _symbolsDefinedBefore(stmt, o);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(stmt, o).toString());
    }
  }
}
