package compiler.ast;

import java.util.stream.*;

public class IfElseNode extends Expression {
    Expression boolExpr;
    Expression trueCase;
    Expression elseCase;

    public Stream<AbstractNode> children() {
        return Stream.of(boolExpr, trueCase, elseCase);
    }

    public IfElseNode expression(Expression boolExpr) {
        this.boolExpr = boolExpr;
        return this;
    }

    public IfElseNode caseTrue(Expression trueCase) {
        this.trueCase = trueCase;
        return this;
    }

    public IfElseNode caseElse(Expression elseCase) {
        this.elseCase = elseCase;
        return this;
    }
}