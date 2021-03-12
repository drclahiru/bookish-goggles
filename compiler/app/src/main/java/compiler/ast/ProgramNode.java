package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class ProgramNode extends AbstractNode {
    ArrayList<LetBindingNode> bindings = new ArrayList<>();

    public Stream<AbstractNode> children() {
        return this.bindings.stream().map((x) -> (AbstractNode)x);
    }

    public ProgramNode let(LetBindingNode let) {
        this.bindings.add(let);
        return this;
    }
}