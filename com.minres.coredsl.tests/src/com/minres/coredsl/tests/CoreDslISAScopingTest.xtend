/*
 * generated by Xtext 2.10.0
 */
package com.minres.coredsl.tests

import com.google.inject.Inject
import com.minres.coredsl.coreDsl.DescriptionContent
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

import static org.junit.jupiter.api.Assertions.assertFalse
import static org.junit.jupiter.api.Assertions.assertTrue

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslISAScopingTest {

    @Inject extension ParseHelper<DescriptionContent> parseHelper

    @Inject ValidationTestHelper validator

    @Test
    def void useBeforeDeclaration() {
        val content = '''
        InstructionSet TestISA {
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
                    behavior: {
                        x = 0;
                        int x;
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertFalse(issues.isEmpty())
    }
    
    @Test
    def void declarationBeforeUse() {
        val content = '''
        InstructionSet TestISA {
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
                    behavior: {
                        int x;
                        x = 0;
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }
    
    @Test
    def void useBeforeDeclarationNested() {
        val content = '''
        InstructionSet TestISA {
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
                    behavior: {
                        {
                            x = 0;
                        }
                        int x;
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertFalse(issues.isEmpty())
    }
    
    @Test
    def void declarationBeforeUseNested() {
        val content = '''
        InstructionSet TestISA {
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
                    behavior: {
                        int x;
                        {
                            x = 0;
                        }
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }
    
    @Test
    def void globalScope() {
        val content = '''
        InstructionSet TestISA {
            architectural_state {
                int CCC = 42;
                register unsigned int X[32];
            }

            functions {
                int foo(int arg) {
                    return arg;
                }
            }

            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
                    behavior: {
                        X[rd] = (unsigned int)(X[rs1] + X[rs2] + foo(CCC));
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }
    
    @Test
    def void globalScopeExtended() {
        val content = '''
        InstructionSet TestISA {
            architectural_state {
                int CCC = 42;
                register unsigned int X[32];
            }

            functions {
                int foo(int arg) {
                    return arg;
                }
            }
        }
        
        InstructionSet TestISA2 extends TestISA {
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
                    behavior: {
                        X[rd] = (unsigned int)(X[rs1] + X[rs2] + foo(CCC));
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }
    
    @Test
    def void globalScopeFromFile() {
        val content = '''
        import "inputs/RISCVBase.core_desc"
        
        InstructionSet TestISA2 extends RISCVBase {
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
                    behavior: {
                        X[rd] = (unsigned int)(X[rs1] + X[rs2] + XLEN);
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }
    
    //@Test
    def void structMembersDirect() {
        val content = '''
        InstructionSet TestISA {
            architectural_state {
                struct {
                    unsigned int X, y;
                } point;
            }
            
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    behavior: {
                        unsigned sum = point.x + point.y;
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }

    //@Test
    def void structMembersIndirect() {
        val content = '''
        InstructionSet TestISA {
            architectural_state {
                struct point_s {
                    unsigned int X, y;
                };
            }
            
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    behavior: {
                        struct point_s  point;
                        unsigned sum = point.x + point.y;
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }
    
   // @Test
    def void structMembersDirectSub() {
        val content = '''
        InstructionSet TestISA {
            architectural_state {
                unsigned N_REGS = 4;
                struct {
                    float real;
                    float imag;
                } complex[N_REGS];
            }
            
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
                    behavior: {
                        float x = complex[1].real * complex[1].imag;
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }
    
    //@Test
    def void structMembersIndirectSub() {
        val content = '''
        InstructionSet TestISA {
            architectural_state {
                unsigned N_REGS = 4;
                struct point_s {
                    unsigned int X, y;
                };
            }
            
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    behavior: {
                        struct point_s  point[N_REGS];
                        unsigned sum = point[0].x + point[0].y;
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        for (iss : issues) println(iss)
        assertTrue(issues.isEmpty())
    }
    
    //@Test
    def void structMembersDirectNested() {
        val content = '''
        InstructionSet TestISA {
            architectural_state {
                struct rect_s {
                    struct origin_s {
                        unsigned int X, y;
                    } origin;
                    struct size_s {
                        unsigned int X, y;
                    } size;
                } rect;
            }
            
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    behavior: {
                        unsigned sum = rect.origin.x;// + rect.size.x;
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }
    
    //@Test
    def void unions() {
        val content = '''
        InstructionSet TestISA {
            architectural_state {
                union un1 {
                    long l;
                    int i;
                    short s;
                    char c;
                    int arr[10];
                    struct {float f; double d;} strct;
                };
                union un1 UR;
            }
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    behavior: {
                        UR.l = UR.s * UR.c / UR.i;
                        UR.strct.d = UR.arr[10];
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }
    
    @Test
    def void spawn() {
        val content = '''
        InstructionSet TestISA {
            architectural_state {
                register unsigned int X[32];
                register unsigned int PC;
            }
            functions {
                void maybe_corrupt_PC(int i) {
                    if ((i & 17) > 3)
                        PC = 0xdeadbeef;
                }
            }
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    behavior: {
                        int incr = (int)(X[rs1] * X[rs2]);
                        spawn {
                            int i;
                            for (i = 0; i < 42; i += incr) {
                                maybe_corrupt_PC(i % X[rd]);
                            }
                        }
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        assertTrue(issues.isEmpty())
    }
    
    @Test
    def void forLoopDecl() {
        val content = '''
        InstructionSet TestISA {
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    behavior: {
                        for (int y = 0, z = -1; y < 0 && z != 5; ++y) {}
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        for (iss : issues) println(iss)
        assertTrue(issues.isEmpty())
    }
    
    @Test
    def void doWhile() {
        val content = '''
        InstructionSet TestISA {
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    behavior: {
                        int z = 0;
                        do {
                            z++;
                        } while (z < 10);
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        for (iss : issues) println(iss)
        assertTrue(issues.isEmpty())
    }
    
    @Test
    def void switches() {
        val content = '''
        InstructionSet TestISA {
            instructions {
                Inst1 {
                    encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b0000000;  
                    behavior: {
                        int foobar;
                        switch(rs1) {
                            case 1:
                                foobar = rs2;
                                break;
                            case 2: {
                                int foobar = rs2;
                                int baz = foobar;
                                break;
                            }
                        }
                    }
                }
            }
        }
        '''.parse
        val issues = validator.validate(content)
        for (iss : issues) println(iss)
        assertTrue(issues.isEmpty())
    }
    
}   
