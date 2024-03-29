package compiler.analysis;

import compiler.IdentifierContext;
import compiler.TypeVarGenerator;
import compiler.Utility;
import compiler.ast.*;
import compiler.visitor.PatternVisitorT;
import compiler.visitor.VisitorException;
import compiler.visitor.VisitorExceptionAggregate;
import compiler.visitor.VisitorT;
import compiler.visitor.VisitorVoid;

import java.util.*;

public class TypeInferencer {
    final HashMap<Identifier, IdentifierDeclarationNode> declMap;
    final TypeVarGenerator varGen = new TypeVarGenerator();

    public TypeInferencer(HashMap<Identifier, IdentifierDeclarationNode> declMap) {
        this.declMap = declMap;
    }
    public IdentifierContext run(ProgramNode pn) throws VisitorExceptionAggregate {
        var exceptions = new ArrayList<VisitorException>();
        
        var v = new InferenceVisitor();
        for (var bind : pn.bindings) {
            try {
                v.visitLetBinding(bind);
            } catch (VisitorException ex) {
                exceptions.add(ex);
            }
        }
        if (exceptions.size() > 0) {
            throw new VisitorExceptionAggregate(exceptions);
        }
        var ctx = v.subst.apply(v.ctx);
        declMap.forEach((i, decl) -> {
            if (decl.typeScheme == null) {
                decl.typeScheme = ctx.get(decl.identifier.value);
            }
        });
        for (var bind : pn.bindings) {
            try {
                new ApplyInferred(v.subst).visit(bind);
            } catch (VisitorException ex) {
            }
        }
        return ctx;
    }

    class ApplyInferred extends VisitorVoid {
        final Substitution subst;
        public ApplyInferred(Substitution subst) {
            this.subst = subst;
        }
        @Override
        public void visit(AbstractNode n) throws VisitorException {
            n.type = subst.apply(n.type);
            super.visit(n);
        }
    }

    class InferenceVisitor extends VisitorT<TypeNode> {
        final IdentifierContext ctx;
        final Substitution subst;

        public InferenceVisitor() {
            ctx = Utility.createPrelude();
            subst = new Substitution();
        }

        public TypeNode run(ExpressionNode n) throws VisitorException {
            var typeResult = visit(n);
            return subst.apply(typeResult);
        }
        
        @Override
        public TypeNode visit(AbstractNode n) throws VisitorException {
            return n.type = super.visit(n);
        }

        @Override
        protected TypeNode visitIdentifier(IdentifierNode n) {
            var scheme = ctx.get(n.value);
            if (scheme == null) {
                throw new Error("unbound variable: " + n.value);
            }
            // scopeId 1 is globalScope, and the prelude is defined with scope null
            if (n.value.scopeId == null || n.value.scopeId == 1) {
                return scheme.instantiate(varGen);
            }
            return scheme.type;
        }
        @Override
        protected TypeNode visitBool(BoolNode n) {
            return new SimpleTypeNode(n.source, SimpleType.Bool);
        }
        @Override
        protected TypeNode visitNumber(NumberNode n) {
            return new SimpleTypeNode(n.source, SimpleType.Number);
        }
        @Override
        protected TypeNode visitString(StringNode n) {
            return new SimpleTypeNode(n.source, SimpleType.String);
        }
        @Override
        protected TypeNode visitFunction(FunctionNode n) throws VisitorException {
            for (var p : n.parameters) {
                var scheme = new TypeScheme(varGen.next());
                ctx.put(p.identifier.value, scheme);
            }
            var t = new FunctionTypeNode(n.source);
            t.return_ = visit(n.return_);
            for (var p : n.parameters) {
                var pt = ctx.get(p.identifier.value).type;
                t.parameters.add(subst.apply(pt));
            }
            return t;
        }
        @Override
        protected TypeNode visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
            var tyRes = varGen.next();
            var identifierT = visitIdentifier(n.identifier);

            var tf = new FunctionTypeNode(n.source);
            for (var a : n.arguments) {
                tf.parameters.add(visit(a));
            }
            tf.return_ = tyRes;
            subst.unify(identifierT, tf);
            return subst.apply(tyRes);
        }
        @Override
        protected TypeNode visitIfElse(IfElseNode n) throws VisitorException {
            subst.unify(new SimpleTypeNode(null, SimpleType.Bool), visit(n.boolExpr));

            var branch1 = visit(n.trueCase);
            var branch2 = visit(n.elseCase);
            subst.unify(branch1, branch2);
            
            return subst.apply(branch1);
        }
        @Override
        protected TypeNode visitLetBinding(LetBindingNode n) throws VisitorException {
            var tempT = varGen.next();
            ctx.put(n.declaration.identifier.value, new TypeScheme(tempT));
            var t = visit(n.expr);
            subst.unify(t, tempT);
            if (n.declaration.typeScheme != null) {
                subst.unify(t, n.declaration.typeScheme.type);
                ctx.put(
                    n.declaration.identifier.value,
                    n.declaration.typeScheme
                );
            } else {
                ctx.put(
                    n.declaration.identifier.value,
                    subst.apply(t).generalize(varGen)
                );
            }
            return null;
        }
        @Override
        protected TypeNode visitLetExpression(LetExpressionNode n) throws VisitorException {
            ctx.put(n.declaration.identifier.value, new TypeScheme(visit(n.expr)));
            return visit(n.next);
        }
        @Override
        protected TypeNode visitProgram(ProgramNode n) throws VisitorException {
            throw new Error("Shouldn't be visited");
        }
        @Override
        protected TypeNode visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
            throw new Error("Shouldn't be visited");
        }
        @Override
        protected TypeNode visitRange(RangeNode n) throws VisitorException {
            throw new Error("Shouldn't be visited");
        }
        @Override
        protected TypeNode visitList(ListNode n) throws VisitorException {
            var t = varGen.next();
            for (var arg : n.exprs) {
                subst.unify(t, visit(arg));
            }
            return new ListTypeNode(n.source, subst.apply(t));
        }

        @Override
        protected TypeNode visitMatch(MatchNode n) throws VisitorException {
            var patVisitor = new InferencePatternVisitor(subst, ctx);

            var exprT = visit(n.expr);
            var returnT = varGen.next();

            for (var pat : n.patterns) {
                subst.unify(exprT, patVisitor.visit(pat.pattern));
                subst.unify(returnT, visit(pat.expr));
            }
            return subst.apply(returnT);
        }
    }

    class InferencePatternVisitor extends PatternVisitorT<TypeNode> {
        final Substitution subst;
        final IdentifierContext ctx;
        public InferencePatternVisitor(Substitution subst, IdentifierContext ctx) {
            this.subst = subst;
            this.ctx = ctx;
        }

        @Override
        protected TypeNode visitPatternVar(PatternVarNode n) throws VisitorException {
            var t = varGen.next();
            ctx.put(n.decl.identifier.value, new TypeScheme(t));
            return t;
        }
        @Override
        protected TypeNode visitPatternListEmpty(PatternListEmpty n) throws VisitorException {
            return new ListTypeNode(n.source, varGen.next());
        }
        @Override
        protected TypeNode visitPatternListCons(PatternListCons n) throws VisitorException {
            var headT = visit(n.head);
            var tailT = visit(n.tail);
            var t = new ListTypeNode(n.source, headT);
            subst.unify(t, tailT);
            return subst.apply(t);
        }
    }

    class Substitution extends HashMap<VariableTypeNode, TypeNode> {
        static final long serialVersionUID = 1L;
        public Substitution() {
            super();
        }
        public Substitution(Substitution sub) {
            super(sub);
        }
    
        @Override
        public TypeNode put(VariableTypeNode key, TypeNode value) {
            var keyToUpdate = new Vector<VariableTypeNode>();
            super.forEach((k, v) -> {
                if (v == key) {
                    keyToUpdate.add(k);
                }
            });
            for (var k : keyToUpdate) {
                super.put(k, value);
            }
            return super.put(key, value);
        }
    
        public TypeNode apply(TypeNode ty) {
            if (ty instanceof VariableTypeNode) {
                var t = (VariableTypeNode)ty;
                var t2 = get(t);
                if (t2 != null) {
                    return t2;
                }
            } else if (ty instanceof FunctionTypeNode) {
                var t = (FunctionTypeNode)ty;
                var tf = new FunctionTypeNode(ty.source);
                for (var p : t.parameters) {
                    tf.parameters.add(apply(p));
                }
                tf.return_ = apply(t.return_);
                return tf;
            } else if (ty instanceof ListTypeNode) {
                var t = (ListTypeNode)ty;
                return new ListTypeNode(ty.source, apply(t.innerType));
            }
            return ty;
        }
    
        public TypeScheme apply(TypeScheme scheme) {
            var nextSubst = new Substitution(this);
            for (var v : scheme.getTypeVars()) {
                nextSubst.remove(v);
            }
            var t = nextSubst.apply(scheme.type);
            return new TypeScheme(t);
        }
    
        public IdentifierContext apply(IdentifierContext ctx) {
            var nextCtx = ctx.clone();
            for (var x : ctx.entrySet()) {
                nextCtx.put(x.getKey(), apply(x.getValue()));
            }
            return nextCtx;
        }
    
        void bindIdent(VariableTypeNode v, TypeNode ty) {
            if (ty.getTypeVars().contains(v)) {
                throw new Error("occurs check failed");
            }

            var oldTy = get(v);
            if (oldTy != null) {
                unify(ty, oldTy);
                put(v, apply(ty));
            } else {
                put(v, ty);
            }

        }
        public void unify(TypeNode t1, TypeNode t2) {
            t1 = apply(t1);
            t2 = apply(t2);
            if (t1.equals(t2)) {
                // do nothing
            } else if (t1 instanceof VariableTypeNode) {
                bindIdent((VariableTypeNode)t1, t2);
            } else if (t2 instanceof VariableTypeNode) {
                bindIdent((VariableTypeNode)t2, t1);
            } else if (t1 instanceof FunctionTypeNode && t2 instanceof FunctionTypeNode) {
                var t1t = (FunctionTypeNode)t1;
                var t2t = (FunctionTypeNode)t2;
                if (t1t.parameters.size() != t2t.parameters.size()) {
                    System.out.println("arity mismatch between " + t1t + " and " + t2t);
                }
                for (var i = 0; i < Math.min(t1t.parameters.size(), t2t.parameters.size()); i++) {
                    unify(t1t.parameters.get(i), t2t.parameters.get(i));
                }
                unify(apply(t1t.return_), apply(t2t.return_));
            } else if (t1 instanceof ListTypeNode && t2 instanceof ListTypeNode) {
                unify(((ListTypeNode)t1).innerType, ((ListTypeNode)t2).innerType);
            } else {
                System.out.println("types do not unify: " + t1 + " and " + t2);
            }
        }
    
        @Override
        public String toString() {
            var s = new StringBuilder();
            s.append("{");
            this.entrySet().stream().limit(1).forEach(x -> {
                s.append(x.getKey());
                s.append(" => ");
                s.append(x.getValue());
            });
            this.entrySet().stream().skip(1).forEach(x -> {
                s.append(" ; ");
                s.append(x.getKey());
                s.append(" => ");
                s.append(x.getValue());
            });
            s.append("}");
            return s.toString();
        }
    }
}