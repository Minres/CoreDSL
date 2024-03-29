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
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(CoreDslInjectorProvider)
class CoreDslParsingTest {

    @Inject extension ParseHelper<DescriptionContent> parseHelper

    @Inject ValidationTestHelper validator

    def CharSequence addInstructionContext(CharSequence str)'''
        InstructionSet TestISA {
            architectural_state { 
                register int PC [[is_pc]];
                register int Xreg[32];
                register float Freg[32];
            }
            instructions {
                «str»
            }
        }
    '''

    //@Test
    def void parseInstrPRELU() {
        val content = '''
        PRELU {
            encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b1111011;  
            assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
            behavior: {
                float alpha = 0.2;  
                float input, new_alpha;
                input = Freg[rs1];  // read global F register
                if (rs2!=0) // avoid having an additional instruction for setting parameter
                    new_alpha = Freg[rs2];
                else 
                    new_alpha = alpha; // use the stored alpha when rs2==0
                if(input > 0)
                    Freg[rd] = input;
                else 
                    Freg[rd] = input*new_alpha; 
                if (rs2!=0)
                    alpha = new_alpha; // update internal alpha register
                }
        }
        '''.addInstructionContext.parse
        validator.assertNoErrors(content)
    }

    //@Test
    def void parseInstrSBOX() {
        val content = '''
        SBOX {
            encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b1111011;  
            assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
            behavior: {
                unsigned int data_i;
                // contents of array omitted for for brevity        
                const unsigned char sbox[256] = { 0x63, 0x7c, 0};  

                data_i = (unsigned int) Xreg[rs1];  
                Xreg[rd] = sbox[data_i[31:24]] :: sbox[data_i[23:16]] :: sbox[data_i[15:8]] :: sbox[data_i[7:0]];
            }
        }
        '''.addInstructionContext.parse
        validator.assertNoErrors(content)
    }

    //@Test
    def void parseInstrSQRTFloatRegs() {
        val content = '''
            InstructionSet TestISA {
                architectural_state {
                    register float F_Ext[32];
                }
                instructions { 
                    vectorL {
                        encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b1111011 ;
                        assembly: "{name(rd)}, {name(rs1)}";
                        behavior: { 
                        float xc = F_Ext[rs1];     
                        float yc = F_Ext[rs1];
                        float sqdist = xc*xc + yc*yc;
                        //...SQRT(sqdist) computation
                        }
                    }
                }
            }
        '''.parse
        validator.assertNoErrors(content)
    }

    //@Test
    def void parseInstrSQRTUnionRegs() {
        val content = '''
            InstructionSet TestISA {
                architectural_state {
                    union ISAXRegFile{
                        double doublePrec;  // for a double precision entry
                        struct vector2d {
                            float x_coord;
                            float y_coord;
                        } vector2d;         // for a 2d vector entry
                    } ISAXRegFile[32]; 
                }
                instructions { 
                    vectorL {
                        encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b1111011 ;
                        assembly: "{name(rd)}, {name(rs1)}";
                        behavior: { 
                            float xc = ISAXRegFile[rs1].vector2d.x_coord;
                            float yc = ISAXRegFile[rs1].vector2d.y_coord;
                            double result;
                            double sqdist = xc*xc + yc*yc;
                            if((sqdist==0) || (sqdist[30:23]==0xff))
                                result = 0; // avoid special cases
                            else
                                result = 1;//sqrt(sqdist);  
                            ISAXRegFile[rd].doublePrec = result;
                        }
                    }
                }
            }
        '''.parse
        validator.assertNoErrors(content)
    }

    //@Test
    def void parseInstrSpawn() {
        val content = '''
            InstructionSet TestISA {
                architectural_state {
                	register int PC [[is_pc]];
                    register float Freg[32];
                    register bool F_ready[32] [[is_interlock_for=Freg]];  // use attribute to indicate purpose of F_ready
                }
                instructions {
                    SIN {
                        encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b1111011 ;
                        assembly: "#{name(rd)}, {name(rs1)}";
                        behavior: { 
                            double theta = Freg[rs1];
                            F_ready[rd] = false;            // synchronously mark result as unavailable
                            spawn {                         // asynchronously do the following block
                                    Freg[rd] = 0.01f;     // first perform the computation        
                                    F_ready[rd] = true;     // afterwards mark the result as ready
                            }
                        }
                    }
                }
            }
        '''.parse
        validator.assertNoErrors(content)
    }

    //@Test
    def void parseInstrZOL() {
        val content = '''
            InstructionSet TestISA {
                architectural_state {
                	register int PC;
                	register int X[32];
                    unsigned int count, endpc, startpc;
                }
                functions {
                    void doZOL(){      
                        bool zolactive = true; 
                        while (zolactive) {         // keep executing while condition is true
                            if (PC == endpc) {      // evaluate loop body once per clock cycle
                                if (count != 0) {
                                    --count;
                                    PC = startpc;   // jump to loop start
                                } else
                                    zolactive = false;  // iteration limit reached, stop execution
                            }
                        }
                    }
                }
                instructions {
                    LP_SETUPI {
                        encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b1111011 ;
                        assembly: "{name(rs1)}, {name(rs2)}";
                        behavior: {
                            count   = X[rs1];
                            endpc   = PC + 4 + X[rs2]<<2; // use PC relative addressing to save bits
                            startpc = PC + 4; 
                            spawn doZOL(); // Keep running after LPSETUPI ends
                        }
                    }
                }
            }
        '''.parse
        validator.assertNoErrors(content)
    }
    
    //@Test
    def void parseInstrSwitch() {
        val content = '''
        FOO {
            encoding: 0b0000000 :: rs2[4:0] :: rs1[4:0] :: 0b000 :: rd[4:0] :: 0b1111011;  
            assembly: "{name(rd)}, {name(rs1)}, {name(rs2)}";
            behavior: {
                switch(rs1) {
                    case 1: break;
                    case 2: break;
                }
            }
        }
        '''.addInstructionContext.parse
        validator.assertNoErrors(content)
    }
}
