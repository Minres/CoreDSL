package com.minres.coredsl.util

import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.TypeSpecifier

class ModelExtensions {
	private new() {}
	
	static def void assertThat(boolean condition, String errorMsg) {
		if(!condition) throw new CompilerAssertionError(errorMsg);
	}
	
	// Declarator extensions
	
	/**
	 * Returns the declaration the declarator belongs to.
	 */
	static def Declaration getDeclaration(Declarator declarator) {
		assertThat(declarator.eContainer instanceof Declaration,
			'Parent node of a declarator must always be a declaration');
		
		return declarator.eContainer as Declaration;
	}
	
	/**
	 * Returns the type specifier of the declaration the declarator belongs to.
	 */
	static def TypeSpecifier getTypeSpecifier(Declarator declarator) {
		return declarator.declaration.type;
	}
	
	/**
	 * Returns true of the declarator belongs to a declaration in the
	 * {@code architectural_state} section of an instruction set or core definition.
	 */
	static def boolean isIsaConstant(Declarator declarator) {
		return declarator.declaration.eContainer instanceof ISA;
	}
	
	// ISA extensions
	
	/**
	 * Returns all declarators declared in the {@code architectural_state} section
	 * of this ISA, <b>excluding</b> those declared in any parent types.
	 */
	static def Iterable<Declarator> getDeclaredConstants(ISA isa) {
		return isa.declarations.flatMap[it.declaration.declarators];
	}
}
