package com.minres.coredsl.validation;

import static com.minres.coredsl.validation.KnownAttributes.AttributeUsage.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.minres.coredsl.coreDsl.Expression;

public final class KnownAttributes {
	private KnownAttributes() {}

	private static final Map<String, AttributeInfo> registeredAttributes = new HashMap<String, AttributeInfo>();
	
	static {
		register("enable", 1, instruction);
		register("hls", 0, instruction);
		register("no_cont", 0, instruction);
		register("cond", 0, instruction);
		register("flush", 0, instruction);
		register("do_not_synthesize", 0, function);
		register("is_pc", 0, declaration);
		register("is_main_reg", 0, declaration);
		register("is_main_mem", 0, declaration);
		register("is_interlock_for", 1, declaration);
	}
	
	public static void register(String name, int paramCount, AttributeUsage... allowedUsage) {
		register(name, paramCount, null, allowedUsage);
	}
	
	public static void register(String name, int paramCount, AttributeValidator validator, AttributeUsage... allowedUsage) {
		register(new AttributeInfo(name, paramCount, validator, allowedUsage));
	}
	
	public static void register(AttributeInfo attrib) {
		registeredAttributes.put(attrib.name, attrib);
	}
	
	public static AttributeInfo byName(String name) {		
		return registeredAttributes.getOrDefault(name, null);
	}
	
	public static Collection<AttributeInfo> getAll() {
		return registeredAttributes.values();
	}
	
	public enum AttributeUsage {
		instruction, function, declaration 
	}
	
	public static final class AttributeInfo {
		public final String name;
		public final int paramCount; // TODO allow multiple signatures?
		public final List<AttributeUsage> allowedUsage;
		public final AttributeValidator validator;
		
		public AttributeInfo(String name, int paramCount, AttributeValidator validator, AttributeUsage... allowedUsage) {
			this.name = name;
			this.paramCount = paramCount;
			this.validator = validator;
			this.allowedUsage = Collections.unmodifiableList(Arrays.asList(allowedUsage));
		}
		
		public boolean validate(EObject node, EList<Expression> params) {
			return validator == null || validator.validate(node, params);
		}
	}
	
	public interface AttributeValidator {
		boolean validate(EObject node, EList<Expression> params);
	}
}
