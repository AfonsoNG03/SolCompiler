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
		RULE_prog = 0, RULE_line = 1, RULE_inst = 2, RULE_assignInst = 3, RULE_var = 4, 
		RULE_block = 5, RULE_type = 6, RULE_while = 7, RULE_for = 8, RULE_if = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "line", "inst", "assignInst", "var", "block", "type", "while", 
			"for", "if"
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
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0)) {
				{
				{
				setState(20);
				var();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				line();
				}
				}
				setState(29); 
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
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				match(PRINT);
				setState(32);
				inst(0);
				setState(33);
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
				setState(35);
				inst(0);
				setState(36);
				match(SEMICOLON);
				}
				break;
			case BEGIN:
				_localctx = new BlockCodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				block();
				}
				break;
			case WHILE:
				_localctx = new WhileCycleContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				while_();
				}
				break;
			case FOR:
				_localctx = new ForCycleContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				for_();
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				if_();
				}
				break;
			case BREAK:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				match(BREAK);
				setState(43);
				match(SEMICOLON);
				}
				break;
			case SEMICOLON:
				_localctx = new EmptyContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(44);
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
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(48);
				match(LPAREN);
				setState(49);
				inst(0);
				setState(50);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
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
				setState(53);
				inst(10);
				}
				break;
			case 3:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
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
				setState(55);
				match(ID);
				setState(56);
				match(ASSIGN);
				setState(57);
				inst(2);
				}
				break;
			case 5:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(79);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(61);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(62);
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
						setState(63);
						inst(10);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(64);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(65);
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
						setState(66);
						inst(9);
						}
						break;
					case 3:
						{
						_localctx = new RelContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(67);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(68);
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
						setState(69);
						inst(8);
						}
						break;
					case 4:
						{
						_localctx = new EqualContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(70);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(71);
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
						setState(72);
						inst(7);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(73);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(74);
						((AndContext)_localctx).op = match(AND);
						setState(75);
						inst(6);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new InstContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inst);
						setState(76);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(77);
						((OrContext)_localctx).op = match(OR);
						setState(78);
						inst(5);
						}
						break;
					}
					} 
				}
				setState(83);
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
	public static class AssignInstContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SolParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SolParser.ASSIGN, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public AssignInstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignInst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterAssignInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitAssignInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitAssignInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignInstContext assignInst() throws RecognitionException {
		AssignInstContext _localctx = new AssignInstContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignInst);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(ID);
				setState(85);
				match(ASSIGN);
				setState(86);
				inst(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(ID);
				}
				break;
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
	public static class VarContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SolParser.SEMICOLON, 0); }
		public List<AssignInstContext> assignInst() {
			return getRuleContexts(AssignInstContext.class);
		}
		public AssignInstContext assignInst(int i) {
			return getRuleContext(AssignInstContext.class,i);
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
		enterRule(_localctx, 8, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			type();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(91);
				assignInst();
				}
			}

			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(94);
				match(COMMA);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(95);
					assignInst();
					}
				}

				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
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
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(BEGIN);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1632136070476L) != 0)) {
				{
				{
				setState(106);
				line();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
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
		public Token op;
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
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			((TypeContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0)) ) {
				((TypeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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
		enterRule(_localctx, 14, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(WHILE);
			setState(117);
			inst(0);
			setState(118);
			match(DO);
			setState(119);
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
		enterRule(_localctx, 16, RULE_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(FOR);
			setState(122);
			match(ID);
			setState(123);
			match(ASSIGN);
			setState(124);
			inst(0);
			setState(125);
			match(TO);
			setState(126);
			inst(0);
			setState(127);
			match(DO);
			setState(128);
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
		enterRule(_localctx, 18, RULE_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(IF);
			setState(131);
			inst(0);
			setState(132);
			match(THEN);
			setState(133);
			line();
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(134);
				match(ELSE);
				setState(135);
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
		"\u0004\u0001+\u008b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0005\u0000\u0016\b\u0000\n\u0000"+
		"\f\u0000\u0019\t\u0000\u0001\u0000\u0004\u0000\u001c\b\u0000\u000b\u0000"+
		"\f\u0000\u001d\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001.\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"<\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002P\b\u0002\n\u0002\f\u0002S\t\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003Y\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0003\u0004]\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"a\b\u0004\u0005\u0004c\b\u0004\n\u0004\f\u0004f\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0005\u0005l\b\u0005\n\u0005\f\u0005o\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u0089\b\t\u0001\t\u0000\u0001\u0004\n\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0007\u0002\u0000\u0012"+
		"\u0012\u0019\u0019\u0002\u0000\u0015\u0016\"$\u0002\u0000\u0010\u0010"+
		"\u0013\u0014\u0001\u0000\u0011\u0012\u0001\u0000\u001e!\u0001\u0000\u001c"+
		"\u001d\u0001\u0000\f\u000f\u0099\u0000\u0017\u0001\u0000\u0000\u0000\u0002"+
		"-\u0001\u0000\u0000\u0000\u0004;\u0001\u0000\u0000\u0000\u0006X\u0001"+
		"\u0000\u0000\u0000\bZ\u0001\u0000\u0000\u0000\ni\u0001\u0000\u0000\u0000"+
		"\fr\u0001\u0000\u0000\u0000\u000et\u0001\u0000\u0000\u0000\u0010y\u0001"+
		"\u0000\u0000\u0000\u0012\u0082\u0001\u0000\u0000\u0000\u0014\u0016\u0003"+
		"\b\u0004\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0019\u0001\u0000"+
		"\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000"+
		"\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000"+
		"\u0000\u0000\u001a\u001c\u0003\u0002\u0001\u0000\u001b\u001a\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u0001\u0001\u0000"+
		"\u0000\u0000\u001f \u0005%\u0000\u0000 !\u0003\u0004\u0002\u0000!\"\u0005"+
		"&\u0000\u0000\".\u0001\u0000\u0000\u0000#$\u0003\u0004\u0002\u0000$%\u0005"+
		"&\u0000\u0000%.\u0001\u0000\u0000\u0000&.\u0003\n\u0005\u0000\'.\u0003"+
		"\u000e\u0007\u0000(.\u0003\u0010\b\u0000).\u0003\u0012\t\u0000*+\u0005"+
		"\u0002\u0000\u0000+.\u0005&\u0000\u0000,.\u0005&\u0000\u0000-\u001f\u0001"+
		"\u0000\u0000\u0000-#\u0001\u0000\u0000\u0000-&\u0001\u0000\u0000\u0000"+
		"-\'\u0001\u0000\u0000\u0000-(\u0001\u0000\u0000\u0000-)\u0001\u0000\u0000"+
		"\u0000-*\u0001\u0000\u0000\u0000-,\u0001\u0000\u0000\u0000.\u0003\u0001"+
		"\u0000\u0000\u0000/0\u0006\u0002\uffff\uffff\u000001\u0005\u0017\u0000"+
		"\u000012\u0003\u0004\u0002\u000023\u0005\u0018\u0000\u00003<\u0001\u0000"+
		"\u0000\u000045\u0007\u0000\u0000\u00005<\u0003\u0004\u0002\n6<\u0007\u0001"+
		"\u0000\u000078\u0005(\u0000\u000089\u0005\u0001\u0000\u00009<\u0003\u0004"+
		"\u0002\u0002:<\u0005(\u0000\u0000;/\u0001\u0000\u0000\u0000;4\u0001\u0000"+
		"\u0000\u0000;6\u0001\u0000\u0000\u0000;7\u0001\u0000\u0000\u0000;:\u0001"+
		"\u0000\u0000\u0000<Q\u0001\u0000\u0000\u0000=>\n\t\u0000\u0000>?\u0007"+
		"\u0002\u0000\u0000?P\u0003\u0004\u0002\n@A\n\b\u0000\u0000AB\u0007\u0003"+
		"\u0000\u0000BP\u0003\u0004\u0002\tCD\n\u0007\u0000\u0000DE\u0007\u0004"+
		"\u0000\u0000EP\u0003\u0004\u0002\bFG\n\u0006\u0000\u0000GH\u0007\u0005"+
		"\u0000\u0000HP\u0003\u0004\u0002\u0007IJ\n\u0005\u0000\u0000JK\u0005\u001a"+
		"\u0000\u0000KP\u0003\u0004\u0002\u0006LM\n\u0004\u0000\u0000MN\u0005\u001b"+
		"\u0000\u0000NP\u0003\u0004\u0002\u0005O=\u0001\u0000\u0000\u0000O@\u0001"+
		"\u0000\u0000\u0000OC\u0001\u0000\u0000\u0000OF\u0001\u0000\u0000\u0000"+
		"OI\u0001\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R\u0005\u0001"+
		"\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TU\u0005(\u0000\u0000UV\u0005"+
		"\u0001\u0000\u0000VY\u0003\u0004\u0002\u0000WY\u0005(\u0000\u0000XT\u0001"+
		"\u0000\u0000\u0000XW\u0001\u0000\u0000\u0000Y\u0007\u0001\u0000\u0000"+
		"\u0000Z\\\u0003\f\u0006\u0000[]\u0003\u0006\u0003\u0000\\[\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]d\u0001\u0000\u0000\u0000^`\u0005"+
		"\'\u0000\u0000_a\u0003\u0006\u0003\u0000`_\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000ac\u0001\u0000\u0000\u0000b^\u0001\u0000\u0000\u0000"+
		"cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000eg\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gh\u0005&\u0000"+
		"\u0000h\t\u0001\u0000\u0000\u0000im\u0005\n\u0000\u0000jl\u0003\u0002"+
		"\u0001\u0000kj\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000\u0000mk\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001\u0000\u0000\u0000"+
		"om\u0001\u0000\u0000\u0000pq\u0005\u000b\u0000\u0000q\u000b\u0001\u0000"+
		"\u0000\u0000rs\u0007\u0006\u0000\u0000s\r\u0001\u0000\u0000\u0000tu\u0005"+
		"\b\u0000\u0000uv\u0003\u0004\u0002\u0000vw\u0005\t\u0000\u0000wx\u0003"+
		"\u0002\u0001\u0000x\u000f\u0001\u0000\u0000\u0000yz\u0005\u0006\u0000"+
		"\u0000z{\u0005(\u0000\u0000{|\u0005\u0001\u0000\u0000|}\u0003\u0004\u0002"+
		"\u0000}~\u0005\u0007\u0000\u0000~\u007f\u0003\u0004\u0002\u0000\u007f"+
		"\u0080\u0005\t\u0000\u0000\u0080\u0081\u0003\u0002\u0001\u0000\u0081\u0011"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0003\u0000\u0000\u0083\u0084"+
		"\u0003\u0004\u0002\u0000\u0084\u0085\u0005\u0004\u0000\u0000\u0085\u0088"+
		"\u0003\u0002\u0001\u0000\u0086\u0087\u0005\u0005\u0000\u0000\u0087\u0089"+
		"\u0003\u0002\u0001\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0001\u0000\u0000\u0000\u0089\u0013\u0001\u0000\u0000\u0000\f\u0017\u001d"+
		"-;OQX\\`dm\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}