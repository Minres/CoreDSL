package com.minres.coredsl.util

import org.eclipse.emf.ecore.EObject
import com.minres.coredsl.coreDsl.DirectDeclarator
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.InstructionSet

class ModelUtil {

    static def <T extends EObject> T parentOfType(EObject obj, Class<T> clazz) {
        if (obj.eContainer === null)
            return null
        if (clazz.isInstance(obj.eContainer))
            return obj.eContainer as T
        return obj.eContainer.parentOfType(clazz)
    }
    
    static def DirectDeclarator effectiveDeclarator(ISA isa, String name){
        if(isa instanceof CoreDef) {
            val decl = isa.constants.findFirst[it.init.findFirst[it.declarator.name==name && it.initializer!==null]!==null]
            if(decl!==null)
                return decl.init.findFirst[it.declarator.name==name].declarator
            for(contrib:isa.contributingType.reverse) {
                val contribDecl = contrib.effectiveDeclarator(name)
                if(contribDecl!==null)
                    return contribDecl
            }
        } else if(isa instanceof InstructionSet){
            val decl = isa.constants.findFirst[it.init.findFirst[it.declarator.name==name && it.initializer!==null]!==null]
            if(decl!==null)
                return decl.init.findFirst[it.declarator.name==name].declarator
            val baseDecl = isa.superType.effectiveDeclarator(name)
            if(baseDecl!==null)
                return baseDecl
        }
        null
    }
}