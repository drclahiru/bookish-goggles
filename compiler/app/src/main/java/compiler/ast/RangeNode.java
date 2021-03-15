package compiler.ast;

import java.util.stream.*;

public class RangeNode extends ExpressionNode {
    public final String startCol;
    public final int startRow;
    public final String endCol;
    public final int endRow;

    public RangeNode(String startCol, int startRow, String endCol, int endRow) {
        this.startCol = startCol;
        this.startRow = startRow;
        this.endCol = endCol;
        this.endRow = endRow;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }
}