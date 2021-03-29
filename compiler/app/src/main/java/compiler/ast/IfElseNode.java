package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.RuleContext;

public class IfElseNode extends ExpressionNode {
    public ExpressionNode boolExpr;
    public ExpressionNode trueCase;
    public ExpressionNode elseCase;

    public IfElseNode(RuleContext source) {
        super(source);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(boolExpr, trueCase, elseCase);
    }
}