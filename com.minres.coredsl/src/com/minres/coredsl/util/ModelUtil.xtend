package com.minres.coredsl.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.Declaration
import org.eclipse.emf.common.util.EList

class ModelUtil {

    static def <T extends EObject> T parentOfType(EObject obj, Class<T> clazz){
        if(obj.eContainer===null)
            return null
        if(clazz.isInstance(obj.eContainer))
            return obj.eContainer as T
        return obj.eContainer.parentOfType(clazz)
    }
        
    static def <T extends EObject> Iterable<T> allOfTypeAllHier(ISA isa, Class<T> clazz){
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
    
	static def <T extends EObject> T childOfparentOfType(EObject obj, Class<T> clazz){
		if(obj.eContainer===null)
			return null
		if(clazz.isInstance(obj.eContainer))
			return obj as T
		return obj.eContainer.childOfparentOfType(clazz)
	}
	
	static def <T extends EObject> Iterable<T> allOfType(ISA isa, Class<T> clazz){
		if(isa.eIsProxy) 
			EcoreUtil2.resolveAll(isa)		
		switch(isa){
			CoreDef:{
				val ret = isa.regs.allOfType(clazz) + isa.constants.allOfType(clazz) + isa.spaces.allOfType(clazz)
				if(isa.contributingType === null)
					return ret
				else
					return ret +  isa.contributingType.map[it.allOfType(clazz)].flatten
			}
			InstructionSet: {
				val ret = isa.regs.allOfType(clazz) + isa.constants.allOfType(clazz) + isa.spaces.allOfType(clazz) + isa.func as Iterable<T>
				if(isa.superType === null)
					return ret
				else {
					return ret +  isa.superType.allOfType(clazz)				
				}
			}
		}
	}
	
	static def <T extends EObject> Iterable<T> allOfType(EList<Declaration> decls, Class<T> clazz){
		decls.map[EcoreUtil2.getAllContentsOfType(it, clazz)].flatten
	}
}