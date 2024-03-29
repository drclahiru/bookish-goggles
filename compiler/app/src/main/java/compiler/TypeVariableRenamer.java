package compiler;

import java.util.*;
import compiler.ast.*;

public class TypeVariableRenamer {
    Map<VariableTypeNode, String> map;
    public TypeVariableRenamer(Map<VariableTypeNode, String> map) {
        this.map = map;
    }
    public TypeNode rename(TypeNode t) {
        var ty = t;
        for (var e : map.entrySet()) {
            ty = renameVar(ty, e.getKey().id, e.getValue());
        }
        return ty;
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
        if (t instanceof ListTypeNode) {
            var lt = (ListTypeNode)t;
            var innerT = lt.innerType;
            return new ListTypeNode(null, renameVar(innerT, from, to));
        }
        return t;
    }

    static TypeVariableRenamer emptyInstance = new TypeVariableRenamer(new HashMap<VariableTypeNode, String>()); 
    public static TypeVariableRenamer empty() {
        return emptyInstance;
    }
}
