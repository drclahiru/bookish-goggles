package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class FunctionNode extends Expression {
    ArrayList<IdentifierNode> parameters;
    ArrayList<LetBindingNode> body;
    Expression return_;

    public FunctionNode(ArrayList<IdentifierNode> parameters, ArrayList<LetBindingNode> body, Expression return_) {
        this.parameters = parameters;
        this.body = body;
        this.return_ = return_;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Stream<AbstractNode> children() {
        return Stream.concat(Stream.concat(this.parameters.stream(), this.body.stream()), Stream.of(this.return_));
    }

    public FunctionNode addParameter(IdentifierNode arg) {
        this.parameters.add(arg);
        return this;
    }

    public FunctionNode addBinding(LetBindingNode binding) {
        this.body.add(binding);
        return this;
    }

    public FunctionNode setReturn(Expression return_) {
        this.return_ = return_;
        return this;
    }
}
