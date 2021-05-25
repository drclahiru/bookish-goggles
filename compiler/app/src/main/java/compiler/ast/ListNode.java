package compiler.ast;

import java.util.stream.*;
import java.util.ArrayList;
import org.antlr.v4.runtime.ParserRuleContext;

public class ListNode extends ExpressionNode {
    public final ArrayList<ExpressionNode> exprs;

    public ListNode(ParserRuleContext source, ArrayList<ExpressionNode> value) {
        super(source);
        this.exprs = value;
    }

    public Stream<AbstractNode> children() {
        return exprs.stream().map(x -> x);
    }

    @Override
    public ListNode clone() {
        var nextExprs = new ArrayList<ExpressionNode>();
        for (var e : exprs) {
            nextExprs.add(e.clone());
        }
        var n = new ListNode(source, nextExprs);
        n.type = type;
        return n;
    }
}