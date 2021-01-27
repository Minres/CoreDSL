package com.minres.coredsl.typing

import com.minres.coredsl.coreDsl.DataTypes
import com.minres.coredsl.coreDsl.BitField
import org.eclipse.xtend.lib.annotations.Data
import com.minres.coredsl.coreDsl.TypeSpecifier

@Data class DataType {
    //! the data type of the expression, a value null denotes a composite type
    DataTypes type
    //! the signedness of the expression, a value null denotes a composite type    
    DataTypes unSinged
    //! the bit size of the expression, a value of 0 denotes a pointer 
    Integer size
    
}