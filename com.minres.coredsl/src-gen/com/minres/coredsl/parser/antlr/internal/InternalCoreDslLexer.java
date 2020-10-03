package com.minres.coredsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCoreDslLexer extends Lexer {
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

    public InternalCoreDslLexer() {;} 
    public InternalCoreDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCoreDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalCoreDsl.g"; }

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:11:7: ( 'import' )
            // InternalCoreDsl.g:11:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:12:7: ( 'InstructionSet' )
            // InternalCoreDsl.g:12:9: 'InstructionSet'
            {
            match("InstructionSet"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:13:7: ( 'extends' )
            // InternalCoreDsl.g:13:9: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:14:7: ( '{' )
            // InternalCoreDsl.g:14:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:15:7: ( 'constants' )
            // InternalCoreDsl.g:15:9: 'constants'
            {
            match("constants"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:16:7: ( '}' )
            // InternalCoreDsl.g:16:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:17:7: ( 'registers' )
            // InternalCoreDsl.g:17:9: 'registers'
            {
            match("registers"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:18:7: ( 'address_spaces' )
            // InternalCoreDsl.g:18:9: 'address_spaces'
            {
            match("address_spaces"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:19:7: ( 'functions' )
            // InternalCoreDsl.g:19:9: 'functions'
            {
            match("functions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:20:7: ( 'instructions' )
            // InternalCoreDsl.g:20:9: 'instructions'
            {
            match("instructions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:21:7: ( 'Core' )
            // InternalCoreDsl.g:21:9: 'Core'
            {
            match("Core"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:22:7: ( 'provides' )
            // InternalCoreDsl.g:22:9: 'provides'
            {
            match("provides"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:23:7: ( ',' )
            // InternalCoreDsl.g:23:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:24:7: ( 'encoding' )
            // InternalCoreDsl.g:24:9: 'encoding'
            {
            match("encoding"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:25:7: ( ':' )
            // InternalCoreDsl.g:25:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:26:7: ( ';' )
            // InternalCoreDsl.g:26:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:27:7: ( 'args_disass' )
            // InternalCoreDsl.g:27:9: 'args_disass'
            {
            match("args_disass"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:28:7: ( 'behavior' )
            // InternalCoreDsl.g:28:9: 'behavior'
            {
            match("behavior"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:29:7: ( '::' )
            // InternalCoreDsl.g:29:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:30:7: ( '\\'' )
            // InternalCoreDsl.g:30:9: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:31:7: ( 'extern' )
            // InternalCoreDsl.g:31:9: 'extern'
            {
            match("extern"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:32:7: ( '(' )
            // InternalCoreDsl.g:32:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:33:7: ( ')' )
            // InternalCoreDsl.g:33:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:34:7: ( 'case' )
            // InternalCoreDsl.g:34:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:35:7: ( 'default' )
            // InternalCoreDsl.g:35:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:36:7: ( 'if' )
            // InternalCoreDsl.g:36:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:37:7: ( 'else' )
            // InternalCoreDsl.g:37:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:38:7: ( 'switch' )
            // InternalCoreDsl.g:38:9: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:39:7: ( 'while' )
            // InternalCoreDsl.g:39:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:40:7: ( 'do' )
            // InternalCoreDsl.g:40:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:41:7: ( 'for' )
            // InternalCoreDsl.g:41:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:42:7: ( 'continue' )
            // InternalCoreDsl.g:42:9: 'continue'
            {
            match("continue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:43:7: ( 'break' )
            // InternalCoreDsl.g:43:9: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:44:7: ( 'return' )
            // InternalCoreDsl.g:44:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:45:7: ( 'spawn' )
            // InternalCoreDsl.g:45:9: 'spawn'
            {
            match("spawn"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:46:7: ( '*' )
            // InternalCoreDsl.g:46:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:47:7: ( '&' )
            // InternalCoreDsl.g:47:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:48:7: ( '=' )
            // InternalCoreDsl.g:48:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:49:7: ( '<' )
            // InternalCoreDsl.g:49:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:50:7: ( '>' )
            // InternalCoreDsl.g:50:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:51:7: ( 'enum' )
            // InternalCoreDsl.g:51:9: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:52:7: ( '.' )
            // InternalCoreDsl.g:52:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:53:7: ( '*=' )
            // InternalCoreDsl.g:53:9: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:54:7: ( '/=' )
            // InternalCoreDsl.g:54:9: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:55:7: ( '%=' )
            // InternalCoreDsl.g:55:9: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:56:7: ( '+=' )
            // InternalCoreDsl.g:56:9: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:57:7: ( '-=' )
            // InternalCoreDsl.g:57:9: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:58:7: ( '<<=' )
            // InternalCoreDsl.g:58:9: '<<='
            {
            match("<<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:59:7: ( '>>=' )
            // InternalCoreDsl.g:59:9: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:60:7: ( '&=' )
            // InternalCoreDsl.g:60:9: '&='
            {
            match("&="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:61:7: ( '^=' )
            // InternalCoreDsl.g:61:9: '^='
            {
            match("^="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:62:7: ( '|=' )
            // InternalCoreDsl.g:62:9: '|='
            {
            match("|="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:63:7: ( '?' )
            // InternalCoreDsl.g:63:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:64:7: ( '||' )
            // InternalCoreDsl.g:64:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:65:7: ( '&&' )
            // InternalCoreDsl.g:65:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:66:7: ( '|' )
            // InternalCoreDsl.g:66:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:67:7: ( '^' )
            // InternalCoreDsl.g:67:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:68:7: ( '==' )
            // InternalCoreDsl.g:68:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:69:7: ( '!=' )
            // InternalCoreDsl.g:69:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:70:7: ( '<=' )
            // InternalCoreDsl.g:70:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:71:7: ( '>=' )
            // InternalCoreDsl.g:71:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:72:7: ( '<<' )
            // InternalCoreDsl.g:72:9: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:73:7: ( '>>' )
            // InternalCoreDsl.g:73:9: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:74:7: ( '+' )
            // InternalCoreDsl.g:74:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:75:7: ( '-' )
            // InternalCoreDsl.g:75:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:76:7: ( '/' )
            // InternalCoreDsl.g:76:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:77:7: ( '%' )
            // InternalCoreDsl.g:77:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:78:7: ( '++' )
            // InternalCoreDsl.g:78:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:79:7: ( '--' )
            // InternalCoreDsl.g:79:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:80:7: ( 'sizeof' )
            // InternalCoreDsl.g:80:9: 'sizeof'
            {
            match("sizeof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:81:7: ( '~' )
            // InternalCoreDsl.g:81:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:82:7: ( '!' )
            // InternalCoreDsl.g:82:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:83:7: ( '->' )
            // InternalCoreDsl.g:83:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:84:7: ( 'u8' )
            // InternalCoreDsl.g:84:9: 'u8'
            {
            match("u8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:85:7: ( 'u' )
            // InternalCoreDsl.g:85:9: 'u'
            {
            match('u'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:86:7: ( 'U' )
            // InternalCoreDsl.g:86:9: 'U'
            {
            match('U'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:87:7: ( 'L' )
            // InternalCoreDsl.g:87:9: 'L'
            {
            match('L'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:88:8: ( 'bool' )
            // InternalCoreDsl.g:88:10: 'bool'
            {
            match("bool"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:89:8: ( 'char' )
            // InternalCoreDsl.g:89:10: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:90:8: ( 'short' )
            // InternalCoreDsl.g:90:10: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:91:8: ( 'int' )
            // InternalCoreDsl.g:91:10: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:92:8: ( 'long' )
            // InternalCoreDsl.g:92:10: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:93:8: ( 'signed' )
            // InternalCoreDsl.g:93:10: 'signed'
            {
            match("signed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:94:8: ( 'unsigned' )
            // InternalCoreDsl.g:94:10: 'unsigned'
            {
            match("unsigned"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:95:8: ( 'float' )
            // InternalCoreDsl.g:95:10: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:96:8: ( 'double' )
            // InternalCoreDsl.g:96:10: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:97:8: ( 'void' )
            // InternalCoreDsl.g:97:10: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:98:8: ( 'alias' )
            // InternalCoreDsl.g:98:10: 'alias'
            {
            match("alias"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:99:8: ( 'const' )
            // InternalCoreDsl.g:99:10: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:100:8: ( 'volatile' )
            // InternalCoreDsl.g:100:10: 'volatile'
            {
            match("volatile"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:101:8: ( 'static' )
            // InternalCoreDsl.g:101:10: 'static'
            {
            match("static"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:102:8: ( 'NONE' )
            // InternalCoreDsl.g:102:10: 'NONE'
            {
            match("NONE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:103:8: ( 'is_pc' )
            // InternalCoreDsl.g:103:10: 'is_pc'
            {
            match("is_pc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:104:8: ( 'is_interlock_for' )
            // InternalCoreDsl.g:104:10: 'is_interlock_for'
            {
            match("is_interlock_for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:105:8: ( 'no_cont' )
            // InternalCoreDsl.g:105:10: 'no_cont'
            {
            match("no_cont"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:106:8: ( 'cond' )
            // InternalCoreDsl.g:106:10: 'cond'
            {
            match("cond"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:107:8: ( 'flush' )
            // InternalCoreDsl.g:107:10: 'flush'
            {
            match("flush"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:108:8: ( 'struct' )
            // InternalCoreDsl.g:108:10: 'struct'
            {
            match("struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:109:8: ( 'union' )
            // InternalCoreDsl.g:109:10: 'union'
            {
            match("union"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "T__122"
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:110:8: ( 's' )
            // InternalCoreDsl.g:110:10: 's'
            {
            match('s'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "RULE_LEFT_BR"
    public final void mRULE_LEFT_BR() throws RecognitionException {
        try {
            int _type = RULE_LEFT_BR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6949:14: ( '[' )
            // InternalCoreDsl.g:6949:16: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LEFT_BR"

    // $ANTLR start "RULE_RIGHT_BR"
    public final void mRULE_RIGHT_BR() throws RecognitionException {
        try {
            int _type = RULE_RIGHT_BR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6951:15: ( ']' )
            // InternalCoreDsl.g:6951:17: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RIGHT_BR"

    // $ANTLR start "RULE_BVAL"
    public final void mRULE_BVAL() throws RecognitionException {
        try {
            int _type = RULE_BVAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6953:11: ( 'b' ( '0' .. '9' )+ )
            // InternalCoreDsl.g:6953:13: 'b' ( '0' .. '9' )+
            {
            match('b'); 
            // InternalCoreDsl.g:6953:17: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCoreDsl.g:6953:18: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BVAL"

    // $ANTLR start "RULE_BOOLEAN"
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6955:14: ( ( 'true' | 'false' ) )
            // InternalCoreDsl.g:6955:16: ( 'true' | 'false' )
            {
            // InternalCoreDsl.g:6955:16: ( 'true' | 'false' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='t') ) {
                alt2=1;
            }
            else if ( (LA2_0=='f') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalCoreDsl.g:6955:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6955:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6957:12: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'l' | 'L' )? )
            // InternalCoreDsl.g:6957:14: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'l' | 'L' )?
            {
            // InternalCoreDsl.g:6957:14: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCoreDsl.g:6957:15: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            match('.'); 
            // InternalCoreDsl.g:6957:30: ( '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalCoreDsl.g:6957:31: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalCoreDsl.g:6957:42: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='E'||LA7_0=='e') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalCoreDsl.g:6957:43: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalCoreDsl.g:6957:53: ( '+' | '-' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='+'||LA5_0=='-') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalCoreDsl.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    // InternalCoreDsl.g:6957:64: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalCoreDsl.g:6957:65: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    }
                    break;

            }

            // InternalCoreDsl.g:6957:78: ( 'f' | 'F' | 'l' | 'L' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='F'||LA8_0=='L'||LA8_0=='f'||LA8_0=='l') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalCoreDsl.g:
                    {
                    if ( input.LA(1)=='F'||input.LA(1)=='L'||input.LA(1)=='f'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT"

    // $ANTLR start "RULE_INTEGER"
    public final void mRULE_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6959:14: ( ( RULE_BINARYINT | RULE_HEXADECIMALINT | RULE_OCTALINT | RULE_DECIMALINT | RULE_VLOGINT ) ( 'u' | 'U' )? ( 'l' | 'L' ( 'l' | 'L' )? )? )
            // InternalCoreDsl.g:6959:16: ( RULE_BINARYINT | RULE_HEXADECIMALINT | RULE_OCTALINT | RULE_DECIMALINT | RULE_VLOGINT ) ( 'u' | 'U' )? ( 'l' | 'L' ( 'l' | 'L' )? )?
            {
            // InternalCoreDsl.g:6959:16: ( RULE_BINARYINT | RULE_HEXADECIMALINT | RULE_OCTALINT | RULE_DECIMALINT | RULE_VLOGINT )
            int alt9=5;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalCoreDsl.g:6959:17: RULE_BINARYINT
                    {
                    mRULE_BINARYINT(); 

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6959:32: RULE_HEXADECIMALINT
                    {
                    mRULE_HEXADECIMALINT(); 

                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6959:52: RULE_OCTALINT
                    {
                    mRULE_OCTALINT(); 

                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6959:66: RULE_DECIMALINT
                    {
                    mRULE_DECIMALINT(); 

                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:6959:82: RULE_VLOGINT
                    {
                    mRULE_VLOGINT(); 

                    }
                    break;

            }

            // InternalCoreDsl.g:6959:96: ( 'u' | 'U' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='U'||LA10_0=='u') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalCoreDsl.g:
                    {
                    if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalCoreDsl.g:6959:107: ( 'l' | 'L' ( 'l' | 'L' )? )?
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='l') ) {
                alt12=1;
            }
            else if ( (LA12_0=='L') ) {
                alt12=2;
            }
            switch (alt12) {
                case 1 :
                    // InternalCoreDsl.g:6959:108: 'l'
                    {
                    match('l'); 

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6959:112: 'L' ( 'l' | 'L' )?
                    {
                    match('L'); 
                    // InternalCoreDsl.g:6959:116: ( 'l' | 'L' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='L'||LA11_0=='l') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalCoreDsl.g:
                            {
                            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER"

    // $ANTLR start "RULE_BINARYINT"
    public final void mRULE_BINARYINT() throws RecognitionException {
        try {
            // InternalCoreDsl.g:6961:25: ( ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* )
            // InternalCoreDsl.g:6961:27: ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )*
            {
            // InternalCoreDsl.g:6961:27: ( '0b' | '0B' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='0') ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1=='b') ) {
                    alt13=1;
                }
                else if ( (LA13_1=='B') ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalCoreDsl.g:6961:28: '0b'
                    {
                    match("0b"); 


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6961:33: '0B'
                    {
                    match("0B"); 


                    }
                    break;

            }

            matchRange('0','1'); 
            // InternalCoreDsl.g:6961:48: ( ( '_' )? '0' .. '1' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='1')||LA15_0=='_') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalCoreDsl.g:6961:49: ( '_' )? '0' .. '1'
            	    {
            	    // InternalCoreDsl.g:6961:49: ( '_' )?
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0=='_') ) {
            	        alt14=1;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // InternalCoreDsl.g:6961:49: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    matchRange('0','1'); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINARYINT"

    // $ANTLR start "RULE_OCTALINT"
    public final void mRULE_OCTALINT() throws RecognitionException {
        try {
            // InternalCoreDsl.g:6963:24: ( '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            // InternalCoreDsl.g:6963:26: '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )*
            {
            match('0'); 
            // InternalCoreDsl.g:6963:30: ( '_' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='_') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalCoreDsl.g:6963:30: '_'
                    {
                    match('_'); 

                    }
                    break;

            }

            matchRange('0','7'); 
            // InternalCoreDsl.g:6963:44: ( ( '_' )? '0' .. '7' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='7')||LA18_0=='_') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalCoreDsl.g:6963:45: ( '_' )? '0' .. '7'
            	    {
            	    // InternalCoreDsl.g:6963:45: ( '_' )?
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0=='_') ) {
            	        alt17=1;
            	    }
            	    switch (alt17) {
            	        case 1 :
            	            // InternalCoreDsl.g:6963:45: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_OCTALINT"

    // $ANTLR start "RULE_DECIMALINT"
    public final void mRULE_DECIMALINT() throws RecognitionException {
        try {
            // InternalCoreDsl.g:6965:26: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) )
            // InternalCoreDsl.g:6965:28: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
            {
            // InternalCoreDsl.g:6965:28: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='0') ) {
                alt21=1;
            }
            else if ( ((LA21_0>='1' && LA21_0<='9')) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalCoreDsl.g:6965:29: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6965:33: '1' .. '9' ( ( '_' )? '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // InternalCoreDsl.g:6965:42: ( ( '_' )? '0' .. '9' )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>='0' && LA20_0<='9')||LA20_0=='_') ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalCoreDsl.g:6965:43: ( '_' )? '0' .. '9'
                    	    {
                    	    // InternalCoreDsl.g:6965:43: ( '_' )?
                    	    int alt19=2;
                    	    int LA19_0 = input.LA(1);

                    	    if ( (LA19_0=='_') ) {
                    	        alt19=1;
                    	    }
                    	    switch (alt19) {
                    	        case 1 :
                    	            // InternalCoreDsl.g:6965:43: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECIMALINT"

    // $ANTLR start "RULE_HEXADECIMALINT"
    public final void mRULE_HEXADECIMALINT() throws RecognitionException {
        try {
            // InternalCoreDsl.g:6967:30: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* )
            // InternalCoreDsl.g:6967:32: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
            {
            // InternalCoreDsl.g:6967:32: ( '0x' | '0X' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='0') ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1=='x') ) {
                    alt22=1;
                }
                else if ( (LA22_1=='X') ) {
                    alt22=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalCoreDsl.g:6967:33: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6967:38: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalCoreDsl.g:6967:73: ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='0' && LA24_0<='9')||(LA24_0>='A' && LA24_0<='F')||LA24_0=='_'||(LA24_0>='a' && LA24_0<='f')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalCoreDsl.g:6967:74: ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            	    {
            	    // InternalCoreDsl.g:6967:74: ( '_' )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0=='_') ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // InternalCoreDsl.g:6967:74: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEXADECIMALINT"

    // $ANTLR start "RULE_VLOGINT"
    public final void mRULE_VLOGINT() throws RecognitionException {
        try {
            // InternalCoreDsl.g:6969:23: ( ( '0' .. '9' )+ '\\'' ( 'b' ( '01' )+ | 'o' ( '0' .. '7' )+ | 'd' ( '0' .. '9' )+ | 'h' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ ) )
            // InternalCoreDsl.g:6969:25: ( '0' .. '9' )+ '\\'' ( 'b' ( '01' )+ | 'o' ( '0' .. '7' )+ | 'd' ( '0' .. '9' )+ | 'h' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            {
            // InternalCoreDsl.g:6969:25: ( '0' .. '9' )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='0' && LA25_0<='9')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalCoreDsl.g:6969:26: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            match('\''); 
            // InternalCoreDsl.g:6969:42: ( 'b' ( '01' )+ | 'o' ( '0' .. '7' )+ | 'd' ( '0' .. '9' )+ | 'h' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt30=1;
                }
                break;
            case 'o':
                {
                alt30=2;
                }
                break;
            case 'd':
                {
                alt30=3;
                }
                break;
            case 'h':
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalCoreDsl.g:6969:43: 'b' ( '01' )+
                    {
                    match('b'); 
                    // InternalCoreDsl.g:6969:47: ( '01' )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0=='0') ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalCoreDsl.g:6969:47: '01'
                    	    {
                    	    match("01"); 


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:6969:53: 'o' ( '0' .. '7' )+
                    {
                    match('o'); 
                    // InternalCoreDsl.g:6969:57: ( '0' .. '7' )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0>='0' && LA27_0<='7')) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalCoreDsl.g:6969:58: '0' .. '7'
                    	    {
                    	    matchRange('0','7'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:6969:69: 'd' ( '0' .. '9' )+
                    {
                    match('d'); 
                    // InternalCoreDsl.g:6969:73: ( '0' .. '9' )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0>='0' && LA28_0<='9')) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalCoreDsl.g:6969:74: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:6969:85: 'h' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    {
                    match('h'); 
                    // InternalCoreDsl.g:6969:89: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( ((LA29_0>='0' && LA29_0<='9')||(LA29_0>='A' && LA29_0<='F')||(LA29_0>='a' && LA29_0<='f')) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalCoreDsl.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_VLOGINT"

    // $ANTLR start "RULE_CHARCONST"
    public final void mRULE_CHARCONST() throws RecognitionException {
        try {
            int _type = RULE_CHARCONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6971:16: ( '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // InternalCoreDsl.g:6971:18: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // InternalCoreDsl.g:6971:23: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0=='\\') ) {
                    alt31=1;
                }
                else if ( ((LA31_0>='\u0000' && LA31_0<='&')||(LA31_0>='(' && LA31_0<='[')||(LA31_0>=']' && LA31_0<='\uFFFF')) ) {
                    alt31=2;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalCoreDsl.g:6971:24: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalCoreDsl.g:6971:31: ~ ( ( '\\\\' | '\\'' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARCONST"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6973:10: ( '~this one has been deactivated' )
            // InternalCoreDsl.g:6973:12: '~this one has been deactivated'
            {
            match("~this one has been deactivated"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6975:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalCoreDsl.g:6975:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalCoreDsl.g:6975:11: ( '^' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='^') ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalCoreDsl.g:6975:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalCoreDsl.g:6975:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>='0' && LA33_0<='9')||(LA33_0>='A' && LA33_0<='Z')||LA33_0=='_'||(LA33_0>='a' && LA33_0<='z')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalCoreDsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6977:13: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalCoreDsl.g:6977:15: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // InternalCoreDsl.g:6977:19: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
            loop34:
            do {
                int alt34=3;
                int LA34_0 = input.LA(1);

                if ( (LA34_0=='\\') ) {
                    alt34=1;
                }
                else if ( ((LA34_0>='\u0000' && LA34_0<='!')||(LA34_0>='#' && LA34_0<='[')||(LA34_0>=']' && LA34_0<='\uFFFF')) ) {
                    alt34=2;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalCoreDsl.g:6977:20: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalCoreDsl.g:6977:27: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6979:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalCoreDsl.g:6979:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalCoreDsl.g:6979:24: ( options {greedy=false; } : . )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0=='*') ) {
                    int LA35_1 = input.LA(2);

                    if ( (LA35_1=='/') ) {
                        alt35=2;
                    }
                    else if ( ((LA35_1>='\u0000' && LA35_1<='.')||(LA35_1>='0' && LA35_1<='\uFFFF')) ) {
                        alt35=1;
                    }


                }
                else if ( ((LA35_0>='\u0000' && LA35_0<=')')||(LA35_0>='+' && LA35_0<='\uFFFF')) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalCoreDsl.g:6979:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6981:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalCoreDsl.g:6981:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalCoreDsl.g:6981:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>='\u0000' && LA36_0<='\t')||(LA36_0>='\u000B' && LA36_0<='\f')||(LA36_0>='\u000E' && LA36_0<='\uFFFF')) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalCoreDsl.g:6981:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // InternalCoreDsl.g:6981:40: ( ( '\\r' )? '\\n' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0=='\n'||LA38_0=='\r') ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalCoreDsl.g:6981:41: ( '\\r' )? '\\n'
                    {
                    // InternalCoreDsl.g:6981:41: ( '\\r' )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0=='\r') ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalCoreDsl.g:6981:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6983:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalCoreDsl.g:6983:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalCoreDsl.g:6983:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>='\t' && LA39_0<='\n')||LA39_0=='\r'||LA39_0==' ') ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalCoreDsl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:6985:16: ( . )
            // InternalCoreDsl.g:6985:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalCoreDsl.g:1:8: ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | RULE_LEFT_BR | RULE_RIGHT_BR | RULE_BVAL | RULE_BOOLEAN | RULE_FLOAT | RULE_INTEGER | RULE_CHARCONST | RULE_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt40=114;
        alt40 = dfa40.predict(input);
        switch (alt40) {
            case 1 :
                // InternalCoreDsl.g:1:10: T__23
                {
                mT__23(); 

                }
                break;
            case 2 :
                // InternalCoreDsl.g:1:16: T__24
                {
                mT__24(); 

                }
                break;
            case 3 :
                // InternalCoreDsl.g:1:22: T__25
                {
                mT__25(); 

                }
                break;
            case 4 :
                // InternalCoreDsl.g:1:28: T__26
                {
                mT__26(); 

                }
                break;
            case 5 :
                // InternalCoreDsl.g:1:34: T__27
                {
                mT__27(); 

                }
                break;
            case 6 :
                // InternalCoreDsl.g:1:40: T__28
                {
                mT__28(); 

                }
                break;
            case 7 :
                // InternalCoreDsl.g:1:46: T__29
                {
                mT__29(); 

                }
                break;
            case 8 :
                // InternalCoreDsl.g:1:52: T__30
                {
                mT__30(); 

                }
                break;
            case 9 :
                // InternalCoreDsl.g:1:58: T__31
                {
                mT__31(); 

                }
                break;
            case 10 :
                // InternalCoreDsl.g:1:64: T__32
                {
                mT__32(); 

                }
                break;
            case 11 :
                // InternalCoreDsl.g:1:70: T__33
                {
                mT__33(); 

                }
                break;
            case 12 :
                // InternalCoreDsl.g:1:76: T__34
                {
                mT__34(); 

                }
                break;
            case 13 :
                // InternalCoreDsl.g:1:82: T__35
                {
                mT__35(); 

                }
                break;
            case 14 :
                // InternalCoreDsl.g:1:88: T__36
                {
                mT__36(); 

                }
                break;
            case 15 :
                // InternalCoreDsl.g:1:94: T__37
                {
                mT__37(); 

                }
                break;
            case 16 :
                // InternalCoreDsl.g:1:100: T__38
                {
                mT__38(); 

                }
                break;
            case 17 :
                // InternalCoreDsl.g:1:106: T__39
                {
                mT__39(); 

                }
                break;
            case 18 :
                // InternalCoreDsl.g:1:112: T__40
                {
                mT__40(); 

                }
                break;
            case 19 :
                // InternalCoreDsl.g:1:118: T__41
                {
                mT__41(); 

                }
                break;
            case 20 :
                // InternalCoreDsl.g:1:124: T__42
                {
                mT__42(); 

                }
                break;
            case 21 :
                // InternalCoreDsl.g:1:130: T__43
                {
                mT__43(); 

                }
                break;
            case 22 :
                // InternalCoreDsl.g:1:136: T__44
                {
                mT__44(); 

                }
                break;
            case 23 :
                // InternalCoreDsl.g:1:142: T__45
                {
                mT__45(); 

                }
                break;
            case 24 :
                // InternalCoreDsl.g:1:148: T__46
                {
                mT__46(); 

                }
                break;
            case 25 :
                // InternalCoreDsl.g:1:154: T__47
                {
                mT__47(); 

                }
                break;
            case 26 :
                // InternalCoreDsl.g:1:160: T__48
                {
                mT__48(); 

                }
                break;
            case 27 :
                // InternalCoreDsl.g:1:166: T__49
                {
                mT__49(); 

                }
                break;
            case 28 :
                // InternalCoreDsl.g:1:172: T__50
                {
                mT__50(); 

                }
                break;
            case 29 :
                // InternalCoreDsl.g:1:178: T__51
                {
                mT__51(); 

                }
                break;
            case 30 :
                // InternalCoreDsl.g:1:184: T__52
                {
                mT__52(); 

                }
                break;
            case 31 :
                // InternalCoreDsl.g:1:190: T__53
                {
                mT__53(); 

                }
                break;
            case 32 :
                // InternalCoreDsl.g:1:196: T__54
                {
                mT__54(); 

                }
                break;
            case 33 :
                // InternalCoreDsl.g:1:202: T__55
                {
                mT__55(); 

                }
                break;
            case 34 :
                // InternalCoreDsl.g:1:208: T__56
                {
                mT__56(); 

                }
                break;
            case 35 :
                // InternalCoreDsl.g:1:214: T__57
                {
                mT__57(); 

                }
                break;
            case 36 :
                // InternalCoreDsl.g:1:220: T__58
                {
                mT__58(); 

                }
                break;
            case 37 :
                // InternalCoreDsl.g:1:226: T__59
                {
                mT__59(); 

                }
                break;
            case 38 :
                // InternalCoreDsl.g:1:232: T__60
                {
                mT__60(); 

                }
                break;
            case 39 :
                // InternalCoreDsl.g:1:238: T__61
                {
                mT__61(); 

                }
                break;
            case 40 :
                // InternalCoreDsl.g:1:244: T__62
                {
                mT__62(); 

                }
                break;
            case 41 :
                // InternalCoreDsl.g:1:250: T__63
                {
                mT__63(); 

                }
                break;
            case 42 :
                // InternalCoreDsl.g:1:256: T__64
                {
                mT__64(); 

                }
                break;
            case 43 :
                // InternalCoreDsl.g:1:262: T__65
                {
                mT__65(); 

                }
                break;
            case 44 :
                // InternalCoreDsl.g:1:268: T__66
                {
                mT__66(); 

                }
                break;
            case 45 :
                // InternalCoreDsl.g:1:274: T__67
                {
                mT__67(); 

                }
                break;
            case 46 :
                // InternalCoreDsl.g:1:280: T__68
                {
                mT__68(); 

                }
                break;
            case 47 :
                // InternalCoreDsl.g:1:286: T__69
                {
                mT__69(); 

                }
                break;
            case 48 :
                // InternalCoreDsl.g:1:292: T__70
                {
                mT__70(); 

                }
                break;
            case 49 :
                // InternalCoreDsl.g:1:298: T__71
                {
                mT__71(); 

                }
                break;
            case 50 :
                // InternalCoreDsl.g:1:304: T__72
                {
                mT__72(); 

                }
                break;
            case 51 :
                // InternalCoreDsl.g:1:310: T__73
                {
                mT__73(); 

                }
                break;
            case 52 :
                // InternalCoreDsl.g:1:316: T__74
                {
                mT__74(); 

                }
                break;
            case 53 :
                // InternalCoreDsl.g:1:322: T__75
                {
                mT__75(); 

                }
                break;
            case 54 :
                // InternalCoreDsl.g:1:328: T__76
                {
                mT__76(); 

                }
                break;
            case 55 :
                // InternalCoreDsl.g:1:334: T__77
                {
                mT__77(); 

                }
                break;
            case 56 :
                // InternalCoreDsl.g:1:340: T__78
                {
                mT__78(); 

                }
                break;
            case 57 :
                // InternalCoreDsl.g:1:346: T__79
                {
                mT__79(); 

                }
                break;
            case 58 :
                // InternalCoreDsl.g:1:352: T__80
                {
                mT__80(); 

                }
                break;
            case 59 :
                // InternalCoreDsl.g:1:358: T__81
                {
                mT__81(); 

                }
                break;
            case 60 :
                // InternalCoreDsl.g:1:364: T__82
                {
                mT__82(); 

                }
                break;
            case 61 :
                // InternalCoreDsl.g:1:370: T__83
                {
                mT__83(); 

                }
                break;
            case 62 :
                // InternalCoreDsl.g:1:376: T__84
                {
                mT__84(); 

                }
                break;
            case 63 :
                // InternalCoreDsl.g:1:382: T__85
                {
                mT__85(); 

                }
                break;
            case 64 :
                // InternalCoreDsl.g:1:388: T__86
                {
                mT__86(); 

                }
                break;
            case 65 :
                // InternalCoreDsl.g:1:394: T__87
                {
                mT__87(); 

                }
                break;
            case 66 :
                // InternalCoreDsl.g:1:400: T__88
                {
                mT__88(); 

                }
                break;
            case 67 :
                // InternalCoreDsl.g:1:406: T__89
                {
                mT__89(); 

                }
                break;
            case 68 :
                // InternalCoreDsl.g:1:412: T__90
                {
                mT__90(); 

                }
                break;
            case 69 :
                // InternalCoreDsl.g:1:418: T__91
                {
                mT__91(); 

                }
                break;
            case 70 :
                // InternalCoreDsl.g:1:424: T__92
                {
                mT__92(); 

                }
                break;
            case 71 :
                // InternalCoreDsl.g:1:430: T__93
                {
                mT__93(); 

                }
                break;
            case 72 :
                // InternalCoreDsl.g:1:436: T__94
                {
                mT__94(); 

                }
                break;
            case 73 :
                // InternalCoreDsl.g:1:442: T__95
                {
                mT__95(); 

                }
                break;
            case 74 :
                // InternalCoreDsl.g:1:448: T__96
                {
                mT__96(); 

                }
                break;
            case 75 :
                // InternalCoreDsl.g:1:454: T__97
                {
                mT__97(); 

                }
                break;
            case 76 :
                // InternalCoreDsl.g:1:460: T__98
                {
                mT__98(); 

                }
                break;
            case 77 :
                // InternalCoreDsl.g:1:466: T__99
                {
                mT__99(); 

                }
                break;
            case 78 :
                // InternalCoreDsl.g:1:472: T__100
                {
                mT__100(); 

                }
                break;
            case 79 :
                // InternalCoreDsl.g:1:479: T__101
                {
                mT__101(); 

                }
                break;
            case 80 :
                // InternalCoreDsl.g:1:486: T__102
                {
                mT__102(); 

                }
                break;
            case 81 :
                // InternalCoreDsl.g:1:493: T__103
                {
                mT__103(); 

                }
                break;
            case 82 :
                // InternalCoreDsl.g:1:500: T__104
                {
                mT__104(); 

                }
                break;
            case 83 :
                // InternalCoreDsl.g:1:507: T__105
                {
                mT__105(); 

                }
                break;
            case 84 :
                // InternalCoreDsl.g:1:514: T__106
                {
                mT__106(); 

                }
                break;
            case 85 :
                // InternalCoreDsl.g:1:521: T__107
                {
                mT__107(); 

                }
                break;
            case 86 :
                // InternalCoreDsl.g:1:528: T__108
                {
                mT__108(); 

                }
                break;
            case 87 :
                // InternalCoreDsl.g:1:535: T__109
                {
                mT__109(); 

                }
                break;
            case 88 :
                // InternalCoreDsl.g:1:542: T__110
                {
                mT__110(); 

                }
                break;
            case 89 :
                // InternalCoreDsl.g:1:549: T__111
                {
                mT__111(); 

                }
                break;
            case 90 :
                // InternalCoreDsl.g:1:556: T__112
                {
                mT__112(); 

                }
                break;
            case 91 :
                // InternalCoreDsl.g:1:563: T__113
                {
                mT__113(); 

                }
                break;
            case 92 :
                // InternalCoreDsl.g:1:570: T__114
                {
                mT__114(); 

                }
                break;
            case 93 :
                // InternalCoreDsl.g:1:577: T__115
                {
                mT__115(); 

                }
                break;
            case 94 :
                // InternalCoreDsl.g:1:584: T__116
                {
                mT__116(); 

                }
                break;
            case 95 :
                // InternalCoreDsl.g:1:591: T__117
                {
                mT__117(); 

                }
                break;
            case 96 :
                // InternalCoreDsl.g:1:598: T__118
                {
                mT__118(); 

                }
                break;
            case 97 :
                // InternalCoreDsl.g:1:605: T__119
                {
                mT__119(); 

                }
                break;
            case 98 :
                // InternalCoreDsl.g:1:612: T__120
                {
                mT__120(); 

                }
                break;
            case 99 :
                // InternalCoreDsl.g:1:619: T__121
                {
                mT__121(); 

                }
                break;
            case 100 :
                // InternalCoreDsl.g:1:626: T__122
                {
                mT__122(); 

                }
                break;
            case 101 :
                // InternalCoreDsl.g:1:633: RULE_LEFT_BR
                {
                mRULE_LEFT_BR(); 

                }
                break;
            case 102 :
                // InternalCoreDsl.g:1:646: RULE_RIGHT_BR
                {
                mRULE_RIGHT_BR(); 

                }
                break;
            case 103 :
                // InternalCoreDsl.g:1:660: RULE_BVAL
                {
                mRULE_BVAL(); 

                }
                break;
            case 104 :
                // InternalCoreDsl.g:1:670: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 105 :
                // InternalCoreDsl.g:1:683: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 106 :
                // InternalCoreDsl.g:1:694: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 107 :
                // InternalCoreDsl.g:1:707: RULE_CHARCONST
                {
                mRULE_CHARCONST(); 

                }
                break;
            case 108 :
                // InternalCoreDsl.g:1:722: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 109 :
                // InternalCoreDsl.g:1:731: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 110 :
                // InternalCoreDsl.g:1:739: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 111 :
                // InternalCoreDsl.g:1:751: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 112 :
                // InternalCoreDsl.g:1:767: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 113 :
                // InternalCoreDsl.g:1:783: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 114 :
                // InternalCoreDsl.g:1:791: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA40 dfa40 = new DFA40(this);
    static final String DFA9_eotS =
        "\1\uffff\2\10\3\uffff\1\5\2\uffff\1\10\1\5";
    static final String DFA9_eofS =
        "\13\uffff";
    static final String DFA9_minS =
        "\1\60\2\47\3\uffff\1\47\2\uffff\2\47";
    static final String DFA9_maxS =
        "\1\71\1\170\1\71\3\uffff\1\71\2\uffff\2\71";
    static final String DFA9_acceptS =
        "\3\uffff\1\1\1\2\1\3\1\uffff\1\5\1\4\2\uffff";
    static final String DFA9_specialS =
        "\13\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\11\2",
            "\1\7\10\uffff\10\6\2\7\10\uffff\1\3\25\uffff\1\4\6\uffff\1\5\2\uffff\1\3\25\uffff\1\4",
            "\1\7\10\uffff\12\11",
            "",
            "",
            "",
            "\1\7\10\uffff\10\12\2\7",
            "",
            "",
            "\1\7\10\uffff\12\11",
            "\1\7\10\uffff\10\12\2\7"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "6959:16: ( RULE_BINARYINT | RULE_HEXADECIMALINT | RULE_OCTALINT | RULE_DECIMALINT | RULE_VLOGINT )";
        }
    }
    static final String DFA40_eotS =
        "\1\uffff\3\71\1\uffff\1\71\1\uffff\5\71\1\uffff\1\117\1\uffff\1\71\1\125\2\uffff\1\71\1\140\1\71\1\143\1\146\1\150\1\153\1\156\1\uffff\1\163\1\165\1\170\1\174\1\176\1\u0081\1\uffff\1\u0084\1\u0086\1\u0089\1\u008a\1\u008b\4\71\2\uffff\1\71\2\u0093\1\uffff\1\64\2\uffff\2\71\1\u009d\1\71\1\uffff\4\71\1\uffff\3\71\1\uffff\12\71\4\uffff\3\71\1\u00b6\4\uffff\1\71\1\u00b9\5\71\1\uffff\1\71\7\uffff\1\u00c3\2\uffff\1\u00c5\32\uffff\1\u00c6\1\71\3\uffff\4\71\2\uffff\1\71\1\uffff\1\u0093\2\uffff\1\u0093\2\uffff\2\71\1\u00d2\1\uffff\17\71\1\u00e5\10\71\1\uffff\2\71\1\uffff\10\71\5\uffff\10\71\1\u0093\2\71\1\uffff\5\71\1\u0108\1\u0109\2\71\1\u010c\1\u010d\1\u010e\6\71\1\uffff\3\71\1\u0118\3\71\1\u011c\14\71\1\u0129\1\u012a\1\71\1\u012c\1\71\1\u012e\2\71\1\u0131\5\71\2\uffff\1\u0138\1\71\3\uffff\4\71\1\u013e\1\71\1\u0140\1\u0141\1\u012e\1\uffff\2\71\1\u0144\1\uffff\3\71\1\u0148\2\71\1\u014b\2\71\1\u014e\1\71\1\u0150\2\uffff\1\71\1\uffff\1\71\1\uffff\1\u0153\1\71\1\uffff\3\71\1\u0158\2\71\1\uffff\2\71\1\u015d\2\71\1\uffff\1\71\2\uffff\2\71\1\uffff\1\71\1\u0164\1\u0165\1\uffff\1\u0166\1\u0167\1\uffff\1\u0168\1\u0169\1\uffff\1\71\1\uffff\2\71\1\uffff\3\71\1\u0170\1\uffff\4\71\1\uffff\5\71\1\u017a\6\uffff\2\71\1\u017d\3\71\1\uffff\1\u0181\1\71\1\u0183\4\71\1\u0188\1\u0189\1\uffff\1\u018a\1\u018b\1\uffff\3\71\1\uffff\1\u018f\1\uffff\1\u0190\2\71\1\u0193\4\uffff\3\71\2\uffff\2\71\1\uffff\4\71\1\u019d\1\u019e\3\71\2\uffff\4\71\1\u01a6\1\u01a7\1\71\2\uffff\1\u01a9\1\uffff";
    static final String DFA40_eofS =
        "\u01aa\uffff";
    static final String DFA40_minS =
        "\1\0\1\146\1\156\1\154\1\uffff\1\141\1\uffff\1\145\1\144\1\141\1\157\1\162\1\uffff\1\72\1\uffff\1\60\1\0\2\uffff\1\145\1\60\1\150\1\75\1\46\1\75\1\74\1\75\1\uffff\1\52\1\75\1\53\1\55\2\75\1\uffff\1\75\1\164\3\60\2\157\1\117\1\157\2\uffff\1\162\2\56\1\uffff\1\0\2\uffff\1\160\1\163\1\60\1\137\1\uffff\1\163\1\164\1\143\1\163\1\uffff\1\156\1\163\1\141\1\uffff\1\147\1\144\1\147\1\151\1\156\1\162\1\157\1\154\1\162\1\157\4\uffff\1\150\1\145\1\157\1\60\4\uffff\1\146\1\60\1\151\1\141\1\147\1\157\1\141\1\uffff\1\151\7\uffff\1\75\2\uffff\1\75\32\uffff\1\60\1\151\3\uffff\1\156\1\151\1\116\1\137\2\uffff\1\165\1\uffff\1\56\1\47\1\uffff\1\56\2\uffff\1\157\1\164\1\60\1\uffff\1\151\1\164\1\145\1\157\1\155\1\145\1\144\1\145\1\162\1\151\1\165\1\162\1\163\1\141\1\143\1\60\1\141\2\163\1\145\1\166\2\141\1\154\1\uffff\1\141\1\142\1\uffff\1\164\1\167\1\145\1\156\1\162\1\164\1\165\1\154\5\uffff\1\151\1\157\1\147\1\144\1\141\1\105\1\143\1\145\1\56\2\162\1\uffff\1\143\1\156\1\162\1\156\1\144\2\60\1\164\1\151\3\60\1\163\1\162\1\145\1\137\1\163\1\164\1\uffff\1\164\1\150\1\145\1\60\1\151\1\166\1\153\1\60\1\165\1\154\1\143\1\156\1\157\1\145\1\164\1\151\1\143\1\145\1\147\1\156\2\60\1\164\1\60\1\157\1\60\1\164\1\165\1\60\1\164\1\165\1\144\1\156\1\151\2\uffff\1\60\1\156\3\uffff\1\164\1\156\1\163\1\144\1\60\1\151\3\60\1\uffff\1\144\1\151\1\60\1\uffff\1\154\1\145\1\150\1\60\1\146\1\144\1\60\1\143\1\164\1\60\1\156\1\60\2\uffff\1\151\1\uffff\1\156\1\uffff\1\60\1\143\1\uffff\1\145\1\143\1\163\1\60\2\156\1\uffff\1\165\1\145\1\60\1\163\1\151\1\uffff\1\157\2\uffff\1\145\1\157\1\uffff\1\164\2\60\1\uffff\2\60\1\uffff\2\60\1\uffff\1\145\1\uffff\1\154\1\164\1\uffff\1\164\1\162\1\164\1\60\1\uffff\1\147\1\164\1\145\1\162\1\uffff\1\137\1\163\1\156\1\163\1\162\1\60\6\uffff\1\144\1\145\1\60\1\151\1\154\1\151\1\uffff\1\60\1\163\1\60\2\163\1\141\1\163\2\60\1\uffff\2\60\1\uffff\3\157\1\uffff\1\60\1\uffff\1\60\1\160\1\163\1\60\4\uffff\1\156\1\143\1\156\2\uffff\1\141\1\163\1\uffff\1\163\1\153\1\123\1\143\2\60\1\137\2\145\2\uffff\1\146\1\164\1\163\1\157\2\60\1\162\2\uffff\1\60\1\uffff";
    static final String DFA40_maxS =
        "\1\uffff\1\163\1\156\1\170\1\uffff\1\157\1\uffff\1\145\1\162\1\165\1\157\1\162\1\uffff\1\72\1\uffff\1\162\1\uffff\2\uffff\1\157\1\172\1\150\4\75\1\76\1\uffff\3\75\1\76\1\172\1\174\1\uffff\1\75\1\164\3\172\2\157\1\117\1\157\2\uffff\1\162\2\71\1\uffff\1\uffff\2\uffff\1\160\1\164\1\172\1\137\1\uffff\1\163\1\164\1\165\1\163\1\uffff\1\156\1\163\1\141\1\uffff\1\164\1\144\1\147\1\151\1\156\1\162\1\165\1\154\1\162\1\157\4\uffff\1\150\1\145\1\157\1\172\4\uffff\1\146\1\172\1\151\1\141\1\172\1\157\1\162\1\uffff\1\151\7\uffff\1\75\2\uffff\1\75\32\uffff\1\172\1\163\3\uffff\1\156\1\154\1\116\1\137\2\uffff\1\165\1\uffff\2\71\1\uffff\1\71\2\uffff\1\157\1\164\1\172\1\uffff\1\160\1\164\1\145\1\157\1\155\1\145\1\164\1\145\1\162\1\151\1\165\1\162\1\163\1\141\1\143\1\172\1\141\2\163\1\145\1\166\2\141\1\154\1\uffff\1\141\1\142\1\uffff\1\164\1\167\1\145\1\156\1\162\1\164\1\165\1\154\5\uffff\1\151\1\157\1\147\1\144\1\141\1\105\1\143\1\145\1\71\2\162\1\uffff\1\143\1\156\2\162\1\144\2\172\1\164\1\151\3\172\1\163\1\162\1\145\1\137\1\163\1\164\1\uffff\1\164\1\150\1\145\1\172\1\151\1\166\1\153\1\172\1\165\1\154\1\143\1\156\1\157\1\145\1\164\1\151\1\143\1\145\1\147\1\156\2\172\1\164\1\172\1\157\1\172\1\164\1\165\1\172\1\164\1\165\1\144\1\156\1\151\2\uffff\1\172\1\156\3\uffff\1\164\1\156\1\163\1\144\1\172\1\151\3\172\1\uffff\1\144\1\151\1\172\1\uffff\1\154\1\145\1\150\1\172\1\146\1\144\1\172\1\143\1\164\1\172\1\156\1\172\2\uffff\1\151\1\uffff\1\156\1\uffff\1\172\1\143\1\uffff\1\145\1\143\1\163\1\172\2\156\1\uffff\1\165\1\145\1\172\1\163\1\151\1\uffff\1\157\2\uffff\1\145\1\157\1\uffff\1\164\2\172\1\uffff\2\172\1\uffff\2\172\1\uffff\1\145\1\uffff\1\154\1\164\1\uffff\1\164\1\162\1\164\1\172\1\uffff\1\147\1\164\1\145\1\162\1\uffff\1\137\1\163\1\156\1\163\1\162\1\172\6\uffff\1\144\1\145\1\172\1\151\1\154\1\151\1\uffff\1\172\1\163\1\172\2\163\1\141\1\163\2\172\1\uffff\2\172\1\uffff\3\157\1\uffff\1\172\1\uffff\1\172\1\160\1\163\1\172\4\uffff\1\156\1\143\1\156\2\uffff\1\141\1\163\1\uffff\1\163\1\153\1\123\1\143\2\172\1\137\2\145\2\uffff\1\146\1\164\1\163\1\157\2\172\1\162\2\uffff\1\172\1\uffff";
    static final String DFA40_acceptS =
        "\4\uffff\1\4\1\uffff\1\6\5\uffff\1\15\1\uffff\1\20\2\uffff\1\26\1\27\10\uffff\1\52\6\uffff\1\65\11\uffff\1\145\1\146\3\uffff\1\155\1\uffff\1\161\1\162\4\uffff\1\155\4\uffff\1\4\3\uffff\1\6\12\uffff\1\15\1\23\1\17\1\20\4\uffff\1\24\1\153\1\26\1\27\7\uffff\1\144\1\uffff\1\53\1\44\1\62\1\67\1\45\1\72\1\46\1\uffff\1\74\1\47\1\uffff\1\75\1\50\1\52\1\54\1\157\1\160\1\102\1\55\1\103\1\56\1\104\1\100\1\57\1\105\1\111\1\101\1\63\1\71\1\64\1\66\1\70\1\65\1\73\1\110\1\154\1\107\2\uffff\1\113\1\114\1\115\4\uffff\1\145\1\146\1\uffff\1\152\2\uffff\1\151\1\uffff\1\156\1\161\3\uffff\1\32\30\uffff\1\147\2\uffff\1\36\10\uffff\1\60\1\76\1\61\1\77\1\112\13\uffff\1\121\22\uffff\1\37\42\uffff\1\51\1\33\2\uffff\1\140\1\30\1\117\11\uffff\1\13\3\uffff\1\116\14\uffff\1\122\1\127\1\uffff\1\134\1\uffff\1\150\2\uffff\1\135\6\uffff\1\131\5\uffff\1\130\1\uffff\1\125\1\141\2\uffff\1\41\3\uffff\1\43\2\uffff\1\120\2\uffff\1\35\1\uffff\1\143\2\uffff\1\1\4\uffff\1\25\4\uffff\1\42\6\uffff\1\126\1\34\1\106\1\123\1\133\1\142\6\uffff\1\3\11\uffff\1\31\2\uffff\1\137\3\uffff\1\16\1\uffff\1\40\4\uffff\1\14\1\22\1\124\1\132\3\uffff\1\5\1\7\2\uffff\1\11\11\uffff\1\21\1\12\7\uffff\1\2\1\10\1\uffff\1\136";
    static final String DFA40_specialS =
        "\1\0\17\uffff\1\1\41\uffff\1\2\u0177\uffff}>";
    static final String[] DFA40_transitionS = {
            "\11\64\2\63\2\64\1\63\22\64\1\63\1\43\1\62\2\64\1\35\1\27\1\20\1\21\1\22\1\26\1\36\1\14\1\37\1\33\1\34\1\57\11\60\1\15\1\16\1\31\1\30\1\32\1\42\1\64\2\61\1\12\5\61\1\2\2\61\1\47\1\61\1\52\6\61\1\46\5\61\1\54\1\64\1\55\1\40\1\61\1\64\1\10\1\17\1\5\1\23\1\3\1\11\2\61\1\1\2\61\1\50\1\61\1\53\1\61\1\13\1\61\1\7\1\24\1\56\1\45\1\51\1\25\3\61\1\4\1\41\1\6\1\44\uff81\64",
            "\1\67\6\uffff\1\65\1\66\4\uffff\1\70",
            "\1\72",
            "\1\75\1\uffff\1\74\11\uffff\1\73",
            "",
            "\1\100\6\uffff\1\101\6\uffff\1\77",
            "",
            "\1\103",
            "\1\104\7\uffff\1\106\5\uffff\1\105",
            "\1\112\12\uffff\1\111\2\uffff\1\110\5\uffff\1\107",
            "\1\113",
            "\1\114",
            "",
            "\1\116",
            "",
            "\12\124\53\uffff\1\121\11\uffff\1\123\2\uffff\1\122",
            "\0\126",
            "",
            "",
            "\1\131\11\uffff\1\132",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\7\71\1\136\1\135\6\71\1\134\3\71\1\137\2\71\1\133\3\71",
            "\1\141",
            "\1\142",
            "\1\145\26\uffff\1\144",
            "\1\147",
            "\1\151\1\152",
            "\1\155\1\154",
            "",
            "\1\161\4\uffff\1\162\15\uffff\1\160",
            "\1\164",
            "\1\167\21\uffff\1\166",
            "\1\172\17\uffff\1\171\1\173",
            "\1\175\3\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\177\76\uffff\1\u0080",
            "",
            "\1\u0083",
            "\1\u0085",
            "\10\71\1\u0087\1\71\7\uffff\32\71\4\uffff\1\71\1\uffff\15\71\1\u0088\14\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "",
            "",
            "\1\u0092",
            "\1\u0096\1\uffff\10\u0094\2\u0095",
            "\1\u0096\1\uffff\12\u0097",
            "",
            "\0\u0098",
            "",
            "",
            "\1\u009a",
            "\1\u009b\1\u009c",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u009e",
            "",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1\21\uffff\1\u00a2",
            "\1\u00a3",
            "",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\1\u00a7\14\uffff\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae\5\uffff\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "",
            "",
            "",
            "",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\12\124\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "",
            "",
            "",
            "\1\u00b7",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\24\71\1\u00b8\5\71",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bd\22\uffff\1\u00bc",
            "\1\u00be",
            "\1\u00bf\20\uffff\1\u00c0",
            "",
            "\1\u00c1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00c2",
            "",
            "",
            "\1\u00c4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u00c8\11\uffff\1\u00c7",
            "",
            "",
            "",
            "\1\u00c9",
            "\1\u00ca\2\uffff\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "",
            "",
            "\1\u00ce",
            "",
            "\1\u0096\1\uffff\10\u00cf\2\u0095",
            "\1\u0093\6\uffff\1\u0096\1\uffff\12\u0095",
            "",
            "\1\u0096\1\uffff\12\u0097",
            "",
            "",
            "\1\u00d0",
            "\1\u00d1",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\1\u00d4\6\uffff\1\u00d3",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00dc\16\uffff\1\u00da\1\u00db",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "",
            "\1\u00ee",
            "\1\u00ef",
            "",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "",
            "",
            "",
            "",
            "",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0096\1\uffff\10\u00cf\2\u0095",
            "\1\u0100",
            "\1\u0101",
            "",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105\3\uffff\1\u0106",
            "\1\u0107",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u010a",
            "\1\u010b",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u012b",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u012d",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u012f",
            "\1\u0130",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\1\u0137\31\71",
            "\1\u0139",
            "",
            "",
            "",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u013f",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\1\u0142",
            "\1\u0143",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u0149",
            "\1\u014a",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u014c",
            "\1\u014d",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u014f",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "",
            "\1\u0151",
            "",
            "\1\u0152",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u0154",
            "",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u0159",
            "\1\u015a",
            "",
            "\1\u015b",
            "\1\u015c",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u015e",
            "\1\u015f",
            "",
            "\1\u0160",
            "",
            "",
            "\1\u0161",
            "\1\u0162",
            "",
            "\1\u0163",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\1\u016a",
            "",
            "\1\u016b",
            "\1\u016c",
            "",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\1\u0171",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "",
            "\1\u0175",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u017b",
            "\1\u017c",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u017e",
            "\1\u017f",
            "\1\u0180",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u0182",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u0184",
            "\1\u0185",
            "\1\u0186",
            "\1\u0187",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u0191",
            "\1\u0192",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "",
            "",
            "",
            "",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196",
            "",
            "",
            "\1\u0197",
            "\1\u0198",
            "",
            "\1\u0199",
            "\1\u019a",
            "\1\u019b",
            "\1\u019c",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u019f",
            "\1\u01a0",
            "\1\u01a1",
            "",
            "",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            "\1\u01a8",
            "",
            "",
            "\12\71\7\uffff\32\71\4\uffff\1\71\1\uffff\32\71",
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | RULE_LEFT_BR | RULE_RIGHT_BR | RULE_BVAL | RULE_BOOLEAN | RULE_FLOAT | RULE_INTEGER | RULE_CHARCONST | RULE_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_0 = input.LA(1);

                        s = -1;
                        if ( (LA40_0=='i') ) {s = 1;}

                        else if ( (LA40_0=='I') ) {s = 2;}

                        else if ( (LA40_0=='e') ) {s = 3;}

                        else if ( (LA40_0=='{') ) {s = 4;}

                        else if ( (LA40_0=='c') ) {s = 5;}

                        else if ( (LA40_0=='}') ) {s = 6;}

                        else if ( (LA40_0=='r') ) {s = 7;}

                        else if ( (LA40_0=='a') ) {s = 8;}

                        else if ( (LA40_0=='f') ) {s = 9;}

                        else if ( (LA40_0=='C') ) {s = 10;}

                        else if ( (LA40_0=='p') ) {s = 11;}

                        else if ( (LA40_0==',') ) {s = 12;}

                        else if ( (LA40_0==':') ) {s = 13;}

                        else if ( (LA40_0==';') ) {s = 14;}

                        else if ( (LA40_0=='b') ) {s = 15;}

                        else if ( (LA40_0=='\'') ) {s = 16;}

                        else if ( (LA40_0=='(') ) {s = 17;}

                        else if ( (LA40_0==')') ) {s = 18;}

                        else if ( (LA40_0=='d') ) {s = 19;}

                        else if ( (LA40_0=='s') ) {s = 20;}

                        else if ( (LA40_0=='w') ) {s = 21;}

                        else if ( (LA40_0=='*') ) {s = 22;}

                        else if ( (LA40_0=='&') ) {s = 23;}

                        else if ( (LA40_0=='=') ) {s = 24;}

                        else if ( (LA40_0=='<') ) {s = 25;}

                        else if ( (LA40_0=='>') ) {s = 26;}

                        else if ( (LA40_0=='.') ) {s = 27;}

                        else if ( (LA40_0=='/') ) {s = 28;}

                        else if ( (LA40_0=='%') ) {s = 29;}

                        else if ( (LA40_0=='+') ) {s = 30;}

                        else if ( (LA40_0=='-') ) {s = 31;}

                        else if ( (LA40_0=='^') ) {s = 32;}

                        else if ( (LA40_0=='|') ) {s = 33;}

                        else if ( (LA40_0=='?') ) {s = 34;}

                        else if ( (LA40_0=='!') ) {s = 35;}

                        else if ( (LA40_0=='~') ) {s = 36;}

                        else if ( (LA40_0=='u') ) {s = 37;}

                        else if ( (LA40_0=='U') ) {s = 38;}

                        else if ( (LA40_0=='L') ) {s = 39;}

                        else if ( (LA40_0=='l') ) {s = 40;}

                        else if ( (LA40_0=='v') ) {s = 41;}

                        else if ( (LA40_0=='N') ) {s = 42;}

                        else if ( (LA40_0=='n') ) {s = 43;}

                        else if ( (LA40_0=='[') ) {s = 44;}

                        else if ( (LA40_0==']') ) {s = 45;}

                        else if ( (LA40_0=='t') ) {s = 46;}

                        else if ( (LA40_0=='0') ) {s = 47;}

                        else if ( ((LA40_0>='1' && LA40_0<='9')) ) {s = 48;}

                        else if ( ((LA40_0>='A' && LA40_0<='B')||(LA40_0>='D' && LA40_0<='H')||(LA40_0>='J' && LA40_0<='K')||LA40_0=='M'||(LA40_0>='O' && LA40_0<='T')||(LA40_0>='V' && LA40_0<='Z')||LA40_0=='_'||(LA40_0>='g' && LA40_0<='h')||(LA40_0>='j' && LA40_0<='k')||LA40_0=='m'||LA40_0=='o'||LA40_0=='q'||(LA40_0>='x' && LA40_0<='z')) ) {s = 49;}

                        else if ( (LA40_0=='\"') ) {s = 50;}

                        else if ( ((LA40_0>='\t' && LA40_0<='\n')||LA40_0=='\r'||LA40_0==' ') ) {s = 51;}

                        else if ( ((LA40_0>='\u0000' && LA40_0<='\b')||(LA40_0>='\u000B' && LA40_0<='\f')||(LA40_0>='\u000E' && LA40_0<='\u001F')||(LA40_0>='#' && LA40_0<='$')||LA40_0=='@'||LA40_0=='\\'||LA40_0=='`'||(LA40_0>='\u007F' && LA40_0<='\uFFFF')) ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_16 = input.LA(1);

                        s = -1;
                        if ( ((LA40_16>='\u0000' && LA40_16<='\uFFFF')) ) {s = 86;}

                        else s = 85;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA40_50 = input.LA(1);

                        s = -1;
                        if ( ((LA40_50>='\u0000' && LA40_50<='\uFFFF')) ) {s = 152;}

                        else s = 52;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}