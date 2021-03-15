package compiler.ast;

import java.util.stream.*;

public class IfElseNode extends ExpressionNode {
    public ExpressionNode boolExpr;
    public ExpressionNode trueCase;
    public ExpressionNode elseCase;

    public Stream<AbstractNode> children() {
        return Stream.of(boolExpr, trueCase, elseCase);
    }
}