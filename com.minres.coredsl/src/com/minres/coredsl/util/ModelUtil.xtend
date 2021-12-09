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
import com.minres.coredsl.coreDsl.ReferenceTypeSpecifier
import com.minres.coredsl.coreDsl.PointerTypeSpecifier
import java.util.Set
import java.util.HashSet
import java.util.ArrayList

class ModelUtil {
    
    static val logger = Logger.getLogger(typeof(ModelUtil));
    
    /**
     * Returns all instruction sets of a core in the order described <a href="https://github.com/Minres/CoreDSL/wiki/Elaboration">here</a>.
     */
    static def Iterable<InstructionSet> getTransitiveProvidedInstructionSets(CoreDef core) {
    	val list = new ArrayList<InstructionSet>()
    	val seen = new HashSet<InstructionSet>()
    	for (instructionSet : core.contributingTypes) {
    		getFlatInstructionSetHierarchy(instructionSet, list, seen)
    	}
    	return list
    }
    
    /**
     * Returns all instruction sets in the inheritance hierarchy, starting with the least derived instruction set and ending with the function input.
     */
    static def Iterable<InstructionSet> getFlatInstructionSetHierarchy(InstructionSet instructionSet) {
    	val list = new ArrayList<InstructionSet>()
    	val seen = new HashSet<InstructionSet>()
    	getFlatInstructionSetHierarchy(instructionSet, list, seen)
    	return list
    }
    
    private static def void getFlatInstructionSetHierarchy(InstructionSet instructionSet, List<InstructionSet> list, Set<InstructionSet> seen) {
    	if(!seen.add(instructionSet)) return;
    	
    	if(instructionSet.superType !== null)
    		getFlatInstructionSetHierarchy(instructionSet.superType, list, seen);
    	
    	list.add(instructionSet)
    }

    static def Iterable<Declaration> getStateConstDeclarations(ISA isa) {
        isa.declarations.filter[
        	!(it as Declaration).storage.contains(StorageClassSpecifier.EXTERN) && 
        	!(it as Declaration).storage.contains(StorageClassSpecifier.REGISTER) &&
        	!((it as Declaration).type instanceof ReferenceTypeSpecifier) &&
        	!((it as Declaration).type instanceof PointerTypeSpecifier)
        ].map[it as Declaration]
    }

    static def Iterable<Declaration> getStateExternDeclarations(ISA isa) {
        isa.declarations.filter[
        	(it as Declaration).storage.contains(StorageClassSpecifier.EXTERN) &&
        	!((it as Declaration).type instanceof ReferenceTypeSpecifier) &&
        	!((it as Declaration).type instanceof PointerTypeSpecifier)
        ].map[it as Declaration]
    }
    
    static def Iterable<Declaration> getStateRegisterDeclarations(ISA isa) {
        isa.declarations.filter[
        	(it as Declaration).storage.contains(StorageClassSpecifier.REGISTER) &&
        	!((it as Declaration).type instanceof ReferenceTypeSpecifier) &&
        	!((it as Declaration).type instanceof PointerTypeSpecifier)
        ].map[it as Declaration]
    }

    static def Iterable<Declaration> getStateAliasDeclarations(ISA isa) {
        isa.declarations.filter[
        	!(it as Declaration).storage.contains(StorageClassSpecifier.EXTERN) && 
        	!(it as Declaration).storage.contains(StorageClassSpecifier.REGISTER) &&
        	(it as Declaration).type instanceof ReferenceTypeSpecifier
        ].map[it as Declaration]
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
            for(contrib:isa.contributingTypes.reverseView) {
                val contribDecl = contrib.effectiveDeclarator(name)
                if(contribDecl!==null)
                    return contribDecl
            }
        } else if(isa instanceof InstructionSet){
            val decl = isa.declarations.findFirst[it.declarators.findFirst[it.name==name && it.initializer!==null]!==null]
            if(decl!==null)
                return decl.declarators.findFirst[it.name==name]
            val baseDecl = isa.superType.effectiveDeclarator(name)
            if(baseDecl!==null)
                return baseDecl
        }
        null
    }
    
    
    static def Iterable<Declaration> allDefinitions(CoreDef core){
    	if(core.contributingTypes.size == 0) return core.declarations
    	
        val instrSets = core.contributingTypes?.map[InstructionSet i| i.allInstructionSets].flatten
        val seen = newLinkedHashSet
        seen.addAll(instrSets)
        seen.add(core)
        return seen.map[ISA i| i.declarations].flatten
    }

    static def Iterable<Declaration> allDefinitions(InstructionSet core){
        return core.allInstructionSets.flatMap[it.declarations]
    }

    static def Iterable<Instruction> allInstr(CoreDef core){
        val unique = newLinkedHashMap
        val instrList = if(core.contributingTypes.size == 0) core.instructions else {
            val instrSets = core.contributingTypes?.map[InstructionSet i| i.allInstructionSets].flatten
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
    private static def dispatch getRegEx(BitField i) '''«FOR idx : i.right.value.intValue .. i.left.value.intValue».«ENDFOR»'''
    private static def dispatch getRegEx(BitValue i) '''«i.value.toString(2)»'''
    
}