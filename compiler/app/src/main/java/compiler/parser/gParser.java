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
		OR=1, AND=2, EQ=3, NEQ=4, GT=5, LT=6, GTEQ=7, LTEQ=8, PLUS=9, MINUS=10, 
		MULT=11, DIV=12, MOD=13, OPERATOR=14, ASSIGN=15, OPAR=16, CPAR=17, OBRACE=18, 
		CBRACE=19, TRUE=20, FALSE=21, NULL=22, IF=23, ELSE=24, PAR=25, COMMA=26, 
		ARROW=27, LET=28, BASIC_TYPE=29, RANGE_NAME=30, ID=31, CELL_ID=32, BOOL=33, 
		CHARACTER=34, STRING=35, NUMBER=36, RANGE=37, VALUE_TYPE=38, NEWLINE=39, 
		WS=40;
	public static final int
		RULE_base_rule = 0, RULE_code_block = 1, RULE_stat = 2, RULE_if_else = 3, 
		RULE_lambda = 4, RULE_range_binding = 5, RULE_let_binding = 6, RULE_range_bindings = 7, 
		RULE_let_bindings = 8, RULE_global_scope = 9, RULE_type = 10, RULE_range_type = 11, 
		RULE_lambda_type = 12, RULE_expr = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"base_rule", "code_block", "stat", "if_else", "lambda", "range_binding", 
			"let_binding", "range_bindings", "let_bindings", "global_scope", "type", 
			"range_type", "lambda_type", "expr"
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

	public static class Base_ruleContext extends ParserRuleContext {
		public Code_blockContext code_block() {
			return getRuleContext(Code_blockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(gParser.EOF, 0); }
		public Base_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterBase_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitBase_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitBase_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_ruleContext base_rule() throws RecognitionException {
		Base_ruleContext _localctx = new Base_ruleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_base_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			code_block();
			setState(29);
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

	public static class Code_blockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public Code_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterCode_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitCode_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitCode_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Code_blockContext code_block() throws RecognitionException {
		Code_blockContext _localctx = new Code_blockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAR) | (1L << IF) | (1L << LET) | (1L << BASIC_TYPE) | (1L << RANGE_NAME) | (1L << ID) | (1L << RANGE) | (1L << VALUE_TYPE))) != 0)) {
				{
				{
				setState(31);
				stat();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StatContext extends ParserRuleContext {
		public If_elseContext if_else() {
			return getRuleContext(If_elseContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public Range_bindingContext range_binding() {
			return getRuleContext(Range_bindingContext.class,0);
		}
		public Let_bindingContext let_binding() {
			return getRuleContext(Let_bindingContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				if_else();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				lambda();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				range_binding();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				let_binding();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(41);
				expr(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(42);
				type();
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

	public static class If_elseContext extends ParserRuleContext {
		public If_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_else; }
	 
		public If_elseContext() { }
		public void copyFrom(If_elseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VisitorTestContext extends If_elseContext {
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
		public List<If_elseContext> if_else() {
			return getRuleContexts(If_elseContext.class);
		}
		public If_elseContext if_else(int i) {
			return getRuleContext(If_elseContext.class,i);
		}
		public TerminalNode WS() { return getToken(gParser.WS, 0); }
		public VisitorTestContext(If_elseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterVisitorTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitVisitorTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitVisitorTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_elseContext if_else() throws RecognitionException {
		If_elseContext _localctx = new If_elseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_if_else);
		try {
			_localctx = new VisitorTestContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(IF);
			setState(46);
			expr(0);
			setState(47);
			match(OBRACE);
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case RANGE:
			case VALUE_TYPE:
				{
				setState(48);
				expr(0);
				}
				break;
			case IF:
				{
				setState(49);
				if_else();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(52);
			match(CBRACE);
			setState(53);
			match(ELSE);
			setState(54);
			match(OBRACE);
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case RANGE:
			case VALUE_TYPE:
				{
				setState(55);
				expr(0);
				}
				break;
			case IF:
				{
				setState(56);
				if_else();
				}
				break;
			case WS:
				{
				setState(57);
				match(WS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(60);
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
		public TerminalNode NEWLINE() { return getToken(gParser.NEWLINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public If_elseContext if_else() {
			return getRuleContext(If_elseContext.class,0);
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
		enterRule(_localctx, 8, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(OPAR);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(63);
				match(ID);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(64);
					match(COMMA);
					setState(65);
					match(ID);
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(73);
			match(CPAR);
			setState(74);
			match(OBRACE);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LET) {
				{
				{
				setState(75);
				let_binding();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case RANGE:
			case VALUE_TYPE:
				{
				setState(81);
				expr(0);
				}
				break;
			case IF:
				{
				setState(82);
				if_else();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(85);
			match(CBRACE);
			setState(86);
			match(NEWLINE);
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
		public TerminalNode RANGE() { return getToken(gParser.RANGE, 0); }
		public TerminalNode ASSIGN() { return getToken(gParser.ASSIGN, 0); }
		public TerminalNode OPAR() { return getToken(gParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(gParser.CPAR, 0); }
		public List<TerminalNode> VALUE_TYPE() { return getTokens(gParser.VALUE_TYPE); }
		public TerminalNode VALUE_TYPE(int i) {
			return getToken(gParser.VALUE_TYPE, i);
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
		enterRule(_localctx, 10, RULE_range_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(RANGE);
			setState(89);
			match(ASSIGN);
			setState(90);
			match(OPAR);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE_TYPE) {
				{
				setState(91);
				match(VALUE_TYPE);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(92);
					match(COMMA);
					setState(93);
					match(VALUE_TYPE);
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(101);
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
		public TerminalNode OPAR() { return getToken(gParser.OPAR, 0); }
		public TerminalNode BASIC_TYPE() { return getToken(gParser.BASIC_TYPE, 0); }
		public TerminalNode CPAR() { return getToken(gParser.CPAR, 0); }
		public TerminalNode ASSIGN() { return getToken(gParser.ASSIGN, 0); }
		public TerminalNode NEWLINE() { return getToken(gParser.NEWLINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public If_elseContext if_else() {
			return getRuleContext(If_elseContext.class,0);
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
		enterRule(_localctx, 12, RULE_let_binding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(LET);
			setState(104);
			match(ID);
			setState(105);
			match(OPAR);
			setState(106);
			match(BASIC_TYPE);
			setState(107);
			match(CPAR);
			setState(108);
			match(ASSIGN);
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case RANGE:
			case VALUE_TYPE:
				{
				setState(109);
				expr(0);
				}
				break;
			case IF:
				{
				setState(110);
				if_else();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(113);
			match(NEWLINE);
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

	public static class Range_bindingsContext extends ParserRuleContext {
		public List<Range_bindingContext> range_binding() {
			return getRuleContexts(Range_bindingContext.class);
		}
		public Range_bindingContext range_binding(int i) {
			return getRuleContext(Range_bindingContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(gParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(gParser.NEWLINE, i);
		}
		public Range_bindingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_bindings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterRange_bindings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitRange_bindings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitRange_bindings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Range_bindingsContext range_bindings() throws RecognitionException {
		Range_bindingsContext _localctx = new Range_bindingsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_range_bindings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RANGE) {
				{
				{
				setState(115);
				range_binding();
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(116);
					match(NEWLINE);
					}
					}
					setState(119); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Let_bindingsContext extends ParserRuleContext {
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
		public Let_bindingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_bindings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterLet_bindings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitLet_bindings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitLet_bindings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_bindingsContext let_bindings() throws RecognitionException {
		Let_bindingsContext _localctx = new Let_bindingsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_let_bindings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			let_binding();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(127);
				match(NEWLINE);
				setState(128);
				let_binding();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Global_scopeContext extends ParserRuleContext {
		public Range_bindingsContext range_bindings() {
			return getRuleContext(Range_bindingsContext.class,0);
		}
		public Let_bindingsContext let_bindings() {
			return getRuleContext(Let_bindingsContext.class,0);
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
		enterRule(_localctx, 18, RULE_global_scope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			range_bindings();
			setState(135);
			let_bindings();
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
		public TerminalNode BASIC_TYPE() { return getToken(gParser.BASIC_TYPE, 0); }
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
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RANGE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				range_type();
				}
				break;
			case BASIC_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(BASIC_TYPE);
				}
				break;
			case OPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
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
		enterRule(_localctx, 22, RULE_range_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(RANGE_NAME);
			setState(143);
			match(OPAR);
			setState(144);
			match(BASIC_TYPE);
			setState(145);
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

	public static class Lambda_typeContext extends ParserRuleContext {
		public TerminalNode OPAR() { return getToken(gParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(gParser.CPAR, 0); }
		public TerminalNode ARROW() { return getToken(gParser.ARROW, 0); }
		public List<TerminalNode> BASIC_TYPE() { return getTokens(gParser.BASIC_TYPE); }
		public TerminalNode BASIC_TYPE(int i) {
			return getToken(gParser.BASIC_TYPE, i);
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
			setState(147);
			match(OPAR);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BASIC_TYPE) {
				{
				setState(148);
				match(BASIC_TYPE);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(149);
					match(COMMA);
					setState(150);
					match(BASIC_TYPE);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(158);
			match(CPAR);
			setState(159);
			match(ARROW);
			setState(160);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode VALUE_TYPE() { return getToken(gParser.VALUE_TYPE, 0); }
		public TerminalNode RANGE() { return getToken(gParser.RANGE, 0); }
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpr(this);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(163);
				match(ID);
				}
				break;
			case VALUE_TYPE:
				{
				setState(164);
				match(VALUE_TYPE);
				}
				break;
			case RANGE:
				{
				setState(165);
				match(RANGE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(180);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(169);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(170);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(171);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(172);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(173);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(174);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(175);
						_la = _input.LA(1);
						if ( !(_la==OR || _la==AND) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(176);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(177);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(178);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GT) | (1L << LT) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(179);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00bc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\7\3#\n\3\f\3\16"+
		"\3&\13\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4.\n\4\3\5\3\5\3\5\3\5\3\5\5\5\65\n"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5=\n\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6E\n\6\f"+
		"\6\16\6H\13\6\5\6J\n\6\3\6\3\6\3\6\7\6O\n\6\f\6\16\6R\13\6\3\6\3\6\5\6"+
		"V\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7a\n\7\f\7\16\7d\13\7\5\7"+
		"f\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\br\n\b\3\b\3\b\3\t\3\t"+
		"\6\tx\n\t\r\t\16\ty\7\t|\n\t\f\t\16\t\177\13\t\3\n\3\n\3\n\7\n\u0084\n"+
		"\n\f\n\16\n\u0087\13\n\3\13\3\13\3\13\3\f\3\f\3\f\5\f\u008f\n\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u009a\n\16\f\16\16\16\u009d\13"+
		"\16\5\16\u009f\n\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00a9"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u00b7\n\17\f\17\16\17\u00ba\13\17\3\17\2\3\34\20\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\2\6\3\2\r\17\3\2\13\f\3\2\3\4\3\2\5\n\2\u00ca\2\36\3\2"+
		"\2\2\4$\3\2\2\2\6-\3\2\2\2\b/\3\2\2\2\n@\3\2\2\2\fZ\3\2\2\2\16i\3\2\2"+
		"\2\20}\3\2\2\2\22\u0080\3\2\2\2\24\u0088\3\2\2\2\26\u008e\3\2\2\2\30\u0090"+
		"\3\2\2\2\32\u0095\3\2\2\2\34\u00a8\3\2\2\2\36\37\5\4\3\2\37 \7\2\2\3 "+
		"\3\3\2\2\2!#\5\6\4\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\5\3\2"+
		"\2\2&$\3\2\2\2\'.\5\b\5\2(.\5\n\6\2).\5\f\7\2*.\5\16\b\2+.\5\34\17\2,"+
		".\5\26\f\2-\'\3\2\2\2-(\3\2\2\2-)\3\2\2\2-*\3\2\2\2-+\3\2\2\2-,\3\2\2"+
		"\2.\7\3\2\2\2/\60\7\31\2\2\60\61\5\34\17\2\61\64\7\24\2\2\62\65\5\34\17"+
		"\2\63\65\5\b\5\2\64\62\3\2\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66\67\7\25"+
		"\2\2\678\7\32\2\28<\7\24\2\29=\5\34\17\2:=\5\b\5\2;=\7*\2\2<9\3\2\2\2"+
		"<:\3\2\2\2<;\3\2\2\2=>\3\2\2\2>?\7\25\2\2?\t\3\2\2\2@I\7\22\2\2AF\7!\2"+
		"\2BC\7\34\2\2CE\7!\2\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GJ\3\2\2"+
		"\2HF\3\2\2\2IA\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\23\2\2LP\7\24\2\2MO\5\16"+
		"\b\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QU\3\2\2\2RP\3\2\2\2SV\5\34"+
		"\17\2TV\5\b\5\2US\3\2\2\2UT\3\2\2\2VW\3\2\2\2WX\7\25\2\2XY\7)\2\2Y\13"+
		"\3\2\2\2Z[\7\'\2\2[\\\7\21\2\2\\e\7\22\2\2]b\7(\2\2^_\7\34\2\2_a\7(\2"+
		"\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2cf\3\2\2\2db\3\2\2\2e]\3\2\2"+
		"\2ef\3\2\2\2fg\3\2\2\2gh\7\23\2\2h\r\3\2\2\2ij\7\36\2\2jk\7!\2\2kl\7\22"+
		"\2\2lm\7\37\2\2mn\7\23\2\2nq\7\21\2\2or\5\34\17\2pr\5\b\5\2qo\3\2\2\2"+
		"qp\3\2\2\2rs\3\2\2\2st\7)\2\2t\17\3\2\2\2uw\5\f\7\2vx\7)\2\2wv\3\2\2\2"+
		"xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{u\3\2\2\2|\177\3\2\2\2}{\3\2"+
		"\2\2}~\3\2\2\2~\21\3\2\2\2\177}\3\2\2\2\u0080\u0085\5\16\b\2\u0081\u0082"+
		"\7)\2\2\u0082\u0084\5\16\b\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\23\3\2\2\2\u0087\u0085\3\2\2"+
		"\2\u0088\u0089\5\20\t\2\u0089\u008a\5\22\n\2\u008a\25\3\2\2\2\u008b\u008f"+
		"\5\30\r\2\u008c\u008f\7\37\2\2\u008d\u008f\5\32\16\2\u008e\u008b\3\2\2"+
		"\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2\2\2\u008f\27\3\2\2\2\u0090\u0091"+
		"\7 \2\2\u0091\u0092\7\22\2\2\u0092\u0093\7\37\2\2\u0093\u0094\7\23\2\2"+
		"\u0094\31\3\2\2\2\u0095\u009e\7\22\2\2\u0096\u009b\7\37\2\2\u0097\u0098"+
		"\7\34\2\2\u0098\u009a\7\37\2\2\u0099\u0097\3\2\2\2\u009a\u009d\3\2\2\2"+
		"\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009e\u0096\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\7\23\2\2\u00a1\u00a2\7\35\2\2\u00a2\u00a3\7\37\2\2\u00a3\33\3\2"+
		"\2\2\u00a4\u00a5\b\17\1\2\u00a5\u00a9\7!\2\2\u00a6\u00a9\7(\2\2\u00a7"+
		"\u00a9\7\'\2\2\u00a8\u00a4\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2"+
		"\2\2\u00a9\u00b8\3\2\2\2\u00aa\u00ab\f\t\2\2\u00ab\u00ac\t\2\2\2\u00ac"+
		"\u00b7\5\34\17\n\u00ad\u00ae\f\b\2\2\u00ae\u00af\t\3\2\2\u00af\u00b7\5"+
		"\34\17\t\u00b0\u00b1\f\7\2\2\u00b1\u00b2\t\4\2\2\u00b2\u00b7\5\34\17\b"+
		"\u00b3\u00b4\f\6\2\2\u00b4\u00b5\t\5\2\2\u00b5\u00b7\5\34\17\7\u00b6\u00aa"+
		"\3\2\2\2\u00b6\u00ad\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6\u00b3\3\2\2\2\u00b7"+
		"\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\35\3\2\2"+
		"\2\u00ba\u00b8\3\2\2\2\26$-\64<FIPUbeqy}\u0085\u008e\u009b\u009e\u00a8"+
		"\u00b6\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}