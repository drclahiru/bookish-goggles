package compiler.ast;

import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

public class MatchBranchNode extends AbstractNode {
    public PatternNode pattern;
    public ExpressionNode expr;

    public MatchBranchNode(ParserRuleContext source) {
        super(source);
    }

    @Override
    public MatchBranchNode clone() {
        var node = new MatchBranchNode(source);
        node.pattern = pattern.clone();
        node.expr = expr.clone();
        node.type = type;
        return node;
    }

    @Override
    public Stream<AbstractNode> children() {
        return Stream.of(pattern, expr);
    }
}