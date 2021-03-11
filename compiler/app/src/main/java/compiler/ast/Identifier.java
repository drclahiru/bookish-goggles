package compiler.ast;

public class Identifier {
    String value;
    Integer scopeLevel;

    public Identifier(String value) {
        this.value = value;
        this.scopeLevel = null;
    }
    public Identifier(String value, Integer scopeLevel) {
        this.value = value;
        this.scopeLevel = scopeLevel;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Identifier)) {
            return false;
        }

        var other = (Identifier)o;
        return this.scopeLevel == other.scopeLevel
            && this.value == other.value;
    }

    public String scopedValue() {
        if (this.scopeLevel == null) {
            return this.value;
        }
        return value + "@" + scopeLevelToString(scopeLevel);
    }

    static String scopeLevelToString(int code) {
        var s = "";
        for (var n = code; n > 0; n /= 26)
        {
            var c = (char)(96 + (n % 26));
            s += c;
            n /= 26;
        }
        return s;
    }
}
