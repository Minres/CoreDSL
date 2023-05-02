package com.minres.coredsl.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.validation.ValidationMessageAcceptor

class IssueReportTarget {
	public val EObject object;
	public val EStructuralFeature feature;
	public val int index;
	
	new(EObject object, EStructuralFeature feature, int index) {
		this.object = object;
		this.feature = feature;
		this.index = index;
	}
	
	new(EObject object, EStructuralFeature feature) {
		this.object = object;
		this.feature = feature;
		this.index = ValidationMessageAcceptor.INSIGNIFICANT_INDEX;
	}
}