package compiler.ast;

import java.util.*;
import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class FunctionNode extends ExpressionNode {
    public final ArrayList<IdentifierDeclarationNode> parameters = new ArrayList<>();
    public ExpressionNode return_;

    public FunctionNode(ParserRuleContext source) {
        super(source);
    }

    public Stream<AbstractNode> children() {
        return Stream.concat(this.parameters.stream(), Stream.of(this.return_));
    }

    @Override
    public FunctionNode clone() {
        var n = new FunctionNode(source);
        n.type = type;
        n.return_ = return_.clone();
        for (var param : parameters) {
            n.parameters.add(param.clone());
        }
        return n;
    }
}
