package compiler.ast;

import java.util.stream.*;

public class IdentifierDeclarationNode extends AbstractNode {
    IdentifierNode identifier;
    TypeNode type;

    public IdentifierDeclarationNode(IdentifierNode node) {
        this.identifier = node;
    }

    public IdentifierDeclarationNode type(TypeNode type) {
        this.type = type;
        return this;
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.identifier, this.type);
    }
}
