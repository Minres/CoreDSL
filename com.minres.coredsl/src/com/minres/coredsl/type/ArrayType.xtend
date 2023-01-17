package com.minres.coredsl.type

class ArrayType extends AggregateType {
	
	public final CoreDslType elementType;
	public final int count;
	
	new(CoreDslType elementType, int count) {
		super(elementType.bitSize * count);
		this.elementType = elementType;
		this.count = count;
	}
	
	override isArrayType() { return true; }
	
	override toString() { return '''«elementType»[«count»]'''; }
}
