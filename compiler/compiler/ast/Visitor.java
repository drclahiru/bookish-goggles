package compiler.ast;

// public interface Visitor {
//     void visit(AbstractNode n);
// }

public interface Visitor {
    default void defaultVisit(AbstractNode n) {
        n.children().filter((x) -> x != null).forEach((x) -> visit(x));
    };
    default void visit(AbstractNode n) {
        if (n instanceof Expression) {
            visit((Expression)n);
        } else if (n instanceof TypeNode) {
            visit((TypeNode)n);
        } else if (n instanceof LetBindingNode) {
            visit((LetBindingNode)n);
        } else if (n instanceof ProgramNode) {
            visit((ProgramNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    };
    default void visit(BinaryOperatorNode n) {
        defaultVisit(n);
    };
    default void visit(LetBindingNode n) {
        defaultVisit(n);
    };
    default void visit(BoolNode n) {
        defaultVisit(n);
    };
    default void visit(Expression n) {
        if (n instanceof BinaryOperatorNode) {
            visit((BinaryOperatorNode)n);
        } else if (n instanceof BoolNode) {
            visit((BoolNode)n);
        } else if (n instanceof FunctionInvocationNode) {
            visit((FunctionInvocationNode)n);
        } else if (n instanceof FunctionNode) {
            visit((FunctionNode)n);
        } else if (n instanceof IdentifierNode) {
            visit((IdentifierNode)n);
        } else if (n instanceof IfElseNode) {
            visit((IfElseNode)n);
        } else if (n instanceof NumberNode) {
            visit((NumberNode)n);
        } else if (n instanceof StringNode) {
            visit((StringNode)n);
        } else if (n instanceof UnaryOperatorNode) {
            visit((UnaryOperatorNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    };
    default void visit(FunctionInvocationNode n) {
        defaultVisit(n);
    };
    default void visit(FunctionNode n) {
        defaultVisit(n);
    };
    default void visit(FunctionTypeNode n) {
        defaultVisit(n);
    };
    default void visit(IdentifierNode n) {
        defaultVisit(n);
    };
    default void visit(IfElseNode n) {
        defaultVisit(n);
    };
    default void visit(NumberNode n) {
        defaultVisit(n);
    };
    default void visit(ProgramNode n) {
        defaultVisit(n);
    };
    default void visit(SimpleTypeNode n) {
        defaultVisit(n);
    };
    default void visit(StringNode n) {
        defaultVisit(n);
    };
    default void visit(TypeNode n) {
        if (n instanceof SimpleTypeNode) {
            visit((SimpleTypeNode)n);
        } else if (n instanceof FunctionTypeNode) {
            visit((FunctionTypeNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    };
    default void visit(UnaryOperatorNode n) {
        defaultVisit(n);
    };
}