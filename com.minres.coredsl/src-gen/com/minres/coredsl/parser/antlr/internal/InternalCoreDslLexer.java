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

    public InternalCoreDslLexer() {;} 
    public InternalCoreDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCoreDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalCoreDsl.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:12:7: ( 'InsructionSet' )
            // InternalCoreDsl.g:12:9: 'InsructionSet'
            {
            match("InsructionSet"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:16:7: ( ',' )
            // InternalCoreDsl.g:16:9: ','
            {
            match(','); 

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
            // InternalCoreDsl.g:17:7: ( '}' )
            // InternalCoreDsl.g:17:9: '}'
            {
            match('}'); 

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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:19:7: ( 'registers' )
            // InternalCoreDsl.g:19:9: 'registers'
            {
            match("registers"); 


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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:23:7: ( 'template' )
            // InternalCoreDsl.g:23:9: 'template'
            {
            match("template"); 


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
            // InternalCoreDsl.g:24:7: ( ':' )
            // InternalCoreDsl.g:24:9: ':'
            {
            match(':'); 

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
            // InternalCoreDsl.g:25:7: ( ';' )
            // InternalCoreDsl.g:25:9: ';'
            {
            match(';'); 

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
            // InternalCoreDsl.g:26:7: ( '[' )
            // InternalCoreDsl.g:26:9: '['
            {
            match('['); 

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
            // InternalCoreDsl.g:27:7: ( ']' )
            // InternalCoreDsl.g:27:9: ']'
            {
            match(']'); 

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
            // InternalCoreDsl.g:28:7: ( '(' )
            // InternalCoreDsl.g:28:9: '('
            {
            match('('); 

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
            // InternalCoreDsl.g:29:7: ( ')' )
            // InternalCoreDsl.g:29:9: ')'
            {
            match(')'); 

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
            // InternalCoreDsl.g:30:7: ( 'encoding' )
            // InternalCoreDsl.g:30:9: 'encoding'
            {
            match("encoding"); 


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
            // InternalCoreDsl.g:31:7: ( 'args_disass' )
            // InternalCoreDsl.g:31:9: 'args_disass'
            {
            match("args_disass"); 


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
            // InternalCoreDsl.g:32:7: ( '|' )
            // InternalCoreDsl.g:32:9: '|'
            {
            match('|'); 

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
            // InternalCoreDsl.g:33:7: ( '\\'' )
            // InternalCoreDsl.g:33:9: '\\''
            {
            match('\''); 

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
            // InternalCoreDsl.g:34:7: ( '<=' )
            // InternalCoreDsl.g:34:9: '<='
            {
            match("<="); 


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
            // InternalCoreDsl.g:35:7: ( 'if' )
            // InternalCoreDsl.g:35:9: 'if'
            {
            match("if"); 


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
            // InternalCoreDsl.g:36:7: ( 'else' )
            // InternalCoreDsl.g:36:9: 'else'
            {
            match("else"); 


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
            // InternalCoreDsl.g:37:7: ( 'C++' )
            // InternalCoreDsl.g:37:9: 'C++'
            {
            match("C++"); 


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
            // InternalCoreDsl.g:38:7: ( ':=' )
            // InternalCoreDsl.g:38:9: ':='
            {
            match(":="); 


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
            // InternalCoreDsl.g:39:7: ( 'alias' )
            // InternalCoreDsl.g:39:9: 'alias'
            {
            match("alias"); 


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
            // InternalCoreDsl.g:40:7: ( 'is' )
            // InternalCoreDsl.g:40:9: 'is'
            {
            match("is"); 


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
            // InternalCoreDsl.g:41:7: ( 'val' )
            // InternalCoreDsl.g:41:9: 'val'
            {
            match("val"); 


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
            // InternalCoreDsl.g:42:7: ( '||' )
            // InternalCoreDsl.g:42:9: '||'
            {
            match("||"); 


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
            // InternalCoreDsl.g:43:7: ( '&&' )
            // InternalCoreDsl.g:43:9: '&&'
            {
            match("&&"); 


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
            // InternalCoreDsl.g:44:7: ( '^' )
            // InternalCoreDsl.g:44:9: '^'
            {
            match('^'); 

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
            // InternalCoreDsl.g:45:7: ( '&' )
            // InternalCoreDsl.g:45:9: '&'
            {
            match('&'); 

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
            // InternalCoreDsl.g:46:7: ( '==' )
            // InternalCoreDsl.g:46:9: '=='
            {
            match("=="); 


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
            // InternalCoreDsl.g:47:7: ( '!=' )
            // InternalCoreDsl.g:47:9: '!='
            {
            match("!="); 


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
            // InternalCoreDsl.g:48:7: ( '<' )
            // InternalCoreDsl.g:48:9: '<'
            {
            match('<'); 

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
            // InternalCoreDsl.g:49:7: ( '>' )
            // InternalCoreDsl.g:49:9: '>'
            {
            match('>'); 

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
            // InternalCoreDsl.g:50:7: ( '>=' )
            // InternalCoreDsl.g:50:9: '>='
            {
            match(">="); 


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
            // InternalCoreDsl.g:51:7: ( '<<' )
            // InternalCoreDsl.g:51:9: '<<'
            {
            match("<<"); 


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
            // InternalCoreDsl.g:52:7: ( '>>' )
            // InternalCoreDsl.g:52:9: '>>'
            {
            match(">>"); 


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
            // InternalCoreDsl.g:53:7: ( '+' )
            // InternalCoreDsl.g:53:9: '+'
            {
            match('+'); 

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
            // InternalCoreDsl.g:54:7: ( '-' )
            // InternalCoreDsl.g:54:9: '-'
            {
            match('-'); 

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
            // InternalCoreDsl.g:55:7: ( '*' )
            // InternalCoreDsl.g:55:9: '*'
            {
            match('*'); 

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
            // InternalCoreDsl.g:56:7: ( '/' )
            // InternalCoreDsl.g:56:9: '/'
            {
            match('/'); 

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
            // InternalCoreDsl.g:57:7: ( '%' )
            // InternalCoreDsl.g:57:9: '%'
            {
            match('%'); 

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
            // InternalCoreDsl.g:58:7: ( '~' )
            // InternalCoreDsl.g:58:9: '~'
            {
            match('~'); 

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
            // InternalCoreDsl.g:59:7: ( '!' )
            // InternalCoreDsl.g:59:9: '!'
            {
            match('!'); 

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
            // InternalCoreDsl.g:60:7: ( 'NONE' )
            // InternalCoreDsl.g:60:9: 'NONE'
            {
            match("NONE"); 


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
            // InternalCoreDsl.g:61:7: ( 'u' )
            // InternalCoreDsl.g:61:9: 'u'
            {
            match('u'); 

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
            // InternalCoreDsl.g:62:7: ( 's' )
            // InternalCoreDsl.g:62:9: 's'
            {
            match('s'); 

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
            // InternalCoreDsl.g:63:7: ( 'f' )
            // InternalCoreDsl.g:63:9: 'f'
            {
            match('f'); 

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
            // InternalCoreDsl.g:64:7: ( 'd' )
            // InternalCoreDsl.g:64:9: 'd'
            {
            match('d'); 

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
            // InternalCoreDsl.g:65:7: ( 'q' )
            // InternalCoreDsl.g:65:9: 'q'
            {
            match('q'); 

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
            // InternalCoreDsl.g:66:7: ( 'b' )
            // InternalCoreDsl.g:66:9: 'b'
            {
            match('b'); 

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
            // InternalCoreDsl.g:67:7: ( 'is_pc' )
            // InternalCoreDsl.g:67:9: 'is_pc'
            {
            match("is_pc"); 


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
            // InternalCoreDsl.g:68:7: ( 'delete' )
            // InternalCoreDsl.g:68:9: 'delete'
            {
            match("delete"); 


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
            // InternalCoreDsl.g:69:7: ( 'is_reg_with' )
            // InternalCoreDsl.g:69:9: 'is_reg_with'
            {
            match("is_reg_with"); 


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
            // InternalCoreDsl.g:70:7: ( 'is_addr_width' )
            // InternalCoreDsl.g:70:9: 'is_addr_width'
            {
            match("is_addr_width"); 


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
            // InternalCoreDsl.g:71:7: ( 'no_cont' )
            // InternalCoreDsl.g:71:9: 'no_cont'
            {
            match("no_cont"); 


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
            // InternalCoreDsl.g:72:7: ( 'cond' )
            // InternalCoreDsl.g:72:9: 'cond'
            {
            match("cond"); 


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
            // InternalCoreDsl.g:73:7: ( 'flush' )
            // InternalCoreDsl.g:73:9: 'flush'
            {
            match("flush"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "RULE_PROCEDURENAME"
    public final void mRULE_PROCEDURENAME() throws RecognitionException {
        try {
            int _type = RULE_PROCEDURENAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:4499:20: ( ( 'raise' | 'leave' | 'wait' | 'dispatch_' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )* ) )
            // InternalCoreDsl.g:4499:22: ( 'raise' | 'leave' | 'wait' | 'dispatch_' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )* )
            {
            // InternalCoreDsl.g:4499:22: ( 'raise' | 'leave' | 'wait' | 'dispatch_' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )* )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 'r':
                {
                alt2=1;
                }
                break;
            case 'l':
                {
                alt2=2;
                }
                break;
            case 'w':
                {
                alt2=3;
                }
                break;
            case 'd':
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalCoreDsl.g:4499:23: 'raise'
                    {
                    match("raise"); 


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4499:31: 'leave'
                    {
                    match("leave"); 


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:4499:39: 'wait'
                    {
                    match("wait"); 


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:4499:46: 'dispatch_' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )*
                    {
                    match("dispatch_"); 

                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalCoreDsl.g:4499:82: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0=='.'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalCoreDsl.g:
                    	    {
                    	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
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
    // $ANTLR end "RULE_PROCEDURENAME"

    // $ANTLR start "RULE_FUNCTIONNAME"
    public final void mRULE_FUNCTIONNAME() throws RecognitionException {
        try {
            int _type = RULE_FUNCTIONNAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:4501:19: ( ( 'sext' | 'zext' | 'choose' | 'shll' | 'shrl' | 'shra' | 'fdispatch_' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )* ) )
            // InternalCoreDsl.g:4501:21: ( 'sext' | 'zext' | 'choose' | 'shll' | 'shrl' | 'shra' | 'fdispatch_' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )* )
            {
            // InternalCoreDsl.g:4501:21: ( 'sext' | 'zext' | 'choose' | 'shll' | 'shrl' | 'shra' | 'fdispatch_' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )* )
            int alt4=7;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalCoreDsl.g:4501:22: 'sext'
                    {
                    match("sext"); 


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4501:29: 'zext'
                    {
                    match("zext"); 


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:4501:36: 'choose'
                    {
                    match("choose"); 


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:4501:45: 'shll'
                    {
                    match("shll"); 


                    }
                    break;
                case 5 :
                    // InternalCoreDsl.g:4501:52: 'shrl'
                    {
                    match("shrl"); 


                    }
                    break;
                case 6 :
                    // InternalCoreDsl.g:4501:59: 'shra'
                    {
                    match("shra"); 


                    }
                    break;
                case 7 :
                    // InternalCoreDsl.g:4501:66: 'fdispatch_' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )*
                    {
                    match("fdispatch_"); 

                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalCoreDsl.g:4501:103: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='.'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalCoreDsl.g:
                    	    {
                    	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
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
    // $ANTLR end "RULE_FUNCTIONNAME"

    // $ANTLR start "RULE_BVAL"
    public final void mRULE_BVAL() throws RecognitionException {
        try {
            int _type = RULE_BVAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:4503:11: ( 'b' ( '0' .. '9' )+ )
            // InternalCoreDsl.g:4503:13: 'b' ( '0' .. '9' )+
            {
            match('b'); 
            // InternalCoreDsl.g:4503:17: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCoreDsl.g:4503:18: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // InternalCoreDsl.g:4505:14: ( ( 'true' | 'false' ) )
            // InternalCoreDsl.g:4505:16: ( 'true' | 'false' )
            {
            // InternalCoreDsl.g:4505:16: ( 'true' | 'false' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='t') ) {
                alt6=1;
            }
            else if ( (LA6_0=='f') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalCoreDsl.g:4505:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4505:24: 'false'
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

    // $ANTLR start "RULE_NATURAL"
    public final void mRULE_NATURAL() throws RecognitionException {
        try {
            int _type = RULE_NATURAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:4507:14: ( ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* ) )
            // InternalCoreDsl.g:4507:16: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            {
            // InternalCoreDsl.g:4507:16: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            int alt19=4;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'B':
                case 'b':
                    {
                    alt19=2;
                    }
                    break;
                case 'X':
                case 'x':
                    {
                    alt19=3;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '_':
                    {
                    alt19=4;
                    }
                    break;
                default:
                    alt19=1;}

            }
            else if ( ((LA19_0>='1' && LA19_0<='9')) ) {
                alt19=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalCoreDsl.g:4507:17: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
                    {
                    // InternalCoreDsl.g:4507:17: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='0') ) {
                        alt9=1;
                    }
                    else if ( ((LA9_0>='1' && LA9_0<='9')) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalCoreDsl.g:4507:18: '0'
                            {
                            match('0'); 

                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:4507:22: '1' .. '9' ( ( '_' )? '0' .. '9' )*
                            {
                            matchRange('1','9'); 
                            // InternalCoreDsl.g:4507:31: ( ( '_' )? '0' .. '9' )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( ((LA8_0>='0' && LA8_0<='9')||LA8_0=='_') ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // InternalCoreDsl.g:4507:32: ( '_' )? '0' .. '9'
                            	    {
                            	    // InternalCoreDsl.g:4507:32: ( '_' )?
                            	    int alt7=2;
                            	    int LA7_0 = input.LA(1);

                            	    if ( (LA7_0=='_') ) {
                            	        alt7=1;
                            	    }
                            	    switch (alt7) {
                            	        case 1 :
                            	            // InternalCoreDsl.g:4507:32: '_'
                            	            {
                            	            match('_'); 

                            	            }
                            	            break;

                            	    }

                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalCoreDsl.g:4507:49: ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )*
                    {
                    // InternalCoreDsl.g:4507:49: ( '0b' | '0B' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='0') ) {
                        int LA10_1 = input.LA(2);

                        if ( (LA10_1=='b') ) {
                            alt10=1;
                        }
                        else if ( (LA10_1=='B') ) {
                            alt10=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalCoreDsl.g:4507:50: '0b'
                            {
                            match("0b"); 


                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:4507:55: '0B'
                            {
                            match("0B"); 


                            }
                            break;

                    }

                    matchRange('0','1'); 
                    // InternalCoreDsl.g:4507:70: ( ( '_' )? '0' .. '1' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='1')||LA12_0=='_') ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalCoreDsl.g:4507:71: ( '_' )? '0' .. '1'
                    	    {
                    	    // InternalCoreDsl.g:4507:71: ( '_' )?
                    	    int alt11=2;
                    	    int LA11_0 = input.LA(1);

                    	    if ( (LA11_0=='_') ) {
                    	        alt11=1;
                    	    }
                    	    switch (alt11) {
                    	        case 1 :
                    	            // InternalCoreDsl.g:4507:71: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','1'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // InternalCoreDsl.g:4507:87: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
                    {
                    // InternalCoreDsl.g:4507:87: ( '0x' | '0X' )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='0') ) {
                        int LA13_1 = input.LA(2);

                        if ( (LA13_1=='x') ) {
                            alt13=1;
                        }
                        else if ( (LA13_1=='X') ) {
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
                            // InternalCoreDsl.g:4507:88: '0x'
                            {
                            match("0x"); 


                            }
                            break;
                        case 2 :
                            // InternalCoreDsl.g:4507:93: '0X'
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

                    // InternalCoreDsl.g:4507:128: ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')||(LA15_0>='A' && LA15_0<='F')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='f')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalCoreDsl.g:4507:129: ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
                    	    {
                    	    // InternalCoreDsl.g:4507:129: ( '_' )?
                    	    int alt14=2;
                    	    int LA14_0 = input.LA(1);

                    	    if ( (LA14_0=='_') ) {
                    	        alt14=1;
                    	    }
                    	    switch (alt14) {
                    	        case 1 :
                    	            // InternalCoreDsl.g:4507:129: '_'
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
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;
                case 4 :
                    // InternalCoreDsl.g:4507:165: '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )*
                    {
                    match('0'); 
                    // InternalCoreDsl.g:4507:169: ( '_' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='_') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalCoreDsl.g:4507:169: '_'
                            {
                            match('_'); 

                            }
                            break;

                    }

                    matchRange('0','7'); 
                    // InternalCoreDsl.g:4507:183: ( ( '_' )? '0' .. '7' )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>='0' && LA18_0<='7')||LA18_0=='_') ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalCoreDsl.g:4507:184: ( '_' )? '0' .. '7'
                    	    {
                    	    // InternalCoreDsl.g:4507:184: ( '_' )?
                    	    int alt17=2;
                    	    int LA17_0 = input.LA(1);

                    	    if ( (LA17_0=='_') ) {
                    	        alt17=1;
                    	    }
                    	    switch (alt17) {
                    	        case 1 :
                    	            // InternalCoreDsl.g:4507:184: '_'
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
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NATURAL"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCoreDsl.g:4509:10: ( 'this one has been deactivated' )
            // InternalCoreDsl.g:4509:12: 'this one has been deactivated'
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
            // InternalCoreDsl.g:4511:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )* )
            // InternalCoreDsl.g:4511:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )*
            {
            // InternalCoreDsl.g:4511:11: ( '^' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='^') ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalCoreDsl.g:4511:11: '^'
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

            // InternalCoreDsl.g:4511:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='.'||(LA21_0>='0' && LA21_0<='9')||(LA21_0>='A' && LA21_0<='Z')||LA21_0=='_'||(LA21_0>='a' && LA21_0<='z')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalCoreDsl.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop21;
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
            // InternalCoreDsl.g:4513:13: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalCoreDsl.g:4513:15: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // InternalCoreDsl.g:4513:19: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='\\') ) {
                    alt22=1;
                }
                else if ( ((LA22_0>='\u0000' && LA22_0<='!')||(LA22_0>='#' && LA22_0<='[')||(LA22_0>=']' && LA22_0<='\uFFFF')) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalCoreDsl.g:4513:20: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalCoreDsl.g:4513:27: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop22;
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
            // InternalCoreDsl.g:4515:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalCoreDsl.g:4515:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalCoreDsl.g:4515:24: ( options {greedy=false; } : . )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0=='*') ) {
                    int LA23_1 = input.LA(2);

                    if ( (LA23_1=='/') ) {
                        alt23=2;
                    }
                    else if ( ((LA23_1>='\u0000' && LA23_1<='.')||(LA23_1>='0' && LA23_1<='\uFFFF')) ) {
                        alt23=1;
                    }


                }
                else if ( ((LA23_0>='\u0000' && LA23_0<=')')||(LA23_0>='+' && LA23_0<='\uFFFF')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalCoreDsl.g:4515:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop23;
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
            // InternalCoreDsl.g:4517:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalCoreDsl.g:4517:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalCoreDsl.g:4517:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='\u0000' && LA24_0<='\t')||(LA24_0>='\u000B' && LA24_0<='\f')||(LA24_0>='\u000E' && LA24_0<='\uFFFF')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalCoreDsl.g:4517:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop24;
                }
            } while (true);

            // InternalCoreDsl.g:4517:40: ( ( '\\r' )? '\\n' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='\n'||LA26_0=='\r') ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalCoreDsl.g:4517:41: ( '\\r' )? '\\n'
                    {
                    // InternalCoreDsl.g:4517:41: ( '\\r' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='\r') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalCoreDsl.g:4517:41: '\\r'
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
            // InternalCoreDsl.g:4519:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalCoreDsl.g:4519:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalCoreDsl.g:4519:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='\t' && LA27_0<='\n')||LA27_0=='\r'||LA27_0==' ') ) {
                    alt27=1;
                }


                switch (alt27) {
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
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
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
            // InternalCoreDsl.g:4521:16: ( . )
            // InternalCoreDsl.g:4521:18: .
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
        // InternalCoreDsl.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | RULE_PROCEDURENAME | RULE_FUNCTIONNAME | RULE_BVAL | RULE_BOOLEAN | RULE_NATURAL | RULE_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt28=75;
        alt28 = dfa28.predict(input);
        switch (alt28) {
            case 1 :
                // InternalCoreDsl.g:1:10: T__16
                {
                mT__16(); 

                }
                break;
            case 2 :
                // InternalCoreDsl.g:1:16: T__17
                {
                mT__17(); 

                }
                break;
            case 3 :
                // InternalCoreDsl.g:1:22: T__18
                {
                mT__18(); 

                }
                break;
            case 4 :
                // InternalCoreDsl.g:1:28: T__19
                {
                mT__19(); 

                }
                break;
            case 5 :
                // InternalCoreDsl.g:1:34: T__20
                {
                mT__20(); 

                }
                break;
            case 6 :
                // InternalCoreDsl.g:1:40: T__21
                {
                mT__21(); 

                }
                break;
            case 7 :
                // InternalCoreDsl.g:1:46: T__22
                {
                mT__22(); 

                }
                break;
            case 8 :
                // InternalCoreDsl.g:1:52: T__23
                {
                mT__23(); 

                }
                break;
            case 9 :
                // InternalCoreDsl.g:1:58: T__24
                {
                mT__24(); 

                }
                break;
            case 10 :
                // InternalCoreDsl.g:1:64: T__25
                {
                mT__25(); 

                }
                break;
            case 11 :
                // InternalCoreDsl.g:1:70: T__26
                {
                mT__26(); 

                }
                break;
            case 12 :
                // InternalCoreDsl.g:1:76: T__27
                {
                mT__27(); 

                }
                break;
            case 13 :
                // InternalCoreDsl.g:1:82: T__28
                {
                mT__28(); 

                }
                break;
            case 14 :
                // InternalCoreDsl.g:1:88: T__29
                {
                mT__29(); 

                }
                break;
            case 15 :
                // InternalCoreDsl.g:1:94: T__30
                {
                mT__30(); 

                }
                break;
            case 16 :
                // InternalCoreDsl.g:1:100: T__31
                {
                mT__31(); 

                }
                break;
            case 17 :
                // InternalCoreDsl.g:1:106: T__32
                {
                mT__32(); 

                }
                break;
            case 18 :
                // InternalCoreDsl.g:1:112: T__33
                {
                mT__33(); 

                }
                break;
            case 19 :
                // InternalCoreDsl.g:1:118: T__34
                {
                mT__34(); 

                }
                break;
            case 20 :
                // InternalCoreDsl.g:1:124: T__35
                {
                mT__35(); 

                }
                break;
            case 21 :
                // InternalCoreDsl.g:1:130: T__36
                {
                mT__36(); 

                }
                break;
            case 22 :
                // InternalCoreDsl.g:1:136: T__37
                {
                mT__37(); 

                }
                break;
            case 23 :
                // InternalCoreDsl.g:1:142: T__38
                {
                mT__38(); 

                }
                break;
            case 24 :
                // InternalCoreDsl.g:1:148: T__39
                {
                mT__39(); 

                }
                break;
            case 25 :
                // InternalCoreDsl.g:1:154: T__40
                {
                mT__40(); 

                }
                break;
            case 26 :
                // InternalCoreDsl.g:1:160: T__41
                {
                mT__41(); 

                }
                break;
            case 27 :
                // InternalCoreDsl.g:1:166: T__42
                {
                mT__42(); 

                }
                break;
            case 28 :
                // InternalCoreDsl.g:1:172: T__43
                {
                mT__43(); 

                }
                break;
            case 29 :
                // InternalCoreDsl.g:1:178: T__44
                {
                mT__44(); 

                }
                break;
            case 30 :
                // InternalCoreDsl.g:1:184: T__45
                {
                mT__45(); 

                }
                break;
            case 31 :
                // InternalCoreDsl.g:1:190: T__46
                {
                mT__46(); 

                }
                break;
            case 32 :
                // InternalCoreDsl.g:1:196: T__47
                {
                mT__47(); 

                }
                break;
            case 33 :
                // InternalCoreDsl.g:1:202: T__48
                {
                mT__48(); 

                }
                break;
            case 34 :
                // InternalCoreDsl.g:1:208: T__49
                {
                mT__49(); 

                }
                break;
            case 35 :
                // InternalCoreDsl.g:1:214: T__50
                {
                mT__50(); 

                }
                break;
            case 36 :
                // InternalCoreDsl.g:1:220: T__51
                {
                mT__51(); 

                }
                break;
            case 37 :
                // InternalCoreDsl.g:1:226: T__52
                {
                mT__52(); 

                }
                break;
            case 38 :
                // InternalCoreDsl.g:1:232: T__53
                {
                mT__53(); 

                }
                break;
            case 39 :
                // InternalCoreDsl.g:1:238: T__54
                {
                mT__54(); 

                }
                break;
            case 40 :
                // InternalCoreDsl.g:1:244: T__55
                {
                mT__55(); 

                }
                break;
            case 41 :
                // InternalCoreDsl.g:1:250: T__56
                {
                mT__56(); 

                }
                break;
            case 42 :
                // InternalCoreDsl.g:1:256: T__57
                {
                mT__57(); 

                }
                break;
            case 43 :
                // InternalCoreDsl.g:1:262: T__58
                {
                mT__58(); 

                }
                break;
            case 44 :
                // InternalCoreDsl.g:1:268: T__59
                {
                mT__59(); 

                }
                break;
            case 45 :
                // InternalCoreDsl.g:1:274: T__60
                {
                mT__60(); 

                }
                break;
            case 46 :
                // InternalCoreDsl.g:1:280: T__61
                {
                mT__61(); 

                }
                break;
            case 47 :
                // InternalCoreDsl.g:1:286: T__62
                {
                mT__62(); 

                }
                break;
            case 48 :
                // InternalCoreDsl.g:1:292: T__63
                {
                mT__63(); 

                }
                break;
            case 49 :
                // InternalCoreDsl.g:1:298: T__64
                {
                mT__64(); 

                }
                break;
            case 50 :
                // InternalCoreDsl.g:1:304: T__65
                {
                mT__65(); 

                }
                break;
            case 51 :
                // InternalCoreDsl.g:1:310: T__66
                {
                mT__66(); 

                }
                break;
            case 52 :
                // InternalCoreDsl.g:1:316: T__67
                {
                mT__67(); 

                }
                break;
            case 53 :
                // InternalCoreDsl.g:1:322: T__68
                {
                mT__68(); 

                }
                break;
            case 54 :
                // InternalCoreDsl.g:1:328: T__69
                {
                mT__69(); 

                }
                break;
            case 55 :
                // InternalCoreDsl.g:1:334: T__70
                {
                mT__70(); 

                }
                break;
            case 56 :
                // InternalCoreDsl.g:1:340: T__71
                {
                mT__71(); 

                }
                break;
            case 57 :
                // InternalCoreDsl.g:1:346: T__72
                {
                mT__72(); 

                }
                break;
            case 58 :
                // InternalCoreDsl.g:1:352: T__73
                {
                mT__73(); 

                }
                break;
            case 59 :
                // InternalCoreDsl.g:1:358: T__74
                {
                mT__74(); 

                }
                break;
            case 60 :
                // InternalCoreDsl.g:1:364: T__75
                {
                mT__75(); 

                }
                break;
            case 61 :
                // InternalCoreDsl.g:1:370: T__76
                {
                mT__76(); 

                }
                break;
            case 62 :
                // InternalCoreDsl.g:1:376: T__77
                {
                mT__77(); 

                }
                break;
            case 63 :
                // InternalCoreDsl.g:1:382: T__78
                {
                mT__78(); 

                }
                break;
            case 64 :
                // InternalCoreDsl.g:1:388: RULE_PROCEDURENAME
                {
                mRULE_PROCEDURENAME(); 

                }
                break;
            case 65 :
                // InternalCoreDsl.g:1:407: RULE_FUNCTIONNAME
                {
                mRULE_FUNCTIONNAME(); 

                }
                break;
            case 66 :
                // InternalCoreDsl.g:1:425: RULE_BVAL
                {
                mRULE_BVAL(); 

                }
                break;
            case 67 :
                // InternalCoreDsl.g:1:435: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 68 :
                // InternalCoreDsl.g:1:448: RULE_NATURAL
                {
                mRULE_NATURAL(); 

                }
                break;
            case 69 :
                // InternalCoreDsl.g:1:461: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 70 :
                // InternalCoreDsl.g:1:470: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 71 :
                // InternalCoreDsl.g:1:478: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 72 :
                // InternalCoreDsl.g:1:490: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 73 :
                // InternalCoreDsl.g:1:506: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 74 :
                // InternalCoreDsl.g:1:522: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 75 :
                // InternalCoreDsl.g:1:530: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA4_eotS =
        "\13\uffff";
    static final String DFA4_eofS =
        "\13\uffff";
    static final String DFA4_minS =
        "\1\143\1\145\4\uffff\1\154\1\uffff\1\141\2\uffff";
    static final String DFA4_maxS =
        "\1\172\1\150\4\uffff\1\162\1\uffff\1\154\2\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\2\1\3\1\7\1\1\1\uffff\1\4\1\uffff\1\5\1\6";
    static final String DFA4_specialS =
        "\13\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\3\2\uffff\1\4\14\uffff\1\1\6\uffff\1\2",
            "\1\5\2\uffff\1\6",
            "",
            "",
            "",
            "",
            "\1\7\5\uffff\1\10",
            "",
            "\1\12\12\uffff\1\11",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "4501:21: ( 'sext' | 'zext' | 'choose' | 'shll' | 'shrl' | 'shra' | 'fdispatch_' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )* )";
        }
    }
    static final String DFA28_eotS =
        "\1\uffff\3\67\1\uffff\1\67\2\uffff\5\67\1\115\5\uffff\1\124\1\uffff\1\130\1\67\1\133\1\134\1\62\1\137\1\142\3\uffff\1\150\2\uffff\1\67\1\154\1\157\1\163\1\166\1\167\1\171\4\67\3\uffff\1\62\2\uffff\2\67\1\u0083\1\u0085\1\uffff\4\67\1\uffff\2\67\2\uffff\6\67\1\uffff\4\67\15\uffff\1\67\21\uffff\1\67\1\uffff\2\67\1\uffff\3\67\1\uffff\2\67\2\uffff\1\u00a0\1\uffff\4\67\3\uffff\2\67\1\uffff\1\67\1\uffff\20\67\1\u00bb\11\67\1\uffff\14\67\1\u00d2\1\67\1\u00d4\6\67\1\u00db\2\67\1\u00de\1\67\1\uffff\1\u00e0\4\u00e1\7\67\1\u00e9\1\u00e1\2\67\1\u00ec\5\67\1\uffff\1\67\1\uffff\3\67\1\u00f6\1\67\1\u00e9\1\uffff\2\67\4\uffff\1\u00fa\1\67\1\u00de\3\67\1\u00e9\1\uffff\1\u00ff\1\67\1\uffff\6\67\1\u00e1\2\67\1\uffff\3\67\1\uffff\1\67\1\u010d\2\67\1\uffff\4\67\1\u0114\10\67\1\uffff\1\67\1\u011e\4\67\1\uffff\1\u0123\4\67\1\u0128\1\u0129\2\67\1\uffff\4\67\1\uffff\1\u0130\2\67\1\u0133\2\uffff\6\67\1\uffff\2\67\1\uffff\1\67\1\u00e9\1\67\1\u013f\3\67\1\u0143\1\u00e1\1\u00e9\1\u0145\1\uffff\3\67\1\uffff\1\u00e1\1\uffff\1\u0149\1\u014a\1\67\2\uffff\1\u014c\1\uffff";
    static final String DFA28_eofS =
        "\u014d\uffff";
    static final String DFA28_minS =
        "\1\0\1\146\1\156\1\154\1\uffff\1\150\2\uffff\1\144\1\141\1\53\1\162\1\145\1\75\5\uffff\1\174\1\uffff\1\74\1\141\1\46\1\101\3\75\3\uffff\1\52\2\uffff\1\117\6\56\1\157\1\145\1\141\1\145\3\uffff\1\0\2\uffff\1\160\1\163\2\56\1\uffff\1\163\1\164\1\143\1\163\1\uffff\1\156\1\157\2\uffff\1\144\1\147\1\151\1\147\1\151\1\162\1\uffff\1\157\1\155\1\165\1\151\15\uffff\1\154\21\uffff\1\116\1\uffff\1\170\1\154\1\uffff\1\165\1\151\1\154\1\uffff\1\154\1\163\2\uffff\1\56\1\uffff\1\137\1\141\1\151\1\170\3\uffff\1\157\1\164\1\uffff\1\141\1\uffff\1\162\1\145\1\157\1\145\1\144\1\157\1\162\1\163\1\141\1\151\1\163\1\145\1\166\1\160\1\145\1\163\1\56\1\105\1\164\1\154\1\141\3\163\1\145\1\160\1\uffff\1\143\1\166\2\164\2\162\1\143\1\145\1\144\1\165\1\156\1\144\1\56\1\164\1\56\1\163\1\145\1\137\2\163\1\145\1\56\1\151\1\154\1\56\1\40\1\uffff\5\56\1\150\1\160\1\145\1\164\1\141\1\157\1\145\2\56\1\164\1\165\1\56\1\147\1\144\1\143\1\144\1\151\1\uffff\1\141\1\uffff\1\145\1\163\1\144\1\56\1\164\1\56\1\uffff\1\144\1\141\4\uffff\1\56\1\141\1\56\1\145\1\164\1\156\1\56\1\uffff\1\56\1\143\1\uffff\1\137\1\162\1\164\1\163\2\156\1\56\1\163\1\151\1\uffff\2\145\1\164\1\uffff\1\164\1\56\1\143\1\164\1\uffff\1\164\1\167\1\137\1\151\1\56\1\147\1\164\1\137\1\163\1\162\1\163\1\145\1\143\1\uffff\1\150\1\56\2\151\1\167\1\157\1\uffff\1\56\2\163\1\141\1\163\2\56\1\150\1\137\1\uffff\1\157\1\164\1\151\1\156\1\uffff\1\56\1\160\1\163\1\56\2\uffff\1\137\1\101\1\156\1\150\1\144\1\123\1\uffff\1\141\1\163\1\uffff\1\101\1\56\1\163\1\56\1\164\1\145\1\143\4\56\1\uffff\1\150\1\164\1\145\1\uffff\1\56\1\uffff\2\56\1\163\2\uffff\1\56\1\uffff";
    static final String DFA28_maxS =
        "\1\uffff\1\163\1\156\1\170\1\uffff\1\157\2\uffff\1\162\1\145\1\157\2\162\1\75\5\uffff\1\174\1\uffff\1\75\1\141\1\46\1\172\2\75\1\76\3\uffff\1\57\2\uffff\1\117\6\172\1\157\1\145\1\141\1\145\3\uffff\1\uffff\2\uffff\1\160\1\163\2\172\1\uffff\1\163\1\164\1\143\1\163\1\uffff\1\156\1\157\2\uffff\1\144\1\147\1\151\1\147\1\151\1\162\1\uffff\1\157\1\155\1\165\1\151\15\uffff\1\154\21\uffff\1\116\1\uffff\1\170\1\162\1\uffff\1\165\1\151\1\154\1\uffff\1\154\1\163\2\uffff\1\172\1\uffff\1\137\1\141\1\151\1\170\3\uffff\1\157\1\164\1\uffff\1\162\1\uffff\1\162\1\145\1\157\1\145\1\163\1\157\1\162\1\163\1\141\1\151\1\163\1\145\1\166\1\160\1\145\1\163\1\172\1\105\1\164\2\154\3\163\1\145\1\160\1\uffff\1\143\1\166\2\164\2\162\1\143\1\145\1\144\1\165\1\156\1\144\1\172\1\164\1\172\1\163\1\145\1\137\2\163\1\145\1\172\1\151\1\154\1\172\1\40\1\uffff\5\172\1\150\1\160\1\145\1\164\1\141\1\157\1\145\2\172\1\164\1\165\1\172\1\147\1\144\1\143\1\144\1\151\1\uffff\1\141\1\uffff\1\145\1\163\1\144\1\172\1\164\1\172\1\uffff\1\144\1\141\4\uffff\1\172\1\141\1\172\1\145\1\164\1\156\1\172\1\uffff\1\172\1\143\1\uffff\1\137\1\162\1\164\1\163\2\156\1\172\1\163\1\151\1\uffff\2\145\1\164\1\uffff\1\164\1\172\1\143\1\164\1\uffff\1\164\1\167\1\137\1\151\1\172\1\147\1\164\1\137\1\163\1\162\1\163\1\145\1\143\1\uffff\1\150\1\172\2\151\1\167\1\157\1\uffff\1\172\2\163\1\141\1\163\2\172\1\150\1\137\1\uffff\1\157\1\164\1\151\1\156\1\uffff\1\172\1\160\1\163\1\172\2\uffff\1\137\1\172\1\156\1\150\1\144\1\123\1\uffff\1\141\1\163\1\uffff\2\172\1\163\1\172\1\164\1\145\1\143\4\172\1\uffff\1\150\1\164\1\145\1\uffff\1\172\1\uffff\2\172\1\163\2\uffff\1\172\1\uffff";
    static final String DFA28_acceptS =
        "\4\uffff\1\4\1\uffff\1\6\1\7\6\uffff\1\17\1\20\1\21\1\22\1\23\1\uffff\1\27\7\uffff\1\53\1\54\1\55\1\uffff\1\57\1\60\13\uffff\2\104\1\106\1\uffff\1\112\1\113\4\uffff\1\106\4\uffff\1\4\2\uffff\1\6\1\7\6\uffff\1\33\4\uffff\1\34\1\16\1\17\1\20\1\21\1\22\1\23\1\40\1\26\1\27\1\30\1\51\1\46\1\uffff\1\41\1\43\1\42\1\44\1\45\1\61\1\50\1\52\1\47\1\53\1\54\1\55\1\110\1\111\1\56\1\57\1\60\1\uffff\1\63\2\uffff\1\64\3\uffff\1\65\2\uffff\1\66\1\67\1\uffff\1\70\4\uffff\1\104\1\107\1\112\2\uffff\1\31\1\uffff\1\36\32\uffff\1\102\32\uffff\1\37\26\uffff\1\32\1\uffff\1\76\6\uffff\1\13\2\uffff\1\103\1\105\1\62\1\101\7\uffff\1\100\2\uffff\1\71\11\uffff\1\35\3\uffff\1\77\4\uffff\1\1\15\uffff\1\72\6\uffff\1\3\11\uffff\1\75\4\uffff\1\24\4\uffff\1\14\1\15\6\uffff\1\5\2\uffff\1\11\13\uffff\1\73\3\uffff\1\25\1\uffff\1\12\3\uffff\1\74\1\2\1\uffff\1\10";
    static final String DFA28_specialS =
        "\1\0\57\uffff\1\1\u011c\uffff}>";
    static final String[] DFA28_transitionS = {
            "\11\62\2\61\2\62\1\61\22\62\1\61\1\32\1\60\2\62\1\40\1\27\1\24\1\21\1\22\1\36\1\34\1\6\1\35\1\62\1\37\1\55\11\56\1\15\1\16\1\25\1\31\1\33\2\62\2\57\1\12\5\57\1\2\4\57\1\42\14\57\1\17\1\62\1\20\1\30\1\57\1\62\1\10\1\50\1\5\1\46\1\3\1\45\2\57\1\1\2\57\1\52\1\57\1\51\1\57\1\13\1\47\1\11\1\44\1\14\1\43\1\26\1\53\2\57\1\54\1\4\1\23\1\7\1\41\uff81\62",
            "\1\65\6\uffff\1\63\1\64\4\uffff\1\66",
            "\1\70",
            "\1\73\1\uffff\1\72\11\uffff\1\71",
            "",
            "\1\76\6\uffff\1\75",
            "",
            "",
            "\1\101\7\uffff\1\103\5\uffff\1\102",
            "\1\105\3\uffff\1\104",
            "\1\107\103\uffff\1\106",
            "\1\110",
            "\1\111\2\uffff\1\113\11\uffff\1\112",
            "\1\114",
            "",
            "",
            "",
            "",
            "",
            "\1\123",
            "",
            "\1\127\1\126",
            "\1\131",
            "\1\132",
            "\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\135",
            "\1\136",
            "\1\140\1\141",
            "",
            "",
            "",
            "\1\146\4\uffff\1\147",
            "",
            "",
            "\1\153",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\155\2\67\1\156\22\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\1\162\2\67\1\161\7\67\1\160\16\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\164\3\67\1\165\21\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\1\uffff\12\170\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "",
            "",
            "\0\177",
            "",
            "",
            "\1\u0081",
            "\1\u0082",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\u0084\1\uffff\32\67",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "",
            "\1\u008a",
            "\1\u008b",
            "",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
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
            "\1\u0096",
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
            "\1\u0097",
            "",
            "\1\u0098",
            "\1\u0099\5\uffff\1\u009a",
            "",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "",
            "\1\u009e",
            "\1\u009f",
            "",
            "",
            "\1\67\1\uffff\12\170\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "",
            "",
            "",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\1\u00a9\16\uffff\1\u00a7\1\uffff\1\u00a8",
            "",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00af\16\uffff\1\u00ae",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00c0\12\uffff\1\u00bf",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00d3",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00dc",
            "\1\u00dd",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00df",
            "",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00ea",
            "\1\u00eb",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "",
            "\1\u00f2",
            "",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00f7",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u00f8",
            "\1\u00f9",
            "",
            "",
            "",
            "",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00fb",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0100",
            "",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0107",
            "\1\u0108",
            "",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "",
            "\1\u010c",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u010e",
            "\1\u010f",
            "",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "",
            "\1\u011d",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u012a",
            "\1\u012b",
            "",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0131",
            "\1\u0132",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\u0134",
            "\32\u0135\4\uffff\1\u0135\1\uffff\32\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "",
            "\1\u013a",
            "\1\u013b",
            "",
            "\32\u013c\4\uffff\1\u013c\1\uffff\32\u013c",
            "\1\u013d\1\uffff\12\u013d\7\uffff\32\u013d\4\uffff\1\u013d\1\uffff\32\u013d",
            "\1\u013e",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0144\1\uffff\12\u0144\7\uffff\32\u0144\4\uffff\1\u0144\1\uffff\32\u0144",
            "\1\u013d\1\uffff\12\u013d\7\uffff\32\u013d\4\uffff\1\u013d\1\uffff\32\u013d",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "",
            "\1\u0144\1\uffff\12\u0144\7\uffff\32\u0144\4\uffff\1\u0144\1\uffff\32\u0144",
            "",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u014b",
            "",
            "",
            "\1\67\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | RULE_PROCEDURENAME | RULE_FUNCTIONNAME | RULE_BVAL | RULE_BOOLEAN | RULE_NATURAL | RULE_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_0 = input.LA(1);

                        s = -1;
                        if ( (LA28_0=='i') ) {s = 1;}

                        else if ( (LA28_0=='I') ) {s = 2;}

                        else if ( (LA28_0=='e') ) {s = 3;}

                        else if ( (LA28_0=='{') ) {s = 4;}

                        else if ( (LA28_0=='c') ) {s = 5;}

                        else if ( (LA28_0==',') ) {s = 6;}

                        else if ( (LA28_0=='}') ) {s = 7;}

                        else if ( (LA28_0=='a') ) {s = 8;}

                        else if ( (LA28_0=='r') ) {s = 9;}

                        else if ( (LA28_0=='C') ) {s = 10;}

                        else if ( (LA28_0=='p') ) {s = 11;}

                        else if ( (LA28_0=='t') ) {s = 12;}

                        else if ( (LA28_0==':') ) {s = 13;}

                        else if ( (LA28_0==';') ) {s = 14;}

                        else if ( (LA28_0=='[') ) {s = 15;}

                        else if ( (LA28_0==']') ) {s = 16;}

                        else if ( (LA28_0=='(') ) {s = 17;}

                        else if ( (LA28_0==')') ) {s = 18;}

                        else if ( (LA28_0=='|') ) {s = 19;}

                        else if ( (LA28_0=='\'') ) {s = 20;}

                        else if ( (LA28_0=='<') ) {s = 21;}

                        else if ( (LA28_0=='v') ) {s = 22;}

                        else if ( (LA28_0=='&') ) {s = 23;}

                        else if ( (LA28_0=='^') ) {s = 24;}

                        else if ( (LA28_0=='=') ) {s = 25;}

                        else if ( (LA28_0=='!') ) {s = 26;}

                        else if ( (LA28_0=='>') ) {s = 27;}

                        else if ( (LA28_0=='+') ) {s = 28;}

                        else if ( (LA28_0=='-') ) {s = 29;}

                        else if ( (LA28_0=='*') ) {s = 30;}

                        else if ( (LA28_0=='/') ) {s = 31;}

                        else if ( (LA28_0=='%') ) {s = 32;}

                        else if ( (LA28_0=='~') ) {s = 33;}

                        else if ( (LA28_0=='N') ) {s = 34;}

                        else if ( (LA28_0=='u') ) {s = 35;}

                        else if ( (LA28_0=='s') ) {s = 36;}

                        else if ( (LA28_0=='f') ) {s = 37;}

                        else if ( (LA28_0=='d') ) {s = 38;}

                        else if ( (LA28_0=='q') ) {s = 39;}

                        else if ( (LA28_0=='b') ) {s = 40;}

                        else if ( (LA28_0=='n') ) {s = 41;}

                        else if ( (LA28_0=='l') ) {s = 42;}

                        else if ( (LA28_0=='w') ) {s = 43;}

                        else if ( (LA28_0=='z') ) {s = 44;}

                        else if ( (LA28_0=='0') ) {s = 45;}

                        else if ( ((LA28_0>='1' && LA28_0<='9')) ) {s = 46;}

                        else if ( ((LA28_0>='A' && LA28_0<='B')||(LA28_0>='D' && LA28_0<='H')||(LA28_0>='J' && LA28_0<='M')||(LA28_0>='O' && LA28_0<='Z')||LA28_0=='_'||(LA28_0>='g' && LA28_0<='h')||(LA28_0>='j' && LA28_0<='k')||LA28_0=='m'||LA28_0=='o'||(LA28_0>='x' && LA28_0<='y')) ) {s = 47;}

                        else if ( (LA28_0=='\"') ) {s = 48;}

                        else if ( ((LA28_0>='\t' && LA28_0<='\n')||LA28_0=='\r'||LA28_0==' ') ) {s = 49;}

                        else if ( ((LA28_0>='\u0000' && LA28_0<='\b')||(LA28_0>='\u000B' && LA28_0<='\f')||(LA28_0>='\u000E' && LA28_0<='\u001F')||(LA28_0>='#' && LA28_0<='$')||LA28_0=='.'||(LA28_0>='?' && LA28_0<='@')||LA28_0=='\\'||LA28_0=='`'||(LA28_0>='\u007F' && LA28_0<='\uFFFF')) ) {s = 50;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_48 = input.LA(1);

                        s = -1;
                        if ( ((LA28_48>='\u0000' && LA28_48<='\uFFFF')) ) {s = 127;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}