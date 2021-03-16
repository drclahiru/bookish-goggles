package compiler.ast;

import java.lang.annotation.Inherited;
import java.util.*;
import java.util.stream.*;

public class FunctionTypeNode extends TypeNode {
    public final ArrayList<TypeNode> parameters = new ArrayList<>();
    public TypeNode return_;

    public Stream<AbstractNode> children() {
        return Stream.concat(this.parameters.stream(), Stream.of(return_));
    }

    @Override
    public String toString() {
        var b = new StringBuilder();
        b.append("(");
        parameters
            .stream()
            .limit(1)
            .map(x -> x.toString())
            .forEach(b::append);
        parameters
            .stream()
            .skip(1)
            .map(x -> ", " + x.toString())
            .forEach(b::append);
        b.append(") -> ");
        b.append(return_.toString());

        return b.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FunctionTypeNode)) {
            return false;
        }

        var other = (FunctionTypeNode)o;
        if (this.parameters.size() != other.parameters.size()) {
            return false;
        }
        for (var i = 0; i < this.parameters.size(); i++) {
            var a1 = this.parameters.get(i);
            var a2 = other.parameters.get(i);
            if (a1 != a2) {
                return false;
            }
        }
        return this.return_ == other.return_;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(parameters, return_);
    }
}
