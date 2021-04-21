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
        return Stream.of(this.declaration, this.expr, this.next);
    }

    @Override
    public LetExpressionNode clone() {
        var n = new LetExpressionNode(source, declaration.identifier);
        n.type = type;
        n.declaration = declaration.clone();
        n.expr = expr.clone();
        n.next = next.clone();
        return n;
    }
}
