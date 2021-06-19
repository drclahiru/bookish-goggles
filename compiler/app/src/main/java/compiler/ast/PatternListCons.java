package compiler.ast;

import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

public class PatternListCons extends PatternNode {
    public final PatternNode left;
    public final PatternNode right;
    public PatternListCons(ParserRuleContext source, PatternNode left, PatternNode right) {
        super(source);
        this.left = left;
        this.right = right;
    }

    @Override
    public PatternListCons clone() {
        return this;
    }

    @Override
    public Stream<AbstractNode> children() {
        return Stream.concat(left.children(), right.children());
    }
}