package compiler.ast;

import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

public class PatternListEmpty extends PatternNode {
    public PatternListEmpty(ParserRuleContext source) {
        super(source);
    }

    @Override
    public PatternListEmpty clone() {
        return this;
    }

    @Override
    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}