/**
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl.coreDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumerator List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.coredsl.coreDsl.EnumeratorList#getEnumerators <em>Enumerators</em>}</li>
 * </ul>
 *
 * @see com.minres.coredsl.coreDsl.CoreDslPackage#getEnumeratorList()
 * @model
 * @generated
 */
public interface EnumeratorList extends EObject
{
  /**
   * Returns the value of the '<em><b>Enumerators</b></em>' containment reference list.
   * The list contents are of type {@link com.minres.coredsl.coreDsl.Enumerator}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumerators</em>' containment reference list.
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getEnumeratorList_Enumerators()
   * @model containment="true"
   * @generated
   */
  EList<Enumerator> getEnumerators();

} // EnumeratorList
