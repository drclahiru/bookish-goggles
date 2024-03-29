package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class FunctionInvocationNode extends ExpressionNode {
    public IdentifierNode identifier;
    public final ArrayList<ExpressionNode> arguments = new ArrayList<>();

    public FunctionInvocationNode(ParserRuleContext source) {
        super(source);
    }

    public Stream<AbstractNode> children() {
        return Stream.concat(Stream.of(this.identifier), this.arguments.stream());
    }

    public boolean isOperator() {
        return arguments.size() == 2 && identifier.value.name.matches("^[^[a-z_]].*");
    }

    @Override
    public FunctionInvocationNode clone() {
        var n = new FunctionInvocationNode(source);
        n.type = type;
        n.identifier = identifier.clone();
        for (var arg : arguments) {
            n.arguments.add(arg.clone());
        }
        return n;
    }
}
