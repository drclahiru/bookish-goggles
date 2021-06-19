package compiler.ast;

import compiler.TypeVarGenerator;
import compiler.TypeVariableRenamer;
import java.util.*;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;


public abstract class TypeNode extends AbstractNode {
    public TypeNode(ParserRuleContext source) {
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

        if (this instanceof ListTypeNode && o instanceof ListTypeNode) {
            return ((ListTypeNode)this).equals((ListTypeNode)o);
        }

        return false;
    }

    @Override
    public abstract TypeNode clone();
    

    public abstract void addTypeVars(Set<VariableTypeNode> s);

    public Set<VariableTypeNode> getTypeVars() {
        var s = new HashSet<VariableTypeNode>();
        addTypeVars(s);
        return s;
    };

    public TypeScheme generalize(TypeVarGenerator varGen) {
        var vars = getTypeVars()
            .stream()
            .collect(Collectors.toMap(x -> x, x -> varGen.next().id));
        var renamer = new TypeVariableRenamer(vars);
        return new TypeScheme(renamer.rename(this));
    }
}
