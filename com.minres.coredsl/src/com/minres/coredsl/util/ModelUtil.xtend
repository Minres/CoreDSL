package com.minres.coredsl.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.ISA

class ModelUtil {

    static def <T extends EObject> parentOfType(EObject obj, Class<T> clazz){
        if(obj.eContainer===null)
            return null
        if(clazz.isInstance(obj.eContainer))
            return obj.eContainer
        return obj.eContainer.parentOfType(clazz)
    }
        
    static def <T extends EObject> Iterable<T> allOfType(ISA isa, Class<T> clazz){
        if(isa.eIsProxy) 
            EcoreUtil2.resolveAll(isa)      
        switch(isa){
            CoreDef:{
                if(isa.contributingType === null)
                    return EcoreUtil2.getAllContentsOfType(isa, clazz)
                else
                    return EcoreUtil2.getAllContentsOfType(isa, clazz) +  isa.contributingType.map[it.allOfType(clazz)].flatten
            }
            InstructionSet: {
                if(isa.superType === null)
                    return EcoreUtil2.getAllContentsOfType(isa, clazz)
                else {
                    return EcoreUtil2.getAllContentsOfType(isa, clazz) +  isa.superType.allOfType(clazz)                
                }
            }
        }
    }
    
}