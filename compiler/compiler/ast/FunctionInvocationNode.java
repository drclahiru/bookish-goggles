package compiler.ast;

import java.util.ArrayList;

public class FunctionInvocationNode extends Expression {
    IdentifierNode identifier;
    ArrayList<Expression> arguments;

    public FunctionInvocationNode(IdentifierNode identifier, ArrayList<Expression> arguments) {
        this.identifier = identifier;
        this.arguments = arguments;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public FunctionInvocationNode addArgument(Expression arg) {
        this.arguments.add(arg);
        return this;
    }
}
