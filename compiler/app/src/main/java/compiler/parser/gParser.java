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
		ARROW=27, LET=28, IN=29, RANGE_NAME=30, BOOL=31, TRUE=32, FALSE=33, NUMBER=34, 
		ID=35, CELL_COL=36, CELL_ROW=37, STRING=38, CHARACTER=39, NEWLINE=40, 
		WS=41;
	public static final int
		RULE_global_scope = 0, RULE_statements = 1, RULE_range_binding = 2, RULE_let_binding = 3, 
		RULE_let_expr = 4, RULE_expr = 5, RULE_if_else = 6, RULE_type = 7, RULE_basic_type = 8, 
		RULE_range_type = 9, RULE_lambda = 10, RULE_lambda_type = 11, RULE_lambda_invocation = 12, 
		RULE_value = 13, RULE_range = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"global_scope", "statements", "range_binding", "let_binding", "let_expr", 
			"expr", "if_else", "type", "basic_type", "range_type", "lambda", "lambda_type", 
			"lambda_invocation", "value", "range"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", null, "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", 
			"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", null, "'='", "'('", "')'", 
			"'{'", "'}'", "'null'", "'if'", "'else'", "'\"'", "','", "'->'", "'let'", 
			"'in'", "'Range'", null, "'true'", "'false'", null, null, null, null, 
			null, null, "'\r?\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "BASIC_TYPE", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", 
			"LTEQ", "PLUS", "MINUS", "MULT", "DIV", "MOD", "OPERATOR", "ASSIGN", 
			"OPAR", "CPAR", "OBRACE", "CBRACE", "NULL", "IF", "ELSE", "PAR", "COMMA", 
			"ARROW", "LET", "IN", "RANGE_NAME", "BOOL", "TRUE", "FALSE", "NUMBER", 
			"ID", "CELL_COL", "CELL_ROW", "STRING", "CHARACTER", "NEWLINE", "WS"
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LET || _la==CELL_COL) {
				{
				{
				setState(30);
				statements();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CELL_COL:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				range_binding();
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(39);
					match(NEWLINE);
					}
					}
					setState(44);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case LET:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				let_binding();
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(46);
					match(NEWLINE);
					}
					}
					setState(51);
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
		public TerminalNode OPAR() { return getToken(gParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(gParser.CPAR, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			range();
			setState(55);
			match(ASSIGN);
			setState(56);
			match(OPAR);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				setState(57);
				value();
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(58);
					match(COMMA);
					setState(59);
					value();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(67);
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
			setState(69);
			match(LET);
			setState(70);
			match(ID);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BASIC_TYPE) | (1L << OPAR) | (1L << RANGE_NAME))) != 0)) {
				{
				setState(71);
				type();
				}
			}

			setState(74);
			match(ASSIGN);
			setState(75);
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
			setState(77);
			match(LET);
			setState(78);
			match(ID);
			setState(79);
			match(ASSIGN);
			setState(80);
			expr(0);
			setState(81);
			match(IN);
			setState(82);
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
	public static class Expr_rangeContext extends ExprContext {
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
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
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_lambdaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(85);
				lambda();
				}
				break;
			case 2:
				{
				_localctx = new Expr_if_elseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				if_else();
				}
				break;
			case 3:
				{
				_localctx = new Expr_valueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				value();
				}
				break;
			case 4:
				{
				_localctx = new Expr_rangeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				range();
				}
				break;
			case 5:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new Expr_invokeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				lambda_invocation();
				}
				break;
			case 7:
				{
				_localctx = new Expr_letContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				let_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(106);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(95);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(96);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(98);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(101);
						_la = _input.LA(1);
						if ( !(_la==OR || _la==AND) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(102);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(104);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GT) | (1L << LT) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(105);
						expr(9);
						}
						break;
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		public List<TerminalNode> OBRACE() { return getTokens(gParser.OBRACE); }
		public TerminalNode OBRACE(int i) {
			return getToken(gParser.OBRACE, i);
		}
		public List<TerminalNode> CBRACE() { return getTokens(gParser.CBRACE); }
		public TerminalNode CBRACE(int i) {
			return getToken(gParser.CBRACE, i);
		}
		public TerminalNode ELSE() { return getToken(gParser.ELSE, 0); }
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
			setState(111);
			match(IF);
			setState(112);
			expr(0);
			setState(113);
			match(OBRACE);
			setState(114);
			expr(0);
			setState(115);
			match(CBRACE);
			setState(116);
			match(ELSE);
			setState(117);
			match(OBRACE);
			setState(118);
			expr(0);
			setState(119);
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
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RANGE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				range_type();
				}
				break;
			case BASIC_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				basic_type();
				}
				break;
			case OPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
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
			setState(126);
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
		public TerminalNode BASIC_TYPE() { return getToken(gParser.BASIC_TYPE, 0); }
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
			setState(128);
			match(RANGE_NAME);
			setState(129);
			match(OPAR);
			setState(130);
			match(BASIC_TYPE);
			setState(131);
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
		enterRule(_localctx, 20, RULE_lambda);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(OPAR);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(134);
				match(ID);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(135);
					match(COMMA);
					setState(136);
					match(ID);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144);
			match(CPAR);
			setState(145);
			match(OBRACE);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(146);
					let_binding();
					setState(147);
					match(NEWLINE);
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			{
			setState(154);
			expr(0);
			}
			setState(155);
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
		enterRule(_localctx, 22, RULE_lambda_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(OPAR);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BASIC_TYPE) | (1L << OPAR) | (1L << RANGE_NAME))) != 0)) {
				{
				setState(158);
				type();
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(159);
					match(COMMA);
					setState(160);
					type();
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(168);
			match(CPAR);
			setState(169);
			match(ARROW);
			setState(170);
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
		enterRule(_localctx, 24, RULE_lambda_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(ID);
			setState(173);
			match(OPAR);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAR) | (1L << IF) | (1L << LET) | (1L << BOOL) | (1L << NUMBER) | (1L << ID) | (1L << CELL_COL) | (1L << STRING))) != 0)) {
				{
				setState(174);
				expr(0);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(175);
					match(COMMA);
					setState(176);
					expr(0);
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(184);
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
		enterRule(_localctx, 26, RULE_value);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(NUMBER);
				}
				break;
			case BOOL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(BOOL);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
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
		public List<TerminalNode> CELL_COL() { return getTokens(gParser.CELL_COL); }
		public TerminalNode CELL_COL(int i) {
			return getToken(gParser.CELL_COL, i);
		}
		public List<TerminalNode> CELL_ROW() { return getTokens(gParser.CELL_ROW); }
		public TerminalNode CELL_ROW(int i) {
			return getToken(gParser.CELL_ROW, i);
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
		enterRule(_localctx, 28, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(CELL_COL);
			setState(192);
			match(CELL_ROW);
			setState(193);
			match(T__0);
			setState(194);
			match(CELL_COL);
			setState(195);
			match(CELL_ROW);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00c8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2\16"+
		"\2%\13\2\3\2\3\2\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\3\3\3\7\3\62\n\3\f"+
		"\3\16\3\65\13\3\5\3\67\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4?\n\4\f\4\16\4B"+
		"\13\4\5\4D\n\4\3\4\3\4\3\5\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7_\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\5\t\177\n\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u008c\n\f\f\f\16\f\u008f\13\f\5\f"+
		"\u0091\n\f\3\f\3\f\3\f\3\f\3\f\7\f\u0098\n\f\f\f\16\f\u009b\13\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\7\r\u00a4\n\r\f\r\16\r\u00a7\13\r\5\r\u00a9\n\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16\u00b4\n\16\f\16\16\16\u00b7"+
		"\13\16\5\16\u00b9\n\16\3\16\3\16\3\17\3\17\3\17\5\17\u00c0\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\2\3\f\21\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36\2\6\3\2\17\21\3\2\r\16\3\2\5\6\3\2\7\f\2\u00d4\2#\3\2\2\2\4\66"+
		"\3\2\2\2\68\3\2\2\2\bG\3\2\2\2\nO\3\2\2\2\f^\3\2\2\2\16q\3\2\2\2\20~\3"+
		"\2\2\2\22\u0080\3\2\2\2\24\u0082\3\2\2\2\26\u0087\3\2\2\2\30\u009f\3\2"+
		"\2\2\32\u00ae\3\2\2\2\34\u00bf\3\2\2\2\36\u00c1\3\2\2\2 \"\5\4\3\2! \3"+
		"\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7\2\2\3\'"+
		"\3\3\2\2\2(,\5\6\4\2)+\7*\2\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2"+
		"-\67\3\2\2\2.,\3\2\2\2/\63\5\b\5\2\60\62\7*\2\2\61\60\3\2\2\2\62\65\3"+
		"\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\66(\3\2"+
		"\2\2\66/\3\2\2\2\67\5\3\2\2\289\5\36\20\29:\7\23\2\2:C\7\24\2\2;@\5\34"+
		"\17\2<=\7\34\2\2=?\5\34\17\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A"+
		"D\3\2\2\2B@\3\2\2\2C;\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7\25\2\2F\7\3\2\2"+
		"\2GH\7\36\2\2HJ\7%\2\2IK\5\20\t\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7\23"+
		"\2\2MN\5\f\7\2N\t\3\2\2\2OP\7\36\2\2PQ\7%\2\2QR\7\23\2\2RS\5\f\7\2ST\7"+
		"\37\2\2TU\5\f\7\2U\13\3\2\2\2VW\b\7\1\2W_\5\26\f\2X_\5\16\b\2Y_\5\34\17"+
		"\2Z_\5\36\20\2[_\7%\2\2\\_\5\32\16\2]_\5\n\6\2^V\3\2\2\2^X\3\2\2\2^Y\3"+
		"\2\2\2^Z\3\2\2\2^[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_n\3\2\2\2`a\f\r\2\2ab"+
		"\t\2\2\2bm\5\f\7\16cd\f\f\2\2de\t\3\2\2em\5\f\7\rfg\f\13\2\2gh\t\4\2\2"+
		"hm\5\f\7\fij\f\n\2\2jk\t\5\2\2km\5\f\7\13l`\3\2\2\2lc\3\2\2\2lf\3\2\2"+
		"\2li\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\r\3\2\2\2pn\3\2\2\2qr\7\31"+
		"\2\2rs\5\f\7\2st\7\26\2\2tu\5\f\7\2uv\7\27\2\2vw\7\32\2\2wx\7\26\2\2x"+
		"y\5\f\7\2yz\7\27\2\2z\17\3\2\2\2{\177\5\24\13\2|\177\5\22\n\2}\177\5\30"+
		"\r\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\21\3\2\2\2\u0080\u0081\7\4\2\2"+
		"\u0081\23\3\2\2\2\u0082\u0083\7 \2\2\u0083\u0084\7\24\2\2\u0084\u0085"+
		"\7\4\2\2\u0085\u0086\7\25\2\2\u0086\25\3\2\2\2\u0087\u0090\7\24\2\2\u0088"+
		"\u008d\7%\2\2\u0089\u008a\7\34\2\2\u008a\u008c\7%\2\2\u008b\u0089\3\2"+
		"\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\25\2\2\u0093\u0099\7\26\2\2\u0094"+
		"\u0095\5\b\5\2\u0095\u0096\7*\2\2\u0096\u0098\3\2\2\2\u0097\u0094\3\2"+
		"\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\5\f\7\2\u009d\u009e\7\27"+
		"\2\2\u009e\27\3\2\2\2\u009f\u00a8\7\24\2\2\u00a0\u00a5\5\20\t\2\u00a1"+
		"\u00a2\7\34\2\2\u00a2\u00a4\5\20\t\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3"+
		"\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00ab\7\25\2\2\u00ab\u00ac\7\35\2\2\u00ac\u00ad\5\20\t\2\u00ad"+
		"\31\3\2\2\2\u00ae\u00af\7%\2\2\u00af\u00b8\7\24\2\2\u00b0\u00b5\5\f\7"+
		"\2\u00b1\u00b2\7\34\2\2\u00b2\u00b4\5\f\7\2\u00b3\u00b1\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b9\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b0\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\7\25\2\2\u00bb\33\3\2\2\2\u00bc\u00c0\7$\2"+
		"\2\u00bd\u00c0\7!\2\2\u00be\u00c0\7(\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\35\3\2\2\2\u00c1\u00c2\7&\2\2\u00c2"+
		"\u00c3\7\'\2\2\u00c3\u00c4\7\3\2\2\u00c4\u00c5\7&\2\2\u00c5\u00c6\7\'"+
		"\2\2\u00c6\37\3\2\2\2\25#,\63\66@CJ^ln~\u008d\u0090\u0099\u00a5\u00a8"+
		"\u00b5\u00b8\u00bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}