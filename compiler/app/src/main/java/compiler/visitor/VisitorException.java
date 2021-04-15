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

    @Override
    public String toString() {
        var b = new StringBuilder();
        var sourceNode = source;
        var source = sourceNode.source;
        var start = source.getStart();
        var stop = source.getStop();
        b.append("[");
        b.append(start.getLine());
        b.append(":");
        b.append(start.getCharPositionInLine());
        b.append("..");
        b.append(stop.getLine());
        b.append(":");
        b.append(stop.getCharPositionInLine());
        b.append("] ");
        b.append(message);
        return b.toString();
    }
}