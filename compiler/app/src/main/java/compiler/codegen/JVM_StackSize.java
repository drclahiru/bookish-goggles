package compiler.codegen;

import java.util.HashSet;

import compiler.IdentifierContext;
import compiler.ast.*;
import compiler.visitor.*;

class JVM_StackSize extends VisitorVoid {
	IdentifierContext idCtx;
    HashSet<Identifier> globalIds;
    int currentStack = 0;
    int maxStack = 0;

	public JVM_StackSize(IdentifierContext idCtx, HashSet<Identifier> globalIds) {
		this.idCtx = idCtx;
        this.globalIds = globalIds;
	}

    public int run(ExpressionNode n) {
        try {
            visit(n);
            return maxStack;
        }
        catch (VisitorException e) {
            return 0;
        }
    }

    void stackSize(int n) {
        currentStack += n;
        maxStack = Math.max(maxStack, currentStack);
    }

    protected void visitLetExpression(LetExpressionNode n) throws VisitorException {
        visit(n.expr);
        visit(n.next);
    }
    protected void visitBool(BoolNode n) throws VisitorException {
        stackSize(1);
    }
    protected void visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
        visit(n.identifier);
        for (var x : n.arguments) {
            visit(x);
        }
        stackSize(-n.arguments.size());
    }
    protected void visitIdentifier(IdentifierNode n) throws VisitorException {
        var type = idCtx.get(n.value).type;
        var construct = globalIds.contains(n.value) && type instanceof FunctionTypeNode;
        
        if (construct) {
            stackSize(2);
            stackSize(-1);
        } else {
            stackSize(1);
        }
    }
    protected void visitIfElse(IfElseNode n) throws VisitorException {
        visit(n.boolExpr);
        stackSize(-1);
        var startStack = currentStack;
        visit(n.trueCase);
        currentStack = startStack;
        visit(n.elseCase);
    }
    protected void visitNumber(NumberNode n) throws VisitorException {
        stackSize(2);
        stackSize(-1);
    }
    protected void visitString(StringNode n) throws VisitorException {
        stackSize(1);
    }
    protected void visitRange(RangeNode n) throws VisitorException {
        throw new Error("todo");
    }
    protected void visitList(ListNode n) throws VisitorException {
        throw new Error("todo");
    }
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
    protected void visitLetBinding(LetBindingNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
    protected void visitFunction(FunctionNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
}