package compiler.ast;

import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

public class PatternVarNode extends PatternNode {
    public final IdentifierDeclarationNode decl;

    public PatternVarNode(ParserRuleContext source, IdentifierNode ident) {
        super(source);
        this.decl = new IdentifierDeclarationNode(source, ident);
    }

    @Override
    public PatternVarNode clone() {
        var pat = new PatternVarNode(source, decl.identifier.clone());
        pat.decl.typeScheme = new TypeScheme(decl.typeScheme.type);
        pat.type = type.clone();
        return this;
    }

    @Override
    public Stream<AbstractNode> children() {
        return Stream.of(decl);
    }
}