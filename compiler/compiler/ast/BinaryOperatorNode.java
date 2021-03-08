package compiler.ast;

public class BinaryOperatorNode extends Expression {

    Expression left;
    Expression right;
    Operator operator;

    public BinaryOperatorNode(Expression left, Operator operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public BinaryOperatorNode setLeft(Expression left) {
        this.left = left;
        return this;
    }

    public BinaryOperatorNode setOperator(Operator operator) {
        this.operator = operator;
        return this;
    }

    public BinaryOperatorNode setRight(Expression right) {
        this.right = right;
        return this;
    }
}