package compiler.ast;

public class NumberNode extends Expression {
    double value;

    public NumberNode(double value) {
        this.value = value;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}