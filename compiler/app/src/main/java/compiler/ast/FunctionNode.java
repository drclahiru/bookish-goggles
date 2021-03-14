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

    public void parameter(IdentifierNode id) {
        this.parameters.add(new IdentifierDeclarationNode(id));
    }

    public void parameter(IdentifierDeclarationNode node) {
        this.parameters.add(node);
    }

    public void let(LetBindingNode let) {
        this.body.add(let);
    }

    public void returns(Expression return_) {
        this.return_ = return_;
    }
}
