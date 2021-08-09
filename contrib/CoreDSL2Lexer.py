# A CoreDSL 2 lexer for Pygments
#
# example (run from repository root):
#   pygmentize -l contrib/CoreDSL2Lexer.py -x com.minres.coredsl.tests/inputs/fir.core_desc
#
# style recommendation: tango

from pygments.lexer import inherit, bygroups
from pygments.lexers.c_cpp import CLexer
from pygments.token import *


class CustomLexer(CLexer):
    name = 'CoreDSL'
    aliases = ['coredsl']
    filenames = ['*.core_desc']

    ident = CLexer._ident

    section_names = ['architectural_state', 'functions', 'instructions']

    tokens = {
        'statements': [
            (r'import', Comment.Preproc),
            (r'(InstructionSet|CoreDef)(\s+)', bygroups(Keyword, Text), 'classname'),
            (r'(extends|provides)(\s+)', bygroups(Keyword, Text), 'classname'),
            (r'(instructions|architectural_state|functions)', Keyword),

            (r'(int|long|short|char|unsigned|signed)<[^>]+>', Keyword.Type),
            (r'(float|double)<\d+,\d+,\d+,\d+>', Keyword.Type),

            (r'spawn', Keyword),
            (r'(::?)', Operator),
            (r'0?b[0|1]+s?', Number.Bin),
            (r"\d+'s?b[01]+", Number.Bin),
            (r"\d+'s?o[0-7]+", Number.Oct),
            (r"\d+'s?d[0-9]+", Number.Integer),
            (r"\d+'s?h[0-9a-fA-F]+", Number.Hex),
            (r'\[\[' + ident + r'\]\]', Name.Decorator),

            inherit
        ],
        'classname': [
            (r'(' + ident + r')(\s*)(,)(\s*)', bygroups(Name.Class, Text, Punctuation, Text),),
            inherit
        ]
    }
