package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class BoolNode extends ExpressionNode {
    public final boolean value;

    public BoolNode(ParserRuleContext source, boolean value) {
        super(source);
        this.value = value;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}