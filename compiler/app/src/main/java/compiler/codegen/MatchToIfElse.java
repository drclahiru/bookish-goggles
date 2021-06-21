package compiler.codegen;

import java.util.*;

import compiler.ast.*;
import compiler.visitor.PatternVisitorT;
import compiler.visitor.VisitorException;
import compiler.visitor.VisitorT;

public class MatchToIfElse extends VisitorT<ExpressionNode> {
    final IdentifierGenerator idGen;
    public MatchToIfElse(IdentifierGenerator idGen) {
        this.idGen = idGen;
    }

    @Override
    protected ExpressionNode visitLetBinding(LetBindingNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
    @Override
    protected ExpressionNode visitLetExpression(LetExpressionNode n) throws VisitorException {
        var node = n.clone();
        node.expr = visit(node.expr);
        node.next = visit(node.next);
        return node;
    }
    @Override
    protected ExpressionNode visitBool(BoolNode n) throws VisitorException {
        return n;
    }
    @Override
    protected ExpressionNode visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
        var node = n.clone();
        for (var i = 0; i < node.arguments.size(); i++) {
            node.arguments.set(i, visit(node.arguments.get(i)));
        }
        return node;
    }
    @Override
    protected ExpressionNode visitFunction(FunctionNode n) throws VisitorException {
        var node = n.clone();
        node.return_ = visit(node.return_);
        return node;
    }
    @Override
    protected ExpressionNode visitIdentifier(IdentifierNode n) throws VisitorException {
        return n;
    }
    @Override
    protected ExpressionNode visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
    @Override
    protected ExpressionNode visitIfElse(IfElseNode n) throws VisitorException {
        var node = n.clone();
        node.boolExpr = visit(node.boolExpr);
        node.trueCase = visit(node.trueCase);
        node.elseCase = visit(node.elseCase);
        return node;
    }
    @Override
    protected ExpressionNode visitNumber(NumberNode n) throws VisitorException {
        return n;
    }
    @Override
    protected ExpressionNode visitProgram(ProgramNode n) throws VisitorException {
        for (var b : n.bindings) {
            b.expr = visit(b.expr);
        }
        return null;
    }
    @Override
    protected ExpressionNode visitString(StringNode n) throws VisitorException {
        return n;
    }
    @Override
    protected ExpressionNode visitRange(RangeNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
    @Override
    protected ExpressionNode visitList(ListNode n) throws VisitorException {
        var node = n.clone();
        for (var i = 0; i < node.exprs.size(); i++) {
            node.exprs.set(i, visit(node.exprs.get(i)));
        }
        return node;
    }
    @Override
    protected ExpressionNode visitMatch(MatchNode n) throws VisitorException {
        // assume the match expression has already been checked for exhaustiveness
        // transform match into a series of if-else expressions

        ExpressionNode expr = unreachable();
        for (var i = n.patterns.size() - 1; i >= 0; i--) {
            var branch = n.patterns.get(i);
            var nextExpr = new IfElseNode(branch.source);
            
            var patVis = new PatternMatchGen(n.expr);
            var cond = patVis.visit(branch.pattern);
            nextExpr.boolExpr = cond != null ? cond : new BoolNode(null, true); 

            {
                var bExpr = branch.expr;
                for (var e : patVis.bindings.entrySet()) {
                    var decl = e.getKey();
                    var tmp = new LetExpressionNode(null, decl.identifier);
                    tmp.expr = e.getValue();
                    tmp.next = bExpr;
                    tmp.declaration.typeScheme = decl.typeScheme;
                    bExpr = tmp;
                }
                nextExpr.trueCase = bExpr;
            }
            nextExpr.elseCase = expr;
            expr = nextExpr;
        }
        return expr;
    }

    ExpressionNode unreachable() {
        var node = new FunctionInvocationNode(null);
        node.identifier = new IdentifierNode(null, "$$unreachable");
        return node;
    }

    class PatternMatchGen extends PatternVisitorT<ExpressionNode> {
        final List<ExpressionNode> exprToMatch = new ArrayList<>();
        final Map<IdentifierDeclarationNode, ExpressionNode> bindings = new HashMap<>();

        public PatternMatchGen(ExpressionNode expr) {
            this.exprToMatch.add(expr);
        }

        public ExpressionNode currentExpr() {
            return exprToMatch.get(exprToMatch.size() - 1);
        }

        public void popExpr() {
            exprToMatch.remove(exprToMatch.size() - 1);
        }

        @Override
        protected ExpressionNode visitPatternVar(PatternVarNode n) throws VisitorException {
            bindings.put(n.decl, currentExpr());
            return null;
        }
        @Override
        protected ExpressionNode visitPatternListEmpty(PatternListEmpty n) throws VisitorException {
            var node = new FunctionInvocationNode(null);
            node.identifier = new IdentifierNode(null, "$$list_is_empty");
            node.arguments.add(currentExpr());
            return node;
        }
        @Override
        protected ExpressionNode visitPatternListCons(PatternListCons n) throws VisitorException {
            // if not(isEmpty(currentExpr)) && visit(head) && visit(tail)
            ExpressionNode node;
            {
                var tmpNode = new FunctionInvocationNode(null);
                tmpNode.identifier = new IdentifierNode(null, "$$list_is_empty");
                tmpNode.arguments.add(currentExpr());
                node = tmpNode;
            }
            {
                var tmpNode = new FunctionInvocationNode(null);
                tmpNode.identifier = new IdentifierNode(null, "not");
                tmpNode.arguments.add(node);
                node = tmpNode;
            }
            {
                {
                    var expr = new FunctionInvocationNode(null);
                    expr.identifier = new IdentifierNode(null, "$$list_head");
                    expr.arguments.add(currentExpr());
                    exprToMatch.add(expr);
                }
                var head = visit(n.head);
                popExpr();
                if (head != null) {
                    var tmpNode = new FunctionInvocationNode(null);
                    tmpNode.identifier = new IdentifierNode(null, "&&");   
                    tmpNode.arguments.add(node);
                    tmpNode.arguments.add(head);
                    node = tmpNode;
                }
            }
            {
                {
                    var expr = new FunctionInvocationNode(null);
                    expr.identifier = new IdentifierNode(null, "$$list_tail");
                    expr.arguments.add(currentExpr());
                    exprToMatch.add(expr);
                }
                var tail = visit(n.tail);
                popExpr();
                if (tail != null) {
                    var tmpNode = new FunctionInvocationNode(null);
                    tmpNode.identifier = new IdentifierNode(null, "&&");   
                    tmpNode.arguments.add(node);
                    tmpNode.arguments.add(tail);
                    node = tmpNode;
                }
            }
            return node;
        }
    }
}