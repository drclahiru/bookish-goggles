package compiler.ast;

import java.util.stream.*;

public abstract class AbstractNode {
    public abstract void accept(Visitor v);

    public Stream<BindingNode> children() {
        return Stream.empty();
    }
}
