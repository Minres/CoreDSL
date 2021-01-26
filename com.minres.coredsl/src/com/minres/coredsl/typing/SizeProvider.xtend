package com.minres.coredsl.typing

import com.minres.coredsl.coreDsl.CompositeType
import com.minres.coredsl.coreDsl.EnumType
import javax.lang.model.type.PrimitiveType

class SizeProvider {

    def static dispatch Integer sizeOf(PrimitiveType e) {
        return null
    }
    
    def static dispatch Integer sizeOf(CompositeType e) {
        return null
    }

    def static dispatch Integer sizeOf(EnumType e) {
        return null
    }

}
