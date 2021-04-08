package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class LetBindingNode extends AbstractNode {
    public IdentifierDeclarationNode declaration;
    public ExpressionNode expr;

    public LetBindingNode(ParserRuleContext source, IdentifierNode identifier) {
        super(source);
        this.declaration = new IdentifierDeclarationNode(source, identifier);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.declaration, this.expr);
    }
}