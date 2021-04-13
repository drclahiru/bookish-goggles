package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class IdentifierDeclarationNode extends AbstractNode {
    public IdentifierNode identifier;
    public TypeScheme type;

    public IdentifierDeclarationNode(ParserRuleContext source, IdentifierNode node) {
        super(source);
        this.identifier = node;
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.identifier);
    }
}
