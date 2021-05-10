package compiler.codegen;

import java.util.*;
import compiler.*;
import compiler.analysis.ClosureResolver;
import compiler.ast.*;
import compiler.visitor.*;

public class LambdaLifter extends VisitorT<ExpressionNode> {
    final IdentifierContext idMap;
    final IdentifierGenerator gen;
    final Set<Identifier> ignoreInClosure = new HashSet<Identifier>(Utility.createPrelude().keySet());
    final ArrayList<LetBindingNode> globals = new ArrayList<>();
    boolean inLambda = false;
    Identifier currentBinding = null;

    public LambdaLifter(IdentifierContext idMap, IdentifierGenerator gen) {
        this.idMap = idMap;
        this.gen = gen;
    }

    public void run(ProgramNode ast) {
        for (var b : ast.bindings) {
            ignoreInClosure.add(b.declaration.identifier.value);
        }
        try {
            for (var b : ast.bindings) {
                currentBinding = b.declaration.identifier.value;
                visit(b);
            }
            ast.bindings.clear();
            ast.bindings.addAll(globals);
        } catch (VisitorException ex) {
            throw new Error(ex);
        }
    }

    protected LetExpressionNode visitLetExpression(LetExpressionNode n) throws VisitorException {
        var let = n.clone();
        let.expr = visit(n.expr);
        let.next = visit(n.next);
        return let;
    }
    protected ExpressionNode visitBool(BoolNode n) throws VisitorException {
        return n;
    }
    protected ExpressionNode visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
        var fInvoc = n.clone();
        fInvoc.identifier = visitIdentifier(fInvoc.identifier);
        for (var i = 0; i < n.arguments.size(); i++) {
            fInvoc.arguments.set(i, visit(n.arguments.get(i)));
        }
        return fInvoc;
    }
    protected ExpressionNode visitFunction(FunctionNode n) throws VisitorException {
        if (!inLambda) {
            inLambda = true;
            var f = n.clone();
            for (var p : f.parameters) {
                p.identifier = visitIdentifier(p.identifier);
            }
            f.return_ = visit(n.return_);
            inLambda = false;
            return f;
        }
        
        var id = new IdentifierNode(null, gen.nextPrefixed(currentBinding.name));
        var captures = new ClosureResolver(ignoreInClosure, true).run(n.return_);
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
            f.return_ = visit(n.return_);
            fType.return_ = f.return_.type;
            f.type = fType;
            var let = new LetBindingNode(null, id);
            let.expr = f;
            let.declaration.typeScheme = new TypeScheme(fType);
            globals.add(let);
            idMap.put(id.value, let.declaration.typeScheme);
        }
        return id;

    }
    protected IdentifierNode visitIdentifier(IdentifierNode n) throws VisitorException {
        return n;
    }
    protected IfElseNode visitIfElse(IfElseNode n) throws VisitorException {
        var ifElse = n.clone();
        ifElse.boolExpr = visit(n.boolExpr);
        ifElse.trueCase = visit(n.trueCase);
        ifElse.elseCase = visit(n.elseCase);
        return ifElse;
    }
    protected ExpressionNode visitNumber(NumberNode n) throws VisitorException {
        return n;
    }
    protected ExpressionNode visitString(StringNode n) throws VisitorException {
        return n;
    }
    protected ExpressionNode visitRange(RangeNode n) throws VisitorException {
        return n;
    }
    protected ExpressionNode visitRangeNodeExpression(RangeNodeExpression n) throws VisitorException {
        return n;
    }
    protected ExpressionNode visitLetBinding(LetBindingNode n) throws VisitorException {
        var let = n.clone();
        let.expr = visit(n.expr);
        globals.add(let);
        return null;
    }
    protected ExpressionNode visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
    protected ExpressionNode visitProgram(ProgramNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
}
