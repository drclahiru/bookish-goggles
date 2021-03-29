package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;
import org.antlr.v4.runtime.RuleContext;

public class FunctionNode extends ExpressionNode {
    public final ArrayList<IdentifierDeclarationNode> parameters = new ArrayList<>();
    public final ArrayList<LetBindingNode> body = new ArrayList<>();
    public ExpressionNode return_;

    public FunctionNode(RuleContext source) {
        super(source);
    }

    public Stream<AbstractNode> children() {
        return Stream.concat(Stream.concat(this.parameters.stream(), this.body.stream()), Stream.of(this.return_));
    }
}
