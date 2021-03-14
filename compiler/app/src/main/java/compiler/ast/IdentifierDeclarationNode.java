package compiler.ast;

import java.util.stream.*;

public class IdentifierDeclarationNode extends AbstractNode {
    IdentifierNode identifier;
    TypeNode type;

    public IdentifierDeclarationNode(IdentifierNode node) {
        this.identifier = node;
    }

    public void type(TypeNode type) {
        this.type = type;
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.identifier, this.type);
    }
}
