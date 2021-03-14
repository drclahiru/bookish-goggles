package compiler.ast;

public abstract class Visitor {
    protected void defaultVisit(AbstractNode n) {
        n.children().filter((x) -> x != null).forEach((x) -> visit(x));
    }
    protected void visit(AbstractNode n) {
        if (n == null) {
        } else if (n instanceof Expression) {
            visitExpression((Expression)n);
        } else if (n instanceof TypeNode) {
            visitType((TypeNode)n);
        } else if (n instanceof LetBindingNode) {
            visitLetBinding((LetBindingNode)n);
        } else if (n instanceof IdentifierDeclarationNode) {
            visitIdentifierDeclaration((IdentifierDeclarationNode)n);
        } else if (n instanceof ProgramNode) {
            visitProgram((ProgramNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    }
    protected void visitOperator(OperatorNode n) {
        defaultVisit(n);
    }
    protected void visitLetBinding(LetBindingNode n) {
        defaultVisit(n);
    }
    protected void visitBool(BoolNode n) {
        defaultVisit(n);
    }
    protected void visitExpression(Expression n) {
        if (n instanceof OperatorNode) {
            visitOperator((OperatorNode)n);
        } else if (n instanceof BoolNode) {
            visitBool((BoolNode)n);
        } else if (n instanceof FunctionInvocationNode) {
            visitFunctionInvocation((FunctionInvocationNode)n);
        } else if (n instanceof FunctionNode) {
            visitFunction((FunctionNode)n);
        } else if (n instanceof IdentifierNode) {
            visitIdentifier((IdentifierNode)n);
        } else if (n instanceof IfElseNode) {
            visitIfElse((IfElseNode)n);
        } else if (n instanceof NumberNode) {
            visitNumber((NumberNode)n);
        } else if (n instanceof StringNode) {
            visitString((StringNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    }
    protected void visitFunctionInvocation(FunctionInvocationNode n) {
        defaultVisit(n);
    }
    protected void visitFunction(FunctionNode n) {
        defaultVisit(n);
    }
    protected void visitFunctionType(FunctionTypeNode n) {
        defaultVisit(n);
    }
    protected void visitIdentifier(IdentifierNode n) {
        defaultVisit(n);
    }
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) {
        defaultVisit(n);
    }
    protected void visitIfElse(IfElseNode n) {
        defaultVisit(n);
    }
    protected void visitNumber(NumberNode n) {
        defaultVisit(n);
    }
    protected void visitProgram(ProgramNode n) {
        defaultVisit(n);
    }
    protected void visitSimpleType(SimpleTypeNode n) {
        defaultVisit(n);
    }
    protected void visitString(StringNode n) {
        defaultVisit(n);
    }
    protected void visitType(TypeNode n) {
        if (n == null) {
        } else if (n instanceof SimpleTypeNode) {
            visitSimpleType((SimpleTypeNode)n);
        } else if (n instanceof FunctionTypeNode) {
            visitFunctionType((FunctionTypeNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    }
}