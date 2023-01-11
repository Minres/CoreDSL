package com.minres.coredsl.analysis

import com.minres.coredsl.coreDsl.CoreDslPackage
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.NamedEntity
import com.minres.coredsl.coreDsl.UserTypeDeclaration
import com.minres.coredsl.coreDsl.UserTypeSpecifier
import com.minres.coredsl.type.CoreDslType
import com.minres.coredsl.type.ErrorType
import com.minres.coredsl.type.FunctionType
import com.minres.coredsl.util.CompilerAssertion
import java.util.ArrayList
import java.util.HashMap
import java.util.LinkedHashMap
import java.util.LinkedList
import java.util.List
import java.util.Map
import java.util.Set
import java.util.Stack
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension com.minres.coredsl.util.ModelExtensions.*

class ElaborationContext extends ProxyMessageAcceptor {
	static class SharedResultsCache {
		val Map<ISA, Set<String>> exposedNames = new LinkedHashMap();
		val Map<Declarator, StorageClass> storageClasses = new LinkedHashMap();
		
		def areExposedNamesSet(ISA isa) {
			return exposedNames.containsKey(isa);
		}
		
		def getExposedNames(ISA isa) {
			val result = exposedNames.get(isa);
			CompilerAssertion.assertThat(result !== null, "Exposed names for ISA " + isa.name + " have not been set");
			return result;
		}
		
		def setExposedNames(ISA isa, Set<String> names) {
			CompilerAssertion.assertThat(!areExposedNamesSet(isa), "Exposed names for ISA " + isa.name + " have already been set");
			exposedNames.put(isa, names);
		}
		
		def isStorageClassSet(Declarator declarator) {
			return storageClasses.containsKey(declarator);
		}

		def getStorageClass(Declarator declarator) {
			val result = storageClasses.get(declarator);
			CompilerAssertion.assertThat(result !== null, "Storage class has not been set");
			return result !== null ? result : StorageClass.unknown;
		}

		def setStorageClass(Declarator declarator, StorageClass storageClass) {
			CompilerAssertion.assertThat(!isStorageClassSet(declarator), "Storage class has already been set");
			storageClasses.put(declarator, storageClass);
		}

		def boolean isIsaParameter(Declarator declarator) {
			return getStorageClass(declarator) === StorageClass.param;
		}
	}

	static class ElaborationDeclarationInfo {
		public val String name;
		public val List<Declarator> declarators = new ArrayList();
		public val List<Expression> assignments = new ArrayList();

		new(String name) {
			this.name = name;
		}
	}

	public val ISA root;
	public val boolean isPartialElaboration;
	public val SharedResultsCache sharedCache;

	public val List<ISA> elaborationOrder = new ArrayList();
	public val Stack<InstructionSet> currentInheritanceStack = new Stack();

	public val Map<String, ElaborationDeclarationInfo> declInfo = new HashMap();
	public val List<Expression> calculationQueue = new LinkedList();
	public val Map<Expression, ConstantValue> calculatedValues = new HashMap();
	public var gatherPhaseDone = false;

	public val Map<EObject, NodeInfo> nodeInfo = new HashMap();

	new(ISA root, ValidationMessageAcceptor acceptor, SharedResultsCache sharedCache) {
		super(acceptor, root, root, CoreDslPackage.Literals.ISA__NAME, -1);
		this.root = root;
		this.sharedCache = sharedCache ?: new ElaborationContext.SharedResultsCache();
		isPartialElaboration = root instanceof InstructionSet;
	}

	override getErrorDescription(EObject object) {
		val isa = object.ancestorOfTypeOrSelf(ISA);
		if(isa === null) return "Error";
		return "Error in instruction set " + isa.name;
	}

	def isInElaborationScope(EObject obj) {
		return obj.ancestorOfType(ISA) == root;
	}

	def getCalculatedValue(Declarator declarator) {
		return getCalculatedValue(declarator.name);
	}

	def getCalculatedValue(String name) {
		CompilerAssertion.assertThat(gatherPhaseDone,
			"Calculated results may not be accessed before the gathering phase finishes");
		val info = declInfo.get(name);
		val expression = info?.assignments.last();
		val result = calculatedValues.get(expression);
		return result !== null ? result : ConstantValue.indeterminate;
	}

	def getCalculatedType(String name) {
		CompilerAssertion.assertThat(gatherPhaseDone,
			"Calculated results may not be accessed before the gathering phase finishes");
		val info = declInfo.get(name);
		val declarator = info?.declarators.last();

		// TODO this is an ugly hack, remove it
		if(declarator.type instanceof UserTypeSpecifier) return ErrorType.invalid;

		return CoreDslTypeProvider.getSpecifiedType(this, declarator.type);
	}

	// Everything below here is used *after* elaboration and should be moved out of here
	def setStorageClass(Declarator declarator, StorageClass storage) {
		getOrCreateNodeInfo(declarator).storage = storage;
		return storage;
	}

	def getStorageClass(Declarator declarator) {
		return getOrCreateNodeInfo(declarator).storage;
	}

	def setDeclaredType(NamedEntity entity, CoreDslType type) {
		getOrCreateNodeInfo(entity).type = type;
		return type;
	}

	def getDeclaredType(NamedEntity entity) {
		return getOrCreateNodeInfo(entity).type;
	}

	def setFunctionSignature(FunctionDefinition function, FunctionType type) {
		getOrCreateNodeInfo(function).type = type;
		return type;
	}

	def getFunctionSignature(FunctionDefinition function) {
		return getOrCreateNodeInfo(function).type as FunctionType;
	}

	def setUserTypeInstance(UserTypeDeclaration declaration, CoreDslType type) {
		getOrCreateNodeInfo(declaration).type = type;
		return type;
	}

	def getUserTypeInstance(UserTypeDeclaration declaration) {
		return getOrCreateNodeInfo(declaration).type;
	}

	def setExpressionType(Expression expression, CoreDslType type) {
		getOrCreateNodeInfo(expression).type = type;
		return type;
	}

	def getExpressionType(Expression expression) {
		return getOrCreateNodeInfo(expression).type;
	}

	def setExpressionValue(Expression expression, ConstantValue value) {
		getOrCreateNodeInfo(expression).value = value;
		return value;
	}

	def getExpressionValue(Expression expression) {
		return getOrCreateNodeInfo(expression).value;
	}

	def setFieldOffset(Declarator field, int offset) {
		getOrCreateNodeInfo(field).offset = offset;
		return offset;
	}

	def getFieldOffset(Declarator field) {
		return getOrCreateNodeInfo(field).offset;
	}

	// TODO change the first parameter to Declarator once enum members are declarators
	def setConstantValue(EObject constant, ConstantValue value) {
		getOrCreateNodeInfo(constant).value = value;
		return value;
	}

	def getConstantValue(Declarator constant) {
		return getNodeInfo(constant).value;
	}

	def NodeInfo getNodeInfo(EObject node) {
		val info = tryGetNodeInfo(node);
		if(info === null) {
			CompilerAssertion.fail("Node info has not been set for " + node);
		}
		return info;
	}

	def NodeInfo tryGetNodeInfo(EObject node) {
		return nodeInfo.get(node);
	}

	def NodeInfo getOrCreateNodeInfo(EObject node) {
		var info = tryGetNodeInfo(node);
		if(info === null) {
			info = new NodeInfo(node);
			nodeInfo.put(node, info);
		}
		return info;
	}

	static class NodeInfo {
		public val EObject node;
		var StorageClass _storage;
		var CoreDslType _type;
		var ConstantValue _value;
		var Integer _offset;

		new(EObject node) {
			this.node = node;
		}

		def StorageClass getStorage() {
			CompilerAssertion.assertThat(isStorageSet, "Storage class for this node has not been set: " + node);
			return _storage;
		}

		def void setStorage(StorageClass storage) {
			CompilerAssertion.assertThat(!isStorageSet, "Storage for this node has already been set: " + node);
			_storage = storage;
		}

		def boolean isStorageSet() {
			return _storage !== null;
		}

		def CoreDslType getType() {
			CompilerAssertion.assertThat(isTypeSet, "Type for this node has not been set: " + node);
			return _type;
		}

		def void setType(CoreDslType type) {
			CompilerAssertion.assertThat(!isTypeSet, "Type for this node has already been set: " + node);
			_type = type;
		}

		def boolean isTypeSet() {
			return _type !== null;
		}

		def ConstantValue getValue() {
			CompilerAssertion.assertThat(isValueSet, "Value for this node has not been set: " + node);
			return _value;
		}

		def void setValue(ConstantValue value) {
			CompilerAssertion.assertThat(!isValueSet, "Value for this node has already been set: " + node);
			_value = value;
		}

		def boolean isValueSet() {
			return _value !== null;
		}

		def Integer getOffset() {
			CompilerAssertion.assertThat(isOffsetSet, "Offset for this node has not been set: " + node);
			return _offset;
		}

		def void setOffset(Integer offset) {
			CompilerAssertion.assertThat(!isOffsetSet, "Offset for this node has already been set: " + node);
			_offset = offset;
		}

		def boolean isOffsetSet() {
			return _offset !== null;
		}
	}
}
