package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class FunctionTypeNode extends TypeNode {
    ArrayList<SimpleTypeNode> parameters = new ArrayList<>();
    SimpleTypeNode return_;

    public Stream<AbstractNode> children() {
        return Stream.concat(this.parameters.stream(), Stream.of(return_));
    }

    public FunctionTypeNode parameter(SimpleTypeNode param) {
        this.parameters.add(param);
        return this;
    }

    public FunctionTypeNode returns(SimpleTypeNode return_) {
        this.return_ = return_;
        return this;
    }
}
