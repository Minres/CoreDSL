package com.minres.coredsl.util

import java.lang.RuntimeException

class CompilerAssertionError extends RuntimeException {
	new(String message) { super(message); }
}
