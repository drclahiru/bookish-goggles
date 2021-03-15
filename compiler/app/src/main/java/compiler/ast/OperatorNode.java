package compiler.ast;

import java.util.stream.*;

public class OperatorNode extends FunctionInvocationNode {
    public final Operator operator;

    public OperatorNode(Operator operator) {
        this.operator = operator;
        this.identifier = AST.ident(Utility.opToString(operator));
        this.arguments.add(null);
        this.arguments.add(null);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.getLeft(), this.getRight());
    }

    public void left(ExpressionNode left) {
        this.arguments.set(0, left);
    }

    public void right(ExpressionNode right) {
        this.arguments.set(1, right);
    }

    public ExpressionNode getLeft() {
        return this.arguments.get(0);
    }

    public ExpressionNode getRight() {
        return this.arguments.get(1);
    }
}