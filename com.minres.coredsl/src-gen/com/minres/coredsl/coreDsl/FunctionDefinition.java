/**
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl.coreDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.coredsl.coreDsl.FunctionDefinition#isExtern <em>Extern</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.FunctionDefinition#getType <em>Type</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.FunctionDefinition#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see com.minres.coredsl.coreDsl.CoreDslPackage#getFunctionDefinition()
 * @model
 * @generated
 */
public interface FunctionDefinition extends ParameterList, VariableRef
{
  /**
   * Returns the value of the '<em><b>Extern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extern</em>' attribute.
   * @see #setExtern(boolean)
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getFunctionDefinition_Extern()
   * @model
   * @generated
   */
  boolean isExtern();

  /**
   * Sets the value of the '{@link com.minres.coredsl.coreDsl.FunctionDefinition#isExtern <em>Extern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extern</em>' attribute.
   * @see #isExtern()
   * @generated
   */
  void setExtern(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeSpecifier)
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getFunctionDefinition_Type()
   * @model containment="true"
   * @generated
   */
  TypeSpecifier getType();

  /**
   * Sets the value of the '{@link com.minres.coredsl.coreDsl.FunctionDefinition#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeSpecifier value);

  /**
   * Returns the value of the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' containment reference.
   * @see #setStatement(CompoundStatement)
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getFunctionDefinition_Statement()
   * @model containment="true"
   * @generated
   */
  CompoundStatement getStatement();

  /**
   * Sets the value of the '{@link com.minres.coredsl.coreDsl.FunctionDefinition#getStatement <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement</em>' containment reference.
   * @see #getStatement()
   * @generated
   */
  void setStatement(CompoundStatement value);

} // FunctionDefinition
