package compiler.visitor;

import compiler.ast.*;

public abstract class VisitorT<T> {
    public T visit(AbstractNode n) throws VisitorException {
        if (n == null) {
            return null;
        } else if (n instanceof ExpressionNode) {
            return visitExpression((ExpressionNode)n);
        } else if (n instanceof LetBindingNode) {
            return visitLetBinding((LetBindingNode)n);
        } else if (n instanceof IdentifierDeclarationNode) {
            return visitIdentifierDeclaration((IdentifierDeclarationNode)n);
        } else if (n instanceof ProgramNode) {
            return visitProgram((ProgramNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    }
    protected T visitExpression(ExpressionNode n) throws VisitorException {
        if (n instanceof BoolNode) {
            return visitBool((BoolNode)n);
        } else if (n instanceof FunctionInvocationNode) {
            return visitFunctionInvocation((FunctionInvocationNode)n);
        } else if (n instanceof FunctionNode) {
            return visitFunction((FunctionNode)n);
        } else if (n instanceof IdentifierNode) {
            return visitIdentifier((IdentifierNode)n);
        } else if (n instanceof IfElseNode) {
            return visitIfElse((IfElseNode)n);
        } else if (n instanceof NumberNode) {
            return visitNumber((NumberNode)n);
        } else if (n instanceof StringNode) {
            return visitString((StringNode)n);
        } else if (n instanceof RangeNode) {
            return visitRange((RangeNode)n);  
        } else if (n instanceof ListNode) {
            return visitList((ListNode)n);  
        } else if (n instanceof LetExpressionNode) {
            return visitLetExpression((LetExpressionNode)n);
        } else {
            throw new Error("Unexpected type: " + n);
        }
    }
    protected abstract T visitLetBinding(LetBindingNode n)  throws VisitorException;
    protected abstract T visitLetExpression(LetExpressionNode n)  throws VisitorException;
    protected abstract T visitBool(BoolNode n)  throws VisitorException;
    protected abstract T visitFunctionInvocation(FunctionInvocationNode n)  throws VisitorException;
    protected abstract T visitFunction(FunctionNode n)  throws VisitorException;
    protected abstract T visitIdentifier(IdentifierNode n)  throws VisitorException;
    protected abstract T visitIdentifierDeclaration(IdentifierDeclarationNode n)  throws VisitorException;
    protected abstract T visitIfElse(IfElseNode n)  throws VisitorException;
    protected abstract T visitNumber(NumberNode n)  throws VisitorException;
    protected abstract T visitProgram(ProgramNode n)  throws VisitorException;
    protected abstract T visitString(StringNode n)  throws VisitorException;
    protected abstract T visitRange(RangeNode n)  throws VisitorException;
    protected abstract T visitList(ListNode n)  throws VisitorException;
}