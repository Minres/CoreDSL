/**
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl.coreDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.coredsl.coreDsl.CoreDef#getContributingType <em>Contributing Type</em>}</li>
 * </ul>
 *
 * @see com.minres.coredsl.coreDsl.CoreDslPackage#getCoreDef()
 * @model
 * @generated
 */
public interface CoreDef extends ISA
{
  /**
   * Returns the value of the '<em><b>Contributing Type</b></em>' reference list.
   * The list contents are of type {@link com.minres.coredsl.coreDsl.InstructionSet}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contributing Type</em>' reference list.
   * @see com.minres.coredsl.coreDsl.CoreDslPackage#getCoreDef_ContributingType()
   * @model
   * @generated
   */
  EList<InstructionSet> getContributingType();

} // CoreDef
