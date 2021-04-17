package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class NumberNode extends ExpressionNode {
    public final double value;

    public NumberNode(ParserRuleContext source, double value) {
        super(source);
        this.value = value;
        this.type = new SimpleTypeNode(source, SimpleType.Number);
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}