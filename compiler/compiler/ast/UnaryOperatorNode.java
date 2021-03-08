package compiler.ast;

import java.util.stream.*;

public class UnaryOperatorNode extends Expression {

    Operator operator;
    Expression expr;

    public UnaryOperatorNode(Operator operator, Expression expr) {
        this.operator = operator;
        this.expr = expr;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public UnaryOperatorNode setExpr(Expression expr) {
        this.expr = expr;
        return this;
    }

    public UnaryOperatorNode setOperator(Operator operator) {
        this.operator = operator;
        return this;
    }
}