package compiler.analysis;

import java.util.*;
import compiler.ast.*;
import compiler.visitor.*;

// find a better name...
public class ClosureResolver extends VisitorVoid {
    Stack<FunctionNode> closures = new Stack<>();

    public void run(ProgramNode n) throws VisitorExceptionAggregate {
        var errors = new Vector<VisitorException>(); 
        for (var b : n.bindings) {
            try {
                visit(b);
            } catch (VisitorException e) {
                errors.add(e);
            }
        }
        if (errors.size() > 0) {
            throw new VisitorExceptionAggregate(errors);
        }
    }
    
    protected void visitFunction(FunctionNode n) throws VisitorException {
        closures.add(n);
        super.visitFunction(n);
        closures.pop();
    }
    protected void visitIdentifier(IdentifierNode n) throws VisitorException {
        if (!closures.empty()) {
            closures.peek().captures.add(n.value);
        }
    }
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
    }
}
