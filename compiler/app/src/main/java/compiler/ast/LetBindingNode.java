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

    @Override
    public LetBindingNode clone() {
        var n = new LetBindingNode(source, declaration.identifier);
        n.type = type;
        n.declaration = declaration.clone();
        n.expr = expr.clone();
        return n;
    }
}