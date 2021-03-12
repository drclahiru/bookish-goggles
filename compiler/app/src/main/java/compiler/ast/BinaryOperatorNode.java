package compiler.ast;

import java.util.stream.*;

public class BinaryOperatorNode extends Expression {
    Expression left;
    Expression right;
    Operator operator;

    public Stream<AbstractNode> children() {
        return Stream.of(this.left, this.right);
    }

    public BinaryOperatorNode left(Expression left) {
        this.left = left;
        return this;
    }

    public BinaryOperatorNode operator(Operator operator) {
        this.operator = operator;
        return this;
    }

    public BinaryOperatorNode right(Expression right) {
        this.right = right;
        return this;
    }
}