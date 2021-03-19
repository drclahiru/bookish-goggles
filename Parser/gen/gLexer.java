// Generated from C:/Users/Jitka/IdeaProjects/untitled\g.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OR=1, AND=2, EQ=3, NEQ=4, GT=5, LT=6, GTEQ=7, LTEQ=8, PLUS=9, MINUS=10, 
		MULT=11, DIV=12, MOD=13, OPERATOR=14, ASSIGN=15, OPAR=16, CPAR=17, OBRACE=18, 
		CBRACE=19, TRUE=20, FALSE=21, NULL=22, IF=23, ELSE=24, PAR=25, COMMA=26, 
		ARROW=27, LET=28, BASIC_TYPE=29, RANGE_NAME=30, ID=31, CELL_ID=32, BOOL=33, 
		CHARACTER=34, STRING=35, NUMBER=36, RANGE=37, VALUE_TYPE=38, NEWLINE=39, 
		WS=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "MINUS", 
			"MULT", "DIV", "MOD", "OPERATOR", "ASSIGN", "OPAR", "CPAR", "OBRACE", 
			"CBRACE", "TRUE", "FALSE", "NULL", "IF", "ELSE", "PAR", "COMMA", "ARROW", 
			"LET", "BASIC_TYPE", "RANGE_NAME", "ID", "CELL_ID", "BOOL", "CHARACTER", 
			"STRING", "NUMBER", "RANGE", "VALUE_TYPE", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", null, "'='", "'('", "')'", "'{'", "'}'", 
			"'true'", "'false'", "'null'", "'if'", "'else'", "'\"'", "','", "'->'", 
			"'let'", null, "'Range'", null, null, null, null, null, null, null, null, 
			"'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "MINUS", 
			"MULT", "DIV", "MOD", "OPERATOR", "ASSIGN", "OPAR", "CPAR", "OBRACE", 
			"CBRACE", "TRUE", "FALSE", "NULL", "IF", "ELSE", "PAR", "COMMA", "ARROW", 
			"LET", "BASIC_TYPE", "RANGE_NAME", "ID", "CELL_ID", "BOOL", "CHARACTER", 
			"STRING", "NUMBER", "RANGE", "VALUE_TYPE", "NEWLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public gLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "g.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0110\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0080\n\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\5\36\u00bf\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \6 \u00c8\n"+
		" \r \16 \u00c9\3 \7 \u00cd\n \f \16 \u00d0\13 \3!\6!\u00d3\n!\r!\16!\u00d4"+
		"\3!\3!\7!\u00d9\n!\f!\16!\u00dc\13!\3\"\3\"\5\"\u00e0\n\"\3#\3#\3$\3$"+
		"\7$\u00e6\n$\f$\16$\u00e9\13$\3$\3$\3%\6%\u00ee\n%\r%\16%\u00ef\3%\6%"+
		"\u00f3\n%\r%\16%\u00f4\3%\3%\6%\u00f9\n%\r%\16%\u00fa\5%\u00fd\n%\3&\3"+
		"&\3&\3&\3\'\3\'\3\'\5\'\u0106\n\'\3(\3(\3)\6)\u010b\n)\r)\16)\u010c\3"+
		")\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*\3\2\t\4\2aac|\5\2\62;aac|\3\2C\\\3"+
		"\2\63;\3\2\62;\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u0129\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5V\3\2\2\2\7Y\3"+
		"\2\2\2\t\\\3\2\2\2\13_\3\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21f\3\2\2\2\23i"+
		"\3\2\2\2\25k\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2\35\177\3\2\2"+
		"\2\37\u0081\3\2\2\2!\u0083\3\2\2\2#\u0085\3\2\2\2%\u0087\3\2\2\2\'\u0089"+
		"\3\2\2\2)\u008b\3\2\2\2+\u0090\3\2\2\2-\u0096\3\2\2\2/\u009b\3\2\2\2\61"+
		"\u009e\3\2\2\2\63\u00a3\3\2\2\2\65\u00a5\3\2\2\2\67\u00a7\3\2\2\29\u00aa"+
		"\3\2\2\2;\u00be\3\2\2\2=\u00c0\3\2\2\2?\u00c7\3\2\2\2A\u00d2\3\2\2\2C"+
		"\u00df\3\2\2\2E\u00e1\3\2\2\2G\u00e3\3\2\2\2I\u00fc\3\2\2\2K\u00fe\3\2"+
		"\2\2M\u0105\3\2\2\2O\u0107\3\2\2\2Q\u010a\3\2\2\2ST\7~\2\2TU\7~\2\2U\4"+
		"\3\2\2\2VW\7(\2\2WX\7(\2\2X\6\3\2\2\2YZ\7?\2\2Z[\7?\2\2[\b\3\2\2\2\\]"+
		"\7#\2\2]^\7?\2\2^\n\3\2\2\2_`\7@\2\2`\f\3\2\2\2ab\7>\2\2b\16\3\2\2\2c"+
		"d\7@\2\2de\7?\2\2e\20\3\2\2\2fg\7>\2\2gh\7?\2\2h\22\3\2\2\2ij\7-\2\2j"+
		"\24\3\2\2\2kl\7/\2\2l\26\3\2\2\2mn\7,\2\2n\30\3\2\2\2op\7\61\2\2p\32\3"+
		"\2\2\2qr\7\'\2\2r\34\3\2\2\2s\u0080\5\23\n\2t\u0080\5\25\13\2u\u0080\5"+
		"\27\f\2v\u0080\5\31\r\2w\u0080\5\33\16\2x\u0080\5\5\3\2y\u0080\5\3\2\2"+
		"z\u0080\5\7\4\2{\u0080\5\r\7\2|\u0080\5\21\t\2}\u0080\5\17\b\2~\u0080"+
		"\5\13\6\2\177s\3\2\2\2\177t\3\2\2\2\177u\3\2\2\2\177v\3\2\2\2\177w\3\2"+
		"\2\2\177x\3\2\2\2\177y\3\2\2\2\177z\3\2\2\2\177{\3\2\2\2\177|\3\2\2\2"+
		"\177}\3\2\2\2\177~\3\2\2\2\u0080\36\3\2\2\2\u0081\u0082\7?\2\2\u0082 "+
		"\3\2\2\2\u0083\u0084\7*\2\2\u0084\"\3\2\2\2\u0085\u0086\7+\2\2\u0086$"+
		"\3\2\2\2\u0087\u0088\7}\2\2\u0088&\3\2\2\2\u0089\u008a\7\177\2\2\u008a"+
		"(\3\2\2\2\u008b\u008c\7v\2\2\u008c\u008d\7t\2\2\u008d\u008e\7w\2\2\u008e"+
		"\u008f\7g\2\2\u008f*\3\2\2\2\u0090\u0091\7h\2\2\u0091\u0092\7c\2\2\u0092"+
		"\u0093\7n\2\2\u0093\u0094\7u\2\2\u0094\u0095\7g\2\2\u0095,\3\2\2\2\u0096"+
		"\u0097\7p\2\2\u0097\u0098\7w\2\2\u0098\u0099\7n\2\2\u0099\u009a\7n\2\2"+
		"\u009a.\3\2\2\2\u009b\u009c\7k\2\2\u009c\u009d\7h\2\2\u009d\60\3\2\2\2"+
		"\u009e\u009f\7g\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2"+
		"\7g\2\2\u00a2\62\3\2\2\2\u00a3\u00a4\7$\2\2\u00a4\64\3\2\2\2\u00a5\u00a6"+
		"\7.\2\2\u00a6\66\3\2\2\2\u00a7\u00a8\7/\2\2\u00a8\u00a9\7@\2\2\u00a98"+
		"\3\2\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7v\2\2\u00ad"+
		":\3\2\2\2\u00ae\u00af\7U\2\2\u00af\u00b0\7v\2\2\u00b0\u00b1\7t\2\2\u00b1"+
		"\u00b2\7k\2\2\u00b2\u00b3\7p\2\2\u00b3\u00bf\7i\2\2\u00b4\u00b5\7D\2\2"+
		"\u00b5\u00b6\7q\2\2\u00b6\u00b7\7q\2\2\u00b7\u00bf\7n\2\2\u00b8\u00b9"+
		"\7P\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bb\7o\2\2\u00bb\u00bc\7d\2\2\u00bc"+
		"\u00bd\7g\2\2\u00bd\u00bf\7t\2\2\u00be\u00ae\3\2\2\2\u00be\u00b4\3\2\2"+
		"\2\u00be\u00b8\3\2\2\2\u00bf<\3\2\2\2\u00c0\u00c1\7T\2\2\u00c1\u00c2\7"+
		"c\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7i\2\2\u00c4\u00c5\7g\2\2\u00c5>"+
		"\3\2\2\2\u00c6\u00c8\t\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00ce\3\2\2\2\u00cb\u00cd\t\3"+
		"\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf@\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d3\t\4\2\2"+
		"\u00d2\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00da\t\5\2\2\u00d7\u00d9\t\6\2\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00dbB\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e0\5)\25\2\u00de\u00e0"+
		"\5+\26\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0D\3\2\2\2\u00e1"+
		"\u00e2\t\7\2\2\u00e2F\3\2\2\2\u00e3\u00e7\5\63\32\2\u00e4\u00e6\5E#\2"+
		"\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8"+
		"\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\5\63\32\2"+
		"\u00ebH\3\2\2\2\u00ec\u00ee\t\6\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00ef\3"+
		"\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00fd\3\2\2\2\u00f1"+
		"\u00f3\t\6\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\7\60\2\2\u00f7"+
		"\u00f9\t\6\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2"+
		"\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00ed\3\2\2\2\u00fc"+
		"\u00f2\3\2\2\2\u00fdJ\3\2\2\2\u00fe\u00ff\5A!\2\u00ff\u0100\7<\2\2\u0100"+
		"\u0101\5A!\2\u0101L\3\2\2\2\u0102\u0106\5I%\2\u0103\u0106\5C\"\2\u0104"+
		"\u0106\5G$\2\u0105\u0102\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0104\3\2\2"+
		"\2\u0106N\3\2\2\2\u0107\u0108\7\f\2\2\u0108P\3\2\2\2\u0109\u010b\t\b\2"+
		"\2\u010a\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\b)\2\2\u010fR\3\2\2\2\21\2\177"+
		"\u00be\u00c9\u00ce\u00d4\u00da\u00df\u00e7\u00ef\u00f4\u00fa\u00fc\u0105"+
		"\u010c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}