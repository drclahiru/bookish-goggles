package compiler.ast;

import java.util.stream.*;
import java.util.ArrayList;
import org.antlr.v4.runtime.ParserRuleContext;

public class RangeNodeExpression extends ExpressionNode {
    public final ArrayList<ExpressionNode> value;

    public RangeNodeExpression(ParserRuleContext source, ArrayList<ExpressionNode> value) {
        super(source);
        this.value = value;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }

    @Override
    public RangeNodeExpression clone() {
        var n = new RangeNodeExpression (source, value);
        n.type = type;
        return n;
    }
}