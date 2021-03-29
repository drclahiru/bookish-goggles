package compiler.ast;

import org.antlr.v4.runtime.RuleContext;

public abstract class TypeNode extends AbstractNode {
    public TypeNode(RuleContext source) {
        super(source);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this instanceof SimpleTypeNode && o instanceof SimpleTypeNode) {
            return ((SimpleTypeNode)this).equals((SimpleTypeNode)o);
        }

        if (this instanceof FunctionTypeNode && o instanceof FunctionTypeNode) {
            return ((FunctionTypeNode)this).equals((FunctionTypeNode)o);
        }

        if (this instanceof VariableTypeNode && o instanceof VariableTypeNode) {
            return ((VariableTypeNode)this).equals((VariableTypeNode)o);
        }

        return false;
    }
}
