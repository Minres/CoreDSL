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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BVAL", "RULE_VLOGVAL", "RULE_LEFT_BR", "RULE_RIGHT_BR", "RULE_INTEGER", "RULE_FLOAT", "RULE_BOOLEAN", "RULE_CHARCONST", "RULE_VLOGINT", "RULE_BINARYINT", "RULE_HEXADECIMALINT", "RULE_OCTALINT", "RULE_DECIMALINT", "RULE_INT", "RULE_ANY_OTHER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'import'", "'InstructionSet'", "'extends'", "'{'", "'constants'", "'}'", "'address_spaces'", "'registers'", "'functions'", "'instructions'", "'Core'", "'provides'", "','", "'encoding'", "':'", "';'", "'args_disass'", "'behavior'", "'|'", "'::'", "'\\''", "'extern'", "'('", "')'", "'case'", "'default'", "'if'", "'else'", "'switch'", "'while'", "'do'", "'for'", "'continue'", "'break'", "'return'", "'spawn'", "'*'", "'typedef'", "'='", "'<'", "'>'", "'enum'", "'.'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'?'", "'||'", "'&&'", "'^'", "'&'", "'=='", "'!='", "'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'/'", "'%'", "'++'", "'--'", "'sizeof'", "'~'", "'!'", "'->'", "'u8'", "'u'", "'U'", "'L'", "'l'", "'f'", "'F'", "'bool'", "'char'", "'short'", "'int'", "'long'", "'signed'", "'unsigned'", "'float'", "'double'", "'void'", "'const'", "'volatile'", "'static'", "'NONE'", "'is_pc'", "'delete'", "'is_interlock_for'", "'no_cont'", "'cond'", "'flush'", "'struct'", "'union'", "'s'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RULE_DECIMALINT=18;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=19;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=21;
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
    public static final int RULE_RIGHT_BR=9;
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
    public static final int RULE_BINARYINT=15;
    public static final int RULE_HEXADECIMALINT=16;
    public static final int RULE_OCTALINT=17;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=11;
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
    public static final int T__90=90;
    public static final int RULE_BOOLEAN=12;
    public static final int RULE_CHARCONST=13;
    public static final int RULE_VLOGINT=14;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__24=24;
    public static final int T__25=25;
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
    public static final int RULE_SL_COMMENT=22;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int RULE_VLOGVAL=7;
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
    public static final int RULE_WS=23;
    public static final int RULE_ANY_OTHER=20;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int RULE_LEFT_BR=8;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=10;
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

                if ( (LA1_0==24) ) {
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

                if ( (LA2_0==25||LA2_0==34) ) {
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
            otherlv_0=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
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

            if ( (LA3_0==25) ) {
                alt3=1;
            }
            else if ( (LA3_0==34) ) {
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
            otherlv_0=(Token)match(input,25,FOLLOW_6); if (state.failed) return current;
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

            if ( (LA4_0==26) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalCoreDsl.g:237:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,27,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:259:3: (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==28) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalCoreDsl.g:260:4: otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getInstructionSetAccess().getConstantsKeyword_4_0());
                      			
                    }
                    otherlv_6=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:268:4: ( (lv_constants_7_0= ruleDeclaration ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_LEFT_BR||LA5_0==45||LA5_0==61||LA5_0==65||(LA5_0>=105 && LA5_0<=117)||(LA5_0>=125 && LA5_0<=126)) ) {
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

                    otherlv_8=(Token)match(input,29,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:292:3: (otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==30) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalCoreDsl.g:293:4: otherlv_9= 'address_spaces' otherlv_10= '{' ( (lv_spaces_11_0= ruleDeclaration ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getInstructionSetAccess().getAddress_spacesKeyword_5_0());
                      			
                    }
                    otherlv_10=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_5_1());
                      			
                    }
                    // InternalCoreDsl.g:301:4: ( (lv_spaces_11_0= ruleDeclaration ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_LEFT_BR||LA7_0==45||LA7_0==61||LA7_0==65||(LA7_0>=105 && LA7_0<=117)||(LA7_0>=125 && LA7_0<=126)) ) {
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

                    otherlv_12=(Token)match(input,29,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:325:3: (otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==31) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalCoreDsl.g:326:4: otherlv_13= 'registers' otherlv_14= '{' ( (lv_regs_15_0= ruleDeclaration ) )+ otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,31,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getInstructionSetAccess().getRegistersKeyword_6_0());
                      			
                    }
                    otherlv_14=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_6_1());
                      			
                    }
                    // InternalCoreDsl.g:334:4: ( (lv_regs_15_0= ruleDeclaration ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_LEFT_BR||LA9_0==45||LA9_0==61||LA9_0==65||(LA9_0>=105 && LA9_0<=117)||(LA9_0>=125 && LA9_0<=126)) ) {
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

                    otherlv_16=(Token)match(input,29,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:358:3: (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==32) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalCoreDsl.g:359:4: otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,32,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getInstructionSetAccess().getFunctionsKeyword_7_0());
                      			
                    }
                    otherlv_18=(Token)match(input,27,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_7_1());
                      			
                    }
                    // InternalCoreDsl.g:367:4: ( (lv_func_19_0= ruleFunctionDefinition ) )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==45||LA11_0==65||(LA11_0>=105 && LA11_0<=114)||(LA11_0>=125 && LA11_0<=126)) ) {
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

                    otherlv_20=(Token)match(input,29,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_7_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:391:3: (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' )
            // InternalCoreDsl.g:392:4: otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}'
            {
            otherlv_21=(Token)match(input,33,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_21, grammarAccess.getInstructionSetAccess().getInstructionsKeyword_8_0());
              			
            }
            otherlv_22=(Token)match(input,27,FOLLOW_6); if (state.failed) return current;
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

            otherlv_24=(Token)match(input,29,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_24, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_8_3());
              			
            }

            }

            otherlv_25=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,34,FOLLOW_6); if (state.failed) return current;
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

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalCoreDsl.g:470:4: otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
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

                        if ( (LA14_0==36) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalCoreDsl.g:488:5: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,27,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:511:3: (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalCoreDsl.g:512:4: otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getCoreDefAccess().getConstantsKeyword_4_0());
                      			
                    }
                    otherlv_8=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:520:4: ( (lv_constants_9_0= ruleDeclaration ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_LEFT_BR||LA16_0==45||LA16_0==61||LA16_0==65||(LA16_0>=105 && LA16_0<=117)||(LA16_0>=125 && LA16_0<=126)) ) {
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

                    otherlv_10=(Token)match(input,29,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:544:3: (otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalCoreDsl.g:545:4: otherlv_11= 'address_spaces' otherlv_12= '{' ( (lv_spaces_13_0= ruleDeclaration ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getCoreDefAccess().getAddress_spacesKeyword_5_0());
                      			
                    }
                    otherlv_12=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_5_1());
                      			
                    }
                    // InternalCoreDsl.g:553:4: ( (lv_spaces_13_0= ruleDeclaration ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_LEFT_BR||LA18_0==45||LA18_0==61||LA18_0==65||(LA18_0>=105 && LA18_0<=117)||(LA18_0>=125 && LA18_0<=126)) ) {
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

                    otherlv_14=(Token)match(input,29,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:577:3: (otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalCoreDsl.g:578:4: otherlv_15= 'registers' otherlv_16= '{' ( (lv_regs_17_0= ruleDeclaration ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,31,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getCoreDefAccess().getRegistersKeyword_6_0());
                      			
                    }
                    otherlv_16=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_6_1());
                      			
                    }
                    // InternalCoreDsl.g:586:4: ( (lv_regs_17_0= ruleDeclaration ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_LEFT_BR||LA20_0==45||LA20_0==61||LA20_0==65||(LA20_0>=105 && LA20_0<=117)||(LA20_0>=125 && LA20_0<=126)) ) {
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

                    otherlv_18=(Token)match(input,29,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:610:3: (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalCoreDsl.g:611:4: otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,33,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getCoreDefAccess().getInstructionsKeyword_7_0());
                      			
                    }
                    otherlv_20=(Token)match(input,27,FOLLOW_6); if (state.failed) return current;
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

                    otherlv_22=(Token)match(input,29,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_22, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_7_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_23=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:658:1: ruleInstruction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* ruleDoubleRightBracket )? otherlv_6= '{' (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' ) (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )? (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) ) otherlv_18= '}' ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
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
            // InternalCoreDsl.g:664:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* ruleDoubleRightBracket )? otherlv_6= '{' (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' ) (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )? (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) ) otherlv_18= '}' ) )
            // InternalCoreDsl.g:665:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* ruleDoubleRightBracket )? otherlv_6= '{' (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' ) (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )? (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) ) otherlv_18= '}' )
            {
            // InternalCoreDsl.g:665:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* ruleDoubleRightBracket )? otherlv_6= '{' (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' ) (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )? (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) ) otherlv_18= '}' )
            // InternalCoreDsl.g:666:3: ( (lv_name_0_0= RULE_ID ) ) ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* ruleDoubleRightBracket )? otherlv_6= '{' (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' ) (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )? (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) ) otherlv_18= '}'
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

            // InternalCoreDsl.g:684:3: ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* ruleDoubleRightBracket )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_LEFT_BR) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalCoreDsl.g:685:4: ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )* ruleDoubleRightBracket
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getInstructionAccess().getDoubleLeftBracketParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_27);
                    ruleDoubleLeftBracket();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:692:4: ( (lv_attributes_2_0= ruleInstrAttribute ) )
                    // InternalCoreDsl.g:693:5: (lv_attributes_2_0= ruleInstrAttribute )
                    {
                    // InternalCoreDsl.g:693:5: (lv_attributes_2_0= ruleInstrAttribute )
                    // InternalCoreDsl.g:694:6: lv_attributes_2_0= ruleInstrAttribute
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

                    // InternalCoreDsl.g:711:4: (otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==36) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalCoreDsl.g:712:5: otherlv_3= ',' ( (lv_attributes_4_0= ruleInstrAttribute ) )
                    	    {
                    	    otherlv_3=(Token)match(input,36,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getInstructionAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:716:5: ( (lv_attributes_4_0= ruleInstrAttribute ) )
                    	    // InternalCoreDsl.g:717:6: (lv_attributes_4_0= ruleInstrAttribute )
                    	    {
                    	    // InternalCoreDsl.g:717:6: (lv_attributes_4_0= ruleInstrAttribute )
                    	    // InternalCoreDsl.g:718:7: lv_attributes_4_0= ruleInstrAttribute
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

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getInstructionAccess().getDoubleRightBracketParserRuleCall_1_3());
                      			
                    }
                    pushFollow(FOLLOW_8);
                    ruleDoubleRightBracket();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_6=(Token)match(input,27,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getInstructionAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalCoreDsl.g:748:3: (otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';' )
            // InternalCoreDsl.g:749:4: otherlv_7= 'encoding' otherlv_8= ':' ( (lv_encoding_9_0= ruleEncoding ) ) otherlv_10= ';'
            {
            otherlv_7=(Token)match(input,37,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_7, grammarAccess.getInstructionAccess().getEncodingKeyword_3_0());
              			
            }
            otherlv_8=(Token)match(input,38,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_8, grammarAccess.getInstructionAccess().getColonKeyword_3_1());
              			
            }
            // InternalCoreDsl.g:757:4: ( (lv_encoding_9_0= ruleEncoding ) )
            // InternalCoreDsl.g:758:5: (lv_encoding_9_0= ruleEncoding )
            {
            // InternalCoreDsl.g:758:5: (lv_encoding_9_0= ruleEncoding )
            // InternalCoreDsl.g:759:6: lv_encoding_9_0= ruleEncoding
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

            otherlv_10=(Token)match(input,39,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_10, grammarAccess.getInstructionAccess().getSemicolonKeyword_3_3());
              			
            }

            }

            // InternalCoreDsl.g:781:3: (otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==40) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalCoreDsl.g:782:4: otherlv_11= 'args_disass' otherlv_12= ':' ( (lv_disass_13_0= RULE_STRING ) ) otherlv_14= ';'
                    {
                    otherlv_11=(Token)match(input,40,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getInstructionAccess().getArgs_disassKeyword_4_0());
                      			
                    }
                    otherlv_12=(Token)match(input,38,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getInstructionAccess().getColonKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:790:4: ( (lv_disass_13_0= RULE_STRING ) )
                    // InternalCoreDsl.g:791:5: (lv_disass_13_0= RULE_STRING )
                    {
                    // InternalCoreDsl.g:791:5: (lv_disass_13_0= RULE_STRING )
                    // InternalCoreDsl.g:792:6: lv_disass_13_0= RULE_STRING
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

                    otherlv_14=(Token)match(input,39,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getInstructionAccess().getSemicolonKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:813:3: (otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) ) )
            // InternalCoreDsl.g:814:4: otherlv_15= 'behavior' otherlv_16= ':' ( (lv_behavior_17_0= ruleCompoundStatement ) )
            {
            otherlv_15=(Token)match(input,41,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_15, grammarAccess.getInstructionAccess().getBehaviorKeyword_5_0());
              			
            }
            otherlv_16=(Token)match(input,38,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_16, grammarAccess.getInstructionAccess().getColonKeyword_5_1());
              			
            }
            // InternalCoreDsl.g:822:4: ( (lv_behavior_17_0= ruleCompoundStatement ) )
            // InternalCoreDsl.g:823:5: (lv_behavior_17_0= ruleCompoundStatement )
            {
            // InternalCoreDsl.g:823:5: (lv_behavior_17_0= ruleCompoundStatement )
            // InternalCoreDsl.g:824:6: lv_behavior_17_0= ruleCompoundStatement
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

            otherlv_18=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:850:1: entryRuleEncoding returns [EObject current=null] : iv_ruleEncoding= ruleEncoding EOF ;
    public final EObject entryRuleEncoding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEncoding = null;


        try {
            // InternalCoreDsl.g:850:49: (iv_ruleEncoding= ruleEncoding EOF )
            // InternalCoreDsl.g:851:2: iv_ruleEncoding= ruleEncoding EOF
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
    // InternalCoreDsl.g:857:1: ruleEncoding returns [EObject current=null] : ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' | (otherlv_2= '::' ( (lv_fields_3_0= ruleField ) ) ) )* ) ;
    public final EObject ruleEncoding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_fields_0_0 = null;

        EObject lv_fields_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:863:2: ( ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' | (otherlv_2= '::' ( (lv_fields_3_0= ruleField ) ) ) )* ) )
            // InternalCoreDsl.g:864:2: ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' | (otherlv_2= '::' ( (lv_fields_3_0= ruleField ) ) ) )* )
            {
            // InternalCoreDsl.g:864:2: ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' | (otherlv_2= '::' ( (lv_fields_3_0= ruleField ) ) ) )* )
            // InternalCoreDsl.g:865:3: ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '|' | (otherlv_2= '::' ( (lv_fields_3_0= ruleField ) ) ) )*
            {
            // InternalCoreDsl.g:865:3: ( (lv_fields_0_0= ruleField ) )
            // InternalCoreDsl.g:866:4: (lv_fields_0_0= ruleField )
            {
            // InternalCoreDsl.g:866:4: (lv_fields_0_0= ruleField )
            // InternalCoreDsl.g:867:5: lv_fields_0_0= ruleField
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

            // InternalCoreDsl.g:884:3: (otherlv_1= '|' | (otherlv_2= '::' ( (lv_fields_3_0= ruleField ) ) ) )*
            loop27:
            do {
                int alt27=3;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==42) ) {
                    alt27=1;
                }
                else if ( (LA27_0==43) ) {
                    alt27=2;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalCoreDsl.g:885:4: otherlv_1= '|'
            	    {
            	    otherlv_1=(Token)match(input,42,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getEncodingAccess().getVerticalLineKeyword_1_0());
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // InternalCoreDsl.g:890:4: (otherlv_2= '::' ( (lv_fields_3_0= ruleField ) ) )
            	    {
            	    // InternalCoreDsl.g:890:4: (otherlv_2= '::' ( (lv_fields_3_0= ruleField ) ) )
            	    // InternalCoreDsl.g:891:5: otherlv_2= '::' ( (lv_fields_3_0= ruleField ) )
            	    {
            	    otherlv_2=(Token)match(input,43,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getEncodingAccess().getColonColonKeyword_1_1_0());
            	      				
            	    }
            	    // InternalCoreDsl.g:895:5: ( (lv_fields_3_0= ruleField ) )
            	    // InternalCoreDsl.g:896:6: (lv_fields_3_0= ruleField )
            	    {
            	    // InternalCoreDsl.g:896:6: (lv_fields_3_0= ruleField )
            	    // InternalCoreDsl.g:897:7: lv_fields_3_0= ruleField
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getEncodingAccess().getFieldsFieldParserRuleCall_1_1_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_fields_3_0=ruleField();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getEncodingRule());
            	      							}
            	      							add(
            	      								current,
            	      								"fields",
            	      								lv_fields_3_0,
            	      								"com.minres.coredsl.CoreDsl.Field");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

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
    // InternalCoreDsl.g:920:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalCoreDsl.g:920:46: (iv_ruleField= ruleField EOF )
            // InternalCoreDsl.g:921:2: iv_ruleField= ruleField EOF
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
    // InternalCoreDsl.g:927:1: ruleField returns [EObject current=null] : (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        EObject this_BitValue_0 = null;

        EObject this_BitField_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:933:2: ( (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField ) )
            // InternalCoreDsl.g:934:2: (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField )
            {
            // InternalCoreDsl.g:934:2: (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_BVAL && LA28_0<=RULE_VLOGVAL)) ) {
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
                    // InternalCoreDsl.g:935:3: this_BitValue_0= ruleBitValue
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
                    // InternalCoreDsl.g:944:3: this_BitField_1= ruleBitField
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
    // InternalCoreDsl.g:956:1: entryRuleBitValue returns [EObject current=null] : iv_ruleBitValue= ruleBitValue EOF ;
    public final EObject entryRuleBitValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitValue = null;


        try {
            // InternalCoreDsl.g:956:49: (iv_ruleBitValue= ruleBitValue EOF )
            // InternalCoreDsl.g:957:2: iv_ruleBitValue= ruleBitValue EOF
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
    // InternalCoreDsl.g:963:1: ruleBitValue returns [EObject current=null] : ( ( (lv_name_0_1= RULE_BVAL | lv_name_0_2= RULE_VLOGVAL ) ) ) ;
    public final EObject ruleBitValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:969:2: ( ( ( (lv_name_0_1= RULE_BVAL | lv_name_0_2= RULE_VLOGVAL ) ) ) )
            // InternalCoreDsl.g:970:2: ( ( (lv_name_0_1= RULE_BVAL | lv_name_0_2= RULE_VLOGVAL ) ) )
            {
            // InternalCoreDsl.g:970:2: ( ( (lv_name_0_1= RULE_BVAL | lv_name_0_2= RULE_VLOGVAL ) ) )
            // InternalCoreDsl.g:971:3: ( (lv_name_0_1= RULE_BVAL | lv_name_0_2= RULE_VLOGVAL ) )
            {
            // InternalCoreDsl.g:971:3: ( (lv_name_0_1= RULE_BVAL | lv_name_0_2= RULE_VLOGVAL ) )
            // InternalCoreDsl.g:972:4: (lv_name_0_1= RULE_BVAL | lv_name_0_2= RULE_VLOGVAL )
            {
            // InternalCoreDsl.g:972:4: (lv_name_0_1= RULE_BVAL | lv_name_0_2= RULE_VLOGVAL )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_BVAL) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_VLOGVAL) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalCoreDsl.g:973:5: lv_name_0_1= RULE_BVAL
                    {
                    lv_name_0_1=(Token)match(input,RULE_BVAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_name_0_1, grammarAccess.getBitValueAccess().getNameBVALTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBitValueRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"name",
                      						lv_name_0_1,
                      						"com.minres.coredsl.CoreDsl.BVAL");
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:988:5: lv_name_0_2= RULE_VLOGVAL
                    {
                    lv_name_0_2=(Token)match(input,RULE_VLOGVAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_name_0_2, grammarAccess.getBitValueAccess().getNameVLOGVALTerminalRuleCall_0_1());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBitValueRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"name",
                      						lv_name_0_2,
                      						"com.minres.coredsl.CoreDsl.VLOGVAL");
                      				
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
    // $ANTLR end "ruleBitValue"


    // $ANTLR start "entryRuleBitField"
    // InternalCoreDsl.g:1008:1: entryRuleBitField returns [EObject current=null] : iv_ruleBitField= ruleBitField EOF ;
    public final EObject entryRuleBitField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitField = null;


        try {
            // InternalCoreDsl.g:1008:49: (iv_ruleBitField= ruleBitField EOF )
            // InternalCoreDsl.g:1009:2: iv_ruleBitField= ruleBitField EOF
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
    // InternalCoreDsl.g:1015:1: ruleBitField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? ) ;
    public final EObject ruleBitField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        EObject lv_bitRange_1_0 = null;

        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1021:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? ) )
            // InternalCoreDsl.g:1022:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? )
            {
            // InternalCoreDsl.g:1022:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? )
            // InternalCoreDsl.g:1023:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )?
            {
            // InternalCoreDsl.g:1023:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:1024:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:1024:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:1025:5: lv_name_0_0= RULE_ID
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

            // InternalCoreDsl.g:1041:3: ( (lv_bitRange_1_0= ruleRangeSpec ) )
            // InternalCoreDsl.g:1042:4: (lv_bitRange_1_0= ruleRangeSpec )
            {
            // InternalCoreDsl.g:1042:4: (lv_bitRange_1_0= ruleRangeSpec )
            // InternalCoreDsl.g:1043:5: lv_bitRange_1_0= ruleRangeSpec
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

            // InternalCoreDsl.g:1060:3: ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==44||LA31_0==99||LA31_0==127) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalCoreDsl.g:1061:4: (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) )
                    {
                    // InternalCoreDsl.g:1061:4: (otherlv_2= '\\'' )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==44) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalCoreDsl.g:1062:5: otherlv_2= '\\''
                            {
                            otherlv_2=(Token)match(input,44,FOLLOW_38); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getBitFieldAccess().getApostropheKeyword_2_0());
                              				
                            }

                            }
                            break;

                    }

                    // InternalCoreDsl.g:1067:4: ( (lv_type_3_0= ruleBitfieldDataType ) )
                    // InternalCoreDsl.g:1068:5: (lv_type_3_0= ruleBitfieldDataType )
                    {
                    // InternalCoreDsl.g:1068:5: (lv_type_3_0= ruleBitfieldDataType )
                    // InternalCoreDsl.g:1069:6: lv_type_3_0= ruleBitfieldDataType
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
    // InternalCoreDsl.g:1091:1: entryRuleRangeSpec returns [EObject current=null] : iv_ruleRangeSpec= ruleRangeSpec EOF ;
    public final EObject entryRuleRangeSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeSpec = null;


        try {
            // InternalCoreDsl.g:1091:50: (iv_ruleRangeSpec= ruleRangeSpec EOF )
            // InternalCoreDsl.g:1092:2: iv_ruleRangeSpec= ruleRangeSpec EOF
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
    // InternalCoreDsl.g:1098:1: ruleRangeSpec returns [EObject current=null] : (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_left_1_0= ruleIntegerConstant ) ) otherlv_2= ':' ( (lv_right_3_0= ruleIntegerConstant ) ) this_RIGHT_BR_4= RULE_RIGHT_BR ) ;
    public final EObject ruleRangeSpec() throws RecognitionException {
        EObject current = null;

        Token this_LEFT_BR_0=null;
        Token otherlv_2=null;
        Token this_RIGHT_BR_4=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1104:2: ( (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_left_1_0= ruleIntegerConstant ) ) otherlv_2= ':' ( (lv_right_3_0= ruleIntegerConstant ) ) this_RIGHT_BR_4= RULE_RIGHT_BR ) )
            // InternalCoreDsl.g:1105:2: (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_left_1_0= ruleIntegerConstant ) ) otherlv_2= ':' ( (lv_right_3_0= ruleIntegerConstant ) ) this_RIGHT_BR_4= RULE_RIGHT_BR )
            {
            // InternalCoreDsl.g:1105:2: (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_left_1_0= ruleIntegerConstant ) ) otherlv_2= ':' ( (lv_right_3_0= ruleIntegerConstant ) ) this_RIGHT_BR_4= RULE_RIGHT_BR )
            // InternalCoreDsl.g:1106:3: this_LEFT_BR_0= RULE_LEFT_BR ( (lv_left_1_0= ruleIntegerConstant ) ) otherlv_2= ':' ( (lv_right_3_0= ruleIntegerConstant ) ) this_RIGHT_BR_4= RULE_RIGHT_BR
            {
            this_LEFT_BR_0=(Token)match(input,RULE_LEFT_BR,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_LEFT_BR_0, grammarAccess.getRangeSpecAccess().getLEFT_BRTerminalRuleCall_0());
              		
            }
            // InternalCoreDsl.g:1110:3: ( (lv_left_1_0= ruleIntegerConstant ) )
            // InternalCoreDsl.g:1111:4: (lv_left_1_0= ruleIntegerConstant )
            {
            // InternalCoreDsl.g:1111:4: (lv_left_1_0= ruleIntegerConstant )
            // InternalCoreDsl.g:1112:5: lv_left_1_0= ruleIntegerConstant
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRangeSpecAccess().getLeftIntegerConstantParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_30);
            lv_left_1_0=ruleIntegerConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRangeSpecRule());
              					}
              					set(
              						current,
              						"left",
              						lv_left_1_0,
              						"com.minres.coredsl.CoreDsl.IntegerConstant");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRangeSpecAccess().getColonKeyword_2());
              		
            }
            // InternalCoreDsl.g:1133:3: ( (lv_right_3_0= ruleIntegerConstant ) )
            // InternalCoreDsl.g:1134:4: (lv_right_3_0= ruleIntegerConstant )
            {
            // InternalCoreDsl.g:1134:4: (lv_right_3_0= ruleIntegerConstant )
            // InternalCoreDsl.g:1135:5: lv_right_3_0= ruleIntegerConstant
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRangeSpecAccess().getRightIntegerConstantParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_40);
            lv_right_3_0=ruleIntegerConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRangeSpecRule());
              					}
              					set(
              						current,
              						"right",
              						lv_right_3_0,
              						"com.minres.coredsl.CoreDsl.IntegerConstant");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            this_RIGHT_BR_4=(Token)match(input,RULE_RIGHT_BR,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_RIGHT_BR_4, grammarAccess.getRangeSpecAccess().getRIGHT_BRTerminalRuleCall_4());
              		
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
    // InternalCoreDsl.g:1160:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalCoreDsl.g:1160:59: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalCoreDsl.g:1161:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
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
    // InternalCoreDsl.g:1167:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_extern_0_0= 'extern' ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' ( (lv_statement_6_0= ruleCompoundStatement ) )? ) ;
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
            // InternalCoreDsl.g:1173:2: ( ( ( (lv_extern_0_0= 'extern' ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' ( (lv_statement_6_0= ruleCompoundStatement ) )? ) )
            // InternalCoreDsl.g:1174:2: ( ( (lv_extern_0_0= 'extern' ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' ( (lv_statement_6_0= ruleCompoundStatement ) )? )
            {
            // InternalCoreDsl.g:1174:2: ( ( (lv_extern_0_0= 'extern' ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' ( (lv_statement_6_0= ruleCompoundStatement ) )? )
            // InternalCoreDsl.g:1175:3: ( (lv_extern_0_0= 'extern' ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' ( (lv_statement_6_0= ruleCompoundStatement ) )?
            {
            // InternalCoreDsl.g:1175:3: ( (lv_extern_0_0= 'extern' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==45) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalCoreDsl.g:1176:4: (lv_extern_0_0= 'extern' )
                    {
                    // InternalCoreDsl.g:1176:4: (lv_extern_0_0= 'extern' )
                    // InternalCoreDsl.g:1177:5: lv_extern_0_0= 'extern'
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

            // InternalCoreDsl.g:1189:3: ( (lv_type_1_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:1190:4: (lv_type_1_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:1190:4: (lv_type_1_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:1191:5: lv_type_1_0= ruleTypeSpecifier
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

            // InternalCoreDsl.g:1208:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalCoreDsl.g:1209:4: (lv_name_2_0= RULE_ID )
            {
            // InternalCoreDsl.g:1209:4: (lv_name_2_0= RULE_ID )
            // InternalCoreDsl.g:1210:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,46,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalCoreDsl.g:1230:3: (this_ParameterList_4= ruleParameterList[$current] )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==65||(LA33_0>=105 && LA33_0<=114)||(LA33_0>=125 && LA33_0<=126)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalCoreDsl.g:1231:4: this_ParameterList_4= ruleParameterList[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                      				}
                      				newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParameterListParserRuleCall_4());
                      			
                    }
                    pushFollow(FOLLOW_43);
                    this_ParameterList_4=ruleParameterList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ParameterList_4;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,47,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_5());
              		
            }
            // InternalCoreDsl.g:1247:3: ( (lv_statement_6_0= ruleCompoundStatement ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==27) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalCoreDsl.g:1248:4: (lv_statement_6_0= ruleCompoundStatement )
                    {
                    // InternalCoreDsl.g:1248:4: (lv_statement_6_0= ruleCompoundStatement )
                    // InternalCoreDsl.g:1249:5: lv_statement_6_0= ruleCompoundStatement
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
    // $ANTLR end "ruleFunctionDefinition"


    // $ANTLR start "ruleParameterList"
    // InternalCoreDsl.g:1271:1: ruleParameterList[EObject in_current] returns [EObject current=in_current] : ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* ) ;
    public final EObject ruleParameterList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_params_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1277:2: ( ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* ) )
            // InternalCoreDsl.g:1278:2: ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* )
            {
            // InternalCoreDsl.g:1278:2: ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* )
            // InternalCoreDsl.g:1279:3: ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )*
            {
            // InternalCoreDsl.g:1279:3: ( (lv_params_0_0= ruleParameterDeclaration ) )
            // InternalCoreDsl.g:1280:4: (lv_params_0_0= ruleParameterDeclaration )
            {
            // InternalCoreDsl.g:1280:4: (lv_params_0_0= ruleParameterDeclaration )
            // InternalCoreDsl.g:1281:5: lv_params_0_0= ruleParameterDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListAccess().getParamsParameterDeclarationParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_45);
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

            // InternalCoreDsl.g:1298:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==36) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalCoreDsl.g:1299:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,36,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:1303:4: ( (lv_parameters_2_0= ruleParameterDeclaration ) )
            	    // InternalCoreDsl.g:1304:5: (lv_parameters_2_0= ruleParameterDeclaration )
            	    {
            	    // InternalCoreDsl.g:1304:5: (lv_parameters_2_0= ruleParameterDeclaration )
            	    // InternalCoreDsl.g:1305:6: lv_parameters_2_0= ruleParameterDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getParametersParameterDeclarationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_45);
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
            	    break loop35;
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
    // InternalCoreDsl.g:1327:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDeclaration = null;


        try {
            // InternalCoreDsl.g:1327:61: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // InternalCoreDsl.g:1328:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
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
    // InternalCoreDsl.g:1334:1: ruleParameterDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_declarator_1_0 = null;

        EObject lv_declarator_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1340:2: ( ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? ) )
            // InternalCoreDsl.g:1341:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? )
            {
            // InternalCoreDsl.g:1341:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? )
            // InternalCoreDsl.g:1342:3: ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )?
            {
            // InternalCoreDsl.g:1342:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:1343:4: (lv_type_0_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:1343:4: (lv_type_0_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:1344:5: lv_type_0_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterDeclarationAccess().getTypeTypeSpecifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_46);
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

            // InternalCoreDsl.g:1361:3: ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )?
            int alt36=3;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_LEFT_BR||LA36_0==46) ) {
                alt36=2;
            }
            switch (alt36) {
                case 1 :
                    // InternalCoreDsl.g:1362:4: ( (lv_declarator_1_0= ruleDirectDeclarator ) )
                    {
                    // InternalCoreDsl.g:1362:4: ( (lv_declarator_1_0= ruleDirectDeclarator ) )
                    // InternalCoreDsl.g:1363:5: (lv_declarator_1_0= ruleDirectDeclarator )
                    {
                    // InternalCoreDsl.g:1363:5: (lv_declarator_1_0= ruleDirectDeclarator )
                    // InternalCoreDsl.g:1364:6: lv_declarator_1_0= ruleDirectDeclarator
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
                    // InternalCoreDsl.g:1382:4: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )
                    {
                    // InternalCoreDsl.g:1382:4: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )
                    // InternalCoreDsl.g:1383:5: (lv_declarator_2_0= ruleAbstractDeclarator )
                    {
                    // InternalCoreDsl.g:1383:5: (lv_declarator_2_0= ruleAbstractDeclarator )
                    // InternalCoreDsl.g:1384:6: lv_declarator_2_0= ruleAbstractDeclarator
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
    // InternalCoreDsl.g:1406:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalCoreDsl.g:1406:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalCoreDsl.g:1407:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalCoreDsl.g:1413:1: ruleStatement returns [EObject current=null] : (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement | this_SpawnStatement_5= ruleSpawnStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_CompoundStatement_0 = null;

        EObject this_ExpressionStatement_1 = null;

        EObject this_SelectionStatement_2 = null;

        EObject this_IterationStatement_3 = null;

        EObject this_JumpStatement_4 = null;

        EObject this_SpawnStatement_5 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1419:2: ( (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement | this_SpawnStatement_5= ruleSpawnStatement ) )
            // InternalCoreDsl.g:1420:2: (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement | this_SpawnStatement_5= ruleSpawnStatement )
            {
            // InternalCoreDsl.g:1420:2: (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement | this_SpawnStatement_5= ruleSpawnStatement )
            int alt37=6;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt37=1;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 39:
            case 46:
            case 60:
            case 81:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 98:
            case 99:
            case 100:
            case 101:
                {
                alt37=2;
                }
                break;
            case 50:
            case 52:
                {
                alt37=3;
                }
                break;
            case 53:
            case 54:
            case 55:
                {
                alt37=4;
                }
                break;
            case 56:
            case 57:
            case 58:
                {
                alt37=5;
                }
                break;
            case 59:
                {
                alt37=6;
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
                    // InternalCoreDsl.g:1421:3: this_CompoundStatement_0= ruleCompoundStatement
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
                    // InternalCoreDsl.g:1430:3: this_ExpressionStatement_1= ruleExpressionStatement
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
                    // InternalCoreDsl.g:1439:3: this_SelectionStatement_2= ruleSelectionStatement
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
                    // InternalCoreDsl.g:1448:3: this_IterationStatement_3= ruleIterationStatement
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
                    // InternalCoreDsl.g:1457:3: this_JumpStatement_4= ruleJumpStatement
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
                case 6 :
                    // InternalCoreDsl.g:1466:3: this_SpawnStatement_5= ruleSpawnStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSpawnStatementParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SpawnStatement_5=ruleSpawnStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SpawnStatement_5;
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
    // InternalCoreDsl.g:1478:1: entryRuleLabeledStatement returns [EObject current=null] : iv_ruleLabeledStatement= ruleLabeledStatement EOF ;
    public final EObject entryRuleLabeledStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabeledStatement = null;


        try {
            // InternalCoreDsl.g:1478:57: (iv_ruleLabeledStatement= ruleLabeledStatement EOF )
            // InternalCoreDsl.g:1479:2: iv_ruleLabeledStatement= ruleLabeledStatement EOF
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
    // InternalCoreDsl.g:1485:1: ruleLabeledStatement returns [EObject current=null] : ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) ) ;
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
            // InternalCoreDsl.g:1491:2: ( ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) ) )
            // InternalCoreDsl.g:1492:2: ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) )
            {
            // InternalCoreDsl.g:1492:2: ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==48) ) {
                alt38=1;
            }
            else if ( (LA38_0==49) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalCoreDsl.g:1493:3: (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:1493:3: (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:1494:4: otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) )
                    {
                    otherlv_0=(Token)match(input,48,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getLabeledStatementAccess().getCaseKeyword_0_0());
                      			
                    }
                    // InternalCoreDsl.g:1498:4: ( (lv_constExpr_1_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:1499:5: (lv_constExpr_1_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:1499:5: (lv_constExpr_1_0= ruleConstantExpression )
                    // InternalCoreDsl.g:1500:6: lv_constExpr_1_0= ruleConstantExpression
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

                    otherlv_2=(Token)match(input,38,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getLabeledStatementAccess().getColonKeyword_0_2());
                      			
                    }
                    // InternalCoreDsl.g:1521:4: ( (lv_stmt_3_0= ruleStatement ) )
                    // InternalCoreDsl.g:1522:5: (lv_stmt_3_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1522:5: (lv_stmt_3_0= ruleStatement )
                    // InternalCoreDsl.g:1523:6: lv_stmt_3_0= ruleStatement
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
                    // InternalCoreDsl.g:1542:3: (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:1542:3: (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:1543:4: otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) )
                    {
                    otherlv_4=(Token)match(input,49,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getLabeledStatementAccess().getDefaultKeyword_1_0());
                      			
                    }
                    otherlv_5=(Token)match(input,38,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getLabeledStatementAccess().getColonKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:1551:4: ( (lv_stmt_6_0= ruleStatement ) )
                    // InternalCoreDsl.g:1552:5: (lv_stmt_6_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1552:5: (lv_stmt_6_0= ruleStatement )
                    // InternalCoreDsl.g:1553:6: lv_stmt_6_0= ruleStatement
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
    // InternalCoreDsl.g:1575:1: entryRuleCompoundStatement returns [EObject current=null] : iv_ruleCompoundStatement= ruleCompoundStatement EOF ;
    public final EObject entryRuleCompoundStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundStatement = null;


        try {
            // InternalCoreDsl.g:1575:58: (iv_ruleCompoundStatement= ruleCompoundStatement EOF )
            // InternalCoreDsl.g:1576:2: iv_ruleCompoundStatement= ruleCompoundStatement EOF
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
    // InternalCoreDsl.g:1582:1: ruleCompoundStatement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' ) ;
    public final EObject ruleCompoundStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_items_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1588:2: ( ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' ) )
            // InternalCoreDsl.g:1589:2: ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' )
            {
            // InternalCoreDsl.g:1589:2: ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' )
            // InternalCoreDsl.g:1590:3: () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}'
            {
            // InternalCoreDsl.g:1590:3: ()
            // InternalCoreDsl.g:1591:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCompoundStatementAccess().getCompoundStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,27,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundStatementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalCoreDsl.g:1601:3: ( (lv_items_2_0= ruleBlockItem ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_ID)||LA39_0==RULE_LEFT_BR||(LA39_0>=RULE_INTEGER && LA39_0<=RULE_CHARCONST)||LA39_0==27||LA39_0==39||(LA39_0>=45 && LA39_0<=46)||LA39_0==50||(LA39_0>=52 && LA39_0<=61)||LA39_0==65||LA39_0==81||(LA39_0>=88 && LA39_0<=89)||(LA39_0>=92 && LA39_0<=96)||(LA39_0>=98 && LA39_0<=101)||(LA39_0>=105 && LA39_0<=117)||(LA39_0>=125 && LA39_0<=126)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalCoreDsl.g:1602:4: (lv_items_2_0= ruleBlockItem )
            	    {
            	    // InternalCoreDsl.g:1602:4: (lv_items_2_0= ruleBlockItem )
            	    // InternalCoreDsl.g:1603:5: lv_items_2_0= ruleBlockItem
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundStatementAccess().getItemsBlockItemParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_49);
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
            	    break loop39;
                }
            } while (true);

            otherlv_3=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:1628:1: entryRuleBlockItem returns [EObject current=null] : iv_ruleBlockItem= ruleBlockItem EOF ;
    public final EObject entryRuleBlockItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockItem = null;


        try {
            // InternalCoreDsl.g:1628:50: (iv_ruleBlockItem= ruleBlockItem EOF )
            // InternalCoreDsl.g:1629:2: iv_ruleBlockItem= ruleBlockItem EOF
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
    // InternalCoreDsl.g:1635:1: ruleBlockItem returns [EObject current=null] : (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration ) ;
    public final EObject ruleBlockItem() throws RecognitionException {
        EObject current = null;

        EObject this_Statement_0 = null;

        EObject this_Declaration_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1641:2: ( (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration ) )
            // InternalCoreDsl.g:1642:2: (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration )
            {
            // InternalCoreDsl.g:1642:2: (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||(LA40_0>=RULE_INTEGER && LA40_0<=RULE_CHARCONST)||LA40_0==27||LA40_0==39||LA40_0==46||LA40_0==50||(LA40_0>=52 && LA40_0<=60)||LA40_0==81||(LA40_0>=88 && LA40_0<=89)||(LA40_0>=92 && LA40_0<=96)||(LA40_0>=98 && LA40_0<=101)) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_LEFT_BR||LA40_0==45||LA40_0==61||LA40_0==65||(LA40_0>=105 && LA40_0<=117)||(LA40_0>=125 && LA40_0<=126)) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalCoreDsl.g:1643:3: this_Statement_0= ruleStatement
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
                    // InternalCoreDsl.g:1652:3: this_Declaration_1= ruleDeclaration
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
    // InternalCoreDsl.g:1664:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalCoreDsl.g:1664:60: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalCoreDsl.g:1665:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
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
    // InternalCoreDsl.g:1671:1: ruleExpressionStatement returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1677:2: ( ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' ) )
            // InternalCoreDsl.g:1678:2: ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' )
            {
            // InternalCoreDsl.g:1678:2: ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' )
            // InternalCoreDsl.g:1679:3: () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';'
            {
            // InternalCoreDsl.g:1679:3: ()
            // InternalCoreDsl.g:1680:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExpressionStatementAccess().getExpressionStatementAction_0(),
              					current);
              			
            }

            }

            // InternalCoreDsl.g:1686:3: ( (lv_expr_1_0= ruleAssignmentExpression ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_STRING && LA41_0<=RULE_ID)||(LA41_0>=RULE_INTEGER && LA41_0<=RULE_CHARCONST)||LA41_0==46||LA41_0==60||LA41_0==81||(LA41_0>=88 && LA41_0<=89)||(LA41_0>=92 && LA41_0<=96)||(LA41_0>=98 && LA41_0<=101)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalCoreDsl.g:1687:4: (lv_expr_1_0= ruleAssignmentExpression )
                    {
                    // InternalCoreDsl.g:1687:4: (lv_expr_1_0= ruleAssignmentExpression )
                    // InternalCoreDsl.g:1688:5: lv_expr_1_0= ruleAssignmentExpression
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

            otherlv_2=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:1713:1: entryRuleSelectionStatement returns [EObject current=null] : iv_ruleSelectionStatement= ruleSelectionStatement EOF ;
    public final EObject entryRuleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionStatement = null;


        try {
            // InternalCoreDsl.g:1713:59: (iv_ruleSelectionStatement= ruleSelectionStatement EOF )
            // InternalCoreDsl.g:1714:2: iv_ruleSelectionStatement= ruleSelectionStatement EOF
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
    // InternalCoreDsl.g:1720:1: ruleSelectionStatement returns [EObject current=null] : (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement ) ;
    public final EObject ruleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject this_IfStatement_0 = null;

        EObject this_SwitchStatement_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1726:2: ( (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement ) )
            // InternalCoreDsl.g:1727:2: (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement )
            {
            // InternalCoreDsl.g:1727:2: (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==50) ) {
                alt42=1;
            }
            else if ( (LA42_0==52) ) {
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
                    // InternalCoreDsl.g:1728:3: this_IfStatement_0= ruleIfStatement
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
                    // InternalCoreDsl.g:1737:3: this_SwitchStatement_1= ruleSwitchStatement
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
    // InternalCoreDsl.g:1749:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalCoreDsl.g:1749:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalCoreDsl.g:1750:2: iv_ruleIfStatement= ruleIfStatement EOF
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
    // InternalCoreDsl.g:1756:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? ) ;
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
            // InternalCoreDsl.g:1762:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? ) )
            // InternalCoreDsl.g:1763:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? )
            {
            // InternalCoreDsl.g:1763:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? )
            // InternalCoreDsl.g:1764:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )?
            {
            otherlv_0=(Token)match(input,50,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,46,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalCoreDsl.g:1772:3: ( (lv_cond_2_0= ruleConditionalExpression ) )
            // InternalCoreDsl.g:1773:4: (lv_cond_2_0= ruleConditionalExpression )
            {
            // InternalCoreDsl.g:1773:4: (lv_cond_2_0= ruleConditionalExpression )
            // InternalCoreDsl.g:1774:5: lv_cond_2_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getCondConditionalExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_43);
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

            otherlv_3=(Token)match(input,47,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalCoreDsl.g:1795:3: ( (lv_thenStmt_4_0= ruleStatement ) )
            // InternalCoreDsl.g:1796:4: (lv_thenStmt_4_0= ruleStatement )
            {
            // InternalCoreDsl.g:1796:4: (lv_thenStmt_4_0= ruleStatement )
            // InternalCoreDsl.g:1797:5: lv_thenStmt_4_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getThenStmtStatementParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_50);
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

            // InternalCoreDsl.g:1814:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==51) ) {
                int LA43_1 = input.LA(2);

                if ( (synpred1_InternalCoreDsl()) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalCoreDsl.g:1815:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) )
                    {
                    // InternalCoreDsl.g:1815:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalCoreDsl.g:1816:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,51,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfStatementAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalCoreDsl.g:1822:4: ( (lv_elseStmt_6_0= ruleStatement ) )
                    // InternalCoreDsl.g:1823:5: (lv_elseStmt_6_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1823:5: (lv_elseStmt_6_0= ruleStatement )
                    // InternalCoreDsl.g:1824:6: lv_elseStmt_6_0= ruleStatement
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
    // InternalCoreDsl.g:1846:1: entryRuleSwitchStatement returns [EObject current=null] : iv_ruleSwitchStatement= ruleSwitchStatement EOF ;
    public final EObject entryRuleSwitchStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStatement = null;


        try {
            // InternalCoreDsl.g:1846:56: (iv_ruleSwitchStatement= ruleSwitchStatement EOF )
            // InternalCoreDsl.g:1847:2: iv_ruleSwitchStatement= ruleSwitchStatement EOF
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
    // InternalCoreDsl.g:1853:1: ruleSwitchStatement returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' ) ;
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
            // InternalCoreDsl.g:1859:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' ) )
            // InternalCoreDsl.g:1860:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' )
            {
            // InternalCoreDsl.g:1860:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' )
            // InternalCoreDsl.g:1861:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatementAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,46,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalCoreDsl.g:1869:3: ( (lv_cond_2_0= ruleConditionalExpression ) )
            // InternalCoreDsl.g:1870:4: (lv_cond_2_0= ruleConditionalExpression )
            {
            // InternalCoreDsl.g:1870:4: (lv_cond_2_0= ruleConditionalExpression )
            // InternalCoreDsl.g:1871:5: lv_cond_2_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatementAccess().getCondConditionalExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_43);
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
            otherlv_4=(Token)match(input,27,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatementAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalCoreDsl.g:1896:3: ( (lv_items_5_0= ruleLabeledStatement ) )
            // InternalCoreDsl.g:1897:4: (lv_items_5_0= ruleLabeledStatement )
            {
            // InternalCoreDsl.g:1897:4: (lv_items_5_0= ruleLabeledStatement )
            // InternalCoreDsl.g:1898:5: lv_items_5_0= ruleLabeledStatement
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

            otherlv_6=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:1923:1: entryRuleIterationStatement returns [EObject current=null] : iv_ruleIterationStatement= ruleIterationStatement EOF ;
    public final EObject entryRuleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationStatement = null;


        try {
            // InternalCoreDsl.g:1923:59: (iv_ruleIterationStatement= ruleIterationStatement EOF )
            // InternalCoreDsl.g:1924:2: iv_ruleIterationStatement= ruleIterationStatement EOF
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
    // InternalCoreDsl.g:1930:1: ruleIterationStatement returns [EObject current=null] : ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) ) ;
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
            // InternalCoreDsl.g:1936:2: ( ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) ) )
            // InternalCoreDsl.g:1937:2: ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) )
            {
            // InternalCoreDsl.g:1937:2: ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt44=1;
                }
                break;
            case 54:
                {
                alt44=2;
                }
                break;
            case 55:
                {
                alt44=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalCoreDsl.g:1938:3: ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:1938:3: ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:1939:4: ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) )
                    {
                    // InternalCoreDsl.g:1939:4: ( (lv_type_0_0= 'while' ) )
                    // InternalCoreDsl.g:1940:5: (lv_type_0_0= 'while' )
                    {
                    // InternalCoreDsl.g:1940:5: (lv_type_0_0= 'while' )
                    // InternalCoreDsl.g:1941:6: lv_type_0_0= 'while'
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

                    otherlv_1=(Token)match(input,46,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getIterationStatementAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalCoreDsl.g:1957:4: ( (lv_cond_2_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:1958:5: (lv_cond_2_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:1958:5: (lv_cond_2_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:1959:6: lv_cond_2_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getCondConditionalExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
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

                    otherlv_3=(Token)match(input,47,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getIterationStatementAccess().getRightParenthesisKeyword_0_3());
                      			
                    }
                    // InternalCoreDsl.g:1980:4: ( (lv_stmt_4_0= ruleStatement ) )
                    // InternalCoreDsl.g:1981:5: (lv_stmt_4_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1981:5: (lv_stmt_4_0= ruleStatement )
                    // InternalCoreDsl.g:1982:6: lv_stmt_4_0= ruleStatement
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
                    // InternalCoreDsl.g:2001:3: ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' )
                    {
                    // InternalCoreDsl.g:2001:3: ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' )
                    // InternalCoreDsl.g:2002:4: ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';'
                    {
                    // InternalCoreDsl.g:2002:4: ( (lv_type_5_0= 'do' ) )
                    // InternalCoreDsl.g:2003:5: (lv_type_5_0= 'do' )
                    {
                    // InternalCoreDsl.g:2003:5: (lv_type_5_0= 'do' )
                    // InternalCoreDsl.g:2004:6: lv_type_5_0= 'do'
                    {
                    lv_type_5_0=(Token)match(input,54,FOLLOW_48); if (state.failed) return current;
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

                    // InternalCoreDsl.g:2016:4: ( (lv_stmt_6_0= ruleStatement ) )
                    // InternalCoreDsl.g:2017:5: (lv_stmt_6_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:2017:5: (lv_stmt_6_0= ruleStatement )
                    // InternalCoreDsl.g:2018:6: lv_stmt_6_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getStmtStatementParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_52);
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
                    otherlv_8=(Token)match(input,46,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getIterationStatementAccess().getLeftParenthesisKeyword_1_3());
                      			
                    }
                    // InternalCoreDsl.g:2043:4: ( (lv_cond_9_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:2044:5: (lv_cond_9_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:2044:5: (lv_cond_9_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:2045:6: lv_cond_9_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getCondConditionalExpressionParserRuleCall_1_4_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
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
                    otherlv_11=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getIterationStatementAccess().getSemicolonKeyword_1_6());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:2072:3: ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:2072:3: ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:2073:4: ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) )
                    {
                    // InternalCoreDsl.g:2073:4: ( (lv_type_12_0= 'for' ) )
                    // InternalCoreDsl.g:2074:5: (lv_type_12_0= 'for' )
                    {
                    // InternalCoreDsl.g:2074:5: (lv_type_12_0= 'for' )
                    // InternalCoreDsl.g:2075:6: lv_type_12_0= 'for'
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

                    otherlv_13=(Token)match(input,46,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getIterationStatementAccess().getLeftParenthesisKeyword_2_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIterationStatementRule());
                      				}
                      				newCompositeNode(grammarAccess.getIterationStatementAccess().getForConditionParserRuleCall_2_2());
                      			
                    }
                    pushFollow(FOLLOW_43);
                    this_ForCondition_14=ruleForCondition(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ForCondition_14;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_15=(Token)match(input,47,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getIterationStatementAccess().getRightParenthesisKeyword_2_3());
                      			
                    }
                    // InternalCoreDsl.g:2106:4: ( (lv_stmt_16_0= ruleStatement ) )
                    // InternalCoreDsl.g:2107:5: (lv_stmt_16_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:2107:5: (lv_stmt_16_0= ruleStatement )
                    // InternalCoreDsl.g:2108:6: lv_stmt_16_0= ruleStatement
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
    // InternalCoreDsl.g:2131:1: ruleForCondition[EObject in_current] returns [EObject current=in_current] : ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? ) ;
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
            // InternalCoreDsl.g:2137:2: ( ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? ) )
            // InternalCoreDsl.g:2138:2: ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? )
            {
            // InternalCoreDsl.g:2138:2: ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? )
            // InternalCoreDsl.g:2139:3: ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )?
            {
            // InternalCoreDsl.g:2139:3: ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_LEFT_BR||LA46_0==45||LA46_0==61||LA46_0==65||(LA46_0>=105 && LA46_0<=117)||(LA46_0>=125 && LA46_0<=126)) ) {
                alt46=1;
            }
            else if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_ID)||(LA46_0>=RULE_INTEGER && LA46_0<=RULE_CHARCONST)||LA46_0==39||LA46_0==46||LA46_0==60||LA46_0==81||(LA46_0>=88 && LA46_0<=89)||(LA46_0>=92 && LA46_0<=96)||(LA46_0>=98 && LA46_0<=101)) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalCoreDsl.g:2140:4: ( (lv_startDecl_0_0= ruleDeclaration ) )
                    {
                    // InternalCoreDsl.g:2140:4: ( (lv_startDecl_0_0= ruleDeclaration ) )
                    // InternalCoreDsl.g:2141:5: (lv_startDecl_0_0= ruleDeclaration )
                    {
                    // InternalCoreDsl.g:2141:5: (lv_startDecl_0_0= ruleDeclaration )
                    // InternalCoreDsl.g:2142:6: lv_startDecl_0_0= ruleDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getForConditionAccess().getStartDeclDeclarationParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_54);
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
                    // InternalCoreDsl.g:2160:4: ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' )
                    {
                    // InternalCoreDsl.g:2160:4: ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' )
                    // InternalCoreDsl.g:2161:5: ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';'
                    {
                    // InternalCoreDsl.g:2161:5: ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( ((LA45_0>=RULE_STRING && LA45_0<=RULE_ID)||(LA45_0>=RULE_INTEGER && LA45_0<=RULE_CHARCONST)||LA45_0==46||LA45_0==60||LA45_0==81||(LA45_0>=88 && LA45_0<=89)||(LA45_0>=92 && LA45_0<=96)||(LA45_0>=98 && LA45_0<=101)) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalCoreDsl.g:2162:6: (lv_startExpr_1_0= ruleAssignmentExpression2 )
                            {
                            // InternalCoreDsl.g:2162:6: (lv_startExpr_1_0= ruleAssignmentExpression2 )
                            // InternalCoreDsl.g:2163:7: lv_startExpr_1_0= ruleAssignmentExpression2
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getForConditionAccess().getStartExprAssignmentExpression2ParserRuleCall_0_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_32);
                            lv_startExpr_1_0=ruleAssignmentExpression2();

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
                              								"com.minres.coredsl.CoreDsl.AssignmentExpression2");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    otherlv_2=(Token)match(input,39,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getForConditionAccess().getSemicolonKeyword_0_1_1());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:2186:3: ( (lv_endExpr_3_0= ruleConditionalExpression ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_ID)||(LA47_0>=RULE_INTEGER && LA47_0<=RULE_CHARCONST)||LA47_0==46||LA47_0==60||LA47_0==81||(LA47_0>=88 && LA47_0<=89)||(LA47_0>=92 && LA47_0<=96)||(LA47_0>=98 && LA47_0<=101)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalCoreDsl.g:2187:4: (lv_endExpr_3_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:2187:4: (lv_endExpr_3_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:2188:5: lv_endExpr_3_0= ruleConditionalExpression
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

            otherlv_4=(Token)match(input,39,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getForConditionAccess().getSemicolonKeyword_2());
              		
            }
            // InternalCoreDsl.g:2209:3: ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_STRING && LA49_0<=RULE_ID)||(LA49_0>=RULE_INTEGER && LA49_0<=RULE_CHARCONST)||LA49_0==46||LA49_0==60||LA49_0==81||(LA49_0>=88 && LA49_0<=89)||(LA49_0>=92 && LA49_0<=96)||(LA49_0>=98 && LA49_0<=101)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalCoreDsl.g:2210:4: ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )*
                    {
                    // InternalCoreDsl.g:2210:4: ( (lv_loopExprs_5_0= ruleAssignmentExpression ) )
                    // InternalCoreDsl.g:2211:5: (lv_loopExprs_5_0= ruleAssignmentExpression )
                    {
                    // InternalCoreDsl.g:2211:5: (lv_loopExprs_5_0= ruleAssignmentExpression )
                    // InternalCoreDsl.g:2212:6: lv_loopExprs_5_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getForConditionAccess().getLoopExprsAssignmentExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_45);
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

                    // InternalCoreDsl.g:2229:4: (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==36) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2230:5: otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) )
                    	    {
                    	    otherlv_6=(Token)match(input,36,FOLLOW_47); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getForConditionAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2234:5: ( (lv_loopExprs_7_0= ruleAssignmentExpression ) )
                    	    // InternalCoreDsl.g:2235:6: (lv_loopExprs_7_0= ruleAssignmentExpression )
                    	    {
                    	    // InternalCoreDsl.g:2235:6: (lv_loopExprs_7_0= ruleAssignmentExpression )
                    	    // InternalCoreDsl.g:2236:7: lv_loopExprs_7_0= ruleAssignmentExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getForConditionAccess().getLoopExprsAssignmentExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_45);
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
                    	    break loop48;
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
    // InternalCoreDsl.g:2259:1: entryRuleJumpStatement returns [EObject current=null] : iv_ruleJumpStatement= ruleJumpStatement EOF ;
    public final EObject entryRuleJumpStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJumpStatement = null;


        try {
            // InternalCoreDsl.g:2259:54: (iv_ruleJumpStatement= ruleJumpStatement EOF )
            // InternalCoreDsl.g:2260:2: iv_ruleJumpStatement= ruleJumpStatement EOF
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
    // InternalCoreDsl.g:2266:1: ruleJumpStatement returns [EObject current=null] : ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) ) ;
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
            // InternalCoreDsl.g:2272:2: ( ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) ) )
            // InternalCoreDsl.g:2273:2: ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) )
            {
            // InternalCoreDsl.g:2273:2: ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) )
            int alt51=3;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt51=1;
                }
                break;
            case 57:
                {
                alt51=2;
                }
                break;
            case 58:
                {
                alt51=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalCoreDsl.g:2274:3: ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' )
                    {
                    // InternalCoreDsl.g:2274:3: ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' )
                    // InternalCoreDsl.g:2275:4: ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';'
                    {
                    // InternalCoreDsl.g:2275:4: ( (lv_type_0_0= 'continue' ) )
                    // InternalCoreDsl.g:2276:5: (lv_type_0_0= 'continue' )
                    {
                    // InternalCoreDsl.g:2276:5: (lv_type_0_0= 'continue' )
                    // InternalCoreDsl.g:2277:6: lv_type_0_0= 'continue'
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

                    otherlv_1=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getJumpStatementAccess().getSemicolonKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2295:3: ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' )
                    {
                    // InternalCoreDsl.g:2295:3: ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' )
                    // InternalCoreDsl.g:2296:4: ( (lv_type_2_0= 'break' ) ) otherlv_3= ';'
                    {
                    // InternalCoreDsl.g:2296:4: ( (lv_type_2_0= 'break' ) )
                    // InternalCoreDsl.g:2297:5: (lv_type_2_0= 'break' )
                    {
                    // InternalCoreDsl.g:2297:5: (lv_type_2_0= 'break' )
                    // InternalCoreDsl.g:2298:6: lv_type_2_0= 'break'
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

                    otherlv_3=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getJumpStatementAccess().getSemicolonKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:2316:3: ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' )
                    {
                    // InternalCoreDsl.g:2316:3: ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' )
                    // InternalCoreDsl.g:2317:4: ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';'
                    {
                    // InternalCoreDsl.g:2317:4: ( (lv_type_4_0= 'return' ) )
                    // InternalCoreDsl.g:2318:5: (lv_type_4_0= 'return' )
                    {
                    // InternalCoreDsl.g:2318:5: (lv_type_4_0= 'return' )
                    // InternalCoreDsl.g:2319:6: lv_type_4_0= 'return'
                    {
                    lv_type_4_0=(Token)match(input,58,FOLLOW_54); if (state.failed) return current;
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

                    // InternalCoreDsl.g:2331:4: ( (lv_expr_5_0= ruleConditionalExpression ) )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( ((LA50_0>=RULE_STRING && LA50_0<=RULE_ID)||(LA50_0>=RULE_INTEGER && LA50_0<=RULE_CHARCONST)||LA50_0==46||LA50_0==60||LA50_0==81||(LA50_0>=88 && LA50_0<=89)||(LA50_0>=92 && LA50_0<=96)||(LA50_0>=98 && LA50_0<=101)) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalCoreDsl.g:2332:5: (lv_expr_5_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:2332:5: (lv_expr_5_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:2333:6: lv_expr_5_0= ruleConditionalExpression
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

                    otherlv_6=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleSpawnStatement"
    // InternalCoreDsl.g:2359:1: entryRuleSpawnStatement returns [EObject current=null] : iv_ruleSpawnStatement= ruleSpawnStatement EOF ;
    public final EObject entryRuleSpawnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpawnStatement = null;


        try {
            // InternalCoreDsl.g:2359:55: (iv_ruleSpawnStatement= ruleSpawnStatement EOF )
            // InternalCoreDsl.g:2360:2: iv_ruleSpawnStatement= ruleSpawnStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpawnStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSpawnStatement=ruleSpawnStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpawnStatement; 
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
    // $ANTLR end "entryRuleSpawnStatement"


    // $ANTLR start "ruleSpawnStatement"
    // InternalCoreDsl.g:2366:1: ruleSpawnStatement returns [EObject current=null] : (otherlv_0= 'spawn' ( (lv_stmt_1_0= ruleStatement ) ) ) ;
    public final EObject ruleSpawnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_stmt_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2372:2: ( (otherlv_0= 'spawn' ( (lv_stmt_1_0= ruleStatement ) ) ) )
            // InternalCoreDsl.g:2373:2: (otherlv_0= 'spawn' ( (lv_stmt_1_0= ruleStatement ) ) )
            {
            // InternalCoreDsl.g:2373:2: (otherlv_0= 'spawn' ( (lv_stmt_1_0= ruleStatement ) ) )
            // InternalCoreDsl.g:2374:3: otherlv_0= 'spawn' ( (lv_stmt_1_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSpawnStatementAccess().getSpawnKeyword_0());
              		
            }
            // InternalCoreDsl.g:2378:3: ( (lv_stmt_1_0= ruleStatement ) )
            // InternalCoreDsl.g:2379:4: (lv_stmt_1_0= ruleStatement )
            {
            // InternalCoreDsl.g:2379:4: (lv_stmt_1_0= ruleStatement )
            // InternalCoreDsl.g:2380:5: lv_stmt_1_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSpawnStatementAccess().getStmtStatementParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_stmt_1_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSpawnStatementRule());
              					}
              					set(
              						current,
              						"stmt",
              						lv_stmt_1_0,
              						"com.minres.coredsl.CoreDsl.Statement");
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
    // $ANTLR end "ruleSpawnStatement"


    // $ANTLR start "entryRuleDeclaration"
    // InternalCoreDsl.g:2401:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalCoreDsl.g:2401:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalCoreDsl.g:2402:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalCoreDsl.g:2408:1: ruleDeclaration returns [EObject current=null] : (this_TypeOrVarDeclaration_0= ruleTypeOrVarDeclaration | this_TypedefDeclaration_1= ruleTypedefDeclaration ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_TypeOrVarDeclaration_0 = null;

        EObject this_TypedefDeclaration_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2414:2: ( (this_TypeOrVarDeclaration_0= ruleTypeOrVarDeclaration | this_TypedefDeclaration_1= ruleTypedefDeclaration ) )
            // InternalCoreDsl.g:2415:2: (this_TypeOrVarDeclaration_0= ruleTypeOrVarDeclaration | this_TypedefDeclaration_1= ruleTypedefDeclaration )
            {
            // InternalCoreDsl.g:2415:2: (this_TypeOrVarDeclaration_0= ruleTypeOrVarDeclaration | this_TypedefDeclaration_1= ruleTypedefDeclaration )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_LEFT_BR||LA52_0==45||LA52_0==65||(LA52_0>=105 && LA52_0<=117)||(LA52_0>=125 && LA52_0<=126)) ) {
                alt52=1;
            }
            else if ( (LA52_0==61) ) {
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
                    // InternalCoreDsl.g:2416:3: this_TypeOrVarDeclaration_0= ruleTypeOrVarDeclaration
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
                    // InternalCoreDsl.g:2425:3: this_TypedefDeclaration_1= ruleTypedefDeclaration
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
    // InternalCoreDsl.g:2437:1: entryRuleTypeOrVarDeclaration returns [EObject current=null] : iv_ruleTypeOrVarDeclaration= ruleTypeOrVarDeclaration EOF ;
    public final EObject entryRuleTypeOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeOrVarDeclaration = null;


        try {
            // InternalCoreDsl.g:2437:61: (iv_ruleTypeOrVarDeclaration= ruleTypeOrVarDeclaration EOF )
            // InternalCoreDsl.g:2438:2: iv_ruleTypeOrVarDeclaration= ruleTypeOrVarDeclaration EOF
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
    // InternalCoreDsl.g:2444:1: ruleTypeOrVarDeclaration returns [EObject current=null] : ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( (lv_is_ptr_3_0= '*' ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' ) ;
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
            // InternalCoreDsl.g:2450:2: ( ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( (lv_is_ptr_3_0= '*' ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' ) )
            // InternalCoreDsl.g:2451:2: ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( (lv_is_ptr_3_0= '*' ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' )
            {
            // InternalCoreDsl.g:2451:2: ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( (lv_is_ptr_3_0= '*' ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' )
            // InternalCoreDsl.g:2452:3: (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( (lv_is_ptr_3_0= '*' ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';'
            {
            // InternalCoreDsl.g:2452:3: (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_LEFT_BR||LA53_0==45||(LA53_0>=115 && LA53_0<=117)) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalCoreDsl.g:2453:4: this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current]
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
            	    break loop53;
                }
            } while (true);

            // InternalCoreDsl.g:2465:3: ( (lv_type_1_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:2466:4: (lv_type_1_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:2466:4: (lv_type_1_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:2467:5: lv_type_1_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getTypeTypeSpecifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_56);
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

            // InternalCoreDsl.g:2484:3: ( (lv_size_2_0= ruleBitSizeSpecifier ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==63) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalCoreDsl.g:2485:4: (lv_size_2_0= ruleBitSizeSpecifier )
                    {
                    // InternalCoreDsl.g:2485:4: (lv_size_2_0= ruleBitSizeSpecifier )
                    // InternalCoreDsl.g:2486:5: lv_size_2_0= ruleBitSizeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getSizeBitSizeSpecifierParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_57);
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

            // InternalCoreDsl.g:2503:3: ( (lv_is_ptr_3_0= '*' ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==60) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalCoreDsl.g:2504:4: (lv_is_ptr_3_0= '*' )
                    {
                    // InternalCoreDsl.g:2504:4: (lv_is_ptr_3_0= '*' )
                    // InternalCoreDsl.g:2505:5: lv_is_ptr_3_0= '*'
                    {
                    lv_is_ptr_3_0=(Token)match(input,60,FOLLOW_58); if (state.failed) return current;
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

            // InternalCoreDsl.g:2517:3: ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalCoreDsl.g:2518:4: ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )*
                    {
                    // InternalCoreDsl.g:2518:4: ( (lv_init_4_0= ruleInitDeclarator ) )
                    // InternalCoreDsl.g:2519:5: (lv_init_4_0= ruleInitDeclarator )
                    {
                    // InternalCoreDsl.g:2519:5: (lv_init_4_0= ruleInitDeclarator )
                    // InternalCoreDsl.g:2520:6: lv_init_4_0= ruleInitDeclarator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getInitInitDeclaratorParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_59);
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

                    // InternalCoreDsl.g:2537:4: (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==36) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2538:5: otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) )
                    	    {
                    	    otherlv_5=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getTypeOrVarDeclarationAccess().getCommaKeyword_4_1_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2542:5: ( (lv_init_6_0= ruleInitDeclarator ) )
                    	    // InternalCoreDsl.g:2543:6: (lv_init_6_0= ruleInitDeclarator )
                    	    {
                    	    // InternalCoreDsl.g:2543:6: (lv_init_6_0= ruleInitDeclarator )
                    	    // InternalCoreDsl.g:2544:7: lv_init_6_0= ruleInitDeclarator
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getTypeOrVarDeclarationAccess().getInitInitDeclaratorParserRuleCall_4_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_59);
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
                    	    break loop56;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:2571:1: entryRuleTypedefDeclaration returns [EObject current=null] : iv_ruleTypedefDeclaration= ruleTypedefDeclaration EOF ;
    public final EObject entryRuleTypedefDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefDeclaration = null;


        try {
            // InternalCoreDsl.g:2571:59: (iv_ruleTypedefDeclaration= ruleTypedefDeclaration EOF )
            // InternalCoreDsl.g:2572:2: iv_ruleTypedefDeclaration= ruleTypedefDeclaration EOF
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
    // InternalCoreDsl.g:2578:1: ruleTypedefDeclaration returns [EObject current=null] : (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' ) ;
    public final EObject ruleTypedefDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject this_DeclarationSpecifier_1 = null;

        EObject lv_type_2_0 = null;

        EObject lv_init_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2584:2: ( (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' ) )
            // InternalCoreDsl.g:2585:2: (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' )
            {
            // InternalCoreDsl.g:2585:2: (otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';' )
            // InternalCoreDsl.g:2586:3: otherlv_0= 'typedef' (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )* ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_init_3_0= ruleInitDeclarator ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypedefDeclarationAccess().getTypedefKeyword_0());
              		
            }
            // InternalCoreDsl.g:2590:3: (this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current] )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_LEFT_BR||LA58_0==45||(LA58_0>=115 && LA58_0<=117)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalCoreDsl.g:2591:4: this_DeclarationSpecifier_1= ruleDeclarationSpecifier[$current]
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
            	    break loop58;
                }
            } while (true);

            // InternalCoreDsl.g:2603:3: ( (lv_type_2_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:2604:4: (lv_type_2_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:2604:4: (lv_type_2_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:2605:5: lv_type_2_0= ruleTypeSpecifier
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

            // InternalCoreDsl.g:2622:3: ( (lv_init_3_0= ruleInitDeclarator ) )
            // InternalCoreDsl.g:2623:4: (lv_init_3_0= ruleInitDeclarator )
            {
            // InternalCoreDsl.g:2623:4: (lv_init_3_0= ruleInitDeclarator )
            // InternalCoreDsl.g:2624:5: lv_init_3_0= ruleInitDeclarator
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

            otherlv_4=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:2650:1: ruleDeclarationSpecifier[EObject in_current] returns [EObject current=in_current] : ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] ) ;
    public final EObject ruleDeclarationSpecifier(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Enumerator lv_storage_0_0 = null;

        Enumerator lv_qualifiers_1_0 = null;

        EObject this_AttributeList_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2656:2: ( ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] ) )
            // InternalCoreDsl.g:2657:2: ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] )
            {
            // InternalCoreDsl.g:2657:2: ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | this_AttributeList_2= ruleAttributeList[$current] )
            int alt59=3;
            switch ( input.LA(1) ) {
            case 45:
            case 117:
                {
                alt59=1;
                }
                break;
            case 115:
            case 116:
                {
                alt59=2;
                }
                break;
            case RULE_LEFT_BR:
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
                    // InternalCoreDsl.g:2658:3: ( (lv_storage_0_0= ruleStorageClassSpecifier ) )
                    {
                    // InternalCoreDsl.g:2658:3: ( (lv_storage_0_0= ruleStorageClassSpecifier ) )
                    // InternalCoreDsl.g:2659:4: (lv_storage_0_0= ruleStorageClassSpecifier )
                    {
                    // InternalCoreDsl.g:2659:4: (lv_storage_0_0= ruleStorageClassSpecifier )
                    // InternalCoreDsl.g:2660:5: lv_storage_0_0= ruleStorageClassSpecifier
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
                    // InternalCoreDsl.g:2678:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    {
                    // InternalCoreDsl.g:2678:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    // InternalCoreDsl.g:2679:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    {
                    // InternalCoreDsl.g:2679:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    // InternalCoreDsl.g:2680:5: lv_qualifiers_1_0= ruleTypeQualifier
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
                    // InternalCoreDsl.g:2698:3: this_AttributeList_2= ruleAttributeList[$current]
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
    // InternalCoreDsl.g:2714:1: ruleAttributeList[EObject in_current] returns [EObject current=in_current] : ( ruleDoubleLeftBracket ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* ruleDoubleRightBracket ) ;
    public final EObject ruleAttributeList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_2=null;
        EObject lv_attrs_1_0 = null;

        EObject lv_attrs_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2720:2: ( ( ruleDoubleLeftBracket ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* ruleDoubleRightBracket ) )
            // InternalCoreDsl.g:2721:2: ( ruleDoubleLeftBracket ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* ruleDoubleRightBracket )
            {
            // InternalCoreDsl.g:2721:2: ( ruleDoubleLeftBracket ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* ruleDoubleRightBracket )
            // InternalCoreDsl.g:2722:3: ruleDoubleLeftBracket ( (lv_attrs_1_0= ruleAttribute ) ) (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )* ruleDoubleRightBracket
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAttributeListAccess().getDoubleLeftBracketParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_60);
            ruleDoubleLeftBracket();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:2729:3: ( (lv_attrs_1_0= ruleAttribute ) )
            // InternalCoreDsl.g:2730:4: (lv_attrs_1_0= ruleAttribute )
            {
            // InternalCoreDsl.g:2730:4: (lv_attrs_1_0= ruleAttribute )
            // InternalCoreDsl.g:2731:5: lv_attrs_1_0= ruleAttribute
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeListAccess().getAttrsAttributeParserRuleCall_1_0());
              				
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

            // InternalCoreDsl.g:2748:3: (otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==36) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalCoreDsl.g:2749:4: otherlv_2= ',' ( (lv_attrs_3_0= ruleAttribute ) )
            	    {
            	    otherlv_2=(Token)match(input,36,FOLLOW_60); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAttributeListAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:2753:4: ( (lv_attrs_3_0= ruleAttribute ) )
            	    // InternalCoreDsl.g:2754:5: (lv_attrs_3_0= ruleAttribute )
            	    {
            	    // InternalCoreDsl.g:2754:5: (lv_attrs_3_0= ruleAttribute )
            	    // InternalCoreDsl.g:2755:6: lv_attrs_3_0= ruleAttribute
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAttributeListAccess().getAttrsAttributeParserRuleCall_2_1_0());
            	      					
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
            	    break loop60;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAttributeListAccess().getDoubleRightBracketParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_2);
            ruleDoubleRightBracket();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
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


    // $ANTLR start "entryRuleAttribute"
    // InternalCoreDsl.g:2784:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalCoreDsl.g:2784:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalCoreDsl.g:2785:2: iv_ruleAttribute= ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute; 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalCoreDsl.g:2791:1: ruleAttribute returns [EObject current=null] : ( ( (lv_type_0_0= ruleStatementAttribute ) ) (otherlv_1= '=' ( (lv_val_2_0= ruleConditionalExpression ) ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_val_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2797:2: ( ( ( (lv_type_0_0= ruleStatementAttribute ) ) (otherlv_1= '=' ( (lv_val_2_0= ruleConditionalExpression ) ) )? ) )
            // InternalCoreDsl.g:2798:2: ( ( (lv_type_0_0= ruleStatementAttribute ) ) (otherlv_1= '=' ( (lv_val_2_0= ruleConditionalExpression ) ) )? )
            {
            // InternalCoreDsl.g:2798:2: ( ( (lv_type_0_0= ruleStatementAttribute ) ) (otherlv_1= '=' ( (lv_val_2_0= ruleConditionalExpression ) ) )? )
            // InternalCoreDsl.g:2799:3: ( (lv_type_0_0= ruleStatementAttribute ) ) (otherlv_1= '=' ( (lv_val_2_0= ruleConditionalExpression ) ) )?
            {
            // InternalCoreDsl.g:2799:3: ( (lv_type_0_0= ruleStatementAttribute ) )
            // InternalCoreDsl.g:2800:4: (lv_type_0_0= ruleStatementAttribute )
            {
            // InternalCoreDsl.g:2800:4: (lv_type_0_0= ruleStatementAttribute )
            // InternalCoreDsl.g:2801:5: lv_type_0_0= ruleStatementAttribute
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeAccess().getTypeStatementAttributeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_61);
            lv_type_0_0=ruleStatementAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"com.minres.coredsl.CoreDsl.StatementAttribute");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:2818:3: (otherlv_1= '=' ( (lv_val_2_0= ruleConditionalExpression ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==62) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalCoreDsl.g:2819:4: otherlv_1= '=' ( (lv_val_2_0= ruleConditionalExpression ) )
                    {
                    otherlv_1=(Token)match(input,62,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:2823:4: ( (lv_val_2_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:2824:5: (lv_val_2_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:2824:5: (lv_val_2_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:2825:6: lv_val_2_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAttributeAccess().getValConditionalExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_val_2_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAttributeRule());
                      						}
                      						set(
                      							current,
                      							"val",
                      							lv_val_2_0,
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleTypeSpecifier"
    // InternalCoreDsl.g:2847:1: entryRuleTypeSpecifier returns [EObject current=null] : iv_ruleTypeSpecifier= ruleTypeSpecifier EOF ;
    public final EObject entryRuleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSpecifier = null;


        try {
            // InternalCoreDsl.g:2847:54: (iv_ruleTypeSpecifier= ruleTypeSpecifier EOF )
            // InternalCoreDsl.g:2848:2: iv_ruleTypeSpecifier= ruleTypeSpecifier EOF
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
    // InternalCoreDsl.g:2854:1: ruleTypeSpecifier returns [EObject current=null] : this_DataTypeSpecifier_0= ruleDataTypeSpecifier ;
    public final EObject ruleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_DataTypeSpecifier_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2860:2: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier )
            // InternalCoreDsl.g:2861:2: this_DataTypeSpecifier_0= ruleDataTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getTypeSpecifierAccess().getDataTypeSpecifierParserRuleCall());
              	
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
    // InternalCoreDsl.g:2872:1: entryRuleDataTypeSpecifier returns [EObject current=null] : iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF ;
    public final EObject entryRuleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeSpecifier = null;


        try {
            // InternalCoreDsl.g:2872:58: (iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF )
            // InternalCoreDsl.g:2873:2: iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF
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
    // InternalCoreDsl.g:2879:1: ruleDataTypeSpecifier returns [EObject current=null] : (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier ) ;
    public final EObject ruleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_PodSpecifier_0 = null;

        EObject this_StructOrUnionSpecifier_1 = null;

        EObject this_EnumSpecifier_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2885:2: ( (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier ) )
            // InternalCoreDsl.g:2886:2: (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier )
            {
            // InternalCoreDsl.g:2886:2: (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier )
            int alt62=3;
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
                {
                alt62=1;
                }
                break;
            case 125:
            case 126:
                {
                alt62=2;
                }
                break;
            case 65:
                {
                alt62=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalCoreDsl.g:2887:3: this_PodSpecifier_0= rulePodSpecifier
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
                    // InternalCoreDsl.g:2896:3: this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier
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
                    // InternalCoreDsl.g:2905:3: this_EnumSpecifier_2= ruleEnumSpecifier
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


    // $ANTLR start "entryRulePodSpecifier"
    // InternalCoreDsl.g:2917:1: entryRulePodSpecifier returns [EObject current=null] : iv_rulePodSpecifier= rulePodSpecifier EOF ;
    public final EObject entryRulePodSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePodSpecifier = null;


        try {
            // InternalCoreDsl.g:2917:53: (iv_rulePodSpecifier= rulePodSpecifier EOF )
            // InternalCoreDsl.g:2918:2: iv_rulePodSpecifier= rulePodSpecifier EOF
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
    // InternalCoreDsl.g:2924:1: rulePodSpecifier returns [EObject current=null] : ( (lv_dataType_0_0= ruleDataTypes ) )+ ;
    public final EObject rulePodSpecifier() throws RecognitionException {
        EObject current = null;

        Enumerator lv_dataType_0_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2930:2: ( ( (lv_dataType_0_0= ruleDataTypes ) )+ )
            // InternalCoreDsl.g:2931:2: ( (lv_dataType_0_0= ruleDataTypes ) )+
            {
            // InternalCoreDsl.g:2931:2: ( (lv_dataType_0_0= ruleDataTypes ) )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( ((LA63_0>=105 && LA63_0<=114)) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalCoreDsl.g:2932:3: (lv_dataType_0_0= ruleDataTypes )
            	    {
            	    // InternalCoreDsl.g:2932:3: (lv_dataType_0_0= ruleDataTypes )
            	    // InternalCoreDsl.g:2933:4: lv_dataType_0_0= ruleDataTypes
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getPodSpecifierAccess().getDataTypeDataTypesEnumRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_62);
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
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
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
    // InternalCoreDsl.g:2953:1: entryRuleBitSizeSpecifier returns [EObject current=null] : iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF ;
    public final EObject entryRuleBitSizeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitSizeSpecifier = null;


        try {
            // InternalCoreDsl.g:2953:57: (iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF )
            // InternalCoreDsl.g:2954:2: iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF
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
    // InternalCoreDsl.g:2960:1: ruleBitSizeSpecifier returns [EObject current=null] : (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' ) ;
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
            // InternalCoreDsl.g:2966:2: ( (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' ) )
            // InternalCoreDsl.g:2967:2: (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' )
            {
            // InternalCoreDsl.g:2967:2: (otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>' )
            // InternalCoreDsl.g:2968:3: otherlv_0= '<' ( (lv_size_1_0= ruleBitSizeValue ) ) (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )? otherlv_8= '>'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBitSizeSpecifierAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalCoreDsl.g:2972:3: ( (lv_size_1_0= ruleBitSizeValue ) )
            // InternalCoreDsl.g:2973:4: (lv_size_1_0= ruleBitSizeValue )
            {
            // InternalCoreDsl.g:2973:4: (lv_size_1_0= ruleBitSizeValue )
            // InternalCoreDsl.g:2974:5: lv_size_1_0= ruleBitSizeValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_64);
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

            // InternalCoreDsl.g:2991:3: (otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==36) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalCoreDsl.g:2992:4: otherlv_2= ',' ( (lv_size_3_0= ruleBitSizeValue ) ) otherlv_4= ',' ( (lv_size_5_0= ruleBitSizeValue ) ) otherlv_6= ',' ( (lv_size_7_0= ruleBitSizeValue ) )
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_0());
                      			
                    }
                    // InternalCoreDsl.g:2996:4: ( (lv_size_3_0= ruleBitSizeValue ) )
                    // InternalCoreDsl.g:2997:5: (lv_size_3_0= ruleBitSizeValue )
                    {
                    // InternalCoreDsl.g:2997:5: (lv_size_3_0= ruleBitSizeValue )
                    // InternalCoreDsl.g:2998:6: lv_size_3_0= ruleBitSizeValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_65);
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

                    otherlv_4=(Token)match(input,36,FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_2());
                      			
                    }
                    // InternalCoreDsl.g:3019:4: ( (lv_size_5_0= ruleBitSizeValue ) )
                    // InternalCoreDsl.g:3020:5: (lv_size_5_0= ruleBitSizeValue )
                    {
                    // InternalCoreDsl.g:3020:5: (lv_size_5_0= ruleBitSizeValue )
                    // InternalCoreDsl.g:3021:6: lv_size_5_0= ruleBitSizeValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_65);
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

                    otherlv_6=(Token)match(input,36,FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_4());
                      			
                    }
                    // InternalCoreDsl.g:3042:4: ( (lv_size_7_0= ruleBitSizeValue ) )
                    // InternalCoreDsl.g:3043:5: (lv_size_7_0= ruleBitSizeValue )
                    {
                    // InternalCoreDsl.g:3043:5: (lv_size_7_0= ruleBitSizeValue )
                    // InternalCoreDsl.g:3044:6: lv_size_7_0= ruleBitSizeValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizeBitSizeValueParserRuleCall_2_5_0());
                      					
                    }
                    pushFollow(FOLLOW_66);
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

            otherlv_8=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:3070:1: entryRuleBitSizeValue returns [EObject current=null] : iv_ruleBitSizeValue= ruleBitSizeValue EOF ;
    public final EObject entryRuleBitSizeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitSizeValue = null;


        try {
            // InternalCoreDsl.g:3070:53: (iv_ruleBitSizeValue= ruleBitSizeValue EOF )
            // InternalCoreDsl.g:3071:2: iv_ruleBitSizeValue= ruleBitSizeValue EOF
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
    // InternalCoreDsl.g:3077:1: ruleBitSizeValue returns [EObject current=null] : ( ( (lv_val_0_0= ruleIntegerConstant ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleBitSizeValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_val_0_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3083:2: ( ( ( (lv_val_0_0= ruleIntegerConstant ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // InternalCoreDsl.g:3084:2: ( ( (lv_val_0_0= ruleIntegerConstant ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalCoreDsl.g:3084:2: ( ( (lv_val_0_0= ruleIntegerConstant ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_INTEGER) ) {
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
                    // InternalCoreDsl.g:3085:3: ( (lv_val_0_0= ruleIntegerConstant ) )
                    {
                    // InternalCoreDsl.g:3085:3: ( (lv_val_0_0= ruleIntegerConstant ) )
                    // InternalCoreDsl.g:3086:4: (lv_val_0_0= ruleIntegerConstant )
                    {
                    // InternalCoreDsl.g:3086:4: (lv_val_0_0= ruleIntegerConstant )
                    // InternalCoreDsl.g:3087:5: lv_val_0_0= ruleIntegerConstant
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBitSizeValueAccess().getValIntegerConstantParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_val_0_0=ruleIntegerConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBitSizeValueRule());
                      					}
                      					add(
                      						current,
                      						"val",
                      						lv_val_0_0,
                      						"com.minres.coredsl.CoreDsl.IntegerConstant");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3105:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:3105:3: ( (otherlv_1= RULE_ID ) )
                    // InternalCoreDsl.g:3106:4: (otherlv_1= RULE_ID )
                    {
                    // InternalCoreDsl.g:3106:4: (otherlv_1= RULE_ID )
                    // InternalCoreDsl.g:3107:5: otherlv_1= RULE_ID
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
    // InternalCoreDsl.g:3122:1: entryRuleEnumSpecifier returns [EObject current=null] : iv_ruleEnumSpecifier= ruleEnumSpecifier EOF ;
    public final EObject entryRuleEnumSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumSpecifier = null;


        try {
            // InternalCoreDsl.g:3122:54: (iv_ruleEnumSpecifier= ruleEnumSpecifier EOF )
            // InternalCoreDsl.g:3123:2: iv_ruleEnumSpecifier= ruleEnumSpecifier EOF
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
    // InternalCoreDsl.g:3129:1: ruleEnumSpecifier returns [EObject current=null] : ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) ) ;
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
            // InternalCoreDsl.g:3135:2: ( ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:3136:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:3136:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==65) ) {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==RULE_ID) ) {
                    int LA68_2 = input.LA(3);

                    if ( (LA68_2==EOF||LA68_2==RULE_ID||LA68_2==RULE_LEFT_BR||LA68_2==36||LA68_2==39||(LA68_2>=46 && LA68_2<=47)||LA68_2==60||LA68_2==63) ) {
                        alt68=2;
                    }
                    else if ( (LA68_2==27) ) {
                        alt68=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA68_1==27) ) {
                    alt68=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalCoreDsl.g:3137:3: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' )
                    {
                    // InternalCoreDsl.g:3137:3: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' )
                    // InternalCoreDsl.g:3138:4: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}'
                    {
                    otherlv_0=(Token)match(input,65,FOLLOW_67); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getEnumSpecifierAccess().getEnumKeyword_0_0());
                      			
                    }
                    // InternalCoreDsl.g:3142:4: ( (lv_name_1_0= RULE_ID ) )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==RULE_ID) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // InternalCoreDsl.g:3143:5: (lv_name_1_0= RULE_ID )
                            {
                            // InternalCoreDsl.g:3143:5: (lv_name_1_0= RULE_ID )
                            // InternalCoreDsl.g:3144:6: lv_name_1_0= RULE_ID
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

                    otherlv_2=(Token)match(input,27,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEnumSpecifierAccess().getLeftCurlyBracketKeyword_0_2());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getEnumSpecifierRule());
                      				}
                      				newCompositeNode(grammarAccess.getEnumSpecifierAccess().getEnumeratorListParserRuleCall_0_3());
                      			
                    }
                    pushFollow(FOLLOW_68);
                    this_EnumeratorList_3=ruleEnumeratorList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_EnumeratorList_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:3175:4: (otherlv_4= ',' )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==36) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalCoreDsl.g:3176:5: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getEnumSpecifierAccess().getCommaKeyword_0_4());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getEnumSpecifierAccess().getRightCurlyBracketKeyword_0_5());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3187:3: (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:3187:3: (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:3188:4: otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getEnumSpecifierAccess().getEnumKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3192:4: ( (lv_name_7_0= RULE_ID ) )
                    // InternalCoreDsl.g:3193:5: (lv_name_7_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3193:5: (lv_name_7_0= RULE_ID )
                    // InternalCoreDsl.g:3194:6: lv_name_7_0= RULE_ID
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
    // InternalCoreDsl.g:3216:1: ruleEnumeratorList[EObject in_current] returns [EObject current=in_current] : ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* ) ;
    public final EObject ruleEnumeratorList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_enumerators_0_0 = null;

        EObject lv_enumerators_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3222:2: ( ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* ) )
            // InternalCoreDsl.g:3223:2: ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* )
            {
            // InternalCoreDsl.g:3223:2: ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* )
            // InternalCoreDsl.g:3224:3: ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )*
            {
            // InternalCoreDsl.g:3224:3: ( (lv_enumerators_0_0= ruleEnumerator ) )
            // InternalCoreDsl.g:3225:4: (lv_enumerators_0_0= ruleEnumerator )
            {
            // InternalCoreDsl.g:3225:4: (lv_enumerators_0_0= ruleEnumerator )
            // InternalCoreDsl.g:3226:5: lv_enumerators_0_0= ruleEnumerator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumeratorListAccess().getEnumeratorsEnumeratorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_45);
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

            // InternalCoreDsl.g:3243:3: (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==36) ) {
                    int LA69_1 = input.LA(2);

                    if ( (LA69_1==RULE_ID) ) {
                        alt69=1;
                    }


                }


                switch (alt69) {
            	case 1 :
            	    // InternalCoreDsl.g:3244:4: otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) )
            	    {
            	    otherlv_1=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getEnumeratorListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3248:4: ( (lv_enumerators_2_0= ruleEnumerator ) )
            	    // InternalCoreDsl.g:3249:5: (lv_enumerators_2_0= ruleEnumerator )
            	    {
            	    // InternalCoreDsl.g:3249:5: (lv_enumerators_2_0= ruleEnumerator )
            	    // InternalCoreDsl.g:3250:6: lv_enumerators_2_0= ruleEnumerator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumeratorListAccess().getEnumeratorsEnumeratorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_45);
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
    // $ANTLR end "ruleEnumeratorList"


    // $ANTLR start "entryRuleEnumerator"
    // InternalCoreDsl.g:3272:1: entryRuleEnumerator returns [EObject current=null] : iv_ruleEnumerator= ruleEnumerator EOF ;
    public final EObject entryRuleEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerator = null;


        try {
            // InternalCoreDsl.g:3272:51: (iv_ruleEnumerator= ruleEnumerator EOF )
            // InternalCoreDsl.g:3273:2: iv_ruleEnumerator= ruleEnumerator EOF
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
    // InternalCoreDsl.g:3279:1: ruleEnumerator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) ) ;
    public final EObject ruleEnumerator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3285:2: ( ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) ) )
            // InternalCoreDsl.g:3286:2: ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) )
            {
            // InternalCoreDsl.g:3286:2: ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==EOF||LA70_1==29||LA70_1==36) ) {
                    alt70=1;
                }
                else if ( (LA70_1==62) ) {
                    alt70=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

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
                    // InternalCoreDsl.g:3287:3: ( (lv_name_0_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:3287:3: ( (lv_name_0_0= RULE_ID ) )
                    // InternalCoreDsl.g:3288:4: (lv_name_0_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3288:4: (lv_name_0_0= RULE_ID )
                    // InternalCoreDsl.g:3289:5: lv_name_0_0= RULE_ID
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
                    // InternalCoreDsl.g:3306:3: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) )
                    {
                    // InternalCoreDsl.g:3306:3: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) )
                    // InternalCoreDsl.g:3307:4: ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) )
                    {
                    // InternalCoreDsl.g:3307:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalCoreDsl.g:3308:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3308:5: (lv_name_1_0= RULE_ID )
                    // InternalCoreDsl.g:3309:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_69); if (state.failed) return current;
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

                    otherlv_2=(Token)match(input,62,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:3329:4: ( (lv_expression_3_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:3330:5: (lv_expression_3_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:3330:5: (lv_expression_3_0= ruleConstantExpression )
                    // InternalCoreDsl.g:3331:6: lv_expression_3_0= ruleConstantExpression
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
    // InternalCoreDsl.g:3353:1: entryRuleStructOrUnionSpecifier returns [EObject current=null] : iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF ;
    public final EObject entryRuleStructOrUnionSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructOrUnionSpecifier = null;


        try {
            // InternalCoreDsl.g:3353:63: (iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF )
            // InternalCoreDsl.g:3354:2: iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF
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
    // InternalCoreDsl.g:3360:1: ruleStructOrUnionSpecifier returns [EObject current=null] : ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) ) ;
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
            // InternalCoreDsl.g:3366:2: ( ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:3367:2: ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:3367:2: ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==125) ) {
                int LA73_1 = input.LA(2);

                if ( (LA73_1==RULE_ID) ) {
                    int LA73_3 = input.LA(3);

                    if ( (LA73_3==27) ) {
                        alt73=1;
                    }
                    else if ( (LA73_3==EOF||LA73_3==RULE_ID||LA73_3==RULE_LEFT_BR||LA73_3==36||LA73_3==39||(LA73_3>=46 && LA73_3<=47)||LA73_3==60||LA73_3==63) ) {
                        alt73=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 73, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA73_1==27) ) {
                    alt73=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA73_0==126) ) {
                int LA73_2 = input.LA(2);

                if ( (LA73_2==RULE_ID) ) {
                    int LA73_3 = input.LA(3);

                    if ( (LA73_3==27) ) {
                        alt73=1;
                    }
                    else if ( (LA73_3==EOF||LA73_3==RULE_ID||LA73_3==RULE_LEFT_BR||LA73_3==36||LA73_3==39||(LA73_3>=46 && LA73_3<=47)||LA73_3==60||LA73_3==63) ) {
                        alt73=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 73, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA73_2==27) ) {
                    alt73=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalCoreDsl.g:3368:3: ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' )
                    {
                    // InternalCoreDsl.g:3368:3: ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' )
                    // InternalCoreDsl.g:3369:4: ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}'
                    {
                    // InternalCoreDsl.g:3369:4: ( (lv_composeType_0_0= ruleStructOrUnion ) )
                    // InternalCoreDsl.g:3370:5: (lv_composeType_0_0= ruleStructOrUnion )
                    {
                    // InternalCoreDsl.g:3370:5: (lv_composeType_0_0= ruleStructOrUnion )
                    // InternalCoreDsl.g:3371:6: lv_composeType_0_0= ruleStructOrUnion
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStructOrUnionSpecifierAccess().getComposeTypeStructOrUnionEnumRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_67);
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

                    // InternalCoreDsl.g:3388:4: ( (lv_name_1_0= RULE_ID ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==RULE_ID) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalCoreDsl.g:3389:5: (lv_name_1_0= RULE_ID )
                            {
                            // InternalCoreDsl.g:3389:5: (lv_name_1_0= RULE_ID )
                            // InternalCoreDsl.g:3390:6: lv_name_1_0= RULE_ID
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

                    otherlv_2=(Token)match(input,27,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getStructOrUnionSpecifierAccess().getLeftCurlyBracketKeyword_0_2());
                      			
                    }
                    // InternalCoreDsl.g:3410:4: ( (lv_decls_3_0= ruleStructDeclaration ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==65||(LA72_0>=105 && LA72_0<=116)||(LA72_0>=125 && LA72_0<=126)) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalCoreDsl.g:3411:5: (lv_decls_3_0= ruleStructDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:3411:5: (lv_decls_3_0= ruleStructDeclaration )
                    	    // InternalCoreDsl.g:3412:6: lv_decls_3_0= ruleStructDeclaration
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
                    	    break loop72;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getStructOrUnionSpecifierAccess().getRightCurlyBracketKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3435:3: ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:3435:3: ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:3436:4: ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:3436:4: ( (lv_composeType_5_0= ruleStructOrUnion ) )
                    // InternalCoreDsl.g:3437:5: (lv_composeType_5_0= ruleStructOrUnion )
                    {
                    // InternalCoreDsl.g:3437:5: (lv_composeType_5_0= ruleStructOrUnion )
                    // InternalCoreDsl.g:3438:6: lv_composeType_5_0= ruleStructOrUnion
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

                    // InternalCoreDsl.g:3455:4: ( (lv_name_6_0= RULE_ID ) )
                    // InternalCoreDsl.g:3456:5: (lv_name_6_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3456:5: (lv_name_6_0= RULE_ID )
                    // InternalCoreDsl.g:3457:6: lv_name_6_0= RULE_ID
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
    // InternalCoreDsl.g:3478:1: entryRuleStructDeclaration returns [EObject current=null] : iv_ruleStructDeclaration= ruleStructDeclaration EOF ;
    public final EObject entryRuleStructDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructDeclaration = null;


        try {
            // InternalCoreDsl.g:3478:58: (iv_ruleStructDeclaration= ruleStructDeclaration EOF )
            // InternalCoreDsl.g:3479:2: iv_ruleStructDeclaration= ruleStructDeclaration EOF
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
    // InternalCoreDsl.g:3485:1: ruleStructDeclaration returns [EObject current=null] : ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleStructDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_specifier_0_0 = null;

        EObject lv_decls_1_0 = null;

        EObject lv_decls_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3491:2: ( ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' ) )
            // InternalCoreDsl.g:3492:2: ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' )
            {
            // InternalCoreDsl.g:3492:2: ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' )
            // InternalCoreDsl.g:3493:3: ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';'
            {
            // InternalCoreDsl.g:3493:3: ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) )
            // InternalCoreDsl.g:3494:4: (lv_specifier_0_0= ruleStructDeclarationSpecifier )
            {
            // InternalCoreDsl.g:3494:4: (lv_specifier_0_0= ruleStructDeclarationSpecifier )
            // InternalCoreDsl.g:3495:5: lv_specifier_0_0= ruleStructDeclarationSpecifier
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

            // InternalCoreDsl.g:3512:3: ( (lv_decls_1_0= ruleDirectDeclarator ) )
            // InternalCoreDsl.g:3513:4: (lv_decls_1_0= ruleDirectDeclarator )
            {
            // InternalCoreDsl.g:3513:4: (lv_decls_1_0= ruleDirectDeclarator )
            // InternalCoreDsl.g:3514:5: lv_decls_1_0= ruleDirectDeclarator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStructDeclarationAccess().getDeclsDirectDeclaratorParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_59);
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

            // InternalCoreDsl.g:3531:3: (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==36) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalCoreDsl.g:3532:4: otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) )
            	    {
            	    otherlv_2=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getStructDeclarationAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3536:4: ( (lv_decls_3_0= ruleDirectDeclarator ) )
            	    // InternalCoreDsl.g:3537:5: (lv_decls_3_0= ruleDirectDeclarator )
            	    {
            	    // InternalCoreDsl.g:3537:5: (lv_decls_3_0= ruleDirectDeclarator )
            	    // InternalCoreDsl.g:3538:6: lv_decls_3_0= ruleDirectDeclarator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getStructDeclarationAccess().getDeclsDirectDeclaratorParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_59);
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
            	    break loop74;
                }
            } while (true);

            otherlv_4=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:3564:1: entryRuleStructDeclarationSpecifier returns [EObject current=null] : iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF ;
    public final EObject entryRuleStructDeclarationSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructDeclarationSpecifier = null;


        try {
            // InternalCoreDsl.g:3564:67: (iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF )
            // InternalCoreDsl.g:3565:2: iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF
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
    // InternalCoreDsl.g:3571:1: ruleStructDeclarationSpecifier returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) ) ;
    public final EObject ruleStructDeclarationSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        Enumerator lv_qualifiers_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3577:2: ( ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) ) )
            // InternalCoreDsl.g:3578:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) )
            {
            // InternalCoreDsl.g:3578:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==65||(LA75_0>=105 && LA75_0<=114)||(LA75_0>=125 && LA75_0<=126)) ) {
                alt75=1;
            }
            else if ( ((LA75_0>=115 && LA75_0<=116)) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalCoreDsl.g:3579:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
                    {
                    // InternalCoreDsl.g:3579:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
                    // InternalCoreDsl.g:3580:4: (lv_type_0_0= ruleTypeSpecifier )
                    {
                    // InternalCoreDsl.g:3580:4: (lv_type_0_0= ruleTypeSpecifier )
                    // InternalCoreDsl.g:3581:5: lv_type_0_0= ruleTypeSpecifier
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
                    // InternalCoreDsl.g:3599:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    {
                    // InternalCoreDsl.g:3599:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    // InternalCoreDsl.g:3600:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    {
                    // InternalCoreDsl.g:3600:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    // InternalCoreDsl.g:3601:5: lv_qualifiers_1_0= ruleTypeQualifier
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
    // InternalCoreDsl.g:3622:1: entryRuleInitDeclarator returns [EObject current=null] : iv_ruleInitDeclarator= ruleInitDeclarator EOF ;
    public final EObject entryRuleInitDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitDeclarator = null;


        try {
            // InternalCoreDsl.g:3622:55: (iv_ruleInitDeclarator= ruleInitDeclarator EOF )
            // InternalCoreDsl.g:3623:2: iv_ruleInitDeclarator= ruleInitDeclarator EOF
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
    // InternalCoreDsl.g:3629:1: ruleInitDeclarator returns [EObject current=null] : ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? ) ;
    public final EObject ruleInitDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_declarator_0_0 = null;

        EObject lv_initializer_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3635:2: ( ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? ) )
            // InternalCoreDsl.g:3636:2: ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? )
            {
            // InternalCoreDsl.g:3636:2: ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )? )
            // InternalCoreDsl.g:3637:3: ( (lv_declarator_0_0= ruleDirectDeclarator ) ) (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )?
            {
            // InternalCoreDsl.g:3637:3: ( (lv_declarator_0_0= ruleDirectDeclarator ) )
            // InternalCoreDsl.g:3638:4: (lv_declarator_0_0= ruleDirectDeclarator )
            {
            // InternalCoreDsl.g:3638:4: (lv_declarator_0_0= ruleDirectDeclarator )
            // InternalCoreDsl.g:3639:5: lv_declarator_0_0= ruleDirectDeclarator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInitDeclaratorAccess().getDeclaratorDirectDeclaratorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_61);
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

            // InternalCoreDsl.g:3656:3: (otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==62) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalCoreDsl.g:3657:4: otherlv_1= '=' ( (lv_initializer_2_0= ruleInitializer ) )
                    {
                    otherlv_1=(Token)match(input,62,FOLLOW_70); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInitDeclaratorAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3661:4: ( (lv_initializer_2_0= ruleInitializer ) )
                    // InternalCoreDsl.g:3662:5: (lv_initializer_2_0= ruleInitializer )
                    {
                    // InternalCoreDsl.g:3662:5: (lv_initializer_2_0= ruleInitializer )
                    // InternalCoreDsl.g:3663:6: lv_initializer_2_0= ruleInitializer
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
    // InternalCoreDsl.g:3685:1: entryRuleDirectDeclarator returns [EObject current=null] : iv_ruleDirectDeclarator= ruleDirectDeclarator EOF ;
    public final EObject entryRuleDirectDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectDeclarator = null;


        try {
            // InternalCoreDsl.g:3685:57: (iv_ruleDirectDeclarator= ruleDirectDeclarator EOF )
            // InternalCoreDsl.g:3686:2: iv_ruleDirectDeclarator= ruleDirectDeclarator EOF
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
    // InternalCoreDsl.g:3692:1: ruleDirectDeclarator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )? ) ;
    public final EObject ruleDirectDeclarator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token this_LEFT_BR_4=null;
        Token this_RIGHT_BR_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_index_2_0 = null;

        EObject lv_size_5_0 = null;

        EObject this_ParameterList_9 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3698:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )? ) )
            // InternalCoreDsl.g:3699:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )? )
            {
            // InternalCoreDsl.g:3699:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )? )
            // InternalCoreDsl.g:3700:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )?
            {
            // InternalCoreDsl.g:3700:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:3701:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:3701:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:3702:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_71); if (state.failed) return current;
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

            // InternalCoreDsl.g:3718:3: (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==38) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalCoreDsl.g:3719:4: otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) )
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectDeclaratorAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3723:4: ( (lv_index_2_0= ruleIntegerConstant ) )
                    // InternalCoreDsl.g:3724:5: (lv_index_2_0= ruleIntegerConstant )
                    {
                    // InternalCoreDsl.g:3724:5: (lv_index_2_0= ruleIntegerConstant )
                    // InternalCoreDsl.g:3725:6: lv_index_2_0= ruleIntegerConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getIndexIntegerConstantParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_72);
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

            // InternalCoreDsl.g:3743:3: ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )?
            int alt79=3;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_LEFT_BR) ) {
                alt79=1;
            }
            else if ( (LA79_0==46) ) {
                alt79=2;
            }
            switch (alt79) {
                case 1 :
                    // InternalCoreDsl.g:3744:4: ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ )
                    {
                    // InternalCoreDsl.g:3744:4: ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ )
                    // InternalCoreDsl.g:3745:5: () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+
                    {
                    // InternalCoreDsl.g:3745:5: ()
                    // InternalCoreDsl.g:3746:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndSet(
                      							grammarAccess.getDirectDeclaratorAccess().getDirectDeclaratorLeftAction_2_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalCoreDsl.g:3752:5: (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+
                    int cnt78=0;
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==RULE_LEFT_BR) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalCoreDsl.g:3753:6: this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR
                    	    {
                    	    this_LEFT_BR_4=(Token)match(input,RULE_LEFT_BR,FOLLOW_47); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(this_LEFT_BR_4, grammarAccess.getDirectDeclaratorAccess().getLEFT_BRTerminalRuleCall_2_0_1_0());
                    	      					
                    	    }
                    	    // InternalCoreDsl.g:3757:6: ( (lv_size_5_0= ruleConditionalExpression ) )
                    	    // InternalCoreDsl.g:3758:7: (lv_size_5_0= ruleConditionalExpression )
                    	    {
                    	    // InternalCoreDsl.g:3758:7: (lv_size_5_0= ruleConditionalExpression )
                    	    // InternalCoreDsl.g:3759:8: lv_size_5_0= ruleConditionalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getSizeConditionalExpressionParserRuleCall_2_0_1_1_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_40);
                    	    lv_size_5_0=ruleConditionalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getDirectDeclaratorRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"size",
                    	      									lv_size_5_0,
                    	      									"com.minres.coredsl.CoreDsl.ConditionalExpression");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }

                    	    this_RIGHT_BR_6=(Token)match(input,RULE_RIGHT_BR,FOLLOW_73); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(this_RIGHT_BR_6, grammarAccess.getDirectDeclaratorAccess().getRIGHT_BRTerminalRuleCall_2_0_1_2());
                    	      					
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt78 >= 1 ) break loop78;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(78, input);
                                throw eee;
                        }
                        cnt78++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3783:4: ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' )
                    {
                    // InternalCoreDsl.g:3783:4: ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' )
                    // InternalCoreDsl.g:3784:5: () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')'
                    {
                    // InternalCoreDsl.g:3784:5: ()
                    // InternalCoreDsl.g:3785:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndSet(
                      							grammarAccess.getDirectDeclaratorAccess().getDirectDeclaratorLeftAction_2_1_0(),
                      							current);
                      					
                    }

                    }

                    otherlv_8=(Token)match(input,46,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getDirectDeclaratorAccess().getLeftParenthesisKeyword_2_1_1());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getDirectDeclaratorRule());
                      					}
                      					newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getParameterListParserRuleCall_2_1_2());
                      				
                    }
                    pushFollow(FOLLOW_43);
                    this_ParameterList_9=ruleParameterList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_ParameterList_9;
                      					afterParserOrEnumRuleCall();
                      				
                    }
                    otherlv_10=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getDirectDeclaratorAccess().getRightParenthesisKeyword_2_1_3());
                      				
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
    // $ANTLR end "ruleDirectDeclarator"


    // $ANTLR start "entryRuleInitializer"
    // InternalCoreDsl.g:3816:1: entryRuleInitializer returns [EObject current=null] : iv_ruleInitializer= ruleInitializer EOF ;
    public final EObject entryRuleInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitializer = null;


        try {
            // InternalCoreDsl.g:3816:52: (iv_ruleInitializer= ruleInitializer EOF )
            // InternalCoreDsl.g:3817:2: iv_ruleInitializer= ruleInitializer EOF
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
    // InternalCoreDsl.g:3823:1: ruleInitializer returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) ) ;
    public final EObject ruleInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expr_0_0 = null;

        EObject this_InitializerList_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3829:2: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) ) )
            // InternalCoreDsl.g:3830:2: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) )
            {
            // InternalCoreDsl.g:3830:2: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=RULE_STRING && LA81_0<=RULE_ID)||(LA81_0>=RULE_INTEGER && LA81_0<=RULE_CHARCONST)||LA81_0==46||LA81_0==60||LA81_0==81||(LA81_0>=88 && LA81_0<=89)||(LA81_0>=92 && LA81_0<=96)||(LA81_0>=98 && LA81_0<=101)) ) {
                alt81=1;
            }
            else if ( (LA81_0==27) ) {
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
                    // InternalCoreDsl.g:3831:3: ( (lv_expr_0_0= ruleConditionalExpression ) )
                    {
                    // InternalCoreDsl.g:3831:3: ( (lv_expr_0_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:3832:4: (lv_expr_0_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:3832:4: (lv_expr_0_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:3833:5: lv_expr_0_0= ruleConditionalExpression
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
                    // InternalCoreDsl.g:3851:3: (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' )
                    {
                    // InternalCoreDsl.g:3851:3: (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' )
                    // InternalCoreDsl.g:3852:4: otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_74); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInitializerAccess().getLeftCurlyBracketKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getInitializerRule());
                      				}
                      				newCompositeNode(grammarAccess.getInitializerAccess().getInitializerListParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_68);
                    this_InitializerList_2=ruleInitializerList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_InitializerList_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:3867:4: (otherlv_3= ',' )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==36) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // InternalCoreDsl.g:3868:5: otherlv_3= ','
                            {
                            otherlv_3=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getInitializerAccess().getCommaKeyword_1_2());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:3883:1: ruleInitializerList[EObject in_current] returns [EObject current=in_current] : ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* ) ;
    public final EObject ruleInitializerList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_init_0_1 = null;

        EObject lv_init_0_2 = null;

        EObject lv_init_2_1 = null;

        EObject lv_init_2_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3889:2: ( ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* ) )
            // InternalCoreDsl.g:3890:2: ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* )
            {
            // InternalCoreDsl.g:3890:2: ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* )
            // InternalCoreDsl.g:3891:3: ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )*
            {
            // InternalCoreDsl.g:3891:3: ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) )
            // InternalCoreDsl.g:3892:4: ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) )
            {
            // InternalCoreDsl.g:3892:4: ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) )
            // InternalCoreDsl.g:3893:5: (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer )
            {
            // InternalCoreDsl.g:3893:5: (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_LEFT_BR||LA82_0==66) ) {
                alt82=1;
            }
            else if ( ((LA82_0>=RULE_STRING && LA82_0<=RULE_ID)||(LA82_0>=RULE_INTEGER && LA82_0<=RULE_CHARCONST)||LA82_0==27||LA82_0==46||LA82_0==60||LA82_0==81||(LA82_0>=88 && LA82_0<=89)||(LA82_0>=92 && LA82_0<=96)||(LA82_0>=98 && LA82_0<=101)) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalCoreDsl.g:3894:6: lv_init_0_1= ruleDesignatedInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInitializerListAccess().getInitDesignatedInitializerParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_45);
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
                    // InternalCoreDsl.g:3910:6: lv_init_0_2= ruleInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInitializerListAccess().getInitInitializerParserRuleCall_0_0_1());
                      					
                    }
                    pushFollow(FOLLOW_45);
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

            // InternalCoreDsl.g:3928:3: (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==36) ) {
                    int LA84_1 = input.LA(2);

                    if ( ((LA84_1>=RULE_STRING && LA84_1<=RULE_ID)||LA84_1==RULE_LEFT_BR||(LA84_1>=RULE_INTEGER && LA84_1<=RULE_CHARCONST)||LA84_1==27||LA84_1==46||LA84_1==60||LA84_1==66||LA84_1==81||(LA84_1>=88 && LA84_1<=89)||(LA84_1>=92 && LA84_1<=96)||(LA84_1>=98 && LA84_1<=101)) ) {
                        alt84=1;
                    }


                }


                switch (alt84) {
            	case 1 :
            	    // InternalCoreDsl.g:3929:4: otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) )
            	    {
            	    otherlv_1=(Token)match(input,36,FOLLOW_74); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getInitializerListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3933:4: ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) )
            	    // InternalCoreDsl.g:3934:5: ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) )
            	    {
            	    // InternalCoreDsl.g:3934:5: ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) )
            	    // InternalCoreDsl.g:3935:6: (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer )
            	    {
            	    // InternalCoreDsl.g:3935:6: (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer )
            	    int alt83=2;
            	    int LA83_0 = input.LA(1);

            	    if ( (LA83_0==RULE_LEFT_BR||LA83_0==66) ) {
            	        alt83=1;
            	    }
            	    else if ( ((LA83_0>=RULE_STRING && LA83_0<=RULE_ID)||(LA83_0>=RULE_INTEGER && LA83_0<=RULE_CHARCONST)||LA83_0==27||LA83_0==46||LA83_0==60||LA83_0==81||(LA83_0>=88 && LA83_0<=89)||(LA83_0>=92 && LA83_0<=96)||(LA83_0>=98 && LA83_0<=101)) ) {
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
            	            // InternalCoreDsl.g:3936:7: lv_init_2_1= ruleDesignatedInitializer
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getInitializerListAccess().getInitDesignatedInitializerParserRuleCall_1_1_0_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_45);
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
            	            // InternalCoreDsl.g:3952:7: lv_init_2_2= ruleInitializer
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getInitializerListAccess().getInitInitializerParserRuleCall_1_1_0_1());
            	              						
            	            }
            	            pushFollow(FOLLOW_45);
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
            	    break loop84;
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
    // InternalCoreDsl.g:3975:1: entryRuleDesignatedInitializer returns [EObject current=null] : iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF ;
    public final EObject entryRuleDesignatedInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesignatedInitializer = null;


        try {
            // InternalCoreDsl.g:3975:62: (iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF )
            // InternalCoreDsl.g:3976:2: iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF
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
    // InternalCoreDsl.g:3982:1: ruleDesignatedInitializer returns [EObject current=null] : ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) ) ;
    public final EObject ruleDesignatedInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_designators_0_0 = null;

        EObject lv_init_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3988:2: ( ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) ) )
            // InternalCoreDsl.g:3989:2: ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) )
            {
            // InternalCoreDsl.g:3989:2: ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) )
            // InternalCoreDsl.g:3990:3: ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) )
            {
            // InternalCoreDsl.g:3990:3: ( (lv_designators_0_0= ruleDesignator ) )+
            int cnt85=0;
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==RULE_LEFT_BR||LA85_0==66) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalCoreDsl.g:3991:4: (lv_designators_0_0= ruleDesignator )
            	    {
            	    // InternalCoreDsl.g:3991:4: (lv_designators_0_0= ruleDesignator )
            	    // InternalCoreDsl.g:3992:5: lv_designators_0_0= ruleDesignator
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDesignatedInitializerAccess().getDesignatorsDesignatorParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_75);
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
            	    if ( cnt85 >= 1 ) break loop85;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(85, input);
                        throw eee;
                }
                cnt85++;
            } while (true);

            otherlv_1=(Token)match(input,62,FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDesignatedInitializerAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalCoreDsl.g:4013:3: ( (lv_init_2_0= ruleInitializer ) )
            // InternalCoreDsl.g:4014:4: (lv_init_2_0= ruleInitializer )
            {
            // InternalCoreDsl.g:4014:4: (lv_init_2_0= ruleInitializer )
            // InternalCoreDsl.g:4015:5: lv_init_2_0= ruleInitializer
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
    // InternalCoreDsl.g:4036:1: entryRuleDesignator returns [EObject current=null] : iv_ruleDesignator= ruleDesignator EOF ;
    public final EObject entryRuleDesignator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesignator = null;


        try {
            // InternalCoreDsl.g:4036:51: (iv_ruleDesignator= ruleDesignator EOF )
            // InternalCoreDsl.g:4037:2: iv_ruleDesignator= ruleDesignator EOF
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
    // InternalCoreDsl.g:4043:1: ruleDesignator returns [EObject current=null] : ( (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) ) ;
    public final EObject ruleDesignator() throws RecognitionException {
        EObject current = null;

        Token this_LEFT_BR_0=null;
        Token this_RIGHT_BR_2=null;
        Token otherlv_3=null;
        Token lv_prop_4_0=null;
        EObject lv_idx_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4049:2: ( ( (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:4050:2: ( (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:4050:2: ( (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_LEFT_BR) ) {
                alt86=1;
            }
            else if ( (LA86_0==66) ) {
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
                    // InternalCoreDsl.g:4051:3: (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR )
                    {
                    // InternalCoreDsl.g:4051:3: (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR )
                    // InternalCoreDsl.g:4052:4: this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR
                    {
                    this_LEFT_BR_0=(Token)match(input,RULE_LEFT_BR,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_LEFT_BR_0, grammarAccess.getDesignatorAccess().getLEFT_BRTerminalRuleCall_0_0());
                      			
                    }
                    // InternalCoreDsl.g:4056:4: ( (lv_idx_1_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:4057:5: (lv_idx_1_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:4057:5: (lv_idx_1_0= ruleConstantExpression )
                    // InternalCoreDsl.g:4058:6: lv_idx_1_0= ruleConstantExpression
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

                    this_RIGHT_BR_2=(Token)match(input,RULE_RIGHT_BR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_RIGHT_BR_2, grammarAccess.getDesignatorAccess().getRIGHT_BRTerminalRuleCall_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4081:3: (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:4081:3: (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:4082:4: otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,66,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDesignatorAccess().getFullStopKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:4086:4: ( (lv_prop_4_0= RULE_ID ) )
                    // InternalCoreDsl.g:4087:5: (lv_prop_4_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:4087:5: (lv_prop_4_0= RULE_ID )
                    // InternalCoreDsl.g:4088:6: lv_prop_4_0= RULE_ID
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
    // InternalCoreDsl.g:4109:1: entryRuleAbstractDeclarator returns [EObject current=null] : iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF ;
    public final EObject entryRuleAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractDeclarator = null;


        try {
            // InternalCoreDsl.g:4109:59: (iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF )
            // InternalCoreDsl.g:4110:2: iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF
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
    // InternalCoreDsl.g:4116:1: ruleAbstractDeclarator returns [EObject current=null] : this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator ;
    public final EObject ruleAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject this_DirectAbstractDeclarator_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4122:2: (this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator )
            // InternalCoreDsl.g:4123:2: this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator
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
    // InternalCoreDsl.g:4134:1: entryRuleDirectAbstractDeclarator returns [EObject current=null] : iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF ;
    public final EObject entryRuleDirectAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectAbstractDeclarator = null;


        try {
            // InternalCoreDsl.g:4134:65: (iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF )
            // InternalCoreDsl.g:4135:2: iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF
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
    // InternalCoreDsl.g:4141:1: ruleDirectAbstractDeclarator returns [EObject current=null] : ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR ) ) ;
    public final EObject ruleDirectAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token this_LEFT_BR_6=null;
        Token this_RIGHT_BR_8=null;
        EObject lv_declarator_2_0 = null;

        EObject this_ParameterList_3 = null;

        EObject lv_expr_7_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4147:2: ( ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR ) ) )
            // InternalCoreDsl.g:4148:2: ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR ) )
            {
            // InternalCoreDsl.g:4148:2: ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==46) ) {
                alt90=1;
            }
            else if ( (LA90_0==RULE_LEFT_BR) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalCoreDsl.g:4149:3: ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' )
                    {
                    // InternalCoreDsl.g:4149:3: ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' )
                    // InternalCoreDsl.g:4150:4: () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')'
                    {
                    // InternalCoreDsl.g:4150:4: ()
                    // InternalCoreDsl.g:4151:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDirectAbstractDeclaratorAccess().getDirectAbstractDeclaratorAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,46,FOLLOW_76); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectAbstractDeclaratorAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalCoreDsl.g:4161:4: ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] )
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==RULE_LEFT_BR||(LA88_0>=46 && LA88_0<=47)) ) {
                        alt88=1;
                    }
                    else if ( (LA88_0==65||(LA88_0>=105 && LA88_0<=114)||(LA88_0>=125 && LA88_0<=126)) ) {
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
                            // InternalCoreDsl.g:4162:5: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )?
                            {
                            // InternalCoreDsl.g:4162:5: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )?
                            int alt87=2;
                            int LA87_0 = input.LA(1);

                            if ( (LA87_0==RULE_LEFT_BR||LA87_0==46) ) {
                                alt87=1;
                            }
                            switch (alt87) {
                                case 1 :
                                    // InternalCoreDsl.g:4163:6: (lv_declarator_2_0= ruleAbstractDeclarator )
                                    {
                                    // InternalCoreDsl.g:4163:6: (lv_declarator_2_0= ruleAbstractDeclarator )
                                    // InternalCoreDsl.g:4164:7: lv_declarator_2_0= ruleAbstractDeclarator
                                    {
                                    if ( state.backtracking==0 ) {

                                      							newCompositeNode(grammarAccess.getDirectAbstractDeclaratorAccess().getDeclaratorAbstractDeclaratorParserRuleCall_0_2_0_0());
                                      						
                                    }
                                    pushFollow(FOLLOW_43);
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
                            // InternalCoreDsl.g:4182:5: this_ParameterList_3= ruleParameterList[$current]
                            {
                            if ( state.backtracking==0 ) {

                              					if (current==null) {
                              						current = createModelElement(grammarAccess.getDirectAbstractDeclaratorRule());
                              					}
                              					newCompositeNode(grammarAccess.getDirectAbstractDeclaratorAccess().getParameterListParserRuleCall_0_2_1());
                              				
                            }
                            pushFollow(FOLLOW_43);
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
                    // InternalCoreDsl.g:4200:3: ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR )
                    {
                    // InternalCoreDsl.g:4200:3: ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR )
                    // InternalCoreDsl.g:4201:4: () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR
                    {
                    // InternalCoreDsl.g:4201:4: ()
                    // InternalCoreDsl.g:4202:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDirectAbstractDeclaratorAccess().getDirectAbstractDeclaratorAction_1_0(),
                      						current);
                      				
                    }

                    }

                    this_LEFT_BR_6=(Token)match(input,RULE_LEFT_BR,FOLLOW_77); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_LEFT_BR_6, grammarAccess.getDirectAbstractDeclaratorAccess().getLEFT_BRTerminalRuleCall_1_1());
                      			
                    }
                    // InternalCoreDsl.g:4212:4: ( (lv_expr_7_0= ruleConstantExpression ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( ((LA89_0>=RULE_STRING && LA89_0<=RULE_ID)||(LA89_0>=RULE_INTEGER && LA89_0<=RULE_CHARCONST)||LA89_0==46||LA89_0==60||LA89_0==81||(LA89_0>=88 && LA89_0<=89)||(LA89_0>=92 && LA89_0<=96)||(LA89_0>=98 && LA89_0<=101)) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalCoreDsl.g:4213:5: (lv_expr_7_0= ruleConstantExpression )
                            {
                            // InternalCoreDsl.g:4213:5: (lv_expr_7_0= ruleConstantExpression )
                            // InternalCoreDsl.g:4214:6: lv_expr_7_0= ruleConstantExpression
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

                    this_RIGHT_BR_8=(Token)match(input,RULE_RIGHT_BR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_RIGHT_BR_8, grammarAccess.getDirectAbstractDeclaratorAccess().getRIGHT_BRTerminalRuleCall_1_3());
                      			
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


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalCoreDsl.g:4240:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalCoreDsl.g:4240:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalCoreDsl.g:4241:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
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
    // InternalCoreDsl.g:4247:1: ruleAssignmentExpression returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )* ) ;
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
            // InternalCoreDsl.g:4253:2: ( (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )* ) )
            // InternalCoreDsl.g:4254:2: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )* )
            {
            // InternalCoreDsl.g:4254:2: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )* )
            // InternalCoreDsl.g:4255:3: this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getPrefixExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_78);
            this_PrefixExpression_0=rulePrefixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrefixExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4263:3: ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==62||(LA92_0>=67 && LA92_0<=76)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalCoreDsl.g:4264:4: () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) )
            	    {
            	    // InternalCoreDsl.g:4264:4: ()
            	    // InternalCoreDsl.g:4265:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:4271:4: ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) )
            	    // InternalCoreDsl.g:4272:5: ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) )
            	    {
            	    // InternalCoreDsl.g:4272:5: ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) )
            	    // InternalCoreDsl.g:4273:6: (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' )
            	    {
            	    // InternalCoreDsl.g:4273:6: (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' )
            	    int alt91=11;
            	    switch ( input.LA(1) ) {
            	    case 62:
            	        {
            	        alt91=1;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt91=2;
            	        }
            	        break;
            	    case 68:
            	        {
            	        alt91=3;
            	        }
            	        break;
            	    case 69:
            	        {
            	        alt91=4;
            	        }
            	        break;
            	    case 70:
            	        {
            	        alt91=5;
            	        }
            	        break;
            	    case 71:
            	        {
            	        alt91=6;
            	        }
            	        break;
            	    case 72:
            	        {
            	        alt91=7;
            	        }
            	        break;
            	    case 73:
            	        {
            	        alt91=8;
            	        }
            	        break;
            	    case 74:
            	        {
            	        alt91=9;
            	        }
            	        break;
            	    case 75:
            	        {
            	        alt91=10;
            	        }
            	        break;
            	    case 76:
            	        {
            	        alt91=11;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 91, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt91) {
            	        case 1 :
            	            // InternalCoreDsl.g:4274:7: lv_assignment_2_1= '='
            	            {
            	            lv_assignment_2_1=(Token)match(input,62,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_1, grammarAccess.getAssignmentExpressionAccess().getAssignmentEqualsSignKeyword_1_1_0_0());
            	              						
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
            	            // InternalCoreDsl.g:4285:7: lv_assignment_2_2= '*='
            	            {
            	            lv_assignment_2_2=(Token)match(input,67,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_2, grammarAccess.getAssignmentExpressionAccess().getAssignmentAsteriskEqualsSignKeyword_1_1_0_1());
            	              						
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
            	            // InternalCoreDsl.g:4296:7: lv_assignment_2_3= '/='
            	            {
            	            lv_assignment_2_3=(Token)match(input,68,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_3, grammarAccess.getAssignmentExpressionAccess().getAssignmentSolidusEqualsSignKeyword_1_1_0_2());
            	              						
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
            	            // InternalCoreDsl.g:4307:7: lv_assignment_2_4= '%='
            	            {
            	            lv_assignment_2_4=(Token)match(input,69,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_4, grammarAccess.getAssignmentExpressionAccess().getAssignmentPercentSignEqualsSignKeyword_1_1_0_3());
            	              						
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
            	            // InternalCoreDsl.g:4318:7: lv_assignment_2_5= '+='
            	            {
            	            lv_assignment_2_5=(Token)match(input,70,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_5, grammarAccess.getAssignmentExpressionAccess().getAssignmentPlusSignEqualsSignKeyword_1_1_0_4());
            	              						
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
            	            // InternalCoreDsl.g:4329:7: lv_assignment_2_6= '-='
            	            {
            	            lv_assignment_2_6=(Token)match(input,71,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_6, grammarAccess.getAssignmentExpressionAccess().getAssignmentHyphenMinusEqualsSignKeyword_1_1_0_5());
            	              						
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
            	            // InternalCoreDsl.g:4340:7: lv_assignment_2_7= '<<='
            	            {
            	            lv_assignment_2_7=(Token)match(input,72,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_7, grammarAccess.getAssignmentExpressionAccess().getAssignmentLessThanSignLessThanSignEqualsSignKeyword_1_1_0_6());
            	              						
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
            	            // InternalCoreDsl.g:4351:7: lv_assignment_2_8= '>>='
            	            {
            	            lv_assignment_2_8=(Token)match(input,73,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_8, grammarAccess.getAssignmentExpressionAccess().getAssignmentGreaterThanSignGreaterThanSignEqualsSignKeyword_1_1_0_7());
            	              						
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
            	            // InternalCoreDsl.g:4362:7: lv_assignment_2_9= '&='
            	            {
            	            lv_assignment_2_9=(Token)match(input,74,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_9, grammarAccess.getAssignmentExpressionAccess().getAssignmentAmpersandEqualsSignKeyword_1_1_0_8());
            	              						
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
            	            // InternalCoreDsl.g:4373:7: lv_assignment_2_10= '^='
            	            {
            	            lv_assignment_2_10=(Token)match(input,75,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_10, grammarAccess.getAssignmentExpressionAccess().getAssignmentCircumflexAccentEqualsSignKeyword_1_1_0_9());
            	              						
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
            	            // InternalCoreDsl.g:4384:7: lv_assignment_2_11= '|='
            	            {
            	            lv_assignment_2_11=(Token)match(input,76,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_11, grammarAccess.getAssignmentExpressionAccess().getAssignmentVerticalLineEqualsSignKeyword_1_1_0_10());
            	              						
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

            	    // InternalCoreDsl.g:4397:4: ( (lv_rights_3_0= ruleConditionalExpression ) )
            	    // InternalCoreDsl.g:4398:5: (lv_rights_3_0= ruleConditionalExpression )
            	    {
            	    // InternalCoreDsl.g:4398:5: (lv_rights_3_0= ruleConditionalExpression )
            	    // InternalCoreDsl.g:4399:6: lv_rights_3_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightsConditionalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_78);
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
            	    break loop92;
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
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleAssignmentExpression2"
    // InternalCoreDsl.g:4421:1: entryRuleAssignmentExpression2 returns [EObject current=null] : iv_ruleAssignmentExpression2= ruleAssignmentExpression2 EOF ;
    public final EObject entryRuleAssignmentExpression2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression2 = null;


        try {
            // InternalCoreDsl.g:4421:62: (iv_ruleAssignmentExpression2= ruleAssignmentExpression2 EOF )
            // InternalCoreDsl.g:4422:2: iv_ruleAssignmentExpression2= ruleAssignmentExpression2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpression2Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression2=ruleAssignmentExpression2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression2; 
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
    // $ANTLR end "entryRuleAssignmentExpression2"


    // $ANTLR start "ruleAssignmentExpression2"
    // InternalCoreDsl.g:4428:1: ruleAssignmentExpression2 returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ ) ;
    public final EObject ruleAssignmentExpression2() throws RecognitionException {
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
            // InternalCoreDsl.g:4434:2: ( (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ ) )
            // InternalCoreDsl.g:4435:2: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ )
            {
            // InternalCoreDsl.g:4435:2: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ )
            // InternalCoreDsl.g:4436:3: this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpression2Access().getPrefixExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_79);
            this_PrefixExpression_0=rulePrefixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrefixExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4444:3: ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+
            int cnt94=0;
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==62||(LA94_0>=67 && LA94_0<=76)) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalCoreDsl.g:4445:4: () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) )
            	    {
            	    // InternalCoreDsl.g:4445:4: ()
            	    // InternalCoreDsl.g:4446:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAssignmentExpression2Access().getAssignmentExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:4452:4: ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) )
            	    // InternalCoreDsl.g:4453:5: ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) )
            	    {
            	    // InternalCoreDsl.g:4453:5: ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) )
            	    // InternalCoreDsl.g:4454:6: (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' )
            	    {
            	    // InternalCoreDsl.g:4454:6: (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' )
            	    int alt93=11;
            	    switch ( input.LA(1) ) {
            	    case 62:
            	        {
            	        alt93=1;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt93=2;
            	        }
            	        break;
            	    case 68:
            	        {
            	        alt93=3;
            	        }
            	        break;
            	    case 69:
            	        {
            	        alt93=4;
            	        }
            	        break;
            	    case 70:
            	        {
            	        alt93=5;
            	        }
            	        break;
            	    case 71:
            	        {
            	        alt93=6;
            	        }
            	        break;
            	    case 72:
            	        {
            	        alt93=7;
            	        }
            	        break;
            	    case 73:
            	        {
            	        alt93=8;
            	        }
            	        break;
            	    case 74:
            	        {
            	        alt93=9;
            	        }
            	        break;
            	    case 75:
            	        {
            	        alt93=10;
            	        }
            	        break;
            	    case 76:
            	        {
            	        alt93=11;
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
            	            // InternalCoreDsl.g:4455:7: lv_assignment_2_1= '='
            	            {
            	            lv_assignment_2_1=(Token)match(input,62,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_1, grammarAccess.getAssignmentExpression2Access().getAssignmentEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalCoreDsl.g:4466:7: lv_assignment_2_2= '*='
            	            {
            	            lv_assignment_2_2=(Token)match(input,67,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_2, grammarAccess.getAssignmentExpression2Access().getAssignmentAsteriskEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalCoreDsl.g:4477:7: lv_assignment_2_3= '/='
            	            {
            	            lv_assignment_2_3=(Token)match(input,68,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_3, grammarAccess.getAssignmentExpression2Access().getAssignmentSolidusEqualsSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_3, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalCoreDsl.g:4488:7: lv_assignment_2_4= '%='
            	            {
            	            lv_assignment_2_4=(Token)match(input,69,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_4, grammarAccess.getAssignmentExpression2Access().getAssignmentPercentSignEqualsSignKeyword_1_1_0_3());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_4, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // InternalCoreDsl.g:4499:7: lv_assignment_2_5= '+='
            	            {
            	            lv_assignment_2_5=(Token)match(input,70,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_5, grammarAccess.getAssignmentExpression2Access().getAssignmentPlusSignEqualsSignKeyword_1_1_0_4());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_5, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // InternalCoreDsl.g:4510:7: lv_assignment_2_6= '-='
            	            {
            	            lv_assignment_2_6=(Token)match(input,71,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_6, grammarAccess.getAssignmentExpression2Access().getAssignmentHyphenMinusEqualsSignKeyword_1_1_0_5());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_6, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 7 :
            	            // InternalCoreDsl.g:4521:7: lv_assignment_2_7= '<<='
            	            {
            	            lv_assignment_2_7=(Token)match(input,72,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_7, grammarAccess.getAssignmentExpression2Access().getAssignmentLessThanSignLessThanSignEqualsSignKeyword_1_1_0_6());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_7, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 8 :
            	            // InternalCoreDsl.g:4532:7: lv_assignment_2_8= '>>='
            	            {
            	            lv_assignment_2_8=(Token)match(input,73,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_8, grammarAccess.getAssignmentExpression2Access().getAssignmentGreaterThanSignGreaterThanSignEqualsSignKeyword_1_1_0_7());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_8, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 9 :
            	            // InternalCoreDsl.g:4543:7: lv_assignment_2_9= '&='
            	            {
            	            lv_assignment_2_9=(Token)match(input,74,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_9, grammarAccess.getAssignmentExpression2Access().getAssignmentAmpersandEqualsSignKeyword_1_1_0_8());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_9, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 10 :
            	            // InternalCoreDsl.g:4554:7: lv_assignment_2_10= '^='
            	            {
            	            lv_assignment_2_10=(Token)match(input,75,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_10, grammarAccess.getAssignmentExpression2Access().getAssignmentCircumflexAccentEqualsSignKeyword_1_1_0_9());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_10, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 11 :
            	            // InternalCoreDsl.g:4565:7: lv_assignment_2_11= '|='
            	            {
            	            lv_assignment_2_11=(Token)match(input,76,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_assignment_2_11, grammarAccess.getAssignmentExpression2Access().getAssignmentVerticalLineEqualsSignKeyword_1_1_0_10());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAssignmentExpression2Rule());
            	              							}
            	              							addWithLastConsumed(current, "assignment", lv_assignment_2_11, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalCoreDsl.g:4578:4: ( (lv_rights_3_0= ruleConditionalExpression ) )
            	    // InternalCoreDsl.g:4579:5: (lv_rights_3_0= ruleConditionalExpression )
            	    {
            	    // InternalCoreDsl.g:4579:5: (lv_rights_3_0= ruleConditionalExpression )
            	    // InternalCoreDsl.g:4580:6: lv_rights_3_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAssignmentExpression2Access().getRightsConditionalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_78);
            	    lv_rights_3_0=ruleConditionalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAssignmentExpression2Rule());
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
            	    if ( cnt94 >= 1 ) break loop94;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(94, input);
                        throw eee;
                }
                cnt94++;
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
    // $ANTLR end "ruleAssignmentExpression2"


    // $ANTLR start "entryRuleConditionalExpression"
    // InternalCoreDsl.g:4602:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalCoreDsl.g:4602:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalCoreDsl.g:4603:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalCoreDsl.g:4609:1: ruleConditionalExpression returns [EObject current=null] : (this_ConcatenationExpression_0= ruleConcatenationExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_ConcatenationExpression_0 = null;

        EObject lv_left_3_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4615:2: ( (this_ConcatenationExpression_0= ruleConcatenationExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalCoreDsl.g:4616:2: (this_ConcatenationExpression_0= ruleConcatenationExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalCoreDsl.g:4616:2: (this_ConcatenationExpression_0= ruleConcatenationExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? )
            // InternalCoreDsl.g:4617:3: this_ConcatenationExpression_0= ruleConcatenationExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConditionalExpressionAccess().getConcatenationExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_80);
            this_ConcatenationExpression_0=ruleConcatenationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ConcatenationExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4625:3: ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==77) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalCoreDsl.g:4626:4: () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) )
                    {
                    // InternalCoreDsl.g:4626:4: ()
                    // InternalCoreDsl.g:4627:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getConditionalExpressionAccess().getConditionalExpressionCondAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,77,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:4637:4: ( (lv_left_3_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:4638:5: (lv_left_3_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:4638:5: (lv_left_3_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:4639:6: lv_left_3_0= ruleConditionalExpression
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

                    otherlv_4=(Token)match(input,38,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                      			
                    }
                    // InternalCoreDsl.g:4660:4: ( (lv_right_5_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:4661:5: (lv_right_5_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:4661:5: (lv_right_5_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:4662:6: lv_right_5_0= ruleConditionalExpression
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


    // $ANTLR start "entryRuleConcatenationExpression"
    // InternalCoreDsl.g:4684:1: entryRuleConcatenationExpression returns [EObject current=null] : iv_ruleConcatenationExpression= ruleConcatenationExpression EOF ;
    public final EObject entryRuleConcatenationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatenationExpression = null;


        try {
            // InternalCoreDsl.g:4684:64: (iv_ruleConcatenationExpression= ruleConcatenationExpression EOF )
            // InternalCoreDsl.g:4685:2: iv_ruleConcatenationExpression= ruleConcatenationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConcatenationExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConcatenationExpression=ruleConcatenationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConcatenationExpression; 
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
    // $ANTLR end "entryRuleConcatenationExpression"


    // $ANTLR start "ruleConcatenationExpression"
    // InternalCoreDsl.g:4691:1: ruleConcatenationExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )? ) ;
    public final EObject ruleConcatenationExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4697:2: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )? ) )
            // InternalCoreDsl.g:4698:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )? )
            {
            // InternalCoreDsl.g:4698:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )? )
            // InternalCoreDsl.g:4699:3: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConcatenationExpressionAccess().getLogicalOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_81);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4707:3: ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==43) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalCoreDsl.g:4708:4: () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) )
                    {
                    // InternalCoreDsl.g:4708:4: ()
                    // InternalCoreDsl.g:4709:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getConcatenationExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4715:4: ( (lv_op_2_0= '::' ) )
                    // InternalCoreDsl.g:4716:5: (lv_op_2_0= '::' )
                    {
                    // InternalCoreDsl.g:4716:5: (lv_op_2_0= '::' )
                    // InternalCoreDsl.g:4717:6: lv_op_2_0= '::'
                    {
                    lv_op_2_0=(Token)match(input,43,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_0, grammarAccess.getConcatenationExpressionAccess().getOpColonColonKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConcatenationExpressionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_0, "::");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:4729:4: ( (lv_right_3_0= ruleConcatenationExpression ) )
                    // InternalCoreDsl.g:4730:5: (lv_right_3_0= ruleConcatenationExpression )
                    {
                    // InternalCoreDsl.g:4730:5: (lv_right_3_0= ruleConcatenationExpression )
                    // InternalCoreDsl.g:4731:6: lv_right_3_0= ruleConcatenationExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConcatenationExpressionAccess().getRightConcatenationExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleConcatenationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConcatenationExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.minres.coredsl.CoreDsl.ConcatenationExpression");
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
    // $ANTLR end "ruleConcatenationExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalCoreDsl.g:4753:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalCoreDsl.g:4753:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalCoreDsl.g:4754:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalCoreDsl.g:4760:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4766:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4767:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4767:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? )
            // InternalCoreDsl.g:4768:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_82);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4776:3: ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==78) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalCoreDsl.g:4777:4: () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) )
                    {
                    // InternalCoreDsl.g:4777:4: ()
                    // InternalCoreDsl.g:4778:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getLogicalOrExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4784:4: ( (lv_op_2_0= '||' ) )
                    // InternalCoreDsl.g:4785:5: (lv_op_2_0= '||' )
                    {
                    // InternalCoreDsl.g:4785:5: (lv_op_2_0= '||' )
                    // InternalCoreDsl.g:4786:6: lv_op_2_0= '||'
                    {
                    lv_op_2_0=(Token)match(input,78,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4798:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
                    // InternalCoreDsl.g:4799:5: (lv_right_3_0= ruleLogicalOrExpression )
                    {
                    // InternalCoreDsl.g:4799:5: (lv_right_3_0= ruleLogicalOrExpression )
                    // InternalCoreDsl.g:4800:6: lv_right_3_0= ruleLogicalOrExpression
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
    // InternalCoreDsl.g:4822:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalCoreDsl.g:4822:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalCoreDsl.g:4823:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalCoreDsl.g:4829:1: ruleLogicalAndExpression returns [EObject current=null] : (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_InclusiveOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4835:2: ( (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? ) )
            // InternalCoreDsl.g:4836:2: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? )
            {
            // InternalCoreDsl.g:4836:2: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? )
            // InternalCoreDsl.g:4837:3: this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getInclusiveOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_83);
            this_InclusiveOrExpression_0=ruleInclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_InclusiveOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4845:3: ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==79) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalCoreDsl.g:4846:4: () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    {
                    // InternalCoreDsl.g:4846:4: ()
                    // InternalCoreDsl.g:4847:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getLogicalAndExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4853:4: ( (lv_op_2_0= '&&' ) )
                    // InternalCoreDsl.g:4854:5: (lv_op_2_0= '&&' )
                    {
                    // InternalCoreDsl.g:4854:5: (lv_op_2_0= '&&' )
                    // InternalCoreDsl.g:4855:6: lv_op_2_0= '&&'
                    {
                    lv_op_2_0=(Token)match(input,79,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4867:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    // InternalCoreDsl.g:4868:5: (lv_right_3_0= ruleLogicalAndExpression )
                    {
                    // InternalCoreDsl.g:4868:5: (lv_right_3_0= ruleLogicalAndExpression )
                    // InternalCoreDsl.g:4869:6: lv_right_3_0= ruleLogicalAndExpression
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
    // InternalCoreDsl.g:4891:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalCoreDsl.g:4891:62: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalCoreDsl.g:4892:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
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
    // InternalCoreDsl.g:4898:1: ruleInclusiveOrExpression returns [EObject current=null] : (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_ExclusiveOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4904:2: ( (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4905:2: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4905:2: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? )
            // InternalCoreDsl.g:4906:3: this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExclusiveOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_84);
            this_ExclusiveOrExpression_0=ruleExclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExclusiveOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4914:3: ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==42) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalCoreDsl.g:4915:4: () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) )
                    {
                    // InternalCoreDsl.g:4915:4: ()
                    // InternalCoreDsl.g:4916:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getInclusiveOrExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4922:4: ( (lv_op_2_0= '|' ) )
                    // InternalCoreDsl.g:4923:5: (lv_op_2_0= '|' )
                    {
                    // InternalCoreDsl.g:4923:5: (lv_op_2_0= '|' )
                    // InternalCoreDsl.g:4924:6: lv_op_2_0= '|'
                    {
                    lv_op_2_0=(Token)match(input,42,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4936:4: ( (lv_right_3_0= ruleInclusiveOrExpression ) )
                    // InternalCoreDsl.g:4937:5: (lv_right_3_0= ruleInclusiveOrExpression )
                    {
                    // InternalCoreDsl.g:4937:5: (lv_right_3_0= ruleInclusiveOrExpression )
                    // InternalCoreDsl.g:4938:6: lv_right_3_0= ruleInclusiveOrExpression
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
    // InternalCoreDsl.g:4960:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalCoreDsl.g:4960:62: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalCoreDsl.g:4961:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
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
    // InternalCoreDsl.g:4967:1: ruleExclusiveOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4973:2: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4974:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4974:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? )
            // InternalCoreDsl.g:4975:3: this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_85);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4983:3: ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==80) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalCoreDsl.g:4984:4: () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) )
                    {
                    // InternalCoreDsl.g:4984:4: ()
                    // InternalCoreDsl.g:4985:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getExclusiveOrExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4991:4: ( (lv_op_2_0= '^' ) )
                    // InternalCoreDsl.g:4992:5: (lv_op_2_0= '^' )
                    {
                    // InternalCoreDsl.g:4992:5: (lv_op_2_0= '^' )
                    // InternalCoreDsl.g:4993:6: lv_op_2_0= '^'
                    {
                    lv_op_2_0=(Token)match(input,80,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5005:4: ( (lv_right_3_0= ruleExclusiveOrExpression ) )
                    // InternalCoreDsl.g:5006:5: (lv_right_3_0= ruleExclusiveOrExpression )
                    {
                    // InternalCoreDsl.g:5006:5: (lv_right_3_0= ruleExclusiveOrExpression )
                    // InternalCoreDsl.g:5007:6: lv_right_3_0= ruleExclusiveOrExpression
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
    // InternalCoreDsl.g:5029:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalCoreDsl.g:5029:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalCoreDsl.g:5030:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalCoreDsl.g:5036:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5042:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? ) )
            // InternalCoreDsl.g:5043:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? )
            {
            // InternalCoreDsl.g:5043:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? )
            // InternalCoreDsl.g:5044:3: this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_86);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5052:3: ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==81) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalCoreDsl.g:5053:4: () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) )
                    {
                    // InternalCoreDsl.g:5053:4: ()
                    // InternalCoreDsl.g:5054:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAndExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5060:4: ( (lv_op_2_0= '&' ) )
                    // InternalCoreDsl.g:5061:5: (lv_op_2_0= '&' )
                    {
                    // InternalCoreDsl.g:5061:5: (lv_op_2_0= '&' )
                    // InternalCoreDsl.g:5062:6: lv_op_2_0= '&'
                    {
                    lv_op_2_0=(Token)match(input,81,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5074:4: ( (lv_right_3_0= ruleAndExpression ) )
                    // InternalCoreDsl.g:5075:5: (lv_right_3_0= ruleAndExpression )
                    {
                    // InternalCoreDsl.g:5075:5: (lv_right_3_0= ruleAndExpression )
                    // InternalCoreDsl.g:5076:6: lv_right_3_0= ruleAndExpression
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
    // InternalCoreDsl.g:5098:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalCoreDsl.g:5098:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalCoreDsl.g:5099:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalCoreDsl.g:5105:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5111:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? ) )
            // InternalCoreDsl.g:5112:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? )
            {
            // InternalCoreDsl.g:5112:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? )
            // InternalCoreDsl.g:5113:3: this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_87);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5121:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( ((LA103_0>=82 && LA103_0<=83)) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalCoreDsl.g:5122:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
                    {
                    // InternalCoreDsl.g:5122:4: ()
                    // InternalCoreDsl.g:5123:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getEqualityExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5129:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
                    // InternalCoreDsl.g:5130:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
                    {
                    // InternalCoreDsl.g:5130:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
                    // InternalCoreDsl.g:5131:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
                    {
                    // InternalCoreDsl.g:5131:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
                    int alt102=2;
                    int LA102_0 = input.LA(1);

                    if ( (LA102_0==82) ) {
                        alt102=1;
                    }
                    else if ( (LA102_0==83) ) {
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
                            // InternalCoreDsl.g:5132:7: lv_op_2_1= '=='
                            {
                            lv_op_2_1=(Token)match(input,82,FOLLOW_47); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5143:7: lv_op_2_2= '!='
                            {
                            lv_op_2_2=(Token)match(input,83,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5156:4: ( (lv_right_3_0= ruleEqualityExpression ) )
                    // InternalCoreDsl.g:5157:5: (lv_right_3_0= ruleEqualityExpression )
                    {
                    // InternalCoreDsl.g:5157:5: (lv_right_3_0= ruleEqualityExpression )
                    // InternalCoreDsl.g:5158:6: lv_right_3_0= ruleEqualityExpression
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
    // InternalCoreDsl.g:5180:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalCoreDsl.g:5180:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalCoreDsl.g:5181:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalCoreDsl.g:5187:1: ruleRelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? ) ;
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
            // InternalCoreDsl.g:5193:2: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? ) )
            // InternalCoreDsl.g:5194:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? )
            {
            // InternalCoreDsl.g:5194:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? )
            // InternalCoreDsl.g:5195:3: this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_88);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5203:3: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( ((LA105_0>=63 && LA105_0<=64)||(LA105_0>=84 && LA105_0<=85)) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalCoreDsl.g:5204:4: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
                    {
                    // InternalCoreDsl.g:5204:4: ()
                    // InternalCoreDsl.g:5205:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getRelationalExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5211:4: ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
                    // InternalCoreDsl.g:5212:5: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
                    {
                    // InternalCoreDsl.g:5212:5: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
                    // InternalCoreDsl.g:5213:6: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
                    {
                    // InternalCoreDsl.g:5213:6: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
                    int alt104=4;
                    switch ( input.LA(1) ) {
                    case 63:
                        {
                        alt104=1;
                        }
                        break;
                    case 64:
                        {
                        alt104=2;
                        }
                        break;
                    case 84:
                        {
                        alt104=3;
                        }
                        break;
                    case 85:
                        {
                        alt104=4;
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
                            // InternalCoreDsl.g:5214:7: lv_op_2_1= '<'
                            {
                            lv_op_2_1=(Token)match(input,63,FOLLOW_47); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5225:7: lv_op_2_2= '>'
                            {
                            lv_op_2_2=(Token)match(input,64,FOLLOW_47); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5236:7: lv_op_2_3= '<='
                            {
                            lv_op_2_3=(Token)match(input,84,FOLLOW_47); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5247:7: lv_op_2_4= '>='
                            {
                            lv_op_2_4=(Token)match(input,85,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5260:4: ( (lv_right_3_0= ruleRelationalExpression ) )
                    // InternalCoreDsl.g:5261:5: (lv_right_3_0= ruleRelationalExpression )
                    {
                    // InternalCoreDsl.g:5261:5: (lv_right_3_0= ruleRelationalExpression )
                    // InternalCoreDsl.g:5262:6: lv_right_3_0= ruleRelationalExpression
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
    // InternalCoreDsl.g:5284:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalCoreDsl.g:5284:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalCoreDsl.g:5285:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalCoreDsl.g:5291:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5297:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? ) )
            // InternalCoreDsl.g:5298:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? )
            {
            // InternalCoreDsl.g:5298:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? )
            // InternalCoreDsl.g:5299:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_89);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5307:3: ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( ((LA107_0>=86 && LA107_0<=87)) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalCoreDsl.g:5308:4: () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) )
                    {
                    // InternalCoreDsl.g:5308:4: ()
                    // InternalCoreDsl.g:5309:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getShiftExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5315:4: ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) )
                    // InternalCoreDsl.g:5316:5: ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) )
                    {
                    // InternalCoreDsl.g:5316:5: ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) )
                    // InternalCoreDsl.g:5317:6: (lv_op_2_1= '<<' | lv_op_2_2= '>>' )
                    {
                    // InternalCoreDsl.g:5317:6: (lv_op_2_1= '<<' | lv_op_2_2= '>>' )
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==86) ) {
                        alt106=1;
                    }
                    else if ( (LA106_0==87) ) {
                        alt106=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 106, 0, input);

                        throw nvae;
                    }
                    switch (alt106) {
                        case 1 :
                            // InternalCoreDsl.g:5318:7: lv_op_2_1= '<<'
                            {
                            lv_op_2_1=(Token)match(input,86,FOLLOW_47); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5329:7: lv_op_2_2= '>>'
                            {
                            lv_op_2_2=(Token)match(input,87,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5342:4: ( (lv_right_3_0= ruleShiftExpression ) )
                    // InternalCoreDsl.g:5343:5: (lv_right_3_0= ruleShiftExpression )
                    {
                    // InternalCoreDsl.g:5343:5: (lv_right_3_0= ruleShiftExpression )
                    // InternalCoreDsl.g:5344:6: lv_right_3_0= ruleShiftExpression
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
    // InternalCoreDsl.g:5366:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalCoreDsl.g:5366:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalCoreDsl.g:5367:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalCoreDsl.g:5373:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5379:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) )
            // InternalCoreDsl.g:5380:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            {
            // InternalCoreDsl.g:5380:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            // InternalCoreDsl.g:5381:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_90);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5389:3: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( ((LA109_0>=88 && LA109_0<=89)) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalCoreDsl.g:5390:4: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
                    {
                    // InternalCoreDsl.g:5390:4: ()
                    // InternalCoreDsl.g:5391:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAdditiveExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5397:4: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    // InternalCoreDsl.g:5398:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    {
                    // InternalCoreDsl.g:5398:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    // InternalCoreDsl.g:5399:6: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    {
                    // InternalCoreDsl.g:5399:6: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( (LA108_0==88) ) {
                        alt108=1;
                    }
                    else if ( (LA108_0==89) ) {
                        alt108=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 108, 0, input);

                        throw nvae;
                    }
                    switch (alt108) {
                        case 1 :
                            // InternalCoreDsl.g:5400:7: lv_op_2_1= '+'
                            {
                            lv_op_2_1=(Token)match(input,88,FOLLOW_47); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5411:7: lv_op_2_2= '-'
                            {
                            lv_op_2_2=(Token)match(input,89,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5424:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
                    // InternalCoreDsl.g:5425:5: (lv_right_3_0= ruleAdditiveExpression )
                    {
                    // InternalCoreDsl.g:5425:5: (lv_right_3_0= ruleAdditiveExpression )
                    // InternalCoreDsl.g:5426:6: lv_right_3_0= ruleAdditiveExpression
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
    // InternalCoreDsl.g:5448:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalCoreDsl.g:5448:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalCoreDsl.g:5449:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalCoreDsl.g:5455:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_CastExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5461:2: ( (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? ) )
            // InternalCoreDsl.g:5462:2: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? )
            {
            // InternalCoreDsl.g:5462:2: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? )
            // InternalCoreDsl.g:5463:3: this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_91);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CastExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5471:3: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==60||(LA111_0>=90 && LA111_0<=91)) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalCoreDsl.g:5472:4: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    {
                    // InternalCoreDsl.g:5472:4: ()
                    // InternalCoreDsl.g:5473:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getMultiplicativeExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5479:4: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) )
                    // InternalCoreDsl.g:5480:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
                    {
                    // InternalCoreDsl.g:5480:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
                    // InternalCoreDsl.g:5481:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
                    {
                    // InternalCoreDsl.g:5481:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
                    int alt110=3;
                    switch ( input.LA(1) ) {
                    case 60:
                        {
                        alt110=1;
                        }
                        break;
                    case 90:
                        {
                        alt110=2;
                        }
                        break;
                    case 91:
                        {
                        alt110=3;
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
                            // InternalCoreDsl.g:5482:7: lv_op_2_1= '*'
                            {
                            lv_op_2_1=(Token)match(input,60,FOLLOW_47); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5493:7: lv_op_2_2= '/'
                            {
                            lv_op_2_2=(Token)match(input,90,FOLLOW_47); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5504:7: lv_op_2_3= '%'
                            {
                            lv_op_2_3=(Token)match(input,91,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5517:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    // InternalCoreDsl.g:5518:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    {
                    // InternalCoreDsl.g:5518:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    // InternalCoreDsl.g:5519:6: lv_right_3_0= ruleMultiplicativeExpression
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
    // InternalCoreDsl.g:5541:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalCoreDsl.g:5541:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalCoreDsl.g:5542:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalCoreDsl.g:5548:1: ruleCastExpression returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_PrefixExpression_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_left_4_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5554:2: ( (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) ) )
            // InternalCoreDsl.g:5555:2: (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) )
            {
            // InternalCoreDsl.g:5555:2: (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) ) )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( ((LA112_0>=RULE_STRING && LA112_0<=RULE_ID)||(LA112_0>=RULE_INTEGER && LA112_0<=RULE_CHARCONST)||LA112_0==60||LA112_0==81||(LA112_0>=88 && LA112_0<=89)||(LA112_0>=92 && LA112_0<=96)||(LA112_0>=98 && LA112_0<=101)) ) {
                alt112=1;
            }
            else if ( (LA112_0==46) ) {
                int LA112_2 = input.LA(2);

                if ( (LA112_2==65||(LA112_2>=105 && LA112_2<=114)||(LA112_2>=125 && LA112_2<=126)) ) {
                    alt112=2;
                }
                else if ( ((LA112_2>=RULE_STRING && LA112_2<=RULE_ID)||(LA112_2>=RULE_INTEGER && LA112_2<=RULE_CHARCONST)||LA112_2==46||LA112_2==60||LA112_2==81||(LA112_2>=88 && LA112_2<=89)||(LA112_2>=92 && LA112_2<=96)||(LA112_2>=98 && LA112_2<=101)) ) {
                    alt112=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 112, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // InternalCoreDsl.g:5556:3: this_PrefixExpression_0= rulePrefixExpression
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
                    // InternalCoreDsl.g:5565:3: (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) )
                    {
                    // InternalCoreDsl.g:5565:3: (otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) ) )
                    // InternalCoreDsl.g:5566:4: otherlv_1= '(' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ')' ( (lv_left_4_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,46,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:5570:4: ( (lv_type_2_0= ruleDataTypeSpecifier ) )
                    // InternalCoreDsl.g:5571:5: (lv_type_2_0= ruleDataTypeSpecifier )
                    {
                    // InternalCoreDsl.g:5571:5: (lv_type_2_0= ruleDataTypeSpecifier )
                    // InternalCoreDsl.g:5572:6: lv_type_2_0= ruleDataTypeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeDataTypeSpecifierParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
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

                    otherlv_3=(Token)match(input,47,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }
                    // InternalCoreDsl.g:5593:4: ( (lv_left_4_0= ruleCastExpression ) )
                    // InternalCoreDsl.g:5594:5: (lv_left_4_0= ruleCastExpression )
                    {
                    // InternalCoreDsl.g:5594:5: (lv_left_4_0= ruleCastExpression )
                    // InternalCoreDsl.g:5595:6: lv_left_4_0= ruleCastExpression
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
    // InternalCoreDsl.g:5617:1: entryRulePrefixExpression returns [EObject current=null] : iv_rulePrefixExpression= rulePrefixExpression EOF ;
    public final EObject entryRulePrefixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpression = null;


        try {
            // InternalCoreDsl.g:5617:57: (iv_rulePrefixExpression= rulePrefixExpression EOF )
            // InternalCoreDsl.g:5618:2: iv_rulePrefixExpression= rulePrefixExpression EOF
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
    // InternalCoreDsl.g:5624:1: rulePrefixExpression returns [EObject current=null] : (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) ) ;
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
            // InternalCoreDsl.g:5630:2: ( (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) ) )
            // InternalCoreDsl.g:5631:2: (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) )
            {
            // InternalCoreDsl.g:5631:2: (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' ) )
            int alt114=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 46:
            case 98:
            case 99:
            case 100:
            case 101:
                {
                alt114=1;
                }
                break;
            case 92:
                {
                alt114=2;
                }
                break;
            case 93:
                {
                alt114=3;
                }
                break;
            case 60:
            case 81:
            case 88:
            case 89:
            case 95:
            case 96:
                {
                alt114=4;
                }
                break;
            case 94:
                {
                alt114=5;
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
                    // InternalCoreDsl.g:5632:3: this_PostfixExpression_0= rulePostfixExpression
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
                    // InternalCoreDsl.g:5641:3: ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) )
                    {
                    // InternalCoreDsl.g:5641:3: ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) )
                    // InternalCoreDsl.g:5642:4: ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) )
                    {
                    // InternalCoreDsl.g:5642:4: ( (lv_op_1_0= '++' ) )
                    // InternalCoreDsl.g:5643:5: (lv_op_1_0= '++' )
                    {
                    // InternalCoreDsl.g:5643:5: (lv_op_1_0= '++' )
                    // InternalCoreDsl.g:5644:6: lv_op_1_0= '++'
                    {
                    lv_op_1_0=(Token)match(input,92,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5656:4: ( (lv_left_2_0= rulePrefixExpression ) )
                    // InternalCoreDsl.g:5657:5: (lv_left_2_0= rulePrefixExpression )
                    {
                    // InternalCoreDsl.g:5657:5: (lv_left_2_0= rulePrefixExpression )
                    // InternalCoreDsl.g:5658:6: lv_left_2_0= rulePrefixExpression
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
                    // InternalCoreDsl.g:5677:3: ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) )
                    {
                    // InternalCoreDsl.g:5677:3: ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) )
                    // InternalCoreDsl.g:5678:4: ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) )
                    {
                    // InternalCoreDsl.g:5678:4: ( (lv_op_3_0= '--' ) )
                    // InternalCoreDsl.g:5679:5: (lv_op_3_0= '--' )
                    {
                    // InternalCoreDsl.g:5679:5: (lv_op_3_0= '--' )
                    // InternalCoreDsl.g:5680:6: lv_op_3_0= '--'
                    {
                    lv_op_3_0=(Token)match(input,93,FOLLOW_47); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5692:4: ( (lv_left_4_0= rulePrefixExpression ) )
                    // InternalCoreDsl.g:5693:5: (lv_left_4_0= rulePrefixExpression )
                    {
                    // InternalCoreDsl.g:5693:5: (lv_left_4_0= rulePrefixExpression )
                    // InternalCoreDsl.g:5694:6: lv_left_4_0= rulePrefixExpression
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
                    // InternalCoreDsl.g:5713:3: (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) )
                    {
                    // InternalCoreDsl.g:5713:3: (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) )
                    // InternalCoreDsl.g:5714:4: this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getPrefixExpressionRule());
                      				}
                      				newCompositeNode(grammarAccess.getPrefixExpressionAccess().getUnaryOperatorParserRuleCall_3_0());
                      			
                    }
                    pushFollow(FOLLOW_47);
                    this_UnaryOperator_5=ruleUnaryOperator(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_UnaryOperator_5;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:5725:4: ( (lv_left_6_0= ruleCastExpression ) )
                    // InternalCoreDsl.g:5726:5: (lv_left_6_0= ruleCastExpression )
                    {
                    // InternalCoreDsl.g:5726:5: (lv_left_6_0= ruleCastExpression )
                    // InternalCoreDsl.g:5727:6: lv_left_6_0= ruleCastExpression
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
                    // InternalCoreDsl.g:5746:3: ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' )
                    {
                    // InternalCoreDsl.g:5746:3: ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')' )
                    // InternalCoreDsl.g:5747:4: ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) ) otherlv_11= ')'
                    {
                    // InternalCoreDsl.g:5747:4: ( (lv_op_7_0= 'sizeof' ) )
                    // InternalCoreDsl.g:5748:5: (lv_op_7_0= 'sizeof' )
                    {
                    // InternalCoreDsl.g:5748:5: (lv_op_7_0= 'sizeof' )
                    // InternalCoreDsl.g:5749:6: lv_op_7_0= 'sizeof'
                    {
                    lv_op_7_0=(Token)match(input,94,FOLLOW_41); if (state.failed) return current;
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

                    otherlv_8=(Token)match(input,46,FOLLOW_92); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getPrefixExpressionAccess().getLeftParenthesisKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:5765:4: ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleDataTypeSpecifier ) ) )
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( ((LA113_0>=RULE_STRING && LA113_0<=RULE_ID)||(LA113_0>=RULE_INTEGER && LA113_0<=RULE_CHARCONST)||LA113_0==46||(LA113_0>=98 && LA113_0<=101)) ) {
                        alt113=1;
                    }
                    else if ( (LA113_0==65||(LA113_0>=105 && LA113_0<=114)||(LA113_0>=125 && LA113_0<=126)) ) {
                        alt113=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 113, 0, input);

                        throw nvae;
                    }
                    switch (alt113) {
                        case 1 :
                            // InternalCoreDsl.g:5766:5: ( (lv_left_9_0= rulePostfixExpression ) )
                            {
                            // InternalCoreDsl.g:5766:5: ( (lv_left_9_0= rulePostfixExpression ) )
                            // InternalCoreDsl.g:5767:6: (lv_left_9_0= rulePostfixExpression )
                            {
                            // InternalCoreDsl.g:5767:6: (lv_left_9_0= rulePostfixExpression )
                            // InternalCoreDsl.g:5768:7: lv_left_9_0= rulePostfixExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPrefixExpressionAccess().getLeftPostfixExpressionParserRuleCall_4_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_43);
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
                            // InternalCoreDsl.g:5786:5: ( (lv_type_10_0= ruleDataTypeSpecifier ) )
                            {
                            // InternalCoreDsl.g:5786:5: ( (lv_type_10_0= ruleDataTypeSpecifier ) )
                            // InternalCoreDsl.g:5787:6: (lv_type_10_0= ruleDataTypeSpecifier )
                            {
                            // InternalCoreDsl.g:5787:6: (lv_type_10_0= ruleDataTypeSpecifier )
                            // InternalCoreDsl.g:5788:7: lv_type_10_0= ruleDataTypeSpecifier
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPrefixExpressionAccess().getTypeDataTypeSpecifierParserRuleCall_4_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_43);
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
    // InternalCoreDsl.g:5816:1: ruleUnaryOperator[EObject in_current] returns [EObject current=in_current] : ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) ) ;
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
            // InternalCoreDsl.g:5822:2: ( ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) ) )
            // InternalCoreDsl.g:5823:2: ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) )
            {
            // InternalCoreDsl.g:5823:2: ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) )
            // InternalCoreDsl.g:5824:3: ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) )
            {
            // InternalCoreDsl.g:5824:3: ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) )
            // InternalCoreDsl.g:5825:4: (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' )
            {
            // InternalCoreDsl.g:5825:4: (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' )
            int alt115=6;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt115=1;
                }
                break;
            case 60:
                {
                alt115=2;
                }
                break;
            case 88:
                {
                alt115=3;
                }
                break;
            case 89:
                {
                alt115=4;
                }
                break;
            case 95:
                {
                alt115=5;
                }
                break;
            case 96:
                {
                alt115=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }

            switch (alt115) {
                case 1 :
                    // InternalCoreDsl.g:5826:5: lv_op_0_1= '&'
                    {
                    lv_op_0_1=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5837:5: lv_op_0_2= '*'
                    {
                    lv_op_0_2=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5848:5: lv_op_0_3= '+'
                    {
                    lv_op_0_3=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5859:5: lv_op_0_4= '-'
                    {
                    lv_op_0_4=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5870:5: lv_op_0_5= '~'
                    {
                    lv_op_0_5=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5881:5: lv_op_0_6= '!'
                    {
                    lv_op_0_6=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:5897:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalCoreDsl.g:5897:58: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalCoreDsl.g:5898:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalCoreDsl.g:5904:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject lv_ops_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5910:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* ) )
            // InternalCoreDsl.g:5911:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* )
            {
            // InternalCoreDsl.g:5911:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* )
            // InternalCoreDsl.g:5912:3: this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_93);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5920:3: ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==RULE_LEFT_BR||LA116_0==46||LA116_0==66||(LA116_0>=92 && LA116_0<=93)||LA116_0==97) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // InternalCoreDsl.g:5921:4: () ( (lv_ops_2_0= rulePostfixOperator ) )
            	    {
            	    // InternalCoreDsl.g:5921:4: ()
            	    // InternalCoreDsl.g:5922:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getPostfixExpressionAccess().getPostfixExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:5928:4: ( (lv_ops_2_0= rulePostfixOperator ) )
            	    // InternalCoreDsl.g:5929:5: (lv_ops_2_0= rulePostfixOperator )
            	    {
            	    // InternalCoreDsl.g:5929:5: (lv_ops_2_0= rulePostfixOperator )
            	    // InternalCoreDsl.g:5930:6: lv_ops_2_0= rulePostfixOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPostfixExpressionAccess().getOpsPostfixOperatorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_93);
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
            	    break loop116;
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
    // InternalCoreDsl.g:5952:1: entryRulePostfixOperator returns [EObject current=null] : iv_rulePostfixOperator= rulePostfixOperator EOF ;
    public final EObject entryRulePostfixOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOperator = null;


        try {
            // InternalCoreDsl.g:5952:56: (iv_rulePostfixOperator= rulePostfixOperator EOF )
            // InternalCoreDsl.g:5953:2: iv_rulePostfixOperator= rulePostfixOperator EOF
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
    // InternalCoreDsl.g:5959:1: rulePostfixOperator returns [EObject current=null] : ( ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) ) ;
    public final EObject rulePostfixOperator() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;
        Token otherlv_2=null;
        Token this_RIGHT_BR_4=null;
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
            // InternalCoreDsl.g:5965:2: ( ( ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) ) )
            // InternalCoreDsl.g:5966:2: ( ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) )
            {
            // InternalCoreDsl.g:5966:2: ( ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) )
            int alt120=6;
            switch ( input.LA(1) ) {
            case RULE_LEFT_BR:
                {
                alt120=1;
                }
                break;
            case 46:
                {
                alt120=2;
                }
                break;
            case 66:
                {
                alt120=3;
                }
                break;
            case 97:
                {
                alt120=4;
                }
                break;
            case 92:
                {
                alt120=5;
                }
                break;
            case 93:
                {
                alt120=6;
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
                    // InternalCoreDsl.g:5967:3: ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR )
                    {
                    // InternalCoreDsl.g:5967:3: ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR )
                    // InternalCoreDsl.g:5968:4: ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR
                    {
                    // InternalCoreDsl.g:5968:4: ( (lv_op_0_0= RULE_LEFT_BR ) )
                    // InternalCoreDsl.g:5969:5: (lv_op_0_0= RULE_LEFT_BR )
                    {
                    // InternalCoreDsl.g:5969:5: (lv_op_0_0= RULE_LEFT_BR )
                    // InternalCoreDsl.g:5970:6: lv_op_0_0= RULE_LEFT_BR
                    {
                    lv_op_0_0=(Token)match(input,RULE_LEFT_BR,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_0_0, grammarAccess.getPostfixOperatorAccess().getOpLEFT_BRTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPostfixOperatorRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"op",
                      							lv_op_0_0,
                      							"com.minres.coredsl.CoreDsl.LEFT_BR");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5986:4: ( (lv_args_1_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:5987:5: (lv_args_1_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:5987:5: (lv_args_1_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:5988:6: lv_args_1_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_94);
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

                    // InternalCoreDsl.g:6005:4: (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )?
                    int alt117=2;
                    int LA117_0 = input.LA(1);

                    if ( (LA117_0==38) ) {
                        alt117=1;
                    }
                    switch (alt117) {
                        case 1 :
                            // InternalCoreDsl.g:6006:5: otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) )
                            {
                            otherlv_2=(Token)match(input,38,FOLLOW_47); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getPostfixOperatorAccess().getColonKeyword_0_2_0());
                              				
                            }
                            // InternalCoreDsl.g:6010:5: ( (lv_args_3_0= ruleConditionalExpression ) )
                            // InternalCoreDsl.g:6011:6: (lv_args_3_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:6011:6: (lv_args_3_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:6012:7: lv_args_3_0= ruleConditionalExpression
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

                    this_RIGHT_BR_4=(Token)match(input,RULE_RIGHT_BR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_RIGHT_BR_4, grammarAccess.getPostfixOperatorAccess().getRIGHT_BRTerminalRuleCall_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6036:3: ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' )
                    {
                    // InternalCoreDsl.g:6036:3: ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' )
                    // InternalCoreDsl.g:6037:4: ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')'
                    {
                    // InternalCoreDsl.g:6037:4: ( (lv_op_5_0= '(' ) )
                    // InternalCoreDsl.g:6038:5: (lv_op_5_0= '(' )
                    {
                    // InternalCoreDsl.g:6038:5: (lv_op_5_0= '(' )
                    // InternalCoreDsl.g:6039:6: lv_op_5_0= '('
                    {
                    lv_op_5_0=(Token)match(input,46,FOLLOW_95); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6051:4: ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )?
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( ((LA119_0>=RULE_STRING && LA119_0<=RULE_ID)||(LA119_0>=RULE_INTEGER && LA119_0<=RULE_CHARCONST)||LA119_0==46||LA119_0==60||LA119_0==81||(LA119_0>=88 && LA119_0<=89)||(LA119_0>=92 && LA119_0<=96)||(LA119_0>=98 && LA119_0<=101)) ) {
                        alt119=1;
                    }
                    switch (alt119) {
                        case 1 :
                            // InternalCoreDsl.g:6052:5: ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )*
                            {
                            // InternalCoreDsl.g:6052:5: ( (lv_args_6_0= ruleConditionalExpression ) )
                            // InternalCoreDsl.g:6053:6: (lv_args_6_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:6053:6: (lv_args_6_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:6054:7: lv_args_6_0= ruleConditionalExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_1_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_96);
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

                            // InternalCoreDsl.g:6071:5: (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )*
                            loop118:
                            do {
                                int alt118=2;
                                int LA118_0 = input.LA(1);

                                if ( (LA118_0==36) ) {
                                    alt118=1;
                                }


                                switch (alt118) {
                            	case 1 :
                            	    // InternalCoreDsl.g:6072:6: otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) )
                            	    {
                            	    otherlv_7=(Token)match(input,36,FOLLOW_47); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_7, grammarAccess.getPostfixOperatorAccess().getCommaKeyword_1_1_1_0());
                            	      					
                            	    }
                            	    // InternalCoreDsl.g:6076:6: ( (lv_args_8_0= ruleConditionalExpression ) )
                            	    // InternalCoreDsl.g:6077:7: (lv_args_8_0= ruleConditionalExpression )
                            	    {
                            	    // InternalCoreDsl.g:6077:7: (lv_args_8_0= ruleConditionalExpression )
                            	    // InternalCoreDsl.g:6078:8: lv_args_8_0= ruleConditionalExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_1_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_96);
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
                            	    break loop118;
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
                    // InternalCoreDsl.g:6103:3: ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:6103:3: ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) )
                    // InternalCoreDsl.g:6104:4: ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:6104:4: ( (lv_op_10_0= '.' ) )
                    // InternalCoreDsl.g:6105:5: (lv_op_10_0= '.' )
                    {
                    // InternalCoreDsl.g:6105:5: (lv_op_10_0= '.' )
                    // InternalCoreDsl.g:6106:6: lv_op_10_0= '.'
                    {
                    lv_op_10_0=(Token)match(input,66,FOLLOW_6); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6118:4: ( (otherlv_11= RULE_ID ) )
                    // InternalCoreDsl.g:6119:5: (otherlv_11= RULE_ID )
                    {
                    // InternalCoreDsl.g:6119:5: (otherlv_11= RULE_ID )
                    // InternalCoreDsl.g:6120:6: otherlv_11= RULE_ID
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
                    // InternalCoreDsl.g:6133:3: ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:6133:3: ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) )
                    // InternalCoreDsl.g:6134:4: ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:6134:4: ( (lv_op_12_0= '->' ) )
                    // InternalCoreDsl.g:6135:5: (lv_op_12_0= '->' )
                    {
                    // InternalCoreDsl.g:6135:5: (lv_op_12_0= '->' )
                    // InternalCoreDsl.g:6136:6: lv_op_12_0= '->'
                    {
                    lv_op_12_0=(Token)match(input,97,FOLLOW_6); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6148:4: ( (otherlv_13= RULE_ID ) )
                    // InternalCoreDsl.g:6149:5: (otherlv_13= RULE_ID )
                    {
                    // InternalCoreDsl.g:6149:5: (otherlv_13= RULE_ID )
                    // InternalCoreDsl.g:6150:6: otherlv_13= RULE_ID
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
                    // InternalCoreDsl.g:6163:3: ( (lv_op_14_0= '++' ) )
                    {
                    // InternalCoreDsl.g:6163:3: ( (lv_op_14_0= '++' ) )
                    // InternalCoreDsl.g:6164:4: (lv_op_14_0= '++' )
                    {
                    // InternalCoreDsl.g:6164:4: (lv_op_14_0= '++' )
                    // InternalCoreDsl.g:6165:5: lv_op_14_0= '++'
                    {
                    lv_op_14_0=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6178:3: ( (lv_op_15_0= '--' ) )
                    {
                    // InternalCoreDsl.g:6178:3: ( (lv_op_15_0= '--' ) )
                    // InternalCoreDsl.g:6179:4: (lv_op_15_0= '--' )
                    {
                    // InternalCoreDsl.g:6179:4: (lv_op_15_0= '--' )
                    // InternalCoreDsl.g:6180:5: lv_op_15_0= '--'
                    {
                    lv_op_15_0=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6196:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalCoreDsl.g:6196:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalCoreDsl.g:6197:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalCoreDsl.g:6203:1: rulePrimaryExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) ) ;
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
            // InternalCoreDsl.g:6209:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) ) )
            // InternalCoreDsl.g:6210:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) )
            {
            // InternalCoreDsl.g:6210:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) )
            int alt122=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt122=1;
                }
                break;
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
                {
                alt122=2;
                }
                break;
            case 101:
                {
                int LA122_3 = input.LA(2);

                if ( (LA122_3==RULE_CHARCONST) ) {
                    alt122=2;
                }
                else if ( (LA122_3==RULE_STRING) ) {
                    alt122=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 122, 3, input);

                    throw nvae;
                }
                }
                break;
            case 99:
                {
                int LA122_4 = input.LA(2);

                if ( (LA122_4==RULE_STRING) ) {
                    alt122=3;
                }
                else if ( (LA122_4==RULE_CHARCONST) ) {
                    alt122=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 122, 4, input);

                    throw nvae;
                }
                }
                break;
            case 100:
                {
                int LA122_5 = input.LA(2);

                if ( (LA122_5==RULE_STRING) ) {
                    alt122=3;
                }
                else if ( (LA122_5==RULE_CHARCONST) ) {
                    alt122=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 122, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case 98:
                {
                alt122=3;
                }
                break;
            case 46:
                {
                alt122=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }

            switch (alt122) {
                case 1 :
                    // InternalCoreDsl.g:6211:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:6211:3: ( (otherlv_0= RULE_ID ) )
                    // InternalCoreDsl.g:6212:4: (otherlv_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:6212:4: (otherlv_0= RULE_ID )
                    // InternalCoreDsl.g:6213:5: otherlv_0= RULE_ID
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
                    // InternalCoreDsl.g:6225:3: ( (lv_constant_1_0= ruleConstant ) )
                    {
                    // InternalCoreDsl.g:6225:3: ( (lv_constant_1_0= ruleConstant ) )
                    // InternalCoreDsl.g:6226:4: (lv_constant_1_0= ruleConstant )
                    {
                    // InternalCoreDsl.g:6226:4: (lv_constant_1_0= ruleConstant )
                    // InternalCoreDsl.g:6227:5: lv_constant_1_0= ruleConstant
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
                    // InternalCoreDsl.g:6245:3: ( (lv_literal_2_0= ruleStringLiteral ) )+
                    {
                    // InternalCoreDsl.g:6245:3: ( (lv_literal_2_0= ruleStringLiteral ) )+
                    int cnt121=0;
                    loop121:
                    do {
                        int alt121=2;
                        int LA121_0 = input.LA(1);

                        if ( (LA121_0==RULE_STRING||(LA121_0>=98 && LA121_0<=101)) ) {
                            alt121=1;
                        }


                        switch (alt121) {
                    	case 1 :
                    	    // InternalCoreDsl.g:6246:4: (lv_literal_2_0= ruleStringLiteral )
                    	    {
                    	    // InternalCoreDsl.g:6246:4: (lv_literal_2_0= ruleStringLiteral )
                    	    // InternalCoreDsl.g:6247:5: lv_literal_2_0= ruleStringLiteral
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralStringLiteralParserRuleCall_2_0());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_97);
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
                    	    if ( cnt121 >= 1 ) break loop121;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(121, input);
                                throw eee;
                        }
                        cnt121++;
                    } while (true);


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6265:3: (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' )
                    {
                    // InternalCoreDsl.g:6265:3: (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' )
                    // InternalCoreDsl.g:6266:4: otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,46,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalCoreDsl.g:6270:4: ( (lv_left_4_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:6271:5: (lv_left_4_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:6271:5: (lv_left_4_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:6272:6: lv_left_4_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLeftConditionalExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
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
    // InternalCoreDsl.g:6298:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalCoreDsl.g:6298:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalCoreDsl.g:6299:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalCoreDsl.g:6305:1: ruleStringLiteral returns [EObject current=null] : ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;
        EObject this_EncodingPrefix_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6311:2: ( ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) ) )
            // InternalCoreDsl.g:6312:2: ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) )
            {
            // InternalCoreDsl.g:6312:2: ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) ) )
            // InternalCoreDsl.g:6313:3: (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_val_1_0= RULE_STRING ) )
            {
            // InternalCoreDsl.g:6313:3: (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( ((LA123_0>=98 && LA123_0<=101)) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalCoreDsl.g:6314:4: this_EncodingPrefix_0= ruleEncodingPrefix[$current]
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

            // InternalCoreDsl.g:6326:3: ( (lv_val_1_0= RULE_STRING ) )
            // InternalCoreDsl.g:6327:4: (lv_val_1_0= RULE_STRING )
            {
            // InternalCoreDsl.g:6327:4: (lv_val_1_0= RULE_STRING )
            // InternalCoreDsl.g:6328:5: lv_val_1_0= RULE_STRING
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
    // InternalCoreDsl.g:6349:1: ruleEncodingPrefix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) ) ;
    public final EObject ruleEncodingPrefix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_prefix_0_1=null;
        Token lv_prefix_0_2=null;
        Token lv_prefix_0_3=null;
        Token lv_prefix_0_4=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6355:2: ( ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) ) )
            // InternalCoreDsl.g:6356:2: ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) )
            {
            // InternalCoreDsl.g:6356:2: ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) )
            // InternalCoreDsl.g:6357:3: ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) )
            {
            // InternalCoreDsl.g:6357:3: ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) )
            // InternalCoreDsl.g:6358:4: (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' )
            {
            // InternalCoreDsl.g:6358:4: (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' )
            int alt124=4;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt124=1;
                }
                break;
            case 99:
                {
                alt124=2;
                }
                break;
            case 100:
                {
                alt124=3;
                }
                break;
            case 101:
                {
                alt124=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }

            switch (alt124) {
                case 1 :
                    // InternalCoreDsl.g:6359:5: lv_prefix_0_1= 'u8'
                    {
                    lv_prefix_0_1=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6370:5: lv_prefix_0_2= 'u'
                    {
                    lv_prefix_0_2=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6381:5: lv_prefix_0_3= 'U'
                    {
                    lv_prefix_0_3=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:6392:5: lv_prefix_0_4= 'L'
                    {
                    lv_prefix_0_4=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6408:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalCoreDsl.g:6408:59: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalCoreDsl.g:6409:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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
    // InternalCoreDsl.g:6415:1: ruleConstantExpression returns [EObject current=null] : this_ConditionalExpression_0= ruleConditionalExpression ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6421:2: (this_ConditionalExpression_0= ruleConditionalExpression )
            // InternalCoreDsl.g:6422:2: this_ConditionalExpression_0= ruleConditionalExpression
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
    // InternalCoreDsl.g:6433:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalCoreDsl.g:6433:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalCoreDsl.g:6434:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalCoreDsl.g:6440:1: ruleConstant returns [EObject current=null] : (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerConstant_0 = null;

        EObject this_FloatingConstant_1 = null;

        EObject this_CharacterConstant_2 = null;

        EObject this_BoolConstant_3 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6446:2: ( (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant ) )
            // InternalCoreDsl.g:6447:2: (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant )
            {
            // InternalCoreDsl.g:6447:2: (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant )
            int alt125=4;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
                {
                alt125=1;
                }
                break;
            case RULE_FLOAT:
                {
                alt125=2;
                }
                break;
            case RULE_CHARCONST:
            case 99:
            case 100:
            case 101:
                {
                alt125=3;
                }
                break;
            case RULE_BOOLEAN:
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
                    // InternalCoreDsl.g:6448:3: this_IntegerConstant_0= ruleIntegerConstant
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
                    // InternalCoreDsl.g:6457:3: this_FloatingConstant_1= ruleFloatingConstant
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
                    // InternalCoreDsl.g:6466:3: this_CharacterConstant_2= ruleCharacterConstant
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
                    // InternalCoreDsl.g:6475:3: this_BoolConstant_3= ruleBoolConstant
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
    // InternalCoreDsl.g:6487:1: entryRuleIntegerConstant returns [EObject current=null] : iv_ruleIntegerConstant= ruleIntegerConstant EOF ;
    public final EObject entryRuleIntegerConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerConstant = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalCoreDsl.g:6489:2: (iv_ruleIntegerConstant= ruleIntegerConstant EOF )
            // InternalCoreDsl.g:6490:2: iv_ruleIntegerConstant= ruleIntegerConstant EOF
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerConstant"


    // $ANTLR start "ruleIntegerConstant"
    // InternalCoreDsl.g:6499:1: ruleIntegerConstant returns [EObject current=null] : ( ( (lv_val_0_0= RULE_INTEGER ) ) ( ( (lv_unsigned_1_1= 'u' | lv_unsigned_1_2= 'U' ) ) )? ( ( ( (lv_long_2_1= 'l' | lv_long_2_2= 'L' ) ) ) ( ( (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' ) ) )? )? ) ;
    public final EObject ruleIntegerConstant() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        Token lv_unsigned_1_1=null;
        Token lv_unsigned_1_2=null;
        Token lv_long_2_1=null;
        Token lv_long_2_2=null;
        Token lv_longlong_3_1=null;
        Token lv_longlong_3_2=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalCoreDsl.g:6506:2: ( ( ( (lv_val_0_0= RULE_INTEGER ) ) ( ( (lv_unsigned_1_1= 'u' | lv_unsigned_1_2= 'U' ) ) )? ( ( ( (lv_long_2_1= 'l' | lv_long_2_2= 'L' ) ) ) ( ( (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' ) ) )? )? ) )
            // InternalCoreDsl.g:6507:2: ( ( (lv_val_0_0= RULE_INTEGER ) ) ( ( (lv_unsigned_1_1= 'u' | lv_unsigned_1_2= 'U' ) ) )? ( ( ( (lv_long_2_1= 'l' | lv_long_2_2= 'L' ) ) ) ( ( (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' ) ) )? )? )
            {
            // InternalCoreDsl.g:6507:2: ( ( (lv_val_0_0= RULE_INTEGER ) ) ( ( (lv_unsigned_1_1= 'u' | lv_unsigned_1_2= 'U' ) ) )? ( ( ( (lv_long_2_1= 'l' | lv_long_2_2= 'L' ) ) ) ( ( (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' ) ) )? )? )
            // InternalCoreDsl.g:6508:3: ( (lv_val_0_0= RULE_INTEGER ) ) ( ( (lv_unsigned_1_1= 'u' | lv_unsigned_1_2= 'U' ) ) )? ( ( ( (lv_long_2_1= 'l' | lv_long_2_2= 'L' ) ) ) ( ( (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' ) ) )? )?
            {
            // InternalCoreDsl.g:6508:3: ( (lv_val_0_0= RULE_INTEGER ) )
            // InternalCoreDsl.g:6509:4: (lv_val_0_0= RULE_INTEGER )
            {
            // InternalCoreDsl.g:6509:4: (lv_val_0_0= RULE_INTEGER )
            // InternalCoreDsl.g:6510:5: lv_val_0_0= RULE_INTEGER
            {
            lv_val_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_98); if (state.failed) return current;
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

            // InternalCoreDsl.g:6526:3: ( ( (lv_unsigned_1_1= 'u' | lv_unsigned_1_2= 'U' ) ) )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( ((LA127_0>=99 && LA127_0<=100)) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalCoreDsl.g:6527:4: ( (lv_unsigned_1_1= 'u' | lv_unsigned_1_2= 'U' ) )
                    {
                    // InternalCoreDsl.g:6527:4: ( (lv_unsigned_1_1= 'u' | lv_unsigned_1_2= 'U' ) )
                    // InternalCoreDsl.g:6528:5: (lv_unsigned_1_1= 'u' | lv_unsigned_1_2= 'U' )
                    {
                    // InternalCoreDsl.g:6528:5: (lv_unsigned_1_1= 'u' | lv_unsigned_1_2= 'U' )
                    int alt126=2;
                    int LA126_0 = input.LA(1);

                    if ( (LA126_0==99) ) {
                        alt126=1;
                    }
                    else if ( (LA126_0==100) ) {
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
                            // InternalCoreDsl.g:6529:6: lv_unsigned_1_1= 'u'
                            {
                            lv_unsigned_1_1=(Token)match(input,99,FOLLOW_99); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_unsigned_1_1, grammarAccess.getIntegerConstantAccess().getUnsignedUKeyword_1_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getIntegerConstantRule());
                              						}
                              						setWithLastConsumed(current, "unsigned", lv_unsigned_1_1 != null, null);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:6540:6: lv_unsigned_1_2= 'U'
                            {
                            lv_unsigned_1_2=(Token)match(input,100,FOLLOW_99); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_unsigned_1_2, grammarAccess.getIntegerConstantAccess().getUnsignedUKeyword_1_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getIntegerConstantRule());
                              						}
                              						setWithLastConsumed(current, "unsigned", lv_unsigned_1_2 != null, null);
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:6553:3: ( ( ( (lv_long_2_1= 'l' | lv_long_2_2= 'L' ) ) ) ( ( (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' ) ) )? )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( ((LA131_0>=101 && LA131_0<=102)) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // InternalCoreDsl.g:6554:4: ( ( (lv_long_2_1= 'l' | lv_long_2_2= 'L' ) ) ) ( ( (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' ) ) )?
                    {
                    // InternalCoreDsl.g:6554:4: ( ( (lv_long_2_1= 'l' | lv_long_2_2= 'L' ) ) )
                    // InternalCoreDsl.g:6555:5: ( (lv_long_2_1= 'l' | lv_long_2_2= 'L' ) )
                    {
                    // InternalCoreDsl.g:6555:5: ( (lv_long_2_1= 'l' | lv_long_2_2= 'L' ) )
                    // InternalCoreDsl.g:6556:6: (lv_long_2_1= 'l' | lv_long_2_2= 'L' )
                    {
                    // InternalCoreDsl.g:6556:6: (lv_long_2_1= 'l' | lv_long_2_2= 'L' )
                    int alt128=2;
                    int LA128_0 = input.LA(1);

                    if ( (LA128_0==102) ) {
                        alt128=1;
                    }
                    else if ( (LA128_0==101) ) {
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
                            // InternalCoreDsl.g:6557:7: lv_long_2_1= 'l'
                            {
                            lv_long_2_1=(Token)match(input,102,FOLLOW_99); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_long_2_1, grammarAccess.getIntegerConstantAccess().getLongLKeyword_2_0_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getIntegerConstantRule());
                              							}
                              							setWithLastConsumed(current, "long", lv_long_2_1 != null, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:6568:7: lv_long_2_2= 'L'
                            {
                            lv_long_2_2=(Token)match(input,101,FOLLOW_99); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_long_2_2, grammarAccess.getIntegerConstantAccess().getLongLKeyword_2_0_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getIntegerConstantRule());
                              							}
                              							setWithLastConsumed(current, "long", lv_long_2_2 != null, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalCoreDsl.g:6581:4: ( ( (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' ) ) )?
                    int alt130=2;
                    int LA130_0 = input.LA(1);

                    if ( ((LA130_0>=101 && LA130_0<=102)) ) {
                        alt130=1;
                    }
                    switch (alt130) {
                        case 1 :
                            // InternalCoreDsl.g:6582:5: ( (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' ) )
                            {
                            // InternalCoreDsl.g:6582:5: ( (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' ) )
                            // InternalCoreDsl.g:6583:6: (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' )
                            {
                            // InternalCoreDsl.g:6583:6: (lv_longlong_3_1= 'l' | lv_longlong_3_2= 'L' )
                            int alt129=2;
                            int LA129_0 = input.LA(1);

                            if ( (LA129_0==102) ) {
                                alt129=1;
                            }
                            else if ( (LA129_0==101) ) {
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
                                    // InternalCoreDsl.g:6584:7: lv_longlong_3_1= 'l'
                                    {
                                    lv_longlong_3_1=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(lv_longlong_3_1, grammarAccess.getIntegerConstantAccess().getLonglongLKeyword_2_1_0_0());
                                      						
                                    }
                                    if ( state.backtracking==0 ) {

                                      							if (current==null) {
                                      								current = createModelElement(grammarAccess.getIntegerConstantRule());
                                      							}
                                      							setWithLastConsumed(current, "longlong", lv_longlong_3_1 != null, null);
                                      						
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalCoreDsl.g:6595:7: lv_longlong_3_2= 'L'
                                    {
                                    lv_longlong_3_2=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(lv_longlong_3_2, grammarAccess.getIntegerConstantAccess().getLonglongLKeyword_2_1_0_1());
                                      						
                                    }
                                    if ( state.backtracking==0 ) {

                                      							if (current==null) {
                                      								current = createModelElement(grammarAccess.getIntegerConstantRule());
                                      							}
                                      							setWithLastConsumed(current, "longlong", lv_longlong_3_2 != null, null);
                                      						
                                    }

                                    }
                                    break;

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleIntegerConstant"


    // $ANTLR start "entryRuleFloatingConstant"
    // InternalCoreDsl.g:6616:1: entryRuleFloatingConstant returns [EObject current=null] : iv_ruleFloatingConstant= ruleFloatingConstant EOF ;
    public final EObject entryRuleFloatingConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatingConstant = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalCoreDsl.g:6618:2: (iv_ruleFloatingConstant= ruleFloatingConstant EOF )
            // InternalCoreDsl.g:6619:2: iv_ruleFloatingConstant= ruleFloatingConstant EOF
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleFloatingConstant"


    // $ANTLR start "ruleFloatingConstant"
    // InternalCoreDsl.g:6628:1: ruleFloatingConstant returns [EObject current=null] : ( ( (lv_val_0_0= RULE_FLOAT ) ) ( ( ( (lv_f_1_1= 'f' | lv_f_1_2= 'F' ) ) ) | ( ( (lv_l_2_1= 'l' | lv_l_2_2= 'L' ) ) ) )? ) ;
    public final EObject ruleFloatingConstant() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        Token lv_f_1_1=null;
        Token lv_f_1_2=null;
        Token lv_l_2_1=null;
        Token lv_l_2_2=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalCoreDsl.g:6635:2: ( ( ( (lv_val_0_0= RULE_FLOAT ) ) ( ( ( (lv_f_1_1= 'f' | lv_f_1_2= 'F' ) ) ) | ( ( (lv_l_2_1= 'l' | lv_l_2_2= 'L' ) ) ) )? ) )
            // InternalCoreDsl.g:6636:2: ( ( (lv_val_0_0= RULE_FLOAT ) ) ( ( ( (lv_f_1_1= 'f' | lv_f_1_2= 'F' ) ) ) | ( ( (lv_l_2_1= 'l' | lv_l_2_2= 'L' ) ) ) )? )
            {
            // InternalCoreDsl.g:6636:2: ( ( (lv_val_0_0= RULE_FLOAT ) ) ( ( ( (lv_f_1_1= 'f' | lv_f_1_2= 'F' ) ) ) | ( ( (lv_l_2_1= 'l' | lv_l_2_2= 'L' ) ) ) )? )
            // InternalCoreDsl.g:6637:3: ( (lv_val_0_0= RULE_FLOAT ) ) ( ( ( (lv_f_1_1= 'f' | lv_f_1_2= 'F' ) ) ) | ( ( (lv_l_2_1= 'l' | lv_l_2_2= 'L' ) ) ) )?
            {
            // InternalCoreDsl.g:6637:3: ( (lv_val_0_0= RULE_FLOAT ) )
            // InternalCoreDsl.g:6638:4: (lv_val_0_0= RULE_FLOAT )
            {
            // InternalCoreDsl.g:6638:4: (lv_val_0_0= RULE_FLOAT )
            // InternalCoreDsl.g:6639:5: lv_val_0_0= RULE_FLOAT
            {
            lv_val_0_0=(Token)match(input,RULE_FLOAT,FOLLOW_100); if (state.failed) return current;
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

            // InternalCoreDsl.g:6655:3: ( ( ( (lv_f_1_1= 'f' | lv_f_1_2= 'F' ) ) ) | ( ( (lv_l_2_1= 'l' | lv_l_2_2= 'L' ) ) ) )?
            int alt134=3;
            int LA134_0 = input.LA(1);

            if ( ((LA134_0>=103 && LA134_0<=104)) ) {
                alt134=1;
            }
            else if ( ((LA134_0>=101 && LA134_0<=102)) ) {
                alt134=2;
            }
            switch (alt134) {
                case 1 :
                    // InternalCoreDsl.g:6656:4: ( ( (lv_f_1_1= 'f' | lv_f_1_2= 'F' ) ) )
                    {
                    // InternalCoreDsl.g:6656:4: ( ( (lv_f_1_1= 'f' | lv_f_1_2= 'F' ) ) )
                    // InternalCoreDsl.g:6657:5: ( (lv_f_1_1= 'f' | lv_f_1_2= 'F' ) )
                    {
                    // InternalCoreDsl.g:6657:5: ( (lv_f_1_1= 'f' | lv_f_1_2= 'F' ) )
                    // InternalCoreDsl.g:6658:6: (lv_f_1_1= 'f' | lv_f_1_2= 'F' )
                    {
                    // InternalCoreDsl.g:6658:6: (lv_f_1_1= 'f' | lv_f_1_2= 'F' )
                    int alt132=2;
                    int LA132_0 = input.LA(1);

                    if ( (LA132_0==103) ) {
                        alt132=1;
                    }
                    else if ( (LA132_0==104) ) {
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
                            // InternalCoreDsl.g:6659:7: lv_f_1_1= 'f'
                            {
                            lv_f_1_1=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_f_1_1, grammarAccess.getFloatingConstantAccess().getFFKeyword_1_0_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getFloatingConstantRule());
                              							}
                              							setWithLastConsumed(current, "f", lv_f_1_1 != null, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:6670:7: lv_f_1_2= 'F'
                            {
                            lv_f_1_2=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_f_1_2, grammarAccess.getFloatingConstantAccess().getFFKeyword_1_0_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getFloatingConstantRule());
                              							}
                              							setWithLastConsumed(current, "f", lv_f_1_2 != null, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6684:4: ( ( (lv_l_2_1= 'l' | lv_l_2_2= 'L' ) ) )
                    {
                    // InternalCoreDsl.g:6684:4: ( ( (lv_l_2_1= 'l' | lv_l_2_2= 'L' ) ) )
                    // InternalCoreDsl.g:6685:5: ( (lv_l_2_1= 'l' | lv_l_2_2= 'L' ) )
                    {
                    // InternalCoreDsl.g:6685:5: ( (lv_l_2_1= 'l' | lv_l_2_2= 'L' ) )
                    // InternalCoreDsl.g:6686:6: (lv_l_2_1= 'l' | lv_l_2_2= 'L' )
                    {
                    // InternalCoreDsl.g:6686:6: (lv_l_2_1= 'l' | lv_l_2_2= 'L' )
                    int alt133=2;
                    int LA133_0 = input.LA(1);

                    if ( (LA133_0==102) ) {
                        alt133=1;
                    }
                    else if ( (LA133_0==101) ) {
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
                            // InternalCoreDsl.g:6687:7: lv_l_2_1= 'l'
                            {
                            lv_l_2_1=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_l_2_1, grammarAccess.getFloatingConstantAccess().getLLKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getFloatingConstantRule());
                              							}
                              							setWithLastConsumed(current, "l", lv_l_2_1 != null, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:6698:7: lv_l_2_2= 'L'
                            {
                            lv_l_2_2=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_l_2_2, grammarAccess.getFloatingConstantAccess().getLLKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getFloatingConstantRule());
                              							}
                              							setWithLastConsumed(current, "l", lv_l_2_2 != null, null);
                              						
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleFloatingConstant"


    // $ANTLR start "entryRuleBoolConstant"
    // InternalCoreDsl.g:6719:1: entryRuleBoolConstant returns [EObject current=null] : iv_ruleBoolConstant= ruleBoolConstant EOF ;
    public final EObject entryRuleBoolConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolConstant = null;


        try {
            // InternalCoreDsl.g:6719:53: (iv_ruleBoolConstant= ruleBoolConstant EOF )
            // InternalCoreDsl.g:6720:2: iv_ruleBoolConstant= ruleBoolConstant EOF
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
    // InternalCoreDsl.g:6726:1: ruleBoolConstant returns [EObject current=null] : ( (lv_val_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBoolConstant() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6732:2: ( ( (lv_val_0_0= RULE_BOOLEAN ) ) )
            // InternalCoreDsl.g:6733:2: ( (lv_val_0_0= RULE_BOOLEAN ) )
            {
            // InternalCoreDsl.g:6733:2: ( (lv_val_0_0= RULE_BOOLEAN ) )
            // InternalCoreDsl.g:6734:3: (lv_val_0_0= RULE_BOOLEAN )
            {
            // InternalCoreDsl.g:6734:3: (lv_val_0_0= RULE_BOOLEAN )
            // InternalCoreDsl.g:6735:4: lv_val_0_0= RULE_BOOLEAN
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


    // $ANTLR start "entryRuleCharacterConstant"
    // InternalCoreDsl.g:6754:1: entryRuleCharacterConstant returns [EObject current=null] : iv_ruleCharacterConstant= ruleCharacterConstant EOF ;
    public final EObject entryRuleCharacterConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterConstant = null;


        try {
            // InternalCoreDsl.g:6754:58: (iv_ruleCharacterConstant= ruleCharacterConstant EOF )
            // InternalCoreDsl.g:6755:2: iv_ruleCharacterConstant= ruleCharacterConstant EOF
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
    // InternalCoreDsl.g:6761:1: ruleCharacterConstant returns [EObject current=null] : ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) ) ;
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
            // InternalCoreDsl.g:6767:2: ( ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) ) )
            // InternalCoreDsl.g:6768:2: ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) )
            {
            // InternalCoreDsl.g:6768:2: ( ( (lv_val_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) ) )
            int alt135=4;
            switch ( input.LA(1) ) {
            case RULE_CHARCONST:
                {
                alt135=1;
                }
                break;
            case 101:
                {
                alt135=2;
                }
                break;
            case 99:
                {
                alt135=3;
                }
                break;
            case 100:
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
                    // InternalCoreDsl.g:6769:3: ( (lv_val_0_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6769:3: ( (lv_val_0_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6770:4: (lv_val_0_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6770:4: (lv_val_0_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6771:5: lv_val_0_0= RULE_CHARCONST
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
                    // InternalCoreDsl.g:6788:3: ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6788:3: ( ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6789:4: ( (lv_enc_1_0= 'L' ) ) ( (lv_val_2_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6789:4: ( (lv_enc_1_0= 'L' ) )
                    // InternalCoreDsl.g:6790:5: (lv_enc_1_0= 'L' )
                    {
                    // InternalCoreDsl.g:6790:5: (lv_enc_1_0= 'L' )
                    // InternalCoreDsl.g:6791:6: lv_enc_1_0= 'L'
                    {
                    lv_enc_1_0=(Token)match(input,101,FOLLOW_101); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6803:4: ( (lv_val_2_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6804:5: (lv_val_2_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6804:5: (lv_val_2_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6805:6: lv_val_2_0= RULE_CHARCONST
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
                    // InternalCoreDsl.g:6823:3: ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6823:3: ( ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6824:4: ( (lv_enc_3_0= 'u' ) ) ( (lv_val_4_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6824:4: ( (lv_enc_3_0= 'u' ) )
                    // InternalCoreDsl.g:6825:5: (lv_enc_3_0= 'u' )
                    {
                    // InternalCoreDsl.g:6825:5: (lv_enc_3_0= 'u' )
                    // InternalCoreDsl.g:6826:6: lv_enc_3_0= 'u'
                    {
                    lv_enc_3_0=(Token)match(input,99,FOLLOW_101); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6838:4: ( (lv_val_4_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6839:5: (lv_val_4_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6839:5: (lv_val_4_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6840:6: lv_val_4_0= RULE_CHARCONST
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
                    // InternalCoreDsl.g:6858:3: ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6858:3: ( ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6859:4: ( (lv_enc_5_0= 'U' ) ) ( (lv_val_6_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6859:4: ( (lv_enc_5_0= 'U' ) )
                    // InternalCoreDsl.g:6860:5: (lv_enc_5_0= 'U' )
                    {
                    // InternalCoreDsl.g:6860:5: (lv_enc_5_0= 'U' )
                    // InternalCoreDsl.g:6861:6: lv_enc_5_0= 'U'
                    {
                    lv_enc_5_0=(Token)match(input,100,FOLLOW_101); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6873:4: ( (lv_val_6_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6874:5: (lv_val_6_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6874:5: (lv_val_6_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6875:6: lv_val_6_0= RULE_CHARCONST
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


    // $ANTLR start "entryRuleDoubleLeftBracket"
    // InternalCoreDsl.g:6896:1: entryRuleDoubleLeftBracket returns [String current=null] : iv_ruleDoubleLeftBracket= ruleDoubleLeftBracket EOF ;
    public final String entryRuleDoubleLeftBracket() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDoubleLeftBracket = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalCoreDsl.g:6898:2: (iv_ruleDoubleLeftBracket= ruleDoubleLeftBracket EOF )
            // InternalCoreDsl.g:6899:2: iv_ruleDoubleLeftBracket= ruleDoubleLeftBracket EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoubleLeftBracketRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDoubleLeftBracket=ruleDoubleLeftBracket();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDoubleLeftBracket.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleLeftBracket"


    // $ANTLR start "ruleDoubleLeftBracket"
    // InternalCoreDsl.g:6908:1: ruleDoubleLeftBracket returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LEFT_BR_0= RULE_LEFT_BR this_LEFT_BR_1= RULE_LEFT_BR ) ;
    public final AntlrDatatypeRuleToken ruleDoubleLeftBracket() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LEFT_BR_0=null;
        Token this_LEFT_BR_1=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalCoreDsl.g:6915:2: ( (this_LEFT_BR_0= RULE_LEFT_BR this_LEFT_BR_1= RULE_LEFT_BR ) )
            // InternalCoreDsl.g:6916:2: (this_LEFT_BR_0= RULE_LEFT_BR this_LEFT_BR_1= RULE_LEFT_BR )
            {
            // InternalCoreDsl.g:6916:2: (this_LEFT_BR_0= RULE_LEFT_BR this_LEFT_BR_1= RULE_LEFT_BR )
            // InternalCoreDsl.g:6917:3: this_LEFT_BR_0= RULE_LEFT_BR this_LEFT_BR_1= RULE_LEFT_BR
            {
            this_LEFT_BR_0=(Token)match(input,RULE_LEFT_BR,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_LEFT_BR_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_LEFT_BR_0, grammarAccess.getDoubleLeftBracketAccess().getLEFT_BRTerminalRuleCall_0());
              		
            }
            this_LEFT_BR_1=(Token)match(input,RULE_LEFT_BR,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_LEFT_BR_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_LEFT_BR_1, grammarAccess.getDoubleLeftBracketAccess().getLEFT_BRTerminalRuleCall_1());
              		
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDoubleLeftBracket"


    // $ANTLR start "entryRuleDoubleRightBracket"
    // InternalCoreDsl.g:6938:1: entryRuleDoubleRightBracket returns [String current=null] : iv_ruleDoubleRightBracket= ruleDoubleRightBracket EOF ;
    public final String entryRuleDoubleRightBracket() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDoubleRightBracket = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalCoreDsl.g:6940:2: (iv_ruleDoubleRightBracket= ruleDoubleRightBracket EOF )
            // InternalCoreDsl.g:6941:2: iv_ruleDoubleRightBracket= ruleDoubleRightBracket EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoubleRightBracketRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDoubleRightBracket=ruleDoubleRightBracket();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDoubleRightBracket.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleRightBracket"


    // $ANTLR start "ruleDoubleRightBracket"
    // InternalCoreDsl.g:6950:1: ruleDoubleRightBracket returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_RIGHT_BR_0= RULE_RIGHT_BR this_RIGHT_BR_1= RULE_RIGHT_BR ) ;
    public final AntlrDatatypeRuleToken ruleDoubleRightBracket() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_RIGHT_BR_0=null;
        Token this_RIGHT_BR_1=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalCoreDsl.g:6957:2: ( (this_RIGHT_BR_0= RULE_RIGHT_BR this_RIGHT_BR_1= RULE_RIGHT_BR ) )
            // InternalCoreDsl.g:6958:2: (this_RIGHT_BR_0= RULE_RIGHT_BR this_RIGHT_BR_1= RULE_RIGHT_BR )
            {
            // InternalCoreDsl.g:6958:2: (this_RIGHT_BR_0= RULE_RIGHT_BR this_RIGHT_BR_1= RULE_RIGHT_BR )
            // InternalCoreDsl.g:6959:3: this_RIGHT_BR_0= RULE_RIGHT_BR this_RIGHT_BR_1= RULE_RIGHT_BR
            {
            this_RIGHT_BR_0=(Token)match(input,RULE_RIGHT_BR,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_RIGHT_BR_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_RIGHT_BR_0, grammarAccess.getDoubleRightBracketAccess().getRIGHT_BRTerminalRuleCall_0());
              		
            }
            this_RIGHT_BR_1=(Token)match(input,RULE_RIGHT_BR,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_RIGHT_BR_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_RIGHT_BR_1, grammarAccess.getDoubleRightBracketAccess().getRIGHT_BRTerminalRuleCall_1());
              		
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDoubleRightBracket"


    // $ANTLR start "ruleDataTypes"
    // InternalCoreDsl.g:6980:1: ruleDataTypes returns [Enumerator current=null] : ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'void' ) ) ;
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


        	enterRule();

        try {
            // InternalCoreDsl.g:6986:2: ( ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'void' ) ) )
            // InternalCoreDsl.g:6987:2: ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'void' ) )
            {
            // InternalCoreDsl.g:6987:2: ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'void' ) )
            int alt136=10;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt136=1;
                }
                break;
            case 106:
                {
                alt136=2;
                }
                break;
            case 107:
                {
                alt136=3;
                }
                break;
            case 108:
                {
                alt136=4;
                }
                break;
            case 109:
                {
                alt136=5;
                }
                break;
            case 110:
                {
                alt136=6;
                }
                break;
            case 111:
                {
                alt136=7;
                }
                break;
            case 112:
                {
                alt136=8;
                }
                break;
            case 113:
                {
                alt136=9;
                }
                break;
            case 114:
                {
                alt136=10;
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
                    // InternalCoreDsl.g:6988:3: (enumLiteral_0= 'bool' )
                    {
                    // InternalCoreDsl.g:6988:3: (enumLiteral_0= 'bool' )
                    // InternalCoreDsl.g:6989:4: enumLiteral_0= 'bool'
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
                    // InternalCoreDsl.g:6996:3: (enumLiteral_1= 'char' )
                    {
                    // InternalCoreDsl.g:6996:3: (enumLiteral_1= 'char' )
                    // InternalCoreDsl.g:6997:4: enumLiteral_1= 'char'
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
                    // InternalCoreDsl.g:7004:3: (enumLiteral_2= 'short' )
                    {
                    // InternalCoreDsl.g:7004:3: (enumLiteral_2= 'short' )
                    // InternalCoreDsl.g:7005:4: enumLiteral_2= 'short'
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
                    // InternalCoreDsl.g:7012:3: (enumLiteral_3= 'int' )
                    {
                    // InternalCoreDsl.g:7012:3: (enumLiteral_3= 'int' )
                    // InternalCoreDsl.g:7013:4: enumLiteral_3= 'int'
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
                    // InternalCoreDsl.g:7020:3: (enumLiteral_4= 'long' )
                    {
                    // InternalCoreDsl.g:7020:3: (enumLiteral_4= 'long' )
                    // InternalCoreDsl.g:7021:4: enumLiteral_4= 'long'
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
                    // InternalCoreDsl.g:7028:3: (enumLiteral_5= 'signed' )
                    {
                    // InternalCoreDsl.g:7028:3: (enumLiteral_5= 'signed' )
                    // InternalCoreDsl.g:7029:4: enumLiteral_5= 'signed'
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
                    // InternalCoreDsl.g:7036:3: (enumLiteral_6= 'unsigned' )
                    {
                    // InternalCoreDsl.g:7036:3: (enumLiteral_6= 'unsigned' )
                    // InternalCoreDsl.g:7037:4: enumLiteral_6= 'unsigned'
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
                    // InternalCoreDsl.g:7044:3: (enumLiteral_7= 'float' )
                    {
                    // InternalCoreDsl.g:7044:3: (enumLiteral_7= 'float' )
                    // InternalCoreDsl.g:7045:4: enumLiteral_7= 'float'
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
                    // InternalCoreDsl.g:7052:3: (enumLiteral_8= 'double' )
                    {
                    // InternalCoreDsl.g:7052:3: (enumLiteral_8= 'double' )
                    // InternalCoreDsl.g:7053:4: enumLiteral_8= 'double'
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
                    // InternalCoreDsl.g:7060:3: (enumLiteral_9= 'void' )
                    {
                    // InternalCoreDsl.g:7060:3: (enumLiteral_9= 'void' )
                    // InternalCoreDsl.g:7061:4: enumLiteral_9= 'void'
                    {
                    enumLiteral_9=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getVOIDEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getDataTypesAccess().getVOIDEnumLiteralDeclaration_9());
                      			
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
    // InternalCoreDsl.g:7071:1: ruleTypeQualifier returns [Enumerator current=null] : ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) ) ;
    public final Enumerator ruleTypeQualifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:7077:2: ( ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) ) )
            // InternalCoreDsl.g:7078:2: ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) )
            {
            // InternalCoreDsl.g:7078:2: ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==115) ) {
                alt137=1;
            }
            else if ( (LA137_0==116) ) {
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
                    // InternalCoreDsl.g:7079:3: (enumLiteral_0= 'const' )
                    {
                    // InternalCoreDsl.g:7079:3: (enumLiteral_0= 'const' )
                    // InternalCoreDsl.g:7080:4: enumLiteral_0= 'const'
                    {
                    enumLiteral_0=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeQualifierAccess().getCONSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTypeQualifierAccess().getCONSTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7087:3: (enumLiteral_1= 'volatile' )
                    {
                    // InternalCoreDsl.g:7087:3: (enumLiteral_1= 'volatile' )
                    // InternalCoreDsl.g:7088:4: enumLiteral_1= 'volatile'
                    {
                    enumLiteral_1=(Token)match(input,116,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:7098:1: ruleStorageClassSpecifier returns [Enumerator current=null] : ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) ) ;
    public final Enumerator ruleStorageClassSpecifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:7104:2: ( ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) ) )
            // InternalCoreDsl.g:7105:2: ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) )
            {
            // InternalCoreDsl.g:7105:2: ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==45) ) {
                alt138=1;
            }
            else if ( (LA138_0==117) ) {
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
                    // InternalCoreDsl.g:7106:3: (enumLiteral_0= 'extern' )
                    {
                    // InternalCoreDsl.g:7106:3: (enumLiteral_0= 'extern' )
                    // InternalCoreDsl.g:7107:4: enumLiteral_0= 'extern'
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
                    // InternalCoreDsl.g:7114:3: (enumLiteral_1= 'static' )
                    {
                    // InternalCoreDsl.g:7114:3: (enumLiteral_1= 'static' )
                    // InternalCoreDsl.g:7115:4: enumLiteral_1= 'static'
                    {
                    enumLiteral_1=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "ruleStatementAttribute"
    // InternalCoreDsl.g:7125:1: ruleStatementAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) | (enumLiteral_3= 'is_interlock_for' ) ) ;
    public final Enumerator ruleStatementAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:7131:2: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) | (enumLiteral_3= 'is_interlock_for' ) ) )
            // InternalCoreDsl.g:7132:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) | (enumLiteral_3= 'is_interlock_for' ) )
            {
            // InternalCoreDsl.g:7132:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'delete' ) | (enumLiteral_3= 'is_interlock_for' ) )
            int alt139=4;
            switch ( input.LA(1) ) {
            case 118:
                {
                alt139=1;
                }
                break;
            case 119:
                {
                alt139=2;
                }
                break;
            case 120:
                {
                alt139=3;
                }
                break;
            case 121:
                {
                alt139=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;
            }

            switch (alt139) {
                case 1 :
                    // InternalCoreDsl.g:7133:3: (enumLiteral_0= 'NONE' )
                    {
                    // InternalCoreDsl.g:7133:3: (enumLiteral_0= 'NONE' )
                    // InternalCoreDsl.g:7134:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStatementAttributeAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getStatementAttributeAccess().getNONEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7141:3: (enumLiteral_1= 'is_pc' )
                    {
                    // InternalCoreDsl.g:7141:3: (enumLiteral_1= 'is_pc' )
                    // InternalCoreDsl.g:7142:4: enumLiteral_1= 'is_pc'
                    {
                    enumLiteral_1=(Token)match(input,119,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStatementAttributeAccess().getIS_PCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getStatementAttributeAccess().getIS_PCEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:7149:3: (enumLiteral_2= 'delete' )
                    {
                    // InternalCoreDsl.g:7149:3: (enumLiteral_2= 'delete' )
                    // InternalCoreDsl.g:7150:4: enumLiteral_2= 'delete'
                    {
                    enumLiteral_2=(Token)match(input,120,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStatementAttributeAccess().getDELEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getStatementAttributeAccess().getDELEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:7157:3: (enumLiteral_3= 'is_interlock_for' )
                    {
                    // InternalCoreDsl.g:7157:3: (enumLiteral_3= 'is_interlock_for' )
                    // InternalCoreDsl.g:7158:4: enumLiteral_3= 'is_interlock_for'
                    {
                    enumLiteral_3=(Token)match(input,121,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStatementAttributeAccess().getIS_INTERLOCK_FOREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getStatementAttributeAccess().getIS_INTERLOCK_FOREnumLiteralDeclaration_3());
                      			
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
    // $ANTLR end "ruleStatementAttribute"


    // $ANTLR start "ruleInstrAttribute"
    // InternalCoreDsl.g:7168:1: ruleInstrAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) ) ;
    public final Enumerator ruleInstrAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:7174:2: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) ) )
            // InternalCoreDsl.g:7175:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) )
            {
            // InternalCoreDsl.g:7175:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) )
            int alt140=4;
            switch ( input.LA(1) ) {
            case 118:
                {
                alt140=1;
                }
                break;
            case 122:
                {
                alt140=2;
                }
                break;
            case 123:
                {
                alt140=3;
                }
                break;
            case 124:
                {
                alt140=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }

            switch (alt140) {
                case 1 :
                    // InternalCoreDsl.g:7176:3: (enumLiteral_0= 'NONE' )
                    {
                    // InternalCoreDsl.g:7176:3: (enumLiteral_0= 'NONE' )
                    // InternalCoreDsl.g:7177:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInstrAttributeAccess().getNONEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7184:3: (enumLiteral_1= 'no_cont' )
                    {
                    // InternalCoreDsl.g:7184:3: (enumLiteral_1= 'no_cont' )
                    // InternalCoreDsl.g:7185:4: enumLiteral_1= 'no_cont'
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
                    // InternalCoreDsl.g:7192:3: (enumLiteral_2= 'cond' )
                    {
                    // InternalCoreDsl.g:7192:3: (enumLiteral_2= 'cond' )
                    // InternalCoreDsl.g:7193:4: enumLiteral_2= 'cond'
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
                    // InternalCoreDsl.g:7200:3: (enumLiteral_3= 'flush' )
                    {
                    // InternalCoreDsl.g:7200:3: (enumLiteral_3= 'flush' )
                    // InternalCoreDsl.g:7201:4: enumLiteral_3= 'flush'
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
    // InternalCoreDsl.g:7211:1: ruleStructOrUnion returns [Enumerator current=null] : ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) ) ;
    public final Enumerator ruleStructOrUnion() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:7217:2: ( ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) ) )
            // InternalCoreDsl.g:7218:2: ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) )
            {
            // InternalCoreDsl.g:7218:2: ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) )
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==125) ) {
                alt141=1;
            }
            else if ( (LA141_0==126) ) {
                alt141=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }
            switch (alt141) {
                case 1 :
                    // InternalCoreDsl.g:7219:3: (enumLiteral_0= 'struct' )
                    {
                    // InternalCoreDsl.g:7219:3: (enumLiteral_0= 'struct' )
                    // InternalCoreDsl.g:7220:4: enumLiteral_0= 'struct'
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
                    // InternalCoreDsl.g:7227:3: (enumLiteral_1= 'union' )
                    {
                    // InternalCoreDsl.g:7227:3: (enumLiteral_1= 'union' )
                    // InternalCoreDsl.g:7228:4: enumLiteral_1= 'union'
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
    // InternalCoreDsl.g:7238:1: ruleBitfieldDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) ) ;
    public final Enumerator ruleBitfieldDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:7244:2: ( ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) ) )
            // InternalCoreDsl.g:7245:2: ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) )
            {
            // InternalCoreDsl.g:7245:2: ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) )
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==99) ) {
                alt142=1;
            }
            else if ( (LA142_0==127) ) {
                alt142=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;
            }
            switch (alt142) {
                case 1 :
                    // InternalCoreDsl.g:7246:3: (enumLiteral_0= 'u' )
                    {
                    // InternalCoreDsl.g:7246:3: (enumLiteral_0= 'u' )
                    // InternalCoreDsl.g:7247:4: enumLiteral_0= 'u'
                    {
                    enumLiteral_0=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getBitfieldDataTypeAccess().getUNSIGNEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getBitfieldDataTypeAccess().getUNSIGNEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7254:3: (enumLiteral_1= 's' )
                    {
                    // InternalCoreDsl.g:7254:3: (enumLiteral_1= 's' )
                    // InternalCoreDsl.g:7255:4: enumLiteral_1= 's'
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
        // InternalCoreDsl.g:1816:5: ( 'else' )
        // InternalCoreDsl.g:1816:6: 'else'
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000403000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000402000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000003D0000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x2000200000000100L,0x603FFE0000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x2000200020000100L,0x603FFE0000000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000003C0000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000380000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000200000000100L,0x603FFE0000000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000200020000100L,0x603FFE0000000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000001008000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000002F0000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000002E0000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000002A0000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000220000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000200008000100L,0x0038000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x1C40000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000100000000002L,0x8000000800000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000100000000000L,0x8000000800000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000A00000000100L,0x603FFE0000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000400000000122L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x1000400000003C30L,0x0000003DF3020000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x1FF4408008003C30L,0x0000003DF3020000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x3FF4608028003D30L,0x603FFE3DF3020002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x3000608000003D30L,0x603FFE3DF3020002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x1000408000003C30L,0x0000003DF3020000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x1000400000003C32L,0x0000003DF3020000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x9000008000000020L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x1000008000000020L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000008000000020L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000009000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x03C0000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0007FE0000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000001000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000001020000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x1000400008003C30L,0x0000003DF3020000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000404000000102L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000400000000102L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x1000400008003D30L,0x0000003DF3020004L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x4000000000000100L,0x0000000000000004L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000E00000000100L,0x603FFE0000000002L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x1000400000003E30L,0x0000003DF3020000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x4000000000000002L,0x0000000000001FF8L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x4000000000000000L,0x0000000000001FF8L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x8000000000000002L,0x0000000000300001L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000002L,0x0000000000C00000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000002L,0x0000000003000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x1000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000600000003D30L,0x603FFE3C00000002L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000400000000102L,0x0000000230000004L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x1000C00000003C30L,0x0000003DF3020000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000801000000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000012L,0x0000003C00000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000002L,0x0000007800000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000002L,0x0000006000000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000002L,0x000001E000000000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000002000L});

}