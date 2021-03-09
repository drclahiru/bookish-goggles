package compiler.ast;

import java.util.stream.*;

public class SimpleTypeNode extends TypeNode {
    IdentifierNode identifier;

    public SimpleTypeNode(IdentifierNode identifier) {
        this.identifier = identifier;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(identifier);
    }
}
