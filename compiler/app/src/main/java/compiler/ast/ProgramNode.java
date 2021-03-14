package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class ProgramNode extends AbstractNode {
    ArrayList<LetBindingNode> bindings = new ArrayList<>();

    public Stream<AbstractNode> children() {
        return this.bindings.stream().map((x) -> (AbstractNode)x);
    }

    public void let(LetBindingNode let) {
        this.bindings.add(let);
    }
}