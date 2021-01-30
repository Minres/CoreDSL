package com.minres.coredsl.interpreter

import java.util.Set
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.typing.DataType
import java.util.HashMap
import com.minres.coredsl.coreDsl.DirectDeclarator

class EvaluationContext {

    final EvaluationContext parent
    
    final HashMap<DirectDeclarator, Value> values = newHashMap
    
    final Set<Expression> alreadyEvaluating
    
    final DataType expectedType

    def EvaluationContext cloneWithExpectation(DataType newExpectation) {
        new EvaluationContext(newExpectation, alreadyEvaluating)
    }

    new(EvaluationContext context) {
       parent=context
       expectedType=parent.expectedType
       alreadyEvaluating=parent.alreadyEvaluating
    }

    new(DataType expectedType, Set<Expression> alreadyEvaluating) {
        this.parent=null
        this.expectedType = expectedType;
        this.alreadyEvaluating = alreadyEvaluating;
    }
    
    new(EvaluationContext context, DataType expectedType, Set<Expression> alreadyEvaluating) {
        this.parent=context
        this.expectedType = expectedType;
        this.alreadyEvaluating = alreadyEvaluating;
    }

    override boolean equals(Object obj) {
        if (this == obj)
             return  true;
        if (obj === null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        val other = obj as EvaluationContext;
        if (alreadyEvaluating === null) {
            if (other.alreadyEvaluating !== null)
                return false;
        } else if (!alreadyEvaluating.equals(other.alreadyEvaluating))
            return false;
        if (expectedType === null) {
            if (other.expectedType !== null)
                return false;
        } else if (!expectedType.equals(other.expectedType))
            return false;
        return true;
    }

    def Set<Expression> getAlreadyEvaluating() {
        return alreadyEvaluating;
    }
    
    def Value getValue(DirectDeclarator decl){
        values.get(decl)
    }
    
    def newValue(DirectDeclarator decl, Value value){
        values.put(decl, value)
    }
    
    def assignValue(DirectDeclarator decl, Value value){
        if(values.containsKey(decl)){
            values.put(decl, value)            
        }
    }
    
    def EvaluationContext fork(){
        return new EvaluationContext(this)
    }
    
    def EvaluationContext fork(DataType expectedType){
        return new EvaluationContext(this, expectedType, alreadyEvaluating);
    }
    
    def static root(){
        return new EvaluationContext(null, null, #{})
    }
    
}
