package compiler.analysis;

import compiler.IdentifierContext;
import compiler.Utility;
import compiler.ast.*;
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
        InferenceVisitor(IdentifierContext ctx, Substitution subst) {
            this.ctx = ctx;
            this.subst = subst;
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
            return instantiate(scheme);
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
            var visitor = new InferenceVisitor(ctx.clone(), subst);
            var t = visitor.visitFunctionInner(n);
            addFromCtx(visitor.ctx);
            return t;
        }
        protected TypeNode visitFunctionInner(FunctionNode n) throws VisitorException {
            var params = new ArrayList<TypeNode>();
            for (var p : n.parameters) {
                var scheme = new TypeScheme(varGen.next());
                ctx.put(p.identifier.value, scheme);
                params.add(scheme.type);
            }
            var t = new FunctionTypeNode(n.source);
            t.return_ = visit(n.return_);
            for (var p : params) {
                t.parameters.add(subst.apply(p));
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
            var conditionT = visit(n.boolExpr);
            subst.unify(new SimpleTypeNode(null, SimpleType.Bool), conditionT);

            var branch1 = visit(n.trueCase);
            var branch2 = visit(n.elseCase);
            subst.unify(branch1, branch2);
            
            return subst.apply(branch1);
        }
        @Override
        protected TypeNode visitLetBinding(LetBindingNode n) throws VisitorException {
            var visitor = new InferenceVisitor(ctx.clone(), subst);
            var t = visitor.visitLetBindingInner(n);
            addFromCtx(visitor.ctx);
            return t;
        }
        protected TypeNode visitLetBindingInner(LetBindingNode n) throws VisitorException {
            ctx.put(n.declaration.identifier.value, generalize(ctx, varGen.next()));
            var t = visit(n.expr);
            if (n.declaration.typeScheme != null) {
                ctx.put(n.declaration.identifier.value, n.declaration.typeScheme);
                subst.unify(t, n.declaration.typeScheme.type);
            } else {
                ctx.put(n.declaration.identifier.value, generalize(ctx, t));
            }
            return null;
        }
        @Override
        protected TypeNode visitLetExpression(LetExpressionNode n) throws VisitorException {
            var t = visit(n.expr);
            var tyVar = varGen.next();
            ctx.put(n.declaration.identifier.value, new TypeScheme(tyVar));
            subst.unify(t, tyVar);
            var visitor = new InferenceVisitor(subst.apply(ctx), subst);
            var tNext = visitor.visit(n.next);
            addFromCtx(visitor.ctx);
            return tNext;
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
            throw new Error("Not implemented yet");
        }

        /**
         * add keys that only exist in {@code other} to {@code this.ctx}
         */
        void addFromCtx(IdentifierContext other) {
            for (var k : except(other.keySet(), ctx.keySet())) {
                ctx.put(k, other.get(k));
            }
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
            var out = super.put(key, value);
            var keyToUpdate = new Vector<VariableTypeNode>();
            super.forEach((k, v) -> {
                if (v == key) {
                    keyToUpdate.add(k);
                }
            });
            for (var k : keyToUpdate) {
                super.put(k, value);
            }
            return out;
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
            }
            return ty;
        }
    
        public TypeScheme apply(TypeScheme scheme) {
            var nextSubst = new Substitution(this);
            for (var v : scheme.vars) {
                nextSubst.remove(v);
            }
            var t = nextSubst.apply(scheme.type);
            return new TypeScheme(scheme.vars, t);
        }

        public IdentifierContext apply(IdentifierContext ctx) {
            var nextCtx = ctx.clone();
            for (var x : ctx.entrySet()) {
                nextCtx.put(x.getKey(), apply(x.getValue()));
            }
            return nextCtx;
        }

        void bindIdent(VariableTypeNode v, TypeNode ty) {
            if (freeTypeVars(ty).contains(v)) {
                throw new Error("occurs check failed");
            }
            put(v, ty);
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

    class TypeVarGenerator {
        int nextTypeVarId = 1;

        public VariableTypeNode next() {
            return new VariableTypeNode(Integer.toString(nextTypeVarId++));
        }
    }

    TypeNode instantiate(TypeScheme scheme) {
        var subst = new Substitution();
        for (var v : scheme.vars) {
            subst.put(v, varGen.next());
        }
        return subst.apply(scheme.type);
    }

    static TypeScheme generalize(IdentifierContext ctx, TypeNode t) {
        var vars = except(freeTypeVars(t), freeTypeVarsCtx(ctx));
        var sch = new TypeScheme(vars, t);
        return sch;
    }
    
    static Set<VariableTypeNode> freeTypeVars(TypeNode t) {
        var s = new HashSet<VariableTypeNode>();
        freeTypeVars(t, s);
        return s;
    }
    
    static void freeTypeVars(TypeNode t, Set<VariableTypeNode> s) {
        if (t instanceof VariableTypeNode) {
            s.add((VariableTypeNode)t);
        } else if (t instanceof FunctionTypeNode) {
            var tf = (FunctionTypeNode)t;
            for (var p : tf.parameters) {
                freeTypeVars(p, s);
            }
            freeTypeVars(tf.return_, s);
        }
    }

    static Set<VariableTypeNode> freeTypeVarsScheme(TypeScheme scheme) {
        return except(scheme.vars, freeTypeVars(scheme.type));
    }

    static Set<VariableTypeNode> freeTypeVarsCtx(IdentifierContext ctx) {
        Set<VariableTypeNode> s = new HashSet<VariableTypeNode>();
        var vals = ctx.values();
        for (var sch : vals) {
            s.addAll(freeTypeVarsScheme(sch));
        }
        return s;
    }

    static<T> Set<T> difference(Set<T> s1, Set<T> s2) {
        var s3 = new HashSet<T>(s1);
        for (var val : s2) {
            if (s3.contains(val)) {
                s3.remove(val);
            } else {
                s3.add(val);
            }
        }
        return s3;
    }

    /**
     * returns the set of elements that appear in {@code s1}, but not in {@code s2}.
     * 
     * @param s1 
     * @param s2 
     * @param <T> type of elements in the set
     */
    static<T> Set<T> except(Set<T> s1, Set<T> s2) {
        var s3 = new HashSet<T>(s1);
        for (var val : s2) {
            s3.remove(val);
        }
        return s3;
    }
}