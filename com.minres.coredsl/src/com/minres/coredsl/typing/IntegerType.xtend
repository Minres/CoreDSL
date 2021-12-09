package com.minres.coredsl.typing

import org.eclipse.xtend.lib.annotations.Data;

@Data class IntegerType extends DataType {
	public val int bitSize;
	public val boolean signed;
	
	override toString() {
		return signed ? "signed<" + bitSize + ">" : "unsigned<" + bitSize + ">"
	}
}
