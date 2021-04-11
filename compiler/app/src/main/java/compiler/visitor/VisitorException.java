package compiler.visitor;

import compiler.ast.AbstractNode;

public class VisitorException extends Exception {
    @java.io.Serial
    static final long serialVersionUID = 1L;

    public final AbstractNode source;
    public final String message;
    public VisitorException(AbstractNode source, String message) {
        this.source = source;
        this.message = message;
    }
}