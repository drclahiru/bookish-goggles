package compiler.ast;

import java.util.stream.*;

public class LetBindingNode extends AbstractNode {
    IdentifierDeclarationNode identifier;
    Expression expr;

    public LetBindingNode(IdentifierNode identifier) {
        this.identifier = new IdentifierDeclarationNode(identifier);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.identifier, this.expr);
    }

    public LetBindingNode type(TypeNode type) {
        this.identifier.type = type;
        return this;
    }

    public LetBindingNode expression(Expression expr) {
        this.expr = expr;
        return this;
    }
}