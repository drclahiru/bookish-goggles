package compiler.ast;

import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

public class PatternVarNode extends PatternNode {
    public final IdentifierNode ident;

    public PatternVarNode(ParserRuleContext source, IdentifierNode ident) {
        super(source);
        this.ident = ident;
    }

    @Override
    public PatternVarNode clone() {
        return this;
    }

    @Override
    public Stream<AbstractNode> children() {
        return Stream.of(ident).map(x -> x);
    }
}