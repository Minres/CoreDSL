package com.minres.coredsl.util

import com.minres.coredsl.coreDsl.DataTypes
import com.minres.coredsl.coreDsl.BitField
import org.eclipse.xtend.lib.annotations.Data

@Data class DataType {
    DataTypes type
    Integer size
    
    def static get(BitField bf){
        new DataType(DataTypes.UNSIGNED, bf.bitRange.left.value.intValue)
    }
}