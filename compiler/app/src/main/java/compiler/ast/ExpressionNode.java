package compiler.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class ExpressionNode extends AbstractNode {
    public ExpressionNode(ParserRuleContext source) {
        super(source);
    }
}
