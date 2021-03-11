package compiler.ast;

import java.util.stream.*;

public class IdentifierNode extends Expression {
    String value;

    public IdentifierNode(String value) {
        this.value = value;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}
