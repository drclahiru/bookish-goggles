package compiler.analysis;

import java.util.*;

import compiler.ast.*;
import compiler.visitor.*;

public class ClosureResolver extends VisitorVoid {
    Set<Identifier> ignores;
    Set<Identifier> captures;
    Set<Identifier> params;
    boolean shallow;

    public ClosureResolver(Set<Identifier> ignores) {
        this.ignores = ignores;
        this.shallow = false;
    }
    public ClosureResolver(Set<Identifier> ignores, boolean shallow) {
        this.ignores = ignores;
        this.shallow = shallow;
    }

    public Set<Identifier> run(ExpressionNode n) {
        captures = new HashSet<>();
        params = new HashSet<>();
        try {
            visitExpression(n);
        } catch (VisitorException e) {}
        captures.removeAll(params);
        return captures;
    }
    
    @Override
    protected void visitFunction(FunctionNode n) throws VisitorException {
        for (var p : n.parameters) {
            params.add(p.identifier.value);
        }
        if (!shallow) {
            visit(n.return_);
        }
    }
    @Override
    protected void visitLetExpression(LetExpressionNode n) throws VisitorException {
        if (!shallow) {
            visit(n.expr);
        }
        visit(n.next);
    }
    @Override
    protected void visitIdentifier(IdentifierNode n) throws VisitorException {
        if (!ignores.contains(n.value)){
            captures.add(n.value);
        }
    }
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
    }
}
