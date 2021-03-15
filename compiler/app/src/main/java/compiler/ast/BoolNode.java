package compiler.ast;

import java.util.stream.*;

public class BoolNode extends ExpressionNode {
    public final boolean value;

    public BoolNode(boolean value) {
        this.value = value;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}