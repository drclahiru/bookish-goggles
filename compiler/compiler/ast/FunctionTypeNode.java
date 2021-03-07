package compiler.ast;

import java.util.ArrayList;

public class FunctionTypeNode extends TypeNode {
    ArrayList<IdentifierNode> parameters;
    IdentifierNode return_;

    public FunctionTypeNode(ArrayList<IdentifierNode> parameters, IdentifierNode return_) {
        this.parameters = parameters;
        this.return_ = return_;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public FunctionTypeNode addParameter(IdentifierNode param) {
        this.parameters.add(param);
        return this;
    }
}
