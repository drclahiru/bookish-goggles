package compiler.visitor;

import compiler.ast.*;
import java.util.*;

// reference material:
//     https://www.cs.cornell.edu/courses/cs3110/2016fa/l/17-inference/notes.html

public class TypeInferencer {
    final HashMap<Identifier, IdentifierDeclarationNode> declMap;

    public TypeInferencer(HashMap<Identifier, IdentifierDeclarationNode> declMap) {
        this.declMap = declMap;
    }

    public void run(ProgramNode p) throws VisitorException{
        new PreliminaryTypeSetter().visit(p);
        var uni = new TypeUnifier();
        uni.visitProgram(p);
        declMap.forEach((i, decl) -> {
            if (decl.type == null) {
                decl.type = uni.subber.sub(decl.identifier.inferredType);
            }
        });
    }

    class TypeUnifier extends VisitorVoid {
        final HashMap<Identifier, TypeNode> idTypeMap;
        final Substituter subber = new Substituter();
        final List<TypePair> constraints = new ArrayList<>();

        public TypeUnifier() {
            var idTypeMap = Utility.createPrelude();
            declMap.forEach((id, decl) -> {
                idTypeMap.put(id, decl.identifier.inferredType);
            });
            this.idTypeMap = idTypeMap;
        }

        void addConstraint(TypeNode a, TypeNode b) {
            constraints.add(new TypePair(a, b));
        }

        void unify() {
            var cs = constraints;
            for (var i = 0; i < cs.size(); i++) {
                var c = cs.get(i);
                if (c.type1.equals(c.type2)) {
                    continue;
                }
                if (c.type1 instanceof VariableTypeNode && !typeContains(c.type2, (VariableTypeNode)c.type1)) {
                    subber.addMapping(c.type1, c.type2);
                    subFromIdx(cs, i);
                    continue;
                }
                if (c.type2 instanceof VariableTypeNode && !typeContains(c.type1, (VariableTypeNode)c.type2)) {
                    subber.addMapping(c.type2, c.type1);
                    subFromIdx(cs, i);
                    continue;
                }
                if (c.type1 instanceof FunctionTypeNode && c.type2 instanceof FunctionTypeNode) {
                    var t1 = (FunctionTypeNode)c.type1;
                    var t2 = (FunctionTypeNode)c.type2;
                    if (t1.parameters.size() != t2.parameters.size()) {
                        throw new Error("arity mismatch between function types \"" + t1 + "\" and \"" + t2 + "\"");
                    }
                    for (var j = 0; j < t1.parameters.size() && j < t2.parameters.size(); j++) {
                        cs.add(new TypePair(t1.parameters.get(j), t2.parameters.get(j)));
                    }
                    cs.add(new TypePair(t1.return_, t2.return_));
                    continue;
                }
                throw new Error("Unification between \"" + c.type1 + "\" and \"" + c.type2 + "\" is untypeable");
            }
        }

        void subFromIdx(List<TypePair> cs, int idx) {
            for (var i = idx; i < cs.size(); i++) {
                cs.set(i, subber.sub(cs.get(i)));
            }
        }

        TypeNode assertPreliminary(TypeNode t, String location) {
            if (t == null) {
                throw new Error(location + ": preliminary type not set");
            }
            return t;
        }

        @Override
        protected void visitProgram(ProgramNode n) throws VisitorException {
            for (var b : n.bindings) {
                visit(b.declaration);
            }
            for (var b : n.bindings) {
                visit(b.expr);
                addConstraint( 
                    b.declaration.identifier.inferredType,
                    b.expr.inferredType
                );
            }
            unify();
        }

        @Override
        protected void visitFunction(FunctionNode n) throws VisitorException {
            var tEq = new FunctionTypeNode(n.source);
            n.parameters.forEach(param -> {
                tEq.parameters.add(
                    assertPreliminary(param.identifier.inferredType, "function param")
                );
            });
            tEq.return_ = assertPreliminary(n.return_.inferredType, "function return");
            addConstraint(n.inferredType, tEq);

            for (var p : n.parameters) {
                visit(p);
            }
            for (var b : n.body) {
                visit(b.declaration);
            }
            for (var b : n.body) {
                visit(b.expr);
                addConstraint( 
                    b.declaration.identifier.inferredType,
                    b.expr.inferredType
                );
            }
            visit(n.return_);
            unify();
        }

        @Override
        protected void visitIfElse(IfElseNode n) throws VisitorException {
            super.visitIfElse(n);
            addConstraint(n.boolExpr.inferredType, new SimpleTypeNode(n.boolExpr.source, SimpleType.Bool));
            addConstraint(n.inferredType, n.trueCase.inferredType);
            addConstraint(n.trueCase.inferredType, n.elseCase.inferredType);
        }

        @Override
        protected void visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
            super.visitFunctionInvocation(n);
            var t = idTypeMap.get(n.identifier.value);
            if (t instanceof FunctionTypeNode) {
                var tf = (FunctionTypeNode)t;
                addConstraint(n.inferredType, tf.return_);
                if (n.arguments.size() != tf.parameters.size()) {
                    throw new Error("arity mismatch between definition and invocation");
                }
                for (var i = 0; i < n.arguments.size() && i < tf.parameters.size(); i++) {
                    addConstraint(n.arguments.get(i).inferredType, tf.parameters.get(i));
                }
            } else if (t instanceof VariableTypeNode) {
                var f = new FunctionTypeNode(n.source);
                for (var arg : n.arguments) {
                    f.parameters.add(
                        assertPreliminary(arg.inferredType, "functionInvocation arg")
                    );
                }
                f.return_ = assertPreliminary(n.inferredType, "functionInvocation return");
                addConstraint(f, t);
            } else if (t == null) {
                throw new Error("no declaration found for invoked function");
            } else {
                throw new Error("unexpected type for " + n + " found: " + t);
            }
        }
    }

    class TypeVarGenerator {
        int nextTypeVarId = 1;

        public VariableTypeNode next() {
            return new VariableTypeNode(nextTypeVarId++);
        }
    }

    class PreliminaryTypeSetter extends VisitorVoid {
        final HashMap<Identifier, TypeNode> prelude;
        final TypeVarGenerator typeGen;

        public PreliminaryTypeSetter() {
            this.prelude = Utility.createPrelude();
            this.typeGen = new TypeVarGenerator();
        }
        
        @Override
        protected void visitBool(BoolNode n) {
            n.inferredType = new SimpleTypeNode(n.source, SimpleType.Bool);
        }
    
        @Override
        protected void visitNumber(NumberNode n) {
            n.inferredType = new SimpleTypeNode(n.source, SimpleType.Number);
        }
    
        @Override
        protected void visitString(StringNode n) {
            n.inferredType = new SimpleTypeNode(n.source, SimpleType.String);
        }
    
        @Override
        protected void visitIdentifier(IdentifierNode n) {
            var decl = declMap.get(n.value);
            if (decl != null) {
                n.inferredType = decl.identifier.inferredType;
            } else if (!prelude.containsKey(n.value)) {
                throw new Error("Identifier has no definition: " + n.value);
            }
        }
    
        @Override
        protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) {
            if (n.type != null) {
                n.identifier.inferredType = n.type;
            } else {
                n.identifier.inferredType = typeGen.next();
            }
        }
    
        @Override
        protected void visitExpression(ExpressionNode n) throws VisitorException {
            n.inferredType = typeGen.next();
            super.visitExpression(n);
        }

        @Override
        protected void visitProgram(ProgramNode n) throws VisitorException {
            for (var b : n.bindings) {
                visit(b.declaration);
            }
            for (var b : n.bindings) {
                visit(b.expr);
            }
        }
        
        @Override
        protected void visitFunction(FunctionNode n) throws VisitorException {
            for (var p : n.parameters) {
                visit(p);
            }
            for (var b : n.body) {
                visit(b.declaration);
            }
            for (var b : n.body) {
                visit(b.expr);
            }
            visit(n.return_);

            var t = new FunctionTypeNode(n.source);
            n.parameters.forEach(param -> {
                t.parameters.add(param.identifier.inferredType);
            });
            t.return_ = n.return_.inferredType;
            n.inferredType = t;
        }

        @Override
        protected void visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
            super.visitFunctionInvocation(n);
            var t = new FunctionTypeNode(n.source);
            n.arguments.forEach(arg -> {
                t.parameters.add(arg.inferredType);
            });
            t.return_ = n.inferredType;
            n.identifier.inferredType = t;
        }
    }

    class Substituter {
        final Map<TypeNode, TypeNode> subs = new HashMap<>();

        public void addMapping(TypeNode from, TypeNode to) {
            subs.put(from, to);

            var fromValueKeys = new ArrayList<TypePair>();
            subs.forEach((k, v) -> {
                var sVal = sub(v);
                if (!sVal.equals(v)) {
                    fromValueKeys.add(new TypePair(k, sVal));
                }
            });
            for (var x : fromValueKeys) {
                subs.put(x.type1, x.type2);
            }
        }
        public TypeNode sub(TypeNode t) {
            if (t == null) {
                throw new Error("Attempt to substitute non-type null");
            }
            if (t instanceof FunctionTypeNode) {
                var tf = (FunctionTypeNode)t;
                var f = new FunctionTypeNode(tf.source);
                tf.parameters.forEach(p -> {
                    f.parameters.add(sub(p));
                });
                f.return_ = sub(tf.return_);
                return f;
            }
            if (subs.containsKey(t)) {
                t = subs.get(t);
            }
            return t;
        }
        public TypePair sub(TypePair t) {
            return new TypePair(sub(t.type1), sub(t.type2));
        }
        public HashSet<TypePair> sub(Set<TypePair> ts) {
            var next = new HashSet<TypePair>();
            for (var t : ts) {
                next.add(sub(t));
            } 
            return next;
        }
        public ArrayList<TypePair> sub(ArrayList<TypePair> ts) {
            var next = new ArrayList<TypePair>();
            for (var t : ts) {
                var newT = sub(t);
                if (!next.contains(newT)) {
                    next.add(newT);
                }
            }
            return next;
        }
    }

    class TypePair {
        final TypeNode type1;
        final TypeNode type2;
        
        public TypePair(TypeNode type1, TypeNode type2) {
            this.type1 = type1;
            this.type2 = type2;
        }
    
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof TypePair)) {
                return false;
            }
    
            var other = (TypePair)o;
            return (this.type1.equals(other.type1) && this.type2.equals(other.type2))
                || (this.type1.equals(other.type2) && this.type2.equals(other.type1));
        }
        
        @Override
        public int hashCode() {
            var h1 = type1.hashCode();
            var h2 = type2.hashCode();
            if (h1 < h2) {
                return Objects.hash(h1, h2);
            } else {
                return Objects.hash(h2, h1);
            }
        }

        @Override
        public String toString() {
            return "" + type1 + " <-> " + type2;
        }
    }
    
    static boolean typeContains(TypeNode t, VariableTypeNode v) {
        if (t instanceof SimpleTypeNode) {
            return false;
        }
        if (t instanceof VariableTypeNode) {
            return ((VariableTypeNode)t).id == v.id;
        }
        if (t instanceof FunctionTypeNode) {
            var t_ = (FunctionTypeNode)t;

            for (var p : t_.parameters) {
                if (typeContains(p, v)) {
                    return true;
                }
            }
            return typeContains(t_.return_, v);
        }
        throw new Error("unexpected type: " + t);
    }
}