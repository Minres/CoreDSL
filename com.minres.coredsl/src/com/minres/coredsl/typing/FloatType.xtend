package com.minres.coredsl.typing

import org.eclipse.xtend.lib.annotations.Data;

@Data class FloatType extends DataType {
	public int bitSize;
	
	override toString() {
		return bitSize == 32 ? "float" : bitSize == 64 ? "double" : "float<" + bitSize + ">"
	}
}
