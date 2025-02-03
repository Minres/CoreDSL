package com.minres.coredsl.util

import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DeclarationStatement
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.EnumTypeDeclaration
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.NamedEntity
import com.minres.coredsl.coreDsl.StructTypeDeclaration
import com.minres.coredsl.coreDsl.TypeQualifier
import com.minres.coredsl.coreDsl.UnionTypeDeclaration
import com.minres.coredsl.coreDsl.UserTypeDeclaration
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

import static extension com.minres.coredsl.util.DataExtensions.*
import com.minres.coredsl.coreDsl.ExpressionInitializer
import com.minres.coredsl.coreDsl.IndexAccessExpression
import com.minres.coredsl.coreDsl.EntityReference

abstract class ModelExtensions {
	private new() {
	}

	// EObject extensions
	static def getSyntaxNode(EObject obj) {
		return NodeModelUtils.getNode(obj);
	}

	static def getShortDescription(EObject obj) {
		val node = NodeModelUtils.getNode(obj);
		val location = NodeModelUtils.getLineAndColumn(node, node.offset);
		var className = obj.class.simpleName;
		
		if(className.endsWith("Impl")) {
			className = className.substring(0, className.length - 4);
		}

		if(obj instanceof NamedEntity) {
			return '''«className» «obj.name» in line «location.line»''';
		} else {
			return '''«className» in line «location.line»''';
		}
	}

	static def <T extends EObject> T ancestorOfType(EObject obj, Class<T> type) {
		return ancestorOfTypeOrSelf(obj.eContainer, type);
	}

	static def <T extends EObject> T ancestorOfTypeOrSelf(EObject obj, Class<T> type) {
		var cur = obj;
		while(cur !== null) {
			if(type.isInstance(cur)) return cur as T;
			cur = cur.eContainer;
		}
		return null;
	}

	static def <T extends EObject> List<T> descendantsOfType(EObject obj, Class<T> type) {
		return obj.eAllContents.filter(type).toList;
	}

	static def boolean isDescendantOf(EObject obj, EObject potentialAncestor) {
		return isDescendantOfOrSelf(obj.eContainer, potentialAncestor);
	}

	static def boolean isDescendantOfOrSelf(EObject obj, EObject potentialAncestor) {
		var cur = obj;
		while(cur !== null) {
			if(cur === potentialAncestor) return true;
			cur = cur.eContainer;
		}
		return false;
	}

	// Declaration extensions
	static def isVolatile(Declaration decl) {
		return decl !== null && decl.qualifiers.contains(TypeQualifier.VOLATILE);
	}

	static def isConst(Declaration decl) {
		return decl !== null && decl.qualifiers.contains(TypeQualifier.CONST);
	}

	static def isIsaStateElement(Declaration decl) {
		return decl !== null && decl.eContainer instanceof DeclarationStatement &&
			decl.eContainer.eContainer instanceof ISA;
	}

	static def isIsaParameter(Declaration decl) {
		return decl.isIsaStateElement && decl.storage.empty && decl.declarators.findFirst[it.isAlias] === null;
	}

	// Declarator extensions
	static def isUserTypeMember(Declarator decl) {
		return decl.ancestorOfType(UserTypeDeclaration) !== null;
	}

	static def isStructMember(Declarator decl) {
		return decl.ancestorOfType(StructTypeDeclaration) !== null;
	}

	static def isUnionMember(Declarator decl) {
		return decl.ancestorOfType(UnionTypeDeclaration) !== null;
	}

	static def isEnumMember(Declarator decl) {
		return decl.eContainer instanceof EnumTypeDeclaration;
	}

	static def getDeclaration(Declarator decl) {
		return decl.eContainer.castOrNull(Declaration);
	}

	static def getType(Declarator decl) {
		return decl.declaration?.type;
	}

	static def isVolatile(Declarator decl) {
		return decl.declaration.isVolatile;
	}

	static def isConst(Declarator decl) {
		return decl.declaration.isConst;
	}

	static def isIsaStateElement(Declarator decl) {
		return decl.declaration.isIsaStateElement;
	}

	static def isIsaParameter(Declarator decl) {
		return decl.declaration.isIsaParameter;
	}

	// ISA extensions
	static def getElaborationOrder(ISA isa) {
		var order = new ArrayList();
		getElaborationOrder(isa, order, new HashSet());
		return order;
	}

	private static def dispatch void getElaborationOrder(InstructionSet iset, List<ISA> order, HashSet<ISA> seen) {
		if(!seen.add(iset)) return;
		if(iset.superType !== null)
			getElaborationOrder(iset.superType, order, seen)
		else
			for (isa : iset.providedInstructionSets) {
				getElaborationOrder(isa, order, seen);
			}
		order.add(iset);
	}

	private static def dispatch void getElaborationOrder(CoreDef core, List<ISA> order, HashSet<ISA> seen) {
		for (iset : core.providedInstructionSets) {
			getElaborationOrder(iset, order, seen);
		}
		order.add(core);
	}
	
	static def getRealDeclarator(Declarator declarator) {
		if(declarator.isAlias) {
			val initializer = declarator.initializer
			if(initializer instanceof ExpressionInitializer) {
				val value = initializer.value
				if(value instanceof IndexAccessExpression) {
					val target = value.target
					if(target instanceof EntityReference)
						if(target.target instanceof Declarator)
							return target.target as Declarator
				}
			}
		}
		declarator
	}
}
