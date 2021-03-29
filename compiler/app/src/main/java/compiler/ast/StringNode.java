package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.RuleContext;

public class StringNode extends ExpressionNode {
    public final String value;

    public StringNode(RuleContext source, String value) {
        super(source);
        this.value = value;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}