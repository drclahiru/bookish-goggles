package compiler.ast;

public class IdentifierNode extends Expression {
    String value;

    public IdentifierNode(String value) {
        this.value = value;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
