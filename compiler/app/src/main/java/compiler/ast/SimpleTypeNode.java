package compiler.ast;

import java.util.*;
import java.util.stream.*;

import org.antlr.v4.runtime.ParserRuleContext;

public class SimpleTypeNode extends TypeNode {
    public final SimpleType type;

    public SimpleTypeNode(ParserRuleContext source, SimpleType type) {
        super(source);
        this.type = type;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }

    @Override
    public String toString() {
        return type.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SimpleTypeNode)) {
            return false;
        }

        var other = (SimpleTypeNode)o;
        return this.type == other.type;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public SimpleTypeNode clone() {
        var n = new SimpleTypeNode(source, type);
        return n;
    }

    @Override
    public void addTypeVars(Set<VariableTypeNode> s) {
    }
}
