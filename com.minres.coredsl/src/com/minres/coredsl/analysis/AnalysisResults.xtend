package com.minres.coredsl.analysis

import com.minres.coredsl.analysis.AnalysisContext
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.ISA
import java.util.LinkedHashMap
import java.util.Map

class AnalysisResults {
	public val DescriptionContent root;

	public val Map<ISA, AnalysisContext> results = new LinkedHashMap();

	new(DescriptionContent root) {
		this.root = root;
	}
}
