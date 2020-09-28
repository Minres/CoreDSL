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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BVAL", "RULE_INTEGER", "RULE_FLOAT", "RULE_BOOLEAN", "RULE_CHARCONST", "RULE_DECIMALCONSTANT", "RULE_BINARYCONSTANT", "RULE_HEXADECIMALCONSTANT", "RULE_OCTALCONSTANT", "RULE_VLOGCONSTANT", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'InstructionSet'", "'extends'", "'{'", "'constants'", "'}'", "'address_spaces'", "'registers'", "'functions'", "'instructions'", "'Core'", "'provides'", "','", "'[['", "']]'", "'encoding'", "':'", "';'", "'args_disass'", "'behavior'", "'|'", "'\\''", "'['", "']'", "'extern'", "'('", "')'", "'case'", "'default'", "'if'", "'else'", "'switch'", "'while'", "'do'", "'for'", "'continue'", "'break'", "'return'", "'*'", "'typedef'", "'<'", "'>'", "'enum'", "'='", "'.'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'?'", "'||'", "'&&'", "'^'", "'&'", "'=='", "'!='", "'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'/'", "'%'", "'++'", "'--'", "'sizeof'", "'~'", "'!'", "'->'", "'u8'", "'u'", "'U'", "'L'", "'l'", "'ll'", "'LL'", "'f'", "'F'", "'bool'", "'char'", "'short'", "'int'", "'long'", "'signed'", "'unsigned'", "'float'", "'double'", "'frac'", "'accum'", "'const'", "'volatile'", "'static'", "'NONE'", "'is_pc'", "'delete'", "'no_cont'", "'cond'", "'flush'", "'struct'", "'union'", "'s'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
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
    public static final int RULE_INT=16;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=17;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int RULE_BINARYCONSTANT=12;
    public static final int RULE_OCTALCONSTANT=14;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_VLOGCONSTANT=15;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=8;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int RULE_HEXADECIMALCONSTANT=13;
    public static final int T__90=90;
    public static final int RULE_BOOLEAN=9;
    public static final int RULE_CHARCONST=10;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DECIMALCONSTANT=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int RULE_BVAL=6;
    public static final int T__120=120;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=18;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=19;
    public static final int RULE_ANY_OTHER=20;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=7;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

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

                if ( (LA1_0==21) ) {
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

                if ( (LA2_0==22||LA2_0==31) ) {
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
            otherlv_0=(Token)match(input,21,FOLLOW_5); if (state.failed) return current;
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

            if ( (LA3_0==22) ) {
                alt3=1;
            }
            else if ( (LA3_0==31) ) {
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
    // InternalCoreDsl.g:206:1: ruleInstructionSet returns [EObject current=null] : (otherlv_0= 'InstructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )? (otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}' )? (otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}' )? (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )? (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' ) otherlv_25= '}' ) ;
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
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        EObject lv_constants_7_0 = null;

        EObject lv_spaces_11_0 = null;

        EObject lv_regs_15_0 = null;

        EObject lv_func_19_0 = null;

        EObject lv_instr_23_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:212:2: ( (otherlv_0= 'InstructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )? (otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}' )? (otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}' )? (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )? (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' ) otherlv_25= '}' ) )
            // InternalCoreDsl.g:213:2: (otherlv_0= 'InstructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )? (otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}' )? (otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}' )? (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )? (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' ) otherlv_25= '}' )
            {
            // InternalCoreDsl.g:213:2: (otherlv_0= 'InstructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )? (otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}' )? (otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}' )? (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )? (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' ) otherlv_25= '}' )
            // InternalCoreDsl.g:214:3: otherlv_0= 'InstructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )? (otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}' )? (otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}' )? (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )? (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' ) otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getInstructionSetAccess().getInstructionSetKeyword_0());
              		
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

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalCoreDsl.g:237:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_6); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,24,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:259:3: (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalCoreDsl.g:260:4: otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getInstructionSetAccess().getConstantsKeyword_4_0());
                      			
                    }
                    otherlv_6=(Token)match(input,24,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:268:4: ( (lv_constants_7_0= ruleDeclaration ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID||LA5_0==34||LA5_0==45||LA5_0==60||LA5_0==63||(LA5_0>=106 && LA5_0<=119)||(LA5_0>=126 && LA5_0<=127)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalCoreDsl.g:269:5: (lv_constants_7_0= ruleDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:269:5: (lv_constants_7_0= ruleDeclaration )
                    	    // InternalCoreDsl.g:270:6: lv_constants_7_0= ruleDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getInstructionSetAccess().getConstantsDeclarationParserRuleCall_4_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_constants_7_0=ruleDeclaration();

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
                    	      							"com.minres.coredsl.CoreDsl.Declaration");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);

                    otherlv_8=(Token)match(input,26,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:292:3: (otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalCoreDsl.g:293:4: otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getInstructionSetAccess().getAddress_spacesKeyword_5_0());
                      			
                    }
                    otherlv_10=(Token)match(input,24,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_5_1());
                      			
                    }
                    // InternalCoreDsl.g:301:4: ( (lv_spaces_11_0= ruleDeclaration ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID||LA7_0==34||LA7_0==45||LA7_0==60||LA7_0==63||(LA7_0>=106 && LA7_0<=119)||(LA7_0>=126 && LA7_0<=127)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalCoreDsl.g:302:5: (lv_spaces_11_0= ruleDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:302:5: (lv_spaces_11_0= ruleDeclaration )
                    	    // InternalCoreDsl.g:303:6: lv_spaces_11_0= ruleDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getInstructionSetAccess().getSpacesDeclarationParserRuleCall_5_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_spaces_11_0=ruleDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"spaces",
                    	      							lv_spaces_11_0,
                    	      							"com.minres.coredsl.CoreDsl.Declaration");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    otherlv_12=(Token)match(input,26,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:325:3: (otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalCoreDsl.g:326:4: otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getInstructionSetAccess().getRegistersKeyword_6_0());
                      			
                    }
                    otherlv_14=(Token)match(input,24,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_6_1());
                      			
                    }
                    // InternalCoreDsl.g:334:4: ( (lv_regs_15_0= ruleDeclaration ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID||LA9_0==34||LA9_0==45||LA9_0==60||LA9_0==63||(LA9_0>=106 && LA9_0<=119)||(LA9_0>=126 && LA9_0<=127)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalCoreDsl.g:335:5: (lv_regs_15_0= ruleDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:335:5: (lv_regs_15_0= ruleDeclaration )
                    	    // InternalCoreDsl.g:336:6: lv_regs_15_0= ruleDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getInstructionSetAccess().getRegsDeclarationParserRuleCall_6_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_regs_15_0=ruleDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"regs",
                    	      							lv_regs_15_0,
                    	      							"com.minres.coredsl.CoreDsl.Declaration");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    otherlv_16=(Token)match(input,26,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:358:3: (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==29) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalCoreDsl.g:359:4: otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getInstructionSetAccess().getFunctionsKeyword_7_0());
                      			
                    }
                    otherlv_18=(Token)match(input,24,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_7_1());
                      			
                    }
                    // InternalCoreDsl.g:367:4: ( (lv_func_19_0= ruleFunctionDefinition ) )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID||LA11_0==45||LA11_0==63||(LA11_0>=106 && LA11_0<=116)||(LA11_0>=126 && LA11_0<=127)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalCoreDsl.g:368:5: (lv_func_19_0= ruleFunctionDefinition )
                    	    {
                    	    // InternalCoreDsl.g:368:5: (lv_func_19_0= ruleFunctionDefinition )
                    	    // InternalCoreDsl.g:369:6: lv_func_19_0= ruleFunctionDefinition
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getInstructionSetAccess().getFuncFunctionDefinitionParserRuleCall_7_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_16);
                    	    lv_func_19_0=ruleFunctionDefinition();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"func",
                    	      							lv_func_19_0,
                    	      							"com.minres.coredsl.CoreDsl.FunctionDefinition");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    otherlv_20=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_7_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:391:3: (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' )
            // InternalCoreDsl.g:392:4: otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}'
            {
            otherlv_21=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_21, grammarAccess.getInstructionSetAccess().getInstructionsKeyword_8_0());
              			
            }
            otherlv_22=(Token)match(input,24,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_22, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_8_1());
              			
            }
            // InternalCoreDsl.g:400:4: ( (lv_instr_23_0= ruleInstruction ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalCoreDsl.g:401:5: (lv_instr_23_0= ruleInstruction )
            	    {
            	    // InternalCoreDsl.g:401:5: (lv_instr_23_0= ruleInstruction )
            	    // InternalCoreDsl.g:402:6: lv_instr_23_0= ruleInstruction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getInstructionSetAccess().getInstrInstructionParserRuleCall_8_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
            	    lv_instr_23_0=ruleInstruction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getInstructionSetRule());
            	      						}
            	      						add(
            	      							current,
            	      							"instr",
            	      							lv_instr_23_0,
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

            otherlv_24=(Token)match(input,26,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_24, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_8_3());
              			
            }

            }

            otherlv_25=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_25, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_9());
              		
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
    // InternalCoreDsl.g:432:1: entryRuleCoreDef returns [EObject current=null] : iv_ruleCoreDef= ruleCoreDef EOF ;
    public final EObject entryRuleCoreDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCoreDef = null;


        try {
            // InternalCoreDsl.g:432:48: (iv_ruleCoreDef= ruleCoreDef EOF )
            // InternalCoreDsl.g:433:2: iv_ruleCoreDef= ruleCoreDef EOF
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
    // InternalCoreDsl.g:439:1: ruleCoreDef returns [EObject current=null] : (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )? (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}' )? (otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}' )? (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )? otherlv_23= '}' ) ;
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
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        EObject lv_constants_9_0 = null;

        EObject lv_spaces_13_0 = null;

        EObject lv_regs_17_0 = null;

        EObject lv_instr_21_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:445:2: ( (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )? (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}' )? (otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}' )? (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )? otherlv_23= '}' ) )
            // InternalCoreDsl.g:446:2: (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )? (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}' )? (otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}' )? (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )? otherlv_23= '}' )
            {
            // InternalCoreDsl.g:446:2: (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )? (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}' )? (otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}' )? (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )? otherlv_23= '}' )
            // InternalCoreDsl.g:447:3: otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )? (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}' )? (otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}' )? (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )? otherlv_23= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCoreDefAccess().getCoreKeyword_0());
              		
            }
            // InternalCoreDsl.g:451:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalCoreDsl.g:452:4: (lv_name_1_0= RULE_ID )
            {
            // InternalCoreDsl.g:452:4: (lv_name_1_0= RULE_ID )
            // InternalCoreDsl.g:453:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
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

            // InternalCoreDsl.g:469:3: (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==32) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalCoreDsl.g:470:4: otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getCoreDefAccess().getProvidesKeyword_2_0());
                      			
                    }
                    // InternalCoreDsl.g:474:4: ( (otherlv_3= RULE_ID ) )
                    // InternalCoreDsl.g:475:5: (otherlv_3= RULE_ID )
                    {
                    // InternalCoreDsl.g:475:5: (otherlv_3= RULE_ID )
                    // InternalCoreDsl.g:476:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCoreDefRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getCoreDefAccess().getContributingTypeInstructionSetCrossReference_2_1_0());
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:487:4: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==33) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalCoreDsl.g:488:5: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getCoreDefAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:492:5: ( (otherlv_5= RULE_ID ) )
                    	    // InternalCoreDsl.g:493:6: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalCoreDsl.g:493:6: (otherlv_5= RULE_ID )
                    	    // InternalCoreDsl.g:494:7: otherlv_5= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getCoreDefRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_5, grammarAccess.getCoreDefAccess().getContributingTypeInstructionSetCrossReference_2_2_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,24,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:511:3: (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalCoreDsl.g:512:4: otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,25,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getCoreDefAccess().getConstantsKeyword_4_0());
                      			
                    }
                    otherlv_8=(Token)match(input,24,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:520:4: ( (lv_constants_9_0= ruleDeclaration ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID||LA16_0==34||LA16_0==45||LA16_0==60||LA16_0==63||(LA16_0>=106 && LA16_0<=119)||(LA16_0>=126 && LA16_0<=127)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalCoreDsl.g:521:5: (lv_constants_9_0= ruleDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:521:5: (lv_constants_9_0= ruleDeclaration )
                    	    // InternalCoreDsl.g:522:6: lv_constants_9_0= ruleDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCoreDefAccess().getConstantsDeclarationParserRuleCall_4_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_constants_9_0=ruleDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"constants",
                    	      							lv_constants_9_0,
                    	      							"com.minres.coredsl.CoreDsl.Declaration");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    otherlv_10=(Token)match(input,26,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:544:3: (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalCoreDsl.g:545:4: otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getCoreDefAccess().getAddress_spacesKeyword_5_0());
                      			
                    }
                    otherlv_12=(Token)match(input,24,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_5_1());
                      			
                    }
                    // InternalCoreDsl.g:553:4: ( (lv_spaces_13_0= ruleDeclaration ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_ID||LA18_0==34||LA18_0==45||LA18_0==60||LA18_0==63||(LA18_0>=106 && LA18_0<=119)||(LA18_0>=126 && LA18_0<=127)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalCoreDsl.g:554:5: (lv_spaces_13_0= ruleDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:554:5: (lv_spaces_13_0= ruleDeclaration )
                    	    // InternalCoreDsl.g:555:6: lv_spaces_13_0= ruleDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCoreDefAccess().getSpacesDeclarationParserRuleCall_5_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_spaces_13_0=ruleDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"spaces",
                    	      							lv_spaces_13_0,
                    	      							"com.minres.coredsl.CoreDsl.Declaration");
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

                    otherlv_14=(Token)match(input,26,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:577:3: (otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalCoreDsl.g:578:4: otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getCoreDefAccess().getRegistersKeyword_6_0());
                      			
                    }
                    otherlv_16=(Token)match(input,24,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_6_1());
                      			
                    }
                    // InternalCoreDsl.g:586:4: ( (lv_regs_17_0= ruleDeclaration ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID||LA20_0==34||LA20_0==45||LA20_0==60||LA20_0==63||(LA20_0>=106 && LA20_0<=119)||(LA20_0>=126 && LA20_0<=127)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalCoreDsl.g:587:5: (lv_regs_17_0= ruleDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:587:5: (lv_regs_17_0= ruleDeclaration )
                    	    // InternalCoreDsl.g:588:6: lv_regs_17_0= ruleDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCoreDefAccess().getRegsDeclarationParserRuleCall_6_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_regs_17_0=ruleDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"regs",
                    	      							lv_regs_17_0,
                    	      							"com.minres.coredsl.CoreDsl.Declaration");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    otherlv_18=(Token)match(input,26,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:610:3: (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalCoreDsl.g:611:4: otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getCoreDefAccess().getInstructionsKeyword_7_0());
                      			
                    }
                    otherlv_20=(Token)match(input,24,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_7_1());
                      			
                    }
                    // InternalCoreDsl.g:619:4: ( (lv_instr_21_0= ruleInstruction ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_ID) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalCoreDsl.g:620:5: (lv_instr_21_0= ruleInstruction )
                    	    {
                    	    // InternalCoreDsl.g:620:5: (lv_instr_21_0= ruleInstruction )
                    	    // InternalCoreDsl.g:621:6: lv_instr_21_0= ruleInstruction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCoreDefAccess().getInstrInstructionParserRuleCall_7_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_18);
                    	    lv_instr_21_0=ruleInstruction();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"instr",
                    	      							lv_instr_21_0,
                    	      							"com.minres.coredsl.CoreDsl.Instruction");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    otherlv_22=(Token)match(input,26,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_22, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_7_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_23=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_23, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_8());
              		
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


    // $ANTLR start "entryRuleInstruction"
    // InternalCoreDsl.g:651:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // InternalCoreDsl.g:651:52: (iv_ruleInstruction= ruleInstruction EOF )
            // InternalCoreDsl.g:652:2: iv_ruleInstruction= ruleInstruction EOF
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
    // InternalCoreDsl.g:658:1: ruleInstruction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[[' ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* otherlv_5= ']]' )? otherlv_6= '{' (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' ) (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )? (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) ) otherlv_18= '}' ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token lv_disass_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Enumerator lv_attributes_2_0 = null;

        Enumerator lv_attributes_4_0 = null;

        EObject lv_encoding_9_0 = null;

        EObject lv_behavior_17_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:664:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[[' ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* otherlv_5= ']]' )? otherlv_6= '{' (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' ) (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )? (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) ) otherlv_18= '}' ) )
            // InternalCoreDsl.g:665:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[[' ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* otherlv_5= ']]' )? otherlv_6= '{' (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' ) (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )? (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) ) otherlv_18= '}' )
            {
            // InternalCoreDsl.g:665:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[[' ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* otherlv_5= ']]' )? otherlv_6= '{' (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' ) (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )? (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) ) otherlv_18= '}' )
            // InternalCoreDsl.g:666:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[[' ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* otherlv_5= ']]' )? otherlv_6= '{' (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' ) (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )? (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) ) otherlv_18= '}'
            {
            // InternalCoreDsl.g:666:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:667:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:667:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:668:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getInstructionAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInstructionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            // InternalCoreDsl.g:684:3: (otherlv_1= '[[' ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* otherlv_5= ']]' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalCoreDsl.g:685:4: otherlv_1= '[[' ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* otherlv_5= ']]'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInstructionAccess().getLeftSquareBracketLeftSquareBracketKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:689:4: ( (lv_attributes_2_0= ruleInstrAttribute ) )
                    // InternalCoreDsl.g:690:5: (lv_attributes_2_0= ruleInstrAttribute )
                    {
                    // InternalCoreDsl.g:690:5: (lv_attributes_2_0= ruleInstrAttribute )
                    // InternalCoreDsl.g:691:6: lv_attributes_2_0= ruleInstrAttribute
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionAccess().getAttributesInstrAttributeEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    lv_attributes_2_0=ruleInstrAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionRule());
                      						}
                      						add(
                      							current,
                      							"attributes",
                      							lv_attributes_2_0,
                      							"com.minres.coredsl.CoreDsl.InstrAttribute");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:708:4: (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==33) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalCoreDsl.g:709:5: otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) )
                    	    {
                    	    otherlv_3=(Token)match(input,33,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getInstructionAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:713:5: ( (lv_attributes_4_0= ruleInstrAttribute ) )
                    	    // InternalCoreDsl.g:714:6: (lv_attributes_4_0= ruleInstrAttribute )
                    	    {
                    	    // InternalCoreDsl.g:714:6: (lv_attributes_4_0= ruleInstrAttribute )
                    	    // InternalCoreDsl.g:715:7: lv_attributes_4_0= ruleInstrAttribute
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getInstructionAccess().getAttributesInstrAttributeEnumRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
                    	    lv_attributes_4_0=ruleInstrAttribute();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getInstructionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"attributes",
                    	      								lv_attributes_4_0,
                    	      								"com.minres.coredsl.CoreDsl.InstrAttribute");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,35,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getInstructionAccess().getRightSquareBracketRightSquareBracketKeyword_1_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_6=(Token)match(input,24,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getInstructionAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalCoreDsl.g:742:3: (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' )
            // InternalCoreDsl.g:743:4: otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';'
            {
            otherlv_7=(Token)match(input,36,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_7, grammarAccess.getInstructionAccess().getEncodingKeyword_3_0());
              			
            }
            otherlv_8=(Token)match(input,37,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_8, grammarAccess.getInstructionAccess().getColonKeyword_3_1());
              			
            }
            // InternalCoreDsl.g:751:4: ( (lv_encoding_9_0= ruleEncoding ) )
            // InternalCoreDsl.g:752:5: (lv_encoding_9_0= ruleEncoding )
            {
            // InternalCoreDsl.g:752:5: (lv_encoding_9_0= ruleEncoding )
            // InternalCoreDsl.g:753:6: lv_encoding_9_0= ruleEncoding
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getInstructionAccess().getEncodingEncodingParserRuleCall_3_2_0());
              					
            }
            pushFollow(FOLLOW_32);
            lv_encoding_9_0=ruleEncoding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getInstructionRule());
              						}
              						set(
              							current,
              							"encoding",
              							lv_encoding_9_0,
              							"com.minres.coredsl.CoreDsl.Encoding");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            otherlv_10=(Token)match(input,38,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_10, grammarAccess.getInstructionAccess().getSemicolonKeyword_3_3());
              			
            }

            }

            // InternalCoreDsl.g:775:3: (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==39) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalCoreDsl.g:776:4: otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';'
                    {
                    otherlv_11=(Token)match(input,39,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getInstructionAccess().getArgs_disassKeyword_4_0());
                      			
                    }
                    otherlv_12=(Token)match(input,37,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getInstructionAccess().getColonKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:784:4: ( (lv_disass_13_0= RULE_STRING ) )
                    // InternalCoreDsl.g:785:5: (lv_disass_13_0= RULE_STRING )
                    {
                    // InternalCoreDsl.g:785:5: (lv_disass_13_0= RULE_STRING )
                    // InternalCoreDsl.g:786:6: lv_disass_13_0= RULE_STRING
                    {
                    lv_disass_13_0=(Token)match(input,RULE_STRING,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_disass_13_0, grammarAccess.getInstructionAccess().getDisassSTRINGTerminalRuleCall_4_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getInstructionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"disass",
                      							lv_disass_13_0,
                      							"com.minres.coredsl.CoreDsl.STRING");
                      					
                    }

                    }


                    }

                    otherlv_14=(Token)match(input,38,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getInstructionAccess().getSemicolonKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:807:3: (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) )
            // InternalCoreDsl.g:808:4: otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) )
            {
            otherlv_15=(Token)match(input,40,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_15, grammarAccess.getInstructionAccess().getBehaviorKeyword_5_0());
              			
            }
            otherlv_16=(Token)match(input,37,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_16, grammarAccess.getInstructionAccess().getColonKeyword_5_1());
              			
            }
            // InternalCoreDsl.g:816:4: ( (lv_behavior_17_0= ruleCompoundStatement ) )
            // InternalCoreDsl.g:817:5: (lv_behavior_17_0= ruleCompoundStatement )
            {
            // InternalCoreDsl.g:817:5: (lv_behavior_17_0= ruleCompoundStatement )
            // InternalCoreDsl.g:818:6: lv_behavior_17_0= ruleCompoundStatement
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getInstructionAccess().getBehaviorCompoundStatementParserRuleCall_5_2_0());
              					
            }
            pushFollow(FOLLOW_19);
            lv_behavior_17_0=ruleCompoundStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getInstructionRule());
              						}
              						set(
              							current,
              							"behavior",
              							lv_behavior_17_0,
              							"com.minres.coredsl.CoreDsl.CompoundStatement");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }

            otherlv_18=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_18, grammarAccess.getInstructionAccess().getRightCurlyBracketKeyword_6());
              		
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
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleEncoding"
    // InternalCoreDsl.g:844:1: entryRuleEncoding returns [EObject current=null] : iv_ruleEncoding= ruleEncoding EOF ;
    public final EObject entryRuleEncoding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEncoding = null;


        try {
            // InternalCoreDsl.g:844:49: (iv_ruleEncoding= ruleEncoding EOF )
            // InternalCoreDsl.g:845:2: iv_ruleEncoding= ruleEncoding EOF
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
    // InternalCoreDsl.g:851:1: ruleEncoding returns [EObject current=null] : ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )* ) ;
    public final EObject ruleEncoding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fields_0_0 = null;

        EObject lv_fields_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:857:2: ( ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )* ) )
            // InternalCoreDsl.g:858:2: ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )* )
            {
            // InternalCoreDsl.g:858:2: ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )* )
            // InternalCoreDsl.g:859:3: ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )*
            {
            // InternalCoreDsl.g:859:3: ( (lv_fields_0_0= ruleField ) )
            // InternalCoreDsl.g:860:4: (lv_fields_0_0= ruleField )
            {
            // InternalCoreDsl.g:860:4: (lv_fields_0_0= ruleField )
            // InternalCoreDsl.g:861:5: lv_fields_0_0= ruleField
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEncodingAccess().getFieldsFieldParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
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

            // InternalCoreDsl.g:878:3: (otherlv_1= '|' ( (lv_fields_2_0= ruleField ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==41) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalCoreDsl.g:879:4: otherlv_1= '|' ( (lv_fields_2_0= ruleField ) )
            	    {
            	    otherlv_1=(Token)match(input,41,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getEncodingAccess().getVerticalLineKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:883:4: ( (lv_fields_2_0= ruleField ) )
            	    // InternalCoreDsl.g:884:5: (lv_fields_2_0= ruleField )
            	    {
            	    // InternalCoreDsl.g:884:5: (lv_fields_2_0= ruleField )
            	    // InternalCoreDsl.g:885:6: lv_fields_2_0= ruleField
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEncodingAccess().getFieldsFieldParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
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
            	    break loop27;
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
    // InternalCoreDsl.g:907:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalCoreDsl.g:907:46: (iv_ruleField= ruleField EOF )
            // InternalCoreDsl.g:908:2: iv_ruleField= ruleField EOF
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
    // InternalCoreDsl.g:914:1: ruleField returns [EObject current=null] : (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        EObject this_BitValue_0 = null;

        EObject this_BitField_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:920:2: ( (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField ) )
            // InternalCoreDsl.g:921:2: (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField )
            {
            // InternalCoreDsl.g:921:2: (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_BVAL) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_ID) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalCoreDsl.g:922:3: this_BitValue_0= ruleBitValue
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
                    // InternalCoreDsl.g:931:3: this_BitField_1= ruleBitField
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
    // InternalCoreDsl.g:943:1: entryRuleBitValue returns [EObject current=null] : iv_ruleBitValue= ruleBitValue EOF ;
    public final EObject entryRuleBitValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitValue = null;


        try {
            // InternalCoreDsl.g:943:49: (iv_ruleBitValue= ruleBitValue EOF )
            // InternalCoreDsl.g:944:2: iv_ruleBitValue= ruleBitValue EOF
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
    // InternalCoreDsl.g:950:1: ruleBitValue returns [EObject current=null] : ( (lv_name_0_0= RULE_BVAL ) ) ;
    public final EObject ruleBitValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:956:2: ( ( (lv_name_0_0= RULE_BVAL ) ) )
            // InternalCoreDsl.g:957:2: ( (lv_name_0_0= RULE_BVAL ) )
            {
            // InternalCoreDsl.g:957:2: ( (lv_name_0_0= RULE_BVAL ) )
            // InternalCoreDsl.g:958:3: (lv_name_0_0= RULE_BVAL )
            {
            // InternalCoreDsl.g:958:3: (lv_name_0_0= RULE_BVAL )
            // InternalCoreDsl.g:959:4: lv_name_0_0= RULE_BVAL
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
    // InternalCoreDsl.g:978:1: entryRuleBitField returns [EObject current=null] : iv_ruleBitField= ruleBitField EOF ;
    public final EObject entryRuleBitField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitField = null;


        try {
            // InternalCoreDsl.g:978:49: (iv_ruleBitField= ruleBitField EOF )
            // InternalCoreDsl.g:979:2: iv_ruleBitField= ruleBitField EOF
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
    // InternalCoreDsl.g:985:1: ruleBitField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? ) ;
    public final EObject ruleBitField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        EObject lv_bitRange_1_0 = null;

        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:991:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? ) )
            // InternalCoreDsl.g:992:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? )
            {
            // InternalCoreDsl.g:992:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? )
            // InternalCoreDsl.g:993:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )?
            {
            // InternalCoreDsl.g:993:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:994:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:994:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:995:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_36); if (state.failed) return current;
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

            // InternalCoreDsl.g:1011:3: ( (lv_bitRange_1_0= ruleRangeSpec ) )
            // InternalCoreDsl.g:1012:4: (lv_bitRange_1_0= ruleRangeSpec )
            {
            // InternalCoreDsl.g:1012:4: (lv_bitRange_1_0= ruleRangeSpec )
            // InternalCoreDsl.g:1013:5: lv_bitRange_1_0= ruleRangeSpec
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBitFieldAccess().getBitRangeRangeSpecParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_37);
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

            // InternalCoreDsl.g:1030:3: ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==42||LA30_0==98||LA30_0==128) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalCoreDsl.g:1031:4: (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) )
                    {
                    // InternalCoreDsl.g:1031:4: (otherlv_2= '\\'' )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==42) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalCoreDsl.g:1032:5: otherlv_2= '\\''
                            {
                            otherlv_2=(Token)match(input,42,FOLLOW_38); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getBitFieldAccess().getApostropheKeyword_2_0());
                              				
                            }

                            }
                            break;

                    }

                    // InternalCoreDsl.g:1037:4: ( (lv_type_3_0= ruleBitfieldDataType ) )
                    // InternalCoreDsl.g:1038:5: (lv_type_3_0= ruleBitfieldDataType )
                    {
                    // InternalCoreDsl.g:1038:5: (lv_type_3_0= ruleBitfieldDataType )
                    // InternalCoreDsl.g:1039:6: lv_type_3_0= ruleBitfieldDataType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitFieldAccess().getTypeBitfieldDataTypeEnumRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_type_3_0=ruleBitfieldDataType();

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
                      							"com.minres.coredsl.CoreDsl.BitfieldDataType");
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


    // $ANTLR start "entryRuleRangeSpec"
    // InternalCoreDsl.g:1061:1: entryRuleRangeSpec returns [EObject current=null] : iv_ruleRangeSpec= ruleRangeSpec EOF ;
    public final EObject entryRuleRangeSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeSpec = null;


        try {
            // InternalCoreDsl.g:1061:50: (iv_ruleRangeSpec= ruleRangeSpec EOF )
            // InternalCoreDsl.g:1062:2: iv_ruleRangeSpec= ruleRangeSpec EOF
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
    // InternalCoreDsl.g:1068:1: ruleRangeSpec returns [EObject current=null] : (otherlv_0= '[' ( (lv_left_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_INTEGER ) ) otherlv_4= ']' ) ;
    public final EObject ruleRangeSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_left_1_0=null;
        Token otherlv_2=null;
        Token lv_right_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:1074:2: ( (otherlv_0= '[' ( (lv_left_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_INTEGER ) ) otherlv_4= ']' ) )
            // InternalCoreDsl.g:1075:2: (otherlv_0= '[' ( (lv_left_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_INTEGER ) ) otherlv_4= ']' )
            {
            // InternalCoreDsl.g:1075:2: (otherlv_0= '[' ( (lv_left_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_INTEGER ) ) otherlv_4= ']' )
            // InternalCoreDsl.g:1076:3: otherlv_0= '[' ( (lv_left_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_INTEGER ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRangeSpecAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalCoreDsl.g:1080:3: ( (lv_left_1_0= RULE_INTEGER ) )
            // InternalCoreDsl.g:1081:4: (lv_left_1_0= RULE_INTEGER )
            {
            // InternalCoreDsl.g:1081:4: (lv_left_1_0= RULE_INTEGER )
            // InternalCoreDsl.g:1082:5: lv_left_1_0= RULE_INTEGER
            {
            lv_left_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_left_1_0, grammarAccess.getRangeSpecAccess().getLeftINTEGERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRangeSpecRule());
              					}
              					setWithLastConsumed(
              						current,
              						"left",
              						lv_left_1_0,
              						"com.minres.coredsl.CoreDsl.INTEGER");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRangeSpecAccess().getColonKeyword_2());
              		
            }
            // InternalCoreDsl.g:1102:3: ( (lv_right_3_0= RULE_INTEGER ) )
            // InternalCoreDsl.g:1103:4: (lv_right_3_0= RULE_INTEGER )
            {
            // InternalCoreDsl.g:1103:4: (lv_right_3_0= RULE_INTEGER )
            // InternalCoreDsl.g:1104:5: lv_right_3_0= RULE_INTEGER
            {
            lv_right_3_0=(Token)match(input,RULE_INTEGER,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_right_3_0, grammarAccess.getRangeSpecAccess().getRightINTEGERTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRangeSpecRule());
              					}
              					setWithLastConsumed(
              						current,
              						"right",
              						lv_right_3_0,
              						"com.minres.coredsl.CoreDsl.INTEGER");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleFunctionDefinition"
    // InternalCoreDsl.g:1128:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalCoreDsl.g:1128:59: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalCoreDsl.g:1129:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
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
    // $ANTLR end "entryRuleFunctionDefinition"


    // $ANTLR start "ruleFunctionDefinition"
    // InternalCoreDsl.g:1135:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_extern_0_0= 'extern' ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' this_ParameterList_4= ruleParameterList[$current] otherlv_5= ')' ( (lv_statement_6_0= ruleCompoundStatement ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_extern_0_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        EObject this_ParameterList_4 = null;

        EObject lv_statement_6_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1141:2: ( ( ( (lv_extern_0_0= 'extern' ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' this_ParameterList_4= ruleParameterList[$current] otherlv_5= ')' ( (lv_statement_6_0= ruleCompoundStatement ) ) ) )
            // InternalCoreDsl.g:1142:2: ( ( (lv_extern_0_0= 'extern' ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' this_ParameterList_4= ruleParameterList[$current] otherlv_5= ')' ( (lv_statement_6_0= ruleCompoundStatement ) ) )
            {
            // InternalCoreDsl.g:1142:2: ( ( (lv_extern_0_0= 'extern' ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' this_ParameterList_4= ruleParameterList[$current] otherlv_5= ')' ( (lv_statement_6_0= ruleCompoundStatement ) ) )
            // InternalCoreDsl.g:1143:3: ( (lv_extern_0_0= 'extern' ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' this_ParameterList_4= ruleParameterList[$current] otherlv_5= ')' ( (lv_statement_6_0= ruleCompoundStatement ) )
            {
            // InternalCoreDsl.g:1143:3: ( (lv_extern_0_0= 'extern' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==45) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalCoreDsl.g:1144:4: (lv_extern_0_0= 'extern' )
                    {
                    // InternalCoreDsl.g:1144:4: (lv_extern_0_0= 'extern' )
                    // InternalCoreDsl.g:1145:5: lv_extern_0_0= 'extern'
                    {
                    lv_extern_0_0=(Token)match(input,45,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_extern_0_0, grammarAccess.getFunctionDefinitionAccess().getExternExternKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                      					}
                      					setWithLastConsumed(current, "extern", lv_extern_0_0 != null, "extern");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:1157:3: ( (lv_type_1_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:1158:4: (lv_type_1_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:1158:4: (lv_type_1_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:1159:5: lv_type_1_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getTypeTypeSpecifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_type_1_0=ruleTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"com.minres.coredsl.CoreDsl.TypeSpecifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:1176:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalCoreDsl.g:1177:4: (lv_name_2_0= RULE_ID )
            {
            // InternalCoreDsl.g:1177:4: (lv_name_2_0= RULE_ID )
            // InternalCoreDsl.g:1178:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,46,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_3());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getFunctionDefinitionRule());
              			}
              			newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParameterListParserRuleCall_4());
              		
            }
            pushFollow(FOLLOW_42);
            this_ParameterList_4=ruleParameterList(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ParameterList_4;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_5=(Token)match(input,47,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_5());
              		
            }
            // InternalCoreDsl.g:1213:3: ( (lv_statement_6_0= ruleCompoundStatement ) )
            // InternalCoreDsl.g:1214:4: (lv_statement_6_0= ruleCompoundStatement )
            {
            // InternalCoreDsl.g:1214:4: (lv_statement_6_0= ruleCompoundStatement )
            // InternalCoreDsl.g:1215:5: lv_statement_6_0= ruleCompoundStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getStatementCompoundStatementParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_statement_6_0=ruleCompoundStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              					}
              					set(
              						current,
              						"statement",
              						lv_statement_6_0,
              						"com.minres.coredsl.CoreDsl.CompoundStatement");
              					afterParserOrEnumRuleCall();
              				
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
    // $ANTLR end "ruleFunctionDefinition"


    // $ANTLR start "ruleParameterList"
    // InternalCoreDsl.g:1237:1: ruleParameterList[EObject in_current] returns [EObject current=in_current] : ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* ) ;
    public final EObject ruleParameterList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_params_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1243:2: ( ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* ) )
            // InternalCoreDsl.g:1244:2: ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* )
            {
            // InternalCoreDsl.g:1244:2: ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* )
            // InternalCoreDsl.g:1245:3: ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )*
            {
            // InternalCoreDsl.g:1245:3: ( (lv_params_0_0= ruleParameterDeclaration ) )
            // InternalCoreDsl.g:1246:4: (lv_params_0_0= ruleParameterDeclaration )
            {
            // InternalCoreDsl.g:1246:4: (lv_params_0_0= ruleParameterDeclaration )
            // InternalCoreDsl.g:1247:5: lv_params_0_0= ruleParameterDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListAccess().getParamsParameterDeclarationParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_params_0_0=ruleParameterDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterListRule());
              					}
              					add(
              						current,
              						"params",
              						lv_params_0_0,
              						"com.minres.coredsl.CoreDsl.ParameterDeclaration");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:1264:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==33) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalCoreDsl.g:1265:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:1269:4: ( (lv_parameters_2_0= ruleParameterDeclaration ) )
            	    // InternalCoreDsl.g:1270:5: (lv_parameters_2_0= ruleParameterDeclaration )
            	    {
            	    // InternalCoreDsl.g:1270:5: (lv_parameters_2_0= ruleParameterDeclaration )
            	    // InternalCoreDsl.g:1271:6: lv_parameters_2_0= ruleParameterDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getParametersParameterDeclarationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_parameters_2_0=ruleParameterDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getParameterListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parameters",
            	      							lv_parameters_2_0,
            	      							"com.minres.coredsl.CoreDsl.ParameterDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameterDeclaration"
    // InternalCoreDsl.g:1293:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDeclaration = null;


        try {
            // InternalCoreDsl.g:1293:61: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // InternalCoreDsl.g:1294:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterDeclaration=ruleParameterDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterDeclaration; 
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
    // $ANTLR end "entryRuleParameterDeclaration"


    // $ANTLR start "ruleParameterDeclaration"
    // InternalCoreDsl.g:1300:1: ruleParameterDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_declarator_1_0 = null;

        EObject lv_declarator_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1306:2: ( ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? ) )
            // InternalCoreDsl.g:1307:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? )
            {
            // InternalCoreDsl.g:1307:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? )
            // InternalCoreDsl.g:1308:3: ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )?
            {
            // InternalCoreDsl.g:1308:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:1309:4: (lv_type_0_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:1309:4: (lv_type_0_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:1310:5: lv_type_0_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterDeclarationAccess().getTypeTypeSpecifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_44);
            lv_type_0_0=ruleTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterDeclarationRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"com.minres.coredsl.CoreDsl.TypeSpecifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:1327:3: ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )?
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            else if ( (LA33_0==43||LA33_0==46) ) {
                alt33=2;
            }
            switch (alt33) {
                case 1 :
                    // InternalCoreDsl.g:1328:4: ( (lv_declarator_1_0= ruleDirectDeclarator ) )
                    {
                    // InternalCoreDsl.g:1328:4: ( (lv_declarator_1_0= ruleDirectDeclarator ) )
                    // InternalCoreDsl.g:1329:5: (lv_declarator_1_0= ruleDirectDeclarator )
                    {
                    // InternalCoreDsl.g:1329:5: (lv_declarator_1_0= ruleDirectDeclarator )
                    // InternalCoreDsl.g:1330:6: lv_declarator_1_0= ruleDirectDeclarator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterDeclarationAccess().getDeclaratorDirectDeclaratorParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_declarator_1_0=ruleDirectDeclarator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"declarator",
                      							lv_declarator_1_0,
                      							"com.minres.coredsl.CoreDsl.DirectDeclarator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1348:4: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )
                    {
                    // InternalCoreDsl.g:1348:4: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )
                    // InternalCoreDsl.g:1349:5: (lv_declarator_2_0= ruleAbstractDeclarator )
                    {
                    // InternalCoreDsl.g:1349:5: (lv_declarator_2_0= ruleAbstractDeclarator )
                    // InternalCoreDsl.g:1350:6: lv_declarator_2_0= ruleAbstractDeclarator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterDeclarationAccess().getDeclaratorAbstractDeclaratorParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_declarator_2_0=ruleAbstractDeclarator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"declarator",
                      							lv_declarator_2_0,
                      							"com.minres.coredsl.CoreDsl.AbstractDeclarator");
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
    // $ANTLR end "ruleParameterDeclaration"


    // $ANTLR start "entryRuleStatement"
    // InternalCoreDsl.g:1372:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalCoreDsl.g:1372:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalCoreDsl.g:1373:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalCoreDsl.g:1379:1: ruleStatement returns [EObject current=null] : (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_CompoundStatement_0 = null;

        EObject this_ExpressionStatement_1 = null;

        EObject this_SelectionStatement_2 = null;

        EObject this_IterationStatement_3 = null;

        EObject this_JumpStatement_4 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1385:2: ( (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement ) )
            // InternalCoreDsl.g:1386:2: (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement )
            {
            // InternalCoreDsl.g:1386:2: (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement )
            int alt34=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt34=1;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 38:
            case 46:
            case 59:
            case 80:
            case 87:
            case 88:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 98:
            case 99:
            case 100:
                {
                alt34=2;
                }
                break;
            case 50:
            case 52:
                {
                alt34=3;
                }
                break;
            case 53:
            case 54:
            case 55:
                {
                alt34=4;
                }
                break;
            case 56:
            case 57:
            case 58:
                {
                alt34=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalCoreDsl.g:1387:3: this_CompoundStatement_0= ruleCompoundStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getCompoundStatementParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CompoundStatement_0=ruleCompoundStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CompoundStatement_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1396:3: this_ExpressionStatement_1= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getExpressionStatementParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExpressionStatement_1=ruleExpressionStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExpressionStatement_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:1405:3: this_SelectionStatement_2= ruleSelectionStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSelectionStatementParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SelectionStatement_2=ruleSelectionStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SelectionStatement_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:1414:3: this_IterationStatement_3= ruleIterationStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getIterationStatementParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IterationStatement_3=ruleIterationStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IterationStatement_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:1423:3: this_JumpStatement_4= ruleJumpStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getJumpStatementParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_JumpStatement_4=ruleJumpStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_JumpStatement_4;
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


    // $ANTLR start "entryRuleLabeledStatement"
    // InternalCoreDsl.g:1435:1: entryRuleLabeledStatement returns [EObject current=null] : iv_ruleLabeledStatement= ruleLabeledStatement EOF ;
    public final EObject entryRuleLabeledStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabeledStatement = null;


        try {
            // InternalCoreDsl.g:1435:57: (iv_ruleLabeledStatement= ruleLabeledStatement EOF )
            // InternalCoreDsl.g:1436:2: iv_ruleLabeledStatement= ruleLabeledStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLabeledStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLabeledStatement=ruleLabeledStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLabeledStatement; 
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
    // $ANTLR end "entryRuleLabeledStatement"


    // $ANTLR start "ruleLabeledStatement"
    // InternalCoreDsl.g:1442:1: ruleLabeledStatement returns [EObject current=null] : ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) ) ;
    public final EObject ruleLabeledStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_constExpr_1_0 = null;

        EObject lv_stmt_3_0 = null;

        EObject lv_stmt_6_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1448:2: ( ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) ) )
            // InternalCoreDsl.g:1449:2: ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) )
            {
            // InternalCoreDsl.g:1449:2: ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==48) ) {
                alt35=1;
            }
            else if ( (LA35_0==49) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalCoreDsl.g:1450:3: (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:1450:3: (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:1451:4: otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) )
                    {
                    otherlv_0=(Token)match(input,48,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getLabeledStatementAccess().getCaseKeyword_0_0());
                      			
                    }
                    // InternalCoreDsl.g:1455:4: ( (lv_constExpr_1_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:1456:5: (lv_constExpr_1_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:1456:5: (lv_constExpr_1_0= ruleConstantExpression )
                    // InternalCoreDsl.g:1457:6: lv_constExpr_1_0= ruleConstantExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLabeledStatementAccess().getConstExprConstantExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_30);
                    lv_constExpr_1_0=ruleConstantExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLabeledStatementRule());
                      						}
                      						set(
                      							current,
                      							"constExpr",
                      							lv_constExpr_1_0,
                      							"com.minres.coredsl.CoreDsl.ConstantExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,37,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getLabeledStatementAccess().getColonKeyword_0_2());
                      			
                    }
                    // InternalCoreDsl.g:1478:4: ( (lv_stmt_3_0= ruleStatement ) )
                    // InternalCoreDsl.g:1479:5: (lv_stmt_3_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1479:5: (lv_stmt_3_0= ruleStatement )
                    // InternalCoreDsl.g:1480:6: lv_stmt_3_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLabeledStatementAccess().getStmtStatementParserRuleCall_0_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_stmt_3_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLabeledStatementRule());
                      						}
                      						set(
                      							current,
                      							"stmt",
                      							lv_stmt_3_0,
                      							"com.minres.coredsl.CoreDsl.Statement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1499:3: (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:1499:3: (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:1500:4: otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) )
                    {
                    otherlv_4=(Token)match(input,49,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getLabeledStatementAccess().getDefaultKeyword_1_0());
                      			
                    }
                    otherlv_5=(Token)match(input,37,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getLabeledStatementAccess().getColonKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:1508:4: ( (lv_stmt_6_0= ruleStatement ) )
                    // InternalCoreDsl.g:1509:5: (lv_stmt_6_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1509:5: (lv_stmt_6_0= ruleStatement )
                    // InternalCoreDsl.g:1510:6: lv_stmt_6_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLabeledStatementAccess().getStmtStatementParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_stmt_6_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLabeledStatementRule());
                      						}
                      						set(
                      							current,
                      							"stmt",
                      							lv_stmt_6_0,
                      							"com.minres.coredsl.CoreDsl.Statement");
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
    // $ANTLR end "ruleLabeledStatement"


    // $ANTLR start "entryRuleCompoundStatement"
    // InternalCoreDsl.g:1532:1: entryRuleCompoundStatement returns [EObject current=null] : iv_ruleCompoundStatement= ruleCompoundStatement EOF ;
    public final EObject entryRuleCompoundStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundStatement = null;


        try {
            // InternalCoreDsl.g:1532:58: (iv_ruleCompoundStatement= ruleCompoundStatement EOF )
            // InternalCoreDsl.g:1533:2: iv_ruleCompoundStatement= ruleCompoundStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompoundStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompoundStatement=ruleCompoundStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompoundStatement; 
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
    // $ANTLR end "entryRuleCompoundStatement"


    // $ANTLR start "ruleCompoundStatement"
    // InternalCoreDsl.g:1539:1: ruleCompoundStatement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' ) ;
    public final EObject ruleCompoundStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_items_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1545:2: ( ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' ) )
            // InternalCoreDsl.g:1546:2: ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' )
            {
            // InternalCoreDsl.g:1546:2: ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' )
            // InternalCoreDsl.g:1547:3: () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}'
            {
            // InternalCoreDsl.g:1547:3: ()
            // InternalCoreDsl.g:1548:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCompoundStatementAccess().getCompoundStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,24,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundStatementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalCoreDsl.g:1558:3: ( (lv_items_2_0= ruleBlockItem ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_ID)||(LA36_0>=RULE_INTEGER && LA36_0<=RULE_CHARCONST)||LA36_0==24||LA36_0==34||LA36_0==38||(LA36_0>=45 && LA36_0<=46)||LA36_0==50||(LA36_0>=52 && LA36_0<=60)||LA36_0==63||LA36_0==80||(LA36_0>=87 && LA36_0<=88)||(LA36_0>=91 && LA36_0<=95)||(LA36_0>=97 && LA36_0<=100)||(LA36_0>=106 && LA36_0<=119)||(LA36_0>=126 && LA36_0<=127)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalCoreDsl.g:1559:4: (lv_items_2_0= ruleBlockItem )
            	    {
            	    // InternalCoreDsl.g:1559:4: (lv_items_2_0= ruleBlockItem )
            	    // InternalCoreDsl.g:1560:5: lv_items_2_0= ruleBlockItem
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundStatementAccess().getItemsBlockItemParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_47);
            	    lv_items_2_0=ruleBlockItem();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCompoundStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"items",
            	      						lv_items_2_0,
            	      						"com.minres.coredsl.CoreDsl.BlockItem");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_3=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCompoundStatementAccess().getRightCurlyBracketKeyword_3());
              		
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
    // $ANTLR end "ruleCompoundStatement"


    // $ANTLR start "entryRuleBlockItem"
    // InternalCoreDsl.g:1585:1: entryRuleBlockItem returns [EObject current=null] : iv_ruleBlockItem= ruleBlockItem EOF ;
    public final EObject entryRuleBlockItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockItem = null;


        try {
            // InternalCoreDsl.g:1585:50: (iv_ruleBlockItem= ruleBlockItem EOF )
            // InternalCoreDsl.g:1586:2: iv_ruleBlockItem= ruleBlockItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockItemRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlockItem=ruleBlockItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockItem; 
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
    // $ANTLR end "entryRuleBlockItem"


    // $ANTLR start "ruleBlockItem"
    // InternalCoreDsl.g:1592:1: ruleBlockItem returns [EObject current=null] : (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration ) ;
    public final EObject ruleBlockItem() throws RecognitionException {
        EObject current = null;

        EObject this_Statement_0 = null;

        EObject this_Declaration_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1598:2: ( (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration ) )
            // InternalCoreDsl.g:1599:2: (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration )
            {
            // InternalCoreDsl.g:1599:2: (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration )
            int alt37=2;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 24:
            case 38:
            case 46:
            case 50:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 80:
            case 87:
            case 88:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 98:
            case 99:
            case 100:
                {
                alt37=1;
                }
                break;
            case RULE_ID:
                {
                int LA37_2 = input.LA(2);

                if ( (LA37_2==43||LA37_2==46||(LA37_2>=64 && LA37_2<=75)||(LA37_2>=91 && LA37_2<=92)||LA37_2==96) ) {
                    alt37=1;
                }
                else if ( (LA37_2==RULE_ID||LA37_2==38||LA37_2==59||LA37_2==61) ) {
                    alt37=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
            case 45:
            case 60:
            case 63:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 126:
            case 127:
                {
                alt37=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalCoreDsl.g:1600:3: this_Statement_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBlockItemAccess().getStatementParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Statement_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Statement_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1609:3: this_Declaration_1= ruleDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBlockItemAccess().getDeclarationParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Declaration_1=ruleDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Declaration_1;
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
    // $ANTLR end "ruleBlockItem"


    // $ANTLR start "entryRuleExpressionStatement"
    // InternalCoreDsl.g:1621:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalCoreDsl.g:1621:60: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalCoreDsl.g:1622:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
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
    // $ANTLR end "entryRuleExpressionStatement"


    // $ANTLR start "ruleExpressionStatement"
    // InternalCoreDsl.g:1628:1: ruleExpressionStatement returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1634:2: ( ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' ) )
            // InternalCoreDsl.g:1635:2: ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' )
            {
            // InternalCoreDsl.g:1635:2: ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' )
            // InternalCoreDsl.g:1636:3: () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';'
            {
            // InternalCoreDsl.g:1636:3: ()
            // InternalCoreDsl.g:1637:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExpressionStatementAccess().getExpressionStatementAction_0(),
              					current);
              			
            }

            }

            // InternalCoreDsl.g:1643:3: ( (lv_expr_1_0= ruleAssignmentExpression ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_ID)||(LA38_0>=RULE_INTEGER && LA38_0<=RULE_CHARCONST)||LA38_0==46||LA38_0==59||LA38_0==80||(LA38_0>=87 && LA38_0<=88)||(LA38_0>=91 && LA38_0<=95)||(LA38_0>=97 && LA38_0<=100)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalCoreDsl.g:1644:4: (lv_expr_1_0= ruleAssignmentExpression )
                    {
                    // InternalCoreDsl.g:1644:4: (lv_expr_1_0= ruleAssignmentExpression )
                    // InternalCoreDsl.g:1645:5: lv_expr_1_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprAssignmentExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_32);
                    lv_expr_1_0=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
                      					}
                      					set(
                      						current,
                      						"expr",
                      						lv_expr_1_0,
                      						"com.minres.coredsl.CoreDsl.AssignmentExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_2());
              		
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
    // $ANTLR end "ruleExpressionStatement"


    // $ANTLR start "entryRuleSelectionStatement"
    // InternalCoreDsl.g:1670:1: entryRuleSelectionStatement returns [EObject current=null] : iv_ruleSelectionStatement= ruleSelectionStatement EOF ;
    public final EObject entryRuleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionStatement = null;


        try {
            // InternalCoreDsl.g:1670:59: (iv_ruleSelectionStatement= ruleSelectionStatement EOF )
            // InternalCoreDsl.g:1671:2: iv_ruleSelectionStatement= ruleSelectionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelectionStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSelectionStatement=ruleSelectionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelectionStatement; 
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
    // $ANTLR end "entryRuleSelectionStatement"


    // $ANTLR start "ruleSelectionStatement"
    // InternalCoreDsl.g:1677:1: ruleSelectionStatement returns [EObject current=null] : (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement ) ;
    public final EObject ruleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject this_IfStatement_0 = null;

        EObject this_SwitchStatement_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1683:2: ( (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement ) )
            // InternalCoreDsl.g:1684:2: (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement )
            {
            // InternalCoreDsl.g:1684:2: (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==50) ) {
                alt39=1;
            }
            else if ( (LA39_0==52) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalCoreDsl.g:1685:3: this_IfStatement_0= ruleIfStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSelectionStatementAccess().getIfStatementParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfStatement_0=ruleIfStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfStatement_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1694:3: this_SwitchStatement_1= ruleSwitchStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSelectionStatementAccess().getSwitchStatementParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SwitchStatement_1=ruleSwitchStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SwitchStatement_1;
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
    // $ANTLR end "ruleSelectionStatement"


    // $ANTLR start "entryRuleIfStatement"
    // InternalCoreDsl.g:1706:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalCoreDsl.g:1706:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalCoreDsl.g:1707:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfStatement; 
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
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // InternalCoreDsl.g:1713:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_cond_2_0 = null;

        EObject lv_thenStmt_4_0 = null;

        EObject lv_elseStmt_6_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1719:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? ) )
            // InternalCoreDsl.g:1720:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? )
            {
            // InternalCoreDsl.g:1720:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? )
            // InternalCoreDsl.g:1721:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )?
            {
            otherlv_0=(Token)match(input,50,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,46,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalCoreDsl.g:1729:3: ( (lv_cond_2_0= ruleConditionalExpression ) )
            // InternalCoreDsl.g:1730:4: (lv_cond_2_0= ruleConditionalExpression )
            {
            // InternalCoreDsl.g:1730:4: (lv_cond_2_0= ruleConditionalExpression )
            // InternalCoreDsl.g:1731:5: lv_cond_2_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getCondConditionalExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_42);
            lv_cond_2_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_2_0,
              						"com.minres.coredsl.CoreDsl.ConditionalExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,47,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalCoreDsl.g:1752:3: ( (lv_thenStmt_4_0= ruleStatement ) )
            // InternalCoreDsl.g:1753:4: (lv_thenStmt_4_0= ruleStatement )
            {
            // InternalCoreDsl.g:1753:4: (lv_thenStmt_4_0= ruleStatement )
            // InternalCoreDsl.g:1754:5: lv_thenStmt_4_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getThenStmtStatementParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_48);
            lv_thenStmt_4_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"thenStmt",
              						lv_thenStmt_4_0,
              						"com.minres.coredsl.CoreDsl.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:1771:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==51) ) {
                int LA40_1 = input.LA(2);

                if ( (synpred1_InternalCoreDsl()) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // InternalCoreDsl.g:1772:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) )
                    {
                    // InternalCoreDsl.g:1772:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalCoreDsl.g:1773:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,51,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfStatementAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalCoreDsl.g:1779:4: ( (lv_elseStmt_6_0= ruleStatement ) )
                    // InternalCoreDsl.g:1780:5: (lv_elseStmt_6_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1780:5: (lv_elseStmt_6_0= ruleStatement )
                    // InternalCoreDsl.g:1781:6: lv_elseStmt_6_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfStatementAccess().getElseStmtStatementParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_elseStmt_6_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfStatementRule());
                      						}
                      						set(
                      							current,
                      							"elseStmt",
                      							lv_elseStmt_6_0,
                      							"com.minres.coredsl.CoreDsl.Statement");
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
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleSwitchStatement"
    // InternalCoreDsl.g:1803:1: entryRuleSwitchStatement returns [EObject current=null] : iv_ruleSwitchStatement= ruleSwitchStatement EOF ;
    public final EObject entryRuleSwitchStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStatement = null;


        try {
            // InternalCoreDsl.g:1803:56: (iv_ruleSwitchStatement= ruleSwitchStatement EOF )
            // InternalCoreDsl.g:1804:2: iv_ruleSwitchStatement= ruleSwitchStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSwitchStatement=ruleSwitchStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchStatement; 
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
    // $ANTLR end "entryRuleSwitchStatement"


    // $ANTLR start "ruleSwitchStatement"
    // InternalCoreDsl.g:1810:1: ruleSwitchStatement returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' ) ;
    public final EObject ruleSwitchStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_cond_2_0 = null;

        EObject lv_items_5_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1816:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' ) )
            // InternalCoreDsl.g:1817:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' )
            {
            // InternalCoreDsl.g:1817:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' )
            // InternalCoreDsl.g:1818:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatementAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,46,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalCoreDsl.g:1826:3: ( (lv_cond_2_0= ruleConditionalExpression ) )
            // InternalCoreDsl.g:1827:4: (lv_cond_2_0= ruleConditionalExpression )
            {
            // InternalCoreDsl.g:1827:4: (lv_cond_2_0= ruleConditionalExpression )
            // InternalCoreDsl.g:1828:5: lv_cond_2_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatementAccess().getCondConditionalExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_42);
            lv_cond_2_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSwitchStatementRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_2_0,
              						"com.minres.coredsl.CoreDsl.ConditionalExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,47,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,24,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatementAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalCoreDsl.g:1853:3: ( (lv_items_5_0= ruleLabeledStatement ) )
            // InternalCoreDsl.g:1854:4: (lv_items_5_0= ruleLabeledStatement )
            {
            // InternalCoreDsl.g:1854:4: (lv_items_5_0= ruleLabeledStatement )
            // InternalCoreDsl.g:1855:5: lv_items_5_0= ruleLabeledStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatementAccess().getItemsLabeledStatementParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_items_5_0=ruleLabeledStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSwitchStatementRule());
              					}
              					add(
              						current,
              						"items",
              						lv_items_5_0,
              						"com.minres.coredsl.CoreDsl.LabeledStatement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSwitchStatementAccess().getRightCurlyBracketKeyword_6());
              		
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
    // $ANTLR end "ruleSwitchStatement"


    // $ANTLR start "entryRuleIterationStatement"
    // InternalCoreDsl.g:1880:1: entryRuleIterationStatement returns [EObject current=null] : iv_ruleIterationStatement= ruleIterationStatement EOF ;
    public final EObject entryRuleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationStatement = null;


        try {
            // InternalCoreDsl.g:1880:59: (iv_ruleIterationStatement= ruleIterationStatement EOF )
            // InternalCoreDsl.g:1881:2: iv_ruleIterationStatement= ruleIterationStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIterationStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIterationStatement=ruleIterationStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIterationStatement; 
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
    // $ANTLR end "entryRuleIterationStatement"


    // $ANTLR start "ruleIterationStatement"
    // InternalCoreDsl.g:1887:1: ruleIterationStatement returns [EObject current=null] : ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) ) ;
    public final EObject ruleIterationStatement() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_type_5_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_type_12_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_cond_2_0 = null;

        EObject lv_stmt_4_0 = null;

        EObject lv_stmt_6_0 = null;

        EObject lv_cond_9_0 = null;

        EObject this_ForCondition_14 = null;

        EObject lv_stmt_16_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1893:2: ( ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) ) )
            // InternalCoreDsl.g:1894:2: ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) )
            {
            // InternalCoreDsl.g:1894:2: ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt41=1;
                }
                break;
            case 54:
                {
                alt41=2;
                }
                break;
            case 55:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalCoreDsl.g:1895:3: ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:1895:3: ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:1896:4: ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) )
                    {
                    // InternalCoreDsl.g:1896:4: ( (lv_type_0_0= 'while' ) )
                    // InternalCoreDsl.g:1897:5: (lv_type_0_0= 'while' )
                    {
                    // InternalCoreDsl.g:1897:5: (lv_type_0_0= 'while' )
                    // InternalCoreDsl.g:1898:6: lv_type_0_0= 'while'
                    {
                    lv_type_0_0=(Token)match(input,53,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_0_0, grammarAccess.getIterationStatementAccess().getTypeWhileKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIterationStatementRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_0_0, "while");
                      					
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,46,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getIterationStatementAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalCoreDsl.g:1914:4: ( (lv_cond_2_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:1915:5: (lv_cond_2_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:1915:5: (lv_cond_2_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:1916:6: lv_cond_2_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getCondConditionalExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_42);
                    lv_cond_2_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIterationStatementRule());
                      						}
                      						set(
                      							current,
                      							"cond",
                      							lv_cond_2_0,
                      							"com.minres.coredsl.CoreDsl.ConditionalExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,47,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getIterationStatementAccess().getRightParenthesisKeyword_0_3());
                      			
                    }
                    // InternalCoreDsl.g:1937:4: ( (lv_stmt_4_0= ruleStatement ) )
                    // InternalCoreDsl.g:1938:5: (lv_stmt_4_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1938:5: (lv_stmt_4_0= ruleStatement )
                    // InternalCoreDsl.g:1939:6: lv_stmt_4_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getStmtStatementParserRuleCall_0_4_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_stmt_4_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIterationStatementRule());
                      						}
                      						set(
                      							current,
                      							"stmt",
                      							lv_stmt_4_0,
                      							"com.minres.coredsl.CoreDsl.Statement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1958:3: ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' )
                    {
                    // InternalCoreDsl.g:1958:3: ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' )
                    // InternalCoreDsl.g:1959:4: ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';'
                    {
                    // InternalCoreDsl.g:1959:4: ( (lv_type_5_0= 'do' ) )
                    // InternalCoreDsl.g:1960:5: (lv_type_5_0= 'do' )
                    {
                    // InternalCoreDsl.g:1960:5: (lv_type_5_0= 'do' )
                    // InternalCoreDsl.g:1961:6: lv_type_5_0= 'do'
                    {
                    lv_type_5_0=(Token)match(input,54,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_5_0, grammarAccess.getIterationStatementAccess().getTypeDoKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIterationStatementRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_5_0, "do");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:1973:4: ( (lv_stmt_6_0= ruleStatement ) )
                    // InternalCoreDsl.g:1974:5: (lv_stmt_6_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1974:5: (lv_stmt_6_0= ruleStatement )
                    // InternalCoreDsl.g:1975:6: lv_stmt_6_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getStmtStatementParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_50);
                    lv_stmt_6_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIterationStatementRule());
                      						}
                      						set(
                      							current,
                      							"stmt",
                      							lv_stmt_6_0,
                      							"com.minres.coredsl.CoreDsl.Statement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,53,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getIterationStatementAccess().getWhileKeyword_1_2());
                      			
                    }
                    otherlv_8=(Token)match(input,46,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getIterationStatementAccess().getLeftParenthesisKeyword_1_3());
                      			
                    }
                    // InternalCoreDsl.g:2000:4: ( (lv_cond_9_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:2001:5: (lv_cond_9_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:2001:5: (lv_cond_9_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:2002:6: lv_cond_9_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getCondConditionalExpressionParserRuleCall_1_4_0());
                      					
                    }
                    pushFollow(FOLLOW_42);
                    lv_cond_9_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIterationStatementRule());
                      						}
                      						set(
                      							current,
                      							"cond",
                      							lv_cond_9_0,
                      							"com.minres.coredsl.CoreDsl.ConditionalExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,47,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getIterationStatementAccess().getRightParenthesisKeyword_1_5());
                      			
                    }
                    otherlv_11=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getIterationStatementAccess().getSemicolonKeyword_1_6());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:2029:3: ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:2029:3: ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:2030:4: ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) )
                    {
                    // InternalCoreDsl.g:2030:4: ( (lv_type_12_0= 'for' ) )
                    // InternalCoreDsl.g:2031:5: (lv_type_12_0= 'for' )
                    {
                    // InternalCoreDsl.g:2031:5: (lv_type_12_0= 'for' )
                    // InternalCoreDsl.g:2032:6: lv_type_12_0= 'for'
                    {
                    lv_type_12_0=(Token)match(input,55,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_12_0, grammarAccess.getIterationStatementAccess().getTypeForKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIterationStatementRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_12_0, "for");
                      					
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,46,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getIterationStatementAccess().getLeftParenthesisKeyword_2_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIterationStatementRule());
                      				}
                      				newCompositeNode(grammarAccess.getIterationStatementAccess().getForConditionParserRuleCall_2_2());
                      			
                    }
                    pushFollow(FOLLOW_42);
                    this_ForCondition_14=ruleForCondition(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ForCondition_14;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_15=(Token)match(input,47,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getIterationStatementAccess().getRightParenthesisKeyword_2_3());
                      			
                    }
                    // InternalCoreDsl.g:2063:4: ( (lv_stmt_16_0= ruleStatement ) )
                    // InternalCoreDsl.g:2064:5: (lv_stmt_16_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:2064:5: (lv_stmt_16_0= ruleStatement )
                    // InternalCoreDsl.g:2065:6: lv_stmt_16_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getStmtStatementParserRuleCall_2_4_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_stmt_16_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIterationStatementRule());
                      						}
                      						set(
                      							current,
                      							"stmt",
                      							lv_stmt_16_0,
                      							"com.minres.coredsl.CoreDsl.Statement");
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
    // $ANTLR end "ruleIterationStatement"


    // $ANTLR start "ruleForCondition"
    // InternalCoreDsl.g:2088:1: ruleForCondition[EObject in_current] returns [EObject current=in_current] : ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleExpression ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? ) ;
    public final EObject ruleForCondition(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_startDecl_0_0 = null;

        EObject lv_startExpr_1_0 = null;

        EObject lv_endExpr_3_0 = null;

        EObject lv_loopExprs_5_0 = null;

        EObject lv_loopExprs_7_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2094:2: ( ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleExpression ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? ) )
            // InternalCoreDsl.g:2095:2: ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleExpression ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? )
            {
            // InternalCoreDsl.g:2095:2: ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleExpression ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? )
            // InternalCoreDsl.g:2096:3: ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleExpression ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )?
            {
            // InternalCoreDsl.g:2096:3: ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleExpression ) )? otherlv_2= ';' ) )
            int alt43=2;
            switch ( input.LA(1) ) {
            case 34:
            case 45:
            case 60:
            case 63:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 126:
            case 127:
                {
                alt43=1;
                }
                break;
            case RULE_ID:
                {
                int LA43_2 = input.LA(2);

                if ( (LA43_2==43||LA43_2==46||(LA43_2>=64 && LA43_2<=75)||(LA43_2>=91 && LA43_2<=92)||LA43_2==96) ) {
                    alt43=2;
                }
                else if ( (LA43_2==RULE_ID||LA43_2==38||LA43_2==59||LA43_2==61) ) {
                    alt43=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 38:
            case 46:
            case 59:
            case 80:
            case 87:
            case 88:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 98:
            case 99:
            case 100:
                {
                alt43=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalCoreDsl.g:2097:4: ( (lv_startDecl_0_0= ruleDeclaration ) )
                    {
                    // InternalCoreDsl.g:2097:4: ( (lv_startDecl_0_0= ruleDeclaration ) )
                    // InternalCoreDsl.g:2098:5: (lv_startDecl_0_0= ruleDeclaration )
                    {
                    // InternalCoreDsl.g:2098:5: (lv_startDecl_0_0= ruleDeclaration )
                    // InternalCoreDsl.g:2099:6: lv_startDecl_0_0= ruleDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getForConditionAccess().getStartDeclDeclarationParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_52);
                    lv_startDecl_0_0=ruleDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getForConditionRule());
                      						}
                      						set(
                      							current,
                      							"startDecl",
                      							lv_startDecl_0_0,
                      							"com.minres.coredsl.CoreDsl.Declaration");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2117:4: ( ( (lv_startExpr_1_0= ruleExpression ) )? otherlv_2= ';' )
                    {
                    // InternalCoreDsl.g:2117:4: ( ( (lv_startExpr_1_0= ruleExpression ) )? otherlv_2= ';' )
                    // InternalCoreDsl.g:2118:5: ( (lv_startExpr_1_0= ruleExpression ) )? otherlv_2= ';'
                    {
                    // InternalCoreDsl.g:2118:5: ( (lv_startExpr_1_0= ruleExpression ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_ID)||(LA42_0>=RULE_INTEGER && LA42_0<=RULE_CHARCONST)||LA42_0==46||LA42_0==59||LA42_0==80||(LA42_0>=87 && LA42_0<=88)||(LA42_0>=91 && LA42_0<=95)||(LA42_0>=97 && LA42_0<=100)) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalCoreDsl.g:2119:6: (lv_startExpr_1_0= ruleExpression )
                            {
                            // InternalCoreDsl.g:2119:6: (lv_startExpr_1_0= ruleExpression )
                            // InternalCoreDsl.g:2120:7: lv_startExpr_1_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getForConditionAccess().getStartExprExpressionParserRuleCall_0_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_32);
                            lv_startExpr_1_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getForConditionRule());
                              							}
                              							set(
                              								current,
                              								"startExpr",
                              								lv_startExpr_1_0,
                              								"com.minres.coredsl.CoreDsl.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    otherlv_2=(Token)match(input,38,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getForConditionAccess().getSemicolonKeyword_0_1_1());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:2143:3: ( (lv_endExpr_3_0= ruleConditionalExpression ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_ID)||(LA44_0>=RULE_INTEGER && LA44_0<=RULE_CHARCONST)||LA44_0==46||LA44_0==59||LA44_0==80||(LA44_0>=87 && LA44_0<=88)||(LA44_0>=91 && LA44_0<=95)||(LA44_0>=97 && LA44_0<=100)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalCoreDsl.g:2144:4: (lv_endExpr_3_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:2144:4: (lv_endExpr_3_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:2145:5: lv_endExpr_3_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getForConditionAccess().getEndExprConditionalExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_32);
                    lv_endExpr_3_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getForConditionRule());
                      					}
                      					set(
                      						current,
                      						"endExpr",
                      						lv_endExpr_3_0,
                      						"com.minres.coredsl.CoreDsl.ConditionalExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,38,FOLLOW_53); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getForConditionAccess().getSemicolonKeyword_2());
              		
            }
            // InternalCoreDsl.g:2166:3: ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_ID)||(LA46_0>=RULE_INTEGER && LA46_0<=RULE_CHARCONST)||LA46_0==46||LA46_0==59||LA46_0==80||(LA46_0>=87 && LA46_0<=88)||(LA46_0>=91 && LA46_0<=95)||(LA46_0>=97 && LA46_0<=100)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalCoreDsl.g:2167:4: ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )*
                    {
                    // InternalCoreDsl.g:2167:4: ( (lv_loopExprs_5_0= ruleAssignmentExpression ) )
                    // InternalCoreDsl.g:2168:5: (lv_loopExprs_5_0= ruleAssignmentExpression )
                    {
                    // InternalCoreDsl.g:2168:5: (lv_loopExprs_5_0= ruleAssignmentExpression )
                    // InternalCoreDsl.g:2169:6: lv_loopExprs_5_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getForConditionAccess().getLoopExprsAssignmentExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
                    lv_loopExprs_5_0=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getForConditionRule());
                      						}
                      						add(
                      							current,
                      							"loopExprs",
                      							lv_loopExprs_5_0,
                      							"com.minres.coredsl.CoreDsl.AssignmentExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:2186:4: (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==33) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2187:5: otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) )
                    	    {
                    	    otherlv_6=(Token)match(input,33,FOLLOW_45); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getForConditionAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2191:5: ( (lv_loopExprs_7_0= ruleAssignmentExpression ) )
                    	    // InternalCoreDsl.g:2192:6: (lv_loopExprs_7_0= ruleAssignmentExpression )
                    	    {
                    	    // InternalCoreDsl.g:2192:6: (lv_loopExprs_7_0= ruleAssignmentExpression )
                    	    // InternalCoreDsl.g:2193:7: lv_loopExprs_7_0= ruleAssignmentExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getForConditionAccess().getLoopExprsAssignmentExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_43);
                    	    lv_loopExprs_7_0=ruleAssignmentExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getForConditionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"loopExprs",
                    	      								lv_loopExprs_7_0,
                    	      								"com.minres.coredsl.CoreDsl.AssignmentExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


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
    // $ANTLR end "ruleForCondition"


    // $ANTLR start "entryRuleJumpStatement"
    // InternalCoreDsl.g:2216:1: entryRuleJumpStatement returns [EObject current=null] : iv_ruleJumpStatement= ruleJumpStatement EOF ;
    public final EObject entryRuleJumpStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJumpStatement = null;


        try {
            // InternalCoreDsl.g:2216:54: (iv_ruleJumpStatement= ruleJumpStatement EOF )
            // InternalCoreDsl.g:2217:2: iv_ruleJumpStatement= ruleJumpStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJumpStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJumpStatement=ruleJumpStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJumpStatement; 
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
    // $ANTLR end "entryRuleJumpStatement"


    // $ANTLR start "ruleJumpStatement"
    // InternalCoreDsl.g:2223:1: ruleJumpStatement returns [EObject current=null] : ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) ) ;
    public final EObject ruleJumpStatement() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;
        Token otherlv_3=null;
        Token lv_type_4_0=null;
        Token otherlv_6=null;
        EObject lv_expr_5_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2229:2: ( ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) ) )
            // InternalCoreDsl.g:2230:2: ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) )
            {
            // InternalCoreDsl.g:2230:2: ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt48=1;
                }
                break;
            case 57:
                {
                alt48=2;
                }
                break;
            case 58:
                {
                alt48=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalCoreDsl.g:2231:3: ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' )
                    {
                    // InternalCoreDsl.g:2231:3: ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' )
                    // InternalCoreDsl.g:2232:4: ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';'
                    {
                    // InternalCoreDsl.g:2232:4: ( (lv_type_0_0= 'continue' ) )
                    // InternalCoreDsl.g:2233:5: (lv_type_0_0= 'continue' )
                    {
                    // InternalCoreDsl.g:2233:5: (lv_type_0_0= 'continue' )
                    // InternalCoreDsl.g:2234:6: lv_type_0_0= 'continue'
                    {
                    lv_type_0_0=(Token)match(input,56,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_0_0, grammarAccess.getJumpStatementAccess().getTypeContinueKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getJumpStatementRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_0_0, "continue");
                      					
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getJumpStatementAccess().getSemicolonKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2252:3: ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' )
                    {
                    // InternalCoreDsl.g:2252:3: ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' )
                    // InternalCoreDsl.g:2253:4: ( (lv_type_2_0= 'break' ) ) otherlv_3= ';'
                    {
                    // InternalCoreDsl.g:2253:4: ( (lv_type_2_0= 'break' ) )
                    // InternalCoreDsl.g:2254:5: (lv_type_2_0= 'break' )
                    {
                    // InternalCoreDsl.g:2254:5: (lv_type_2_0= 'break' )
                    // InternalCoreDsl.g:2255:6: lv_type_2_0= 'break'
                    {
                    lv_type_2_0=(Token)match(input,57,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_2_0, grammarAccess.getJumpStatementAccess().getTypeBreakKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getJumpStatementRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_2_0, "break");
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getJumpStatementAccess().getSemicolonKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:2273:3: ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' )
                    {
                    // InternalCoreDsl.g:2273:3: ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' )
                    // InternalCoreDsl.g:2274:4: ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';'
                    {
                    // InternalCoreDsl.g:2274:4: ( (lv_type_4_0= 'return' ) )
                    // InternalCoreDsl.g:2275:5: (lv_type_4_0= 'return' )
                    {
                    // InternalCoreDsl.g:2275:5: (lv_type_4_0= 'return' )
                    // InternalCoreDsl.g:2276:6: lv_type_4_0= 'return'
                    {
                    lv_type_4_0=(Token)match(input,58,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_4_0, grammarAccess.getJumpStatementAccess().getTypeReturnKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getJumpStatementRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_4_0, "return");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:2288:4: ( (lv_expr_5_0= ruleConditionalExpression ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_ID)||(LA47_0>=RULE_INTEGER && LA47_0<=RULE_CHARCONST)||LA47_0==46||LA47_0==59||LA47_0==80||(LA47_0>=87 && LA47_0<=88)||(LA47_0>=91 && LA47_0<=95)||(LA47_0>=97 && LA47_0<=100)) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalCoreDsl.g:2289:5: (lv_expr_5_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:2289:5: (lv_expr_5_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:2290:6: lv_expr_5_0= ruleConditionalExpression
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getJumpStatementAccess().getExprConditionalExpressionParserRuleCall_2_1_0());
                              					
                            }
                            pushFollow(FOLLOW_32);
                            lv_expr_5_0=ruleConditionalExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getJumpStatementRule());
                              						}
                              						set(
                              							current,
                              							"expr",
                              							lv_expr_5_0,
                              							"com.minres.coredsl.CoreDsl.ConditionalExpression");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getJumpStatementAccess().getSemicolonKeyword_2_2());
                      			
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
    // $ANTLR end "ruleJumpStatement"


    // $ANTLR start "entryRuleDeclaration"
    // InternalCoreDsl.g:2316:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalCoreDsl.g:2316:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalCoreDsl.g:2317:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
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
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalCoreDsl.g:2323:1: ruleDeclaration returns [EObject current=null] : (this_TypeOrVarDeclaration_0= ruleTypeOrVarDeclaration | this_TypedefDeclaration_1= ruleTypedefDeclaration ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_TypeOrVarDeclaration_0 = null;

        EObject this_TypedefDeclaration_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2329:2: ( (this_TypeOrVarDeclaration_0= ruleTypeOrVarDeclaration | this_TypedefDeclaration_1= ruleTypedefDeclaration ) )
            // InternalCoreDsl.g:2330:2: (this_TypeOrVarDeclaration_0= ruleTypeOrVarDeclaration | this_TypedefDeclaration_1= ruleTypedefDeclaration )
            {
            // InternalCoreDsl.g:2330:2: (this_TypeOrVarDeclaration_0= ruleTypeOrVarDeclaration | this_TypedefDeclaration_1= ruleTypedefDeclaration )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID||LA49_0==34||LA49_0==45||LA49_0==63||(LA49_0>=106 && LA49_0<=119)||(LA49_0>=126 && LA49_0<=127)) ) {
                alt49=1;
            }
            else if ( (LA49_0==60) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalCoreDsl.g:2331:3: this_TypeOrVarDeclaration_0= ruleTypeOrVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDeclarationAccess().getTypeOrVarDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeOrVarDeclaration_0=ruleTypeOrVarDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeOrVarDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2340:3: this_TypedefDeclaration_1= ruleTypedefDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDeclarationAccess().getTypedefDeclarationParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypedefDeclaration_1=ruleTypedefDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypedefDeclaration_1;
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleTypeOrVarDeclaration"
    // InternalCoreDsl.g:2352:1: entryRuleTypeOrVarDeclaration returns [EObject current=null] : iv_ruleTypeOrVarDeclaration= ruleTypeOrVarDeclaration EOF ;
    public final EObject entryRuleTypeOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeOrVarDeclaration = null;


        try {
            // InternalCoreDsl.g:2352:61: (iv_ruleTypeOrVarDeclaration= ruleTypeOrVarDeclaration EOF )
            // InternalCoreDsl.g:2353:2: iv_ruleTypeOrVarDeclaration= ruleTypeOrVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeOrVarDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeOrVarDeclaration=ruleTypeOrVarDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeOrVarDeclaration; 
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
    // $ANTLR end "entryRuleTypeOrVarDeclaration"


    // $ANTLR start "ruleTypeOrVarDeclaration"
    // InternalCoreDsl.g:2359:1: ruleTypeOrVarDeclaration returns [EObject current=null] : ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( (lv_is_ptr_3_0= '*' ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' ) ;
    public final EObject ruleTypeOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_is_ptr_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject this_DeclarationSpecifier_0 = null;

        EObject lv_type_1_0 = null;

        EObject lv_size_2_0 = null;

        EObject lv_init_4_0 = null;

        EObject lv_init_6_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2365:2: ( ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( (lv_is_ptr_3_0= '*' ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' ) )
            // InternalCoreDsl.g:2366:2: ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( (lv_is_ptr_3_0= '*' ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' )
            {
            // InternalCoreDsl.g:2366:2: ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( (lv_is_ptr_3_0= '*' ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' )
            // InternalCoreDsl.g:2367:3: (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( (lv_is_ptr_3_0= '*' ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';'
            {
            // InternalCoreDsl.g:2367:3: (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==34||LA50_0==45||(LA50_0>=117 && LA50_0<=119)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalCoreDsl.g:2368:4: this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current]
            	    {
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElement(grammarAccess.getTypeOrVarDeclarationRule());
            	      				}
            	      				newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getDeclarationSpecifierParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_15);
            	    this_DeclarationSpecifier_0=ruleDeclarationSpecifier(current);

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current = this_DeclarationSpecifier_0;
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            // InternalCoreDsl.g:2380:3: ( (lv_type_1_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:2381:4: (lv_type_1_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:2381:4: (lv_type_1_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:2382:5: lv_type_1_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getTypeTypeSpecifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_54);
            lv_type_1_0=ruleTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypeOrVarDeclarationRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"com.minres.coredsl.CoreDsl.TypeSpecifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:2399:3: ( (lv_size_2_0= ruleBitSizeSpecifier ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==61) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalCoreDsl.g:2400:4: (lv_size_2_0= ruleBitSizeSpecifier )
                    {
                    // InternalCoreDsl.g:2400:4: (lv_size_2_0= ruleBitSizeSpecifier )
                    // InternalCoreDsl.g:2401:5: lv_size_2_0= ruleBitSizeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getSizeBitSizeSpecifierParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_55);
                    lv_size_2_0=ruleBitSizeSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getTypeOrVarDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"size",
                      						lv_size_2_0,
                      						"com.minres.coredsl.CoreDsl.BitSizeSpecifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:2418:3: ( (lv_is_ptr_3_0= '*' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==59) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalCoreDsl.g:2419:4: (lv_is_ptr_3_0= '*' )
                    {
                    // InternalCoreDsl.g:2419:4: (lv_is_ptr_3_0= '*' )
                    // InternalCoreDsl.g:2420:5: lv_is_ptr_3_0= '*'
                    {
                    lv_is_ptr_3_0=(Token)match(input,59,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_is_ptr_3_0, grammarAccess.getTypeOrVarDeclarationAccess().getIs_ptrAsteriskKeyword_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTypeOrVarDeclarationRule());
                      					}
                      					setWithLastConsumed(current, "is_ptr", lv_is_ptr_3_0 != null, "*");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:2432:3: ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalCoreDsl.g:2433:4: ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )*
                    {
                    // InternalCoreDsl.g:2433:4: ( (lv_init_4_0= ruleInitDeclarator ) )
                    // InternalCoreDsl.g:2434:5: (lv_init_4_0= ruleInitDeclarator )
                    {
                    // InternalCoreDsl.g:2434:5: (lv_init_4_0= ruleInitDeclarator )
                    // InternalCoreDsl.g:2435:6: lv_init_4_0= ruleInitDeclarator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getInitInitDeclaratorParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_57);
                    lv_init_4_0=ruleInitDeclarator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTypeOrVarDeclarationRule());
                      						}
                      						add(
                      							current,
                      							"init",
                      							lv_init_4_0,
                      							"com.minres.coredsl.CoreDsl.InitDeclarator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:2452:4: (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==33) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2453:5: otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) )
                    	    {
                    	    otherlv_5=(Token)match(input,33,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getTypeOrVarDeclarationAccess().getCommaKeyword_4_1_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2457:5: ( (lv_init_6_0= ruleInitDeclarator ) )
                    	    // InternalCoreDsl.g:2458:6: (lv_init_6_0= ruleInitDeclarator )
                    	    {
                    	    // InternalCoreDsl.g:2458:6: (lv_init_6_0= ruleInitDeclarator )
                    	    // InternalCoreDsl.g:2459:7: lv_init_6_0= ruleInitDeclarator
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getInitInitDeclaratorParserRuleCall_4_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_57);
                    	    lv_init_6_0=ruleInitDeclarator();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getTypeOrVarDeclarationRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"init",
                    	      								lv_init_6_0,
                    	      								"com.minres.coredsl.CoreDsl.InitDeclarator");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getTypeOrVarDeclarationAccess().getSemicolonKeyword_5());
              		
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
    // $ANTLR end "ruleTypeOrVarDeclaration"


    // $ANTLR start "entryRuleTypedefDeclaration"
    // InternalCoreDsl.g:2486:1: entryRuleTypedefDeclaration returns [EObject current=null] : iv_ruleTypedefDeclaration= ruleTypedefDeclaration EOF ;
    public final EObject entryRuleTypedefDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefDeclaration = null;


        try {
            // InternalCoreDsl.g:2486:59: (iv_ruleTypedefDeclaration= ruleTypedefDeclaration EOF )
            // InternalCoreDsl.g:2487:2: iv_ruleTypedefDeclaration= ruleTypedefDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefDeclaration=ruleTypedefDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefDeclaration; 
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
    // $ANTLR end "entryRuleTypedefDeclaration"


    // $ANTLR start "ruleTypedefDeclaration"
    // InternalCoreDsl.g:2493:1: ruleTypedefDeclaration returns [EObject current=null] : (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' ) ;
    public final EObject ruleTypedefDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject this_DeclarationSpecifier_1 = null;

        EObject lv_type_2_0 = null;

        EObject lv_init_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2499:2: ( (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' ) )
            // InternalCoreDsl.g:2500:2: (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' )
            {
            // InternalCoreDsl.g:2500:2: (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' )
            // InternalCoreDsl.g:2501:3: otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypedefDeclarationAccess().getTypedefKeyword_0());
              		
            }
            // InternalCoreDsl.g:2505:3: (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==34||LA55_0==45||(LA55_0>=117 && LA55_0<=119)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalCoreDsl.g:2506:4: this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current]
            	    {
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElement(grammarAccess.getTypedefDeclarationRule());
            	      				}
            	      				newCompositeNode(grammarAccess.getTypedefDeclarationAccess().getDeclarationSpecifierParserRuleCall_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_15);
            	    this_DeclarationSpecifier_1=ruleDeclarationSpecifier(current);

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current = this_DeclarationSpecifier_1;
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            // InternalCoreDsl.g:2518:3: ( (lv_type_2_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:2519:4: (lv_type_2_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:2519:4: (lv_type_2_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:2520:5: lv_type_2_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedefDeclarationAccess().getTypeTypeSpecifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_type_2_0=ruleTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypedefDeclarationRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_2_0,
              						"com.minres.coredsl.CoreDsl.TypeSpecifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:2537:3: ( (lv_init_3_0= ruleInitDeclarator ) )
            // InternalCoreDsl.g:2538:4: (lv_init_3_0= ruleInitDeclarator )
            {
            // InternalCoreDsl.g:2538:4: (lv_init_3_0= ruleInitDeclarator )
            // InternalCoreDsl.g:2539:5: lv_init_3_0= ruleInitDeclarator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedefDeclarationAccess().getInitInitDeclaratorParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_32);
            lv_init_3_0=ruleInitDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypedefDeclarationRule());
              					}
              					add(
              						current,
              						"init",
              						lv_init_3_0,
              						"com.minres.coredsl.CoreDsl.InitDeclarator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getTypedefDeclarationAccess().getSemicolonKeyword_4());
              		
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
    // $ANTLR end "ruleTypedefDeclaration"


    // $ANTLR start "ruleDeclarationSpecifier"
    // InternalCoreDsl.g:2565:1: ruleDeclarationSpecifier[EObject in_current] returns [EObject current=in_current] : ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] ) ;
    public final EObject ruleDeclarationSpecifier(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Enumerator lv_storage_0_0 = null;

        Enumerator lv_qualifiers_1_0 = null;

        EObject this_AttributeList_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2571:2: ( ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] ) )
            // InternalCoreDsl.g:2572:2: ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] )
            {
            // InternalCoreDsl.g:2572:2: ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] )
            int alt56=3;
            switch ( input.LA(1) ) {
            case 45:
            case 119:
                {
                alt56=1;
                }
                break;
            case 117:
            case 118:
                {
                alt56=2;
                }
                break;
            case 34:
                {
                alt56=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalCoreDsl.g:2573:3: ( (lv_storage_0_0= ruleStorageClassSpecifier ) )
                    {
                    // InternalCoreDsl.g:2573:3: ( (lv_storage_0_0= ruleStorageClassSpecifier ) )
                    // InternalCoreDsl.g:2574:4: (lv_storage_0_0= ruleStorageClassSpecifier )
                    {
                    // InternalCoreDsl.g:2574:4: (lv_storage_0_0= ruleStorageClassSpecifier )
                    // InternalCoreDsl.g:2575:5: lv_storage_0_0= ruleStorageClassSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDeclarationSpecifierAccess().getStorageStorageClassSpecifierEnumRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_storage_0_0=ruleStorageClassSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDeclarationSpecifierRule());
                      					}
                      					add(
                      						current,
                      						"storage",
                      						lv_storage_0_0,
                      						"com.minres.coredsl.CoreDsl.StorageClassSpecifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2593:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    {
                    // InternalCoreDsl.g:2593:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    // InternalCoreDsl.g:2594:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    {
                    // InternalCoreDsl.g:2594:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    // InternalCoreDsl.g:2595:5: lv_qualifiers_1_0= ruleTypeQualifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDeclarationSpecifierAccess().getQualifiersTypeQualifierEnumRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_qualifiers_1_0=ruleTypeQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDeclarationSpecifierRule());
                      					}
                      					add(
                      						current,
                      						"qualifiers",
                      						lv_qualifiers_1_0,
                      						"com.minres.coredsl.CoreDsl.TypeQualifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:2613:3: this_AttributeList_2= ruleAttributeList[$current]
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      				current = createModelElement(grammarAccess.getDeclarationSpecifierRule());
                      			}
                      			newCompositeNode(grammarAccess.getDeclarationSpecifierAccess().getAttributeListParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AttributeList_2=ruleAttributeList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AttributeList_2;
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
    // $ANTLR end "ruleDeclarationSpecifier"


    // $ANTLR start "ruleAttributeList"
    // InternalCoreDsl.g:2629:1: ruleAttributeList[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '[[' ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* otherlv_4= ']]' ) ;
    public final EObject ruleAttributeList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_attrs_1_0 = null;

        Enumerator lv_attrs_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2635:2: ( (otherlv_0= '[[' ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* otherlv_4= ']]' ) )
            // InternalCoreDsl.g:2636:2: (otherlv_0= '[[' ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* otherlv_4= ']]' )
            {
            // InternalCoreDsl.g:2636:2: (otherlv_0= '[[' ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* otherlv_4= ']]' )
            // InternalCoreDsl.g:2637:3: otherlv_0= '[[' ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* otherlv_4= ']]'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAttributeListAccess().getLeftSquareBracketLeftSquareBracketKeyword_0());
              		
            }
            // InternalCoreDsl.g:2641:3: ( (lv_attrs_1_0= ruleAttribute ) )
            // InternalCoreDsl.g:2642:4: (lv_attrs_1_0= ruleAttribute )
            {
            // InternalCoreDsl.g:2642:4: (lv_attrs_1_0= ruleAttribute )
            // InternalCoreDsl.g:2643:5: lv_attrs_1_0= ruleAttribute
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeListAccess().getAttrsAttributeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_attrs_1_0=ruleAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeListRule());
              					}
              					add(
              						current,
              						"attrs",
              						lv_attrs_1_0,
              						"com.minres.coredsl.CoreDsl.Attribute");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:2660:3: (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==33) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalCoreDsl.g:2661:4: otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) )
            	    {
            	    otherlv_2=(Token)match(input,33,FOLLOW_58); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAttributeListAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:2665:4: ( (lv_attrs_3_0= ruleAttribute ) )
            	    // InternalCoreDsl.g:2666:5: (lv_attrs_3_0= ruleAttribute )
            	    {
            	    // InternalCoreDsl.g:2666:5: (lv_attrs_3_0= ruleAttribute )
            	    // InternalCoreDsl.g:2667:6: lv_attrs_3_0= ruleAttribute
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAttributeListAccess().getAttrsAttributeEnumRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_attrs_3_0=ruleAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAttributeListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"attrs",
            	      							lv_attrs_3_0,
            	      							"com.minres.coredsl.CoreDsl.Attribute");
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

            otherlv_4=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getAttributeListAccess().getRightSquareBracketRightSquareBracketKeyword_3());
              		
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
    // $ANTLR end "ruleAttributeList"


    // $ANTLR start "entryRuleTypeSpecifier"
    // InternalCoreDsl.g:2693:1: entryRuleTypeSpecifier returns [EObject current=null] : iv_ruleTypeSpecifier= ruleTypeSpecifier EOF ;
    public final EObject entryRuleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSpecifier = null;


        try {
            // InternalCoreDsl.g:2693:54: (iv_ruleTypeSpecifier= ruleTypeSpecifier EOF )
            // InternalCoreDsl.g:2694:2: iv_ruleTypeSpecifier= ruleTypeSpecifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeSpecifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeSpecifier=ruleTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeSpecifier; 
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
    // $ANTLR end "entryRuleTypeSpecifier"


    // $ANTLR start "ruleTypeSpecifier"
    // InternalCoreDsl.g:2700:1: ruleTypeSpecifier returns [EObject current=null] : (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_TypedefRef_1= ruleTypedefRef ) ;
    public final EObject ruleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_DataTypeSpecifier_0 = null;

        EObject this_TypedefRef_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2706:2: ( (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_TypedefRef_1= ruleTypedefRef ) )
            // InternalCoreDsl.g:2707:2: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_TypedefRef_1= ruleTypedefRef )
            {
            // InternalCoreDsl.g:2707:2: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_TypedefRef_1= ruleTypedefRef )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==63||(LA58_0>=106 && LA58_0<=116)||(LA58_0>=126 && LA58_0<=127)) ) {
                alt58=1;
            }
            else if ( (LA58_0==RULE_ID) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalCoreDsl.g:2708:3: this_DataTypeSpecifier_0= ruleDataTypeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeSpecifierAccess().getDataTypeSpecifierParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DataTypeSpecifier_0=ruleDataTypeSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DataTypeSpecifier_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2717:3: this_TypedefRef_1= ruleTypedefRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeSpecifierAccess().getTypedefRefParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypedefRef_1=ruleTypedefRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypedefRef_1;
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
    // $ANTLR end "ruleTypeSpecifier"


    // $ANTLR start "entryRuleDataTypeSpecifier"
    // InternalCoreDsl.g:2729:1: entryRuleDataTypeSpecifier returns [EObject current=null] : iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF ;
    public final EObject entryRuleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeSpecifier = null;


        try {
            // InternalCoreDsl.g:2729:58: (iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF )
            // InternalCoreDsl.g:2730:2: iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeSpecifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeSpecifier=ruleDataTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeSpecifier; 
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
    // $ANTLR end "entryRuleDataTypeSpecifier"


    // $ANTLR start "ruleDataTypeSpecifier"
    // InternalCoreDsl.g:2736:1: ruleDataTypeSpecifier returns [EObject current=null] : (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier ) ;
    public final EObject ruleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_PodSpecifier_0 = null;

        EObject this_StructOrUnionSpecifier_1 = null;

        EObject this_EnumSpecifier_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2742:2: ( (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier ) )
            // InternalCoreDsl.g:2743:2: (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier )
            {
            // InternalCoreDsl.g:2743:2: (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier )
            int alt59=3;
            switch ( input.LA(1) ) {
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
                {
                alt59=1;
                }
                break;
            case 126:
            case 127:
                {
                alt59=2;
                }
                break;
            case 63:
                {
                alt59=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalCoreDsl.g:2744:3: this_PodSpecifier_0= rulePodSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getPodSpecifierParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PodSpecifier_0=rulePodSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PodSpecifier_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2753:3: this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getStructOrUnionSpecifierParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StructOrUnionSpecifier_1=ruleStructOrUnionSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StructOrUnionSpecifier_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:2762:3: this_EnumSpecifier_2= ruleEnumSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getEnumSpecifierParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EnumSpecifier_2=ruleEnumSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EnumSpecifier_2;
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
    // $ANTLR end "ruleDataTypeSpecifier"


    // $ANTLR start "entryRuleTypedefRef"
    // InternalCoreDsl.g:2774:1: entryRuleTypedefRef returns [EObject current=null] : iv_ruleTypedefRef= ruleTypedefRef EOF ;
    public final EObject entryRuleTypedefRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefRef = null;


        try {
            // InternalCoreDsl.g:2774:51: (iv_ruleTypedefRef= ruleTypedefRef EOF )
            // InternalCoreDsl.g:2775:2: iv_ruleTypedefRef= ruleTypedefRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefRef=ruleTypedefRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefRef; 
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
    // $ANTLR end "entryRuleTypedefRef"


    // $ANTLR start "ruleTypedefRef"
    // InternalCoreDsl.g:2781:1: ruleTypedefRef returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleTypedefRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:2787:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalCoreDsl.g:2788:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalCoreDsl.g:2788:2: ( (otherlv_0= RULE_ID ) )
            // InternalCoreDsl.g:2789:3: (otherlv_0= RULE_ID )
            {
            // InternalCoreDsl.g:2789:3: (otherlv_0= RULE_ID )
            // InternalCoreDsl.g:2790:4: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getTypedefRefRule());
              				}
              			
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_0, grammarAccess.getTypedefRefAccess().getRefDirectDeclaratorCrossReference_0());
              			
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
    // $ANTLR end "ruleTypedefRef"


    // $ANTLR start "entryRulePodSpecifier"
    // InternalCoreDsl.g:2804:1: entryRulePodSpecifier returns [EObject current=null] : iv_rulePodSpecifier= rulePodSpecifier EOF ;
    public final EObject entryRulePodSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePodSpecifier = null;


        try {
            // InternalCoreDsl.g:2804:53: (iv_rulePodSpecifier= rulePodSpecifier EOF )
            // InternalCoreDsl.g:2805:2: iv_rulePodSpecifier= rulePodSpecifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPodSpecifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePodSpecifier=rulePodSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePodSpecifier; 
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
    // $ANTLR end "entryRulePodSpecifier"


    // $ANTLR start "rulePodSpecifier"
    // InternalCoreDsl.g:2811:1: rulePodSpecifier returns [EObject current=null] : ( (lv_dataType_0_0= ruleDataTypes ) )+ ;
    public final EObject rulePodSpecifier() throws RecognitionException {
        EObject current = null;

        Enumerator lv_dataType_0_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2817:2: ( ( (lv_dataType_0_0= ruleDataTypes ) )+ )
            // InternalCoreDsl.g:2818:2: ( (lv_dataType_0_0= ruleDataTypes ) )+
            {
            // InternalCoreDsl.g:2818:2: ( (lv_dataType_0_0= ruleDataTypes ) )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( ((LA60_0>=106 && LA60_0<=116)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalCoreDsl.g:2819:3: (lv_dataType_0_0= ruleDataTypes )
            	    {
            	    // InternalCoreDsl.g:2819:3: (lv_dataType_0_0= ruleDataTypes )
            	    // InternalCoreDsl.g:2820:4: lv_dataType_0_0= ruleDataTypes
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getPodSpecifierAccess().getDataTypeDataTypesEnumRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_59);
            	    lv_dataType_0_0=ruleDataTypes();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getPodSpecifierRule());
            	      				}
            	      				add(
            	      					current,
            	      					"dataType",
            	      					lv_dataType_0_0,
            	      					"com.minres.coredsl.CoreDsl.DataTypes");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
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
    // $ANTLR end "rulePodSpecifier"


    // $ANTLR start "entryRuleBitSizeSpecifier"
    // InternalCoreDsl.g:2840:1: entryRuleBitSizeSpecifier returns [EObject current=null] : iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF ;
    public final EObject entryRuleBitSizeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitSizeSpecifier = null;


        try {
            // InternalCoreDsl.g:2840:57: (iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF )
            // InternalCoreDsl.g:2841:2: iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitSizeSpecifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitSizeSpecifier=ruleBitSizeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitSizeSpecifier; 
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
    // $ANTLR end "entryRuleBitSizeSpecifier"


    // $ANTLR start "ruleBitSizeSpecifier"
    // InternalCoreDsl.g:2847:1: ruleBitSizeSpecifier returns [EObject current=null] : (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' ) ;
    public final EObject ruleBitSizeSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_size_1_0 = null;

        EObject lv_size_3_0 = null;

        EObject lv_size_5_0 = null;

        EObject lv_size_7_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2853:2: ( (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' ) )
            // InternalCoreDsl.g:2854:2: (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' )
            {
            // InternalCoreDsl.g:2854:2: (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' )
            // InternalCoreDsl.g:2855:3: otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBitSizeSpecifierAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalCoreDsl.g:2859:3: ( (lv_size_1_0= ruleBitSizeValue ) )
            // InternalCoreDsl.g:2860:4: (lv_size_1_0= ruleBitSizeValue )
            {
            // InternalCoreDsl.g:2860:4: (lv_size_1_0= ruleBitSizeValue )
            // InternalCoreDsl.g:2861:5: lv_size_1_0= ruleBitSizeValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_61);
            lv_size_1_0=ruleBitSizeValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBitSizeSpecifierRule());
              					}
              					add(
              						current,
              						"size",
              						lv_size_1_0,
              						"com.minres.coredsl.CoreDsl.BitSizeValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:2878:3: (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==33) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalCoreDsl.g:2879:4: otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) )
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_60); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_0());
                      			
                    }
                    // InternalCoreDsl.g:2883:4: ( (lv_size_3_0= ruleBitSizeValue ) )
                    // InternalCoreDsl.g:2884:5: (lv_size_3_0= ruleBitSizeValue )
                    {
                    // InternalCoreDsl.g:2884:5: (lv_size_3_0= ruleBitSizeValue )
                    // InternalCoreDsl.g:2885:6: lv_size_3_0= ruleBitSizeValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_62);
                    lv_size_3_0=ruleBitSizeValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBitSizeSpecifierRule());
                      						}
                      						add(
                      							current,
                      							"size",
                      							lv_size_3_0,
                      							"com.minres.coredsl.CoreDsl.BitSizeValue");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,33,FOLLOW_60); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_2());
                      			
                    }
                    // InternalCoreDsl.g:2906:4: ( (lv_size_5_0= ruleBitSizeValue ) )
                    // InternalCoreDsl.g:2907:5: (lv_size_5_0= ruleBitSizeValue )
                    {
                    // InternalCoreDsl.g:2907:5: (lv_size_5_0= ruleBitSizeValue )
                    // InternalCoreDsl.g:2908:6: lv_size_5_0= ruleBitSizeValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_62);
                    lv_size_5_0=ruleBitSizeValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBitSizeSpecifierRule());
                      						}
                      						add(
                      							current,
                      							"size",
                      							lv_size_5_0,
                      							"com.minres.coredsl.CoreDsl.BitSizeValue");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,33,FOLLOW_60); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_4());
                      			
                    }
                    // InternalCoreDsl.g:2929:4: ( (lv_size_7_0= ruleBitSizeValue ) )
                    // InternalCoreDsl.g:2930:5: (lv_size_7_0= ruleBitSizeValue )
                    {
                    // InternalCoreDsl.g:2930:5: (lv_size_7_0= ruleBitSizeValue )
                    // InternalCoreDsl.g:2931:6: lv_size_7_0= ruleBitSizeValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_2_5_0());
                      					
                    }
                    pushFollow(FOLLOW_63);
                    lv_size_7_0=ruleBitSizeValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBitSizeSpecifierRule());
                      						}
                      						add(
                      							current,
                      							"size",
                      							lv_size_7_0,
                      							"com.minres.coredsl.CoreDsl.BitSizeValue");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getBitSizeSpecifierAccess().getGreaterThanSignKeyword_3());
              		
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
    // $ANTLR end "ruleBitSizeSpecifier"


    // $ANTLR start "entryRuleBitSizeValue"
    // InternalCoreDsl.g:2957:1: entryRuleBitSizeValue returns [EObject current=null] : iv_ruleBitSizeValue= ruleBitSizeValue EOF ;
    public final EObject entryRuleBitSizeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitSizeValue = null;


        try {
            // InternalCoreDsl.g:2957:53: (iv_ruleBitSizeValue= ruleBitSizeValue EOF )
            // InternalCoreDsl.g:2958:2: iv_ruleBitSizeValue= ruleBitSizeValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitSizeValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitSizeValue=ruleBitSizeValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitSizeValue; 
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
    // $ANTLR end "entryRuleBitSizeValue"


    // $ANTLR start "ruleBitSizeValue"
    // InternalCoreDsl.g:2964:1: ruleBitSizeValue returns [EObject current=null] : ( ( (lv_val_0_0= RULE_INTEGER ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleBitSizeValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:2970:2: ( ( ( (lv_val_0_0= RULE_INTEGER ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // InternalCoreDsl.g:2971:2: ( ( (lv_val_0_0= RULE_INTEGER ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalCoreDsl.g:2971:2: ( ( (lv_val_0_0= RULE_INTEGER ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_INTEGER) ) {
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
                    // InternalCoreDsl.g:2972:3: ( (lv_val_0_0= RULE_INTEGER ) )
                    {
                    // InternalCoreDsl.g:2972:3: ( (lv_val_0_0= RULE_INTEGER ) )
                    // InternalCoreDsl.g:2973:4: (lv_val_0_0= RULE_INTEGER )
                    {
                    // InternalCoreDsl.g:2973:4: (lv_val_0_0= RULE_INTEGER )
                    // InternalCoreDsl.g:2974:5: lv_val_0_0= RULE_INTEGER
                    {
                    lv_val_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_val_0_0, grammarAccess.getBitSizeValueAccess().getValINTEGERTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBitSizeValueRule());
                      					}
                      					addWithLastConsumed(
                      						current,
                      						"val",
                      						lv_val_0_0,
                      						"com.minres.coredsl.CoreDsl.INTEGER");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2991:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:2991:3: ( (otherlv_1= RULE_ID ) )
                    // InternalCoreDsl.g:2992:4: (otherlv_1= RULE_ID )
                    {
                    // InternalCoreDsl.g:2992:4: (otherlv_1= RULE_ID )
                    // InternalCoreDsl.g:2993:5: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBitSizeValueRule());
                      					}
                      				
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getBitSizeValueAccess().getConstantConstantCrossReference_1_0());
                      				
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
    // $ANTLR end "ruleBitSizeValue"


    // $ANTLR start "entryRuleEnumSpecifier"
    // InternalCoreDsl.g:3008:1: entryRuleEnumSpecifier returns [EObject current=null] : iv_ruleEnumSpecifier= ruleEnumSpecifier EOF ;
    public final EObject entryRuleEnumSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumSpecifier = null;


        try {
            // InternalCoreDsl.g:3008:54: (iv_ruleEnumSpecifier= ruleEnumSpecifier EOF )
            // InternalCoreDsl.g:3009:2: iv_ruleEnumSpecifier= ruleEnumSpecifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumSpecifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumSpecifier=ruleEnumSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumSpecifier; 
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
    // $ANTLR end "entryRuleEnumSpecifier"


    // $ANTLR start "ruleEnumSpecifier"
    // InternalCoreDsl.g:3015:1: ruleEnumSpecifier returns [EObject current=null] : ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) ) ;
    public final EObject ruleEnumSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        EObject this_EnumeratorList_3 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3021:2: ( ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:3022:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:3022:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==63) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==RULE_ID) ) {
                    int LA65_2 = input.LA(3);

                    if ( (LA65_2==EOF||LA65_2==RULE_ID||LA65_2==33||LA65_2==38||LA65_2==43||(LA65_2>=46 && LA65_2<=47)||LA65_2==59||LA65_2==61) ) {
                        alt65=2;
                    }
                    else if ( (LA65_2==24) ) {
                        alt65=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 65, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA65_1==24) ) {
                    alt65=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalCoreDsl.g:3023:3: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' )
                    {
                    // InternalCoreDsl.g:3023:3: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' )
                    // InternalCoreDsl.g:3024:4: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}'
                    {
                    otherlv_0=(Token)match(input,63,FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getEnumSpecifierAccess().getEnumKeyword_0_0());
                      			
                    }
                    // InternalCoreDsl.g:3028:4: ( (lv_name_1_0= RULE_ID ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==RULE_ID) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // InternalCoreDsl.g:3029:5: (lv_name_1_0= RULE_ID )
                            {
                            // InternalCoreDsl.g:3029:5: (lv_name_1_0= RULE_ID )
                            // InternalCoreDsl.g:3030:6: lv_name_1_0= RULE_ID
                            {
                            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_name_1_0, grammarAccess.getEnumSpecifierAccess().getNameIDTerminalRuleCall_0_1_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getEnumSpecifierRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"name",
                              							lv_name_1_0,
                              							"com.minres.coredsl.CoreDsl.ID");
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_2=(Token)match(input,24,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEnumSpecifierAccess().getLeftCurlyBracketKeyword_0_2());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getEnumSpecifierRule());
                      				}
                      				newCompositeNode(grammarAccess.getEnumSpecifierAccess().getEnumeratorListParserRuleCall_0_3());
                      			
                    }
                    pushFollow(FOLLOW_65);
                    this_EnumeratorList_3=ruleEnumeratorList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_EnumeratorList_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:3061:4: (otherlv_4= ',' )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==33) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // InternalCoreDsl.g:3062:5: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,33,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getEnumSpecifierAccess().getCommaKeyword_0_4());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getEnumSpecifierAccess().getRightCurlyBracketKeyword_0_5());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3073:3: (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:3073:3: (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:3074:4: otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,63,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getEnumSpecifierAccess().getEnumKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3078:4: ( (lv_name_7_0= RULE_ID ) )
                    // InternalCoreDsl.g:3079:5: (lv_name_7_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3079:5: (lv_name_7_0= RULE_ID )
                    // InternalCoreDsl.g:3080:6: lv_name_7_0= RULE_ID
                    {
                    lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_7_0, grammarAccess.getEnumSpecifierAccess().getNameIDTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEnumSpecifierRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_7_0,
                      							"com.minres.coredsl.CoreDsl.ID");
                      					
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
    // $ANTLR end "ruleEnumSpecifier"


    // $ANTLR start "ruleEnumeratorList"
    // InternalCoreDsl.g:3102:1: ruleEnumeratorList[EObject in_current] returns [EObject current=in_current] : ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* ) ;
    public final EObject ruleEnumeratorList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_enumerators_0_0 = null;

        EObject lv_enumerators_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3108:2: ( ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* ) )
            // InternalCoreDsl.g:3109:2: ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* )
            {
            // InternalCoreDsl.g:3109:2: ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* )
            // InternalCoreDsl.g:3110:3: ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )*
            {
            // InternalCoreDsl.g:3110:3: ( (lv_enumerators_0_0= ruleEnumerator ) )
            // InternalCoreDsl.g:3111:4: (lv_enumerators_0_0= ruleEnumerator )
            {
            // InternalCoreDsl.g:3111:4: (lv_enumerators_0_0= ruleEnumerator )
            // InternalCoreDsl.g:3112:5: lv_enumerators_0_0= ruleEnumerator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumeratorListAccess().getEnumeratorsEnumeratorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_enumerators_0_0=ruleEnumerator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumeratorListRule());
              					}
              					add(
              						current,
              						"enumerators",
              						lv_enumerators_0_0,
              						"com.minres.coredsl.CoreDsl.Enumerator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:3129:3: (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==33) ) {
                    int LA66_1 = input.LA(2);

                    if ( (LA66_1==RULE_ID) ) {
                        alt66=1;
                    }


                }


                switch (alt66) {
            	case 1 :
            	    // InternalCoreDsl.g:3130:4: otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getEnumeratorListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3134:4: ( (lv_enumerators_2_0= ruleEnumerator ) )
            	    // InternalCoreDsl.g:3135:5: (lv_enumerators_2_0= ruleEnumerator )
            	    {
            	    // InternalCoreDsl.g:3135:5: (lv_enumerators_2_0= ruleEnumerator )
            	    // InternalCoreDsl.g:3136:6: lv_enumerators_2_0= ruleEnumerator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumeratorListAccess().getEnumeratorsEnumeratorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_enumerators_2_0=ruleEnumerator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEnumeratorListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enumerators",
            	      							lv_enumerators_2_0,
            	      							"com.minres.coredsl.CoreDsl.Enumerator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
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
    // $ANTLR end "ruleEnumeratorList"


    // $ANTLR start "entryRuleEnumerator"
    // InternalCoreDsl.g:3158:1: entryRuleEnumerator returns [EObject current=null] : iv_ruleEnumerator= ruleEnumerator EOF ;
    public final EObject entryRuleEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerator = null;


        try {
            // InternalCoreDsl.g:3158:51: (iv_ruleEnumerator= ruleEnumerator EOF )
            // InternalCoreDsl.g:3159:2: iv_ruleEnumerator= ruleEnumerator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumeratorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumerator=ruleEnumerator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumerator; 
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
    // $ANTLR end "entryRuleEnumerator"


    // $ANTLR start "ruleEnumerator"
    // InternalCoreDsl.g:3165:1: ruleEnumerator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) ) ;
    public final EObject ruleEnumerator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3171:2: ( ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) ) )
            // InternalCoreDsl.g:3172:2: ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) )
            {
            // InternalCoreDsl.g:3172:2: ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==EOF||LA67_1==26||LA67_1==33) ) {
                    alt67=1;
                }
                else if ( (LA67_1==64) ) {
                    alt67=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalCoreDsl.g:3173:3: ( (lv_name_0_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:3173:3: ( (lv_name_0_0= RULE_ID ) )
                    // InternalCoreDsl.g:3174:4: (lv_name_0_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3174:4: (lv_name_0_0= RULE_ID )
                    // InternalCoreDsl.g:3175:5: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_name_0_0, grammarAccess.getEnumeratorAccess().getNameIDTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEnumeratorRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"name",
                      						lv_name_0_0,
                      						"com.minres.coredsl.CoreDsl.ID");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3192:3: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) )
                    {
                    // InternalCoreDsl.g:3192:3: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) )
                    // InternalCoreDsl.g:3193:4: ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) )
                    {
                    // InternalCoreDsl.g:3193:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalCoreDsl.g:3194:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3194:5: (lv_name_1_0= RULE_ID )
                    // InternalCoreDsl.g:3195:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_0, grammarAccess.getEnumeratorAccess().getNameIDTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEnumeratorRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_1_0,
                      							"com.minres.coredsl.CoreDsl.ID");
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,64,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:3215:4: ( (lv_expression_3_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:3216:5: (lv_expression_3_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:3216:5: (lv_expression_3_0= ruleConstantExpression )
                    // InternalCoreDsl.g:3217:6: lv_expression_3_0= ruleConstantExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEnumeratorAccess().getExpressionConstantExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_3_0=ruleConstantExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEnumeratorRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_3_0,
                      							"com.minres.coredsl.CoreDsl.ConstantExpression");
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
    // $ANTLR end "ruleEnumerator"


    // $ANTLR start "entryRuleStructOrUnionSpecifier"
    // InternalCoreDsl.g:3239:1: entryRuleStructOrUnionSpecifier returns [EObject current=null] : iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF ;
    public final EObject entryRuleStructOrUnionSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructOrUnionSpecifier = null;


        try {
            // InternalCoreDsl.g:3239:63: (iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF )
            // InternalCoreDsl.g:3240:2: iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStructOrUnionSpecifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStructOrUnionSpecifier=ruleStructOrUnionSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStructOrUnionSpecifier; 
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
    // $ANTLR end "entryRuleStructOrUnionSpecifier"


    // $ANTLR start "ruleStructOrUnionSpecifier"
    // InternalCoreDsl.g:3246:1: ruleStructOrUnionSpecifier returns [EObject current=null] : ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) ) ;
    public final EObject ruleStructOrUnionSpecifier() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_name_6_0=null;
        Enumerator lv_composeType_0_0 = null;

        EObject lv_decls_3_0 = null;

        Enumerator lv_composeType_5_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3252:2: ( ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:3253:2: ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:3253:2: ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==126) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==RULE_ID) ) {
                    int LA70_3 = input.LA(3);

                    if ( (LA70_3==EOF||LA70_3==RULE_ID||LA70_3==33||LA70_3==38||LA70_3==43||(LA70_3>=46 && LA70_3<=47)||LA70_3==59||LA70_3==61) ) {
                        alt70=2;
                    }
                    else if ( (LA70_3==24) ) {
                        alt70=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA70_1==24) ) {
                    alt70=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA70_0==127) ) {
                int LA70_2 = input.LA(2);

                if ( (LA70_2==RULE_ID) ) {
                    int LA70_3 = input.LA(3);

                    if ( (LA70_3==EOF||LA70_3==RULE_ID||LA70_3==33||LA70_3==38||LA70_3==43||(LA70_3>=46 && LA70_3<=47)||LA70_3==59||LA70_3==61) ) {
                        alt70=2;
                    }
                    else if ( (LA70_3==24) ) {
                        alt70=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA70_2==24) ) {
                    alt70=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalCoreDsl.g:3254:3: ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' )
                    {
                    // InternalCoreDsl.g:3254:3: ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' )
                    // InternalCoreDsl.g:3255:4: ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}'
                    {
                    // InternalCoreDsl.g:3255:4: ( (lv_composeType_0_0= ruleStructOrUnion ) )
                    // InternalCoreDsl.g:3256:5: (lv_composeType_0_0= ruleStructOrUnion )
                    {
                    // InternalCoreDsl.g:3256:5: (lv_composeType_0_0= ruleStructOrUnion )
                    // InternalCoreDsl.g:3257:6: lv_composeType_0_0= ruleStructOrUnion
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStructOrUnionSpecifierAccess().getComposeTypeStructOrUnionEnumRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_64);
                    lv_composeType_0_0=ruleStructOrUnion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getStructOrUnionSpecifierRule());
                      						}
                      						set(
                      							current,
                      							"composeType",
                      							lv_composeType_0_0,
                      							"com.minres.coredsl.CoreDsl.StructOrUnion");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:3274:4: ( (lv_name_1_0= RULE_ID ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==RULE_ID) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalCoreDsl.g:3275:5: (lv_name_1_0= RULE_ID )
                            {
                            // InternalCoreDsl.g:3275:5: (lv_name_1_0= RULE_ID )
                            // InternalCoreDsl.g:3276:6: lv_name_1_0= RULE_ID
                            {
                            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_name_1_0, grammarAccess.getStructOrUnionSpecifierAccess().getNameIDTerminalRuleCall_0_1_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getStructOrUnionSpecifierRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"name",
                              							lv_name_1_0,
                              							"com.minres.coredsl.CoreDsl.ID");
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_2=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getStructOrUnionSpecifierAccess().getLeftCurlyBracketKeyword_0_2());
                      			
                    }
                    // InternalCoreDsl.g:3296:4: ( (lv_decls_3_0= ruleStructDeclaration ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==RULE_ID||LA69_0==63||(LA69_0>=106 && LA69_0<=118)||(LA69_0>=126 && LA69_0<=127)) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // InternalCoreDsl.g:3297:5: (lv_decls_3_0= ruleStructDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:3297:5: (lv_decls_3_0= ruleStructDeclaration )
                    	    // InternalCoreDsl.g:3298:6: lv_decls_3_0= ruleStructDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getStructOrUnionSpecifierAccess().getDeclsStructDeclarationParserRuleCall_0_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_16);
                    	    lv_decls_3_0=ruleStructDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getStructOrUnionSpecifierRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"decls",
                    	      							lv_decls_3_0,
                    	      							"com.minres.coredsl.CoreDsl.StructDeclaration");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getStructOrUnionSpecifierAccess().getRightCurlyBracketKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3321:3: ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:3321:3: ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:3322:4: ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:3322:4: ( (lv_composeType_5_0= ruleStructOrUnion ) )
                    // InternalCoreDsl.g:3323:5: (lv_composeType_5_0= ruleStructOrUnion )
                    {
                    // InternalCoreDsl.g:3323:5: (lv_composeType_5_0= ruleStructOrUnion )
                    // InternalCoreDsl.g:3324:6: lv_composeType_5_0= ruleStructOrUnion
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStructOrUnionSpecifierAccess().getComposeTypeStructOrUnionEnumRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_6);
                    lv_composeType_5_0=ruleStructOrUnion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getStructOrUnionSpecifierRule());
                      						}
                      						set(
                      							current,
                      							"composeType",
                      							lv_composeType_5_0,
                      							"com.minres.coredsl.CoreDsl.StructOrUnion");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:3341:4: ( (lv_name_6_0= RULE_ID ) )
                    // InternalCoreDsl.g:3342:5: (lv_name_6_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3342:5: (lv_name_6_0= RULE_ID )
                    // InternalCoreDsl.g:3343:6: lv_name_6_0= RULE_ID
                    {
                    lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_6_0, grammarAccess.getStructOrUnionSpecifierAccess().getNameIDTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getStructOrUnionSpecifierRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_6_0,
                      							"com.minres.coredsl.CoreDsl.ID");
                      					
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
    // $ANTLR end "ruleStructOrUnionSpecifier"


    // $ANTLR start "entryRuleStructDeclaration"
    // InternalCoreDsl.g:3364:1: entryRuleStructDeclaration returns [EObject current=null] : iv_ruleStructDeclaration= ruleStructDeclaration EOF ;
    public final EObject entryRuleStructDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructDeclaration = null;


        try {
            // InternalCoreDsl.g:3364:58: (iv_ruleStructDeclaration= ruleStructDeclaration EOF )
            // InternalCoreDsl.g:3365:2: iv_ruleStructDeclaration= ruleStructDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStructDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStructDeclaration=ruleStructDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStructDeclaration; 
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
    // $ANTLR end "entryRuleStructDeclaration"


    // $ANTLR start "ruleStructDeclaration"
    // InternalCoreDsl.g:3371:1: ruleStructDeclaration returns [EObject current=null] : ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleStructDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_specifier_0_0 = null;

        EObject lv_decls_1_0 = null;

        EObject lv_decls_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3377:2: ( ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' ) )
            // InternalCoreDsl.g:3378:2: ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' )
            {
            // InternalCoreDsl.g:3378:2: ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' )
            // InternalCoreDsl.g:3379:3: ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';'
            {
            // InternalCoreDsl.g:3379:3: ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) )
            // InternalCoreDsl.g:3380:4: (lv_specifier_0_0= ruleStructDeclarationSpecifier )
            {
            // InternalCoreDsl.g:3380:4: (lv_specifier_0_0= ruleStructDeclarationSpecifier )
            // InternalCoreDsl.g:3381:5: lv_specifier_0_0= ruleStructDeclarationSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStructDeclarationAccess().getSpecifierStructDeclarationSpecifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_specifier_0_0=ruleStructDeclarationSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStructDeclarationRule());
              					}
              					set(
              						current,
              						"specifier",
              						lv_specifier_0_0,
              						"com.minres.coredsl.CoreDsl.StructDeclarationSpecifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:3398:3: ( (lv_decls_1_0= ruleDirectDeclarator ) )
            // InternalCoreDsl.g:3399:4: (lv_decls_1_0= ruleDirectDeclarator )
            {
            // InternalCoreDsl.g:3399:4: (lv_decls_1_0= ruleDirectDeclarator )
            // InternalCoreDsl.g:3400:5: lv_decls_1_0= ruleDirectDeclarator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStructDeclarationAccess().getDeclsDirectDeclaratorParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_57);
            lv_decls_1_0=ruleDirectDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStructDeclarationRule());
              					}
              					add(
              						current,
              						"decls",
              						lv_decls_1_0,
              						"com.minres.coredsl.CoreDsl.DirectDeclarator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:3417:3: (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==33) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalCoreDsl.g:3418:4: otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) )
            	    {
            	    otherlv_2=(Token)match(input,33,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getStructDeclarationAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3422:4: ( (lv_decls_3_0= ruleDirectDeclarator ) )
            	    // InternalCoreDsl.g:3423:5: (lv_decls_3_0= ruleDirectDeclarator )
            	    {
            	    // InternalCoreDsl.g:3423:5: (lv_decls_3_0= ruleDirectDeclarator )
            	    // InternalCoreDsl.g:3424:6: lv_decls_3_0= ruleDirectDeclarator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getStructDeclarationAccess().getDeclsDirectDeclaratorParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_57);
            	    lv_decls_3_0=ruleDirectDeclarator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getStructDeclarationRule());
            	      						}
            	      						add(
            	      							current,
            	      							"decls",
            	      							lv_decls_3_0,
            	      							"com.minres.coredsl.CoreDsl.DirectDeclarator");
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

            otherlv_4=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getStructDeclarationAccess().getSemicolonKeyword_3());
              		
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
    // $ANTLR end "ruleStructDeclaration"


    // $ANTLR start "entryRuleStructDeclarationSpecifier"
    // InternalCoreDsl.g:3450:1: entryRuleStructDeclarationSpecifier returns [EObject current=null] : iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF ;
    public final EObject entryRuleStructDeclarationSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructDeclarationSpecifier = null;


        try {
            // InternalCoreDsl.g:3450:67: (iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF )
            // InternalCoreDsl.g:3451:2: iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStructDeclarationSpecifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStructDeclarationSpecifier=ruleStructDeclarationSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStructDeclarationSpecifier; 
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
    // $ANTLR end "entryRuleStructDeclarationSpecifier"


    // $ANTLR start "ruleStructDeclarationSpecifier"
    // InternalCoreDsl.g:3457:1: ruleStructDeclarationSpecifier returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) ) ;
    public final EObject ruleStructDeclarationSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        Enumerator lv_qualifiers_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3463:2: ( ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) ) )
            // InternalCoreDsl.g:3464:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) )
            {
            // InternalCoreDsl.g:3464:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID||LA72_0==63||(LA72_0>=106 && LA72_0<=116)||(LA72_0>=126 && LA72_0<=127)) ) {
                alt72=1;
            }
            else if ( ((LA72_0>=117 && LA72_0<=118)) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // InternalCoreDsl.g:3465:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
                    {
                    // InternalCoreDsl.g:3465:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
                    // InternalCoreDsl.g:3466:4: (lv_type_0_0= ruleTypeSpecifier )
                    {
                    // InternalCoreDsl.g:3466:4: (lv_type_0_0= ruleTypeSpecifier )
                    // InternalCoreDsl.g:3467:5: lv_type_0_0= ruleTypeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStructDeclarationSpecifierAccess().getTypeTypeSpecifierParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_type_0_0=ruleTypeSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStructDeclarationSpecifierRule());
                      					}
                      					set(
                      						current,
                      						"type",
                      						lv_type_0_0,
                      						"com.minres.coredsl.CoreDsl.TypeSpecifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3485:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    {
                    // InternalCoreDsl.g:3485:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    // InternalCoreDsl.g:3486:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    {
                    // InternalCoreDsl.g:3486:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    // InternalCoreDsl.g:3487:5: lv_qualifiers_1_0= ruleTypeQualifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStructDeclarationSpecifierAccess().getQualifiersTypeQualifierEnumRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_qualifiers_1_0=ruleTypeQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStructDeclarationSpecifierRule());
                      					}
                      					add(
                      						current,
                      						"qualifiers",
                      						lv_qualifiers_1_0,
                      						"com.minres.coredsl.CoreDsl.TypeQualifier");
                      					afterParserOrEnumRuleCall();
                      				
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
    // $ANTLR end "ruleStructDeclarationSpecifier"


    // $ANTLR start "entryRuleInitDeclarator"
    // InternalCoreDsl.g:3508:1: entryRuleInitDeclarator returns [EObject current=null] : iv_ruleInitDeclarator= ruleInitDeclarator EOF ;
    public final EObject entryRuleInitDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitDeclarator = null;


        try {
            // InternalCoreDsl.g:3508:55: (iv_ruleInitDeclarator= ruleInitDeclarator EOF )
            // InternalCoreDsl.g:3509:2: iv_ruleInitDeclarator= ruleInitDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitDeclaratorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInitDeclarator=ruleInitDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInitDeclarator; 
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
    // $ANTLR end "entryRuleInitDeclarator"


    // $ANTLR start "ruleInitDeclarator"
    // InternalCoreDsl.g:3515:1: ruleInitDeclarator returns [EObject current=null] : ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? ) ;
    public final EObject ruleInitDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_declarator_0_0 = null;

        EObject lv_initializer_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3521:2: ( ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? ) )
            // InternalCoreDsl.g:3522:2: ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? )
            {
            // InternalCoreDsl.g:3522:2: ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? )
            // InternalCoreDsl.g:3523:3: ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )?
            {
            // InternalCoreDsl.g:3523:3: ( (lv_declarator_0_0= ruleDirectDeclarator ) )
            // InternalCoreDsl.g:3524:4: (lv_declarator_0_0= ruleDirectDeclarator )
            {
            // InternalCoreDsl.g:3524:4: (lv_declarator_0_0= ruleDirectDeclarator )
            // InternalCoreDsl.g:3525:5: lv_declarator_0_0= ruleDirectDeclarator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInitDeclaratorAccess().getDeclaratorDirectDeclaratorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_67);
            lv_declarator_0_0=ruleDirectDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInitDeclaratorRule());
              					}
              					set(
              						current,
              						"declarator",
              						lv_declarator_0_0,
              						"com.minres.coredsl.CoreDsl.DirectDeclarator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:3542:3: (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==64) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalCoreDsl.g:3543:4: otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) )
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_68); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInitDeclaratorAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3547:4: ( (lv_initializer_2_0= ruleInitializer ) )
                    // InternalCoreDsl.g:3548:5: (lv_initializer_2_0= ruleInitializer )
                    {
                    // InternalCoreDsl.g:3548:5: (lv_initializer_2_0= ruleInitializer )
                    // InternalCoreDsl.g:3549:6: lv_initializer_2_0= ruleInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInitDeclaratorAccess().getInitializerInitializerParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_initializer_2_0=ruleInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInitDeclaratorRule());
                      						}
                      						set(
                      							current,
                      							"initializer",
                      							lv_initializer_2_0,
                      							"com.minres.coredsl.CoreDsl.Initializer");
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
    // $ANTLR end "ruleInitDeclarator"


    // $ANTLR start "entryRuleDirectDeclarator"
    // InternalCoreDsl.g:3571:1: entryRuleDirectDeclarator returns [EObject current=null] : iv_ruleDirectDeclarator= ruleDirectDeclarator EOF ;
    public final EObject entryRuleDirectDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectDeclarator = null;


        try {
            // InternalCoreDsl.g:3571:57: (iv_ruleDirectDeclarator= ruleDirectDeclarator EOF )
            // InternalCoreDsl.g:3572:2: iv_ruleDirectDeclarator= ruleDirectDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectDeclaratorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDirectDeclarator=ruleDirectDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectDeclarator; 
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
    // $ANTLR end "entryRuleDirectDeclarator"


    // $ANTLR start "ruleDirectDeclarator"
    // InternalCoreDsl.g:3578:1: ruleDirectDeclarator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )? ) ;
    public final EObject ruleDirectDeclarator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_index_2_0 = null;

        Enumerator lv_qualifiers_5_0 = null;

        EObject lv_expr_6_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3584:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )? ) )
            // InternalCoreDsl.g:3585:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )? )
            {
            // InternalCoreDsl.g:3585:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )? )
            // InternalCoreDsl.g:3586:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )?
            {
            // InternalCoreDsl.g:3586:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:3587:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:3587:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:3588:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getDirectDeclaratorAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDirectDeclaratorRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"com.minres.coredsl.CoreDsl.ID");
              				
            }

            }


            }

            // InternalCoreDsl.g:3604:3: (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==37) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalCoreDsl.g:3605:4: otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) )
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectDeclaratorAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3609:4: ( (lv_index_2_0= ruleIntegerConstant ) )
                    // InternalCoreDsl.g:3610:5: (lv_index_2_0= ruleIntegerConstant )
                    {
                    // InternalCoreDsl.g:3610:5: (lv_index_2_0= ruleIntegerConstant )
                    // InternalCoreDsl.g:3611:6: lv_index_2_0= ruleIntegerConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getIndexIntegerConstantParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_70);
                    lv_index_2_0=ruleIntegerConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectDeclaratorRule());
                      						}
                      						set(
                      							current,
                      							"index",
                      							lv_index_2_0,
                      							"com.minres.coredsl.CoreDsl.IntegerConstant");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:3629:3: ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==43) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalCoreDsl.g:3630:4: () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']'
                    {
                    // InternalCoreDsl.g:3630:4: ()
                    // InternalCoreDsl.g:3631:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getDirectDeclaratorAccess().getDirectDeclaratorLeftAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_4=(Token)match(input,43,FOLLOW_71); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDirectDeclaratorAccess().getLeftSquareBracketKeyword_2_1());
                      			
                    }
                    // InternalCoreDsl.g:3641:4: ( (lv_qualifiers_5_0= ruleTypeQualifier ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( ((LA75_0>=117 && LA75_0<=118)) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalCoreDsl.g:3642:5: (lv_qualifiers_5_0= ruleTypeQualifier )
                            {
                            // InternalCoreDsl.g:3642:5: (lv_qualifiers_5_0= ruleTypeQualifier )
                            // InternalCoreDsl.g:3643:6: lv_qualifiers_5_0= ruleTypeQualifier
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getQualifiersTypeQualifierEnumRuleCall_2_2_0());
                              					
                            }
                            pushFollow(FOLLOW_72);
                            lv_qualifiers_5_0=ruleTypeQualifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getDirectDeclaratorRule());
                              						}
                              						add(
                              							current,
                              							"qualifiers",
                              							lv_qualifiers_5_0,
                              							"com.minres.coredsl.CoreDsl.TypeQualifier");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalCoreDsl.g:3660:4: ( (lv_expr_6_0= ruleConditionalExpression ) )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( ((LA76_0>=RULE_STRING && LA76_0<=RULE_ID)||(LA76_0>=RULE_INTEGER && LA76_0<=RULE_CHARCONST)||LA76_0==46||LA76_0==59||LA76_0==80||(LA76_0>=87 && LA76_0<=88)||(LA76_0>=91 && LA76_0<=95)||(LA76_0>=97 && LA76_0<=100)) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // InternalCoreDsl.g:3661:5: (lv_expr_6_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:3661:5: (lv_expr_6_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:3662:6: lv_expr_6_0= ruleConditionalExpression
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getExprConditionalExpressionParserRuleCall_2_3_0());
                              					
                            }
                            pushFollow(FOLLOW_40);
                            lv_expr_6_0=ruleConditionalExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getDirectDeclaratorRule());
                              						}
                              						set(
                              							current,
                              							"expr",
                              							lv_expr_6_0,
                              							"com.minres.coredsl.CoreDsl.ConditionalExpression");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getDirectDeclaratorAccess().getRightSquareBracketKeyword_2_4());
                      			
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
    // $ANTLR end "ruleDirectDeclarator"


    // $ANTLR start "entryRuleInitializer"
    // InternalCoreDsl.g:3688:1: entryRuleInitializer returns [EObject current=null] : iv_ruleInitializer= ruleInitializer EOF ;
    public final EObject entryRuleInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitializer = null;


        try {
            // InternalCoreDsl.g:3688:52: (iv_ruleInitializer= ruleInitializer EOF )
            // InternalCoreDsl.g:3689:2: iv_ruleInitializer= ruleInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitializerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInitializer=ruleInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInitializer; 
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
    // $ANTLR end "entryRuleInitializer"


    // $ANTLR start "ruleInitializer"
    // InternalCoreDsl.g:3695:1: ruleInitializer returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) ) ;
    public final EObject ruleInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expr_0_0 = null;

        EObject this_InitializerList_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3701:2: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) ) )
            // InternalCoreDsl.g:3702:2: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) )
            {
            // InternalCoreDsl.g:3702:2: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=RULE_STRING && LA79_0<=RULE_ID)||(LA79_0>=RULE_INTEGER && LA79_0<=RULE_CHARCONST)||LA79_0==46||LA79_0==59||LA79_0==80||(LA79_0>=87 && LA79_0<=88)||(LA79_0>=91 && LA79_0<=95)||(LA79_0>=97 && LA79_0<=100)) ) {
                alt79=1;
            }
            else if ( (LA79_0==24) ) {
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
                    // InternalCoreDsl.g:3703:3: ( (lv_expr_0_0= ruleConditionalExpression ) )
                    {
                    // InternalCoreDsl.g:3703:3: ( (lv_expr_0_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:3704:4: (lv_expr_0_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:3704:4: (lv_expr_0_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:3705:5: lv_expr_0_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInitializerAccess().getExprConditionalExpressionParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_0_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getInitializerRule());
                      					}
                      					set(
                      						current,
                      						"expr",
                      						lv_expr_0_0,
                      						"com.minres.coredsl.CoreDsl.ConditionalExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3723:3: (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' )
                    {
                    // InternalCoreDsl.g:3723:3: (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' )
                    // InternalCoreDsl.g:3724:4: otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_73); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInitializerAccess().getLeftCurlyBracketKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getInitializerRule());
                      				}
                      				newCompositeNode(grammarAccess.getInitializerAccess().getInitializerListParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_65);
                    this_InitializerList_2=ruleInitializerList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_InitializerList_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:3739:4: (otherlv_3= ',' )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==33) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalCoreDsl.g:3740:5: otherlv_3= ','
                            {
                            otherlv_3=(Token)match(input,33,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getInitializerAccess().getCommaKeyword_1_2());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getInitializerAccess().getRightCurlyBracketKeyword_1_3());
                      			
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
    // $ANTLR end "ruleInitializer"


    // $ANTLR start "ruleInitializerList"
    // InternalCoreDsl.g:3755:1: ruleInitializerList[EObject in_current] returns [EObject current=in_current] : ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* ) ;
    public final EObject ruleInitializerList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_init_0_1 = null;

        EObject lv_init_0_2 = null;

        EObject lv_init_2_1 = null;

        EObject lv_init_2_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3761:2: ( ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* ) )
            // InternalCoreDsl.g:3762:2: ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* )
            {
            // InternalCoreDsl.g:3762:2: ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* )
            // InternalCoreDsl.g:3763:3: ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )*
            {
            // InternalCoreDsl.g:3763:3: ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) )
            // InternalCoreDsl.g:3764:4: ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) )
            {
            // InternalCoreDsl.g:3764:4: ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) )
            // InternalCoreDsl.g:3765:5: (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer )
            {
            // InternalCoreDsl.g:3765:5: (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==43||LA80_0==65) ) {
                alt80=1;
            }
            else if ( ((LA80_0>=RULE_STRING && LA80_0<=RULE_ID)||(LA80_0>=RULE_INTEGER && LA80_0<=RULE_CHARCONST)||LA80_0==24||LA80_0==46||LA80_0==59||LA80_0==80||(LA80_0>=87 && LA80_0<=88)||(LA80_0>=91 && LA80_0<=95)||(LA80_0>=97 && LA80_0<=100)) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // InternalCoreDsl.g:3766:6: lv_init_0_1= ruleDesignatedInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInitializerListAccess().getInitDesignatedInitializerParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
                    lv_init_0_1=ruleDesignatedInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInitializerListRule());
                      						}
                      						add(
                      							current,
                      							"init",
                      							lv_init_0_1,
                      							"com.minres.coredsl.CoreDsl.DesignatedInitializer");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3782:6: lv_init_0_2= ruleInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInitializerListAccess().getInitInitializerParserRuleCall_0_0_1());
                      					
                    }
                    pushFollow(FOLLOW_43);
                    lv_init_0_2=ruleInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInitializerListRule());
                      						}
                      						add(
                      							current,
                      							"init",
                      							lv_init_0_2,
                      							"com.minres.coredsl.CoreDsl.Initializer");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalCoreDsl.g:3800:3: (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==33) ) {
                    int LA82_1 = input.LA(2);

                    if ( ((LA82_1>=RULE_STRING && LA82_1<=RULE_ID)||(LA82_1>=RULE_INTEGER && LA82_1<=RULE_CHARCONST)||LA82_1==24||LA82_1==43||LA82_1==46||LA82_1==59||LA82_1==65||LA82_1==80||(LA82_1>=87 && LA82_1<=88)||(LA82_1>=91 && LA82_1<=95)||(LA82_1>=97 && LA82_1<=100)) ) {
                        alt82=1;
                    }


                }


                switch (alt82) {
            	case 1 :
            	    // InternalCoreDsl.g:3801:4: otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_73); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getInitializerListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3805:4: ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) )
            	    // InternalCoreDsl.g:3806:5: ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) )
            	    {
            	    // InternalCoreDsl.g:3806:5: ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) )
            	    // InternalCoreDsl.g:3807:6: (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer )
            	    {
            	    // InternalCoreDsl.g:3807:6: (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer )
            	    int alt81=2;
            	    int LA81_0 = input.LA(1);

            	    if ( (LA81_0==43||LA81_0==65) ) {
            	        alt81=1;
            	    }
            	    else if ( ((LA81_0>=RULE_STRING && LA81_0<=RULE_ID)||(LA81_0>=RULE_INTEGER && LA81_0<=RULE_CHARCONST)||LA81_0==24||LA81_0==46||LA81_0==59||LA81_0==80||(LA81_0>=87 && LA81_0<=88)||(LA81_0>=91 && LA81_0<=95)||(LA81_0>=97 && LA81_0<=100)) ) {
            	        alt81=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 81, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt81) {
            	        case 1 :
            	            // InternalCoreDsl.g:3808:7: lv_init_2_1= ruleDesignatedInitializer
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getInitializerListAccess().getInitDesignatedInitializerParserRuleCall_1_1_0_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_43);
            	            lv_init_2_1=ruleDesignatedInitializer();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getInitializerListRule());
            	              							}
            	              							add(
            	              								current,
            	              								"init",
            	              								lv_init_2_1,
            	              								"com.minres.coredsl.CoreDsl.DesignatedInitializer");
            	              							afterParserOrEnumRuleCall();
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalCoreDsl.g:3824:7: lv_init_2_2= ruleInitializer
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getInitializerListAccess().getInitInitializerParserRuleCall_1_1_0_1());
            	              						
            	            }
            	            pushFollow(FOLLOW_43);
            	            lv_init_2_2=ruleInitializer();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getInitializerListRule());
            	              							}
            	              							add(
            	              								current,
            	              								"init",
            	              								lv_init_2_2,
            	              								"com.minres.coredsl.CoreDsl.Initializer");
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
    // $ANTLR end "ruleInitializerList"


    // $ANTLR start "entryRuleDesignatedInitializer"
    // InternalCoreDsl.g:3847:1: entryRuleDesignatedInitializer returns [EObject current=null] : iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF ;
    public final EObject entryRuleDesignatedInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesignatedInitializer = null;


        try {
            // InternalCoreDsl.g:3847:62: (iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF )
            // InternalCoreDsl.g:3848:2: iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDesignatedInitializerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDesignatedInitializer=ruleDesignatedInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDesignatedInitializer; 
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
    // $ANTLR end "entryRuleDesignatedInitializer"


    // $ANTLR start "ruleDesignatedInitializer"
    // InternalCoreDsl.g:3854:1: ruleDesignatedInitializer returns [EObject current=null] : ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) ) ;
    public final EObject ruleDesignatedInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_designators_0_0 = null;

        EObject lv_init_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3860:2: ( ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) ) )
            // InternalCoreDsl.g:3861:2: ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) )
            {
            // InternalCoreDsl.g:3861:2: ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) )
            // InternalCoreDsl.g:3862:3: ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) )
            {
            // InternalCoreDsl.g:3862:3: ( (lv_designators_0_0= ruleDesignator ) )+
            int cnt83=0;
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==43||LA83_0==65) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalCoreDsl.g:3863:4: (lv_designators_0_0= ruleDesignator )
            	    {
            	    // InternalCoreDsl.g:3863:4: (lv_designators_0_0= ruleDesignator )
            	    // InternalCoreDsl.g:3864:5: lv_designators_0_0= ruleDesignator
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDesignatedInitializerAccess().getDesignatorsDesignatorParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_74);
            	    lv_designators_0_0=ruleDesignator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDesignatedInitializerRule());
            	      					}
            	      					add(
            	      						current,
            	      						"designators",
            	      						lv_designators_0_0,
            	      						"com.minres.coredsl.CoreDsl.Designator");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt83 >= 1 ) break loop83;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(83, input);
                        throw eee;
                }
                cnt83++;
            } while (true);

            otherlv_1=(Token)match(input,64,FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDesignatedInitializerAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalCoreDsl.g:3885:3: ( (lv_init_2_0= ruleInitializer ) )
            // InternalCoreDsl.g:3886:4: (lv_init_2_0= ruleInitializer )
            {
            // InternalCoreDsl.g:3886:4: (lv_init_2_0= ruleInitializer )
            // InternalCoreDsl.g:3887:5: lv_init_2_0= ruleInitializer
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDesignatedInitializerAccess().getInitInitializerParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_init_2_0=ruleInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDesignatedInitializerRule());
              					}
              					set(
              						current,
              						"init",
              						lv_init_2_0,
              						"com.minres.coredsl.CoreDsl.Initializer");
              					afterParserOrEnumRuleCall();
              				
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
    // $ANTLR end "ruleDesignatedInitializer"


    // $ANTLR start "entryRuleDesignator"
    // InternalCoreDsl.g:3908:1: entryRuleDesignator returns [EObject current=null] : iv_ruleDesignator= ruleDesignator EOF ;
    public final EObject entryRuleDesignator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesignator = null;


        try {
            // InternalCoreDsl.g:3908:51: (iv_ruleDesignator= ruleDesignator EOF )
            // InternalCoreDsl.g:3909:2: iv_ruleDesignator= ruleDesignator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDesignatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDesignator=ruleDesignator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDesignator; 
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
    // $ANTLR end "entryRuleDesignator"


    // $ANTLR start "ruleDesignator"
    // InternalCoreDsl.g:3915:1: ruleDesignator returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) ) ;
    public final EObject ruleDesignator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_prop_4_0=null;
        EObject lv_idx_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3921:2: ( ( (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:3922:2: ( (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:3922:2: ( (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==43) ) {
                alt84=1;
            }
            else if ( (LA84_0==65) ) {
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
                    // InternalCoreDsl.g:3923:3: (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' )
                    {
                    // InternalCoreDsl.g:3923:3: (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' )
                    // InternalCoreDsl.g:3924:4: otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']'
                    {
                    otherlv_0=(Token)match(input,43,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getDesignatorAccess().getLeftSquareBracketKeyword_0_0());
                      			
                    }
                    // InternalCoreDsl.g:3928:4: ( (lv_idx_1_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:3929:5: (lv_idx_1_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:3929:5: (lv_idx_1_0= ruleConstantExpression )
                    // InternalCoreDsl.g:3930:6: lv_idx_1_0= ruleConstantExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDesignatorAccess().getIdxConstantExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
                    lv_idx_1_0=ruleConstantExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDesignatorRule());
                      						}
                      						set(
                      							current,
                      							"idx",
                      							lv_idx_1_0,
                      							"com.minres.coredsl.CoreDsl.ConstantExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getDesignatorAccess().getRightSquareBracketKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3953:3: (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:3953:3: (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:3954:4: otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDesignatorAccess().getFullStopKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3958:4: ( (lv_prop_4_0= RULE_ID ) )
                    // InternalCoreDsl.g:3959:5: (lv_prop_4_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3959:5: (lv_prop_4_0= RULE_ID )
                    // InternalCoreDsl.g:3960:6: lv_prop_4_0= RULE_ID
                    {
                    lv_prop_4_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_prop_4_0, grammarAccess.getDesignatorAccess().getPropIDTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDesignatorRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"prop",
                      							lv_prop_4_0,
                      							"com.minres.coredsl.CoreDsl.ID");
                      					
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
    // $ANTLR end "ruleDesignator"


    // $ANTLR start "entryRuleAbstractDeclarator"
    // InternalCoreDsl.g:3981:1: entryRuleAbstractDeclarator returns [EObject current=null] : iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF ;
    public final EObject entryRuleAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractDeclarator = null;


        try {
            // InternalCoreDsl.g:3981:59: (iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF )
            // InternalCoreDsl.g:3982:2: iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractDeclaratorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAbstractDeclarator=ruleAbstractDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractDeclarator; 
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
    // $ANTLR end "entryRuleAbstractDeclarator"


    // $ANTLR start "ruleAbstractDeclarator"
    // InternalCoreDsl.g:3988:1: ruleAbstractDeclarator returns [EObject current=null] : this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator ;
    public final EObject ruleAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject this_DirectAbstractDeclarator_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3994:2: (this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator )
            // InternalCoreDsl.g:3995:2: this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getAbstractDeclaratorAccess().getDirectAbstractDeclaratorParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_DirectAbstractDeclarator_0=ruleDirectAbstractDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_DirectAbstractDeclarator_0;
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
    // $ANTLR end "ruleAbstractDeclarator"


    // $ANTLR start "entryRuleDirectAbstractDeclarator"
    // InternalCoreDsl.g:4006:1: entryRuleDirectAbstractDeclarator returns [EObject current=null] : iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF ;
    public final EObject entryRuleDirectAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectAbstractDeclarator = null;


        try {
            // InternalCoreDsl.g:4006:65: (iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF )
            // InternalCoreDsl.g:4007:2: iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectAbstractDeclaratorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDirectAbstractDeclarator=ruleDirectAbstractDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectAbstractDeclarator; 
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
    // $ANTLR end "entryRuleDirectAbstractDeclarator"


    // $ANTLR start "ruleDirectAbstractDeclarator"
    // InternalCoreDsl.g:4013:1: ruleDirectAbstractDeclarator returns [EObject current=null] : ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' ) ) ;
    public final EObject ruleDirectAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_declarator_2_0 = null;

        EObject this_ParameterList_3 = null;

        EObject lv_expr_7_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4019:2: ( ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' ) ) )
            // InternalCoreDsl.g:4020:2: ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' ) )
            {
            // InternalCoreDsl.g:4020:2: ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==46) ) {
                alt88=1;
            }
            else if ( (LA88_0==43) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // InternalCoreDsl.g:4021:3: ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' )
                    {
                    // InternalCoreDsl.g:4021:3: ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' )
                    // InternalCoreDsl.g:4022:4: () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')'
                    {
                    // InternalCoreDsl.g:4022:4: ()
                    // InternalCoreDsl.g:4023:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDirectAbstractDeclaratorAccess().getDirectAbstractDeclaratorAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,46,FOLLOW_75); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectAbstractDeclaratorAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalCoreDsl.g:4033:4: ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] )
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==43||(LA86_0>=46 && LA86_0<=47)) ) {
                        alt86=1;
                    }
                    else if ( (LA86_0==RULE_ID||LA86_0==63||(LA86_0>=106 && LA86_0<=116)||(LA86_0>=126 && LA86_0<=127)) ) {
                        alt86=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 86, 0, input);

                        throw nvae;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalCoreDsl.g:4034:5: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )?
                            {
                            // InternalCoreDsl.g:4034:5: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )?
                            int alt85=2;
                            int LA85_0 = input.LA(1);

                            if ( (LA85_0==43||LA85_0==46) ) {
                                alt85=1;
                            }
                            switch (alt85) {
                                case 1 :
                                    // InternalCoreDsl.g:4035:6: (lv_declarator_2_0= ruleAbstractDeclarator )
                                    {
                                    // InternalCoreDsl.g:4035:6: (lv_declarator_2_0= ruleAbstractDeclarator )
                                    // InternalCoreDsl.g:4036:7: lv_declarator_2_0= ruleAbstractDeclarator
                                    {
                                    if ( state.backtracking==0 ) {

                                      							newCompositeNode(grammarAccess.getDirectAbstractDeclaratorAccess().getDeclaratorAbstractDeclaratorParserRuleCall_0_2_0_0());
                                      						
                                    }
                                    pushFollow(FOLLOW_42);
                                    lv_declarator_2_0=ruleAbstractDeclarator();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							if (current==null) {
                                      								current = createModelElementForParent(grammarAccess.getDirectAbstractDeclaratorRule());
                                      							}
                                      							set(
                                      								current,
                                      								"declarator",
                                      								lv_declarator_2_0,
                                      								"com.minres.coredsl.CoreDsl.AbstractDeclarator");
                                      							afterParserOrEnumRuleCall();
                                      						
                                    }

                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:4054:5: this_ParameterList_3= ruleParameterList[$current]
                            {
                            if ( state.backtracking==0 ) {

                              					if (current==null) {
                              						current = createModelElement(grammarAccess.getDirectAbstractDeclaratorRule());
                              					}
                              					newCompositeNode(grammarAccess.getDirectAbstractDeclaratorAccess().getParameterListParserRuleCall_0_2_1());
                              				
                            }
                            pushFollow(FOLLOW_42);
                            this_ParameterList_3=ruleParameterList(current);

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current = this_ParameterList_3;
                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDirectAbstractDeclaratorAccess().getRightParenthesisKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4072:3: ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' )
                    {
                    // InternalCoreDsl.g:4072:3: ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' )
                    // InternalCoreDsl.g:4073:4: () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']'
                    {
                    // InternalCoreDsl.g:4073:4: ()
                    // InternalCoreDsl.g:4074:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDirectAbstractDeclaratorAccess().getDirectAbstractDeclaratorAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_6=(Token)match(input,43,FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getDirectAbstractDeclaratorAccess().getLeftSquareBracketKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:4084:4: ( (lv_expr_7_0= ruleConstantExpression ) )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( ((LA87_0>=RULE_STRING && LA87_0<=RULE_ID)||(LA87_0>=RULE_INTEGER && LA87_0<=RULE_CHARCONST)||LA87_0==46||LA87_0==59||LA87_0==80||(LA87_0>=87 && LA87_0<=88)||(LA87_0>=91 && LA87_0<=95)||(LA87_0>=97 && LA87_0<=100)) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalCoreDsl.g:4085:5: (lv_expr_7_0= ruleConstantExpression )
                            {
                            // InternalCoreDsl.g:4085:5: (lv_expr_7_0= ruleConstantExpression )
                            // InternalCoreDsl.g:4086:6: lv_expr_7_0= ruleConstantExpression
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getDirectAbstractDeclaratorAccess().getExprConstantExpressionParserRuleCall_1_2_0());
                              					
                            }
                            pushFollow(FOLLOW_40);
                            lv_expr_7_0=ruleConstantExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getDirectAbstractDeclaratorRule());
                              						}
                              						set(
                              							current,
                              							"expr",
                              							lv_expr_7_0,
                              							"com.minres.coredsl.CoreDsl.ConstantExpression");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getDirectAbstractDeclaratorAccess().getRightSquareBracketKeyword_1_3());
                      			
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
    // $ANTLR end "ruleDirectAbstractDeclarator"


    // $ANTLR start "entryRuleExpression"
    // InternalCoreDsl.g:4112:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalCoreDsl.g:4112:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalCoreDsl.g:4113:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalCoreDsl.g:4119:1: ruleExpression returns [EObject current=null] : (this_AssignmentExpression_0= ruleAssignmentExpression ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )? ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AssignmentExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4125:2: ( (this_AssignmentExpression_0= ruleAssignmentExpression ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )? ) )
            // InternalCoreDsl.g:4126:2: (this_AssignmentExpression_0= ruleAssignmentExpression ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )? )
            {
            // InternalCoreDsl.g:4126:2: (this_AssignmentExpression_0= ruleAssignmentExpression ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )? )
            // InternalCoreDsl.g:4127:3: this_AssignmentExpression_0= ruleAssignmentExpression ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_43);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AssignmentExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4135:3: ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==33) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalCoreDsl.g:4136:4: () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) )
                    {
                    // InternalCoreDsl.g:4136:4: ()
                    // InternalCoreDsl.g:4137:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getExpressionAccess().getExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,33,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getCommaKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:4147:4: ( (lv_right_3_0= ruleAssignmentExpression ) )
                    // InternalCoreDsl.g:4148:5: (lv_right_3_0= ruleAssignmentExpression )
                    {
                    // InternalCoreDsl.g:4148:5: (lv_right_3_0= ruleAssignmentExpression )
                    // InternalCoreDsl.g:4149:6: lv_right_3_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionAccess().getRightAssignmentExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.AssignmentExpression");
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalCoreDsl.g:4171:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalCoreDsl.g:4171:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalCoreDsl.g:4172:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
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
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalCoreDsl.g:4178:1: ruleAssignmentExpression returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression () ( ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_assignment_2_1=null;
        Token lv_assignment_2_2=null;
        Token lv_assignment_2_3=null;
        Token lv_assignment_2_4=null;
        Token lv_assignment_2_5=null;
        Token lv_assignment_2_6=null;
        Token lv_assignment_2_7=null;
        Token lv_assignment_2_8=null;
        Token lv_assignment_2_9=null;
        Token lv_assignment_2_10=null;
        Token lv_assignment_2_11=null;
        EObject this_PrefixExpression_0 = null;

        EObject lv_rights_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4184:2: ( (this_PrefixExpression_0= rulePrefixExpression () ( ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ ) )
            // InternalCoreDsl.g:4185:2: (this_PrefixExpression_0= rulePrefixExpression () ( ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ )
            {
            // InternalCoreDsl.g:4185:2: (this_PrefixExpression_0= rulePrefixExpression () ( ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ )
            // InternalCoreDsl.g:4186:3: this_PrefixExpression_0= rulePrefixExpression () ( ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getPrefixExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_76);
            this_PrefixExpression_0=rulePrefixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrefixExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4194:3: ()
            // InternalCoreDsl.g:4195:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElementAndSet(
              					grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLeftAction_1(),
              					current);
              			
            }

            }

            // InternalCoreDsl.g:4201:3: ( ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+
            int cnt91=0;
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==64||(LA91_0>=66 && LA91_0<=75)) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalCoreDsl.g:4202:4: ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) )
            	    {
            	    // InternalCoreDsl.g:4202:4: ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) )
            	    // InternalCoreDsl.g:4203:5: ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) )
            	    {
            	    // InternalCoreDsl.g:4203:5: ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) )
            	    // InternalCoreDsl.g:4204:6: (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' )
            	    {
            	    // InternalCoreDsl.g:4204:6: (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' )
            	    int alt90=11;
            	    switch ( input.LA(1) ) {
            	    case 64:
            	        {
            	        alt90=1;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt90=2;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt90=3;
            	        }
            	        break;
            	    case 68:
            	        {
            	        alt90=4;
            	        }
            	        break;
            	    case 69:
            	        {
            	        alt90=5;
            	        }
            	        break;
            	    case 70:
            	        {
            	        alt90=6;
            	        }
            	        break;
            	    case 71:
            	        {
            	        alt90=7;
            	        }
            	        break;
            	    case 72:
            	        {
            	        alt90=8;
            	        }
            	        break;
            	    case 73:
            	        {
            	        alt90=9;
            	        }
            	        break;
            	    case 74:
            	        {
            	        alt90=10;
            	        }
            	        break;
            	    case 75:
            	        {
            	        alt90=11;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 90, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt90) {
            	        case 1 :
            	            // InternalCoreDsl.g:4205:7: lv_assignment_2_1= '='
            	            {
            	            lv_assignment_2_1=(Token)match(input,64,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_1, grammarAccess.getAssignmentExpressionAccess().getAssignmentEqualsSignKeyword_2_0_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalCoreDsl.g:4216:7: lv_assignment_2_2= '*='
            	            {
            	            lv_assignment_2_2=(Token)match(input,66,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_2, grammarAccess.getAssignmentExpressionAccess().getAssignmentAsteriskEqualsSignKeyword_2_0_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalCoreDsl.g:4227:7: lv_assignment_2_3= '/='
            	            {
            	            lv_assignment_2_3=(Token)match(input,67,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_3, grammarAccess.getAssignmentExpressionAccess().getAssignmentSolidusEqualsSignKeyword_2_0_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_3, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalCoreDsl.g:4238:7: lv_assignment_2_4= '%='
            	            {
            	            lv_assignment_2_4=(Token)match(input,68,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_4, grammarAccess.getAssignmentExpressionAccess().getAssignmentPercentSignEqualsSignKeyword_2_0_0_3());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_4, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // InternalCoreDsl.g:4249:7: lv_assignment_2_5= '+='
            	            {
            	            lv_assignment_2_5=(Token)match(input,69,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_5, grammarAccess.getAssignmentExpressionAccess().getAssignmentPlusSignEqualsSignKeyword_2_0_0_4());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_5, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // InternalCoreDsl.g:4260:7: lv_assignment_2_6= '-='
            	            {
            	            lv_assignment_2_6=(Token)match(input,70,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_6, grammarAccess.getAssignmentExpressionAccess().getAssignmentHyphenMinusEqualsSignKeyword_2_0_0_5());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_6, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 7 :
            	            // InternalCoreDsl.g:4271:7: lv_assignment_2_7= '<<='
            	            {
            	            lv_assignment_2_7=(Token)match(input,71,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_7, grammarAccess.getAssignmentExpressionAccess().getAssignmentLessThanSignLessThanSignEqualsSignKeyword_2_0_0_6());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_7, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 8 :
            	            // InternalCoreDsl.g:4282:7: lv_assignment_2_8= '>>='
            	            {
            	            lv_assignment_2_8=(Token)match(input,72,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_8, grammarAccess.getAssignmentExpressionAccess().getAssignmentGreaterThanSignGreaterThanSignEqualsSignKeyword_2_0_0_7());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_8, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 9 :
            	            // InternalCoreDsl.g:4293:7: lv_assignment_2_9= '&='
            	            {
            	            lv_assignment_2_9=(Token)match(input,73,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_9, grammarAccess.getAssignmentExpressionAccess().getAssignmentAmpersandEqualsSignKeyword_2_0_0_8());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_9, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 10 :
            	            // InternalCoreDsl.g:4304:7: lv_assignment_2_10= '^='
            	            {
            	            lv_assignment_2_10=(Token)match(input,74,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_10, grammarAccess.getAssignmentExpressionAccess().getAssignmentCircumflexAccentEqualsSignKeyword_2_0_0_9());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_10, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 11 :
            	            // InternalCoreDsl.g:4315:7: lv_assignment_2_11= '|='
            	            {
            	            lv_assignment_2_11=(Token)match(input,75,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_11, grammarAccess.getAssignmentExpressionAccess().getAssignmentVerticalLineEqualsSignKeyword_2_0_0_10());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpressionRule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_11, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalCoreDsl.g:4328:4: ( (lv_rights_3_0= ruleConditionalExpression ) )
            	    // InternalCoreDsl.g:4329:5: (lv_rights_3_0= ruleConditionalExpression )
            	    {
            	    // InternalCoreDsl.g:4329:5: (lv_rights_3_0= ruleConditionalExpression )
            	    // InternalCoreDsl.g:4330:6: lv_rights_3_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightsConditionalExpressionParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_77);
            	    lv_rights_3_0=ruleConditionalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"rights",
            	      							lv_rights_3_0,
            	      							"com.minres.coredsl.CoreDsl.ConditionalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt91 >= 1 ) break loop91;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(91, input);
                        throw eee;
                }
                cnt91++;
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
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // InternalCoreDsl.g:4352:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalCoreDsl.g:4352:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalCoreDsl.g:4353:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalExpression; 
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
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // InternalCoreDsl.g:4359:1: ruleConditionalExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_left_3_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4365:2: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalCoreDsl.g:4366:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalCoreDsl.g:4366:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? )
            // InternalCoreDsl.g:4367:3: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_78);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4375:3: ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==76) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalCoreDsl.g:4376:4: () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) )
                    {
                    // InternalCoreDsl.g:4376:4: ()
                    // InternalCoreDsl.g:4377:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getConditionalExpressionAccess().getConditionalExpressionCondAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,76,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:4387:4: ( (lv_left_3_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:4388:5: (lv_left_3_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:4388:5: (lv_left_3_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:4389:6: lv_left_3_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLeftConditionalExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_30);
                    lv_left_3_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_3_0,
                      							"com.minres.coredsl.CoreDsl.ConditionalExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,37,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                      			
                    }
                    // InternalCoreDsl.g:4410:4: ( (lv_right_5_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:4411:5: (lv_right_5_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:4411:5: (lv_right_5_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:4412:6: lv_right_5_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getRightConditionalExpressionParserRuleCall_1_4_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_5_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_5_0,
                      							"com.minres.coredsl.CoreDsl.ConditionalExpression");
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
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalCoreDsl.g:4434:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalCoreDsl.g:4434:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalCoreDsl.g:4435:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
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
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // InternalCoreDsl.g:4441:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4447:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4448:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4448:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? )
            // InternalCoreDsl.g:4449:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_79);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4457:3: ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==77) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalCoreDsl.g:4458:4: () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) )
                    {
                    // InternalCoreDsl.g:4458:4: ()
                    // InternalCoreDsl.g:4459:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getLogicalOrExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4465:4: ( (lv_op_2_0= '||' ) )
                    // InternalCoreDsl.g:4466:5: (lv_op_2_0= '||' )
                    {
                    // InternalCoreDsl.g:4466:5: (lv_op_2_0= '||' )
                    // InternalCoreDsl.g:4467:6: lv_op_2_0= '||'
                    {
                    lv_op_2_0=(Token)match(input,77,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_0, grammarAccess.getLogicalOrExpressionAccess().getOpVerticalLineVerticalLineKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLogicalOrExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_0, "||");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:4479:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
                    // InternalCoreDsl.g:4480:5: (lv_right_3_0= ruleLogicalOrExpression )
                    {
                    // InternalCoreDsl.g:4480:5: (lv_right_3_0= ruleLogicalOrExpression )
                    // InternalCoreDsl.g:4481:6: lv_right_3_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleLogicalOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.LogicalOrExpression");
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
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalCoreDsl.g:4503:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalCoreDsl.g:4503:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalCoreDsl.g:4504:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
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
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // InternalCoreDsl.g:4510:1: ruleLogicalAndExpression returns [EObject current=null] : (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_InclusiveOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4516:2: ( (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? ) )
            // InternalCoreDsl.g:4517:2: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? )
            {
            // InternalCoreDsl.g:4517:2: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? )
            // InternalCoreDsl.g:4518:3: this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getInclusiveOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_80);
            this_InclusiveOrExpression_0=ruleInclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_InclusiveOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4526:3: ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==78) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalCoreDsl.g:4527:4: () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    {
                    // InternalCoreDsl.g:4527:4: ()
                    // InternalCoreDsl.g:4528:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getLogicalAndExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4534:4: ( (lv_op_2_0= '&&' ) )
                    // InternalCoreDsl.g:4535:5: (lv_op_2_0= '&&' )
                    {
                    // InternalCoreDsl.g:4535:5: (lv_op_2_0= '&&' )
                    // InternalCoreDsl.g:4536:6: lv_op_2_0= '&&'
                    {
                    lv_op_2_0=(Token)match(input,78,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_0, grammarAccess.getLogicalAndExpressionAccess().getOpAmpersandAmpersandKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLogicalAndExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_0, "&&");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:4548:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    // InternalCoreDsl.g:4549:5: (lv_right_3_0= ruleLogicalAndExpression )
                    {
                    // InternalCoreDsl.g:4549:5: (lv_right_3_0= ruleLogicalAndExpression )
                    // InternalCoreDsl.g:4550:6: lv_right_3_0= ruleLogicalAndExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleLogicalAndExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.LogicalAndExpression");
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
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleInclusiveOrExpression"
    // InternalCoreDsl.g:4572:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalCoreDsl.g:4572:62: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalCoreDsl.g:4573:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInclusiveOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInclusiveOrExpression=ruleInclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInclusiveOrExpression; 
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
    // $ANTLR end "entryRuleInclusiveOrExpression"


    // $ANTLR start "ruleInclusiveOrExpression"
    // InternalCoreDsl.g:4579:1: ruleInclusiveOrExpression returns [EObject current=null] : (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_ExclusiveOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4585:2: ( (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4586:2: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4586:2: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? )
            // InternalCoreDsl.g:4587:3: this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExclusiveOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_35);
            this_ExclusiveOrExpression_0=ruleExclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExclusiveOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4595:3: ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==41) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalCoreDsl.g:4596:4: () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) )
                    {
                    // InternalCoreDsl.g:4596:4: ()
                    // InternalCoreDsl.g:4597:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getInclusiveOrExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4603:4: ( (lv_op_2_0= '|' ) )
                    // InternalCoreDsl.g:4604:5: (lv_op_2_0= '|' )
                    {
                    // InternalCoreDsl.g:4604:5: (lv_op_2_0= '|' )
                    // InternalCoreDsl.g:4605:6: lv_op_2_0= '|'
                    {
                    lv_op_2_0=(Token)match(input,41,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_0, grammarAccess.getInclusiveOrExpressionAccess().getOpVerticalLineKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getInclusiveOrExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_0, "|");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:4617:4: ( (lv_right_3_0= ruleInclusiveOrExpression ) )
                    // InternalCoreDsl.g:4618:5: (lv_right_3_0= ruleInclusiveOrExpression )
                    {
                    // InternalCoreDsl.g:4618:5: (lv_right_3_0= ruleInclusiveOrExpression )
                    // InternalCoreDsl.g:4619:6: lv_right_3_0= ruleInclusiveOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getRightInclusiveOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleInclusiveOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInclusiveOrExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.InclusiveOrExpression");
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
    // $ANTLR end "ruleInclusiveOrExpression"


    // $ANTLR start "entryRuleExclusiveOrExpression"
    // InternalCoreDsl.g:4641:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalCoreDsl.g:4641:62: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalCoreDsl.g:4642:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExclusiveOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExclusiveOrExpression=ruleExclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExclusiveOrExpression; 
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
    // $ANTLR end "entryRuleExclusiveOrExpression"


    // $ANTLR start "ruleExclusiveOrExpression"
    // InternalCoreDsl.g:4648:1: ruleExclusiveOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4654:2: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4655:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4655:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? )
            // InternalCoreDsl.g:4656:3: this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_81);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4664:3: ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==79) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalCoreDsl.g:4665:4: () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) )
                    {
                    // InternalCoreDsl.g:4665:4: ()
                    // InternalCoreDsl.g:4666:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getExclusiveOrExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4672:4: ( (lv_op_2_0= '^' ) )
                    // InternalCoreDsl.g:4673:5: (lv_op_2_0= '^' )
                    {
                    // InternalCoreDsl.g:4673:5: (lv_op_2_0= '^' )
                    // InternalCoreDsl.g:4674:6: lv_op_2_0= '^'
                    {
                    lv_op_2_0=(Token)match(input,79,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_0, grammarAccess.getExclusiveOrExpressionAccess().getOpCircumflexAccentKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getExclusiveOrExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_0, "^");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:4686:4: ( (lv_right_3_0= ruleExclusiveOrExpression ) )
                    // InternalCoreDsl.g:4687:5: (lv_right_3_0= ruleExclusiveOrExpression )
                    {
                    // InternalCoreDsl.g:4687:5: (lv_right_3_0= ruleExclusiveOrExpression )
                    // InternalCoreDsl.g:4688:6: lv_right_3_0= ruleExclusiveOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getRightExclusiveOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleExclusiveOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExclusiveOrExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.ExclusiveOrExpression");
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
    // $ANTLR end "ruleExclusiveOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalCoreDsl.g:4710:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalCoreDsl.g:4710:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalCoreDsl.g:4711:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
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
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalCoreDsl.g:4717:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4723:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? ) )
            // InternalCoreDsl.g:4724:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? )
            {
            // InternalCoreDsl.g:4724:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? )
            // InternalCoreDsl.g:4725:3: this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_82);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4733:3: ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==80) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalCoreDsl.g:4734:4: () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) )
                    {
                    // InternalCoreDsl.g:4734:4: ()
                    // InternalCoreDsl.g:4735:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAndExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4741:4: ( (lv_op_2_0= '&' ) )
                    // InternalCoreDsl.g:4742:5: (lv_op_2_0= '&' )
                    {
                    // InternalCoreDsl.g:4742:5: (lv_op_2_0= '&' )
                    // InternalCoreDsl.g:4743:6: lv_op_2_0= '&'
                    {
                    lv_op_2_0=(Token)match(input,80,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_0, grammarAccess.getAndExpressionAccess().getOpAmpersandKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAndExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_0, "&");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:4755:4: ( (lv_right_3_0= ruleAndExpression ) )
                    // InternalCoreDsl.g:4756:5: (lv_right_3_0= ruleAndExpression )
                    {
                    // InternalCoreDsl.g:4756:5: (lv_right_3_0= ruleAndExpression )
                    // InternalCoreDsl.g:4757:6: lv_right_3_0= ruleAndExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleAndExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.AndExpression");
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
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalCoreDsl.g:4779:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalCoreDsl.g:4779:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalCoreDsl.g:4780:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
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
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalCoreDsl.g:4786:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4792:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? ) )
            // InternalCoreDsl.g:4793:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? )
            {
            // InternalCoreDsl.g:4793:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? )
            // InternalCoreDsl.g:4794:3: this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_83);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4802:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( ((LA99_0>=81 && LA99_0<=82)) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalCoreDsl.g:4803:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
                    {
                    // InternalCoreDsl.g:4803:4: ()
                    // InternalCoreDsl.g:4804:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getEqualityExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4810:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
                    // InternalCoreDsl.g:4811:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
                    {
                    // InternalCoreDsl.g:4811:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
                    // InternalCoreDsl.g:4812:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
                    {
                    // InternalCoreDsl.g:4812:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( (LA98_0==81) ) {
                        alt98=1;
                    }
                    else if ( (LA98_0==82) ) {
                        alt98=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 98, 0, input);

                        throw nvae;
                    }
                    switch (alt98) {
                        case 1 :
                            // InternalCoreDsl.g:4813:7: lv_op_2_1= '=='
                            {
                            lv_op_2_1=(Token)match(input,81,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_1, grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEqualityExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:4824:7: lv_op_2_2= '!='
                            {
                            lv_op_2_2=(Token)match(input,82,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_2, grammarAccess.getEqualityExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEqualityExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalCoreDsl.g:4837:4: ( (lv_right_3_0= ruleEqualityExpression ) )
                    // InternalCoreDsl.g:4838:5: (lv_right_3_0= ruleEqualityExpression )
                    {
                    // InternalCoreDsl.g:4838:5: (lv_right_3_0= ruleEqualityExpression )
                    // InternalCoreDsl.g:4839:6: lv_right_3_0= ruleEqualityExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleEqualityExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.EqualityExpression");
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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalCoreDsl.g:4861:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalCoreDsl.g:4861:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalCoreDsl.g:4862:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
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
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalCoreDsl.g:4868:1: ruleRelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_ShiftExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4874:2: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? ) )
            // InternalCoreDsl.g:4875:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? )
            {
            // InternalCoreDsl.g:4875:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? )
            // InternalCoreDsl.g:4876:3: this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_84);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4884:3: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( ((LA101_0>=61 && LA101_0<=62)||(LA101_0>=83 && LA101_0<=84)) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalCoreDsl.g:4885:4: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
                    {
                    // InternalCoreDsl.g:4885:4: ()
                    // InternalCoreDsl.g:4886:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getRelationalExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4892:4: ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
                    // InternalCoreDsl.g:4893:5: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
                    {
                    // InternalCoreDsl.g:4893:5: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
                    // InternalCoreDsl.g:4894:6: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
                    {
                    // InternalCoreDsl.g:4894:6: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
                    int alt100=4;
                    switch ( input.LA(1) ) {
                    case 61:
                        {
                        alt100=1;
                        }
                        break;
                    case 62:
                        {
                        alt100=2;
                        }
                        break;
                    case 83:
                        {
                        alt100=3;
                        }
                        break;
                    case 84:
                        {
                        alt100=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 100, 0, input);

                        throw nvae;
                    }

                    switch (alt100) {
                        case 1 :
                            // InternalCoreDsl.g:4895:7: lv_op_2_1= '<'
                            {
                            lv_op_2_1=(Token)match(input,61,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_1, grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getRelationalExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:4906:7: lv_op_2_2= '>'
                            {
                            lv_op_2_2=(Token)match(input,62,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_2, grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getRelationalExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_2, null);
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalCoreDsl.g:4917:7: lv_op_2_3= '<='
                            {
                            lv_op_2_3=(Token)match(input,83,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_3, grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_2());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getRelationalExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_3, null);
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalCoreDsl.g:4928:7: lv_op_2_4= '>='
                            {
                            lv_op_2_4=(Token)match(input,84,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_4, grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_3());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getRelationalExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_4, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalCoreDsl.g:4941:4: ( (lv_right_3_0= ruleRelationalExpression ) )
                    // InternalCoreDsl.g:4942:5: (lv_right_3_0= ruleRelationalExpression )
                    {
                    // InternalCoreDsl.g:4942:5: (lv_right_3_0= ruleRelationalExpression )
                    // InternalCoreDsl.g:4943:6: lv_right_3_0= ruleRelationalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleRelationalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.RelationalExpression");
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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalCoreDsl.g:4965:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalCoreDsl.g:4965:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalCoreDsl.g:4966:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
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
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // InternalCoreDsl.g:4972:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4978:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? ) )
            // InternalCoreDsl.g:4979:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? )
            {
            // InternalCoreDsl.g:4979:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? )
            // InternalCoreDsl.g:4980:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_85);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4988:3: ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( ((LA103_0>=85 && LA103_0<=86)) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalCoreDsl.g:4989:4: () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) )
                    {
                    // InternalCoreDsl.g:4989:4: ()
                    // InternalCoreDsl.g:4990:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getShiftExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4996:4: ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) )
                    // InternalCoreDsl.g:4997:5: ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) )
                    {
                    // InternalCoreDsl.g:4997:5: ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) )
                    // InternalCoreDsl.g:4998:6: (lv_op_2_1= '<<' | lv_op_2_2= '>>' )
                    {
                    // InternalCoreDsl.g:4998:6: (lv_op_2_1= '<<' | lv_op_2_2= '>>' )
                    int alt102=2;
                    int LA102_0 = input.LA(1);

                    if ( (LA102_0==85) ) {
                        alt102=1;
                    }
                    else if ( (LA102_0==86) ) {
                        alt102=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 102, 0, input);

                        throw nvae;
                    }
                    switch (alt102) {
                        case 1 :
                            // InternalCoreDsl.g:4999:7: lv_op_2_1= '<<'
                            {
                            lv_op_2_1=(Token)match(input,85,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_1, grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getShiftExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:5010:7: lv_op_2_2= '>>'
                            {
                            lv_op_2_2=(Token)match(input,86,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_2, grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getShiftExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalCoreDsl.g:5023:4: ( (lv_right_3_0= ruleShiftExpression ) )
                    // InternalCoreDsl.g:5024:5: (lv_right_3_0= ruleShiftExpression )
                    {
                    // InternalCoreDsl.g:5024:5: (lv_right_3_0= ruleShiftExpression )
                    // InternalCoreDsl.g:5025:6: lv_right_3_0= ruleShiftExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightShiftExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleShiftExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.ShiftExpression");
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
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalCoreDsl.g:5047:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalCoreDsl.g:5047:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalCoreDsl.g:5048:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
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
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalCoreDsl.g:5054:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5060:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) )
            // InternalCoreDsl.g:5061:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            {
            // InternalCoreDsl.g:5061:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            // InternalCoreDsl.g:5062:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_86);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5070:3: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( ((LA105_0>=87 && LA105_0<=88)) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalCoreDsl.g:5071:4: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
                    {
                    // InternalCoreDsl.g:5071:4: ()
                    // InternalCoreDsl.g:5072:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAdditiveExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5078:4: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    // InternalCoreDsl.g:5079:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    {
                    // InternalCoreDsl.g:5079:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    // InternalCoreDsl.g:5080:6: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    {
                    // InternalCoreDsl.g:5080:6: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==87) ) {
                        alt104=1;
                    }
                    else if ( (LA104_0==88) ) {
                        alt104=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 104, 0, input);

                        throw nvae;
                    }
                    switch (alt104) {
                        case 1 :
                            // InternalCoreDsl.g:5081:7: lv_op_2_1= '+'
                            {
                            lv_op_2_1=(Token)match(input,87,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_1, grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:5092:7: lv_op_2_2= '-'
                            {
                            lv_op_2_2=(Token)match(input,88,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_2, grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalCoreDsl.g:5105:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
                    // InternalCoreDsl.g:5106:5: (lv_right_3_0= ruleAdditiveExpression )
                    {
                    // InternalCoreDsl.g:5106:5: (lv_right_3_0= ruleAdditiveExpression )
                    // InternalCoreDsl.g:5107:6: lv_right_3_0= ruleAdditiveExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleAdditiveExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.AdditiveExpression");
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalCoreDsl.g:5129:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalCoreDsl.g:5129:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalCoreDsl.g:5130:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
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
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalCoreDsl.g:5136:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_CastExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5142:2: ( (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? ) )
            // InternalCoreDsl.g:5143:2: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? )
            {
            // InternalCoreDsl.g:5143:2: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? )
            // InternalCoreDsl.g:5144:3: this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_87);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CastExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5152:3: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==59||(LA107_0>=89 && LA107_0<=90)) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalCoreDsl.g:5153:4: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    {
                    // InternalCoreDsl.g:5153:4: ()
                    // InternalCoreDsl.g:5154:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getMultiplicativeExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5160:4: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) )
                    // InternalCoreDsl.g:5161:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
                    {
                    // InternalCoreDsl.g:5161:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
                    // InternalCoreDsl.g:5162:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
                    {
                    // InternalCoreDsl.g:5162:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
                    int alt106=3;
                    switch ( input.LA(1) ) {
                    case 59:
                        {
                        alt106=1;
                        }
                        break;
                    case 89:
                        {
                        alt106=2;
                        }
                        break;
                    case 90:
                        {
                        alt106=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 106, 0, input);

                        throw nvae;
                    }

                    switch (alt106) {
                        case 1 :
                            // InternalCoreDsl.g:5163:7: lv_op_2_1= '*'
                            {
                            lv_op_2_1=(Token)match(input,59,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_1, grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:5174:7: lv_op_2_2= '/'
                            {
                            lv_op_2_2=(Token)match(input,89,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_2, grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_2, null);
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalCoreDsl.g:5185:7: lv_op_2_3= '%'
                            {
                            lv_op_2_3=(Token)match(input,90,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_2_3, grammarAccess.getMultiplicativeExpressionAccess().getOpPercentSignKeyword_1_1_0_2());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_2_3, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalCoreDsl.g:5198:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    // InternalCoreDsl.g:5199:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    {
                    // InternalCoreDsl.g:5199:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    // InternalCoreDsl.g:5200:6: lv_right_3_0= ruleMultiplicativeExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleMultiplicativeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.MultiplicativeExpression");
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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleCastExpression"
    // InternalCoreDsl.g:5222:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalCoreDsl.g:5222:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalCoreDsl.g:5223:2: iv_ruleCastExpression= ruleCastExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCastExpression=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCastExpression; 
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
    // $ANTLR end "entryRuleCastExpression"


    // $ANTLR start "ruleCastExpression"
    // InternalCoreDsl.g:5229:1: ruleCastExpression returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_PrefixExpression_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_left_4_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5235:2: ( (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) ) )
            // InternalCoreDsl.g:5236:2: (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) )
            {
            // InternalCoreDsl.g:5236:2: (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( ((LA108_0>=RULE_STRING && LA108_0<=RULE_ID)||(LA108_0>=RULE_INTEGER && LA108_0<=RULE_CHARCONST)||LA108_0==59||LA108_0==80||(LA108_0>=87 && LA108_0<=88)||(LA108_0>=91 && LA108_0<=95)||(LA108_0>=97 && LA108_0<=100)) ) {
                alt108=1;
            }
            else if ( (LA108_0==46) ) {
                int LA108_2 = input.LA(2);

                if ( (LA108_2==63||(LA108_2>=106 && LA108_2<=116)||(LA108_2>=126 && LA108_2<=127)) ) {
                    alt108=2;
                }
                else if ( ((LA108_2>=RULE_STRING && LA108_2<=RULE_ID)||(LA108_2>=RULE_INTEGER && LA108_2<=RULE_CHARCONST)||LA108_2==46||LA108_2==59||LA108_2==80||(LA108_2>=87 && LA108_2<=88)||(LA108_2>=91 && LA108_2<=95)||(LA108_2>=97 && LA108_2<=100)) ) {
                    alt108=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 108, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }
            switch (alt108) {
                case 1 :
                    // InternalCoreDsl.g:5237:3: this_PrefixExpression_0= rulePrefixExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCastExpressionAccess().getPrefixExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PrefixExpression_0=rulePrefixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrefixExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:5246:3: (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) )
                    {
                    // InternalCoreDsl.g:5246:3: (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) )
                    // InternalCoreDsl.g:5247:4: otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,46,FOLLOW_88); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:5251:4: ( (lv_type_2_0= ruleDataTypeSpecifier ) )
                    // InternalCoreDsl.g:5252:5: (lv_type_2_0= ruleDataTypeSpecifier )
                    {
                    // InternalCoreDsl.g:5252:5: (lv_type_2_0= ruleDataTypeSpecifier )
                    // InternalCoreDsl.g:5253:6: lv_type_2_0= ruleDataTypeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeDataTypeSpecifierParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_42);
                    lv_type_2_0=ruleDataTypeSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_2_0,
                      							"com.minres.coredsl.CoreDsl.DataTypeSpecifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,47,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }
                    // InternalCoreDsl.g:5274:4: ( (lv_left_4_0= ruleCastExpression ) )
                    // InternalCoreDsl.g:5275:5: (lv_left_4_0= ruleCastExpression )
                    {
                    // InternalCoreDsl.g:5275:5: (lv_left_4_0= ruleCastExpression )
                    // InternalCoreDsl.g:5276:6: lv_left_4_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getLeftCastExpressionParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_left_4_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_4_0,
                      							"com.minres.coredsl.CoreDsl.CastExpression");
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
    // $ANTLR end "ruleCastExpression"


    // $ANTLR start "entryRulePrefixExpression"
    // InternalCoreDsl.g:5298:1: entryRulePrefixExpression returns [EObject current=null] : iv_rulePrefixExpression= rulePrefixExpression EOF ;
    public final EObject entryRulePrefixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpression = null;


        try {
            // InternalCoreDsl.g:5298:57: (iv_rulePrefixExpression= rulePrefixExpression EOF )
            // InternalCoreDsl.g:5299:2: iv_rulePrefixExpression= rulePrefixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrefixExpression=rulePrefixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixExpression; 
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
    // $ANTLR end "entryRulePrefixExpression"


    // $ANTLR start "rulePrefixExpression"
    // InternalCoreDsl.g:5305:1: rulePrefixExpression returns [EObject current=null] : (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) ) ;
    public final EObject rulePrefixExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        Token lv_op_3_0=null;
        Token lv_op_7_0=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        EObject this_PostfixExpression_0 = null;

        EObject lv_left_2_0 = null;

        EObject lv_left_4_0 = null;

        EObject this_UnaryOperator_5 = null;

        EObject lv_left_6_0 = null;

        EObject lv_left_9_0 = null;

        EObject lv_type_10_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5311:2: ( (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) ) )
            // InternalCoreDsl.g:5312:2: (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) )
            {
            // InternalCoreDsl.g:5312:2: (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) )
            int alt110=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 46:
            case 97:
            case 98:
            case 99:
            case 100:
                {
                alt110=1;
                }
                break;
            case 91:
                {
                alt110=2;
                }
                break;
            case 92:
                {
                alt110=3;
                }
                break;
            case 59:
            case 80:
            case 87:
            case 88:
            case 94:
            case 95:
                {
                alt110=4;
                }
                break;
            case 93:
                {
                alt110=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }

            switch (alt110) {
                case 1 :
                    // InternalCoreDsl.g:5313:3: this_PostfixExpression_0= rulePostfixExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrefixExpressionAccess().getPostfixExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PostfixExpression_0=rulePostfixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostfixExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:5322:3: ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) )
                    {
                    // InternalCoreDsl.g:5322:3: ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) )
                    // InternalCoreDsl.g:5323:4: ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) )
                    {
                    // InternalCoreDsl.g:5323:4: ( (lv_op_1_0= '++' ) )
                    // InternalCoreDsl.g:5324:5: (lv_op_1_0= '++' )
                    {
                    // InternalCoreDsl.g:5324:5: (lv_op_1_0= '++' )
                    // InternalCoreDsl.g:5325:6: lv_op_1_0= '++'
                    {
                    lv_op_1_0=(Token)match(input,91,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_1_0, grammarAccess.getPrefixExpressionAccess().getOpPlusSignPlusSignKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrefixExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_1_0, "++");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5337:4: ( (lv_left_2_0= rulePrefixExpression ) )
                    // InternalCoreDsl.g:5338:5: (lv_left_2_0= rulePrefixExpression )
                    {
                    // InternalCoreDsl.g:5338:5: (lv_left_2_0= rulePrefixExpression )
                    // InternalCoreDsl.g:5339:6: lv_left_2_0= rulePrefixExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixExpressionAccess().getLeftPrefixExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_left_2_0=rulePrefixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrefixExpressionRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_2_0,
                      							"com.minres.coredsl.CoreDsl.PrefixExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:5358:3: ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) )
                    {
                    // InternalCoreDsl.g:5358:3: ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) )
                    // InternalCoreDsl.g:5359:4: ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) )
                    {
                    // InternalCoreDsl.g:5359:4: ( (lv_op_3_0= '--' ) )
                    // InternalCoreDsl.g:5360:5: (lv_op_3_0= '--' )
                    {
                    // InternalCoreDsl.g:5360:5: (lv_op_3_0= '--' )
                    // InternalCoreDsl.g:5361:6: lv_op_3_0= '--'
                    {
                    lv_op_3_0=(Token)match(input,92,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_3_0, grammarAccess.getPrefixExpressionAccess().getOpHyphenMinusHyphenMinusKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrefixExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_3_0, "--");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5373:4: ( (lv_left_4_0= rulePrefixExpression ) )
                    // InternalCoreDsl.g:5374:5: (lv_left_4_0= rulePrefixExpression )
                    {
                    // InternalCoreDsl.g:5374:5: (lv_left_4_0= rulePrefixExpression )
                    // InternalCoreDsl.g:5375:6: lv_left_4_0= rulePrefixExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixExpressionAccess().getLeftPrefixExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_left_4_0=rulePrefixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrefixExpressionRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_4_0,
                      							"com.minres.coredsl.CoreDsl.PrefixExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:5394:3: (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) )
                    {
                    // InternalCoreDsl.g:5394:3: (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) )
                    // InternalCoreDsl.g:5395:4: this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getPrefixExpressionRule());
                      				}
                      				newCompositeNode(grammarAccess.getPrefixExpressionAccess().getUnaryOperatorParserRuleCall_3_0());
                      			
                    }
                    pushFollow(FOLLOW_45);
                    this_UnaryOperator_5=ruleUnaryOperator(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_UnaryOperator_5;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:5406:4: ( (lv_left_6_0= ruleCastExpression ) )
                    // InternalCoreDsl.g:5407:5: (lv_left_6_0= ruleCastExpression )
                    {
                    // InternalCoreDsl.g:5407:5: (lv_left_6_0= ruleCastExpression )
                    // InternalCoreDsl.g:5408:6: lv_left_6_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixExpressionAccess().getLeftCastExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_left_6_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrefixExpressionRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_6_0,
                      							"com.minres.coredsl.CoreDsl.CastExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:5427:3: ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' )
                    {
                    // InternalCoreDsl.g:5427:3: ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' )
                    // InternalCoreDsl.g:5428:4: ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')'
                    {
                    // InternalCoreDsl.g:5428:4: ( (lv_op_7_0= 'sizeof' ) )
                    // InternalCoreDsl.g:5429:5: (lv_op_7_0= 'sizeof' )
                    {
                    // InternalCoreDsl.g:5429:5: (lv_op_7_0= 'sizeof' )
                    // InternalCoreDsl.g:5430:6: lv_op_7_0= 'sizeof'
                    {
                    lv_op_7_0=(Token)match(input,93,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_7_0, grammarAccess.getPrefixExpressionAccess().getOpSizeofKeyword_4_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrefixExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_7_0, "sizeof");
                      					
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,46,FOLLOW_89); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getPrefixExpressionAccess().getLeftParenthesisKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:5446:4: ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) )
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( ((LA109_0>=RULE_STRING && LA109_0<=RULE_ID)||(LA109_0>=RULE_INTEGER && LA109_0<=RULE_CHARCONST)||LA109_0==46||(LA109_0>=97 && LA109_0<=100)) ) {
                        alt109=1;
                    }
                    else if ( (LA109_0==63||(LA109_0>=106 && LA109_0<=116)||(LA109_0>=126 && LA109_0<=127)) ) {
                        alt109=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 109, 0, input);

                        throw nvae;
                    }
                    switch (alt109) {
                        case 1 :
                            // InternalCoreDsl.g:5447:5: ( (lv_left_9_0= rulePostfixExpression ) )
                            {
                            // InternalCoreDsl.g:5447:5: ( (lv_left_9_0= rulePostfixExpression ) )
                            // InternalCoreDsl.g:5448:6: (lv_left_9_0= rulePostfixExpression )
                            {
                            // InternalCoreDsl.g:5448:6: (lv_left_9_0= rulePostfixExpression )
                            // InternalCoreDsl.g:5449:7: lv_left_9_0= rulePostfixExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPrefixExpressionAccess().getLeftPostfixExpressionParserRuleCall_4_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_42);
                            lv_left_9_0=rulePostfixExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getPrefixExpressionRule());
                              							}
                              							set(
                              								current,
                              								"left",
                              								lv_left_9_0,
                              								"com.minres.coredsl.CoreDsl.PostfixExpression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:5467:5: ( (lv_type_10_0= ruleDataTypeSpecifier ) )
                            {
                            // InternalCoreDsl.g:5467:5: ( (lv_type_10_0= ruleDataTypeSpecifier ) )
                            // InternalCoreDsl.g:5468:6: (lv_type_10_0= ruleDataTypeSpecifier )
                            {
                            // InternalCoreDsl.g:5468:6: (lv_type_10_0= ruleDataTypeSpecifier )
                            // InternalCoreDsl.g:5469:7: lv_type_10_0= ruleDataTypeSpecifier
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPrefixExpressionAccess().getTypeDataTypeSpecifierParserRuleCall_4_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_42);
                            lv_type_10_0=ruleDataTypeSpecifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getPrefixExpressionRule());
                              							}
                              							set(
                              								current,
                              								"type",
                              								lv_type_10_0,
                              								"com.minres.coredsl.CoreDsl.DataTypeSpecifier");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getPrefixExpressionAccess().getRightParenthesisKeyword_4_3());
                      			
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
    // $ANTLR end "rulePrefixExpression"


    // $ANTLR start "ruleUnaryOperator"
    // InternalCoreDsl.g:5497:1: ruleUnaryOperator[EObject in_current] returns [EObject current=in_current] : ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) ) ;
    public final EObject ruleUnaryOperator(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        Token lv_op_0_4=null;
        Token lv_op_0_5=null;
        Token lv_op_0_6=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:5503:2: ( ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) ) )
            // InternalCoreDsl.g:5504:2: ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) )
            {
            // InternalCoreDsl.g:5504:2: ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) )
            // InternalCoreDsl.g:5505:3: ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) )
            {
            // InternalCoreDsl.g:5505:3: ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) )
            // InternalCoreDsl.g:5506:4: (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' )
            {
            // InternalCoreDsl.g:5506:4: (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' )
            int alt111=6;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt111=1;
                }
                break;
            case 59:
                {
                alt111=2;
                }
                break;
            case 87:
                {
                alt111=3;
                }
                break;
            case 88:
                {
                alt111=4;
                }
                break;
            case 94:
                {
                alt111=5;
                }
                break;
            case 95:
                {
                alt111=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }

            switch (alt111) {
                case 1 :
                    // InternalCoreDsl.g:5507:5: lv_op_0_1= '&'
                    {
                    lv_op_0_1=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_op_0_1, grammarAccess.getUnaryOperatorAccess().getOpAmpersandKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      					}
                      					setWithLastConsumed(current, "op", lv_op_0_1, null);
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:5518:5: lv_op_0_2= '*'
                    {
                    lv_op_0_2=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_op_0_2, grammarAccess.getUnaryOperatorAccess().getOpAsteriskKeyword_0_1());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      					}
                      					setWithLastConsumed(current, "op", lv_op_0_2, null);
                      				
                    }

                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:5529:5: lv_op_0_3= '+'
                    {
                    lv_op_0_3=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_op_0_3, grammarAccess.getUnaryOperatorAccess().getOpPlusSignKeyword_0_2());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      					}
                      					setWithLastConsumed(current, "op", lv_op_0_3, null);
                      				
                    }

                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:5540:5: lv_op_0_4= '-'
                    {
                    lv_op_0_4=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_op_0_4, grammarAccess.getUnaryOperatorAccess().getOpHyphenMinusKeyword_0_3());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      					}
                      					setWithLastConsumed(current, "op", lv_op_0_4, null);
                      				
                    }

                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:5551:5: lv_op_0_5= '~'
                    {
                    lv_op_0_5=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_op_0_5, grammarAccess.getUnaryOperatorAccess().getOpTildeKeyword_0_4());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      					}
                      					setWithLastConsumed(current, "op", lv_op_0_5, null);
                      				
                    }

                    }
                    break;
                case 6 :
                    // InternalCoreDsl.g:5562:5: lv_op_0_6= '!'
                    {
                    lv_op_0_6=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_op_0_6, grammarAccess.getUnaryOperatorAccess().getOpExclamationMarkKeyword_0_5());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                      					}
                      					setWithLastConsumed(current, "op", lv_op_0_6, null);
                      				
                    }

                    }
                    break;

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
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRulePostfixExpression"
    // InternalCoreDsl.g:5578:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalCoreDsl.g:5578:58: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalCoreDsl.g:5579:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
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
    // $ANTLR end "entryRulePostfixExpression"


    // $ANTLR start "rulePostfixExpression"
    // InternalCoreDsl.g:5585:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject lv_ops_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5591:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* ) )
            // InternalCoreDsl.g:5592:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* )
            {
            // InternalCoreDsl.g:5592:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* )
            // InternalCoreDsl.g:5593:3: this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_90);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5601:3: ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )*
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( (LA112_0==43||LA112_0==46||LA112_0==65||(LA112_0>=91 && LA112_0<=92)||LA112_0==96) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // InternalCoreDsl.g:5602:4: () ( (lv_ops_2_0= rulePostfixOperator ) )
            	    {
            	    // InternalCoreDsl.g:5602:4: ()
            	    // InternalCoreDsl.g:5603:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getPostfixExpressionAccess().getPostfixExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:5609:4: ( (lv_ops_2_0= rulePostfixOperator ) )
            	    // InternalCoreDsl.g:5610:5: (lv_ops_2_0= rulePostfixOperator )
            	    {
            	    // InternalCoreDsl.g:5610:5: (lv_ops_2_0= rulePostfixOperator )
            	    // InternalCoreDsl.g:5611:6: lv_ops_2_0= rulePostfixOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPostfixExpressionAccess().getOpsPostfixOperatorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_90);
            	    lv_ops_2_0=rulePostfixOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"ops",
            	      							lv_ops_2_0,
            	      							"com.minres.coredsl.CoreDsl.PostfixOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop112;
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
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRulePostfixOperator"
    // InternalCoreDsl.g:5633:1: entryRulePostfixOperator returns [EObject current=null] : iv_rulePostfixOperator= rulePostfixOperator EOF ;
    public final EObject entryRulePostfixOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOperator = null;


        try {
            // InternalCoreDsl.g:5633:56: (iv_rulePostfixOperator= rulePostfixOperator EOF )
            // InternalCoreDsl.g:5634:2: iv_rulePostfixOperator= rulePostfixOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostfixOperator=rulePostfixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixOperator; 
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
    // $ANTLR end "entryRulePostfixOperator"


    // $ANTLR start "rulePostfixOperator"
    // InternalCoreDsl.g:5640:1: rulePostfixOperator returns [EObject current=null] : ( ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) ) ;
    public final EObject rulePostfixOperator() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_op_5_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_op_10_0=null;
        Token otherlv_11=null;
        Token lv_op_12_0=null;
        Token otherlv_13=null;
        Token lv_op_14_0=null;
        Token lv_op_15_0=null;
        EObject lv_args_1_0 = null;

        EObject lv_args_3_0 = null;

        EObject lv_args_6_0 = null;

        EObject lv_args_8_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5646:2: ( ( ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) ) )
            // InternalCoreDsl.g:5647:2: ( ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) )
            {
            // InternalCoreDsl.g:5647:2: ( ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) )
            int alt116=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt116=1;
                }
                break;
            case 46:
                {
                alt116=2;
                }
                break;
            case 65:
                {
                alt116=3;
                }
                break;
            case 96:
                {
                alt116=4;
                }
                break;
            case 91:
                {
                alt116=5;
                }
                break;
            case 92:
                {
                alt116=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }

            switch (alt116) {
                case 1 :
                    // InternalCoreDsl.g:5648:3: ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' )
                    {
                    // InternalCoreDsl.g:5648:3: ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' )
                    // InternalCoreDsl.g:5649:4: ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']'
                    {
                    // InternalCoreDsl.g:5649:4: ( (lv_op_0_0= '[' ) )
                    // InternalCoreDsl.g:5650:5: (lv_op_0_0= '[' )
                    {
                    // InternalCoreDsl.g:5650:5: (lv_op_0_0= '[' )
                    // InternalCoreDsl.g:5651:6: lv_op_0_0= '['
                    {
                    lv_op_0_0=(Token)match(input,43,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_0_0, grammarAccess.getPostfixOperatorAccess().getOpLeftSquareBracketKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPostfixOperatorRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_0_0, "[");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5663:4: ( (lv_args_1_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:5664:5: (lv_args_1_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:5664:5: (lv_args_1_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:5665:6: lv_args_1_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_91);
                    lv_args_1_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPostfixOperatorRule());
                      						}
                      						add(
                      							current,
                      							"args",
                      							lv_args_1_0,
                      							"com.minres.coredsl.CoreDsl.ConditionalExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5682:4: (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )?
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( (LA113_0==37) ) {
                        alt113=1;
                    }
                    switch (alt113) {
                        case 1 :
                            // InternalCoreDsl.g:5683:5: otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) )
                            {
                            otherlv_2=(Token)match(input,37,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getPostfixOperatorAccess().getColonKeyword_0_2_0());
                              				
                            }
                            // InternalCoreDsl.g:5687:5: ( (lv_args_3_0= ruleConditionalExpression ) )
                            // InternalCoreDsl.g:5688:6: (lv_args_3_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:5688:6: (lv_args_3_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:5689:7: lv_args_3_0= ruleConditionalExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_0_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_40);
                            lv_args_3_0=ruleConditionalExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getPostfixOperatorRule());
                              							}
                              							add(
                              								current,
                              								"args",
                              								lv_args_3_0,
                              								"com.minres.coredsl.CoreDsl.ConditionalExpression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPostfixOperatorAccess().getRightSquareBracketKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:5713:3: ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' )
                    {
                    // InternalCoreDsl.g:5713:3: ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' )
                    // InternalCoreDsl.g:5714:4: ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')'
                    {
                    // InternalCoreDsl.g:5714:4: ( (lv_op_5_0= '(' ) )
                    // InternalCoreDsl.g:5715:5: (lv_op_5_0= '(' )
                    {
                    // InternalCoreDsl.g:5715:5: (lv_op_5_0= '(' )
                    // InternalCoreDsl.g:5716:6: lv_op_5_0= '('
                    {
                    lv_op_5_0=(Token)match(input,46,FOLLOW_92); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_5_0, grammarAccess.getPostfixOperatorAccess().getOpLeftParenthesisKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPostfixOperatorRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_5_0, "(");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5728:4: ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )?
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( ((LA115_0>=RULE_STRING && LA115_0<=RULE_ID)||(LA115_0>=RULE_INTEGER && LA115_0<=RULE_CHARCONST)||LA115_0==46||LA115_0==59||LA115_0==80||(LA115_0>=87 && LA115_0<=88)||(LA115_0>=91 && LA115_0<=95)||(LA115_0>=97 && LA115_0<=100)) ) {
                        alt115=1;
                    }
                    switch (alt115) {
                        case 1 :
                            // InternalCoreDsl.g:5729:5: ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )*
                            {
                            // InternalCoreDsl.g:5729:5: ( (lv_args_6_0= ruleConditionalExpression ) )
                            // InternalCoreDsl.g:5730:6: (lv_args_6_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:5730:6: (lv_args_6_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:5731:7: lv_args_6_0= ruleConditionalExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_1_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_93);
                            lv_args_6_0=ruleConditionalExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getPostfixOperatorRule());
                              							}
                              							add(
                              								current,
                              								"args",
                              								lv_args_6_0,
                              								"com.minres.coredsl.CoreDsl.ConditionalExpression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalCoreDsl.g:5748:5: (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )*
                            loop114:
                            do {
                                int alt114=2;
                                int LA114_0 = input.LA(1);

                                if ( (LA114_0==33) ) {
                                    alt114=1;
                                }


                                switch (alt114) {
                            	case 1 :
                            	    // InternalCoreDsl.g:5749:6: otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) )
                            	    {
                            	    otherlv_7=(Token)match(input,33,FOLLOW_45); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_7, grammarAccess.getPostfixOperatorAccess().getCommaKeyword_1_1_1_0());
                            	      					
                            	    }
                            	    // InternalCoreDsl.g:5753:6: ( (lv_args_8_0= ruleConditionalExpression ) )
                            	    // InternalCoreDsl.g:5754:7: (lv_args_8_0= ruleConditionalExpression )
                            	    {
                            	    // InternalCoreDsl.g:5754:7: (lv_args_8_0= ruleConditionalExpression )
                            	    // InternalCoreDsl.g:5755:8: lv_args_8_0= ruleConditionalExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_1_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_93);
                            	    lv_args_8_0=ruleConditionalExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getPostfixOperatorRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"args",
                            	      									lv_args_8_0,
                            	      									"com.minres.coredsl.CoreDsl.ConditionalExpression");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop114;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPostfixOperatorAccess().getRightParenthesisKeyword_1_2());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:5780:3: ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:5780:3: ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) )
                    // InternalCoreDsl.g:5781:4: ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:5781:4: ( (lv_op_10_0= '.' ) )
                    // InternalCoreDsl.g:5782:5: (lv_op_10_0= '.' )
                    {
                    // InternalCoreDsl.g:5782:5: (lv_op_10_0= '.' )
                    // InternalCoreDsl.g:5783:6: lv_op_10_0= '.'
                    {
                    lv_op_10_0=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_10_0, grammarAccess.getPostfixOperatorAccess().getOpFullStopKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPostfixOperatorRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_10_0, ".");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5795:4: ( (otherlv_11= RULE_ID ) )
                    // InternalCoreDsl.g:5796:5: (otherlv_11= RULE_ID )
                    {
                    // InternalCoreDsl.g:5796:5: (otherlv_11= RULE_ID )
                    // InternalCoreDsl.g:5797:6: otherlv_11= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPostfixOperatorRule());
                      						}
                      					
                    }
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_11, grammarAccess.getPostfixOperatorAccess().getMemberDirectDeclaratorCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:5810:3: ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:5810:3: ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) )
                    // InternalCoreDsl.g:5811:4: ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:5811:4: ( (lv_op_12_0= '->' ) )
                    // InternalCoreDsl.g:5812:5: (lv_op_12_0= '->' )
                    {
                    // InternalCoreDsl.g:5812:5: (lv_op_12_0= '->' )
                    // InternalCoreDsl.g:5813:6: lv_op_12_0= '->'
                    {
                    lv_op_12_0=(Token)match(input,96,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_12_0, grammarAccess.getPostfixOperatorAccess().getOpHyphenMinusGreaterThanSignKeyword_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPostfixOperatorRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_12_0, "->");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5825:4: ( (otherlv_13= RULE_ID ) )
                    // InternalCoreDsl.g:5826:5: (otherlv_13= RULE_ID )
                    {
                    // InternalCoreDsl.g:5826:5: (otherlv_13= RULE_ID )
                    // InternalCoreDsl.g:5827:6: otherlv_13= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPostfixOperatorRule());
                      						}
                      					
                    }
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_13, grammarAccess.getPostfixOperatorAccess().getMemberDirectDeclaratorCrossReference_3_1_0());
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:5840:3: ( (lv_op_14_0= '++' ) )
                    {
                    // InternalCoreDsl.g:5840:3: ( (lv_op_14_0= '++' ) )
                    // InternalCoreDsl.g:5841:4: (lv_op_14_0= '++' )
                    {
                    // InternalCoreDsl.g:5841:4: (lv_op_14_0= '++' )
                    // InternalCoreDsl.g:5842:5: lv_op_14_0= '++'
                    {
                    lv_op_14_0=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_op_14_0, grammarAccess.getPostfixOperatorAccess().getOpPlusSignPlusSignKeyword_4_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPostfixOperatorRule());
                      					}
                      					setWithLastConsumed(current, "op", lv_op_14_0, "++");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalCoreDsl.g:5855:3: ( (lv_op_15_0= '--' ) )
                    {
                    // InternalCoreDsl.g:5855:3: ( (lv_op_15_0= '--' ) )
                    // InternalCoreDsl.g:5856:4: (lv_op_15_0= '--' )
                    {
                    // InternalCoreDsl.g:5856:4: (lv_op_15_0= '--' )
                    // InternalCoreDsl.g:5857:5: lv_op_15_0= '--'
                    {
                    lv_op_15_0=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_op_15_0, grammarAccess.getPostfixOperatorAccess().getOpHyphenMinusHyphenMinusKeyword_5_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPostfixOperatorRule());
                      					}
                      					setWithLastConsumed(current, "op", lv_op_15_0, "--");
                      				
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
    // $ANTLR end "rulePostfixOperator"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalCoreDsl.g:5873:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalCoreDsl.g:5873:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalCoreDsl.g:5874:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalCoreDsl.g:5880:1: rulePrimaryExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_constant_1_0 = null;

        EObject lv_literal_2_0 = null;

        EObject lv_left_4_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5886:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) ) )
            // InternalCoreDsl.g:5887:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) )
            {
            // InternalCoreDsl.g:5887:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) )
            int alt118=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt118=1;
                }
                break;
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
                {
                alt118=2;
                }
                break;
            case 100:
                {
                int LA118_3 = input.LA(2);

                if ( (LA118_3==RULE_CHARCONST) ) {
                    alt118=2;
                }
                else if ( (LA118_3==RULE_STRING) ) {
                    alt118=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 118, 3, input);

                    throw nvae;
                }
                }
                break;
            case 98:
                {
                int LA118_4 = input.LA(2);

                if ( (LA118_4==RULE_CHARCONST) ) {
                    alt118=2;
                }
                else if ( (LA118_4==RULE_STRING) ) {
                    alt118=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 118, 4, input);

                    throw nvae;
                }
                }
                break;
            case 99:
                {
                int LA118_5 = input.LA(2);

                if ( (LA118_5==RULE_STRING) ) {
                    alt118=3;
                }
                else if ( (LA118_5==RULE_CHARCONST) ) {
                    alt118=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 118, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case 97:
                {
                alt118=3;
                }
                break;
            case 46:
                {
                alt118=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }

            switch (alt118) {
                case 1 :
                    // InternalCoreDsl.g:5888:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:5888:3: ( (otherlv_0= RULE_ID ) )
                    // InternalCoreDsl.g:5889:4: (otherlv_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:5889:4: (otherlv_0= RULE_ID )
                    // InternalCoreDsl.g:5890:5: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      					}
                      				
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getRefVariableRefCrossReference_0_0());
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:5902:3: ( (lv_constant_1_0= ruleConstant ) )
                    {
                    // InternalCoreDsl.g:5902:3: ( (lv_constant_1_0= ruleConstant ) )
                    // InternalCoreDsl.g:5903:4: (lv_constant_1_0= ruleConstant )
                    {
                    // InternalCoreDsl.g:5903:4: (lv_constant_1_0= ruleConstant )
                    // InternalCoreDsl.g:5904:5: lv_constant_1_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstantConstantParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_constant_1_0=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      					}
                      					set(
                      						current,
                      						"constant",
                      						lv_constant_1_0,
                      						"com.minres.coredsl.CoreDsl.Constant");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:5922:3: ( (lv_literal_2_0= ruleStringLiteral ) )+
                    {
                    // InternalCoreDsl.g:5922:3: ( (lv_literal_2_0= ruleStringLiteral ) )+
                    int cnt117=0;
                    loop117:
                    do {
                        int alt117=2;
                        int LA117_0 = input.LA(1);

                        if ( (LA117_0==RULE_STRING||(LA117_0>=97 && LA117_0<=100)) ) {
                            alt117=1;
                        }


                        switch (alt117) {
                    	case 1 :
                    	    // InternalCoreDsl.g:5923:4: (lv_literal_2_0= ruleStringLiteral )
                    	    {
                    	    // InternalCoreDsl.g:5923:4: (lv_literal_2_0= ruleStringLiteral )
                    	    // InternalCoreDsl.g:5924:5: lv_literal_2_0= ruleStringLiteral
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralStringLiteralParserRuleCall_2_0());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_94);
                    	    lv_literal_2_0=ruleStringLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					if (current==null) {
                    	      						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    	      					}
                    	      					add(
                    	      						current,
                    	      						"literal",
                    	      						lv_literal_2_0,
                    	      						"com.minres.coredsl.CoreDsl.StringLiteral");
                    	      					afterParserOrEnumRuleCall();
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt117 >= 1 ) break loop117;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(117, input);
                                throw eee;
                        }
                        cnt117++;
                    } while (true);


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:5942:3: (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' )
                    {
                    // InternalCoreDsl.g:5942:3: (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' )
                    // InternalCoreDsl.g:5943:4: otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,46,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalCoreDsl.g:5947:4: ( (lv_left_4_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:5948:5: (lv_left_4_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:5948:5: (lv_left_4_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:5949:6: lv_left_4_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLeftConditionalExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_42);
                    lv_left_4_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_4_0,
                      							"com.minres.coredsl.CoreDsl.ConditionalExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2());
                      			
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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalCoreDsl.g:5975:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalCoreDsl.g:5975:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalCoreDsl.g:5976:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral; 
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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalCoreDsl.g:5982:1: ruleStringLiteral returns [EObject current=null] : ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;
        EObject this_EncodingPrefix_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5988:2: ( ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) ) )
            // InternalCoreDsl.g:5989:2: ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) )
            {
            // InternalCoreDsl.g:5989:2: ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) )
            // InternalCoreDsl.g:5990:3: (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) )
            {
            // InternalCoreDsl.g:5990:3: (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( ((LA119_0>=97 && LA119_0<=100)) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalCoreDsl.g:5991:4: this_EncodingPrefix_0= ruleEncodingPrefix[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getStringLiteralRule());
                      				}
                      				newCompositeNode(grammarAccess.getStringLiteralAccess().getEncodingPrefixParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_5);
                    this_EncodingPrefix_0=ruleEncodingPrefix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_EncodingPrefix_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:6003:3: ( (lv_val_1_0= RULE_STRING ) )
            // InternalCoreDsl.g:6004:4: (lv_val_1_0= RULE_STRING )
            {
            // InternalCoreDsl.g:6004:4: (lv_val_1_0= RULE_STRING )
            // InternalCoreDsl.g:6005:5: lv_val_1_0= RULE_STRING
            {
            lv_val_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_val_1_0, grammarAccess.getStringLiteralAccess().getValSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStringLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"val",
              						lv_val_1_0,
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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "ruleEncodingPrefix"
    // InternalCoreDsl.g:6026:1: ruleEncodingPrefix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) ) ;
    public final EObject ruleEncodingPrefix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_prefix_0_1=null;
        Token lv_prefix_0_2=null;
        Token lv_prefix_0_3=null;
        Token lv_prefix_0_4=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6032:2: ( ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) ) )
            // InternalCoreDsl.g:6033:2: ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) )
            {
            // InternalCoreDsl.g:6033:2: ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) )
            // InternalCoreDsl.g:6034:3: ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) )
            {
            // InternalCoreDsl.g:6034:3: ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) )
            // InternalCoreDsl.g:6035:4: (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' )
            {
            // InternalCoreDsl.g:6035:4: (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' )
            int alt120=4;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt120=1;
                }
                break;
            case 98:
                {
                alt120=2;
                }
                break;
            case 99:
                {
                alt120=3;
                }
                break;
            case 100:
                {
                alt120=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;
            }

            switch (alt120) {
                case 1 :
                    // InternalCoreDsl.g:6036:5: lv_prefix_0_1= 'u8'
                    {
                    lv_prefix_0_1=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_prefix_0_1, grammarAccess.getEncodingPrefixAccess().getPrefixU8Keyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEncodingPrefixRule());
                      					}
                      					setWithLastConsumed(current, "prefix", lv_prefix_0_1, null);
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6047:5: lv_prefix_0_2= 'u'
                    {
                    lv_prefix_0_2=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_prefix_0_2, grammarAccess.getEncodingPrefixAccess().getPrefixUKeyword_0_1());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEncodingPrefixRule());
                      					}
                      					setWithLastConsumed(current, "prefix", lv_prefix_0_2, null);
                      				
                    }

                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6058:5: lv_prefix_0_3= 'U'
                    {
                    lv_prefix_0_3=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_prefix_0_3, grammarAccess.getEncodingPrefixAccess().getPrefixUKeyword_0_2());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEncodingPrefixRule());
                      					}
                      					setWithLastConsumed(current, "prefix", lv_prefix_0_3, null);
                      				
                    }

                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6069:5: lv_prefix_0_4= 'L'
                    {
                    lv_prefix_0_4=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_prefix_0_4, grammarAccess.getEncodingPrefixAccess().getPrefixLKeyword_0_3());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEncodingPrefixRule());
                      					}
                      					setWithLastConsumed(current, "prefix", lv_prefix_0_4, null);
                      				
                    }

                    }
                    break;

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
    // $ANTLR end "ruleEncodingPrefix"


    // $ANTLR start "entryRuleConstantExpression"
    // InternalCoreDsl.g:6085:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalCoreDsl.g:6085:59: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalCoreDsl.g:6086:2: iv_ruleConstantExpression= ruleConstantExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantExpression=ruleConstantExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantExpression; 
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
    // $ANTLR end "entryRuleConstantExpression"


    // $ANTLR start "ruleConstantExpression"
    // InternalCoreDsl.g:6092:1: ruleConstantExpression returns [EObject current=null] : this_ConditionalExpression_0= ruleConditionalExpression ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6098:2: (this_ConditionalExpression_0= ruleConditionalExpression )
            // InternalCoreDsl.g:6099:2: this_ConditionalExpression_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getConstantExpressionAccess().getConditionalExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_ConditionalExpression_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_ConditionalExpression_0;
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
    // $ANTLR end "ruleConstantExpression"


    // $ANTLR start "entryRuleConstant"
    // InternalCoreDsl.g:6110:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalCoreDsl.g:6110:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalCoreDsl.g:6111:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalCoreDsl.g:6117:1: ruleConstant returns [EObject current=null] : (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerConstant_0 = null;

        EObject this_FloatingConstant_1 = null;

        EObject this_CharacterConstant_2 = null;

        EObject this_BoolConstant_3 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6123:2: ( (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant ) )
            // InternalCoreDsl.g:6124:2: (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant )
            {
            // InternalCoreDsl.g:6124:2: (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant )
            int alt121=4;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
                {
                alt121=1;
                }
                break;
            case RULE_FLOAT:
                {
                alt121=2;
                }
                break;
            case RULE_CHARCONST:
            case 98:
            case 99:
            case 100:
                {
                alt121=3;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt121=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // InternalCoreDsl.g:6125:3: this_IntegerConstant_0= ruleIntegerConstant
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantAccess().getIntegerConstantParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IntegerConstant_0=ruleIntegerConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntegerConstant_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6134:3: this_FloatingConstant_1= ruleFloatingConstant
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantAccess().getFloatingConstantParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FloatingConstant_1=ruleFloatingConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FloatingConstant_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6143:3: this_CharacterConstant_2= ruleCharacterConstant
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantAccess().getCharacterConstantParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CharacterConstant_2=ruleCharacterConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CharacterConstant_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6152:3: this_BoolConstant_3= ruleBoolConstant
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BoolConstant_3=ruleBoolConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BoolConstant_3;
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


    // $ANTLR start "entryRuleIntegerConstant"
    // InternalCoreDsl.g:6164:1: entryRuleIntegerConstant returns [EObject current=null] : iv_ruleIntegerConstant= ruleIntegerConstant EOF ;
    public final EObject entryRuleIntegerConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerConstant = null;


        try {
            // InternalCoreDsl.g:6164:56: (iv_ruleIntegerConstant= ruleIntegerConstant EOF )
            // InternalCoreDsl.g:6165:2: iv_ruleIntegerConstant= ruleIntegerConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerConstantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntegerConstant=ruleIntegerConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerConstant; 
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
    // $ANTLR end "entryRuleIntegerConstant"


    // $ANTLR start "ruleIntegerConstant"
    // InternalCoreDsl.g:6171:1: ruleIntegerConstant returns [EObject current=null] : ( ( (lv_val_0_0= RULE_INTEGER ) ) (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )? ) ;
    public final EObject ruleIntegerConstant() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        EObject this_IntegerSuffix_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6177:2: ( ( ( (lv_val_0_0= RULE_INTEGER ) ) (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )? ) )
            // InternalCoreDsl.g:6178:2: ( ( (lv_val_0_0= RULE_INTEGER ) ) (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )? )
            {
            // InternalCoreDsl.g:6178:2: ( ( (lv_val_0_0= RULE_INTEGER ) ) (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )? )
            // InternalCoreDsl.g:6179:3: ( (lv_val_0_0= RULE_INTEGER ) ) (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )?
            {
            // InternalCoreDsl.g:6179:3: ( (lv_val_0_0= RULE_INTEGER ) )
            // InternalCoreDsl.g:6180:4: (lv_val_0_0= RULE_INTEGER )
            {
            // InternalCoreDsl.g:6180:4: (lv_val_0_0= RULE_INTEGER )
            // InternalCoreDsl.g:6181:5: lv_val_0_0= RULE_INTEGER
            {
            lv_val_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_95); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_val_0_0, grammarAccess.getIntegerConstantAccess().getValINTEGERTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getIntegerConstantRule());
              					}
              					setWithLastConsumed(
              						current,
              						"val",
              						lv_val_0_0,
              						"com.minres.coredsl.CoreDsl.INTEGER");
              				
            }

            }


            }

            // InternalCoreDsl.g:6197:3: (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( ((LA122_0>=98 && LA122_0<=103)) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalCoreDsl.g:6198:4: this_IntegerSuffix_1= ruleIntegerSuffix[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIntegerConstantRule());
                      				}
                      				newCompositeNode(grammarAccess.getIntegerConstantAccess().getIntegerSuffixParserRuleCall_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_IntegerSuffix_1=ruleIntegerSuffix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_IntegerSuffix_1;
                      				afterParserOrEnumRuleCall();
                      			
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
    // $ANTLR end "ruleIntegerConstant"


    // $ANTLR start "entryRuleFloatingConstant"
    // InternalCoreDsl.g:6214:1: entryRuleFloatingConstant returns [EObject current=null] : iv_ruleFloatingConstant= ruleFloatingConstant EOF ;
    public final EObject entryRuleFloatingConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatingConstant = null;


        try {
            // InternalCoreDsl.g:6214:57: (iv_ruleFloatingConstant= ruleFloatingConstant EOF )
            // InternalCoreDsl.g:6215:2: iv_ruleFloatingConstant= ruleFloatingConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatingConstantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFloatingConstant=ruleFloatingConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloatingConstant; 
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
    // $ANTLR end "entryRuleFloatingConstant"


    // $ANTLR start "ruleFloatingConstant"
    // InternalCoreDsl.g:6221:1: ruleFloatingConstant returns [EObject current=null] : ( ( (lv_val_0_0= RULE_FLOAT ) ) (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )? ) ;
    public final EObject ruleFloatingConstant() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        EObject this_FloatingSuffix_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6227:2: ( ( ( (lv_val_0_0= RULE_FLOAT ) ) (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )? ) )
            // InternalCoreDsl.g:6228:2: ( ( (lv_val_0_0= RULE_FLOAT ) ) (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )? )
            {
            // InternalCoreDsl.g:6228:2: ( ( (lv_val_0_0= RULE_FLOAT ) ) (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )? )
            // InternalCoreDsl.g:6229:3: ( (lv_val_0_0= RULE_FLOAT ) ) (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )?
            {
            // InternalCoreDsl.g:6229:3: ( (lv_val_0_0= RULE_FLOAT ) )
            // InternalCoreDsl.g:6230:4: (lv_val_0_0= RULE_FLOAT )
            {
            // InternalCoreDsl.g:6230:4: (lv_val_0_0= RULE_FLOAT )
            // InternalCoreDsl.g:6231:5: lv_val_0_0= RULE_FLOAT
            {
            lv_val_0_0=(Token)match(input,RULE_FLOAT,FOLLOW_96); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_val_0_0, grammarAccess.getFloatingConstantAccess().getValFLOATTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFloatingConstantRule());
              					}
              					setWithLastConsumed(
              						current,
              						"val",
              						lv_val_0_0,
              						"com.minres.coredsl.CoreDsl.FLOAT");
              				
            }

            }


            }

            // InternalCoreDsl.g:6247:3: (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( ((LA123_0>=100 && LA123_0<=101)||(LA123_0>=104 && LA123_0<=105)) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalCoreDsl.g:6248:4: this_FloatingSuffix_1= ruleFloatingSuffix[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getFloatingConstantRule());
                      				}
                      				newCompositeNode(grammarAccess.getFloatingConstantAccess().getFloatingSuffixParserRuleCall_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_FloatingSuffix_1=ruleFloatingSuffix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_FloatingSuffix_1;
                      				afterParserOrEnumRuleCall();
                      			
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
    // $ANTLR end "ruleFloatingConstant"


    // $ANTLR start "entryRuleBoolConstant"
    // InternalCoreDsl.g:6264:1: entryRuleBoolConstant returns [EObject current=null] : iv_ruleBoolConstant= ruleBoolConstant EOF ;
    public final EObject entryRuleBoolConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolConstant = null;


        try {
            // InternalCoreDsl.g:6264:53: (iv_ruleBoolConstant= ruleBoolConstant EOF )
            // InternalCoreDsl.g:6265:2: iv_ruleBoolConstant= ruleBoolConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolConstantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBoolConstant=ruleBoolConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolConstant; 
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
    // $ANTLR end "entryRuleBoolConstant"


    // $ANTLR start "ruleBoolConstant"
    // InternalCoreDsl.g:6271:1: ruleBoolConstant returns [EObject current=null] : ( (lv_val_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBoolConstant() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6277:2: ( ( (lv_val_0_0= RULE_BOOLEAN ) ) )
            // InternalCoreDsl.g:6278:2: ( (lv_val_0_0= RULE_BOOLEAN ) )
            {
            // InternalCoreDsl.g:6278:2: ( (lv_val_0_0= RULE_BOOLEAN ) )
            // InternalCoreDsl.g:6279:3: (lv_val_0_0= RULE_BOOLEAN )
            {
            // InternalCoreDsl.g:6279:3: (lv_val_0_0= RULE_BOOLEAN )
            // InternalCoreDsl.g:6280:4: lv_val_0_0= RULE_BOOLEAN
            {
            lv_val_0_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_val_0_0, grammarAccess.getBoolConstantAccess().getValBOOLEANTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getBoolConstantRule());
              				}
              				setWithLastConsumed(
              					current,
              					"val",
              					lv_val_0_0,
              					"com.minres.coredsl.CoreDsl.BOOLEAN");
              			
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
    // $ANTLR end "ruleBoolConstant"


    // $ANTLR start "ruleIntegerSuffix"
    // InternalCoreDsl.g:6300:1: ruleIntegerSuffix[EObject in_current] returns [EObject current=in_current] : ( (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? ) | (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] ) | (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? ) | (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? ) ) ;
    public final EObject ruleIntegerSuffix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        EObject this_UnsignedSuffix_0 = null;

        EObject this_LongSuffix_1 = null;

        EObject this_UnsignedSuffix_2 = null;

        EObject this_LongLongSuffix_3 = null;

        EObject this_LongSuffix_4 = null;

        EObject this_UnsignedSuffix_5 = null;

        EObject this_LongLongSuffix_6 = null;

        EObject this_UnsignedSuffix_7 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6306:2: ( ( (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? ) | (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] ) | (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? ) | (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? ) ) )
            // InternalCoreDsl.g:6307:2: ( (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? ) | (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] ) | (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? ) | (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? ) )
            {
            // InternalCoreDsl.g:6307:2: ( (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? ) | (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] ) | (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? ) | (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? ) )
            int alt127=4;
            switch ( input.LA(1) ) {
            case 98:
                {
                int LA127_1 = input.LA(2);

                if ( (LA127_1==EOF||LA127_1==26||LA127_1==33||(LA127_1>=37 && LA127_1<=38)||LA127_1==41||(LA127_1>=43 && LA127_1<=44)||(LA127_1>=46 && LA127_1<=47)||LA127_1==59||(LA127_1>=61 && LA127_1<=62)||(LA127_1>=64 && LA127_1<=92)||LA127_1==96||(LA127_1>=100 && LA127_1<=101)) ) {
                    alt127=1;
                }
                else if ( ((LA127_1>=102 && LA127_1<=103)) ) {
                    alt127=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 127, 1, input);

                    throw nvae;
                }
                }
                break;
            case 99:
                {
                int LA127_2 = input.LA(2);

                if ( (LA127_2==EOF||LA127_2==26||LA127_2==33||(LA127_2>=37 && LA127_2<=38)||LA127_2==41||(LA127_2>=43 && LA127_2<=44)||(LA127_2>=46 && LA127_2<=47)||LA127_2==59||(LA127_2>=61 && LA127_2<=62)||(LA127_2>=64 && LA127_2<=92)||LA127_2==96||(LA127_2>=100 && LA127_2<=101)) ) {
                    alt127=1;
                }
                else if ( ((LA127_2>=102 && LA127_2<=103)) ) {
                    alt127=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 127, 2, input);

                    throw nvae;
                }
                }
                break;
            case 100:
            case 101:
                {
                alt127=3;
                }
                break;
            case 102:
            case 103:
                {
                alt127=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }

            switch (alt127) {
                case 1 :
                    // InternalCoreDsl.g:6308:3: (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? )
                    {
                    // InternalCoreDsl.g:6308:3: (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? )
                    // InternalCoreDsl.g:6309:4: this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )?
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIntegerSuffixRule());
                      				}
                      				newCompositeNode(grammarAccess.getIntegerSuffixAccess().getUnsignedSuffixParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_97);
                    this_UnsignedSuffix_0=ruleUnsignedSuffix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_UnsignedSuffix_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:6320:4: (this_LongSuffix_1= ruleLongSuffix[$current] )?
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( ((LA124_0>=100 && LA124_0<=101)) ) {
                        alt124=1;
                    }
                    switch (alt124) {
                        case 1 :
                            // InternalCoreDsl.g:6321:5: this_LongSuffix_1= ruleLongSuffix[$current]
                            {
                            if ( state.backtracking==0 ) {

                              					if (current==null) {
                              						current = createModelElement(grammarAccess.getIntegerSuffixRule());
                              					}
                              					newCompositeNode(grammarAccess.getIntegerSuffixAccess().getLongSuffixParserRuleCall_0_1());
                              				
                            }
                            pushFollow(FOLLOW_2);
                            this_LongSuffix_1=ruleLongSuffix(current);

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current = this_LongSuffix_1;
                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6335:3: (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] )
                    {
                    // InternalCoreDsl.g:6335:3: (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] )
                    // InternalCoreDsl.g:6336:4: this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIntegerSuffixRule());
                      				}
                      				newCompositeNode(grammarAccess.getIntegerSuffixAccess().getUnsignedSuffixParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_98);
                    this_UnsignedSuffix_2=ruleUnsignedSuffix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_UnsignedSuffix_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIntegerSuffixRule());
                      				}
                      				newCompositeNode(grammarAccess.getIntegerSuffixAccess().getLongLongSuffixParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_LongLongSuffix_3=ruleLongLongSuffix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LongLongSuffix_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6360:3: (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? )
                    {
                    // InternalCoreDsl.g:6360:3: (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? )
                    // InternalCoreDsl.g:6361:4: this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )?
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIntegerSuffixRule());
                      				}
                      				newCompositeNode(grammarAccess.getIntegerSuffixAccess().getLongSuffixParserRuleCall_2_0());
                      			
                    }
                    pushFollow(FOLLOW_99);
                    this_LongSuffix_4=ruleLongSuffix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LongSuffix_4;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:6372:4: (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )?
                    int alt125=2;
                    int LA125_0 = input.LA(1);

                    if ( ((LA125_0>=98 && LA125_0<=99)) ) {
                        alt125=1;
                    }
                    switch (alt125) {
                        case 1 :
                            // InternalCoreDsl.g:6373:5: this_UnsignedSuffix_5= ruleUnsignedSuffix[$current]
                            {
                            if ( state.backtracking==0 ) {

                              					if (current==null) {
                              						current = createModelElement(grammarAccess.getIntegerSuffixRule());
                              					}
                              					newCompositeNode(grammarAccess.getIntegerSuffixAccess().getUnsignedSuffixParserRuleCall_2_1());
                              				
                            }
                            pushFollow(FOLLOW_2);
                            this_UnsignedSuffix_5=ruleUnsignedSuffix(current);

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current = this_UnsignedSuffix_5;
                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6387:3: (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? )
                    {
                    // InternalCoreDsl.g:6387:3: (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? )
                    // InternalCoreDsl.g:6388:4: this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )?
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIntegerSuffixRule());
                      				}
                      				newCompositeNode(grammarAccess.getIntegerSuffixAccess().getLongLongSuffixParserRuleCall_3_0());
                      			
                    }
                    pushFollow(FOLLOW_99);
                    this_LongLongSuffix_6=ruleLongLongSuffix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LongLongSuffix_6;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:6399:4: (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )?
                    int alt126=2;
                    int LA126_0 = input.LA(1);

                    if ( ((LA126_0>=98 && LA126_0<=99)) ) {
                        alt126=1;
                    }
                    switch (alt126) {
                        case 1 :
                            // InternalCoreDsl.g:6400:5: this_UnsignedSuffix_7= ruleUnsignedSuffix[$current]
                            {
                            if ( state.backtracking==0 ) {

                              					if (current==null) {
                              						current = createModelElement(grammarAccess.getIntegerSuffixRule());
                              					}
                              					newCompositeNode(grammarAccess.getIntegerSuffixAccess().getUnsignedSuffixParserRuleCall_3_1());
                              				
                            }
                            pushFollow(FOLLOW_2);
                            this_UnsignedSuffix_7=ruleUnsignedSuffix(current);

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current = this_UnsignedSuffix_7;
                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

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
    // $ANTLR end "ruleIntegerSuffix"


    // $ANTLR start "ruleUnsignedSuffix"
    // InternalCoreDsl.g:6418:1: ruleUnsignedSuffix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) ) ) ;
    public final EObject ruleUnsignedSuffix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_unsigned_0_1=null;
        Token lv_unsigned_0_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6424:2: ( ( ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) ) ) )
            // InternalCoreDsl.g:6425:2: ( ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) ) )
            {
            // InternalCoreDsl.g:6425:2: ( ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) ) )
            // InternalCoreDsl.g:6426:3: ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) )
            {
            // InternalCoreDsl.g:6426:3: ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) )
            // InternalCoreDsl.g:6427:4: (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' )
            {
            // InternalCoreDsl.g:6427:4: (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' )
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==98) ) {
                alt128=1;
            }
            else if ( (LA128_0==99) ) {
                alt128=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }
            switch (alt128) {
                case 1 :
                    // InternalCoreDsl.g:6428:5: lv_unsigned_0_1= 'u'
                    {
                    lv_unsigned_0_1=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_unsigned_0_1, grammarAccess.getUnsignedSuffixAccess().getUnsignedUKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnsignedSuffixRule());
                      					}
                      					setWithLastConsumed(current, "unsigned", lv_unsigned_0_1 != null, null);
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6439:5: lv_unsigned_0_2= 'U'
                    {
                    lv_unsigned_0_2=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_unsigned_0_2, grammarAccess.getUnsignedSuffixAccess().getUnsignedUKeyword_0_1());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnsignedSuffixRule());
                      					}
                      					setWithLastConsumed(current, "unsigned", lv_unsigned_0_2 != null, null);
                      				
                    }

                    }
                    break;

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
    // $ANTLR end "ruleUnsignedSuffix"


    // $ANTLR start "ruleLongSuffix"
    // InternalCoreDsl.g:6456:1: ruleLongSuffix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) ) ) ;
    public final EObject ruleLongSuffix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_long_0_1=null;
        Token lv_long_0_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6462:2: ( ( ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) ) ) )
            // InternalCoreDsl.g:6463:2: ( ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) ) )
            {
            // InternalCoreDsl.g:6463:2: ( ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) ) )
            // InternalCoreDsl.g:6464:3: ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) )
            {
            // InternalCoreDsl.g:6464:3: ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) )
            // InternalCoreDsl.g:6465:4: (lv_long_0_1= 'l' | lv_long_0_2= 'L' )
            {
            // InternalCoreDsl.g:6465:4: (lv_long_0_1= 'l' | lv_long_0_2= 'L' )
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==101) ) {
                alt129=1;
            }
            else if ( (LA129_0==100) ) {
                alt129=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }
            switch (alt129) {
                case 1 :
                    // InternalCoreDsl.g:6466:5: lv_long_0_1= 'l'
                    {
                    lv_long_0_1=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_long_0_1, grammarAccess.getLongSuffixAccess().getLongLKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getLongSuffixRule());
                      					}
                      					setWithLastConsumed(current, "long", lv_long_0_1 != null, null);
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6477:5: lv_long_0_2= 'L'
                    {
                    lv_long_0_2=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_long_0_2, grammarAccess.getLongSuffixAccess().getLongLKeyword_0_1());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getLongSuffixRule());
                      					}
                      					setWithLastConsumed(current, "long", lv_long_0_2 != null, null);
                      				
                    }

                    }
                    break;

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
    // $ANTLR end "ruleLongSuffix"


    // $ANTLR start "ruleLongLongSuffix"
    // InternalCoreDsl.g:6494:1: ruleLongLongSuffix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) ) ) ;
    public final EObject ruleLongLongSuffix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_longlong_0_1=null;
        Token lv_longlong_0_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6500:2: ( ( ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) ) ) )
            // InternalCoreDsl.g:6501:2: ( ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) ) )
            {
            // InternalCoreDsl.g:6501:2: ( ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) ) )
            // InternalCoreDsl.g:6502:3: ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) )
            {
            // InternalCoreDsl.g:6502:3: ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) )
            // InternalCoreDsl.g:6503:4: (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' )
            {
            // InternalCoreDsl.g:6503:4: (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==102) ) {
                alt130=1;
            }
            else if ( (LA130_0==103) ) {
                alt130=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }
            switch (alt130) {
                case 1 :
                    // InternalCoreDsl.g:6504:5: lv_longlong_0_1= 'll'
                    {
                    lv_longlong_0_1=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_longlong_0_1, grammarAccess.getLongLongSuffixAccess().getLonglongLlKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getLongLongSuffixRule());
                      					}
                      					setWithLastConsumed(current, "longlong", lv_longlong_0_1 != null, null);
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6515:5: lv_longlong_0_2= 'LL'
                    {
                    lv_longlong_0_2=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_longlong_0_2, grammarAccess.getLongLongSuffixAccess().getLonglongLLKeyword_0_1());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getLongLongSuffixRule());
                      					}
                      					setWithLastConsumed(current, "longlong", lv_longlong_0_2 != null, null);
                      				
                    }

                    }
                    break;

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
    // $ANTLR end "ruleLongLongSuffix"


    // $ANTLR start "ruleFloatingSuffix"
    // InternalCoreDsl.g:6532:1: ruleFloatingSuffix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_f_0_0= 'f' ) ) | ( (lv_l_1_0= 'l' ) ) | ( (lv_f_2_0= 'F' ) ) | ( (lv_f_3_0= 'L' ) ) ) ;
    public final EObject ruleFloatingSuffix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_f_0_0=null;
        Token lv_l_1_0=null;
        Token lv_f_2_0=null;
        Token lv_f_3_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6538:2: ( ( ( (lv_f_0_0= 'f' ) ) | ( (lv_l_1_0= 'l' ) ) | ( (lv_f_2_0= 'F' ) ) | ( (lv_f_3_0= 'L' ) ) ) )
            // InternalCoreDsl.g:6539:2: ( ( (lv_f_0_0= 'f' ) ) | ( (lv_l_1_0= 'l' ) ) | ( (lv_f_2_0= 'F' ) ) | ( (lv_f_3_0= 'L' ) ) )
            {
            // InternalCoreDsl.g:6539:2: ( ( (lv_f_0_0= 'f' ) ) | ( (lv_l_1_0= 'l' ) ) | ( (lv_f_2_0= 'F' ) ) | ( (lv_f_3_0= 'L' ) ) )
            int alt131=4;
            switch ( input.LA(1) ) {
            case 104:
                {
                alt131=1;
                }
                break;
            case 101:
                {
                alt131=2;
                }
                break;
            case 105:
                {
                alt131=3;
                }
                break;
            case 100:
                {
                alt131=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }

            switch (alt131) {
                case 1 :
                    // InternalCoreDsl.g:6540:3: ( (lv_f_0_0= 'f' ) )
                    {
                    // InternalCoreDsl.g:6540:3: ( (lv_f_0_0= 'f' ) )
                    // InternalCoreDsl.g:6541:4: (lv_f_0_0= 'f' )
                    {
                    // InternalCoreDsl.g:6541:4: (lv_f_0_0= 'f' )
                    // InternalCoreDsl.g:6542:5: lv_f_0_0= 'f'
                    {
                    lv_f_0_0=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_f_0_0, grammarAccess.getFloatingSuffixAccess().getFFKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFloatingSuffixRule());
                      					}
                      					setWithLastConsumed(current, "f", lv_f_0_0 != null, "f");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6555:3: ( (lv_l_1_0= 'l' ) )
                    {
                    // InternalCoreDsl.g:6555:3: ( (lv_l_1_0= 'l' ) )
                    // InternalCoreDsl.g:6556:4: (lv_l_1_0= 'l' )
                    {
                    // InternalCoreDsl.g:6556:4: (lv_l_1_0= 'l' )
                    // InternalCoreDsl.g:6557:5: lv_l_1_0= 'l'
                    {
                    lv_l_1_0=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_l_1_0, grammarAccess.getFloatingSuffixAccess().getLLKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFloatingSuffixRule());
                      					}
                      					setWithLastConsumed(current, "l", lv_l_1_0 != null, "l");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6570:3: ( (lv_f_2_0= 'F' ) )
                    {
                    // InternalCoreDsl.g:6570:3: ( (lv_f_2_0= 'F' ) )
                    // InternalCoreDsl.g:6571:4: (lv_f_2_0= 'F' )
                    {
                    // InternalCoreDsl.g:6571:4: (lv_f_2_0= 'F' )
                    // InternalCoreDsl.g:6572:5: lv_f_2_0= 'F'
                    {
                    lv_f_2_0=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_f_2_0, grammarAccess.getFloatingSuffixAccess().getFFKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFloatingSuffixRule());
                      					}
                      					setWithLastConsumed(current, "f", lv_f_2_0 != null, "F");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6585:3: ( (lv_f_3_0= 'L' ) )
                    {
                    // InternalCoreDsl.g:6585:3: ( (lv_f_3_0= 'L' ) )
                    // InternalCoreDsl.g:6586:4: (lv_f_3_0= 'L' )
                    {
                    // InternalCoreDsl.g:6586:4: (lv_f_3_0= 'L' )
                    // InternalCoreDsl.g:6587:5: lv_f_3_0= 'L'
                    {
                    lv_f_3_0=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_f_3_0, grammarAccess.getFloatingSuffixAccess().getFLKeyword_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFloatingSuffixRule());
                      					}
                      					setWithLastConsumed(current, "f", lv_f_3_0 != null, "L");
                      				
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
    // $ANTLR end "ruleFloatingSuffix"


    // $ANTLR start "entryRuleCharacterConstant"
    // InternalCoreDsl.g:6603:1: entryRuleCharacterConstant returns [EObject current=null] : iv_ruleCharacterConstant= ruleCharacterConstant EOF ;
    public final EObject entryRuleCharacterConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterConstant = null;


        try {
            // InternalCoreDsl.g:6603:58: (iv_ruleCharacterConstant= ruleCharacterConstant EOF )
            // InternalCoreDsl.g:6604:2: iv_ruleCharacterConstant= ruleCharacterConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCharacterConstantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCharacterConstant=ruleCharacterConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCharacterConstant; 
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
    // $ANTLR end "entryRuleCharacterConstant"


    // $ANTLR start "ruleCharacterConstant"
    // InternalCoreDsl.g:6610:1: ruleCharacterConstant returns [EObject current=null] : ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) ) ;
    public final EObject ruleCharacterConstant() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        Token lv_enc_1_0=null;
        Token lv_val_2_0=null;
        Token lv_enc_3_0=null;
        Token lv_val_4_0=null;
        Token lv_enc_5_0=null;
        Token lv_val_6_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6616:2: ( ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) ) )
            // InternalCoreDsl.g:6617:2: ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) )
            {
            // InternalCoreDsl.g:6617:2: ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) )
            int alt132=4;
            switch ( input.LA(1) ) {
            case RULE_CHARCONST:
                {
                alt132=1;
                }
                break;
            case 100:
                {
                alt132=2;
                }
                break;
            case 98:
                {
                alt132=3;
                }
                break;
            case 99:
                {
                alt132=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }

            switch (alt132) {
                case 1 :
                    // InternalCoreDsl.g:6618:3: ( (lv_val_0_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6618:3: ( (lv_val_0_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6619:4: (lv_val_0_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6619:4: (lv_val_0_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6620:5: lv_val_0_0= RULE_CHARCONST
                    {
                    lv_val_0_0=(Token)match(input,RULE_CHARCONST,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_val_0_0, grammarAccess.getCharacterConstantAccess().getValCHARCONSTTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getCharacterConstantRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"val",
                      						lv_val_0_0,
                      						"com.minres.coredsl.CoreDsl.CHARCONST");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6637:3: ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6637:3: ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6638:4: ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6638:4: ( (lv_enc_1_0= 'L' ) )
                    // InternalCoreDsl.g:6639:5: (lv_enc_1_0= 'L' )
                    {
                    // InternalCoreDsl.g:6639:5: (lv_enc_1_0= 'L' )
                    // InternalCoreDsl.g:6640:6: lv_enc_1_0= 'L'
                    {
                    lv_enc_1_0=(Token)match(input,100,FOLLOW_100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_enc_1_0, grammarAccess.getCharacterConstantAccess().getEncLKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCharacterConstantRule());
                      						}
                      						setWithLastConsumed(current, "enc", lv_enc_1_0, "L");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:6652:4: ( (lv_val_2_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6653:5: (lv_val_2_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6653:5: (lv_val_2_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6654:6: lv_val_2_0= RULE_CHARCONST
                    {
                    lv_val_2_0=(Token)match(input,RULE_CHARCONST,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_val_2_0, grammarAccess.getCharacterConstantAccess().getValCHARCONSTTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCharacterConstantRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"val",
                      							lv_val_2_0,
                      							"com.minres.coredsl.CoreDsl.CHARCONST");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6672:3: ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6672:3: ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6673:4: ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6673:4: ( (lv_enc_3_0= 'u' ) )
                    // InternalCoreDsl.g:6674:5: (lv_enc_3_0= 'u' )
                    {
                    // InternalCoreDsl.g:6674:5: (lv_enc_3_0= 'u' )
                    // InternalCoreDsl.g:6675:6: lv_enc_3_0= 'u'
                    {
                    lv_enc_3_0=(Token)match(input,98,FOLLOW_100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_enc_3_0, grammarAccess.getCharacterConstantAccess().getEncUKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCharacterConstantRule());
                      						}
                      						setWithLastConsumed(current, "enc", lv_enc_3_0, "u");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:6687:4: ( (lv_val_4_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6688:5: (lv_val_4_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6688:5: (lv_val_4_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6689:6: lv_val_4_0= RULE_CHARCONST
                    {
                    lv_val_4_0=(Token)match(input,RULE_CHARCONST,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_val_4_0, grammarAccess.getCharacterConstantAccess().getValCHARCONSTTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCharacterConstantRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"val",
                      							lv_val_4_0,
                      							"com.minres.coredsl.CoreDsl.CHARCONST");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6707:3: ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6707:3: ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6708:4: ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6708:4: ( (lv_enc_5_0= 'U' ) )
                    // InternalCoreDsl.g:6709:5: (lv_enc_5_0= 'U' )
                    {
                    // InternalCoreDsl.g:6709:5: (lv_enc_5_0= 'U' )
                    // InternalCoreDsl.g:6710:6: lv_enc_5_0= 'U'
                    {
                    lv_enc_5_0=(Token)match(input,99,FOLLOW_100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_enc_5_0, grammarAccess.getCharacterConstantAccess().getEncUKeyword_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCharacterConstantRule());
                      						}
                      						setWithLastConsumed(current, "enc", lv_enc_5_0, "U");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:6722:4: ( (lv_val_6_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6723:5: (lv_val_6_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6723:5: (lv_val_6_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6724:6: lv_val_6_0= RULE_CHARCONST
                    {
                    lv_val_6_0=(Token)match(input,RULE_CHARCONST,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_val_6_0, grammarAccess.getCharacterConstantAccess().getValCHARCONSTTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCharacterConstantRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"val",
                      							lv_val_6_0,
                      							"com.minres.coredsl.CoreDsl.CHARCONST");
                      					
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
    // $ANTLR end "ruleCharacterConstant"


    // $ANTLR start "ruleDataTypes"
    // InternalCoreDsl.g:6745:1: ruleDataTypes returns [Enumerator current=null] : ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'frac' ) | (enumLiteral_10= 'accum' ) ) ;
    public final Enumerator ruleDataTypes() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6751:2: ( ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'frac' ) | (enumLiteral_10= 'accum' ) ) )
            // InternalCoreDsl.g:6752:2: ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'frac' ) | (enumLiteral_10= 'accum' ) )
            {
            // InternalCoreDsl.g:6752:2: ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'frac' ) | (enumLiteral_10= 'accum' ) )
            int alt133=11;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt133=1;
                }
                break;
            case 107:
                {
                alt133=2;
                }
                break;
            case 108:
                {
                alt133=3;
                }
                break;
            case 109:
                {
                alt133=4;
                }
                break;
            case 110:
                {
                alt133=5;
                }
                break;
            case 111:
                {
                alt133=6;
                }
                break;
            case 112:
                {
                alt133=7;
                }
                break;
            case 113:
                {
                alt133=8;
                }
                break;
            case 114:
                {
                alt133=9;
                }
                break;
            case 115:
                {
                alt133=10;
                }
                break;
            case 116:
                {
                alt133=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }

            switch (alt133) {
                case 1 :
                    // InternalCoreDsl.g:6753:3: (enumLiteral_0= 'bool' )
                    {
                    // InternalCoreDsl.g:6753:3: (enumLiteral_0= 'bool' )
                    // InternalCoreDsl.g:6754:4: enumLiteral_0= 'bool'
                    {
                    enumLiteral_0=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getDataTypesAccess().getBOOLEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6761:3: (enumLiteral_1= 'char' )
                    {
                    // InternalCoreDsl.g:6761:3: (enumLiteral_1= 'char' )
                    // InternalCoreDsl.g:6762:4: enumLiteral_1= 'char'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getCHAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getDataTypesAccess().getCHAREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6769:3: (enumLiteral_2= 'short' )
                    {
                    // InternalCoreDsl.g:6769:3: (enumLiteral_2= 'short' )
                    // InternalCoreDsl.g:6770:4: enumLiteral_2= 'short'
                    {
                    enumLiteral_2=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getSHORTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getDataTypesAccess().getSHORTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6777:3: (enumLiteral_3= 'int' )
                    {
                    // InternalCoreDsl.g:6777:3: (enumLiteral_3= 'int' )
                    // InternalCoreDsl.g:6778:4: enumLiteral_3= 'int'
                    {
                    enumLiteral_3=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getINTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getDataTypesAccess().getINTEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:6785:3: (enumLiteral_4= 'long' )
                    {
                    // InternalCoreDsl.g:6785:3: (enumLiteral_4= 'long' )
                    // InternalCoreDsl.g:6786:4: enumLiteral_4= 'long'
                    {
                    enumLiteral_4=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getLONGEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getDataTypesAccess().getLONGEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalCoreDsl.g:6793:3: (enumLiteral_5= 'signed' )
                    {
                    // InternalCoreDsl.g:6793:3: (enumLiteral_5= 'signed' )
                    // InternalCoreDsl.g:6794:4: enumLiteral_5= 'signed'
                    {
                    enumLiteral_5=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getSIGNEDEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getDataTypesAccess().getSIGNEDEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalCoreDsl.g:6801:3: (enumLiteral_6= 'unsigned' )
                    {
                    // InternalCoreDsl.g:6801:3: (enumLiteral_6= 'unsigned' )
                    // InternalCoreDsl.g:6802:4: enumLiteral_6= 'unsigned'
                    {
                    enumLiteral_6=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getUNSIGNEDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getDataTypesAccess().getUNSIGNEDEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalCoreDsl.g:6809:3: (enumLiteral_7= 'float' )
                    {
                    // InternalCoreDsl.g:6809:3: (enumLiteral_7= 'float' )
                    // InternalCoreDsl.g:6810:4: enumLiteral_7= 'float'
                    {
                    enumLiteral_7=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getFLOATEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getDataTypesAccess().getFLOATEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalCoreDsl.g:6817:3: (enumLiteral_8= 'double' )
                    {
                    // InternalCoreDsl.g:6817:3: (enumLiteral_8= 'double' )
                    // InternalCoreDsl.g:6818:4: enumLiteral_8= 'double'
                    {
                    enumLiteral_8=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getDOUBLEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getDataTypesAccess().getDOUBLEEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalCoreDsl.g:6825:3: (enumLiteral_9= 'frac' )
                    {
                    // InternalCoreDsl.g:6825:3: (enumLiteral_9= 'frac' )
                    // InternalCoreDsl.g:6826:4: enumLiteral_9= 'frac'
                    {
                    enumLiteral_9=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getFRACEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getDataTypesAccess().getFRACEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalCoreDsl.g:6833:3: (enumLiteral_10= 'accum' )
                    {
                    // InternalCoreDsl.g:6833:3: (enumLiteral_10= 'accum' )
                    // InternalCoreDsl.g:6834:4: enumLiteral_10= 'accum'
                    {
                    enumLiteral_10=(Token)match(input,116,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getACCUMEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getDataTypesAccess().getACCUMEnumLiteralDeclaration_10());
                      			
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
    // $ANTLR end "ruleDataTypes"


    // $ANTLR start "ruleTypeQualifier"
    // InternalCoreDsl.g:6844:1: ruleTypeQualifier returns [Enumerator current=null] : ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) ) ;
    public final Enumerator ruleTypeQualifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6850:2: ( ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) ) )
            // InternalCoreDsl.g:6851:2: ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) )
            {
            // InternalCoreDsl.g:6851:2: ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) )
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==117) ) {
                alt134=1;
            }
            else if ( (LA134_0==118) ) {
                alt134=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }
            switch (alt134) {
                case 1 :
                    // InternalCoreDsl.g:6852:3: (enumLiteral_0= 'const' )
                    {
                    // InternalCoreDsl.g:6852:3: (enumLiteral_0= 'const' )
                    // InternalCoreDsl.g:6853:4: enumLiteral_0= 'const'
                    {
                    enumLiteral_0=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeQualifierAccess().getCONSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTypeQualifierAccess().getCONSTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6860:3: (enumLiteral_1= 'volatile' )
                    {
                    // InternalCoreDsl.g:6860:3: (enumLiteral_1= 'volatile' )
                    // InternalCoreDsl.g:6861:4: enumLiteral_1= 'volatile'
                    {
                    enumLiteral_1=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeQualifierAccess().getVOLATILEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getTypeQualifierAccess().getVOLATILEEnumLiteralDeclaration_1());
                      			
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
    // $ANTLR end "ruleTypeQualifier"


    // $ANTLR start "ruleStorageClassSpecifier"
    // InternalCoreDsl.g:6871:1: ruleStorageClassSpecifier returns [Enumerator current=null] : ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) ) ;
    public final Enumerator ruleStorageClassSpecifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6877:2: ( ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) ) )
            // InternalCoreDsl.g:6878:2: ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) )
            {
            // InternalCoreDsl.g:6878:2: ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) )
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==45) ) {
                alt135=1;
            }
            else if ( (LA135_0==119) ) {
                alt135=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }
            switch (alt135) {
                case 1 :
                    // InternalCoreDsl.g:6879:3: (enumLiteral_0= 'extern' )
                    {
                    // InternalCoreDsl.g:6879:3: (enumLiteral_0= 'extern' )
                    // InternalCoreDsl.g:6880:4: enumLiteral_0= 'extern'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStorageClassSpecifierAccess().getEXTERNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getStorageClassSpecifierAccess().getEXTERNEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6887:3: (enumLiteral_1= 'static' )
                    {
                    // InternalCoreDsl.g:6887:3: (enumLiteral_1= 'static' )
                    // InternalCoreDsl.g:6888:4: enumLiteral_1= 'static'
                    {
                    enumLiteral_1=(Token)match(input,119,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStorageClassSpecifierAccess().getSTATICEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getStorageClassSpecifierAccess().getSTATICEnumLiteralDeclaration_1());
                      			
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
    // $ANTLR end "ruleStorageClassSpecifier"


    // $ANTLR start "ruleAttribute"
    // InternalCoreDsl.g:6898:1: ruleAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) ) ;
    public final Enumerator ruleAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6904:2: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) ) )
            // InternalCoreDsl.g:6905:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) )
            {
            // InternalCoreDsl.g:6905:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) )
            int alt136=3;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt136=1;
                }
                break;
            case 121:
                {
                alt136=2;
                }
                break;
            case 122:
                {
                alt136=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }

            switch (alt136) {
                case 1 :
                    // InternalCoreDsl.g:6906:3: (enumLiteral_0= 'NONE' )
                    {
                    // InternalCoreDsl.g:6906:3: (enumLiteral_0= 'NONE' )
                    // InternalCoreDsl.g:6907:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,120,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAttributeAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAttributeAccess().getNONEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6914:3: (enumLiteral_1= 'is_pc' )
                    {
                    // InternalCoreDsl.g:6914:3: (enumLiteral_1= 'is_pc' )
                    // InternalCoreDsl.g:6915:4: enumLiteral_1= 'is_pc'
                    {
                    enumLiteral_1=(Token)match(input,121,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAttributeAccess().getIS_PCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAttributeAccess().getIS_PCEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6922:3: (enumLiteral_2= 'delete' )
                    {
                    // InternalCoreDsl.g:6922:3: (enumLiteral_2= 'delete' )
                    // InternalCoreDsl.g:6923:4: enumLiteral_2= 'delete'
                    {
                    enumLiteral_2=(Token)match(input,122,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAttributeAccess().getDELEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAttributeAccess().getDELEnumLiteralDeclaration_2());
                      			
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "ruleInstrAttribute"
    // InternalCoreDsl.g:6933:1: ruleInstrAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) ) ;
    public final Enumerator ruleInstrAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6939:2: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) ) )
            // InternalCoreDsl.g:6940:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) )
            {
            // InternalCoreDsl.g:6940:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) )
            int alt137=4;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt137=1;
                }
                break;
            case 123:
                {
                alt137=2;
                }
                break;
            case 124:
                {
                alt137=3;
                }
                break;
            case 125:
                {
                alt137=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }

            switch (alt137) {
                case 1 :
                    // InternalCoreDsl.g:6941:3: (enumLiteral_0= 'NONE' )
                    {
                    // InternalCoreDsl.g:6941:3: (enumLiteral_0= 'NONE' )
                    // InternalCoreDsl.g:6942:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,120,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInstrAttributeAccess().getNONEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6949:3: (enumLiteral_1= 'no_cont' )
                    {
                    // InternalCoreDsl.g:6949:3: (enumLiteral_1= 'no_cont' )
                    // InternalCoreDsl.g:6950:4: enumLiteral_1= 'no_cont'
                    {
                    enumLiteral_1=(Token)match(input,123,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getNO_CONTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getInstrAttributeAccess().getNO_CONTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6957:3: (enumLiteral_2= 'cond' )
                    {
                    // InternalCoreDsl.g:6957:3: (enumLiteral_2= 'cond' )
                    // InternalCoreDsl.g:6958:4: enumLiteral_2= 'cond'
                    {
                    enumLiteral_2=(Token)match(input,124,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getCONDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getInstrAttributeAccess().getCONDEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6965:3: (enumLiteral_3= 'flush' )
                    {
                    // InternalCoreDsl.g:6965:3: (enumLiteral_3= 'flush' )
                    // InternalCoreDsl.g:6966:4: enumLiteral_3= 'flush'
                    {
                    enumLiteral_3=(Token)match(input,125,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getFLUSHEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getInstrAttributeAccess().getFLUSHEnumLiteralDeclaration_3());
                      			
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


    // $ANTLR start "ruleStructOrUnion"
    // InternalCoreDsl.g:6976:1: ruleStructOrUnion returns [Enumerator current=null] : ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) ) ;
    public final Enumerator ruleStructOrUnion() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6982:2: ( ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) ) )
            // InternalCoreDsl.g:6983:2: ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) )
            {
            // InternalCoreDsl.g:6983:2: ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==126) ) {
                alt138=1;
            }
            else if ( (LA138_0==127) ) {
                alt138=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }
            switch (alt138) {
                case 1 :
                    // InternalCoreDsl.g:6984:3: (enumLiteral_0= 'struct' )
                    {
                    // InternalCoreDsl.g:6984:3: (enumLiteral_0= 'struct' )
                    // InternalCoreDsl.g:6985:4: enumLiteral_0= 'struct'
                    {
                    enumLiteral_0=(Token)match(input,126,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStructOrUnionAccess().getSTRUCTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getStructOrUnionAccess().getSTRUCTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6992:3: (enumLiteral_1= 'union' )
                    {
                    // InternalCoreDsl.g:6992:3: (enumLiteral_1= 'union' )
                    // InternalCoreDsl.g:6993:4: enumLiteral_1= 'union'
                    {
                    enumLiteral_1=(Token)match(input,127,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStructOrUnionAccess().getUNIONEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getStructOrUnionAccess().getUNIONEnumLiteralDeclaration_1());
                      			
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
    // $ANTLR end "ruleStructOrUnion"


    // $ANTLR start "ruleBitfieldDataType"
    // InternalCoreDsl.g:7003:1: ruleBitfieldDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) ) ;
    public final Enumerator ruleBitfieldDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:7009:2: ( ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) ) )
            // InternalCoreDsl.g:7010:2: ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) )
            {
            // InternalCoreDsl.g:7010:2: ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) )
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==98) ) {
                alt139=1;
            }
            else if ( (LA139_0==128) ) {
                alt139=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;
            }
            switch (alt139) {
                case 1 :
                    // InternalCoreDsl.g:7011:3: (enumLiteral_0= 'u' )
                    {
                    // InternalCoreDsl.g:7011:3: (enumLiteral_0= 'u' )
                    // InternalCoreDsl.g:7012:4: enumLiteral_0= 'u'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getBitfieldDataTypeAccess().getUNSIGNEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getBitfieldDataTypeAccess().getUNSIGNEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7019:3: (enumLiteral_1= 's' )
                    {
                    // InternalCoreDsl.g:7019:3: (enumLiteral_1= 's' )
                    // InternalCoreDsl.g:7020:4: enumLiteral_1= 's'
                    {
                    enumLiteral_1=(Token)match(input,128,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getBitfieldDataTypeAccess().getSIGNEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getBitfieldDataTypeAccess().getSIGNEDEnumLiteralDeclaration_1());
                      			
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
    // $ANTLR end "ruleBitfieldDataType"

    // $ANTLR start synpred1_InternalCoreDsl
    public final void synpred1_InternalCoreDsl_fragment() throws RecognitionException {   
        // InternalCoreDsl.g:1773:5: ( 'else' )
        // InternalCoreDsl.g:1773:6: 'else'
        {
        match(input,51,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalCoreDsl

    // Delegated rules

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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000080600000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000080400002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000007A000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x9000200400000020L,0xC0FFFC0000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x9000200404000020L,0xC0FFFC0000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000078000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x8000200400000020L,0xC0FFFC0000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x8000200404000020L,0xC0FFFC0000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000101000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000201000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000005E000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000005C000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000054000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000044000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x3900000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000040000000002L,0x0000000400000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000040000000000L,0x0000000400000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000480000000022L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x08004000000007B0L,0x0000001EF9810000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0FF44040010007B0L,0x0000001EF9810000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x9FF46044050007B0L,0xC0FFFC1EF9810000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x98006044000007B0L,0xC0FFFC1EF9810000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x08004040000007B0L,0x0000001EF9810000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x08004000000007B2L,0x0000001EF9810000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x2800004000000020L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0800004000000020L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000004000000020L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000004200000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0700000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000002L,0x001FFC0000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x4000000200000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000204000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x08004000010007B0L,0x0000001EF9810000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000082000000002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x08005000000007B0L,0x0060001EF9810000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x08005000000007B0L,0x0000001EF9810000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x08004800010007B0L,0x0000001EF9810002L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x8000E80400000020L,0xC0FFFC0000000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000FFDL});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000FFDL});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000002L,0x0000000000060000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x6000000000000002L,0x0000000000180000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0800000000000002L,0x0000000006000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x8000000000000000L,0xC01FFC0000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x80004000000007B0L,0xC01FFC1E00000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000480000000002L,0x0000000118000002L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000102000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0800C000000007B0L,0x0000001EF9810000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000800200000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000012L,0x0000001E00000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000002L,0x000000FC00000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000002L,0x0000033000000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000002L,0x0000003000000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000000L,0x000000FC00000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000002L,0x0000000C00000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000400L});

}