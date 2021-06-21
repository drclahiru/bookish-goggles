package compiler.ast;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

public class MatchNode extends ExpressionNode {
    public ExpressionNode expr;
    public ArrayList<MatchBranchNode> patterns = new ArrayList<>();

    public MatchNode(ParserRuleContext source) {
        super(source);
    }

    @Override
    public Stream<AbstractNode> children() {
        return Stream.concat(expr.children(), patterns.stream().flatMap(x -> x.children()));
    }

    @Override
    public MatchNode clone() {
        var n = new MatchNode(source);
        n.expr = expr.clone();
        for (var p : patterns) {
            n.patterns.add(p.clone());
        }
        n.type = type;
        return n;
    }
}
