package compiler.ast;

import java.util.stream.*;

public class StringNode extends ExpressionNode {
    public final String value;

    public StringNode(String value) {
        this.value = value;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}