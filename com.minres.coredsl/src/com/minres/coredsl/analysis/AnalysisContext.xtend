package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.NamedEntity
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.UserTypeDeclaration
import com.minres.coredsl.type.CoreDslType
import com.minres.coredsl.type.FunctionType
import com.minres.coredsl.util.CompilerAssertion
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.ValidationMessageAcceptor
import com.minres.coredsl.validation.IssueCodes

class AnalysisContext extends ProxyMessageAcceptor {
	
	public val ISA root;

	new(ISA root, ValidationMessageAcceptor acceptor) {
		super(acceptor, root, root, CoreDslPackage.Literals.ISA__NAME, -1);
		this.root = root;
	}
	
	// /////////////////////////////////////////////////////////////////////////
	// ////////////////////////// Public accessors /////////////////////////////
	// /////////////////////////////////////////////////////////////////////////
	
	def isStorageClassSet(NamedEntity entity) { _isStorageSet(entity) }
	def getStorageClass(NamedEntity entity) { _getStorage(entity) }
	def setStorageClass(NamedEntity entity, StorageClass storage) { _setStorage(entity, storage) }
		
	def isDeclaredTypeSet(NamedEntity entity) { _isTypeSet(entity) }
	def getDeclaredType(NamedEntity entity) { _getType(entity) }
	def setDeclaredType(NamedEntity entity, CoreDslType type) {
		 acceptInfo("Type: " + (type.isValid ? type.toString() : "invalid"), entity, CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.DebugInfo);
		 _setType(entity, type)
	}
		
	def isSpecifiedTypeSet(TypeSpecifier typeSpecifier) { _isTypeSet(typeSpecifier) }
	def getSpecifiedType(TypeSpecifier typeSpecifier) { _getType(typeSpecifier) }
	def setSpecifiedType(TypeSpecifier typeSpecifier, CoreDslType type) { _setType(typeSpecifier, type) }
		
	def isExpressionTypeSet(Expression expression) { _isTypeSet(expression) }
	def getExpressionType(Expression expression) { _getType(expression) }
	def setExpressionType(Expression expression, CoreDslType type) { _setType(expression, type) }
		
	def isUserTypeInstanceSet(UserTypeDeclaration declaration) { _isTypeSet(declaration) }
	def getUserTypeInstance(UserTypeDeclaration declaration) { _getType(declaration) }
	def setUserTypeInstance(UserTypeDeclaration declaration, CoreDslType type) { _setType(declaration, type) }
		
	def isFunctionSignatureSet(FunctionDefinition function) { _isTypeSet(function) }
	def getFunctionSignature(FunctionDefinition function) { _getType(function) as FunctionType }
	def setFunctionSignature(FunctionDefinition function, FunctionType type) { _setType(function, type) as FunctionType }
		
	def isConstantValueSet(NamedEntity entity) { _isValueSet(entity) }
	def getConstantValue(NamedEntity entity) { _getValue(entity) }
	def setConstantValue(NamedEntity entity, ConstantValue value) {
		acceptInfo("Value: " + (value.isValid ? value.value.toString() : "invalid"), entity, CoreDslPackage.Literals.NAMED_ENTITY__NAME, -1, IssueCodes.DebugInfo);
		_setValue(entity, value)
	}
		
	def isExpressionValueSet(Expression expression) { _isValueSet(expression) }
	def getExpressionValue(Expression expression) { _getValue(expression) }
	def setExpressionValue(Expression expression, ConstantValue value) { _setValue(expression, value) }
		
	def isFieldOffsetSet(Declarator field) { _isValueSet(field) }
	def getFieldOffset(Declarator field) { _getValue(field) }
	def setFieldOffset(Declarator field, ConstantValue value) { _setValue(field, value) }
	
	// /////////////////////////////////////////////////////////////////////////
	// /////////////////////// Private implementation //////////////////////////
	// /////////////////////////////////////////////////////////////////////////
	
	val Map<EObject, StorageClass> storageMap = new HashMap();
	val Map<EObject, CoreDslType> typeMap = new HashMap();
	val Map<EObject, ConstantValue> valueMap = new HashMap();

	def private _isStorageSet(EObject node) { 
		return storageMap.containsKey(node);
	}
	def private _getStorage(EObject node) {
		CompilerAssertion.assertThat(_isStorageSet(node), "Storage class has not been set for node " + node); 
		return storageMap.get(node);
	}
	def private _setStorage(EObject node, StorageClass storage) {
		CompilerAssertion.assertThat(!_isStorageSet(node), "Storage class has already been set for node " + node);
		storageMap.put(node, storage);
		return storage;
	}

	def private _isTypeSet(EObject node) {
		return typeMap.containsKey(node);
	}
	def private _getType(EObject node) {
		CompilerAssertion.assertThat(_isTypeSet(node), "Type has not been set for node " + node); 
		return typeMap.get(node); 
	}
	def private _setType(EObject node, CoreDslType type) {
		CompilerAssertion.assertThat(!_isTypeSet(node), "Type has already been set for node " + node);
		typeMap.put(node, type);
		return type;
	}

	def private _isValueSet(EObject node) {
		return valueMap.containsKey(node);
	}
	def private _getValue(EObject node) {
		CompilerAssertion.assertThat(_isValueSet(node), "Value has not been set for node " + node); 
		return valueMap.get(node);
	}
	def private _setValue(EObject node, ConstantValue value) {
		CompilerAssertion.assertThat(!_isValueSet(node), "Value has already been set for node " + node);
		valueMap.put(node, value);
		return value;
	}
}
