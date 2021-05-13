package compiler.ast;

import java.util.*;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

public class UnificationErrorType extends TypeNode {
    public List<TypeNode> types = new ArrayList<>();

    public UnificationErrorType(ParserRuleContext source) {
        super(source);
    }

    @Override
    public String toString() {
        var b = new StringBuilder();
        b.append("Error(");
        types
            .stream()
            .limit(1)
            .map(x -> x.toString())
            .forEach(b::append);
        types
            .stream()
            .skip(1)
            .map(x -> " | " + x.toString())
            .forEach(b::append);
        b.append(")");

        return b.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UnificationErrorType)) {
            return false;
        }

        var other = (UnificationErrorType)o;
        if (this.types.size() != other.types.size()) {
            return false;
        }
        for (var i = 0; i < this.types.size(); i++) {
            var a1 = this.types.get(i);
            var a2 = other.types.get(i);
            if (!a1.equals(a2)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return types.hashCode();
    }
    

    @Override
    public TypeNode clone() {
        var next = new UnificationErrorType(source);
        for (var t : types) {
            next.types.add(t.clone());
        }
        return next;
    }

    @Override
    public Stream<AbstractNode> children() {
        return types.stream().map(x -> x);
    }
}
