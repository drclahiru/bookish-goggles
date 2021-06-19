package compiler.ast;

import java.util.*;
import java.util.stream.*;

import org.antlr.v4.runtime.ParserRuleContext;

public class ListTypeNode extends TypeNode {
    public final TypeNode innerType;

    public ListTypeNode(ParserRuleContext source, TypeNode innerType) {
        super(source);
        this.innerType = innerType;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }

    @Override
    public String toString() {
        return "List(" + innerType.toString() + ")";
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ListTypeNode)) {
            return false;
        }

        var other = (ListTypeNode)o;
        return this.innerType.equals(other.innerType);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(innerType);
    }

    @Override
    public ListTypeNode clone() {
        return new ListTypeNode(source, innerType.clone());
    }

    @Override
    public void addTypeVars(Set<VariableTypeNode> s) {
        innerType.addTypeVars(s);
    }
}
