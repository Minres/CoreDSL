package com.minres.coredsl.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.EList
import java.util.ArrayList

class SyntaxTreeWalker {

	static def Iterable<EObject> getChildren(EObject node) {
		return node.eClass.EStructuralFeatures
			.map[node.eGet(it)]
			.flatMap [switch (it) {
				EList<EObject>: return it
				EObject: return #[it]
				default: return #[]
			}
		];
	}
	
	// descendants

	private static def Iterable<EObject> getDescendants(EObject node, boolean preOrder, boolean postOrder) {
		val list = new ArrayList<EObject>;
		iterate(node, [list.add(it)], preOrder, postOrder);
		return list;
	}

	static def Iterable<EObject> getDescendantsPreOrder(EObject node) {
		return getDescendants(node, true, false);
	}

	static def Iterable<EObject> getDescendantsPostOrder(EObject node) {
		return getDescendants(node, false, true);
	}

	static def <T extends EObject> Iterable<T> getDescendantsPreOrder(EObject node, Class<T> filterType) {
		return node.descendantsPreOrder.filter(filterType);
	}

	static def <T extends EObject> Iterable<T> getDescendantsPostOrder(EObject node, Class<T> filterType) {
		return node.descendantsPostOrder.filter(filterType);
	}
	
	// enumeration

	private static def void iterate(EObject node, (EObject)=>void action, boolean preOrder, boolean postOrder) {
		if(preOrder) action.apply(node);
		for (child : node.children) {
			iterate(child, action, preOrder, postOrder);
		}
		if(postOrder) action.apply(node);
	}

	static def void iteratePreOrder(EObject node, (EObject)=>void action) {
		iterate(node, action, true, false);
	}

	static def void iteratePostOrder(EObject node, (EObject)=>void action) {
		iterate(node, action, true, false);
	}
}
