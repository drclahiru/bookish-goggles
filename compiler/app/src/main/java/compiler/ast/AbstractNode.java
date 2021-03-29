package compiler.ast;

import java.util.stream.*;

import org.antlr.v4.runtime.RuleContext;

public abstract class AbstractNode {
    public final RuleContext source;
    public AbstractNode(RuleContext source) {
        this.source = source;
    }
    public abstract Stream<AbstractNode> children();
}
