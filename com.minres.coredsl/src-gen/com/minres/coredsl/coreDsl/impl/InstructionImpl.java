/**
 * generated by Xtext 2.22.0
 */
package com.minres.coredsl.coreDsl.impl;

import com.minres.coredsl.coreDsl.CoreDslPackage;
import com.minres.coredsl.coreDsl.Encoding;
import com.minres.coredsl.coreDsl.InstrAttribute;
import com.minres.coredsl.coreDsl.Instruction;
import com.minres.coredsl.coreDsl.Statement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.minres.coredsl.coreDsl.impl.InstructionImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.impl.InstructionImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.impl.InstructionImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.impl.InstructionImpl#getDisass <em>Disass</em>}</li>
 *   <li>{@link com.minres.coredsl.coreDsl.impl.InstructionImpl#getBehavior <em>Behavior</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstructionImpl extends MinimalEObjectImpl.Container implements Instruction
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<InstrAttribute> attributes;

  /**
   * The cached value of the '{@link #getEncoding() <em>Encoding</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEncoding()
   * @generated
   * @ordered
   */
  protected Encoding encoding;

  /**
   * The default value of the '{@link #getDisass() <em>Disass</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDisass()
   * @generated
   * @ordered
   */
  protected static final String DISASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDisass() <em>Disass</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDisass()
   * @generated
   * @ordered
   */
  protected String disass = DISASS_EDEFAULT;

  /**
   * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehavior()
   * @generated
   * @ordered
   */
  protected Statement behavior;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InstructionImpl()
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
    return CoreDslPackage.Literals.INSTRUCTION;
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
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoreDslPackage.INSTRUCTION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<InstrAttribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EDataTypeEList<InstrAttribute>(InstrAttribute.class, this, CoreDslPackage.INSTRUCTION__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Encoding getEncoding()
  {
    return encoding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEncoding(Encoding newEncoding, NotificationChain msgs)
  {
    Encoding oldEncoding = encoding;
    encoding = newEncoding;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoreDslPackage.INSTRUCTION__ENCODING, oldEncoding, newEncoding);
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
  public void setEncoding(Encoding newEncoding)
  {
    if (newEncoding != encoding)
    {
      NotificationChain msgs = null;
      if (encoding != null)
        msgs = ((InternalEObject)encoding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoreDslPackage.INSTRUCTION__ENCODING, null, msgs);
      if (newEncoding != null)
        msgs = ((InternalEObject)newEncoding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CoreDslPackage.INSTRUCTION__ENCODING, null, msgs);
      msgs = basicSetEncoding(newEncoding, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoreDslPackage.INSTRUCTION__ENCODING, newEncoding, newEncoding));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDisass()
  {
    return disass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDisass(String newDisass)
  {
    String oldDisass = disass;
    disass = newDisass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoreDslPackage.INSTRUCTION__DISASS, oldDisass, disass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Statement getBehavior()
  {
    return behavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBehavior(Statement newBehavior, NotificationChain msgs)
  {
    Statement oldBehavior = behavior;
    behavior = newBehavior;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoreDslPackage.INSTRUCTION__BEHAVIOR, oldBehavior, newBehavior);
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
  public void setBehavior(Statement newBehavior)
  {
    if (newBehavior != behavior)
    {
      NotificationChain msgs = null;
      if (behavior != null)
        msgs = ((InternalEObject)behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoreDslPackage.INSTRUCTION__BEHAVIOR, null, msgs);
      if (newBehavior != null)
        msgs = ((InternalEObject)newBehavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CoreDslPackage.INSTRUCTION__BEHAVIOR, null, msgs);
      msgs = basicSetBehavior(newBehavior, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoreDslPackage.INSTRUCTION__BEHAVIOR, newBehavior, newBehavior));
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
      case CoreDslPackage.INSTRUCTION__ENCODING:
        return basicSetEncoding(null, msgs);
      case CoreDslPackage.INSTRUCTION__BEHAVIOR:
        return basicSetBehavior(null, msgs);
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
      case CoreDslPackage.INSTRUCTION__NAME:
        return getName();
      case CoreDslPackage.INSTRUCTION__ATTRIBUTES:
        return getAttributes();
      case CoreDslPackage.INSTRUCTION__ENCODING:
        return getEncoding();
      case CoreDslPackage.INSTRUCTION__DISASS:
        return getDisass();
      case CoreDslPackage.INSTRUCTION__BEHAVIOR:
        return getBehavior();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CoreDslPackage.INSTRUCTION__NAME:
        setName((String)newValue);
        return;
      case CoreDslPackage.INSTRUCTION__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends InstrAttribute>)newValue);
        return;
      case CoreDslPackage.INSTRUCTION__ENCODING:
        setEncoding((Encoding)newValue);
        return;
      case CoreDslPackage.INSTRUCTION__DISASS:
        setDisass((String)newValue);
        return;
      case CoreDslPackage.INSTRUCTION__BEHAVIOR:
        setBehavior((Statement)newValue);
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
      case CoreDslPackage.INSTRUCTION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CoreDslPackage.INSTRUCTION__ATTRIBUTES:
        getAttributes().clear();
        return;
      case CoreDslPackage.INSTRUCTION__ENCODING:
        setEncoding((Encoding)null);
        return;
      case CoreDslPackage.INSTRUCTION__DISASS:
        setDisass(DISASS_EDEFAULT);
        return;
      case CoreDslPackage.INSTRUCTION__BEHAVIOR:
        setBehavior((Statement)null);
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
      case CoreDslPackage.INSTRUCTION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CoreDslPackage.INSTRUCTION__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case CoreDslPackage.INSTRUCTION__ENCODING:
        return encoding != null;
      case CoreDslPackage.INSTRUCTION__DISASS:
        return DISASS_EDEFAULT == null ? disass != null : !DISASS_EDEFAULT.equals(disass);
      case CoreDslPackage.INSTRUCTION__BEHAVIOR:
        return behavior != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", attributes: ");
    result.append(attributes);
    result.append(", disass: ");
    result.append(disass);
    result.append(')');
    return result.toString();
  }

} //InstructionImpl
