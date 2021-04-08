package compiler.ast;

import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class IfElseNode extends ExpressionNode {
    public ExpressionNode boolExpr;
    public ExpressionNode trueCase;
    public ExpressionNode elseCase;

    public IfElseNode(ParserRuleContext source) {
        super(source);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(boolExpr, trueCase, elseCase);
    }
}