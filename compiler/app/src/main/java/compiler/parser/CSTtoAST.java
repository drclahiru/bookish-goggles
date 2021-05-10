package compiler.parser;

import compiler.ast.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class CSTtoAST extends AbstractParseTreeVisitor<AbstractNode> implements gVisitor<AbstractNode> {
    @Override
	public ProgramNode visitGlobal_scope(gParser.Global_scopeContext ctx) {
        var x = new ProgramNode(ctx);
        for (var statementCtx : ctx.statements()) {
            var statement = visit(statementCtx);
            if (statement instanceof LetBindingNode) {
                x.bindings.add((LetBindingNode)statement);
            } else if (statement instanceof RangeBindingNode) {
                x.rangeBindings.add((RangeBindingNode)statement);
            }
        }
        return x;
    }
    @Override
	public AbstractNode visitStatements(gParser.StatementsContext ctx) {
        return visitChildren(ctx);
    }
    @Override
	public AbstractNode visitRange_binding(gParser.Range_bindingContext ctx) {
        var rangeBinding = new RangeBindingNode(ctx, visitRange(ctx.range()));
        rangeBinding.expr = visitRange_expr(ctx.range_expr());
        return rangeBinding;
    }
    @Override
	public LetBindingNode visitLet_binding(gParser.Let_bindingContext ctx) {
        var id = ctx.ID();
        var idNode = new IdentifierNode(ctx, id.getText());
        var letNode = new LetBindingNode(ctx, idNode);
        var t = ctx.type();
        if (t != null) {
            letNode.declaration.typeScheme = new TypeScheme(visitType(t));
        }
        letNode.expr = visitExpr(ctx.expr());
        return letNode;
    }
    @Override
    public ExpressionNode visitLet_expr(gParser.Let_exprContext ctx) {
        var id = ctx.ID();
        var idNode = new IdentifierNode(ctx, id.getText());
        var letExpr = new LetExpressionNode(ctx, idNode);
        letExpr.expr = visitExpr(ctx.expr(0));
        letExpr.next = visitExpr(ctx.expr(1));
        return letExpr;
    }
    @Override
	public ExpressionNode visitExpr_lambda(gParser.Expr_lambdaContext ctx) {
        return visitLambda(ctx.lambda());
    }
    @Override
	public ExpressionNode visitExpr_invoke(gParser.Expr_invokeContext ctx) {
        return visitLambda_invocation(ctx.lambda_invocation());
    }
	public ExpressionNode visitExpr_value(gParser.Expr_valueContext ctx) {
        return (ExpressionNode)visit(ctx.value());
    }
    @Override
	public ExpressionNode visitExpr_range(gParser.Expr_rangeContext ctx) {
        return visitRange_expr(ctx.range_expr());
    }
    @Override
    public RangeNodeExpression visitRange_expr(gParser.Range_exprContext ctx) {
        var smth = new ArrayList<ExpressionNode>();
        for (var arg : ctx.value()) {
            smth.add((ExpressionNode)visit(arg));
        }
        return new RangeNodeExpression(ctx, smth);
    }
    @Override
	public ExpressionNode visitExpr_if_else(gParser.Expr_if_elseContext ctx) {
        return visitIf_else(ctx.if_else());
    }
    @Override
    public ExpressionNode visitExpr_let(gParser.Expr_letContext ctx) {
        return visitLet_expr(ctx.let_expr());
    }
    @Override
	public IdentifierNode visitId(gParser.IdContext ctx) {
        var id = ctx.ID();
        return new IdentifierNode(ctx, id.getText());
    }
    @Override
	public ExpressionNode visitOperator(gParser.OperatorContext ctx) {
        var x = new FunctionInvocationNode(ctx);
        var op = ctx.getChild(1);
        x.identifier = new IdentifierNode(ctx, op.getText());
        x.arguments.add(visitExpr(ctx.expr(0)));
        x.arguments.add(visitExpr(ctx.expr(1)));
        return x;
    }
	public ExpressionNode visitExpr(gParser.ExprContext ctx) {

        return (ExpressionNode)visit(ctx);
    }
    @Override
	public IfElseNode visitIf_else(gParser.If_elseContext ctx) {
        var t = new IfElseNode(ctx);
        var exprs = ctx.expr();
        t.boolExpr = visitExpr(exprs.get(0));
        t.trueCase = visitExpr(exprs.get(1));
        t.elseCase = visitExpr(exprs.get(2));
        return t;
    }
    @Override
	public TypeNode visitType(gParser.TypeContext ctx) {
        return (TypeNode)visitChildren(ctx);
    }
    @Override
	public SimpleTypeNode visitBasic_type(gParser.Basic_typeContext ctx) {
        var t = ctx.BASIC_TYPE().getText();
        if (t.equals("String")) {
            return new SimpleTypeNode(ctx, SimpleType.String);
        } else if (t.equals("Bool")) {
            return new SimpleTypeNode(ctx, SimpleType.Bool);
        } else if (t.equals("Number")) {
            return new SimpleTypeNode(ctx, SimpleType.Number);
        } else {
            throw new Error("Unexpected type: " + t);
        }
    }
    @Override
	public AbstractNode visitRange_type(gParser.Range_typeContext ctx) {
        // TODO: implement
        return visitChildren(ctx);
    }
    @Override
	public FunctionNode visitLambda(gParser.LambdaContext ctx) {
        var x = new FunctionNode(ctx);
        for (var id : ctx.ID()) {
            var idNode = new IdentifierNode(ctx, id.getText());
            var paramNode = new IdentifierDeclarationNode(ctx, idNode);
            x.parameters.add(paramNode);
        }
        x.return_ = visitExpr(ctx.expr());
        return x;
    }
    @Override
	public FunctionTypeNode visitLambda_type(gParser.Lambda_typeContext ctx) {
        var types = ctx.type();
        var returnType = types.get(types.size() - 1);
        var params = types.subList(0, types.size() - 1);
        var t = new FunctionTypeNode(ctx);
        for (var p : params) {
            t.parameters.add(visitType(p));
        }
        t.return_ = visitType(returnType);
        return t;
    }
    @Override
	public ExpressionNode visitLambda_invocation(gParser.Lambda_invocationContext ctx) {
        var invocNode = new FunctionInvocationNode(ctx);
        var idNode = ctx.ID();
        invocNode.identifier = new IdentifierNode(ctx, idNode.getText());
        for (var arg : ctx.expr()) {
            invocNode.arguments.add(visitExpr(arg));
        }
        return invocNode;
    }
    @Override
	public NumberNode visitNumber(gParser.NumberContext ctx) {
        var n = ctx.NUMBER();
        return new NumberNode(ctx, Double.parseDouble(n.getText()));
    }
    @Override
	public BoolNode visitBool(gParser.BoolContext ctx) {
        var b = ctx.BOOL();
        return new BoolNode(ctx, b.getText().equals("true"));
    }
    @Override
	public StringNode visitString(gParser.StringContext ctx) {
        var s = ctx.STRING();
        return new StringNode(ctx, s.getText());
    }
    @Override
	public RangeNode visitRange(gParser.RangeContext ctx) {
        //System.out.println(ctx.CELL_ADDRESS(0).getText());

        Pattern pattern = Pattern.compile("([A-Z]+)(\\d+)");
        Matcher start = pattern.matcher(ctx.CELL_ADDRESS(0).getText());
        Matcher end = pattern.matcher(ctx.CELL_ADDRESS(1).getText());



        if(start.find() && end.find()) {
            var col1 = start.group(1);
            var row1 = start.group(2);
            var col2 = end.group(1);
            var row2 = end.group(2);
            return new RangeNode(ctx,col1, Integer.parseInt(row1), col2, Integer.parseInt(row2));
        } else {
            throw new Error("The range for the type 'Range' is not provided correctly");
        }
    }
}
