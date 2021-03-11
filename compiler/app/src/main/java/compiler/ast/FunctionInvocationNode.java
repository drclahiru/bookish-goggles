package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class FunctionInvocationNode extends Expression {
    IdentifierNode identifier;
    ArrayList<Expression> arguments;

    public FunctionInvocationNode(IdentifierNode identifier, ArrayList<Expression> arguments) {
        this.identifier = identifier;
        this.arguments = arguments;
    }

    public Stream<AbstractNode> children() {
        return Stream.concat(Stream.of(this.identifier), this.arguments.stream());
    }

    public FunctionInvocationNode addArgument(Expression arg) {
        this.arguments.add(arg);
        return this;
    }
}
