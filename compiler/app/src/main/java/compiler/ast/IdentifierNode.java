package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.RuleContext;

public class IdentifierNode extends ExpressionNode {
    public Identifier value;

    public IdentifierNode(RuleContext source, String name) {
        super(source);
        this.value = new Identifier(name);
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}
