package compiler.ast;

import java.util.stream.Stream;
import org.antlr.v4.runtime.ParserRuleContext;

public class LetExpressionNode extends ExpressionNode {
    public IdentifierDeclarationNode declaration;
    public ExpressionNode expr;
    public ExpressionNode next;

    public LetExpressionNode(ParserRuleContext source, IdentifierNode identifier) {
        super(source);
        this.declaration = new IdentifierDeclarationNode(source, identifier);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.declaration, this.expr);
    }
}
