package compiler.ast;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.stream.*;

public class FunctionTypeNode extends TypeNode {
    ArrayList<TypeNode> parameters = new ArrayList<>();
    TypeNode return_;

    public Stream<AbstractNode> children() {
        return Stream.concat(this.parameters.stream(), Stream.of(return_));
    }

    public void parameter(TypeNode param) {
        this.parameters.add(param);
    }

    public void returns(TypeNode return_) {
        this.return_ = return_;
    }
}
