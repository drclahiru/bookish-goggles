package compiler.ast;

import java.util.*;
import java.util.stream.*;

import org.antlr.v4.runtime.ParserRuleContext;

public class RangeTypeNode extends TypeNode {
    public final TypeNode innerType;

    public RangeTypeNode(ParserRuleContext source, TypeNode innerType) {
        super(source);
        this.innerType = innerType;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }

    @Override
    public String toString() {
        return "[" + innerType.toString() + "]";
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RangeTypeNode)) {
            return false;
        }

        var other = (RangeTypeNode)o;
        return this.innerType == other.innerType;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(innerType);
    }

    @Override
    public RangeTypeNode clone() {
        var n = new RangeTypeNode(source, innerType);
        return n;
    }
}
