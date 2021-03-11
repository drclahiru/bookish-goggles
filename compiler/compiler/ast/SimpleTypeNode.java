package compiler.ast;

import java.util.stream.*;

public class SimpleTypeNode extends TypeNode {
    IdentifierNode identifier;

    public SimpleTypeNode(IdentifierNode identifier) {
        this.identifier = identifier;
    }

    public Stream<AbstractNode> children() {
        return Stream.of(identifier);
    }
}
