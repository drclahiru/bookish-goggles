package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class StringNode extends ExpressionNode {
    public final String value;

    public StringNode(ParserRuleContext source, String value) {
        super(source);
        this.value = value;
        this.type = new SimpleTypeNode(source, SimpleType.String);
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}