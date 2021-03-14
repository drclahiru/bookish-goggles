package compiler.ast;

import java.util.stream.*;

public class SimpleTypeNode extends TypeNode {
    final SimpleType type;

    public SimpleTypeNode(SimpleType type) {
        this.type = type;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}
