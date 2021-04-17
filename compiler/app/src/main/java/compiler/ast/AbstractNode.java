package compiler.ast;

import java.util.stream.*;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class AbstractNode {
    public final ParserRuleContext source;
    public TypeNode type;
    public AbstractNode(ParserRuleContext source) {
        this.source = source;
    }
    public abstract Stream<AbstractNode> children();
}
