package com.minres.coredsl.util;

import com.minres.coredsl.coreDsl.AssignmentExpression;
import com.minres.coredsl.coreDsl.BitField;
import com.minres.coredsl.coreDsl.BoolConstant;
import com.minres.coredsl.coreDsl.CastExpression;
import com.minres.coredsl.coreDsl.CharacterConstant;
import com.minres.coredsl.coreDsl.ConditionalExpression;
import com.minres.coredsl.coreDsl.DirectDeclarator;
import com.minres.coredsl.coreDsl.Expression;
import com.minres.coredsl.coreDsl.FloatingConstant;
import com.minres.coredsl.coreDsl.FunctionDefinition;
import com.minres.coredsl.coreDsl.InfixExpression;
import com.minres.coredsl.coreDsl.IntegerConstant;
import com.minres.coredsl.coreDsl.PostfixExpression;
import com.minres.coredsl.coreDsl.PrefixExpression;
import com.minres.coredsl.coreDsl.PrimaryExpression;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class SizeProvider {
  protected static Integer _sizeOf(final PrimaryExpression e) {
    return null;
  }
  
  protected static Integer _sizeOf(final PostfixExpression e) {
    return null;
  }
  
  protected static Integer _sizeOf(final PrefixExpression e) {
    return null;
  }
  
  protected static Integer _sizeOf(final CastExpression e) {
    return null;
  }
  
  protected static Integer _sizeOf(final InfixExpression e) {
    return null;
  }
  
  protected static Integer _sizeOf(final AssignmentExpression e) {
    return null;
  }
  
  protected static Integer _sizeOf(final ConditionalExpression e) {
    return null;
  }
  
  protected static Integer _sizeOf(final Expression e) {
    return null;
  }
  
  protected static Integer _sizeOf(final FunctionDefinition e) {
    return null;
  }
  
  protected static Integer _sizeOf(final DirectDeclarator e) {
    return null;
  }
  
  protected static Integer _sizeOf(final BitField e) {
    return null;
  }
  
  protected static Integer _sizeOf(final IntegerConstant e) {
    return null;
  }
  
  protected static Integer _sizeOf(final FloatingConstant e) {
    return null;
  }
  
  protected static Integer _sizeOf(final BoolConstant e) {
    return null;
  }
  
  protected static Integer _sizeOf(final CharacterConstant e) {
    return null;
  }
  
  public static Integer sizeOf(final EObject e) {
    if (e instanceof PrimaryExpression) {
      return _sizeOf((PrimaryExpression)e);
    } else if (e instanceof PostfixExpression) {
      return _sizeOf((PostfixExpression)e);
    } else if (e instanceof PrefixExpression) {
      return _sizeOf((PrefixExpression)e);
    } else if (e instanceof AssignmentExpression) {
      return _sizeOf((AssignmentExpression)e);
    } else if (e instanceof BitField) {
      return _sizeOf((BitField)e);
    } else if (e instanceof CastExpression) {
      return _sizeOf((CastExpression)e);
    } else if (e instanceof ConditionalExpression) {
      return _sizeOf((ConditionalExpression)e);
    } else if (e instanceof InfixExpression) {
      return _sizeOf((InfixExpression)e);
    } else if (e instanceof BoolConstant) {
      return _sizeOf((BoolConstant)e);
    } else if (e instanceof CharacterConstant) {
      return _sizeOf((CharacterConstant)e);
    } else if (e instanceof DirectDeclarator) {
      return _sizeOf((DirectDeclarator)e);
    } else if (e instanceof Expression) {
      return _sizeOf((Expression)e);
    } else if (e instanceof FloatingConstant) {
      return _sizeOf((FloatingConstant)e);
    } else if (e instanceof FunctionDefinition) {
      return _sizeOf((FunctionDefinition)e);
    } else if (e instanceof IntegerConstant) {
      return _sizeOf((IntegerConstant)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
}
