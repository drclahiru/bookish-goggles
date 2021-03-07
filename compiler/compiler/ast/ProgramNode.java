package compiler.ast;

import java.util.ArrayList;

public class ProgramNode extends AbstractNode {
    ArrayList<BindingNode> bindings;

    public ProgramNode(ArrayList<BindingNode> bindings) {
        this.bindings = bindings;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public ProgramNode addBinding(BindingNode binding) {
        this.bindings.add(binding);
        return this;
    }
}