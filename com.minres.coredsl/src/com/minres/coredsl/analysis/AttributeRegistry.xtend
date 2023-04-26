package com.minres.coredsl.analysis

import java.util.Arrays
import java.util.Collections
import java.util.HashMap
import java.util.List
import java.util.Map
import com.minres.coredsl.coreDsl.Attribute

class AttributeRegistry {
	val Map<String, AttributeInfo> registeredAttributes = new HashMap<String, AttributeInfo>();

	def void register(String name, int paramCount, (AnalysisContext, Attribute, AttributeUsage)=>void validator,
		AttributeUsage... allowedUsage) {
		register(new AttributeInfo(name, paramCount, validator, allowedUsage));
	}

	def void register(String name, int paramCount, AttributeUsage... allowedUsage) {
		register(new AttributeInfo(name, paramCount, null, allowedUsage));
	}

	def void register(AttributeInfo attrib) {
		registeredAttributes.put(attrib.name, attrib);
	}

	def byName(String name) {
		return registeredAttributes.getOrDefault(name, null);
	}

	def getAll() {
		return registeredAttributes.values();
	}

	enum AttributeUsage {
		instruction,
		function,
		declarator,
		alwaysBlock
	}

	static final class AttributeInfo {
		public val String name;
		public val int paramCount; // TODO allow multiple signatures?
		public val (AnalysisContext, Attribute, AttributeUsage)=>void validator;
		public val List<AttributeUsage> allowedUsage;

		new(String name, int paramCount, (AnalysisContext, Attribute, AttributeUsage)=>void validator,
			AttributeUsage... allowedUsage) {
			this.name = name;
			this.paramCount = paramCount;
			this.validator = validator;
			this.allowedUsage = Collections.unmodifiableList(Arrays.asList(allowedUsage));
		}
	}
}
