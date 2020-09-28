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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BVAL", "RULE_NATURAL", "RULE_FLOAT", "RULE_BOOLEAN", "RULE_CHARCONST", "RULE_DECIMALCONSTANT", "RULE_BINARYCONSTANT", "RULE_HEXADECIMALCONSTANT", "RULE_OCTALCONSTANT", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'InstructionSet'", "'extends'", "'{'", "'constants'", "'}'", "'address_spaces'", "'registers'", "'functions'", "'instructions'", "'Core'", "'provides'", "','", "'[['", "']]'", "'encoding'", "':'", "';'", "'args_disass'", "'behavior'", "'|'", "'\\''", "'['", "']'", "'extern'", "'('", "')'", "'case'", "'default'", "'if'", "'else'", "'switch'", "'while'", "'do'", "'for'", "'continue'", "'break'", "'return'", "'typedef'", "'<'", "'>'", "'enum'", "'='", "'.'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'?'", "'||'", "'&&'", "'^'", "'&'", "'=='", "'!='", "'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'sizeof'", "'~'", "'!'", "'->'", "'u8'", "'u'", "'U'", "'L'", "'l'", "'ll'", "'LL'", "'f'", "'F'", "'bool'", "'char'", "'short'", "'int'", "'long'", "'signed'", "'unsigned'", "'float'", "'double'", "'frac'", "'accum'", "'const'", "'volatile'", "'static'", "'NONE'", "'is_pc'", "'delete'", "'no_cont'", "'cond'", "'flush'", "'struct'", "'union'", "'s'"
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
    public static final int RULE_INT=15;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=16;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
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
    public static final int RULE_NATURAL=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
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
    public static final int RULE_SL_COMMENT=17;
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
    public static final int RULE_WS=18;
    public static final int RULE_ANY_OTHER=19;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
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

                if ( (LA1_0==20) ) {
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

                if ( (LA2_0==21||LA2_0==30) ) {
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
            otherlv_0=(Token)match(input,20,FOLLOW_5); if (state.failed) return current;
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

            if ( (LA3_0==21) ) {
                alt3=1;
            }
            else if ( (LA3_0==30) ) {
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
            otherlv_0=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
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

            if ( (LA4_0==22) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalCoreDsl.g:237:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_6); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,23,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:259:3: (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalCoreDsl.g:260:4: otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,24,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getInstructionSetAccess().getConstantsKeyword_4_0());
                      			
                    }
                    otherlv_6=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:268:4: ( (lv_constants_7_0= ruleDeclaration ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID||LA5_0==33||LA5_0==44||LA5_0==58||LA5_0==61||(LA5_0>=105 && LA5_0<=118)||(LA5_0>=125 && LA5_0<=126)) ) {
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

                    otherlv_8=(Token)match(input,25,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:292:3: (otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalCoreDsl.g:293:4: otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,26,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getInstructionSetAccess().getAddress_spacesKeyword_5_0());
                      			
                    }
                    otherlv_10=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_5_1());
                      			
                    }
                    // InternalCoreDsl.g:301:4: ( (lv_spaces_11_0= ruleDeclaration ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID||LA7_0==33||LA7_0==44||LA7_0==58||LA7_0==61||(LA7_0>=105 && LA7_0<=118)||(LA7_0>=125 && LA7_0<=126)) ) {
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

                    otherlv_12=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:325:3: (otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalCoreDsl.g:326:4: otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getInstructionSetAccess().getRegistersKeyword_6_0());
                      			
                    }
                    otherlv_14=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_6_1());
                      			
                    }
                    // InternalCoreDsl.g:334:4: ( (lv_regs_15_0= ruleDeclaration ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID||LA9_0==33||LA9_0==44||LA9_0==58||LA9_0==61||(LA9_0>=105 && LA9_0<=118)||(LA9_0>=125 && LA9_0<=126)) ) {
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

                    otherlv_16=(Token)match(input,25,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:358:3: (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalCoreDsl.g:359:4: otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getInstructionSetAccess().getFunctionsKeyword_7_0());
                      			
                    }
                    otherlv_18=(Token)match(input,23,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_7_1());
                      			
                    }
                    // InternalCoreDsl.g:367:4: ( (lv_func_19_0= ruleFunctionDefinition ) )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID||LA11_0==44||LA11_0==61||(LA11_0>=105 && LA11_0<=115)||(LA11_0>=125 && LA11_0<=126)) ) {
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

                    otherlv_20=(Token)match(input,25,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_7_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:391:3: (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' )
            // InternalCoreDsl.g:392:4: otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}'
            {
            otherlv_21=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_21, grammarAccess.getInstructionSetAccess().getInstructionsKeyword_8_0());
              			
            }
            otherlv_22=(Token)match(input,23,FOLLOW_6); if (state.failed) return current;
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

            otherlv_24=(Token)match(input,25,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_24, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_8_3());
              			
            }

            }

            otherlv_25=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,30,FOLLOW_6); if (state.failed) return current;
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

            if ( (LA15_0==31) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalCoreDsl.g:470:4: otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_6); if (state.failed) return current;
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

                        if ( (LA14_0==32) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalCoreDsl.g:488:5: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,32,FOLLOW_6); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,23,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:511:3: (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==24) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalCoreDsl.g:512:4: otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,24,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getCoreDefAccess().getConstantsKeyword_4_0());
                      			
                    }
                    otherlv_8=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:520:4: ( (lv_constants_9_0= ruleDeclaration ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID||LA16_0==33||LA16_0==44||LA16_0==58||LA16_0==61||(LA16_0>=105 && LA16_0<=118)||(LA16_0>=125 && LA16_0<=126)) ) {
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

                    otherlv_10=(Token)match(input,25,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:544:3: (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==26) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalCoreDsl.g:545:4: otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,26,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getCoreDefAccess().getAddress_spacesKeyword_5_0());
                      			
                    }
                    otherlv_12=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_5_1());
                      			
                    }
                    // InternalCoreDsl.g:553:4: ( (lv_spaces_13_0= ruleDeclaration ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_ID||LA18_0==33||LA18_0==44||LA18_0==58||LA18_0==61||(LA18_0>=105 && LA18_0<=118)||(LA18_0>=125 && LA18_0<=126)) ) {
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

                    otherlv_14=(Token)match(input,25,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:577:3: (otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==27) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalCoreDsl.g:578:4: otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getCoreDefAccess().getRegistersKeyword_6_0());
                      			
                    }
                    otherlv_16=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_6_1());
                      			
                    }
                    // InternalCoreDsl.g:586:4: ( (lv_regs_17_0= ruleDeclaration ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID||LA20_0==33||LA20_0==44||LA20_0==58||LA20_0==61||(LA20_0>=105 && LA20_0<=118)||(LA20_0>=125 && LA20_0<=126)) ) {
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

                    otherlv_18=(Token)match(input,25,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:610:3: (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalCoreDsl.g:611:4: otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getCoreDefAccess().getInstructionsKeyword_7_0());
                      			
                    }
                    otherlv_20=(Token)match(input,23,FOLLOW_6); if (state.failed) return current;
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

                    otherlv_22=(Token)match(input,25,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_22, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_7_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_23=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalCoreDsl.g:685:4: otherlv_1= '[[' ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* otherlv_5= ']]'
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_27); if (state.failed) return current;
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

                        if ( (LA24_0==32) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalCoreDsl.g:709:5: otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) )
                    	    {
                    	    otherlv_3=(Token)match(input,32,FOLLOW_27); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,34,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getInstructionAccess().getRightSquareBracketRightSquareBracketKeyword_1_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_6=(Token)match(input,23,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getInstructionAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalCoreDsl.g:742:3: (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' )
            // InternalCoreDsl.g:743:4: otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';'
            {
            otherlv_7=(Token)match(input,35,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_7, grammarAccess.getInstructionAccess().getEncodingKeyword_3_0());
              			
            }
            otherlv_8=(Token)match(input,36,FOLLOW_31); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,37,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_10, grammarAccess.getInstructionAccess().getSemicolonKeyword_3_3());
              			
            }

            }

            // InternalCoreDsl.g:775:3: (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalCoreDsl.g:776:4: otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';'
                    {
                    otherlv_11=(Token)match(input,38,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getInstructionAccess().getArgs_disassKeyword_4_0());
                      			
                    }
                    otherlv_12=(Token)match(input,36,FOLLOW_5); if (state.failed) return current;
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

                    otherlv_14=(Token)match(input,37,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getInstructionAccess().getSemicolonKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:807:3: (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) )
            // InternalCoreDsl.g:808:4: otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) )
            {
            otherlv_15=(Token)match(input,39,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_15, grammarAccess.getInstructionAccess().getBehaviorKeyword_5_0());
              			
            }
            otherlv_16=(Token)match(input,36,FOLLOW_8); if (state.failed) return current;
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

            otherlv_18=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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

                if ( (LA27_0==40) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalCoreDsl.g:879:4: otherlv_1= '|' ( (lv_fields_2_0= ruleField ) )
            	    {
            	    otherlv_1=(Token)match(input,40,FOLLOW_31); if (state.failed) return current;
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

            if ( (LA30_0==41||LA30_0==97||LA30_0==127) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalCoreDsl.g:1031:4: (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) )
                    {
                    // InternalCoreDsl.g:1031:4: (otherlv_2= '\\'' )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==41) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalCoreDsl.g:1032:5: otherlv_2= '\\''
                            {
                            otherlv_2=(Token)match(input,41,FOLLOW_38); if (state.failed) return current;
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
    // InternalCoreDsl.g:1068:1: ruleRangeSpec returns [EObject current=null] : (otherlv_0= '[' ( (lv_left_1_0= RULE_NATURAL ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NATURAL ) ) otherlv_4= ']' ) ;
    public final EObject ruleRangeSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_left_1_0=null;
        Token otherlv_2=null;
        Token lv_right_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:1074:2: ( (otherlv_0= '[' ( (lv_left_1_0= RULE_NATURAL ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NATURAL ) ) otherlv_4= ']' ) )
            // InternalCoreDsl.g:1075:2: (otherlv_0= '[' ( (lv_left_1_0= RULE_NATURAL ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NATURAL ) ) otherlv_4= ']' )
            {
            // InternalCoreDsl.g:1075:2: (otherlv_0= '[' ( (lv_left_1_0= RULE_NATURAL ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NATURAL ) ) otherlv_4= ']' )
            // InternalCoreDsl.g:1076:3: otherlv_0= '[' ( (lv_left_1_0= RULE_NATURAL ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NATURAL ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRangeSpecAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalCoreDsl.g:1080:3: ( (lv_left_1_0= RULE_NATURAL ) )
            // InternalCoreDsl.g:1081:4: (lv_left_1_0= RULE_NATURAL )
            {
            // InternalCoreDsl.g:1081:4: (lv_left_1_0= RULE_NATURAL )
            // InternalCoreDsl.g:1082:5: lv_left_1_0= RULE_NATURAL
            {
            lv_left_1_0=(Token)match(input,RULE_NATURAL,FOLLOW_30); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,36,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRangeSpecAccess().getColonKeyword_2());
              		
            }
            // InternalCoreDsl.g:1102:3: ( (lv_right_3_0= RULE_NATURAL ) )
            // InternalCoreDsl.g:1103:4: (lv_right_3_0= RULE_NATURAL )
            {
            // InternalCoreDsl.g:1103:4: (lv_right_3_0= RULE_NATURAL )
            // InternalCoreDsl.g:1104:5: lv_right_3_0= RULE_NATURAL
            {
            lv_right_3_0=(Token)match(input,RULE_NATURAL,FOLLOW_40); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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

            if ( (LA31_0==44) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalCoreDsl.g:1144:4: (lv_extern_0_0= 'extern' )
                    {
                    // InternalCoreDsl.g:1144:4: (lv_extern_0_0= 'extern' )
                    // InternalCoreDsl.g:1145:5: lv_extern_0_0= 'extern'
                    {
                    lv_extern_0_0=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,45,FOLLOW_15); if (state.failed) return current;
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
            otherlv_5=(Token)match(input,46,FOLLOW_8); if (state.failed) return current;
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

                if ( (LA32_0==32) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalCoreDsl.g:1265:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,32,FOLLOW_15); if (state.failed) return current;
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
            else if ( (LA33_0==42||LA33_0==45) ) {
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
            case 23:
                {
                alt34=1;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_NATURAL:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 37:
            case 45:
            case 78:
            case 85:
            case 86:
            case 87:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 97:
            case 98:
            case 99:
                {
                alt34=2;
                }
                break;
            case 49:
            case 51:
                {
                alt34=3;
                }
                break;
            case 52:
            case 53:
            case 54:
                {
                alt34=4;
                }
                break;
            case 55:
            case 56:
            case 57:
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

            if ( (LA35_0==47) ) {
                alt35=1;
            }
            else if ( (LA35_0==48) ) {
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
                    otherlv_0=(Token)match(input,47,FOLLOW_45); if (state.failed) return current;
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

                    otherlv_2=(Token)match(input,36,FOLLOW_46); if (state.failed) return current;
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
                    otherlv_4=(Token)match(input,48,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getLabeledStatementAccess().getDefaultKeyword_1_0());
                      			
                    }
                    otherlv_5=(Token)match(input,36,FOLLOW_46); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,23,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundStatementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalCoreDsl.g:1558:3: ( (lv_items_2_0= ruleBlockItem ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_ID)||(LA36_0>=RULE_NATURAL && LA36_0<=RULE_CHARCONST)||LA36_0==23||LA36_0==33||LA36_0==37||(LA36_0>=44 && LA36_0<=45)||LA36_0==49||(LA36_0>=51 && LA36_0<=58)||LA36_0==61||LA36_0==78||(LA36_0>=85 && LA36_0<=87)||(LA36_0>=90 && LA36_0<=94)||(LA36_0>=96 && LA36_0<=99)||(LA36_0>=105 && LA36_0<=118)||(LA36_0>=125 && LA36_0<=126)) ) {
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

            otherlv_3=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
            case RULE_NATURAL:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 23:
            case 37:
            case 45:
            case 49:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 78:
            case 85:
            case 86:
            case 87:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 97:
            case 98:
            case 99:
                {
                alt37=1;
                }
                break;
            case RULE_ID:
                {
                int LA37_2 = input.LA(2);

                if ( (LA37_2==RULE_ID||LA37_2==37||LA37_2==59) ) {
                    alt37=2;
                }
                else if ( (LA37_2==42||LA37_2==45||(LA37_2>=62 && LA37_2<=73)||(LA37_2>=90 && LA37_2<=91)||LA37_2==95) ) {
                    alt37=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 2, input);

                    throw nvae;
                }
                }
                break;
            case 33:
            case 44:
            case 58:
            case 61:
            case 105:
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
            case 125:
            case 126:
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

            if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_ID)||(LA38_0>=RULE_NATURAL && LA38_0<=RULE_CHARCONST)||LA38_0==45||LA38_0==78||(LA38_0>=85 && LA38_0<=87)||(LA38_0>=90 && LA38_0<=94)||(LA38_0>=96 && LA38_0<=99)) ) {
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

            otherlv_2=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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

            if ( (LA39_0==49) ) {
                alt39=1;
            }
            else if ( (LA39_0==51) ) {
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
            otherlv_0=(Token)match(input,49,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,45,FOLLOW_45); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,46,FOLLOW_46); if (state.failed) return current;
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

            if ( (LA40_0==50) ) {
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
                    otherlv_5=(Token)match(input,50,FOLLOW_46); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,51,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatementAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,45,FOLLOW_45); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,46,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,23,FOLLOW_49); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
            case 52:
                {
                alt41=1;
                }
                break;
            case 53:
                {
                alt41=2;
                }
                break;
            case 54:
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
                    lv_type_0_0=(Token)match(input,52,FOLLOW_41); if (state.failed) return current;
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

                    otherlv_1=(Token)match(input,45,FOLLOW_45); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,46,FOLLOW_46); if (state.failed) return current;
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
                    lv_type_5_0=(Token)match(input,53,FOLLOW_46); if (state.failed) return current;
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

                    otherlv_7=(Token)match(input,52,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getIterationStatementAccess().getWhileKeyword_1_2());
                      			
                    }
                    otherlv_8=(Token)match(input,45,FOLLOW_45); if (state.failed) return current;
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

                    otherlv_10=(Token)match(input,46,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getIterationStatementAccess().getRightParenthesisKeyword_1_5());
                      			
                    }
                    otherlv_11=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
                    lv_type_12_0=(Token)match(input,54,FOLLOW_41); if (state.failed) return current;
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

                    otherlv_13=(Token)match(input,45,FOLLOW_51); if (state.failed) return current;
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
                    otherlv_15=(Token)match(input,46,FOLLOW_46); if (state.failed) return current;
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
            case 33:
            case 44:
            case 58:
            case 61:
            case 105:
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
            case 125:
            case 126:
                {
                alt43=1;
                }
                break;
            case RULE_ID:
                {
                int LA43_2 = input.LA(2);

                if ( (LA43_2==42||LA43_2==45||(LA43_2>=62 && LA43_2<=73)||(LA43_2>=90 && LA43_2<=91)||LA43_2==95) ) {
                    alt43=2;
                }
                else if ( (LA43_2==RULE_ID||LA43_2==37||LA43_2==59) ) {
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
            case RULE_NATURAL:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 37:
            case 45:
            case 78:
            case 85:
            case 86:
            case 87:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 97:
            case 98:
            case 99:
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

                    if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_ID)||(LA42_0>=RULE_NATURAL && LA42_0<=RULE_CHARCONST)||LA42_0==45||LA42_0==78||(LA42_0>=85 && LA42_0<=87)||(LA42_0>=90 && LA42_0<=94)||(LA42_0>=96 && LA42_0<=99)) ) {
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

                    otherlv_2=(Token)match(input,37,FOLLOW_52); if (state.failed) return current;
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

            if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_ID)||(LA44_0>=RULE_NATURAL && LA44_0<=RULE_CHARCONST)||LA44_0==45||LA44_0==78||(LA44_0>=85 && LA44_0<=87)||(LA44_0>=90 && LA44_0<=94)||(LA44_0>=96 && LA44_0<=99)) ) {
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

            otherlv_4=(Token)match(input,37,FOLLOW_53); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getForConditionAccess().getSemicolonKeyword_2());
              		
            }
            // InternalCoreDsl.g:2166:3: ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_ID)||(LA46_0>=RULE_NATURAL && LA46_0<=RULE_CHARCONST)||LA46_0==45||LA46_0==78||(LA46_0>=85 && LA46_0<=87)||(LA46_0>=90 && LA46_0<=94)||(LA46_0>=96 && LA46_0<=99)) ) {
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

                        if ( (LA45_0==32) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2187:5: otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) )
                    	    {
                    	    otherlv_6=(Token)match(input,32,FOLLOW_45); if (state.failed) return current;
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
            case 55:
                {
                alt48=1;
                }
                break;
            case 56:
                {
                alt48=2;
                }
                break;
            case 57:
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
                    lv_type_0_0=(Token)match(input,55,FOLLOW_32); if (state.failed) return current;
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

                    otherlv_1=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
                    lv_type_2_0=(Token)match(input,56,FOLLOW_32); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
                    lv_type_4_0=(Token)match(input,57,FOLLOW_52); if (state.failed) return current;
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

                    if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_ID)||(LA47_0>=RULE_NATURAL && LA47_0<=RULE_CHARCONST)||LA47_0==45||LA47_0==78||(LA47_0>=85 && LA47_0<=87)||(LA47_0>=90 && LA47_0<=94)||(LA47_0>=96 && LA47_0<=99)) ) {
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

                    otherlv_6=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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

            if ( (LA49_0==RULE_ID||LA49_0==33||LA49_0==44||LA49_0==61||(LA49_0>=105 && LA49_0<=118)||(LA49_0>=125 && LA49_0<=126)) ) {
                alt49=1;
            }
            else if ( (LA49_0==58) ) {
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
    // InternalCoreDsl.g:2359:1: ruleTypeOrVarDeclaration returns [EObject current=null] : ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( ( (lv_init_3_0= ruleInitDeclarator ) ) (otherlv_4= ',' ( (lv_init_5_0= ruleInitDeclarator ) ) )* )? otherlv_6= ';' ) ;
    public final EObject ruleTypeOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_DeclarationSpecifier_0 = null;

        EObject lv_type_1_0 = null;

        EObject lv_size_2_0 = null;

        EObject lv_init_3_0 = null;

        EObject lv_init_5_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2365:2: ( ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( ( (lv_init_3_0= ruleInitDeclarator ) ) (otherlv_4= ',' ( (lv_init_5_0= ruleInitDeclarator ) ) )* )? otherlv_6= ';' ) )
            // InternalCoreDsl.g:2366:2: ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( ( (lv_init_3_0= ruleInitDeclarator ) ) (otherlv_4= ',' ( (lv_init_5_0= ruleInitDeclarator ) ) )* )? otherlv_6= ';' )
            {
            // InternalCoreDsl.g:2366:2: ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( ( (lv_init_3_0= ruleInitDeclarator ) ) (otherlv_4= ',' ( (lv_init_5_0= ruleInitDeclarator ) ) )* )? otherlv_6= ';' )
            // InternalCoreDsl.g:2367:3: (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( ( (lv_init_3_0= ruleInitDeclarator ) ) (otherlv_4= ',' ( (lv_init_5_0= ruleInitDeclarator ) ) )* )? otherlv_6= ';'
            {
            // InternalCoreDsl.g:2367:3: (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==33||LA50_0==44||(LA50_0>=116 && LA50_0<=118)) ) {
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

            if ( (LA51_0==59) ) {
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

            // InternalCoreDsl.g:2418:3: ( ( (lv_init_3_0= ruleInitDeclarator ) ) (otherlv_4= ',' ( (lv_init_5_0= ruleInitDeclarator ) ) )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalCoreDsl.g:2419:4: ( (lv_init_3_0= ruleInitDeclarator ) ) (otherlv_4= ',' ( (lv_init_5_0= ruleInitDeclarator ) ) )*
                    {
                    // InternalCoreDsl.g:2419:4: ( (lv_init_3_0= ruleInitDeclarator ) )
                    // InternalCoreDsl.g:2420:5: (lv_init_3_0= ruleInitDeclarator )
                    {
                    // InternalCoreDsl.g:2420:5: (lv_init_3_0= ruleInitDeclarator )
                    // InternalCoreDsl.g:2421:6: lv_init_3_0= ruleInitDeclarator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getInitInitDeclaratorParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_56);
                    lv_init_3_0=ruleInitDeclarator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTypeOrVarDeclarationRule());
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

                    // InternalCoreDsl.g:2438:4: (otherlv_4= ',' ( (lv_init_5_0= ruleInitDeclarator ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==32) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2439:5: otherlv_4= ',' ( (lv_init_5_0= ruleInitDeclarator ) )
                    	    {
                    	    otherlv_4=(Token)match(input,32,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getTypeOrVarDeclarationAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2443:5: ( (lv_init_5_0= ruleInitDeclarator ) )
                    	    // InternalCoreDsl.g:2444:6: (lv_init_5_0= ruleInitDeclarator )
                    	    {
                    	    // InternalCoreDsl.g:2444:6: (lv_init_5_0= ruleInitDeclarator )
                    	    // InternalCoreDsl.g:2445:7: lv_init_5_0= ruleInitDeclarator
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getInitInitDeclaratorParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_56);
                    	    lv_init_5_0=ruleInitDeclarator();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getTypeOrVarDeclarationRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"init",
                    	      								lv_init_5_0,
                    	      								"com.minres.coredsl.CoreDsl.InitDeclarator");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getTypeOrVarDeclarationAccess().getSemicolonKeyword_4());
              		
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
    // InternalCoreDsl.g:2472:1: entryRuleTypedefDeclaration returns [EObject current=null] : iv_ruleTypedefDeclaration= ruleTypedefDeclaration EOF ;
    public final EObject entryRuleTypedefDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefDeclaration = null;


        try {
            // InternalCoreDsl.g:2472:59: (iv_ruleTypedefDeclaration= ruleTypedefDeclaration EOF )
            // InternalCoreDsl.g:2473:2: iv_ruleTypedefDeclaration= ruleTypedefDeclaration EOF
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
    // InternalCoreDsl.g:2479:1: ruleTypedefDeclaration returns [EObject current=null] : (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' ) ;
    public final EObject ruleTypedefDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject this_DeclarationSpecifier_1 = null;

        EObject lv_type_2_0 = null;

        EObject lv_init_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2485:2: ( (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' ) )
            // InternalCoreDsl.g:2486:2: (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' )
            {
            // InternalCoreDsl.g:2486:2: (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' )
            // InternalCoreDsl.g:2487:3: otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypedefDeclarationAccess().getTypedefKeyword_0());
              		
            }
            // InternalCoreDsl.g:2491:3: (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==33||LA54_0==44||(LA54_0>=116 && LA54_0<=118)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalCoreDsl.g:2492:4: this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current]
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
            	    break loop54;
                }
            } while (true);

            // InternalCoreDsl.g:2504:3: ( (lv_type_2_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:2505:4: (lv_type_2_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:2505:4: (lv_type_2_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:2506:5: lv_type_2_0= ruleTypeSpecifier
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

            // InternalCoreDsl.g:2523:3: ( (lv_init_3_0= ruleInitDeclarator ) )
            // InternalCoreDsl.g:2524:4: (lv_init_3_0= ruleInitDeclarator )
            {
            // InternalCoreDsl.g:2524:4: (lv_init_3_0= ruleInitDeclarator )
            // InternalCoreDsl.g:2525:5: lv_init_3_0= ruleInitDeclarator
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

            otherlv_4=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:2551:1: ruleDeclarationSpecifier[EObject in_current] returns [EObject current=in_current] : ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] ) ;
    public final EObject ruleDeclarationSpecifier(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Enumerator lv_storage_0_0 = null;

        Enumerator lv_qualifiers_1_0 = null;

        EObject this_AttributeList_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2557:2: ( ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] ) )
            // InternalCoreDsl.g:2558:2: ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] )
            {
            // InternalCoreDsl.g:2558:2: ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 44:
            case 118:
                {
                alt55=1;
                }
                break;
            case 116:
            case 117:
                {
                alt55=2;
                }
                break;
            case 33:
                {
                alt55=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalCoreDsl.g:2559:3: ( (lv_storage_0_0= ruleStorageClassSpecifier ) )
                    {
                    // InternalCoreDsl.g:2559:3: ( (lv_storage_0_0= ruleStorageClassSpecifier ) )
                    // InternalCoreDsl.g:2560:4: (lv_storage_0_0= ruleStorageClassSpecifier )
                    {
                    // InternalCoreDsl.g:2560:4: (lv_storage_0_0= ruleStorageClassSpecifier )
                    // InternalCoreDsl.g:2561:5: lv_storage_0_0= ruleStorageClassSpecifier
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
                    // InternalCoreDsl.g:2579:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    {
                    // InternalCoreDsl.g:2579:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    // InternalCoreDsl.g:2580:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    {
                    // InternalCoreDsl.g:2580:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    // InternalCoreDsl.g:2581:5: lv_qualifiers_1_0= ruleTypeQualifier
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
                    // InternalCoreDsl.g:2599:3: this_AttributeList_2= ruleAttributeList[$current]
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
    // InternalCoreDsl.g:2615:1: ruleAttributeList[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '[[' ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* otherlv_4= ']]' ) ;
    public final EObject ruleAttributeList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_attrs_1_0 = null;

        Enumerator lv_attrs_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2621:2: ( (otherlv_0= '[[' ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* otherlv_4= ']]' ) )
            // InternalCoreDsl.g:2622:2: (otherlv_0= '[[' ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* otherlv_4= ']]' )
            {
            // InternalCoreDsl.g:2622:2: (otherlv_0= '[[' ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* otherlv_4= ']]' )
            // InternalCoreDsl.g:2623:3: otherlv_0= '[[' ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* otherlv_4= ']]'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAttributeListAccess().getLeftSquareBracketLeftSquareBracketKeyword_0());
              		
            }
            // InternalCoreDsl.g:2627:3: ( (lv_attrs_1_0= ruleAttribute ) )
            // InternalCoreDsl.g:2628:4: (lv_attrs_1_0= ruleAttribute )
            {
            // InternalCoreDsl.g:2628:4: (lv_attrs_1_0= ruleAttribute )
            // InternalCoreDsl.g:2629:5: lv_attrs_1_0= ruleAttribute
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

            // InternalCoreDsl.g:2646:3: (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==32) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalCoreDsl.g:2647:4: otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) )
            	    {
            	    otherlv_2=(Token)match(input,32,FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAttributeListAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:2651:4: ( (lv_attrs_3_0= ruleAttribute ) )
            	    // InternalCoreDsl.g:2652:5: (lv_attrs_3_0= ruleAttribute )
            	    {
            	    // InternalCoreDsl.g:2652:5: (lv_attrs_3_0= ruleAttribute )
            	    // InternalCoreDsl.g:2653:6: lv_attrs_3_0= ruleAttribute
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
            	    break loop56;
                }
            } while (true);

            otherlv_4=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:2679:1: entryRuleTypeSpecifier returns [EObject current=null] : iv_ruleTypeSpecifier= ruleTypeSpecifier EOF ;
    public final EObject entryRuleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSpecifier = null;


        try {
            // InternalCoreDsl.g:2679:54: (iv_ruleTypeSpecifier= ruleTypeSpecifier EOF )
            // InternalCoreDsl.g:2680:2: iv_ruleTypeSpecifier= ruleTypeSpecifier EOF
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
    // InternalCoreDsl.g:2686:1: ruleTypeSpecifier returns [EObject current=null] : (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_TypedefRef_1= ruleTypedefRef ) ;
    public final EObject ruleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_DataTypeSpecifier_0 = null;

        EObject this_TypedefRef_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2692:2: ( (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_TypedefRef_1= ruleTypedefRef ) )
            // InternalCoreDsl.g:2693:2: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_TypedefRef_1= ruleTypedefRef )
            {
            // InternalCoreDsl.g:2693:2: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_TypedefRef_1= ruleTypedefRef )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==61||(LA57_0>=105 && LA57_0<=115)||(LA57_0>=125 && LA57_0<=126)) ) {
                alt57=1;
            }
            else if ( (LA57_0==RULE_ID) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalCoreDsl.g:2694:3: this_DataTypeSpecifier_0= ruleDataTypeSpecifier
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
                    // InternalCoreDsl.g:2703:3: this_TypedefRef_1= ruleTypedefRef
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
    // InternalCoreDsl.g:2715:1: entryRuleDataTypeSpecifier returns [EObject current=null] : iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF ;
    public final EObject entryRuleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeSpecifier = null;


        try {
            // InternalCoreDsl.g:2715:58: (iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF )
            // InternalCoreDsl.g:2716:2: iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF
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
    // InternalCoreDsl.g:2722:1: ruleDataTypeSpecifier returns [EObject current=null] : (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier ) ;
    public final EObject ruleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_PodSpecifier_0 = null;

        EObject this_StructOrUnionSpecifier_1 = null;

        EObject this_EnumSpecifier_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2728:2: ( (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier ) )
            // InternalCoreDsl.g:2729:2: (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier )
            {
            // InternalCoreDsl.g:2729:2: (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier )
            int alt58=3;
            switch ( input.LA(1) ) {
            case 105:
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
                {
                alt58=1;
                }
                break;
            case 125:
            case 126:
                {
                alt58=2;
                }
                break;
            case 61:
                {
                alt58=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalCoreDsl.g:2730:3: this_PodSpecifier_0= rulePodSpecifier
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
                    // InternalCoreDsl.g:2739:3: this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier
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
                    // InternalCoreDsl.g:2748:3: this_EnumSpecifier_2= ruleEnumSpecifier
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
    // InternalCoreDsl.g:2760:1: entryRuleTypedefRef returns [EObject current=null] : iv_ruleTypedefRef= ruleTypedefRef EOF ;
    public final EObject entryRuleTypedefRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefRef = null;


        try {
            // InternalCoreDsl.g:2760:51: (iv_ruleTypedefRef= ruleTypedefRef EOF )
            // InternalCoreDsl.g:2761:2: iv_ruleTypedefRef= ruleTypedefRef EOF
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
    // InternalCoreDsl.g:2767:1: ruleTypedefRef returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleTypedefRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:2773:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalCoreDsl.g:2774:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalCoreDsl.g:2774:2: ( (otherlv_0= RULE_ID ) )
            // InternalCoreDsl.g:2775:3: (otherlv_0= RULE_ID )
            {
            // InternalCoreDsl.g:2775:3: (otherlv_0= RULE_ID )
            // InternalCoreDsl.g:2776:4: otherlv_0= RULE_ID
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
    // InternalCoreDsl.g:2790:1: entryRulePodSpecifier returns [EObject current=null] : iv_rulePodSpecifier= rulePodSpecifier EOF ;
    public final EObject entryRulePodSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePodSpecifier = null;


        try {
            // InternalCoreDsl.g:2790:53: (iv_rulePodSpecifier= rulePodSpecifier EOF )
            // InternalCoreDsl.g:2791:2: iv_rulePodSpecifier= rulePodSpecifier EOF
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
    // InternalCoreDsl.g:2797:1: rulePodSpecifier returns [EObject current=null] : ( (lv_dataType_0_0= ruleDataTypes ) )+ ;
    public final EObject rulePodSpecifier() throws RecognitionException {
        EObject current = null;

        Enumerator lv_dataType_0_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2803:2: ( ( (lv_dataType_0_0= ruleDataTypes ) )+ )
            // InternalCoreDsl.g:2804:2: ( (lv_dataType_0_0= ruleDataTypes ) )+
            {
            // InternalCoreDsl.g:2804:2: ( (lv_dataType_0_0= ruleDataTypes ) )+
            int cnt59=0;
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( ((LA59_0>=105 && LA59_0<=115)) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalCoreDsl.g:2805:3: (lv_dataType_0_0= ruleDataTypes )
            	    {
            	    // InternalCoreDsl.g:2805:3: (lv_dataType_0_0= ruleDataTypes )
            	    // InternalCoreDsl.g:2806:4: lv_dataType_0_0= ruleDataTypes
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getPodSpecifierAccess().getDataTypeDataTypesEnumRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_58);
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
            	    if ( cnt59 >= 1 ) break loop59;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(59, input);
                        throw eee;
                }
                cnt59++;
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
    // InternalCoreDsl.g:2826:1: entryRuleBitSizeSpecifier returns [EObject current=null] : iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF ;
    public final EObject entryRuleBitSizeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitSizeSpecifier = null;


        try {
            // InternalCoreDsl.g:2826:57: (iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF )
            // InternalCoreDsl.g:2827:2: iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF
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
    // InternalCoreDsl.g:2833:1: ruleBitSizeSpecifier returns [EObject current=null] : (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' ) ;
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
            // InternalCoreDsl.g:2839:2: ( (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' ) )
            // InternalCoreDsl.g:2840:2: (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' )
            {
            // InternalCoreDsl.g:2840:2: (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' )
            // InternalCoreDsl.g:2841:3: otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBitSizeSpecifierAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalCoreDsl.g:2845:3: ( (lv_size_1_0= ruleBitSizeValue ) )
            // InternalCoreDsl.g:2846:4: (lv_size_1_0= ruleBitSizeValue )
            {
            // InternalCoreDsl.g:2846:4: (lv_size_1_0= ruleBitSizeValue )
            // InternalCoreDsl.g:2847:5: lv_size_1_0= ruleBitSizeValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_60);
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

            // InternalCoreDsl.g:2864:3: (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==32) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalCoreDsl.g:2865:4: otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) )
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_0());
                      			
                    }
                    // InternalCoreDsl.g:2869:4: ( (lv_size_3_0= ruleBitSizeValue ) )
                    // InternalCoreDsl.g:2870:5: (lv_size_3_0= ruleBitSizeValue )
                    {
                    // InternalCoreDsl.g:2870:5: (lv_size_3_0= ruleBitSizeValue )
                    // InternalCoreDsl.g:2871:6: lv_size_3_0= ruleBitSizeValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_61);
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

                    otherlv_4=(Token)match(input,32,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_2());
                      			
                    }
                    // InternalCoreDsl.g:2892:4: ( (lv_size_5_0= ruleBitSizeValue ) )
                    // InternalCoreDsl.g:2893:5: (lv_size_5_0= ruleBitSizeValue )
                    {
                    // InternalCoreDsl.g:2893:5: (lv_size_5_0= ruleBitSizeValue )
                    // InternalCoreDsl.g:2894:6: lv_size_5_0= ruleBitSizeValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_61);
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

                    otherlv_6=(Token)match(input,32,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_4());
                      			
                    }
                    // InternalCoreDsl.g:2915:4: ( (lv_size_7_0= ruleBitSizeValue ) )
                    // InternalCoreDsl.g:2916:5: (lv_size_7_0= ruleBitSizeValue )
                    {
                    // InternalCoreDsl.g:2916:5: (lv_size_7_0= ruleBitSizeValue )
                    // InternalCoreDsl.g:2917:6: lv_size_7_0= ruleBitSizeValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_2_5_0());
                      					
                    }
                    pushFollow(FOLLOW_62);
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

            otherlv_8=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:2943:1: entryRuleBitSizeValue returns [EObject current=null] : iv_ruleBitSizeValue= ruleBitSizeValue EOF ;
    public final EObject entryRuleBitSizeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitSizeValue = null;


        try {
            // InternalCoreDsl.g:2943:53: (iv_ruleBitSizeValue= ruleBitSizeValue EOF )
            // InternalCoreDsl.g:2944:2: iv_ruleBitSizeValue= ruleBitSizeValue EOF
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
    // InternalCoreDsl.g:2950:1: ruleBitSizeValue returns [EObject current=null] : ( ( (lv_val_0_0= RULE_NATURAL ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleBitSizeValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:2956:2: ( ( ( (lv_val_0_0= RULE_NATURAL ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // InternalCoreDsl.g:2957:2: ( ( (lv_val_0_0= RULE_NATURAL ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalCoreDsl.g:2957:2: ( ( (lv_val_0_0= RULE_NATURAL ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_NATURAL) ) {
                alt61=1;
            }
            else if ( (LA61_0==RULE_ID) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalCoreDsl.g:2958:3: ( (lv_val_0_0= RULE_NATURAL ) )
                    {
                    // InternalCoreDsl.g:2958:3: ( (lv_val_0_0= RULE_NATURAL ) )
                    // InternalCoreDsl.g:2959:4: (lv_val_0_0= RULE_NATURAL )
                    {
                    // InternalCoreDsl.g:2959:4: (lv_val_0_0= RULE_NATURAL )
                    // InternalCoreDsl.g:2960:5: lv_val_0_0= RULE_NATURAL
                    {
                    lv_val_0_0=(Token)match(input,RULE_NATURAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_val_0_0, grammarAccess.getBitSizeValueAccess().getValNATURALTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBitSizeValueRule());
                      					}
                      					addWithLastConsumed(
                      						current,
                      						"val",
                      						lv_val_0_0,
                      						"com.minres.coredsl.CoreDsl.NATURAL");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2977:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:2977:3: ( (otherlv_1= RULE_ID ) )
                    // InternalCoreDsl.g:2978:4: (otherlv_1= RULE_ID )
                    {
                    // InternalCoreDsl.g:2978:4: (otherlv_1= RULE_ID )
                    // InternalCoreDsl.g:2979:5: otherlv_1= RULE_ID
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
    // InternalCoreDsl.g:2994:1: entryRuleEnumSpecifier returns [EObject current=null] : iv_ruleEnumSpecifier= ruleEnumSpecifier EOF ;
    public final EObject entryRuleEnumSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumSpecifier = null;


        try {
            // InternalCoreDsl.g:2994:54: (iv_ruleEnumSpecifier= ruleEnumSpecifier EOF )
            // InternalCoreDsl.g:2995:2: iv_ruleEnumSpecifier= ruleEnumSpecifier EOF
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
    // InternalCoreDsl.g:3001:1: ruleEnumSpecifier returns [EObject current=null] : ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) ) ;
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
            // InternalCoreDsl.g:3007:2: ( ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:3008:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:3008:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==61) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==RULE_ID) ) {
                    int LA64_2 = input.LA(3);

                    if ( (LA64_2==23) ) {
                        alt64=1;
                    }
                    else if ( (LA64_2==EOF||LA64_2==RULE_ID||LA64_2==32||LA64_2==37||LA64_2==42||(LA64_2>=45 && LA64_2<=46)||LA64_2==59) ) {
                        alt64=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA64_1==23) ) {
                    alt64=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalCoreDsl.g:3009:3: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' )
                    {
                    // InternalCoreDsl.g:3009:3: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' )
                    // InternalCoreDsl.g:3010:4: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}'
                    {
                    otherlv_0=(Token)match(input,61,FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getEnumSpecifierAccess().getEnumKeyword_0_0());
                      			
                    }
                    // InternalCoreDsl.g:3014:4: ( (lv_name_1_0= RULE_ID ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==RULE_ID) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalCoreDsl.g:3015:5: (lv_name_1_0= RULE_ID )
                            {
                            // InternalCoreDsl.g:3015:5: (lv_name_1_0= RULE_ID )
                            // InternalCoreDsl.g:3016:6: lv_name_1_0= RULE_ID
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

                    otherlv_2=(Token)match(input,23,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEnumSpecifierAccess().getLeftCurlyBracketKeyword_0_2());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getEnumSpecifierRule());
                      				}
                      				newCompositeNode(grammarAccess.getEnumSpecifierAccess().getEnumeratorListParserRuleCall_0_3());
                      			
                    }
                    pushFollow(FOLLOW_64);
                    this_EnumeratorList_3=ruleEnumeratorList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_EnumeratorList_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:3047:4: (otherlv_4= ',' )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==32) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // InternalCoreDsl.g:3048:5: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,32,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getEnumSpecifierAccess().getCommaKeyword_0_4());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getEnumSpecifierAccess().getRightCurlyBracketKeyword_0_5());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3059:3: (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:3059:3: (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:3060:4: otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,61,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getEnumSpecifierAccess().getEnumKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3064:4: ( (lv_name_7_0= RULE_ID ) )
                    // InternalCoreDsl.g:3065:5: (lv_name_7_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3065:5: (lv_name_7_0= RULE_ID )
                    // InternalCoreDsl.g:3066:6: lv_name_7_0= RULE_ID
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
    // InternalCoreDsl.g:3088:1: ruleEnumeratorList[EObject in_current] returns [EObject current=in_current] : ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* ) ;
    public final EObject ruleEnumeratorList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_enumerators_0_0 = null;

        EObject lv_enumerators_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3094:2: ( ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* ) )
            // InternalCoreDsl.g:3095:2: ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* )
            {
            // InternalCoreDsl.g:3095:2: ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* )
            // InternalCoreDsl.g:3096:3: ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )*
            {
            // InternalCoreDsl.g:3096:3: ( (lv_enumerators_0_0= ruleEnumerator ) )
            // InternalCoreDsl.g:3097:4: (lv_enumerators_0_0= ruleEnumerator )
            {
            // InternalCoreDsl.g:3097:4: (lv_enumerators_0_0= ruleEnumerator )
            // InternalCoreDsl.g:3098:5: lv_enumerators_0_0= ruleEnumerator
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

            // InternalCoreDsl.g:3115:3: (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==32) ) {
                    int LA65_1 = input.LA(2);

                    if ( (LA65_1==RULE_ID) ) {
                        alt65=1;
                    }


                }


                switch (alt65) {
            	case 1 :
            	    // InternalCoreDsl.g:3116:4: otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) )
            	    {
            	    otherlv_1=(Token)match(input,32,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getEnumeratorListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3120:4: ( (lv_enumerators_2_0= ruleEnumerator ) )
            	    // InternalCoreDsl.g:3121:5: (lv_enumerators_2_0= ruleEnumerator )
            	    {
            	    // InternalCoreDsl.g:3121:5: (lv_enumerators_2_0= ruleEnumerator )
            	    // InternalCoreDsl.g:3122:6: lv_enumerators_2_0= ruleEnumerator
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
            	    break loop65;
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
    // InternalCoreDsl.g:3144:1: entryRuleEnumerator returns [EObject current=null] : iv_ruleEnumerator= ruleEnumerator EOF ;
    public final EObject entryRuleEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerator = null;


        try {
            // InternalCoreDsl.g:3144:51: (iv_ruleEnumerator= ruleEnumerator EOF )
            // InternalCoreDsl.g:3145:2: iv_ruleEnumerator= ruleEnumerator EOF
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
    // InternalCoreDsl.g:3151:1: ruleEnumerator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) ) ;
    public final EObject ruleEnumerator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3157:2: ( ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) ) )
            // InternalCoreDsl.g:3158:2: ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) )
            {
            // InternalCoreDsl.g:3158:2: ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==62) ) {
                    alt66=2;
                }
                else if ( (LA66_1==EOF||LA66_1==25||LA66_1==32) ) {
                    alt66=1;
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
                    // InternalCoreDsl.g:3159:3: ( (lv_name_0_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:3159:3: ( (lv_name_0_0= RULE_ID ) )
                    // InternalCoreDsl.g:3160:4: (lv_name_0_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3160:4: (lv_name_0_0= RULE_ID )
                    // InternalCoreDsl.g:3161:5: lv_name_0_0= RULE_ID
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
                    // InternalCoreDsl.g:3178:3: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) )
                    {
                    // InternalCoreDsl.g:3178:3: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) )
                    // InternalCoreDsl.g:3179:4: ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) )
                    {
                    // InternalCoreDsl.g:3179:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalCoreDsl.g:3180:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3180:5: (lv_name_1_0= RULE_ID )
                    // InternalCoreDsl.g:3181:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_65); if (state.failed) return current;
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

                    otherlv_2=(Token)match(input,62,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:3201:4: ( (lv_expression_3_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:3202:5: (lv_expression_3_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:3202:5: (lv_expression_3_0= ruleConstantExpression )
                    // InternalCoreDsl.g:3203:6: lv_expression_3_0= ruleConstantExpression
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
    // InternalCoreDsl.g:3225:1: entryRuleStructOrUnionSpecifier returns [EObject current=null] : iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF ;
    public final EObject entryRuleStructOrUnionSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructOrUnionSpecifier = null;


        try {
            // InternalCoreDsl.g:3225:63: (iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF )
            // InternalCoreDsl.g:3226:2: iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF
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
    // InternalCoreDsl.g:3232:1: ruleStructOrUnionSpecifier returns [EObject current=null] : ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) ) ;
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
            // InternalCoreDsl.g:3238:2: ( ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:3239:2: ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:3239:2: ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==125) ) {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==RULE_ID) ) {
                    int LA69_3 = input.LA(3);

                    if ( (LA69_3==EOF||LA69_3==RULE_ID||LA69_3==32||LA69_3==37||LA69_3==42||(LA69_3>=45 && LA69_3<=46)||LA69_3==59) ) {
                        alt69=2;
                    }
                    else if ( (LA69_3==23) ) {
                        alt69=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA69_1==23) ) {
                    alt69=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA69_0==126) ) {
                int LA69_2 = input.LA(2);

                if ( (LA69_2==RULE_ID) ) {
                    int LA69_3 = input.LA(3);

                    if ( (LA69_3==EOF||LA69_3==RULE_ID||LA69_3==32||LA69_3==37||LA69_3==42||(LA69_3>=45 && LA69_3<=46)||LA69_3==59) ) {
                        alt69=2;
                    }
                    else if ( (LA69_3==23) ) {
                        alt69=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA69_2==23) ) {
                    alt69=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalCoreDsl.g:3240:3: ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' )
                    {
                    // InternalCoreDsl.g:3240:3: ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' )
                    // InternalCoreDsl.g:3241:4: ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}'
                    {
                    // InternalCoreDsl.g:3241:4: ( (lv_composeType_0_0= ruleStructOrUnion ) )
                    // InternalCoreDsl.g:3242:5: (lv_composeType_0_0= ruleStructOrUnion )
                    {
                    // InternalCoreDsl.g:3242:5: (lv_composeType_0_0= ruleStructOrUnion )
                    // InternalCoreDsl.g:3243:6: lv_composeType_0_0= ruleStructOrUnion
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStructOrUnionSpecifierAccess().getComposeTypeStructOrUnionEnumRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_63);
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

                    // InternalCoreDsl.g:3260:4: ( (lv_name_1_0= RULE_ID ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==RULE_ID) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalCoreDsl.g:3261:5: (lv_name_1_0= RULE_ID )
                            {
                            // InternalCoreDsl.g:3261:5: (lv_name_1_0= RULE_ID )
                            // InternalCoreDsl.g:3262:6: lv_name_1_0= RULE_ID
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

                    otherlv_2=(Token)match(input,23,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getStructOrUnionSpecifierAccess().getLeftCurlyBracketKeyword_0_2());
                      			
                    }
                    // InternalCoreDsl.g:3282:4: ( (lv_decls_3_0= ruleStructDeclaration ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==RULE_ID||LA68_0==61||(LA68_0>=105 && LA68_0<=117)||(LA68_0>=125 && LA68_0<=126)) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalCoreDsl.g:3283:5: (lv_decls_3_0= ruleStructDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:3283:5: (lv_decls_3_0= ruleStructDeclaration )
                    	    // InternalCoreDsl.g:3284:6: lv_decls_3_0= ruleStructDeclaration
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
                    	    break loop68;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getStructOrUnionSpecifierAccess().getRightCurlyBracketKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3307:3: ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:3307:3: ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:3308:4: ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:3308:4: ( (lv_composeType_5_0= ruleStructOrUnion ) )
                    // InternalCoreDsl.g:3309:5: (lv_composeType_5_0= ruleStructOrUnion )
                    {
                    // InternalCoreDsl.g:3309:5: (lv_composeType_5_0= ruleStructOrUnion )
                    // InternalCoreDsl.g:3310:6: lv_composeType_5_0= ruleStructOrUnion
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

                    // InternalCoreDsl.g:3327:4: ( (lv_name_6_0= RULE_ID ) )
                    // InternalCoreDsl.g:3328:5: (lv_name_6_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3328:5: (lv_name_6_0= RULE_ID )
                    // InternalCoreDsl.g:3329:6: lv_name_6_0= RULE_ID
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
    // InternalCoreDsl.g:3350:1: entryRuleStructDeclaration returns [EObject current=null] : iv_ruleStructDeclaration= ruleStructDeclaration EOF ;
    public final EObject entryRuleStructDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructDeclaration = null;


        try {
            // InternalCoreDsl.g:3350:58: (iv_ruleStructDeclaration= ruleStructDeclaration EOF )
            // InternalCoreDsl.g:3351:2: iv_ruleStructDeclaration= ruleStructDeclaration EOF
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
    // InternalCoreDsl.g:3357:1: ruleStructDeclaration returns [EObject current=null] : ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleStructDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_specifier_0_0 = null;

        EObject lv_decls_1_0 = null;

        EObject lv_decls_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3363:2: ( ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' ) )
            // InternalCoreDsl.g:3364:2: ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' )
            {
            // InternalCoreDsl.g:3364:2: ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' )
            // InternalCoreDsl.g:3365:3: ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';'
            {
            // InternalCoreDsl.g:3365:3: ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) )
            // InternalCoreDsl.g:3366:4: (lv_specifier_0_0= ruleStructDeclarationSpecifier )
            {
            // InternalCoreDsl.g:3366:4: (lv_specifier_0_0= ruleStructDeclarationSpecifier )
            // InternalCoreDsl.g:3367:5: lv_specifier_0_0= ruleStructDeclarationSpecifier
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

            // InternalCoreDsl.g:3384:3: ( (lv_decls_1_0= ruleDirectDeclarator ) )
            // InternalCoreDsl.g:3385:4: (lv_decls_1_0= ruleDirectDeclarator )
            {
            // InternalCoreDsl.g:3385:4: (lv_decls_1_0= ruleDirectDeclarator )
            // InternalCoreDsl.g:3386:5: lv_decls_1_0= ruleDirectDeclarator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStructDeclarationAccess().getDeclsDirectDeclaratorParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_56);
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

            // InternalCoreDsl.g:3403:3: (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==32) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalCoreDsl.g:3404:4: otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) )
            	    {
            	    otherlv_2=(Token)match(input,32,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getStructDeclarationAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3408:4: ( (lv_decls_3_0= ruleDirectDeclarator ) )
            	    // InternalCoreDsl.g:3409:5: (lv_decls_3_0= ruleDirectDeclarator )
            	    {
            	    // InternalCoreDsl.g:3409:5: (lv_decls_3_0= ruleDirectDeclarator )
            	    // InternalCoreDsl.g:3410:6: lv_decls_3_0= ruleDirectDeclarator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getStructDeclarationAccess().getDeclsDirectDeclaratorParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
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
            	    break loop70;
                }
            } while (true);

            otherlv_4=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:3436:1: entryRuleStructDeclarationSpecifier returns [EObject current=null] : iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF ;
    public final EObject entryRuleStructDeclarationSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructDeclarationSpecifier = null;


        try {
            // InternalCoreDsl.g:3436:67: (iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF )
            // InternalCoreDsl.g:3437:2: iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF
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
    // InternalCoreDsl.g:3443:1: ruleStructDeclarationSpecifier returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) ) ;
    public final EObject ruleStructDeclarationSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        Enumerator lv_qualifiers_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3449:2: ( ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) ) )
            // InternalCoreDsl.g:3450:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) )
            {
            // InternalCoreDsl.g:3450:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ID||LA71_0==61||(LA71_0>=105 && LA71_0<=115)||(LA71_0>=125 && LA71_0<=126)) ) {
                alt71=1;
            }
            else if ( ((LA71_0>=116 && LA71_0<=117)) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalCoreDsl.g:3451:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
                    {
                    // InternalCoreDsl.g:3451:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
                    // InternalCoreDsl.g:3452:4: (lv_type_0_0= ruleTypeSpecifier )
                    {
                    // InternalCoreDsl.g:3452:4: (lv_type_0_0= ruleTypeSpecifier )
                    // InternalCoreDsl.g:3453:5: lv_type_0_0= ruleTypeSpecifier
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
                    // InternalCoreDsl.g:3471:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    {
                    // InternalCoreDsl.g:3471:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    // InternalCoreDsl.g:3472:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    {
                    // InternalCoreDsl.g:3472:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    // InternalCoreDsl.g:3473:5: lv_qualifiers_1_0= ruleTypeQualifier
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
    // InternalCoreDsl.g:3494:1: entryRuleInitDeclarator returns [EObject current=null] : iv_ruleInitDeclarator= ruleInitDeclarator EOF ;
    public final EObject entryRuleInitDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitDeclarator = null;


        try {
            // InternalCoreDsl.g:3494:55: (iv_ruleInitDeclarator= ruleInitDeclarator EOF )
            // InternalCoreDsl.g:3495:2: iv_ruleInitDeclarator= ruleInitDeclarator EOF
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
    // InternalCoreDsl.g:3501:1: ruleInitDeclarator returns [EObject current=null] : ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? ) ;
    public final EObject ruleInitDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_declarator_0_0 = null;

        EObject lv_initializer_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3507:2: ( ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? ) )
            // InternalCoreDsl.g:3508:2: ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? )
            {
            // InternalCoreDsl.g:3508:2: ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? )
            // InternalCoreDsl.g:3509:3: ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )?
            {
            // InternalCoreDsl.g:3509:3: ( (lv_declarator_0_0= ruleDirectDeclarator ) )
            // InternalCoreDsl.g:3510:4: (lv_declarator_0_0= ruleDirectDeclarator )
            {
            // InternalCoreDsl.g:3510:4: (lv_declarator_0_0= ruleDirectDeclarator )
            // InternalCoreDsl.g:3511:5: lv_declarator_0_0= ruleDirectDeclarator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInitDeclaratorAccess().getDeclaratorDirectDeclaratorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_66);
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

            // InternalCoreDsl.g:3528:3: (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==62) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalCoreDsl.g:3529:4: otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) )
                    {
                    otherlv_1=(Token)match(input,62,FOLLOW_67); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInitDeclaratorAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3533:4: ( (lv_initializer_2_0= ruleInitializer ) )
                    // InternalCoreDsl.g:3534:5: (lv_initializer_2_0= ruleInitializer )
                    {
                    // InternalCoreDsl.g:3534:5: (lv_initializer_2_0= ruleInitializer )
                    // InternalCoreDsl.g:3535:6: lv_initializer_2_0= ruleInitializer
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
    // InternalCoreDsl.g:3557:1: entryRuleDirectDeclarator returns [EObject current=null] : iv_ruleDirectDeclarator= ruleDirectDeclarator EOF ;
    public final EObject entryRuleDirectDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectDeclarator = null;


        try {
            // InternalCoreDsl.g:3557:57: (iv_ruleDirectDeclarator= ruleDirectDeclarator EOF )
            // InternalCoreDsl.g:3558:2: iv_ruleDirectDeclarator= ruleDirectDeclarator EOF
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
    // InternalCoreDsl.g:3564:1: ruleDirectDeclarator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )? ) ;
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
            // InternalCoreDsl.g:3570:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )? ) )
            // InternalCoreDsl.g:3571:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )? )
            {
            // InternalCoreDsl.g:3571:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )? )
            // InternalCoreDsl.g:3572:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )?
            {
            // InternalCoreDsl.g:3572:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:3573:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:3573:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:3574:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_68); if (state.failed) return current;
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

            // InternalCoreDsl.g:3590:3: (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==36) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalCoreDsl.g:3591:4: otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) )
                    {
                    otherlv_1=(Token)match(input,36,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectDeclaratorAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3595:4: ( (lv_index_2_0= ruleIntegerConstant ) )
                    // InternalCoreDsl.g:3596:5: (lv_index_2_0= ruleIntegerConstant )
                    {
                    // InternalCoreDsl.g:3596:5: (lv_index_2_0= ruleIntegerConstant )
                    // InternalCoreDsl.g:3597:6: lv_index_2_0= ruleIntegerConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getIndexIntegerConstantParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_69);
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

            // InternalCoreDsl.g:3615:3: ( () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==42) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalCoreDsl.g:3616:4: () otherlv_4= '[' ( (lv_qualifiers_5_0= ruleTypeQualifier ) )? ( (lv_expr_6_0= ruleConditionalExpression ) )? otherlv_7= ']'
                    {
                    // InternalCoreDsl.g:3616:4: ()
                    // InternalCoreDsl.g:3617:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getDirectDeclaratorAccess().getDirectDeclaratorLeftAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_4=(Token)match(input,42,FOLLOW_70); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDirectDeclaratorAccess().getLeftSquareBracketKeyword_2_1());
                      			
                    }
                    // InternalCoreDsl.g:3627:4: ( (lv_qualifiers_5_0= ruleTypeQualifier ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( ((LA74_0>=116 && LA74_0<=117)) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalCoreDsl.g:3628:5: (lv_qualifiers_5_0= ruleTypeQualifier )
                            {
                            // InternalCoreDsl.g:3628:5: (lv_qualifiers_5_0= ruleTypeQualifier )
                            // InternalCoreDsl.g:3629:6: lv_qualifiers_5_0= ruleTypeQualifier
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getQualifiersTypeQualifierEnumRuleCall_2_2_0());
                              					
                            }
                            pushFollow(FOLLOW_71);
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

                    // InternalCoreDsl.g:3646:4: ( (lv_expr_6_0= ruleConditionalExpression ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( ((LA75_0>=RULE_STRING && LA75_0<=RULE_ID)||(LA75_0>=RULE_NATURAL && LA75_0<=RULE_CHARCONST)||LA75_0==45||LA75_0==78||(LA75_0>=85 && LA75_0<=87)||(LA75_0>=90 && LA75_0<=94)||(LA75_0>=96 && LA75_0<=99)) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalCoreDsl.g:3647:5: (lv_expr_6_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:3647:5: (lv_expr_6_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:3648:6: lv_expr_6_0= ruleConditionalExpression
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

                    otherlv_7=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "ruleInitializerList"
    // InternalCoreDsl.g:3675:1: ruleInitializerList[EObject in_current] returns [EObject current=in_current] : ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )? ) ;
    public final EObject ruleInitializerList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_init_0_1 = null;

        EObject lv_init_0_2 = null;

        EObject lv_init_2_1 = null;

        EObject lv_init_2_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3681:2: ( ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )? ) )
            // InternalCoreDsl.g:3682:2: ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )? )
            {
            // InternalCoreDsl.g:3682:2: ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )? )
            // InternalCoreDsl.g:3683:3: ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )?
            {
            // InternalCoreDsl.g:3683:3: ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) )
            // InternalCoreDsl.g:3684:4: ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) )
            {
            // InternalCoreDsl.g:3684:4: ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) )
            // InternalCoreDsl.g:3685:5: (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer )
            {
            // InternalCoreDsl.g:3685:5: (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==42||LA77_0==63) ) {
                alt77=1;
            }
            else if ( ((LA77_0>=RULE_STRING && LA77_0<=RULE_ID)||(LA77_0>=RULE_NATURAL && LA77_0<=RULE_CHARCONST)||LA77_0==23||LA77_0==45||LA77_0==78||(LA77_0>=85 && LA77_0<=87)||(LA77_0>=90 && LA77_0<=94)||(LA77_0>=96 && LA77_0<=99)) ) {
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
                    // InternalCoreDsl.g:3686:6: lv_init_0_1= ruleDesignatedInitializer
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
                    // InternalCoreDsl.g:3702:6: lv_init_0_2= ruleInitializer
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

            // InternalCoreDsl.g:3720:3: (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==32) ) {
                int LA79_1 = input.LA(2);

                if ( ((LA79_1>=RULE_STRING && LA79_1<=RULE_ID)||(LA79_1>=RULE_NATURAL && LA79_1<=RULE_CHARCONST)||LA79_1==23||LA79_1==42||LA79_1==45||LA79_1==63||LA79_1==78||(LA79_1>=85 && LA79_1<=87)||(LA79_1>=90 && LA79_1<=94)||(LA79_1>=96 && LA79_1<=99)) ) {
                    alt79=1;
                }
            }
            switch (alt79) {
                case 1 :
                    // InternalCoreDsl.g:3721:4: otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) )
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInitializerListAccess().getCommaKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3725:4: ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) )
                    // InternalCoreDsl.g:3726:5: ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) )
                    {
                    // InternalCoreDsl.g:3726:5: ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) )
                    // InternalCoreDsl.g:3727:6: (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer )
                    {
                    // InternalCoreDsl.g:3727:6: (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer )
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==42||LA78_0==63) ) {
                        alt78=1;
                    }
                    else if ( ((LA78_0>=RULE_STRING && LA78_0<=RULE_ID)||(LA78_0>=RULE_NATURAL && LA78_0<=RULE_CHARCONST)||LA78_0==23||LA78_0==45||LA78_0==78||(LA78_0>=85 && LA78_0<=87)||(LA78_0>=90 && LA78_0<=94)||(LA78_0>=96 && LA78_0<=99)) ) {
                        alt78=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 78, 0, input);

                        throw nvae;
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalCoreDsl.g:3728:7: lv_init_2_1= ruleDesignatedInitializer
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getInitializerListAccess().getInitDesignatedInitializerParserRuleCall_1_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
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
                            // InternalCoreDsl.g:3744:7: lv_init_2_2= ruleInitializer
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getInitializerListAccess().getInitInitializerParserRuleCall_1_1_0_1());
                              						
                            }
                            pushFollow(FOLLOW_2);
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
    // $ANTLR end "ruleInitializerList"


    // $ANTLR start "entryRuleInitializer"
    // InternalCoreDsl.g:3767:1: entryRuleInitializer returns [EObject current=null] : iv_ruleInitializer= ruleInitializer EOF ;
    public final EObject entryRuleInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitializer = null;


        try {
            // InternalCoreDsl.g:3767:52: (iv_ruleInitializer= ruleInitializer EOF )
            // InternalCoreDsl.g:3768:2: iv_ruleInitializer= ruleInitializer EOF
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
    // InternalCoreDsl.g:3774:1: ruleInitializer returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) ) ;
    public final EObject ruleInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expr_0_0 = null;

        EObject this_InitializerList_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3780:2: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) ) )
            // InternalCoreDsl.g:3781:2: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) )
            {
            // InternalCoreDsl.g:3781:2: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=RULE_STRING && LA81_0<=RULE_ID)||(LA81_0>=RULE_NATURAL && LA81_0<=RULE_CHARCONST)||LA81_0==45||LA81_0==78||(LA81_0>=85 && LA81_0<=87)||(LA81_0>=90 && LA81_0<=94)||(LA81_0>=96 && LA81_0<=99)) ) {
                alt81=1;
            }
            else if ( (LA81_0==23) ) {
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
                    // InternalCoreDsl.g:3782:3: ( (lv_expr_0_0= ruleConditionalExpression ) )
                    {
                    // InternalCoreDsl.g:3782:3: ( (lv_expr_0_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:3783:4: (lv_expr_0_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:3783:4: (lv_expr_0_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:3784:5: lv_expr_0_0= ruleConditionalExpression
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
                    // InternalCoreDsl.g:3802:3: (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' )
                    {
                    // InternalCoreDsl.g:3802:3: (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' )
                    // InternalCoreDsl.g:3803:4: otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}'
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInitializerAccess().getLeftCurlyBracketKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getInitializerRule());
                      				}
                      				newCompositeNode(grammarAccess.getInitializerAccess().getInitializerListParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_64);
                    this_InitializerList_2=ruleInitializerList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_InitializerList_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:3818:4: (otherlv_3= ',' )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==32) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // InternalCoreDsl.g:3819:5: otherlv_3= ','
                            {
                            otherlv_3=(Token)match(input,32,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getInitializerAccess().getCommaKeyword_1_2());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDesignatedInitializer"
    // InternalCoreDsl.g:3833:1: entryRuleDesignatedInitializer returns [EObject current=null] : iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF ;
    public final EObject entryRuleDesignatedInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesignatedInitializer = null;


        try {
            // InternalCoreDsl.g:3833:62: (iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF )
            // InternalCoreDsl.g:3834:2: iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF
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
    // InternalCoreDsl.g:3840:1: ruleDesignatedInitializer returns [EObject current=null] : ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) ) ;
    public final EObject ruleDesignatedInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_designators_0_0 = null;

        EObject lv_init_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3846:2: ( ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) ) )
            // InternalCoreDsl.g:3847:2: ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) )
            {
            // InternalCoreDsl.g:3847:2: ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) )
            // InternalCoreDsl.g:3848:3: ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) )
            {
            // InternalCoreDsl.g:3848:3: ( (lv_designators_0_0= ruleDesignator ) )+
            int cnt82=0;
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==42||LA82_0==63) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalCoreDsl.g:3849:4: (lv_designators_0_0= ruleDesignator )
            	    {
            	    // InternalCoreDsl.g:3849:4: (lv_designators_0_0= ruleDesignator )
            	    // InternalCoreDsl.g:3850:5: lv_designators_0_0= ruleDesignator
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDesignatedInitializerAccess().getDesignatorsDesignatorParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_73);
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
            	    if ( cnt82 >= 1 ) break loop82;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(82, input);
                        throw eee;
                }
                cnt82++;
            } while (true);

            otherlv_1=(Token)match(input,62,FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDesignatedInitializerAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalCoreDsl.g:3871:3: ( (lv_init_2_0= ruleInitializer ) )
            // InternalCoreDsl.g:3872:4: (lv_init_2_0= ruleInitializer )
            {
            // InternalCoreDsl.g:3872:4: (lv_init_2_0= ruleInitializer )
            // InternalCoreDsl.g:3873:5: lv_init_2_0= ruleInitializer
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
    // InternalCoreDsl.g:3894:1: entryRuleDesignator returns [EObject current=null] : iv_ruleDesignator= ruleDesignator EOF ;
    public final EObject entryRuleDesignator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesignator = null;


        try {
            // InternalCoreDsl.g:3894:51: (iv_ruleDesignator= ruleDesignator EOF )
            // InternalCoreDsl.g:3895:2: iv_ruleDesignator= ruleDesignator EOF
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
    // InternalCoreDsl.g:3901:1: ruleDesignator returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) ) ;
    public final EObject ruleDesignator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_prop_4_0=null;
        EObject lv_idx_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3907:2: ( ( (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:3908:2: ( (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:3908:2: ( (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==42) ) {
                alt83=1;
            }
            else if ( (LA83_0==63) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // InternalCoreDsl.g:3909:3: (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' )
                    {
                    // InternalCoreDsl.g:3909:3: (otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']' )
                    // InternalCoreDsl.g:3910:4: otherlv_0= '[' ( (lv_idx_1_0= ruleConstantExpression ) ) otherlv_2= ']'
                    {
                    otherlv_0=(Token)match(input,42,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getDesignatorAccess().getLeftSquareBracketKeyword_0_0());
                      			
                    }
                    // InternalCoreDsl.g:3914:4: ( (lv_idx_1_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:3915:5: (lv_idx_1_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:3915:5: (lv_idx_1_0= ruleConstantExpression )
                    // InternalCoreDsl.g:3916:6: lv_idx_1_0= ruleConstantExpression
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

                    otherlv_2=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getDesignatorAccess().getRightSquareBracketKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3939:3: (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:3939:3: (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:3940:4: otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,63,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDesignatorAccess().getFullStopKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3944:4: ( (lv_prop_4_0= RULE_ID ) )
                    // InternalCoreDsl.g:3945:5: (lv_prop_4_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3945:5: (lv_prop_4_0= RULE_ID )
                    // InternalCoreDsl.g:3946:6: lv_prop_4_0= RULE_ID
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
    // InternalCoreDsl.g:3967:1: entryRuleAbstractDeclarator returns [EObject current=null] : iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF ;
    public final EObject entryRuleAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractDeclarator = null;


        try {
            // InternalCoreDsl.g:3967:59: (iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF )
            // InternalCoreDsl.g:3968:2: iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF
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
    // InternalCoreDsl.g:3974:1: ruleAbstractDeclarator returns [EObject current=null] : this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator ;
    public final EObject ruleAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject this_DirectAbstractDeclarator_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3980:2: (this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator )
            // InternalCoreDsl.g:3981:2: this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator
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
    // InternalCoreDsl.g:3992:1: entryRuleDirectAbstractDeclarator returns [EObject current=null] : iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF ;
    public final EObject entryRuleDirectAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectAbstractDeclarator = null;


        try {
            // InternalCoreDsl.g:3992:65: (iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF )
            // InternalCoreDsl.g:3993:2: iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF
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
    // InternalCoreDsl.g:3999:1: ruleDirectAbstractDeclarator returns [EObject current=null] : ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' ) ) ;
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
            // InternalCoreDsl.g:4005:2: ( ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' ) ) )
            // InternalCoreDsl.g:4006:2: ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' ) )
            {
            // InternalCoreDsl.g:4006:2: ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==45) ) {
                alt87=1;
            }
            else if ( (LA87_0==42) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalCoreDsl.g:4007:3: ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' )
                    {
                    // InternalCoreDsl.g:4007:3: ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' )
                    // InternalCoreDsl.g:4008:4: () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')'
                    {
                    // InternalCoreDsl.g:4008:4: ()
                    // InternalCoreDsl.g:4009:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDirectAbstractDeclaratorAccess().getDirectAbstractDeclaratorAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,45,FOLLOW_74); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectAbstractDeclaratorAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalCoreDsl.g:4019:4: ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] )
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==42||(LA85_0>=45 && LA85_0<=46)) ) {
                        alt85=1;
                    }
                    else if ( (LA85_0==RULE_ID||LA85_0==61||(LA85_0>=105 && LA85_0<=115)||(LA85_0>=125 && LA85_0<=126)) ) {
                        alt85=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 85, 0, input);

                        throw nvae;
                    }
                    switch (alt85) {
                        case 1 :
                            // InternalCoreDsl.g:4020:5: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )?
                            {
                            // InternalCoreDsl.g:4020:5: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )?
                            int alt84=2;
                            int LA84_0 = input.LA(1);

                            if ( (LA84_0==42||LA84_0==45) ) {
                                alt84=1;
                            }
                            switch (alt84) {
                                case 1 :
                                    // InternalCoreDsl.g:4021:6: (lv_declarator_2_0= ruleAbstractDeclarator )
                                    {
                                    // InternalCoreDsl.g:4021:6: (lv_declarator_2_0= ruleAbstractDeclarator )
                                    // InternalCoreDsl.g:4022:7: lv_declarator_2_0= ruleAbstractDeclarator
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
                            // InternalCoreDsl.g:4040:5: this_ParameterList_3= ruleParameterList[$current]
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

                    otherlv_4=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDirectAbstractDeclaratorAccess().getRightParenthesisKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4058:3: ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' )
                    {
                    // InternalCoreDsl.g:4058:3: ( () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']' )
                    // InternalCoreDsl.g:4059:4: () otherlv_6= '[' ( (lv_expr_7_0= ruleConstantExpression ) )? otherlv_8= ']'
                    {
                    // InternalCoreDsl.g:4059:4: ()
                    // InternalCoreDsl.g:4060:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDirectAbstractDeclaratorAccess().getDirectAbstractDeclaratorAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_6=(Token)match(input,42,FOLLOW_71); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getDirectAbstractDeclaratorAccess().getLeftSquareBracketKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:4070:4: ( (lv_expr_7_0= ruleConstantExpression ) )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( ((LA86_0>=RULE_STRING && LA86_0<=RULE_ID)||(LA86_0>=RULE_NATURAL && LA86_0<=RULE_CHARCONST)||LA86_0==45||LA86_0==78||(LA86_0>=85 && LA86_0<=87)||(LA86_0>=90 && LA86_0<=94)||(LA86_0>=96 && LA86_0<=99)) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalCoreDsl.g:4071:5: (lv_expr_7_0= ruleConstantExpression )
                            {
                            // InternalCoreDsl.g:4071:5: (lv_expr_7_0= ruleConstantExpression )
                            // InternalCoreDsl.g:4072:6: lv_expr_7_0= ruleConstantExpression
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

                    otherlv_8=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:4098:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalCoreDsl.g:4098:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalCoreDsl.g:4099:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalCoreDsl.g:4105:1: ruleExpression returns [EObject current=null] : (this_AssignmentExpression_0= ruleAssignmentExpression ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )? ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AssignmentExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4111:2: ( (this_AssignmentExpression_0= ruleAssignmentExpression ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )? ) )
            // InternalCoreDsl.g:4112:2: (this_AssignmentExpression_0= ruleAssignmentExpression ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )? )
            {
            // InternalCoreDsl.g:4112:2: (this_AssignmentExpression_0= ruleAssignmentExpression ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )? )
            // InternalCoreDsl.g:4113:3: this_AssignmentExpression_0= ruleAssignmentExpression ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )?
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
            // InternalCoreDsl.g:4121:3: ( () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==32) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalCoreDsl.g:4122:4: () otherlv_2= ',' ( (lv_right_3_0= ruleAssignmentExpression ) )
                    {
                    // InternalCoreDsl.g:4122:4: ()
                    // InternalCoreDsl.g:4123:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getExpressionAccess().getExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,32,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getCommaKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:4133:4: ( (lv_right_3_0= ruleAssignmentExpression ) )
                    // InternalCoreDsl.g:4134:5: (lv_right_3_0= ruleAssignmentExpression )
                    {
                    // InternalCoreDsl.g:4134:5: (lv_right_3_0= ruleAssignmentExpression )
                    // InternalCoreDsl.g:4135:6: lv_right_3_0= ruleAssignmentExpression
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
    // InternalCoreDsl.g:4157:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalCoreDsl.g:4157:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalCoreDsl.g:4158:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
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
    // InternalCoreDsl.g:4164:1: ruleAssignmentExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression () ( ( (lv_op_2_1= '=' | lv_op_2_2= '*=' | lv_op_2_3= '/=' | lv_op_2_4= '%=' | lv_op_2_5= '+=' | lv_op_2_6= '-=' | lv_op_2_7= '<<=' | lv_op_2_8= '>>=' | lv_op_2_9= '&=' | lv_op_2_10= '^=' | lv_op_2_11= '|=' ) ) ) ( (lv_right_3_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        Token lv_op_2_5=null;
        Token lv_op_2_6=null;
        Token lv_op_2_7=null;
        Token lv_op_2_8=null;
        Token lv_op_2_9=null;
        Token lv_op_2_10=null;
        Token lv_op_2_11=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4170:2: ( (this_UnaryExpression_0= ruleUnaryExpression () ( ( (lv_op_2_1= '=' | lv_op_2_2= '*=' | lv_op_2_3= '/=' | lv_op_2_4= '%=' | lv_op_2_5= '+=' | lv_op_2_6= '-=' | lv_op_2_7= '<<=' | lv_op_2_8= '>>=' | lv_op_2_9= '&=' | lv_op_2_10= '^=' | lv_op_2_11= '|=' ) ) ) ( (lv_right_3_0= ruleConditionalExpression ) ) ) )
            // InternalCoreDsl.g:4171:2: (this_UnaryExpression_0= ruleUnaryExpression () ( ( (lv_op_2_1= '=' | lv_op_2_2= '*=' | lv_op_2_3= '/=' | lv_op_2_4= '%=' | lv_op_2_5= '+=' | lv_op_2_6= '-=' | lv_op_2_7= '<<=' | lv_op_2_8= '>>=' | lv_op_2_9= '&=' | lv_op_2_10= '^=' | lv_op_2_11= '|=' ) ) ) ( (lv_right_3_0= ruleConditionalExpression ) ) )
            {
            // InternalCoreDsl.g:4171:2: (this_UnaryExpression_0= ruleUnaryExpression () ( ( (lv_op_2_1= '=' | lv_op_2_2= '*=' | lv_op_2_3= '/=' | lv_op_2_4= '%=' | lv_op_2_5= '+=' | lv_op_2_6= '-=' | lv_op_2_7= '<<=' | lv_op_2_8= '>>=' | lv_op_2_9= '&=' | lv_op_2_10= '^=' | lv_op_2_11= '|=' ) ) ) ( (lv_right_3_0= ruleConditionalExpression ) ) )
            // InternalCoreDsl.g:4172:3: this_UnaryExpression_0= ruleUnaryExpression () ( ( (lv_op_2_1= '=' | lv_op_2_2= '*=' | lv_op_2_3= '/=' | lv_op_2_4= '%=' | lv_op_2_5= '+=' | lv_op_2_6= '-=' | lv_op_2_7= '<<=' | lv_op_2_8= '>>=' | lv_op_2_9= '&=' | lv_op_2_10= '^=' | lv_op_2_11= '|=' ) ) ) ( (lv_right_3_0= ruleConditionalExpression ) )
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getUnaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_75);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_UnaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4180:3: ()
            // InternalCoreDsl.g:4181:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElementAndSet(
              					grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLeftAction_1(),
              					current);
              			
            }

            }

            // InternalCoreDsl.g:4187:3: ( ( (lv_op_2_1= '=' | lv_op_2_2= '*=' | lv_op_2_3= '/=' | lv_op_2_4= '%=' | lv_op_2_5= '+=' | lv_op_2_6= '-=' | lv_op_2_7= '<<=' | lv_op_2_8= '>>=' | lv_op_2_9= '&=' | lv_op_2_10= '^=' | lv_op_2_11= '|=' ) ) )
            // InternalCoreDsl.g:4188:4: ( (lv_op_2_1= '=' | lv_op_2_2= '*=' | lv_op_2_3= '/=' | lv_op_2_4= '%=' | lv_op_2_5= '+=' | lv_op_2_6= '-=' | lv_op_2_7= '<<=' | lv_op_2_8= '>>=' | lv_op_2_9= '&=' | lv_op_2_10= '^=' | lv_op_2_11= '|=' ) )
            {
            // InternalCoreDsl.g:4188:4: ( (lv_op_2_1= '=' | lv_op_2_2= '*=' | lv_op_2_3= '/=' | lv_op_2_4= '%=' | lv_op_2_5= '+=' | lv_op_2_6= '-=' | lv_op_2_7= '<<=' | lv_op_2_8= '>>=' | lv_op_2_9= '&=' | lv_op_2_10= '^=' | lv_op_2_11= '|=' ) )
            // InternalCoreDsl.g:4189:5: (lv_op_2_1= '=' | lv_op_2_2= '*=' | lv_op_2_3= '/=' | lv_op_2_4= '%=' | lv_op_2_5= '+=' | lv_op_2_6= '-=' | lv_op_2_7= '<<=' | lv_op_2_8= '>>=' | lv_op_2_9= '&=' | lv_op_2_10= '^=' | lv_op_2_11= '|=' )
            {
            // InternalCoreDsl.g:4189:5: (lv_op_2_1= '=' | lv_op_2_2= '*=' | lv_op_2_3= '/=' | lv_op_2_4= '%=' | lv_op_2_5= '+=' | lv_op_2_6= '-=' | lv_op_2_7= '<<=' | lv_op_2_8= '>>=' | lv_op_2_9= '&=' | lv_op_2_10= '^=' | lv_op_2_11= '|=' )
            int alt89=11;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt89=1;
                }
                break;
            case 64:
                {
                alt89=2;
                }
                break;
            case 65:
                {
                alt89=3;
                }
                break;
            case 66:
                {
                alt89=4;
                }
                break;
            case 67:
                {
                alt89=5;
                }
                break;
            case 68:
                {
                alt89=6;
                }
                break;
            case 69:
                {
                alt89=7;
                }
                break;
            case 70:
                {
                alt89=8;
                }
                break;
            case 71:
                {
                alt89=9;
                }
                break;
            case 72:
                {
                alt89=10;
                }
                break;
            case 73:
                {
                alt89=11;
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
                    // InternalCoreDsl.g:4190:6: lv_op_2_1= '='
                    {
                    lv_op_2_1=(Token)match(input,62,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_1, grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4201:6: lv_op_2_2= '*='
                    {
                    lv_op_2_2=(Token)match(input,64,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_2, grammarAccess.getAssignmentExpressionAccess().getOpAsteriskEqualsSignKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:4212:6: lv_op_2_3= '/='
                    {
                    lv_op_2_3=(Token)match(input,65,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_3, grammarAccess.getAssignmentExpressionAccess().getOpSolidusEqualsSignKeyword_2_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:4223:6: lv_op_2_4= '%='
                    {
                    lv_op_2_4=(Token)match(input,66,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_4, grammarAccess.getAssignmentExpressionAccess().getOpPercentSignEqualsSignKeyword_2_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_4, null);
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:4234:6: lv_op_2_5= '+='
                    {
                    lv_op_2_5=(Token)match(input,67,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_5, grammarAccess.getAssignmentExpressionAccess().getOpPlusSignEqualsSignKeyword_2_0_4());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_5, null);
                      					
                    }

                    }
                    break;
                case 6 :
                    // InternalCoreDsl.g:4245:6: lv_op_2_6= '-='
                    {
                    lv_op_2_6=(Token)match(input,68,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_6, grammarAccess.getAssignmentExpressionAccess().getOpHyphenMinusEqualsSignKeyword_2_0_5());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_6, null);
                      					
                    }

                    }
                    break;
                case 7 :
                    // InternalCoreDsl.g:4256:6: lv_op_2_7= '<<='
                    {
                    lv_op_2_7=(Token)match(input,69,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_7, grammarAccess.getAssignmentExpressionAccess().getOpLessThanSignLessThanSignEqualsSignKeyword_2_0_6());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_7, null);
                      					
                    }

                    }
                    break;
                case 8 :
                    // InternalCoreDsl.g:4267:6: lv_op_2_8= '>>='
                    {
                    lv_op_2_8=(Token)match(input,70,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_8, grammarAccess.getAssignmentExpressionAccess().getOpGreaterThanSignGreaterThanSignEqualsSignKeyword_2_0_7());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_8, null);
                      					
                    }

                    }
                    break;
                case 9 :
                    // InternalCoreDsl.g:4278:6: lv_op_2_9= '&='
                    {
                    lv_op_2_9=(Token)match(input,71,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_9, grammarAccess.getAssignmentExpressionAccess().getOpAmpersandEqualsSignKeyword_2_0_8());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_9, null);
                      					
                    }

                    }
                    break;
                case 10 :
                    // InternalCoreDsl.g:4289:6: lv_op_2_10= '^='
                    {
                    lv_op_2_10=(Token)match(input,72,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_10, grammarAccess.getAssignmentExpressionAccess().getOpCircumflexAccentEqualsSignKeyword_2_0_9());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_10, null);
                      					
                    }

                    }
                    break;
                case 11 :
                    // InternalCoreDsl.g:4300:6: lv_op_2_11= '|='
                    {
                    lv_op_2_11=(Token)match(input,73,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_11, grammarAccess.getAssignmentExpressionAccess().getOpVerticalLineEqualsSignKeyword_2_0_10());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_11, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalCoreDsl.g:4313:3: ( (lv_right_3_0= ruleConditionalExpression ) )
            // InternalCoreDsl.g:4314:4: (lv_right_3_0= ruleConditionalExpression )
            {
            // InternalCoreDsl.g:4314:4: (lv_right_3_0= ruleConditionalExpression )
            // InternalCoreDsl.g:4315:5: lv_right_3_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightConditionalExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_right_3_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
              					}
              					set(
              						current,
              						"right",
              						lv_right_3_0,
              						"com.minres.coredsl.CoreDsl.ConditionalExpression");
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
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // InternalCoreDsl.g:4336:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalCoreDsl.g:4336:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalCoreDsl.g:4337:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalCoreDsl.g:4343:1: ruleConditionalExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_left_3_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4349:2: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalCoreDsl.g:4350:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalCoreDsl.g:4350:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? )
            // InternalCoreDsl.g:4351:3: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_76);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4359:3: ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==74) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalCoreDsl.g:4360:4: () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) )
                    {
                    // InternalCoreDsl.g:4360:4: ()
                    // InternalCoreDsl.g:4361:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getConditionalExpressionAccess().getConditionalExpressionCondAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,74,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:4371:4: ( (lv_left_3_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:4372:5: (lv_left_3_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:4372:5: (lv_left_3_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:4373:6: lv_left_3_0= ruleConditionalExpression
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

                    otherlv_4=(Token)match(input,36,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                      			
                    }
                    // InternalCoreDsl.g:4394:4: ( (lv_right_5_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:4395:5: (lv_right_5_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:4395:5: (lv_right_5_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:4396:6: lv_right_5_0= ruleConditionalExpression
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
    // InternalCoreDsl.g:4418:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalCoreDsl.g:4418:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalCoreDsl.g:4419:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalCoreDsl.g:4425:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4431:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4432:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4432:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? )
            // InternalCoreDsl.g:4433:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_77);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4441:3: ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==75) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalCoreDsl.g:4442:4: () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) )
                    {
                    // InternalCoreDsl.g:4442:4: ()
                    // InternalCoreDsl.g:4443:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getLogicalOrExpressionAccess().getLogicalExprLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4449:4: ( (lv_op_2_0= '||' ) )
                    // InternalCoreDsl.g:4450:5: (lv_op_2_0= '||' )
                    {
                    // InternalCoreDsl.g:4450:5: (lv_op_2_0= '||' )
                    // InternalCoreDsl.g:4451:6: lv_op_2_0= '||'
                    {
                    lv_op_2_0=(Token)match(input,75,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4463:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
                    // InternalCoreDsl.g:4464:5: (lv_right_3_0= ruleLogicalOrExpression )
                    {
                    // InternalCoreDsl.g:4464:5: (lv_right_3_0= ruleLogicalOrExpression )
                    // InternalCoreDsl.g:4465:6: lv_right_3_0= ruleLogicalOrExpression
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
    // InternalCoreDsl.g:4487:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalCoreDsl.g:4487:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalCoreDsl.g:4488:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalCoreDsl.g:4494:1: ruleLogicalAndExpression returns [EObject current=null] : (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_InclusiveOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4500:2: ( (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? ) )
            // InternalCoreDsl.g:4501:2: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? )
            {
            // InternalCoreDsl.g:4501:2: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? )
            // InternalCoreDsl.g:4502:3: this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getInclusiveOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_78);
            this_InclusiveOrExpression_0=ruleInclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_InclusiveOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4510:3: ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==76) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalCoreDsl.g:4511:4: () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    {
                    // InternalCoreDsl.g:4511:4: ()
                    // InternalCoreDsl.g:4512:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getLogicalAndExpressionAccess().getLogicalExprLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4518:4: ( (lv_op_2_0= '&&' ) )
                    // InternalCoreDsl.g:4519:5: (lv_op_2_0= '&&' )
                    {
                    // InternalCoreDsl.g:4519:5: (lv_op_2_0= '&&' )
                    // InternalCoreDsl.g:4520:6: lv_op_2_0= '&&'
                    {
                    lv_op_2_0=(Token)match(input,76,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4532:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    // InternalCoreDsl.g:4533:5: (lv_right_3_0= ruleLogicalAndExpression )
                    {
                    // InternalCoreDsl.g:4533:5: (lv_right_3_0= ruleLogicalAndExpression )
                    // InternalCoreDsl.g:4534:6: lv_right_3_0= ruleLogicalAndExpression
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
    // InternalCoreDsl.g:4556:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalCoreDsl.g:4556:62: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalCoreDsl.g:4557:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
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
    // InternalCoreDsl.g:4563:1: ruleInclusiveOrExpression returns [EObject current=null] : (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_ExclusiveOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4569:2: ( (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4570:2: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4570:2: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? )
            // InternalCoreDsl.g:4571:3: this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )?
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
            // InternalCoreDsl.g:4579:3: ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==40) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalCoreDsl.g:4580:4: () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) )
                    {
                    // InternalCoreDsl.g:4580:4: ()
                    // InternalCoreDsl.g:4581:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getInclusiveOrExpressionAccess().getLogicalExprLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4587:4: ( (lv_op_2_0= '|' ) )
                    // InternalCoreDsl.g:4588:5: (lv_op_2_0= '|' )
                    {
                    // InternalCoreDsl.g:4588:5: (lv_op_2_0= '|' )
                    // InternalCoreDsl.g:4589:6: lv_op_2_0= '|'
                    {
                    lv_op_2_0=(Token)match(input,40,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4601:4: ( (lv_right_3_0= ruleInclusiveOrExpression ) )
                    // InternalCoreDsl.g:4602:5: (lv_right_3_0= ruleInclusiveOrExpression )
                    {
                    // InternalCoreDsl.g:4602:5: (lv_right_3_0= ruleInclusiveOrExpression )
                    // InternalCoreDsl.g:4603:6: lv_right_3_0= ruleInclusiveOrExpression
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
    // InternalCoreDsl.g:4625:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalCoreDsl.g:4625:62: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalCoreDsl.g:4626:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
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
    // InternalCoreDsl.g:4632:1: ruleExclusiveOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4638:2: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4639:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4639:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? )
            // InternalCoreDsl.g:4640:3: this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_79);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4648:3: ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==77) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalCoreDsl.g:4649:4: () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) )
                    {
                    // InternalCoreDsl.g:4649:4: ()
                    // InternalCoreDsl.g:4650:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getExclusiveOrExpressionAccess().getLogicalExprLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4656:4: ( (lv_op_2_0= '^' ) )
                    // InternalCoreDsl.g:4657:5: (lv_op_2_0= '^' )
                    {
                    // InternalCoreDsl.g:4657:5: (lv_op_2_0= '^' )
                    // InternalCoreDsl.g:4658:6: lv_op_2_0= '^'
                    {
                    lv_op_2_0=(Token)match(input,77,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4670:4: ( (lv_right_3_0= ruleExclusiveOrExpression ) )
                    // InternalCoreDsl.g:4671:5: (lv_right_3_0= ruleExclusiveOrExpression )
                    {
                    // InternalCoreDsl.g:4671:5: (lv_right_3_0= ruleExclusiveOrExpression )
                    // InternalCoreDsl.g:4672:6: lv_right_3_0= ruleExclusiveOrExpression
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
    // InternalCoreDsl.g:4694:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalCoreDsl.g:4694:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalCoreDsl.g:4695:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalCoreDsl.g:4701:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4707:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? ) )
            // InternalCoreDsl.g:4708:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? )
            {
            // InternalCoreDsl.g:4708:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? )
            // InternalCoreDsl.g:4709:3: this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_80);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4717:3: ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==78) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalCoreDsl.g:4718:4: () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) )
                    {
                    // InternalCoreDsl.g:4718:4: ()
                    // InternalCoreDsl.g:4719:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAndExpressionAccess().getLogicalExprLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4725:4: ( (lv_op_2_0= '&' ) )
                    // InternalCoreDsl.g:4726:5: (lv_op_2_0= '&' )
                    {
                    // InternalCoreDsl.g:4726:5: (lv_op_2_0= '&' )
                    // InternalCoreDsl.g:4727:6: lv_op_2_0= '&'
                    {
                    lv_op_2_0=(Token)match(input,78,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4739:4: ( (lv_right_3_0= ruleAndExpression ) )
                    // InternalCoreDsl.g:4740:5: (lv_right_3_0= ruleAndExpression )
                    {
                    // InternalCoreDsl.g:4740:5: (lv_right_3_0= ruleAndExpression )
                    // InternalCoreDsl.g:4741:6: lv_right_3_0= ruleAndExpression
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
    // InternalCoreDsl.g:4763:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalCoreDsl.g:4763:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalCoreDsl.g:4764:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalCoreDsl.g:4770:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4776:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? ) )
            // InternalCoreDsl.g:4777:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? )
            {
            // InternalCoreDsl.g:4777:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? )
            // InternalCoreDsl.g:4778:3: this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_81);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4786:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( ((LA97_0>=79 && LA97_0<=80)) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalCoreDsl.g:4787:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
                    {
                    // InternalCoreDsl.g:4787:4: ()
                    // InternalCoreDsl.g:4788:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getEqualityExpressionAccess().getLogicalExprLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4794:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
                    // InternalCoreDsl.g:4795:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
                    {
                    // InternalCoreDsl.g:4795:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
                    // InternalCoreDsl.g:4796:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
                    {
                    // InternalCoreDsl.g:4796:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==79) ) {
                        alt96=1;
                    }
                    else if ( (LA96_0==80) ) {
                        alt96=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 96, 0, input);

                        throw nvae;
                    }
                    switch (alt96) {
                        case 1 :
                            // InternalCoreDsl.g:4797:7: lv_op_2_1= '=='
                            {
                            lv_op_2_1=(Token)match(input,79,FOLLOW_45); if (state.failed) return current;
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
                            // InternalCoreDsl.g:4808:7: lv_op_2_2= '!='
                            {
                            lv_op_2_2=(Token)match(input,80,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4821:4: ( (lv_right_3_0= ruleEqualityExpression ) )
                    // InternalCoreDsl.g:4822:5: (lv_right_3_0= ruleEqualityExpression )
                    {
                    // InternalCoreDsl.g:4822:5: (lv_right_3_0= ruleEqualityExpression )
                    // InternalCoreDsl.g:4823:6: lv_right_3_0= ruleEqualityExpression
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
    // InternalCoreDsl.g:4845:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalCoreDsl.g:4845:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalCoreDsl.g:4846:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalCoreDsl.g:4852:1: ruleRelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? ) ;
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
            // InternalCoreDsl.g:4858:2: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? ) )
            // InternalCoreDsl.g:4859:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? )
            {
            // InternalCoreDsl.g:4859:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? )
            // InternalCoreDsl.g:4860:3: this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_82);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4868:3: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( ((LA99_0>=59 && LA99_0<=60)||(LA99_0>=81 && LA99_0<=82)) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalCoreDsl.g:4869:4: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
                    {
                    // InternalCoreDsl.g:4869:4: ()
                    // InternalCoreDsl.g:4870:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getRelationalExpressionAccess().getLogicalExprLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4876:4: ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
                    // InternalCoreDsl.g:4877:5: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
                    {
                    // InternalCoreDsl.g:4877:5: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
                    // InternalCoreDsl.g:4878:6: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
                    {
                    // InternalCoreDsl.g:4878:6: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
                    int alt98=4;
                    switch ( input.LA(1) ) {
                    case 59:
                        {
                        alt98=1;
                        }
                        break;
                    case 60:
                        {
                        alt98=2;
                        }
                        break;
                    case 81:
                        {
                        alt98=3;
                        }
                        break;
                    case 82:
                        {
                        alt98=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 98, 0, input);

                        throw nvae;
                    }

                    switch (alt98) {
                        case 1 :
                            // InternalCoreDsl.g:4879:7: lv_op_2_1= '<'
                            {
                            lv_op_2_1=(Token)match(input,59,FOLLOW_45); if (state.failed) return current;
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
                            // InternalCoreDsl.g:4890:7: lv_op_2_2= '>'
                            {
                            lv_op_2_2=(Token)match(input,60,FOLLOW_45); if (state.failed) return current;
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
                            // InternalCoreDsl.g:4901:7: lv_op_2_3= '<='
                            {
                            lv_op_2_3=(Token)match(input,81,FOLLOW_45); if (state.failed) return current;
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
                            // InternalCoreDsl.g:4912:7: lv_op_2_4= '>='
                            {
                            lv_op_2_4=(Token)match(input,82,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4925:4: ( (lv_right_3_0= ruleRelationalExpression ) )
                    // InternalCoreDsl.g:4926:5: (lv_right_3_0= ruleRelationalExpression )
                    {
                    // InternalCoreDsl.g:4926:5: (lv_right_3_0= ruleRelationalExpression )
                    // InternalCoreDsl.g:4927:6: lv_right_3_0= ruleRelationalExpression
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
    // InternalCoreDsl.g:4949:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalCoreDsl.g:4949:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalCoreDsl.g:4950:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalCoreDsl.g:4956:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4962:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? ) )
            // InternalCoreDsl.g:4963:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? )
            {
            // InternalCoreDsl.g:4963:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? )
            // InternalCoreDsl.g:4964:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_83);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4972:3: ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( ((LA101_0>=83 && LA101_0<=84)) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalCoreDsl.g:4973:4: () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) )
                    {
                    // InternalCoreDsl.g:4973:4: ()
                    // InternalCoreDsl.g:4974:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getShiftExpressionAccess().getArithmeticExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4980:4: ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) )
                    // InternalCoreDsl.g:4981:5: ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) )
                    {
                    // InternalCoreDsl.g:4981:5: ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) )
                    // InternalCoreDsl.g:4982:6: (lv_op_2_1= '<<' | lv_op_2_2= '>>' )
                    {
                    // InternalCoreDsl.g:4982:6: (lv_op_2_1= '<<' | lv_op_2_2= '>>' )
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==83) ) {
                        alt100=1;
                    }
                    else if ( (LA100_0==84) ) {
                        alt100=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 100, 0, input);

                        throw nvae;
                    }
                    switch (alt100) {
                        case 1 :
                            // InternalCoreDsl.g:4983:7: lv_op_2_1= '<<'
                            {
                            lv_op_2_1=(Token)match(input,83,FOLLOW_45); if (state.failed) return current;
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
                            // InternalCoreDsl.g:4994:7: lv_op_2_2= '>>'
                            {
                            lv_op_2_2=(Token)match(input,84,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5007:4: ( (lv_right_3_0= ruleShiftExpression ) )
                    // InternalCoreDsl.g:5008:5: (lv_right_3_0= ruleShiftExpression )
                    {
                    // InternalCoreDsl.g:5008:5: (lv_right_3_0= ruleShiftExpression )
                    // InternalCoreDsl.g:5009:6: lv_right_3_0= ruleShiftExpression
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
    // InternalCoreDsl.g:5031:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalCoreDsl.g:5031:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalCoreDsl.g:5032:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalCoreDsl.g:5038:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5044:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) )
            // InternalCoreDsl.g:5045:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            {
            // InternalCoreDsl.g:5045:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            // InternalCoreDsl.g:5046:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_84);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5054:3: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( ((LA103_0>=85 && LA103_0<=86)) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalCoreDsl.g:5055:4: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
                    {
                    // InternalCoreDsl.g:5055:4: ()
                    // InternalCoreDsl.g:5056:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5062:4: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    // InternalCoreDsl.g:5063:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    {
                    // InternalCoreDsl.g:5063:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    // InternalCoreDsl.g:5064:6: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    {
                    // InternalCoreDsl.g:5064:6: (lv_op_2_1= '+' | lv_op_2_2= '-' )
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
                            // InternalCoreDsl.g:5065:7: lv_op_2_1= '+'
                            {
                            lv_op_2_1=(Token)match(input,85,FOLLOW_45); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5076:7: lv_op_2_2= '-'
                            {
                            lv_op_2_2=(Token)match(input,86,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5089:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
                    // InternalCoreDsl.g:5090:5: (lv_right_3_0= ruleAdditiveExpression )
                    {
                    // InternalCoreDsl.g:5090:5: (lv_right_3_0= ruleAdditiveExpression )
                    // InternalCoreDsl.g:5091:6: lv_right_3_0= ruleAdditiveExpression
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
    // InternalCoreDsl.g:5113:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalCoreDsl.g:5113:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalCoreDsl.g:5114:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalCoreDsl.g:5120:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_CastExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5126:2: ( (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? ) )
            // InternalCoreDsl.g:5127:2: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? )
            {
            // InternalCoreDsl.g:5127:2: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? )
            // InternalCoreDsl.g:5128:3: this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_85);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CastExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5136:3: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( ((LA105_0>=87 && LA105_0<=89)) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalCoreDsl.g:5137:4: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    {
                    // InternalCoreDsl.g:5137:4: ()
                    // InternalCoreDsl.g:5138:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5144:4: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) )
                    // InternalCoreDsl.g:5145:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
                    {
                    // InternalCoreDsl.g:5145:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
                    // InternalCoreDsl.g:5146:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
                    {
                    // InternalCoreDsl.g:5146:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
                    int alt104=3;
                    switch ( input.LA(1) ) {
                    case 87:
                        {
                        alt104=1;
                        }
                        break;
                    case 88:
                        {
                        alt104=2;
                        }
                        break;
                    case 89:
                        {
                        alt104=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 104, 0, input);

                        throw nvae;
                    }

                    switch (alt104) {
                        case 1 :
                            // InternalCoreDsl.g:5147:7: lv_op_2_1= '*'
                            {
                            lv_op_2_1=(Token)match(input,87,FOLLOW_45); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5158:7: lv_op_2_2= '/'
                            {
                            lv_op_2_2=(Token)match(input,88,FOLLOW_45); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5169:7: lv_op_2_3= '%'
                            {
                            lv_op_2_3=(Token)match(input,89,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5182:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    // InternalCoreDsl.g:5183:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    {
                    // InternalCoreDsl.g:5183:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    // InternalCoreDsl.g:5184:6: lv_right_3_0= ruleMultiplicativeExpression
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
    // InternalCoreDsl.g:5206:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalCoreDsl.g:5206:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalCoreDsl.g:5207:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalCoreDsl.g:5213:1: ruleCastExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_left_4_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5219:2: ( (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) ) )
            // InternalCoreDsl.g:5220:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) )
            {
            // InternalCoreDsl.g:5220:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( ((LA106_0>=RULE_STRING && LA106_0<=RULE_ID)||(LA106_0>=RULE_NATURAL && LA106_0<=RULE_CHARCONST)||LA106_0==78||(LA106_0>=85 && LA106_0<=87)||(LA106_0>=90 && LA106_0<=94)||(LA106_0>=96 && LA106_0<=99)) ) {
                alt106=1;
            }
            else if ( (LA106_0==45) ) {
                int LA106_2 = input.LA(2);

                if ( (LA106_2==61||(LA106_2>=105 && LA106_2<=115)||(LA106_2>=125 && LA106_2<=126)) ) {
                    alt106=2;
                }
                else if ( ((LA106_2>=RULE_STRING && LA106_2<=RULE_ID)||(LA106_2>=RULE_NATURAL && LA106_2<=RULE_CHARCONST)||LA106_2==45||LA106_2==78||(LA106_2>=85 && LA106_2<=87)||(LA106_2>=90 && LA106_2<=94)||(LA106_2>=96 && LA106_2<=99)) ) {
                    alt106=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // InternalCoreDsl.g:5221:3: this_UnaryExpression_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCastExpressionAccess().getUnaryExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryExpression_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:5230:3: (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) )
                    {
                    // InternalCoreDsl.g:5230:3: (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) )
                    // InternalCoreDsl.g:5231:4: otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,45,FOLLOW_86); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:5235:4: ( (lv_type_2_0= ruleDataTypeSpecifier ) )
                    // InternalCoreDsl.g:5236:5: (lv_type_2_0= ruleDataTypeSpecifier )
                    {
                    // InternalCoreDsl.g:5236:5: (lv_type_2_0= ruleDataTypeSpecifier )
                    // InternalCoreDsl.g:5237:6: lv_type_2_0= ruleDataTypeSpecifier
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

                    otherlv_3=(Token)match(input,46,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }
                    // InternalCoreDsl.g:5258:4: ( (lv_left_4_0= ruleCastExpression ) )
                    // InternalCoreDsl.g:5259:5: (lv_left_4_0= ruleCastExpression )
                    {
                    // InternalCoreDsl.g:5259:5: (lv_left_4_0= ruleCastExpression )
                    // InternalCoreDsl.g:5260:6: lv_left_4_0= ruleCastExpression
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


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalCoreDsl.g:5282:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalCoreDsl.g:5282:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalCoreDsl.g:5283:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalCoreDsl.g:5289:1: ruleUnaryExpression returns [EObject current=null] : (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= ruleUnaryExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= ruleUnaryExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
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
            // InternalCoreDsl.g:5295:2: ( (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= ruleUnaryExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= ruleUnaryExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) ) )
            // InternalCoreDsl.g:5296:2: (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= ruleUnaryExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= ruleUnaryExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) )
            {
            // InternalCoreDsl.g:5296:2: (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= ruleUnaryExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= ruleUnaryExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) )
            int alt108=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
            case RULE_NATURAL:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 45:
            case 96:
            case 97:
            case 98:
            case 99:
                {
                alt108=1;
                }
                break;
            case 90:
                {
                alt108=2;
                }
                break;
            case 91:
                {
                alt108=3;
                }
                break;
            case 78:
            case 85:
            case 86:
            case 87:
            case 93:
            case 94:
                {
                alt108=4;
                }
                break;
            case 92:
                {
                alt108=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // InternalCoreDsl.g:5297:3: this_PostfixExpression_0= rulePostfixExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixExpressionParserRuleCall_0());
                      		
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
                    // InternalCoreDsl.g:5306:3: ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= ruleUnaryExpression ) ) )
                    {
                    // InternalCoreDsl.g:5306:3: ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= ruleUnaryExpression ) ) )
                    // InternalCoreDsl.g:5307:4: ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= ruleUnaryExpression ) )
                    {
                    // InternalCoreDsl.g:5307:4: ( (lv_op_1_0= '++' ) )
                    // InternalCoreDsl.g:5308:5: (lv_op_1_0= '++' )
                    {
                    // InternalCoreDsl.g:5308:5: (lv_op_1_0= '++' )
                    // InternalCoreDsl.g:5309:6: lv_op_1_0= '++'
                    {
                    lv_op_1_0=(Token)match(input,90,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_1_0, grammarAccess.getUnaryExpressionAccess().getOpPlusSignPlusSignKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnaryExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_1_0, "++");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5321:4: ( (lv_left_2_0= ruleUnaryExpression ) )
                    // InternalCoreDsl.g:5322:5: (lv_left_2_0= ruleUnaryExpression )
                    {
                    // InternalCoreDsl.g:5322:5: (lv_left_2_0= ruleUnaryExpression )
                    // InternalCoreDsl.g:5323:6: lv_left_2_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getLeftUnaryExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_left_2_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_2_0,
                      							"com.minres.coredsl.CoreDsl.UnaryExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:5342:3: ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= ruleUnaryExpression ) ) )
                    {
                    // InternalCoreDsl.g:5342:3: ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= ruleUnaryExpression ) ) )
                    // InternalCoreDsl.g:5343:4: ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= ruleUnaryExpression ) )
                    {
                    // InternalCoreDsl.g:5343:4: ( (lv_op_3_0= '--' ) )
                    // InternalCoreDsl.g:5344:5: (lv_op_3_0= '--' )
                    {
                    // InternalCoreDsl.g:5344:5: (lv_op_3_0= '--' )
                    // InternalCoreDsl.g:5345:6: lv_op_3_0= '--'
                    {
                    lv_op_3_0=(Token)match(input,91,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_3_0, grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusHyphenMinusKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnaryExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_3_0, "--");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5357:4: ( (lv_left_4_0= ruleUnaryExpression ) )
                    // InternalCoreDsl.g:5358:5: (lv_left_4_0= ruleUnaryExpression )
                    {
                    // InternalCoreDsl.g:5358:5: (lv_left_4_0= ruleUnaryExpression )
                    // InternalCoreDsl.g:5359:6: lv_left_4_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getLeftUnaryExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_left_4_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_4_0,
                      							"com.minres.coredsl.CoreDsl.UnaryExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:5378:3: (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) )
                    {
                    // InternalCoreDsl.g:5378:3: (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) )
                    // InternalCoreDsl.g:5379:4: this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getUnaryExpressionRule());
                      				}
                      				newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryOperatorParserRuleCall_3_0());
                      			
                    }
                    pushFollow(FOLLOW_45);
                    this_UnaryOperator_5=ruleUnaryOperator(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_UnaryOperator_5;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:5390:4: ( (lv_left_6_0= ruleCastExpression ) )
                    // InternalCoreDsl.g:5391:5: (lv_left_6_0= ruleCastExpression )
                    {
                    // InternalCoreDsl.g:5391:5: (lv_left_6_0= ruleCastExpression )
                    // InternalCoreDsl.g:5392:6: lv_left_6_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getLeftCastExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_left_6_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
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
                    // InternalCoreDsl.g:5411:3: ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' )
                    {
                    // InternalCoreDsl.g:5411:3: ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' )
                    // InternalCoreDsl.g:5412:4: ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')'
                    {
                    // InternalCoreDsl.g:5412:4: ( (lv_op_7_0= 'sizeof' ) )
                    // InternalCoreDsl.g:5413:5: (lv_op_7_0= 'sizeof' )
                    {
                    // InternalCoreDsl.g:5413:5: (lv_op_7_0= 'sizeof' )
                    // InternalCoreDsl.g:5414:6: lv_op_7_0= 'sizeof'
                    {
                    lv_op_7_0=(Token)match(input,92,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_7_0, grammarAccess.getUnaryExpressionAccess().getOpSizeofKeyword_4_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnaryExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_7_0, "sizeof");
                      					
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,45,FOLLOW_87); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:5430:4: ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) )
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( ((LA107_0>=RULE_STRING && LA107_0<=RULE_ID)||(LA107_0>=RULE_NATURAL && LA107_0<=RULE_CHARCONST)||LA107_0==45||(LA107_0>=96 && LA107_0<=99)) ) {
                        alt107=1;
                    }
                    else if ( (LA107_0==61||(LA107_0>=105 && LA107_0<=115)||(LA107_0>=125 && LA107_0<=126)) ) {
                        alt107=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 107, 0, input);

                        throw nvae;
                    }
                    switch (alt107) {
                        case 1 :
                            // InternalCoreDsl.g:5431:5: ( (lv_left_9_0= rulePostfixExpression ) )
                            {
                            // InternalCoreDsl.g:5431:5: ( (lv_left_9_0= rulePostfixExpression ) )
                            // InternalCoreDsl.g:5432:6: (lv_left_9_0= rulePostfixExpression )
                            {
                            // InternalCoreDsl.g:5432:6: (lv_left_9_0= rulePostfixExpression )
                            // InternalCoreDsl.g:5433:7: lv_left_9_0= rulePostfixExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getUnaryExpressionAccess().getLeftPostfixExpressionParserRuleCall_4_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_42);
                            lv_left_9_0=rulePostfixExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
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
                            // InternalCoreDsl.g:5451:5: ( (lv_type_10_0= ruleDataTypeSpecifier ) )
                            {
                            // InternalCoreDsl.g:5451:5: ( (lv_type_10_0= ruleDataTypeSpecifier ) )
                            // InternalCoreDsl.g:5452:6: (lv_type_10_0= ruleDataTypeSpecifier )
                            {
                            // InternalCoreDsl.g:5452:6: (lv_type_10_0= ruleDataTypeSpecifier )
                            // InternalCoreDsl.g:5453:7: lv_type_10_0= ruleDataTypeSpecifier
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getUnaryExpressionAccess().getTypeDataTypeSpecifierParserRuleCall_4_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_42);
                            lv_type_10_0=ruleDataTypeSpecifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
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

                    otherlv_11=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getUnaryExpressionAccess().getRightParenthesisKeyword_4_3());
                      			
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
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "ruleUnaryOperator"
    // InternalCoreDsl.g:5481:1: ruleUnaryOperator[EObject in_current] returns [EObject current=in_current] : ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) ) ;
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
            // InternalCoreDsl.g:5487:2: ( ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) ) )
            // InternalCoreDsl.g:5488:2: ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) )
            {
            // InternalCoreDsl.g:5488:2: ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) )
            // InternalCoreDsl.g:5489:3: ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) )
            {
            // InternalCoreDsl.g:5489:3: ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) )
            // InternalCoreDsl.g:5490:4: (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' )
            {
            // InternalCoreDsl.g:5490:4: (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' )
            int alt109=6;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt109=1;
                }
                break;
            case 87:
                {
                alt109=2;
                }
                break;
            case 85:
                {
                alt109=3;
                }
                break;
            case 86:
                {
                alt109=4;
                }
                break;
            case 93:
                {
                alt109=5;
                }
                break;
            case 94:
                {
                alt109=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }

            switch (alt109) {
                case 1 :
                    // InternalCoreDsl.g:5491:5: lv_op_0_1= '&'
                    {
                    lv_op_0_1=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5502:5: lv_op_0_2= '*'
                    {
                    lv_op_0_2=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5513:5: lv_op_0_3= '+'
                    {
                    lv_op_0_3=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5524:5: lv_op_0_4= '-'
                    {
                    lv_op_0_4=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5535:5: lv_op_0_5= '~'
                    {
                    lv_op_0_5=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5546:5: lv_op_0_6= '!'
                    {
                    lv_op_0_6=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:5562:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalCoreDsl.g:5562:58: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalCoreDsl.g:5563:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalCoreDsl.g:5569:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject lv_ops_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5575:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* ) )
            // InternalCoreDsl.g:5576:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* )
            {
            // InternalCoreDsl.g:5576:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* )
            // InternalCoreDsl.g:5577:3: this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_88);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5585:3: ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==42||LA110_0==45||LA110_0==63||(LA110_0>=90 && LA110_0<=91)||LA110_0==95) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // InternalCoreDsl.g:5586:4: () ( (lv_ops_2_0= rulePostfixOperator ) )
            	    {
            	    // InternalCoreDsl.g:5586:4: ()
            	    // InternalCoreDsl.g:5587:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getPostfixExpressionAccess().getPostfixExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:5593:4: ( (lv_ops_2_0= rulePostfixOperator ) )
            	    // InternalCoreDsl.g:5594:5: (lv_ops_2_0= rulePostfixOperator )
            	    {
            	    // InternalCoreDsl.g:5594:5: (lv_ops_2_0= rulePostfixOperator )
            	    // InternalCoreDsl.g:5595:6: lv_ops_2_0= rulePostfixOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPostfixExpressionAccess().getOpsPostfixOperatorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_88);
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
            	    break loop110;
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
    // InternalCoreDsl.g:5617:1: entryRulePostfixOperator returns [EObject current=null] : iv_rulePostfixOperator= rulePostfixOperator EOF ;
    public final EObject entryRulePostfixOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOperator = null;


        try {
            // InternalCoreDsl.g:5617:56: (iv_rulePostfixOperator= rulePostfixOperator EOF )
            // InternalCoreDsl.g:5618:2: iv_rulePostfixOperator= rulePostfixOperator EOF
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
    // InternalCoreDsl.g:5624:1: rulePostfixOperator returns [EObject current=null] : ( ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) ) ;
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
            // InternalCoreDsl.g:5630:2: ( ( ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) ) )
            // InternalCoreDsl.g:5631:2: ( ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) )
            {
            // InternalCoreDsl.g:5631:2: ( ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) )
            int alt114=6;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt114=1;
                }
                break;
            case 45:
                {
                alt114=2;
                }
                break;
            case 63:
                {
                alt114=3;
                }
                break;
            case 95:
                {
                alt114=4;
                }
                break;
            case 90:
                {
                alt114=5;
                }
                break;
            case 91:
                {
                alt114=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }

            switch (alt114) {
                case 1 :
                    // InternalCoreDsl.g:5632:3: ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' )
                    {
                    // InternalCoreDsl.g:5632:3: ( ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']' )
                    // InternalCoreDsl.g:5633:4: ( (lv_op_0_0= '[' ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? otherlv_4= ']'
                    {
                    // InternalCoreDsl.g:5633:4: ( (lv_op_0_0= '[' ) )
                    // InternalCoreDsl.g:5634:5: (lv_op_0_0= '[' )
                    {
                    // InternalCoreDsl.g:5634:5: (lv_op_0_0= '[' )
                    // InternalCoreDsl.g:5635:6: lv_op_0_0= '['
                    {
                    lv_op_0_0=(Token)match(input,42,FOLLOW_45); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5647:4: ( (lv_args_1_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:5648:5: (lv_args_1_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:5648:5: (lv_args_1_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:5649:6: lv_args_1_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_89);
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

                    // InternalCoreDsl.g:5666:4: (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==36) ) {
                        alt111=1;
                    }
                    switch (alt111) {
                        case 1 :
                            // InternalCoreDsl.g:5667:5: otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) )
                            {
                            otherlv_2=(Token)match(input,36,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getPostfixOperatorAccess().getColonKeyword_0_2_0());
                              				
                            }
                            // InternalCoreDsl.g:5671:5: ( (lv_args_3_0= ruleConditionalExpression ) )
                            // InternalCoreDsl.g:5672:6: (lv_args_3_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:5672:6: (lv_args_3_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:5673:7: lv_args_3_0= ruleConditionalExpression
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

                    otherlv_4=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPostfixOperatorAccess().getRightSquareBracketKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:5697:3: ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' )
                    {
                    // InternalCoreDsl.g:5697:3: ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' )
                    // InternalCoreDsl.g:5698:4: ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')'
                    {
                    // InternalCoreDsl.g:5698:4: ( (lv_op_5_0= '(' ) )
                    // InternalCoreDsl.g:5699:5: (lv_op_5_0= '(' )
                    {
                    // InternalCoreDsl.g:5699:5: (lv_op_5_0= '(' )
                    // InternalCoreDsl.g:5700:6: lv_op_5_0= '('
                    {
                    lv_op_5_0=(Token)match(input,45,FOLLOW_90); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5712:4: ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )?
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( ((LA113_0>=RULE_STRING && LA113_0<=RULE_ID)||(LA113_0>=RULE_NATURAL && LA113_0<=RULE_CHARCONST)||LA113_0==45||LA113_0==78||(LA113_0>=85 && LA113_0<=87)||(LA113_0>=90 && LA113_0<=94)||(LA113_0>=96 && LA113_0<=99)) ) {
                        alt113=1;
                    }
                    switch (alt113) {
                        case 1 :
                            // InternalCoreDsl.g:5713:5: ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )*
                            {
                            // InternalCoreDsl.g:5713:5: ( (lv_args_6_0= ruleConditionalExpression ) )
                            // InternalCoreDsl.g:5714:6: (lv_args_6_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:5714:6: (lv_args_6_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:5715:7: lv_args_6_0= ruleConditionalExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_1_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_91);
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

                            // InternalCoreDsl.g:5732:5: (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )*
                            loop112:
                            do {
                                int alt112=2;
                                int LA112_0 = input.LA(1);

                                if ( (LA112_0==32) ) {
                                    alt112=1;
                                }


                                switch (alt112) {
                            	case 1 :
                            	    // InternalCoreDsl.g:5733:6: otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) )
                            	    {
                            	    otherlv_7=(Token)match(input,32,FOLLOW_45); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_7, grammarAccess.getPostfixOperatorAccess().getCommaKeyword_1_1_1_0());
                            	      					
                            	    }
                            	    // InternalCoreDsl.g:5737:6: ( (lv_args_8_0= ruleConditionalExpression ) )
                            	    // InternalCoreDsl.g:5738:7: (lv_args_8_0= ruleConditionalExpression )
                            	    {
                            	    // InternalCoreDsl.g:5738:7: (lv_args_8_0= ruleConditionalExpression )
                            	    // InternalCoreDsl.g:5739:8: lv_args_8_0= ruleConditionalExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_1_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_91);
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
                            	    break loop112;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPostfixOperatorAccess().getRightParenthesisKeyword_1_2());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:5764:3: ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:5764:3: ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) )
                    // InternalCoreDsl.g:5765:4: ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:5765:4: ( (lv_op_10_0= '.' ) )
                    // InternalCoreDsl.g:5766:5: (lv_op_10_0= '.' )
                    {
                    // InternalCoreDsl.g:5766:5: (lv_op_10_0= '.' )
                    // InternalCoreDsl.g:5767:6: lv_op_10_0= '.'
                    {
                    lv_op_10_0=(Token)match(input,63,FOLLOW_6); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5779:4: ( (otherlv_11= RULE_ID ) )
                    // InternalCoreDsl.g:5780:5: (otherlv_11= RULE_ID )
                    {
                    // InternalCoreDsl.g:5780:5: (otherlv_11= RULE_ID )
                    // InternalCoreDsl.g:5781:6: otherlv_11= RULE_ID
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
                    // InternalCoreDsl.g:5794:3: ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:5794:3: ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) )
                    // InternalCoreDsl.g:5795:4: ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:5795:4: ( (lv_op_12_0= '->' ) )
                    // InternalCoreDsl.g:5796:5: (lv_op_12_0= '->' )
                    {
                    // InternalCoreDsl.g:5796:5: (lv_op_12_0= '->' )
                    // InternalCoreDsl.g:5797:6: lv_op_12_0= '->'
                    {
                    lv_op_12_0=(Token)match(input,95,FOLLOW_6); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5809:4: ( (otherlv_13= RULE_ID ) )
                    // InternalCoreDsl.g:5810:5: (otherlv_13= RULE_ID )
                    {
                    // InternalCoreDsl.g:5810:5: (otherlv_13= RULE_ID )
                    // InternalCoreDsl.g:5811:6: otherlv_13= RULE_ID
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
                    // InternalCoreDsl.g:5824:3: ( (lv_op_14_0= '++' ) )
                    {
                    // InternalCoreDsl.g:5824:3: ( (lv_op_14_0= '++' ) )
                    // InternalCoreDsl.g:5825:4: (lv_op_14_0= '++' )
                    {
                    // InternalCoreDsl.g:5825:4: (lv_op_14_0= '++' )
                    // InternalCoreDsl.g:5826:5: lv_op_14_0= '++'
                    {
                    lv_op_14_0=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5839:3: ( (lv_op_15_0= '--' ) )
                    {
                    // InternalCoreDsl.g:5839:3: ( (lv_op_15_0= '--' ) )
                    // InternalCoreDsl.g:5840:4: (lv_op_15_0= '--' )
                    {
                    // InternalCoreDsl.g:5840:4: (lv_op_15_0= '--' )
                    // InternalCoreDsl.g:5841:5: lv_op_15_0= '--'
                    {
                    lv_op_15_0=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:5857:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalCoreDsl.g:5857:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalCoreDsl.g:5858:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalCoreDsl.g:5864:1: rulePrimaryExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) ) ;
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
            // InternalCoreDsl.g:5870:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) ) )
            // InternalCoreDsl.g:5871:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) )
            {
            // InternalCoreDsl.g:5871:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) )
            int alt116=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt116=1;
                }
                break;
            case RULE_NATURAL:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
                {
                alt116=2;
                }
                break;
            case 99:
                {
                int LA116_3 = input.LA(2);

                if ( (LA116_3==RULE_STRING) ) {
                    alt116=3;
                }
                else if ( (LA116_3==RULE_CHARCONST) ) {
                    alt116=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 116, 3, input);

                    throw nvae;
                }
                }
                break;
            case 97:
                {
                int LA116_4 = input.LA(2);

                if ( (LA116_4==RULE_CHARCONST) ) {
                    alt116=2;
                }
                else if ( (LA116_4==RULE_STRING) ) {
                    alt116=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 116, 4, input);

                    throw nvae;
                }
                }
                break;
            case 98:
                {
                int LA116_5 = input.LA(2);

                if ( (LA116_5==RULE_CHARCONST) ) {
                    alt116=2;
                }
                else if ( (LA116_5==RULE_STRING) ) {
                    alt116=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 116, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case 96:
                {
                alt116=3;
                }
                break;
            case 45:
                {
                alt116=4;
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
                    // InternalCoreDsl.g:5872:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:5872:3: ( (otherlv_0= RULE_ID ) )
                    // InternalCoreDsl.g:5873:4: (otherlv_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:5873:4: (otherlv_0= RULE_ID )
                    // InternalCoreDsl.g:5874:5: otherlv_0= RULE_ID
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
                    // InternalCoreDsl.g:5886:3: ( (lv_constant_1_0= ruleConstant ) )
                    {
                    // InternalCoreDsl.g:5886:3: ( (lv_constant_1_0= ruleConstant ) )
                    // InternalCoreDsl.g:5887:4: (lv_constant_1_0= ruleConstant )
                    {
                    // InternalCoreDsl.g:5887:4: (lv_constant_1_0= ruleConstant )
                    // InternalCoreDsl.g:5888:5: lv_constant_1_0= ruleConstant
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
                    // InternalCoreDsl.g:5906:3: ( (lv_literal_2_0= ruleStringLiteral ) )+
                    {
                    // InternalCoreDsl.g:5906:3: ( (lv_literal_2_0= ruleStringLiteral ) )+
                    int cnt115=0;
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==RULE_STRING||(LA115_0>=96 && LA115_0<=99)) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalCoreDsl.g:5907:4: (lv_literal_2_0= ruleStringLiteral )
                    	    {
                    	    // InternalCoreDsl.g:5907:4: (lv_literal_2_0= ruleStringLiteral )
                    	    // InternalCoreDsl.g:5908:5: lv_literal_2_0= ruleStringLiteral
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralStringLiteralParserRuleCall_2_0());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_92);
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
                    	    if ( cnt115 >= 1 ) break loop115;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(115, input);
                                throw eee;
                        }
                        cnt115++;
                    } while (true);


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:5926:3: (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' )
                    {
                    // InternalCoreDsl.g:5926:3: (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' )
                    // InternalCoreDsl.g:5927:4: otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,45,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalCoreDsl.g:5931:4: ( (lv_left_4_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:5932:5: (lv_left_4_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:5932:5: (lv_left_4_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:5933:6: lv_left_4_0= ruleConditionalExpression
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

                    otherlv_5=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:5959:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalCoreDsl.g:5959:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalCoreDsl.g:5960:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalCoreDsl.g:5966:1: ruleStringLiteral returns [EObject current=null] : ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;
        EObject this_EncodingPrefix_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5972:2: ( ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) ) )
            // InternalCoreDsl.g:5973:2: ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) )
            {
            // InternalCoreDsl.g:5973:2: ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) )
            // InternalCoreDsl.g:5974:3: (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) )
            {
            // InternalCoreDsl.g:5974:3: (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( ((LA117_0>=96 && LA117_0<=99)) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalCoreDsl.g:5975:4: this_EncodingPrefix_0= ruleEncodingPrefix[$current]
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

            // InternalCoreDsl.g:5987:3: ( (lv_val_1_0= RULE_STRING ) )
            // InternalCoreDsl.g:5988:4: (lv_val_1_0= RULE_STRING )
            {
            // InternalCoreDsl.g:5988:4: (lv_val_1_0= RULE_STRING )
            // InternalCoreDsl.g:5989:5: lv_val_1_0= RULE_STRING
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
    // InternalCoreDsl.g:6010:1: ruleEncodingPrefix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) ) ;
    public final EObject ruleEncodingPrefix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_prefix_0_1=null;
        Token lv_prefix_0_2=null;
        Token lv_prefix_0_3=null;
        Token lv_prefix_0_4=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6016:2: ( ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) ) )
            // InternalCoreDsl.g:6017:2: ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) )
            {
            // InternalCoreDsl.g:6017:2: ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) )
            // InternalCoreDsl.g:6018:3: ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) )
            {
            // InternalCoreDsl.g:6018:3: ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) )
            // InternalCoreDsl.g:6019:4: (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' )
            {
            // InternalCoreDsl.g:6019:4: (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' )
            int alt118=4;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt118=1;
                }
                break;
            case 97:
                {
                alt118=2;
                }
                break;
            case 98:
                {
                alt118=3;
                }
                break;
            case 99:
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
                    // InternalCoreDsl.g:6020:5: lv_prefix_0_1= 'u8'
                    {
                    lv_prefix_0_1=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6031:5: lv_prefix_0_2= 'u'
                    {
                    lv_prefix_0_2=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6042:5: lv_prefix_0_3= 'U'
                    {
                    lv_prefix_0_3=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6053:5: lv_prefix_0_4= 'L'
                    {
                    lv_prefix_0_4=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6069:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalCoreDsl.g:6069:59: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalCoreDsl.g:6070:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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
    // InternalCoreDsl.g:6076:1: ruleConstantExpression returns [EObject current=null] : this_ConditionalExpression_0= ruleConditionalExpression ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6082:2: (this_ConditionalExpression_0= ruleConditionalExpression )
            // InternalCoreDsl.g:6083:2: this_ConditionalExpression_0= ruleConditionalExpression
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
    // InternalCoreDsl.g:6094:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalCoreDsl.g:6094:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalCoreDsl.g:6095:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalCoreDsl.g:6101:1: ruleConstant returns [EObject current=null] : (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerConstant_0 = null;

        EObject this_FloatingConstant_1 = null;

        EObject this_CharacterConstant_2 = null;

        EObject this_BoolConstant_3 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6107:2: ( (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant ) )
            // InternalCoreDsl.g:6108:2: (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant )
            {
            // InternalCoreDsl.g:6108:2: (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant )
            int alt119=4;
            switch ( input.LA(1) ) {
            case RULE_NATURAL:
                {
                alt119=1;
                }
                break;
            case RULE_FLOAT:
                {
                alt119=2;
                }
                break;
            case RULE_CHARCONST:
            case 97:
            case 98:
            case 99:
                {
                alt119=3;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt119=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;
            }

            switch (alt119) {
                case 1 :
                    // InternalCoreDsl.g:6109:3: this_IntegerConstant_0= ruleIntegerConstant
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
                    // InternalCoreDsl.g:6118:3: this_FloatingConstant_1= ruleFloatingConstant
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
                    // InternalCoreDsl.g:6127:3: this_CharacterConstant_2= ruleCharacterConstant
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
                    // InternalCoreDsl.g:6136:3: this_BoolConstant_3= ruleBoolConstant
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
    // InternalCoreDsl.g:6148:1: entryRuleIntegerConstant returns [EObject current=null] : iv_ruleIntegerConstant= ruleIntegerConstant EOF ;
    public final EObject entryRuleIntegerConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerConstant = null;


        try {
            // InternalCoreDsl.g:6148:56: (iv_ruleIntegerConstant= ruleIntegerConstant EOF )
            // InternalCoreDsl.g:6149:2: iv_ruleIntegerConstant= ruleIntegerConstant EOF
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
    // InternalCoreDsl.g:6155:1: ruleIntegerConstant returns [EObject current=null] : ( ( (lv_val_0_0= RULE_NATURAL ) ) (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )? ) ;
    public final EObject ruleIntegerConstant() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        EObject this_IntegerSuffix_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6161:2: ( ( ( (lv_val_0_0= RULE_NATURAL ) ) (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )? ) )
            // InternalCoreDsl.g:6162:2: ( ( (lv_val_0_0= RULE_NATURAL ) ) (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )? )
            {
            // InternalCoreDsl.g:6162:2: ( ( (lv_val_0_0= RULE_NATURAL ) ) (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )? )
            // InternalCoreDsl.g:6163:3: ( (lv_val_0_0= RULE_NATURAL ) ) (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )?
            {
            // InternalCoreDsl.g:6163:3: ( (lv_val_0_0= RULE_NATURAL ) )
            // InternalCoreDsl.g:6164:4: (lv_val_0_0= RULE_NATURAL )
            {
            // InternalCoreDsl.g:6164:4: (lv_val_0_0= RULE_NATURAL )
            // InternalCoreDsl.g:6165:5: lv_val_0_0= RULE_NATURAL
            {
            lv_val_0_0=(Token)match(input,RULE_NATURAL,FOLLOW_93); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_val_0_0, grammarAccess.getIntegerConstantAccess().getValNATURALTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getIntegerConstantRule());
              					}
              					setWithLastConsumed(
              						current,
              						"val",
              						lv_val_0_0,
              						"com.minres.coredsl.CoreDsl.NATURAL");
              				
            }

            }


            }

            // InternalCoreDsl.g:6181:3: (this_IntegerSuffix_1= ruleIntegerSuffix[$current] )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( ((LA120_0>=97 && LA120_0<=102)) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalCoreDsl.g:6182:4: this_IntegerSuffix_1= ruleIntegerSuffix[$current]
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
    // InternalCoreDsl.g:6198:1: entryRuleFloatingConstant returns [EObject current=null] : iv_ruleFloatingConstant= ruleFloatingConstant EOF ;
    public final EObject entryRuleFloatingConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatingConstant = null;


        try {
            // InternalCoreDsl.g:6198:57: (iv_ruleFloatingConstant= ruleFloatingConstant EOF )
            // InternalCoreDsl.g:6199:2: iv_ruleFloatingConstant= ruleFloatingConstant EOF
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
    // InternalCoreDsl.g:6205:1: ruleFloatingConstant returns [EObject current=null] : ( ( (lv_val_0_0= RULE_FLOAT ) ) (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )? ) ;
    public final EObject ruleFloatingConstant() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        EObject this_FloatingSuffix_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6211:2: ( ( ( (lv_val_0_0= RULE_FLOAT ) ) (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )? ) )
            // InternalCoreDsl.g:6212:2: ( ( (lv_val_0_0= RULE_FLOAT ) ) (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )? )
            {
            // InternalCoreDsl.g:6212:2: ( ( (lv_val_0_0= RULE_FLOAT ) ) (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )? )
            // InternalCoreDsl.g:6213:3: ( (lv_val_0_0= RULE_FLOAT ) ) (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )?
            {
            // InternalCoreDsl.g:6213:3: ( (lv_val_0_0= RULE_FLOAT ) )
            // InternalCoreDsl.g:6214:4: (lv_val_0_0= RULE_FLOAT )
            {
            // InternalCoreDsl.g:6214:4: (lv_val_0_0= RULE_FLOAT )
            // InternalCoreDsl.g:6215:5: lv_val_0_0= RULE_FLOAT
            {
            lv_val_0_0=(Token)match(input,RULE_FLOAT,FOLLOW_94); if (state.failed) return current;
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

            // InternalCoreDsl.g:6231:3: (this_FloatingSuffix_1= ruleFloatingSuffix[$current] )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( ((LA121_0>=99 && LA121_0<=100)||(LA121_0>=103 && LA121_0<=104)) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalCoreDsl.g:6232:4: this_FloatingSuffix_1= ruleFloatingSuffix[$current]
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
    // InternalCoreDsl.g:6248:1: entryRuleBoolConstant returns [EObject current=null] : iv_ruleBoolConstant= ruleBoolConstant EOF ;
    public final EObject entryRuleBoolConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolConstant = null;


        try {
            // InternalCoreDsl.g:6248:53: (iv_ruleBoolConstant= ruleBoolConstant EOF )
            // InternalCoreDsl.g:6249:2: iv_ruleBoolConstant= ruleBoolConstant EOF
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
    // InternalCoreDsl.g:6255:1: ruleBoolConstant returns [EObject current=null] : ( (lv_val_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBoolConstant() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6261:2: ( ( (lv_val_0_0= RULE_BOOLEAN ) ) )
            // InternalCoreDsl.g:6262:2: ( (lv_val_0_0= RULE_BOOLEAN ) )
            {
            // InternalCoreDsl.g:6262:2: ( (lv_val_0_0= RULE_BOOLEAN ) )
            // InternalCoreDsl.g:6263:3: (lv_val_0_0= RULE_BOOLEAN )
            {
            // InternalCoreDsl.g:6263:3: (lv_val_0_0= RULE_BOOLEAN )
            // InternalCoreDsl.g:6264:4: lv_val_0_0= RULE_BOOLEAN
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
    // InternalCoreDsl.g:6284:1: ruleIntegerSuffix[EObject in_current] returns [EObject current=in_current] : ( (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? ) | (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] ) | (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? ) | (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? ) ) ;
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
            // InternalCoreDsl.g:6290:2: ( ( (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? ) | (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] ) | (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? ) | (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? ) ) )
            // InternalCoreDsl.g:6291:2: ( (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? ) | (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] ) | (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? ) | (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? ) )
            {
            // InternalCoreDsl.g:6291:2: ( (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? ) | (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] ) | (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? ) | (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? ) )
            int alt125=4;
            switch ( input.LA(1) ) {
            case 97:
                {
                int LA125_1 = input.LA(2);

                if ( (LA125_1==EOF||LA125_1==25||LA125_1==32||(LA125_1>=36 && LA125_1<=37)||LA125_1==40||(LA125_1>=42 && LA125_1<=43)||(LA125_1>=45 && LA125_1<=46)||(LA125_1>=59 && LA125_1<=60)||(LA125_1>=62 && LA125_1<=91)||LA125_1==95||(LA125_1>=99 && LA125_1<=100)) ) {
                    alt125=1;
                }
                else if ( ((LA125_1>=101 && LA125_1<=102)) ) {
                    alt125=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 125, 1, input);

                    throw nvae;
                }
                }
                break;
            case 98:
                {
                int LA125_2 = input.LA(2);

                if ( (LA125_2==EOF||LA125_2==25||LA125_2==32||(LA125_2>=36 && LA125_2<=37)||LA125_2==40||(LA125_2>=42 && LA125_2<=43)||(LA125_2>=45 && LA125_2<=46)||(LA125_2>=59 && LA125_2<=60)||(LA125_2>=62 && LA125_2<=91)||LA125_2==95||(LA125_2>=99 && LA125_2<=100)) ) {
                    alt125=1;
                }
                else if ( ((LA125_2>=101 && LA125_2<=102)) ) {
                    alt125=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 125, 2, input);

                    throw nvae;
                }
                }
                break;
            case 99:
            case 100:
                {
                alt125=3;
                }
                break;
            case 101:
            case 102:
                {
                alt125=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;
            }

            switch (alt125) {
                case 1 :
                    // InternalCoreDsl.g:6292:3: (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? )
                    {
                    // InternalCoreDsl.g:6292:3: (this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )? )
                    // InternalCoreDsl.g:6293:4: this_UnsignedSuffix_0= ruleUnsignedSuffix[$current] (this_LongSuffix_1= ruleLongSuffix[$current] )?
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIntegerSuffixRule());
                      				}
                      				newCompositeNode(grammarAccess.getIntegerSuffixAccess().getUnsignedSuffixParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_95);
                    this_UnsignedSuffix_0=ruleUnsignedSuffix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_UnsignedSuffix_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:6304:4: (this_LongSuffix_1= ruleLongSuffix[$current] )?
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( ((LA122_0>=99 && LA122_0<=100)) ) {
                        alt122=1;
                    }
                    switch (alt122) {
                        case 1 :
                            // InternalCoreDsl.g:6305:5: this_LongSuffix_1= ruleLongSuffix[$current]
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
                    // InternalCoreDsl.g:6319:3: (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] )
                    {
                    // InternalCoreDsl.g:6319:3: (this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current] )
                    // InternalCoreDsl.g:6320:4: this_UnsignedSuffix_2= ruleUnsignedSuffix[$current] this_LongLongSuffix_3= ruleLongLongSuffix[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIntegerSuffixRule());
                      				}
                      				newCompositeNode(grammarAccess.getIntegerSuffixAccess().getUnsignedSuffixParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_96);
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
                    // InternalCoreDsl.g:6344:3: (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? )
                    {
                    // InternalCoreDsl.g:6344:3: (this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )? )
                    // InternalCoreDsl.g:6345:4: this_LongSuffix_4= ruleLongSuffix[$current] (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )?
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIntegerSuffixRule());
                      				}
                      				newCompositeNode(grammarAccess.getIntegerSuffixAccess().getLongSuffixParserRuleCall_2_0());
                      			
                    }
                    pushFollow(FOLLOW_97);
                    this_LongSuffix_4=ruleLongSuffix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LongSuffix_4;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:6356:4: (this_UnsignedSuffix_5= ruleUnsignedSuffix[$current] )?
                    int alt123=2;
                    int LA123_0 = input.LA(1);

                    if ( ((LA123_0>=97 && LA123_0<=98)) ) {
                        alt123=1;
                    }
                    switch (alt123) {
                        case 1 :
                            // InternalCoreDsl.g:6357:5: this_UnsignedSuffix_5= ruleUnsignedSuffix[$current]
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
                    // InternalCoreDsl.g:6371:3: (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? )
                    {
                    // InternalCoreDsl.g:6371:3: (this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )? )
                    // InternalCoreDsl.g:6372:4: this_LongLongSuffix_6= ruleLongLongSuffix[$current] (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )?
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIntegerSuffixRule());
                      				}
                      				newCompositeNode(grammarAccess.getIntegerSuffixAccess().getLongLongSuffixParserRuleCall_3_0());
                      			
                    }
                    pushFollow(FOLLOW_97);
                    this_LongLongSuffix_6=ruleLongLongSuffix(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LongLongSuffix_6;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:6383:4: (this_UnsignedSuffix_7= ruleUnsignedSuffix[$current] )?
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( ((LA124_0>=97 && LA124_0<=98)) ) {
                        alt124=1;
                    }
                    switch (alt124) {
                        case 1 :
                            // InternalCoreDsl.g:6384:5: this_UnsignedSuffix_7= ruleUnsignedSuffix[$current]
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
    // InternalCoreDsl.g:6402:1: ruleUnsignedSuffix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) ) ) ;
    public final EObject ruleUnsignedSuffix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_unsigned_0_1=null;
        Token lv_unsigned_0_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6408:2: ( ( ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) ) ) )
            // InternalCoreDsl.g:6409:2: ( ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) ) )
            {
            // InternalCoreDsl.g:6409:2: ( ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) ) )
            // InternalCoreDsl.g:6410:3: ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) )
            {
            // InternalCoreDsl.g:6410:3: ( (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' ) )
            // InternalCoreDsl.g:6411:4: (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' )
            {
            // InternalCoreDsl.g:6411:4: (lv_unsigned_0_1= 'u' | lv_unsigned_0_2= 'U' )
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==97) ) {
                alt126=1;
            }
            else if ( (LA126_0==98) ) {
                alt126=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;
            }
            switch (alt126) {
                case 1 :
                    // InternalCoreDsl.g:6412:5: lv_unsigned_0_1= 'u'
                    {
                    lv_unsigned_0_1=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6423:5: lv_unsigned_0_2= 'U'
                    {
                    lv_unsigned_0_2=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6440:1: ruleLongSuffix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) ) ) ;
    public final EObject ruleLongSuffix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_long_0_1=null;
        Token lv_long_0_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6446:2: ( ( ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) ) ) )
            // InternalCoreDsl.g:6447:2: ( ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) ) )
            {
            // InternalCoreDsl.g:6447:2: ( ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) ) )
            // InternalCoreDsl.g:6448:3: ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) )
            {
            // InternalCoreDsl.g:6448:3: ( (lv_long_0_1= 'l' | lv_long_0_2= 'L' ) )
            // InternalCoreDsl.g:6449:4: (lv_long_0_1= 'l' | lv_long_0_2= 'L' )
            {
            // InternalCoreDsl.g:6449:4: (lv_long_0_1= 'l' | lv_long_0_2= 'L' )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==100) ) {
                alt127=1;
            }
            else if ( (LA127_0==99) ) {
                alt127=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }
            switch (alt127) {
                case 1 :
                    // InternalCoreDsl.g:6450:5: lv_long_0_1= 'l'
                    {
                    lv_long_0_1=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6461:5: lv_long_0_2= 'L'
                    {
                    lv_long_0_2=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6478:1: ruleLongLongSuffix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) ) ) ;
    public final EObject ruleLongLongSuffix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_longlong_0_1=null;
        Token lv_longlong_0_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6484:2: ( ( ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) ) ) )
            // InternalCoreDsl.g:6485:2: ( ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) ) )
            {
            // InternalCoreDsl.g:6485:2: ( ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) ) )
            // InternalCoreDsl.g:6486:3: ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) )
            {
            // InternalCoreDsl.g:6486:3: ( (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' ) )
            // InternalCoreDsl.g:6487:4: (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' )
            {
            // InternalCoreDsl.g:6487:4: (lv_longlong_0_1= 'll' | lv_longlong_0_2= 'LL' )
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==101) ) {
                alt128=1;
            }
            else if ( (LA128_0==102) ) {
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
                    // InternalCoreDsl.g:6488:5: lv_longlong_0_1= 'll'
                    {
                    lv_longlong_0_1=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6499:5: lv_longlong_0_2= 'LL'
                    {
                    lv_longlong_0_2=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6516:1: ruleFloatingSuffix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_f_0_0= 'f' ) ) | ( (lv_l_1_0= 'l' ) ) | ( (lv_f_2_0= 'F' ) ) | ( (lv_f_3_0= 'L' ) ) ) ;
    public final EObject ruleFloatingSuffix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_f_0_0=null;
        Token lv_l_1_0=null;
        Token lv_f_2_0=null;
        Token lv_f_3_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6522:2: ( ( ( (lv_f_0_0= 'f' ) ) | ( (lv_l_1_0= 'l' ) ) | ( (lv_f_2_0= 'F' ) ) | ( (lv_f_3_0= 'L' ) ) ) )
            // InternalCoreDsl.g:6523:2: ( ( (lv_f_0_0= 'f' ) ) | ( (lv_l_1_0= 'l' ) ) | ( (lv_f_2_0= 'F' ) ) | ( (lv_f_3_0= 'L' ) ) )
            {
            // InternalCoreDsl.g:6523:2: ( ( (lv_f_0_0= 'f' ) ) | ( (lv_l_1_0= 'l' ) ) | ( (lv_f_2_0= 'F' ) ) | ( (lv_f_3_0= 'L' ) ) )
            int alt129=4;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt129=1;
                }
                break;
            case 100:
                {
                alt129=2;
                }
                break;
            case 104:
                {
                alt129=3;
                }
                break;
            case 99:
                {
                alt129=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }

            switch (alt129) {
                case 1 :
                    // InternalCoreDsl.g:6524:3: ( (lv_f_0_0= 'f' ) )
                    {
                    // InternalCoreDsl.g:6524:3: ( (lv_f_0_0= 'f' ) )
                    // InternalCoreDsl.g:6525:4: (lv_f_0_0= 'f' )
                    {
                    // InternalCoreDsl.g:6525:4: (lv_f_0_0= 'f' )
                    // InternalCoreDsl.g:6526:5: lv_f_0_0= 'f'
                    {
                    lv_f_0_0=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6539:3: ( (lv_l_1_0= 'l' ) )
                    {
                    // InternalCoreDsl.g:6539:3: ( (lv_l_1_0= 'l' ) )
                    // InternalCoreDsl.g:6540:4: (lv_l_1_0= 'l' )
                    {
                    // InternalCoreDsl.g:6540:4: (lv_l_1_0= 'l' )
                    // InternalCoreDsl.g:6541:5: lv_l_1_0= 'l'
                    {
                    lv_l_1_0=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6554:3: ( (lv_f_2_0= 'F' ) )
                    {
                    // InternalCoreDsl.g:6554:3: ( (lv_f_2_0= 'F' ) )
                    // InternalCoreDsl.g:6555:4: (lv_f_2_0= 'F' )
                    {
                    // InternalCoreDsl.g:6555:4: (lv_f_2_0= 'F' )
                    // InternalCoreDsl.g:6556:5: lv_f_2_0= 'F'
                    {
                    lv_f_2_0=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6569:3: ( (lv_f_3_0= 'L' ) )
                    {
                    // InternalCoreDsl.g:6569:3: ( (lv_f_3_0= 'L' ) )
                    // InternalCoreDsl.g:6570:4: (lv_f_3_0= 'L' )
                    {
                    // InternalCoreDsl.g:6570:4: (lv_f_3_0= 'L' )
                    // InternalCoreDsl.g:6571:5: lv_f_3_0= 'L'
                    {
                    lv_f_3_0=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6587:1: entryRuleCharacterConstant returns [EObject current=null] : iv_ruleCharacterConstant= ruleCharacterConstant EOF ;
    public final EObject entryRuleCharacterConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterConstant = null;


        try {
            // InternalCoreDsl.g:6587:58: (iv_ruleCharacterConstant= ruleCharacterConstant EOF )
            // InternalCoreDsl.g:6588:2: iv_ruleCharacterConstant= ruleCharacterConstant EOF
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
    // InternalCoreDsl.g:6594:1: ruleCharacterConstant returns [EObject current=null] : ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) ) ;
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
            // InternalCoreDsl.g:6600:2: ( ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) ) )
            // InternalCoreDsl.g:6601:2: ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) )
            {
            // InternalCoreDsl.g:6601:2: ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) )
            int alt130=4;
            switch ( input.LA(1) ) {
            case RULE_CHARCONST:
                {
                alt130=1;
                }
                break;
            case 99:
                {
                alt130=2;
                }
                break;
            case 97:
                {
                alt130=3;
                }
                break;
            case 98:
                {
                alt130=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }

            switch (alt130) {
                case 1 :
                    // InternalCoreDsl.g:6602:3: ( (lv_val_0_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6602:3: ( (lv_val_0_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6603:4: (lv_val_0_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6603:4: (lv_val_0_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6604:5: lv_val_0_0= RULE_CHARCONST
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
                    // InternalCoreDsl.g:6621:3: ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6621:3: ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6622:4: ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6622:4: ( (lv_enc_1_0= 'L' ) )
                    // InternalCoreDsl.g:6623:5: (lv_enc_1_0= 'L' )
                    {
                    // InternalCoreDsl.g:6623:5: (lv_enc_1_0= 'L' )
                    // InternalCoreDsl.g:6624:6: lv_enc_1_0= 'L'
                    {
                    lv_enc_1_0=(Token)match(input,99,FOLLOW_98); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6636:4: ( (lv_val_2_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6637:5: (lv_val_2_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6637:5: (lv_val_2_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6638:6: lv_val_2_0= RULE_CHARCONST
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
                    // InternalCoreDsl.g:6656:3: ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6656:3: ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6657:4: ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6657:4: ( (lv_enc_3_0= 'u' ) )
                    // InternalCoreDsl.g:6658:5: (lv_enc_3_0= 'u' )
                    {
                    // InternalCoreDsl.g:6658:5: (lv_enc_3_0= 'u' )
                    // InternalCoreDsl.g:6659:6: lv_enc_3_0= 'u'
                    {
                    lv_enc_3_0=(Token)match(input,97,FOLLOW_98); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6671:4: ( (lv_val_4_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6672:5: (lv_val_4_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6672:5: (lv_val_4_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6673:6: lv_val_4_0= RULE_CHARCONST
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
                    // InternalCoreDsl.g:6691:3: ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6691:3: ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6692:4: ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6692:4: ( (lv_enc_5_0= 'U' ) )
                    // InternalCoreDsl.g:6693:5: (lv_enc_5_0= 'U' )
                    {
                    // InternalCoreDsl.g:6693:5: (lv_enc_5_0= 'U' )
                    // InternalCoreDsl.g:6694:6: lv_enc_5_0= 'U'
                    {
                    lv_enc_5_0=(Token)match(input,98,FOLLOW_98); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6706:4: ( (lv_val_6_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6707:5: (lv_val_6_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6707:5: (lv_val_6_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6708:6: lv_val_6_0= RULE_CHARCONST
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
    // InternalCoreDsl.g:6729:1: ruleDataTypes returns [Enumerator current=null] : ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'frac' ) | (enumLiteral_10= 'accum' ) ) ;
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
            // InternalCoreDsl.g:6735:2: ( ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'frac' ) | (enumLiteral_10= 'accum' ) ) )
            // InternalCoreDsl.g:6736:2: ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'frac' ) | (enumLiteral_10= 'accum' ) )
            {
            // InternalCoreDsl.g:6736:2: ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'frac' ) | (enumLiteral_10= 'accum' ) )
            int alt131=11;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt131=1;
                }
                break;
            case 106:
                {
                alt131=2;
                }
                break;
            case 107:
                {
                alt131=3;
                }
                break;
            case 108:
                {
                alt131=4;
                }
                break;
            case 109:
                {
                alt131=5;
                }
                break;
            case 110:
                {
                alt131=6;
                }
                break;
            case 111:
                {
                alt131=7;
                }
                break;
            case 112:
                {
                alt131=8;
                }
                break;
            case 113:
                {
                alt131=9;
                }
                break;
            case 114:
                {
                alt131=10;
                }
                break;
            case 115:
                {
                alt131=11;
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
                    // InternalCoreDsl.g:6737:3: (enumLiteral_0= 'bool' )
                    {
                    // InternalCoreDsl.g:6737:3: (enumLiteral_0= 'bool' )
                    // InternalCoreDsl.g:6738:4: enumLiteral_0= 'bool'
                    {
                    enumLiteral_0=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getDataTypesAccess().getBOOLEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6745:3: (enumLiteral_1= 'char' )
                    {
                    // InternalCoreDsl.g:6745:3: (enumLiteral_1= 'char' )
                    // InternalCoreDsl.g:6746:4: enumLiteral_1= 'char'
                    {
                    enumLiteral_1=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getCHAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getDataTypesAccess().getCHAREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6753:3: (enumLiteral_2= 'short' )
                    {
                    // InternalCoreDsl.g:6753:3: (enumLiteral_2= 'short' )
                    // InternalCoreDsl.g:6754:4: enumLiteral_2= 'short'
                    {
                    enumLiteral_2=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getSHORTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getDataTypesAccess().getSHORTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6761:3: (enumLiteral_3= 'int' )
                    {
                    // InternalCoreDsl.g:6761:3: (enumLiteral_3= 'int' )
                    // InternalCoreDsl.g:6762:4: enumLiteral_3= 'int'
                    {
                    enumLiteral_3=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getINTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getDataTypesAccess().getINTEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:6769:3: (enumLiteral_4= 'long' )
                    {
                    // InternalCoreDsl.g:6769:3: (enumLiteral_4= 'long' )
                    // InternalCoreDsl.g:6770:4: enumLiteral_4= 'long'
                    {
                    enumLiteral_4=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getLONGEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getDataTypesAccess().getLONGEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalCoreDsl.g:6777:3: (enumLiteral_5= 'signed' )
                    {
                    // InternalCoreDsl.g:6777:3: (enumLiteral_5= 'signed' )
                    // InternalCoreDsl.g:6778:4: enumLiteral_5= 'signed'
                    {
                    enumLiteral_5=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getSIGNEDEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getDataTypesAccess().getSIGNEDEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalCoreDsl.g:6785:3: (enumLiteral_6= 'unsigned' )
                    {
                    // InternalCoreDsl.g:6785:3: (enumLiteral_6= 'unsigned' )
                    // InternalCoreDsl.g:6786:4: enumLiteral_6= 'unsigned'
                    {
                    enumLiteral_6=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getUNSIGNEDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getDataTypesAccess().getUNSIGNEDEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalCoreDsl.g:6793:3: (enumLiteral_7= 'float' )
                    {
                    // InternalCoreDsl.g:6793:3: (enumLiteral_7= 'float' )
                    // InternalCoreDsl.g:6794:4: enumLiteral_7= 'float'
                    {
                    enumLiteral_7=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getFLOATEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getDataTypesAccess().getFLOATEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalCoreDsl.g:6801:3: (enumLiteral_8= 'double' )
                    {
                    // InternalCoreDsl.g:6801:3: (enumLiteral_8= 'double' )
                    // InternalCoreDsl.g:6802:4: enumLiteral_8= 'double'
                    {
                    enumLiteral_8=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getDOUBLEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getDataTypesAccess().getDOUBLEEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalCoreDsl.g:6809:3: (enumLiteral_9= 'frac' )
                    {
                    // InternalCoreDsl.g:6809:3: (enumLiteral_9= 'frac' )
                    // InternalCoreDsl.g:6810:4: enumLiteral_9= 'frac'
                    {
                    enumLiteral_9=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getFRACEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getDataTypesAccess().getFRACEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalCoreDsl.g:6817:3: (enumLiteral_10= 'accum' )
                    {
                    // InternalCoreDsl.g:6817:3: (enumLiteral_10= 'accum' )
                    // InternalCoreDsl.g:6818:4: enumLiteral_10= 'accum'
                    {
                    enumLiteral_10=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6828:1: ruleTypeQualifier returns [Enumerator current=null] : ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) ) ;
    public final Enumerator ruleTypeQualifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6834:2: ( ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) ) )
            // InternalCoreDsl.g:6835:2: ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) )
            {
            // InternalCoreDsl.g:6835:2: ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) )
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==116) ) {
                alt132=1;
            }
            else if ( (LA132_0==117) ) {
                alt132=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }
            switch (alt132) {
                case 1 :
                    // InternalCoreDsl.g:6836:3: (enumLiteral_0= 'const' )
                    {
                    // InternalCoreDsl.g:6836:3: (enumLiteral_0= 'const' )
                    // InternalCoreDsl.g:6837:4: enumLiteral_0= 'const'
                    {
                    enumLiteral_0=(Token)match(input,116,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeQualifierAccess().getCONSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTypeQualifierAccess().getCONSTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6844:3: (enumLiteral_1= 'volatile' )
                    {
                    // InternalCoreDsl.g:6844:3: (enumLiteral_1= 'volatile' )
                    // InternalCoreDsl.g:6845:4: enumLiteral_1= 'volatile'
                    {
                    enumLiteral_1=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6855:1: ruleStorageClassSpecifier returns [Enumerator current=null] : ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) ) ;
    public final Enumerator ruleStorageClassSpecifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6861:2: ( ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) ) )
            // InternalCoreDsl.g:6862:2: ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) )
            {
            // InternalCoreDsl.g:6862:2: ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) )
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==44) ) {
                alt133=1;
            }
            else if ( (LA133_0==118) ) {
                alt133=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }
            switch (alt133) {
                case 1 :
                    // InternalCoreDsl.g:6863:3: (enumLiteral_0= 'extern' )
                    {
                    // InternalCoreDsl.g:6863:3: (enumLiteral_0= 'extern' )
                    // InternalCoreDsl.g:6864:4: enumLiteral_0= 'extern'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStorageClassSpecifierAccess().getEXTERNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getStorageClassSpecifierAccess().getEXTERNEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6871:3: (enumLiteral_1= 'static' )
                    {
                    // InternalCoreDsl.g:6871:3: (enumLiteral_1= 'static' )
                    // InternalCoreDsl.g:6872:4: enumLiteral_1= 'static'
                    {
                    enumLiteral_1=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6882:1: ruleAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) ) ;
    public final Enumerator ruleAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6888:2: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) ) )
            // InternalCoreDsl.g:6889:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) )
            {
            // InternalCoreDsl.g:6889:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) )
            int alt134=3;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt134=1;
                }
                break;
            case 120:
                {
                alt134=2;
                }
                break;
            case 121:
                {
                alt134=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }

            switch (alt134) {
                case 1 :
                    // InternalCoreDsl.g:6890:3: (enumLiteral_0= 'NONE' )
                    {
                    // InternalCoreDsl.g:6890:3: (enumLiteral_0= 'NONE' )
                    // InternalCoreDsl.g:6891:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,119,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAttributeAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAttributeAccess().getNONEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6898:3: (enumLiteral_1= 'is_pc' )
                    {
                    // InternalCoreDsl.g:6898:3: (enumLiteral_1= 'is_pc' )
                    // InternalCoreDsl.g:6899:4: enumLiteral_1= 'is_pc'
                    {
                    enumLiteral_1=(Token)match(input,120,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAttributeAccess().getIS_PCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAttributeAccess().getIS_PCEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6906:3: (enumLiteral_2= 'delete' )
                    {
                    // InternalCoreDsl.g:6906:3: (enumLiteral_2= 'delete' )
                    // InternalCoreDsl.g:6907:4: enumLiteral_2= 'delete'
                    {
                    enumLiteral_2=(Token)match(input,121,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6917:1: ruleInstrAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) ) ;
    public final Enumerator ruleInstrAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6923:2: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) ) )
            // InternalCoreDsl.g:6924:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) )
            {
            // InternalCoreDsl.g:6924:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) )
            int alt135=4;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt135=1;
                }
                break;
            case 122:
                {
                alt135=2;
                }
                break;
            case 123:
                {
                alt135=3;
                }
                break;
            case 124:
                {
                alt135=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }

            switch (alt135) {
                case 1 :
                    // InternalCoreDsl.g:6925:3: (enumLiteral_0= 'NONE' )
                    {
                    // InternalCoreDsl.g:6925:3: (enumLiteral_0= 'NONE' )
                    // InternalCoreDsl.g:6926:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,119,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInstrAttributeAccess().getNONEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6933:3: (enumLiteral_1= 'no_cont' )
                    {
                    // InternalCoreDsl.g:6933:3: (enumLiteral_1= 'no_cont' )
                    // InternalCoreDsl.g:6934:4: enumLiteral_1= 'no_cont'
                    {
                    enumLiteral_1=(Token)match(input,122,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getNO_CONTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getInstrAttributeAccess().getNO_CONTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6941:3: (enumLiteral_2= 'cond' )
                    {
                    // InternalCoreDsl.g:6941:3: (enumLiteral_2= 'cond' )
                    // InternalCoreDsl.g:6942:4: enumLiteral_2= 'cond'
                    {
                    enumLiteral_2=(Token)match(input,123,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getCONDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getInstrAttributeAccess().getCONDEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6949:3: (enumLiteral_3= 'flush' )
                    {
                    // InternalCoreDsl.g:6949:3: (enumLiteral_3= 'flush' )
                    // InternalCoreDsl.g:6950:4: enumLiteral_3= 'flush'
                    {
                    enumLiteral_3=(Token)match(input,124,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6960:1: ruleStructOrUnion returns [Enumerator current=null] : ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) ) ;
    public final Enumerator ruleStructOrUnion() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6966:2: ( ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) ) )
            // InternalCoreDsl.g:6967:2: ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) )
            {
            // InternalCoreDsl.g:6967:2: ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) )
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==125) ) {
                alt136=1;
            }
            else if ( (LA136_0==126) ) {
                alt136=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }
            switch (alt136) {
                case 1 :
                    // InternalCoreDsl.g:6968:3: (enumLiteral_0= 'struct' )
                    {
                    // InternalCoreDsl.g:6968:3: (enumLiteral_0= 'struct' )
                    // InternalCoreDsl.g:6969:4: enumLiteral_0= 'struct'
                    {
                    enumLiteral_0=(Token)match(input,125,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStructOrUnionAccess().getSTRUCTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getStructOrUnionAccess().getSTRUCTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6976:3: (enumLiteral_1= 'union' )
                    {
                    // InternalCoreDsl.g:6976:3: (enumLiteral_1= 'union' )
                    // InternalCoreDsl.g:6977:4: enumLiteral_1= 'union'
                    {
                    enumLiteral_1=(Token)match(input,126,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6987:1: ruleBitfieldDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) ) ;
    public final Enumerator ruleBitfieldDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6993:2: ( ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) ) )
            // InternalCoreDsl.g:6994:2: ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) )
            {
            // InternalCoreDsl.g:6994:2: ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==97) ) {
                alt137=1;
            }
            else if ( (LA137_0==127) ) {
                alt137=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }
            switch (alt137) {
                case 1 :
                    // InternalCoreDsl.g:6995:3: (enumLiteral_0= 'u' )
                    {
                    // InternalCoreDsl.g:6995:3: (enumLiteral_0= 'u' )
                    // InternalCoreDsl.g:6996:4: enumLiteral_0= 'u'
                    {
                    enumLiteral_0=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getBitfieldDataTypeAccess().getUNSIGNEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getBitfieldDataTypeAccess().getUNSIGNEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7003:3: (enumLiteral_1= 's' )
                    {
                    // InternalCoreDsl.g:7003:3: (enumLiteral_1= 's' )
                    // InternalCoreDsl.g:7004:4: enumLiteral_1= 's'
                    {
                    enumLiteral_1=(Token)match(input,127,FOLLOW_2); if (state.failed) return current;
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
        match(input,50,FOLLOW_2); if (state.failed) return ;

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000040300000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000040200002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000003D000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x2400100200000020L,0x607FFE0000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x2400100202000020L,0x607FFE0000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000003C000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000038000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x2000100200000020L,0x607FFE0000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x2000100202000020L,0x607FFE0000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000100800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000002F000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000002E000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000000002A000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x1C80000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000020000000002L,0x8000000200000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000020000000000L,0x8000000200000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000240000000022L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00002000000007B0L,0x0000000F7CE04000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x03FA2020008007B0L,0x0000000F7CE04000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x27FA3022028007B0L,0x607FFE0F7CE04000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x24003022000007B0L,0x607FFE0F7CE04000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x00002020000007B0L,0x0000000F7CE04000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x00002000000007B2L,0x0000000F7CE04000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0800002000000020L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000002000000020L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000002100000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0380000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x000FFE0000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x1000000100000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000102000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x00002000008007B0L,0x0000000F7CE04000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000041000000002L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x00002800000007B0L,0x0030000F7CE04000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x00002800000007B0L,0x0000000F7CE04000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x80002400008007B0L,0x0000000F7CE04000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0xC000040000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x2000740200000020L,0x607FFE0000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x4000000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000002L,0x0000000000018000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x1800000000000002L,0x0000000000060000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000002L,0x0000000000180000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000002L,0x0000000003800000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x2000000000000000L,0x600FFE0000000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x20002000000007B0L,0x600FFE0F00000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x8000240000000002L,0x000000008C000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000081000000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x00006000000007B0L,0x0000000F7CE04000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000400100000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000012L,0x0000000F00000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000002L,0x0000007E00000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000002L,0x0000019800000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000002L,0x0000001800000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0000007E00000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000002L,0x0000000600000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000400L});

}