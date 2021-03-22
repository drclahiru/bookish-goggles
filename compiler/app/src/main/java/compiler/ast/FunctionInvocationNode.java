package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class FunctionInvocationNode extends ExpressionNode {
    public IdentifierNode identifier;
    public final ArrayList<ExpressionNode> arguments = new ArrayList<>();

    public Stream<AbstractNode> children() {
        return Stream.concat(Stream.of(this.identifier), this.arguments.stream());
    }

    public boolean isOperator() {
        return arguments.size() == 2 && identifier.value.name.matches("^[^[a-z]].*");
    }
}
