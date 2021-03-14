package compiler.ast;

import java.util.stream.*;

public class IfElseNode extends Expression {
    Expression boolExpr;
    Expression trueCase;
    Expression elseCase;

    public Stream<AbstractNode> children() {
        return Stream.of(boolExpr, trueCase, elseCase);
    }

    public void expression(Expression boolExpr) {
        this.boolExpr = boolExpr;
    }

    public void caseTrue(Expression trueCase) {
        this.trueCase = trueCase;
    }

    public void caseElse(Expression elseCase) {
        this.elseCase = elseCase;
    }
}