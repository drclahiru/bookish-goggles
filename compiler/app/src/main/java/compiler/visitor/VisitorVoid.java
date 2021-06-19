package compiler.visitor;

import compiler.ast.*;

public abstract class VisitorVoid {
    protected void defaultVisit(AbstractNode n) throws VisitorException {
        for (var x : (Iterable<AbstractNode>) n.children().filter((x) -> x != null)::iterator) {
            visit(x);
        }
    }
    public void visit(AbstractNode n) throws VisitorException {
        if (n == null) {
        } else if (n instanceof ExpressionNode) {
            visitExpression((ExpressionNode)n);
        } else if (n instanceof TypeNode) {
            visitType((TypeNode)n);
        } else if (n instanceof PatternNode) {
            visitPattern((PatternNode)n);
        } else if (n instanceof LetBindingNode) {
            visitLetBinding((LetBindingNode)n);
        } else if (n instanceof IdentifierDeclarationNode) {
            visitIdentifierDeclaration((IdentifierDeclarationNode)n);
        } else if (n instanceof ProgramNode) {
            visitProgram((ProgramNode)n);
        } else if (n instanceof MatchBranchNode) {
            visitMatchBranchExpr((MatchBranchNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    }
    protected void visitLetBinding(LetBindingNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitLetExpression(LetExpressionNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitBool(BoolNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitExpression(ExpressionNode n) throws VisitorException {
        if (n instanceof BoolNode) {
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
        } else if (n instanceof RangeNode) {
            visitRange((RangeNode)n);   
        } else if (n instanceof ListNode) {
            visitList((ListNode)n); 
        } else if (n instanceof LetExpressionNode) {
            visitLetExpression((LetExpressionNode)n);
        } else if (n instanceof MatchNode) {
            visitMatch((MatchNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    }
    protected void visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitFunction(FunctionNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitFunctionType(FunctionTypeNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitIdentifier(IdentifierNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitIfElse(IfElseNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitNumber(NumberNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitProgram(ProgramNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitSimpleType(SimpleTypeNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitString(StringNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitType(TypeNode n) throws VisitorException {
        if (n == null) {
        } else if (n instanceof SimpleTypeNode) {
            visitSimpleType((SimpleTypeNode)n);
        } else if (n instanceof FunctionTypeNode) {
            visitFunctionType((FunctionTypeNode)n);
        } else if (n instanceof VariableTypeNode) {
            visitVariableType((VariableTypeNode)n);
        } else if (n instanceof ListTypeNode) {
            visitListType((ListTypeNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    }
    protected void visitRange(RangeNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitList(ListNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitMatch(MatchNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitVariableType(VariableTypeNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitListType(ListTypeNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitPattern(PatternNode n) throws VisitorException {
        if (n instanceof PatternVarNode) {
            visitPatternVar((PatternVarNode)n);
        } else if (n instanceof PatternListCons) {
            visitPatternListCons((PatternListCons)n);
        } else if (n instanceof PatternListEmpty) {
            visitPatternListEmpty((PatternListEmpty)n);
        } else {
            throw new Error("Unexpected pattern: " + n);
        }
    }
    protected void visitMatchBranchExpr(MatchBranchNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitPatternVar(PatternVarNode n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitPatternListEmpty(PatternListEmpty n) throws VisitorException {
        defaultVisit(n);
    }
    protected void visitPatternListCons(PatternListCons n) throws VisitorException {
        defaultVisit(n);
    }
}