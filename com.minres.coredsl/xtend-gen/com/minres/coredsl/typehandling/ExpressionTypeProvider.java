package com.minres.coredsl.typehandling;

import com.google.common.base.Objects;
import com.minres.coredsl.coreDsl.AdditionExpr;
import com.minres.coredsl.coreDsl.AddressSpace;
import com.minres.coredsl.coreDsl.BitExpr;
import com.minres.coredsl.coreDsl.BitField;
import com.minres.coredsl.coreDsl.BooleanExpr;
import com.minres.coredsl.coreDsl.ComparisonExpr;
import com.minres.coredsl.coreDsl.Constant;
import com.minres.coredsl.coreDsl.DataType;
import com.minres.coredsl.coreDsl.Expression;
import com.minres.coredsl.coreDsl.Function;
import com.minres.coredsl.coreDsl.MultiplicationExpr;
import com.minres.coredsl.coreDsl.NumberLiteral;
import com.minres.coredsl.coreDsl.Register;
import com.minres.coredsl.coreDsl.RegisterAlias;
import com.minres.coredsl.coreDsl.RegisterFile;
import com.minres.coredsl.coreDsl.Scalar;
import com.minres.coredsl.coreDsl.ShiftExpr;
import com.minres.coredsl.coreDsl.TypeConv;
import com.minres.coredsl.coreDsl.UnitaryExpr;
import com.minres.coredsl.coreDsl.ValueRef;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class ExpressionTypeProvider {
  protected DataType _typeFor(final Expression e) {
    boolean _matched = false;
    if (e instanceof BooleanExpr) {
      _matched=true;
      return DataType.BOOLEAN;
    }
    if (!_matched) {
      if (e instanceof BitExpr) {
        _matched=true;
        final DataType leftType = this.typeFor(((BitExpr)e).getLeft());
        if ((Objects.equal(((BitExpr)e).getOp(), "<<") || Objects.equal(((BitExpr)e).getOp(), ">>"))) {
          return this.typeFor(((BitExpr)e).getLeft());
        }
        if ((Objects.equal(leftType, this.typeFor(((BitExpr)e).getRight())) && (Objects.equal(leftType, DataType.SIGNED) || Objects.equal(leftType, DataType.UNSIGNED)))) {
          return leftType;
        } else {
          return DataType.NONE;
        }
      }
    }
    if (!_matched) {
      if (e instanceof ComparisonExpr) {
        _matched=true;
        return DataType.BOOLEAN;
      }
    }
    if (!_matched) {
      if (e instanceof ShiftExpr) {
        _matched=true;
        final DataType leftType = this.typeFor(((ShiftExpr)e).getLeft());
        if ((Objects.equal(leftType, this.typeFor(((ShiftExpr)e).getRight())) && (Objects.equal(leftType, DataType.SIGNED) || Objects.equal(leftType, DataType.UNSIGNED)))) {
          return leftType;
        } else {
          return DataType.NONE;
        }
      }
    }
    if (!_matched) {
      if (e instanceof AdditionExpr) {
        _matched=true;
        final DataType leftType = this.typeFor(((AdditionExpr)e).getLeft());
        if (((Objects.equal(leftType, this.typeFor(((AdditionExpr)e).getRight())) && (!Objects.equal(leftType, DataType.BOOLEAN))) && (!Objects.equal(leftType, DataType.NONE)))) {
          return leftType;
        } else {
          return DataType.NONE;
        }
      }
    }
    if (!_matched) {
      if (e instanceof MultiplicationExpr) {
        _matched=true;
        final DataType leftType = this.typeFor(((MultiplicationExpr)e).getLeft());
        if (((Objects.equal(leftType, this.typeFor(((MultiplicationExpr)e).getRight())) && (!Objects.equal(leftType, DataType.BOOLEAN))) && (!Objects.equal(leftType, DataType.NONE)))) {
          return leftType;
        } else {
          return DataType.NONE;
        }
      }
    }
    if (!_matched) {
      if (e instanceof UnitaryExpr) {
        _matched=true;
        String _op = ((UnitaryExpr)e).getOp();
        boolean _equals = Objects.equal(_op, "!");
        if (_equals) {
          return DataType.BOOLEAN;
        } else {
          DataType _typeFor = this.typeFor(((UnitaryExpr)e).getExpr());
          boolean _equals_1 = Objects.equal(_typeFor, DataType.SIGNED);
          if (_equals_1) {
            return DataType.SIGNED;
          } else {
            DataType _typeFor_1 = this.typeFor(((UnitaryExpr)e).getExpr());
            boolean _equals_2 = Objects.equal(_typeFor_1, DataType.UNSIGNED);
            if (_equals_2) {
              return DataType.UNSIGNED;
            } else {
              return DataType.NONE;
            }
          }
        }
      }
    }
    if (!_matched) {
      if (e instanceof TypeConv) {
        _matched=true;
        return ((TypeConv)e).getType();
      }
    }
    if (!_matched) {
      if (e instanceof Function) {
        _matched=true;
        return DataType.UNSIGNED;
      }
    }
    if (!_matched) {
      if (e instanceof NumberLiteral) {
        _matched=true;
        return DataType.UNSIGNED;
      }
    }
    return DataType.NONE;
  }
  
  protected DataType _typeFor(final ValueRef e) {
    DataType _xblockexpression = null;
    {
      final EObject ref = e.getValue();
      DataType _switchResult = null;
      boolean _matched = false;
      if (ref instanceof RegisterFile) {
        _matched=true;
        return DataType.UNSIGNED;
      }
      if (!_matched) {
        if (ref instanceof AddressSpace) {
          _matched=true;
          return DataType.UNSIGNED;
        }
      }
      if (!_matched) {
        if (ref instanceof Register) {
          _matched=true;
          return DataType.UNSIGNED;
        }
      }
      if (!_matched) {
        if (ref instanceof RegisterAlias) {
          _matched=true;
          return DataType.UNSIGNED;
        }
      }
      if (!_matched) {
        if (ref instanceof Scalar) {
          _matched=true;
          return DataType.UNSIGNED;
        }
      }
      if (!_matched) {
        if (ref instanceof Constant) {
          _matched=true;
          return DataType.UNSIGNED;
        }
      }
      if (!_matched) {
        if (ref instanceof BitField) {
          _matched=true;
          DataType _type = ((BitField)ref).getType();
          boolean _notEquals = (!Objects.equal(_type, DataType.NONE));
          if (_notEquals) {
            return ((BitField)ref).getType();
          } else {
            return DataType.UNSIGNED;
          }
        }
      }
      if (!_matched) {
        _switchResult = DataType.NONE;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public DataType typeFor(final Expression e) {
    if (e instanceof ValueRef) {
      return _typeFor((ValueRef)e);
    } else if (e != null) {
      return _typeFor(e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
}
