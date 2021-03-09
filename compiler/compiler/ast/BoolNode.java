package compiler.ast;

import java.util.stream.*;

public class BoolNode extends Expression {
    boolean value;

    public BoolNode(boolean value) {
        this.value = value;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}