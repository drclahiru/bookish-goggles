package compiler.ast;

import java.util.stream.*;

public abstract class TypeNode extends AbstractNode {
    @Override
    public boolean equals(Object o) {
        if (this instanceof SimpleTypeNode && o instanceof SimpleTypeNode) {
            return ((SimpleTypeNode)this).equals((SimpleTypeNode)o);
        }

        if (this instanceof FunctionTypeNode && o instanceof FunctionTypeNode) {
            return ((FunctionTypeNode)this).equals((FunctionTypeNode)o);
        }

        if (this instanceof GenericTypeNode && o instanceof GenericTypeNode) {
            return ((GenericTypeNode)this).equals((GenericTypeNode)o);
        }
        return false;
    }
}
