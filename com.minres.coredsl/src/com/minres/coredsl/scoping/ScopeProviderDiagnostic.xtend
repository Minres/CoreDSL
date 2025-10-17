package com.minres.coredsl.scoping

import org.eclipse.xtext.diagnostics.Diagnostic

class ScopeProviderDiagnostic implements Diagnostic {
    
    val String message
    
    new(String message) {
        this.message = message
    }
    
    override getColumnEnd() {
        -1
    }
    
    override getLength() {
        0
    }
    
    override getLineEnd() {
        -1
    }
    
    override getOffset() {
        -1
    }
    
    override getColumn() {
        -1
    }
    
    override getLine() {
        -1
    }
    
    override getLocation() {
        null
    }
    
    override getMessage() {
        message
    }
    

}