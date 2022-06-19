package com.minres.coredsl.validation;

import static com.minres.coredsl.validation.KnownAttributes.AttributeUsage.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		register("clk_budget", 1, function);
		register("type", 1, instruction);
	}
	
	public static void register(String name, int paramCount, AttributeUsage... allowedUsage) {
		register(new AttributeInfo(name, paramCount, allowedUsage));
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
		
		public AttributeInfo(String name, int paramCount, AttributeUsage... allowedUsage) {
			this.name = name;
			this.paramCount = paramCount;
			this.allowedUsage = Collections.unmodifiableList(Arrays.asList(allowedUsage));
		}
	}
}
