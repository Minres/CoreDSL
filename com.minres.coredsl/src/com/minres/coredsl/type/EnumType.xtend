package com.minres.coredsl.type

import com.minres.coredsl.coreDsl.EnumTypeDeclaration

class EnumType extends CoreDslType {

	public val EnumTypeDeclaration declaration;
	public val IntegerType baseType;

	new(EnumTypeDeclaration declaration, IntegerType baseType) {
		super(baseType.bitSize);
		this.declaration = declaration;
		this.baseType = baseType;
	}
	
	override isEnumType() { return true; }
}
