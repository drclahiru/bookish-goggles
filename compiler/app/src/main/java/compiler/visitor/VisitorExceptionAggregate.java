package compiler.visitor;

import java.util.List;

public class VisitorExceptionAggregate extends Exception {
    @java.io.Serial
    static final long serialVersionUID = 1L;
    public final List<VisitorException> exceptions;

    public VisitorExceptionAggregate(List<VisitorException> exceptions) {
        this.exceptions = exceptions;
    }

    @Override
    public String toString() {
        var b = new StringBuilder();
        for (var ex : exceptions) {
            b.append(ex);
            b.append("\n");
        }
        return b.toString();
    }
}
