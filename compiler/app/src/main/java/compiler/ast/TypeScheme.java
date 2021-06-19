package compiler.ast;

import compiler.TypeVarGenerator;
import compiler.TypeVariableRenamer;
import compiler.Utility;

import java.util.*;
import java.util.stream.Collectors;

public class TypeScheme {
    public final TypeNode type;

    public TypeScheme(TypeNode type) {
        this.type = type;
    }

    @Override
    public String toString() {
        var b = new StringBuilder();

        var renamer = createRenamer();
        var vars = type.getTypeVars();
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
        var vars = type.getTypeVars();
        if (!vars.isEmpty()) {
            var i = 0;
            for (var v : vars) {
                var s = Utility.intToAlphabetic(i++);
                varMap.put(v, s);
            }
        }
        return new TypeVariableRenamer(varMap);
    }

    public Set<VariableTypeNode> getTypeVars() {
        return type.getTypeVars();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VariableTypeNode)) {
            return false;
        }

        var other = (TypeScheme)o;
        return this.type.equals(other.type);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public TypeNode instantiate(TypeVarGenerator varGen) {
        var vars = type
            .getTypeVars()
            .stream()
            .collect(Collectors.toMap(x -> x, x -> varGen.next().id));

        var renamer = new TypeVariableRenamer(vars);
        return renamer.rename(type);
    }
}
