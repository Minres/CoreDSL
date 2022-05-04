package com.minres.coredsl.util

import org.eclipse.emf.ecore.EObject
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.StorageClassSpecifier
import com.minres.coredsl.coreDsl.Instruction
import org.apache.log4j.Logger
import java.util.List
import com.minres.coredsl.coreDsl.Encoding
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BitValue
import com.minres.coredsl.coreDsl.Statement

class ModelUtil {
    
    static val logger = Logger.getLogger(typeof(ModelUtil));

    static def Iterable<Declarator> getStateDeclarators(ISA isa) {
        isa.declarations.flatMap[it.declaration.declarators]
    }

    static def Iterable<Declarator> getStateConstDeclarators(ISA isa) {
        isa.stateDeclarators.filter[
        	val decl = it.eContainer.eContainer as Declaration
        	!decl.storage.contains(StorageClassSpecifier.EXTERN) && 
        	!decl.storage.contains(StorageClassSpecifier.REGISTER) && 
        	!it.alias
        ]
    }

    static def Iterable<Declarator> getStateExternDeclarators(ISA isa) {
        isa.stateDeclarators.filter[
        	val decl = it.eContainer.eContainer as Declaration
        	decl.storage.contains(StorageClassSpecifier.EXTERN)
        ]
    }
    
    static def Iterable<Declarator> getStateRegisterDeclarators(ISA isa) {
        isa.stateDeclarators.filter[
        	val decl = it.eContainer.eContainer as Declaration
        	decl.storage.contains(StorageClassSpecifier.REGISTER)
        ]
    }

    static def Iterable<Declarator> getStateAliasDeclarators(ISA isa) {
        isa.stateDeclarators.filter[
        	it.alias
        ]
    }

    static def <T extends EObject> T parentOfType(EObject obj, Class<T> clazz) {
        if (obj.eContainer === null)
            return null
        if (clazz.isInstance(obj.eContainer))
            return obj.eContainer as T
        return obj.eContainer.parentOfType(clazz)
    }
    
    static def Declarator effectiveDeclarator(ISA isa, String name){
        if(isa instanceof CoreDef) {
            val decl = isa.allDefinitions.filter[it instanceof Declaration].findFirst[
	           	(it as Declaration).declarators.findFirst[it.name==name]!==null
            ]
            if(decl!==null) {
                return (decl as Declaration).declarators.findFirst[it.name==name]
            }
            for(contrib:isa.providedInstructionSets.reverseView) {
                val contribDecl = contrib.effectiveDeclarator(name)
                if(contribDecl!==null)
                    return contribDecl
            }
        } else if(isa instanceof InstructionSet){
            val decl = isa.stateDeclarators.findFirst[it.name==name]
            if(decl!==null) {
            	if(decl.initializer !== null)
	                return decl            	
            }
            val baseDecl = isa.superType.effectiveDeclarator(name)
            if(baseDecl!==null)
                return baseDecl
        }
        null
    }
        
    static def Iterable<Statement> allDefinitions(ISA isa){
        switch(isa){
            CoreDef:
                if (isa.providedInstructionSets.size == 0)
                    return isa.declarations + isa.assignments
                else {
                    val instrSets = isa.providedInstructionSets?.flatMap[it.allInstructionSets]
                    val seen = newLinkedHashSet
                    seen.addAll(instrSets)
                    seen.add(isa)
                    return seen.flatMap[it.declarations + it.assignments]
                }
            InstructionSet:
                return isa.allInstructionSets.flatMap[it.declarations + it.assignments]
        }
    }
    
    static def Iterable<Instruction> allInstr(CoreDef core){
        val unique = newLinkedHashMap
        val instrList = if(core.providedInstructionSets.size == 0) core.instructions else {
            val instrSets = core.providedInstructionSets?.map[InstructionSet i| i.allInstructionSets].flatten
            val seen = newLinkedHashSet
            seen.addAll(instrSets)
            seen.add(core)
            seen.map[ISA i| i.instructions].flatten
        }
        for(Instruction i: instrList){
            if(i.eContainer instanceof InstructionSet)
                logger.trace("adding instruction "+i.name+" of "+(i.eContainer as InstructionSet).name)
            if(i.eContainer instanceof CoreDef)
                logger.trace("adding instruction "+i.name+" of "+(i.eContainer as CoreDef).name)
            unique.put(i.name, i)
        }
        val instLut = newLinkedHashMap()
        for(Instruction i: unique.values){
            logger.trace("adding encoding "+i.encoding.bitEncoding+" for instruction "+i.name)
            instLut.put(i.encoding.bitEncoding, i)
        }
        return instLut.values
    }

    static def List<ISA> allInstructionSets(InstructionSet core) {
        val s = if(core.superType !== null) core.superType.allInstructionSets else newLinkedList
        s.add(core)
        return s
    }
    
    private static def String getBitEncoding(Encoding encoding) '''«FOR field : encoding.fields»«field.regEx»«ENDFOR»'''
    private static def dispatch getRegEx(BitField i) '''«FOR idx : i.endIndex.value.intValue .. i.startIndex.value.intValue».«ENDFOR»'''
    private static def dispatch getRegEx(BitValue i) '''«i.value.toString(2)»'''
    
}