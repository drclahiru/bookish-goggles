package compiler.ast;

import java.util.Objects;

public class Identifier {
    public final String name;
    public final Integer scopeId;

    public Identifier(String name) {
        this.name = name;
        this.scopeId = null;
    }
    public Identifier(String name, Integer scopeId) {
        this.name = name;
        this.scopeId = scopeId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Identifier)) {
            return false;
        }

        var other = (Identifier)o;
        var scopeEq = this.scopeId == other.scopeId;
        var nameEq = this.name.equals(other.name);
        var eq = scopeEq && nameEq;
        return eq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scopeId, name);
    }

    @Override
    public String toString() {
        if (scopeId == null) {
            return name;
        }
        return scopeId + "_" + name;
    }
}
