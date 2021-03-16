package compiler.ast;

import java.util.*;
import java.util.stream.*;

public class GenericTypeNode extends TypeNode {
    public final int id;

    public GenericTypeNode(int id) {
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
        if (!(o instanceof GenericTypeNode)) {
            return false;
        }

        var other = (GenericTypeNode)o;
        return this.id == other.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
