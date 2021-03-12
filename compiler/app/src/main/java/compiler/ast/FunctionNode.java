package compiler.ast;

import java.util.ArrayList;
import java.util.stream.*;

public class FunctionNode extends Expression {
    ArrayList<IdentifierDeclarationNode> parameters = new ArrayList<>();
    ArrayList<LetBindingNode> body = new ArrayList<>();
    Expression return_;

    public Stream<AbstractNode> children() {
        return Stream.concat(Stream.concat(this.parameters.stream(), this.body.stream()), Stream.of(this.return_));
    }

    public FunctionNode parameter(IdentifierNode id) {
        this.parameters.add(new IdentifierDeclarationNode(id));
        return this;
    }

    public FunctionNode parameter(IdentifierDeclarationNode node) {
        this.parameters.add(node);
        return this;
    }

    public FunctionNode let(LetBindingNode let) {
        this.body.add(let);
        return this;
    }

    public FunctionNode returns(Expression return_) {
        this.return_ = return_;
        return this;
    }
}
