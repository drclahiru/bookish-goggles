package compiler.ast;

import java.util.*;
import java.util.stream.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class FunctionTypeNode extends TypeNode {
    public final ArrayList<TypeNode> parameters = new ArrayList<>();
    public TypeNode return_;
    public FunctionTypeNode(ParserRuleContext source) {
        super(source);
    }

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
            if (!a1.equals(a2)) {
                return false;
            }
        }
        return this.return_.equals(other.return_);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(parameters, return_);
    }
    
    @Override
    public FunctionTypeNode clone() {
        var n = new FunctionTypeNode(source);
        n.type = type;
        n.return_ = return_.clone();
        for (var param : parameters) {
            n.parameters.add(param.clone());
        }
        return n;
    }
}
