package compiler.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class PatternNode extends AbstractNode {
    public PatternNode(ParserRuleContext source) {
        super(source);
    }

    @Override
    public abstract PatternNode clone();
}