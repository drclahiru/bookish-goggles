package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class ProgramNode extends AbstractNode {
    public final ArrayList<LetBindingNode> bindings = new ArrayList<>();
    public final ArrayList<RangeBindingNode> rangeBindings = new ArrayList<>();

    public ProgramNode(ParserRuleContext source) {
        super(source);
    }

    public Stream<AbstractNode> children() {
        return Stream.concat(
            this.bindings.stream().map((x) -> (AbstractNode)x),
            this.rangeBindings.stream().map((x) -> (AbstractNode)x)
        );
    }

    @Override
    public ProgramNode clone() {
        var n = new ProgramNode(source);
        n.type = type;
        for (var b : bindings) {
            n.bindings.add(b.clone());
        }
        for (var b : rangeBindings) {
            n.rangeBindings.add(b.clone());
        }
        return n;
    }
}