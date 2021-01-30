package com.minres.coredsl.tests;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CoreDslParsingTest.class, 
    CoreDslLoadTest.class,
    CoreDslTerminalsTest.class,
    CoreDslScopingTest.class,
    CoreDslInterpreterTest.class
})

public class CoreDSLParserTests {
    
}