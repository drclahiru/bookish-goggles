package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class IdentifierNode extends ExpressionNode {
    public Identifier value;

    public IdentifierNode(ParserRuleContext source, String name) {
        super(source);
        this.value = new Identifier(name);
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}
