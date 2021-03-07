package compiler.ast;

import java.util.ArrayList;

// shorter/simpler methods of constructing nodes
public class AST {
    public static FunctionNode function() {
        return new FunctionNode(new ArrayList<IdentifierNode>(), new ArrayList<BindingNode>(), null);
    }

    public static FunctionInvocationNode invoke(String identifier) {
        return new FunctionInvocationNode(ident(identifier), new ArrayList<Expression>());
    }

    public static NumberNode number(double value) {
        return new NumberNode(value);
    }

    public static Expression add(Expression left, Expression right) {
        return new AdditionNode(left, right);
    }

    public static IdentifierNode ident(String value) {
        return new IdentifierNode(value);
    }

    public static BindingNode binding(String identifier, Expression expr) {
        return new BindingNode(ident(identifier), null, expr);
    }

    public static BindingNode binding(String identifier, String type, Expression expr) {
        return new BindingNode(ident(identifier), type(type), expr);
    }

    public static BindingNode binding(String identifier, TypeNode type, Expression expr) {
        return new BindingNode(ident(identifier), type, expr);
    }

    public static SimpleTypeNode type(String identifier) {
        return new SimpleTypeNode(ident(identifier));
    }

    public static FunctionTypeNode funcType(String return_) {
        return new FunctionTypeNode(new ArrayList<IdentifierNode>(), ident(return_));
    }

    public static ProgramNode program() {
        return new ProgramNode(new ArrayList<BindingNode>());
    }
}
