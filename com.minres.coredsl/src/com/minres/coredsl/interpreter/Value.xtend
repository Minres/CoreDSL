package com.minres.coredsl.interpreter

import com.minres.coredsl.typing.DataType
import org.eclipse.xtend.lib.annotations.Data 

@Data class Value {
    DataType type
    Number value
}