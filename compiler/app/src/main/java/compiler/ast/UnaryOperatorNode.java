package compiler.ast;

import java.util.stream.*;

public class UnaryOperatorNode extends Expression {

    Operator operator;
    Expression expr;
    
    public Stream<AbstractNode> children() {
        return Stream.of(this.expr);
    }

    public UnaryOperatorNode expression(Expression expr) {
        this.expr = expr;
        return this;
    }

    public UnaryOperatorNode operator(Operator operator) {
        this.operator = operator;
        return this;
    }
}