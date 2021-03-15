package compiler.ast;

import java.util.stream.*;

public class IdentifierDeclarationNode extends AbstractNode {
    public IdentifierNode identifier;
    public TypeNode type;

    public IdentifierDeclarationNode(IdentifierNode node) {
        this.identifier = node;
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.identifier, this.type);
    }
}
