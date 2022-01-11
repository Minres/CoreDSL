package com.minres.coredsl.typing

import org.eclipse.xtend.lib.annotations.Data

@Data class DataType {
	enum Type {
		VOID, COMPOSITE, INTEGRAL_SIGNED, INTEGRAL_UNSIGNED, FLOAT
	}
    //! the data type of the expression, a value null denotes a composite type
    Type type
    //! the bit size of the expression, a value of 0 denotes a pointer 
    Integer size
}