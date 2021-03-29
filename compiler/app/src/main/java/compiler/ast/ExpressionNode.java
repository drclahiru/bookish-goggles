package compiler.ast;

import org.antlr.v4.runtime.RuleContext;

public abstract class ExpressionNode extends AbstractNode {
    public TypeNode inferredType = null;
    public ExpressionNode(RuleContext source) {
        super(source);
    }
}
