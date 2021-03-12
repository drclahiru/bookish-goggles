package compiler.ast;

import java.util.ArrayList;

// shorter/simpler methods of constructing nodes
public class AST {
    public static FunctionNode function() {
        return new FunctionNode();
    }

    public static FunctionInvocationNode invoke(String identifier) {
        return new FunctionInvocationNode().identifier(ident(identifier));
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

    public static IdentifierNode ident(String value) {
        return new IdentifierNode(value);
    }

    public static LetBindingNode let(String identifier) {
        return new LetBindingNode(ident(identifier));
    }

    public static SimpleTypeNode type(String identifier) {
        return new SimpleTypeNode().identifier(ident(identifier));
    }

    public static FunctionTypeNode funcType() {
        return new FunctionTypeNode();
    }

    public static ProgramNode program() {
        return new ProgramNode();
    }

    public static IfElseNode ifElse() {
        return new IfElseNode();
    }

    public static BinaryOperatorNode binOp() {
        return new BinaryOperatorNode();
    }

    public static UnaryOperatorNode unOp() {
        return new UnaryOperatorNode();
    }
}
