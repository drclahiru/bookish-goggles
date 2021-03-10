package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class ProgramNode extends AbstractNode {
    ArrayList<LetBindingNode> bindings;

    public ProgramNode(ArrayList<LetBindingNode> bindings) {
        this.bindings = bindings;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Stream<AbstractNode> children() {
        return this.bindings.stream().map((x) -> (AbstractNode)x);
    }

    public ProgramNode addBinding(LetBindingNode binding) {
        this.bindings.add(binding);
        return this;
    }
}