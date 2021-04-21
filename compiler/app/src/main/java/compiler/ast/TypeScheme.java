package compiler.ast;

import compiler.TypeVariableRenamer;
import compiler.Utility;
import java.util.*;

public class TypeScheme {
    public final Set<VariableTypeNode> vars;
    public final TypeNode type;

    public TypeScheme(TypeNode type) {
        this(new HashSet<>(), type);
    }
    public TypeScheme(Set<VariableTypeNode> vars, TypeNode type) {
        this.vars = vars;
        this.type = type;
    }

    @Override
    public String toString() {
        var b = new StringBuilder();

        var renamer = createRenamer();
        for (var e : vars) {
            b.append(e);
            b.append(" ");
        }
        if (!vars.isEmpty()){
            b.append("=> ");
        }

        b.append(renamer.rename(type).toString());

        return b.toString();
    }

    public TypeVariableRenamer createRenamer() {
        var varMap = new HashMap<VariableTypeNode, String>();
        if (!vars.isEmpty()) {
            var i = 0;
            for (var v : vars) {
                var s = Utility.intToAlphabetic(i++);
                varMap.put(v, s);
            }
        }
        return new TypeVariableRenamer(varMap);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VariableTypeNode)) {
            return false;
        }

        var other = (TypeScheme)o;
        return this.type.equals(other.type) && this.vars.equals(other.vars);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(vars, type);
    }
}
