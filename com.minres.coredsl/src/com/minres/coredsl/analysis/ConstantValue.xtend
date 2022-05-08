package com.minres.coredsl.analysis

import java.math.BigInteger
import org.eclipse.xtend.lib.annotations.Data

@Data
final class ConstantValue {
	public static val ConstantValue indeterminate = new ConstantValue(StatusCode.indeterminate);
	public static val ConstantValue invalid = new ConstantValue(StatusCode.invalid);

	public val StatusCode status;
	public val BigInteger value;

	new(BigInteger value) {
		this.status = StatusCode.success;
		this.value = value;
	}

	private new(StatusCode error) {
		this.status = error;
		this.value = null;
	}

	def isValid() { return status === StatusCode.success; }
	def isError() { return status !== StatusCode.success; }
	def isIndeterminate() { return status === StatusCode.indeterminate; }
	def isInvalid() { return status === StatusCode.invalid; }

	enum StatusCode {
		success,
		indeterminate,
		invalid
	}
}
