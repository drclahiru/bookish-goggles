package compiler.ast;

import java.util.stream.*;

public class BindingNode extends AbstractNode {
    IdentifierNode identifier;
    TypeNode type;
    Expression expr;

    public BindingNode(IdentifierNode identifier, TypeNode type, Expression expr) {
        this.identifier = identifier;
        this.type = type;
        this.expr = expr;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Stream<AbstractNode> children() {
        return Stream.of(this.identifier, this.type, this.expr);
    }
}