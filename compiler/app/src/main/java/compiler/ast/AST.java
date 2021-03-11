package compiler.ast;

import java.util.ArrayList;

// shorter/simpler methods of constructing nodes
public class AST {
    public static FunctionNode function() {
        return new FunctionNode(new ArrayList<IdentifierNode>(), new ArrayList<LetBindingNode>(), null);
    }

    public static FunctionInvocationNode invoke(String identifier) {
        return new FunctionInvocationNode(ident(identifier), new ArrayList<Expression>());
    }

    public static BoolNode bool(Boolean value) {
        return new BoolNode(value);
    }

    public static NumberNode number(double value) {
        return new NumberNode(value);
    }

    public static StringNode string(String value) {
        return new StringNode(value);
    }

    public static BinaryOperatorNode add(Expression left, Expression right) {
        return new BinaryOperatorNode(left, Operator.Add, right);
    }

    public static IdentifierNode ident(String value) {
        return new IdentifierNode(value);
    }

    public static LetBindingNode binding(String identifier, Expression expr) {
        return new LetBindingNode(ident(identifier), null, expr);
    }

    public static LetBindingNode binding(String identifier, String type, Expression expr) {
        return new LetBindingNode(ident(identifier), type(type), expr);
    }

    public static LetBindingNode binding(String identifier, TypeNode type, Expression expr) {
        return new LetBindingNode(ident(identifier), type, expr);
    }

    public static SimpleTypeNode type(String identifier) {
        return new SimpleTypeNode(ident(identifier));
    }

    public static FunctionTypeNode funcType(String return_) {
        return new FunctionTypeNode(new ArrayList<IdentifierNode>(), ident(return_));
    }

    public static ProgramNode program() {
        return new ProgramNode(new ArrayList<LetBindingNode>());
    }

    public static IfElseNode ifElse(Expression boolExpr) {
        return new IfElseNode(boolExpr, null, null);
    }

    public static BinaryOperatorNode binOp(Operator op) {
        return new BinaryOperatorNode(null, op, null);
    }

    public static BinaryOperatorNode binOp(Expression left, Operator op, Expression right) {
        return new BinaryOperatorNode(left, op, right);
    }

    public static UnaryOperatorNode unOp(Operator op) {
        return new UnaryOperatorNode(op, null);
    }

    public static UnaryOperatorNode unOp(Operator op, Expression expr) {
        return new UnaryOperatorNode(op, expr);
    }
}
