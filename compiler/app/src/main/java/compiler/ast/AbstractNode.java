package compiler.ast;

import java.util.stream.*;

public abstract class AbstractNode {
    public abstract Stream<AbstractNode> children();
}
