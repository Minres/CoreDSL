package com.minres.coredsl.type

import org.eclipse.xtend.lib.annotations.Data

@Data
class ErrorType extends CoreDslType {
	public static ErrorType indeterminate = new ErrorType(ErrorCode.indeterminate);
	public static ErrorType invalid = new ErrorType(ErrorCode.invalid);

	ErrorCode errorCode;

	private new(ErrorCode errorCode) {
		super(-1);
		this.errorCode = errorCode;
	}

	enum ErrorCode {
		indeterminate,
		invalid
	}

	override toString() { return '''<«errorCode.name» type>'''; }
}
