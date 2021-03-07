package compiler.ast;

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
}