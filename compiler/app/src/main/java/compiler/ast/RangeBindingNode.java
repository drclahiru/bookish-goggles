package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class RangeBindingNode extends AbstractNode {
    public RangeNode range;
    public RangeNodeExpression expr;

    public RangeBindingNode(ParserRuleContext source, RangeNode range) {
        super(source);
        this.range = range;
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.range, this.expr);
    }
    public boolean validate() {
    	var length = range.endRow-range.startRow;
    	var ln = expr.value.size();
    	
    	return length+1 == ln;
    }

    @Override
    public RangeBindingNode clone() {
        var n = new RangeBindingNode(source, range);
        n.type = type;
        n.range = range.clone();
        n.expr = expr.clone();
        return n;
    }
}