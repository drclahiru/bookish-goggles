package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.RuleContext;

public class IdentifierDeclarationNode extends AbstractNode {
    public IdentifierNode identifier;
    public TypeNode type;

    public IdentifierDeclarationNode(RuleContext source, IdentifierNode node) {
        super(source);
        this.identifier = node;
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.identifier, this.type);
    }
}
