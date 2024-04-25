// Generated from C:/Users/fpgue/Desktop/Trabalhos Uni/Compiladores2324/UNI/SolCompiler/Sol.g4 by ANTLR 4.13.1
package Sol;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ASSIGN=1, BREAK=2, IF=3, THEN=4, ELSE=5, FOR=6, TO=7, WHILE=8, DO=9, BEGIN=10, 
		END=11, TYPEINT=12, TYPEDOUBLE=13, TYPESTRING=14, TYPEBOOL=15, MULT=16, 
		ADD=17, SUB=18, DIV=19, MOD=20, TRUE=21, FALSE=22, LPAREN=23, RPAREN=24, 
		NOT=25, AND=26, OR=27, EQ=28, NEQ=29, LT=30, LE=31, GT=32, GE=33, INT=34, 
		DOUBLE=35, STRING=36, PRINT=37, SEMICOLON=38, COMMA=39, ID=40, WS=41, 
		SL_COMMENT=42, ML_COMMENT=43;
	public static final int
		RULE_prog = 0, RULE_line = 1, RULE_inst = 2, RULE_var = 3, RULE_block = 4, 
		RULE_type = 5, RULE_while = 6, RULE_for = 7, RULE_if = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "line", "inst", "var", "block", "type", "while", "for", "if"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'break'", "'if'", "'then'", "'else'", "'for'", "'to'", 
			"'while'", "'do'", "'begin'", "'end'", "'int'", "'real'", "'string'", 
			"'bool'", "'*'", "'+'", "'-'", "'/'", "'%'", "'true'", "'false'", "'('", 
			"')'", "'not'", "'and'", "'or'", "'=='", "'!='", "'<'", "'<='", "'>'", 
			"'>='", null, null, null, "'print'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ASSIGN", "BREAK", "IF", "THEN", "ELSE", "FOR", "TO", "WHILE", 
			"DO", "BEGIN", "END", "TYPEINT", "TYPEDOUBLE", "TYPESTRING", "TYPEBOOL", 
			"MULT", "ADD", "SUB", "DIV", "MOD", "TRUE", "FALSE", "LPAREN", "RPAREN", 
			"NOT", "AND", "OR", "EQ", "NEQ", "LT", "LE", "GT", "GE", "INT", "DOUBLE", 
			"STRING", "PRINT", "SEMICOLON", "COMMA", "ID", "WS", "SL_COMMENT", "ML_COMMENT"
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

	@Override
	public String getGrammarFileName() { return "Sol.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0)) {
				{
				{
				setState(18);
				var();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				line();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1632136070476L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	 
		public LineContext() { }
		public void copyFrom(LineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockCodeContext extends LineContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockCodeContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterBlockCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitBlockCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitBlockCode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends LineContext {
		public TerminalNode BREAK() { return getToken(SolParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(SolParser.SEMICOLON, 0); }
		public BreakStatementContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends LineContext {
		public TerminalNode PRINT() { return getToken(SolParser.PRINT, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SolParser.SEMICOLON, 0); }
		public PrintContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends LineContext {
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public IfStatementContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyContext extends LineContext {
		public TerminalNode SEMICOLON() { return getToken(SolParser.SEMICOLON, 0); }
		public EmptyContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileCycleContext extends LineContext {
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public WhileCycleContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterWhileCycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitWhileCycle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitWhileCycle(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForCycleContext extends LineContext {
		public ForContext for_() {
			return getRuleContext(ForContext.class,0);
		}
		public ForCycleContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterForCycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitForCycle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitForCycle(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends LineContext {
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SolParser.SEMICOLON, 0); }
		public InstructionContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(PRINT);
				setState(30);
				inst(0);
				setState(31);
				match(SEMICOLON);
				}
				break;
			case SUB:
			case TRUE:
			case FALSE:
			case LPAREN:
			case NOT:
			case INT:
			case DOUBLE:
			case STRING:
			case ID:
				_localctx = new InstructionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				inst(0);
				setState(34);
				match(SEMICOLON);
				}
				break;
			case BEGIN:
				_localctx = new BlockCodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				block();
				}
				break;
			case WHILE:
				_localctx = new WhileCycleContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				while_();
				}
				break;
			case FOR:
				_localctx = new ForCycleContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				for_();
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(39);
				if_();
				}
				break;
			case BREAK:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(40);
				match(BREAK);
				setState(41);
				match(SEMICOLON);
				}
				break;
			case SEMICOLON:
				_localctx = new EmptyContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(42);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstContext extends ParserRuleContext {
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
	 
		public InstContext() { }
		public void copyFrom(InstContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends InstContext {
		public Token op;
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public TerminalNode OR() { return getToken(SolParser.OR, 0); }
		public OrContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends InstContext {
		public Token op;
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public TerminalNode ADD() { return getToken(SolParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SolParser.SUB, 0); }
		public AddSubContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualContext extends InstContext {
		public Token op;
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public TerminalNode EQ() { return getToken(SolParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SolParser.NEQ, 0); }
		public EqualContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends InstContext {
		public Token op;
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public TerminalNode AND() { return getToken(SolParser.AND, 0); }
		public AndContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends InstContext {
		public Token op;
		public TerminalNode INT() { return getToken(SolParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(SolParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(SolParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(SolParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SolParser.FALSE, 0); }
		public LiteralContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelContext extends InstContext {
		public Token op;
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public TerminalNode LT() { return getToken(SolParser.LT, 0); }
		public TerminalNode LE() { return getToken(SolParser.LE, 0); }
		public TerminalNode GT() { return getToken(SolParser.GT, 0); }
		public TerminalNode GE() { return getToken(SolParser.GE, 0); }
		public RelContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitRel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitRel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends InstContext {
		public TerminalNode ID() { return getToken(SolParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SolParser.ASSIGN, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public AssignContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends InstContext {
		public TerminalNode ID() { return getToken(SolParser.ID, 0); }
		public IdContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends InstContext {
		public Token op;
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public TerminalNode SUB() { return getToken(SolParser.SUB, 0); }
		public TerminalNode NOT() { return getToken(SolParser.NOT, 0); }
		public UnaryContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenContext extends InstContext {
		public TerminalNode LPAREN() { return getToken(SolParser.LPAREN, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SolParser.RPAREN, 0); }
		public ParenContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultDivContext extends InstContext {
		public Token op;
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public TerminalNode MULT() { return getToken(SolParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(SolParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SolParser.MOD, 0); }
		public MultDivContext(InstContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitMultDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstContext inst() throws RecognitionException {
		return inst(0);
	}

	private InstContext inst(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InstContext _localctx = new InstContext(_ctx, _parentState);
		InstContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_inst, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(46);
				match(LPAREN);
				setState(47);
				inst(0);
				setState(48);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==NOT) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(51);
				inst(10);
				}
				break;
			case 3:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				((LiteralContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 120265375744L) != 0)) ) {
					((LiteralContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53);
				match(ID);
				setState(54);
				match(ASSIGN);
				setState(55);
				inst(2);
				}
				break;
			case 5:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(77);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(59);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(60);
						((MultDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1638400L) != 0)) ) {
							((MultDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(61);
						inst(10);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(62);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(63);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(64);
						inst(9);
						}
						break;
					case 3:
						{
						_localctx = new RelContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(65);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(66);
						((RelContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16106127360L) != 0)) ) {
							((RelContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(67);
						inst(8);
						}
						break;
					case 4:
						{
						_localctx = new EqualContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(68);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(69);
						((EqualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(70);
						inst(7);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(71);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(72);
						((AndContext)_localctx).op = match(AND);
						setState(73);
						inst(6);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(74);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(75);
						((OrContext)_localctx).op = match(OR);
						setState(76);
						inst(5);
						}
						break;
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SolParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(SolParser.SEMICOLON, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(SolParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SolParser.ASSIGN, i);
		}
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SolParser.COMMA, i);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			type();
			setState(83);
			match(ID);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(84);
				match(ASSIGN);
				setState(85);
				inst(0);
				}
			}

			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(88);
				match(COMMA);
				setState(89);
				match(ID);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(90);
					match(ASSIGN);
					setState(91);
					inst(0);
					}
				}

				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(SolParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(SolParser.END, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(BEGIN);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1632136070476L) != 0)) {
				{
				{
				setState(102);
				line();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPEINT() { return getToken(SolParser.TYPEINT, 0); }
		public TerminalNode TYPEDOUBLE() { return getToken(SolParser.TYPEDOUBLE, 0); }
		public TerminalNode TYPESTRING() { return getToken(SolParser.TYPESTRING, 0); }
		public TerminalNode TYPEBOOL() { return getToken(SolParser.TYPEBOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(SolParser.WHILE, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public TerminalNode DO() { return getToken(SolParser.DO, 0); }
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(WHILE);
			setState(113);
			inst(0);
			setState(114);
			match(DO);
			setState(115);
			line();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SolParser.FOR, 0); }
		public TerminalNode ID() { return getToken(SolParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SolParser.ASSIGN, 0); }
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public TerminalNode TO() { return getToken(SolParser.TO, 0); }
		public TerminalNode DO() { return getToken(SolParser.DO, 0); }
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public ForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForContext for_() throws RecognitionException {
		ForContext _localctx = new ForContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(FOR);
			setState(118);
			match(ID);
			setState(119);
			match(ASSIGN);
			setState(120);
			inst(0);
			setState(121);
			match(TO);
			setState(122);
			inst(0);
			setState(123);
			match(DO);
			setState(124);
			line();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SolParser.IF, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SolParser.THEN, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SolParser.ELSE, 0); }
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(IF);
			setState(127);
			inst(0);
			setState(128);
			match(THEN);
			setState(129);
			line();
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(130);
				match(ELSE);
				setState(131);
				line();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return inst_sempred((InstContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean inst_sempred(InstContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u0087\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0005\u0000\u0014\b\u0000\n\u0000\f\u0000\u0017"+
		"\t\u0000\u0001\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001,\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002:\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002N\b\u0002\n\u0002\f\u0002Q\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003W\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003]\b\u0003\u0005\u0003_\b\u0003\n\u0003"+
		"\f\u0003b\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005"+
		"\u0004h\b\u0004\n\u0004\f\u0004k\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u0085\b\b\u0001\b\u0000\u0001\u0004\t\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000\u0007\u0002\u0000\u0012\u0012"+
		"\u0019\u0019\u0002\u0000\u0015\u0016\"$\u0002\u0000\u0010\u0010\u0013"+
		"\u0014\u0001\u0000\u0011\u0012\u0001\u0000\u001e!\u0001\u0000\u001c\u001d"+
		"\u0001\u0000\f\u000f\u0095\u0000\u0015\u0001\u0000\u0000\u0000\u0002+"+
		"\u0001\u0000\u0000\u0000\u00049\u0001\u0000\u0000\u0000\u0006R\u0001\u0000"+
		"\u0000\u0000\be\u0001\u0000\u0000\u0000\nn\u0001\u0000\u0000\u0000\fp"+
		"\u0001\u0000\u0000\u0000\u000eu\u0001\u0000\u0000\u0000\u0010~\u0001\u0000"+
		"\u0000\u0000\u0012\u0014\u0003\u0006\u0003\u0000\u0013\u0012\u0001\u0000"+
		"\u0000\u0000\u0014\u0017\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000"+
		"\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0019\u0001\u0000"+
		"\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0018\u001a\u0003\u0002"+
		"\u0001\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000"+
		"\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000"+
		"\u0000\u0000\u001c\u0001\u0001\u0000\u0000\u0000\u001d\u001e\u0005%\u0000"+
		"\u0000\u001e\u001f\u0003\u0004\u0002\u0000\u001f \u0005&\u0000\u0000 "+
		",\u0001\u0000\u0000\u0000!\"\u0003\u0004\u0002\u0000\"#\u0005&\u0000\u0000"+
		"#,\u0001\u0000\u0000\u0000$,\u0003\b\u0004\u0000%,\u0003\f\u0006\u0000"+
		"&,\u0003\u000e\u0007\u0000\',\u0003\u0010\b\u0000()\u0005\u0002\u0000"+
		"\u0000),\u0005&\u0000\u0000*,\u0005&\u0000\u0000+\u001d\u0001\u0000\u0000"+
		"\u0000+!\u0001\u0000\u0000\u0000+$\u0001\u0000\u0000\u0000+%\u0001\u0000"+
		"\u0000\u0000+&\u0001\u0000\u0000\u0000+\'\u0001\u0000\u0000\u0000+(\u0001"+
		"\u0000\u0000\u0000+*\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000"+
		"\u0000-.\u0006\u0002\uffff\uffff\u0000./\u0005\u0017\u0000\u0000/0\u0003"+
		"\u0004\u0002\u000001\u0005\u0018\u0000\u00001:\u0001\u0000\u0000\u0000"+
		"23\u0007\u0000\u0000\u00003:\u0003\u0004\u0002\n4:\u0007\u0001\u0000\u0000"+
		"56\u0005(\u0000\u000067\u0005\u0001\u0000\u00007:\u0003\u0004\u0002\u0002"+
		"8:\u0005(\u0000\u00009-\u0001\u0000\u0000\u000092\u0001\u0000\u0000\u0000"+
		"94\u0001\u0000\u0000\u000095\u0001\u0000\u0000\u000098\u0001\u0000\u0000"+
		"\u0000:O\u0001\u0000\u0000\u0000;<\n\t\u0000\u0000<=\u0007\u0002\u0000"+
		"\u0000=N\u0003\u0004\u0002\n>?\n\b\u0000\u0000?@\u0007\u0003\u0000\u0000"+
		"@N\u0003\u0004\u0002\tAB\n\u0007\u0000\u0000BC\u0007\u0004\u0000\u0000"+
		"CN\u0003\u0004\u0002\bDE\n\u0006\u0000\u0000EF\u0007\u0005\u0000\u0000"+
		"FN\u0003\u0004\u0002\u0007GH\n\u0005\u0000\u0000HI\u0005\u001a\u0000\u0000"+
		"IN\u0003\u0004\u0002\u0006JK\n\u0004\u0000\u0000KL\u0005\u001b\u0000\u0000"+
		"LN\u0003\u0004\u0002\u0005M;\u0001\u0000\u0000\u0000M>\u0001\u0000\u0000"+
		"\u0000MA\u0001\u0000\u0000\u0000MD\u0001\u0000\u0000\u0000MG\u0001\u0000"+
		"\u0000\u0000MJ\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u0005\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000RS\u0003\n\u0005\u0000SV\u0005(\u0000"+
		"\u0000TU\u0005\u0001\u0000\u0000UW\u0003\u0004\u0002\u0000VT\u0001\u0000"+
		"\u0000\u0000VW\u0001\u0000\u0000\u0000W`\u0001\u0000\u0000\u0000XY\u0005"+
		"\'\u0000\u0000Y\\\u0005(\u0000\u0000Z[\u0005\u0001\u0000\u0000[]\u0003"+
		"\u0004\u0002\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000"+
		"]_\u0001\u0000\u0000\u0000^X\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000"+
		"\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000cd\u0005&\u0000\u0000d\u0007\u0001"+
		"\u0000\u0000\u0000ei\u0005\n\u0000\u0000fh\u0003\u0002\u0001\u0000gf\u0001"+
		"\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000lm\u0005\u000b\u0000\u0000m\t\u0001\u0000\u0000\u0000no\u0007\u0006"+
		"\u0000\u0000o\u000b\u0001\u0000\u0000\u0000pq\u0005\b\u0000\u0000qr\u0003"+
		"\u0004\u0002\u0000rs\u0005\t\u0000\u0000st\u0003\u0002\u0001\u0000t\r"+
		"\u0001\u0000\u0000\u0000uv\u0005\u0006\u0000\u0000vw\u0005(\u0000\u0000"+
		"wx\u0005\u0001\u0000\u0000xy\u0003\u0004\u0002\u0000yz\u0005\u0007\u0000"+
		"\u0000z{\u0003\u0004\u0002\u0000{|\u0005\t\u0000\u0000|}\u0003\u0002\u0001"+
		"\u0000}\u000f\u0001\u0000\u0000\u0000~\u007f\u0005\u0003\u0000\u0000\u007f"+
		"\u0080\u0003\u0004\u0002\u0000\u0080\u0081\u0005\u0004\u0000\u0000\u0081"+
		"\u0084\u0003\u0002\u0001\u0000\u0082\u0083\u0005\u0005\u0000\u0000\u0083"+
		"\u0085\u0003\u0002\u0001\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0001\u0000\u0000\u0000\u0085\u0011\u0001\u0000\u0000\u0000\u000b"+
		"\u0015\u001b+9MOV\\`i\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}