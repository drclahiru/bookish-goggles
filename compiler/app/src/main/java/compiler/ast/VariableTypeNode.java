package compiler.ast;

import java.util.*;
import java.util.stream.*;

public class VariableTypeNode extends TypeNode {
    public final String id;

    public VariableTypeNode(String id) {
        super(null);
        this.id = id;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }

    @Override
    public String toString() {
        return id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VariableTypeNode)) {
            return false;
        }

        var other = (VariableTypeNode)o;
        return this.id.equals(other.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public VariableTypeNode clone() {
        var n = new VariableTypeNode(id);
        n.type = type;
        return n;
    }
}