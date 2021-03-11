package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class FunctionTypeNode extends TypeNode {
    ArrayList<IdentifierNode> parameters;
    IdentifierNode return_;

    public FunctionTypeNode(ArrayList<IdentifierNode> parameters, IdentifierNode return_) {
        this.parameters = parameters;
        this.return_ = return_;
    }

    public Stream<AbstractNode> children() {
        return Stream.concat(this.parameters.stream(), Stream.of(return_));
    }

    public FunctionTypeNode addParameter(IdentifierNode param) {
        this.parameters.add(param);
        return this;
    }
}
