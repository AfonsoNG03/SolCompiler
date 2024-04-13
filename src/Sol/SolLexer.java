// Generated from C:/Users/fpgue/Desktop/Trabalhos Uni/Compiladores2324/UNI/SolCompiler/Sol.g4 by ANTLR 4.13.1
package Sol;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MULT=1, ADD=2, SUB=3, DIV=4, MOD=5, TRUE=6, FALSE=7, LPAREN=8, RPAREN=9, 
		NOT=10, AND=11, OR=12, EQ=13, NEQ=14, LT=15, LE=16, GT=17, GE=18, INT=19, 
		DOUBLE=20, STRING=21, NEWLINE=22, PRINT=23, SEMICOLON=24, WS=25, SL_COMMENT=26, 
		ML_COMMENT=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"MULT", "ADD", "SUB", "DIV", "MOD", "TRUE", "FALSE", "LPAREN", "RPAREN", 
			"NOT", "AND", "OR", "EQ", "NEQ", "LT", "LE", "GT", "GE", "INT", "DOUBLE", 
			"STRING", "NEWLINE", "PRINT", "SEMICOLON", "WS", "SL_COMMENT", "ML_COMMENT", 
			"DIGIT", "ESC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'+'", "'-'", "'/'", "'%'", "'true'", "'false'", "'('", 
			"')'", "'not'", "'and'", "'or'", "'=='", "'!='", "'<'", "'<='", "'>'", 
			"'>='", null, null, null, null, "'print'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MULT", "ADD", "SUB", "DIV", "MOD", "TRUE", "FALSE", "LPAREN", 
			"RPAREN", "NOT", "AND", "OR", "EQ", "NEQ", "LT", "LE", "GT", "GE", "INT", 
			"DOUBLE", "STRING", "NEWLINE", "PRINT", "SEMICOLON", "WS", "SL_COMMENT", 
			"ML_COMMENT"
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


	public SolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Sol.g4"; }

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
		"\u0004\u0000\u001b\u00ca\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012q\b\u0012\u000b"+
		"\u0012\f\u0012r\u0001\u0013\u0004\u0013v\b\u0013\u000b\u0013\f\u0013w"+
		"\u0001\u0013\u0001\u0013\u0005\u0013|\b\u0013\n\u0013\f\u0013\u007f\t"+
		"\u0013\u0001\u0013\u0001\u0013\u0004\u0013\u0083\b\u0013\u000b\u0013\f"+
		"\u0013\u0084\u0003\u0013\u0087\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u008c\b\u0014\n\u0014\f\u0014\u008f\t\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0003\u0015\u0094\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0004\u0018\u00a1\b\u0018\u000b\u0018\f"+
		"\u0018\u00a2\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u00ab\b\u0019\n\u0019\f\u0019\u00ae\t\u0019\u0001"+
		"\u0019\u0003\u0019\u00b1\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u00b9\b\u001a\n\u001a\f\u001a"+
		"\u00bc\t\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u00c9\b\u001c\u0003\u008d\u00ac\u00ba\u0000\u001d\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u00193\u001a5\u001b7\u00009\u0000\u0001\u0000\u0003\u0003\u0000\t\n"+
		"\r\r  \u0001\u0001\n\n\u0001\u000009\u00d3\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000"+
		"\u0000\u0000\u0001;\u0001\u0000\u0000\u0000\u0003=\u0001\u0000\u0000\u0000"+
		"\u0005?\u0001\u0000\u0000\u0000\u0007A\u0001\u0000\u0000\u0000\tC\u0001"+
		"\u0000\u0000\u0000\u000bE\u0001\u0000\u0000\u0000\rJ\u0001\u0000\u0000"+
		"\u0000\u000fP\u0001\u0000\u0000\u0000\u0011R\u0001\u0000\u0000\u0000\u0013"+
		"T\u0001\u0000\u0000\u0000\u0015X\u0001\u0000\u0000\u0000\u0017\\\u0001"+
		"\u0000\u0000\u0000\u0019_\u0001\u0000\u0000\u0000\u001bb\u0001\u0000\u0000"+
		"\u0000\u001de\u0001\u0000\u0000\u0000\u001fg\u0001\u0000\u0000\u0000!"+
		"j\u0001\u0000\u0000\u0000#l\u0001\u0000\u0000\u0000%p\u0001\u0000\u0000"+
		"\u0000\'\u0086\u0001\u0000\u0000\u0000)\u0088\u0001\u0000\u0000\u0000"+
		"+\u0093\u0001\u0000\u0000\u0000-\u0097\u0001\u0000\u0000\u0000/\u009d"+
		"\u0001\u0000\u0000\u00001\u00a0\u0001\u0000\u0000\u00003\u00a6\u0001\u0000"+
		"\u0000\u00005\u00b4\u0001\u0000\u0000\u00007\u00c2\u0001\u0000\u0000\u0000"+
		"9\u00c8\u0001\u0000\u0000\u0000;<\u0005*\u0000\u0000<\u0002\u0001\u0000"+
		"\u0000\u0000=>\u0005+\u0000\u0000>\u0004\u0001\u0000\u0000\u0000?@\u0005"+
		"-\u0000\u0000@\u0006\u0001\u0000\u0000\u0000AB\u0005/\u0000\u0000B\b\u0001"+
		"\u0000\u0000\u0000CD\u0005%\u0000\u0000D\n\u0001\u0000\u0000\u0000EF\u0005"+
		"t\u0000\u0000FG\u0005r\u0000\u0000GH\u0005u\u0000\u0000HI\u0005e\u0000"+
		"\u0000I\f\u0001\u0000\u0000\u0000JK\u0005f\u0000\u0000KL\u0005a\u0000"+
		"\u0000LM\u0005l\u0000\u0000MN\u0005s\u0000\u0000NO\u0005e\u0000\u0000"+
		"O\u000e\u0001\u0000\u0000\u0000PQ\u0005(\u0000\u0000Q\u0010\u0001\u0000"+
		"\u0000\u0000RS\u0005)\u0000\u0000S\u0012\u0001\u0000\u0000\u0000TU\u0005"+
		"n\u0000\u0000UV\u0005o\u0000\u0000VW\u0005t\u0000\u0000W\u0014\u0001\u0000"+
		"\u0000\u0000XY\u0005a\u0000\u0000YZ\u0005n\u0000\u0000Z[\u0005d\u0000"+
		"\u0000[\u0016\u0001\u0000\u0000\u0000\\]\u0005o\u0000\u0000]^\u0005r\u0000"+
		"\u0000^\u0018\u0001\u0000\u0000\u0000_`\u0005=\u0000\u0000`a\u0005=\u0000"+
		"\u0000a\u001a\u0001\u0000\u0000\u0000bc\u0005!\u0000\u0000cd\u0005=\u0000"+
		"\u0000d\u001c\u0001\u0000\u0000\u0000ef\u0005<\u0000\u0000f\u001e\u0001"+
		"\u0000\u0000\u0000gh\u0005<\u0000\u0000hi\u0005=\u0000\u0000i \u0001\u0000"+
		"\u0000\u0000jk\u0005>\u0000\u0000k\"\u0001\u0000\u0000\u0000lm\u0005>"+
		"\u0000\u0000mn\u0005=\u0000\u0000n$\u0001\u0000\u0000\u0000oq\u00037\u001b"+
		"\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000s&\u0001\u0000\u0000\u0000tv\u0003"+
		"7\u001b\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001"+
		"\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"y}\u0005.\u0000\u0000z|\u00037\u001b\u0000{z\u0001\u0000\u0000\u0000|"+
		"\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000~\u0087\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000"+
		"\u0080\u0082\u0005.\u0000\u0000\u0081\u0083\u00037\u001b\u0000\u0082\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087"+
		"\u0001\u0000\u0000\u0000\u0086u\u0001\u0000\u0000\u0000\u0086\u0080\u0001"+
		"\u0000\u0000\u0000\u0087(\u0001\u0000\u0000\u0000\u0088\u008d\u0005\""+
		"\u0000\u0000\u0089\u008c\u00039\u001c\u0000\u008a\u008c\t\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u0090\u0001\u0000\u0000"+
		"\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0005\"\u0000\u0000"+
		"\u0091*\u0001\u0000\u0000\u0000\u0092\u0094\u0005\r\u0000\u0000\u0093"+
		"\u0092\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0005\n\u0000\u0000\u0096,"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0005p\u0000\u0000\u0098\u0099\u0005"+
		"r\u0000\u0000\u0099\u009a\u0005i\u0000\u0000\u009a\u009b\u0005n\u0000"+
		"\u0000\u009b\u009c\u0005t\u0000\u0000\u009c.\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0005;\u0000\u0000\u009e0\u0001\u0000\u0000\u0000\u009f\u00a1\u0007"+
		"\u0000\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0006"+
		"\u0018\u0000\u0000\u00a52\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005/\u0000"+
		"\u0000\u00a7\u00a8\u0005/\u0000\u0000\u00a8\u00ac\u0001\u0000\u0000\u0000"+
		"\u00a9\u00ab\t\u0000\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ae\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ac\u0001\u0000\u0000\u0000\u00af\u00b1\u0007\u0001\u0000\u0000\u00b0"+
		"\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0006\u0019\u0000\u0000\u00b34\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0005/\u0000\u0000\u00b5\u00b6\u0005*\u0000\u0000\u00b6\u00ba\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b9\t\u0000\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00be\u0005*\u0000\u0000"+
		"\u00be\u00bf\u0005/\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0006\u001a\u0000\u0000\u00c16\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0007\u0002\u0000\u0000\u00c38\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005"+
		"\\\u0000\u0000\u00c5\u00c9\u0005\"\u0000\u0000\u00c6\u00c7\u0005\\\u0000"+
		"\u0000\u00c7\u00c9\u0005\\\u0000\u0000\u00c8\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9:\u0001\u0000\u0000\u0000\u000e"+
		"\u0000rw}\u0084\u0086\u008b\u008d\u0093\u00a2\u00ac\u00b0\u00ba\u00c8"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}