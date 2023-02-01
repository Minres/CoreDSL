package com.minres.coredsl.type

import org.eclipse.xtend.lib.annotations.Data
import java.util.List

@Data
class FunctionType extends CoreDslType {

	val CoreDslType returnType;
	val List<CoreDslType> paramTypes;

	new(CoreDslType returnType, List<CoreDslType> paramTypes) {
		super(0);
		this.returnType = returnType;
		this.paramTypes = paramTypes.immutableCopy();
	}

	override isFunctionType() { return true; }

	override toString() { return '''«returnType»(«paramTypes.map[it.toString()].join(',')»)'''; }
}
