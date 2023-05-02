package com.minres.coredsl.util

import java.lang.RuntimeException

class CompilerAssertion extends RuntimeException {
	new(String message) {
		super(message);
	}

	def static void fail(String message) {
		throw new CompilerAssertion(message);
	}

	def static void assertThat(boolean condition, String message) {
		if(!condition) throw new CompilerAssertion(message);
	}
}
