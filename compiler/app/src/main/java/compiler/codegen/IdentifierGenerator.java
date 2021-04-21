package compiler.codegen;

import compiler.ast.Identifier;

public class IdentifierGenerator {
    Integer nextFunctionId = 1;
    public Identifier next() {
        return nextPrefixed("");
    }
    public Identifier nextPrefixed(String prefix) {
        return new Identifier(prefix + "$" + nextFunctionId++);
    }
    
}
