/**
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl.coreDsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Instr Attribute</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.minres.coredsl.coreDsl.CoreDslPackage#getInstrAttribute()
 * @model
 * @generated
 */
public enum InstrAttribute implements Enumerator
{
  /**
   * The '<em><b>NONE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NONE_VALUE
   * @generated
   * @ordered
   */
  NONE(0, "NONE", "NONE"),

  /**
   * The '<em><b>NO CONT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NO_CONT_VALUE
   * @generated
   * @ordered
   */
  NO_CONT(1, "NO_CONT", "no_cont"),

  /**
   * The '<em><b>COND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COND_VALUE
   * @generated
   * @ordered
   */
  COND(2, "COND", "cond"),

  /**
   * The '<em><b>FLUSH</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLUSH_VALUE
   * @generated
   * @ordered
   */
  FLUSH(3, "FLUSH", "flush");

  /**
   * The '<em><b>NONE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NONE
   * @model
   * @generated
   * @ordered
   */
  public static final int NONE_VALUE = 0;

  /**
   * The '<em><b>NO CONT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NO_CONT
   * @model literal="no_cont"
   * @generated
   * @ordered
   */
  public static final int NO_CONT_VALUE = 1;

  /**
   * The '<em><b>COND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COND
   * @model literal="cond"
   * @generated
   * @ordered
   */
  public static final int COND_VALUE = 2;

  /**
   * The '<em><b>FLUSH</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLUSH
   * @model literal="flush"
   * @generated
   * @ordered
   */
  public static final int FLUSH_VALUE = 3;

  /**
   * An array of all the '<em><b>Instr Attribute</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final InstrAttribute[] VALUES_ARRAY =
    new InstrAttribute[]
    {
      NONE,
      NO_CONT,
      COND,
      FLUSH,
    };

  /**
   * A public read-only list of all the '<em><b>Instr Attribute</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<InstrAttribute> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Instr Attribute</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static InstrAttribute get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      InstrAttribute result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Instr Attribute</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static InstrAttribute getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      InstrAttribute result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Instr Attribute</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static InstrAttribute get(int value)
  {
    switch (value)
    {
      case NONE_VALUE: return NONE;
      case NO_CONT_VALUE: return NO_CONT;
      case COND_VALUE: return COND;
      case FLUSH_VALUE: return FLUSH;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private InstrAttribute(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //InstrAttribute
