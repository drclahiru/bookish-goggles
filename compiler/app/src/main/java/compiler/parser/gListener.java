// Generated from app/src/main/java/compiler/g.g4 by ANTLR 4.9.2

package compiler.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gParser}.
 */
public interface gListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link gParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(gParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(gParser.StatementsContext ctx);
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
	 * Enter a parse tree produced by the {@code expr_lambda}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_lambda(gParser.Expr_lambdaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_lambda}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_lambda(gParser.Expr_lambdaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_invoke}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_invoke(gParser.Expr_invokeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_invoke}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_invoke(gParser.Expr_invokeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_value}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_value(gParser.Expr_valueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_value}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_value(gParser.Expr_valueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_if_else}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_if_else(gParser.Expr_if_elseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_if_else}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_if_else(gParser.Expr_if_elseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_range}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_range(gParser.Expr_rangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_range}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_range(gParser.Expr_rangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(gParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(gParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code operator}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOperator(gParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operator}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOperator(gParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#if_else}.
	 * @param ctx the parse tree
	 */
	void enterIf_else(gParser.If_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#if_else}.
	 * @param ctx the parse tree
	 */
	void exitIf_else(gParser.If_elseContext ctx);
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
	 * Enter a parse tree produced by {@link gParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void enterBasic_type(gParser.Basic_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void exitBasic_type(gParser.Basic_typeContext ctx);
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
	 * Enter a parse tree produced by {@link gParser#lambda_invocation}.
	 * @param ctx the parse tree
	 */
	void enterLambda_invocation(gParser.Lambda_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#lambda_invocation}.
	 * @param ctx the parse tree
	 */
	void exitLambda_invocation(gParser.Lambda_invocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link gParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumber(gParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link gParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumber(gParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link gParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBool(gParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link gParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBool(gParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link gParser#value}.
	 * @param ctx the parse tree
	 */
	void enterString(gParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link gParser#value}.
	 * @param ctx the parse tree
	 */
	void exitString(gParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(gParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(gParser.RangeContext ctx);
}