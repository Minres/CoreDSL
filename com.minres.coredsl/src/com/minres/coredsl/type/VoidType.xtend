package com.minres.coredsl.type

import org.eclipse.xtend.lib.annotations.Data

@Data
class VoidType extends CoreDslType {
	public static val VoidType instance = new VoidType();
	
	private new() { super(0); }
	
	override isVoid() { return true; }
	
	override toString() { return 'void'; }
}
