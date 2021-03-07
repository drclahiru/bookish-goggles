package compiler.ast;

public class AdditionNode extends Expression {
    Expression left;
    Expression right;

    public AdditionNode(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}