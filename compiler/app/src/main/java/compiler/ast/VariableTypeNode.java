package compiler.ast;

import java.util.*;
import java.util.stream.*;

public class VariableTypeNode extends TypeNode {
    public final int id;

    public VariableTypeNode(int id) {
        super(null);
        this.id = id;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }

    @Override
    public String toString() {
        return "'" + Utility.intToAlphabetic(id);
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VariableTypeNode)) {
            return false;
        }

        var other = (VariableTypeNode)o;
        return this.id == other.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}