package com.minres.coredsl.util

import org.eclipse.xtext.xbase.lib.Functions.Function1

abstract class DataExtensions {
	private new() {
	}

	static def <T> castOrNull(Object obj, Class<T> type) {
		if(type.isInstance(obj)) return obj as T;
		return null;
	}

	static def <T> boolean isOneOf(T value, T... options) {
		return options.contains(value);
	}

	static def <T> boolean any(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		return iterable.findFirst(predicate) !== null;
	}
}
