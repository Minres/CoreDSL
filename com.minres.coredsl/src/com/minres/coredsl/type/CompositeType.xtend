package com.minres.coredsl.type

import com.minres.coredsl.coreDsl.CompositeTypeDeclaration
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.StructTypeDeclaration
import com.minres.coredsl.coreDsl.UnionTypeDeclaration
import java.util.ArrayList
import java.util.List

class CompositeType extends CoreDslType {

	public val CompositeTypeDeclaration declaration;
	public val List<Declarator> fields;

	new(CompositeTypeDeclaration declaration, ArrayList<Declarator> fields, int bitSize) {
		super(bitSize);
		this.declaration = declaration;
		this.fields = fields;
	}

	override isStructType() { return declaration instanceof StructTypeDeclaration; }
	override isUnionType() { return declaration instanceof UnionTypeDeclaration; }
}
