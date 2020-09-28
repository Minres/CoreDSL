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

    public InternalCoreDslLexer() {;} 
    public InternalCoreDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCoreDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalCoreDsl.g"; }

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:17:7: ( 'address_spaces' )
            // InternalCoreDsl.g:17:9: 'address_spaces'
            {
            match("address_spaces"); 


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
            // InternalCoreDsl.g:18:7: ( 'registers' )
            // InternalCoreDsl.g:18:9: 'registers'
            {
            match("registers"); 


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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:24:7: ( '[[' )
            // InternalCoreDsl.g:24:9: '[['
            {
            match("[["); 


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
            // InternalCoreDsl.g:25:7: ( ']]' )
            // InternalCoreDsl.g:25:9: ']]'
            {
            match("]]"); 


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
            // InternalCoreDsl.g:26:7: ( 'encoding' )
            // InternalCoreDsl.g:26:9: 'encoding'
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
            // InternalCoreDsl.g:27:7: ( ':' )
            // InternalCoreDsl.g:27:9: ':'
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
            // InternalCoreDsl.g:28:7: ( ';' )
            // InternalCoreDsl.g:28:9: ';'
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
            // InternalCoreDsl.g:29:7: ( 'args_disass' )
            // InternalCoreDsl.g:29:9: 'args_disass'
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
            // InternalCoreDsl.g:30:7: ( 'behavior' )
            // InternalCoreDsl.g:30:9: 'behavior'
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
            // InternalCoreDsl.g:31:7: ( '|' )
            // InternalCoreDsl.g:31:9: '|'
            {
            match('|'); 

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
            // InternalCoreDsl.g:32:7: ( '\\'' )
            // InternalCoreDsl.g:32:9: '\\''
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
            // InternalCoreDsl.g:33:7: ( '[' )
            // InternalCoreDsl.g:33:9: '['
            {
            match('['); 

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
            // InternalCoreDsl.g:34:7: ( ']' )
            // InternalCoreDsl.g:34:9: ']'
            {
            match(']'); 

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
            // InternalCoreDsl.g:35:7: ( 'extern' )
            // InternalCoreDsl.g:35:9: 'extern'
            {
            match("extern"); 


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
            // InternalCoreDsl.g:36:7: ( '(' )
            // InternalCoreDsl.g:36:9: '('
            {
            match('('); 

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
            // InternalCoreDsl.g:37:7: ( ')' )
            // InternalCoreDsl.g:37:9: ')'
            {
            match(')'); 

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
            // InternalCoreDsl.g:38:7: ( 'case' )
            // InternalCoreDsl.g:38:9: 'case'
            {
            match("case"); 


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
            // InternalCoreDsl.g:39:7: ( 'default' )
            // InternalCoreDsl.g:39:9: 'default'
            {
            match("default"); 


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
            // InternalCoreDsl.g:40:7: ( 'if' )
            // InternalCoreDsl.g:40:9: 'if'
            {
            match("if"); 


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
            // InternalCoreDsl.g:41:7: ( 'else' )
            // InternalCoreDsl.g:41:9: 'else'
            {
            match("else"); 


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
            // InternalCoreDsl.g:42:7: ( 'switch' )
            // InternalCoreDsl.g:42:9: 'switch'
            {
            match("switch"); 


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
            // InternalCoreDsl.g:43:7: ( 'while' )
            // InternalCoreDsl.g:43:9: 'while'
            {
            match("while"); 


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
            // InternalCoreDsl.g:44:7: ( 'do' )
            // InternalCoreDsl.g:44:9: 'do'
            {
            match("do"); 


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
            // InternalCoreDsl.g:45:7: ( 'for' )
            // InternalCoreDsl.g:45:9: 'for'
            {
            match("for"); 


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
            // InternalCoreDsl.g:46:7: ( 'continue' )
            // InternalCoreDsl.g:46:9: 'continue'
            {
            match("continue"); 


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
            // InternalCoreDsl.g:47:7: ( 'break' )
            // InternalCoreDsl.g:47:9: 'break'
            {
            match("break"); 


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
            // InternalCoreDsl.g:48:7: ( 'return' )
            // InternalCoreDsl.g:48:9: 'return'
            {
            match("return"); 


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
            // InternalCoreDsl.g:49:7: ( 'typedef' )
            // InternalCoreDsl.g:49:9: 'typedef'
            {
            match("typedef"); 


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
            // InternalCoreDsl.g:50:7: ( '<' )
            // InternalCoreDsl.g:50:9: '<'
            {
            match('<'); 

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
            // InternalCoreDsl.g:51:7: ( '>' )
            // InternalCoreDsl.g:51:9: '>'
            {
            match('>'); 

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
            // InternalCoreDsl.g:52:7: ( 'enum' )
            // InternalCoreDsl.g:52:9: 'enum'
            {
            match("enum"); 


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
            // InternalCoreDsl.g:53:7: ( '=' )
            // InternalCoreDsl.g:53:9: '='
            {
            match('='); 

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
            // InternalCoreDsl.g:54:7: ( '.' )
            // InternalCoreDsl.g:54:9: '.'
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
            // InternalCoreDsl.g:55:7: ( '*=' )
            // InternalCoreDsl.g:55:9: '*='
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
            // InternalCoreDsl.g:56:7: ( '/=' )
            // InternalCoreDsl.g:56:9: '/='
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
            // InternalCoreDsl.g:57:7: ( '%=' )
            // InternalCoreDsl.g:57:9: '%='
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
            // InternalCoreDsl.g:58:7: ( '+=' )
            // InternalCoreDsl.g:58:9: '+='
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
            // InternalCoreDsl.g:59:7: ( '-=' )
            // InternalCoreDsl.g:59:9: '-='
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
            // InternalCoreDsl.g:60:7: ( '<<=' )
            // InternalCoreDsl.g:60:9: '<<='
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
            // InternalCoreDsl.g:61:7: ( '>>=' )
            // InternalCoreDsl.g:61:9: '>>='
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
            // InternalCoreDsl.g:62:7: ( '&=' )
            // InternalCoreDsl.g:62:9: '&='
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
            // InternalCoreDsl.g:63:7: ( '^=' )
            // InternalCoreDsl.g:63:9: '^='
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
            // InternalCoreDsl.g:64:7: ( '|=' )
            // InternalCoreDsl.g:64:9: '|='
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
            // InternalCoreDsl.g:65:7: ( '?' )
            // InternalCoreDsl.g:65:9: '?'
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
            // InternalCoreDsl.g:66:7: ( '||' )
            // InternalCoreDsl.g:66:9: '||'
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
            // InternalCoreDsl.g:67:7: ( '&&' )
            // InternalCoreDsl.g:67:9: '&&'
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
            // InternalCoreDsl.g:68:7: ( '^' )
            // InternalCoreDsl.g:68:9: '^'
            {
            match('^'); 

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
            // InternalCoreDsl.g:69:7: ( '&' )
            // InternalCoreDsl.g:69:9: '&'
            {
            match('&'); 

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
            // InternalCoreDsl.g:70:7: ( '==' )
            // InternalCoreDsl.g:70:9: '=='
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
            // InternalCoreDsl.g:71:7: ( '!=' )
            // InternalCoreDsl.g:71:9: '!='
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
            // InternalCoreDsl.g:72:7: ( '<=' )
            // InternalCoreDsl.g:72:9: '<='
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
            // InternalCoreDsl.g:73:7: ( '>=' )
            // InternalCoreDsl.g:73:9: '>='
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
            // InternalCoreDsl.g:74:7: ( '<<' )
            // InternalCoreDsl.g:74:9: '<<'
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
            // InternalCoreDsl.g:75:7: ( '>>' )
            // InternalCoreDsl.g:75:9: '>>'
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
            // InternalCoreDsl.g:76:7: ( '+' )
            // InternalCoreDsl.g:76:9: '+'
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
            // InternalCoreDsl.g:77:7: ( '-' )
            // InternalCoreDsl.g:77:9: '-'
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
            // InternalCoreDsl.g:78:7: ( '*' )
            // InternalCoreDsl.g:78:9: '*'
            {
            match('*'); 

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
            // InternalCoreDsl.g:79:7: ( '/' )
            // InternalCoreDsl.g:79:9: '/'
            {
            match('/'); 

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
            // InternalCoreDsl.g:80:7: ( '%' )
            // InternalCoreDsl.g:80:9: '%'
            {
            match('%'); 

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
            // InternalCoreDsl.g:81:7: ( '++' )
            // InternalCoreDsl.g:81:9: '++'
            {
            match("++"); 


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
            // InternalCoreDsl.g:82:7: ( '--' )
            // InternalCoreDsl.g:82:9: '--'
            {
            match("--"); 


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
            // InternalCoreDsl.g:83:7: ( 'sizeof' )
            // InternalCoreDsl.g:83:9: 'sizeof'
            {
            match("sizeof"); 


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
            // InternalCoreDsl.g:84:7: ( '~' )
            // InternalCoreDsl.g:84:9: '~'
            {
            match('~'); 

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
            // InternalCoreDsl.g:85:7: ( '!' )
            // InternalCoreDsl.g:85:9: '!'
            {
            match('!'); 

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
            // InternalCoreDsl.g:86:7: ( '->' )
            // InternalCoreDsl.g:86:9: '->'
            {
            match("->"); 


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
            // InternalCoreDsl.g:87:7: ( 'u8' )
            // InternalCoreDsl.g:87:9: 'u8'
            {
            match("u8"); 


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
            // InternalCoreDsl.g:88:7: ( 'u' )
            // InternalCoreDsl.g:88:9: 'u'
            {
            match('u'); 

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
            // InternalCoreDsl.g:89:7: ( 'U' )
            // InternalCoreDsl.g:89:9: 'U'
            {
            match('U'); 

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
            // InternalCoreDsl.g:90:8: ( 'L' )
            // InternalCoreDsl.g:90:10: 'L'
            {
            match('L'); 

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
            // InternalCoreDsl.g:91:8: ( 'l' )
            // InternalCoreDsl.g:91:10: 'l'
            {
            match('l'); 

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
            // InternalCoreDsl.g:92:8: ( 'll' )
            // InternalCoreDsl.g:92:10: 'll'
            {
            match("ll"); 


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
            // InternalCoreDsl.g:93:8: ( 'LL' )
            // InternalCoreDsl.g:93:10: 'LL'
            {
            match("LL"); 


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
            // InternalCoreDsl.g:94:8: ( 'f' )
            // InternalCoreDsl.g:94:10: 'f'
            {
            match('f'); 

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
            // InternalCoreDsl.g:95:8: ( 'F' )
            // InternalCoreDsl.g:95:10: 'F'
            {
            match('F'); 

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
            // InternalCoreDsl.g:96:8: ( 'bool' )
            // InternalCoreDsl.g:96:10: 'bool'
            {
            match("bool"); 


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
            // InternalCoreDsl.g:97:8: ( 'char' )
            // InternalCoreDsl.g:97:10: 'char'
            {
            match("char"); 


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
            // InternalCoreDsl.g:98:8: ( 'short' )
            // InternalCoreDsl.g:98:10: 'short'
            {
            match("short"); 


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
            // InternalCoreDsl.g:99:8: ( 'int' )
            // InternalCoreDsl.g:99:10: 'int'
            {
            match("int"); 


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
            // InternalCoreDsl.g:100:8: ( 'long' )
            // InternalCoreDsl.g:100:10: 'long'
            {
            match("long"); 


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
            // InternalCoreDsl.g:101:8: ( 'signed' )
            // InternalCoreDsl.g:101:10: 'signed'
            {
            match("signed"); 


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
            // InternalCoreDsl.g:102:8: ( 'unsigned' )
            // InternalCoreDsl.g:102:10: 'unsigned'
            {
            match("unsigned"); 


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
            // InternalCoreDsl.g:103:8: ( 'float' )
            // InternalCoreDsl.g:103:10: 'float'
            {
            match("float"); 


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
            // InternalCoreDsl.g:104:8: ( 'double' )
            // InternalCoreDsl.g:104:10: 'double'
            {
            match("double"); 


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
            // InternalCoreDsl.g:105:8: ( 'frac' )
            // InternalCoreDsl.g:105:10: 'frac'
            {
            match("frac"); 


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
            // InternalCoreDsl.g:106:8: ( 'accum' )
            // InternalCoreDsl.g:106:10: 'accum'
            {
            match("accum"); 


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
            // InternalCoreDsl.g:107:8: ( 'const' )
            // InternalCoreDsl.g:107:10: 'const'
            {
            match("const"); 


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
            // InternalCoreDsl.g:108:8: ( 'volatile' )
            // InternalCoreDsl.g:108:10: 'volatile'
            {
            match("volatile"); 


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
            // InternalCoreDsl.g:109:8: ( 'static' )
            // InternalCoreDsl.g:109:10: 'static'
            {
            match("static"); 


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
            // InternalCoreDsl.g:110:8: ( 'NONE' )
            // InternalCoreDsl.g:110:10: 'NONE'
            {
            match("NONE"); 


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
            // InternalCoreDsl.g:111:8: ( 'is_pc' )
            // InternalCoreDsl.g:111:10: 'is_pc'
            {
            match("is_pc"); 


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
            // InternalCoreDsl.g:112:8: ( 'delete' )
            // InternalCoreDsl.g:112:10: 'delete'
            {
            match("delete"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "T__123"
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:113:8: ( 'no_cont' )
            // InternalCoreDsl.g:113:10: 'no_cont'
            {
            match("no_cont"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "T__124"
    public final void mT__124() throws RecognitionException {
        try {
            int _type = T__124;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:114:8: ( 'cond' )
            // InternalCoreDsl.g:114:10: 'cond'
            {
            match("cond"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__124"

    // $ANTLR start "T__125"
    public final void mT__125() throws RecognitionException {
        try {
            int _type = T__125;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:115:8: ( 'flush' )
            // InternalCoreDsl.g:115:10: 'flush'
            {
            match("flush"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__125"

    // $ANTLR start "T__126"
    public final void mT__126() throws RecognitionException {
        try {
            int _type = T__126;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:116:8: ( 'struct' )
            // InternalCoreDsl.g:116:10: 'struct'
            {
            match("struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__126"

    // $ANTLR start "T__127"
    public final void mT__127() throws RecognitionException {
        try {
            int _type = T__127;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:117:8: ( 'union' )
            // InternalCoreDsl.g:117:10: 'union'
            {
            match("union"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__127"

    // $ANTLR start "T__128"
    public final void mT__128() throws RecognitionException {
        try {
            int _type = T__128;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:118:8: ( 's' )
            // InternalCoreDsl.g:118:10: 's'
            {
            match('s'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__128"

    // $ANTLR start "RULE_BVAL"
    public final void mRULE_BVAL() throws RecognitionException {
        try {
            int _type = RULE_BVAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:7015:11: ( 'b' ( '0' .. '9' )+ )
            // InternalCoreDsl.g:7015:13: 'b' ( '0' .. '9' )+
            {
            match('b'); 
            // InternalCoreDsl.g:7015:17: ( '0' .. '9' )+
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
            	    // InternalCoreDsl.g:7015:18: '0' .. '9'
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
            // InternalCoreDsl.g:7017:14: ( ( 'true' | 'false' ) )
            // InternalCoreDsl.g:7017:16: ( 'true' | 'false' )
            {
            // InternalCoreDsl.g:7017:16: ( 'true' | 'false' )
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
                    // InternalCoreDsl.g:7017:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7017:24: 'false'
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
            // InternalCoreDsl.g:7019:12: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? )
            // InternalCoreDsl.g:7019:14: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
            {
            // InternalCoreDsl.g:7019:14: ( '0' .. '9' )+
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
            	    // InternalCoreDsl.g:7019:15: '0' .. '9'
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
            // InternalCoreDsl.g:7019:30: ( '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalCoreDsl.g:7019:31: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalCoreDsl.g:7019:42: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='E'||LA7_0=='e') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalCoreDsl.g:7019:43: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalCoreDsl.g:7019:53: ( '+' | '-' )?
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

                    // InternalCoreDsl.g:7019:64: ( '0' .. '9' )+
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
                    	    // InternalCoreDsl.g:7019:65: '0' .. '9'
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
            // InternalCoreDsl.g:7021:14: ( ( RULE_DECIMALCONSTANT | RULE_BINARYCONSTANT | RULE_HEXADECIMALCONSTANT | RULE_OCTALCONSTANT | RULE_VLOGCONSTANT ) )
            // InternalCoreDsl.g:7021:16: ( RULE_DECIMALCONSTANT | RULE_BINARYCONSTANT | RULE_HEXADECIMALCONSTANT | RULE_OCTALCONSTANT | RULE_VLOGCONSTANT )
            {
            // InternalCoreDsl.g:7021:16: ( RULE_DECIMALCONSTANT | RULE_BINARYCONSTANT | RULE_HEXADECIMALCONSTANT | RULE_OCTALCONSTANT | RULE_VLOGCONSTANT )
            int alt8=5;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalCoreDsl.g:7021:17: RULE_DECIMALCONSTANT
                    {
                    mRULE_DECIMALCONSTANT(); 

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7021:38: RULE_BINARYCONSTANT
                    {
                    mRULE_BINARYCONSTANT(); 

                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:7021:58: RULE_HEXADECIMALCONSTANT
                    {
                    mRULE_HEXADECIMALCONSTANT(); 

                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:7021:83: RULE_OCTALCONSTANT
                    {
                    mRULE_OCTALCONSTANT(); 

                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:7021:102: RULE_VLOGCONSTANT
                    {
                    mRULE_VLOGCONSTANT(); 

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

    // $ANTLR start "RULE_BINARYCONSTANT"
    public final void mRULE_BINARYCONSTANT() throws RecognitionException {
        try {
            // InternalCoreDsl.g:7023:30: ( ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* )
            // InternalCoreDsl.g:7023:32: ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )*
            {
            // InternalCoreDsl.g:7023:32: ( '0b' | '0B' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='0') ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='b') ) {
                    alt9=1;
                }
                else if ( (LA9_1=='B') ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalCoreDsl.g:7023:33: '0b'
                    {
                    match("0b"); 


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7023:38: '0B'
                    {
                    match("0B"); 


                    }
                    break;

            }

            matchRange('0','1'); 
            // InternalCoreDsl.g:7023:53: ( ( '_' )? '0' .. '1' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='1')||LA11_0=='_') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalCoreDsl.g:7023:54: ( '_' )? '0' .. '1'
            	    {
            	    // InternalCoreDsl.g:7023:54: ( '_' )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0=='_') ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // InternalCoreDsl.g:7023:54: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    matchRange('0','1'); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINARYCONSTANT"

    // $ANTLR start "RULE_OCTALCONSTANT"
    public final void mRULE_OCTALCONSTANT() throws RecognitionException {
        try {
            // InternalCoreDsl.g:7025:29: ( '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            // InternalCoreDsl.g:7025:31: '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )*
            {
            match('0'); 
            // InternalCoreDsl.g:7025:35: ( '_' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='_') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalCoreDsl.g:7025:35: '_'
                    {
                    match('_'); 

                    }
                    break;

            }

            matchRange('0','7'); 
            // InternalCoreDsl.g:7025:49: ( ( '_' )? '0' .. '7' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='7')||LA14_0=='_') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalCoreDsl.g:7025:50: ( '_' )? '0' .. '7'
            	    {
            	    // InternalCoreDsl.g:7025:50: ( '_' )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0=='_') ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // InternalCoreDsl.g:7025:50: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_OCTALCONSTANT"

    // $ANTLR start "RULE_DECIMALCONSTANT"
    public final void mRULE_DECIMALCONSTANT() throws RecognitionException {
        try {
            // InternalCoreDsl.g:7027:31: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) )
            // InternalCoreDsl.g:7027:33: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
            {
            // InternalCoreDsl.g:7027:33: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='0') ) {
                alt17=1;
            }
            else if ( ((LA17_0>='1' && LA17_0<='9')) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalCoreDsl.g:7027:34: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7027:38: '1' .. '9' ( ( '_' )? '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // InternalCoreDsl.g:7027:47: ( ( '_' )? '0' .. '9' )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')||LA16_0=='_') ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalCoreDsl.g:7027:48: ( '_' )? '0' .. '9'
                    	    {
                    	    // InternalCoreDsl.g:7027:48: ( '_' )?
                    	    int alt15=2;
                    	    int LA15_0 = input.LA(1);

                    	    if ( (LA15_0=='_') ) {
                    	        alt15=1;
                    	    }
                    	    switch (alt15) {
                    	        case 1 :
                    	            // InternalCoreDsl.g:7027:48: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
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
    // $ANTLR end "RULE_DECIMALCONSTANT"

    // $ANTLR start "RULE_HEXADECIMALCONSTANT"
    public final void mRULE_HEXADECIMALCONSTANT() throws RecognitionException {
        try {
            // InternalCoreDsl.g:7029:35: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* )
            // InternalCoreDsl.g:7029:37: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
            {
            // InternalCoreDsl.g:7029:37: ( '0x' | '0X' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='0') ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1=='x') ) {
                    alt18=1;
                }
                else if ( (LA18_1=='X') ) {
                    alt18=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalCoreDsl.g:7029:38: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7029:43: '0X'
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

            // InternalCoreDsl.g:7029:78: ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='0' && LA20_0<='9')||(LA20_0>='A' && LA20_0<='F')||LA20_0=='_'||(LA20_0>='a' && LA20_0<='f')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalCoreDsl.g:7029:79: ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            	    {
            	    // InternalCoreDsl.g:7029:79: ( '_' )?
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0=='_') ) {
            	        alt19=1;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // InternalCoreDsl.g:7029:79: '_'
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
            	    break loop20;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEXADECIMALCONSTANT"

    // $ANTLR start "RULE_VLOGCONSTANT"
    public final void mRULE_VLOGCONSTANT() throws RecognitionException {
        try {
            // InternalCoreDsl.g:7031:28: ( ( '0' .. '9' )+ '\\'' ( 'b' ( '01' )+ | 'o' ( '0' .. '7' )+ | 'd' ( '0' .. '9' )+ | 'h' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ ) )
            // InternalCoreDsl.g:7031:30: ( '0' .. '9' )+ '\\'' ( 'b' ( '01' )+ | 'o' ( '0' .. '7' )+ | 'd' ( '0' .. '9' )+ | 'h' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            {
            // InternalCoreDsl.g:7031:30: ( '0' .. '9' )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='0' && LA21_0<='9')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalCoreDsl.g:7031:31: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            match('\''); 
            // InternalCoreDsl.g:7031:47: ( 'b' ( '01' )+ | 'o' ( '0' .. '7' )+ | 'd' ( '0' .. '9' )+ | 'h' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt26=1;
                }
                break;
            case 'o':
                {
                alt26=2;
                }
                break;
            case 'd':
                {
                alt26=3;
                }
                break;
            case 'h':
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalCoreDsl.g:7031:48: 'b' ( '01' )+
                    {
                    match('b'); 
                    // InternalCoreDsl.g:7031:52: ( '01' )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0=='0') ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalCoreDsl.g:7031:52: '01'
                    	    {
                    	    match("01"); 


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:7031:58: 'o' ( '0' .. '7' )+
                    {
                    match('o'); 
                    // InternalCoreDsl.g:7031:62: ( '0' .. '7' )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( ((LA23_0>='0' && LA23_0<='7')) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalCoreDsl.g:7031:63: '0' .. '7'
                    	    {
                    	    matchRange('0','7'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:7031:74: 'd' ( '0' .. '9' )+
                    {
                    match('d'); 
                    // InternalCoreDsl.g:7031:78: ( '0' .. '9' )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>='0' && LA24_0<='9')) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalCoreDsl.g:7031:79: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:7031:90: 'h' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    {
                    match('h'); 
                    // InternalCoreDsl.g:7031:94: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='F')||(LA25_0>='a' && LA25_0<='f')) ) {
                            alt25=1;
                        }


                        switch (alt25) {
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
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_VLOGCONSTANT"

    // $ANTLR start "RULE_CHARCONST"
    public final void mRULE_CHARCONST() throws RecognitionException {
        try {
            int _type = RULE_CHARCONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:7033:16: ( '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // InternalCoreDsl.g:7033:18: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // InternalCoreDsl.g:7033:23: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop27:
            do {
                int alt27=3;
                int LA27_0 = input.LA(1);

                if ( (LA27_0=='\\') ) {
                    alt27=1;
                }
                else if ( ((LA27_0>='\u0000' && LA27_0<='&')||(LA27_0>='(' && LA27_0<='[')||(LA27_0>=']' && LA27_0<='\uFFFF')) ) {
                    alt27=2;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalCoreDsl.g:7033:24: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalCoreDsl.g:7033:31: ~ ( ( '\\\\' | '\\'' ) )
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
            	    break loop27;
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
            // InternalCoreDsl.g:7035:10: ( 'this one has been deactivated' )
            // InternalCoreDsl.g:7035:12: 'this one has been deactivated'
            {
            match("this one has been deactivated"); 


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
            // InternalCoreDsl.g:7037:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalCoreDsl.g:7037:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalCoreDsl.g:7037:11: ( '^' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0=='^') ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalCoreDsl.g:7037:11: '^'
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

            // InternalCoreDsl.g:7037:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>='0' && LA29_0<='9')||(LA29_0>='A' && LA29_0<='Z')||LA29_0=='_'||(LA29_0>='a' && LA29_0<='z')) ) {
                    alt29=1;
                }


                switch (alt29) {
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
            	    break loop29;
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
            // InternalCoreDsl.g:7039:13: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalCoreDsl.g:7039:15: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // InternalCoreDsl.g:7039:19: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
            loop30:
            do {
                int alt30=3;
                int LA30_0 = input.LA(1);

                if ( (LA30_0=='\\') ) {
                    alt30=1;
                }
                else if ( ((LA30_0>='\u0000' && LA30_0<='!')||(LA30_0>='#' && LA30_0<='[')||(LA30_0>=']' && LA30_0<='\uFFFF')) ) {
                    alt30=2;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalCoreDsl.g:7039:20: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalCoreDsl.g:7039:27: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop30;
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
            // InternalCoreDsl.g:7041:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalCoreDsl.g:7041:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalCoreDsl.g:7041:24: ( options {greedy=false; } : . )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0=='*') ) {
                    int LA31_1 = input.LA(2);

                    if ( (LA31_1=='/') ) {
                        alt31=2;
                    }
                    else if ( ((LA31_1>='\u0000' && LA31_1<='.')||(LA31_1>='0' && LA31_1<='\uFFFF')) ) {
                        alt31=1;
                    }


                }
                else if ( ((LA31_0>='\u0000' && LA31_0<=')')||(LA31_0>='+' && LA31_0<='\uFFFF')) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalCoreDsl.g:7041:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop31;
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
            // InternalCoreDsl.g:7043:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalCoreDsl.g:7043:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalCoreDsl.g:7043:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>='\u0000' && LA32_0<='\t')||(LA32_0>='\u000B' && LA32_0<='\f')||(LA32_0>='\u000E' && LA32_0<='\uFFFF')) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalCoreDsl.g:7043:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop32;
                }
            } while (true);

            // InternalCoreDsl.g:7043:40: ( ( '\\r' )? '\\n' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0=='\n'||LA34_0=='\r') ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalCoreDsl.g:7043:41: ( '\\r' )? '\\n'
                    {
                    // InternalCoreDsl.g:7043:41: ( '\\r' )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0=='\r') ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalCoreDsl.g:7043:41: '\\r'
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
            // InternalCoreDsl.g:7045:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalCoreDsl.g:7045:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalCoreDsl.g:7045:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>='\t' && LA35_0<='\n')||LA35_0=='\r'||LA35_0==' ') ) {
                    alt35=1;
                }


                switch (alt35) {
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
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
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
            // InternalCoreDsl.g:7047:16: ( . )
            // InternalCoreDsl.g:7047:18: .
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
        // InternalCoreDsl.g:1:8: ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | RULE_BVAL | RULE_BOOLEAN | RULE_FLOAT | RULE_INTEGER | RULE_CHARCONST | RULE_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt36=120;
        alt36 = dfa36.predict(input);
        switch (alt36) {
            case 1 :
                // InternalCoreDsl.g:1:10: T__21
                {
                mT__21(); 

                }
                break;
            case 2 :
                // InternalCoreDsl.g:1:16: T__22
                {
                mT__22(); 

                }
                break;
            case 3 :
                // InternalCoreDsl.g:1:22: T__23
                {
                mT__23(); 

                }
                break;
            case 4 :
                // InternalCoreDsl.g:1:28: T__24
                {
                mT__24(); 

                }
                break;
            case 5 :
                // InternalCoreDsl.g:1:34: T__25
                {
                mT__25(); 

                }
                break;
            case 6 :
                // InternalCoreDsl.g:1:40: T__26
                {
                mT__26(); 

                }
                break;
            case 7 :
                // InternalCoreDsl.g:1:46: T__27
                {
                mT__27(); 

                }
                break;
            case 8 :
                // InternalCoreDsl.g:1:52: T__28
                {
                mT__28(); 

                }
                break;
            case 9 :
                // InternalCoreDsl.g:1:58: T__29
                {
                mT__29(); 

                }
                break;
            case 10 :
                // InternalCoreDsl.g:1:64: T__30
                {
                mT__30(); 

                }
                break;
            case 11 :
                // InternalCoreDsl.g:1:70: T__31
                {
                mT__31(); 

                }
                break;
            case 12 :
                // InternalCoreDsl.g:1:76: T__32
                {
                mT__32(); 

                }
                break;
            case 13 :
                // InternalCoreDsl.g:1:82: T__33
                {
                mT__33(); 

                }
                break;
            case 14 :
                // InternalCoreDsl.g:1:88: T__34
                {
                mT__34(); 

                }
                break;
            case 15 :
                // InternalCoreDsl.g:1:94: T__35
                {
                mT__35(); 

                }
                break;
            case 16 :
                // InternalCoreDsl.g:1:100: T__36
                {
                mT__36(); 

                }
                break;
            case 17 :
                // InternalCoreDsl.g:1:106: T__37
                {
                mT__37(); 

                }
                break;
            case 18 :
                // InternalCoreDsl.g:1:112: T__38
                {
                mT__38(); 

                }
                break;
            case 19 :
                // InternalCoreDsl.g:1:118: T__39
                {
                mT__39(); 

                }
                break;
            case 20 :
                // InternalCoreDsl.g:1:124: T__40
                {
                mT__40(); 

                }
                break;
            case 21 :
                // InternalCoreDsl.g:1:130: T__41
                {
                mT__41(); 

                }
                break;
            case 22 :
                // InternalCoreDsl.g:1:136: T__42
                {
                mT__42(); 

                }
                break;
            case 23 :
                // InternalCoreDsl.g:1:142: T__43
                {
                mT__43(); 

                }
                break;
            case 24 :
                // InternalCoreDsl.g:1:148: T__44
                {
                mT__44(); 

                }
                break;
            case 25 :
                // InternalCoreDsl.g:1:154: T__45
                {
                mT__45(); 

                }
                break;
            case 26 :
                // InternalCoreDsl.g:1:160: T__46
                {
                mT__46(); 

                }
                break;
            case 27 :
                // InternalCoreDsl.g:1:166: T__47
                {
                mT__47(); 

                }
                break;
            case 28 :
                // InternalCoreDsl.g:1:172: T__48
                {
                mT__48(); 

                }
                break;
            case 29 :
                // InternalCoreDsl.g:1:178: T__49
                {
                mT__49(); 

                }
                break;
            case 30 :
                // InternalCoreDsl.g:1:184: T__50
                {
                mT__50(); 

                }
                break;
            case 31 :
                // InternalCoreDsl.g:1:190: T__51
                {
                mT__51(); 

                }
                break;
            case 32 :
                // InternalCoreDsl.g:1:196: T__52
                {
                mT__52(); 

                }
                break;
            case 33 :
                // InternalCoreDsl.g:1:202: T__53
                {
                mT__53(); 

                }
                break;
            case 34 :
                // InternalCoreDsl.g:1:208: T__54
                {
                mT__54(); 

                }
                break;
            case 35 :
                // InternalCoreDsl.g:1:214: T__55
                {
                mT__55(); 

                }
                break;
            case 36 :
                // InternalCoreDsl.g:1:220: T__56
                {
                mT__56(); 

                }
                break;
            case 37 :
                // InternalCoreDsl.g:1:226: T__57
                {
                mT__57(); 

                }
                break;
            case 38 :
                // InternalCoreDsl.g:1:232: T__58
                {
                mT__58(); 

                }
                break;
            case 39 :
                // InternalCoreDsl.g:1:238: T__59
                {
                mT__59(); 

                }
                break;
            case 40 :
                // InternalCoreDsl.g:1:244: T__60
                {
                mT__60(); 

                }
                break;
            case 41 :
                // InternalCoreDsl.g:1:250: T__61
                {
                mT__61(); 

                }
                break;
            case 42 :
                // InternalCoreDsl.g:1:256: T__62
                {
                mT__62(); 

                }
                break;
            case 43 :
                // InternalCoreDsl.g:1:262: T__63
                {
                mT__63(); 

                }
                break;
            case 44 :
                // InternalCoreDsl.g:1:268: T__64
                {
                mT__64(); 

                }
                break;
            case 45 :
                // InternalCoreDsl.g:1:274: T__65
                {
                mT__65(); 

                }
                break;
            case 46 :
                // InternalCoreDsl.g:1:280: T__66
                {
                mT__66(); 

                }
                break;
            case 47 :
                // InternalCoreDsl.g:1:286: T__67
                {
                mT__67(); 

                }
                break;
            case 48 :
                // InternalCoreDsl.g:1:292: T__68
                {
                mT__68(); 

                }
                break;
            case 49 :
                // InternalCoreDsl.g:1:298: T__69
                {
                mT__69(); 

                }
                break;
            case 50 :
                // InternalCoreDsl.g:1:304: T__70
                {
                mT__70(); 

                }
                break;
            case 51 :
                // InternalCoreDsl.g:1:310: T__71
                {
                mT__71(); 

                }
                break;
            case 52 :
                // InternalCoreDsl.g:1:316: T__72
                {
                mT__72(); 

                }
                break;
            case 53 :
                // InternalCoreDsl.g:1:322: T__73
                {
                mT__73(); 

                }
                break;
            case 54 :
                // InternalCoreDsl.g:1:328: T__74
                {
                mT__74(); 

                }
                break;
            case 55 :
                // InternalCoreDsl.g:1:334: T__75
                {
                mT__75(); 

                }
                break;
            case 56 :
                // InternalCoreDsl.g:1:340: T__76
                {
                mT__76(); 

                }
                break;
            case 57 :
                // InternalCoreDsl.g:1:346: T__77
                {
                mT__77(); 

                }
                break;
            case 58 :
                // InternalCoreDsl.g:1:352: T__78
                {
                mT__78(); 

                }
                break;
            case 59 :
                // InternalCoreDsl.g:1:358: T__79
                {
                mT__79(); 

                }
                break;
            case 60 :
                // InternalCoreDsl.g:1:364: T__80
                {
                mT__80(); 

                }
                break;
            case 61 :
                // InternalCoreDsl.g:1:370: T__81
                {
                mT__81(); 

                }
                break;
            case 62 :
                // InternalCoreDsl.g:1:376: T__82
                {
                mT__82(); 

                }
                break;
            case 63 :
                // InternalCoreDsl.g:1:382: T__83
                {
                mT__83(); 

                }
                break;
            case 64 :
                // InternalCoreDsl.g:1:388: T__84
                {
                mT__84(); 

                }
                break;
            case 65 :
                // InternalCoreDsl.g:1:394: T__85
                {
                mT__85(); 

                }
                break;
            case 66 :
                // InternalCoreDsl.g:1:400: T__86
                {
                mT__86(); 

                }
                break;
            case 67 :
                // InternalCoreDsl.g:1:406: T__87
                {
                mT__87(); 

                }
                break;
            case 68 :
                // InternalCoreDsl.g:1:412: T__88
                {
                mT__88(); 

                }
                break;
            case 69 :
                // InternalCoreDsl.g:1:418: T__89
                {
                mT__89(); 

                }
                break;
            case 70 :
                // InternalCoreDsl.g:1:424: T__90
                {
                mT__90(); 

                }
                break;
            case 71 :
                // InternalCoreDsl.g:1:430: T__91
                {
                mT__91(); 

                }
                break;
            case 72 :
                // InternalCoreDsl.g:1:436: T__92
                {
                mT__92(); 

                }
                break;
            case 73 :
                // InternalCoreDsl.g:1:442: T__93
                {
                mT__93(); 

                }
                break;
            case 74 :
                // InternalCoreDsl.g:1:448: T__94
                {
                mT__94(); 

                }
                break;
            case 75 :
                // InternalCoreDsl.g:1:454: T__95
                {
                mT__95(); 

                }
                break;
            case 76 :
                // InternalCoreDsl.g:1:460: T__96
                {
                mT__96(); 

                }
                break;
            case 77 :
                // InternalCoreDsl.g:1:466: T__97
                {
                mT__97(); 

                }
                break;
            case 78 :
                // InternalCoreDsl.g:1:472: T__98
                {
                mT__98(); 

                }
                break;
            case 79 :
                // InternalCoreDsl.g:1:478: T__99
                {
                mT__99(); 

                }
                break;
            case 80 :
                // InternalCoreDsl.g:1:484: T__100
                {
                mT__100(); 

                }
                break;
            case 81 :
                // InternalCoreDsl.g:1:491: T__101
                {
                mT__101(); 

                }
                break;
            case 82 :
                // InternalCoreDsl.g:1:498: T__102
                {
                mT__102(); 

                }
                break;
            case 83 :
                // InternalCoreDsl.g:1:505: T__103
                {
                mT__103(); 

                }
                break;
            case 84 :
                // InternalCoreDsl.g:1:512: T__104
                {
                mT__104(); 

                }
                break;
            case 85 :
                // InternalCoreDsl.g:1:519: T__105
                {
                mT__105(); 

                }
                break;
            case 86 :
                // InternalCoreDsl.g:1:526: T__106
                {
                mT__106(); 

                }
                break;
            case 87 :
                // InternalCoreDsl.g:1:533: T__107
                {
                mT__107(); 

                }
                break;
            case 88 :
                // InternalCoreDsl.g:1:540: T__108
                {
                mT__108(); 

                }
                break;
            case 89 :
                // InternalCoreDsl.g:1:547: T__109
                {
                mT__109(); 

                }
                break;
            case 90 :
                // InternalCoreDsl.g:1:554: T__110
                {
                mT__110(); 

                }
                break;
            case 91 :
                // InternalCoreDsl.g:1:561: T__111
                {
                mT__111(); 

                }
                break;
            case 92 :
                // InternalCoreDsl.g:1:568: T__112
                {
                mT__112(); 

                }
                break;
            case 93 :
                // InternalCoreDsl.g:1:575: T__113
                {
                mT__113(); 

                }
                break;
            case 94 :
                // InternalCoreDsl.g:1:582: T__114
                {
                mT__114(); 

                }
                break;
            case 95 :
                // InternalCoreDsl.g:1:589: T__115
                {
                mT__115(); 

                }
                break;
            case 96 :
                // InternalCoreDsl.g:1:596: T__116
                {
                mT__116(); 

                }
                break;
            case 97 :
                // InternalCoreDsl.g:1:603: T__117
                {
                mT__117(); 

                }
                break;
            case 98 :
                // InternalCoreDsl.g:1:610: T__118
                {
                mT__118(); 

                }
                break;
            case 99 :
                // InternalCoreDsl.g:1:617: T__119
                {
                mT__119(); 

                }
                break;
            case 100 :
                // InternalCoreDsl.g:1:624: T__120
                {
                mT__120(); 

                }
                break;
            case 101 :
                // InternalCoreDsl.g:1:631: T__121
                {
                mT__121(); 

                }
                break;
            case 102 :
                // InternalCoreDsl.g:1:638: T__122
                {
                mT__122(); 

                }
                break;
            case 103 :
                // InternalCoreDsl.g:1:645: T__123
                {
                mT__123(); 

                }
                break;
            case 104 :
                // InternalCoreDsl.g:1:652: T__124
                {
                mT__124(); 

                }
                break;
            case 105 :
                // InternalCoreDsl.g:1:659: T__125
                {
                mT__125(); 

                }
                break;
            case 106 :
                // InternalCoreDsl.g:1:666: T__126
                {
                mT__126(); 

                }
                break;
            case 107 :
                // InternalCoreDsl.g:1:673: T__127
                {
                mT__127(); 

                }
                break;
            case 108 :
                // InternalCoreDsl.g:1:680: T__128
                {
                mT__128(); 

                }
                break;
            case 109 :
                // InternalCoreDsl.g:1:687: RULE_BVAL
                {
                mRULE_BVAL(); 

                }
                break;
            case 110 :
                // InternalCoreDsl.g:1:697: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 111 :
                // InternalCoreDsl.g:1:710: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 112 :
                // InternalCoreDsl.g:1:721: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 113 :
                // InternalCoreDsl.g:1:734: RULE_CHARCONST
                {
                mRULE_CHARCONST(); 

                }
                break;
            case 114 :
                // InternalCoreDsl.g:1:749: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 115 :
                // InternalCoreDsl.g:1:758: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 116 :
                // InternalCoreDsl.g:1:766: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 117 :
                // InternalCoreDsl.g:1:778: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 118 :
                // InternalCoreDsl.g:1:794: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 119 :
                // InternalCoreDsl.g:1:810: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 120 :
                // InternalCoreDsl.g:1:818: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA8_eotS =
        "\1\uffff\2\5\4\uffff\1\6\1\uffff\1\5\1\6";
    static final String DFA8_eofS =
        "\13\uffff";
    static final String DFA8_minS =
        "\1\60\2\47\4\uffff\1\47\1\uffff\2\47";
    static final String DFA8_maxS =
        "\1\71\1\170\1\71\4\uffff\1\71\1\uffff\2\71";
    static final String DFA8_acceptS =
        "\3\uffff\1\2\1\3\1\1\1\4\1\uffff\1\5\2\uffff";
    static final String DFA8_specialS =
        "\13\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\11\2",
            "\1\10\10\uffff\10\7\2\10\10\uffff\1\3\25\uffff\1\4\6\uffff\1\6\2\uffff\1\3\25\uffff\1\4",
            "\1\10\10\uffff\12\11",
            "",
            "",
            "",
            "",
            "\1\10\10\uffff\10\12\2\10",
            "",
            "\1\10\10\uffff\12\11",
            "\1\10\10\uffff\10\12\2\10"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "7021:16: ( RULE_DECIMALCONSTANT | RULE_BINARYCONSTANT | RULE_HEXADECIMALCONSTANT | RULE_OCTALCONSTANT | RULE_VLOGCONSTANT )";
        }
    }
    static final String DFA36_eotS =
        "\1\uffff\3\72\1\uffff\1\72\1\uffff\2\72\1\115\2\72\1\uffff\1\122\1\124\2\uffff\1\72\1\135\1\136\2\uffff\1\72\1\150\2\72\1\157\1\162\1\164\1\uffff\1\167\1\173\1\175\1\u0080\1\u0084\1\u0087\1\u0089\1\uffff\1\u008c\1\uffff\1\u0090\1\u0091\1\u0093\1\u0096\1\u0097\3\72\2\u009b\1\uffff\1\65\2\uffff\2\72\1\u00a5\1\72\1\uffff\4\72\1\uffff\3\72\1\uffff\11\72\1\uffff\2\72\7\uffff\3\72\1\u00bf\7\uffff\1\72\1\u00c3\4\72\1\uffff\4\72\1\u00cf\2\uffff\1\u00d1\35\uffff\1\u00d2\1\72\2\uffff\1\u00d5\1\uffff\1\u00d6\1\72\2\uffff\3\72\2\uffff\1\u009b\1\uffff\1\u009b\2\uffff\2\72\1\u00de\1\uffff\17\72\1\u00f0\11\72\1\uffff\3\72\1\uffff\12\72\5\uffff\2\72\2\uffff\4\72\1\u009b\2\72\1\uffff\4\72\1\u0114\1\u0115\2\72\1\u0118\1\u0119\1\u011a\6\72\1\uffff\2\72\1\u0123\1\72\1\u0125\3\72\1\u0129\13\72\1\u0135\3\72\1\u0139\1\72\1\u013b\3\72\1\u013f\4\72\2\uffff\1\u0145\1\72\3\uffff\2\72\1\u0149\3\72\1\u014d\1\u014e\1\uffff\1\u0135\1\uffff\2\72\1\u0151\1\uffff\6\72\1\u0158\2\72\1\u015b\1\72\2\uffff\1\72\1\u015e\1\uffff\1\72\1\uffff\1\72\1\u0161\1\72\1\uffff\2\72\1\u0165\2\72\1\uffff\3\72\1\uffff\1\72\1\u016c\1\72\2\uffff\2\72\1\uffff\1\72\1\u0171\1\u0172\1\u0173\1\u0174\1\u0175\1\uffff\1\u0176\1\u0177\1\uffff\2\72\1\uffff\2\72\1\uffff\2\72\1\u017e\1\uffff\6\72\1\uffff\3\72\1\u0188\7\uffff\1\u0189\2\72\1\u018c\2\72\1\uffff\1\u018f\1\72\1\u0191\4\72\1\u0196\1\u0197\2\uffff\1\u0198\1\u0199\1\uffff\2\72\1\uffff\1\u019c\1\uffff\2\72\1\u019f\1\u01a0\4\uffff\2\72\1\uffff\2\72\2\uffff\3\72\1\u01a8\1\u01a9\2\72\2\uffff\2\72\1\u01ae\1\u01af\2\uffff";
    static final String DFA36_eofS =
        "\u01b0\uffff";
    static final String DFA36_minS =
        "\1\0\1\146\1\156\1\154\1\uffff\1\141\1\uffff\1\143\1\145\1\60\1\157\1\162\1\uffff\1\133\1\135\2\uffff\1\60\1\75\1\0\2\uffff\1\145\1\60\2\150\1\74\2\75\1\uffff\1\75\1\52\1\75\1\53\1\55\1\46\1\75\1\uffff\1\75\1\uffff\5\60\1\157\1\117\1\157\2\56\1\uffff\1\0\2\uffff\1\160\1\163\1\60\1\137\1\uffff\1\163\1\164\1\143\1\163\1\uffff\1\156\1\163\1\141\1\uffff\1\144\1\147\1\143\1\147\1\156\1\162\1\157\1\141\1\154\1\uffff\1\162\1\157\7\uffff\1\150\1\145\1\157\1\60\7\uffff\1\146\1\60\1\151\1\147\1\157\1\141\1\uffff\1\151\1\160\1\165\1\151\1\75\2\uffff\1\75\35\uffff\1\60\1\151\2\uffff\1\60\1\uffff\1\60\1\156\2\uffff\1\154\1\116\1\137\2\uffff\1\56\1\47\1\56\2\uffff\1\157\1\164\1\60\1\uffff\1\160\1\164\1\145\1\157\1\155\1\145\1\144\1\145\2\162\1\163\1\165\1\151\1\165\1\143\1\60\1\141\1\163\1\143\1\163\1\145\1\166\2\141\1\154\1\uffff\1\141\1\145\1\142\1\uffff\1\164\1\145\1\156\1\162\1\164\1\165\1\154\2\145\1\163\5\uffff\1\151\1\157\2\uffff\1\147\1\141\1\105\1\143\1\56\2\162\1\uffff\1\143\1\162\1\156\1\144\2\60\1\164\1\151\3\60\1\145\1\137\1\155\1\163\1\162\1\164\1\uffff\1\164\1\150\1\60\1\145\1\60\1\151\1\166\1\153\1\60\1\165\1\164\1\154\1\143\1\157\1\145\1\164\1\151\1\143\1\145\1\144\1\60\1\40\1\147\1\156\1\60\1\164\1\60\1\157\1\164\1\165\1\60\1\165\1\144\1\156\1\151\2\uffff\1\60\1\156\3\uffff\1\163\1\144\1\60\1\164\1\156\1\151\2\60\1\uffff\1\60\1\uffff\1\144\1\151\1\60\1\uffff\1\154\2\145\1\150\1\146\1\144\1\60\1\143\1\164\1\60\1\145\2\uffff\1\156\1\60\1\uffff\1\151\1\uffff\1\156\1\60\1\143\1\uffff\1\143\1\163\1\60\2\156\1\uffff\1\165\1\163\1\151\1\uffff\1\145\1\60\1\157\2\uffff\1\145\1\157\1\uffff\1\164\5\60\1\uffff\2\60\1\uffff\1\146\1\145\1\uffff\1\154\1\164\1\uffff\2\164\1\60\1\uffff\1\147\1\164\1\145\1\137\1\163\1\162\1\uffff\1\156\1\163\1\162\1\60\7\uffff\1\60\1\144\1\145\1\60\2\151\1\uffff\1\60\1\163\1\60\1\163\1\141\2\163\2\60\2\uffff\2\60\1\uffff\2\157\1\uffff\1\60\1\uffff\1\160\1\163\2\60\4\uffff\2\156\1\uffff\1\141\1\163\2\uffff\1\163\1\123\1\143\2\60\2\145\2\uffff\1\164\1\163\2\60\2\uffff";
    static final String DFA36_maxS =
        "\1\uffff\1\163\1\156\1\170\1\uffff\1\157\1\uffff\1\162\1\145\1\172\1\157\1\162\1\uffff\1\133\1\135\2\uffff\1\162\1\174\1\uffff\2\uffff\1\157\1\172\1\150\1\171\1\75\1\76\1\75\1\uffff\4\75\1\76\1\75\1\172\1\uffff\1\75\1\uffff\5\172\1\157\1\117\1\157\2\71\1\uffff\1\uffff\2\uffff\1\160\1\164\1\172\1\137\1\uffff\1\163\1\164\1\165\1\163\1\uffff\1\156\1\163\1\141\1\uffff\1\144\1\147\1\143\1\164\1\156\1\162\1\165\1\141\1\154\1\uffff\1\162\1\157\7\uffff\1\150\1\145\1\157\1\172\7\uffff\1\154\1\172\1\151\1\172\1\157\1\162\1\uffff\1\151\1\160\1\165\1\151\1\75\2\uffff\1\75\35\uffff\1\172\1\163\2\uffff\1\172\1\uffff\1\172\1\156\2\uffff\1\154\1\116\1\137\2\uffff\3\71\2\uffff\1\157\1\164\1\172\1\uffff\1\160\1\164\1\145\1\157\1\155\1\145\1\164\1\145\2\162\1\163\1\165\1\151\1\165\1\143\1\172\1\141\1\163\1\143\1\163\1\145\1\166\2\141\1\154\1\uffff\1\141\1\145\1\142\1\uffff\1\164\1\145\1\156\1\162\1\164\1\165\1\154\2\145\1\163\5\uffff\1\151\1\157\2\uffff\1\147\1\141\1\105\1\143\1\71\2\162\1\uffff\1\143\2\162\1\144\2\172\1\164\1\151\3\172\1\145\1\137\1\155\1\163\1\162\1\164\1\uffff\1\164\1\150\1\172\1\145\1\172\1\151\1\166\1\153\1\172\1\165\1\164\1\154\1\143\1\157\1\145\1\164\1\151\1\143\1\145\1\144\1\172\1\40\1\147\1\156\1\172\1\164\1\172\1\157\1\164\1\165\1\172\1\165\1\144\1\156\1\151\2\uffff\1\172\1\156\3\uffff\1\163\1\144\1\172\1\164\1\156\1\151\2\172\1\uffff\1\172\1\uffff\1\144\1\151\1\172\1\uffff\1\154\2\145\1\150\1\146\1\144\1\172\1\143\1\164\1\172\1\145\2\uffff\1\156\1\172\1\uffff\1\151\1\uffff\1\156\1\172\1\143\1\uffff\1\143\1\163\1\172\2\156\1\uffff\1\165\1\163\1\151\1\uffff\1\145\1\172\1\157\2\uffff\1\145\1\157\1\uffff\1\164\5\172\1\uffff\2\172\1\uffff\1\146\1\145\1\uffff\1\154\1\164\1\uffff\2\164\1\172\1\uffff\1\147\1\164\1\145\1\137\1\163\1\162\1\uffff\1\156\1\163\1\162\1\172\7\uffff\1\172\1\144\1\145\1\172\2\151\1\uffff\1\172\1\163\1\172\1\163\1\141\2\163\2\172\2\uffff\2\172\1\uffff\2\157\1\uffff\1\172\1\uffff\1\160\1\163\2\172\4\uffff\2\156\1\uffff\1\141\1\163\2\uffff\1\163\1\123\1\143\2\172\2\145\2\uffff\1\164\1\163\2\172\2\uffff";
    static final String DFA36_acceptS =
        "\4\uffff\1\4\1\uffff\1\6\5\uffff\1\15\2\uffff\1\21\1\22\3\uffff\1\32\1\33\7\uffff\1\54\7\uffff\1\67\1\uffff\1\112\12\uffff\1\163\1\uffff\1\167\1\170\4\uffff\1\163\4\uffff\1\4\3\uffff\1\6\11\uffff\1\124\2\uffff\1\15\1\16\1\27\1\17\1\30\1\21\1\22\4\uffff\1\66\1\70\1\25\1\26\1\161\1\32\1\33\6\uffff\1\154\5\uffff\1\76\1\50\1\uffff\1\77\1\51\1\74\1\53\1\54\1\55\1\104\1\56\1\165\1\166\1\105\1\57\1\106\1\60\1\107\1\102\1\61\1\110\1\114\1\103\1\64\1\71\1\73\1\65\1\72\1\67\1\75\1\113\1\112\2\uffff\1\116\1\117\1\uffff\1\120\2\uffff\1\121\1\125\3\uffff\1\160\1\157\3\uffff\1\164\1\167\3\uffff\1\36\31\uffff\1\155\3\uffff\1\42\12\uffff\1\62\1\100\1\63\1\101\1\115\2\uffff\1\123\1\122\7\uffff\1\131\21\uffff\1\43\43\uffff\1\52\1\37\2\uffff\1\150\1\34\1\127\10\uffff\1\137\1\uffff\1\13\3\uffff\1\126\13\uffff\1\156\1\162\2\uffff\1\132\1\uffff\1\144\3\uffff\1\145\5\uffff\1\141\3\uffff\1\140\3\uffff\1\135\1\151\2\uffff\1\45\6\uffff\1\130\2\uffff\1\41\2\uffff\1\153\2\uffff\1\1\3\uffff\1\31\6\uffff\1\46\4\uffff\1\146\1\136\1\40\1\111\1\133\1\143\1\152\6\uffff\1\3\11\uffff\1\35\1\47\2\uffff\1\147\2\uffff\1\20\1\uffff\1\44\4\uffff\1\14\1\24\1\134\1\142\2\uffff\1\5\2\uffff\1\10\1\11\7\uffff\1\23\1\12\4\uffff\1\2\1\7";
    static final String DFA36_specialS =
        "\1\0\22\uffff\1\1\37\uffff\1\2\u017c\uffff}>";
    static final String[] DFA36_transitionS = {
            "\11\65\2\64\2\65\1\64\22\65\1\64\1\46\1\63\2\65\1\40\1\43\1\23\1\24\1\25\1\36\1\41\1\14\1\42\1\35\1\37\1\60\11\61\1\17\1\20\1\32\1\34\1\33\1\45\1\65\2\62\1\12\2\62\1\54\2\62\1\2\2\62\1\52\1\62\1\56\6\62\1\51\5\62\1\15\1\65\1\16\1\44\1\62\1\65\1\7\1\21\1\5\1\26\1\3\1\11\2\62\1\1\2\62\1\53\1\62\1\57\1\62\1\13\1\62\1\10\1\27\1\31\1\50\1\55\1\30\3\62\1\4\1\22\1\6\1\47\uff81\65",
            "\1\70\6\uffff\1\66\1\67\4\uffff\1\71",
            "\1\73",
            "\1\76\1\uffff\1\75\11\uffff\1\74",
            "",
            "\1\101\6\uffff\1\102\6\uffff\1\100",
            "",
            "\1\106\1\104\15\uffff\1\105",
            "\1\107",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\114\12\72\1\112\2\72\1\111\2\72\1\113\2\72\1\110\5\72",
            "\1\116",
            "\1\117",
            "",
            "\1\121",
            "\1\123",
            "",
            "",
            "\12\132\53\uffff\1\127\11\uffff\1\131\2\uffff\1\130",
            "\1\133\76\uffff\1\134",
            "\0\137",
            "",
            "",
            "\1\142\11\uffff\1\143",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\7\72\1\146\1\145\12\72\1\147\2\72\1\144\3\72",
            "\1\151",
            "\1\154\11\uffff\1\153\6\uffff\1\152",
            "\1\155\1\156",
            "\1\161\1\160",
            "\1\163",
            "",
            "\1\166",
            "\1\171\4\uffff\1\172\15\uffff\1\170",
            "\1\174",
            "\1\177\21\uffff\1\176",
            "\1\u0082\17\uffff\1\u0081\1\u0083",
            "\1\u0086\26\uffff\1\u0085",
            "\1\u0088\3\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\u008b",
            "",
            "\10\72\1\u008e\1\72\7\uffff\32\72\4\uffff\1\72\1\uffff\15\72\1\u008f\14\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\13\72\1\u0092\16\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\13\72\1\u0094\2\72\1\u0095\13\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009c\1\uffff\10\u009d\2\u009e",
            "\1\u009c\1\uffff\12\u009f",
            "",
            "\0\u00a0",
            "",
            "",
            "\1\u00a2",
            "\1\u00a3\1\u00a4",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u00a6",
            "",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9\21\uffff\1\u00aa",
            "\1\u00ab",
            "",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2\14\uffff\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6\5\uffff\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "",
            "\1\u00ba",
            "\1\u00bb",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\12\132\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00c0\5\uffff\1\u00c1",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\24\72\1\u00c2\5\72",
            "\1\u00c4",
            "\1\u00c6\22\uffff\1\u00c5",
            "\1\u00c7",
            "\1\u00c8\20\uffff\1\u00c9",
            "",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "",
            "",
            "\1\u00d0",
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
            "",
            "",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u00d4\11\uffff\1\u00d3",
            "",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u00d7",
            "",
            "",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "",
            "",
            "\1\u009c\1\uffff\10\u00db\2\u009e",
            "\1\u009b\6\uffff\1\u009c\1\uffff\12\u009e",
            "\1\u009c\1\uffff\12\u009f",
            "",
            "",
            "\1\u00dc",
            "\1\u00dd",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e7\16\uffff\1\u00e5\1\u00e6",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "",
            "",
            "",
            "",
            "",
            "\1\u0107",
            "\1\u0108",
            "",
            "",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u009c\1\uffff\10\u00db\2\u009e",
            "\1\u010d",
            "\1\u010e",
            "",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111\3\uffff\1\u0112",
            "\1\u0113",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0116",
            "\1\u0117",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "",
            "\1\u0121",
            "\1\u0122",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0124",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u013a",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u0144\31\72",
            "\1\u0146",
            "",
            "",
            "",
            "\1\u0147",
            "\1\u0148",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\u014f",
            "\1\u0150",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0159",
            "\1\u015a",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u015c",
            "",
            "",
            "\1\u015d",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\u015f",
            "",
            "\1\u0160",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0162",
            "",
            "\1\u0163",
            "\1\u0164",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0166",
            "\1\u0167",
            "",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "",
            "\1\u016b",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u016d",
            "",
            "",
            "\1\u016e",
            "\1\u016f",
            "",
            "\1\u0170",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\u0178",
            "\1\u0179",
            "",
            "\1\u017a",
            "\1\u017b",
            "",
            "\1\u017c",
            "\1\u017d",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\u017f",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "",
            "\1\u0185",
            "\1\u0186",
            "\1\u0187",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u018a",
            "\1\u018b",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u018d",
            "\1\u018e",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0190",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u0192",
            "\1\u0193",
            "\1\u0194",
            "\1\u0195",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\u019a",
            "\1\u019b",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\u019d",
            "\1\u019e",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "",
            "",
            "",
            "\1\u01a1",
            "\1\u01a2",
            "",
            "\1\u01a3",
            "\1\u01a4",
            "",
            "",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\u01aa",
            "\1\u01ab",
            "",
            "",
            "\1\u01ac",
            "\1\u01ad",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | RULE_BVAL | RULE_BOOLEAN | RULE_FLOAT | RULE_INTEGER | RULE_CHARCONST | RULE_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_0 = input.LA(1);

                        s = -1;
                        if ( (LA36_0=='i') ) {s = 1;}

                        else if ( (LA36_0=='I') ) {s = 2;}

                        else if ( (LA36_0=='e') ) {s = 3;}

                        else if ( (LA36_0=='{') ) {s = 4;}

                        else if ( (LA36_0=='c') ) {s = 5;}

                        else if ( (LA36_0=='}') ) {s = 6;}

                        else if ( (LA36_0=='a') ) {s = 7;}

                        else if ( (LA36_0=='r') ) {s = 8;}

                        else if ( (LA36_0=='f') ) {s = 9;}

                        else if ( (LA36_0=='C') ) {s = 10;}

                        else if ( (LA36_0=='p') ) {s = 11;}

                        else if ( (LA36_0==',') ) {s = 12;}

                        else if ( (LA36_0=='[') ) {s = 13;}

                        else if ( (LA36_0==']') ) {s = 14;}

                        else if ( (LA36_0==':') ) {s = 15;}

                        else if ( (LA36_0==';') ) {s = 16;}

                        else if ( (LA36_0=='b') ) {s = 17;}

                        else if ( (LA36_0=='|') ) {s = 18;}

                        else if ( (LA36_0=='\'') ) {s = 19;}

                        else if ( (LA36_0=='(') ) {s = 20;}

                        else if ( (LA36_0==')') ) {s = 21;}

                        else if ( (LA36_0=='d') ) {s = 22;}

                        else if ( (LA36_0=='s') ) {s = 23;}

                        else if ( (LA36_0=='w') ) {s = 24;}

                        else if ( (LA36_0=='t') ) {s = 25;}

                        else if ( (LA36_0=='<') ) {s = 26;}

                        else if ( (LA36_0=='>') ) {s = 27;}

                        else if ( (LA36_0=='=') ) {s = 28;}

                        else if ( (LA36_0=='.') ) {s = 29;}

                        else if ( (LA36_0=='*') ) {s = 30;}

                        else if ( (LA36_0=='/') ) {s = 31;}

                        else if ( (LA36_0=='%') ) {s = 32;}

                        else if ( (LA36_0=='+') ) {s = 33;}

                        else if ( (LA36_0=='-') ) {s = 34;}

                        else if ( (LA36_0=='&') ) {s = 35;}

                        else if ( (LA36_0=='^') ) {s = 36;}

                        else if ( (LA36_0=='?') ) {s = 37;}

                        else if ( (LA36_0=='!') ) {s = 38;}

                        else if ( (LA36_0=='~') ) {s = 39;}

                        else if ( (LA36_0=='u') ) {s = 40;}

                        else if ( (LA36_0=='U') ) {s = 41;}

                        else if ( (LA36_0=='L') ) {s = 42;}

                        else if ( (LA36_0=='l') ) {s = 43;}

                        else if ( (LA36_0=='F') ) {s = 44;}

                        else if ( (LA36_0=='v') ) {s = 45;}

                        else if ( (LA36_0=='N') ) {s = 46;}

                        else if ( (LA36_0=='n') ) {s = 47;}

                        else if ( (LA36_0=='0') ) {s = 48;}

                        else if ( ((LA36_0>='1' && LA36_0<='9')) ) {s = 49;}

                        else if ( ((LA36_0>='A' && LA36_0<='B')||(LA36_0>='D' && LA36_0<='E')||(LA36_0>='G' && LA36_0<='H')||(LA36_0>='J' && LA36_0<='K')||LA36_0=='M'||(LA36_0>='O' && LA36_0<='T')||(LA36_0>='V' && LA36_0<='Z')||LA36_0=='_'||(LA36_0>='g' && LA36_0<='h')||(LA36_0>='j' && LA36_0<='k')||LA36_0=='m'||LA36_0=='o'||LA36_0=='q'||(LA36_0>='x' && LA36_0<='z')) ) {s = 50;}

                        else if ( (LA36_0=='\"') ) {s = 51;}

                        else if ( ((LA36_0>='\t' && LA36_0<='\n')||LA36_0=='\r'||LA36_0==' ') ) {s = 52;}

                        else if ( ((LA36_0>='\u0000' && LA36_0<='\b')||(LA36_0>='\u000B' && LA36_0<='\f')||(LA36_0>='\u000E' && LA36_0<='\u001F')||(LA36_0>='#' && LA36_0<='$')||LA36_0=='@'||LA36_0=='\\'||LA36_0=='`'||(LA36_0>='\u007F' && LA36_0<='\uFFFF')) ) {s = 53;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_19 = input.LA(1);

                        s = -1;
                        if ( ((LA36_19>='\u0000' && LA36_19<='\uFFFF')) ) {s = 95;}

                        else s = 94;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA36_51 = input.LA(1);

                        s = -1;
                        if ( ((LA36_51>='\u0000' && LA36_51<='\uFFFF')) ) {s = 160;}

                        else s = 53;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}