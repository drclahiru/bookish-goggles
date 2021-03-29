package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.RuleContext;

public class NumberNode extends ExpressionNode {
    public final double value;

    public NumberNode(RuleContext source, double value) {
        super(source);
        this.value = value;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}