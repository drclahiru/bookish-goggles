package compiler.ast;

import java.util.stream.*;
import java.util.ArrayList;
import org.antlr.v4.runtime.ParserRuleContext;

public class RangeNodeExpression extends ExpressionNode {

    public final RangeNode rangeNode;
    public final ArrayList<ExpressionNode> value;

    public RangeNodeExpression(ParserRuleContext source, RangeNode rangeNode, ArrayList<ExpressionNode> value) {
        super(source);
        this.rangeNode = rangeNode;
        this.value = value;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }

    @Override
    public RangeNodeExpression clone() {
        var n = new RangeNodeExpression (source, rangeNode, value);
        n.type = type;
        return n;
    }
}