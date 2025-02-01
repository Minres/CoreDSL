package com.minres.coredsl.type

import com.minres.coredsl.coreDsl.CompositeTypeDeclaration
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.StructTypeDeclaration
import com.minres.coredsl.coreDsl.UnionTypeDeclaration
import java.util.List

class CompositeType extends CoreDslType {

	public val CompositeTypeDeclaration declaration;
	public val List<Declarator> fields;

	new(CompositeTypeDeclaration declaration, List<Declarator> fields, int bitSize) {
		super(bitSize);
		this.declaration = declaration;
		this.fields = fields;
	}

	override isCompositeType() { return true; }
	override isStructType() { return declaration instanceof StructTypeDeclaration; }
	override isUnionType() { return declaration instanceof UnionTypeDeclaration; }
	
	override equals(Object obj) {
		if(obj instanceof CompositeType) {
			return obj.declaration === declaration;
		}
		return false;
	}
	
	override toString() { return isStructType ? '''struct «declaration.name»''' : '''union «declaration.name»'''; }
}
