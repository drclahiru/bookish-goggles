package compiler;

import java.util.HashMap;

import compiler.ast.*;

public class IdentifierContext extends HashMap<Identifier, TypeScheme> {
    static final long serialVersionUID = 1L;
    public IdentifierContext() {
        super();
    }
    IdentifierContext(IdentifierContext c) {
        super(c);
    }

    public void print() {
        var out = System.out;
        out.print("{");
        this.entrySet().stream().limit(1).forEach(x -> {
            out.print(x.getKey());
            out.print(": ");
            out.print(x.getValue());
        });
        this.entrySet().stream().skip(1).forEach(x -> {
            out.print(" ; ");
            out.print(x.getKey());
            out.print(": ");
            out.print(x.getValue());
        });
        out.print("}");
    }

    public IdentifierContext clone() {
        return new IdentifierContext(this);
    }
}
