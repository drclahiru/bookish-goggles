package compiler.visitor;

import compiler.ast.*;

public abstract class PatternVisitorT<T> {
    public T visit(PatternNode n) throws VisitorException {
        if (n instanceof PatternVarNode) {
            return visitPatternVar((PatternVarNode)n);
        } else if (n instanceof PatternListCons) {
            return visitPatternListCons((PatternListCons)n);
        } else if (n instanceof PatternListEmpty) {
            return visitPatternListEmpty((PatternListEmpty)n);
        } else {
            throw new Error("Unexpected pattern: " + n);
        }
    }
    protected abstract T visitPatternVar(PatternVarNode n) throws VisitorException;
    protected abstract T visitPatternListEmpty(PatternListEmpty n) throws VisitorException;
    protected abstract T visitPatternListCons(PatternListCons n) throws VisitorException;
}
