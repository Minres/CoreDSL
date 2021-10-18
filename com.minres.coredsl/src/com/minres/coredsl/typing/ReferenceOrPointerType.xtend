package com.minres.coredsl.typing

import org.eclipse.xtend.lib.annotations.Data;

@Data class ReferenceOrPointerType extends DataType {
	public DataType baseType;
}