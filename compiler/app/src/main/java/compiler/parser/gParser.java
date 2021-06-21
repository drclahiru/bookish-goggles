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
		PLUS=11, MINUS=12, MULT=13, DIV=14, MOD=15, CONS=16, ASSIGN=17, OPAR=18, 
		CPAR=19, OBRACE=20, CBRACE=21, NULL=22, IF=23, ELSE=24, PAR=25, COMMA=26, 
		ARROW=27, LET=28, IN=29, LIST_NAME=30, MATCH=31, NUMBER=32, CELL_ADDRESS=33, 
		ID=34, STRING=35, BOOL=36, TRUE=37, FALSE=38, CHARACTER=39, NEWLINE=40, 
		WS=41;
	public static final int
		RULE_global_scope = 0, RULE_statements = 1, RULE_range_binding = 2, RULE_let_binding = 3, 
		RULE_let_expr = 4, RULE_expr = 5, RULE_if_else = 6, RULE_type = 7, RULE_basic_type = 8, 
		RULE_list_type = 9, RULE_list_expr = 10, RULE_match_expr = 11, RULE_match_expr_branch = 12, 
		RULE_pattern = 13, RULE_lambda = 14, RULE_lambda_type = 15, RULE_lambda_invocation = 16, 
		RULE_value = 17, RULE_range = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"global_scope", "statements", "range_binding", "let_binding", "let_expr", 
			"expr", "if_else", "type", "basic_type", "list_type", "list_expr", "match_expr", 
			"match_expr_branch", "pattern", "lambda", "lambda_type", "lambda_invocation", 
			"value", "range"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", null, "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", 
			"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'::'", "'='", "'('", "')'", 
			"'{'", "'}'", "'null'", "'if'", "'else'", "'\"'", "','", "'->'", "'let'", 
			"'in'", "'List'", "'match'", null, null, null, null, null, "'True'", 
			"'False'", null, "'\r?\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "BASIC_TYPE", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", 
			"LTEQ", "PLUS", "MINUS", "MULT", "DIV", "MOD", "CONS", "ASSIGN", "OPAR", 
			"CPAR", "OBRACE", "CBRACE", "NULL", "IF", "ELSE", "PAR", "COMMA", "ARROW", 
			"LET", "IN", "LIST_NAME", "MATCH", "NUMBER", "CELL_ADDRESS", "ID", "STRING", 
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LET || _la==CELL_ADDRESS) {
				{
				{
				setState(38);
				statements();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
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
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CELL_ADDRESS:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				range_binding();
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(47);
					match(NEWLINE);
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case LET:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				let_binding();
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(54);
					match(NEWLINE);
					}
					}
					setState(59);
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
		public List_exprContext list_expr() {
			return getRuleContext(List_exprContext.class,0);
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
			setState(62);
			range();
			setState(63);
			match(ASSIGN);
			setState(64);
			list_expr();
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
			setState(66);
			match(LET);
			setState(67);
			match(ID);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BASIC_TYPE) | (1L << OPAR) | (1L << LIST_NAME))) != 0)) {
				{
				setState(68);
				type();
				}
			}

			setState(71);
			match(ASSIGN);
			setState(72);
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
			setState(74);
			match(LET);
			setState(75);
			match(ID);
			setState(76);
			match(ASSIGN);
			setState(77);
			expr(0);
			setState(78);
			match(IN);
			setState(79);
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
	public static class Expr_listContext extends ExprContext {
		public List_exprContext list_expr() {
			return getRuleContext(List_exprContext.class,0);
		}
		public Expr_listContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitExpr_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpr_list(this);
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
	public static class Expr_matchContext extends ExprContext {
		public Match_exprContext match_expr() {
			return getRuleContext(Match_exprContext.class,0);
		}
		public Expr_matchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterExpr_match(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitExpr_match(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpr_match(this);
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
		public TerminalNode EQ() { return getToken(gParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(gParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(gParser.LT, 0); }
		public TerminalNode GT() { return getToken(gParser.GT, 0); }
		public TerminalNode LTEQ() { return getToken(gParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(gParser.GTEQ, 0); }
		public TerminalNode AND() { return getToken(gParser.AND, 0); }
		public TerminalNode OR() { return getToken(gParser.OR, 0); }
		public TerminalNode CONS() { return getToken(gParser.CONS, 0); }
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
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_lambdaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(82);
				lambda();
				}
				break;
			case 2:
				{
				_localctx = new Expr_if_elseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				if_else();
				}
				break;
			case 3:
				{
				_localctx = new Expr_valueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				value();
				}
				break;
			case 4:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new Expr_invokeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				lambda_invocation();
				}
				break;
			case 6:
				{
				_localctx = new Expr_letContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				let_expr();
				}
				break;
			case 7:
				{
				_localctx = new Expr_listContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				list_expr();
				}
				break;
			case 8:
				{
				_localctx = new Expr_matchContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(110);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(93);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(96);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(97);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(99);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GT) | (1L << LT) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						{
						setState(102);
						match(AND);
						}
						setState(103);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						{
						setState(105);
						match(OR);
						}
						setState(106);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						{
						setState(108);
						match(CONS);
						}
						setState(109);
						expr(10);
						}
						break;
					}
					} 
				}
				setState(114);
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
			setState(115);
			match(IF);
			setState(116);
			expr(0);
			setState(117);
			match(OBRACE);
			setState(118);
			expr(0);
			setState(119);
			match(ELSE);
			setState(120);
			expr(0);
			setState(121);
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
		public List_typeContext list_type() {
			return getRuleContext(List_typeContext.class,0);
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
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LIST_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				list_type();
				}
				break;
			case BASIC_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				basic_type();
				}
				break;
			case OPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
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
			setState(128);
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

	public static class List_typeContext extends ParserRuleContext {
		public TerminalNode LIST_NAME() { return getToken(gParser.LIST_NAME, 0); }
		public TerminalNode OPAR() { return getToken(gParser.OPAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(gParser.CPAR, 0); }
		public List_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterList_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitList_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitList_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_typeContext list_type() throws RecognitionException {
		List_typeContext _localctx = new List_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_list_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(LIST_NAME);
			setState(131);
			match(OPAR);
			setState(132);
			type();
			setState(133);
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

	public static class List_exprContext extends ParserRuleContext {
		public TerminalNode OBRACE() { return getToken(gParser.OBRACE, 0); }
		public TerminalNode CBRACE() { return getToken(gParser.CBRACE, 0); }
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
		public List_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterList_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitList_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitList_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_exprContext list_expr() throws RecognitionException {
		List_exprContext _localctx = new List_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_list_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(OBRACE);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAR) | (1L << OBRACE) | (1L << IF) | (1L << LET) | (1L << MATCH) | (1L << NUMBER) | (1L << ID) | (1L << STRING) | (1L << BOOL))) != 0)) {
				{
				setState(136);
				expr(0);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(137);
					match(COMMA);
					setState(138);
					expr(0);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(146);
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

	public static class Match_exprContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(gParser.MATCH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OBRACE() { return getToken(gParser.OBRACE, 0); }
		public List<Match_expr_branchContext> match_expr_branch() {
			return getRuleContexts(Match_expr_branchContext.class);
		}
		public Match_expr_branchContext match_expr_branch(int i) {
			return getRuleContext(Match_expr_branchContext.class,i);
		}
		public TerminalNode CBRACE() { return getToken(gParser.CBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(gParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gParser.COMMA, i);
		}
		public Match_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterMatch_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitMatch_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitMatch_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Match_exprContext match_expr() throws RecognitionException {
		Match_exprContext _localctx = new Match_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_match_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(MATCH);
			setState(149);
			expr(0);
			setState(150);
			match(OBRACE);
			setState(151);
			match_expr_branch();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(152);
				match(COMMA);
				setState(153);
				match_expr_branch();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
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

	public static class Match_expr_branchContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(gParser.ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Match_expr_branchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_expr_branch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterMatch_expr_branch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitMatch_expr_branch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitMatch_expr_branch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Match_expr_branchContext match_expr_branch() throws RecognitionException {
		Match_expr_branchContext _localctx = new Match_expr_branchContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_match_expr_branch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			pattern();
			setState(162);
			match(ARROW);
			setState(163);
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

	public static class PatternContext extends ParserRuleContext {
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	 
		public PatternContext() { }
		public void copyFrom(PatternContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Pattern_main_idContext extends PatternContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public Pattern_main_idContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterPattern_main_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitPattern_main_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitPattern_main_id(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Pattern_main_list_consContext extends PatternContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode CONS() { return getToken(gParser.CONS, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public Pattern_main_list_consContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterPattern_main_list_cons(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitPattern_main_list_cons(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitPattern_main_list_cons(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Pattern_main_list_emptyContext extends PatternContext {
		public TerminalNode OBRACE() { return getToken(gParser.OBRACE, 0); }
		public TerminalNode CBRACE() { return getToken(gParser.CBRACE, 0); }
		public Pattern_main_list_emptyContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterPattern_main_list_empty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitPattern_main_list_empty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitPattern_main_list_empty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pattern);
		try {
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new Pattern_main_list_consContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(ID);
				setState(166);
				match(CONS);
				setState(167);
				pattern();
				}
				break;
			case 2:
				_localctx = new Pattern_main_list_emptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(OBRACE);
				setState(169);
				match(CBRACE);
				}
				break;
			case 3:
				_localctx = new Pattern_main_idContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
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
		enterRule(_localctx, 28, RULE_lambda);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(OPAR);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(174);
				match(ID);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(175);
					match(COMMA);
					setState(176);
					match(ID);
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
			setState(185);
			match(OBRACE);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(186);
					let_binding();
					setState(187);
					match(NEWLINE);
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			{
			setState(194);
			expr(0);
			}
			setState(195);
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
		enterRule(_localctx, 30, RULE_lambda_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(OPAR);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BASIC_TYPE) | (1L << OPAR) | (1L << LIST_NAME))) != 0)) {
				{
				setState(198);
				type();
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(199);
					match(COMMA);
					setState(200);
					type();
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(208);
			match(CPAR);
			setState(209);
			match(ARROW);
			setState(210);
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
		enterRule(_localctx, 32, RULE_lambda_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(ID);
			setState(213);
			match(OPAR);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAR) | (1L << OBRACE) | (1L << IF) | (1L << LET) | (1L << MATCH) | (1L << NUMBER) | (1L << ID) | (1L << STRING) | (1L << BOOL))) != 0)) {
				{
				setState(214);
				expr(0);
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(215);
					match(COMMA);
					setState(216);
					expr(0);
					}
					}
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(224);
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
		enterRule(_localctx, 34, RULE_value);
		try {
			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				match(NUMBER);
				}
				break;
			case BOOL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(BOOL);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
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
		enterRule(_localctx, 36, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(CELL_ADDRESS);
			setState(232);
			match(T__0);
			setState(233);
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
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00ee\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\3\3\3\3\7\3\63"+
		"\n\3\f\3\16\3\66\13\3\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\5\3?\n\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\5\5H\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7]\n\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7q\n\7\f\7\16\7t\13"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\5\t\u0081\n\t\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u008e\n\f\f\f\16\f\u0091\13"+
		"\f\5\f\u0093\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u009d\n\r\f\r\16"+
		"\r\u00a0\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00ae\n\17\3\20\3\20\3\20\3\20\7\20\u00b4\n\20\f\20\16\20\u00b7"+
		"\13\20\5\20\u00b9\n\20\3\20\3\20\3\20\3\20\3\20\7\20\u00c0\n\20\f\20\16"+
		"\20\u00c3\13\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u00cc\n\21\f\21"+
		"\16\21\u00cf\13\21\5\21\u00d1\n\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\7\22\u00dc\n\22\f\22\16\22\u00df\13\22\5\22\u00e1\n\22\3\22"+
		"\3\22\3\23\3\23\3\23\5\23\u00e8\n\23\3\24\3\24\3\24\3\24\3\24\2\3\f\25"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\5\3\2\17\21\3\2\r\16\3"+
		"\2\7\f\2\u00fc\2+\3\2\2\2\4>\3\2\2\2\6@\3\2\2\2\bD\3\2\2\2\nL\3\2\2\2"+
		"\f\\\3\2\2\2\16u\3\2\2\2\20\u0080\3\2\2\2\22\u0082\3\2\2\2\24\u0084\3"+
		"\2\2\2\26\u0089\3\2\2\2\30\u0096\3\2\2\2\32\u00a3\3\2\2\2\34\u00ad\3\2"+
		"\2\2\36\u00af\3\2\2\2 \u00c7\3\2\2\2\"\u00d6\3\2\2\2$\u00e7\3\2\2\2&\u00e9"+
		"\3\2\2\2(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-"+
		"+\3\2\2\2./\7\2\2\3/\3\3\2\2\2\60\64\5\6\4\2\61\63\7*\2\2\62\61\3\2\2"+
		"\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65?\3\2\2\2\66\64\3\2\2\2"+
		"\67;\5\b\5\28:\7*\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<?\3\2\2"+
		"\2=;\3\2\2\2>\60\3\2\2\2>\67\3\2\2\2?\5\3\2\2\2@A\5&\24\2AB\7\23\2\2B"+
		"C\5\26\f\2C\7\3\2\2\2DE\7\36\2\2EG\7$\2\2FH\5\20\t\2GF\3\2\2\2GH\3\2\2"+
		"\2HI\3\2\2\2IJ\7\23\2\2JK\5\f\7\2K\t\3\2\2\2LM\7\36\2\2MN\7$\2\2NO\7\23"+
		"\2\2OP\5\f\7\2PQ\7\37\2\2QR\5\f\7\2R\13\3\2\2\2ST\b\7\1\2T]\5\36\20\2"+
		"U]\5\16\b\2V]\5$\23\2W]\7$\2\2X]\5\"\22\2Y]\5\n\6\2Z]\5\26\f\2[]\5\30"+
		"\r\2\\S\3\2\2\2\\U\3\2\2\2\\V\3\2\2\2\\W\3\2\2\2\\X\3\2\2\2\\Y\3\2\2\2"+
		"\\Z\3\2\2\2\\[\3\2\2\2]r\3\2\2\2^_\f\20\2\2_`\t\2\2\2`q\5\f\7\21ab\f\17"+
		"\2\2bc\t\3\2\2cq\5\f\7\20de\f\16\2\2ef\t\4\2\2fq\5\f\7\17gh\f\r\2\2hi"+
		"\7\6\2\2iq\5\f\7\16jk\f\f\2\2kl\7\5\2\2lq\5\f\7\rmn\f\13\2\2no\7\22\2"+
		"\2oq\5\f\7\fp^\3\2\2\2pa\3\2\2\2pd\3\2\2\2pg\3\2\2\2pj\3\2\2\2pm\3\2\2"+
		"\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\r\3\2\2\2tr\3\2\2\2uv\7\31\2\2vw\5\f"+
		"\7\2wx\7\26\2\2xy\5\f\7\2yz\7\32\2\2z{\5\f\7\2{|\7\27\2\2|\17\3\2\2\2"+
		"}\u0081\5\24\13\2~\u0081\5\22\n\2\177\u0081\5 \21\2\u0080}\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\177\3\2\2\2\u0081\21\3\2\2\2\u0082\u0083\7\4\2\2\u0083"+
		"\23\3\2\2\2\u0084\u0085\7 \2\2\u0085\u0086\7\24\2\2\u0086\u0087\5\20\t"+
		"\2\u0087\u0088\7\25\2\2\u0088\25\3\2\2\2\u0089\u0092\7\26\2\2\u008a\u008f"+
		"\5\f\7\2\u008b\u008c\7\34\2\2\u008c\u008e\5\f\7\2\u008d\u008b\3\2\2\2"+
		"\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0093"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\7\27\2\2\u0095\27\3\2\2\2\u0096\u0097\7!\2"+
		"\2\u0097\u0098\5\f\7\2\u0098\u0099\7\26\2\2\u0099\u009e\5\32\16\2\u009a"+
		"\u009b\7\34\2\2\u009b\u009d\5\32\16\2\u009c\u009a\3\2\2\2\u009d\u00a0"+
		"\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a1\u00a2\7\27\2\2\u00a2\31\3\2\2\2\u00a3\u00a4\5\34"+
		"\17\2\u00a4\u00a5\7\35\2\2\u00a5\u00a6\5\f\7\2\u00a6\33\3\2\2\2\u00a7"+
		"\u00a8\7$\2\2\u00a8\u00a9\7\22\2\2\u00a9\u00ae\5\34\17\2\u00aa\u00ab\7"+
		"\26\2\2\u00ab\u00ae\7\27\2\2\u00ac\u00ae\7$\2\2\u00ad\u00a7\3\2\2\2\u00ad"+
		"\u00aa\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\35\3\2\2\2\u00af\u00b8\7\24\2"+
		"\2\u00b0\u00b5\7$\2\2\u00b1\u00b2\7\34\2\2\u00b2\u00b4\7$\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b0\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7\25\2\2\u00bb\u00c1\7\26\2\2\u00bc"+
		"\u00bd\5\b\5\2\u00bd\u00be\7*\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bc\3\2"+
		"\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\5\f\7\2\u00c5\u00c6\7\27"+
		"\2\2\u00c6\37\3\2\2\2\u00c7\u00d0\7\24\2\2\u00c8\u00cd\5\20\t\2\u00c9"+
		"\u00ca\7\34\2\2\u00ca\u00cc\5\20\t\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3"+
		"\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00d0\u00c8\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00d3\7\25\2\2\u00d3\u00d4\7\35\2\2\u00d4\u00d5\5\20\t\2\u00d5"+
		"!\3\2\2\2\u00d6\u00d7\7$\2\2\u00d7\u00e0\7\24\2\2\u00d8\u00dd\5\f\7\2"+
		"\u00d9\u00da\7\34\2\2\u00da\u00dc\5\f\7\2\u00db\u00d9\3\2\2\2\u00dc\u00df"+
		"\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e1\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e3\7\25\2\2\u00e3#\3\2\2\2\u00e4\u00e8\7\"\2\2\u00e5\u00e8"+
		"\7&\2\2\u00e6\u00e8\7%\2\2\u00e7\u00e4\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e6\3\2\2\2\u00e8%\3\2\2\2\u00e9\u00ea\7#\2\2\u00ea\u00eb\7\3\2\2\u00eb"+
		"\u00ec\7#\2\2\u00ec\'\3\2\2\2\27+\64;>G\\pr\u0080\u008f\u0092\u009e\u00ad"+
		"\u00b5\u00b8\u00c1\u00cd\u00d0\u00dd\u00e0\u00e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}