package compiler.ast;

import java.util.stream.*;

public class OperatorNode extends FunctionInvocationNode {
    Operator operator;

    public OperatorNode(Operator operator) {
        this.operator = operator;
        this.identifier = AST.ident(Utility.opToString(operator));
        this.arguments.add(null);
        this.arguments.add(null);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.getLeft(), this.getRight());
    }

    public void left(Expression left) {
        this.arguments.set(0, left);
    }

    public void right(Expression right) {
        this.arguments.set(1, right);
    }

    public Expression getLeft() {
        return this.arguments.get(0);
    }

    public Expression getRight() {
        return this.arguments.get(1);
    }
}