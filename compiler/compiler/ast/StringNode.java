package compiler.ast;

import java.util.stream.*;

public class StringNode extends Expression {
    String value;

    public StringNode(String value) {
        this.value = value;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}