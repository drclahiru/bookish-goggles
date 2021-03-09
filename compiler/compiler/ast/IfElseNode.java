package compiler.ast;

import java.util.stream.*;

public class IfElseNode extends Expression {
    Expression boolExpr;
    Expression trueCase;
    Expression elseCase;

    public IfElseNode(Expression boolExpr, Expression trueCase, Expression elseCase) {
        this.boolExpr = boolExpr;
        this.trueCase = trueCase;
        this.elseCase = elseCase;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(boolExpr, trueCase, elseCase);
    }

    public IfElseNode setBoolExpr(Expression boolExpr) {
        this.boolExpr = boolExpr;
        return this;
    }

    public IfElseNode setTrueCase(Expression trueCase) {
        this.trueCase = trueCase;
        return this;
    }

    public IfElseNode setElseCase(Expression elseCase) {
        this.elseCase = elseCase;
        return this;
    }
}