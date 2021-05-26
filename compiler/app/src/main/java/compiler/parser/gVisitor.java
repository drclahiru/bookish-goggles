// Generated from app/src/main/java/compiler/g.g4 by ANTLR 4.9.2

package compiler.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gParser#global_scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_scope(gParser.Global_scopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(gParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#range_binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange_binding(gParser.Range_bindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#let_binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_binding(gParser.Let_bindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#let_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_expr(gParser.Let_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_lambda}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_lambda(gParser.Expr_lambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_invoke}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_invoke(gParser.Expr_invokeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_list}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(gParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_let}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_let(gParser.Expr_letContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_value}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_value(gParser.Expr_valueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_if_else}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_if_else(gParser.Expr_if_elseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(gParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code operator}
	 * labeled alternative in {@link gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(gParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#if_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_else(gParser.If_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(gParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#basic_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasic_type(gParser.Basic_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#list_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_type(gParser.List_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#list_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_expr(gParser.List_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(gParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#lambda_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_type(gParser.Lambda_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#lambda_invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_invocation(gParser.Lambda_invocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link gParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(gParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link gParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(gParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link gParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(gParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(gParser.RangeContext ctx);
}