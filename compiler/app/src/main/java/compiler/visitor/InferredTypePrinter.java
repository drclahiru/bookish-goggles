package compiler.visitor;

import compiler.ast.*;
import java.io.OutputStream;

public class InferredTypePrinter extends PrettyPrinter {
    public InferredTypePrinter(OutputStream out) {
        super(out);
    }

    public void run(AbstractNode n) {
        try {
            visit(n);
        } catch (VisitorException ex) {
            System.out.println("error in InferredTypePrinter: " + ex.message);
        }
    }

    @Override
    protected void visitExpression(ExpressionNode node) throws VisitorException {
        print("[");
        super.visitExpression(node);
        print(" ");
        visit(node.inferredType);
        print("]");
    }
}