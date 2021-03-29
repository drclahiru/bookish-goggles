package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;
import org.antlr.v4.runtime.RuleContext;

public class ProgramNode extends AbstractNode {
    public final ArrayList<LetBindingNode> bindings = new ArrayList<>();

    public ProgramNode(RuleContext source) {
        super(source);
    }

    public Stream<AbstractNode> children() {
        return this.bindings.stream().map((x) -> (AbstractNode)x);
    }
}