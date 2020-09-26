/**
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl.coreDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.coredsl.coreDsl.AttributeList#getAttrs <em>Attrs</em>}</li>
 * </ul>
 *
 * @see com.minres.coredsl.coreDsl.CoreDslPackage#getAttributeList()
 * @model
 * @generated
 */
public interface AttributeList extends EObject
{
  /**
   * Returns the value of the '<em><b>Attrs</b></em>' attribute list.
   * The list contents are of type {@link com.minres.coredsl.coreDsl.Attribute}.
   * The literals are from the enumeration {@link com.minres.coredsl.coreDsl.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attrs</em>' attribute list.
   * @see com.minres.coredsl.coreDsl.Attribute
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getAttributeList_Attrs()
   * @model unique="false"
   * @generated
   */
  EList<Attribute> getAttrs();

} // AttributeList
