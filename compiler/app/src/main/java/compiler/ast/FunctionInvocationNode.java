package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class FunctionInvocationNode extends Expression {
    IdentifierNode identifier;
    ArrayList<Expression> arguments = new ArrayList<>();

    public Stream<AbstractNode> children() {
        return Stream.concat(Stream.of(this.identifier), this.arguments.stream());
    }

    public FunctionInvocationNode identifier(IdentifierNode id) {
        this.identifier = id;
        return this;
    }

    public FunctionInvocationNode argument(Expression arg) {
        this.arguments.add(arg);
        return this;
    }
}
