package compiler.ast;

import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

public class PatternListCons extends PatternNode {
    public final PatternNode head;
    public final PatternNode tail;
    public PatternListCons(ParserRuleContext source, PatternNode left, PatternNode right) {
        super(source);
        this.head = left;
        this.tail = right;
    }

    @Override
    public PatternListCons clone() {
        return this;
    }

    @Override
    public Stream<AbstractNode> children() {
        return Stream.of(head, tail);
    }
}