package compiler.ast;

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

        var varMap = new HashMap<VariableTypeNode, String>();

        if (!vars.isEmpty()) {
            var i = 0;
            for (var v : vars) {
                var s = Utility.intToAlphabetic(i++);
                varMap.put(v, s);
                b.append(s);
                b.append(" ");
            }
        
            b.append("=> ");
        }

        var t = type;
        for (var e : varMap.entrySet()) {
            t = renameVar(t, e.getKey().id, e.getValue());
        }
        b.append(t.toString());

        return b.toString();
    }
    
    TypeNode renameVar(TypeNode t, String from, String to) {
        if (t instanceof VariableTypeNode && ((VariableTypeNode)t).id.equals(from)) {
            return new VariableTypeNode(to);
        }
        if (t instanceof FunctionTypeNode) {
            var ft = (FunctionTypeNode)t;
            var ftNext = new FunctionTypeNode(null);
            for (var p : ft.parameters) {
                ftNext.parameters.add(renameVar(p, from, to));
            }
            ftNext.return_ = renameVar(ft.return_, from, to);
            return ftNext;
        }
        return t;
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
