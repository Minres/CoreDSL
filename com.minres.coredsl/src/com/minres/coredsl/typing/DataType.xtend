package com.minres.coredsl.typing

import org.eclipse.xtend.lib.annotations.Data

@Data class DataType {
    public static final Integer COMPOSITE=0
    public static final Integer INTEGRAL_SIGNED=1
    public static final Integer INTEGRAL_UNSIGNED=2
    public static final Integer FLOAT=3
    
    //! the data type of the expression, a value null denotes a composite type
    Integer type
    //! the bit size of the expression, a value of 0 denotes a pointer 
    Integer size
    
}