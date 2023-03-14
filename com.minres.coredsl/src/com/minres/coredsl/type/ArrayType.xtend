package com.minres.coredsl.type

class ArrayType extends AggregateType {
	
	public final CoreDslType elementType;
	public final int count;
	public final boolean isUnknownSize;
	
	new(CoreDslType elementType, int count) {
		super(elementType.bitSize * count);
		this.elementType = elementType;
		this.count = count;
		this.isUnknownSize = false;
	}
	
	private new(CoreDslType elementType) {
		super(-1);
		this.elementType = elementType;
		this.count = 0;
		this.isUnknownSize = true;
	}
	
	override isArrayType() { return true; }
	
	override toString() { return isUnknownSize ? '''«elementType»[?]''' : '''«elementType»[«count»]'''; }
	
	def static ofUnknownSize(CoreDslType elementType) {
		return new ArrayType(elementType);
	}
}
