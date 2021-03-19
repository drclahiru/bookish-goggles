package compiler.visitor;

import compiler.ast.*;
import java.util.*;
import java.util.function.Consumer;
import java.io.OutputStream;

public class InferredTypePrinter extends PrettyPrinter {
    public InferredTypePrinter(OutputStream out) {
        super(out);
    }

    public void run(AbstractNode n) {
        visit(n);
    }

    @Override
    protected void visitExpression(ExpressionNode node) {
        wrapped(x -> {
            super.visitExpression(node);
            print(" ");
            visit(node.inferredType);
        });
    }

    @Override
    protected void visitOperator(OperatorNode node) {
        visit(node.getLeft());
        wrapped(x -> {
            visit(node.identifier);
            print(" ");
            visit(node.inferredType);
        });
        visit(node.getRight());
    }

    void wrapped(Consumer f) {
        print("[");
        f.accept(null);
        print("]");
    }
}