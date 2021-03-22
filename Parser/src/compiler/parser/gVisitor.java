// Generated from F:/AAU2ndSemester/Project2/bookish-goggles/Parser\g.g4 by ANTLR 4.9.1

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
	 * Visit a parse tree produced by {@link gParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(gParser.StatContext ctx);
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
	 * Visit a parse tree produced by {@link gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(gParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code visitorTest}
	 * labeled alternative in {@link gParser#if_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisitorTest(gParser.VisitorTestContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(gParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#range_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange_type(gParser.Range_typeContext ctx);
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
	 * Visit a parse tree produced by {@link gParser#value_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_type(gParser.Value_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#basic_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasic_type(gParser.Basic_typeContext ctx);
}