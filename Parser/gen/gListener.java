// Generated from C:/Users/Jitka/IdeaProjects/untitled\g.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gParser}.
 */
public interface gListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gParser#base_rule}.
	 * @param ctx the parse tree
	 */
	void enterBase_rule(gParser.Base_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#base_rule}.
	 * @param ctx the parse tree
	 */
	void exitBase_rule(gParser.Base_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#code_block}.
	 * @param ctx the parse tree
	 */
	void enterCode_block(gParser.Code_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#code_block}.
	 * @param ctx the parse tree
	 */
	void exitCode_block(gParser.Code_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(gParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(gParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code visitorTest}
	 * labeled alternative in {@link gParser#if_else}.
	 * @param ctx the parse tree
	 */
	void enterVisitorTest(gParser.VisitorTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code visitorTest}
	 * labeled alternative in {@link gParser#if_else}.
	 * @param ctx the parse tree
	 */
	void exitVisitorTest(gParser.VisitorTestContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#lambda}.
	 * @param ctx the parse tree
	 */
	void enterLambda(gParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#lambda}.
	 * @param ctx the parse tree
	 */
	void exitLambda(gParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#range_binding}.
	 * @param ctx the parse tree
	 */
	void enterRange_binding(gParser.Range_bindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#range_binding}.
	 * @param ctx the parse tree
	 */
	void exitRange_binding(gParser.Range_bindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#let_binding}.
	 * @param ctx the parse tree
	 */
	void enterLet_binding(gParser.Let_bindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#let_binding}.
	 * @param ctx the parse tree
	 */
	void exitLet_binding(gParser.Let_bindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#range_bindings}.
	 * @param ctx the parse tree
	 */
	void enterRange_bindings(gParser.Range_bindingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#range_bindings}.
	 * @param ctx the parse tree
	 */
	void exitRange_bindings(gParser.Range_bindingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#let_bindings}.
	 * @param ctx the parse tree
	 */
	void enterLet_bindings(gParser.Let_bindingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#let_bindings}.
	 * @param ctx the parse tree
	 */
	void exitLet_bindings(gParser.Let_bindingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#global_scope}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_scope(gParser.Global_scopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#global_scope}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_scope(gParser.Global_scopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(gParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(gParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#range_type}.
	 * @param ctx the parse tree
	 */
	void enterRange_type(gParser.Range_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#range_type}.
	 * @param ctx the parse tree
	 */
	void exitRange_type(gParser.Range_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#lambda_type}.
	 * @param ctx the parse tree
	 */
	void enterLambda_type(gParser.Lambda_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#lambda_type}.
	 * @param ctx the parse tree
	 */
	void exitLambda_type(gParser.Lambda_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(gParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(gParser.ExprContext ctx);
}