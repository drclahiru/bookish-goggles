package compiler.ast;

import java.util.stream.*;

public class IdentifierNode extends ExpressionNode {
    public Identifier value;

    public IdentifierNode(String name) {
        this.value = new Identifier(name);
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}
