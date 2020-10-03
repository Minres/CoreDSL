package com.minres.coredsl.util;

import com.google.common.base.Objects;
import com.minres.coredsl.converter.BigDecimalWithSize;
import com.minres.coredsl.converter.BigIntegerWithRadix;
import com.minres.coredsl.coreDsl.AssignmentExpression;
import com.minres.coredsl.coreDsl.BitField;
import com.minres.coredsl.coreDsl.BoolConstant;
import com.minres.coredsl.coreDsl.CastExpression;
import com.minres.coredsl.coreDsl.CharacterConstant;
import com.minres.coredsl.coreDsl.ConditionalExpression;
import com.minres.coredsl.coreDsl.Constant;
import com.minres.coredsl.coreDsl.CoreDslFactory;
import com.minres.coredsl.coreDsl.DataTypes;
import com.minres.coredsl.coreDsl.Declaration;
import com.minres.coredsl.coreDsl.DirectDeclarator;
import com.minres.coredsl.coreDsl.Expression;
import com.minres.coredsl.coreDsl.FloatingConstant;
import com.minres.coredsl.coreDsl.FunctionDefinition;
import com.minres.coredsl.coreDsl.InfixExpression;
import com.minres.coredsl.coreDsl.InitDeclarator;
import com.minres.coredsl.coreDsl.IntegerConstant;
import com.minres.coredsl.coreDsl.PodSpecifier;
import com.minres.coredsl.coreDsl.PostfixExpression;
import com.minres.coredsl.coreDsl.PrefixExpression;
import com.minres.coredsl.coreDsl.PrimaryExpression;
import com.minres.coredsl.coreDsl.TypeSpecifier;
import com.minres.coredsl.coreDsl.Variable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;

@SuppressWarnings("all")
public class TypeProvider {
  protected static TypeSpecifier _typeOf(final PrimaryExpression e) {
    Object _xifexpression = null;
    Constant _constant = e.getConstant();
    boolean _tripleNotEquals = (_constant != null);
    if (_tripleNotEquals) {
      _xifexpression = null;
    } else {
      Object _xifexpression_1 = null;
      Variable _ref = e.getRef();
      boolean _tripleNotEquals_1 = (_ref != null);
      if (_tripleNotEquals_1) {
        _xifexpression_1 = null;
      } else {
        return null;
      }
      _xifexpression = _xifexpression_1;
    }
    return ((TypeSpecifier)_xifexpression);
  }
  
  protected static TypeSpecifier _typeOf(final PostfixExpression e) {
    return null;
  }
  
  protected static TypeSpecifier _typeOf(final PrefixExpression e) {
    return null;
  }
  
  protected static TypeSpecifier _typeOf(final CastExpression e) {
    return null;
  }
  
  protected static TypeSpecifier _typeOf(final InfixExpression e) {
    return null;
  }
  
  protected static TypeSpecifier _typeOf(final AssignmentExpression e) {
    return null;
  }
  
  protected static TypeSpecifier _typeOf(final ConditionalExpression e) {
    return null;
  }
  
  protected static TypeSpecifier _typeOf(final Expression e) {
    return null;
  }
  
  protected static TypeSpecifier _typeOf(final FunctionDefinition e) {
    TypeSpecifier _type = e.getType();
    return ((TypeSpecifier) _type);
  }
  
  protected static TypeSpecifier _typeOf(final DirectDeclarator e) {
    if (((e.eContainer() instanceof InitDeclarator) && (e.eContainer().eContainer() instanceof Declaration))) {
      EObject _eContainer = e.eContainer().eContainer();
      Declaration decl = ((Declaration) _eContainer);
      return decl.getType();
    }
    return null;
  }
  
  protected static TypeSpecifier _typeOf(final BitField e) {
    final PodSpecifier elem = CoreDslFactory.eINSTANCE.createPodSpecifier();
    elem.getDataType().add(DataTypes.UNSIGNED);
    return ((TypeSpecifier) elem);
  }
  
  protected static TypeSpecifier _typeOf(final IntegerConstant e) {
    BigInteger _value = e.getValue();
    final BigIntegerWithRadix value = ((BigIntegerWithRadix) _value);
    final PodSpecifier elem = CoreDslFactory.eINSTANCE.createPodSpecifier();
    EList<DataTypes> _dataType = elem.getDataType();
    DataTypes _xifexpression = null;
    BigIntegerWithRadix.TYPE _type = value.getType();
    boolean _equals = Objects.equal(_type, BigIntegerWithRadix.TYPE.UNSIGNED);
    if (_equals) {
      _xifexpression = DataTypes.UNSIGNED;
    } else {
      _xifexpression = DataTypes.SIGNED;
    }
    _dataType.add(_xifexpression);
    int _size = value.getSize();
    boolean _greaterThan = (_size > 64);
    if (_greaterThan) {
      CollectionExtensions.<DataTypes>addAll(elem.getDataType(), DataTypes.LONG, DataTypes.LONG);
    } else {
      int _size_1 = value.getSize();
      boolean _greaterThan_1 = (_size_1 > 64);
      if (_greaterThan_1) {
        elem.getDataType().add(DataTypes.LONG);
      } else {
        int _size_2 = value.getSize();
        boolean _greaterThan_2 = (_size_2 > 32);
        if (_greaterThan_2) {
          elem.getDataType().add(DataTypes.INT);
        } else {
          int _size_3 = value.getSize();
          boolean _greaterThan_3 = (_size_3 > 16);
          if (_greaterThan_3) {
            elem.getDataType().add(DataTypes.SHORT);
          } else {
            int _size_4 = value.getSize();
            boolean _greaterThan_4 = (_size_4 > 8);
            if (_greaterThan_4) {
              elem.getDataType().add(DataTypes.CHAR);
            }
          }
        }
      }
    }
    return ((TypeSpecifier) elem);
  }
  
  protected static TypeSpecifier _typeOf(final FloatingConstant e) {
    BigDecimal _value = e.getValue();
    final BigDecimalWithSize value = ((BigDecimalWithSize) _value);
    final PodSpecifier elem = CoreDslFactory.eINSTANCE.createPodSpecifier();
    int _size = value.getSize();
    boolean _equals = (_size == 32);
    boolean _matched = false;
    if (Objects.equal(_equals, 32)) {
      _matched=true;
      elem.getDataType().add(DataTypes.FLOAT);
    }
    if (!_matched) {
      elem.getDataType().add(DataTypes.DOUBLE);
    }
    return ((TypeSpecifier) elem);
  }
  
  protected static TypeSpecifier _typeOf(final BoolConstant e) {
    final PodSpecifier elem = CoreDslFactory.eINSTANCE.createPodSpecifier();
    elem.getDataType().add(DataTypes.UNSIGNED);
    elem.getDataType().add(DataTypes.INT);
    return ((TypeSpecifier) elem);
  }
  
  protected static TypeSpecifier _typeOf(final CharacterConstant e) {
    final PodSpecifier elem = CoreDslFactory.eINSTANCE.createPodSpecifier();
    elem.getDataType().add(DataTypes.CHAR);
    return ((TypeSpecifier) elem);
  }
  
  public static boolean isComparable(final TypeSpecifier left, final TypeSpecifier right) {
    return true;
  }
  
  public static boolean isAssignable(final TypeSpecifier to, final TypeSpecifier from) {
    return true;
  }
  
  public static TypeSpecifier typeOf(final EObject e) {
    if (e instanceof PrimaryExpression) {
      return _typeOf((PrimaryExpression)e);
    } else if (e instanceof PostfixExpression) {
      return _typeOf((PostfixExpression)e);
    } else if (e instanceof PrefixExpression) {
      return _typeOf((PrefixExpression)e);
    } else if (e instanceof AssignmentExpression) {
      return _typeOf((AssignmentExpression)e);
    } else if (e instanceof BitField) {
      return _typeOf((BitField)e);
    } else if (e instanceof CastExpression) {
      return _typeOf((CastExpression)e);
    } else if (e instanceof ConditionalExpression) {
      return _typeOf((ConditionalExpression)e);
    } else if (e instanceof InfixExpression) {
      return _typeOf((InfixExpression)e);
    } else if (e instanceof BoolConstant) {
      return _typeOf((BoolConstant)e);
    } else if (e instanceof CharacterConstant) {
      return _typeOf((CharacterConstant)e);
    } else if (e instanceof DirectDeclarator) {
      return _typeOf((DirectDeclarator)e);
    } else if (e instanceof Expression) {
      return _typeOf((Expression)e);
    } else if (e instanceof FloatingConstant) {
      return _typeOf((FloatingConstant)e);
    } else if (e instanceof FunctionDefinition) {
      return _typeOf((FunctionDefinition)e);
    } else if (e instanceof IntegerConstant) {
      return _typeOf((IntegerConstant)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
}
