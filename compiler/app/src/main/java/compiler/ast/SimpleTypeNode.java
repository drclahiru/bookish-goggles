package compiler.ast;

import java.util.stream.*;

public class SimpleTypeNode extends TypeNode {
    IdentifierNode identifier;

    public Stream<AbstractNode> children() {
        return Stream.of(identifier);
    }

    public SimpleTypeNode identifier(IdentifierNode identifier) {
        this.identifier = identifier;
        return this;
    }
}
