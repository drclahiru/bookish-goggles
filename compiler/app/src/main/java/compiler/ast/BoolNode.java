package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.RuleContext;

public class BoolNode extends ExpressionNode {
    public final boolean value;

    public BoolNode(RuleContext source, boolean value) {
        super(source);
        this.value = value;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}