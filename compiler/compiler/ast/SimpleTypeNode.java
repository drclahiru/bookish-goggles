package compiler.ast;

public class SimpleTypeNode extends TypeNode {
    IdentifierNode identifier;

    public SimpleTypeNode(IdentifierNode identifier) {
        this.identifier = identifier;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
