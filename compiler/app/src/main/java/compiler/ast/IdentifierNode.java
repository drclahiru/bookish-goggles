package compiler.ast;

import java.util.stream.*;

public class IdentifierNode extends Expression {
    Identifier identifier;

    public IdentifierNode(String value) {
        this.identifier = new Identifier(value);
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}
