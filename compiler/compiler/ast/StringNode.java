package compiler.ast;

public class StringNode extends Expression {
    String value;

    public StringNode(String value) {
        this.value = value;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}