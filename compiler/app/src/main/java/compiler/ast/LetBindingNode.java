package compiler.ast;

import java.util.stream.*;

public class LetBindingNode extends AbstractNode {
    IdentifierDeclarationNode declaration;
    Expression expr;

    public LetBindingNode(IdentifierNode identifier) {
        this.declaration = new IdentifierDeclarationNode(identifier);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.declaration, this.expr);
    }

    public void type(TypeNode type) {
        this.declaration.type = type;
    }

    public void expression(Expression expr) {
        this.expr = expr;
    }
}