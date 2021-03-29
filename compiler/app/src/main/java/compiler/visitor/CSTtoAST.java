package compiler.visitor;

import compiler.parser.*;
import compiler.ast.*;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class CSTtoAST extends AbstractParseTreeVisitor<AbstractNode> implements gVisitor<AbstractNode> {
	public ProgramNode visitGlobal_scope(gParser.Global_scopeContext ctx) {
        var x = new ProgramNode(ctx.getRuleContext());
        for (var statementCtx : ctx.statements()) {
            var statement = visit(statementCtx);
            // TODO: handle rangeBinding
            x.bindings.add((LetBindingNode)statement);
        }
        return x;
    }
	public AbstractNode visitStatements(gParser.StatementsContext ctx) {
        return visitChildren(ctx);
    }
	public AbstractNode visitRange_binding(gParser.Range_bindingContext ctx) {
        return visitChildren(ctx);
    }
	public LetBindingNode visitLet_binding(gParser.Let_bindingContext ctx) {
        var id = ctx.ID();
        var idNode = new IdentifierNode(ctx.getRuleContext(), id.getText());
        var letNode = new LetBindingNode(ctx.getRuleContext(), idNode);
        var t = ctx.type();
        if (t != null) {
            letNode.declaration.type = visitType(t);
        }
        letNode.expr = visitExpr(ctx.expr());
        return letNode;
    }
	public ExpressionNode visitExpr_lambda(gParser.Expr_lambdaContext ctx) {
        return visitLambda(ctx.lambda());
    }
	public ExpressionNode visitExpr_invoke(gParser.Expr_invokeContext ctx) {
        return visitLambda_invocation(ctx.lambda_invocation());
    }
	public ExpressionNode visitExpr_value(gParser.Expr_valueContext ctx) {
        return (ExpressionNode)visit(ctx.value());
    }
	public ExpressionNode visitExpr_range(gParser.Expr_rangeContext ctx) {
        return visitRange(ctx.range());
    }
	public ExpressionNode visitExpr_if_else(gParser.Expr_if_elseContext ctx) {
        return visitIf_else(ctx.if_else());
    }
	public IdentifierNode visitId(gParser.IdContext ctx) {
        var id = ctx.ID();
        return new IdentifierNode(ctx.getRuleContext(), id.getText());
    }
	public ExpressionNode visitOperator(gParser.OperatorContext ctx) {
        var x = new FunctionInvocationNode(ctx.getRuleContext());
        var op = ctx.getChild(1);
        x.identifier = new IdentifierNode(ctx.getRuleContext(), op.getText());
        x.arguments.add(visitExpr(ctx.expr(0)));
        x.arguments.add(visitExpr(ctx.expr(1)));
        return x;
    }
	public ExpressionNode visitExpr(gParser.ExprContext ctx) {
        return (ExpressionNode)visit(ctx);
    }
    
	public IfElseNode visitIf_else(gParser.If_elseContext ctx) {
        var t = new IfElseNode(ctx.getRuleContext());
        var exprs = ctx.expr();
        t.boolExpr = visitExpr(exprs.get(0));
        t.trueCase = visitExpr(exprs.get(1));
        t.elseCase = visitExpr(exprs.get(2));
        return t;
    }

	public TypeNode visitType(gParser.TypeContext ctx) {
        return (TypeNode)visitChildren(ctx);
    }
	public SimpleTypeNode visitBasic_type(gParser.Basic_typeContext ctx) {
        var t = ctx.BASIC_TYPE().getText();
        if (t == "String") {
            return new SimpleTypeNode(ctx.getRuleContext(), SimpleType.String);
        } else if (t == "Bool") {
            return new SimpleTypeNode(ctx.getRuleContext(), SimpleType.Bool);
        } else {
            return new SimpleTypeNode(ctx.getRuleContext(), SimpleType.Number);
        }
    }

	public AbstractNode visitRange_type(gParser.Range_typeContext ctx) {
        // TODO: implement
        return visitChildren(ctx);
    }
	public FunctionNode visitLambda(gParser.LambdaContext ctx) {
        var x = new FunctionNode(ctx.getRuleContext());
        for (var id : ctx.ID()) {
            var idNode = new IdentifierNode(ctx.getRuleContext(), id.getText());
            var paramNode = new IdentifierDeclarationNode(ctx.getRuleContext(), idNode);
            x.parameters.add(paramNode);
        }
        for (var b : ctx.let_binding()) {
            x.body.add(visitLet_binding(b));
        }
        x.return_ = visitExpr(ctx.expr());
        return x;
    }
	public FunctionTypeNode visitLambda_type(gParser.Lambda_typeContext ctx) {
        var types = ctx.type();
        var returnType = types.get(types.size() - 1);
        var params = types.subList(0, types.size() - 1);
        var t = new FunctionTypeNode(ctx.getRuleContext());
        for (var p : params) {
            t.parameters.add(visitType(p));
        }
        t.return_ = visitType(returnType);
        return t;
    }
	public ExpressionNode visitLambda_invocation(gParser.Lambda_invocationContext ctx) {
        var invocNode = new FunctionInvocationNode(ctx.getRuleContext());
        var idNode = ctx.ID();
        invocNode.identifier = new IdentifierNode(ctx.getRuleContext(), idNode.getText());
        for (var arg : ctx.expr()) {
            invocNode.arguments.add(visitExpr(arg));
        }
        return invocNode;
    }
	public NumberNode visitNumber(gParser.NumberContext ctx) {
        var n = ctx.NUMBER();
        return new NumberNode(ctx.getRuleContext(), Double.parseDouble(n.getText()));
    }
	public BoolNode visitBool(gParser.BoolContext ctx) {
        var b = ctx.BOOL();
        return new BoolNode(ctx.getRuleContext(), b.getText() == "true");
    }
	public StringNode visitString(gParser.StringContext ctx) {
        var s = ctx.STRING();
        return new StringNode(ctx.getRuleContext(), s.getText());
    }
	public ExpressionNode visitRange(gParser.RangeContext ctx) {
        return new RangeNode(ctx.getRuleContext(),
            ctx.CELL_COL(0).getText(),
            Integer.parseInt(ctx.CELL_ROW(0).getText()),
            ctx.CELL_COL(1).getText(),
            Integer.parseInt(ctx.CELL_ROW(1).getText())
        );
    }
}
