package compiler.ast;

import java.util.ArrayList;

public class FunctionNode extends Expression {
    ArrayList<IdentifierNode> parameters;
    ArrayList<BindingNode> body;
    Expression return_;

    public FunctionNode(ArrayList<IdentifierNode> parameters, ArrayList<BindingNode> body, Expression return_) {
        this.parameters = parameters;
        this.body = body;
        this.return_ = return_;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public FunctionNode addParameter(IdentifierNode arg) {
        this.parameters.add(arg);
        return this;
    }

    public FunctionNode addBinding(BindingNode binding) {
        this.body.add(binding);
        return this;
    }

    public FunctionNode setReturn(Expression return_) {
        this.return_ = return_;
        return this;
    }
}
