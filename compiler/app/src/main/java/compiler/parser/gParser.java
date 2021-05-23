// Generated from app/src/main/java/compiler/g.g4 by ANTLR 4.9.2

package compiler.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, BASIC_TYPE=2, OR=3, AND=4, EQ=5, NEQ=6, GT=7, LT=8, GTEQ=9, LTEQ=10, 
		PLUS=11, MINUS=12, MULT=13, DIV=14, MOD=15, OPERATOR=16, ASSIGN=17, OPAR=18, 
		CPAR=19, OBRACE=20, CBRACE=21, NULL=22, IF=23, ELSE=24, PAR=25, COMMA=26, 
		ARROW=27, LET=28, IN=29, RANGE_NAME=30, NUMBER=31, CELL_ADDRESS=32, ID=33, 
		STRING=34, BOOL=35, TRUE=36, FALSE=37, CHARACTER=38, NEWLINE=39, WS=40;
	public static final int
		RULE_global_scope = 0, RULE_statements = 1, RULE_range_binding = 2, RULE_let_binding = 3, 
		RULE_let_expr = 4, RULE_expr = 5, RULE_if_else = 6, RULE_type = 7, RULE_basic_type = 8, 
		RULE_range_type = 9, RULE_range_expr = 10, RULE_lambda = 11, RULE_lambda_type = 12, 
		RULE_lambda_invocation = 13, RULE_value = 14, RULE_range = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"global_scope", "statements", "range_binding", "let_binding", "let_expr", 
			"expr", "if_else", "type", "basic_type", "range_type", "range_expr", 
			"lambda", "lambda_type", "lambda_invocation", "value", "range"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", null, "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", 
			"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", null, "'='", "'('", "')'", 
			"'{'", "'}'", "'null'", "'if'", "'else'", "'\"'", "','", "'->'", "'let'", 
			"'in'", "'Range'", null, null, null, null, null, "'True'", "'False'", 
			null, "'\r?\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "BASIC_TYPE", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", 
			"LTEQ", "PLUS", "MINUS", "MULT", "DIV", "MOD", "OPERATOR", "ASSIGN", 
			"OPAR", "CPAR", "OBRACE", "CBRACE", "NULL", "IF", "ELSE", "PAR", "COMMA", 
			"ARROW", "LET", "IN", "RANGE_NAME", "NUMBER", "CELL_ADDRESS", "ID", "STRING", 
			"BOOL", "TRUE", "FALSE", "CHARACTER", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "g.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Global_scopeContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(gParser.EOF, 0); }
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public Global_scopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterGlobal_scope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitGlobal_scope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitGlobal_scope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_scopeContext global_scope() throws RecognitionException {
		Global_scopeContext _localctx = new Global_scopeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_global_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LET || _la==CELL_ADDRESS) {
				{
				{
				setState(32);
				statements();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(EOF);
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

	public static class StatementsContext extends ParserRuleContext {
		public Range_bindingContext range_binding() {
			return getRuleContext(Range_bindingContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(gParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(gParser.NEWLINE, i);
		}
		public Let_bindingContext let_binding() {
			return getRuleContext(Let_bindingContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CELL_ADDRESS:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				range_binding();
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(41);
					match(NEWLINE);
					}
					}
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case LET:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				let_binding();
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(48);
					match(NEWLINE);
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class Range_bindingContext extends ParserRuleContext {
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(gParser.ASSIGN, 0); }
		public Range_exprContext range_expr() {
			return getRuleContext(Range_exprContext.class,0);
		}
		public Range_bindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterRange_binding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitRange_binding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitRange_binding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Range_bindingContext range_binding() throws RecognitionException {
		Range_bindingContext _localctx = new Range_bindingContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_range_binding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			range();
			setState(57);
			match(ASSIGN);
			setState(58);
			range_expr();
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

	public static class Let_bindingContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(gParser.LET, 0); }
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(gParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Let_bindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterLet_binding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitLet_binding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitLet_binding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_bindingContext let_binding() throws RecognitionException {
		Let_bindingContext _localctx = new Let_bindingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_let_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(LET);
			setState(61);
			match(ID);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BASIC_TYPE) | (1L << OPAR) | (1L << RANGE_NAME))) != 0)) {
				{
				setState(62);
				type();
				}
			}

			setState(65);
			match(ASSIGN);
			setState(66);
			expr(0);
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

	public static class Let_exprContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(gParser.LET, 0); }
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(gParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN() { return getToken(gParser.IN, 0); }
		public Let_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterLet_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitLet_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitLet_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_exprContext let_expr() throws RecognitionException {
		Let_exprContext _localctx = new Let_exprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_let_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(LET);
			setState(69);
			match(ID);
			setState(70);
			match(ASSIGN);
			setState(71);
			expr(0);
			setState(72);
			match(IN);
			setState(73);
			expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expr_lambdaContext extends ExprContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public Expr_lambdaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterExpr_lambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitExpr_lambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpr_lambda(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_invokeContext extends ExprContext {
		public Lambda_invocationContext lambda_invocation() {
			return getRuleContext(Lambda_invocationContext.class,0);
		}
		public Expr_invokeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterExpr_invoke(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitExpr_invoke(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpr_invoke(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_letContext extends ExprContext {
		public Let_exprContext let_expr() {
			return getRuleContext(Let_exprContext.class,0);
		}
		public Expr_letContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterExpr_let(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitExpr_let(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpr_let(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_valueContext extends ExprContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Expr_valueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterExpr_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitExpr_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpr_value(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_if_elseContext extends ExprContext {
		public If_elseContext if_else() {
			return getRuleContext(If_elseContext.class,0);
		}
		public Expr_if_elseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterExpr_if_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitExpr_if_else(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpr_if_else(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_rangeContext extends ExprContext {
		public Range_exprContext range_expr() {
			return getRuleContext(Range_exprContext.class,0);
		}
		public Expr_rangeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterExpr_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitExpr_range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpr_range(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OperatorContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(gParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(gParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(gParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(gParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(gParser.MINUS, 0); }
		public TerminalNode AND() { return getToken(gParser.AND, 0); }
		public TerminalNode OR() { return getToken(gParser.OR, 0); }
		public TerminalNode EQ() { return getToken(gParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(gParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(gParser.LT, 0); }
		public TerminalNode GT() { return getToken(gParser.GT, 0); }
		public TerminalNode LTEQ() { return getToken(gParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(gParser.GTEQ, 0); }
		public OperatorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_lambdaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(76);
				lambda();
				}
				break;
			case 2:
				{
				_localctx = new Expr_if_elseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				if_else();
				}
				break;
			case 3:
				{
				_localctx = new Expr_valueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				value();
				}
				break;
			case 4:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new Expr_invokeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				lambda_invocation();
				}
				break;
			case 6:
				{
				_localctx = new Expr_letContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				let_expr();
				}
				break;
			case 7:
				{
				_localctx = new Expr_rangeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				range_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(97);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(86);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(87);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(88);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(89);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(90);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(91);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(92);
						_la = _input.LA(1);
						if ( !(_la==OR || _la==AND) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(93);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(95);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GT) | (1L << LT) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(96);
						expr(9);
						}
						break;
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class If_elseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(gParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OBRACE() { return getToken(gParser.OBRACE, 0); }
		public TerminalNode ELSE() { return getToken(gParser.ELSE, 0); }
		public TerminalNode CBRACE() { return getToken(gParser.CBRACE, 0); }
		public If_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterIf_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitIf_else(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitIf_else(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_elseContext if_else() throws RecognitionException {
		If_elseContext _localctx = new If_elseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(IF);
			setState(103);
			expr(0);
			setState(104);
			match(OBRACE);
			setState(105);
			expr(0);
			setState(106);
			match(ELSE);
			setState(107);
			expr(0);
			setState(108);
			match(CBRACE);
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

	public static class TypeContext extends ParserRuleContext {
		public Range_typeContext range_type() {
			return getRuleContext(Range_typeContext.class,0);
		}
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public Lambda_typeContext lambda_type() {
			return getRuleContext(Lambda_typeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RANGE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				range_type();
				}
				break;
			case BASIC_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				basic_type();
				}
				break;
			case OPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				lambda_type();
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

	public static class Basic_typeContext extends ParserRuleContext {
		public TerminalNode BASIC_TYPE() { return getToken(gParser.BASIC_TYPE, 0); }
		public Basic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterBasic_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitBasic_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitBasic_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Basic_typeContext basic_type() throws RecognitionException {
		Basic_typeContext _localctx = new Basic_typeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_basic_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(BASIC_TYPE);
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

	public static class Range_typeContext extends ParserRuleContext {
		public TerminalNode RANGE_NAME() { return getToken(gParser.RANGE_NAME, 0); }
		public TerminalNode OPAR() { return getToken(gParser.OPAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(gParser.CPAR, 0); }
		public Range_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterRange_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitRange_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitRange_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Range_typeContext range_type() throws RecognitionException {
		Range_typeContext _localctx = new Range_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_range_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(RANGE_NAME);
			setState(118);
			match(OPAR);
			setState(119);
			type();
			setState(120);
			match(CPAR);
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

	public static class Range_exprContext extends ParserRuleContext {
		public TerminalNode OBRACE() { return getToken(gParser.OBRACE, 0); }
		public TerminalNode CBRACE() { return getToken(gParser.CBRACE, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(gParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gParser.COMMA, i);
		}
		public Range_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterRange_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitRange_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitRange_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Range_exprContext range_expr() throws RecognitionException {
		Range_exprContext _localctx = new Range_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_range_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(OBRACE);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << STRING) | (1L << BOOL))) != 0)) {
				{
				setState(123);
				value();
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(124);
					match(COMMA);
					setState(125);
					value();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(133);
			match(CBRACE);
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

	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode OPAR() { return getToken(gParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(gParser.CPAR, 0); }
		public TerminalNode OBRACE() { return getToken(gParser.OBRACE, 0); }
		public TerminalNode CBRACE() { return getToken(gParser.CBRACE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(gParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(gParser.ID, i);
		}
		public List<Let_bindingContext> let_binding() {
			return getRuleContexts(Let_bindingContext.class);
		}
		public Let_bindingContext let_binding(int i) {
			return getRuleContext(Let_bindingContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(gParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(gParser.NEWLINE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(gParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gParser.COMMA, i);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitLambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_lambda);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(OPAR);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(136);
				match(ID);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(137);
					match(COMMA);
					setState(138);
					match(ID);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(146);
			match(CPAR);
			setState(147);
			match(OBRACE);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(148);
					let_binding();
					setState(149);
					match(NEWLINE);
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			{
			setState(156);
			expr(0);
			}
			setState(157);
			match(CBRACE);
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

	public static class Lambda_typeContext extends ParserRuleContext {
		public TerminalNode OPAR() { return getToken(gParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(gParser.CPAR, 0); }
		public TerminalNode ARROW() { return getToken(gParser.ARROW, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(gParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gParser.COMMA, i);
		}
		public Lambda_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterLambda_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitLambda_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitLambda_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_typeContext lambda_type() throws RecognitionException {
		Lambda_typeContext _localctx = new Lambda_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lambda_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(OPAR);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BASIC_TYPE) | (1L << OPAR) | (1L << RANGE_NAME))) != 0)) {
				{
				setState(160);
				type();
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(161);
					match(COMMA);
					setState(162);
					type();
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(170);
			match(CPAR);
			setState(171);
			match(ARROW);
			setState(172);
			type();
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

	public static class Lambda_invocationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode OPAR() { return getToken(gParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(gParser.CPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(gParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gParser.COMMA, i);
		}
		public Lambda_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterLambda_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitLambda_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitLambda_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_invocationContext lambda_invocation() throws RecognitionException {
		Lambda_invocationContext _localctx = new Lambda_invocationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lambda_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(ID);
			setState(175);
			match(OPAR);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAR) | (1L << OBRACE) | (1L << IF) | (1L << LET) | (1L << NUMBER) | (1L << ID) | (1L << STRING) | (1L << BOOL))) != 0)) {
				{
				setState(176);
				expr(0);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(177);
					match(COMMA);
					setState(178);
					expr(0);
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(186);
			match(CPAR);
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumberContext extends ValueContext {
		public TerminalNode NUMBER() { return getToken(gParser.NUMBER, 0); }
		public NumberContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends ValueContext {
		public TerminalNode BOOL() { return getToken(gParser.BOOL, 0); }
		public BoolContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ValueContext {
		public TerminalNode STRING() { return getToken(gParser.STRING, 0); }
		public StringContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_value);
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(NUMBER);
				}
				break;
			case BOOL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(BOOL);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				match(STRING);
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

	public static class RangeContext extends ParserRuleContext {
		public List<TerminalNode> CELL_ADDRESS() { return getTokens(gParser.CELL_ADDRESS); }
		public TerminalNode CELL_ADDRESS(int i) {
			return getToken(gParser.CELL_ADDRESS, i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(CELL_ADDRESS);
			setState(194);
			match(T__0);
			setState(195);
			match(CELL_ADDRESS);
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
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00c8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\2\3\2\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\7"+
		"\3\64\n\3\f\3\16\3\67\13\3\5\39\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5B\n"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7V\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7d\n\7"+
		"\f\7\16\7g\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\5\tt\n\t\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u0081\n\f\f\f\16\f"+
		"\u0084\13\f\5\f\u0086\n\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u008e\n\r\f\r\16"+
		"\r\u0091\13\r\5\r\u0093\n\r\3\r\3\r\3\r\3\r\3\r\7\r\u009a\n\r\f\r\16\r"+
		"\u009d\13\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u00a6\n\16\f\16\16\16"+
		"\u00a9\13\16\5\16\u00ab\n\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\7\17\u00b6\n\17\f\17\16\17\u00b9\13\17\5\17\u00bb\n\17\3\17\3\17\3"+
		"\20\3\20\3\20\5\20\u00c2\n\20\3\21\3\21\3\21\3\21\3\21\2\3\f\22\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \2\6\3\2\17\21\3\2\r\16\3\2\5\6\3\2"+
		"\7\f\2\u00d3\2%\3\2\2\2\48\3\2\2\2\6:\3\2\2\2\b>\3\2\2\2\nF\3\2\2\2\f"+
		"U\3\2\2\2\16h\3\2\2\2\20s\3\2\2\2\22u\3\2\2\2\24w\3\2\2\2\26|\3\2\2\2"+
		"\30\u0089\3\2\2\2\32\u00a1\3\2\2\2\34\u00b0\3\2\2\2\36\u00c1\3\2\2\2 "+
		"\u00c3\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&("+
		"\3\2\2\2\'%\3\2\2\2()\7\2\2\3)\3\3\2\2\2*.\5\6\4\2+-\7)\2\2,+\3\2\2\2"+
		"-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/9\3\2\2\2\60.\3\2\2\2\61\65\5\b\5\2\62"+
		"\64\7)\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66"+
		"9\3\2\2\2\67\65\3\2\2\28*\3\2\2\28\61\3\2\2\29\5\3\2\2\2:;\5 \21\2;<\7"+
		"\23\2\2<=\5\26\f\2=\7\3\2\2\2>?\7\36\2\2?A\7#\2\2@B\5\20\t\2A@\3\2\2\2"+
		"AB\3\2\2\2BC\3\2\2\2CD\7\23\2\2DE\5\f\7\2E\t\3\2\2\2FG\7\36\2\2GH\7#\2"+
		"\2HI\7\23\2\2IJ\5\f\7\2JK\7\37\2\2KL\5\f\7\2L\13\3\2\2\2MN\b\7\1\2NV\5"+
		"\30\r\2OV\5\16\b\2PV\5\36\20\2QV\7#\2\2RV\5\34\17\2SV\5\n\6\2TV\5\26\f"+
		"\2UM\3\2\2\2UO\3\2\2\2UP\3\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2"+
		"\2Ve\3\2\2\2WX\f\r\2\2XY\t\2\2\2Yd\5\f\7\16Z[\f\f\2\2[\\\t\3\2\2\\d\5"+
		"\f\7\r]^\f\13\2\2^_\t\4\2\2_d\5\f\7\f`a\f\n\2\2ab\t\5\2\2bd\5\f\7\13c"+
		"W\3\2\2\2cZ\3\2\2\2c]\3\2\2\2c`\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2"+
		"f\r\3\2\2\2ge\3\2\2\2hi\7\31\2\2ij\5\f\7\2jk\7\26\2\2kl\5\f\7\2lm\7\32"+
		"\2\2mn\5\f\7\2no\7\27\2\2o\17\3\2\2\2pt\5\24\13\2qt\5\22\n\2rt\5\32\16"+
		"\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2t\21\3\2\2\2uv\7\4\2\2v\23\3\2\2\2wx\7"+
		" \2\2xy\7\24\2\2yz\5\20\t\2z{\7\25\2\2{\25\3\2\2\2|\u0085\7\26\2\2}\u0082"+
		"\5\36\20\2~\177\7\34\2\2\177\u0081\5\36\20\2\u0080~\3\2\2\2\u0081\u0084"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0085}\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2"+
		"\u0087\u0088\7\27\2\2\u0088\27\3\2\2\2\u0089\u0092\7\24\2\2\u008a\u008f"+
		"\7#\2\2\u008b\u008c\7\34\2\2\u008c\u008e\7#\2\2\u008d\u008b\3\2\2\2\u008e"+
		"\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0093\3\2"+
		"\2\2\u0091\u008f\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\7\25\2\2\u0095\u009b\7\26\2\2\u0096\u0097\5"+
		"\b\5\2\u0097\u0098\7)\2\2\u0098\u009a\3\2\2\2\u0099\u0096\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009e\u009f\5\f\7\2\u009f\u00a0\7\27\2\2\u00a0"+
		"\31\3\2\2\2\u00a1\u00aa\7\24\2\2\u00a2\u00a7\5\20\t\2\u00a3\u00a4\7\34"+
		"\2\2\u00a4\u00a6\5\20\t\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2"+
		"\2\2\u00aa\u00a2\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ad\7\25\2\2\u00ad\u00ae\7\35\2\2\u00ae\u00af\5\20\t\2\u00af\33\3\2"+
		"\2\2\u00b0\u00b1\7#\2\2\u00b1\u00ba\7\24\2\2\u00b2\u00b7\5\f\7\2\u00b3"+
		"\u00b4\7\34\2\2\u00b4\u00b6\5\f\7\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3"+
		"\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00b2\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00bd\7\25\2\2\u00bd\35\3\2\2\2\u00be\u00c2\7!\2\2\u00bf\u00c2"+
		"\7%\2\2\u00c0\u00c2\7$\2\2\u00c1\u00be\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c0\3\2\2\2\u00c2\37\3\2\2\2\u00c3\u00c4\7\"\2\2\u00c4\u00c5\7\3\2"+
		"\2\u00c5\u00c6\7\"\2\2\u00c6!\3\2\2\2\25%.\658AUces\u0082\u0085\u008f"+
		"\u0092\u009b\u00a7\u00aa\u00b7\u00ba\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}