package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class ProgramNode extends AbstractNode {
    ArrayList<BindingNode> bindings;

    public ProgramNode(ArrayList<BindingNode> bindings) {
        this.bindings = bindings;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Stream<AbstractNode> children() {
        return this.bindings.stream().map((x) -> (AbstractNode)x);
    }

    public ProgramNode addBinding(BindingNode binding) {
        this.bindings.add(binding);
        return this;
    }
}