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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BVAL", "RULE_LEFT_BR", "RULE_RIGHT_BR", "RULE_INTEGER", "RULE_FLOAT", "RULE_BOOLEAN", "RULE_CHARCONST", "RULE_BINARYINT", "RULE_HEXADECIMALINT", "RULE_OCTALINT", "RULE_DECIMALINT", "RULE_VLOGINT", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'InstructionSet'", "'extends'", "'{'", "'constants'", "'}'", "'registers'", "'address_spaces'", "'functions'", "'instructions'", "'Core'", "'provides'", "','", "'encoding'", "':'", "';'", "'args_disass'", "'behavior'", "'::'", "'\\''", "'extern'", "'('", "')'", "'case'", "'default'", "'if'", "'else'", "'switch'", "'while'", "'do'", "'for'", "'continue'", "'break'", "'return'", "'spawn'", "'*'", "'&'", "'='", "'<'", "'>'", "'enum'", "'.'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'?'", "'||'", "'&&'", "'|'", "'^'", "'=='", "'!='", "'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'/'", "'%'", "'++'", "'--'", "'sizeof'", "'~'", "'!'", "'->'", "'u8'", "'u'", "'U'", "'L'", "'bool'", "'char'", "'short'", "'int'", "'long'", "'signed'", "'unsigned'", "'float'", "'double'", "'void'", "'alias'", "'const'", "'volatile'", "'static'", "'NONE'", "'is_pc'", "'is_interlock_for'", "'no_cont'", "'cond'", "'flush'", "'struct'", "'union'", "'s'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RULE_DECIMALINT=16;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=18;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=19;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_RIGHT_BR=8;
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
    public static final int RULE_BINARYINT=13;
    public static final int RULE_HEXADECIMALINT=14;
    public static final int RULE_OCTALINT=15;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=10;
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
    public static final int RULE_BOOLEAN=11;
    public static final int RULE_CHARCONST=12;
    public static final int RULE_VLOGINT=17;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_BVAL=6;
    public static final int T__120=120;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=20;
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
    public static final int RULE_WS=21;
    public static final int RULE_ANY_OTHER=22;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int RULE_LEFT_BR=7;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=9;
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

                if ( (LA1_0==23) ) {
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

                if ( (LA2_0==24||LA2_0==33) ) {
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
            otherlv_0=(Token)match(input,23,FOLLOW_5); if (state.failed) return current;
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

            if ( (LA3_0==24) ) {
                alt3=1;
            }
            else if ( (LA3_0==33) ) {
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
    // InternalCoreDsl.g:206:1: ruleInstructionSet returns [EObject current=null] : (otherlv_0= 'InstructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )? (otherlv_9= 'registers' otherlv_10= '{' ( (lv_regs_11_0= ruleDeclaration ) )+ otherlv_12= '}' )? (otherlv_13= 'address_spaces' otherlv_14= '{' ( (lv_spaces_15_0= ruleDeclaration ) )+ otherlv_16= '}' )? (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )? (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' )? otherlv_25= '}' ) ;
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

        EObject lv_regs_11_0 = null;

        EObject lv_spaces_15_0 = null;

        EObject lv_func_19_0 = null;

        EObject lv_instr_23_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:212:2: ( (otherlv_0= 'InstructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )? (otherlv_9= 'registers' otherlv_10= '{' ( (lv_regs_11_0= ruleDeclaration ) )+ otherlv_12= '}' )? (otherlv_13= 'address_spaces' otherlv_14= '{' ( (lv_spaces_15_0= ruleDeclaration ) )+ otherlv_16= '}' )? (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )? (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' )? otherlv_25= '}' ) )
            // InternalCoreDsl.g:213:2: (otherlv_0= 'InstructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )? (otherlv_9= 'registers' otherlv_10= '{' ( (lv_regs_11_0= ruleDeclaration ) )+ otherlv_12= '}' )? (otherlv_13= 'address_spaces' otherlv_14= '{' ( (lv_spaces_15_0= ruleDeclaration ) )+ otherlv_16= '}' )? (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )? (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' )? otherlv_25= '}' )
            {
            // InternalCoreDsl.g:213:2: (otherlv_0= 'InstructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )? (otherlv_9= 'registers' otherlv_10= '{' ( (lv_regs_11_0= ruleDeclaration ) )+ otherlv_12= '}' )? (otherlv_13= 'address_spaces' otherlv_14= '{' ( (lv_spaces_15_0= ruleDeclaration ) )+ otherlv_16= '}' )? (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )? (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' )? otherlv_25= '}' )
            // InternalCoreDsl.g:214:3: otherlv_0= 'InstructionSet' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )? (otherlv_9= 'registers' otherlv_10= '{' ( (lv_regs_11_0= ruleDeclaration ) )+ otherlv_12= '}' )? (otherlv_13= 'address_spaces' otherlv_14= '{' ( (lv_spaces_15_0= ruleDeclaration ) )+ otherlv_16= '}' )? (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )? (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' )? otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_6); if (state.failed) return current;
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

            if ( (LA4_0==25) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalCoreDsl.g:237:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_6); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,26,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:259:3: (otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==27) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalCoreDsl.g:260:4: otherlv_5= 'constants' otherlv_6= '{' ( (lv_constants_7_0= ruleDeclaration ) )+ otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getInstructionSetAccess().getConstantsKeyword_4_0());
                      			
                    }
                    otherlv_6=(Token)match(input,26,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:268:4: ( (lv_constants_7_0= ruleDeclaration ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_LEFT_BR||LA5_0==43||LA5_0==63||(LA5_0>=100 && LA5_0<=113)||(LA5_0>=120 && LA5_0<=121)) ) {
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

                    otherlv_8=(Token)match(input,28,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:292:3: (otherlv_9= 'registers' otherlv_10= '{' ( (lv_regs_11_0= ruleDeclaration ) )+ otherlv_12= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalCoreDsl.g:293:4: otherlv_9= 'registers' otherlv_10= '{' ( (lv_regs_11_0= ruleDeclaration ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getInstructionSetAccess().getRegistersKeyword_5_0());
                      			
                    }
                    otherlv_10=(Token)match(input,26,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_5_1());
                      			
                    }
                    // InternalCoreDsl.g:301:4: ( (lv_regs_11_0= ruleDeclaration ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_LEFT_BR||LA7_0==43||LA7_0==63||(LA7_0>=100 && LA7_0<=113)||(LA7_0>=120 && LA7_0<=121)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalCoreDsl.g:302:5: (lv_regs_11_0= ruleDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:302:5: (lv_regs_11_0= ruleDeclaration )
                    	    // InternalCoreDsl.g:303:6: lv_regs_11_0= ruleDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getInstructionSetAccess().getRegsDeclarationParserRuleCall_5_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_regs_11_0=ruleDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getInstructionSetRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"regs",
                    	      							lv_regs_11_0,
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

                    otherlv_12=(Token)match(input,28,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:325:3: (otherlv_13= 'address_spaces' otherlv_14= '{' ( (lv_spaces_15_0= ruleDeclaration ) )+ otherlv_16= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==30) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalCoreDsl.g:326:4: otherlv_13= 'address_spaces' otherlv_14= '{' ( (lv_spaces_15_0= ruleDeclaration ) )+ otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getInstructionSetAccess().getAddress_spacesKeyword_6_0());
                      			
                    }
                    otherlv_14=(Token)match(input,26,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_6_1());
                      			
                    }
                    // InternalCoreDsl.g:334:4: ( (lv_spaces_15_0= ruleDeclaration ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_LEFT_BR||LA9_0==43||LA9_0==63||(LA9_0>=100 && LA9_0<=113)||(LA9_0>=120 && LA9_0<=121)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalCoreDsl.g:335:5: (lv_spaces_15_0= ruleDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:335:5: (lv_spaces_15_0= ruleDeclaration )
                    	    // InternalCoreDsl.g:336:6: lv_spaces_15_0= ruleDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getInstructionSetAccess().getSpacesDeclarationParserRuleCall_6_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_spaces_15_0=ruleDeclaration();

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

                    otherlv_16=(Token)match(input,28,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:358:3: (otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==31) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalCoreDsl.g:359:4: otherlv_17= 'functions' otherlv_18= '{' ( (lv_func_19_0= ruleFunctionDefinition ) )+ otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,31,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getInstructionSetAccess().getFunctionsKeyword_7_0());
                      			
                    }
                    otherlv_18=(Token)match(input,26,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getInstructionSetAccess().getLeftCurlyBracketKeyword_7_1());
                      			
                    }
                    // InternalCoreDsl.g:367:4: ( (lv_func_19_0= ruleFunctionDefinition ) )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==43||LA11_0==63||(LA11_0>=100 && LA11_0<=110)||(LA11_0>=120 && LA11_0<=121)) ) {
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
                    	    pushFollow(FOLLOW_11);
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

                    otherlv_20=(Token)match(input,28,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_7_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:391:3: (otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==32) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalCoreDsl.g:392:4: otherlv_21= 'instructions' otherlv_22= '{' ( (lv_instr_23_0= ruleInstruction ) )+ otherlv_24= '}'
                    {
                    otherlv_21=(Token)match(input,32,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_21, grammarAccess.getInstructionSetAccess().getInstructionsKeyword_8_0());
                      			
                    }
                    otherlv_22=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
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
                    	    pushFollow(FOLLOW_16);
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

                    otherlv_24=(Token)match(input,28,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_24, grammarAccess.getInstructionSetAccess().getRightCurlyBracketKeyword_8_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_25=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:439:1: ruleCoreDef returns [EObject current=null] : (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )? (otherlv_11= 'registers' otherlv_12= '{' ( (lv_regs_13_0= ruleDeclaration ) )+ otherlv_14= '}' )? (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleDeclaration ) )+ otherlv_18= '}' )? (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )? otherlv_23= '}' ) ;
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

        EObject lv_regs_13_0 = null;

        EObject lv_spaces_17_0 = null;

        EObject lv_instr_21_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:445:2: ( (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )? (otherlv_11= 'registers' otherlv_12= '{' ( (lv_regs_13_0= ruleDeclaration ) )+ otherlv_14= '}' )? (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleDeclaration ) )+ otherlv_18= '}' )? (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )? otherlv_23= '}' ) )
            // InternalCoreDsl.g:446:2: (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )? (otherlv_11= 'registers' otherlv_12= '{' ( (lv_regs_13_0= ruleDeclaration ) )+ otherlv_14= '}' )? (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleDeclaration ) )+ otherlv_18= '}' )? (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )? otherlv_23= '}' )
            {
            // InternalCoreDsl.g:446:2: (otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )? (otherlv_11= 'registers' otherlv_12= '{' ( (lv_regs_13_0= ruleDeclaration ) )+ otherlv_14= '}' )? (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleDeclaration ) )+ otherlv_18= '}' )? (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )? otherlv_23= '}' )
            // InternalCoreDsl.g:447:3: otherlv_0= 'Core' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= '{' (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )? (otherlv_11= 'registers' otherlv_12= '{' ( (lv_regs_13_0= ruleDeclaration ) )+ otherlv_14= '}' )? (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleDeclaration ) )+ otherlv_18= '}' )? (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )? otherlv_23= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCoreDefAccess().getCoreKeyword_0());
              		
            }
            // InternalCoreDsl.g:451:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalCoreDsl.g:452:4: (lv_name_1_0= RULE_ID )
            {
            // InternalCoreDsl.g:452:4: (lv_name_1_0= RULE_ID )
            // InternalCoreDsl.g:453:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
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
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==34) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalCoreDsl.g:470:4: otherlv_2= 'provides' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_6); if (state.failed) return current;
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
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getCoreDefAccess().getContributingTypeInstructionSetCrossReference_2_1_0());
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:487:4: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==35) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalCoreDsl.g:488:5: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
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
                    	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,26,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalCoreDsl.g:511:3: (otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalCoreDsl.g:512:4: otherlv_7= 'constants' otherlv_8= '{' ( (lv_constants_9_0= ruleDeclaration ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getCoreDefAccess().getConstantsKeyword_4_0());
                      			
                    }
                    otherlv_8=(Token)match(input,26,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:520:4: ( (lv_constants_9_0= ruleDeclaration ) )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_LEFT_BR||LA17_0==43||LA17_0==63||(LA17_0>=100 && LA17_0<=113)||(LA17_0>=120 && LA17_0<=121)) ) {
                            alt17=1;
                        }


                        switch (alt17) {
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
                    	    if ( cnt17 >= 1 ) break loop17;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    otherlv_10=(Token)match(input,28,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:544:3: (otherlv_11= 'registers' otherlv_12= '{' ( (lv_regs_13_0= ruleDeclaration ) )+ otherlv_14= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalCoreDsl.g:545:4: otherlv_11= 'registers' otherlv_12= '{' ( (lv_regs_13_0= ruleDeclaration ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getCoreDefAccess().getRegistersKeyword_5_0());
                      			
                    }
                    otherlv_12=(Token)match(input,26,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_5_1());
                      			
                    }
                    // InternalCoreDsl.g:553:4: ( (lv_regs_13_0= ruleDeclaration ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_LEFT_BR||LA19_0==43||LA19_0==63||(LA19_0>=100 && LA19_0<=113)||(LA19_0>=120 && LA19_0<=121)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalCoreDsl.g:554:5: (lv_regs_13_0= ruleDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:554:5: (lv_regs_13_0= ruleDeclaration )
                    	    // InternalCoreDsl.g:555:6: lv_regs_13_0= ruleDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCoreDefAccess().getRegsDeclarationParserRuleCall_5_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_regs_13_0=ruleDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getCoreDefRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"regs",
                    	      							lv_regs_13_0,
                    	      							"com.minres.coredsl.CoreDsl.Declaration");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    otherlv_14=(Token)match(input,28,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:577:3: (otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleDeclaration ) )+ otherlv_18= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalCoreDsl.g:578:4: otherlv_15= 'address_spaces' otherlv_16= '{' ( (lv_spaces_17_0= ruleDeclaration ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getCoreDefAccess().getAddress_spacesKeyword_6_0());
                      			
                    }
                    otherlv_16=(Token)match(input,26,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_6_1());
                      			
                    }
                    // InternalCoreDsl.g:586:4: ( (lv_spaces_17_0= ruleDeclaration ) )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_LEFT_BR||LA21_0==43||LA21_0==63||(LA21_0>=100 && LA21_0<=113)||(LA21_0>=120 && LA21_0<=121)) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalCoreDsl.g:587:5: (lv_spaces_17_0= ruleDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:587:5: (lv_spaces_17_0= ruleDeclaration )
                    	    // InternalCoreDsl.g:588:6: lv_spaces_17_0= ruleDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCoreDefAccess().getSpacesDeclarationParserRuleCall_6_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_spaces_17_0=ruleDeclaration();

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
                    	      							"com.minres.coredsl.CoreDsl.Declaration");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);

                    otherlv_18=(Token)match(input,28,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:610:3: (otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalCoreDsl.g:611:4: otherlv_19= 'instructions' otherlv_20= '{' ( (lv_instr_21_0= ruleInstruction ) )+ otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,32,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getCoreDefAccess().getInstructionsKeyword_7_0());
                      			
                    }
                    otherlv_20=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getCoreDefAccess().getLeftCurlyBracketKeyword_7_1());
                      			
                    }
                    // InternalCoreDsl.g:619:4: ( (lv_instr_21_0= ruleInstruction ) )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_ID) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalCoreDsl.g:620:5: (lv_instr_21_0= ruleInstruction )
                    	    {
                    	    // InternalCoreDsl.g:620:5: (lv_instr_21_0= ruleInstruction )
                    	    // InternalCoreDsl.g:621:6: lv_instr_21_0= ruleInstruction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getCoreDefAccess().getInstrInstructionParserRuleCall_7_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_16);
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
                    	    if ( cnt23 >= 1 ) break loop23;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);

                    otherlv_22=(Token)match(input,28,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_22, grammarAccess.getCoreDefAccess().getRightCurlyBracketKeyword_7_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_23=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:658:1: ruleInstruction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) ruleDoubleRightBracket )* otherlv_4= '{' (otherlv_5= 'encoding' otherlv_6= ':' ( (lv_encoding_7_0= ruleEncoding ) ) otherlv_8= ';' ) (otherlv_9= 'args_disass' otherlv_10= ':' ( (lv_disass_11_0= RULE_STRING ) ) otherlv_12= ';' )? (otherlv_13= 'behavior' otherlv_14= ':' ( (lv_behavior_15_0= ruleStatement ) ) ) otherlv_16= '}' ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_disass_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Enumerator lv_attributes_2_0 = null;

        EObject lv_encoding_7_0 = null;

        EObject lv_behavior_15_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:664:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) ruleDoubleRightBracket )* otherlv_4= '{' (otherlv_5= 'encoding' otherlv_6= ':' ( (lv_encoding_7_0= ruleEncoding ) ) otherlv_8= ';' ) (otherlv_9= 'args_disass' otherlv_10= ':' ( (lv_disass_11_0= RULE_STRING ) ) otherlv_12= ';' )? (otherlv_13= 'behavior' otherlv_14= ':' ( (lv_behavior_15_0= ruleStatement ) ) ) otherlv_16= '}' ) )
            // InternalCoreDsl.g:665:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) ruleDoubleRightBracket )* otherlv_4= '{' (otherlv_5= 'encoding' otherlv_6= ':' ( (lv_encoding_7_0= ruleEncoding ) ) otherlv_8= ';' ) (otherlv_9= 'args_disass' otherlv_10= ':' ( (lv_disass_11_0= RULE_STRING ) ) otherlv_12= ';' )? (otherlv_13= 'behavior' otherlv_14= ':' ( (lv_behavior_15_0= ruleStatement ) ) ) otherlv_16= '}' )
            {
            // InternalCoreDsl.g:665:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) ruleDoubleRightBracket )* otherlv_4= '{' (otherlv_5= 'encoding' otherlv_6= ':' ( (lv_encoding_7_0= ruleEncoding ) ) otherlv_8= ';' ) (otherlv_9= 'args_disass' otherlv_10= ':' ( (lv_disass_11_0= RULE_STRING ) ) otherlv_12= ';' )? (otherlv_13= 'behavior' otherlv_14= ':' ( (lv_behavior_15_0= ruleStatement ) ) ) otherlv_16= '}' )
            // InternalCoreDsl.g:666:3: ( (lv_name_0_0= RULE_ID ) ) ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) ruleDoubleRightBracket )* otherlv_4= '{' (otherlv_5= 'encoding' otherlv_6= ':' ( (lv_encoding_7_0= ruleEncoding ) ) otherlv_8= ';' ) (otherlv_9= 'args_disass' otherlv_10= ':' ( (lv_disass_11_0= RULE_STRING ) ) otherlv_12= ';' )? (otherlv_13= 'behavior' otherlv_14= ':' ( (lv_behavior_15_0= ruleStatement ) ) ) otherlv_16= '}'
            {
            // InternalCoreDsl.g:666:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:667:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:667:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:668:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
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

            // InternalCoreDsl.g:684:3: ( ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) ruleDoubleRightBracket )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_LEFT_BR) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalCoreDsl.g:685:4: ruleDoubleLeftBracket ( (lv_attributes_2_0= ruleInstrAttribute ) ) ruleDoubleRightBracket
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getInstructionAccess().getDoubleLeftBracketParserRuleCall_1_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_24);
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
            	    pushFollow(FOLLOW_25);
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

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getInstructionAccess().getDoubleRightBracketParserRuleCall_1_2());
            	      			
            	    }
            	    pushFollow(FOLLOW_23);
            	    ruleDoubleRightBracket();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_4=(Token)match(input,26,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getInstructionAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalCoreDsl.g:723:3: (otherlv_5= 'encoding' otherlv_6= ':' ( (lv_encoding_7_0= ruleEncoding ) ) otherlv_8= ';' )
            // InternalCoreDsl.g:724:4: otherlv_5= 'encoding' otherlv_6= ':' ( (lv_encoding_7_0= ruleEncoding ) ) otherlv_8= ';'
            {
            otherlv_5=(Token)match(input,36,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_5, grammarAccess.getInstructionAccess().getEncodingKeyword_3_0());
              			
            }
            otherlv_6=(Token)match(input,37,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_6, grammarAccess.getInstructionAccess().getColonKeyword_3_1());
              			
            }
            // InternalCoreDsl.g:732:4: ( (lv_encoding_7_0= ruleEncoding ) )
            // InternalCoreDsl.g:733:5: (lv_encoding_7_0= ruleEncoding )
            {
            // InternalCoreDsl.g:733:5: (lv_encoding_7_0= ruleEncoding )
            // InternalCoreDsl.g:734:6: lv_encoding_7_0= ruleEncoding
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getInstructionAccess().getEncodingEncodingParserRuleCall_3_2_0());
              					
            }
            pushFollow(FOLLOW_29);
            lv_encoding_7_0=ruleEncoding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getInstructionRule());
              						}
              						set(
              							current,
              							"encoding",
              							lv_encoding_7_0,
              							"com.minres.coredsl.CoreDsl.Encoding");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            otherlv_8=(Token)match(input,38,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_8, grammarAccess.getInstructionAccess().getSemicolonKeyword_3_3());
              			
            }

            }

            // InternalCoreDsl.g:756:3: (otherlv_9= 'args_disass' otherlv_10= ':' ( (lv_disass_11_0= RULE_STRING ) ) otherlv_12= ';' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==39) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalCoreDsl.g:757:4: otherlv_9= 'args_disass' otherlv_10= ':' ( (lv_disass_11_0= RULE_STRING ) ) otherlv_12= ';'
                    {
                    otherlv_9=(Token)match(input,39,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getInstructionAccess().getArgs_disassKeyword_4_0());
                      			
                    }
                    otherlv_10=(Token)match(input,37,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getInstructionAccess().getColonKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:765:4: ( (lv_disass_11_0= RULE_STRING ) )
                    // InternalCoreDsl.g:766:5: (lv_disass_11_0= RULE_STRING )
                    {
                    // InternalCoreDsl.g:766:5: (lv_disass_11_0= RULE_STRING )
                    // InternalCoreDsl.g:767:6: lv_disass_11_0= RULE_STRING
                    {
                    lv_disass_11_0=(Token)match(input,RULE_STRING,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_disass_11_0, grammarAccess.getInstructionAccess().getDisassSTRINGTerminalRuleCall_4_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getInstructionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"disass",
                      							lv_disass_11_0,
                      							"com.minres.coredsl.CoreDsl.STRING");
                      					
                    }

                    }


                    }

                    otherlv_12=(Token)match(input,38,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getInstructionAccess().getSemicolonKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            // InternalCoreDsl.g:788:3: (otherlv_13= 'behavior' otherlv_14= ':' ( (lv_behavior_15_0= ruleStatement ) ) )
            // InternalCoreDsl.g:789:4: otherlv_13= 'behavior' otherlv_14= ':' ( (lv_behavior_15_0= ruleStatement ) )
            {
            otherlv_13=(Token)match(input,40,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_13, grammarAccess.getInstructionAccess().getBehaviorKeyword_5_0());
              			
            }
            otherlv_14=(Token)match(input,37,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_14, grammarAccess.getInstructionAccess().getColonKeyword_5_1());
              			
            }
            // InternalCoreDsl.g:797:4: ( (lv_behavior_15_0= ruleStatement ) )
            // InternalCoreDsl.g:798:5: (lv_behavior_15_0= ruleStatement )
            {
            // InternalCoreDsl.g:798:5: (lv_behavior_15_0= ruleStatement )
            // InternalCoreDsl.g:799:6: lv_behavior_15_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getInstructionAccess().getBehaviorStatementParserRuleCall_5_2_0());
              					
            }
            pushFollow(FOLLOW_17);
            lv_behavior_15_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getInstructionRule());
              						}
              						set(
              							current,
              							"behavior",
              							lv_behavior_15_0,
              							"com.minres.coredsl.CoreDsl.Statement");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }

            otherlv_16=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_16, grammarAccess.getInstructionAccess().getRightCurlyBracketKeyword_6());
              		
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
    // InternalCoreDsl.g:825:1: entryRuleEncoding returns [EObject current=null] : iv_ruleEncoding= ruleEncoding EOF ;
    public final EObject entryRuleEncoding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEncoding = null;


        try {
            // InternalCoreDsl.g:825:49: (iv_ruleEncoding= ruleEncoding EOF )
            // InternalCoreDsl.g:826:2: iv_ruleEncoding= ruleEncoding EOF
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
    // InternalCoreDsl.g:832:1: ruleEncoding returns [EObject current=null] : ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '::' ( (lv_fields_2_0= ruleField ) ) )* ) ;
    public final EObject ruleEncoding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fields_0_0 = null;

        EObject lv_fields_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:838:2: ( ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '::' ( (lv_fields_2_0= ruleField ) ) )* ) )
            // InternalCoreDsl.g:839:2: ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '::' ( (lv_fields_2_0= ruleField ) ) )* )
            {
            // InternalCoreDsl.g:839:2: ( ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '::' ( (lv_fields_2_0= ruleField ) ) )* )
            // InternalCoreDsl.g:840:3: ( (lv_fields_0_0= ruleField ) ) (otherlv_1= '::' ( (lv_fields_2_0= ruleField ) ) )*
            {
            // InternalCoreDsl.g:840:3: ( (lv_fields_0_0= ruleField ) )
            // InternalCoreDsl.g:841:4: (lv_fields_0_0= ruleField )
            {
            // InternalCoreDsl.g:841:4: (lv_fields_0_0= ruleField )
            // InternalCoreDsl.g:842:5: lv_fields_0_0= ruleField
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEncodingAccess().getFieldsFieldParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_33);
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

            // InternalCoreDsl.g:859:3: (otherlv_1= '::' ( (lv_fields_2_0= ruleField ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==41) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalCoreDsl.g:860:4: otherlv_1= '::' ( (lv_fields_2_0= ruleField ) )
            	    {
            	    otherlv_1=(Token)match(input,41,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getEncodingAccess().getColonColonKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:864:4: ( (lv_fields_2_0= ruleField ) )
            	    // InternalCoreDsl.g:865:5: (lv_fields_2_0= ruleField )
            	    {
            	    // InternalCoreDsl.g:865:5: (lv_fields_2_0= ruleField )
            	    // InternalCoreDsl.g:866:6: lv_fields_2_0= ruleField
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEncodingAccess().getFieldsFieldParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
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
    // InternalCoreDsl.g:888:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalCoreDsl.g:888:46: (iv_ruleField= ruleField EOF )
            // InternalCoreDsl.g:889:2: iv_ruleField= ruleField EOF
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
    // InternalCoreDsl.g:895:1: ruleField returns [EObject current=null] : (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        EObject this_BitValue_0 = null;

        EObject this_BitField_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:901:2: ( (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField ) )
            // InternalCoreDsl.g:902:2: (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField )
            {
            // InternalCoreDsl.g:902:2: (this_BitValue_0= ruleBitValue | this_BitField_1= ruleBitField )
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
                    // InternalCoreDsl.g:903:3: this_BitValue_0= ruleBitValue
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
                    // InternalCoreDsl.g:912:3: this_BitField_1= ruleBitField
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
    // InternalCoreDsl.g:924:1: entryRuleBitValue returns [EObject current=null] : iv_ruleBitValue= ruleBitValue EOF ;
    public final EObject entryRuleBitValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitValue = null;


        try {
            // InternalCoreDsl.g:924:49: (iv_ruleBitValue= ruleBitValue EOF )
            // InternalCoreDsl.g:925:2: iv_ruleBitValue= ruleBitValue EOF
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
    // InternalCoreDsl.g:931:1: ruleBitValue returns [EObject current=null] : ( (lv_name_0_0= RULE_BVAL ) ) ;
    public final EObject ruleBitValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:937:2: ( ( (lv_name_0_0= RULE_BVAL ) ) )
            // InternalCoreDsl.g:938:2: ( (lv_name_0_0= RULE_BVAL ) )
            {
            // InternalCoreDsl.g:938:2: ( (lv_name_0_0= RULE_BVAL ) )
            // InternalCoreDsl.g:939:3: (lv_name_0_0= RULE_BVAL )
            {
            // InternalCoreDsl.g:939:3: (lv_name_0_0= RULE_BVAL )
            // InternalCoreDsl.g:940:4: lv_name_0_0= RULE_BVAL
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
    // InternalCoreDsl.g:959:1: entryRuleBitField returns [EObject current=null] : iv_ruleBitField= ruleBitField EOF ;
    public final EObject entryRuleBitField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitField = null;


        try {
            // InternalCoreDsl.g:959:49: (iv_ruleBitField= ruleBitField EOF )
            // InternalCoreDsl.g:960:2: iv_ruleBitField= ruleBitField EOF
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
    // InternalCoreDsl.g:966:1: ruleBitField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? ) ;
    public final EObject ruleBitField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        EObject lv_bitRange_1_0 = null;

        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:972:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? ) )
            // InternalCoreDsl.g:973:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? )
            {
            // InternalCoreDsl.g:973:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )? )
            // InternalCoreDsl.g:974:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_bitRange_1_0= ruleRangeSpec ) ) ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )?
            {
            // InternalCoreDsl.g:974:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:975:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:975:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:976:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
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

            // InternalCoreDsl.g:992:3: ( (lv_bitRange_1_0= ruleRangeSpec ) )
            // InternalCoreDsl.g:993:4: (lv_bitRange_1_0= ruleRangeSpec )
            {
            // InternalCoreDsl.g:993:4: (lv_bitRange_1_0= ruleRangeSpec )
            // InternalCoreDsl.g:994:5: lv_bitRange_1_0= ruleRangeSpec
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBitFieldAccess().getBitRangeRangeSpecParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_35);
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

            // InternalCoreDsl.g:1011:3: ( (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==42||LA30_0==97||LA30_0==122) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalCoreDsl.g:1012:4: (otherlv_2= '\\'' )? ( (lv_type_3_0= ruleBitfieldDataType ) )
                    {
                    // InternalCoreDsl.g:1012:4: (otherlv_2= '\\'' )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==42) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalCoreDsl.g:1013:5: otherlv_2= '\\''
                            {
                            otherlv_2=(Token)match(input,42,FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getBitFieldAccess().getApostropheKeyword_2_0());
                              				
                            }

                            }
                            break;

                    }

                    // InternalCoreDsl.g:1018:4: ( (lv_type_3_0= ruleBitfieldDataType ) )
                    // InternalCoreDsl.g:1019:5: (lv_type_3_0= ruleBitfieldDataType )
                    {
                    // InternalCoreDsl.g:1019:5: (lv_type_3_0= ruleBitfieldDataType )
                    // InternalCoreDsl.g:1020:6: lv_type_3_0= ruleBitfieldDataType
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
    // InternalCoreDsl.g:1042:1: entryRuleRangeSpec returns [EObject current=null] : iv_ruleRangeSpec= ruleRangeSpec EOF ;
    public final EObject entryRuleRangeSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeSpec = null;


        try {
            // InternalCoreDsl.g:1042:50: (iv_ruleRangeSpec= ruleRangeSpec EOF )
            // InternalCoreDsl.g:1043:2: iv_ruleRangeSpec= ruleRangeSpec EOF
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
    // InternalCoreDsl.g:1049:1: ruleRangeSpec returns [EObject current=null] : (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_left_1_0= ruleIntegerConstant ) ) otherlv_2= ':' ( (lv_right_3_0= ruleIntegerConstant ) ) this_RIGHT_BR_4= RULE_RIGHT_BR ) ;
    public final EObject ruleRangeSpec() throws RecognitionException {
        EObject current = null;

        Token this_LEFT_BR_0=null;
        Token otherlv_2=null;
        Token this_RIGHT_BR_4=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1055:2: ( (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_left_1_0= ruleIntegerConstant ) ) otherlv_2= ':' ( (lv_right_3_0= ruleIntegerConstant ) ) this_RIGHT_BR_4= RULE_RIGHT_BR ) )
            // InternalCoreDsl.g:1056:2: (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_left_1_0= ruleIntegerConstant ) ) otherlv_2= ':' ( (lv_right_3_0= ruleIntegerConstant ) ) this_RIGHT_BR_4= RULE_RIGHT_BR )
            {
            // InternalCoreDsl.g:1056:2: (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_left_1_0= ruleIntegerConstant ) ) otherlv_2= ':' ( (lv_right_3_0= ruleIntegerConstant ) ) this_RIGHT_BR_4= RULE_RIGHT_BR )
            // InternalCoreDsl.g:1057:3: this_LEFT_BR_0= RULE_LEFT_BR ( (lv_left_1_0= ruleIntegerConstant ) ) otherlv_2= ':' ( (lv_right_3_0= ruleIntegerConstant ) ) this_RIGHT_BR_4= RULE_RIGHT_BR
            {
            this_LEFT_BR_0=(Token)match(input,RULE_LEFT_BR,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_LEFT_BR_0, grammarAccess.getRangeSpecAccess().getLEFT_BRTerminalRuleCall_0());
              		
            }
            // InternalCoreDsl.g:1061:3: ( (lv_left_1_0= ruleIntegerConstant ) )
            // InternalCoreDsl.g:1062:4: (lv_left_1_0= ruleIntegerConstant )
            {
            // InternalCoreDsl.g:1062:4: (lv_left_1_0= ruleIntegerConstant )
            // InternalCoreDsl.g:1063:5: lv_left_1_0= ruleIntegerConstant
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRangeSpecAccess().getLeftIntegerConstantParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            otherlv_2=(Token)match(input,37,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRangeSpecAccess().getColonKeyword_2());
              		
            }
            // InternalCoreDsl.g:1084:3: ( (lv_right_3_0= ruleIntegerConstant ) )
            // InternalCoreDsl.g:1085:4: (lv_right_3_0= ruleIntegerConstant )
            {
            // InternalCoreDsl.g:1085:4: (lv_right_3_0= ruleIntegerConstant )
            // InternalCoreDsl.g:1086:5: lv_right_3_0= ruleIntegerConstant
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRangeSpecAccess().getRightIntegerConstantParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_25);
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
    // InternalCoreDsl.g:1111:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalCoreDsl.g:1111:59: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalCoreDsl.g:1112:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
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
    // InternalCoreDsl.g:1118:1: ruleFunctionDefinition returns [EObject current=null] : ( ( ( (lv_extern_0_0= 'extern' ) ) ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' otherlv_6= ';' ) | ( ( (lv_type_7_0= ruleTypeSpecifier ) ) ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '(' (this_ParameterList_10= ruleParameterList[$current] )? otherlv_11= ')' ( (lv_statement_12_0= ruleCompoundStatement ) ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_extern_0_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_type_1_0 = null;

        EObject this_ParameterList_4 = null;

        EObject lv_type_7_0 = null;

        EObject this_ParameterList_10 = null;

        EObject lv_statement_12_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1124:2: ( ( ( ( (lv_extern_0_0= 'extern' ) ) ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' otherlv_6= ';' ) | ( ( (lv_type_7_0= ruleTypeSpecifier ) ) ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '(' (this_ParameterList_10= ruleParameterList[$current] )? otherlv_11= ')' ( (lv_statement_12_0= ruleCompoundStatement ) ) ) ) )
            // InternalCoreDsl.g:1125:2: ( ( ( (lv_extern_0_0= 'extern' ) ) ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' otherlv_6= ';' ) | ( ( (lv_type_7_0= ruleTypeSpecifier ) ) ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '(' (this_ParameterList_10= ruleParameterList[$current] )? otherlv_11= ')' ( (lv_statement_12_0= ruleCompoundStatement ) ) ) )
            {
            // InternalCoreDsl.g:1125:2: ( ( ( (lv_extern_0_0= 'extern' ) ) ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' otherlv_6= ';' ) | ( ( (lv_type_7_0= ruleTypeSpecifier ) ) ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '(' (this_ParameterList_10= ruleParameterList[$current] )? otherlv_11= ')' ( (lv_statement_12_0= ruleCompoundStatement ) ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==43) ) {
                alt33=1;
            }
            else if ( (LA33_0==63||(LA33_0>=100 && LA33_0<=110)||(LA33_0>=120 && LA33_0<=121)) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalCoreDsl.g:1126:3: ( ( (lv_extern_0_0= 'extern' ) ) ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' otherlv_6= ';' )
                    {
                    // InternalCoreDsl.g:1126:3: ( ( (lv_extern_0_0= 'extern' ) ) ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' otherlv_6= ';' )
                    // InternalCoreDsl.g:1127:4: ( (lv_extern_0_0= 'extern' ) ) ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' (this_ParameterList_4= ruleParameterList[$current] )? otherlv_5= ')' otherlv_6= ';'
                    {
                    // InternalCoreDsl.g:1127:4: ( (lv_extern_0_0= 'extern' ) )
                    // InternalCoreDsl.g:1128:5: (lv_extern_0_0= 'extern' )
                    {
                    // InternalCoreDsl.g:1128:5: (lv_extern_0_0= 'extern' )
                    // InternalCoreDsl.g:1129:6: lv_extern_0_0= 'extern'
                    {
                    lv_extern_0_0=(Token)match(input,43,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_extern_0_0, grammarAccess.getFunctionDefinitionAccess().getExternExternKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                      						}
                      						setWithLastConsumed(current, "extern", lv_extern_0_0 != null, "extern");
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:1141:4: ( (lv_type_1_0= ruleTypeSpecifier ) )
                    // InternalCoreDsl.g:1142:5: (lv_type_1_0= ruleTypeSpecifier )
                    {
                    // InternalCoreDsl.g:1142:5: (lv_type_1_0= ruleTypeSpecifier )
                    // InternalCoreDsl.g:1143:6: lv_type_1_0= ruleTypeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getTypeTypeSpecifierParserRuleCall_0_1_0());
                      					
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

                    // InternalCoreDsl.g:1160:4: ( (lv_name_2_0= RULE_ID ) )
                    // InternalCoreDsl.g:1161:5: (lv_name_2_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:1161:5: (lv_name_2_0= RULE_ID )
                    // InternalCoreDsl.g:1162:6: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_2_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_0_2_0());
                      					
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

                    otherlv_3=(Token)match(input,44,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_0_3());
                      			
                    }
                    // InternalCoreDsl.g:1182:4: (this_ParameterList_4= ruleParameterList[$current] )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==63||(LA31_0>=100 && LA31_0<=110)||(LA31_0>=120 && LA31_0<=121)) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalCoreDsl.g:1183:5: this_ParameterList_4= ruleParameterList[$current]
                            {
                            if ( state.backtracking==0 ) {

                              					if (current==null) {
                              						current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                              					}
                              					newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParameterListParserRuleCall_0_4());
                              				
                            }
                            pushFollow(FOLLOW_40);
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

                    otherlv_5=(Token)match(input,45,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_0_5());
                      			
                    }
                    otherlv_6=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getFunctionDefinitionAccess().getSemicolonKeyword_0_6());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:1205:3: ( ( (lv_type_7_0= ruleTypeSpecifier ) ) ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '(' (this_ParameterList_10= ruleParameterList[$current] )? otherlv_11= ')' ( (lv_statement_12_0= ruleCompoundStatement ) ) )
                    {
                    // InternalCoreDsl.g:1205:3: ( ( (lv_type_7_0= ruleTypeSpecifier ) ) ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '(' (this_ParameterList_10= ruleParameterList[$current] )? otherlv_11= ')' ( (lv_statement_12_0= ruleCompoundStatement ) ) )
                    // InternalCoreDsl.g:1206:4: ( (lv_type_7_0= ruleTypeSpecifier ) ) ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '(' (this_ParameterList_10= ruleParameterList[$current] )? otherlv_11= ')' ( (lv_statement_12_0= ruleCompoundStatement ) )
                    {
                    // InternalCoreDsl.g:1206:4: ( (lv_type_7_0= ruleTypeSpecifier ) )
                    // InternalCoreDsl.g:1207:5: (lv_type_7_0= ruleTypeSpecifier )
                    {
                    // InternalCoreDsl.g:1207:5: (lv_type_7_0= ruleTypeSpecifier )
                    // InternalCoreDsl.g:1208:6: lv_type_7_0= ruleTypeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getTypeTypeSpecifierParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_6);
                    lv_type_7_0=ruleTypeSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_7_0,
                      							"com.minres.coredsl.CoreDsl.TypeSpecifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:1225:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalCoreDsl.g:1226:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:1226:5: (lv_name_8_0= RULE_ID )
                    // InternalCoreDsl.g:1227:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_8_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_8_0,
                      							"com.minres.coredsl.CoreDsl.ID");
                      					
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,44,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_1_2());
                      			
                    }
                    // InternalCoreDsl.g:1247:4: (this_ParameterList_10= ruleParameterList[$current] )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==63||(LA32_0>=100 && LA32_0<=110)||(LA32_0>=120 && LA32_0<=121)) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalCoreDsl.g:1248:5: this_ParameterList_10= ruleParameterList[$current]
                            {
                            if ( state.backtracking==0 ) {

                              					if (current==null) {
                              						current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                              					}
                              					newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParameterListParserRuleCall_1_3());
                              				
                            }
                            pushFollow(FOLLOW_40);
                            this_ParameterList_10=ruleParameterList(current);

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current = this_ParameterList_10;
                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,45,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_1_4());
                      			
                    }
                    // InternalCoreDsl.g:1264:4: ( (lv_statement_12_0= ruleCompoundStatement ) )
                    // InternalCoreDsl.g:1265:5: (lv_statement_12_0= ruleCompoundStatement )
                    {
                    // InternalCoreDsl.g:1265:5: (lv_statement_12_0= ruleCompoundStatement )
                    // InternalCoreDsl.g:1266:6: lv_statement_12_0= ruleCompoundStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getStatementCompoundStatementParserRuleCall_1_5_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_12_0=ruleCompoundStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_12_0,
                      							"com.minres.coredsl.CoreDsl.CompoundStatement");
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
    // $ANTLR end "ruleFunctionDefinition"


    // $ANTLR start "ruleParameterList"
    // InternalCoreDsl.g:1289:1: ruleParameterList[EObject in_current] returns [EObject current=in_current] : ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* ) ;
    public final EObject ruleParameterList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_params_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1295:2: ( ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* ) )
            // InternalCoreDsl.g:1296:2: ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* )
            {
            // InternalCoreDsl.g:1296:2: ( ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )* )
            // InternalCoreDsl.g:1297:3: ( (lv_params_0_0= ruleParameterDeclaration ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )*
            {
            // InternalCoreDsl.g:1297:3: ( (lv_params_0_0= ruleParameterDeclaration ) )
            // InternalCoreDsl.g:1298:4: (lv_params_0_0= ruleParameterDeclaration )
            {
            // InternalCoreDsl.g:1298:4: (lv_params_0_0= ruleParameterDeclaration )
            // InternalCoreDsl.g:1299:5: lv_params_0_0= ruleParameterDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListAccess().getParamsParameterDeclarationParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_41);
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

            // InternalCoreDsl.g:1316:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==35) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalCoreDsl.g:1317:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleParameterDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:1321:4: ( (lv_parameters_2_0= ruleParameterDeclaration ) )
            	    // InternalCoreDsl.g:1322:5: (lv_parameters_2_0= ruleParameterDeclaration )
            	    {
            	    // InternalCoreDsl.g:1322:5: (lv_parameters_2_0= ruleParameterDeclaration )
            	    // InternalCoreDsl.g:1323:6: lv_parameters_2_0= ruleParameterDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getParametersParameterDeclarationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_41);
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
            	    break loop34;
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
    // InternalCoreDsl.g:1345:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDeclaration = null;


        try {
            // InternalCoreDsl.g:1345:61: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // InternalCoreDsl.g:1346:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
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
    // InternalCoreDsl.g:1352:1: ruleParameterDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_declarator_1_0 = null;

        EObject lv_declarator_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1358:2: ( ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? ) )
            // InternalCoreDsl.g:1359:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? )
            {
            // InternalCoreDsl.g:1359:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )? )
            // InternalCoreDsl.g:1360:3: ( (lv_type_0_0= ruleTypeSpecifier ) ) ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )?
            {
            // InternalCoreDsl.g:1360:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:1361:4: (lv_type_0_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:1361:4: (lv_type_0_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:1362:5: lv_type_0_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterDeclarationAccess().getTypeTypeSpecifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_42);
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

            // InternalCoreDsl.g:1379:3: ( ( (lv_declarator_1_0= ruleDirectDeclarator ) ) | ( (lv_declarator_2_0= ruleAbstractDeclarator ) ) )?
            int alt35=3;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_LEFT_BR||LA35_0==44) ) {
                alt35=2;
            }
            switch (alt35) {
                case 1 :
                    // InternalCoreDsl.g:1380:4: ( (lv_declarator_1_0= ruleDirectDeclarator ) )
                    {
                    // InternalCoreDsl.g:1380:4: ( (lv_declarator_1_0= ruleDirectDeclarator ) )
                    // InternalCoreDsl.g:1381:5: (lv_declarator_1_0= ruleDirectDeclarator )
                    {
                    // InternalCoreDsl.g:1381:5: (lv_declarator_1_0= ruleDirectDeclarator )
                    // InternalCoreDsl.g:1382:6: lv_declarator_1_0= ruleDirectDeclarator
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
                    // InternalCoreDsl.g:1400:4: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )
                    {
                    // InternalCoreDsl.g:1400:4: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )
                    // InternalCoreDsl.g:1401:5: (lv_declarator_2_0= ruleAbstractDeclarator )
                    {
                    // InternalCoreDsl.g:1401:5: (lv_declarator_2_0= ruleAbstractDeclarator )
                    // InternalCoreDsl.g:1402:6: lv_declarator_2_0= ruleAbstractDeclarator
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
    // InternalCoreDsl.g:1424:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalCoreDsl.g:1424:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalCoreDsl.g:1425:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalCoreDsl.g:1431:1: ruleStatement returns [EObject current=null] : (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement | this_SpawnStatement_5= ruleSpawnStatement ) ;
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
            // InternalCoreDsl.g:1437:2: ( (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement | this_SpawnStatement_5= ruleSpawnStatement ) )
            // InternalCoreDsl.g:1438:2: (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement | this_SpawnStatement_5= ruleSpawnStatement )
            {
            // InternalCoreDsl.g:1438:2: (this_CompoundStatement_0= ruleCompoundStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | this_JumpStatement_4= ruleJumpStatement | this_SpawnStatement_5= ruleSpawnStatement )
            int alt36=6;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt36=1;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 38:
            case 44:
            case 58:
            case 59:
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
                alt36=2;
                }
                break;
            case 48:
            case 50:
                {
                alt36=3;
                }
                break;
            case 51:
            case 52:
            case 53:
                {
                alt36=4;
                }
                break;
            case 54:
            case 55:
            case 56:
                {
                alt36=5;
                }
                break;
            case 57:
                {
                alt36=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalCoreDsl.g:1439:3: this_CompoundStatement_0= ruleCompoundStatement
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
                    // InternalCoreDsl.g:1448:3: this_ExpressionStatement_1= ruleExpressionStatement
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
                    // InternalCoreDsl.g:1457:3: this_SelectionStatement_2= ruleSelectionStatement
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
                    // InternalCoreDsl.g:1466:3: this_IterationStatement_3= ruleIterationStatement
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
                    // InternalCoreDsl.g:1475:3: this_JumpStatement_4= ruleJumpStatement
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
                    // InternalCoreDsl.g:1484:3: this_SpawnStatement_5= ruleSpawnStatement
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
    // InternalCoreDsl.g:1496:1: entryRuleLabeledStatement returns [EObject current=null] : iv_ruleLabeledStatement= ruleLabeledStatement EOF ;
    public final EObject entryRuleLabeledStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabeledStatement = null;


        try {
            // InternalCoreDsl.g:1496:57: (iv_ruleLabeledStatement= ruleLabeledStatement EOF )
            // InternalCoreDsl.g:1497:2: iv_ruleLabeledStatement= ruleLabeledStatement EOF
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
    // InternalCoreDsl.g:1503:1: ruleLabeledStatement returns [EObject current=null] : ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) ) ;
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
            // InternalCoreDsl.g:1509:2: ( ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) ) )
            // InternalCoreDsl.g:1510:2: ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) )
            {
            // InternalCoreDsl.g:1510:2: ( (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) ) | (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==46) ) {
                alt37=1;
            }
            else if ( (LA37_0==47) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalCoreDsl.g:1511:3: (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:1511:3: (otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:1512:4: otherlv_0= 'case' ( (lv_constExpr_1_0= ruleConstantExpression ) ) otherlv_2= ':' ( (lv_stmt_3_0= ruleStatement ) )
                    {
                    otherlv_0=(Token)match(input,46,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getLabeledStatementAccess().getCaseKeyword_0_0());
                      			
                    }
                    // InternalCoreDsl.g:1516:4: ( (lv_constExpr_1_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:1517:5: (lv_constExpr_1_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:1517:5: (lv_constExpr_1_0= ruleConstantExpression )
                    // InternalCoreDsl.g:1518:6: lv_constExpr_1_0= ruleConstantExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLabeledStatementAccess().getConstExprConstantExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
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

                    otherlv_2=(Token)match(input,37,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getLabeledStatementAccess().getColonKeyword_0_2());
                      			
                    }
                    // InternalCoreDsl.g:1539:4: ( (lv_stmt_3_0= ruleStatement ) )
                    // InternalCoreDsl.g:1540:5: (lv_stmt_3_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1540:5: (lv_stmt_3_0= ruleStatement )
                    // InternalCoreDsl.g:1541:6: lv_stmt_3_0= ruleStatement
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
                    // InternalCoreDsl.g:1560:3: (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:1560:3: (otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:1561:4: otherlv_4= 'default' otherlv_5= ':' ( (lv_stmt_6_0= ruleStatement ) )
                    {
                    otherlv_4=(Token)match(input,47,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getLabeledStatementAccess().getDefaultKeyword_1_0());
                      			
                    }
                    otherlv_5=(Token)match(input,37,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getLabeledStatementAccess().getColonKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:1569:4: ( (lv_stmt_6_0= ruleStatement ) )
                    // InternalCoreDsl.g:1570:5: (lv_stmt_6_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1570:5: (lv_stmt_6_0= ruleStatement )
                    // InternalCoreDsl.g:1571:6: lv_stmt_6_0= ruleStatement
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
    // InternalCoreDsl.g:1593:1: entryRuleCompoundStatement returns [EObject current=null] : iv_ruleCompoundStatement= ruleCompoundStatement EOF ;
    public final EObject entryRuleCompoundStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundStatement = null;


        try {
            // InternalCoreDsl.g:1593:58: (iv_ruleCompoundStatement= ruleCompoundStatement EOF )
            // InternalCoreDsl.g:1594:2: iv_ruleCompoundStatement= ruleCompoundStatement EOF
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
    // InternalCoreDsl.g:1600:1: ruleCompoundStatement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' ) ;
    public final EObject ruleCompoundStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_items_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1606:2: ( ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' ) )
            // InternalCoreDsl.g:1607:2: ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' )
            {
            // InternalCoreDsl.g:1607:2: ( () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}' )
            // InternalCoreDsl.g:1608:3: () otherlv_1= '{' ( (lv_items_2_0= ruleBlockItem ) )* otherlv_3= '}'
            {
            // InternalCoreDsl.g:1608:3: ()
            // InternalCoreDsl.g:1609:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCompoundStatementAccess().getCompoundStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,26,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundStatementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalCoreDsl.g:1619:3: ( (lv_items_2_0= ruleBlockItem ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_ID)||LA38_0==RULE_LEFT_BR||(LA38_0>=RULE_INTEGER && LA38_0<=RULE_CHARCONST)||LA38_0==26||LA38_0==38||(LA38_0>=43 && LA38_0<=44)||LA38_0==48||(LA38_0>=50 && LA38_0<=59)||LA38_0==63||(LA38_0>=86 && LA38_0<=87)||(LA38_0>=90 && LA38_0<=94)||(LA38_0>=96 && LA38_0<=113)||(LA38_0>=120 && LA38_0<=121)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalCoreDsl.g:1620:4: (lv_items_2_0= ruleBlockItem )
            	    {
            	    // InternalCoreDsl.g:1620:4: (lv_items_2_0= ruleBlockItem )
            	    // InternalCoreDsl.g:1621:5: lv_items_2_0= ruleBlockItem
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundStatementAccess().getItemsBlockItemParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_44);
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
            	    break loop38;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:1646:1: entryRuleBlockItem returns [EObject current=null] : iv_ruleBlockItem= ruleBlockItem EOF ;
    public final EObject entryRuleBlockItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockItem = null;


        try {
            // InternalCoreDsl.g:1646:50: (iv_ruleBlockItem= ruleBlockItem EOF )
            // InternalCoreDsl.g:1647:2: iv_ruleBlockItem= ruleBlockItem EOF
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
    // InternalCoreDsl.g:1653:1: ruleBlockItem returns [EObject current=null] : (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration ) ;
    public final EObject ruleBlockItem() throws RecognitionException {
        EObject current = null;

        EObject this_Statement_0 = null;

        EObject this_Declaration_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1659:2: ( (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration ) )
            // InternalCoreDsl.g:1660:2: (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration )
            {
            // InternalCoreDsl.g:1660:2: (this_Statement_0= ruleStatement | this_Declaration_1= ruleDeclaration )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_ID)||(LA39_0>=RULE_INTEGER && LA39_0<=RULE_CHARCONST)||LA39_0==26||LA39_0==38||LA39_0==44||LA39_0==48||(LA39_0>=50 && LA39_0<=59)||(LA39_0>=86 && LA39_0<=87)||(LA39_0>=90 && LA39_0<=94)||(LA39_0>=96 && LA39_0<=99)) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_LEFT_BR||LA39_0==43||LA39_0==63||(LA39_0>=100 && LA39_0<=113)||(LA39_0>=120 && LA39_0<=121)) ) {
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
                    // InternalCoreDsl.g:1661:3: this_Statement_0= ruleStatement
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
                    // InternalCoreDsl.g:1670:3: this_Declaration_1= ruleDeclaration
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
    // InternalCoreDsl.g:1682:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalCoreDsl.g:1682:60: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalCoreDsl.g:1683:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
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
    // InternalCoreDsl.g:1689:1: ruleExpressionStatement returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1695:2: ( ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' ) )
            // InternalCoreDsl.g:1696:2: ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' )
            {
            // InternalCoreDsl.g:1696:2: ( () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';' )
            // InternalCoreDsl.g:1697:3: () ( (lv_expr_1_0= ruleAssignmentExpression ) )? otherlv_2= ';'
            {
            // InternalCoreDsl.g:1697:3: ()
            // InternalCoreDsl.g:1698:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExpressionStatementAccess().getExpressionStatementAction_0(),
              					current);
              			
            }

            }

            // InternalCoreDsl.g:1704:3: ( (lv_expr_1_0= ruleAssignmentExpression ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||(LA40_0>=RULE_INTEGER && LA40_0<=RULE_CHARCONST)||LA40_0==44||(LA40_0>=58 && LA40_0<=59)||(LA40_0>=86 && LA40_0<=87)||(LA40_0>=90 && LA40_0<=94)||(LA40_0>=96 && LA40_0<=99)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalCoreDsl.g:1705:4: (lv_expr_1_0= ruleAssignmentExpression )
                    {
                    // InternalCoreDsl.g:1705:4: (lv_expr_1_0= ruleAssignmentExpression )
                    // InternalCoreDsl.g:1706:5: lv_expr_1_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprAssignmentExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_29);
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
    // InternalCoreDsl.g:1731:1: entryRuleSelectionStatement returns [EObject current=null] : iv_ruleSelectionStatement= ruleSelectionStatement EOF ;
    public final EObject entryRuleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionStatement = null;


        try {
            // InternalCoreDsl.g:1731:59: (iv_ruleSelectionStatement= ruleSelectionStatement EOF )
            // InternalCoreDsl.g:1732:2: iv_ruleSelectionStatement= ruleSelectionStatement EOF
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
    // InternalCoreDsl.g:1738:1: ruleSelectionStatement returns [EObject current=null] : (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement ) ;
    public final EObject ruleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject this_IfStatement_0 = null;

        EObject this_SwitchStatement_1 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:1744:2: ( (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement ) )
            // InternalCoreDsl.g:1745:2: (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement )
            {
            // InternalCoreDsl.g:1745:2: (this_IfStatement_0= ruleIfStatement | this_SwitchStatement_1= ruleSwitchStatement )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==48) ) {
                alt41=1;
            }
            else if ( (LA41_0==50) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalCoreDsl.g:1746:3: this_IfStatement_0= ruleIfStatement
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
                    // InternalCoreDsl.g:1755:3: this_SwitchStatement_1= ruleSwitchStatement
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
    // InternalCoreDsl.g:1767:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalCoreDsl.g:1767:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalCoreDsl.g:1768:2: iv_ruleIfStatement= ruleIfStatement EOF
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
    // InternalCoreDsl.g:1774:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? ) ;
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
            // InternalCoreDsl.g:1780:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? ) )
            // InternalCoreDsl.g:1781:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? )
            {
            // InternalCoreDsl.g:1781:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )? )
            // InternalCoreDsl.g:1782:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_thenStmt_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,44,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalCoreDsl.g:1790:3: ( (lv_cond_2_0= ruleConditionalExpression ) )
            // InternalCoreDsl.g:1791:4: (lv_cond_2_0= ruleConditionalExpression )
            {
            // InternalCoreDsl.g:1791:4: (lv_cond_2_0= ruleConditionalExpression )
            // InternalCoreDsl.g:1792:5: lv_cond_2_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getCondConditionalExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_40);
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

            otherlv_3=(Token)match(input,45,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalCoreDsl.g:1813:3: ( (lv_thenStmt_4_0= ruleStatement ) )
            // InternalCoreDsl.g:1814:4: (lv_thenStmt_4_0= ruleStatement )
            {
            // InternalCoreDsl.g:1814:4: (lv_thenStmt_4_0= ruleStatement )
            // InternalCoreDsl.g:1815:5: lv_thenStmt_4_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getThenStmtStatementParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_45);
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

            // InternalCoreDsl.g:1832:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==49) ) {
                int LA42_1 = input.LA(2);

                if ( (synpred1_InternalCoreDsl()) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalCoreDsl.g:1833:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseStmt_6_0= ruleStatement ) )
                    {
                    // InternalCoreDsl.g:1833:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalCoreDsl.g:1834:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,49,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfStatementAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalCoreDsl.g:1840:4: ( (lv_elseStmt_6_0= ruleStatement ) )
                    // InternalCoreDsl.g:1841:5: (lv_elseStmt_6_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1841:5: (lv_elseStmt_6_0= ruleStatement )
                    // InternalCoreDsl.g:1842:6: lv_elseStmt_6_0= ruleStatement
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
    // InternalCoreDsl.g:1864:1: entryRuleSwitchStatement returns [EObject current=null] : iv_ruleSwitchStatement= ruleSwitchStatement EOF ;
    public final EObject entryRuleSwitchStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStatement = null;


        try {
            // InternalCoreDsl.g:1864:56: (iv_ruleSwitchStatement= ruleSwitchStatement EOF )
            // InternalCoreDsl.g:1865:2: iv_ruleSwitchStatement= ruleSwitchStatement EOF
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
    // InternalCoreDsl.g:1871:1: ruleSwitchStatement returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' ) ;
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
            // InternalCoreDsl.g:1877:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' ) )
            // InternalCoreDsl.g:1878:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' )
            {
            // InternalCoreDsl.g:1878:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}' )
            // InternalCoreDsl.g:1879:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_items_5_0= ruleLabeledStatement ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatementAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,44,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalCoreDsl.g:1887:3: ( (lv_cond_2_0= ruleConditionalExpression ) )
            // InternalCoreDsl.g:1888:4: (lv_cond_2_0= ruleConditionalExpression )
            {
            // InternalCoreDsl.g:1888:4: (lv_cond_2_0= ruleConditionalExpression )
            // InternalCoreDsl.g:1889:5: lv_cond_2_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatementAccess().getCondConditionalExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_40);
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

            otherlv_3=(Token)match(input,45,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,26,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatementAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalCoreDsl.g:1914:3: ( (lv_items_5_0= ruleLabeledStatement ) )
            // InternalCoreDsl.g:1915:4: (lv_items_5_0= ruleLabeledStatement )
            {
            // InternalCoreDsl.g:1915:4: (lv_items_5_0= ruleLabeledStatement )
            // InternalCoreDsl.g:1916:5: lv_items_5_0= ruleLabeledStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatementAccess().getItemsLabeledStatementParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_17);
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

            otherlv_6=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:1941:1: entryRuleIterationStatement returns [EObject current=null] : iv_ruleIterationStatement= ruleIterationStatement EOF ;
    public final EObject entryRuleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationStatement = null;


        try {
            // InternalCoreDsl.g:1941:59: (iv_ruleIterationStatement= ruleIterationStatement EOF )
            // InternalCoreDsl.g:1942:2: iv_ruleIterationStatement= ruleIterationStatement EOF
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
    // InternalCoreDsl.g:1948:1: ruleIterationStatement returns [EObject current=null] : ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) ) ;
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
            // InternalCoreDsl.g:1954:2: ( ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) ) )
            // InternalCoreDsl.g:1955:2: ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) )
            {
            // InternalCoreDsl.g:1955:2: ( ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) ) | ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' ) | ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) ) )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt43=1;
                }
                break;
            case 52:
                {
                alt43=2;
                }
                break;
            case 53:
                {
                alt43=3;
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
                    // InternalCoreDsl.g:1956:3: ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:1956:3: ( ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:1957:4: ( (lv_type_0_0= 'while' ) ) otherlv_1= '(' ( (lv_cond_2_0= ruleConditionalExpression ) ) otherlv_3= ')' ( (lv_stmt_4_0= ruleStatement ) )
                    {
                    // InternalCoreDsl.g:1957:4: ( (lv_type_0_0= 'while' ) )
                    // InternalCoreDsl.g:1958:5: (lv_type_0_0= 'while' )
                    {
                    // InternalCoreDsl.g:1958:5: (lv_type_0_0= 'while' )
                    // InternalCoreDsl.g:1959:6: lv_type_0_0= 'while'
                    {
                    lv_type_0_0=(Token)match(input,51,FOLLOW_38); if (state.failed) return current;
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

                    otherlv_1=(Token)match(input,44,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getIterationStatementAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalCoreDsl.g:1975:4: ( (lv_cond_2_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:1976:5: (lv_cond_2_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:1976:5: (lv_cond_2_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:1977:6: lv_cond_2_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getCondConditionalExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
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

                    otherlv_3=(Token)match(input,45,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getIterationStatementAccess().getRightParenthesisKeyword_0_3());
                      			
                    }
                    // InternalCoreDsl.g:1998:4: ( (lv_stmt_4_0= ruleStatement ) )
                    // InternalCoreDsl.g:1999:5: (lv_stmt_4_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:1999:5: (lv_stmt_4_0= ruleStatement )
                    // InternalCoreDsl.g:2000:6: lv_stmt_4_0= ruleStatement
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
                    // InternalCoreDsl.g:2019:3: ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' )
                    {
                    // InternalCoreDsl.g:2019:3: ( ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';' )
                    // InternalCoreDsl.g:2020:4: ( (lv_type_5_0= 'do' ) ) ( (lv_stmt_6_0= ruleStatement ) ) otherlv_7= 'while' otherlv_8= '(' ( (lv_cond_9_0= ruleConditionalExpression ) ) otherlv_10= ')' otherlv_11= ';'
                    {
                    // InternalCoreDsl.g:2020:4: ( (lv_type_5_0= 'do' ) )
                    // InternalCoreDsl.g:2021:5: (lv_type_5_0= 'do' )
                    {
                    // InternalCoreDsl.g:2021:5: (lv_type_5_0= 'do' )
                    // InternalCoreDsl.g:2022:6: lv_type_5_0= 'do'
                    {
                    lv_type_5_0=(Token)match(input,52,FOLLOW_32); if (state.failed) return current;
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

                    // InternalCoreDsl.g:2034:4: ( (lv_stmt_6_0= ruleStatement ) )
                    // InternalCoreDsl.g:2035:5: (lv_stmt_6_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:2035:5: (lv_stmt_6_0= ruleStatement )
                    // InternalCoreDsl.g:2036:6: lv_stmt_6_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getStmtStatementParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_47);
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

                    otherlv_7=(Token)match(input,51,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getIterationStatementAccess().getWhileKeyword_1_2());
                      			
                    }
                    otherlv_8=(Token)match(input,44,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getIterationStatementAccess().getLeftParenthesisKeyword_1_3());
                      			
                    }
                    // InternalCoreDsl.g:2061:4: ( (lv_cond_9_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:2062:5: (lv_cond_9_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:2062:5: (lv_cond_9_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:2063:6: lv_cond_9_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIterationStatementAccess().getCondConditionalExpressionParserRuleCall_1_4_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
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

                    otherlv_10=(Token)match(input,45,FOLLOW_29); if (state.failed) return current;
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
                    // InternalCoreDsl.g:2090:3: ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) )
                    {
                    // InternalCoreDsl.g:2090:3: ( ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) ) )
                    // InternalCoreDsl.g:2091:4: ( (lv_type_12_0= 'for' ) ) otherlv_13= '(' this_ForCondition_14= ruleForCondition[$current] otherlv_15= ')' ( (lv_stmt_16_0= ruleStatement ) )
                    {
                    // InternalCoreDsl.g:2091:4: ( (lv_type_12_0= 'for' ) )
                    // InternalCoreDsl.g:2092:5: (lv_type_12_0= 'for' )
                    {
                    // InternalCoreDsl.g:2092:5: (lv_type_12_0= 'for' )
                    // InternalCoreDsl.g:2093:6: lv_type_12_0= 'for'
                    {
                    lv_type_12_0=(Token)match(input,53,FOLLOW_38); if (state.failed) return current;
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

                    otherlv_13=(Token)match(input,44,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getIterationStatementAccess().getLeftParenthesisKeyword_2_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getIterationStatementRule());
                      				}
                      				newCompositeNode(grammarAccess.getIterationStatementAccess().getForConditionParserRuleCall_2_2());
                      			
                    }
                    pushFollow(FOLLOW_40);
                    this_ForCondition_14=ruleForCondition(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ForCondition_14;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_15=(Token)match(input,45,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getIterationStatementAccess().getRightParenthesisKeyword_2_3());
                      			
                    }
                    // InternalCoreDsl.g:2124:4: ( (lv_stmt_16_0= ruleStatement ) )
                    // InternalCoreDsl.g:2125:5: (lv_stmt_16_0= ruleStatement )
                    {
                    // InternalCoreDsl.g:2125:5: (lv_stmt_16_0= ruleStatement )
                    // InternalCoreDsl.g:2126:6: lv_stmt_16_0= ruleStatement
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
    // InternalCoreDsl.g:2149:1: ruleForCondition[EObject in_current] returns [EObject current=in_current] : ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? ) ;
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
            // InternalCoreDsl.g:2155:2: ( ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? ) )
            // InternalCoreDsl.g:2156:2: ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? )
            {
            // InternalCoreDsl.g:2156:2: ( ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )? )
            // InternalCoreDsl.g:2157:3: ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) ) ( (lv_endExpr_3_0= ruleConditionalExpression ) )? otherlv_4= ';' ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )?
            {
            // InternalCoreDsl.g:2157:3: ( ( (lv_startDecl_0_0= ruleDeclaration ) ) | ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_LEFT_BR||LA45_0==43||LA45_0==63||(LA45_0>=100 && LA45_0<=113)||(LA45_0>=120 && LA45_0<=121)) ) {
                alt45=1;
            }
            else if ( ((LA45_0>=RULE_STRING && LA45_0<=RULE_ID)||(LA45_0>=RULE_INTEGER && LA45_0<=RULE_CHARCONST)||LA45_0==38||LA45_0==44||(LA45_0>=58 && LA45_0<=59)||(LA45_0>=86 && LA45_0<=87)||(LA45_0>=90 && LA45_0<=94)||(LA45_0>=96 && LA45_0<=99)) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalCoreDsl.g:2158:4: ( (lv_startDecl_0_0= ruleDeclaration ) )
                    {
                    // InternalCoreDsl.g:2158:4: ( (lv_startDecl_0_0= ruleDeclaration ) )
                    // InternalCoreDsl.g:2159:5: (lv_startDecl_0_0= ruleDeclaration )
                    {
                    // InternalCoreDsl.g:2159:5: (lv_startDecl_0_0= ruleDeclaration )
                    // InternalCoreDsl.g:2160:6: lv_startDecl_0_0= ruleDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getForConditionAccess().getStartDeclDeclarationParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_49);
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
                    // InternalCoreDsl.g:2178:4: ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' )
                    {
                    // InternalCoreDsl.g:2178:4: ( ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';' )
                    // InternalCoreDsl.g:2179:5: ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )? otherlv_2= ';'
                    {
                    // InternalCoreDsl.g:2179:5: ( (lv_startExpr_1_0= ruleAssignmentExpression2 ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_ID)||(LA44_0>=RULE_INTEGER && LA44_0<=RULE_CHARCONST)||LA44_0==44||(LA44_0>=58 && LA44_0<=59)||(LA44_0>=86 && LA44_0<=87)||(LA44_0>=90 && LA44_0<=94)||(LA44_0>=96 && LA44_0<=99)) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalCoreDsl.g:2180:6: (lv_startExpr_1_0= ruleAssignmentExpression2 )
                            {
                            // InternalCoreDsl.g:2180:6: (lv_startExpr_1_0= ruleAssignmentExpression2 )
                            // InternalCoreDsl.g:2181:7: lv_startExpr_1_0= ruleAssignmentExpression2
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getForConditionAccess().getStartExprAssignmentExpression2ParserRuleCall_0_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_29);
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

                    otherlv_2=(Token)match(input,38,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getForConditionAccess().getSemicolonKeyword_0_1_1());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:2204:3: ( (lv_endExpr_3_0= ruleConditionalExpression ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_ID)||(LA46_0>=RULE_INTEGER && LA46_0<=RULE_CHARCONST)||LA46_0==44||(LA46_0>=58 && LA46_0<=59)||(LA46_0>=86 && LA46_0<=87)||(LA46_0>=90 && LA46_0<=94)||(LA46_0>=96 && LA46_0<=99)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalCoreDsl.g:2205:4: (lv_endExpr_3_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:2205:4: (lv_endExpr_3_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:2206:5: lv_endExpr_3_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getForConditionAccess().getEndExprConditionalExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_29);
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

            otherlv_4=(Token)match(input,38,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getForConditionAccess().getSemicolonKeyword_2());
              		
            }
            // InternalCoreDsl.g:2227:3: ( ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=RULE_STRING && LA48_0<=RULE_ID)||(LA48_0>=RULE_INTEGER && LA48_0<=RULE_CHARCONST)||LA48_0==44||(LA48_0>=58 && LA48_0<=59)||(LA48_0>=86 && LA48_0<=87)||(LA48_0>=90 && LA48_0<=94)||(LA48_0>=96 && LA48_0<=99)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalCoreDsl.g:2228:4: ( (lv_loopExprs_5_0= ruleAssignmentExpression ) ) (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )*
                    {
                    // InternalCoreDsl.g:2228:4: ( (lv_loopExprs_5_0= ruleAssignmentExpression ) )
                    // InternalCoreDsl.g:2229:5: (lv_loopExprs_5_0= ruleAssignmentExpression )
                    {
                    // InternalCoreDsl.g:2229:5: (lv_loopExprs_5_0= ruleAssignmentExpression )
                    // InternalCoreDsl.g:2230:6: lv_loopExprs_5_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getForConditionAccess().getLoopExprsAssignmentExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_41);
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

                    // InternalCoreDsl.g:2247:4: (otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==35) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2248:5: otherlv_6= ',' ( (lv_loopExprs_7_0= ruleAssignmentExpression ) )
                    	    {
                    	    otherlv_6=(Token)match(input,35,FOLLOW_43); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getForConditionAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2252:5: ( (lv_loopExprs_7_0= ruleAssignmentExpression ) )
                    	    // InternalCoreDsl.g:2253:6: (lv_loopExprs_7_0= ruleAssignmentExpression )
                    	    {
                    	    // InternalCoreDsl.g:2253:6: (lv_loopExprs_7_0= ruleAssignmentExpression )
                    	    // InternalCoreDsl.g:2254:7: lv_loopExprs_7_0= ruleAssignmentExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getForConditionAccess().getLoopExprsAssignmentExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_41);
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
                    	    break loop47;
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
    // InternalCoreDsl.g:2277:1: entryRuleJumpStatement returns [EObject current=null] : iv_ruleJumpStatement= ruleJumpStatement EOF ;
    public final EObject entryRuleJumpStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJumpStatement = null;


        try {
            // InternalCoreDsl.g:2277:54: (iv_ruleJumpStatement= ruleJumpStatement EOF )
            // InternalCoreDsl.g:2278:2: iv_ruleJumpStatement= ruleJumpStatement EOF
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
    // InternalCoreDsl.g:2284:1: ruleJumpStatement returns [EObject current=null] : ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) ) ;
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
            // InternalCoreDsl.g:2290:2: ( ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) ) )
            // InternalCoreDsl.g:2291:2: ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) )
            {
            // InternalCoreDsl.g:2291:2: ( ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' ) | ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' ) | ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' ) )
            int alt50=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt50=1;
                }
                break;
            case 55:
                {
                alt50=2;
                }
                break;
            case 56:
                {
                alt50=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalCoreDsl.g:2292:3: ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' )
                    {
                    // InternalCoreDsl.g:2292:3: ( ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';' )
                    // InternalCoreDsl.g:2293:4: ( (lv_type_0_0= 'continue' ) ) otherlv_1= ';'
                    {
                    // InternalCoreDsl.g:2293:4: ( (lv_type_0_0= 'continue' ) )
                    // InternalCoreDsl.g:2294:5: (lv_type_0_0= 'continue' )
                    {
                    // InternalCoreDsl.g:2294:5: (lv_type_0_0= 'continue' )
                    // InternalCoreDsl.g:2295:6: lv_type_0_0= 'continue'
                    {
                    lv_type_0_0=(Token)match(input,54,FOLLOW_29); if (state.failed) return current;
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
                    // InternalCoreDsl.g:2313:3: ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' )
                    {
                    // InternalCoreDsl.g:2313:3: ( ( (lv_type_2_0= 'break' ) ) otherlv_3= ';' )
                    // InternalCoreDsl.g:2314:4: ( (lv_type_2_0= 'break' ) ) otherlv_3= ';'
                    {
                    // InternalCoreDsl.g:2314:4: ( (lv_type_2_0= 'break' ) )
                    // InternalCoreDsl.g:2315:5: (lv_type_2_0= 'break' )
                    {
                    // InternalCoreDsl.g:2315:5: (lv_type_2_0= 'break' )
                    // InternalCoreDsl.g:2316:6: lv_type_2_0= 'break'
                    {
                    lv_type_2_0=(Token)match(input,55,FOLLOW_29); if (state.failed) return current;
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
                    // InternalCoreDsl.g:2334:3: ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' )
                    {
                    // InternalCoreDsl.g:2334:3: ( ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';' )
                    // InternalCoreDsl.g:2335:4: ( (lv_type_4_0= 'return' ) ) ( (lv_expr_5_0= ruleConditionalExpression ) )? otherlv_6= ';'
                    {
                    // InternalCoreDsl.g:2335:4: ( (lv_type_4_0= 'return' ) )
                    // InternalCoreDsl.g:2336:5: (lv_type_4_0= 'return' )
                    {
                    // InternalCoreDsl.g:2336:5: (lv_type_4_0= 'return' )
                    // InternalCoreDsl.g:2337:6: lv_type_4_0= 'return'
                    {
                    lv_type_4_0=(Token)match(input,56,FOLLOW_49); if (state.failed) return current;
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

                    // InternalCoreDsl.g:2349:4: ( (lv_expr_5_0= ruleConditionalExpression ) )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( ((LA49_0>=RULE_STRING && LA49_0<=RULE_ID)||(LA49_0>=RULE_INTEGER && LA49_0<=RULE_CHARCONST)||LA49_0==44||(LA49_0>=58 && LA49_0<=59)||(LA49_0>=86 && LA49_0<=87)||(LA49_0>=90 && LA49_0<=94)||(LA49_0>=96 && LA49_0<=99)) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalCoreDsl.g:2350:5: (lv_expr_5_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:2350:5: (lv_expr_5_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:2351:6: lv_expr_5_0= ruleConditionalExpression
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getJumpStatementAccess().getExprConditionalExpressionParserRuleCall_2_1_0());
                              					
                            }
                            pushFollow(FOLLOW_29);
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


    // $ANTLR start "entryRuleSpawnStatement"
    // InternalCoreDsl.g:2377:1: entryRuleSpawnStatement returns [EObject current=null] : iv_ruleSpawnStatement= ruleSpawnStatement EOF ;
    public final EObject entryRuleSpawnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpawnStatement = null;


        try {
            // InternalCoreDsl.g:2377:55: (iv_ruleSpawnStatement= ruleSpawnStatement EOF )
            // InternalCoreDsl.g:2378:2: iv_ruleSpawnStatement= ruleSpawnStatement EOF
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
    // InternalCoreDsl.g:2384:1: ruleSpawnStatement returns [EObject current=null] : (otherlv_0= 'spawn' ( (lv_stmt_1_0= ruleStatement ) ) ) ;
    public final EObject ruleSpawnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_stmt_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2390:2: ( (otherlv_0= 'spawn' ( (lv_stmt_1_0= ruleStatement ) ) ) )
            // InternalCoreDsl.g:2391:2: (otherlv_0= 'spawn' ( (lv_stmt_1_0= ruleStatement ) ) )
            {
            // InternalCoreDsl.g:2391:2: (otherlv_0= 'spawn' ( (lv_stmt_1_0= ruleStatement ) ) )
            // InternalCoreDsl.g:2392:3: otherlv_0= 'spawn' ( (lv_stmt_1_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSpawnStatementAccess().getSpawnKeyword_0());
              		
            }
            // InternalCoreDsl.g:2396:3: ( (lv_stmt_1_0= ruleStatement ) )
            // InternalCoreDsl.g:2397:4: (lv_stmt_1_0= ruleStatement )
            {
            // InternalCoreDsl.g:2397:4: (lv_stmt_1_0= ruleStatement )
            // InternalCoreDsl.g:2398:5: lv_stmt_1_0= ruleStatement
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
    // InternalCoreDsl.g:2419:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalCoreDsl.g:2419:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalCoreDsl.g:2420:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalCoreDsl.g:2426:1: ruleDeclaration returns [EObject current=null] : ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( ( (lv_ptr_3_1= '*' | lv_ptr_3_2= '&' ) ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_ptr_3_1=null;
        Token lv_ptr_3_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject this_DeclarationSpecifier_0 = null;

        EObject lv_type_1_0 = null;

        EObject lv_size_2_0 = null;

        EObject lv_init_4_0 = null;

        EObject lv_init_6_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2432:2: ( ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( ( (lv_ptr_3_1= '*' | lv_ptr_3_2= '&' ) ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' ) )
            // InternalCoreDsl.g:2433:2: ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( ( (lv_ptr_3_1= '*' | lv_ptr_3_2= '&' ) ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' )
            {
            // InternalCoreDsl.g:2433:2: ( (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( ( (lv_ptr_3_1= '*' | lv_ptr_3_2= '&' ) ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';' )
            // InternalCoreDsl.g:2434:3: (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )* ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_size_2_0= ruleBitSizeSpecifier ) )? ( ( (lv_ptr_3_1= '*' | lv_ptr_3_2= '&' ) ) )? ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )? otherlv_7= ';'
            {
            // InternalCoreDsl.g:2434:3: (this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current] )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_LEFT_BR||LA51_0==43||(LA51_0>=111 && LA51_0<=113)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalCoreDsl.g:2435:4: this_DeclarationSpecifier_0= ruleDeclarationSpecifier[$current]
            	    {
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElement(grammarAccess.getDeclarationRule());
            	      				}
            	      				newCompositeNode(grammarAccess.getDeclarationAccess().getDeclarationSpecifierParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_10);
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
            	    break loop51;
                }
            } while (true);

            // InternalCoreDsl.g:2447:3: ( (lv_type_1_0= ruleTypeSpecifier ) )
            // InternalCoreDsl.g:2448:4: (lv_type_1_0= ruleTypeSpecifier )
            {
            // InternalCoreDsl.g:2448:4: (lv_type_1_0= ruleTypeSpecifier )
            // InternalCoreDsl.g:2449:5: lv_type_1_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeSpecifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_51);
            lv_type_1_0=ruleTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeclarationRule());
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

            // InternalCoreDsl.g:2466:3: ( (lv_size_2_0= ruleBitSizeSpecifier ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==61) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalCoreDsl.g:2467:4: (lv_size_2_0= ruleBitSizeSpecifier )
                    {
                    // InternalCoreDsl.g:2467:4: (lv_size_2_0= ruleBitSizeSpecifier )
                    // InternalCoreDsl.g:2468:5: lv_size_2_0= ruleBitSizeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDeclarationAccess().getSizeBitSizeSpecifierParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_52);
                    lv_size_2_0=ruleBitSizeSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDeclarationRule());
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

            // InternalCoreDsl.g:2485:3: ( ( (lv_ptr_3_1= '*' | lv_ptr_3_2= '&' ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=58 && LA54_0<=59)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalCoreDsl.g:2486:4: ( (lv_ptr_3_1= '*' | lv_ptr_3_2= '&' ) )
                    {
                    // InternalCoreDsl.g:2486:4: ( (lv_ptr_3_1= '*' | lv_ptr_3_2= '&' ) )
                    // InternalCoreDsl.g:2487:5: (lv_ptr_3_1= '*' | lv_ptr_3_2= '&' )
                    {
                    // InternalCoreDsl.g:2487:5: (lv_ptr_3_1= '*' | lv_ptr_3_2= '&' )
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==58) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==59) ) {
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
                            // InternalCoreDsl.g:2488:6: lv_ptr_3_1= '*'
                            {
                            lv_ptr_3_1=(Token)match(input,58,FOLLOW_53); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_ptr_3_1, grammarAccess.getDeclarationAccess().getPtrAsteriskKeyword_3_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getDeclarationRule());
                              						}
                              						setWithLastConsumed(current, "ptr", lv_ptr_3_1, null);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:2499:6: lv_ptr_3_2= '&'
                            {
                            lv_ptr_3_2=(Token)match(input,59,FOLLOW_53); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_ptr_3_2, grammarAccess.getDeclarationAccess().getPtrAmpersandKeyword_3_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getDeclarationRule());
                              						}
                              						setWithLastConsumed(current, "ptr", lv_ptr_3_2, null);
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalCoreDsl.g:2512:3: ( ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalCoreDsl.g:2513:4: ( (lv_init_4_0= ruleInitDeclarator ) ) (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )*
                    {
                    // InternalCoreDsl.g:2513:4: ( (lv_init_4_0= ruleInitDeclarator ) )
                    // InternalCoreDsl.g:2514:5: (lv_init_4_0= ruleInitDeclarator )
                    {
                    // InternalCoreDsl.g:2514:5: (lv_init_4_0= ruleInitDeclarator )
                    // InternalCoreDsl.g:2515:6: lv_init_4_0= ruleInitDeclarator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeclarationAccess().getInitInitDeclaratorParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_54);
                    lv_init_4_0=ruleInitDeclarator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDeclarationRule());
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

                    // InternalCoreDsl.g:2532:4: (otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==35) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalCoreDsl.g:2533:5: otherlv_5= ',' ( (lv_init_6_0= ruleInitDeclarator ) )
                    	    {
                    	    otherlv_5=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getDeclarationAccess().getCommaKeyword_4_1_0());
                    	      				
                    	    }
                    	    // InternalCoreDsl.g:2537:5: ( (lv_init_6_0= ruleInitDeclarator ) )
                    	    // InternalCoreDsl.g:2538:6: (lv_init_6_0= ruleInitDeclarator )
                    	    {
                    	    // InternalCoreDsl.g:2538:6: (lv_init_6_0= ruleInitDeclarator )
                    	    // InternalCoreDsl.g:2539:7: lv_init_6_0= ruleInitDeclarator
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getDeclarationAccess().getInitInitDeclaratorParserRuleCall_4_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_54);
                    	    lv_init_6_0=ruleInitDeclarator();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getDeclarationRule());
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
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getDeclarationAccess().getSemicolonKeyword_5());
              		
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "ruleDeclarationSpecifier"
    // InternalCoreDsl.g:2567:1: ruleDeclarationSpecifier[EObject in_current] returns [EObject current=in_current] : ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | ( (lv_attrs_2_0= ruleAttribute ) ) ) ;
    public final EObject ruleDeclarationSpecifier(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Enumerator lv_storage_0_0 = null;

        Enumerator lv_qualifiers_1_0 = null;

        EObject lv_attrs_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2573:2: ( ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | ( (lv_attrs_2_0= ruleAttribute ) ) ) )
            // InternalCoreDsl.g:2574:2: ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | ( (lv_attrs_2_0= ruleAttribute ) ) )
            {
            // InternalCoreDsl.g:2574:2: ( ( (lv_storage_0_0= ruleStorageClassSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) | ( (lv_attrs_2_0= ruleAttribute ) ) )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 43:
            case 113:
                {
                alt57=1;
                }
                break;
            case 111:
            case 112:
                {
                alt57=2;
                }
                break;
            case RULE_LEFT_BR:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalCoreDsl.g:2575:3: ( (lv_storage_0_0= ruleStorageClassSpecifier ) )
                    {
                    // InternalCoreDsl.g:2575:3: ( (lv_storage_0_0= ruleStorageClassSpecifier ) )
                    // InternalCoreDsl.g:2576:4: (lv_storage_0_0= ruleStorageClassSpecifier )
                    {
                    // InternalCoreDsl.g:2576:4: (lv_storage_0_0= ruleStorageClassSpecifier )
                    // InternalCoreDsl.g:2577:5: lv_storage_0_0= ruleStorageClassSpecifier
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
                    // InternalCoreDsl.g:2595:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    {
                    // InternalCoreDsl.g:2595:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    // InternalCoreDsl.g:2596:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    {
                    // InternalCoreDsl.g:2596:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    // InternalCoreDsl.g:2597:5: lv_qualifiers_1_0= ruleTypeQualifier
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
                    // InternalCoreDsl.g:2615:3: ( (lv_attrs_2_0= ruleAttribute ) )
                    {
                    // InternalCoreDsl.g:2615:3: ( (lv_attrs_2_0= ruleAttribute ) )
                    // InternalCoreDsl.g:2616:4: (lv_attrs_2_0= ruleAttribute )
                    {
                    // InternalCoreDsl.g:2616:4: (lv_attrs_2_0= ruleAttribute )
                    // InternalCoreDsl.g:2617:5: lv_attrs_2_0= ruleAttribute
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDeclarationSpecifierAccess().getAttrsAttributeParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_attrs_2_0=ruleAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDeclarationSpecifierRule());
                      					}
                      					add(
                      						current,
                      						"attrs",
                      						lv_attrs_2_0,
                      						"com.minres.coredsl.CoreDsl.Attribute");
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
    // $ANTLR end "ruleDeclarationSpecifier"


    // $ANTLR start "entryRuleAttribute"
    // InternalCoreDsl.g:2638:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalCoreDsl.g:2638:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalCoreDsl.g:2639:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalCoreDsl.g:2645:1: ruleAttribute returns [EObject current=null] : ( ruleDoubleLeftBracket ( (lv_type_1_0= ruleDeclarationAttribute ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConditionalExpression ) ) )? ruleDoubleRightBracket ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2651:2: ( ( ruleDoubleLeftBracket ( (lv_type_1_0= ruleDeclarationAttribute ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConditionalExpression ) ) )? ruleDoubleRightBracket ) )
            // InternalCoreDsl.g:2652:2: ( ruleDoubleLeftBracket ( (lv_type_1_0= ruleDeclarationAttribute ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConditionalExpression ) ) )? ruleDoubleRightBracket )
            {
            // InternalCoreDsl.g:2652:2: ( ruleDoubleLeftBracket ( (lv_type_1_0= ruleDeclarationAttribute ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConditionalExpression ) ) )? ruleDoubleRightBracket )
            // InternalCoreDsl.g:2653:3: ruleDoubleLeftBracket ( (lv_type_1_0= ruleDeclarationAttribute ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConditionalExpression ) ) )? ruleDoubleRightBracket
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAttributeAccess().getDoubleLeftBracketParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_55);
            ruleDoubleLeftBracket();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:2660:3: ( (lv_type_1_0= ruleDeclarationAttribute ) )
            // InternalCoreDsl.g:2661:4: (lv_type_1_0= ruleDeclarationAttribute )
            {
            // InternalCoreDsl.g:2661:4: (lv_type_1_0= ruleDeclarationAttribute )
            // InternalCoreDsl.g:2662:5: lv_type_1_0= ruleDeclarationAttribute
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeAccess().getTypeDeclarationAttributeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_56);
            lv_type_1_0=ruleDeclarationAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"com.minres.coredsl.CoreDsl.DeclarationAttribute");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:2679:3: (otherlv_2= '=' ( (lv_value_3_0= ruleConditionalExpression ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==60) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalCoreDsl.g:2680:4: otherlv_2= '=' ( (lv_value_3_0= ruleConditionalExpression ) )
                    {
                    otherlv_2=(Token)match(input,60,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalCoreDsl.g:2684:4: ( (lv_value_3_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:2685:5: (lv_value_3_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:2685:5: (lv_value_3_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:2686:6: lv_value_3_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAttributeAccess().getValueConditionalExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
                    lv_value_3_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAttributeRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"com.minres.coredsl.CoreDsl.ConditionalExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAttributeAccess().getDoubleRightBracketParserRuleCall_3());
              		
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleTypeSpecifier"
    // InternalCoreDsl.g:2715:1: entryRuleTypeSpecifier returns [EObject current=null] : iv_ruleTypeSpecifier= ruleTypeSpecifier EOF ;
    public final EObject entryRuleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSpecifier = null;


        try {
            // InternalCoreDsl.g:2715:54: (iv_ruleTypeSpecifier= ruleTypeSpecifier EOF )
            // InternalCoreDsl.g:2716:2: iv_ruleTypeSpecifier= ruleTypeSpecifier EOF
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
    // InternalCoreDsl.g:2722:1: ruleTypeSpecifier returns [EObject current=null] : (this_PodSpecifier_0= rulePodSpecifier | this_StructOrUnionSpecifier_1= ruleStructOrUnionSpecifier | this_EnumSpecifier_2= ruleEnumSpecifier ) ;
    public final EObject ruleTypeSpecifier() throws RecognitionException {
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
            int alt59=3;
            switch ( input.LA(1) ) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
                {
                alt59=1;
                }
                break;
            case 120:
            case 121:
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
                    // InternalCoreDsl.g:2730:3: this_PodSpecifier_0= rulePodSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeSpecifierAccess().getPodSpecifierParserRuleCall_0());
                      		
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

                      			newCompositeNode(grammarAccess.getTypeSpecifierAccess().getStructOrUnionSpecifierParserRuleCall_1());
                      		
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

                      			newCompositeNode(grammarAccess.getTypeSpecifierAccess().getEnumSpecifierParserRuleCall_2());
                      		
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
    // $ANTLR end "ruleTypeSpecifier"


    // $ANTLR start "entryRulePodSpecifier"
    // InternalCoreDsl.g:2760:1: entryRulePodSpecifier returns [EObject current=null] : iv_rulePodSpecifier= rulePodSpecifier EOF ;
    public final EObject entryRulePodSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePodSpecifier = null;


        try {
            // InternalCoreDsl.g:2760:53: (iv_rulePodSpecifier= rulePodSpecifier EOF )
            // InternalCoreDsl.g:2761:2: iv_rulePodSpecifier= rulePodSpecifier EOF
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
    // InternalCoreDsl.g:2767:1: rulePodSpecifier returns [EObject current=null] : ( (lv_dataType_0_0= ruleDataTypes ) )+ ;
    public final EObject rulePodSpecifier() throws RecognitionException {
        EObject current = null;

        Enumerator lv_dataType_0_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:2773:2: ( ( (lv_dataType_0_0= ruleDataTypes ) )+ )
            // InternalCoreDsl.g:2774:2: ( (lv_dataType_0_0= ruleDataTypes ) )+
            {
            // InternalCoreDsl.g:2774:2: ( (lv_dataType_0_0= ruleDataTypes ) )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( ((LA60_0>=100 && LA60_0<=110)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalCoreDsl.g:2775:3: (lv_dataType_0_0= ruleDataTypes )
            	    {
            	    // InternalCoreDsl.g:2775:3: (lv_dataType_0_0= ruleDataTypes )
            	    // InternalCoreDsl.g:2776:4: lv_dataType_0_0= ruleDataTypes
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getPodSpecifierAccess().getDataTypeDataTypesEnumRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_57);
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
    // InternalCoreDsl.g:2796:1: entryRuleBitSizeSpecifier returns [EObject current=null] : iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF ;
    public final EObject entryRuleBitSizeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitSizeSpecifier = null;


        try {
            // InternalCoreDsl.g:2796:57: (iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF )
            // InternalCoreDsl.g:2797:2: iv_ruleBitSizeSpecifier= ruleBitSizeSpecifier EOF
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
    // InternalCoreDsl.g:2803:1: ruleBitSizeSpecifier returns [EObject current=null] : (otherlv_0= '<' ( (lv_size_1_0= rulePrimaryExpression ) ) (otherlv_2= ',' ( (lv_size_3_0= rulePrimaryExpression ) ) otherlv_4= ',' ( (lv_size_5_0= rulePrimaryExpression ) ) otherlv_6= ',' ( (lv_size_7_0= rulePrimaryExpression ) ) )? otherlv_8= '>' ) ;
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
            // InternalCoreDsl.g:2809:2: ( (otherlv_0= '<' ( (lv_size_1_0= rulePrimaryExpression ) ) (otherlv_2= ',' ( (lv_size_3_0= rulePrimaryExpression ) ) otherlv_4= ',' ( (lv_size_5_0= rulePrimaryExpression ) ) otherlv_6= ',' ( (lv_size_7_0= rulePrimaryExpression ) ) )? otherlv_8= '>' ) )
            // InternalCoreDsl.g:2810:2: (otherlv_0= '<' ( (lv_size_1_0= rulePrimaryExpression ) ) (otherlv_2= ',' ( (lv_size_3_0= rulePrimaryExpression ) ) otherlv_4= ',' ( (lv_size_5_0= rulePrimaryExpression ) ) otherlv_6= ',' ( (lv_size_7_0= rulePrimaryExpression ) ) )? otherlv_8= '>' )
            {
            // InternalCoreDsl.g:2810:2: (otherlv_0= '<' ( (lv_size_1_0= rulePrimaryExpression ) ) (otherlv_2= ',' ( (lv_size_3_0= rulePrimaryExpression ) ) otherlv_4= ',' ( (lv_size_5_0= rulePrimaryExpression ) ) otherlv_6= ',' ( (lv_size_7_0= rulePrimaryExpression ) ) )? otherlv_8= '>' )
            // InternalCoreDsl.g:2811:3: otherlv_0= '<' ( (lv_size_1_0= rulePrimaryExpression ) ) (otherlv_2= ',' ( (lv_size_3_0= rulePrimaryExpression ) ) otherlv_4= ',' ( (lv_size_5_0= rulePrimaryExpression ) ) otherlv_6= ',' ( (lv_size_7_0= rulePrimaryExpression ) ) )? otherlv_8= '>'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBitSizeSpecifierAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalCoreDsl.g:2815:3: ( (lv_size_1_0= rulePrimaryExpression ) )
            // InternalCoreDsl.g:2816:4: (lv_size_1_0= rulePrimaryExpression )
            {
            // InternalCoreDsl.g:2816:4: (lv_size_1_0= rulePrimaryExpression )
            // InternalCoreDsl.g:2817:5: lv_size_1_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizePrimaryExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_59);
            lv_size_1_0=rulePrimaryExpression();

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
              						"com.minres.coredsl.CoreDsl.PrimaryExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCoreDsl.g:2834:3: (otherlv_2= ',' ( (lv_size_3_0= rulePrimaryExpression ) ) otherlv_4= ',' ( (lv_size_5_0= rulePrimaryExpression ) ) otherlv_6= ',' ( (lv_size_7_0= rulePrimaryExpression ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==35) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalCoreDsl.g:2835:4: otherlv_2= ',' ( (lv_size_3_0= rulePrimaryExpression ) ) otherlv_4= ',' ( (lv_size_5_0= rulePrimaryExpression ) ) otherlv_6= ',' ( (lv_size_7_0= rulePrimaryExpression ) )
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_0());
                      			
                    }
                    // InternalCoreDsl.g:2839:4: ( (lv_size_3_0= rulePrimaryExpression ) )
                    // InternalCoreDsl.g:2840:5: (lv_size_3_0= rulePrimaryExpression )
                    {
                    // InternalCoreDsl.g:2840:5: (lv_size_3_0= rulePrimaryExpression )
                    // InternalCoreDsl.g:2841:6: lv_size_3_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizePrimaryExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_60);
                    lv_size_3_0=rulePrimaryExpression();

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
                      							"com.minres.coredsl.CoreDsl.PrimaryExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,35,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_2());
                      			
                    }
                    // InternalCoreDsl.g:2862:4: ( (lv_size_5_0= rulePrimaryExpression ) )
                    // InternalCoreDsl.g:2863:5: (lv_size_5_0= rulePrimaryExpression )
                    {
                    // InternalCoreDsl.g:2863:5: (lv_size_5_0= rulePrimaryExpression )
                    // InternalCoreDsl.g:2864:6: lv_size_5_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizePrimaryExpressionParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_60);
                    lv_size_5_0=rulePrimaryExpression();

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
                      							"com.minres.coredsl.CoreDsl.PrimaryExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,35,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getBitSizeSpecifierAccess().getCommaKeyword_2_4());
                      			
                    }
                    // InternalCoreDsl.g:2885:4: ( (lv_size_7_0= rulePrimaryExpression ) )
                    // InternalCoreDsl.g:2886:5: (lv_size_7_0= rulePrimaryExpression )
                    {
                    // InternalCoreDsl.g:2886:5: (lv_size_7_0= rulePrimaryExpression )
                    // InternalCoreDsl.g:2887:6: lv_size_7_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitSizeSpecifierAccess().getSizePrimaryExpressionParserRuleCall_2_5_0());
                      					
                    }
                    pushFollow(FOLLOW_61);
                    lv_size_7_0=rulePrimaryExpression();

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
                      							"com.minres.coredsl.CoreDsl.PrimaryExpression");
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


    // $ANTLR start "entryRuleEnumSpecifier"
    // InternalCoreDsl.g:2913:1: entryRuleEnumSpecifier returns [EObject current=null] : iv_ruleEnumSpecifier= ruleEnumSpecifier EOF ;
    public final EObject entryRuleEnumSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumSpecifier = null;


        try {
            // InternalCoreDsl.g:2913:54: (iv_ruleEnumSpecifier= ruleEnumSpecifier EOF )
            // InternalCoreDsl.g:2914:2: iv_ruleEnumSpecifier= ruleEnumSpecifier EOF
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
    // InternalCoreDsl.g:2920:1: ruleEnumSpecifier returns [EObject current=null] : ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) ) ;
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
            // InternalCoreDsl.g:2926:2: ( ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:2927:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:2927:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' ) | (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==63) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==RULE_ID) ) {
                    int LA64_2 = input.LA(3);

                    if ( (LA64_2==26) ) {
                        alt64=1;
                    }
                    else if ( (LA64_2==EOF||LA64_2==RULE_ID||LA64_2==RULE_LEFT_BR||LA64_2==35||LA64_2==38||(LA64_2>=44 && LA64_2<=45)||(LA64_2>=58 && LA64_2<=59)||LA64_2==61) ) {
                        alt64=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA64_1==26) ) {
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
                    // InternalCoreDsl.g:2928:3: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' )
                    {
                    // InternalCoreDsl.g:2928:3: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}' )
                    // InternalCoreDsl.g:2929:4: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' this_EnumeratorList_3= ruleEnumeratorList[$current] (otherlv_4= ',' )? otherlv_5= '}'
                    {
                    otherlv_0=(Token)match(input,63,FOLLOW_62); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getEnumSpecifierAccess().getEnumKeyword_0_0());
                      			
                    }
                    // InternalCoreDsl.g:2933:4: ( (lv_name_1_0= RULE_ID ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==RULE_ID) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalCoreDsl.g:2934:5: (lv_name_1_0= RULE_ID )
                            {
                            // InternalCoreDsl.g:2934:5: (lv_name_1_0= RULE_ID )
                            // InternalCoreDsl.g:2935:6: lv_name_1_0= RULE_ID
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

                    otherlv_2=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEnumSpecifierAccess().getLeftCurlyBracketKeyword_0_2());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getEnumSpecifierRule());
                      				}
                      				newCompositeNode(grammarAccess.getEnumSpecifierAccess().getEnumeratorListParserRuleCall_0_3());
                      			
                    }
                    pushFollow(FOLLOW_63);
                    this_EnumeratorList_3=ruleEnumeratorList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_EnumeratorList_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:2966:4: (otherlv_4= ',' )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==35) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // InternalCoreDsl.g:2967:5: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,35,FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getEnumSpecifierAccess().getCommaKeyword_0_4());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getEnumSpecifierAccess().getRightCurlyBracketKeyword_0_5());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:2978:3: (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:2978:3: (otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:2979:4: otherlv_6= 'enum' ( (lv_name_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,63,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getEnumSpecifierAccess().getEnumKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:2983:4: ( (lv_name_7_0= RULE_ID ) )
                    // InternalCoreDsl.g:2984:5: (lv_name_7_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:2984:5: (lv_name_7_0= RULE_ID )
                    // InternalCoreDsl.g:2985:6: lv_name_7_0= RULE_ID
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
    // InternalCoreDsl.g:3007:1: ruleEnumeratorList[EObject in_current] returns [EObject current=in_current] : ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* ) ;
    public final EObject ruleEnumeratorList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_enumerators_0_0 = null;

        EObject lv_enumerators_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3013:2: ( ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* ) )
            // InternalCoreDsl.g:3014:2: ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* )
            {
            // InternalCoreDsl.g:3014:2: ( ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )* )
            // InternalCoreDsl.g:3015:3: ( (lv_enumerators_0_0= ruleEnumerator ) ) (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )*
            {
            // InternalCoreDsl.g:3015:3: ( (lv_enumerators_0_0= ruleEnumerator ) )
            // InternalCoreDsl.g:3016:4: (lv_enumerators_0_0= ruleEnumerator )
            {
            // InternalCoreDsl.g:3016:4: (lv_enumerators_0_0= ruleEnumerator )
            // InternalCoreDsl.g:3017:5: lv_enumerators_0_0= ruleEnumerator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumeratorListAccess().getEnumeratorsEnumeratorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_41);
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

            // InternalCoreDsl.g:3034:3: (otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==35) ) {
                    int LA65_1 = input.LA(2);

                    if ( (LA65_1==RULE_ID) ) {
                        alt65=1;
                    }


                }


                switch (alt65) {
            	case 1 :
            	    // InternalCoreDsl.g:3035:4: otherlv_1= ',' ( (lv_enumerators_2_0= ruleEnumerator ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getEnumeratorListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3039:4: ( (lv_enumerators_2_0= ruleEnumerator ) )
            	    // InternalCoreDsl.g:3040:5: (lv_enumerators_2_0= ruleEnumerator )
            	    {
            	    // InternalCoreDsl.g:3040:5: (lv_enumerators_2_0= ruleEnumerator )
            	    // InternalCoreDsl.g:3041:6: lv_enumerators_2_0= ruleEnumerator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumeratorListAccess().getEnumeratorsEnumeratorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_41);
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
    // InternalCoreDsl.g:3063:1: entryRuleEnumerator returns [EObject current=null] : iv_ruleEnumerator= ruleEnumerator EOF ;
    public final EObject entryRuleEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerator = null;


        try {
            // InternalCoreDsl.g:3063:51: (iv_ruleEnumerator= ruleEnumerator EOF )
            // InternalCoreDsl.g:3064:2: iv_ruleEnumerator= ruleEnumerator EOF
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
    // InternalCoreDsl.g:3070:1: ruleEnumerator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) ) ;
    public final EObject ruleEnumerator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3076:2: ( ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) ) )
            // InternalCoreDsl.g:3077:2: ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) )
            {
            // InternalCoreDsl.g:3077:2: ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==60) ) {
                    alt66=2;
                }
                else if ( (LA66_1==EOF||LA66_1==28||LA66_1==35) ) {
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
                    // InternalCoreDsl.g:3078:3: ( (lv_name_0_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:3078:3: ( (lv_name_0_0= RULE_ID ) )
                    // InternalCoreDsl.g:3079:4: (lv_name_0_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3079:4: (lv_name_0_0= RULE_ID )
                    // InternalCoreDsl.g:3080:5: lv_name_0_0= RULE_ID
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
                    // InternalCoreDsl.g:3097:3: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) )
                    {
                    // InternalCoreDsl.g:3097:3: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) ) )
                    // InternalCoreDsl.g:3098:4: ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleConstantExpression ) )
                    {
                    // InternalCoreDsl.g:3098:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalCoreDsl.g:3099:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3099:5: (lv_name_1_0= RULE_ID )
                    // InternalCoreDsl.g:3100:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_64); if (state.failed) return current;
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

                    otherlv_2=(Token)match(input,60,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:3120:4: ( (lv_expression_3_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:3121:5: (lv_expression_3_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:3121:5: (lv_expression_3_0= ruleConstantExpression )
                    // InternalCoreDsl.g:3122:6: lv_expression_3_0= ruleConstantExpression
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
    // InternalCoreDsl.g:3144:1: entryRuleStructOrUnionSpecifier returns [EObject current=null] : iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF ;
    public final EObject entryRuleStructOrUnionSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructOrUnionSpecifier = null;


        try {
            // InternalCoreDsl.g:3144:63: (iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF )
            // InternalCoreDsl.g:3145:2: iv_ruleStructOrUnionSpecifier= ruleStructOrUnionSpecifier EOF
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
    // InternalCoreDsl.g:3151:1: ruleStructOrUnionSpecifier returns [EObject current=null] : ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) ) ;
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
            // InternalCoreDsl.g:3157:2: ( ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:3158:2: ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:3158:2: ( ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' ) | ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==120) ) {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==RULE_ID) ) {
                    int LA69_3 = input.LA(3);

                    if ( (LA69_3==26) ) {
                        alt69=1;
                    }
                    else if ( (LA69_3==EOF||LA69_3==RULE_ID||LA69_3==RULE_LEFT_BR||LA69_3==35||LA69_3==38||(LA69_3>=44 && LA69_3<=45)||(LA69_3>=58 && LA69_3<=59)||LA69_3==61) ) {
                        alt69=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA69_1==26) ) {
                    alt69=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA69_0==121) ) {
                int LA69_2 = input.LA(2);

                if ( (LA69_2==RULE_ID) ) {
                    int LA69_3 = input.LA(3);

                    if ( (LA69_3==26) ) {
                        alt69=1;
                    }
                    else if ( (LA69_3==EOF||LA69_3==RULE_ID||LA69_3==RULE_LEFT_BR||LA69_3==35||LA69_3==38||(LA69_3>=44 && LA69_3<=45)||(LA69_3>=58 && LA69_3<=59)||LA69_3==61) ) {
                        alt69=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA69_2==26) ) {
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
                    // InternalCoreDsl.g:3159:3: ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' )
                    {
                    // InternalCoreDsl.g:3159:3: ( ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}' )
                    // InternalCoreDsl.g:3160:4: ( (lv_composeType_0_0= ruleStructOrUnion ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( (lv_decls_3_0= ruleStructDeclaration ) )* otherlv_4= '}'
                    {
                    // InternalCoreDsl.g:3160:4: ( (lv_composeType_0_0= ruleStructOrUnion ) )
                    // InternalCoreDsl.g:3161:5: (lv_composeType_0_0= ruleStructOrUnion )
                    {
                    // InternalCoreDsl.g:3161:5: (lv_composeType_0_0= ruleStructOrUnion )
                    // InternalCoreDsl.g:3162:6: lv_composeType_0_0= ruleStructOrUnion
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStructOrUnionSpecifierAccess().getComposeTypeStructOrUnionEnumRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_62);
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

                    // InternalCoreDsl.g:3179:4: ( (lv_name_1_0= RULE_ID ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==RULE_ID) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalCoreDsl.g:3180:5: (lv_name_1_0= RULE_ID )
                            {
                            // InternalCoreDsl.g:3180:5: (lv_name_1_0= RULE_ID )
                            // InternalCoreDsl.g:3181:6: lv_name_1_0= RULE_ID
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

                    otherlv_2=(Token)match(input,26,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getStructOrUnionSpecifierAccess().getLeftCurlyBracketKeyword_0_2());
                      			
                    }
                    // InternalCoreDsl.g:3201:4: ( (lv_decls_3_0= ruleStructDeclaration ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==63||(LA68_0>=100 && LA68_0<=112)||(LA68_0>=120 && LA68_0<=121)) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalCoreDsl.g:3202:5: (lv_decls_3_0= ruleStructDeclaration )
                    	    {
                    	    // InternalCoreDsl.g:3202:5: (lv_decls_3_0= ruleStructDeclaration )
                    	    // InternalCoreDsl.g:3203:6: lv_decls_3_0= ruleStructDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getStructOrUnionSpecifierAccess().getDeclsStructDeclarationParserRuleCall_0_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_11);
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

                    otherlv_4=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getStructOrUnionSpecifierAccess().getRightCurlyBracketKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3226:3: ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:3226:3: ( ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:3227:4: ( (lv_composeType_5_0= ruleStructOrUnion ) ) ( (lv_name_6_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:3227:4: ( (lv_composeType_5_0= ruleStructOrUnion ) )
                    // InternalCoreDsl.g:3228:5: (lv_composeType_5_0= ruleStructOrUnion )
                    {
                    // InternalCoreDsl.g:3228:5: (lv_composeType_5_0= ruleStructOrUnion )
                    // InternalCoreDsl.g:3229:6: lv_composeType_5_0= ruleStructOrUnion
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

                    // InternalCoreDsl.g:3246:4: ( (lv_name_6_0= RULE_ID ) )
                    // InternalCoreDsl.g:3247:5: (lv_name_6_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3247:5: (lv_name_6_0= RULE_ID )
                    // InternalCoreDsl.g:3248:6: lv_name_6_0= RULE_ID
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
    // InternalCoreDsl.g:3269:1: entryRuleStructDeclaration returns [EObject current=null] : iv_ruleStructDeclaration= ruleStructDeclaration EOF ;
    public final EObject entryRuleStructDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructDeclaration = null;


        try {
            // InternalCoreDsl.g:3269:58: (iv_ruleStructDeclaration= ruleStructDeclaration EOF )
            // InternalCoreDsl.g:3270:2: iv_ruleStructDeclaration= ruleStructDeclaration EOF
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
    // InternalCoreDsl.g:3276:1: ruleStructDeclaration returns [EObject current=null] : ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleStructDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_specifier_0_0 = null;

        EObject lv_decls_1_0 = null;

        EObject lv_decls_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3282:2: ( ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' ) )
            // InternalCoreDsl.g:3283:2: ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' )
            {
            // InternalCoreDsl.g:3283:2: ( ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';' )
            // InternalCoreDsl.g:3284:3: ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) ) ( (lv_decls_1_0= ruleDirectDeclarator ) ) (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )* otherlv_4= ';'
            {
            // InternalCoreDsl.g:3284:3: ( (lv_specifier_0_0= ruleStructDeclarationSpecifier ) )
            // InternalCoreDsl.g:3285:4: (lv_specifier_0_0= ruleStructDeclarationSpecifier )
            {
            // InternalCoreDsl.g:3285:4: (lv_specifier_0_0= ruleStructDeclarationSpecifier )
            // InternalCoreDsl.g:3286:5: lv_specifier_0_0= ruleStructDeclarationSpecifier
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

            // InternalCoreDsl.g:3303:3: ( (lv_decls_1_0= ruleDirectDeclarator ) )
            // InternalCoreDsl.g:3304:4: (lv_decls_1_0= ruleDirectDeclarator )
            {
            // InternalCoreDsl.g:3304:4: (lv_decls_1_0= ruleDirectDeclarator )
            // InternalCoreDsl.g:3305:5: lv_decls_1_0= ruleDirectDeclarator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStructDeclarationAccess().getDeclsDirectDeclaratorParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_54);
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

            // InternalCoreDsl.g:3322:3: (otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==35) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalCoreDsl.g:3323:4: otherlv_2= ',' ( (lv_decls_3_0= ruleDirectDeclarator ) )
            	    {
            	    otherlv_2=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getStructDeclarationAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3327:4: ( (lv_decls_3_0= ruleDirectDeclarator ) )
            	    // InternalCoreDsl.g:3328:5: (lv_decls_3_0= ruleDirectDeclarator )
            	    {
            	    // InternalCoreDsl.g:3328:5: (lv_decls_3_0= ruleDirectDeclarator )
            	    // InternalCoreDsl.g:3329:6: lv_decls_3_0= ruleDirectDeclarator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getStructDeclarationAccess().getDeclsDirectDeclaratorParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_54);
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
    // InternalCoreDsl.g:3355:1: entryRuleStructDeclarationSpecifier returns [EObject current=null] : iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF ;
    public final EObject entryRuleStructDeclarationSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructDeclarationSpecifier = null;


        try {
            // InternalCoreDsl.g:3355:67: (iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF )
            // InternalCoreDsl.g:3356:2: iv_ruleStructDeclarationSpecifier= ruleStructDeclarationSpecifier EOF
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
    // InternalCoreDsl.g:3362:1: ruleStructDeclarationSpecifier returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) ) ;
    public final EObject ruleStructDeclarationSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        Enumerator lv_qualifiers_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3368:2: ( ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) ) )
            // InternalCoreDsl.g:3369:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) )
            {
            // InternalCoreDsl.g:3369:2: ( ( (lv_type_0_0= ruleTypeSpecifier ) ) | ( (lv_qualifiers_1_0= ruleTypeQualifier ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==63||(LA71_0>=100 && LA71_0<=110)||(LA71_0>=120 && LA71_0<=121)) ) {
                alt71=1;
            }
            else if ( ((LA71_0>=111 && LA71_0<=112)) ) {
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
                    // InternalCoreDsl.g:3370:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
                    {
                    // InternalCoreDsl.g:3370:3: ( (lv_type_0_0= ruleTypeSpecifier ) )
                    // InternalCoreDsl.g:3371:4: (lv_type_0_0= ruleTypeSpecifier )
                    {
                    // InternalCoreDsl.g:3371:4: (lv_type_0_0= ruleTypeSpecifier )
                    // InternalCoreDsl.g:3372:5: lv_type_0_0= ruleTypeSpecifier
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
                    // InternalCoreDsl.g:3390:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    {
                    // InternalCoreDsl.g:3390:3: ( (lv_qualifiers_1_0= ruleTypeQualifier ) )
                    // InternalCoreDsl.g:3391:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    {
                    // InternalCoreDsl.g:3391:4: (lv_qualifiers_1_0= ruleTypeQualifier )
                    // InternalCoreDsl.g:3392:5: lv_qualifiers_1_0= ruleTypeQualifier
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
    // InternalCoreDsl.g:3413:1: entryRuleInitDeclarator returns [EObject current=null] : iv_ruleInitDeclarator= ruleInitDeclarator EOF ;
    public final EObject entryRuleInitDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitDeclarator = null;


        try {
            // InternalCoreDsl.g:3413:55: (iv_ruleInitDeclarator= ruleInitDeclarator EOF )
            // InternalCoreDsl.g:3414:2: iv_ruleInitDeclarator= ruleInitDeclarator EOF
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
    // InternalCoreDsl.g:3420:1: ruleInitDeclarator returns [EObject current=null] : ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) ( (lv_attrs_1_0= ruleAttribute ) )* (otherlv_2= '=' ( (lv_initializer_3_0= ruleInitializer ) ) )? ) ;
    public final EObject ruleInitDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_declarator_0_0 = null;

        EObject lv_attrs_1_0 = null;

        EObject lv_initializer_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3426:2: ( ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) ( (lv_attrs_1_0= ruleAttribute ) )* (otherlv_2= '=' ( (lv_initializer_3_0= ruleInitializer ) ) )? ) )
            // InternalCoreDsl.g:3427:2: ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) ( (lv_attrs_1_0= ruleAttribute ) )* (otherlv_2= '=' ( (lv_initializer_3_0= ruleInitializer ) ) )? )
            {
            // InternalCoreDsl.g:3427:2: ( ( (lv_declarator_0_0= ruleDirectDeclarator ) ) ( (lv_attrs_1_0= ruleAttribute ) )* (otherlv_2= '=' ( (lv_initializer_3_0= ruleInitializer ) ) )? )
            // InternalCoreDsl.g:3428:3: ( (lv_declarator_0_0= ruleDirectDeclarator ) ) ( (lv_attrs_1_0= ruleAttribute ) )* (otherlv_2= '=' ( (lv_initializer_3_0= ruleInitializer ) ) )?
            {
            // InternalCoreDsl.g:3428:3: ( (lv_declarator_0_0= ruleDirectDeclarator ) )
            // InternalCoreDsl.g:3429:4: (lv_declarator_0_0= ruleDirectDeclarator )
            {
            // InternalCoreDsl.g:3429:4: (lv_declarator_0_0= ruleDirectDeclarator )
            // InternalCoreDsl.g:3430:5: lv_declarator_0_0= ruleDirectDeclarator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInitDeclaratorAccess().getDeclaratorDirectDeclaratorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_65);
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

            // InternalCoreDsl.g:3447:3: ( (lv_attrs_1_0= ruleAttribute ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==RULE_LEFT_BR) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalCoreDsl.g:3448:4: (lv_attrs_1_0= ruleAttribute )
            	    {
            	    // InternalCoreDsl.g:3448:4: (lv_attrs_1_0= ruleAttribute )
            	    // InternalCoreDsl.g:3449:5: lv_attrs_1_0= ruleAttribute
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getInitDeclaratorAccess().getAttrsAttributeParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_65);
            	    lv_attrs_1_0=ruleAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getInitDeclaratorRule());
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
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            // InternalCoreDsl.g:3466:3: (otherlv_2= '=' ( (lv_initializer_3_0= ruleInitializer ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==60) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalCoreDsl.g:3467:4: otherlv_2= '=' ( (lv_initializer_3_0= ruleInitializer ) )
                    {
                    otherlv_2=(Token)match(input,60,FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getInitDeclaratorAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalCoreDsl.g:3471:4: ( (lv_initializer_3_0= ruleInitializer ) )
                    // InternalCoreDsl.g:3472:5: (lv_initializer_3_0= ruleInitializer )
                    {
                    // InternalCoreDsl.g:3472:5: (lv_initializer_3_0= ruleInitializer )
                    // InternalCoreDsl.g:3473:6: lv_initializer_3_0= ruleInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInitDeclaratorAccess().getInitializerInitializerParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_initializer_3_0=ruleInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInitDeclaratorRule());
                      						}
                      						set(
                      							current,
                      							"initializer",
                      							lv_initializer_3_0,
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
    // InternalCoreDsl.g:3495:1: entryRuleDirectDeclarator returns [EObject current=null] : iv_ruleDirectDeclarator= ruleDirectDeclarator EOF ;
    public final EObject entryRuleDirectDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectDeclarator = null;


        try {
            // InternalCoreDsl.g:3495:57: (iv_ruleDirectDeclarator= ruleDirectDeclarator EOF )
            // InternalCoreDsl.g:3496:2: iv_ruleDirectDeclarator= ruleDirectDeclarator EOF
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
    // InternalCoreDsl.g:3502:1: ruleDirectDeclarator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )? ) ;
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
            // InternalCoreDsl.g:3508:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )? ) )
            // InternalCoreDsl.g:3509:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )? )
            {
            // InternalCoreDsl.g:3509:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )? )
            // InternalCoreDsl.g:3510:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )? ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )?
            {
            // InternalCoreDsl.g:3510:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCoreDsl.g:3511:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCoreDsl.g:3511:4: (lv_name_0_0= RULE_ID )
            // InternalCoreDsl.g:3512:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_67); if (state.failed) return current;
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

            // InternalCoreDsl.g:3528:3: (otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==37) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalCoreDsl.g:3529:4: otherlv_1= ':' ( (lv_index_2_0= ruleIntegerConstant ) )
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectDeclaratorAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3533:4: ( (lv_index_2_0= ruleIntegerConstant ) )
                    // InternalCoreDsl.g:3534:5: (lv_index_2_0= ruleIntegerConstant )
                    {
                    // InternalCoreDsl.g:3534:5: (lv_index_2_0= ruleIntegerConstant )
                    // InternalCoreDsl.g:3535:6: lv_index_2_0= ruleIntegerConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getIndexIntegerConstantParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_68);
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

            // InternalCoreDsl.g:3553:3: ( ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ ) | ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' ) )?
            int alt76=3;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_LEFT_BR) ) {
                int LA76_1 = input.LA(2);

                if ( ((LA76_1>=RULE_STRING && LA76_1<=RULE_ID)||(LA76_1>=RULE_INTEGER && LA76_1<=RULE_CHARCONST)||LA76_1==44||(LA76_1>=58 && LA76_1<=59)||(LA76_1>=86 && LA76_1<=87)||(LA76_1>=90 && LA76_1<=94)||(LA76_1>=96 && LA76_1<=99)) ) {
                    alt76=1;
                }
            }
            else if ( (LA76_0==44) ) {
                alt76=2;
            }
            switch (alt76) {
                case 1 :
                    // InternalCoreDsl.g:3554:4: ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ )
                    {
                    // InternalCoreDsl.g:3554:4: ( () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+ )
                    // InternalCoreDsl.g:3555:5: () (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+
                    {
                    // InternalCoreDsl.g:3555:5: ()
                    // InternalCoreDsl.g:3556:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndSet(
                      							grammarAccess.getDirectDeclaratorAccess().getDirectDeclaratorLeftAction_2_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalCoreDsl.g:3562:5: (this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR )+
                    int cnt75=0;
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==RULE_LEFT_BR) ) {
                            int LA75_2 = input.LA(2);

                            if ( ((LA75_2>=RULE_STRING && LA75_2<=RULE_ID)||(LA75_2>=RULE_INTEGER && LA75_2<=RULE_CHARCONST)||LA75_2==44||(LA75_2>=58 && LA75_2<=59)||(LA75_2>=86 && LA75_2<=87)||(LA75_2>=90 && LA75_2<=94)||(LA75_2>=96 && LA75_2<=99)) ) {
                                alt75=1;
                            }


                        }


                        switch (alt75) {
                    	case 1 :
                    	    // InternalCoreDsl.g:3563:6: this_LEFT_BR_4= RULE_LEFT_BR ( (lv_size_5_0= ruleConditionalExpression ) ) this_RIGHT_BR_6= RULE_RIGHT_BR
                    	    {
                    	    this_LEFT_BR_4=(Token)match(input,RULE_LEFT_BR,FOLLOW_43); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(this_LEFT_BR_4, grammarAccess.getDirectDeclaratorAccess().getLEFT_BRTerminalRuleCall_2_0_1_0());
                    	      					
                    	    }
                    	    // InternalCoreDsl.g:3567:6: ( (lv_size_5_0= ruleConditionalExpression ) )
                    	    // InternalCoreDsl.g:3568:7: (lv_size_5_0= ruleConditionalExpression )
                    	    {
                    	    // InternalCoreDsl.g:3568:7: (lv_size_5_0= ruleConditionalExpression )
                    	    // InternalCoreDsl.g:3569:8: lv_size_5_0= ruleConditionalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getSizeConditionalExpressionParserRuleCall_2_0_1_1_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_25);
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

                    	    this_RIGHT_BR_6=(Token)match(input,RULE_RIGHT_BR,FOLLOW_69); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(this_RIGHT_BR_6, grammarAccess.getDirectDeclaratorAccess().getRIGHT_BRTerminalRuleCall_2_0_1_2());
                    	      					
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt75 >= 1 ) break loop75;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(75, input);
                                throw eee;
                        }
                        cnt75++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:3593:4: ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' )
                    {
                    // InternalCoreDsl.g:3593:4: ( () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')' )
                    // InternalCoreDsl.g:3594:5: () otherlv_8= '(' this_ParameterList_9= ruleParameterList[$current] otherlv_10= ')'
                    {
                    // InternalCoreDsl.g:3594:5: ()
                    // InternalCoreDsl.g:3595:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndSet(
                      							grammarAccess.getDirectDeclaratorAccess().getDirectDeclaratorLeftAction_2_1_0(),
                      							current);
                      					
                    }

                    }

                    otherlv_8=(Token)match(input,44,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getDirectDeclaratorAccess().getLeftParenthesisKeyword_2_1_1());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getDirectDeclaratorRule());
                      					}
                      					newCompositeNode(grammarAccess.getDirectDeclaratorAccess().getParameterListParserRuleCall_2_1_2());
                      				
                    }
                    pushFollow(FOLLOW_40);
                    this_ParameterList_9=ruleParameterList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_ParameterList_9;
                      					afterParserOrEnumRuleCall();
                      				
                    }
                    otherlv_10=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:3626:1: entryRuleInitializer returns [EObject current=null] : iv_ruleInitializer= ruleInitializer EOF ;
    public final EObject entryRuleInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitializer = null;


        try {
            // InternalCoreDsl.g:3626:52: (iv_ruleInitializer= ruleInitializer EOF )
            // InternalCoreDsl.g:3627:2: iv_ruleInitializer= ruleInitializer EOF
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
    // InternalCoreDsl.g:3633:1: ruleInitializer returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) ) ;
    public final EObject ruleInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expr_0_0 = null;

        EObject this_InitializerList_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3639:2: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) ) )
            // InternalCoreDsl.g:3640:2: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) )
            {
            // InternalCoreDsl.g:3640:2: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) | (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=RULE_STRING && LA78_0<=RULE_ID)||(LA78_0>=RULE_INTEGER && LA78_0<=RULE_CHARCONST)||LA78_0==44||(LA78_0>=58 && LA78_0<=59)||(LA78_0>=86 && LA78_0<=87)||(LA78_0>=90 && LA78_0<=94)||(LA78_0>=96 && LA78_0<=99)) ) {
                alt78=1;
            }
            else if ( (LA78_0==26) ) {
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
                    // InternalCoreDsl.g:3641:3: ( (lv_expr_0_0= ruleConditionalExpression ) )
                    {
                    // InternalCoreDsl.g:3641:3: ( (lv_expr_0_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:3642:4: (lv_expr_0_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:3642:4: (lv_expr_0_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:3643:5: lv_expr_0_0= ruleConditionalExpression
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
                    // InternalCoreDsl.g:3661:3: (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' )
                    {
                    // InternalCoreDsl.g:3661:3: (otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}' )
                    // InternalCoreDsl.g:3662:4: otherlv_1= '{' this_InitializerList_2= ruleInitializerList[$current] (otherlv_3= ',' )? otherlv_4= '}'
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_70); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInitializerAccess().getLeftCurlyBracketKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getInitializerRule());
                      				}
                      				newCompositeNode(grammarAccess.getInitializerAccess().getInitializerListParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_63);
                    this_InitializerList_2=ruleInitializerList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_InitializerList_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:3677:4: (otherlv_3= ',' )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==35) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalCoreDsl.g:3678:5: otherlv_3= ','
                            {
                            otherlv_3=(Token)match(input,35,FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getInitializerAccess().getCommaKeyword_1_2());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:3693:1: ruleInitializerList[EObject in_current] returns [EObject current=in_current] : ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* ) ;
    public final EObject ruleInitializerList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_init_0_1 = null;

        EObject lv_init_0_2 = null;

        EObject lv_init_2_1 = null;

        EObject lv_init_2_2 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3699:2: ( ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* ) )
            // InternalCoreDsl.g:3700:2: ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* )
            {
            // InternalCoreDsl.g:3700:2: ( ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )* )
            // InternalCoreDsl.g:3701:3: ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) ) (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )*
            {
            // InternalCoreDsl.g:3701:3: ( ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) ) )
            // InternalCoreDsl.g:3702:4: ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) )
            {
            // InternalCoreDsl.g:3702:4: ( (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer ) )
            // InternalCoreDsl.g:3703:5: (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer )
            {
            // InternalCoreDsl.g:3703:5: (lv_init_0_1= ruleDesignatedInitializer | lv_init_0_2= ruleInitializer )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_LEFT_BR||LA79_0==64) ) {
                alt79=1;
            }
            else if ( ((LA79_0>=RULE_STRING && LA79_0<=RULE_ID)||(LA79_0>=RULE_INTEGER && LA79_0<=RULE_CHARCONST)||LA79_0==26||LA79_0==44||(LA79_0>=58 && LA79_0<=59)||(LA79_0>=86 && LA79_0<=87)||(LA79_0>=90 && LA79_0<=94)||(LA79_0>=96 && LA79_0<=99)) ) {
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
                    // InternalCoreDsl.g:3704:6: lv_init_0_1= ruleDesignatedInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInitializerListAccess().getInitDesignatedInitializerParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_41);
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
                    // InternalCoreDsl.g:3720:6: lv_init_0_2= ruleInitializer
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInitializerListAccess().getInitInitializerParserRuleCall_0_0_1());
                      					
                    }
                    pushFollow(FOLLOW_41);
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

            // InternalCoreDsl.g:3738:3: (otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==35) ) {
                    int LA81_1 = input.LA(2);

                    if ( ((LA81_1>=RULE_STRING && LA81_1<=RULE_ID)||LA81_1==RULE_LEFT_BR||(LA81_1>=RULE_INTEGER && LA81_1<=RULE_CHARCONST)||LA81_1==26||LA81_1==44||(LA81_1>=58 && LA81_1<=59)||LA81_1==64||(LA81_1>=86 && LA81_1<=87)||(LA81_1>=90 && LA81_1<=94)||(LA81_1>=96 && LA81_1<=99)) ) {
                        alt81=1;
                    }


                }


                switch (alt81) {
            	case 1 :
            	    // InternalCoreDsl.g:3739:4: otherlv_1= ',' ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_70); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getInitializerListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalCoreDsl.g:3743:4: ( ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) ) )
            	    // InternalCoreDsl.g:3744:5: ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) )
            	    {
            	    // InternalCoreDsl.g:3744:5: ( (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer ) )
            	    // InternalCoreDsl.g:3745:6: (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer )
            	    {
            	    // InternalCoreDsl.g:3745:6: (lv_init_2_1= ruleDesignatedInitializer | lv_init_2_2= ruleInitializer )
            	    int alt80=2;
            	    int LA80_0 = input.LA(1);

            	    if ( (LA80_0==RULE_LEFT_BR||LA80_0==64) ) {
            	        alt80=1;
            	    }
            	    else if ( ((LA80_0>=RULE_STRING && LA80_0<=RULE_ID)||(LA80_0>=RULE_INTEGER && LA80_0<=RULE_CHARCONST)||LA80_0==26||LA80_0==44||(LA80_0>=58 && LA80_0<=59)||(LA80_0>=86 && LA80_0<=87)||(LA80_0>=90 && LA80_0<=94)||(LA80_0>=96 && LA80_0<=99)) ) {
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
            	            // InternalCoreDsl.g:3746:7: lv_init_2_1= ruleDesignatedInitializer
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getInitializerListAccess().getInitDesignatedInitializerParserRuleCall_1_1_0_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_41);
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
            	            // InternalCoreDsl.g:3762:7: lv_init_2_2= ruleInitializer
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getInitializerListAccess().getInitInitializerParserRuleCall_1_1_0_1());
            	              						
            	            }
            	            pushFollow(FOLLOW_41);
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
            	    break loop81;
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
    // InternalCoreDsl.g:3785:1: entryRuleDesignatedInitializer returns [EObject current=null] : iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF ;
    public final EObject entryRuleDesignatedInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesignatedInitializer = null;


        try {
            // InternalCoreDsl.g:3785:62: (iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF )
            // InternalCoreDsl.g:3786:2: iv_ruleDesignatedInitializer= ruleDesignatedInitializer EOF
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
    // InternalCoreDsl.g:3792:1: ruleDesignatedInitializer returns [EObject current=null] : ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) ) ;
    public final EObject ruleDesignatedInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_designators_0_0 = null;

        EObject lv_init_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3798:2: ( ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) ) )
            // InternalCoreDsl.g:3799:2: ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) )
            {
            // InternalCoreDsl.g:3799:2: ( ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) ) )
            // InternalCoreDsl.g:3800:3: ( (lv_designators_0_0= ruleDesignator ) )+ otherlv_1= '=' ( (lv_init_2_0= ruleInitializer ) )
            {
            // InternalCoreDsl.g:3800:3: ( (lv_designators_0_0= ruleDesignator ) )+
            int cnt82=0;
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==RULE_LEFT_BR||LA82_0==64) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalCoreDsl.g:3801:4: (lv_designators_0_0= ruleDesignator )
            	    {
            	    // InternalCoreDsl.g:3801:4: (lv_designators_0_0= ruleDesignator )
            	    // InternalCoreDsl.g:3802:5: lv_designators_0_0= ruleDesignator
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDesignatedInitializerAccess().getDesignatorsDesignatorParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_71);
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

            otherlv_1=(Token)match(input,60,FOLLOW_66); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDesignatedInitializerAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalCoreDsl.g:3823:3: ( (lv_init_2_0= ruleInitializer ) )
            // InternalCoreDsl.g:3824:4: (lv_init_2_0= ruleInitializer )
            {
            // InternalCoreDsl.g:3824:4: (lv_init_2_0= ruleInitializer )
            // InternalCoreDsl.g:3825:5: lv_init_2_0= ruleInitializer
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
    // InternalCoreDsl.g:3846:1: entryRuleDesignator returns [EObject current=null] : iv_ruleDesignator= ruleDesignator EOF ;
    public final EObject entryRuleDesignator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesignator = null;


        try {
            // InternalCoreDsl.g:3846:51: (iv_ruleDesignator= ruleDesignator EOF )
            // InternalCoreDsl.g:3847:2: iv_ruleDesignator= ruleDesignator EOF
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
    // InternalCoreDsl.g:3853:1: ruleDesignator returns [EObject current=null] : ( (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) ) ;
    public final EObject ruleDesignator() throws RecognitionException {
        EObject current = null;

        Token this_LEFT_BR_0=null;
        Token this_RIGHT_BR_2=null;
        Token otherlv_3=null;
        Token lv_prop_4_0=null;
        EObject lv_idx_1_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3859:2: ( ( (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) ) )
            // InternalCoreDsl.g:3860:2: ( (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) )
            {
            // InternalCoreDsl.g:3860:2: ( (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR ) | (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_LEFT_BR) ) {
                alt83=1;
            }
            else if ( (LA83_0==64) ) {
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
                    // InternalCoreDsl.g:3861:3: (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR )
                    {
                    // InternalCoreDsl.g:3861:3: (this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR )
                    // InternalCoreDsl.g:3862:4: this_LEFT_BR_0= RULE_LEFT_BR ( (lv_idx_1_0= ruleConstantExpression ) ) this_RIGHT_BR_2= RULE_RIGHT_BR
                    {
                    this_LEFT_BR_0=(Token)match(input,RULE_LEFT_BR,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_LEFT_BR_0, grammarAccess.getDesignatorAccess().getLEFT_BRTerminalRuleCall_0_0());
                      			
                    }
                    // InternalCoreDsl.g:3866:4: ( (lv_idx_1_0= ruleConstantExpression ) )
                    // InternalCoreDsl.g:3867:5: (lv_idx_1_0= ruleConstantExpression )
                    {
                    // InternalCoreDsl.g:3867:5: (lv_idx_1_0= ruleConstantExpression )
                    // InternalCoreDsl.g:3868:6: lv_idx_1_0= ruleConstantExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDesignatorAccess().getIdxConstantExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
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
                    // InternalCoreDsl.g:3891:3: (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:3891:3: (otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) ) )
                    // InternalCoreDsl.g:3892:4: otherlv_3= '.' ( (lv_prop_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,64,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDesignatorAccess().getFullStopKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:3896:4: ( (lv_prop_4_0= RULE_ID ) )
                    // InternalCoreDsl.g:3897:5: (lv_prop_4_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:3897:5: (lv_prop_4_0= RULE_ID )
                    // InternalCoreDsl.g:3898:6: lv_prop_4_0= RULE_ID
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
    // InternalCoreDsl.g:3919:1: entryRuleAbstractDeclarator returns [EObject current=null] : iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF ;
    public final EObject entryRuleAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractDeclarator = null;


        try {
            // InternalCoreDsl.g:3919:59: (iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF )
            // InternalCoreDsl.g:3920:2: iv_ruleAbstractDeclarator= ruleAbstractDeclarator EOF
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
    // InternalCoreDsl.g:3926:1: ruleAbstractDeclarator returns [EObject current=null] : this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator ;
    public final EObject ruleAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject this_DirectAbstractDeclarator_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:3932:2: (this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator )
            // InternalCoreDsl.g:3933:2: this_DirectAbstractDeclarator_0= ruleDirectAbstractDeclarator
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
    // InternalCoreDsl.g:3944:1: entryRuleDirectAbstractDeclarator returns [EObject current=null] : iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF ;
    public final EObject entryRuleDirectAbstractDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectAbstractDeclarator = null;


        try {
            // InternalCoreDsl.g:3944:65: (iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF )
            // InternalCoreDsl.g:3945:2: iv_ruleDirectAbstractDeclarator= ruleDirectAbstractDeclarator EOF
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
    // InternalCoreDsl.g:3951:1: ruleDirectAbstractDeclarator returns [EObject current=null] : ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR ) ) ;
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
            // InternalCoreDsl.g:3957:2: ( ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR ) ) )
            // InternalCoreDsl.g:3958:2: ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR ) )
            {
            // InternalCoreDsl.g:3958:2: ( ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' ) | ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==44) ) {
                alt87=1;
            }
            else if ( (LA87_0==RULE_LEFT_BR) ) {
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
                    // InternalCoreDsl.g:3959:3: ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' )
                    {
                    // InternalCoreDsl.g:3959:3: ( () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')' )
                    // InternalCoreDsl.g:3960:4: () otherlv_1= '(' ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] ) otherlv_4= ')'
                    {
                    // InternalCoreDsl.g:3960:4: ()
                    // InternalCoreDsl.g:3961:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDirectAbstractDeclaratorAccess().getDirectAbstractDeclaratorAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,44,FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectAbstractDeclaratorAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalCoreDsl.g:3971:4: ( ( (lv_declarator_2_0= ruleAbstractDeclarator ) )? | this_ParameterList_3= ruleParameterList[$current] )
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==RULE_LEFT_BR||(LA85_0>=44 && LA85_0<=45)) ) {
                        alt85=1;
                    }
                    else if ( (LA85_0==63||(LA85_0>=100 && LA85_0<=110)||(LA85_0>=120 && LA85_0<=121)) ) {
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
                            // InternalCoreDsl.g:3972:5: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )?
                            {
                            // InternalCoreDsl.g:3972:5: ( (lv_declarator_2_0= ruleAbstractDeclarator ) )?
                            int alt84=2;
                            int LA84_0 = input.LA(1);

                            if ( (LA84_0==RULE_LEFT_BR||LA84_0==44) ) {
                                alt84=1;
                            }
                            switch (alt84) {
                                case 1 :
                                    // InternalCoreDsl.g:3973:6: (lv_declarator_2_0= ruleAbstractDeclarator )
                                    {
                                    // InternalCoreDsl.g:3973:6: (lv_declarator_2_0= ruleAbstractDeclarator )
                                    // InternalCoreDsl.g:3974:7: lv_declarator_2_0= ruleAbstractDeclarator
                                    {
                                    if ( state.backtracking==0 ) {

                                      							newCompositeNode(grammarAccess.getDirectAbstractDeclaratorAccess().getDeclaratorAbstractDeclaratorParserRuleCall_0_2_0_0());
                                      						
                                    }
                                    pushFollow(FOLLOW_40);
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
                            // InternalCoreDsl.g:3992:5: this_ParameterList_3= ruleParameterList[$current]
                            {
                            if ( state.backtracking==0 ) {

                              					if (current==null) {
                              						current = createModelElement(grammarAccess.getDirectAbstractDeclaratorRule());
                              					}
                              					newCompositeNode(grammarAccess.getDirectAbstractDeclaratorAccess().getParameterListParserRuleCall_0_2_1());
                              				
                            }
                            pushFollow(FOLLOW_40);
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

                    otherlv_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDirectAbstractDeclaratorAccess().getRightParenthesisKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4010:3: ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR )
                    {
                    // InternalCoreDsl.g:4010:3: ( () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR )
                    // InternalCoreDsl.g:4011:4: () this_LEFT_BR_6= RULE_LEFT_BR ( (lv_expr_7_0= ruleConstantExpression ) )? this_RIGHT_BR_8= RULE_RIGHT_BR
                    {
                    // InternalCoreDsl.g:4011:4: ()
                    // InternalCoreDsl.g:4012:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDirectAbstractDeclaratorAccess().getDirectAbstractDeclaratorAction_1_0(),
                      						current);
                      				
                    }

                    }

                    this_LEFT_BR_6=(Token)match(input,RULE_LEFT_BR,FOLLOW_73); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_LEFT_BR_6, grammarAccess.getDirectAbstractDeclaratorAccess().getLEFT_BRTerminalRuleCall_1_1());
                      			
                    }
                    // InternalCoreDsl.g:4022:4: ( (lv_expr_7_0= ruleConstantExpression ) )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( ((LA86_0>=RULE_STRING && LA86_0<=RULE_ID)||(LA86_0>=RULE_INTEGER && LA86_0<=RULE_CHARCONST)||LA86_0==44||(LA86_0>=58 && LA86_0<=59)||(LA86_0>=86 && LA86_0<=87)||(LA86_0>=90 && LA86_0<=94)||(LA86_0>=96 && LA86_0<=99)) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalCoreDsl.g:4023:5: (lv_expr_7_0= ruleConstantExpression )
                            {
                            // InternalCoreDsl.g:4023:5: (lv_expr_7_0= ruleConstantExpression )
                            // InternalCoreDsl.g:4024:6: lv_expr_7_0= ruleConstantExpression
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getDirectAbstractDeclaratorAccess().getExprConstantExpressionParserRuleCall_1_2_0());
                              					
                            }
                            pushFollow(FOLLOW_25);
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
    // InternalCoreDsl.g:4050:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalCoreDsl.g:4050:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalCoreDsl.g:4051:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
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
    // InternalCoreDsl.g:4057:1: ruleAssignmentExpression returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )* ) ;
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
            // InternalCoreDsl.g:4063:2: ( (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )* ) )
            // InternalCoreDsl.g:4064:2: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )* )
            {
            // InternalCoreDsl.g:4064:2: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )* )
            // InternalCoreDsl.g:4065:3: this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getPrefixExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_74);
            this_PrefixExpression_0=rulePrefixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrefixExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4073:3: ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==60||(LA89_0>=65 && LA89_0<=74)) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalCoreDsl.g:4074:4: () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) )
            	    {
            	    // InternalCoreDsl.g:4074:4: ()
            	    // InternalCoreDsl.g:4075:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:4081:4: ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) )
            	    // InternalCoreDsl.g:4082:5: ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) )
            	    {
            	    // InternalCoreDsl.g:4082:5: ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) )
            	    // InternalCoreDsl.g:4083:6: (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' )
            	    {
            	    // InternalCoreDsl.g:4083:6: (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' )
            	    int alt88=11;
            	    switch ( input.LA(1) ) {
            	    case 60:
            	        {
            	        alt88=1;
            	        }
            	        break;
            	    case 65:
            	        {
            	        alt88=2;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt88=3;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt88=4;
            	        }
            	        break;
            	    case 68:
            	        {
            	        alt88=5;
            	        }
            	        break;
            	    case 69:
            	        {
            	        alt88=6;
            	        }
            	        break;
            	    case 70:
            	        {
            	        alt88=7;
            	        }
            	        break;
            	    case 71:
            	        {
            	        alt88=8;
            	        }
            	        break;
            	    case 72:
            	        {
            	        alt88=9;
            	        }
            	        break;
            	    case 73:
            	        {
            	        alt88=10;
            	        }
            	        break;
            	    case 74:
            	        {
            	        alt88=11;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 88, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt88) {
            	        case 1 :
            	            // InternalCoreDsl.g:4084:7: lv_assignment_2_1= '='
            	            {
            	            lv_assignment_2_1=(Token)match(input,60,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4095:7: lv_assignment_2_2= '*='
            	            {
            	            lv_assignment_2_2=(Token)match(input,65,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4106:7: lv_assignment_2_3= '/='
            	            {
            	            lv_assignment_2_3=(Token)match(input,66,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4117:7: lv_assignment_2_4= '%='
            	            {
            	            lv_assignment_2_4=(Token)match(input,67,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4128:7: lv_assignment_2_5= '+='
            	            {
            	            lv_assignment_2_5=(Token)match(input,68,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4139:7: lv_assignment_2_6= '-='
            	            {
            	            lv_assignment_2_6=(Token)match(input,69,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4150:7: lv_assignment_2_7= '<<='
            	            {
            	            lv_assignment_2_7=(Token)match(input,70,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4161:7: lv_assignment_2_8= '>>='
            	            {
            	            lv_assignment_2_8=(Token)match(input,71,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4172:7: lv_assignment_2_9= '&='
            	            {
            	            lv_assignment_2_9=(Token)match(input,72,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4183:7: lv_assignment_2_10= '^='
            	            {
            	            lv_assignment_2_10=(Token)match(input,73,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4194:7: lv_assignment_2_11= '|='
            	            {
            	            lv_assignment_2_11=(Token)match(input,74,FOLLOW_43); if (state.failed) return current;
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

            	    // InternalCoreDsl.g:4207:4: ( (lv_rights_3_0= ruleConditionalExpression ) )
            	    // InternalCoreDsl.g:4208:5: (lv_rights_3_0= ruleConditionalExpression )
            	    {
            	    // InternalCoreDsl.g:4208:5: (lv_rights_3_0= ruleConditionalExpression )
            	    // InternalCoreDsl.g:4209:6: lv_rights_3_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightsConditionalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_74);
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
            	    break loop89;
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
    // InternalCoreDsl.g:4231:1: entryRuleAssignmentExpression2 returns [EObject current=null] : iv_ruleAssignmentExpression2= ruleAssignmentExpression2 EOF ;
    public final EObject entryRuleAssignmentExpression2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression2 = null;


        try {
            // InternalCoreDsl.g:4231:62: (iv_ruleAssignmentExpression2= ruleAssignmentExpression2 EOF )
            // InternalCoreDsl.g:4232:2: iv_ruleAssignmentExpression2= ruleAssignmentExpression2 EOF
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
    // InternalCoreDsl.g:4238:1: ruleAssignmentExpression2 returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ ) ;
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
            // InternalCoreDsl.g:4244:2: ( (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ ) )
            // InternalCoreDsl.g:4245:2: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ )
            {
            // InternalCoreDsl.g:4245:2: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+ )
            // InternalCoreDsl.g:4246:3: this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpression2Access().getPrefixExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_75);
            this_PrefixExpression_0=rulePrefixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrefixExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4254:3: ( () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) ) )+
            int cnt91=0;
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==60||(LA91_0>=65 && LA91_0<=74)) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalCoreDsl.g:4255:4: () ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) ) ( (lv_rights_3_0= ruleConditionalExpression ) )
            	    {
            	    // InternalCoreDsl.g:4255:4: ()
            	    // InternalCoreDsl.g:4256:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAssignmentExpression2Access().getAssignmentExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:4262:4: ( ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) ) )
            	    // InternalCoreDsl.g:4263:5: ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) )
            	    {
            	    // InternalCoreDsl.g:4263:5: ( (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' ) )
            	    // InternalCoreDsl.g:4264:6: (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' )
            	    {
            	    // InternalCoreDsl.g:4264:6: (lv_assignment_2_1= '=' | lv_assignment_2_2= '*=' | lv_assignment_2_3= '/=' | lv_assignment_2_4= '%=' | lv_assignment_2_5= '+=' | lv_assignment_2_6= '-=' | lv_assignment_2_7= '<<=' | lv_assignment_2_8= '>>=' | lv_assignment_2_9= '&=' | lv_assignment_2_10= '^=' | lv_assignment_2_11= '|=' )
            	    int alt90=11;
            	    switch ( input.LA(1) ) {
            	    case 60:
            	        {
            	        alt90=1;
            	        }
            	        break;
            	    case 65:
            	        {
            	        alt90=2;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt90=3;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt90=4;
            	        }
            	        break;
            	    case 68:
            	        {
            	        alt90=5;
            	        }
            	        break;
            	    case 69:
            	        {
            	        alt90=6;
            	        }
            	        break;
            	    case 70:
            	        {
            	        alt90=7;
            	        }
            	        break;
            	    case 71:
            	        {
            	        alt90=8;
            	        }
            	        break;
            	    case 72:
            	        {
            	        alt90=9;
            	        }
            	        break;
            	    case 73:
            	        {
            	        alt90=10;
            	        }
            	        break;
            	    case 74:
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
            	            // InternalCoreDsl.g:4265:7: lv_assignment_2_1= '='
            	            {
            	            lv_assignment_2_1=(Token)match(input,60,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4276:7: lv_assignment_2_2= '*='
            	            {
            	            lv_assignment_2_2=(Token)match(input,65,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4287:7: lv_assignment_2_3= '/='
            	            {
            	            lv_assignment_2_3=(Token)match(input,66,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4298:7: lv_assignment_2_4= '%='
            	            {
            	            lv_assignment_2_4=(Token)match(input,67,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4309:7: lv_assignment_2_5= '+='
            	            {
            	            lv_assignment_2_5=(Token)match(input,68,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4320:7: lv_assignment_2_6= '-='
            	            {
            	            lv_assignment_2_6=(Token)match(input,69,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4331:7: lv_assignment_2_7= '<<='
            	            {
            	            lv_assignment_2_7=(Token)match(input,70,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4342:7: lv_assignment_2_8= '>>='
            	            {
            	            lv_assignment_2_8=(Token)match(input,71,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4353:7: lv_assignment_2_9= '&='
            	            {
            	            lv_assignment_2_9=(Token)match(input,72,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4364:7: lv_assignment_2_10= '^='
            	            {
            	            lv_assignment_2_10=(Token)match(input,73,FOLLOW_43); if (state.failed) return current;
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
            	            // InternalCoreDsl.g:4375:7: lv_assignment_2_11= '|='
            	            {
            	            lv_assignment_2_11=(Token)match(input,74,FOLLOW_43); if (state.failed) return current;
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

            	    // InternalCoreDsl.g:4388:4: ( (lv_rights_3_0= ruleConditionalExpression ) )
            	    // InternalCoreDsl.g:4389:5: (lv_rights_3_0= ruleConditionalExpression )
            	    {
            	    // InternalCoreDsl.g:4389:5: (lv_rights_3_0= ruleConditionalExpression )
            	    // InternalCoreDsl.g:4390:6: lv_rights_3_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAssignmentExpression2Access().getRightsConditionalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_74);
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
    // $ANTLR end "ruleAssignmentExpression2"


    // $ANTLR start "entryRuleConditionalExpression"
    // InternalCoreDsl.g:4412:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalCoreDsl.g:4412:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalCoreDsl.g:4413:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalCoreDsl.g:4419:1: ruleConditionalExpression returns [EObject current=null] : (this_ConcatenationExpression_0= ruleConcatenationExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_ConcatenationExpression_0 = null;

        EObject lv_left_3_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4425:2: ( (this_ConcatenationExpression_0= ruleConcatenationExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? ) )
            // InternalCoreDsl.g:4426:2: (this_ConcatenationExpression_0= ruleConcatenationExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? )
            {
            // InternalCoreDsl.g:4426:2: (this_ConcatenationExpression_0= ruleConcatenationExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )? )
            // InternalCoreDsl.g:4427:3: this_ConcatenationExpression_0= ruleConcatenationExpression ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConditionalExpressionAccess().getConcatenationExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_76);
            this_ConcatenationExpression_0=ruleConcatenationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ConcatenationExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4435:3: ( () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==75) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalCoreDsl.g:4436:4: () otherlv_2= '?' ( (lv_left_3_0= ruleConditionalExpression ) ) otherlv_4= ':' ( (lv_right_5_0= ruleConditionalExpression ) )
                    {
                    // InternalCoreDsl.g:4436:4: ()
                    // InternalCoreDsl.g:4437:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getConditionalExpressionAccess().getConditionalExpressionCondAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,75,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1());
                      			
                    }
                    // InternalCoreDsl.g:4447:4: ( (lv_left_3_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:4448:5: (lv_left_3_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:4448:5: (lv_left_3_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:4449:6: lv_left_3_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLeftConditionalExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
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

                    otherlv_4=(Token)match(input,37,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                      			
                    }
                    // InternalCoreDsl.g:4470:4: ( (lv_right_5_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:4471:5: (lv_right_5_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:4471:5: (lv_right_5_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:4472:6: lv_right_5_0= ruleConditionalExpression
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
    // InternalCoreDsl.g:4494:1: entryRuleConcatenationExpression returns [EObject current=null] : iv_ruleConcatenationExpression= ruleConcatenationExpression EOF ;
    public final EObject entryRuleConcatenationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatenationExpression = null;


        try {
            // InternalCoreDsl.g:4494:64: (iv_ruleConcatenationExpression= ruleConcatenationExpression EOF )
            // InternalCoreDsl.g:4495:2: iv_ruleConcatenationExpression= ruleConcatenationExpression EOF
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
    // InternalCoreDsl.g:4501:1: ruleConcatenationExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )? ) ;
    public final EObject ruleConcatenationExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4507:2: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )? ) )
            // InternalCoreDsl.g:4508:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )? )
            {
            // InternalCoreDsl.g:4508:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )? )
            // InternalCoreDsl.g:4509:3: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConcatenationExpressionAccess().getLogicalOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_33);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4517:3: ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==41) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalCoreDsl.g:4518:4: () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleConcatenationExpression ) )
                    {
                    // InternalCoreDsl.g:4518:4: ()
                    // InternalCoreDsl.g:4519:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getConcatenationExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4525:4: ( (lv_op_2_0= '::' ) )
                    // InternalCoreDsl.g:4526:5: (lv_op_2_0= '::' )
                    {
                    // InternalCoreDsl.g:4526:5: (lv_op_2_0= '::' )
                    // InternalCoreDsl.g:4527:6: lv_op_2_0= '::'
                    {
                    lv_op_2_0=(Token)match(input,41,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4539:4: ( (lv_right_3_0= ruleConcatenationExpression ) )
                    // InternalCoreDsl.g:4540:5: (lv_right_3_0= ruleConcatenationExpression )
                    {
                    // InternalCoreDsl.g:4540:5: (lv_right_3_0= ruleConcatenationExpression )
                    // InternalCoreDsl.g:4541:6: lv_right_3_0= ruleConcatenationExpression
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
    // InternalCoreDsl.g:4563:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalCoreDsl.g:4563:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalCoreDsl.g:4564:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalCoreDsl.g:4570:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4576:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4577:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4577:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )? )
            // InternalCoreDsl.g:4578:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )?
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
            // InternalCoreDsl.g:4586:3: ( () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==76) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalCoreDsl.g:4587:4: () ( (lv_op_2_0= '||' ) ) ( (lv_right_3_0= ruleLogicalOrExpression ) )
                    {
                    // InternalCoreDsl.g:4587:4: ()
                    // InternalCoreDsl.g:4588:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getLogicalOrExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4594:4: ( (lv_op_2_0= '||' ) )
                    // InternalCoreDsl.g:4595:5: (lv_op_2_0= '||' )
                    {
                    // InternalCoreDsl.g:4595:5: (lv_op_2_0= '||' )
                    // InternalCoreDsl.g:4596:6: lv_op_2_0= '||'
                    {
                    lv_op_2_0=(Token)match(input,76,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4608:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
                    // InternalCoreDsl.g:4609:5: (lv_right_3_0= ruleLogicalOrExpression )
                    {
                    // InternalCoreDsl.g:4609:5: (lv_right_3_0= ruleLogicalOrExpression )
                    // InternalCoreDsl.g:4610:6: lv_right_3_0= ruleLogicalOrExpression
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
    // InternalCoreDsl.g:4632:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalCoreDsl.g:4632:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalCoreDsl.g:4633:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalCoreDsl.g:4639:1: ruleLogicalAndExpression returns [EObject current=null] : (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_InclusiveOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4645:2: ( (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? ) )
            // InternalCoreDsl.g:4646:2: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? )
            {
            // InternalCoreDsl.g:4646:2: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )? )
            // InternalCoreDsl.g:4647:3: this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )?
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
            // InternalCoreDsl.g:4655:3: ( () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==77) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalCoreDsl.g:4656:4: () ( (lv_op_2_0= '&&' ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    {
                    // InternalCoreDsl.g:4656:4: ()
                    // InternalCoreDsl.g:4657:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getLogicalAndExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4663:4: ( (lv_op_2_0= '&&' ) )
                    // InternalCoreDsl.g:4664:5: (lv_op_2_0= '&&' )
                    {
                    // InternalCoreDsl.g:4664:5: (lv_op_2_0= '&&' )
                    // InternalCoreDsl.g:4665:6: lv_op_2_0= '&&'
                    {
                    lv_op_2_0=(Token)match(input,77,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4677:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    // InternalCoreDsl.g:4678:5: (lv_right_3_0= ruleLogicalAndExpression )
                    {
                    // InternalCoreDsl.g:4678:5: (lv_right_3_0= ruleLogicalAndExpression )
                    // InternalCoreDsl.g:4679:6: lv_right_3_0= ruleLogicalAndExpression
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
    // InternalCoreDsl.g:4701:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // InternalCoreDsl.g:4701:62: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // InternalCoreDsl.g:4702:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
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
    // InternalCoreDsl.g:4708:1: ruleInclusiveOrExpression returns [EObject current=null] : (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_ExclusiveOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4714:2: ( (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4715:2: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4715:2: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )? )
            // InternalCoreDsl.g:4716:3: this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExclusiveOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_79);
            this_ExclusiveOrExpression_0=ruleExclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExclusiveOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4724:3: ( () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==78) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalCoreDsl.g:4725:4: () ( (lv_op_2_0= '|' ) ) ( (lv_right_3_0= ruleInclusiveOrExpression ) )
                    {
                    // InternalCoreDsl.g:4725:4: ()
                    // InternalCoreDsl.g:4726:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getInclusiveOrExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4732:4: ( (lv_op_2_0= '|' ) )
                    // InternalCoreDsl.g:4733:5: (lv_op_2_0= '|' )
                    {
                    // InternalCoreDsl.g:4733:5: (lv_op_2_0= '|' )
                    // InternalCoreDsl.g:4734:6: lv_op_2_0= '|'
                    {
                    lv_op_2_0=(Token)match(input,78,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4746:4: ( (lv_right_3_0= ruleInclusiveOrExpression ) )
                    // InternalCoreDsl.g:4747:5: (lv_right_3_0= ruleInclusiveOrExpression )
                    {
                    // InternalCoreDsl.g:4747:5: (lv_right_3_0= ruleInclusiveOrExpression )
                    // InternalCoreDsl.g:4748:6: lv_right_3_0= ruleInclusiveOrExpression
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
    // InternalCoreDsl.g:4770:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // InternalCoreDsl.g:4770:62: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // InternalCoreDsl.g:4771:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
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
    // InternalCoreDsl.g:4777:1: ruleExclusiveOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4783:2: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? ) )
            // InternalCoreDsl.g:4784:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? )
            {
            // InternalCoreDsl.g:4784:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )? )
            // InternalCoreDsl.g:4785:3: this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_80);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4793:3: ( () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==79) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalCoreDsl.g:4794:4: () ( (lv_op_2_0= '^' ) ) ( (lv_right_3_0= ruleExclusiveOrExpression ) )
                    {
                    // InternalCoreDsl.g:4794:4: ()
                    // InternalCoreDsl.g:4795:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getExclusiveOrExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4801:4: ( (lv_op_2_0= '^' ) )
                    // InternalCoreDsl.g:4802:5: (lv_op_2_0= '^' )
                    {
                    // InternalCoreDsl.g:4802:5: (lv_op_2_0= '^' )
                    // InternalCoreDsl.g:4803:6: lv_op_2_0= '^'
                    {
                    lv_op_2_0=(Token)match(input,79,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4815:4: ( (lv_right_3_0= ruleExclusiveOrExpression ) )
                    // InternalCoreDsl.g:4816:5: (lv_right_3_0= ruleExclusiveOrExpression )
                    {
                    // InternalCoreDsl.g:4816:5: (lv_right_3_0= ruleExclusiveOrExpression )
                    // InternalCoreDsl.g:4817:6: lv_right_3_0= ruleExclusiveOrExpression
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
    // InternalCoreDsl.g:4839:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalCoreDsl.g:4839:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalCoreDsl.g:4840:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalCoreDsl.g:4846:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4852:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? ) )
            // InternalCoreDsl.g:4853:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? )
            {
            // InternalCoreDsl.g:4853:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )? )
            // InternalCoreDsl.g:4854:3: this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_81);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4862:3: ( () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==59) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalCoreDsl.g:4863:4: () ( (lv_op_2_0= '&' ) ) ( (lv_right_3_0= ruleAndExpression ) )
                    {
                    // InternalCoreDsl.g:4863:4: ()
                    // InternalCoreDsl.g:4864:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAndExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4870:4: ( (lv_op_2_0= '&' ) )
                    // InternalCoreDsl.g:4871:5: (lv_op_2_0= '&' )
                    {
                    // InternalCoreDsl.g:4871:5: (lv_op_2_0= '&' )
                    // InternalCoreDsl.g:4872:6: lv_op_2_0= '&'
                    {
                    lv_op_2_0=(Token)match(input,59,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4884:4: ( (lv_right_3_0= ruleAndExpression ) )
                    // InternalCoreDsl.g:4885:5: (lv_right_3_0= ruleAndExpression )
                    {
                    // InternalCoreDsl.g:4885:5: (lv_right_3_0= ruleAndExpression )
                    // InternalCoreDsl.g:4886:6: lv_right_3_0= ruleAndExpression
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
    // InternalCoreDsl.g:4908:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalCoreDsl.g:4908:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalCoreDsl.g:4909:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalCoreDsl.g:4915:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:4921:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? ) )
            // InternalCoreDsl.g:4922:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? )
            {
            // InternalCoreDsl.g:4922:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )? )
            // InternalCoreDsl.g:4923:3: this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_82);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:4931:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( ((LA100_0>=80 && LA100_0<=81)) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalCoreDsl.g:4932:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
                    {
                    // InternalCoreDsl.g:4932:4: ()
                    // InternalCoreDsl.g:4933:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getEqualityExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:4939:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
                    // InternalCoreDsl.g:4940:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
                    {
                    // InternalCoreDsl.g:4940:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
                    // InternalCoreDsl.g:4941:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
                    {
                    // InternalCoreDsl.g:4941:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==80) ) {
                        alt99=1;
                    }
                    else if ( (LA99_0==81) ) {
                        alt99=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 99, 0, input);

                        throw nvae;
                    }
                    switch (alt99) {
                        case 1 :
                            // InternalCoreDsl.g:4942:7: lv_op_2_1= '=='
                            {
                            lv_op_2_1=(Token)match(input,80,FOLLOW_43); if (state.failed) return current;
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
                            // InternalCoreDsl.g:4953:7: lv_op_2_2= '!='
                            {
                            lv_op_2_2=(Token)match(input,81,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:4966:4: ( (lv_right_3_0= ruleEqualityExpression ) )
                    // InternalCoreDsl.g:4967:5: (lv_right_3_0= ruleEqualityExpression )
                    {
                    // InternalCoreDsl.g:4967:5: (lv_right_3_0= ruleEqualityExpression )
                    // InternalCoreDsl.g:4968:6: lv_right_3_0= ruleEqualityExpression
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
    // InternalCoreDsl.g:4990:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalCoreDsl.g:4990:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalCoreDsl.g:4991:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalCoreDsl.g:4997:1: ruleRelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? ) ;
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
            // InternalCoreDsl.g:5003:2: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? ) )
            // InternalCoreDsl.g:5004:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? )
            {
            // InternalCoreDsl.g:5004:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )? )
            // InternalCoreDsl.g:5005:3: this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_83);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5013:3: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( ((LA102_0>=61 && LA102_0<=62)||(LA102_0>=82 && LA102_0<=83)) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalCoreDsl.g:5014:4: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
                    {
                    // InternalCoreDsl.g:5014:4: ()
                    // InternalCoreDsl.g:5015:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getRelationalExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5021:4: ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
                    // InternalCoreDsl.g:5022:5: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
                    {
                    // InternalCoreDsl.g:5022:5: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
                    // InternalCoreDsl.g:5023:6: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
                    {
                    // InternalCoreDsl.g:5023:6: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
                    int alt101=4;
                    switch ( input.LA(1) ) {
                    case 61:
                        {
                        alt101=1;
                        }
                        break;
                    case 62:
                        {
                        alt101=2;
                        }
                        break;
                    case 82:
                        {
                        alt101=3;
                        }
                        break;
                    case 83:
                        {
                        alt101=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 101, 0, input);

                        throw nvae;
                    }

                    switch (alt101) {
                        case 1 :
                            // InternalCoreDsl.g:5024:7: lv_op_2_1= '<'
                            {
                            lv_op_2_1=(Token)match(input,61,FOLLOW_43); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5035:7: lv_op_2_2= '>'
                            {
                            lv_op_2_2=(Token)match(input,62,FOLLOW_43); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5046:7: lv_op_2_3= '<='
                            {
                            lv_op_2_3=(Token)match(input,82,FOLLOW_43); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5057:7: lv_op_2_4= '>='
                            {
                            lv_op_2_4=(Token)match(input,83,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5070:4: ( (lv_right_3_0= ruleRelationalExpression ) )
                    // InternalCoreDsl.g:5071:5: (lv_right_3_0= ruleRelationalExpression )
                    {
                    // InternalCoreDsl.g:5071:5: (lv_right_3_0= ruleRelationalExpression )
                    // InternalCoreDsl.g:5072:6: lv_right_3_0= ruleRelationalExpression
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
    // InternalCoreDsl.g:5094:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalCoreDsl.g:5094:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalCoreDsl.g:5095:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalCoreDsl.g:5101:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5107:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? ) )
            // InternalCoreDsl.g:5108:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? )
            {
            // InternalCoreDsl.g:5108:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )? )
            // InternalCoreDsl.g:5109:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_84);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5117:3: ( () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( ((LA104_0>=84 && LA104_0<=85)) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalCoreDsl.g:5118:4: () ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) ) ( (lv_right_3_0= ruleShiftExpression ) )
                    {
                    // InternalCoreDsl.g:5118:4: ()
                    // InternalCoreDsl.g:5119:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getShiftExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5125:4: ( ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) ) )
                    // InternalCoreDsl.g:5126:5: ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) )
                    {
                    // InternalCoreDsl.g:5126:5: ( (lv_op_2_1= '<<' | lv_op_2_2= '>>' ) )
                    // InternalCoreDsl.g:5127:6: (lv_op_2_1= '<<' | lv_op_2_2= '>>' )
                    {
                    // InternalCoreDsl.g:5127:6: (lv_op_2_1= '<<' | lv_op_2_2= '>>' )
                    int alt103=2;
                    int LA103_0 = input.LA(1);

                    if ( (LA103_0==84) ) {
                        alt103=1;
                    }
                    else if ( (LA103_0==85) ) {
                        alt103=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 103, 0, input);

                        throw nvae;
                    }
                    switch (alt103) {
                        case 1 :
                            // InternalCoreDsl.g:5128:7: lv_op_2_1= '<<'
                            {
                            lv_op_2_1=(Token)match(input,84,FOLLOW_43); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5139:7: lv_op_2_2= '>>'
                            {
                            lv_op_2_2=(Token)match(input,85,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5152:4: ( (lv_right_3_0= ruleShiftExpression ) )
                    // InternalCoreDsl.g:5153:5: (lv_right_3_0= ruleShiftExpression )
                    {
                    // InternalCoreDsl.g:5153:5: (lv_right_3_0= ruleShiftExpression )
                    // InternalCoreDsl.g:5154:6: lv_right_3_0= ruleShiftExpression
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
    // InternalCoreDsl.g:5176:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalCoreDsl.g:5176:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalCoreDsl.g:5177:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalCoreDsl.g:5183:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5189:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) )
            // InternalCoreDsl.g:5190:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            {
            // InternalCoreDsl.g:5190:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            // InternalCoreDsl.g:5191:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_85);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5199:3: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( ((LA106_0>=86 && LA106_0<=87)) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalCoreDsl.g:5200:4: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
                    {
                    // InternalCoreDsl.g:5200:4: ()
                    // InternalCoreDsl.g:5201:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAdditiveExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5207:4: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    // InternalCoreDsl.g:5208:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    {
                    // InternalCoreDsl.g:5208:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    // InternalCoreDsl.g:5209:6: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    {
                    // InternalCoreDsl.g:5209:6: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==86) ) {
                        alt105=1;
                    }
                    else if ( (LA105_0==87) ) {
                        alt105=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 105, 0, input);

                        throw nvae;
                    }
                    switch (alt105) {
                        case 1 :
                            // InternalCoreDsl.g:5210:7: lv_op_2_1= '+'
                            {
                            lv_op_2_1=(Token)match(input,86,FOLLOW_43); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5221:7: lv_op_2_2= '-'
                            {
                            lv_op_2_2=(Token)match(input,87,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5234:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
                    // InternalCoreDsl.g:5235:5: (lv_right_3_0= ruleAdditiveExpression )
                    {
                    // InternalCoreDsl.g:5235:5: (lv_right_3_0= ruleAdditiveExpression )
                    // InternalCoreDsl.g:5236:6: lv_right_3_0= ruleAdditiveExpression
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
    // InternalCoreDsl.g:5258:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalCoreDsl.g:5258:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalCoreDsl.g:5259:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalCoreDsl.g:5265:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_CastExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5271:2: ( (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? ) )
            // InternalCoreDsl.g:5272:2: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? )
            {
            // InternalCoreDsl.g:5272:2: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )? )
            // InternalCoreDsl.g:5273:3: this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_86);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CastExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5281:3: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==58||(LA108_0>=88 && LA108_0<=89)) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalCoreDsl.g:5282:4: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    {
                    // InternalCoreDsl.g:5282:4: ()
                    // InternalCoreDsl.g:5283:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getMultiplicativeExpressionAccess().getInfixExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCoreDsl.g:5289:4: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) )
                    // InternalCoreDsl.g:5290:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
                    {
                    // InternalCoreDsl.g:5290:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
                    // InternalCoreDsl.g:5291:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
                    {
                    // InternalCoreDsl.g:5291:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
                    int alt107=3;
                    switch ( input.LA(1) ) {
                    case 58:
                        {
                        alt107=1;
                        }
                        break;
                    case 88:
                        {
                        alt107=2;
                        }
                        break;
                    case 89:
                        {
                        alt107=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 107, 0, input);

                        throw nvae;
                    }

                    switch (alt107) {
                        case 1 :
                            // InternalCoreDsl.g:5292:7: lv_op_2_1= '*'
                            {
                            lv_op_2_1=(Token)match(input,58,FOLLOW_43); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5303:7: lv_op_2_2= '/'
                            {
                            lv_op_2_2=(Token)match(input,88,FOLLOW_43); if (state.failed) return current;
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
                            // InternalCoreDsl.g:5314:7: lv_op_2_3= '%'
                            {
                            lv_op_2_3=(Token)match(input,89,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5327:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    // InternalCoreDsl.g:5328:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    {
                    // InternalCoreDsl.g:5328:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    // InternalCoreDsl.g:5329:6: lv_right_3_0= ruleMultiplicativeExpression
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
    // InternalCoreDsl.g:5351:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalCoreDsl.g:5351:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalCoreDsl.g:5352:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalCoreDsl.g:5358:1: ruleCastExpression returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_size_3_0= ruleBitSizeSpecifier ) )? otherlv_4= ')' ( (lv_left_5_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_PrefixExpression_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_size_3_0 = null;

        EObject lv_left_5_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5364:2: ( (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_size_3_0= ruleBitSizeSpecifier ) )? otherlv_4= ')' ( (lv_left_5_0= ruleCastExpression ) ) ) ) )
            // InternalCoreDsl.g:5365:2: (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_size_3_0= ruleBitSizeSpecifier ) )? otherlv_4= ')' ( (lv_left_5_0= ruleCastExpression ) ) ) )
            {
            // InternalCoreDsl.g:5365:2: (this_PrefixExpression_0= rulePrefixExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_size_3_0= ruleBitSizeSpecifier ) )? otherlv_4= ')' ( (lv_left_5_0= ruleCastExpression ) ) ) )
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( ((LA110_0>=RULE_STRING && LA110_0<=RULE_ID)||(LA110_0>=RULE_INTEGER && LA110_0<=RULE_CHARCONST)||(LA110_0>=58 && LA110_0<=59)||(LA110_0>=86 && LA110_0<=87)||(LA110_0>=90 && LA110_0<=94)||(LA110_0>=96 && LA110_0<=99)) ) {
                alt110=1;
            }
            else if ( (LA110_0==44) ) {
                int LA110_2 = input.LA(2);

                if ( ((LA110_2>=RULE_STRING && LA110_2<=RULE_ID)||(LA110_2>=RULE_INTEGER && LA110_2<=RULE_CHARCONST)||LA110_2==44||(LA110_2>=58 && LA110_2<=59)||(LA110_2>=86 && LA110_2<=87)||(LA110_2>=90 && LA110_2<=94)||(LA110_2>=96 && LA110_2<=99)) ) {
                    alt110=1;
                }
                else if ( (LA110_2==63||(LA110_2>=100 && LA110_2<=110)||(LA110_2>=120 && LA110_2<=121)) ) {
                    alt110=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 110, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }
            switch (alt110) {
                case 1 :
                    // InternalCoreDsl.g:5366:3: this_PrefixExpression_0= rulePrefixExpression
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
                    // InternalCoreDsl.g:5375:3: (otherlv_1= '(' ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_size_3_0= ruleBitSizeSpecifier ) )? otherlv_4= ')' ( (lv_left_5_0= ruleCastExpression ) ) )
                    {
                    // InternalCoreDsl.g:5375:3: (otherlv_1= '(' ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_size_3_0= ruleBitSizeSpecifier ) )? otherlv_4= ')' ( (lv_left_5_0= ruleCastExpression ) ) )
                    // InternalCoreDsl.g:5376:4: otherlv_1= '(' ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_size_3_0= ruleBitSizeSpecifier ) )? otherlv_4= ')' ( (lv_left_5_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalCoreDsl.g:5380:4: ( (lv_type_2_0= ruleTypeSpecifier ) )
                    // InternalCoreDsl.g:5381:5: (lv_type_2_0= ruleTypeSpecifier )
                    {
                    // InternalCoreDsl.g:5381:5: (lv_type_2_0= ruleTypeSpecifier )
                    // InternalCoreDsl.g:5382:6: lv_type_2_0= ruleTypeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeTypeSpecifierParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_87);
                    lv_type_2_0=ruleTypeSpecifier();

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
                      							"com.minres.coredsl.CoreDsl.TypeSpecifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCoreDsl.g:5399:4: ( (lv_size_3_0= ruleBitSizeSpecifier ) )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==61) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // InternalCoreDsl.g:5400:5: (lv_size_3_0= ruleBitSizeSpecifier )
                            {
                            // InternalCoreDsl.g:5400:5: (lv_size_3_0= ruleBitSizeSpecifier )
                            // InternalCoreDsl.g:5401:6: lv_size_3_0= ruleBitSizeSpecifier
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getCastExpressionAccess().getSizeBitSizeSpecifierParserRuleCall_1_2_0());
                              					
                            }
                            pushFollow(FOLLOW_40);
                            lv_size_3_0=ruleBitSizeSpecifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                              						}
                              						set(
                              							current,
                              							"size",
                              							lv_size_3_0,
                              							"com.minres.coredsl.CoreDsl.BitSizeSpecifier");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,45,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_3());
                      			
                    }
                    // InternalCoreDsl.g:5422:4: ( (lv_left_5_0= ruleCastExpression ) )
                    // InternalCoreDsl.g:5423:5: (lv_left_5_0= ruleCastExpression )
                    {
                    // InternalCoreDsl.g:5423:5: (lv_left_5_0= ruleCastExpression )
                    // InternalCoreDsl.g:5424:6: lv_left_5_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getLeftCastExpressionParserRuleCall_1_4_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_left_5_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_5_0,
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
    // InternalCoreDsl.g:5446:1: entryRulePrefixExpression returns [EObject current=null] : iv_rulePrefixExpression= rulePrefixExpression EOF ;
    public final EObject entryRulePrefixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpression = null;


        try {
            // InternalCoreDsl.g:5446:57: (iv_rulePrefixExpression= rulePrefixExpression EOF )
            // InternalCoreDsl.g:5447:2: iv_rulePrefixExpression= rulePrefixExpression EOF
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
    // InternalCoreDsl.g:5453:1: rulePrefixExpression returns [EObject current=null] : (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleTypeSpecifier ) ) ) otherlv_11= ')' ) ) ;
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
            // InternalCoreDsl.g:5459:2: ( (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleTypeSpecifier ) ) ) otherlv_11= ')' ) ) )
            // InternalCoreDsl.g:5460:2: (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleTypeSpecifier ) ) ) otherlv_11= ')' ) )
            {
            // InternalCoreDsl.g:5460:2: (this_PostfixExpression_0= rulePostfixExpression | ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) ) | ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) ) | (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) ) | ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleTypeSpecifier ) ) ) otherlv_11= ')' ) )
            int alt112=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
            case 44:
            case 96:
            case 97:
            case 98:
            case 99:
                {
                alt112=1;
                }
                break;
            case 90:
                {
                alt112=2;
                }
                break;
            case 91:
                {
                alt112=3;
                }
                break;
            case 58:
            case 59:
            case 86:
            case 87:
            case 93:
            case 94:
                {
                alt112=4;
                }
                break;
            case 92:
                {
                alt112=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }

            switch (alt112) {
                case 1 :
                    // InternalCoreDsl.g:5461:3: this_PostfixExpression_0= rulePostfixExpression
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
                    // InternalCoreDsl.g:5470:3: ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) )
                    {
                    // InternalCoreDsl.g:5470:3: ( ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) ) )
                    // InternalCoreDsl.g:5471:4: ( (lv_op_1_0= '++' ) ) ( (lv_left_2_0= rulePrefixExpression ) )
                    {
                    // InternalCoreDsl.g:5471:4: ( (lv_op_1_0= '++' ) )
                    // InternalCoreDsl.g:5472:5: (lv_op_1_0= '++' )
                    {
                    // InternalCoreDsl.g:5472:5: (lv_op_1_0= '++' )
                    // InternalCoreDsl.g:5473:6: lv_op_1_0= '++'
                    {
                    lv_op_1_0=(Token)match(input,90,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5485:4: ( (lv_left_2_0= rulePrefixExpression ) )
                    // InternalCoreDsl.g:5486:5: (lv_left_2_0= rulePrefixExpression )
                    {
                    // InternalCoreDsl.g:5486:5: (lv_left_2_0= rulePrefixExpression )
                    // InternalCoreDsl.g:5487:6: lv_left_2_0= rulePrefixExpression
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
                    // InternalCoreDsl.g:5506:3: ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) )
                    {
                    // InternalCoreDsl.g:5506:3: ( ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) ) )
                    // InternalCoreDsl.g:5507:4: ( (lv_op_3_0= '--' ) ) ( (lv_left_4_0= rulePrefixExpression ) )
                    {
                    // InternalCoreDsl.g:5507:4: ( (lv_op_3_0= '--' ) )
                    // InternalCoreDsl.g:5508:5: (lv_op_3_0= '--' )
                    {
                    // InternalCoreDsl.g:5508:5: (lv_op_3_0= '--' )
                    // InternalCoreDsl.g:5509:6: lv_op_3_0= '--'
                    {
                    lv_op_3_0=(Token)match(input,91,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5521:4: ( (lv_left_4_0= rulePrefixExpression ) )
                    // InternalCoreDsl.g:5522:5: (lv_left_4_0= rulePrefixExpression )
                    {
                    // InternalCoreDsl.g:5522:5: (lv_left_4_0= rulePrefixExpression )
                    // InternalCoreDsl.g:5523:6: lv_left_4_0= rulePrefixExpression
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
                    // InternalCoreDsl.g:5542:3: (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) )
                    {
                    // InternalCoreDsl.g:5542:3: (this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) ) )
                    // InternalCoreDsl.g:5543:4: this_UnaryOperator_5= ruleUnaryOperator[$current] ( (lv_left_6_0= ruleCastExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getPrefixExpressionRule());
                      				}
                      				newCompositeNode(grammarAccess.getPrefixExpressionAccess().getUnaryOperatorParserRuleCall_3_0());
                      			
                    }
                    pushFollow(FOLLOW_43);
                    this_UnaryOperator_5=ruleUnaryOperator(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_UnaryOperator_5;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCoreDsl.g:5554:4: ( (lv_left_6_0= ruleCastExpression ) )
                    // InternalCoreDsl.g:5555:5: (lv_left_6_0= ruleCastExpression )
                    {
                    // InternalCoreDsl.g:5555:5: (lv_left_6_0= ruleCastExpression )
                    // InternalCoreDsl.g:5556:6: lv_left_6_0= ruleCastExpression
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
                    // InternalCoreDsl.g:5575:3: ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleTypeSpecifier ) ) ) otherlv_11= ')' )
                    {
                    // InternalCoreDsl.g:5575:3: ( ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleTypeSpecifier ) ) ) otherlv_11= ')' )
                    // InternalCoreDsl.g:5576:4: ( (lv_op_7_0= 'sizeof' ) ) otherlv_8= '(' ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleTypeSpecifier ) ) ) otherlv_11= ')'
                    {
                    // InternalCoreDsl.g:5576:4: ( (lv_op_7_0= 'sizeof' ) )
                    // InternalCoreDsl.g:5577:5: (lv_op_7_0= 'sizeof' )
                    {
                    // InternalCoreDsl.g:5577:5: (lv_op_7_0= 'sizeof' )
                    // InternalCoreDsl.g:5578:6: lv_op_7_0= 'sizeof'
                    {
                    lv_op_7_0=(Token)match(input,92,FOLLOW_38); if (state.failed) return current;
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

                    otherlv_8=(Token)match(input,44,FOLLOW_88); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getPrefixExpressionAccess().getLeftParenthesisKeyword_4_1());
                      			
                    }
                    // InternalCoreDsl.g:5594:4: ( ( (lv_left_9_0= rulePostfixExpression ) ) | ( (lv_type_10_0= ruleTypeSpecifier ) ) )
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( ((LA111_0>=RULE_STRING && LA111_0<=RULE_ID)||(LA111_0>=RULE_INTEGER && LA111_0<=RULE_CHARCONST)||LA111_0==44||(LA111_0>=96 && LA111_0<=99)) ) {
                        alt111=1;
                    }
                    else if ( (LA111_0==63||(LA111_0>=100 && LA111_0<=110)||(LA111_0>=120 && LA111_0<=121)) ) {
                        alt111=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 111, 0, input);

                        throw nvae;
                    }
                    switch (alt111) {
                        case 1 :
                            // InternalCoreDsl.g:5595:5: ( (lv_left_9_0= rulePostfixExpression ) )
                            {
                            // InternalCoreDsl.g:5595:5: ( (lv_left_9_0= rulePostfixExpression ) )
                            // InternalCoreDsl.g:5596:6: (lv_left_9_0= rulePostfixExpression )
                            {
                            // InternalCoreDsl.g:5596:6: (lv_left_9_0= rulePostfixExpression )
                            // InternalCoreDsl.g:5597:7: lv_left_9_0= rulePostfixExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPrefixExpressionAccess().getLeftPostfixExpressionParserRuleCall_4_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_40);
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
                            // InternalCoreDsl.g:5615:5: ( (lv_type_10_0= ruleTypeSpecifier ) )
                            {
                            // InternalCoreDsl.g:5615:5: ( (lv_type_10_0= ruleTypeSpecifier ) )
                            // InternalCoreDsl.g:5616:6: (lv_type_10_0= ruleTypeSpecifier )
                            {
                            // InternalCoreDsl.g:5616:6: (lv_type_10_0= ruleTypeSpecifier )
                            // InternalCoreDsl.g:5617:7: lv_type_10_0= ruleTypeSpecifier
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPrefixExpressionAccess().getTypeTypeSpecifierParserRuleCall_4_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_40);
                            lv_type_10_0=ruleTypeSpecifier();

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
                              								"com.minres.coredsl.CoreDsl.TypeSpecifier");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:5645:1: ruleUnaryOperator[EObject in_current] returns [EObject current=in_current] : ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) ) ;
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
            // InternalCoreDsl.g:5651:2: ( ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) ) )
            // InternalCoreDsl.g:5652:2: ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) )
            {
            // InternalCoreDsl.g:5652:2: ( ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) ) )
            // InternalCoreDsl.g:5653:3: ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) )
            {
            // InternalCoreDsl.g:5653:3: ( (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' ) )
            // InternalCoreDsl.g:5654:4: (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' )
            {
            // InternalCoreDsl.g:5654:4: (lv_op_0_1= '&' | lv_op_0_2= '*' | lv_op_0_3= '+' | lv_op_0_4= '-' | lv_op_0_5= '~' | lv_op_0_6= '!' )
            int alt113=6;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt113=1;
                }
                break;
            case 58:
                {
                alt113=2;
                }
                break;
            case 86:
                {
                alt113=3;
                }
                break;
            case 87:
                {
                alt113=4;
                }
                break;
            case 93:
                {
                alt113=5;
                }
                break;
            case 94:
                {
                alt113=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // InternalCoreDsl.g:5655:5: lv_op_0_1= '&'
                    {
                    lv_op_0_1=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5666:5: lv_op_0_2= '*'
                    {
                    lv_op_0_2=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5677:5: lv_op_0_3= '+'
                    {
                    lv_op_0_3=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5688:5: lv_op_0_4= '-'
                    {
                    lv_op_0_4=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
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
                    // InternalCoreDsl.g:5699:5: lv_op_0_5= '~'
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
                    // InternalCoreDsl.g:5710:5: lv_op_0_6= '!'
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
    // InternalCoreDsl.g:5726:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalCoreDsl.g:5726:58: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalCoreDsl.g:5727:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalCoreDsl.g:5733:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject lv_ops_2_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:5739:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* ) )
            // InternalCoreDsl.g:5740:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* )
            {
            // InternalCoreDsl.g:5740:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )* )
            // InternalCoreDsl.g:5741:3: this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_89);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCoreDsl.g:5749:3: ( () ( (lv_ops_2_0= rulePostfixOperator ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==RULE_LEFT_BR||LA114_0==44||LA114_0==64||(LA114_0>=90 && LA114_0<=91)||LA114_0==95) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // InternalCoreDsl.g:5750:4: () ( (lv_ops_2_0= rulePostfixOperator ) )
            	    {
            	    // InternalCoreDsl.g:5750:4: ()
            	    // InternalCoreDsl.g:5751:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getPostfixExpressionAccess().getPostfixExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalCoreDsl.g:5757:4: ( (lv_ops_2_0= rulePostfixOperator ) )
            	    // InternalCoreDsl.g:5758:5: (lv_ops_2_0= rulePostfixOperator )
            	    {
            	    // InternalCoreDsl.g:5758:5: (lv_ops_2_0= rulePostfixOperator )
            	    // InternalCoreDsl.g:5759:6: lv_ops_2_0= rulePostfixOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPostfixExpressionAccess().getOpsPostfixOperatorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_89);
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
            	    break loop114;
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
    // InternalCoreDsl.g:5781:1: entryRulePostfixOperator returns [EObject current=null] : iv_rulePostfixOperator= rulePostfixOperator EOF ;
    public final EObject entryRulePostfixOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOperator = null;


        try {
            // InternalCoreDsl.g:5781:56: (iv_rulePostfixOperator= rulePostfixOperator EOF )
            // InternalCoreDsl.g:5782:2: iv_rulePostfixOperator= rulePostfixOperator EOF
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
    // InternalCoreDsl.g:5788:1: rulePostfixOperator returns [EObject current=null] : ( ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) ) ;
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
            // InternalCoreDsl.g:5794:2: ( ( ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) ) )
            // InternalCoreDsl.g:5795:2: ( ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) )
            {
            // InternalCoreDsl.g:5795:2: ( ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR ) | ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' ) | ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) ) | ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) ) | ( (lv_op_14_0= '++' ) ) | ( (lv_op_15_0= '--' ) ) )
            int alt118=6;
            switch ( input.LA(1) ) {
            case RULE_LEFT_BR:
                {
                alt118=1;
                }
                break;
            case 44:
                {
                alt118=2;
                }
                break;
            case 64:
                {
                alt118=3;
                }
                break;
            case 95:
                {
                alt118=4;
                }
                break;
            case 90:
                {
                alt118=5;
                }
                break;
            case 91:
                {
                alt118=6;
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
                    // InternalCoreDsl.g:5796:3: ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR )
                    {
                    // InternalCoreDsl.g:5796:3: ( ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR )
                    // InternalCoreDsl.g:5797:4: ( (lv_op_0_0= RULE_LEFT_BR ) ) ( (lv_args_1_0= ruleConditionalExpression ) ) (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )? this_RIGHT_BR_4= RULE_RIGHT_BR
                    {
                    // InternalCoreDsl.g:5797:4: ( (lv_op_0_0= RULE_LEFT_BR ) )
                    // InternalCoreDsl.g:5798:5: (lv_op_0_0= RULE_LEFT_BR )
                    {
                    // InternalCoreDsl.g:5798:5: (lv_op_0_0= RULE_LEFT_BR )
                    // InternalCoreDsl.g:5799:6: lv_op_0_0= RULE_LEFT_BR
                    {
                    lv_op_0_0=(Token)match(input,RULE_LEFT_BR,FOLLOW_43); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5815:4: ( (lv_args_1_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:5816:5: (lv_args_1_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:5816:5: (lv_args_1_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:5817:6: lv_args_1_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_90);
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

                    // InternalCoreDsl.g:5834:4: (otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) ) )?
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==37) ) {
                        alt115=1;
                    }
                    switch (alt115) {
                        case 1 :
                            // InternalCoreDsl.g:5835:5: otherlv_2= ':' ( (lv_args_3_0= ruleConditionalExpression ) )
                            {
                            otherlv_2=(Token)match(input,37,FOLLOW_43); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getPostfixOperatorAccess().getColonKeyword_0_2_0());
                              				
                            }
                            // InternalCoreDsl.g:5839:5: ( (lv_args_3_0= ruleConditionalExpression ) )
                            // InternalCoreDsl.g:5840:6: (lv_args_3_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:5840:6: (lv_args_3_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:5841:7: lv_args_3_0= ruleConditionalExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_0_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_25);
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
                    // InternalCoreDsl.g:5865:3: ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' )
                    {
                    // InternalCoreDsl.g:5865:3: ( ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')' )
                    // InternalCoreDsl.g:5866:4: ( (lv_op_5_0= '(' ) ) ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )? otherlv_9= ')'
                    {
                    // InternalCoreDsl.g:5866:4: ( (lv_op_5_0= '(' ) )
                    // InternalCoreDsl.g:5867:5: (lv_op_5_0= '(' )
                    {
                    // InternalCoreDsl.g:5867:5: (lv_op_5_0= '(' )
                    // InternalCoreDsl.g:5868:6: lv_op_5_0= '('
                    {
                    lv_op_5_0=(Token)match(input,44,FOLLOW_91); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5880:4: ( ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )* )?
                    int alt117=2;
                    int LA117_0 = input.LA(1);

                    if ( ((LA117_0>=RULE_STRING && LA117_0<=RULE_ID)||(LA117_0>=RULE_INTEGER && LA117_0<=RULE_CHARCONST)||LA117_0==44||(LA117_0>=58 && LA117_0<=59)||(LA117_0>=86 && LA117_0<=87)||(LA117_0>=90 && LA117_0<=94)||(LA117_0>=96 && LA117_0<=99)) ) {
                        alt117=1;
                    }
                    switch (alt117) {
                        case 1 :
                            // InternalCoreDsl.g:5881:5: ( (lv_args_6_0= ruleConditionalExpression ) ) (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )*
                            {
                            // InternalCoreDsl.g:5881:5: ( (lv_args_6_0= ruleConditionalExpression ) )
                            // InternalCoreDsl.g:5882:6: (lv_args_6_0= ruleConditionalExpression )
                            {
                            // InternalCoreDsl.g:5882:6: (lv_args_6_0= ruleConditionalExpression )
                            // InternalCoreDsl.g:5883:7: lv_args_6_0= ruleConditionalExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_1_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_92);
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

                            // InternalCoreDsl.g:5900:5: (otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) ) )*
                            loop116:
                            do {
                                int alt116=2;
                                int LA116_0 = input.LA(1);

                                if ( (LA116_0==35) ) {
                                    alt116=1;
                                }


                                switch (alt116) {
                            	case 1 :
                            	    // InternalCoreDsl.g:5901:6: otherlv_7= ',' ( (lv_args_8_0= ruleConditionalExpression ) )
                            	    {
                            	    otherlv_7=(Token)match(input,35,FOLLOW_43); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_7, grammarAccess.getPostfixOperatorAccess().getCommaKeyword_1_1_1_0());
                            	      					
                            	    }
                            	    // InternalCoreDsl.g:5905:6: ( (lv_args_8_0= ruleConditionalExpression ) )
                            	    // InternalCoreDsl.g:5906:7: (lv_args_8_0= ruleConditionalExpression )
                            	    {
                            	    // InternalCoreDsl.g:5906:7: (lv_args_8_0= ruleConditionalExpression )
                            	    // InternalCoreDsl.g:5907:8: lv_args_8_0= ruleConditionalExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getPostfixOperatorAccess().getArgsConditionalExpressionParserRuleCall_1_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_92);
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
                            	    break loop116;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPostfixOperatorAccess().getRightParenthesisKeyword_1_2());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:5932:3: ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:5932:3: ( ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) ) )
                    // InternalCoreDsl.g:5933:4: ( (lv_op_10_0= '.' ) ) ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:5933:4: ( (lv_op_10_0= '.' ) )
                    // InternalCoreDsl.g:5934:5: (lv_op_10_0= '.' )
                    {
                    // InternalCoreDsl.g:5934:5: (lv_op_10_0= '.' )
                    // InternalCoreDsl.g:5935:6: lv_op_10_0= '.'
                    {
                    lv_op_10_0=(Token)match(input,64,FOLLOW_6); if (state.failed) return current;
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

                    // InternalCoreDsl.g:5947:4: ( (otherlv_11= RULE_ID ) )
                    // InternalCoreDsl.g:5948:5: (otherlv_11= RULE_ID )
                    {
                    // InternalCoreDsl.g:5948:5: (otherlv_11= RULE_ID )
                    // InternalCoreDsl.g:5949:6: otherlv_11= RULE_ID
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
                    // InternalCoreDsl.g:5962:3: ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) )
                    {
                    // InternalCoreDsl.g:5962:3: ( ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) ) )
                    // InternalCoreDsl.g:5963:4: ( (lv_op_12_0= '->' ) ) ( (otherlv_13= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:5963:4: ( (lv_op_12_0= '->' ) )
                    // InternalCoreDsl.g:5964:5: (lv_op_12_0= '->' )
                    {
                    // InternalCoreDsl.g:5964:5: (lv_op_12_0= '->' )
                    // InternalCoreDsl.g:5965:6: lv_op_12_0= '->'
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

                    // InternalCoreDsl.g:5977:4: ( (otherlv_13= RULE_ID ) )
                    // InternalCoreDsl.g:5978:5: (otherlv_13= RULE_ID )
                    {
                    // InternalCoreDsl.g:5978:5: (otherlv_13= RULE_ID )
                    // InternalCoreDsl.g:5979:6: otherlv_13= RULE_ID
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
                    // InternalCoreDsl.g:5992:3: ( (lv_op_14_0= '++' ) )
                    {
                    // InternalCoreDsl.g:5992:3: ( (lv_op_14_0= '++' ) )
                    // InternalCoreDsl.g:5993:4: (lv_op_14_0= '++' )
                    {
                    // InternalCoreDsl.g:5993:4: (lv_op_14_0= '++' )
                    // InternalCoreDsl.g:5994:5: lv_op_14_0= '++'
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
                    // InternalCoreDsl.g:6007:3: ( (lv_op_15_0= '--' ) )
                    {
                    // InternalCoreDsl.g:6007:3: ( (lv_op_15_0= '--' ) )
                    // InternalCoreDsl.g:6008:4: (lv_op_15_0= '--' )
                    {
                    // InternalCoreDsl.g:6008:4: (lv_op_15_0= '--' )
                    // InternalCoreDsl.g:6009:5: lv_op_15_0= '--'
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
    // InternalCoreDsl.g:6025:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalCoreDsl.g:6025:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalCoreDsl.g:6026:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalCoreDsl.g:6032:1: rulePrimaryExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) ) ;
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
            // InternalCoreDsl.g:6038:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) ) )
            // InternalCoreDsl.g:6039:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) )
            {
            // InternalCoreDsl.g:6039:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_constant_1_0= ruleConstant ) ) | ( (lv_literal_2_0= ruleStringLiteral ) )+ | (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' ) )
            int alt120=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt120=1;
                }
                break;
            case RULE_INTEGER:
            case RULE_FLOAT:
            case RULE_BOOLEAN:
            case RULE_CHARCONST:
                {
                alt120=2;
                }
                break;
            case 99:
                {
                int LA120_3 = input.LA(2);

                if ( (LA120_3==RULE_CHARCONST) ) {
                    alt120=2;
                }
                else if ( (LA120_3==RULE_STRING) ) {
                    alt120=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 120, 3, input);

                    throw nvae;
                }
                }
                break;
            case 97:
                {
                int LA120_4 = input.LA(2);

                if ( (LA120_4==RULE_CHARCONST) ) {
                    alt120=2;
                }
                else if ( (LA120_4==RULE_STRING) ) {
                    alt120=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 120, 4, input);

                    throw nvae;
                }
                }
                break;
            case 98:
                {
                int LA120_5 = input.LA(2);

                if ( (LA120_5==RULE_CHARCONST) ) {
                    alt120=2;
                }
                else if ( (LA120_5==RULE_STRING) ) {
                    alt120=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 120, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case 96:
                {
                alt120=3;
                }
                break;
            case 44:
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
                    // InternalCoreDsl.g:6040:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalCoreDsl.g:6040:3: ( (otherlv_0= RULE_ID ) )
                    // InternalCoreDsl.g:6041:4: (otherlv_0= RULE_ID )
                    {
                    // InternalCoreDsl.g:6041:4: (otherlv_0= RULE_ID )
                    // InternalCoreDsl.g:6042:5: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      					}
                      				
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getRefVariableCrossReference_0_0());
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6054:3: ( (lv_constant_1_0= ruleConstant ) )
                    {
                    // InternalCoreDsl.g:6054:3: ( (lv_constant_1_0= ruleConstant ) )
                    // InternalCoreDsl.g:6055:4: (lv_constant_1_0= ruleConstant )
                    {
                    // InternalCoreDsl.g:6055:4: (lv_constant_1_0= ruleConstant )
                    // InternalCoreDsl.g:6056:5: lv_constant_1_0= ruleConstant
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
                    // InternalCoreDsl.g:6074:3: ( (lv_literal_2_0= ruleStringLiteral ) )+
                    {
                    // InternalCoreDsl.g:6074:3: ( (lv_literal_2_0= ruleStringLiteral ) )+
                    int cnt119=0;
                    loop119:
                    do {
                        int alt119=2;
                        int LA119_0 = input.LA(1);

                        if ( (LA119_0==RULE_STRING||(LA119_0>=96 && LA119_0<=99)) ) {
                            alt119=1;
                        }


                        switch (alt119) {
                    	case 1 :
                    	    // InternalCoreDsl.g:6075:4: (lv_literal_2_0= ruleStringLiteral )
                    	    {
                    	    // InternalCoreDsl.g:6075:4: (lv_literal_2_0= ruleStringLiteral )
                    	    // InternalCoreDsl.g:6076:5: lv_literal_2_0= ruleStringLiteral
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralStringLiteralParserRuleCall_2_0());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_93);
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
                    	    if ( cnt119 >= 1 ) break loop119;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(119, input);
                                throw eee;
                        }
                        cnt119++;
                    } while (true);


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6094:3: (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' )
                    {
                    // InternalCoreDsl.g:6094:3: (otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')' )
                    // InternalCoreDsl.g:6095:4: otherlv_3= '(' ( (lv_left_4_0= ruleConditionalExpression ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,44,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalCoreDsl.g:6099:4: ( (lv_left_4_0= ruleConditionalExpression ) )
                    // InternalCoreDsl.g:6100:5: (lv_left_4_0= ruleConditionalExpression )
                    {
                    // InternalCoreDsl.g:6100:5: (lv_left_4_0= ruleConditionalExpression )
                    // InternalCoreDsl.g:6101:6: lv_left_4_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLeftConditionalExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
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

                    otherlv_5=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6127:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalCoreDsl.g:6127:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalCoreDsl.g:6128:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalCoreDsl.g:6134:1: ruleStringLiteral returns [EObject current=null] : ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject this_EncodingPrefix_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6140:2: ( ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalCoreDsl.g:6141:2: ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalCoreDsl.g:6141:2: ( (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalCoreDsl.g:6142:3: (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )? ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalCoreDsl.g:6142:3: (this_EncodingPrefix_0= ruleEncodingPrefix[$current] )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( ((LA121_0>=96 && LA121_0<=99)) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalCoreDsl.g:6143:4: this_EncodingPrefix_0= ruleEncodingPrefix[$current]
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

            // InternalCoreDsl.g:6155:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalCoreDsl.g:6156:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalCoreDsl.g:6156:4: (lv_value_1_0= RULE_STRING )
            // InternalCoreDsl.g:6157:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStringLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
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
    // InternalCoreDsl.g:6178:1: ruleEncodingPrefix[EObject in_current] returns [EObject current=in_current] : ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) ) ;
    public final EObject ruleEncodingPrefix(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_prefix_0_1=null;
        Token lv_prefix_0_2=null;
        Token lv_prefix_0_3=null;
        Token lv_prefix_0_4=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6184:2: ( ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) ) )
            // InternalCoreDsl.g:6185:2: ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) )
            {
            // InternalCoreDsl.g:6185:2: ( ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) ) )
            // InternalCoreDsl.g:6186:3: ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) )
            {
            // InternalCoreDsl.g:6186:3: ( (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' ) )
            // InternalCoreDsl.g:6187:4: (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' )
            {
            // InternalCoreDsl.g:6187:4: (lv_prefix_0_1= 'u8' | lv_prefix_0_2= 'u' | lv_prefix_0_3= 'U' | lv_prefix_0_4= 'L' )
            int alt122=4;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt122=1;
                }
                break;
            case 97:
                {
                alt122=2;
                }
                break;
            case 98:
                {
                alt122=3;
                }
                break;
            case 99:
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
                    // InternalCoreDsl.g:6188:5: lv_prefix_0_1= 'u8'
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
                    // InternalCoreDsl.g:6199:5: lv_prefix_0_2= 'u'
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
                    // InternalCoreDsl.g:6210:5: lv_prefix_0_3= 'U'
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
                    // InternalCoreDsl.g:6221:5: lv_prefix_0_4= 'L'
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
    // InternalCoreDsl.g:6237:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalCoreDsl.g:6237:59: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalCoreDsl.g:6238:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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
    // InternalCoreDsl.g:6244:1: ruleConstantExpression returns [EObject current=null] : this_ConditionalExpression_0= ruleConditionalExpression ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6250:2: (this_ConditionalExpression_0= ruleConditionalExpression )
            // InternalCoreDsl.g:6251:2: this_ConditionalExpression_0= ruleConditionalExpression
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
    // InternalCoreDsl.g:6262:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalCoreDsl.g:6262:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalCoreDsl.g:6263:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalCoreDsl.g:6269:1: ruleConstant returns [EObject current=null] : (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerConstant_0 = null;

        EObject this_FloatingConstant_1 = null;

        EObject this_CharacterConstant_2 = null;

        EObject this_BoolConstant_3 = null;



        	enterRule();

        try {
            // InternalCoreDsl.g:6275:2: ( (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant ) )
            // InternalCoreDsl.g:6276:2: (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant )
            {
            // InternalCoreDsl.g:6276:2: (this_IntegerConstant_0= ruleIntegerConstant | this_FloatingConstant_1= ruleFloatingConstant | this_CharacterConstant_2= ruleCharacterConstant | this_BoolConstant_3= ruleBoolConstant )
            int alt123=4;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
                {
                alt123=1;
                }
                break;
            case RULE_FLOAT:
                {
                alt123=2;
                }
                break;
            case RULE_CHARCONST:
            case 97:
            case 98:
            case 99:
                {
                alt123=3;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt123=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }

            switch (alt123) {
                case 1 :
                    // InternalCoreDsl.g:6277:3: this_IntegerConstant_0= ruleIntegerConstant
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
                    // InternalCoreDsl.g:6286:3: this_FloatingConstant_1= ruleFloatingConstant
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
                    // InternalCoreDsl.g:6295:3: this_CharacterConstant_2= ruleCharacterConstant
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
                    // InternalCoreDsl.g:6304:3: this_BoolConstant_3= ruleBoolConstant
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
    // InternalCoreDsl.g:6316:1: entryRuleIntegerConstant returns [EObject current=null] : iv_ruleIntegerConstant= ruleIntegerConstant EOF ;
    public final EObject entryRuleIntegerConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerConstant = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalCoreDsl.g:6318:2: (iv_ruleIntegerConstant= ruleIntegerConstant EOF )
            // InternalCoreDsl.g:6319:2: iv_ruleIntegerConstant= ruleIntegerConstant EOF
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
    // InternalCoreDsl.g:6328:1: ruleIntegerConstant returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleIntegerConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalCoreDsl.g:6335:2: ( ( (lv_value_0_0= RULE_INTEGER ) ) )
            // InternalCoreDsl.g:6336:2: ( (lv_value_0_0= RULE_INTEGER ) )
            {
            // InternalCoreDsl.g:6336:2: ( (lv_value_0_0= RULE_INTEGER ) )
            // InternalCoreDsl.g:6337:3: (lv_value_0_0= RULE_INTEGER )
            {
            // InternalCoreDsl.g:6337:3: (lv_value_0_0= RULE_INTEGER )
            // InternalCoreDsl.g:6338:4: lv_value_0_0= RULE_INTEGER
            {
            lv_value_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getIntegerConstantAccess().getValueINTEGERTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getIntegerConstantRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"com.minres.coredsl.CoreDsl.INTEGER");
              			
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleIntegerConstant"


    // $ANTLR start "entryRuleFloatingConstant"
    // InternalCoreDsl.g:6360:1: entryRuleFloatingConstant returns [EObject current=null] : iv_ruleFloatingConstant= ruleFloatingConstant EOF ;
    public final EObject entryRuleFloatingConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatingConstant = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalCoreDsl.g:6362:2: (iv_ruleFloatingConstant= ruleFloatingConstant EOF )
            // InternalCoreDsl.g:6363:2: iv_ruleFloatingConstant= ruleFloatingConstant EOF
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
    // InternalCoreDsl.g:6372:1: ruleFloatingConstant returns [EObject current=null] : ( (lv_value_0_0= RULE_FLOAT ) ) ;
    public final EObject ruleFloatingConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalCoreDsl.g:6379:2: ( ( (lv_value_0_0= RULE_FLOAT ) ) )
            // InternalCoreDsl.g:6380:2: ( (lv_value_0_0= RULE_FLOAT ) )
            {
            // InternalCoreDsl.g:6380:2: ( (lv_value_0_0= RULE_FLOAT ) )
            // InternalCoreDsl.g:6381:3: (lv_value_0_0= RULE_FLOAT )
            {
            // InternalCoreDsl.g:6381:3: (lv_value_0_0= RULE_FLOAT )
            // InternalCoreDsl.g:6382:4: lv_value_0_0= RULE_FLOAT
            {
            lv_value_0_0=(Token)match(input,RULE_FLOAT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getFloatingConstantAccess().getValueFLOATTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getFloatingConstantRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"com.minres.coredsl.CoreDsl.FLOAT");
              			
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleFloatingConstant"


    // $ANTLR start "entryRuleBoolConstant"
    // InternalCoreDsl.g:6404:1: entryRuleBoolConstant returns [EObject current=null] : iv_ruleBoolConstant= ruleBoolConstant EOF ;
    public final EObject entryRuleBoolConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolConstant = null;


        try {
            // InternalCoreDsl.g:6404:53: (iv_ruleBoolConstant= ruleBoolConstant EOF )
            // InternalCoreDsl.g:6405:2: iv_ruleBoolConstant= ruleBoolConstant EOF
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
    // InternalCoreDsl.g:6411:1: ruleBoolConstant returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBoolConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6417:2: ( ( (lv_value_0_0= RULE_BOOLEAN ) ) )
            // InternalCoreDsl.g:6418:2: ( (lv_value_0_0= RULE_BOOLEAN ) )
            {
            // InternalCoreDsl.g:6418:2: ( (lv_value_0_0= RULE_BOOLEAN ) )
            // InternalCoreDsl.g:6419:3: (lv_value_0_0= RULE_BOOLEAN )
            {
            // InternalCoreDsl.g:6419:3: (lv_value_0_0= RULE_BOOLEAN )
            // InternalCoreDsl.g:6420:4: lv_value_0_0= RULE_BOOLEAN
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getBoolConstantAccess().getValueBOOLEANTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getBoolConstantRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
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
    // InternalCoreDsl.g:6439:1: entryRuleCharacterConstant returns [EObject current=null] : iv_ruleCharacterConstant= ruleCharacterConstant EOF ;
    public final EObject entryRuleCharacterConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterConstant = null;


        try {
            // InternalCoreDsl.g:6439:58: (iv_ruleCharacterConstant= ruleCharacterConstant EOF )
            // InternalCoreDsl.g:6440:2: iv_ruleCharacterConstant= ruleCharacterConstant EOF
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
    // InternalCoreDsl.g:6446:1: ruleCharacterConstant returns [EObject current=null] : ( ( (lv_value_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_value_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_value_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_value_6_0= RULE_CHARCONST ) ) ) ) ;
    public final EObject ruleCharacterConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_enc_1_0=null;
        Token lv_value_2_0=null;
        Token lv_enc_3_0=null;
        Token lv_value_4_0=null;
        Token lv_enc_5_0=null;
        Token lv_value_6_0=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6452:2: ( ( ( (lv_value_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_value_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_value_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_value_6_0= RULE_CHARCONST ) ) ) ) )
            // InternalCoreDsl.g:6453:2: ( ( (lv_value_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_value_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_value_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_value_6_0= RULE_CHARCONST ) ) ) )
            {
            // InternalCoreDsl.g:6453:2: ( ( (lv_value_0_0= RULE_CHARCONST ) ) | ( ( (lv_enc_1_0= 'L' ) ) ( (lv_value_2_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_3_0= 'u' ) ) ( (lv_value_4_0= RULE_CHARCONST ) ) ) | ( ( (lv_enc_5_0= 'U' ) ) ( (lv_value_6_0= RULE_CHARCONST ) ) ) )
            int alt124=4;
            switch ( input.LA(1) ) {
            case RULE_CHARCONST:
                {
                alt124=1;
                }
                break;
            case 99:
                {
                alt124=2;
                }
                break;
            case 97:
                {
                alt124=3;
                }
                break;
            case 98:
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
                    // InternalCoreDsl.g:6454:3: ( (lv_value_0_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6454:3: ( (lv_value_0_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6455:4: (lv_value_0_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6455:4: (lv_value_0_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6456:5: lv_value_0_0= RULE_CHARCONST
                    {
                    lv_value_0_0=(Token)match(input,RULE_CHARCONST,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_value_0_0, grammarAccess.getCharacterConstantAccess().getValueCHARCONSTTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getCharacterConstantRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"value",
                      						lv_value_0_0,
                      						"com.minres.coredsl.CoreDsl.CHARCONST");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6473:3: ( ( (lv_enc_1_0= 'L' ) ) ( (lv_value_2_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6473:3: ( ( (lv_enc_1_0= 'L' ) ) ( (lv_value_2_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6474:4: ( (lv_enc_1_0= 'L' ) ) ( (lv_value_2_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6474:4: ( (lv_enc_1_0= 'L' ) )
                    // InternalCoreDsl.g:6475:5: (lv_enc_1_0= 'L' )
                    {
                    // InternalCoreDsl.g:6475:5: (lv_enc_1_0= 'L' )
                    // InternalCoreDsl.g:6476:6: lv_enc_1_0= 'L'
                    {
                    lv_enc_1_0=(Token)match(input,99,FOLLOW_94); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6488:4: ( (lv_value_2_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6489:5: (lv_value_2_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6489:5: (lv_value_2_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6490:6: lv_value_2_0= RULE_CHARCONST
                    {
                    lv_value_2_0=(Token)match(input,RULE_CHARCONST,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_0, grammarAccess.getCharacterConstantAccess().getValueCHARCONSTTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCharacterConstantRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_2_0,
                      							"com.minres.coredsl.CoreDsl.CHARCONST");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6508:3: ( ( (lv_enc_3_0= 'u' ) ) ( (lv_value_4_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6508:3: ( ( (lv_enc_3_0= 'u' ) ) ( (lv_value_4_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6509:4: ( (lv_enc_3_0= 'u' ) ) ( (lv_value_4_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6509:4: ( (lv_enc_3_0= 'u' ) )
                    // InternalCoreDsl.g:6510:5: (lv_enc_3_0= 'u' )
                    {
                    // InternalCoreDsl.g:6510:5: (lv_enc_3_0= 'u' )
                    // InternalCoreDsl.g:6511:6: lv_enc_3_0= 'u'
                    {
                    lv_enc_3_0=(Token)match(input,97,FOLLOW_94); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6523:4: ( (lv_value_4_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6524:5: (lv_value_4_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6524:5: (lv_value_4_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6525:6: lv_value_4_0= RULE_CHARCONST
                    {
                    lv_value_4_0=(Token)match(input,RULE_CHARCONST,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_4_0, grammarAccess.getCharacterConstantAccess().getValueCHARCONSTTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCharacterConstantRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_4_0,
                      							"com.minres.coredsl.CoreDsl.CHARCONST");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6543:3: ( ( (lv_enc_5_0= 'U' ) ) ( (lv_value_6_0= RULE_CHARCONST ) ) )
                    {
                    // InternalCoreDsl.g:6543:3: ( ( (lv_enc_5_0= 'U' ) ) ( (lv_value_6_0= RULE_CHARCONST ) ) )
                    // InternalCoreDsl.g:6544:4: ( (lv_enc_5_0= 'U' ) ) ( (lv_value_6_0= RULE_CHARCONST ) )
                    {
                    // InternalCoreDsl.g:6544:4: ( (lv_enc_5_0= 'U' ) )
                    // InternalCoreDsl.g:6545:5: (lv_enc_5_0= 'U' )
                    {
                    // InternalCoreDsl.g:6545:5: (lv_enc_5_0= 'U' )
                    // InternalCoreDsl.g:6546:6: lv_enc_5_0= 'U'
                    {
                    lv_enc_5_0=(Token)match(input,98,FOLLOW_94); if (state.failed) return current;
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

                    // InternalCoreDsl.g:6558:4: ( (lv_value_6_0= RULE_CHARCONST ) )
                    // InternalCoreDsl.g:6559:5: (lv_value_6_0= RULE_CHARCONST )
                    {
                    // InternalCoreDsl.g:6559:5: (lv_value_6_0= RULE_CHARCONST )
                    // InternalCoreDsl.g:6560:6: lv_value_6_0= RULE_CHARCONST
                    {
                    lv_value_6_0=(Token)match(input,RULE_CHARCONST,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_6_0, grammarAccess.getCharacterConstantAccess().getValueCHARCONSTTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCharacterConstantRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_6_0,
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
    // InternalCoreDsl.g:6581:1: entryRuleDoubleLeftBracket returns [String current=null] : iv_ruleDoubleLeftBracket= ruleDoubleLeftBracket EOF ;
    public final String entryRuleDoubleLeftBracket() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDoubleLeftBracket = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalCoreDsl.g:6583:2: (iv_ruleDoubleLeftBracket= ruleDoubleLeftBracket EOF )
            // InternalCoreDsl.g:6584:2: iv_ruleDoubleLeftBracket= ruleDoubleLeftBracket EOF
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
    // InternalCoreDsl.g:6593:1: ruleDoubleLeftBracket returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LEFT_BR_0= RULE_LEFT_BR this_LEFT_BR_1= RULE_LEFT_BR ) ;
    public final AntlrDatatypeRuleToken ruleDoubleLeftBracket() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LEFT_BR_0=null;
        Token this_LEFT_BR_1=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalCoreDsl.g:6600:2: ( (this_LEFT_BR_0= RULE_LEFT_BR this_LEFT_BR_1= RULE_LEFT_BR ) )
            // InternalCoreDsl.g:6601:2: (this_LEFT_BR_0= RULE_LEFT_BR this_LEFT_BR_1= RULE_LEFT_BR )
            {
            // InternalCoreDsl.g:6601:2: (this_LEFT_BR_0= RULE_LEFT_BR this_LEFT_BR_1= RULE_LEFT_BR )
            // InternalCoreDsl.g:6602:3: this_LEFT_BR_0= RULE_LEFT_BR this_LEFT_BR_1= RULE_LEFT_BR
            {
            this_LEFT_BR_0=(Token)match(input,RULE_LEFT_BR,FOLLOW_34); if (state.failed) return current;
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
    // InternalCoreDsl.g:6623:1: entryRuleDoubleRightBracket returns [String current=null] : iv_ruleDoubleRightBracket= ruleDoubleRightBracket EOF ;
    public final String entryRuleDoubleRightBracket() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDoubleRightBracket = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalCoreDsl.g:6625:2: (iv_ruleDoubleRightBracket= ruleDoubleRightBracket EOF )
            // InternalCoreDsl.g:6626:2: iv_ruleDoubleRightBracket= ruleDoubleRightBracket EOF
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
    // InternalCoreDsl.g:6635:1: ruleDoubleRightBracket returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_RIGHT_BR_0= RULE_RIGHT_BR this_RIGHT_BR_1= RULE_RIGHT_BR ) ;
    public final AntlrDatatypeRuleToken ruleDoubleRightBracket() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_RIGHT_BR_0=null;
        Token this_RIGHT_BR_1=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalCoreDsl.g:6642:2: ( (this_RIGHT_BR_0= RULE_RIGHT_BR this_RIGHT_BR_1= RULE_RIGHT_BR ) )
            // InternalCoreDsl.g:6643:2: (this_RIGHT_BR_0= RULE_RIGHT_BR this_RIGHT_BR_1= RULE_RIGHT_BR )
            {
            // InternalCoreDsl.g:6643:2: (this_RIGHT_BR_0= RULE_RIGHT_BR this_RIGHT_BR_1= RULE_RIGHT_BR )
            // InternalCoreDsl.g:6644:3: this_RIGHT_BR_0= RULE_RIGHT_BR this_RIGHT_BR_1= RULE_RIGHT_BR
            {
            this_RIGHT_BR_0=(Token)match(input,RULE_RIGHT_BR,FOLLOW_25); if (state.failed) return current;
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
    // InternalCoreDsl.g:6665:1: ruleDataTypes returns [Enumerator current=null] : ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'void' ) | (enumLiteral_10= 'alias' ) ) ;
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
            // InternalCoreDsl.g:6671:2: ( ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'void' ) | (enumLiteral_10= 'alias' ) ) )
            // InternalCoreDsl.g:6672:2: ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'void' ) | (enumLiteral_10= 'alias' ) )
            {
            // InternalCoreDsl.g:6672:2: ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'short' ) | (enumLiteral_3= 'int' ) | (enumLiteral_4= 'long' ) | (enumLiteral_5= 'signed' ) | (enumLiteral_6= 'unsigned' ) | (enumLiteral_7= 'float' ) | (enumLiteral_8= 'double' ) | (enumLiteral_9= 'void' ) | (enumLiteral_10= 'alias' ) )
            int alt125=11;
            switch ( input.LA(1) ) {
            case 100:
                {
                alt125=1;
                }
                break;
            case 101:
                {
                alt125=2;
                }
                break;
            case 102:
                {
                alt125=3;
                }
                break;
            case 103:
                {
                alt125=4;
                }
                break;
            case 104:
                {
                alt125=5;
                }
                break;
            case 105:
                {
                alt125=6;
                }
                break;
            case 106:
                {
                alt125=7;
                }
                break;
            case 107:
                {
                alt125=8;
                }
                break;
            case 108:
                {
                alt125=9;
                }
                break;
            case 109:
                {
                alt125=10;
                }
                break;
            case 110:
                {
                alt125=11;
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
                    // InternalCoreDsl.g:6673:3: (enumLiteral_0= 'bool' )
                    {
                    // InternalCoreDsl.g:6673:3: (enumLiteral_0= 'bool' )
                    // InternalCoreDsl.g:6674:4: enumLiteral_0= 'bool'
                    {
                    enumLiteral_0=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getDataTypesAccess().getBOOLEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6681:3: (enumLiteral_1= 'char' )
                    {
                    // InternalCoreDsl.g:6681:3: (enumLiteral_1= 'char' )
                    // InternalCoreDsl.g:6682:4: enumLiteral_1= 'char'
                    {
                    enumLiteral_1=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getCHAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getDataTypesAccess().getCHAREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6689:3: (enumLiteral_2= 'short' )
                    {
                    // InternalCoreDsl.g:6689:3: (enumLiteral_2= 'short' )
                    // InternalCoreDsl.g:6690:4: enumLiteral_2= 'short'
                    {
                    enumLiteral_2=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getSHORTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getDataTypesAccess().getSHORTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6697:3: (enumLiteral_3= 'int' )
                    {
                    // InternalCoreDsl.g:6697:3: (enumLiteral_3= 'int' )
                    // InternalCoreDsl.g:6698:4: enumLiteral_3= 'int'
                    {
                    enumLiteral_3=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getINTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getDataTypesAccess().getINTEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:6705:3: (enumLiteral_4= 'long' )
                    {
                    // InternalCoreDsl.g:6705:3: (enumLiteral_4= 'long' )
                    // InternalCoreDsl.g:6706:4: enumLiteral_4= 'long'
                    {
                    enumLiteral_4=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getLONGEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getDataTypesAccess().getLONGEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalCoreDsl.g:6713:3: (enumLiteral_5= 'signed' )
                    {
                    // InternalCoreDsl.g:6713:3: (enumLiteral_5= 'signed' )
                    // InternalCoreDsl.g:6714:4: enumLiteral_5= 'signed'
                    {
                    enumLiteral_5=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getSIGNEDEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getDataTypesAccess().getSIGNEDEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalCoreDsl.g:6721:3: (enumLiteral_6= 'unsigned' )
                    {
                    // InternalCoreDsl.g:6721:3: (enumLiteral_6= 'unsigned' )
                    // InternalCoreDsl.g:6722:4: enumLiteral_6= 'unsigned'
                    {
                    enumLiteral_6=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getUNSIGNEDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getDataTypesAccess().getUNSIGNEDEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalCoreDsl.g:6729:3: (enumLiteral_7= 'float' )
                    {
                    // InternalCoreDsl.g:6729:3: (enumLiteral_7= 'float' )
                    // InternalCoreDsl.g:6730:4: enumLiteral_7= 'float'
                    {
                    enumLiteral_7=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getFLOATEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getDataTypesAccess().getFLOATEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalCoreDsl.g:6737:3: (enumLiteral_8= 'double' )
                    {
                    // InternalCoreDsl.g:6737:3: (enumLiteral_8= 'double' )
                    // InternalCoreDsl.g:6738:4: enumLiteral_8= 'double'
                    {
                    enumLiteral_8=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getDOUBLEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getDataTypesAccess().getDOUBLEEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalCoreDsl.g:6745:3: (enumLiteral_9= 'void' )
                    {
                    // InternalCoreDsl.g:6745:3: (enumLiteral_9= 'void' )
                    // InternalCoreDsl.g:6746:4: enumLiteral_9= 'void'
                    {
                    enumLiteral_9=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getVOIDEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getDataTypesAccess().getVOIDEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalCoreDsl.g:6753:3: (enumLiteral_10= 'alias' )
                    {
                    // InternalCoreDsl.g:6753:3: (enumLiteral_10= 'alias' )
                    // InternalCoreDsl.g:6754:4: enumLiteral_10= 'alias'
                    {
                    enumLiteral_10=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDataTypesAccess().getALIASEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getDataTypesAccess().getALIASEnumLiteralDeclaration_10());
                      			
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
    // InternalCoreDsl.g:6764:1: ruleTypeQualifier returns [Enumerator current=null] : ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) ) ;
    public final Enumerator ruleTypeQualifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6770:2: ( ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) ) )
            // InternalCoreDsl.g:6771:2: ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) )
            {
            // InternalCoreDsl.g:6771:2: ( (enumLiteral_0= 'const' ) | (enumLiteral_1= 'volatile' ) )
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==111) ) {
                alt126=1;
            }
            else if ( (LA126_0==112) ) {
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
                    // InternalCoreDsl.g:6772:3: (enumLiteral_0= 'const' )
                    {
                    // InternalCoreDsl.g:6772:3: (enumLiteral_0= 'const' )
                    // InternalCoreDsl.g:6773:4: enumLiteral_0= 'const'
                    {
                    enumLiteral_0=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeQualifierAccess().getCONSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTypeQualifierAccess().getCONSTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6780:3: (enumLiteral_1= 'volatile' )
                    {
                    // InternalCoreDsl.g:6780:3: (enumLiteral_1= 'volatile' )
                    // InternalCoreDsl.g:6781:4: enumLiteral_1= 'volatile'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6791:1: ruleStorageClassSpecifier returns [Enumerator current=null] : ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) ) ;
    public final Enumerator ruleStorageClassSpecifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6797:2: ( ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) ) )
            // InternalCoreDsl.g:6798:2: ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) )
            {
            // InternalCoreDsl.g:6798:2: ( (enumLiteral_0= 'extern' ) | (enumLiteral_1= 'static' ) )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==43) ) {
                alt127=1;
            }
            else if ( (LA127_0==113) ) {
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
                    // InternalCoreDsl.g:6799:3: (enumLiteral_0= 'extern' )
                    {
                    // InternalCoreDsl.g:6799:3: (enumLiteral_0= 'extern' )
                    // InternalCoreDsl.g:6800:4: enumLiteral_0= 'extern'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStorageClassSpecifierAccess().getEXTERNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getStorageClassSpecifierAccess().getEXTERNEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6807:3: (enumLiteral_1= 'static' )
                    {
                    // InternalCoreDsl.g:6807:3: (enumLiteral_1= 'static' )
                    // InternalCoreDsl.g:6808:4: enumLiteral_1= 'static'
                    {
                    enumLiteral_1=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "ruleDeclarationAttribute"
    // InternalCoreDsl.g:6818:1: ruleDeclarationAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'is_interlock_for' ) ) ;
    public final Enumerator ruleDeclarationAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6824:2: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'is_interlock_for' ) ) )
            // InternalCoreDsl.g:6825:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'is_interlock_for' ) )
            {
            // InternalCoreDsl.g:6825:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'is_pc' ) | (enumLiteral_2= 'is_interlock_for' ) )
            int alt128=3;
            switch ( input.LA(1) ) {
            case 114:
                {
                alt128=1;
                }
                break;
            case 115:
                {
                alt128=2;
                }
                break;
            case 116:
                {
                alt128=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }

            switch (alt128) {
                case 1 :
                    // InternalCoreDsl.g:6826:3: (enumLiteral_0= 'NONE' )
                    {
                    // InternalCoreDsl.g:6826:3: (enumLiteral_0= 'NONE' )
                    // InternalCoreDsl.g:6827:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDeclarationAttributeAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getDeclarationAttributeAccess().getNONEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6834:3: (enumLiteral_1= 'is_pc' )
                    {
                    // InternalCoreDsl.g:6834:3: (enumLiteral_1= 'is_pc' )
                    // InternalCoreDsl.g:6835:4: enumLiteral_1= 'is_pc'
                    {
                    enumLiteral_1=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDeclarationAttributeAccess().getIS_PCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getDeclarationAttributeAccess().getIS_PCEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6842:3: (enumLiteral_2= 'is_interlock_for' )
                    {
                    // InternalCoreDsl.g:6842:3: (enumLiteral_2= 'is_interlock_for' )
                    // InternalCoreDsl.g:6843:4: enumLiteral_2= 'is_interlock_for'
                    {
                    enumLiteral_2=(Token)match(input,116,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getDeclarationAttributeAccess().getIS_INTERLOCK_FOREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getDeclarationAttributeAccess().getIS_INTERLOCK_FOREnumLiteralDeclaration_2());
                      			
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
    // $ANTLR end "ruleDeclarationAttribute"


    // $ANTLR start "ruleInstrAttribute"
    // InternalCoreDsl.g:6853:1: ruleInstrAttribute returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) ) ;
    public final Enumerator ruleInstrAttribute() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6859:2: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) ) )
            // InternalCoreDsl.g:6860:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) )
            {
            // InternalCoreDsl.g:6860:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'no_cont' ) | (enumLiteral_2= 'cond' ) | (enumLiteral_3= 'flush' ) )
            int alt129=4;
            switch ( input.LA(1) ) {
            case 114:
                {
                alt129=1;
                }
                break;
            case 117:
                {
                alt129=2;
                }
                break;
            case 118:
                {
                alt129=3;
                }
                break;
            case 119:
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
                    // InternalCoreDsl.g:6861:3: (enumLiteral_0= 'NONE' )
                    {
                    // InternalCoreDsl.g:6861:3: (enumLiteral_0= 'NONE' )
                    // InternalCoreDsl.g:6862:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInstrAttributeAccess().getNONEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6869:3: (enumLiteral_1= 'no_cont' )
                    {
                    // InternalCoreDsl.g:6869:3: (enumLiteral_1= 'no_cont' )
                    // InternalCoreDsl.g:6870:4: enumLiteral_1= 'no_cont'
                    {
                    enumLiteral_1=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getNO_CONTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getInstrAttributeAccess().getNO_CONTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6877:3: (enumLiteral_2= 'cond' )
                    {
                    // InternalCoreDsl.g:6877:3: (enumLiteral_2= 'cond' )
                    // InternalCoreDsl.g:6878:4: enumLiteral_2= 'cond'
                    {
                    enumLiteral_2=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInstrAttributeAccess().getCONDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getInstrAttributeAccess().getCONDEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6885:3: (enumLiteral_3= 'flush' )
                    {
                    // InternalCoreDsl.g:6885:3: (enumLiteral_3= 'flush' )
                    // InternalCoreDsl.g:6886:4: enumLiteral_3= 'flush'
                    {
                    enumLiteral_3=(Token)match(input,119,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6896:1: ruleStructOrUnion returns [Enumerator current=null] : ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) ) ;
    public final Enumerator ruleStructOrUnion() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6902:2: ( ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) ) )
            // InternalCoreDsl.g:6903:2: ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) )
            {
            // InternalCoreDsl.g:6903:2: ( (enumLiteral_0= 'struct' ) | (enumLiteral_1= 'union' ) )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==120) ) {
                alt130=1;
            }
            else if ( (LA130_0==121) ) {
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
                    // InternalCoreDsl.g:6904:3: (enumLiteral_0= 'struct' )
                    {
                    // InternalCoreDsl.g:6904:3: (enumLiteral_0= 'struct' )
                    // InternalCoreDsl.g:6905:4: enumLiteral_0= 'struct'
                    {
                    enumLiteral_0=(Token)match(input,120,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStructOrUnionAccess().getSTRUCTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getStructOrUnionAccess().getSTRUCTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6912:3: (enumLiteral_1= 'union' )
                    {
                    // InternalCoreDsl.g:6912:3: (enumLiteral_1= 'union' )
                    // InternalCoreDsl.g:6913:4: enumLiteral_1= 'union'
                    {
                    enumLiteral_1=(Token)match(input,121,FOLLOW_2); if (state.failed) return current;
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
    // InternalCoreDsl.g:6923:1: ruleBitfieldDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) ) ;
    public final Enumerator ruleBitfieldDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalCoreDsl.g:6929:2: ( ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) ) )
            // InternalCoreDsl.g:6930:2: ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) )
            {
            // InternalCoreDsl.g:6930:2: ( (enumLiteral_0= 'u' ) | (enumLiteral_1= 's' ) )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==97) ) {
                alt131=1;
            }
            else if ( (LA131_0==122) ) {
                alt131=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }
            switch (alt131) {
                case 1 :
                    // InternalCoreDsl.g:6931:3: (enumLiteral_0= 'u' )
                    {
                    // InternalCoreDsl.g:6931:3: (enumLiteral_0= 'u' )
                    // InternalCoreDsl.g:6932:4: enumLiteral_0= 'u'
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
                    // InternalCoreDsl.g:6939:3: (enumLiteral_1= 's' )
                    {
                    // InternalCoreDsl.g:6939:3: (enumLiteral_1= 's' )
                    // InternalCoreDsl.g:6940:4: enumLiteral_1= 's'
                    {
                    enumLiteral_1=(Token)match(input,122,FOLLOW_2); if (state.failed) return current;
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
        // InternalCoreDsl.g:1834:5: ( 'else' )
        // InternalCoreDsl.g:1834:6: 'else'
        {
        match(input,49,FOLLOW_2); if (state.failed) return ;

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000201800000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000201000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000001F8000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x8000080000000080L,0x0303FFF000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x8000080010000080L,0x0303FFF000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000001F0000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000001D0000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000190000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000110000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000404000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000804000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000178000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000170000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000150000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000080004000080L,0x0003800000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x00E4000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0FFD104004001E30L,0x0000000F7CC00000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000040000000002L,0x0400000200000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000040000000000L,0x0400000200000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x8000280000000080L,0x0303FFF000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00001000000000A2L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0C00100000001E30L,0x0000000F7CC00000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x8FFD184014001EB0L,0x0303FFFF7CC00000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x8C00184000001EB0L,0x0303FFFF7CC00000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0C00104000001E30L,0x0000000F7CC00000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0C00100000001E32L,0x0000000F7CC00000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x2C00004000000020L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0C00004000000020L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000004000000020L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000004800000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x001C000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x1000000000000100L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x00007FF000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000100000001E30L,0x0000000F00000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x4000000800000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x1000080000000082L,0x0003800000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0C00100004001E30L,0x0000000F7CC00000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000102000000082L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000100000000082L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0C00100004001EB0L,0x0000000F7CC00001L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x1000000000000080L,0x0000000000000001L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x8000380000000080L,0x0303FFF000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0C00100000001F30L,0x0000000F7CC00000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x1000000000000002L,0x00000000000007FEL});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x1000000000000000L,0x00000000000007FEL});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000000000030000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x6000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000002L,0x0000000000C00000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0400000000000002L,0x0000000003000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x2000200000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x8000180000001EB0L,0x0303FFFF00000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000100000000082L,0x000000008C000001L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000002000000100L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0C00300000001E30L,0x0000000F7CC00000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000200800000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000012L,0x0000000F00000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000001000L});

}