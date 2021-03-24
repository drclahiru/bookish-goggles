package compiler.visitor;

import compiler.ast.*;
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

    void wrapped(Consumer<Object> f) {
        print("[");
        f.accept(null);
        print("]");
    }
}