package compiler;

import compiler.ast.VariableTypeNode;

public class TypeVarGenerator {
    int nextTypeVarId = 1;

    public VariableTypeNode next() {
        return new VariableTypeNode(Integer.toString(nextTypeVarId++));
    }
}