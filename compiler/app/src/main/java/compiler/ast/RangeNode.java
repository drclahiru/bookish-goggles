package compiler.ast;

import java.util.stream.*;
import java.util.ArrayList;
import org.antlr.v4.runtime.ParserRuleContext;

public class RangeNode extends ExpressionNode {

    public final String startCol;
    public final int startRow;
    public final String endCol;
    public final int endRow; 

    public RangeNode(ParserRuleContext source, String startCol, int startRow, String endCol, int endRow) {
        super(source);
        this.startCol = startCol;
        this.startRow = startRow;
        this.endCol = endCol;
        this.endRow = endRow;
    }

    public Stream<AbstractNode> children() {
        return Stream.empty();
    }

    @Override
    public RangeNode clone() {
        var n = new RangeNode (source, startCol, startRow, endCol, endRow);
        n.type = type;
        return n;
    }
}