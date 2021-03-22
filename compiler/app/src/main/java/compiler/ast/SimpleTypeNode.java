package compiler.ast;

import java.util.*;
import java.util.stream.*;

public class SimpleTypeNode extends TypeNode {
    public final SimpleType type;

    public SimpleTypeNode(SimpleType type) {
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
}
