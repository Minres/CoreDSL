/**
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl.coreDsl.impl;

import com.minres.coredsl.coreDsl.CoreDslPackage;
import com.minres.coredsl.coreDsl.IfStatement;
import com.minres.coredsl.coreDsl.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.minres.coredsl.coreDsl.impl.IfStatementImpl#getThenStmt <em>Then Stmt</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.impl.IfStatementImpl#getElseStmt <em>Else Stmt</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfStatementImpl extends SelectionStatementImpl implements IfStatement
{
  /**
   * The cached value of the '{@link #getThenStmt() <em>Then Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenStmt()
   * @generated
   * @ordered
   */
  protected Statement thenStmt;

  /**
   * The cached value of the '{@link #getElseStmt() <em>Else Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseStmt()
   * @generated
   * @ordered
   */
  protected Statement elseStmt;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfStatementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CoreDslPackage.Literals.IF_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Statement getThenStmt()
  {
    return thenStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenStmt(Statement newThenStmt, NotificationChain msgs)
  {
    Statement oldThenStmt = thenStmt;
    thenStmt = newThenStmt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoreDslPackage.IF_STATEMENT__THEN_STMT, oldThenStmt, newThenStmt);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setThenStmt(Statement newThenStmt)
  {
    if (newThenStmt != thenStmt)
    {
      NotificationChain msgs = null;
      if (thenStmt != null)
        msgs = ((InternalEObject)thenStmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoreDslPackage.IF_STATEMENT__THEN_STMT, null, msgs);
      if (newThenStmt != null)
        msgs = ((InternalEObject)newThenStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CoreDslPackage.IF_STATEMENT__THEN_STMT, null, msgs);
      msgs = basicSetThenStmt(newThenStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoreDslPackage.IF_STATEMENT__THEN_STMT, newThenStmt, newThenStmt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Statement getElseStmt()
  {
    return elseStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseStmt(Statement newElseStmt, NotificationChain msgs)
  {
    Statement oldElseStmt = elseStmt;
    elseStmt = newElseStmt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoreDslPackage.IF_STATEMENT__ELSE_STMT, oldElseStmt, newElseStmt);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setElseStmt(Statement newElseStmt)
  {
    if (newElseStmt != elseStmt)
    {
      NotificationChain msgs = null;
      if (elseStmt != null)
        msgs = ((InternalEObject)elseStmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoreDslPackage.IF_STATEMENT__ELSE_STMT, null, msgs);
      if (newElseStmt != null)
        msgs = ((InternalEObject)newElseStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CoreDslPackage.IF_STATEMENT__ELSE_STMT, null, msgs);
      msgs = basicSetElseStmt(newElseStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoreDslPackage.IF_STATEMENT__ELSE_STMT, newElseStmt, newElseStmt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CoreDslPackage.IF_STATEMENT__THEN_STMT:
        return basicSetThenStmt(null, msgs);
      case CoreDslPackage.IF_STATEMENT__ELSE_STMT:
        return basicSetElseStmt(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CoreDslPackage.IF_STATEMENT__THEN_STMT:
        return getThenStmt();
      case CoreDslPackage.IF_STATEMENT__ELSE_STMT:
        return getElseStmt();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CoreDslPackage.IF_STATEMENT__THEN_STMT:
        setThenStmt((Statement)newValue);
        return;
      case CoreDslPackage.IF_STATEMENT__ELSE_STMT:
        setElseStmt((Statement)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CoreDslPackage.IF_STATEMENT__THEN_STMT:
        setThenStmt((Statement)null);
        return;
      case CoreDslPackage.IF_STATEMENT__ELSE_STMT:
        setElseStmt((Statement)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CoreDslPackage.IF_STATEMENT__THEN_STMT:
        return thenStmt != null;
      case CoreDslPackage.IF_STATEMENT__ELSE_STMT:
        return elseStmt != null;
    }
    return super.eIsSet(featureID);
  }

} //IfStatementImpl
