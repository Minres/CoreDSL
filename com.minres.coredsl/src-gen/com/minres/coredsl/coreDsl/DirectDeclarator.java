/**
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl.coreDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direct Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.coredsl.coreDsl.DirectDeclarator#getIndex <em>Index</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.DirectDeclarator#getLeft <em>Left</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.DirectDeclarator#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.DirectDeclarator#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see com.minres.coredsl.coreDsl.CoreDslPackage#getDirectDeclarator()
 * @model
 * @generated
 */
public interface DirectDeclarator extends VariableRef
{
  /**
   * Returns the value of the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' containment reference.
   * @see #setIndex(IntegerConstant)
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getDirectDeclarator_Index()
   * @model containment="true"
   * @generated
   */
  IntegerConstant getIndex();

  /**
   * Sets the value of the '{@link com.minres.coredsl.coreDsl.DirectDeclarator#getIndex <em>Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' containment reference.
   * @see #getIndex()
   * @generated
   */
  void setIndex(IntegerConstant value);

  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(DirectDeclarator)
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getDirectDeclarator_Left()
   * @model containment="true"
   * @generated
   */
  DirectDeclarator getLeft();

  /**
   * Sets the value of the '{@link com.minres.coredsl.coreDsl.DirectDeclarator#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(DirectDeclarator value);

  /**
   * Returns the value of the '<em><b>Qualifiers</b></em>' attribute list.
   * The list contents are of type {@link com.minres.coredsl.coreDsl.TypeQualifier}.
   * The literals are from the enumeration {@link com.minres.coredsl.coreDsl.TypeQualifier}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualifiers</em>' attribute list.
   * @see com.minres.coredsl.coreDsl.TypeQualifier
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getDirectDeclarator_Qualifiers()
   * @model unique="false"
   * @generated
   */
  EList<TypeQualifier> getQualifiers();

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getDirectDeclarator_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link com.minres.coredsl.coreDsl.DirectDeclarator#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

} // DirectDeclarator
