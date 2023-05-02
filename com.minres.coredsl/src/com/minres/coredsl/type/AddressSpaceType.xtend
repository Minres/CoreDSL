package com.minres.coredsl.type

import java.math.BigInteger

class AddressSpaceType extends CoreDslType {
	
	public final CoreDslType elementType;
	public final BigInteger count;
	public final boolean isUnknownSize;
	
	new(CoreDslType elementType, BigInteger count) {
		super(elementType.bitSize);
		this.elementType = elementType;
		this.count = count;
		this.isUnknownSize = false;
	}
	
	private new(CoreDslType elementType) {
		super(-1);
		this.elementType = elementType;
		this.count = BigInteger.ZERO;
		this.isUnknownSize = true;
	}
	
	override isAddressSpaceType() { return true; }
	override isIncomplete() { return isUnknownSize || elementType.isIncomplete; }
	
	override toString() { return isUnknownSize ? '''«elementType»[address space ?]''' : '''«elementType»[address space «count»]'''; }
	
	def static ofUnknownSize(CoreDslType elementType) {
		return new AddressSpaceType(elementType);
	}
}
