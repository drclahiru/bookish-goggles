package compiler.ast;

public class Identifier {
    String name;
    Integer scopeId;

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
        return this.scopeId == other.scopeId
            && this.name == other.name;
    }

    public String scopedName() {
        if (this.scopeId == null) {
            return this.name;
        }
        return name + "@" + Utility.intToAlphabetic(scopeId);
    }
}
