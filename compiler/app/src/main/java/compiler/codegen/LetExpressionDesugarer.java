package compiler.codegen;

import java.util.*;

import compiler.IdentifierContext;
import compiler.Utility;
import compiler.analysis.ClosureResolver;
import compiler.ast.*;
import compiler.visitor.*;

/*
 * Transforms let-expressions into global-scope bindings.
 * 
 * Example:
 * 
 *   let f = (x) {
 *     let y = x * 2 in
 *     x + y
 *   }
 * 
 * becomes
 * 
 *   let y = (x) { x * 2 }
 * 
 *   let f = (x) { x + y(x) }
 * 
 * the drawback of this approach is that if we were to use y twice, then we would have to 
 * compute it twice. It's possible to do a smarter transformation such that the produced 
 * code would be:
 * 
 *   let y = (x) { x * 2 }
 * 
 *   let f_inner = (x, y) { x + y }
 * 
 *   let f = (x) { f_inner(x, y(x)) }
 * 
 */
public class LetExpressionDesugarer extends VisitorT<ExpressionNode> {
    final IdentifierContext idMap;
    final IdentifierGenerator gen;
    final Set<Identifier> ignoreInClosure = new HashSet<Identifier>(Utility.createPrelude().keySet());
    final ArrayList<LetBindingNode> globals = new ArrayList<>();
    final Map<Identifier, ExpressionNode> letIdentifiers = new HashMap<>();
    final List<Identifier> currentCaptures = new Vector<>();

    public LetExpressionDesugarer(IdentifierContext idMap, IdentifierGenerator gen) {
        this.idMap = idMap;
        this.gen = gen;
    }

    public void run(ProgramNode ast) {
        for (var b : ast.bindings) {
            ignoreInClosure.add(b.declaration.identifier.value);
        }
        try {
            for (var b : ast.bindings) {
                visit(b);
            }
            ast.bindings.clear();
            ast.bindings.addAll(globals);
        } catch (VisitorException ex) {
            throw new Error(ex);
        }
    }

    ExpressionNode mapIdentifier(Identifier i) {
        if (letIdentifiers.containsKey(i) && !currentCaptures.contains(i)) {
            return letIdentifiers.get(i);
        }
        var n = new IdentifierNode(null, i);
        n.type = idMap.get(i).type;
        return n;
    }

    @Override
    protected ExpressionNode visitLetBinding(LetBindingNode n) throws VisitorException {
        n.expr = visit(n.expr);
        globals.add(n);
        return null;
    }

    @Override
    protected ExpressionNode visitLetExpression(LetExpressionNode n) throws VisitorException {
        var id = new IdentifierNode(null, gen.nextPrefixed(n.declaration.identifier.value.name));
        var captures = new ClosureResolver(ignoreInClosure, true).run(n.expr);
        {
            var fType = new FunctionTypeNode(null);
            var f = new FunctionNode(null);
            for (var c : captures) {
                var cid = new IdentifierNode(null, c);
                var decl = new IdentifierDeclarationNode(null, cid);
                decl.typeScheme = idMap.get(cid.value);
                decl.type = decl.typeScheme.type;
                fType.parameters.add(decl.type);
                f.parameters.add(decl);
            }
            currentCaptures.addAll(captures);
            f.return_ = visit(n.expr);
            currentCaptures
                .subList(currentCaptures.size() - captures.size(), currentCaptures.size())
                .clear();
            fType.return_ = f.return_.type;
            f.type = fType;
            var let = new LetBindingNode(null, id);
            let.expr = f;
            let.declaration.typeScheme = new TypeScheme(fType);
            globals.add(let);
            idMap.put(id.value, let.declaration.typeScheme);
        }
        {
            var fInvoc = new FunctionInvocationNode(null);
            fInvoc.identifier = id;
            fInvoc.type = n.type;
            for (var c : captures) {
                fInvoc.arguments.add(mapIdentifier(c));
            }
            letIdentifiers.put(n.declaration.identifier.value, fInvoc);
        }
        return visit(n.next);
    }
    @Override
    protected ExpressionNode visitBool(BoolNode n) throws VisitorException {
        return n;
    }
    @Override
    protected ExpressionNode visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
        var fInvoc = new FunctionInvocationNode(n.source);
        fInvoc.identifier = n.identifier;
        fInvoc.type = n.type;
        for (var arg : n.arguments) {
            fInvoc.arguments.add(visit(arg));
        }
        return fInvoc;
    }
    @Override
    protected ExpressionNode visitFunction(FunctionNode n) throws VisitorException {
        var f = new FunctionNode(n.source);
        f.parameters.addAll(n.parameters);
        f.return_ = visit(n.return_);
        f.type = n.type;
        return f;
    }
    @Override
    protected ExpressionNode visitIdentifier(IdentifierNode n) throws VisitorException {
        return mapIdentifier(n.value);
    }
    
    @Override
    protected ExpressionNode visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
    @Override
    protected ExpressionNode visitIfElse(IfElseNode n) throws VisitorException {
        var ifElse = new IfElseNode(n.source);
        ifElse.boolExpr = visit(n.boolExpr);
        ifElse.trueCase = visit(n.trueCase);
        ifElse.elseCase = visit(n.elseCase);
        ifElse.type = n.type;
        return ifElse;
    }
    @Override
    protected ExpressionNode visitNumber(NumberNode n) throws VisitorException {
        return n;
    }
    @Override
    protected ExpressionNode visitProgram(ProgramNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
    @Override
    protected ExpressionNode visitString(StringNode n) throws VisitorException {
        return n;
    }
    @Override
    protected ExpressionNode visitRange(RangeNode n) throws VisitorException {
        return n;
    }
    @Override
    protected ExpressionNode visitList(ListNode n) throws VisitorException {
        var next = n.clone();
        for (var i = 0; i < n.exprs.size(); i++) {
            next.exprs.set(i, visit(next.exprs.get(i)));
        }
        return next;
    }

    @Override
    protected ExpressionNode visitMatch(MatchNode n) throws VisitorException {
        var next = n.clone();
        next.expr = visit(next.expr);
        for (var i = 0; i < next.patterns.size(); i++) {
            var pat = next.patterns.get(i);
            pat.expr = visit(pat.expr);
            next.patterns.set(i, pat);
        }
        return next;
    }
}
