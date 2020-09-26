/**
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl.coreDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direct Abstract Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.coredsl.coreDsl.DirectAbstractDeclarator#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.DirectAbstractDeclarator#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see com.minres.coredsl.coreDsl.CoreDslPackage#getDirectAbstractDeclarator()
 * @model
 * @generated
 */
public interface DirectAbstractDeclarator extends AbstractDeclarator, ParameterList
{
  /**
   * Returns the value of the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declarator</em>' containment reference.
   * @see #setDeclarator(AbstractDeclarator)
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getDirectAbstractDeclarator_Declarator()
   * @model containment="true"
   * @generated
   */
  AbstractDeclarator getDeclarator();

  /**
   * Sets the value of the '{@link com.minres.coredsl.coreDsl.DirectAbstractDeclarator#getDeclarator <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declarator</em>' containment reference.
   * @see #getDeclarator()
   * @generated
   */
  void setDeclarator(AbstractDeclarator value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getDirectAbstractDeclarator_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link com.minres.coredsl.coreDsl.DirectAbstractDeclarator#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

} // DirectAbstractDeclarator
