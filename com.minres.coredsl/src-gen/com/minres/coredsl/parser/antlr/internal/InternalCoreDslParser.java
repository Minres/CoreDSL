package com.minres.coredsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.minres.coredsl.services.CoreDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalCoreDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_NATURAL", "RULE_BVAL", "RULE_PROCEDURENAME", "RULE_FUNCTIONNAME", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'InsructionSet'", "'extends'", "'{'", "'constants'", "','", "'}'", "'address_spaces'", "'registers'", "'instructions'", "'Core'", "'provides'", "'template'", "':'", "';'", "'['", "']'", "'('", "')'", "'encoding'", "'args_disass'", "'|'", "'\\''", "'<='", "'if'", "'else'", "'C++'", "':='", "'alias'", "'is'", "'val'", "'||'", "'&&'", "'^'", "'&'", "'=='", "'!='", "'<'", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'~'", "'!'", "'NONE'", "'u'", "'s'", "'f'", "'d'", "'q'", "'b'", "'is_pc'", "'delete'", "'is_reg_with'", "'is_addr_width'", "'no_cont'", "'cond'", "'flush'"
    };
    public static final int T__50=50;
    public static final int RULE_BOOLEAN=10;
    public static final int T__19=19;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_PROCEDURENAME=8;
    public static final int RULE_FUNCTIONNAME=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=11;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_NATURAL=6;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_BVAL=7;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int RULE_WS=14;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalCoreDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCoreDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCoreDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCoreDsl.g"; }



     	private CoreDslGrammarAccess grammarAccess;

        public InternalCoreDslParser(TokenStream input, CoreDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "DescriptionContent";
       	}

       	@Override
       	protected CoreDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDescriptionContent"
    // InternalCoreDsl.g:65:1: entryRuleDescriptionContent returns [EObject current=null] : iv_ruleDescriptionContent= ruleDescriptionContent EOF ;
    public final EObject entryRuleDescriptionContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionContent = null;


        try {
            // InternalCoreDsl.g:65:59: (iv_ruleDescriptionContent= ruleDescriptionContent EOF )
            // InternalCoreDsl.g:66:2: iv_ruleDescriptionContent= ruleDescriptionContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionContentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDescriptionContent=ruleDescriptionContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescriptionContent; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescriptionContent"


    // $ANTLR start "ruleDescriptionContent"
    // InternalCoreDsl.g:72:1: ruleDescriptionContent returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_definitions_1_0= ruleISA ) )+ ) ;
    public final EObject ruleDescriptionContent() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_definitions_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:78:2: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_definitions_1_0= ruleISA ) )+ ) )
            // InternalCoreDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_definitions_1_0= ruleISA ) )+ )
            {
            // InternalCoreDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_definitions_1_0= ruleISA ) )+ )
            // InternalCoreDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_definitions_1_0= ruleISA ) )+
            {
            // InternalCoreDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCoreDsl.g:81:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalCoreDsl.g:81:4: (lv_imports_0_0= ruleImport )
            	    // InternalCoreDsl.g:82:5: lv_imports_0_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDescriptionContentAccess().getImportsImportParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDescriptionContentRule());
            	      					}
            	      					add(
            	      						current,
            	      						"imports",
            	      						lv_imports_0_0,
            	      						"com.minres.coredsl.CoreDsl.Import");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalCoreDsl.g:99:3: ( (lv_definitions_1_0= ruleISA ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17||LA2_0==26) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCoreDsl.g:100:4: (lv_definitions_1_0= ruleISA )
            	    {
            	    // InternalCoreDsl.g:100:4: (lv_definitions_1_0= ruleISA )
            	    // InternalCoreDsl.g:101:5: lv_definitions_1_0= ruleISA
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDescriptionContentAccess().getDefinitionsISAParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_definitions_1_0=ruleISA();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDescriptionContentRule());
            	      					}
            	      					add(
            	      						current,
            	      						"definitions",
            	      						lv_definitions_1_0,
            	      						"com.minres.coredsl.CoreDsl.ISA");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescriptionContent"


    // $ANTLR start "entryRuleImport"
    // InternalCoreDsl.g:122:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalCoreDsl.g:122:47: (iv_ruleImport= ruleImport EOF )
            // InternalCoreDsl.g:123:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalCoreDsl.g:129:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:135:2: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // InternalCoreDsl.g:136:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // InternalCoreDsl.g:136:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // InternalCoreDsl.g:137:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
              		
            }
            // InternalCoreDsl.g:141:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalCoreDsl.g:142:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalCoreDsl.g:142:4: (lv_importURI_1_0= RULE_STRING )
            // InternalCoreDsl.g:143:5: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportRule());
              					}
              					setWithLastConsumed(
              						current,
              						"importURI",
              						lv_importURI_1_0,
              						"com.minres.coredsl.CoreDsl.STRING");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleISA"
    // InternalCoreDsl.g:163:1: entryRuleISA returns [EObject current=null] : iv_ruleISA= ruleISA EOF ;
    public final EObject entryRuleISA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleISA = null;


        try {
            // InternalCoreDsl.g:163:44: (iv_ruleISA= ruleISA EOF )
            // InternalCoreDsl.g:164:2: iv_ruleISA= ruleISA EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getISARule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleISA=ruleISA();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleISA; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleISA"


    // $ANTLR start "ruleISA"
    // InternalCoreDsl.g:170:1: ruleISA returns [EObject current=null] : (this_InstructionSet_0= ruleInstructionSet | this_CoreDef_1= ruleCoreDef ) ;
    public final EObject ruleISA() throws RecognitionException {
        EObject current = null;

        EObject this_InstructionSet_0 = null;

        EObject this_CoreDef_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:176:2: ( (this_InstructionSet_0= ruleInstructionSet | this_CoreDef_1= ruleCoreDef ) )
            // InternalCoreDsl.g:177:2: (this_InstructionSet_0= ruleInstructionSet | this_CoreDef_1= ruleCoreDef )
            {
            // InternalCoreDsl.g:177:2: (this_InstructionSet_0= ruleInstructionSet | this_CoreDef_1= ruleCoreDef )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            else if ( (LA3_0==26) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalCoreDsl.g:178:3: this_InstructionSet_0= ruleInstructionSet
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getISAAccess().getInstructionSetParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_InstructionSet_0=ruleInstructionSet();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_InstructionSet_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:187:3: this_CoreDef_1= ruleCoreDef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getISAAccess().getCoreDefParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CoreDef_1=ruleCoreDef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CoreDef_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleISA"


    // $ANTLR start "entryRuleInstructionSet"
    // InternalCoreDsl.g:199:1: entryRuleInstructionSet returns [EObject current=null] : iv_ruleInstructionSet= ruleInstructionSet EOF ;
    public final EObject entryRuleInstructionSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstructionSet = null;


        try {
            // InternalCoreDsl.g:199:55: (iv_ruleInstructionSet= ruleInstructionSet EOF )
            // InternalCoreDsl.g:200:2: iv_ruleInstructionSet= ruleInstructionSet EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstructionSetRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstructionSet=ruleInstructionSet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstructionSet; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstructionSet"


    // $ANTLR start "ruleInstructionSet"
    // InternalCoreDsl.g:206:1: ruleInstructionSet returns [EObject current=null] : (otherlv_0= 'InsructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleConstantDecl ) ) (otherlv_8= ',' ( (lv_constants_9_0= ruleConstantDecl ) ) )* otherlv_10= '}' )? (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleAddressSpace ) ) (otherlv_14= ',' ( (lv_spaces_15_0= ruleAddressSpace ) ) )* otherlv_16= '}' )? (otherlv_17= 'registers' otherlv_18= '{' ( ( (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias ) ) ) (otherlv_20= ',' ( ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) ) ) )* otherlv_22= '}' )? (otherlv_23= 'instructions' otherlv_24= '{' ( (lv_instr_25_0= ruleInstruction ) )+ otherlv_26= '}' )? otherlv_27= '}' ) ;
    public final EObject ruleInstructionSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        EObject lv_constants_7_0 = null;

        EObject lv_constants_9_0 = null;

        EObject lv_spaces_13_0 = null;

        EObject lv_spaces_15_0 = null;

        EObject lv_regs_19_1 = null;

        EObject lv_regs_19_2 = null;

        EObject lv_regs_19_3 = null;

        EObject lv_regs_21_1 = null;

        EObject lv_regs_21_2 = null;

        EObject lv_regs_21_3 = null;

        EObject lv_instr_25_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:212:2: ( (otherlv_0= 'InsructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleConstantDecl ) ) (otherlv_8= ',' ( (lv_constants_9_0= ruleConstantDecl ) ) )* otherlv_10= '}' )? (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleAddressSpace ) ) (otherlv_14= ',' ( (lv_spaces_15_0= ruleAddressSpace ) ) )* otherlv_16= '}' )? (otherlv_17= 'registers' otherlv_18= '{' ( ( (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias ) ) ) (otherlv_20= ',' ( ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) ) ) )* otherlv_22= '}' )? (otherlv_23= 'instructions' otherlv_24= '{' ( (lv_instr_25_0= ruleInstruction ) )+ otherlv_26= '}' )? otherlv_27= '}' ) )
            // InternalCoreDsl.g:213:2: (otherlv_0= 'InsructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleConstantDecl ) ) (otherlv_8= ',' ( (lv_constants_9_0= ruleConstantDecl ) ) )* otherlv_10= '}' )? (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleAddressSpace ) ) (otherlv_14= ',' ( (lv_spaces_15_0= ruleAddressSpace ) ) )* otherlv_16= '}' )? (otherlv_17= 'registers' otherlv_18= '{' ( ( (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias ) ) ) (otherlv_20= ',' ( ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) ) ) )* otherlv_22= '}' )? (otherlv_23= 'instructions' otherlv_24= '{' ( (lv_instr_25_0= ruleInstruction ) )+ otherlv_26= '}' )? otherlv_27= '}' )
            {
            // InternalCoreDsl.g:213:2: (otherlv_0= 'InsructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleConstantDecl ) ) (otherlv_8= ',' ( (lv_constants_9_0= ruleConstantDecl ) ) )* otherlv_10= '}' )? (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleAddressSpace ) ) (otherlv_14= ',' ( (lv_spaces_15_0= ruleAddressSpace ) ) )* otherlv_16= '}' )? (otherlv_17= 'registers' otherlv_18= '{' ( ( (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias ) ) ) (otherlv_20= ',' ( ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) ) ) )* otherlv_22= '}' )? (otherlv_23= 'instructions' otherlv_24= '{' ( (lv_instr_25_0= ruleInstruction ) )+ otherlv_26= '}' )? otherlv_27= '}' )
            // InternalCoreDsl.g:214:3: otherlv_0= 'InsructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleConstantDecl ) ) (otherlv_8= ',' ( (lv_constants_9_0= ruleConstantDecl ) ) )* otherlv_10= '}' )? (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleAddressSpace ) ) (otherlv_14= ',' ( (lv_spaces_15_0= ruleAddressSpace ) ) )* otherlv_16= '}' )? (otherlv_17= 'registers' otherlv_18= '{' ( ( (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias ) ) ) (otherlv_20= ',' ( ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) ) ) )* otherlv_22= '}' )? (otherlv_23= 'instructions' otherlv_24= '{' ( (lv_instr_25_0= ruleInstruction ) )+ otherlv_26= '}' )? otherlv_27= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getInstructionSetAccess().getInsructionSetKeyword_0());
              		
            }
            // InternalCoreDsl.g:218:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalCoreDsl.g:219:4: (lv_name_1_0= RULE_ID )
            {
            // InternalCoreDsl.g:219:4: (lv_name_1_0= RULE_ID )
            // InternalCoreDsl.g:220:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getInstructionSetAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInstructionSetRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            // InternalCoreDsl.g:236:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalCoreDsl.g:237:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getInstructionSetAccess().getExtendsKeyword_2_0());
                      			
                    }
                    // InternalCoreDsl.g:241:4: ( (otherlv_3= RULE_ID ) )
                    // InternalCoreDsl.g:242:5: (otherlv_3= RULE_ID )
                    {
                    // InternalCoreDsl.g:242:5: (otherlv_3= RULE_ID )
                    // InternalCoreDsl.g:243:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getInstructionSetRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getInstructionSetAccess().getSuperTypeInstructionSetCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,19,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:259:3: (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleConstantDecl ) ) (otherlv_8= ',' ( (lv_constants_9_0= ruleConstantDecl ) ) )* otherlv_10= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalCoreDsl.g:260:4: otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleConstantDecl ) ) (otherlv_8= ',' ( (lv_constants_9_0= ruleConstantDecl ) ) )* otherlv_10= '}'
                    {
                    otherlv_5=(Token)match(input,20,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getInstructionSetAccess().getConstantsKeyword_4_0());
                      			
                    }
                    otherlv_6=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:268:4: ( (lv_constants_7_0= ruleConstantDecl ) )
                    // InternalCoreDsl.g:269:5: (lv_constants_7_0= ruleConstantDecl )
                    {
                    // InternalCoreDsl.g:269:5: (lv_constants_7_0= ruleConstantDecl )
                    // InternalCoreDsl.g:270:6: lv_constants_7_0= ruleConstantDecl
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionSetAccess().getConstantsConstantDeclParserRuleCall_4_2_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_constants_7_0=ruleConstantDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                      						}
                      						add(
                      							current,
                      							"constants",
                      							lv_constants_7_0,
                      							"com.minres.coredsl.CoreDsl.ConstantDecl");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:287:4: (otherlv_8= ',' ( (lv_constants_9_0= ruleConstantDecl ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==21) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalCoreDsl.g:288:5: otherlv_8= ',' ( (lv_constants_9_0= ruleConstantDecl ) )
                    	    {
                    	    otherlv_8=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getInstructionSetAccess().getCommaKeyword_4_3_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:292:5: ( (lv_constants_9_0= ruleConstantDecl ) )
                    	    // InternalCoreDsl.g:293:6: (lv_constants_9_0= ruleConstantDecl )
                    	    {
                    	    // InternalCoreDsl.g:293:6: (lv_constants_9_0= ruleConstantDecl )
                    	    // InternalCoreDsl.g:294:7: lv_constants_9_0= ruleConstantDecl
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getInstructionSetAccess().getConstantsConstantDeclParserRuleCall_4_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_constants_9_0=ruleConstantDecl();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"constants",
                    	      								lv_constants_9_0,
                    	      								"com.minres.coredsl.CoreDsl.ConstantDecl");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,22,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_4_4());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:317:3: (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleAddressSpace ) ) (otherlv_14= ',' ( (lv_spaces_15_0= ruleAddressSpace ) ) )* otherlv_16= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalCoreDsl.g:318:4: otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleAddressSpace ) ) (otherlv_14= ',' ( (lv_spaces_15_0= ruleAddressSpace ) ) )* otherlv_16= '}'
                    {
                    otherlv_11=(Token)match(input,23,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getInstructionSetAccess().getAddress_spacesKeyword_5_0());
                      			
                    }
                    otherlv_12=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_5_1());
                      			
                    }
                    // InternalCoreDsl.g:326:4: ( (lv_spaces_13_0= ruleAddressSpace ) )
                    // InternalCoreDsl.g:327:5: (lv_spaces_13_0= ruleAddressSpace )
                    {
                    // InternalCoreDsl.g:327:5: (lv_spaces_13_0= ruleAddressSpace )
                    // InternalCoreDsl.g:328:6: lv_spaces_13_0= ruleAddressSpace
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionSetAccess().getSpacesAddressSpaceParserRuleCall_5_2_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_spaces_13_0=ruleAddressSpace();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                      						}
                      						add(
                      							current,
                      							"spaces",
                      							lv_spaces_13_0,
                      							"com.minres.coredsl.CoreDsl.AddressSpace");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:345:4: (otherlv_14= ',' ( (lv_spaces_15_0= ruleAddressSpace ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==21) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalCoreDsl.g:346:5: otherlv_14= ',' ( (lv_spaces_15_0= ruleAddressSpace ) )
                    	    {
                    	    otherlv_14=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_14, grammarAccess.getInstructionSetAccess().getCommaKeyword_5_3_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:350:5: ( (lv_spaces_15_0= ruleAddressSpace ) )
                    	    // InternalCoreDsl.g:351:6: (lv_spaces_15_0= ruleAddressSpace )
                    	    {
                    	    // InternalCoreDsl.g:351:6: (lv_spaces_15_0= ruleAddressSpace )
                    	    // InternalCoreDsl.g:352:7: lv_spaces_15_0= ruleAddressSpace
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getInstructionSetAccess().getSpacesAddressSpaceParserRuleCall_5_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_spaces_15_0=ruleAddressSpace();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"spaces",
                    	      								lv_spaces_15_0,
                    	      								"com.minres.coredsl.CoreDsl.AddressSpace");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_5_4());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:375:3: (otherlv_17= 'registers' otherlv_18= '{' ( ( (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias ) ) ) (otherlv_20= ',' ( ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) ) ) )* otherlv_22= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalCoreDsl.g:376:4: otherlv_17= 'registers' otherlv_18= '{' ( ( (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias ) ) ) (otherlv_20= ',' ( ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) ) ) )* otherlv_22= '}'
                    {
                    otherlv_17=(Token)match(input,24,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getInstructionSetAccess().getRegistersKeyword_6_0());
                      			
                    }
                    otherlv_18=(Token)match(input,19,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_6_1());
                      			
                    }
                    // InternalCoreDsl.g:384:4: ( ( (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias ) ) )
                    // InternalCoreDsl.g:385:5: ( (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias ) )
                    {
                    // InternalCoreDsl.g:385:5: ( (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias ) )
                    // InternalCoreDsl.g:386:6: (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias )
                    {
                    // InternalCoreDsl.g:386:6: (lv_regs_19_1= ruleRegister | lv_regs_19_2= ruleRegisterFile | lv_regs_19_3= ruleRegisterAlias )
                    int alt9=3;
                    switch ( input.LA(1) ) {
                    case RULE_ID:
                        {
                        alt9=1;
                        }
                        break;
                    case 31:
                        {
                        alt9=2;
                        }
                        break;
                    case 44:
                        {
                        alt9=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }

                    switch (alt9) {
                        case 1 :
                            // InternalCoreDsl.g:387:7: lv_regs_19_1= ruleRegister
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getInstructionSetAccess().getRegsRegisterParserRuleCall_6_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_10);
                            lv_regs_19_1=ruleRegister();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                              							}
                              							add(
                              								current,
                              								"regs",
                              								lv_regs_19_1,
                              								"com.minres.coredsl.CoreDsl.Register");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:403:7: lv_regs_19_2= ruleRegisterFile
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getInstructionSetAccess().getRegsRegisterFileParserRuleCall_6_2_0_1());
                              						
                            }
                            pushFollow(FOLLOW_10);
                            lv_regs_19_2=ruleRegisterFile();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                              							}
                              							add(
                              								current,
                              								"regs",
                              								lv_regs_19_2,
                              								"com.minres.coredsl.CoreDsl.RegisterFile");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalCoreDsl.g:419:7: lv_regs_19_3= ruleRegisterAlias
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getInstructionSetAccess().getRegsRegisterAliasParserRuleCall_6_2_0_2());
                              						
                            }
                            pushFollow(FOLLOW_10);
                            lv_regs_19_3=ruleRegisterAlias();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                              							}
                              							add(
                              								current,
                              								"regs",
                              								lv_regs_19_3,
                              								"com.minres.coredsl.CoreDsl.RegisterAlias");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalCoreDsl.g:437:4: (otherlv_20= ',' ( ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==21) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalCoreDsl.g:438:5: otherlv_20= ',' ( ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) ) )
                    	    {
                    	    otherlv_20=(Token)match(input,21,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_20, grammarAccess.getInstructionSetAccess().getCommaKeyword_6_3_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:442:5: ( ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) ) )
                    	    // InternalCoreDsl.g:443:6: ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) )
                    	    {
                    	    // InternalCoreDsl.g:443:6: ( (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias ) )
                    	    // InternalCoreDsl.g:444:7: (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias )
                    	    {
                    	    // InternalCoreDsl.g:444:7: (lv_regs_21_1= ruleRegister | lv_regs_21_2= ruleRegisterFile | lv_regs_21_3= ruleRegisterAlias )
                    	    int alt10=3;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        alt10=1;
                    	        }
                    	        break;
                    	    case 31:
                    	        {
                    	        alt10=2;
                    	        }
                    	        break;
                    	    case 44:
                    	        {
                    	        alt10=3;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 10, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt10) {
                    	        case 1 :
                    	            // InternalCoreDsl.g:445:8: lv_regs_21_1= ruleRegister
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getInstructionSetAccess().getRegsRegisterParserRuleCall_6_3_1_0_0());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_10);
                    	            lv_regs_21_1=ruleRegister();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"regs",
                    	              									lv_regs_21_1,
                    	              									"com.minres.coredsl.CoreDsl.Register");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalCoreDsl.g:461:8: lv_regs_21_2= ruleRegisterFile
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getInstructionSetAccess().getRegsRegisterFileParserRuleCall_6_3_1_0_1());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_10);
                    	            lv_regs_21_2=ruleRegisterFile();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"regs",
                    	              									lv_regs_21_2,
                    	              									"com.minres.coredsl.CoreDsl.RegisterFile");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;
                    	        case 3 :
                    	            // InternalCoreDsl.g:477:8: lv_regs_21_3= ruleRegisterAlias
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getInstructionSetAccess().getRegsRegisterAliasParserRuleCall_6_3_1_0_2());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_10);
                    	            lv_regs_21_3=ruleRegisterAlias();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"regs",
                    	              									lv_regs_21_3,
                    	              									"com.minres.coredsl.CoreDsl.RegisterAlias");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,22,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_22, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_6_4());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:501:3: (otherlv_23= 'instructions' otherlv_24= '{' ( (lv_instr_25_0= ruleInstruction ) )+ otherlv_26= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalCoreDsl.g:502:4: otherlv_23= 'instructions' otherlv_24= '{' ( (lv_instr_25_0= ruleInstruction ) )+ otherlv_26= '}'
                    {
                    otherlv_23=(Token)match(input,25,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_23, grammarAccess.getInstructionSetAccess().getInstructionsKeyword_7_0());
                      			
                    }
                    otherlv_24=(Token)match(input,19,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_24, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_7_1());
                      			
                    }
                    // InternalCoreDsl.g:510:4: ( (lv_instr_25_0= ruleInstruction ) )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==22) ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1==22) ) {
                                int LA13_3 = input.LA(3);

                                if ( (LA13_3==RULE_ID||LA13_3==RULE_PROCEDURENAME||LA13_3==22||LA13_3==36||LA13_3==40||LA13_3==42||LA13_3==46) ) {
                                    alt13=1;
                                }


                            }
                            else if ( (LA13_1==RULE_ID||LA13_1==RULE_PROCEDURENAME||LA13_1==36||LA13_1==40||LA13_1==42||LA13_1==46) ) {
                                alt13=1;
                            }


                        }
                        else if ( (LA13_0==RULE_ID||LA13_0==RULE_PROCEDURENAME||LA13_0==36||LA13_0==40||LA13_0==42||LA13_0==46) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalCoreDsl.g:511:5: (lv_instr_25_0= ruleInstruction )
                    	    {
                    	    // InternalCoreDsl.g:511:5: (lv_instr_25_0= ruleInstruction )
                    	    // InternalCoreDsl.g:512:6: lv_instr_25_0= ruleInstruction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getInstructionSetAccess().getInstrInstructionParserRuleCall_7_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_15);
                    	    lv_instr_25_0=ruleInstruction();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"instr",
                    	      							lv_instr_25_0,
                    	      							"com.minres.coredsl.CoreDsl.Instruction");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);

                    otherlv_26=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_26, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_7_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_27=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_27, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_8());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstructionSet"


    // $ANTLR start "entryRuleCoreDef"
    // InternalCoreDsl.g:542:1: entryRuleCoreDef returns [EObject current=null] : iv_ruleCoreDef= ruleCoreDef EOF ;
    public final EObject entryRuleCoreDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCoreDef = null;


        try {
            // InternalCoreDsl.g:542:48: (iv_ruleCoreDef= ruleCoreDef EOF )
            // InternalCoreDsl.g:543:2: iv_ruleCoreDef= ruleCoreDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCoreDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCoreDef=ruleCoreDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCoreDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCoreDef"


    // $ANTLR start "ruleCoreDef"
    // InternalCoreDsl.g:549:1: ruleCoreDef returns [EObject current=null] : (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'template' otherlv_8= ':' ( (lv_templateName_9_0= RULE_STRING ) ) otherlv_10= ';' )? (otherlv_11= 'constants' otherlv_12= '{' ( (lv_constants_13_0= ruleConstantDef ) )+ otherlv_14= '}' )? (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleAddressSpace ) ) (otherlv_18= ',' ( (lv_spaces_19_0= ruleAddressSpace ) ) )* otherlv_20= '}' )? (otherlv_21= 'registers' otherlv_22= '{' ( ( (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias ) ) ) (otherlv_24= ',' ( ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) ) ) )* otherlv_26= '}' )? (otherlv_27= 'instructions' otherlv_28= '{' ( (lv_instr_29_0= ruleInstruction ) )+ otherlv_30= '}' )? otherlv_31= '}' ) ;
    public final EObject ruleCoreDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_templateName_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        EObject lv_constants_13_0 = null;

        EObject lv_spaces_17_0 = null;

        EObject lv_spaces_19_0 = null;

        EObject lv_regs_23_1 = null;

        EObject lv_regs_23_2 = null;

        EObject lv_regs_23_3 = null;

        EObject lv_regs_25_1 = null;

        EObject lv_regs_25_2 = null;

        EObject lv_regs_25_3 = null;

        EObject lv_instr_29_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:555:2: ( (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'template' otherlv_8= ':' ( (lv_templateName_9_0= RULE_STRING ) ) otherlv_10= ';' )? (otherlv_11= 'constants' otherlv_12= '{' ( (lv_constants_13_0= ruleConstantDef ) )+ otherlv_14= '}' )? (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleAddressSpace ) ) (otherlv_18= ',' ( (lv_spaces_19_0= ruleAddressSpace ) ) )* otherlv_20= '}' )? (otherlv_21= 'registers' otherlv_22= '{' ( ( (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias ) ) ) (otherlv_24= ',' ( ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) ) ) )* otherlv_26= '}' )? (otherlv_27= 'instructions' otherlv_28= '{' ( (lv_instr_29_0= ruleInstruction ) )+ otherlv_30= '}' )? otherlv_31= '}' ) )
            // InternalCoreDsl.g:556:2: (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'template' otherlv_8= ':' ( (lv_templateName_9_0= RULE_STRING ) ) otherlv_10= ';' )? (otherlv_11= 'constants' otherlv_12= '{' ( (lv_constants_13_0= ruleConstantDef ) )+ otherlv_14= '}' )? (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleAddressSpace ) ) (otherlv_18= ',' ( (lv_spaces_19_0= ruleAddressSpace ) ) )* otherlv_20= '}' )? (otherlv_21= 'registers' otherlv_22= '{' ( ( (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias ) ) ) (otherlv_24= ',' ( ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) ) ) )* otherlv_26= '}' )? (otherlv_27= 'instructions' otherlv_28= '{' ( (lv_instr_29_0= ruleInstruction ) )+ otherlv_30= '}' )? otherlv_31= '}' )
            {
            // InternalCoreDsl.g:556:2: (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'template' otherlv_8= ':' ( (lv_templateName_9_0= RULE_STRING ) ) otherlv_10= ';' )? (otherlv_11= 'constants' otherlv_12= '{' ( (lv_constants_13_0= ruleConstantDef ) )+ otherlv_14= '}' )? (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleAddressSpace ) ) (otherlv_18= ',' ( (lv_spaces_19_0= ruleAddressSpace ) ) )* otherlv_20= '}' )? (otherlv_21= 'registers' otherlv_22= '{' ( ( (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias ) ) ) (otherlv_24= ',' ( ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) ) ) )* otherlv_26= '}' )? (otherlv_27= 'instructions' otherlv_28= '{' ( (lv_instr_29_0= ruleInstruction ) )+ otherlv_30= '}' )? otherlv_31= '}' )
            // InternalCoreDsl.g:557:3: otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'template' otherlv_8= ':' ( (lv_templateName_9_0= RULE_STRING ) ) otherlv_10= ';' )? (otherlv_11= 'constants' otherlv_12= '{' ( (lv_constants_13_0= ruleConstantDef ) )+ otherlv_14= '}' )? (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleAddressSpace ) ) (otherlv_18= ',' ( (lv_spaces_19_0= ruleAddressSpace ) ) )* otherlv_20= '}' )? (otherlv_21= 'registers' otherlv_22= '{' ( ( (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias ) ) ) (otherlv_24= ',' ( ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) ) ) )* otherlv_26= '}' )? (otherlv_27= 'instructions' otherlv_28= '{' ( (lv_instr_29_0= ruleInstruction ) )+ otherlv_30= '}' )? otherlv_31= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCoreDefAccess().getCoreKeyword_0());
              		
            }
            // InternalCoreDsl.g:561:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalCoreDsl.g:562:4: (lv_name_1_0= RULE_ID )
            {
            // InternalCoreDsl.g:562:4: (lv_name_1_0= RULE_ID )
            // InternalCoreDsl.g:563:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getCoreDefAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCoreDefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            // InternalCoreDsl.g:579:3: (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalCoreDsl.g:580:4: otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getCoreDefAccess().getProvidesKeyword_2_0());
                      			
                    }
                    // InternalCoreDsl.g:584:4: ( (otherlv_3= RULE_ID ) )
                    // InternalCoreDsl.g:585:5: (otherlv_3= RULE_ID )
                    {
                    // InternalCoreDsl.g:585:5: (otherlv_3= RULE_ID )
                    // InternalCoreDsl.g:586:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCoreDefRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getCoreDefAccess().getContributingTypeInstructionSetCrossReference_2_1_0());
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:597:4: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==21) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalCoreDsl.g:598:5: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getCoreDefAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:602:5: ( (otherlv_5= RULE_ID ) )
                    	    // InternalCoreDsl.g:603:6: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalCoreDsl.g:603:6: (otherlv_5= RULE_ID )
                    	    // InternalCoreDsl.g:604:7: otherlv_5= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getCoreDefRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_5, grammarAccess.getCoreDefAccess().getContributingTypeInstructionSetCrossReference_2_2_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:621:3: (otherlv_7= 'template' otherlv_8= ':' ( (lv_templateName_9_0= RULE_STRING ) ) otherlv_10= ';' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalCoreDsl.g:622:4: otherlv_7= 'template' otherlv_8= ':' ( (lv_templateName_9_0= RULE_STRING ) ) otherlv_10= ';'
                    {
                    otherlv_7=(Token)match(input,28,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getCoreDefAccess().getTemplateKeyword_4_0());
                      			
                    }
                    otherlv_8=(Token)match(input,29,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getCoreDefAccess().getColonKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:630:4: ( (lv_templateName_9_0= RULE_STRING ) )
                    // InternalCoreDsl.g:631:5: (lv_templateName_9_0= RULE_STRING )
                    {
                    // InternalCoreDsl.g:631:5: (lv_templateName_9_0= RULE_STRING )
                    // InternalCoreDsl.g:632:6: lv_templateName_9_0= RULE_STRING
                    {
                    lv_templateName_9_0=(Token)match(input,RULE_STRING,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_templateName_9_0, grammarAccess.getCoreDefAccess().getTemplateNameSTRINGTerminalRuleCall_4_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCoreDefRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"templateName",
                      							lv_templateName_9_0,
                      							"com.minres.coredsl.CoreDsl.STRING");
                      					
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,30,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getCoreDefAccess().getSemicolonKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:653:3: (otherlv_11= 'constants' otherlv_12= '{' ( (lv_constants_13_0= ruleConstantDef ) )+ otherlv_14= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==20) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalCoreDsl.g:654:4: otherlv_11= 'constants' otherlv_12= '{' ( (lv_constants_13_0= ruleConstantDef ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,20,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getCoreDefAccess().getConstantsKeyword_5_0());
                      			
                    }
                    otherlv_12=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_5_1());
                      			
                    }
                    // InternalCoreDsl.g:662:4: ( (lv_constants_13_0= ruleConstantDef ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_ID) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalCoreDsl.g:663:5: (lv_constants_13_0= ruleConstantDef )
                    	    {
                    	    // InternalCoreDsl.g:663:5: (lv_constants_13_0= ruleConstantDef )
                    	    // InternalCoreDsl.g:664:6: lv_constants_13_0= ruleConstantDef
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCoreDefAccess().getConstantsConstantDefParserRuleCall_5_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_22);
                    	    lv_constants_13_0=ruleConstantDef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constants",
                    	      							lv_constants_13_0,
                    	      							"com.minres.coredsl.CoreDsl.ConstantDef");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    otherlv_14=(Token)match(input,22,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:686:3: (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleAddressSpace ) ) (otherlv_18= ',' ( (lv_spaces_19_0= ruleAddressSpace ) ) )* otherlv_20= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalCoreDsl.g:687:4: otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleAddressSpace ) ) (otherlv_18= ',' ( (lv_spaces_19_0= ruleAddressSpace ) ) )* otherlv_20= '}'
                    {
                    otherlv_15=(Token)match(input,23,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getCoreDefAccess().getAddress_spacesKeyword_6_0());
                      			
                    }
                    otherlv_16=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_6_1());
                      			
                    }
                    // InternalCoreDsl.g:695:4: ( (lv_spaces_17_0= ruleAddressSpace ) )
                    // InternalCoreDsl.g:696:5: (lv_spaces_17_0= ruleAddressSpace )
                    {
                    // InternalCoreDsl.g:696:5: (lv_spaces_17_0= ruleAddressSpace )
                    // InternalCoreDsl.g:697:6: lv_spaces_17_0= ruleAddressSpace
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCoreDefAccess().getSpacesAddressSpaceParserRuleCall_6_2_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_spaces_17_0=ruleAddressSpace();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCoreDefRule());
                      						}
                      						add(
                      							current,
                      							"spaces",
                      							lv_spaces_17_0,
                      							"com.minres.coredsl.CoreDsl.AddressSpace");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:714:4: (otherlv_18= ',' ( (lv_spaces_19_0= ruleAddressSpace ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==21) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalCoreDsl.g:715:5: otherlv_18= ',' ( (lv_spaces_19_0= ruleAddressSpace ) )
                    	    {
                    	    otherlv_18=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_18, grammarAccess.getCoreDefAccess().getCommaKeyword_6_3_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:719:5: ( (lv_spaces_19_0= ruleAddressSpace ) )
                    	    // InternalCoreDsl.g:720:6: (lv_spaces_19_0= ruleAddressSpace )
                    	    {
                    	    // InternalCoreDsl.g:720:6: (lv_spaces_19_0= ruleAddressSpace )
                    	    // InternalCoreDsl.g:721:7: lv_spaces_19_0= ruleAddressSpace
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCoreDefAccess().getSpacesAddressSpaceParserRuleCall_6_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_spaces_19_0=ruleAddressSpace();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"spaces",
                    	      								lv_spaces_19_0,
                    	      								"com.minres.coredsl.CoreDsl.AddressSpace");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_6_4());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:744:3: (otherlv_21= 'registers' otherlv_22= '{' ( ( (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias ) ) ) (otherlv_24= ',' ( ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) ) ) )* otherlv_26= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==24) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalCoreDsl.g:745:4: otherlv_21= 'registers' otherlv_22= '{' ( ( (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias ) ) ) (otherlv_24= ',' ( ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) ) ) )* otherlv_26= '}'
                    {
                    otherlv_21=(Token)match(input,24,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_21, grammarAccess.getCoreDefAccess().getRegistersKeyword_7_0());
                      			
                    }
                    otherlv_22=(Token)match(input,19,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_22, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_7_1());
                      			
                    }
                    // InternalCoreDsl.g:753:4: ( ( (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias ) ) )
                    // InternalCoreDsl.g:754:5: ( (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias ) )
                    {
                    // InternalCoreDsl.g:754:5: ( (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias ) )
                    // InternalCoreDsl.g:755:6: (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias )
                    {
                    // InternalCoreDsl.g:755:6: (lv_regs_23_1= ruleRegister | lv_regs_23_2= ruleRegisterFile | lv_regs_23_3= ruleRegisterAlias )
                    int alt22=3;
                    switch ( input.LA(1) ) {
                    case RULE_ID:
                        {
                        alt22=1;
                        }
                        break;
                    case 31:
                        {
                        alt22=2;
                        }
                        break;
                    case 44:
                        {
                        alt22=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }

                    switch (alt22) {
                        case 1 :
                            // InternalCoreDsl.g:756:7: lv_regs_23_1= ruleRegister
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getCoreDefAccess().getRegsRegisterParserRuleCall_7_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_10);
                            lv_regs_23_1=ruleRegister();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getCoreDefRule());
                              							}
                              							add(
                              								current,
                              								"regs",
                              								lv_regs_23_1,
                              								"com.minres.coredsl.CoreDsl.Register");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:772:7: lv_regs_23_2= ruleRegisterFile
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getCoreDefAccess().getRegsRegisterFileParserRuleCall_7_2_0_1());
                              						
                            }
                            pushFollow(FOLLOW_10);
                            lv_regs_23_2=ruleRegisterFile();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getCoreDefRule());
                              							}
                              							add(
                              								current,
                              								"regs",
                              								lv_regs_23_2,
                              								"com.minres.coredsl.CoreDsl.RegisterFile");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalCoreDsl.g:788:7: lv_regs_23_3= ruleRegisterAlias
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getCoreDefAccess().getRegsRegisterAliasParserRuleCall_7_2_0_2());
                              						
                            }
                            pushFollow(FOLLOW_10);
                            lv_regs_23_3=ruleRegisterAlias();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getCoreDefRule());
                              							}
                              							add(
                              								current,
                              								"regs",
                              								lv_regs_23_3,
                              								"com.minres.coredsl.CoreDsl.RegisterAlias");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalCoreDsl.g:806:4: (otherlv_24= ',' ( ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==21) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalCoreDsl.g:807:5: otherlv_24= ',' ( ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) ) )
                    	    {
                    	    otherlv_24=(Token)match(input,21,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_24, grammarAccess.getCoreDefAccess().getCommaKeyword_7_3_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:811:5: ( ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) ) )
                    	    // InternalCoreDsl.g:812:6: ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) )
                    	    {
                    	    // InternalCoreDsl.g:812:6: ( (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias ) )
                    	    // InternalCoreDsl.g:813:7: (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias )
                    	    {
                    	    // InternalCoreDsl.g:813:7: (lv_regs_25_1= ruleRegister | lv_regs_25_2= ruleRegisterFile | lv_regs_25_3= ruleRegisterAlias )
                    	    int alt23=3;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        alt23=1;
                    	        }
                    	        break;
                    	    case 31:
                    	        {
                    	        alt23=2;
                    	        }
                    	        break;
                    	    case 44:
                    	        {
                    	        alt23=3;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 23, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt23) {
                    	        case 1 :
                    	            // InternalCoreDsl.g:814:8: lv_regs_25_1= ruleRegister
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getCoreDefAccess().getRegsRegisterParserRuleCall_7_3_1_0_0());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_10);
                    	            lv_regs_25_1=ruleRegister();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"regs",
                    	              									lv_regs_25_1,
                    	              									"com.minres.coredsl.CoreDsl.Register");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalCoreDsl.g:830:8: lv_regs_25_2= ruleRegisterFile
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getCoreDefAccess().getRegsRegisterFileParserRuleCall_7_3_1_0_1());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_10);
                    	            lv_regs_25_2=ruleRegisterFile();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"regs",
                    	              									lv_regs_25_2,
                    	              									"com.minres.coredsl.CoreDsl.RegisterFile");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;
                    	        case 3 :
                    	            // InternalCoreDsl.g:846:8: lv_regs_25_3= ruleRegisterAlias
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getCoreDefAccess().getRegsRegisterAliasParserRuleCall_7_3_1_0_2());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_10);
                    	            lv_regs_25_3=ruleRegisterAlias();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"regs",
                    	              									lv_regs_25_3,
                    	              									"com.minres.coredsl.CoreDsl.RegisterAlias");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,22,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_26, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_7_4());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:870:3: (otherlv_27= 'instructions' otherlv_28= '{' ( (lv_instr_29_0= ruleInstruction ) )+ otherlv_30= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==25) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalCoreDsl.g:871:4: otherlv_27= 'instructions' otherlv_28= '{' ( (lv_instr_29_0= ruleInstruction ) )+ otherlv_30= '}'
                    {
                    otherlv_27=(Token)match(input,25,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_27, grammarAccess.getCoreDefAccess().getInstructionsKeyword_8_0());
                      			
                    }
                    otherlv_28=(Token)match(input,19,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_28, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_8_1());
                      			
                    }
                    // InternalCoreDsl.g:879:4: ( (lv_instr_29_0= ruleInstruction ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==22) ) {
                            int LA26_1 = input.LA(2);

                            if ( (LA26_1==22) ) {
                                int LA26_3 = input.LA(3);

                                if ( (LA26_3==RULE_ID||LA26_3==RULE_PROCEDURENAME||LA26_3==22||LA26_3==36||LA26_3==40||LA26_3==42||LA26_3==46) ) {
                                    alt26=1;
                                }


                            }
                            else if ( (LA26_1==RULE_ID||LA26_1==RULE_PROCEDURENAME||LA26_1==36||LA26_1==40||LA26_1==42||LA26_1==46) ) {
                                alt26=1;
                            }


                        }
                        else if ( (LA26_0==RULE_ID||LA26_0==RULE_PROCEDURENAME||LA26_0==36||LA26_0==40||LA26_0==42||LA26_0==46) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalCoreDsl.g:880:5: (lv_instr_29_0= ruleInstruction )
                    	    {
                    	    // InternalCoreDsl.g:880:5: (lv_instr_29_0= ruleInstruction )
                    	    // InternalCoreDsl.g:881:6: lv_instr_29_0= ruleInstruction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCoreDefAccess().getInstrInstructionParserRuleCall_8_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_15);
                    	    lv_instr_29_0=ruleInstruction();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"instr",
                    	      							lv_instr_29_0,
                    	      							"com.minres.coredsl.CoreDsl.Instruction");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    otherlv_30=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_30, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_8_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_31=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_31, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_9());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCoreDef"


    // $ANTLR start "entryRuleRangeSpec"
    // InternalCoreDsl.g:911:1: entryRuleRangeSpec returns [EObject current=null] : iv_ruleRangeSpec= ruleRangeSpec EOF ;
    public final EObject entryRuleRangeSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeSpec = null;


        try {
            // InternalCoreDsl.g:911:50: (iv_ruleRangeSpec= ruleRangeSpec EOF )
            // InternalCoreDsl.g:912:2: iv_ruleRangeSpec= ruleRangeSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeSpecRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRangeSpec=ruleRangeSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeSpec; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeSpec"


    // $ANTLR start "ruleRangeSpec"
    // InternalCoreDsl.g:918:1: ruleRangeSpec returns [EObject current=null] : (otherlv_0= '[' ( (lv_left_1_0= RULE_NATURAL ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NATURAL ) ) otherlv_4= ']' ) ;
    public final EObject ruleRangeSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_left_1_0=null;
        Token otherlv_2=null;
        Token lv_right_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:924:2: ( (otherlv_0= '[' ( (lv_left_1_0= RULE_NATURAL ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NATURAL ) ) otherlv_4= ']' ) )
            // InternalCoreDsl.g:925:2: (otherlv_0= '[' ( (lv_left_1_0= RULE_NATURAL ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NATURAL ) ) otherlv_4= ']' )
            {
            // InternalCoreDsl.g:925:2: (otherlv_0= '[' ( (lv_left_1_0= RULE_NATURAL ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NATURAL ) ) otherlv_4= ']' )
            // InternalCoreDsl.g:926:3: otherlv_0= '[' ( (lv_left_1_0= RULE_NATURAL ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NATURAL ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRangeSpecAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalCoreDsl.g:930:3: ( (lv_left_1_0= RULE_NATURAL ) )
            // InternalCoreDsl.g:931:4: (lv_left_1_0= RULE_NATURAL )
            {
            // InternalCoreDsl.g:931:4: (lv_left_1_0= RULE_NATURAL )
            // InternalCoreDsl.g:932:5: lv_left_1_0= RULE_NATURAL
            {
            lv_left_1_0=(Token)match(input,RULE_NATURAL,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_left_1_0, grammarAccess.getRangeSpecAccess().getLeftNATURALTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRangeSpecRule());
              					}
              					setWithLastConsumed(
              						current,
              						"left",
              						lv_left_1_0,
              						"com.minres.coredsl.CoreDsl.NATURAL");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRangeSpecAccess().getColonKeyword_2());
              		
            }
            // InternalCoreDsl.g:952:3: ( (lv_right_3_0= RULE_NATURAL ) )
            // InternalCoreDsl.g:953:4: (lv_right_3_0= RULE_NATURAL )
            {
            // InternalCoreDsl.g:953:4: (lv_right_3_0= RULE_NATURAL )
            // InternalCoreDsl.g:954:5: lv_right_3_0= RULE_NATURAL
            {
            lv_right_3_0=(Token)match(input,RULE_NATURAL,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_right_3_0, grammarAccess.getRangeSpecAccess().getRightNATURALTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRangeSpecRule());
              					}
              					setWithLastConsumed(
              						current,
              						"right",
              						lv_right_3_0,
              						"com.minres.coredsl.CoreDsl.NATURAL");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRangeSpecAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeSpec"


    // $ANTLR start "entryRuleInstruction"
    // InternalCoreDsl.g:978:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // InternalCoreDsl.g:978:52: (iv_ruleInstruction= ruleInstruction EOF )
            // InternalCoreDsl.g:979:2: iv_ruleInstruction= ruleInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // InternalCoreDsl.g:985:1: ruleInstruction returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_disass_14_0=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Enumerator lv_attributes_3_0 = null;

        Enumerator lv_attributes_5_0 = null;

        EObject lv_encoding_10_0 = null;

        EObject lv_operation_16_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:991:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+ {...}?) ) ) )
            // InternalCoreDsl.g:992:2: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+ {...}?) ) )
            {
            // InternalCoreDsl.g:992:2: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+ {...}?) ) )
            // InternalCoreDsl.g:993:3: ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+ {...}?) )
            {
            // InternalCoreDsl.g:993:3: ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+ {...}?) )
            // InternalCoreDsl.g:994:4: ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+ {...}?)
            {
            getUnorderedGroupHelper().enter(grammarAccess.getInstructionAccess().getUnorderedGroup());
            // InternalCoreDsl.g:997:4: ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+ {...}?)
            // InternalCoreDsl.g:998:5: ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+ {...}?
            {
            // InternalCoreDsl.g:998:5: ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=3;
                alt32 = dfa32.predict(input);
                switch (alt32) {
            	case 1 :
            	    // InternalCoreDsl.g:999:3: ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) )
            	    {
            	    // InternalCoreDsl.g:999:3: ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) )
            	    // InternalCoreDsl.g:1000:4: {...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleInstruction", "getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalCoreDsl.g:1000:105: ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) )
            	    // InternalCoreDsl.g:1001:5: ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getInstructionAccess().getUnorderedGroup(), 0);
            	    // InternalCoreDsl.g:1004:8: ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) )
            	    // InternalCoreDsl.g:1004:9: {...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleInstruction", "true");
            	    }
            	    // InternalCoreDsl.g:1004:18: ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) )
            	    // InternalCoreDsl.g:1004:19: ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' )
            	    {
            	    // InternalCoreDsl.g:1004:19: ( (lv_name_1_0= RULE_ID ) )
            	    // InternalCoreDsl.g:1005:9: (lv_name_1_0= RULE_ID )
            	    {
            	    // InternalCoreDsl.g:1005:9: (lv_name_1_0= RULE_ID )
            	    // InternalCoreDsl.g:1006:10: lv_name_1_0= RULE_ID
            	    {
            	    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(lv_name_1_0, grammarAccess.getInstructionAccess().getNameIDTerminalRuleCall_0_0_0());
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										if (current==null) {
            	      											current = createModelElement(grammarAccess.getInstructionRule());
            	      										}
            	      										setWithLastConsumed(
            	      											current,
            	      											"name",
            	      											lv_name_1_0,
            	      											"com.minres.coredsl.CoreDsl.ID");
            	      									
            	    }

            	    }


            	    }

            	    // InternalCoreDsl.g:1022:8: (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==33) ) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // InternalCoreDsl.g:1023:9: otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')'
            	            {
            	            otherlv_2=(Token)match(input,33,FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              									newLeafNode(otherlv_2, grammarAccess.getInstructionAccess().getLeftParenthesisKeyword_0_1_0());
            	              								
            	            }
            	            // InternalCoreDsl.g:1027:9: ( (lv_attributes_3_0= ruleInstrAttribute ) )
            	            // InternalCoreDsl.g:1028:10: (lv_attributes_3_0= ruleInstrAttribute )
            	            {
            	            // InternalCoreDsl.g:1028:10: (lv_attributes_3_0= ruleInstrAttribute )
            	            // InternalCoreDsl.g:1029:11: lv_attributes_3_0= ruleInstrAttribute
            	            {
            	            if ( state.backtracking==0 ) {

            	              											newCompositeNode(grammarAccess.getInstructionAccess().getAttributesInstrAttributeEnumRuleCall_0_1_1_0());
            	              										
            	            }
            	            pushFollow(FOLLOW_27);
            	            lv_attributes_3_0=ruleInstrAttribute();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              											if (current==null) {
            	              												current = createModelElementForParent(grammarAccess.getInstructionRule());
            	              											}
            	              											add(
            	              												current,
            	              												"attributes",
            	              												lv_attributes_3_0,
            	              												"com.minres.coredsl.CoreDsl.InstrAttribute");
            	              											afterParserOrEnumRuleCall();
            	              										
            	            }

            	            }


            	            }

            	            // InternalCoreDsl.g:1046:9: (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )*
            	            loop28:
            	            do {
            	                int alt28=2;
            	                int LA28_0 = input.LA(1);

            	                if ( (LA28_0==21) ) {
            	                    alt28=1;
            	                }


            	                switch (alt28) {
            	            	case 1 :
            	            	    // InternalCoreDsl.g:1047:10: otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) )
            	            	    {
            	            	    otherlv_4=(Token)match(input,21,FOLLOW_26); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      										newLeafNode(otherlv_4, grammarAccess.getInstructionAccess().getCommaKeyword_0_1_2_0());
            	            	      									
            	            	    }
            	            	    // InternalCoreDsl.g:1051:10: ( (lv_attributes_5_0= ruleInstrAttribute ) )
            	            	    // InternalCoreDsl.g:1052:11: (lv_attributes_5_0= ruleInstrAttribute )
            	            	    {
            	            	    // InternalCoreDsl.g:1052:11: (lv_attributes_5_0= ruleInstrAttribute )
            	            	    // InternalCoreDsl.g:1053:12: lv_attributes_5_0= ruleInstrAttribute
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      												newCompositeNode(grammarAccess.getInstructionAccess().getAttributesInstrAttributeEnumRuleCall_0_1_2_1_0());
            	            	      											
            	            	    }
            	            	    pushFollow(FOLLOW_27);
            	            	    lv_attributes_5_0=ruleInstrAttribute();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      												if (current==null) {
            	            	      													current = createModelElementForParent(grammarAccess.getInstructionRule());
            	            	      												}
            	            	      												add(
            	            	      													current,
            	            	      													"attributes",
            	            	      													lv_attributes_5_0,
            	            	      													"com.minres.coredsl.CoreDsl.InstrAttribute");
            	            	      												afterParserOrEnumRuleCall();
            	            	      											
            	            	    }

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop28;
            	                }
            	            } while (true);

            	            otherlv_6=(Token)match(input,34,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              									newLeafNode(otherlv_6, grammarAccess.getInstructionAccess().getRightParenthesisKeyword_0_1_3());
            	              								
            	            }

            	            }
            	            break;

            	    }

            	    otherlv_7=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								newLeafNode(otherlv_7, grammarAccess.getInstructionAccess().getLeftCurlyBracketKeyword_0_2());
            	      							
            	    }
            	    // InternalCoreDsl.g:1080:8: (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' )
            	    // InternalCoreDsl.g:1081:9: otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';'
            	    {
            	    otherlv_8=(Token)match(input,35,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_8, grammarAccess.getInstructionAccess().getEncodingKeyword_0_3_0());
            	      								
            	    }
            	    otherlv_9=(Token)match(input,29,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_9, grammarAccess.getInstructionAccess().getColonKeyword_0_3_1());
            	      								
            	    }
            	    // InternalCoreDsl.g:1089:9: ( (lv_encoding_10_0= ruleEncoding ) )
            	    // InternalCoreDsl.g:1090:10: (lv_encoding_10_0= ruleEncoding )
            	    {
            	    // InternalCoreDsl.g:1090:10: (lv_encoding_10_0= ruleEncoding )
            	    // InternalCoreDsl.g:1091:11: lv_encoding_10_0= ruleEncoding
            	    {
            	    if ( state.backtracking==0 ) {

            	      											newCompositeNode(grammarAccess.getInstructionAccess().getEncodingEncodingParserRuleCall_0_3_2_0());
            	      										
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_encoding_10_0=ruleEncoding();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      											if (current==null) {
            	      												current = createModelElementForParent(grammarAccess.getInstructionRule());
            	      											}
            	      											set(
            	      												current,
            	      												"encoding",
            	      												lv_encoding_10_0,
            	      												"com.minres.coredsl.CoreDsl.Encoding");
            	      											afterParserOrEnumRuleCall();
            	      										
            	    }

            	    }


            	    }

            	    otherlv_11=(Token)match(input,30,FOLLOW_30); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_11, grammarAccess.getInstructionAccess().getSemicolonKeyword_0_3_3());
            	      								
            	    }

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getInstructionAccess().getUnorderedGroup());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalCoreDsl.g:1119:3: ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) )
            	    {
            	    // InternalCoreDsl.g:1119:3: ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) )
            	    // InternalCoreDsl.g:1120:4: {...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleInstruction", "getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalCoreDsl.g:1120:105: ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) )
            	    // InternalCoreDsl.g:1121:5: ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getInstructionAccess().getUnorderedGroup(), 1);
            	    // InternalCoreDsl.g:1124:8: ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) )
            	    // InternalCoreDsl.g:1124:9: {...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleInstruction", "true");
            	    }
            	    // InternalCoreDsl.g:1124:18: ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' )
            	    // InternalCoreDsl.g:1124:19: (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}'
            	    {
            	    // InternalCoreDsl.g:1124:19: (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==36) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // InternalCoreDsl.g:1125:9: otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';'
            	            {
            	            otherlv_12=(Token)match(input,36,FOLLOW_20); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              									newLeafNode(otherlv_12, grammarAccess.getInstructionAccess().getArgs_disassKeyword_1_0_0());
            	              								
            	            }
            	            otherlv_13=(Token)match(input,29,FOLLOW_5); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              									newLeafNode(otherlv_13, grammarAccess.getInstructionAccess().getColonKeyword_1_0_1());
            	              								
            	            }
            	            // InternalCoreDsl.g:1133:9: ( (lv_disass_14_0= RULE_STRING ) )
            	            // InternalCoreDsl.g:1134:10: (lv_disass_14_0= RULE_STRING )
            	            {
            	            // InternalCoreDsl.g:1134:10: (lv_disass_14_0= RULE_STRING )
            	            // InternalCoreDsl.g:1135:11: lv_disass_14_0= RULE_STRING
            	            {
            	            lv_disass_14_0=(Token)match(input,RULE_STRING,FOLLOW_21); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              											newLeafNode(lv_disass_14_0, grammarAccess.getInstructionAccess().getDisassSTRINGTerminalRuleCall_1_0_2_0());
            	              										
            	            }
            	            if ( state.backtracking==0 ) {

            	              											if (current==null) {
            	              												current = createModelElement(grammarAccess.getInstructionRule());
            	              											}
            	              											setWithLastConsumed(
            	              												current,
            	              												"disass",
            	              												lv_disass_14_0,
            	              												"com.minres.coredsl.CoreDsl.STRING");
            	              										
            	            }

            	            }


            	            }

            	            otherlv_15=(Token)match(input,30,FOLLOW_31); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              									newLeafNode(otherlv_15, grammarAccess.getInstructionAccess().getSemicolonKeyword_1_0_3());
            	              								
            	            }

            	            }
            	            break;

            	    }

            	    // InternalCoreDsl.g:1156:8: ( (lv_operation_16_0= ruleOperation ) )?
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==RULE_ID||LA31_0==RULE_PROCEDURENAME||LA31_0==40||LA31_0==42||LA31_0==46) ) {
            	        alt31=1;
            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // InternalCoreDsl.g:1157:9: (lv_operation_16_0= ruleOperation )
            	            {
            	            // InternalCoreDsl.g:1157:9: (lv_operation_16_0= ruleOperation )
            	            // InternalCoreDsl.g:1158:10: lv_operation_16_0= ruleOperation
            	            {
            	            if ( state.backtracking==0 ) {

            	              										newCompositeNode(grammarAccess.getInstructionAccess().getOperationOperationParserRuleCall_1_1_0());
            	              									
            	            }
            	            pushFollow(FOLLOW_16);
            	            lv_operation_16_0=ruleOperation();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElementForParent(grammarAccess.getInstructionRule());
            	              										}
            	              										set(
            	              											current,
            	              											"operation",
            	              											lv_operation_16_0,
            	              											"com.minres.coredsl.CoreDsl.Operation");
            	              										afterParserOrEnumRuleCall();
            	              									
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_17=(Token)match(input,22,FOLLOW_30); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								newLeafNode(otherlv_17, grammarAccess.getInstructionAccess().getRightCurlyBracketKeyword_1_2());
            	      							
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getInstructionAccess().getUnorderedGroup());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getInstructionAccess().getUnorderedGroup()) ) {
                if (state.backtracking>0) {state.failed=true; return current;}
                throw new FailedPredicateException(input, "ruleInstruction", "getUnorderedGroupHelper().canLeave(grammarAccess.getInstructionAccess().getUnorderedGroup())");
            }

            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getInstructionAccess().getUnorderedGroup());

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleEncoding"
    // InternalCoreDsl.g:1196:1: entryRuleEncoding returns [EObject current=null] : iv_ruleEncoding= ruleEncoding EOF ;
    public final EObject entryRuleEncoding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEncoding = null;


        try {
            // InternalCoreDsl.g:1196:49: (iv_ruleEncoding= ruleEncoding EOF )
            // InternalCoreDsl.g:1197:2: iv_ruleEncoding= ruleEncoding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEncodingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEncoding=ruleEncoding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEncoding; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEncoding"


    // $ANTLR start "ruleEncoding"
    // InternalCoreDsl.g:1203:1: ruleEncoding returns [EObject current=null] : ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )* ) ;
    public final EObject ruleEncoding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fields_0_0 = null;

        EObject lv_fields_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1209:2: ( ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )* ) )
            // InternalCoreDsl.g:1210:2: ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )* )
            {
            // InternalCoreDsl.g:1210:2: ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )* )
            // InternalCoreDsl.g:1211:3: ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )*
            {
            // InternalCoreDsl.g:1211:3: ( (lv_fields_0_0= ruleField ) )
            // InternalCoreDsl.g:1212:4: (lv_fields_0_0= ruleField )
            {
            // InternalCoreDsl.g:1212:4: (lv_fields_0_0= ruleField )
            // InternalCoreDsl.g:1213:5: lv_fields_0_0= ruleField
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEncodingAccess().getFieldsFieldParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_32);
            lv_fields_0_0=ruleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEncodingRule());
              					}
              					add(
              						current,
              						"fields",
              						lv_fields_0_0,
              						"com.minres.coredsl.CoreDsl.Field");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:1230:3: (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==37) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalCoreDsl.g:1231:4: otherlv_1= '|' ( (lv_fields_2_0= ruleField ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getEncodingAccess().getVerticalLineKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:1235:4: ( (lv_fields_2_0= ruleField ) )
            	    // InternalCoreDsl.g:1236:5: (lv_fields_2_0= ruleField )
            	    {
            	    // InternalCoreDsl.g:1236:5: (lv_fields_2_0= ruleField )
            	    // InternalCoreDsl.g:1237:6: lv_fields_2_0= ruleField
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEncodingAccess().getFieldsFieldParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_fields_2_0=ruleField();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEncodingRule());
            	      						}
            	      						add(
            	      							current,
            	      							"fields",
            	      							lv_fields_2_0,
            	      							"com.minres.coredsl.CoreDsl.Field");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEncoding"


    // $ANTLR start "entryRuleField"
    // InternalCoreDsl.g:1259:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalCoreDsl.g:1259:46: (iv_ruleField= ruleField EOF )
            // InternalCoreDsl.g:1260:2: iv_ruleField= ruleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleField; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalCoreDsl.g:1266:1: ruleField returns [EObject current=null] : (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        EObject this_BitValue_0 = null;

        EObject this_BitField_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1272:2: ( (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField ) )
            // InternalCoreDsl.g:1273:2: (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField )
            {
            // InternalCoreDsl.g:1273:2: (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_BVAL) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_ID) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalCoreDsl.g:1274:3: this_BitValue_0= ruleBitValue
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFieldAccess().getBitValueParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BitValue_0=ruleBitValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BitValue_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1283:3: this_BitField_1= ruleBitField
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFieldAccess().getBitFieldParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BitField_1=ruleBitField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BitField_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleBitValue"
    // InternalCoreDsl.g:1295:1: entryRuleBitValue returns [EObject current=null] : iv_ruleBitValue= ruleBitValue EOF ;
    public final EObject entryRuleBitValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitValue = null;


        try {
            // InternalCoreDsl.g:1295:49: (iv_ruleBitValue= ruleBitValue EOF )
            // InternalCoreDsl.g:1296:2: iv_ruleBitValue= ruleBitValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitValue=ruleBitValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitValue"


    // $ANTLR start "ruleBitValue"
    // InternalCoreDsl.g:1302:1: ruleBitValue returns [EObject current=null] : ( (lv_name_0_0= RULE_BVAL ) ) ;
    public final EObject ruleBitValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:1308:2: ( ( (lv_name_0_0= RULE_BVAL ) ) )
            // InternalCoreDsl.g:1309:2: ( (lv_name_0_0= RULE_BVAL ) )
            {
            // InternalCoreDsl.g:1309:2: ( (lv_name_0_0= RULE_BVAL ) )
            // InternalCoreDsl.g:1310:3: (lv_name_0_0= RULE_BVAL )
            {
            // InternalCoreDsl.g:1310:3: (lv_name_0_0= RULE_BVAL )
            // InternalCoreDsl.g:1311:4: lv_name_0_0= RULE_BVAL
            {
            lv_name_0_0=(Token)match(input,RULE_BVAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_name_0_0, grammarAccess.getBitValueAccess().getNameBVALTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getBitValueRule());
              				}
              				setWithLastConsumed(
              					current,
              					"name",
              					lv_name_0_0,
              					"com.minres.coredsl.CoreDsl.BVAL");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitValue"


    // $ANTLR start "entryRuleBitField"
    // InternalCoreDsl.g:1330:1: entryRuleBitField returns [EObject current=null] : iv_ruleBitField= ruleBitField EOF ;
    public final EObject entryRuleBitField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitField = null;


        try {
            // InternalCoreDsl.g:1330:49: (iv_ruleBitField= ruleBitField EOF )
            // InternalCoreDsl.g:1331:2: iv_ruleBitField= ruleBitField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitField=ruleBitField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitField; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitField"


    // $ANTLR start "ruleBitField"
    // InternalCoreDsl.g:1337:1: ruleBitField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )? ) ;
    public final EObject ruleBitField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        EObject lv_bitRange_1_0 = null;

        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1343:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )? ) )
            // InternalCoreDsl.g:1344:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )? )
            {
            // InternalCoreDsl.g:1344:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )? )
            // InternalCoreDsl.g:1345:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )?
            {
            // InternalCoreDsl.g:1345:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:1346:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:1346:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:1347:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getBitFieldAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBitFieldRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            // InternalCoreDsl.g:1363:3: ( (lv_bitRange_1_0= ruleRangeSpec ) )
            // InternalCoreDsl.g:1364:4: (lv_bitRange_1_0= ruleRangeSpec )
            {
            // InternalCoreDsl.g:1364:4: (lv_bitRange_1_0= ruleRangeSpec )
            // InternalCoreDsl.g:1365:5: lv_bitRange_1_0= ruleRangeSpec
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBitFieldAccess().getBitRangeRangeSpecParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_bitRange_1_0=ruleRangeSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBitFieldRule());
              					}
              					set(
              						current,
              						"bitRange",
              						lv_bitRange_1_0,
              						"com.minres.coredsl.CoreDsl.RangeSpec");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:1382:3: ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==38||(LA36_0>=65 && LA36_0<=71)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalCoreDsl.g:1383:4: (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) )
                    {
                    // InternalCoreDsl.g:1383:4: (otherlv_2= '\\'' )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==38) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalCoreDsl.g:1384:5: otherlv_2= '\\''
                            {
                            otherlv_2=(Token)match(input,38,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getBitFieldAccess().getApostropheKeyword_2_0());
                              				
                            }

                            }
                            break;

                    }

                    // InternalCoreDsl.g:1389:4: ( (lv_type_3_0= ruleDataType ) )
                    // InternalCoreDsl.g:1390:5: (lv_type_3_0= ruleDataType )
                    {
                    // InternalCoreDsl.g:1390:5: (lv_type_3_0= ruleDataType )
                    // InternalCoreDsl.g:1391:6: lv_type_3_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitFieldAccess().getTypeDataTypeEnumRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_type_3_0=ruleDataType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBitFieldRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_3_0,
                      							"com.minres.coredsl.CoreDsl.DataType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitField"


    // $ANTLR start "entryRuleOperation"
    // InternalCoreDsl.g:1413:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalCoreDsl.g:1413:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalCoreDsl.g:1414:2: iv_ruleOperation= ruleOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalCoreDsl.g:1420:1: ruleOperation returns [EObject current=null] : ( (lv_statements_0_0= ruleStatement ) )+ ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_0_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1426:2: ( ( (lv_statements_0_0= ruleStatement ) )+ )
            // InternalCoreDsl.g:1427:2: ( (lv_statements_0_0= ruleStatement ) )+
            {
            // InternalCoreDsl.g:1427:2: ( (lv_statements_0_0= ruleStatement ) )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID||LA37_0==RULE_PROCEDURENAME||LA37_0==40||LA37_0==42||LA37_0==46) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalCoreDsl.g:1428:3: (lv_statements_0_0= ruleStatement )
            	    {
            	    // InternalCoreDsl.g:1428:3: (lv_statements_0_0= ruleStatement )
            	    // InternalCoreDsl.g:1429:4: lv_statements_0_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getOperationAccess().getStatementsStatementParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_statements_0_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getOperationRule());
            	      				}
            	      				add(
            	      					current,
            	      					"statements",
            	      					lv_statements_0_0,
            	      					"com.minres.coredsl.CoreDsl.Statement");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleStatement"
    // InternalCoreDsl.g:1449:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalCoreDsl.g:1449:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalCoreDsl.g:1450:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalCoreDsl.g:1456:1: ruleStatement returns [EObject current=null] : (this_Assignment_0= ruleAssignment | this_ConditionalStmt_1= ruleConditionalStmt | this_DirectCode_2= ruleDirectCode | this_Procedure_3= ruleProcedure ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Assignment_0 = null;

        EObject this_ConditionalStmt_1 = null;

        EObject this_DirectCode_2 = null;

        EObject this_Procedure_3 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1462:2: ( (this_Assignment_0= ruleAssignment | this_ConditionalStmt_1= ruleConditionalStmt | this_DirectCode_2= ruleDirectCode | this_Procedure_3= ruleProcedure ) )
            // InternalCoreDsl.g:1463:2: (this_Assignment_0= ruleAssignment | this_ConditionalStmt_1= ruleConditionalStmt | this_DirectCode_2= ruleDirectCode | this_Procedure_3= ruleProcedure )
            {
            // InternalCoreDsl.g:1463:2: (this_Assignment_0= ruleAssignment | this_ConditionalStmt_1= ruleConditionalStmt | this_DirectCode_2= ruleDirectCode | this_Procedure_3= ruleProcedure )
            int alt38=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 46:
                {
                alt38=1;
                }
                break;
            case 40:
                {
                alt38=2;
                }
                break;
            case 42:
                {
                alt38=3;
                }
                break;
            case RULE_PROCEDURENAME:
                {
                alt38=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalCoreDsl.g:1464:3: this_Assignment_0= ruleAssignment
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Assignment_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1473:3: this_ConditionalStmt_1= ruleConditionalStmt
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getConditionalStmtParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConditionalStmt_1=ruleConditionalStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConditionalStmt_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:1482:3: this_DirectCode_2= ruleDirectCode
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getDirectCodeParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DirectCode_2=ruleDirectCode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DirectCode_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:1491:3: this_Procedure_3= ruleProcedure
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getProcedureParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Procedure_3=ruleProcedure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Procedure_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleAssignment"
    // InternalCoreDsl.g:1503:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalCoreDsl.g:1503:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalCoreDsl.g:1504:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalCoreDsl.g:1510:1: ruleAssignment returns [EObject current=null] : ( ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' ) | ( () ( (otherlv_6= RULE_ID ) ) ) | ( () ( (lv_to_8_0= ruleScalar ) ) ) ) ( (lv_bitWidth_9_0= ruleBitSizeSpec ) )? otherlv_10= '<=' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= ';' ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_index_3_0 = null;

        EObject lv_to_8_0 = null;

        EObject lv_bitWidth_9_0 = null;

        EObject lv_expression_11_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1516:2: ( ( ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' ) | ( () ( (otherlv_6= RULE_ID ) ) ) | ( () ( (lv_to_8_0= ruleScalar ) ) ) ) ( (lv_bitWidth_9_0= ruleBitSizeSpec ) )? otherlv_10= '<=' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= ';' ) )
            // InternalCoreDsl.g:1517:2: ( ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' ) | ( () ( (otherlv_6= RULE_ID ) ) ) | ( () ( (lv_to_8_0= ruleScalar ) ) ) ) ( (lv_bitWidth_9_0= ruleBitSizeSpec ) )? otherlv_10= '<=' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= ';' )
            {
            // InternalCoreDsl.g:1517:2: ( ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' ) | ( () ( (otherlv_6= RULE_ID ) ) ) | ( () ( (lv_to_8_0= ruleScalar ) ) ) ) ( (lv_bitWidth_9_0= ruleBitSizeSpec ) )? otherlv_10= '<=' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= ';' )
            // InternalCoreDsl.g:1518:3: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' ) | ( () ( (otherlv_6= RULE_ID ) ) ) | ( () ( (lv_to_8_0= ruleScalar ) ) ) ) ( (lv_bitWidth_9_0= ruleBitSizeSpec ) )? otherlv_10= '<=' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= ';'
            {
            // InternalCoreDsl.g:1518:3: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' ) | ( () ( (otherlv_6= RULE_ID ) ) ) | ( () ( (lv_to_8_0= ruleScalar ) ) ) )
            int alt39=3;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==19||LA39_1==39) ) {
                    alt39=2;
                }
                else if ( (LA39_1==31) ) {
                    alt39=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA39_0==46) ) {
                alt39=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalCoreDsl.g:1519:4: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // InternalCoreDsl.g:1519:4: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // InternalCoreDsl.g:1520:5: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    // InternalCoreDsl.g:1520:5: ()
                    // InternalCoreDsl.g:1521:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElement(
                      							grammarAccess.getAssignmentAccess().getIndexedAssignmentAction_0_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalCoreDsl.g:1527:5: ( (otherlv_1= RULE_ID ) )
                    // InternalCoreDsl.g:1528:6: (otherlv_1= RULE_ID )
                    {
                    // InternalCoreDsl.g:1528:6: (otherlv_1= RULE_ID )
                    // InternalCoreDsl.g:1529:7: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getAssignmentRule());
                      							}
                      						
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getToIndexedVariableCrossReference_0_0_1_0());
                      						
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,31,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getAssignmentAccess().getLeftSquareBracketKeyword_0_0_2());
                      				
                    }
                    // InternalCoreDsl.g:1544:5: ( (lv_index_3_0= ruleExpression ) )
                    // InternalCoreDsl.g:1545:6: (lv_index_3_0= ruleExpression )
                    {
                    // InternalCoreDsl.g:1545:6: (lv_index_3_0= ruleExpression )
                    // InternalCoreDsl.g:1546:7: lv_index_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getAssignmentAccess().getIndexExpressionParserRuleCall_0_0_3_0());
                      						
                    }
                    pushFollow(FOLLOW_24);
                    lv_index_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      							}
                      							set(
                      								current,
                      								"index",
                      								lv_index_3_0,
                      								"com.minres.coredsl.CoreDsl.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,32,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getAssignmentAccess().getRightSquareBracketKeyword_0_0_4());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1569:4: ( () ( (otherlv_6= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:1569:4: ( () ( (otherlv_6= RULE_ID ) ) )
                    // InternalCoreDsl.g:1570:5: () ( (otherlv_6= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:1570:5: ()
                    // InternalCoreDsl.g:1571:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElement(
                      							grammarAccess.getAssignmentAccess().getRegisterAssignmentAction_0_1_0(),
                      							current);
                      					
                    }

                    }

                    // InternalCoreDsl.g:1577:5: ( (otherlv_6= RULE_ID ) )
                    // InternalCoreDsl.g:1578:6: (otherlv_6= RULE_ID )
                    {
                    // InternalCoreDsl.g:1578:6: (otherlv_6= RULE_ID )
                    // InternalCoreDsl.g:1579:7: otherlv_6= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getAssignmentRule());
                      							}
                      						
                    }
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_6, grammarAccess.getAssignmentAccess().getToRegisterVariableCrossReference_0_1_1_0());
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:1592:4: ( () ( (lv_to_8_0= ruleScalar ) ) )
                    {
                    // InternalCoreDsl.g:1592:4: ( () ( (lv_to_8_0= ruleScalar ) ) )
                    // InternalCoreDsl.g:1593:5: () ( (lv_to_8_0= ruleScalar ) )
                    {
                    // InternalCoreDsl.g:1593:5: ()
                    // InternalCoreDsl.g:1594:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElement(
                      							grammarAccess.getAssignmentAccess().getScalarAssignmentAction_0_2_0(),
                      							current);
                      					
                    }

                    }

                    // InternalCoreDsl.g:1600:5: ( (lv_to_8_0= ruleScalar ) )
                    // InternalCoreDsl.g:1601:6: (lv_to_8_0= ruleScalar )
                    {
                    // InternalCoreDsl.g:1601:6: (lv_to_8_0= ruleScalar )
                    // InternalCoreDsl.g:1602:7: lv_to_8_0= ruleScalar
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getAssignmentAccess().getToScalarParserRuleCall_0_2_1_0());
                      						
                    }
                    pushFollow(FOLLOW_38);
                    lv_to_8_0=ruleScalar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      							}
                      							set(
                      								current,
                      								"to",
                      								lv_to_8_0,
                      								"com.minres.coredsl.CoreDsl.Scalar");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:1621:3: ( (lv_bitWidth_9_0= ruleBitSizeSpec ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==19) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalCoreDsl.g:1622:4: (lv_bitWidth_9_0= ruleBitSizeSpec )
                    {
                    // InternalCoreDsl.g:1622:4: (lv_bitWidth_9_0= ruleBitSizeSpec )
                    // InternalCoreDsl.g:1623:5: lv_bitWidth_9_0= ruleBitSizeSpec
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAssignmentAccess().getBitWidthBitSizeSpecParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_39);
                    lv_bitWidth_9_0=ruleBitSizeSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      					}
                      					set(
                      						current,
                      						"bitWidth",
                      						lv_bitWidth_9_0,
                      						"com.minres.coredsl.CoreDsl.BitSizeSpec");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,39,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getAssignmentAccess().getLessThanSignEqualsSignKeyword_2());
              		
            }
            // InternalCoreDsl.g:1644:3: ( (lv_expression_11_0= ruleExpression ) )
            // InternalCoreDsl.g:1645:4: (lv_expression_11_0= ruleExpression )
            {
            // InternalCoreDsl.g:1645:4: (lv_expression_11_0= ruleExpression )
            // InternalCoreDsl.g:1646:5: lv_expression_11_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_expression_11_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignmentRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_11_0,
              						"com.minres.coredsl.CoreDsl.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_12=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_12, grammarAccess.getAssignmentAccess().getSemicolonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleConditionalStmt"
    // InternalCoreDsl.g:1671:1: entryRuleConditionalStmt returns [EObject current=null] : iv_ruleConditionalStmt= ruleConditionalStmt EOF ;
    public final EObject entryRuleConditionalStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalStmt = null;


        try {
            // InternalCoreDsl.g:1671:56: (iv_ruleConditionalStmt= ruleConditionalStmt EOF )
            // InternalCoreDsl.g:1672:2: iv_ruleConditionalStmt= ruleConditionalStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalStmtRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConditionalStmt=ruleConditionalStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalStmt; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalStmt"


    // $ANTLR start "ruleConditionalStmt"
    // InternalCoreDsl.g:1678:1: ruleConditionalStmt returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleBooleanOrExpr ) ) otherlv_3= ')' ( ( (lv_thenStmts_4_0= ruleStatement ) ) | (otherlv_5= '{' ( (lv_thenStmts_6_0= ruleStatement ) )+ otherlv_7= '}' ) ) ( ( ( 'else' )=>otherlv_8= 'else' ) ( ( (lv_elseStmts_9_0= ruleStatement ) ) | (otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}' ) ) )? ) ;
    public final EObject ruleConditionalStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_cond_2_0 = null;

        EObject lv_thenStmts_4_0 = null;

        EObject lv_thenStmts_6_0 = null;

        EObject lv_elseStmts_9_0 = null;

        EObject lv_elseStmts_11_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1684:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleBooleanOrExpr ) ) otherlv_3= ')' ( ( (lv_thenStmts_4_0= ruleStatement ) ) | (otherlv_5= '{' ( (lv_thenStmts_6_0= ruleStatement ) )+ otherlv_7= '}' ) ) ( ( ( 'else' )=>otherlv_8= 'else' ) ( ( (lv_elseStmts_9_0= ruleStatement ) ) | (otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}' ) ) )? ) )
            // InternalCoreDsl.g:1685:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleBooleanOrExpr ) ) otherlv_3= ')' ( ( (lv_thenStmts_4_0= ruleStatement ) ) | (otherlv_5= '{' ( (lv_thenStmts_6_0= ruleStatement ) )+ otherlv_7= '}' ) ) ( ( ( 'else' )=>otherlv_8= 'else' ) ( ( (lv_elseStmts_9_0= ruleStatement ) ) | (otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}' ) ) )? )
            {
            // InternalCoreDsl.g:1685:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleBooleanOrExpr ) ) otherlv_3= ')' ( ( (lv_thenStmts_4_0= ruleStatement ) ) | (otherlv_5= '{' ( (lv_thenStmts_6_0= ruleStatement ) )+ otherlv_7= '}' ) ) ( ( ( 'else' )=>otherlv_8= 'else' ) ( ( (lv_elseStmts_9_0= ruleStatement ) ) | (otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}' ) ) )? )
            // InternalCoreDsl.g:1686:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleBooleanOrExpr ) ) otherlv_3= ')' ( ( (lv_thenStmts_4_0= ruleStatement ) ) | (otherlv_5= '{' ( (lv_thenStmts_6_0= ruleStatement ) )+ otherlv_7= '}' ) ) ( ( ( 'else' )=>otherlv_8= 'else' ) ( ( (lv_elseStmts_9_0= ruleStatement ) ) | (otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}' ) ) )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConditionalStmtAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,33,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConditionalStmtAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalCoreDsl.g:1694:3: ( (lv_cond_2_0= ruleBooleanOrExpr ) )
            // InternalCoreDsl.g:1695:4: (lv_cond_2_0= ruleBooleanOrExpr )
            {
            // InternalCoreDsl.g:1695:4: (lv_cond_2_0= ruleBooleanOrExpr )
            // InternalCoreDsl.g:1696:5: lv_cond_2_0= ruleBooleanOrExpr
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConditionalStmtAccess().getCondBooleanOrExprParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_41);
            lv_cond_2_0=ruleBooleanOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConditionalStmtRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_2_0,
              						"com.minres.coredsl.CoreDsl.BooleanOrExpr");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,34,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConditionalStmtAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalCoreDsl.g:1717:3: ( ( (lv_thenStmts_4_0= ruleStatement ) ) | (otherlv_5= '{' ( (lv_thenStmts_6_0= ruleStatement ) )+ otherlv_7= '}' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID||LA42_0==RULE_PROCEDURENAME||LA42_0==40||LA42_0==42||LA42_0==46) ) {
                alt42=1;
            }
            else if ( (LA42_0==19) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalCoreDsl.g:1718:4: ( (lv_thenStmts_4_0= ruleStatement ) )
                    {
                    // InternalCoreDsl.g:1718:4: ( (lv_thenStmts_4_0= ruleStatement ) )
                    // InternalCoreDsl.g:1719:5: (lv_thenStmts_4_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1719:5: (lv_thenStmts_4_0= ruleStatement )
                    // InternalCoreDsl.g:1720:6: lv_thenStmts_4_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalStmtAccess().getThenStmtsStatementParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
                    lv_thenStmts_4_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalStmtRule());
                      						}
                      						add(
                      							current,
                      							"thenStmts",
                      							lv_thenStmts_4_0,
                      							"com.minres.coredsl.CoreDsl.Statement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1738:4: (otherlv_5= '{' ( (lv_thenStmts_6_0= ruleStatement ) )+ otherlv_7= '}' )
                    {
                    // InternalCoreDsl.g:1738:4: (otherlv_5= '{' ( (lv_thenStmts_6_0= ruleStatement ) )+ otherlv_7= '}' )
                    // InternalCoreDsl.g:1739:5: otherlv_5= '{' ( (lv_thenStmts_6_0= ruleStatement ) )+ otherlv_7= '}'
                    {
                    otherlv_5=(Token)match(input,19,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getConditionalStmtAccess().getLeftCurlyBracketKeyword_4_1_0());
                      				
                    }
                    // InternalCoreDsl.g:1743:5: ( (lv_thenStmts_6_0= ruleStatement ) )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==RULE_ID||LA41_0==RULE_PROCEDURENAME||LA41_0==40||LA41_0==42||LA41_0==46) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalCoreDsl.g:1744:6: (lv_thenStmts_6_0= ruleStatement )
                    	    {
                    	    // InternalCoreDsl.g:1744:6: (lv_thenStmts_6_0= ruleStatement )
                    	    // InternalCoreDsl.g:1745:7: lv_thenStmts_6_0= ruleStatement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getConditionalStmtAccess().getThenStmtsStatementParserRuleCall_4_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_31);
                    	    lv_thenStmts_6_0=ruleStatement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getConditionalStmtRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"thenStmts",
                    	      								lv_thenStmts_6_0,
                    	      								"com.minres.coredsl.CoreDsl.Statement");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt41 >= 1 ) break loop41;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);

                    otherlv_7=(Token)match(input,22,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getConditionalStmtAccess().getRightCurlyBracketKeyword_4_1_2());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:1768:3: ( ( ( 'else' )=>otherlv_8= 'else' ) ( ( (lv_elseStmts_9_0= ruleStatement ) ) | (otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}' ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==41) ) {
                int LA45_1 = input.LA(2);

                if ( (synpred1_InternalCoreDsl()) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // InternalCoreDsl.g:1769:4: ( ( 'else' )=>otherlv_8= 'else' ) ( ( (lv_elseStmts_9_0= ruleStatement ) ) | (otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}' ) )
                    {
                    // InternalCoreDsl.g:1769:4: ( ( 'else' )=>otherlv_8= 'else' )
                    // InternalCoreDsl.g:1770:5: ( 'else' )=>otherlv_8= 'else'
                    {
                    otherlv_8=(Token)match(input,41,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getConditionalStmtAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalCoreDsl.g:1776:4: ( ( (lv_elseStmts_9_0= ruleStatement ) ) | (otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}' ) )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==RULE_ID||LA44_0==RULE_PROCEDURENAME||LA44_0==40||LA44_0==42||LA44_0==46) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==19) ) {
                        alt44=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalCoreDsl.g:1777:5: ( (lv_elseStmts_9_0= ruleStatement ) )
                            {
                            // InternalCoreDsl.g:1777:5: ( (lv_elseStmts_9_0= ruleStatement ) )
                            // InternalCoreDsl.g:1778:6: (lv_elseStmts_9_0= ruleStatement )
                            {
                            // InternalCoreDsl.g:1778:6: (lv_elseStmts_9_0= ruleStatement )
                            // InternalCoreDsl.g:1779:7: lv_elseStmts_9_0= ruleStatement
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getConditionalStmtAccess().getElseStmtsStatementParserRuleCall_5_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_elseStmts_9_0=ruleStatement();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getConditionalStmtRule());
                              							}
                              							add(
                              								current,
                              								"elseStmts",
                              								lv_elseStmts_9_0,
                              								"com.minres.coredsl.CoreDsl.Statement");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:1797:5: (otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}' )
                            {
                            // InternalCoreDsl.g:1797:5: (otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}' )
                            // InternalCoreDsl.g:1798:6: otherlv_10= '{' ( (lv_elseStmts_11_0= ruleStatement ) )+ otherlv_12= '}'
                            {
                            otherlv_10=(Token)match(input,19,FOLLOW_44); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_10, grammarAccess.getConditionalStmtAccess().getLeftCurlyBracketKeyword_5_1_1_0());
                              					
                            }
                            // InternalCoreDsl.g:1802:6: ( (lv_elseStmts_11_0= ruleStatement ) )+
                            int cnt43=0;
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==RULE_ID||LA43_0==RULE_PROCEDURENAME||LA43_0==40||LA43_0==42||LA43_0==46) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // InternalCoreDsl.g:1803:7: (lv_elseStmts_11_0= ruleStatement )
                            	    {
                            	    // InternalCoreDsl.g:1803:7: (lv_elseStmts_11_0= ruleStatement )
                            	    // InternalCoreDsl.g:1804:8: lv_elseStmts_11_0= ruleStatement
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getConditionalStmtAccess().getElseStmtsStatementParserRuleCall_5_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_31);
                            	    lv_elseStmts_11_0=ruleStatement();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getConditionalStmtRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"elseStmts",
                            	      									lv_elseStmts_11_0,
                            	      									"com.minres.coredsl.CoreDsl.Statement");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt43 >= 1 ) break loop43;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(43, input);
                                        throw eee;
                                }
                                cnt43++;
                            } while (true);

                            otherlv_12=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_12, grammarAccess.getConditionalStmtAccess().getRightCurlyBracketKeyword_5_1_1_2());
                              					
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalStmt"


    // $ANTLR start "entryRuleDirectCode"
    // InternalCoreDsl.g:1832:1: entryRuleDirectCode returns [EObject current=null] : iv_ruleDirectCode= ruleDirectCode EOF ;
    public final EObject entryRuleDirectCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectCode = null;


        try {
            // InternalCoreDsl.g:1832:51: (iv_ruleDirectCode= ruleDirectCode EOF )
            // InternalCoreDsl.g:1833:2: iv_ruleDirectCode= ruleDirectCode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectCodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDirectCode=ruleDirectCode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectCode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDirectCode"


    // $ANTLR start "ruleDirectCode"
    // InternalCoreDsl.g:1839:1: ruleDirectCode returns [EObject current=null] : (otherlv_0= 'C++' otherlv_1= '{' ( (lv_code_2_0= RULE_STRING ) ) ( (lv_code_3_0= RULE_STRING ) )* otherlv_4= '}' ) ;
    public final EObject ruleDirectCode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_code_2_0=null;
        Token lv_code_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:1845:2: ( (otherlv_0= 'C++' otherlv_1= '{' ( (lv_code_2_0= RULE_STRING ) ) ( (lv_code_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            // InternalCoreDsl.g:1846:2: (otherlv_0= 'C++' otherlv_1= '{' ( (lv_code_2_0= RULE_STRING ) ) ( (lv_code_3_0= RULE_STRING ) )* otherlv_4= '}' )
            {
            // InternalCoreDsl.g:1846:2: (otherlv_0= 'C++' otherlv_1= '{' ( (lv_code_2_0= RULE_STRING ) ) ( (lv_code_3_0= RULE_STRING ) )* otherlv_4= '}' )
            // InternalCoreDsl.g:1847:3: otherlv_0= 'C++' otherlv_1= '{' ( (lv_code_2_0= RULE_STRING ) ) ( (lv_code_3_0= RULE_STRING ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDirectCodeAccess().getCKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,19,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDirectCodeAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalCoreDsl.g:1855:3: ( (lv_code_2_0= RULE_STRING ) )
            // InternalCoreDsl.g:1856:4: (lv_code_2_0= RULE_STRING )
            {
            // InternalCoreDsl.g:1856:4: (lv_code_2_0= RULE_STRING )
            // InternalCoreDsl.g:1857:5: lv_code_2_0= RULE_STRING
            {
            lv_code_2_0=(Token)match(input,RULE_STRING,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_code_2_0, grammarAccess.getDirectCodeAccess().getCodeSTRINGTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDirectCodeRule());
              					}
              					addWithLastConsumed(
              						current,
              						"code",
              						lv_code_2_0,
              						"com.minres.coredsl.CoreDsl.STRING");
              				
            }

            }


            }

            // InternalCoreDsl.g:1873:3: ( (lv_code_3_0= RULE_STRING ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_STRING) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalCoreDsl.g:1874:4: (lv_code_3_0= RULE_STRING )
            	    {
            	    // InternalCoreDsl.g:1874:4: (lv_code_3_0= RULE_STRING )
            	    // InternalCoreDsl.g:1875:5: lv_code_3_0= RULE_STRING
            	    {
            	    lv_code_3_0=(Token)match(input,RULE_STRING,FOLLOW_45); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(lv_code_3_0, grammarAccess.getDirectCodeAccess().getCodeSTRINGTerminalRuleCall_3_0());
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElement(grammarAccess.getDirectCodeRule());
            	      					}
            	      					addWithLastConsumed(
            	      						current,
            	      						"code",
            	      						lv_code_3_0,
            	      						"com.minres.coredsl.CoreDsl.STRING");
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getDirectCodeAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirectCode"


    // $ANTLR start "entryRuleProcedure"
    // InternalCoreDsl.g:1899:1: entryRuleProcedure returns [EObject current=null] : iv_ruleProcedure= ruleProcedure EOF ;
    public final EObject entryRuleProcedure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcedure = null;


        try {
            // InternalCoreDsl.g:1899:50: (iv_ruleProcedure= ruleProcedure EOF )
            // InternalCoreDsl.g:1900:2: iv_ruleProcedure= ruleProcedure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcedureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcedure=ruleProcedure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcedure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcedure"


    // $ANTLR start "ruleProcedure"
    // InternalCoreDsl.g:1906:1: ruleProcedure returns [EObject current=null] : ( ( (lv_name_0_0= RULE_PROCEDURENAME ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
    public final EObject ruleProcedure() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1912:2: ( ( ( (lv_name_0_0= RULE_PROCEDURENAME ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalCoreDsl.g:1913:2: ( ( (lv_name_0_0= RULE_PROCEDURENAME ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalCoreDsl.g:1913:2: ( ( (lv_name_0_0= RULE_PROCEDURENAME ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalCoreDsl.g:1914:3: ( (lv_name_0_0= RULE_PROCEDURENAME ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            // InternalCoreDsl.g:1914:3: ( (lv_name_0_0= RULE_PROCEDURENAME ) )
            // InternalCoreDsl.g:1915:4: (lv_name_0_0= RULE_PROCEDURENAME )
            {
            // InternalCoreDsl.g:1915:4: (lv_name_0_0= RULE_PROCEDURENAME )
            // InternalCoreDsl.g:1916:5: lv_name_0_0= RULE_PROCEDURENAME
            {
            lv_name_0_0=(Token)match(input,RULE_PROCEDURENAME,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getProcedureAccess().getNamePROCEDURENAMETerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProcedureRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"com.minres.coredsl.CoreDsl.PROCEDURENAME");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getProcedureAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalCoreDsl.g:1936:3: ( (lv_args_2_0= ruleExpression ) )
            // InternalCoreDsl.g:1937:4: (lv_args_2_0= ruleExpression )
            {
            // InternalCoreDsl.g:1937:4: (lv_args_2_0= ruleExpression )
            // InternalCoreDsl.g:1938:5: lv_args_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProcedureAccess().getArgsExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_args_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProcedureRule());
              					}
              					add(
              						current,
              						"args",
              						lv_args_2_0,
              						"com.minres.coredsl.CoreDsl.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:1955:3: (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==21) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalCoreDsl.g:1956:4: otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,21,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getProcedureAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:1960:4: ( (lv_args_4_0= ruleExpression ) )
            	    // InternalCoreDsl.g:1961:5: (lv_args_4_0= ruleExpression )
            	    {
            	    // InternalCoreDsl.g:1961:5: (lv_args_4_0= ruleExpression )
            	    // InternalCoreDsl.g:1962:6: lv_args_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProcedureAccess().getArgsExpressionParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
            	    lv_args_4_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProcedureRule());
            	      						}
            	      						add(
            	      							current,
            	      							"args",
            	      							lv_args_4_0,
            	      							"com.minres.coredsl.CoreDsl.Expression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            otherlv_5=(Token)match(input,34,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getProcedureAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_6=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getProcedureAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcedure"


    // $ANTLR start "entryRuleConstant"
    // InternalCoreDsl.g:1992:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalCoreDsl.g:1992:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalCoreDsl.g:1993:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalCoreDsl.g:1999:1: ruleConstant returns [EObject current=null] : (this_ConstantDef_0= ruleConstantDef | this_ConstantDecl_1= ruleConstantDecl ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantDef_0 = null;

        EObject this_ConstantDecl_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2005:2: ( (this_ConstantDef_0= ruleConstantDef | this_ConstantDecl_1= ruleConstantDecl ) )
            // InternalCoreDsl.g:2006:2: (this_ConstantDef_0= ruleConstantDef | this_ConstantDecl_1= ruleConstantDecl )
            {
            // InternalCoreDsl.g:2006:2: (this_ConstantDef_0= ruleConstantDef | this_ConstantDecl_1= ruleConstantDecl )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==43) ) {
                    int LA48_2 = input.LA(3);

                    if ( (LA48_2==RULE_NATURAL) ) {
                        int LA48_4 = input.LA(4);

                        if ( (LA48_4==30||LA48_4==33) ) {
                            alt48=1;
                        }
                        else if ( (LA48_4==EOF) ) {
                            alt48=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 48, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA48_1==EOF) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalCoreDsl.g:2007:3: this_ConstantDef_0= ruleConstantDef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantAccess().getConstantDefParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConstantDef_0=ruleConstantDef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConstantDef_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2016:3: this_ConstantDecl_1= ruleConstantDecl
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantAccess().getConstantDeclParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConstantDecl_1=ruleConstantDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConstantDecl_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleConstantDef"
    // InternalCoreDsl.g:2028:1: entryRuleConstantDef returns [EObject current=null] : iv_ruleConstantDef= ruleConstantDef EOF ;
    public final EObject entryRuleConstantDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDef = null;


        try {
            // InternalCoreDsl.g:2028:52: (iv_ruleConstantDef= ruleConstantDef EOF )
            // InternalCoreDsl.g:2029:2: iv_ruleConstantDef= ruleConstantDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantDef=ruleConstantDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantDef"


    // $ANTLR start "ruleConstantDef"
    // InternalCoreDsl.g:2035:1: ruleConstantDef returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_value_2_0= RULE_NATURAL ) ) (otherlv_3= '(' ( (lv_attributes_4_0= ruleConstAttribute ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleConstAttribute ) ) )* otherlv_7= ')' )? otherlv_8= ';' ) ;
    public final EObject ruleConstantDef() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Enumerator lv_attributes_4_0 = null;

        Enumerator lv_attributes_6_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2041:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_value_2_0= RULE_NATURAL ) ) (otherlv_3= '(' ( (lv_attributes_4_0= ruleConstAttribute ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleConstAttribute ) ) )* otherlv_7= ')' )? otherlv_8= ';' ) )
            // InternalCoreDsl.g:2042:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_value_2_0= RULE_NATURAL ) ) (otherlv_3= '(' ( (lv_attributes_4_0= ruleConstAttribute ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleConstAttribute ) ) )* otherlv_7= ')' )? otherlv_8= ';' )
            {
            // InternalCoreDsl.g:2042:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_value_2_0= RULE_NATURAL ) ) (otherlv_3= '(' ( (lv_attributes_4_0= ruleConstAttribute ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleConstAttribute ) ) )* otherlv_7= ')' )? otherlv_8= ';' )
            // InternalCoreDsl.g:2043:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_value_2_0= RULE_NATURAL ) ) (otherlv_3= '(' ( (lv_attributes_4_0= ruleConstAttribute ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleConstAttribute ) ) )* otherlv_7= ')' )? otherlv_8= ';'
            {
            // InternalCoreDsl.g:2043:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:2044:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:2044:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:2045:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getConstantDefAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstantDefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,43,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstantDefAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalCoreDsl.g:2065:3: ( (lv_value_2_0= RULE_NATURAL ) )
            // InternalCoreDsl.g:2066:4: (lv_value_2_0= RULE_NATURAL )
            {
            // InternalCoreDsl.g:2066:4: (lv_value_2_0= RULE_NATURAL )
            // InternalCoreDsl.g:2067:5: lv_value_2_0= RULE_NATURAL
            {
            lv_value_2_0=(Token)match(input,RULE_NATURAL,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_2_0, grammarAccess.getConstantDefAccess().getValueNATURALTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstantDefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_2_0,
              						"com.minres.coredsl.CoreDsl.NATURAL");
              				
            }

            }


            }

            // InternalCoreDsl.g:2083:3: (otherlv_3= '(' ( (lv_attributes_4_0= ruleConstAttribute ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleConstAttribute ) ) )* otherlv_7= ')' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==33) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalCoreDsl.g:2084:4: otherlv_3= '(' ( (lv_attributes_4_0= ruleConstAttribute ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleConstAttribute ) ) )* otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getConstantDefAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalCoreDsl.g:2088:4: ( (lv_attributes_4_0= ruleConstAttribute ) )
                    // InternalCoreDsl.g:2089:5: (lv_attributes_4_0= ruleConstAttribute )
                    {
                    // InternalCoreDsl.g:2089:5: (lv_attributes_4_0= ruleConstAttribute )
                    // InternalCoreDsl.g:2090:6: lv_attributes_4_0= ruleConstAttribute
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConstantDefAccess().getAttributesConstAttributeEnumRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    lv_attributes_4_0=ruleConstAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConstantDefRule());
                      						}
                      						add(
                      							current,
                      							"attributes",
                      							lv_attributes_4_0,
                      							"com.minres.coredsl.CoreDsl.ConstAttribute");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:2107:4: (otherlv_5= ',' ( (lv_attributes_6_0= ruleConstAttribute ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==21) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2108:5: otherlv_5= ',' ( (lv_attributes_6_0= ruleConstAttribute ) )
                    	    {
                    	    otherlv_5=(Token)match(input,21,FOLLOW_48); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getConstantDefAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2112:5: ( (lv_attributes_6_0= ruleConstAttribute ) )
                    	    // InternalCoreDsl.g:2113:6: (lv_attributes_6_0= ruleConstAttribute )
                    	    {
                    	    // InternalCoreDsl.g:2113:6: (lv_attributes_6_0= ruleConstAttribute )
                    	    // InternalCoreDsl.g:2114:7: lv_attributes_6_0= ruleConstAttribute
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getConstantDefAccess().getAttributesConstAttributeEnumRuleCall_3_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_27);
                    	    lv_attributes_6_0=ruleConstAttribute();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getConstantDefRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"attributes",
                    	      								lv_attributes_6_0,
                    	      								"com.minres.coredsl.CoreDsl.ConstAttribute");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,34,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getConstantDefAccess().getRightParenthesisKeyword_3_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getConstantDefAccess().getSemicolonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantDef"


    // $ANTLR start "entryRuleConstantDecl"
    // InternalCoreDsl.g:2145:1: entryRuleConstantDecl returns [EObject current=null] : iv_ruleConstantDecl= ruleConstantDecl EOF ;
    public final EObject entryRuleConstantDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDecl = null;


        try {
            // InternalCoreDsl.g:2145:53: (iv_ruleConstantDecl= ruleConstantDecl EOF )
            // InternalCoreDsl.g:2146:2: iv_ruleConstantDecl= ruleConstantDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantDecl=ruleConstantDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantDecl; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantDecl"


    // $ANTLR start "ruleConstantDecl"
    // InternalCoreDsl.g:2152:1: ruleConstantDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_constantDefault_1_0= ruleConstantDefault ) )? ) ;
    public final EObject ruleConstantDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_constantDefault_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2158:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_constantDefault_1_0= ruleConstantDefault ) )? ) )
            // InternalCoreDsl.g:2159:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_constantDefault_1_0= ruleConstantDefault ) )? )
            {
            // InternalCoreDsl.g:2159:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_constantDefault_1_0= ruleConstantDefault ) )? )
            // InternalCoreDsl.g:2160:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_constantDefault_1_0= ruleConstantDefault ) )?
            {
            // InternalCoreDsl.g:2160:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:2161:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:2161:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:2162:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getConstantDeclAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstantDeclRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            // InternalCoreDsl.g:2178:3: ( (lv_constantDefault_1_0= ruleConstantDefault ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==43) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalCoreDsl.g:2179:4: (lv_constantDefault_1_0= ruleConstantDefault )
                    {
                    // InternalCoreDsl.g:2179:4: (lv_constantDefault_1_0= ruleConstantDefault )
                    // InternalCoreDsl.g:2180:5: lv_constantDefault_1_0= ruleConstantDefault
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantDeclAccess().getConstantDefaultConstantDefaultParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_constantDefault_1_0=ruleConstantDefault();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getConstantDeclRule());
                      					}
                      					set(
                      						current,
                      						"constantDefault",
                      						lv_constantDefault_1_0,
                      						"com.minres.coredsl.CoreDsl.ConstantDefault");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantDecl"


    // $ANTLR start "entryRuleConstantDefault"
    // InternalCoreDsl.g:2201:1: entryRuleConstantDefault returns [EObject current=null] : iv_ruleConstantDefault= ruleConstantDefault EOF ;
    public final EObject entryRuleConstantDefault() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefault = null;


        try {
            // InternalCoreDsl.g:2201:56: (iv_ruleConstantDefault= ruleConstantDefault EOF )
            // InternalCoreDsl.g:2202:2: iv_ruleConstantDefault= ruleConstantDefault EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantDefaultRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantDefault=ruleConstantDefault();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantDefault; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantDefault"


    // $ANTLR start "ruleConstantDefault"
    // InternalCoreDsl.g:2208:1: ruleConstantDefault returns [EObject current=null] : (otherlv_0= ':=' ( (lv_defaultValue_1_0= RULE_NATURAL ) ) ) ;
    public final EObject ruleConstantDefault() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_defaultValue_1_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:2214:2: ( (otherlv_0= ':=' ( (lv_defaultValue_1_0= RULE_NATURAL ) ) ) )
            // InternalCoreDsl.g:2215:2: (otherlv_0= ':=' ( (lv_defaultValue_1_0= RULE_NATURAL ) ) )
            {
            // InternalCoreDsl.g:2215:2: (otherlv_0= ':=' ( (lv_defaultValue_1_0= RULE_NATURAL ) ) )
            // InternalCoreDsl.g:2216:3: otherlv_0= ':=' ( (lv_defaultValue_1_0= RULE_NATURAL ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstantDefaultAccess().getColonEqualsSignKeyword_0());
              		
            }
            // InternalCoreDsl.g:2220:3: ( (lv_defaultValue_1_0= RULE_NATURAL ) )
            // InternalCoreDsl.g:2221:4: (lv_defaultValue_1_0= RULE_NATURAL )
            {
            // InternalCoreDsl.g:2221:4: (lv_defaultValue_1_0= RULE_NATURAL )
            // InternalCoreDsl.g:2222:5: lv_defaultValue_1_0= RULE_NATURAL
            {
            lv_defaultValue_1_0=(Token)match(input,RULE_NATURAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_defaultValue_1_0, grammarAccess.getConstantDefaultAccess().getDefaultValueNATURALTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstantDefaultRule());
              					}
              					setWithLastConsumed(
              						current,
              						"defaultValue",
              						lv_defaultValue_1_0,
              						"com.minres.coredsl.CoreDsl.NATURAL");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantDefault"


    // $ANTLR start "entryRuleIndexedVariable"
    // InternalCoreDsl.g:2242:1: entryRuleIndexedVariable returns [EObject current=null] : iv_ruleIndexedVariable= ruleIndexedVariable EOF ;
    public final EObject entryRuleIndexedVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexedVariable = null;


        try {
            // InternalCoreDsl.g:2242:56: (iv_ruleIndexedVariable= ruleIndexedVariable EOF )
            // InternalCoreDsl.g:2243:2: iv_ruleIndexedVariable= ruleIndexedVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndexedVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIndexedVariable=ruleIndexedVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndexedVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndexedVariable"


    // $ANTLR start "ruleIndexedVariable"
    // InternalCoreDsl.g:2249:1: ruleIndexedVariable returns [EObject current=null] : (this_AddressSpace_0= ruleAddressSpace | this_RegisterFile_1= ruleRegisterFile ) ;
    public final EObject ruleIndexedVariable() throws RecognitionException {
        EObject current = null;

        EObject this_AddressSpace_0 = null;

        EObject this_RegisterFile_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2255:2: ( (this_AddressSpace_0= ruleAddressSpace | this_RegisterFile_1= ruleRegisterFile ) )
            // InternalCoreDsl.g:2256:2: (this_AddressSpace_0= ruleAddressSpace | this_RegisterFile_1= ruleRegisterFile )
            {
            // InternalCoreDsl.g:2256:2: (this_AddressSpace_0= ruleAddressSpace | this_RegisterFile_1= ruleRegisterFile )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                alt52=1;
            }
            else if ( (LA52_0==31) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalCoreDsl.g:2257:3: this_AddressSpace_0= ruleAddressSpace
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getIndexedVariableAccess().getAddressSpaceParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AddressSpace_0=ruleAddressSpace();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AddressSpace_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2266:3: this_RegisterFile_1= ruleRegisterFile
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getIndexedVariableAccess().getRegisterFileParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RegisterFile_1=ruleRegisterFile();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RegisterFile_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndexedVariable"


    // $ANTLR start "entryRuleScalarVariable"
    // InternalCoreDsl.g:2278:1: entryRuleScalarVariable returns [EObject current=null] : iv_ruleScalarVariable= ruleScalarVariable EOF ;
    public final EObject entryRuleScalarVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarVariable = null;


        try {
            // InternalCoreDsl.g:2278:55: (iv_ruleScalarVariable= ruleScalarVariable EOF )
            // InternalCoreDsl.g:2279:2: iv_ruleScalarVariable= ruleScalarVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScalarVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScalarVariable=ruleScalarVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScalarVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarVariable"


    // $ANTLR start "ruleScalarVariable"
    // InternalCoreDsl.g:2285:1: ruleScalarVariable returns [EObject current=null] : (this_RegisterVariable_0= ruleRegisterVariable | this_Scalar_1= ruleScalar ) ;
    public final EObject ruleScalarVariable() throws RecognitionException {
        EObject current = null;

        EObject this_RegisterVariable_0 = null;

        EObject this_Scalar_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2291:2: ( (this_RegisterVariable_0= ruleRegisterVariable | this_Scalar_1= ruleScalar ) )
            // InternalCoreDsl.g:2292:2: (this_RegisterVariable_0= ruleRegisterVariable | this_Scalar_1= ruleScalar )
            {
            // InternalCoreDsl.g:2292:2: (this_RegisterVariable_0= ruleRegisterVariable | this_Scalar_1= ruleScalar )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID||LA53_0==44) ) {
                alt53=1;
            }
            else if ( (LA53_0==46) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalCoreDsl.g:2293:3: this_RegisterVariable_0= ruleRegisterVariable
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getScalarVariableAccess().getRegisterVariableParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RegisterVariable_0=ruleRegisterVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RegisterVariable_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2302:3: this_Scalar_1= ruleScalar
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getScalarVariableAccess().getScalarParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Scalar_1=ruleScalar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Scalar_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalarVariable"


    // $ANTLR start "entryRuleRegisterVariable"
    // InternalCoreDsl.g:2314:1: entryRuleRegisterVariable returns [EObject current=null] : iv_ruleRegisterVariable= ruleRegisterVariable EOF ;
    public final EObject entryRuleRegisterVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegisterVariable = null;


        try {
            // InternalCoreDsl.g:2314:57: (iv_ruleRegisterVariable= ruleRegisterVariable EOF )
            // InternalCoreDsl.g:2315:2: iv_ruleRegisterVariable= ruleRegisterVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegisterVariable=ruleRegisterVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegisterVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegisterVariable"


    // $ANTLR start "ruleRegisterVariable"
    // InternalCoreDsl.g:2321:1: ruleRegisterVariable returns [EObject current=null] : (this_Register_0= ruleRegister | this_RegisterAlias_1= ruleRegisterAlias ) ;
    public final EObject ruleRegisterVariable() throws RecognitionException {
        EObject current = null;

        EObject this_Register_0 = null;

        EObject this_RegisterAlias_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2327:2: ( (this_Register_0= ruleRegister | this_RegisterAlias_1= ruleRegisterAlias ) )
            // InternalCoreDsl.g:2328:2: (this_Register_0= ruleRegister | this_RegisterAlias_1= ruleRegisterAlias )
            {
            // InternalCoreDsl.g:2328:2: (this_Register_0= ruleRegister | this_RegisterAlias_1= ruleRegisterAlias )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            else if ( (LA54_0==44) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalCoreDsl.g:2329:3: this_Register_0= ruleRegister
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRegisterVariableAccess().getRegisterParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Register_0=ruleRegister();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Register_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2338:3: this_RegisterAlias_1= ruleRegisterAlias
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRegisterVariableAccess().getRegisterAliasParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RegisterAlias_1=ruleRegisterAlias();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RegisterAlias_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegisterVariable"


    // $ANTLR start "entryRuleAddressSpace"
    // InternalCoreDsl.g:2350:1: entryRuleAddressSpace returns [EObject current=null] : iv_ruleAddressSpace= ruleAddressSpace EOF ;
    public final EObject entryRuleAddressSpace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddressSpace = null;


        try {
            // InternalCoreDsl.g:2350:53: (iv_ruleAddressSpace= ruleAddressSpace EOF )
            // InternalCoreDsl.g:2351:2: iv_ruleAddressSpace= ruleAddressSpace EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddressSpaceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddressSpace=ruleAddressSpace();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddressSpace; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddressSpace"


    // $ANTLR start "ruleAddressSpace"
    // InternalCoreDsl.g:2357:1: ruleAddressSpace returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ']' ) ;
    public final EObject ruleAddressSpace() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bitSize_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:2363:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ']' ) )
            // InternalCoreDsl.g:2364:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ']' )
            {
            // InternalCoreDsl.g:2364:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ']' )
            // InternalCoreDsl.g:2365:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ']'
            {
            // InternalCoreDsl.g:2365:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:2366:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:2366:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:2367:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getAddressSpaceAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAddressSpaceRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAddressSpaceAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalCoreDsl.g:2387:3: ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_NATURAL) ) {
                alt55=1;
            }
            else if ( (LA55_0==RULE_ID) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalCoreDsl.g:2388:4: ( (lv_bitSize_2_0= RULE_NATURAL ) )
                    {
                    // InternalCoreDsl.g:2388:4: ( (lv_bitSize_2_0= RULE_NATURAL ) )
                    // InternalCoreDsl.g:2389:5: (lv_bitSize_2_0= RULE_NATURAL )
                    {
                    // InternalCoreDsl.g:2389:5: (lv_bitSize_2_0= RULE_NATURAL )
                    // InternalCoreDsl.g:2390:6: lv_bitSize_2_0= RULE_NATURAL
                    {
                    lv_bitSize_2_0=(Token)match(input,RULE_NATURAL,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_bitSize_2_0, grammarAccess.getAddressSpaceAccess().getBitSizeNATURALTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddressSpaceRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"bitSize",
                      							lv_bitSize_2_0,
                      							"com.minres.coredsl.CoreDsl.NATURAL");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2407:4: ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:2407:4: ( (otherlv_3= RULE_ID ) )
                    // InternalCoreDsl.g:2408:5: (otherlv_3= RULE_ID )
                    {
                    // InternalCoreDsl.g:2408:5: (otherlv_3= RULE_ID )
                    // InternalCoreDsl.g:2409:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddressSpaceRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getAddressSpaceAccess().getBitSizeConstConstantCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getAddressSpaceAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddressSpace"


    // $ANTLR start "entryRuleRegisterFile"
    // InternalCoreDsl.g:2429:1: entryRuleRegisterFile returns [EObject current=null] : iv_ruleRegisterFile= ruleRegisterFile EOF ;
    public final EObject entryRuleRegisterFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegisterFile = null;


        try {
            // InternalCoreDsl.g:2429:53: (iv_ruleRegisterFile= ruleRegisterFile EOF )
            // InternalCoreDsl.g:2430:2: iv_ruleRegisterFile= ruleRegisterFile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterFileRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegisterFile=ruleRegisterFile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegisterFile; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegisterFile"


    // $ANTLR start "ruleRegisterFile"
    // InternalCoreDsl.g:2436:1: ruleRegisterFile returns [EObject current=null] : ( ( ( ( '[' )=> (lv_range_0_0= ruleRangeSpec ) ) ( (lv_name_1_0= RULE_ID ) ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )? ) ;
    public final EObject ruleRegisterFile() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_bitSize_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_range_0_0 = null;

        Enumerator lv_attributes_7_0 = null;

        Enumerator lv_attributes_9_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2442:2: ( ( ( ( ( '[' )=> (lv_range_0_0= ruleRangeSpec ) ) ( (lv_name_1_0= RULE_ID ) ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )? ) )
            // InternalCoreDsl.g:2443:2: ( ( ( ( '[' )=> (lv_range_0_0= ruleRangeSpec ) ) ( (lv_name_1_0= RULE_ID ) ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )? )
            {
            // InternalCoreDsl.g:2443:2: ( ( ( ( '[' )=> (lv_range_0_0= ruleRangeSpec ) ) ( (lv_name_1_0= RULE_ID ) ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )? )
            // InternalCoreDsl.g:2444:3: ( ( ( '[' )=> (lv_range_0_0= ruleRangeSpec ) ) ( (lv_name_1_0= RULE_ID ) ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )?
            {
            // InternalCoreDsl.g:2444:3: ( ( ( '[' )=> (lv_range_0_0= ruleRangeSpec ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalCoreDsl.g:2445:4: ( ( '[' )=> (lv_range_0_0= ruleRangeSpec ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalCoreDsl.g:2445:4: ( ( '[' )=> (lv_range_0_0= ruleRangeSpec ) )
            // InternalCoreDsl.g:2446:5: ( '[' )=> (lv_range_0_0= ruleRangeSpec )
            {
            // InternalCoreDsl.g:2447:5: (lv_range_0_0= ruleRangeSpec )
            // InternalCoreDsl.g:2448:6: lv_range_0_0= ruleRangeSpec
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getRegisterFileAccess().getRangeRangeSpecParserRuleCall_0_0_0());
              					
            }
            pushFollow(FOLLOW_6);
            lv_range_0_0=ruleRangeSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getRegisterFileRule());
              						}
              						set(
              							current,
              							"range",
              							lv_range_0_0,
              							"com.minres.coredsl.CoreDsl.RangeSpec");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            // InternalCoreDsl.g:2465:4: ( (lv_name_1_0= RULE_ID ) )
            // InternalCoreDsl.g:2466:5: (lv_name_1_0= RULE_ID )
            {
            // InternalCoreDsl.g:2466:5: (lv_name_1_0= RULE_ID )
            // InternalCoreDsl.g:2467:6: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(lv_name_1_0, grammarAccess.getRegisterFileAccess().getNameIDTerminalRuleCall_0_1_0());
              					
            }
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getRegisterFileRule());
              						}
              						setWithLastConsumed(
              							current,
              							"name",
              							lv_name_1_0,
              							"com.minres.coredsl.CoreDsl.ID");
              					
            }

            }


            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRegisterFileAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalCoreDsl.g:2488:3: ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_NATURAL) ) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_ID) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalCoreDsl.g:2489:4: ( (lv_bitSize_3_0= RULE_NATURAL ) )
                    {
                    // InternalCoreDsl.g:2489:4: ( (lv_bitSize_3_0= RULE_NATURAL ) )
                    // InternalCoreDsl.g:2490:5: (lv_bitSize_3_0= RULE_NATURAL )
                    {
                    // InternalCoreDsl.g:2490:5: (lv_bitSize_3_0= RULE_NATURAL )
                    // InternalCoreDsl.g:2491:6: lv_bitSize_3_0= RULE_NATURAL
                    {
                    lv_bitSize_3_0=(Token)match(input,RULE_NATURAL,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_bitSize_3_0, grammarAccess.getRegisterFileAccess().getBitSizeNATURALTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRegisterFileRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"bitSize",
                      							lv_bitSize_3_0,
                      							"com.minres.coredsl.CoreDsl.NATURAL");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2508:4: ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:2508:4: ( (otherlv_4= RULE_ID ) )
                    // InternalCoreDsl.g:2509:5: (otherlv_4= RULE_ID )
                    {
                    // InternalCoreDsl.g:2509:5: (otherlv_4= RULE_ID )
                    // InternalCoreDsl.g:2510:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRegisterFileRule());
                      						}
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_4, grammarAccess.getRegisterFileAccess().getBitSizeConstConstantCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,32,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRegisterFileAccess().getRightSquareBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:2526:3: (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==33) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalCoreDsl.g:2527:4: otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getRegisterFileAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    // InternalCoreDsl.g:2531:4: ( (lv_attributes_7_0= ruleRegAttribute ) )
                    // InternalCoreDsl.g:2532:5: (lv_attributes_7_0= ruleRegAttribute )
                    {
                    // InternalCoreDsl.g:2532:5: (lv_attributes_7_0= ruleRegAttribute )
                    // InternalCoreDsl.g:2533:6: lv_attributes_7_0= ruleRegAttribute
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRegisterFileAccess().getAttributesRegAttributeEnumRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    lv_attributes_7_0=ruleRegAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRegisterFileRule());
                      						}
                      						add(
                      							current,
                      							"attributes",
                      							lv_attributes_7_0,
                      							"com.minres.coredsl.CoreDsl.RegAttribute");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:2550:4: (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==21) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2551:5: otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) )
                    	    {
                    	    otherlv_8=(Token)match(input,21,FOLLOW_52); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getRegisterFileAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2555:5: ( (lv_attributes_9_0= ruleRegAttribute ) )
                    	    // InternalCoreDsl.g:2556:6: (lv_attributes_9_0= ruleRegAttribute )
                    	    {
                    	    // InternalCoreDsl.g:2556:6: (lv_attributes_9_0= ruleRegAttribute )
                    	    // InternalCoreDsl.g:2557:7: lv_attributes_9_0= ruleRegAttribute
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRegisterFileAccess().getAttributesRegAttributeEnumRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_27);
                    	    lv_attributes_9_0=ruleRegAttribute();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getRegisterFileRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"attributes",
                    	      								lv_attributes_9_0,
                    	      								"com.minres.coredsl.CoreDsl.RegAttribute");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getRegisterFileAccess().getRightParenthesisKeyword_4_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegisterFile"


    // $ANTLR start "entryRuleRegister"
    // InternalCoreDsl.g:2584:1: entryRuleRegister returns [EObject current=null] : iv_ruleRegister= ruleRegister EOF ;
    public final EObject entryRuleRegister() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegister = null;


        try {
            // InternalCoreDsl.g:2584:49: (iv_ruleRegister= ruleRegister EOF )
            // InternalCoreDsl.g:2585:2: iv_ruleRegister= ruleRegister EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegister=ruleRegister();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegister; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegister"


    // $ANTLR start "ruleRegister"
    // InternalCoreDsl.g:2591:1: ruleRegister returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ']' (otherlv_5= '(' ( (lv_attributes_6_0= ruleRegAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleRegAttribute ) ) )* otherlv_9= ')' )? ) ;
    public final EObject ruleRegister() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bitSize_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_attributes_6_0 = null;

        Enumerator lv_attributes_8_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2597:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ']' (otherlv_5= '(' ( (lv_attributes_6_0= ruleRegAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleRegAttribute ) ) )* otherlv_9= ')' )? ) )
            // InternalCoreDsl.g:2598:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ']' (otherlv_5= '(' ( (lv_attributes_6_0= ruleRegAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleRegAttribute ) ) )* otherlv_9= ')' )? )
            {
            // InternalCoreDsl.g:2598:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ']' (otherlv_5= '(' ( (lv_attributes_6_0= ruleRegAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleRegAttribute ) ) )* otherlv_9= ')' )? )
            // InternalCoreDsl.g:2599:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ']' (otherlv_5= '(' ( (lv_attributes_6_0= ruleRegAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleRegAttribute ) ) )* otherlv_9= ')' )?
            {
            // InternalCoreDsl.g:2599:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:2600:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:2600:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:2601:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getRegisterAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRegisterAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalCoreDsl.g:2621:3: ( ( (lv_bitSize_2_0= RULE_NATURAL ) ) | ( (otherlv_3= RULE_ID ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_NATURAL) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_ID) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalCoreDsl.g:2622:4: ( (lv_bitSize_2_0= RULE_NATURAL ) )
                    {
                    // InternalCoreDsl.g:2622:4: ( (lv_bitSize_2_0= RULE_NATURAL ) )
                    // InternalCoreDsl.g:2623:5: (lv_bitSize_2_0= RULE_NATURAL )
                    {
                    // InternalCoreDsl.g:2623:5: (lv_bitSize_2_0= RULE_NATURAL )
                    // InternalCoreDsl.g:2624:6: lv_bitSize_2_0= RULE_NATURAL
                    {
                    lv_bitSize_2_0=(Token)match(input,RULE_NATURAL,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_bitSize_2_0, grammarAccess.getRegisterAccess().getBitSizeNATURALTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRegisterRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"bitSize",
                      							lv_bitSize_2_0,
                      							"com.minres.coredsl.CoreDsl.NATURAL");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2641:4: ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:2641:4: ( (otherlv_3= RULE_ID ) )
                    // InternalCoreDsl.g:2642:5: (otherlv_3= RULE_ID )
                    {
                    // InternalCoreDsl.g:2642:5: (otherlv_3= RULE_ID )
                    // InternalCoreDsl.g:2643:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRegisterRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getRegisterAccess().getBitSizeConstConstantCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,32,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRegisterAccess().getRightSquareBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:2659:3: (otherlv_5= '(' ( (lv_attributes_6_0= ruleRegAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleRegAttribute ) ) )* otherlv_9= ')' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==33) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalCoreDsl.g:2660:4: otherlv_5= '(' ( (lv_attributes_6_0= ruleRegAttribute ) ) (otherlv_7= ',' ( (lv_attributes_8_0= ruleRegAttribute ) ) )* otherlv_9= ')'
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getRegisterAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    // InternalCoreDsl.g:2664:4: ( (lv_attributes_6_0= ruleRegAttribute ) )
                    // InternalCoreDsl.g:2665:5: (lv_attributes_6_0= ruleRegAttribute )
                    {
                    // InternalCoreDsl.g:2665:5: (lv_attributes_6_0= ruleRegAttribute )
                    // InternalCoreDsl.g:2666:6: lv_attributes_6_0= ruleRegAttribute
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRegisterAccess().getAttributesRegAttributeEnumRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    lv_attributes_6_0=ruleRegAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRegisterRule());
                      						}
                      						add(
                      							current,
                      							"attributes",
                      							lv_attributes_6_0,
                      							"com.minres.coredsl.CoreDsl.RegAttribute");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:2683:4: (otherlv_7= ',' ( (lv_attributes_8_0= ruleRegAttribute ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==21) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2684:5: otherlv_7= ',' ( (lv_attributes_8_0= ruleRegAttribute ) )
                    	    {
                    	    otherlv_7=(Token)match(input,21,FOLLOW_52); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_7, grammarAccess.getRegisterAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2688:5: ( (lv_attributes_8_0= ruleRegAttribute ) )
                    	    // InternalCoreDsl.g:2689:6: (lv_attributes_8_0= ruleRegAttribute )
                    	    {
                    	    // InternalCoreDsl.g:2689:6: (lv_attributes_8_0= ruleRegAttribute )
                    	    // InternalCoreDsl.g:2690:7: lv_attributes_8_0= ruleRegAttribute
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRegisterAccess().getAttributesRegAttributeEnumRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_27);
                    	    lv_attributes_8_0=ruleRegAttribute();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getRegisterRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"attributes",
                    	      								lv_attributes_8_0,
                    	      								"com.minres.coredsl.CoreDsl.RegAttribute");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getRegisterAccess().getRightParenthesisKeyword_4_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegister"


    // $ANTLR start "entryRuleRegisterAlias"
    // InternalCoreDsl.g:2717:1: entryRuleRegisterAlias returns [EObject current=null] : iv_ruleRegisterAlias= ruleRegisterAlias EOF ;
    public final EObject entryRuleRegisterAlias() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegisterAlias = null;


        try {
            // InternalCoreDsl.g:2717:54: (iv_ruleRegisterAlias= ruleRegisterAlias EOF )
            // InternalCoreDsl.g:2718:2: iv_ruleRegisterAlias= ruleRegisterAlias EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterAliasRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegisterAlias=ruleRegisterAlias();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegisterAlias; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegisterAlias"


    // $ANTLR start "ruleRegisterAlias"
    // InternalCoreDsl.g:2724:1: ruleRegisterAlias returns [EObject current=null] : (otherlv_0= 'alias' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )? otherlv_11= 'is' ( ( (otherlv_12= RULE_ID ) ) | ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '[' ( ( (lv_index_15_0= ruleNumberLiteral ) ) | ( (lv_index_16_0= ruleValueRef ) ) ) otherlv_17= ']' ) ) ) ;
    public final EObject ruleRegisterAlias() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_bitSize_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_17=null;
        Enumerator lv_attributes_7_0 = null;

        Enumerator lv_attributes_9_0 = null;

        EObject lv_index_15_0 = null;

        EObject lv_index_16_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2730:2: ( (otherlv_0= 'alias' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )? otherlv_11= 'is' ( ( (otherlv_12= RULE_ID ) ) | ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '[' ( ( (lv_index_15_0= ruleNumberLiteral ) ) | ( (lv_index_16_0= ruleValueRef ) ) ) otherlv_17= ']' ) ) ) )
            // InternalCoreDsl.g:2731:2: (otherlv_0= 'alias' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )? otherlv_11= 'is' ( ( (otherlv_12= RULE_ID ) ) | ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '[' ( ( (lv_index_15_0= ruleNumberLiteral ) ) | ( (lv_index_16_0= ruleValueRef ) ) ) otherlv_17= ']' ) ) )
            {
            // InternalCoreDsl.g:2731:2: (otherlv_0= 'alias' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )? otherlv_11= 'is' ( ( (otherlv_12= RULE_ID ) ) | ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '[' ( ( (lv_index_15_0= ruleNumberLiteral ) ) | ( (lv_index_16_0= ruleValueRef ) ) ) otherlv_17= ']' ) ) )
            // InternalCoreDsl.g:2732:3: otherlv_0= 'alias' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )? otherlv_11= 'is' ( ( (otherlv_12= RULE_ID ) ) | ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '[' ( ( (lv_index_15_0= ruleNumberLiteral ) ) | ( (lv_index_16_0= ruleValueRef ) ) ) otherlv_17= ']' ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRegisterAliasAccess().getAliasKeyword_0());
              		
            }
            // InternalCoreDsl.g:2736:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalCoreDsl.g:2737:4: (lv_name_1_0= RULE_ID )
            {
            // InternalCoreDsl.g:2737:4: (lv_name_1_0= RULE_ID )
            // InternalCoreDsl.g:2738:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRegisterAliasAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterAliasRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRegisterAliasAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalCoreDsl.g:2758:3: ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_NATURAL) ) {
                alt62=1;
            }
            else if ( (LA62_0==RULE_ID) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalCoreDsl.g:2759:4: ( (lv_bitSize_3_0= RULE_NATURAL ) )
                    {
                    // InternalCoreDsl.g:2759:4: ( (lv_bitSize_3_0= RULE_NATURAL ) )
                    // InternalCoreDsl.g:2760:5: (lv_bitSize_3_0= RULE_NATURAL )
                    {
                    // InternalCoreDsl.g:2760:5: (lv_bitSize_3_0= RULE_NATURAL )
                    // InternalCoreDsl.g:2761:6: lv_bitSize_3_0= RULE_NATURAL
                    {
                    lv_bitSize_3_0=(Token)match(input,RULE_NATURAL,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_bitSize_3_0, grammarAccess.getRegisterAliasAccess().getBitSizeNATURALTerminalRuleCall_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRegisterAliasRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"bitSize",
                      							lv_bitSize_3_0,
                      							"com.minres.coredsl.CoreDsl.NATURAL");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2778:4: ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:2778:4: ( (otherlv_4= RULE_ID ) )
                    // InternalCoreDsl.g:2779:5: (otherlv_4= RULE_ID )
                    {
                    // InternalCoreDsl.g:2779:5: (otherlv_4= RULE_ID )
                    // InternalCoreDsl.g:2780:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRegisterAliasRule());
                      						}
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_4, grammarAccess.getRegisterAliasAccess().getBitSizeConstConstantCrossReference_3_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,32,FOLLOW_53); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRegisterAliasAccess().getRightSquareBracketKeyword_4());
              		
            }
            // InternalCoreDsl.g:2796:3: (otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==33) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalCoreDsl.g:2797:4: otherlv_6= '(' ( (lv_attributes_7_0= ruleRegAttribute ) ) (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getRegisterAliasAccess().getLeftParenthesisKeyword_5_0());
                      			
                    }
                    // InternalCoreDsl.g:2801:4: ( (lv_attributes_7_0= ruleRegAttribute ) )
                    // InternalCoreDsl.g:2802:5: (lv_attributes_7_0= ruleRegAttribute )
                    {
                    // InternalCoreDsl.g:2802:5: (lv_attributes_7_0= ruleRegAttribute )
                    // InternalCoreDsl.g:2803:6: lv_attributes_7_0= ruleRegAttribute
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRegisterAliasAccess().getAttributesRegAttributeEnumRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    lv_attributes_7_0=ruleRegAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRegisterAliasRule());
                      						}
                      						add(
                      							current,
                      							"attributes",
                      							lv_attributes_7_0,
                      							"com.minres.coredsl.CoreDsl.RegAttribute");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:2820:4: (otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==21) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2821:5: otherlv_8= ',' ( (lv_attributes_9_0= ruleRegAttribute ) )
                    	    {
                    	    otherlv_8=(Token)match(input,21,FOLLOW_52); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getRegisterAliasAccess().getCommaKeyword_5_2_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2825:5: ( (lv_attributes_9_0= ruleRegAttribute ) )
                    	    // InternalCoreDsl.g:2826:6: (lv_attributes_9_0= ruleRegAttribute )
                    	    {
                    	    // InternalCoreDsl.g:2826:6: (lv_attributes_9_0= ruleRegAttribute )
                    	    // InternalCoreDsl.g:2827:7: lv_attributes_9_0= ruleRegAttribute
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRegisterAliasAccess().getAttributesRegAttributeEnumRuleCall_5_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_27);
                    	    lv_attributes_9_0=ruleRegAttribute();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getRegisterAliasRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"attributes",
                    	      								lv_attributes_9_0,
                    	      								"com.minres.coredsl.CoreDsl.RegAttribute");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,34,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getRegisterAliasAccess().getRightParenthesisKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_11=(Token)match(input,45,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getRegisterAliasAccess().getIsKeyword_6());
              		
            }
            // InternalCoreDsl.g:2854:3: ( ( (otherlv_12= RULE_ID ) ) | ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '[' ( ( (lv_index_15_0= ruleNumberLiteral ) ) | ( (lv_index_16_0= ruleValueRef ) ) ) otherlv_17= ']' ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==EOF||(LA66_1>=21 && LA66_1<=22)) ) {
                    alt66=1;
                }
                else if ( (LA66_1==31) ) {
                    alt66=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 66, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalCoreDsl.g:2855:4: ( (otherlv_12= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:2855:4: ( (otherlv_12= RULE_ID ) )
                    // InternalCoreDsl.g:2856:5: (otherlv_12= RULE_ID )
                    {
                    // InternalCoreDsl.g:2856:5: (otherlv_12= RULE_ID )
                    // InternalCoreDsl.g:2857:6: otherlv_12= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRegisterAliasRule());
                      						}
                      					
                    }
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_12, grammarAccess.getRegisterAliasAccess().getOriginalRegisterCrossReference_7_0_0());
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2869:4: ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '[' ( ( (lv_index_15_0= ruleNumberLiteral ) ) | ( (lv_index_16_0= ruleValueRef ) ) ) otherlv_17= ']' )
                    {
                    // InternalCoreDsl.g:2869:4: ( ( (otherlv_13= RULE_ID ) ) otherlv_14= '[' ( ( (lv_index_15_0= ruleNumberLiteral ) ) | ( (lv_index_16_0= ruleValueRef ) ) ) otherlv_17= ']' )
                    // InternalCoreDsl.g:2870:5: ( (otherlv_13= RULE_ID ) ) otherlv_14= '[' ( ( (lv_index_15_0= ruleNumberLiteral ) ) | ( (lv_index_16_0= ruleValueRef ) ) ) otherlv_17= ']'
                    {
                    // InternalCoreDsl.g:2870:5: ( (otherlv_13= RULE_ID ) )
                    // InternalCoreDsl.g:2871:6: (otherlv_13= RULE_ID )
                    {
                    // InternalCoreDsl.g:2871:6: (otherlv_13= RULE_ID )
                    // InternalCoreDsl.g:2872:7: otherlv_13= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getRegisterAliasRule());
                      							}
                      						
                    }
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_13, grammarAccess.getRegisterAliasAccess().getOriginalRegisterFileCrossReference_7_1_0_0());
                      						
                    }

                    }


                    }

                    otherlv_14=(Token)match(input,31,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_14, grammarAccess.getRegisterAliasAccess().getLeftSquareBracketKeyword_7_1_1());
                      				
                    }
                    // InternalCoreDsl.g:2887:5: ( ( (lv_index_15_0= ruleNumberLiteral ) ) | ( (lv_index_16_0= ruleValueRef ) ) )
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==RULE_NATURAL) ) {
                        alt65=1;
                    }
                    else if ( (LA65_0==RULE_ID) ) {
                        alt65=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 65, 0, input);

                        throw nvae;
                    }
                    switch (alt65) {
                        case 1 :
                            // InternalCoreDsl.g:2888:6: ( (lv_index_15_0= ruleNumberLiteral ) )
                            {
                            // InternalCoreDsl.g:2888:6: ( (lv_index_15_0= ruleNumberLiteral ) )
                            // InternalCoreDsl.g:2889:7: (lv_index_15_0= ruleNumberLiteral )
                            {
                            // InternalCoreDsl.g:2889:7: (lv_index_15_0= ruleNumberLiteral )
                            // InternalCoreDsl.g:2890:8: lv_index_15_0= ruleNumberLiteral
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getRegisterAliasAccess().getIndexNumberLiteralParserRuleCall_7_1_2_0_0());
                              							
                            }
                            pushFollow(FOLLOW_24);
                            lv_index_15_0=ruleNumberLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getRegisterAliasRule());
                              								}
                              								set(
                              									current,
                              									"index",
                              									lv_index_15_0,
                              									"com.minres.coredsl.CoreDsl.NumberLiteral");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:2908:6: ( (lv_index_16_0= ruleValueRef ) )
                            {
                            // InternalCoreDsl.g:2908:6: ( (lv_index_16_0= ruleValueRef ) )
                            // InternalCoreDsl.g:2909:7: (lv_index_16_0= ruleValueRef )
                            {
                            // InternalCoreDsl.g:2909:7: (lv_index_16_0= ruleValueRef )
                            // InternalCoreDsl.g:2910:8: lv_index_16_0= ruleValueRef
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getRegisterAliasAccess().getIndexValueRefParserRuleCall_7_1_2_1_0());
                              							
                            }
                            pushFollow(FOLLOW_24);
                            lv_index_16_0=ruleValueRef();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getRegisterAliasRule());
                              								}
                              								set(
                              									current,
                              									"index",
                              									lv_index_16_0,
                              									"com.minres.coredsl.CoreDsl.ValueRef");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_17=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_17, grammarAccess.getRegisterAliasAccess().getRightSquareBracketKeyword_7_1_3());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegisterAlias"


    // $ANTLR start "entryRuleScalar"
    // InternalCoreDsl.g:2938:1: entryRuleScalar returns [EObject current=null] : iv_ruleScalar= ruleScalar EOF ;
    public final EObject entryRuleScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalar = null;


        try {
            // InternalCoreDsl.g:2938:47: (iv_ruleScalar= ruleScalar EOF )
            // InternalCoreDsl.g:2939:2: iv_ruleScalar= ruleScalar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScalarRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScalar=ruleScalar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScalar; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalar"


    // $ANTLR start "ruleScalar"
    // InternalCoreDsl.g:2945:1: ruleScalar returns [EObject current=null] : (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' ) ;
    public final EObject ruleScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_bitSize_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:2951:2: ( (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' ) )
            // InternalCoreDsl.g:2952:2: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' )
            {
            // InternalCoreDsl.g:2952:2: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']' )
            // InternalCoreDsl.g:2953:3: otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getScalarAccess().getValKeyword_0());
              		
            }
            // InternalCoreDsl.g:2957:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalCoreDsl.g:2958:4: (lv_name_1_0= RULE_ID )
            {
            // InternalCoreDsl.g:2958:4: (lv_name_1_0= RULE_ID )
            // InternalCoreDsl.g:2959:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getScalarRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getScalarAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalCoreDsl.g:2979:3: ( ( (lv_bitSize_3_0= RULE_NATURAL ) ) | ( (otherlv_4= RULE_ID ) ) )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_NATURAL) ) {
                alt67=1;
            }
            else if ( (LA67_0==RULE_ID) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalCoreDsl.g:2980:4: ( (lv_bitSize_3_0= RULE_NATURAL ) )
                    {
                    // InternalCoreDsl.g:2980:4: ( (lv_bitSize_3_0= RULE_NATURAL ) )
                    // InternalCoreDsl.g:2981:5: (lv_bitSize_3_0= RULE_NATURAL )
                    {
                    // InternalCoreDsl.g:2981:5: (lv_bitSize_3_0= RULE_NATURAL )
                    // InternalCoreDsl.g:2982:6: lv_bitSize_3_0= RULE_NATURAL
                    {
                    lv_bitSize_3_0=(Token)match(input,RULE_NATURAL,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_bitSize_3_0, grammarAccess.getScalarAccess().getBitSizeNATURALTerminalRuleCall_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getScalarRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"bitSize",
                      							lv_bitSize_3_0,
                      							"com.minres.coredsl.CoreDsl.NATURAL");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2999:4: ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:2999:4: ( (otherlv_4= RULE_ID ) )
                    // InternalCoreDsl.g:3000:5: (otherlv_4= RULE_ID )
                    {
                    // InternalCoreDsl.g:3000:5: (otherlv_4= RULE_ID )
                    // InternalCoreDsl.g:3001:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getScalarRule());
                      						}
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_4, grammarAccess.getScalarAccess().getBitSizeConstConstantCrossReference_3_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getScalarAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalar"


    // $ANTLR start "entryRuleNumberLiteral"
    // InternalCoreDsl.g:3021:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalCoreDsl.g:3021:54: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalCoreDsl.g:3022:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // InternalCoreDsl.g:3028:1: ruleNumberLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_NATURAL ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:3034:2: ( ( (lv_value_0_0= RULE_NATURAL ) ) )
            // InternalCoreDsl.g:3035:2: ( (lv_value_0_0= RULE_NATURAL ) )
            {
            // InternalCoreDsl.g:3035:2: ( (lv_value_0_0= RULE_NATURAL ) )
            // InternalCoreDsl.g:3036:3: (lv_value_0_0= RULE_NATURAL )
            {
            // InternalCoreDsl.g:3036:3: (lv_value_0_0= RULE_NATURAL )
            // InternalCoreDsl.g:3037:4: lv_value_0_0= RULE_NATURAL
            {
            lv_value_0_0=(Token)match(input,RULE_NATURAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getNumberLiteralAccess().getValueNATURALTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getNumberLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"com.minres.coredsl.CoreDsl.NATURAL");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleExpression"
    // InternalCoreDsl.g:3056:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalCoreDsl.g:3056:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalCoreDsl.g:3057:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalCoreDsl.g:3063:1: ruleExpression returns [EObject current=null] : this_BooleanOrExpr_0= ruleBooleanOrExpr ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanOrExpr_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3069:2: (this_BooleanOrExpr_0= ruleBooleanOrExpr )
            // InternalCoreDsl.g:3070:2: this_BooleanOrExpr_0= ruleBooleanOrExpr
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getBooleanOrExprParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_BooleanOrExpr_0=ruleBooleanOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_BooleanOrExpr_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleBooleanOrExpr"
    // InternalCoreDsl.g:3081:1: entryRuleBooleanOrExpr returns [EObject current=null] : iv_ruleBooleanOrExpr= ruleBooleanOrExpr EOF ;
    public final EObject entryRuleBooleanOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanOrExpr = null;


        try {
            // InternalCoreDsl.g:3081:54: (iv_ruleBooleanOrExpr= ruleBooleanOrExpr EOF )
            // InternalCoreDsl.g:3082:2: iv_ruleBooleanOrExpr= ruleBooleanOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanOrExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanOrExpr=ruleBooleanOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanOrExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanOrExpr"


    // $ANTLR start "ruleBooleanOrExpr"
    // InternalCoreDsl.g:3088:1: ruleBooleanOrExpr returns [EObject current=null] : (this_BooleanAndExpr_0= ruleBooleanAndExpr ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleBooleanAndExpr ) ) )* ) ;
    public final EObject ruleBooleanOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_BooleanAndExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3094:2: ( (this_BooleanAndExpr_0= ruleBooleanAndExpr ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleBooleanAndExpr ) ) )* ) )
            // InternalCoreDsl.g:3095:2: (this_BooleanAndExpr_0= ruleBooleanAndExpr ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleBooleanAndExpr ) ) )* )
            {
            // InternalCoreDsl.g:3095:2: (this_BooleanAndExpr_0= ruleBooleanAndExpr ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleBooleanAndExpr ) ) )* )
            // InternalCoreDsl.g:3096:3: this_BooleanAndExpr_0= ruleBooleanAndExpr ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleBooleanAndExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBooleanOrExprAccess().getBooleanAndExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_56);
            this_BooleanAndExpr_0=ruleBooleanAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BooleanAndExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3104:3: ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleBooleanAndExpr ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==47) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalCoreDsl.g:3105:4: () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleBooleanAndExpr ) )
            	    {
            	    // InternalCoreDsl.g:3105:4: ()
            	    // InternalCoreDsl.g:3106:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBooleanOrExprAccess().getBooleanExprLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:3112:4: ( (lv_op_2_0= '||' ) )
            	    // InternalCoreDsl.g:3113:5: (lv_op_2_0= '||' )
            	    {
            	    // InternalCoreDsl.g:3113:5: (lv_op_2_0= '||' )
            	    // InternalCoreDsl.g:3114:6: lv_op_2_0= '||'
            	    {
            	    lv_op_2_0=(Token)match(input,47,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getBooleanOrExprAccess().getOpVerticalLineVerticalLineKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getBooleanOrExprRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "||");
            	      					
            	    }

            	    }


            	    }

            	    // InternalCoreDsl.g:3126:4: ( (lv_right_3_0= ruleBooleanAndExpr ) )
            	    // InternalCoreDsl.g:3127:5: (lv_right_3_0= ruleBooleanAndExpr )
            	    {
            	    // InternalCoreDsl.g:3127:5: (lv_right_3_0= ruleBooleanAndExpr )
            	    // InternalCoreDsl.g:3128:6: lv_right_3_0= ruleBooleanAndExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBooleanOrExprAccess().getRightBooleanAndExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
            	    lv_right_3_0=ruleBooleanAndExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBooleanOrExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.minres.coredsl.CoreDsl.BooleanAndExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanOrExpr"


    // $ANTLR start "entryRuleBooleanAndExpr"
    // InternalCoreDsl.g:3150:1: entryRuleBooleanAndExpr returns [EObject current=null] : iv_ruleBooleanAndExpr= ruleBooleanAndExpr EOF ;
    public final EObject entryRuleBooleanAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAndExpr = null;


        try {
            // InternalCoreDsl.g:3150:55: (iv_ruleBooleanAndExpr= ruleBooleanAndExpr EOF )
            // InternalCoreDsl.g:3151:2: iv_ruleBooleanAndExpr= ruleBooleanAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanAndExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanAndExpr=ruleBooleanAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanAndExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanAndExpr"


    // $ANTLR start "ruleBooleanAndExpr"
    // InternalCoreDsl.g:3157:1: ruleBooleanAndExpr returns [EObject current=null] : (this_BitOrExpr_0= ruleBitOrExpr ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleBitOrExpr ) ) )* ) ;
    public final EObject ruleBooleanAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_BitOrExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3163:2: ( (this_BitOrExpr_0= ruleBitOrExpr ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleBitOrExpr ) ) )* ) )
            // InternalCoreDsl.g:3164:2: (this_BitOrExpr_0= ruleBitOrExpr ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleBitOrExpr ) ) )* )
            {
            // InternalCoreDsl.g:3164:2: (this_BitOrExpr_0= ruleBitOrExpr ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleBitOrExpr ) ) )* )
            // InternalCoreDsl.g:3165:3: this_BitOrExpr_0= ruleBitOrExpr ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleBitOrExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBooleanAndExprAccess().getBitOrExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_57);
            this_BitOrExpr_0=ruleBitOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitOrExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3173:3: ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleBitOrExpr ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==48) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalCoreDsl.g:3174:4: () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleBitOrExpr ) )
            	    {
            	    // InternalCoreDsl.g:3174:4: ()
            	    // InternalCoreDsl.g:3175:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBooleanAndExprAccess().getBooleanExprLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:3181:4: ( (lv_op_2_0= '&&' ) )
            	    // InternalCoreDsl.g:3182:5: (lv_op_2_0= '&&' )
            	    {
            	    // InternalCoreDsl.g:3182:5: (lv_op_2_0= '&&' )
            	    // InternalCoreDsl.g:3183:6: lv_op_2_0= '&&'
            	    {
            	    lv_op_2_0=(Token)match(input,48,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getBooleanAndExprAccess().getOpAmpersandAmpersandKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getBooleanAndExprRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "&&");
            	      					
            	    }

            	    }


            	    }

            	    // InternalCoreDsl.g:3195:4: ( (lv_right_3_0= ruleBitOrExpr ) )
            	    // InternalCoreDsl.g:3196:5: (lv_right_3_0= ruleBitOrExpr )
            	    {
            	    // InternalCoreDsl.g:3196:5: (lv_right_3_0= ruleBitOrExpr )
            	    // InternalCoreDsl.g:3197:6: lv_right_3_0= ruleBitOrExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBooleanAndExprAccess().getRightBitOrExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_57);
            	    lv_right_3_0=ruleBitOrExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBooleanAndExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.minres.coredsl.CoreDsl.BitOrExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanAndExpr"


    // $ANTLR start "entryRuleBitOrExpr"
    // InternalCoreDsl.g:3219:1: entryRuleBitOrExpr returns [EObject current=null] : iv_ruleBitOrExpr= ruleBitOrExpr EOF ;
    public final EObject entryRuleBitOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitOrExpr = null;


        try {
            // InternalCoreDsl.g:3219:50: (iv_ruleBitOrExpr= ruleBitOrExpr EOF )
            // InternalCoreDsl.g:3220:2: iv_ruleBitOrExpr= ruleBitOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitOrExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitOrExpr=ruleBitOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitOrExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitOrExpr"


    // $ANTLR start "ruleBitOrExpr"
    // InternalCoreDsl.g:3226:1: ruleBitOrExpr returns [EObject current=null] : (this_BitXOrExpr_0= ruleBitXOrExpr ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleBitXOrExpr ) ) )* ) ;
    public final EObject ruleBitOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_BitXOrExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3232:2: ( (this_BitXOrExpr_0= ruleBitXOrExpr ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleBitXOrExpr ) ) )* ) )
            // InternalCoreDsl.g:3233:2: (this_BitXOrExpr_0= ruleBitXOrExpr ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleBitXOrExpr ) ) )* )
            {
            // InternalCoreDsl.g:3233:2: (this_BitXOrExpr_0= ruleBitXOrExpr ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleBitXOrExpr ) ) )* )
            // InternalCoreDsl.g:3234:3: this_BitXOrExpr_0= ruleBitXOrExpr ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleBitXOrExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitOrExprAccess().getBitXOrExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_32);
            this_BitXOrExpr_0=ruleBitXOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitXOrExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3242:3: ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleBitXOrExpr ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==37) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalCoreDsl.g:3243:4: () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleBitXOrExpr ) )
            	    {
            	    // InternalCoreDsl.g:3243:4: ()
            	    // InternalCoreDsl.g:3244:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitOrExprAccess().getBitExprLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:3250:4: ( (lv_op_2_0= '|' ) )
            	    // InternalCoreDsl.g:3251:5: (lv_op_2_0= '|' )
            	    {
            	    // InternalCoreDsl.g:3251:5: (lv_op_2_0= '|' )
            	    // InternalCoreDsl.g:3252:6: lv_op_2_0= '|'
            	    {
            	    lv_op_2_0=(Token)match(input,37,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getBitOrExprAccess().getOpVerticalLineKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getBitOrExprRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "|");
            	      					
            	    }

            	    }


            	    }

            	    // InternalCoreDsl.g:3264:4: ( (lv_right_3_0= ruleBitXOrExpr ) )
            	    // InternalCoreDsl.g:3265:5: (lv_right_3_0= ruleBitXOrExpr )
            	    {
            	    // InternalCoreDsl.g:3265:5: (lv_right_3_0= ruleBitXOrExpr )
            	    // InternalCoreDsl.g:3266:6: lv_right_3_0= ruleBitXOrExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitOrExprAccess().getRightBitXOrExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_right_3_0=ruleBitXOrExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitOrExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.minres.coredsl.CoreDsl.BitXOrExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitOrExpr"


    // $ANTLR start "entryRuleBitXOrExpr"
    // InternalCoreDsl.g:3288:1: entryRuleBitXOrExpr returns [EObject current=null] : iv_ruleBitXOrExpr= ruleBitXOrExpr EOF ;
    public final EObject entryRuleBitXOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitXOrExpr = null;


        try {
            // InternalCoreDsl.g:3288:51: (iv_ruleBitXOrExpr= ruleBitXOrExpr EOF )
            // InternalCoreDsl.g:3289:2: iv_ruleBitXOrExpr= ruleBitXOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitXOrExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitXOrExpr=ruleBitXOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitXOrExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitXOrExpr"


    // $ANTLR start "ruleBitXOrExpr"
    // InternalCoreDsl.g:3295:1: ruleBitXOrExpr returns [EObject current=null] : (this_BitAndExpr_0= ruleBitAndExpr ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleBitAndExpr ) ) )* ) ;
    public final EObject ruleBitXOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_BitAndExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3301:2: ( (this_BitAndExpr_0= ruleBitAndExpr ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleBitAndExpr ) ) )* ) )
            // InternalCoreDsl.g:3302:2: (this_BitAndExpr_0= ruleBitAndExpr ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleBitAndExpr ) ) )* )
            {
            // InternalCoreDsl.g:3302:2: (this_BitAndExpr_0= ruleBitAndExpr ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleBitAndExpr ) ) )* )
            // InternalCoreDsl.g:3303:3: this_BitAndExpr_0= ruleBitAndExpr ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleBitAndExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitXOrExprAccess().getBitAndExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_58);
            this_BitAndExpr_0=ruleBitAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitAndExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3311:3: ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleBitAndExpr ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==49) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalCoreDsl.g:3312:4: () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleBitAndExpr ) )
            	    {
            	    // InternalCoreDsl.g:3312:4: ()
            	    // InternalCoreDsl.g:3313:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitXOrExprAccess().getBitExprLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:3319:4: ( (lv_op_2_0= '^' ) )
            	    // InternalCoreDsl.g:3320:5: (lv_op_2_0= '^' )
            	    {
            	    // InternalCoreDsl.g:3320:5: (lv_op_2_0= '^' )
            	    // InternalCoreDsl.g:3321:6: lv_op_2_0= '^'
            	    {
            	    lv_op_2_0=(Token)match(input,49,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getBitXOrExprAccess().getOpCircumflexAccentKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getBitXOrExprRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "^");
            	      					
            	    }

            	    }


            	    }

            	    // InternalCoreDsl.g:3333:4: ( (lv_right_3_0= ruleBitAndExpr ) )
            	    // InternalCoreDsl.g:3334:5: (lv_right_3_0= ruleBitAndExpr )
            	    {
            	    // InternalCoreDsl.g:3334:5: (lv_right_3_0= ruleBitAndExpr )
            	    // InternalCoreDsl.g:3335:6: lv_right_3_0= ruleBitAndExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitXOrExprAccess().getRightBitAndExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_58);
            	    lv_right_3_0=ruleBitAndExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitXOrExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.minres.coredsl.CoreDsl.BitAndExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitXOrExpr"


    // $ANTLR start "entryRuleBitAndExpr"
    // InternalCoreDsl.g:3357:1: entryRuleBitAndExpr returns [EObject current=null] : iv_ruleBitAndExpr= ruleBitAndExpr EOF ;
    public final EObject entryRuleBitAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitAndExpr = null;


        try {
            // InternalCoreDsl.g:3357:51: (iv_ruleBitAndExpr= ruleBitAndExpr EOF )
            // InternalCoreDsl.g:3358:2: iv_ruleBitAndExpr= ruleBitAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitAndExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitAndExpr=ruleBitAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitAndExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitAndExpr"


    // $ANTLR start "ruleBitAndExpr"
    // InternalCoreDsl.g:3364:1: ruleBitAndExpr returns [EObject current=null] : (this_EqualityExpr_0= ruleEqualityExpr ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* ) ;
    public final EObject ruleBitAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_EqualityExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3370:2: ( (this_EqualityExpr_0= ruleEqualityExpr ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* ) )
            // InternalCoreDsl.g:3371:2: (this_EqualityExpr_0= ruleEqualityExpr ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* )
            {
            // InternalCoreDsl.g:3371:2: (this_EqualityExpr_0= ruleEqualityExpr ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* )
            // InternalCoreDsl.g:3372:3: this_EqualityExpr_0= ruleEqualityExpr ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitAndExprAccess().getEqualityExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_59);
            this_EqualityExpr_0=ruleEqualityExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3380:3: ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==50) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalCoreDsl.g:3381:4: () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) )
            	    {
            	    // InternalCoreDsl.g:3381:4: ()
            	    // InternalCoreDsl.g:3382:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitAndExprAccess().getBitExprLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:3388:4: ( (lv_op_2_0= '&' ) )
            	    // InternalCoreDsl.g:3389:5: (lv_op_2_0= '&' )
            	    {
            	    // InternalCoreDsl.g:3389:5: (lv_op_2_0= '&' )
            	    // InternalCoreDsl.g:3390:6: lv_op_2_0= '&'
            	    {
            	    lv_op_2_0=(Token)match(input,50,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getBitAndExprAccess().getOpAmpersandKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getBitAndExprRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "&");
            	      					
            	    }

            	    }


            	    }

            	    // InternalCoreDsl.g:3402:4: ( (lv_right_3_0= ruleEqualityExpr ) )
            	    // InternalCoreDsl.g:3403:5: (lv_right_3_0= ruleEqualityExpr )
            	    {
            	    // InternalCoreDsl.g:3403:5: (lv_right_3_0= ruleEqualityExpr )
            	    // InternalCoreDsl.g:3404:6: lv_right_3_0= ruleEqualityExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitAndExprAccess().getRightEqualityExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_59);
            	    lv_right_3_0=ruleEqualityExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitAndExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.minres.coredsl.CoreDsl.EqualityExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitAndExpr"


    // $ANTLR start "entryRuleEqualityExpr"
    // InternalCoreDsl.g:3426:1: entryRuleEqualityExpr returns [EObject current=null] : iv_ruleEqualityExpr= ruleEqualityExpr EOF ;
    public final EObject entryRuleEqualityExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpr = null;


        try {
            // InternalCoreDsl.g:3426:53: (iv_ruleEqualityExpr= ruleEqualityExpr EOF )
            // InternalCoreDsl.g:3427:2: iv_ruleEqualityExpr= ruleEqualityExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpr=ruleEqualityExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpr"


    // $ANTLR start "ruleEqualityExpr"
    // InternalCoreDsl.g:3433:1: ruleEqualityExpr returns [EObject current=null] : (this_ComparisonExpr_0= ruleComparisonExpr ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparisonExpr ) ) )* ) ;
    public final EObject ruleEqualityExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_ComparisonExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3439:2: ( (this_ComparisonExpr_0= ruleComparisonExpr ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparisonExpr ) ) )* ) )
            // InternalCoreDsl.g:3440:2: (this_ComparisonExpr_0= ruleComparisonExpr ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparisonExpr ) ) )* )
            {
            // InternalCoreDsl.g:3440:2: (this_ComparisonExpr_0= ruleComparisonExpr ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparisonExpr ) ) )* )
            // InternalCoreDsl.g:3441:3: this_ComparisonExpr_0= ruleComparisonExpr ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparisonExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExprAccess().getComparisonExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_60);
            this_ComparisonExpr_0=ruleComparisonExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ComparisonExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3449:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparisonExpr ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( ((LA74_0>=51 && LA74_0<=52)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalCoreDsl.g:3450:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparisonExpr ) )
            	    {
            	    // InternalCoreDsl.g:3450:4: ()
            	    // InternalCoreDsl.g:3451:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityExprAccess().getComparisonExprLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:3457:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalCoreDsl.g:3458:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalCoreDsl.g:3458:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalCoreDsl.g:3459:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalCoreDsl.g:3459:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt73=2;
            	    int LA73_0 = input.LA(1);

            	    if ( (LA73_0==51) ) {
            	        alt73=1;
            	    }
            	    else if ( (LA73_0==52) ) {
            	        alt73=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 73, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt73) {
            	        case 1 :
            	            // InternalCoreDsl.g:3460:7: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,51,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getEqualityExprAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalCoreDsl.g:3471:7: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,52,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getEqualityExprAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalCoreDsl.g:3484:4: ( (lv_right_3_0= ruleComparisonExpr ) )
            	    // InternalCoreDsl.g:3485:5: (lv_right_3_0= ruleComparisonExpr )
            	    {
            	    // InternalCoreDsl.g:3485:5: (lv_right_3_0= ruleComparisonExpr )
            	    // InternalCoreDsl.g:3486:6: lv_right_3_0= ruleComparisonExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExprAccess().getRightComparisonExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_60);
            	    lv_right_3_0=ruleComparisonExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.minres.coredsl.CoreDsl.ComparisonExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpr"


    // $ANTLR start "entryRuleComparisonExpr"
    // InternalCoreDsl.g:3508:1: entryRuleComparisonExpr returns [EObject current=null] : iv_ruleComparisonExpr= ruleComparisonExpr EOF ;
    public final EObject entryRuleComparisonExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpr = null;


        try {
            // InternalCoreDsl.g:3508:55: (iv_ruleComparisonExpr= ruleComparisonExpr EOF )
            // InternalCoreDsl.g:3509:2: iv_ruleComparisonExpr= ruleComparisonExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparisonExpr=ruleComparisonExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparisonExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparisonExpr"


    // $ANTLR start "ruleComparisonExpr"
    // InternalCoreDsl.g:3515:1: ruleComparisonExpr returns [EObject current=null] : (this_ShiftExpr_0= ruleShiftExpr ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* ) ;
    public final EObject ruleComparisonExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_ShiftExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3521:2: ( (this_ShiftExpr_0= ruleShiftExpr ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* ) )
            // InternalCoreDsl.g:3522:2: (this_ShiftExpr_0= ruleShiftExpr ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* )
            {
            // InternalCoreDsl.g:3522:2: (this_ShiftExpr_0= ruleShiftExpr ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* )
            // InternalCoreDsl.g:3523:3: this_ShiftExpr_0= ruleShiftExpr ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonExprAccess().getShiftExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_61);
            this_ShiftExpr_0=ruleShiftExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3531:3: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==39||(LA76_0>=53 && LA76_0<=55)) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalCoreDsl.g:3532:4: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleShiftExpr ) )
            	    {
            	    // InternalCoreDsl.g:3532:4: ()
            	    // InternalCoreDsl.g:3533:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getComparisonExprAccess().getComparisonExprLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:3539:4: ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    // InternalCoreDsl.g:3540:5: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    {
            	    // InternalCoreDsl.g:3540:5: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    // InternalCoreDsl.g:3541:6: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    {
            	    // InternalCoreDsl.g:3541:6: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    int alt75=4;
            	    switch ( input.LA(1) ) {
            	    case 53:
            	        {
            	        alt75=1;
            	        }
            	        break;
            	    case 54:
            	        {
            	        alt75=2;
            	        }
            	        break;
            	    case 39:
            	        {
            	        alt75=3;
            	        }
            	        break;
            	    case 55:
            	        {
            	        alt75=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 75, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt75) {
            	        case 1 :
            	            // InternalCoreDsl.g:3542:7: lv_op_2_1= '<'
            	            {
            	            lv_op_2_1=(Token)match(input,53,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getComparisonExprAccess().getOpLessThanSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalCoreDsl.g:3553:7: lv_op_2_2= '>'
            	            {
            	            lv_op_2_2=(Token)match(input,54,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getComparisonExprAccess().getOpGreaterThanSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalCoreDsl.g:3564:7: lv_op_2_3= '<='
            	            {
            	            lv_op_2_3=(Token)match(input,39,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_3, grammarAccess.getComparisonExprAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalCoreDsl.g:3575:7: lv_op_2_4= '>='
            	            {
            	            lv_op_2_4=(Token)match(input,55,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_4, grammarAccess.getComparisonExprAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_3());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalCoreDsl.g:3588:4: ( (lv_right_3_0= ruleShiftExpr ) )
            	    // InternalCoreDsl.g:3589:5: (lv_right_3_0= ruleShiftExpr )
            	    {
            	    // InternalCoreDsl.g:3589:5: (lv_right_3_0= ruleShiftExpr )
            	    // InternalCoreDsl.g:3590:6: lv_right_3_0= ruleShiftExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getComparisonExprAccess().getRightShiftExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_61);
            	    lv_right_3_0=ruleShiftExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getComparisonExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.minres.coredsl.CoreDsl.ShiftExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparisonExpr"


    // $ANTLR start "entryRuleShiftExpr"
    // InternalCoreDsl.g:3612:1: entryRuleShiftExpr returns [EObject current=null] : iv_ruleShiftExpr= ruleShiftExpr EOF ;
    public final EObject entryRuleShiftExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpr = null;


        try {
            // InternalCoreDsl.g:3612:50: (iv_ruleShiftExpr= ruleShiftExpr EOF )
            // InternalCoreDsl.g:3613:2: iv_ruleShiftExpr= ruleShiftExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShiftExpr=ruleShiftExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShiftExpr"


    // $ANTLR start "ruleShiftExpr"
    // InternalCoreDsl.g:3619:1: ruleShiftExpr returns [EObject current=null] : (this_AdditionExpr_0= ruleAdditionExpr ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleAdditionExpr ) ) )* ) ;
    public final EObject ruleShiftExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AdditionExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3625:2: ( (this_AdditionExpr_0= ruleAdditionExpr ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleAdditionExpr ) ) )* ) )
            // InternalCoreDsl.g:3626:2: (this_AdditionExpr_0= ruleAdditionExpr ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleAdditionExpr ) ) )* )
            {
            // InternalCoreDsl.g:3626:2: (this_AdditionExpr_0= ruleAdditionExpr ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleAdditionExpr ) ) )* )
            // InternalCoreDsl.g:3627:3: this_AdditionExpr_0= ruleAdditionExpr ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleAdditionExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExprAccess().getAdditionExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_62);
            this_AdditionExpr_0=ruleAdditionExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditionExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3635:3: ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleAdditionExpr ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( ((LA78_0>=56 && LA78_0<=57)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalCoreDsl.g:3636:4: () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleAdditionExpr ) )
            	    {
            	    // InternalCoreDsl.g:3636:4: ()
            	    // InternalCoreDsl.g:3637:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getShiftExprAccess().getShiftExprLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:3643:4: ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) )
            	    // InternalCoreDsl.g:3644:5: ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) )
            	    {
            	    // InternalCoreDsl.g:3644:5: ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) )
            	    // InternalCoreDsl.g:3645:6: (lv_op_2_1= '<<' | lv_op_2_2= '>>' )
            	    {
            	    // InternalCoreDsl.g:3645:6: (lv_op_2_1= '<<' | lv_op_2_2= '>>' )
            	    int alt77=2;
            	    int LA77_0 = input.LA(1);

            	    if ( (LA77_0==56) ) {
            	        alt77=1;
            	    }
            	    else if ( (LA77_0==57) ) {
            	        alt77=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 77, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt77) {
            	        case 1 :
            	            // InternalCoreDsl.g:3646:7: lv_op_2_1= '<<'
            	            {
            	            lv_op_2_1=(Token)match(input,56,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getShiftExprAccess().getOpLessThanSignLessThanSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getShiftExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalCoreDsl.g:3657:7: lv_op_2_2= '>>'
            	            {
            	            lv_op_2_2=(Token)match(input,57,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getShiftExprAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getShiftExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalCoreDsl.g:3670:4: ( (lv_right_3_0= ruleAdditionExpr ) )
            	    // InternalCoreDsl.g:3671:5: (lv_right_3_0= ruleAdditionExpr )
            	    {
            	    // InternalCoreDsl.g:3671:5: (lv_right_3_0= ruleAdditionExpr )
            	    // InternalCoreDsl.g:3672:6: lv_right_3_0= ruleAdditionExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExprAccess().getRightAdditionExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_62);
            	    lv_right_3_0=ruleAdditionExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.minres.coredsl.CoreDsl.AdditionExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftExpr"


    // $ANTLR start "entryRuleAdditionExpr"
    // InternalCoreDsl.g:3694:1: entryRuleAdditionExpr returns [EObject current=null] : iv_ruleAdditionExpr= ruleAdditionExpr EOF ;
    public final EObject entryRuleAdditionExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionExpr = null;


        try {
            // InternalCoreDsl.g:3694:53: (iv_ruleAdditionExpr= ruleAdditionExpr EOF )
            // InternalCoreDsl.g:3695:2: iv_ruleAdditionExpr= ruleAdditionExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditionExpr=ruleAdditionExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditionExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditionExpr"


    // $ANTLR start "ruleAdditionExpr"
    // InternalCoreDsl.g:3701:1: ruleAdditionExpr returns [EObject current=null] : (this_MultiplicationExpr_0= ruleMultiplicationExpr ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicationExpr ) ) )* ) ;
    public final EObject ruleAdditionExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MultiplicationExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3707:2: ( (this_MultiplicationExpr_0= ruleMultiplicationExpr ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicationExpr ) ) )* ) )
            // InternalCoreDsl.g:3708:2: (this_MultiplicationExpr_0= ruleMultiplicationExpr ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicationExpr ) ) )* )
            {
            // InternalCoreDsl.g:3708:2: (this_MultiplicationExpr_0= ruleMultiplicationExpr ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicationExpr ) ) )* )
            // InternalCoreDsl.g:3709:3: this_MultiplicationExpr_0= ruleMultiplicationExpr ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicationExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionExprAccess().getMultiplicationExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_63);
            this_MultiplicationExpr_0=ruleMultiplicationExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicationExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3717:3: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicationExpr ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( ((LA80_0>=58 && LA80_0<=59)) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalCoreDsl.g:3718:4: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicationExpr ) )
            	    {
            	    // InternalCoreDsl.g:3718:4: ()
            	    // InternalCoreDsl.g:3719:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionExprAccess().getAdditionExprLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:3725:4: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
            	    // InternalCoreDsl.g:3726:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
            	    {
            	    // InternalCoreDsl.g:3726:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
            	    // InternalCoreDsl.g:3727:6: (lv_op_2_1= '+' | lv_op_2_2= '-' )
            	    {
            	    // InternalCoreDsl.g:3727:6: (lv_op_2_1= '+' | lv_op_2_2= '-' )
            	    int alt79=2;
            	    int LA79_0 = input.LA(1);

            	    if ( (LA79_0==58) ) {
            	        alt79=1;
            	    }
            	    else if ( (LA79_0==59) ) {
            	        alt79=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 79, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt79) {
            	        case 1 :
            	            // InternalCoreDsl.g:3728:7: lv_op_2_1= '+'
            	            {
            	            lv_op_2_1=(Token)match(input,58,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getAdditionExprAccess().getOpPlusSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditionExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalCoreDsl.g:3739:7: lv_op_2_2= '-'
            	            {
            	            lv_op_2_2=(Token)match(input,59,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getAdditionExprAccess().getOpHyphenMinusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditionExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalCoreDsl.g:3752:4: ( (lv_right_3_0= ruleMultiplicationExpr ) )
            	    // InternalCoreDsl.g:3753:5: (lv_right_3_0= ruleMultiplicationExpr )
            	    {
            	    // InternalCoreDsl.g:3753:5: (lv_right_3_0= ruleMultiplicationExpr )
            	    // InternalCoreDsl.g:3754:6: lv_right_3_0= ruleMultiplicationExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionExprAccess().getRightMultiplicationExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_63);
            	    lv_right_3_0=ruleMultiplicationExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditionExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.minres.coredsl.CoreDsl.MultiplicationExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditionExpr"


    // $ANTLR start "entryRuleMultiplicationExpr"
    // InternalCoreDsl.g:3776:1: entryRuleMultiplicationExpr returns [EObject current=null] : iv_ruleMultiplicationExpr= ruleMultiplicationExpr EOF ;
    public final EObject entryRuleMultiplicationExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicationExpr = null;


        try {
            // InternalCoreDsl.g:3776:59: (iv_ruleMultiplicationExpr= ruleMultiplicationExpr EOF )
            // InternalCoreDsl.g:3777:2: iv_ruleMultiplicationExpr= ruleMultiplicationExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicationExpr=ruleMultiplicationExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicationExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicationExpr"


    // $ANTLR start "ruleMultiplicationExpr"
    // InternalCoreDsl.g:3783:1: ruleMultiplicationExpr returns [EObject current=null] : (this_UnitaryExpr_0= ruleUnitaryExpr ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleUnitaryExpr ) ) )* ) ;
    public final EObject ruleMultiplicationExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_UnitaryExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3789:2: ( (this_UnitaryExpr_0= ruleUnitaryExpr ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleUnitaryExpr ) ) )* ) )
            // InternalCoreDsl.g:3790:2: (this_UnitaryExpr_0= ruleUnitaryExpr ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleUnitaryExpr ) ) )* )
            {
            // InternalCoreDsl.g:3790:2: (this_UnitaryExpr_0= ruleUnitaryExpr ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleUnitaryExpr ) ) )* )
            // InternalCoreDsl.g:3791:3: this_UnitaryExpr_0= ruleUnitaryExpr ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleUnitaryExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationExprAccess().getUnitaryExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_64);
            this_UnitaryExpr_0=ruleUnitaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_UnitaryExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3799:3: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleUnitaryExpr ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( ((LA82_0>=60 && LA82_0<=62)) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalCoreDsl.g:3800:4: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleUnitaryExpr ) )
            	    {
            	    // InternalCoreDsl.g:3800:4: ()
            	    // InternalCoreDsl.g:3801:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationExprAccess().getMultiplicationExprLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:3807:4: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) )
            	    // InternalCoreDsl.g:3808:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
            	    {
            	    // InternalCoreDsl.g:3808:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
            	    // InternalCoreDsl.g:3809:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
            	    {
            	    // InternalCoreDsl.g:3809:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
            	    int alt81=3;
            	    switch ( input.LA(1) ) {
            	    case 60:
            	        {
            	        alt81=1;
            	        }
            	        break;
            	    case 61:
            	        {
            	        alt81=2;
            	        }
            	        break;
            	    case 62:
            	        {
            	        alt81=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 81, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt81) {
            	        case 1 :
            	            // InternalCoreDsl.g:3810:7: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,60,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getMultiplicationExprAccess().getOpAsteriskKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicationExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalCoreDsl.g:3821:7: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,61,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getMultiplicationExprAccess().getOpSolidusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicationExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalCoreDsl.g:3832:7: lv_op_2_3= '%'
            	            {
            	            lv_op_2_3=(Token)match(input,62,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_3, grammarAccess.getMultiplicationExprAccess().getOpPercentSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicationExprRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalCoreDsl.g:3845:4: ( (lv_right_3_0= ruleUnitaryExpr ) )
            	    // InternalCoreDsl.g:3846:5: (lv_right_3_0= ruleUnitaryExpr )
            	    {
            	    // InternalCoreDsl.g:3846:5: (lv_right_3_0= ruleUnitaryExpr )
            	    // InternalCoreDsl.g:3847:6: lv_right_3_0= ruleUnitaryExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationExprAccess().getRightUnitaryExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_64);
            	    lv_right_3_0=ruleUnitaryExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicationExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.minres.coredsl.CoreDsl.UnitaryExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicationExpr"


    // $ANTLR start "entryRuleUnitaryExpr"
    // InternalCoreDsl.g:3869:1: entryRuleUnitaryExpr returns [EObject current=null] : iv_ruleUnitaryExpr= ruleUnitaryExpr EOF ;
    public final EObject entryRuleUnitaryExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitaryExpr = null;


        try {
            // InternalCoreDsl.g:3869:52: (iv_ruleUnitaryExpr= ruleUnitaryExpr EOF )
            // InternalCoreDsl.g:3870:2: iv_ruleUnitaryExpr= ruleUnitaryExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitaryExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnitaryExpr=ruleUnitaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitaryExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitaryExpr"


    // $ANTLR start "ruleUnitaryExpr"
    // InternalCoreDsl.g:3876:1: ruleUnitaryExpr returns [EObject current=null] : (this_TypeConv_0= ruleTypeConv | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' ) ) ) ( (lv_expr_3_0= ruleUnitaryExpr ) ) ) ) ;
    public final EObject ruleUnitaryExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_TypeConv_0 = null;

        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3882:2: ( (this_TypeConv_0= ruleTypeConv | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' ) ) ) ( (lv_expr_3_0= ruleUnitaryExpr ) ) ) ) )
            // InternalCoreDsl.g:3883:2: (this_TypeConv_0= ruleTypeConv | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' ) ) ) ( (lv_expr_3_0= ruleUnitaryExpr ) ) ) )
            {
            // InternalCoreDsl.g:3883:2: (this_TypeConv_0= ruleTypeConv | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' ) ) ) ( (lv_expr_3_0= ruleUnitaryExpr ) ) ) )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=RULE_ID && LA84_0<=RULE_NATURAL)||LA84_0==RULE_FUNCTIONNAME||LA84_0==33) ) {
                alt84=1;
            }
            else if ( ((LA84_0>=58 && LA84_0<=59)||(LA84_0>=63 && LA84_0<=64)) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalCoreDsl.g:3884:3: this_TypeConv_0= ruleTypeConv
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnitaryExprAccess().getTypeConvParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeConv_0=ruleTypeConv();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeConv_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3893:3: ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' ) ) ) ( (lv_expr_3_0= ruleUnitaryExpr ) ) )
                    {
                    // InternalCoreDsl.g:3893:3: ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' ) ) ) ( (lv_expr_3_0= ruleUnitaryExpr ) ) )
                    // InternalCoreDsl.g:3894:4: () ( ( (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' ) ) ) ( (lv_expr_3_0= ruleUnitaryExpr ) )
                    {
                    // InternalCoreDsl.g:3894:4: ()
                    // InternalCoreDsl.g:3895:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getUnitaryExprAccess().getUnitaryExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:3901:4: ( ( (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' ) ) )
                    // InternalCoreDsl.g:3902:5: ( (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' ) )
                    {
                    // InternalCoreDsl.g:3902:5: ( (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' ) )
                    // InternalCoreDsl.g:3903:6: (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' )
                    {
                    // InternalCoreDsl.g:3903:6: (lv_op_2_1= '-' | lv_op_2_2= '+' | lv_op_2_3= '~' | lv_op_2_4= '!' )
                    int alt83=4;
                    switch ( input.LA(1) ) {
                    case 59:
                        {
                        alt83=1;
                        }
                        break;
                    case 58:
                        {
                        alt83=2;
                        }
                        break;
                    case 63:
                        {
                        alt83=3;
                        }
                        break;
                    case 64:
                        {
                        alt83=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 0, input);

                        throw nvae;
                    }

                    switch (alt83) {
                        case 1 :
                            // InternalCoreDsl.g:3904:7: lv_op_2_1= '-'
                            {
                            lv_op_2_1=(Token)match(input,59,FOLLOW_37); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_1, grammarAccess.getUnitaryExprAccess().getOpHyphenMinusKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getUnitaryExprRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:3915:7: lv_op_2_2= '+'
                            {
                            lv_op_2_2=(Token)match(input,58,FOLLOW_37); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_2, grammarAccess.getUnitaryExprAccess().getOpPlusSignKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getUnitaryExprRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_2, null);
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalCoreDsl.g:3926:7: lv_op_2_3= '~'
                            {
                            lv_op_2_3=(Token)match(input,63,FOLLOW_37); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_3, grammarAccess.getUnitaryExprAccess().getOpTildeKeyword_1_1_0_2());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getUnitaryExprRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_3, null);
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalCoreDsl.g:3937:7: lv_op_2_4= '!'
                            {
                            lv_op_2_4=(Token)match(input,64,FOLLOW_37); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_4, grammarAccess.getUnitaryExprAccess().getOpExclamationMarkKeyword_1_1_0_3());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getUnitaryExprRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_4, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalCoreDsl.g:3950:4: ( (lv_expr_3_0= ruleUnitaryExpr ) )
                    // InternalCoreDsl.g:3951:5: (lv_expr_3_0= ruleUnitaryExpr )
                    {
                    // InternalCoreDsl.g:3951:5: (lv_expr_3_0= ruleUnitaryExpr )
                    // InternalCoreDsl.g:3952:6: lv_expr_3_0= ruleUnitaryExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnitaryExprAccess().getExprUnitaryExprParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_3_0=ruleUnitaryExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnitaryExprRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_3_0,
                      							"com.minres.coredsl.CoreDsl.UnitaryExpr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitaryExpr"


    // $ANTLR start "entryRuleTypeConv"
    // InternalCoreDsl.g:3974:1: entryRuleTypeConv returns [EObject current=null] : iv_ruleTypeConv= ruleTypeConv EOF ;
    public final EObject entryRuleTypeConv() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeConv = null;


        try {
            // InternalCoreDsl.g:3974:49: (iv_ruleTypeConv= ruleTypeConv EOF )
            // InternalCoreDsl.g:3975:2: iv_ruleTypeConv= ruleTypeConv EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeConvRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeConv=ruleTypeConv();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeConv; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeConv"


    // $ANTLR start "ruleTypeConv"
    // InternalCoreDsl.g:3981:1: ruleTypeConv returns [EObject current=null] : (this_Primary_0= rulePrimary ( () (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )? ) ;
    public final EObject ruleTypeConv() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3987:2: ( (this_Primary_0= rulePrimary ( () (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )? ) )
            // InternalCoreDsl.g:3988:2: (this_Primary_0= rulePrimary ( () (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )? )
            {
            // InternalCoreDsl.g:3988:2: (this_Primary_0= rulePrimary ( () (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )? )
            // InternalCoreDsl.g:3989:3: this_Primary_0= rulePrimary ( () (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getTypeConvAccess().getPrimaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_34);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Primary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:3997:3: ( () (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==38||(LA86_0>=65 && LA86_0<=71)) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalCoreDsl.g:3998:4: () (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleDataType ) )
                    {
                    // InternalCoreDsl.g:3998:4: ()
                    // InternalCoreDsl.g:3999:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getTypeConvAccess().getTypeConvExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4005:4: (otherlv_2= '\\'' )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==38) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // InternalCoreDsl.g:4006:5: otherlv_2= '\\''
                            {
                            otherlv_2=(Token)match(input,38,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getTypeConvAccess().getApostropheKeyword_1_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalCoreDsl.g:4011:4: ( (lv_type_3_0= ruleDataType ) )
                    // InternalCoreDsl.g:4012:5: (lv_type_3_0= ruleDataType )
                    {
                    // InternalCoreDsl.g:4012:5: (lv_type_3_0= ruleDataType )
                    // InternalCoreDsl.g:4013:6: lv_type_3_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeConvAccess().getTypeDataTypeEnumRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_type_3_0=ruleDataType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTypeConvRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_3_0,
                      							"com.minres.coredsl.CoreDsl.DataType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeConv"


    // $ANTLR start "entryRulePrimary"
    // InternalCoreDsl.g:4035:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalCoreDsl.g:4035:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalCoreDsl.g:4036:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalCoreDsl.g:4042:1: rulePrimary returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_FUNCTIONNAME ) ) otherlv_5= '(' ( ( (lv_args_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) ) )* )? otherlv_9= ')' ) | this_NumberLiteral_10= ruleNumberLiteral | this_ValueRef_11= ruleValueRef ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject this_Expression_1 = null;

        EObject lv_args_6_0 = null;

        EObject lv_args_8_0 = null;

        EObject this_NumberLiteral_10 = null;

        EObject this_ValueRef_11 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4048:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_FUNCTIONNAME ) ) otherlv_5= '(' ( ( (lv_args_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) ) )* )? otherlv_9= ')' ) | this_NumberLiteral_10= ruleNumberLiteral | this_ValueRef_11= ruleValueRef ) )
            // InternalCoreDsl.g:4049:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_FUNCTIONNAME ) ) otherlv_5= '(' ( ( (lv_args_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) ) )* )? otherlv_9= ')' ) | this_NumberLiteral_10= ruleNumberLiteral | this_ValueRef_11= ruleValueRef )
            {
            // InternalCoreDsl.g:4049:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_FUNCTIONNAME ) ) otherlv_5= '(' ( ( (lv_args_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) ) )* )? otherlv_9= ')' ) | this_NumberLiteral_10= ruleNumberLiteral | this_ValueRef_11= ruleValueRef )
            int alt89=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt89=1;
                }
                break;
            case RULE_FUNCTIONNAME:
                {
                alt89=2;
                }
                break;
            case RULE_NATURAL:
                {
                alt89=3;
                }
                break;
            case RULE_ID:
                {
                alt89=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalCoreDsl.g:4050:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalCoreDsl.g:4050:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalCoreDsl.g:4051:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,33,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_41);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expression_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_2=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4069:3: ( () ( (lv_name_4_0= RULE_FUNCTIONNAME ) ) otherlv_5= '(' ( ( (lv_args_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) ) )* )? otherlv_9= ')' )
                    {
                    // InternalCoreDsl.g:4069:3: ( () ( (lv_name_4_0= RULE_FUNCTIONNAME ) ) otherlv_5= '(' ( ( (lv_args_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) ) )* )? otherlv_9= ')' )
                    // InternalCoreDsl.g:4070:4: () ( (lv_name_4_0= RULE_FUNCTIONNAME ) ) otherlv_5= '(' ( ( (lv_args_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) ) )* )? otherlv_9= ')'
                    {
                    // InternalCoreDsl.g:4070:4: ()
                    // InternalCoreDsl.g:4071:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getFunctionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4077:4: ( (lv_name_4_0= RULE_FUNCTIONNAME ) )
                    // InternalCoreDsl.g:4078:5: (lv_name_4_0= RULE_FUNCTIONNAME )
                    {
                    // InternalCoreDsl.g:4078:5: (lv_name_4_0= RULE_FUNCTIONNAME )
                    // InternalCoreDsl.g:4079:6: lv_name_4_0= RULE_FUNCTIONNAME
                    {
                    lv_name_4_0=(Token)match(input,RULE_FUNCTIONNAME,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_4_0, grammarAccess.getPrimaryAccess().getNameFUNCTIONNAMETerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_4_0,
                      							"com.minres.coredsl.CoreDsl.FUNCTIONNAME");
                      					
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,33,FOLLOW_65); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_1_2());
                      			
                    }
                    // InternalCoreDsl.g:4099:4: ( ( (lv_args_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) ) )* )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( ((LA88_0>=RULE_ID && LA88_0<=RULE_NATURAL)||LA88_0==RULE_FUNCTIONNAME||LA88_0==33||(LA88_0>=58 && LA88_0<=59)||(LA88_0>=63 && LA88_0<=64)) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // InternalCoreDsl.g:4100:5: ( (lv_args_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) ) )*
                            {
                            // InternalCoreDsl.g:4100:5: ( (lv_args_6_0= ruleExpression ) )
                            // InternalCoreDsl.g:4101:6: (lv_args_6_0= ruleExpression )
                            {
                            // InternalCoreDsl.g:4101:6: (lv_args_6_0= ruleExpression )
                            // InternalCoreDsl.g:4102:7: lv_args_6_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPrimaryAccess().getArgsExpressionParserRuleCall_1_3_0_0());
                              						
                            }
                            pushFollow(FOLLOW_27);
                            lv_args_6_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getPrimaryRule());
                              							}
                              							add(
                              								current,
                              								"args",
                              								lv_args_6_0,
                              								"com.minres.coredsl.CoreDsl.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalCoreDsl.g:4119:5: (otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) ) )*
                            loop87:
                            do {
                                int alt87=2;
                                int LA87_0 = input.LA(1);

                                if ( (LA87_0==21) ) {
                                    alt87=1;
                                }


                                switch (alt87) {
                            	case 1 :
                            	    // InternalCoreDsl.g:4120:6: otherlv_7= ',' ( (lv_args_8_0= ruleExpression ) )
                            	    {
                            	    otherlv_7=(Token)match(input,21,FOLLOW_37); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getCommaKeyword_1_3_1_0());
                            	      					
                            	    }
                            	    // InternalCoreDsl.g:4124:6: ( (lv_args_8_0= ruleExpression ) )
                            	    // InternalCoreDsl.g:4125:7: (lv_args_8_0= ruleExpression )
                            	    {
                            	    // InternalCoreDsl.g:4125:7: (lv_args_8_0= ruleExpression )
                            	    // InternalCoreDsl.g:4126:8: lv_args_8_0= ruleExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getPrimaryAccess().getArgsExpressionParserRuleCall_1_3_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_27);
                            	    lv_args_8_0=ruleExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getPrimaryRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"args",
                            	      									lv_args_8_0,
                            	      									"com.minres.coredsl.CoreDsl.Expression");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop87;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_1_4());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:4151:3: this_NumberLiteral_10= ruleNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getNumberLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NumberLiteral_10=ruleNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NumberLiteral_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:4160:3: this_ValueRef_11= ruleValueRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getValueRefParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ValueRef_11=ruleValueRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValueRef_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleValueRef"
    // InternalCoreDsl.g:4172:1: entryRuleValueRef returns [EObject current=null] : iv_ruleValueRef= ruleValueRef EOF ;
    public final EObject entryRuleValueRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRef = null;


        try {
            // InternalCoreDsl.g:4172:49: (iv_ruleValueRef= ruleValueRef EOF )
            // InternalCoreDsl.g:4173:2: iv_ruleValueRef= ruleValueRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValueRef=ruleValueRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueRef"


    // $ANTLR start "ruleValueRef"
    // InternalCoreDsl.g:4179:1: ruleValueRef returns [EObject current=null] : ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) | ( (otherlv_4= RULE_ID ) ) | ( ( RULE_ID )=> (otherlv_5= RULE_ID ) ) ) ( (lv_bitWidth_6_0= ruleBitSizeSpec ) )? ) ;
    public final EObject ruleValueRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_index_2_0 = null;

        EObject lv_bitWidth_6_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4185:2: ( ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) | ( (otherlv_4= RULE_ID ) ) | ( ( RULE_ID )=> (otherlv_5= RULE_ID ) ) ) ( (lv_bitWidth_6_0= ruleBitSizeSpec ) )? ) )
            // InternalCoreDsl.g:4186:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) | ( (otherlv_4= RULE_ID ) ) | ( ( RULE_ID )=> (otherlv_5= RULE_ID ) ) ) ( (lv_bitWidth_6_0= ruleBitSizeSpec ) )? )
            {
            // InternalCoreDsl.g:4186:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) | ( (otherlv_4= RULE_ID ) ) | ( ( RULE_ID )=> (otherlv_5= RULE_ID ) ) ) ( (lv_bitWidth_6_0= ruleBitSizeSpec ) )? )
            // InternalCoreDsl.g:4187:3: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) | ( (otherlv_4= RULE_ID ) ) | ( ( RULE_ID )=> (otherlv_5= RULE_ID ) ) ) ( (lv_bitWidth_6_0= ruleBitSizeSpec ) )?
            {
            // InternalCoreDsl.g:4187:3: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) | ( (otherlv_4= RULE_ID ) ) | ( ( RULE_ID )=> (otherlv_5= RULE_ID ) ) )
            int alt90=3;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_ID) ) {
                int LA90_1 = input.LA(2);

                if ( (LA90_1==31) ) {
                    alt90=1;
                }
                else if ( (true) ) {
                    alt90=2;
                }
                else if ( (synpred3_InternalCoreDsl()) ) {
                    alt90=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalCoreDsl.g:4188:4: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )
                    {
                    // InternalCoreDsl.g:4188:4: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )
                    // InternalCoreDsl.g:4189:5: ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']'
                    {
                    // InternalCoreDsl.g:4189:5: ( (otherlv_0= RULE_ID ) )
                    // InternalCoreDsl.g:4190:6: (otherlv_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:4190:6: (otherlv_0= RULE_ID )
                    // InternalCoreDsl.g:4191:7: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getValueRefRule());
                      							}
                      						
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_0, grammarAccess.getValueRefAccess().getValueIndexedVariableCrossReference_0_0_0_0());
                      						
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getValueRefAccess().getLeftSquareBracketKeyword_0_0_1());
                      				
                    }
                    // InternalCoreDsl.g:4206:5: ( (lv_index_2_0= ruleExpression ) )
                    // InternalCoreDsl.g:4207:6: (lv_index_2_0= ruleExpression )
                    {
                    // InternalCoreDsl.g:4207:6: (lv_index_2_0= ruleExpression )
                    // InternalCoreDsl.g:4208:7: lv_index_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getValueRefAccess().getIndexExpressionParserRuleCall_0_0_2_0());
                      						
                    }
                    pushFollow(FOLLOW_24);
                    lv_index_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getValueRefRule());
                      							}
                      							set(
                      								current,
                      								"index",
                      								lv_index_2_0,
                      								"com.minres.coredsl.CoreDsl.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,32,FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getValueRefAccess().getRightSquareBracketKeyword_0_0_3());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4231:4: ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:4231:4: ( (otherlv_4= RULE_ID ) )
                    // InternalCoreDsl.g:4232:5: (otherlv_4= RULE_ID )
                    {
                    // InternalCoreDsl.g:4232:5: (otherlv_4= RULE_ID )
                    // InternalCoreDsl.g:4233:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getValueRefRule());
                      						}
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_4, grammarAccess.getValueRefAccess().getValueScalarVariableCrossReference_0_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:4245:4: ( ( RULE_ID )=> (otherlv_5= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:4245:4: ( ( RULE_ID )=> (otherlv_5= RULE_ID ) )
                    // InternalCoreDsl.g:4246:5: ( RULE_ID )=> (otherlv_5= RULE_ID )
                    {
                    // InternalCoreDsl.g:4247:5: (otherlv_5= RULE_ID )
                    // InternalCoreDsl.g:4248:6: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getValueRefRule());
                      						}
                      					
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_5, grammarAccess.getValueRefAccess().getValueRValueCrossReference_0_2_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:4260:3: ( (lv_bitWidth_6_0= ruleBitSizeSpec ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==19) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalCoreDsl.g:4261:4: (lv_bitWidth_6_0= ruleBitSizeSpec )
                    {
                    // InternalCoreDsl.g:4261:4: (lv_bitWidth_6_0= ruleBitSizeSpec )
                    // InternalCoreDsl.g:4262:5: lv_bitWidth_6_0= ruleBitSizeSpec
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getValueRefAccess().getBitWidthBitSizeSpecParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_bitWidth_6_0=ruleBitSizeSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getValueRefRule());
                      					}
                      					set(
                      						current,
                      						"bitWidth",
                      						lv_bitWidth_6_0,
                      						"com.minres.coredsl.CoreDsl.BitSizeSpec");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueRef"


    // $ANTLR start "entryRuleBitSizeSpec"
    // InternalCoreDsl.g:4283:1: entryRuleBitSizeSpec returns [EObject current=null] : iv_ruleBitSizeSpec= ruleBitSizeSpec EOF ;
    public final EObject entryRuleBitSizeSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitSizeSpec = null;


        try {
            // InternalCoreDsl.g:4283:52: (iv_ruleBitSizeSpec= ruleBitSizeSpec EOF )
            // InternalCoreDsl.g:4284:2: iv_ruleBitSizeSpec= ruleBitSizeSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitSizeSpecRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitSizeSpec=ruleBitSizeSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitSizeSpec; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitSizeSpec"


    // $ANTLR start "ruleBitSizeSpec"
    // InternalCoreDsl.g:4290:1: ruleBitSizeSpec returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_value_1_0= RULE_NATURAL ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= '}' ) ;
    public final EObject ruleBitSizeSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:4296:2: ( (otherlv_0= '{' ( ( (lv_value_1_0= RULE_NATURAL ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= '}' ) )
            // InternalCoreDsl.g:4297:2: (otherlv_0= '{' ( ( (lv_value_1_0= RULE_NATURAL ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= '}' )
            {
            // InternalCoreDsl.g:4297:2: (otherlv_0= '{' ( ( (lv_value_1_0= RULE_NATURAL ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= '}' )
            // InternalCoreDsl.g:4298:3: otherlv_0= '{' ( ( (lv_value_1_0= RULE_NATURAL ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBitSizeSpecAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            // InternalCoreDsl.g:4302:3: ( ( (lv_value_1_0= RULE_NATURAL ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_NATURAL) ) {
                alt92=1;
            }
            else if ( (LA92_0==RULE_ID) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // InternalCoreDsl.g:4303:4: ( (lv_value_1_0= RULE_NATURAL ) )
                    {
                    // InternalCoreDsl.g:4303:4: ( (lv_value_1_0= RULE_NATURAL ) )
                    // InternalCoreDsl.g:4304:5: (lv_value_1_0= RULE_NATURAL )
                    {
                    // InternalCoreDsl.g:4304:5: (lv_value_1_0= RULE_NATURAL )
                    // InternalCoreDsl.g:4305:6: lv_value_1_0= RULE_NATURAL
                    {
                    lv_value_1_0=(Token)match(input,RULE_NATURAL,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getBitSizeSpecAccess().getValueNATURALTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBitSizeSpecRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_1_0,
                      							"com.minres.coredsl.CoreDsl.NATURAL");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4322:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:4322:4: ( (otherlv_2= RULE_ID ) )
                    // InternalCoreDsl.g:4323:5: (otherlv_2= RULE_ID )
                    {
                    // InternalCoreDsl.g:4323:5: (otherlv_2= RULE_ID )
                    // InternalCoreDsl.g:4324:6: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBitSizeSpecRule());
                      						}
                      					
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_2, grammarAccess.getBitSizeSpecAccess().getConstantConstantCrossReference_1_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBitSizeSpecAccess().getRightCurlyBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitSizeSpec"


    // $ANTLR start "ruleDataType"
    // InternalCoreDsl.g:4344:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'u' ) | (enumLiteral_2= 's' ) | (enumLiteral_3= 'f' ) | (enumLiteral_4= 'd' ) | (enumLiteral_5= 'q' ) | (enumLiteral_6= 'b' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:4350:2: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'u' ) | (enumLiteral_2= 's' ) | (enumLiteral_3= 'f' ) | (enumLiteral_4= 'd' ) | (enumLiteral_5= 'q' ) | (enumLiteral_6= 'b' ) ) )
            // InternalCoreDsl.g:4351:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'u' ) | (enumLiteral_2= 's' ) | (enumLiteral_3= 'f' ) | (enumLiteral_4= 'd' ) | (enumLiteral_5= 'q' ) | (enumLiteral_6= 'b' ) )
            {
            // InternalCoreDsl.g:4351:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'u' ) | (enumLiteral_2= 's' ) | (enumLiteral_3= 'f' ) | (enumLiteral_4= 'd' ) | (enumLiteral_5= 'q' ) | (enumLiteral_6= 'b' ) )
            int alt93=7;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt93=1;
                }
                break;
            case 66:
                {
                alt93=2;
                }
                break;
            case 67:
                {
                alt93=3;
                }
                break;
            case 68:
                {
                alt93=4;
                }
                break;
            case 69:
                {
                alt93=5;
                }
                break;
            case 70:
                {
                alt93=6;
                }
                break;
            case 71:
                {
                alt93=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalCoreDsl.g:4352:3: (enumLiteral_0= 'NONE' )
                    {
                    // InternalCoreDsl.g:4352:3: (enumLiteral_0= 'NONE' )
                    // InternalCoreDsl.g:4353:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypeAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getNONEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4360:3: (enumLiteral_1= 'u' )
                    {
                    // InternalCoreDsl.g:4360:3: (enumLiteral_1= 'u' )
                    // InternalCoreDsl.g:4361:4: enumLiteral_1= 'u'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypeAccess().getUNSIGNEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getUNSIGNEDEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:4368:3: (enumLiteral_2= 's' )
                    {
                    // InternalCoreDsl.g:4368:3: (enumLiteral_2= 's' )
                    // InternalCoreDsl.g:4369:4: enumLiteral_2= 's'
                    {
                    enumLiteral_2=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypeAccess().getSIGNEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getSIGNEDEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:4376:3: (enumLiteral_3= 'f' )
                    {
                    // InternalCoreDsl.g:4376:3: (enumLiteral_3= 'f' )
                    // InternalCoreDsl.g:4377:4: enumLiteral_3= 'f'
                    {
                    enumLiteral_3=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypeAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getFLOATEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:4384:3: (enumLiteral_4= 'd' )
                    {
                    // InternalCoreDsl.g:4384:3: (enumLiteral_4= 'd' )
                    // InternalCoreDsl.g:4385:4: enumLiteral_4= 'd'
                    {
                    enumLiteral_4=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypeAccess().getDOUBLEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getDataTypeAccess().getDOUBLEEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalCoreDsl.g:4392:3: (enumLiteral_5= 'q' )
                    {
                    // InternalCoreDsl.g:4392:3: (enumLiteral_5= 'q' )
                    // InternalCoreDsl.g:4393:4: enumLiteral_5= 'q'
                    {
                    enumLiteral_5=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypeAccess().getQUADEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getDataTypeAccess().getQUADEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalCoreDsl.g:4400:3: (enumLiteral_6= 'b' )
                    {
                    // InternalCoreDsl.g:4400:3: (enumLiteral_6= 'b' )
                    // InternalCoreDsl.g:4401:4: enumLiteral_6= 'b'
                    {
                    enumLiteral_6=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypeAccess().getBOOLEANEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getDataTypeAccess().getBOOLEANEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "ruleRegAttribute"
    // InternalCoreDsl.g:4411:1: ruleRegAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'is_pc' ) | (enumLiteral_1= 'delete' ) ) ;
    public final Enumerator ruleRegAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:4417:2: ( ( (enumLiteral_0= 'is_pc' ) | (enumLiteral_1= 'delete' ) ) )
            // InternalCoreDsl.g:4418:2: ( (enumLiteral_0= 'is_pc' ) | (enumLiteral_1= 'delete' ) )
            {
            // InternalCoreDsl.g:4418:2: ( (enumLiteral_0= 'is_pc' ) | (enumLiteral_1= 'delete' ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==72) ) {
                alt94=1;
            }
            else if ( (LA94_0==73) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalCoreDsl.g:4419:3: (enumLiteral_0= 'is_pc' )
                    {
                    // InternalCoreDsl.g:4419:3: (enumLiteral_0= 'is_pc' )
                    // InternalCoreDsl.g:4420:4: enumLiteral_0= 'is_pc'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegAttributeAccess().getPCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegAttributeAccess().getPCEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4427:3: (enumLiteral_1= 'delete' )
                    {
                    // InternalCoreDsl.g:4427:3: (enumLiteral_1= 'delete' )
                    // InternalCoreDsl.g:4428:4: enumLiteral_1= 'delete'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegAttributeAccess().getDELEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRegAttributeAccess().getDELEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegAttribute"


    // $ANTLR start "ruleConstAttribute"
    // InternalCoreDsl.g:4438:1: ruleConstAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'is_reg_with' ) | (enumLiteral_1= 'is_addr_width' ) ) ;
    public final Enumerator ruleConstAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:4444:2: ( ( (enumLiteral_0= 'is_reg_with' ) | (enumLiteral_1= 'is_addr_width' ) ) )
            // InternalCoreDsl.g:4445:2: ( (enumLiteral_0= 'is_reg_with' ) | (enumLiteral_1= 'is_addr_width' ) )
            {
            // InternalCoreDsl.g:4445:2: ( (enumLiteral_0= 'is_reg_with' ) | (enumLiteral_1= 'is_addr_width' ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==74) ) {
                alt95=1;
            }
            else if ( (LA95_0==75) ) {
                alt95=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalCoreDsl.g:4446:3: (enumLiteral_0= 'is_reg_with' )
                    {
                    // InternalCoreDsl.g:4446:3: (enumLiteral_0= 'is_reg_with' )
                    // InternalCoreDsl.g:4447:4: enumLiteral_0= 'is_reg_with'
                    {
                    enumLiteral_0=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getConstAttributeAccess().getREG_WIDTHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getConstAttributeAccess().getREG_WIDTHEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4454:3: (enumLiteral_1= 'is_addr_width' )
                    {
                    // InternalCoreDsl.g:4454:3: (enumLiteral_1= 'is_addr_width' )
                    // InternalCoreDsl.g:4455:4: enumLiteral_1= 'is_addr_width'
                    {
                    enumLiteral_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getConstAttributeAccess().getADDR_WIDTHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getConstAttributeAccess().getADDR_WIDTHEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstAttribute"


    // $ANTLR start "ruleInstrAttribute"
    // InternalCoreDsl.g:4465:1: ruleInstrAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'no_cont' ) | (enumLiteral_1= 'cond' ) | (enumLiteral_2= 'flush' ) ) ;
    public final Enumerator ruleInstrAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:4471:2: ( ( (enumLiteral_0= 'no_cont' ) | (enumLiteral_1= 'cond' ) | (enumLiteral_2= 'flush' ) ) )
            // InternalCoreDsl.g:4472:2: ( (enumLiteral_0= 'no_cont' ) | (enumLiteral_1= 'cond' ) | (enumLiteral_2= 'flush' ) )
            {
            // InternalCoreDsl.g:4472:2: ( (enumLiteral_0= 'no_cont' ) | (enumLiteral_1= 'cond' ) | (enumLiteral_2= 'flush' ) )
            int alt96=3;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt96=1;
                }
                break;
            case 77:
                {
                alt96=2;
                }
                break;
            case 78:
                {
                alt96=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // InternalCoreDsl.g:4473:3: (enumLiteral_0= 'no_cont' )
                    {
                    // InternalCoreDsl.g:4473:3: (enumLiteral_0= 'no_cont' )
                    // InternalCoreDsl.g:4474:4: enumLiteral_0= 'no_cont'
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getNO_CONTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInstrAttributeAccess().getNO_CONTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4481:3: (enumLiteral_1= 'cond' )
                    {
                    // InternalCoreDsl.g:4481:3: (enumLiteral_1= 'cond' )
                    // InternalCoreDsl.g:4482:4: enumLiteral_1= 'cond'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getCONDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getInstrAttributeAccess().getCONDEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:4489:3: (enumLiteral_2= 'flush' )
                    {
                    // InternalCoreDsl.g:4489:3: (enumLiteral_2= 'flush' )
                    // InternalCoreDsl.g:4490:4: enumLiteral_2= 'flush'
                    {
                    enumLiteral_2=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getFLUSHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getInstrAttributeAccess().getFLUSHEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstrAttribute"

    // $ANTLR start synpred1_InternalCoreDsl
    public final void synpred1_InternalCoreDsl_fragment() throws RecognitionException {   
        // InternalCoreDsl.g:1770:5: ( 'else' )
        // InternalCoreDsl.g:1770:6: 'else'
        {
        match(input,41,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalCoreDsl

    // $ANTLR start synpred3_InternalCoreDsl
    public final void synpred3_InternalCoreDsl_fragment() throws RecognitionException {   
        // InternalCoreDsl.g:4246:5: ( RULE_ID )
        // InternalCoreDsl.g:4246:6: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalCoreDsl

    // Delegated rules

    public final boolean synpred3_InternalCoreDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalCoreDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalCoreDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalCoreDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA32 dfa32 = new DFA32(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\10\12\uffff";
    static final String dfa_3s = "\1\5\7\0\3\uffff";
    static final String dfa_4s = "\1\56\7\0\3\uffff";
    static final String dfa_5s = "\10\uffff\1\3\1\2\1\1";
    static final String dfa_6s = "\1\uffff\1\4\1\2\1\6\1\5\1\3\1\1\1\0\3\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\2\uffff\1\7\15\uffff\1\1\15\uffff\1\3\3\uffff\1\5\1\uffff\1\6\3\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()+ loopback of 998:5: ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleInstrAttribute ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleInstrAttribute ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'encoding' otherlv_9= ':' ( (lv_encoding_10_0= ruleEncoding ) ) otherlv_11= ';' ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_12= 'args_disass' otherlv_13= ':' ( (lv_disass_14_0= RULE_STRING ) ) otherlv_15= ';' )? ( (lv_operation_16_0= ruleOperation ) )? otherlv_17= '}' ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_7 = input.LA(1);

                         
                        int index32_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getInstructionAccess().getUnorderedGroup()) ) {s = 8;}

                         
                        input.seek(index32_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_6 = input.LA(1);

                         
                        int index32_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getInstructionAccess().getUnorderedGroup()) ) {s = 8;}

                         
                        input.seek(index32_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 0) ) {s = 10;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getInstructionAccess().getUnorderedGroup()) ) {s = 8;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_5 = input.LA(1);

                         
                        int index32_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getInstructionAccess().getUnorderedGroup()) ) {s = 8;}

                         
                        input.seek(index32_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getInstructionAccess().getUnorderedGroup()) ) {s = 8;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_4 = input.LA(1);

                         
                        int index32_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getInstructionAccess().getUnorderedGroup()) ) {s = 8;}

                         
                        input.seek(index32_4);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getInstructionAccess().getUnorderedGroup(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getInstructionAccess().getUnorderedGroup()) ) {s = 8;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000004030000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000004020002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000003D00000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000003400000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000100080000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000451000400120L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008080000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000013D00000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000200080000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400200000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000451000400122L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000450000400120L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000002L,0x00000000000000FEL});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000004000000000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000450000000122L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x8C00000200000260L,0x0000000000000001L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000008000080000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000450000080120L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000450000000120L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000200200000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000200000260L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x00E0008000000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x7000000000000002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x8C00000600000260L,0x0000000000000001L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000080002L});

}
