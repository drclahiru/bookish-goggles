package compiler;

import java.util.*;
import compiler.ast.*;

public class TypeVariableRenamer {
    HashMap<VariableTypeNode, String> map;
    public TypeVariableRenamer(HashMap<VariableTypeNode, String> map) {
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
        if (t instanceof RangeTypeNode) {
            var rt = (RangeTypeNode)t;
            return new RangeTypeNode(rt.source, renameVar(rt.innerType, from, to));
        }
        if (t instanceof UnificationErrorType) {
            var ut = (UnificationErrorType)t;
            var utNext = new UnificationErrorType(ut.source);
            for (var t2 : ut.types) {
                utNext.types.add(renameVar(t2, from, to));
            }
            return utNext;
        }
        return t;
    }

    static TypeVariableRenamer emptyInstance = new TypeVariableRenamer(new HashMap<VariableTypeNode, String>()); 
    public static TypeVariableRenamer empty() {
        return emptyInstance;
    }
}
