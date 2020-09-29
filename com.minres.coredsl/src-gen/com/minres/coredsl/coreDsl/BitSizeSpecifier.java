/**
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl.coreDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bit Size Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.coredsl.coreDsl.BitSizeSpecifier#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see com.minres.coredsl.coreDsl.CoreDslPackage#getBitSizeSpecifier()
 * @model
 * @generated
 */
public interface BitSizeSpecifier extends EObject
{
  /**
   * Returns the value of the '<em><b>Size</b></em>' containment reference list.
   * The list contents are of type {@link com.minres.coredsl.coreDsl.PrimaryExpression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' containment reference list.
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getBitSizeSpecifier_Size()
   * @model containment="true"
   * @generated
   */
  EList<PrimaryExpression> getSize();

} // BitSizeSpecifier
