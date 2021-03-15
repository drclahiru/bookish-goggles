package compiler.ast;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.stream.*;

public class FunctionTypeNode extends TypeNode {
    public final ArrayList<TypeNode> parameters = new ArrayList<>();
    public TypeNode return_;

    public Stream<AbstractNode> children() {
        return Stream.concat(this.parameters.stream(), Stream.of(return_));
    }
}
