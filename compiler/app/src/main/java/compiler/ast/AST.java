package compiler.ast;

import java.util.function.Consumer;

// shorter/simpler methods of constructing nodes
public class AST {
    public static FunctionNode function(Consumer<FunctionNode> f) {
        var n = new FunctionNode();
        f.accept(n);
        return n;
    }

    public static FunctionInvocationNode invoke(String name, Consumer<FunctionInvocationNode> f) {
        var n = new FunctionInvocationNode();
        n.identifier = ident(name);
        f.accept(n);
        return n;
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

    public static IdentifierDeclarationNode identDecl(String value) {
        return new IdentifierDeclarationNode(new IdentifierNode(value));
    }

    public static LetBindingNode let(String identifier, Consumer<LetBindingNode> f) {
        var n = new LetBindingNode(ident(identifier));
        f.accept(n);
        return n;
    }

    public static SimpleTypeNode type(SimpleType type) {
        return new SimpleTypeNode(type);
    }

    public static SimpleTypeNode boolType() {
        return new SimpleTypeNode(SimpleType.Bool);
    }

    public static SimpleTypeNode numberType() {
        return new SimpleTypeNode(SimpleType.Number);
    }

    public static SimpleTypeNode stringType() {
        return new SimpleTypeNode(SimpleType.String);
    }

    public static FunctionTypeNode funcType(Consumer<FunctionTypeNode> f) {
        var n = new FunctionTypeNode();
        f.accept(n);
        return n;
    }

    public static VariableTypeNode variableType(int id) {
        return new VariableTypeNode(id);
    }

    public static ProgramNode program(Consumer<ProgramNode> f) {
        var n = new ProgramNode();
        f.accept(n);
        return n;
    }

    public static IfElseNode ifElse(Consumer<IfElseNode> f) {
        var n = new IfElseNode();
        f.accept(n);
        return n;
    }
}
