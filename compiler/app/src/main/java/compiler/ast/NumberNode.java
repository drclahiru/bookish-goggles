package compiler.ast;

import java.util.stream.*;

public class NumberNode extends Expression {
    double value;

    public NumberNode(double value) {
        this.value = value;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}