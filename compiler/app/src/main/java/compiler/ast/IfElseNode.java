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

    @Override
    public IfElseNode clone() {
        var n = new IfElseNode(source);
        n.type = type;
        n.boolExpr = boolExpr.clone();
        n.trueCase = trueCase.clone();
        n.elseCase = elseCase.clone();
        return n;
    }
}