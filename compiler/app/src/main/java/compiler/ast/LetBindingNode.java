package compiler.ast;

import java.util.stream.*;

public class LetBindingNode extends AbstractNode {
    public IdentifierDeclarationNode declaration;
    public ExpressionNode expr;

    public LetBindingNode(IdentifierNode identifier) {
        this.declaration = new IdentifierDeclarationNode(identifier);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.declaration, this.expr);
    }
}