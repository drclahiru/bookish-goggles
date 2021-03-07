package compiler.ast;

public class BoolNode extends Expression {
    boolean value;

    public BoolNode(boolean value) {
        this.value = value;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}