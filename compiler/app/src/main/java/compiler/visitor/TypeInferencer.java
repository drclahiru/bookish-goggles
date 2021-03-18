package compiler.visitor;

import compiler.ast.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Consumer;

// reference material:
//     https://www.cs.cornell.edu/courses/cs3110/2016fa/l/17-inference/notes.html

public class TypeInferencer {
    final HashMap<Identifier, IdentifierDeclarationNode> idMap;

    public TypeInferencer(HashMap<Identifier, IdentifierDeclarationNode> idMap) {
        this.idMap = idMap;
    }

    public void run(ProgramNode p) {
        new PreliminaryTypeSetter(idMap).run(p);
        // new InferredTypePrinter(System.out).run(p);
        var uni = new TypeUnifier(idMap);
        uni.run(p);

        // System.out.println("====");
        // System.out.println("Substitutions:");
        // uni.substitutions.forEach((t1, t2) -> {
        //     System.out.print(t1);
        //     System.out.print(" -> ");
        //     System.out.print(t2);
        //     System.out.println();
        // });
        // System.out.println("====");

        new TypeSubber(uni.substitutions).visit(p);
    }

    class TypeConstraint {
        final TypeNode type1;
        final TypeNode type2;
        
        public TypeConstraint(TypeNode type1, TypeNode type2) {
            this.type1 = type1;
            this.type2 = type2;
        }
    
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof TypeConstraint)) {
                return false;
            }
    
            var other = (TypeConstraint)o;
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

    class TypeSubber extends Visitor {
        final HashMap<TypeNode, TypeNode> substitutions;
        public TypeSubber(HashMap<TypeNode, TypeNode> substitutions) {
            this.substitutions = substitutions;
        }

        TypeNode sub(TypeNode t) {
            if (t instanceof FunctionTypeNode) {
                var tf = (FunctionTypeNode)t;
                return AST.funcType(f -> {
                    tf.parameters.forEach(p -> {
                        f.parameters.add(sub(p));
                    });
                    f.return_ = sub(tf.return_);
                });
            }
            while (substitutions.containsKey(t)) {
                t = sub(substitutions.get(t));
            }
            return t;
        }

        @Override
        protected void visitLetBinding(LetBindingNode n) {
            n.declaration.type = sub(n.declaration.identifier.inferredType);
            visit(n.expr);
        }

        @Override
        protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) {
            n.type = sub(n.identifier.inferredType);
        }
    }

    class TypeUnifier extends Visitor {
        final Queue<ExpressionNode> deferredVisits = new LinkedList<>();
        final HashMap<Identifier, TypeNode> idTypeMap;
        final HashMap<TypeNode, TypeNode> substitutions;
        HashSet<TypeConstraint> constraints = new HashSet<>();

        public TypeUnifier(HashMap<Identifier, IdentifierDeclarationNode> idMap) {
            var idTypeMap = Utility.getPrelude();
            idMap.forEach((id, decl) -> {
                idTypeMap.put(id, decl.identifier.inferredType);
            });
            this.idTypeMap = idTypeMap;
            this.substitutions = new HashMap<>();
        }
        public TypeUnifier(HashMap<Identifier, TypeNode> idTypeMap, HashMap<TypeNode, TypeNode> substitutions) {
            this.idTypeMap = idTypeMap;
            this.substitutions = substitutions;
        }

        public void run(ProgramNode n) {
            scoped(v -> {
                v.visit(n);
            });
        }

        TypeNode sub(TypeNode t) {
            if (t == null) {
                throw new Error("Attempt to substitute non-type null");
            }
            if (t instanceof FunctionTypeNode) {
                var tf = (FunctionTypeNode)t;
                return AST.funcType(f -> {
                    tf.parameters.forEach(p -> {
                        f.parameters.add(sub(p));
                    });
                    f.return_ = sub(tf.return_);
                });
            }
            if (substitutions.containsKey(t)) {
                return substitutions.get(t);
            }
            return t;
        }

        TypeConstraint sub(TypeConstraint t) {
            return new TypeConstraint(sub(t.type1), sub(t.type2));
        }

        HashSet<TypeConstraint> sub(Set<TypeConstraint> ts) {
            var next = new HashSet<TypeConstraint>();
            for (var t : ts) {
                next.add(sub(t));
            }
            return next;
        }

        ArrayList<TypeConstraint> sub(ArrayList<TypeConstraint> ts) {
            var next = new ArrayList<TypeConstraint>();
            for (var t : ts) {
                var newT = sub(t);
                if (!next.contains(newT)) {
                    next.add(newT);
                }
            }
            return next;
        }

        void addConstraint(TypeNode a, TypeNode b) {
            constraints.add(new TypeConstraint(a, b));
        }

        void scoped(Consumer<TypeUnifier> f) {
            var v = new TypeUnifier(idTypeMap, substitutions);
            f.accept(v);
            while (!v.deferredVisits.isEmpty()) {
                var next = v.deferredVisits.remove();
                v.visit(next);
            }
            constraints.addAll(unify(v.constraints));
        }

        Set<TypeConstraint> unify(Set<TypeConstraint> cs) {
            var offset = 0;
            for (var c : cs) {
                offset += 1;
                if (c.type1.equals(c.type2)) {
                    continue;
                }
                if (c.type1 instanceof VariableTypeNode && !typeContains(c.type2, (VariableTypeNode)c.type1)) {
                    substitutions.put(c.type1, c.type2);
                    var nextCs = cs.stream().skip(offset).map(x -> sub(x)).collect(Collectors.toSet());
                    return unify(nextCs);
                }
                if (c.type2 instanceof VariableTypeNode && !typeContains(c.type1, (VariableTypeNode)c.type2)) {
                    substitutions.put(c.type2, c.type1);
                    var nextCs = cs.stream().skip(offset).map(x -> sub(x)).collect(Collectors.toSet());
                    return unify(nextCs);
                }
                if (c.type1 instanceof FunctionTypeNode && c.type2 instanceof FunctionTypeNode) {
                    var nextCs = cs
                        .stream()
                        .skip(offset)
                        .collect(Collectors.toSet());
                    var t1 = (FunctionTypeNode)c.type1;
                    var t2 = (FunctionTypeNode)c.type2;
                    if (t1.parameters.size() != t2.parameters.size()) {
                        throw new Error("arity mismatch between function types \"" + t1 + "\" and \"" + t2 + "\"");
                    }
                    for (var i = 0; i < t1.parameters.size() && i < t2.parameters.size(); i++) {
                        nextCs.add(new TypeConstraint(t1.parameters.get(i), t2.parameters.get(i)));
                    }
                    nextCs.add(new TypeConstraint(t1.return_, t2.return_));
                    return unify(nextCs);
                }
                throw new Error("Unification between \"" + c.type1 + "\" and \"" + c.type2 + "\" is untypeable");
            }
            return new HashSet<>();
        }

        TypeNode assertPriliminaryType(TypeNode t, String location) {
            if (t == null) {
                throw new Error(location + ": preliminary type not set");
            }
            return t;
        }

        @Override
        protected void visitLetBinding(LetBindingNode n) {
            addConstraint( 
                n.declaration.identifier.inferredType,
                n.expr.inferredType
            );
            deferredVisits.add(n.expr);
        }
        
        @Override
        protected void visitFunction(FunctionNode n) {
            addConstraint(
                n.inferredType,
                AST.funcType(f -> {
                    n.parameters.forEach(param -> {
                        f.parameters.add(
                            assertPriliminaryType(param.identifier.inferredType, "function param")
                        );
                    });
                    f.return_ = assertPriliminaryType(n.return_.inferredType, "function return");
                })
            );
            scoped(v -> {
                n.parameters.stream().forEach((p) -> v.visit(p));
                n.body.stream().forEach((p) -> v.visit(p));
                v.deferredVisits.add(n.return_);
            });
        }

        @Override
        protected void visitIfElse(IfElseNode n) {
            super.visitIfElse(n);
            addConstraint(n.boolExpr.inferredType, AST.boolType());
            addConstraint(n.inferredType, n.trueCase.inferredType);
            addConstraint(n.trueCase.inferredType, n.elseCase.inferredType);
        }
        
        @Override
        protected void visitOperator(OperatorNode n) {
            visitFunctionInvocation(n);
        }

        @Override
        protected void visitFunctionInvocation(FunctionInvocationNode n) {
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
                addConstraint(
                    AST.funcType(f -> {
                        for (var arg : n.arguments) {
                            f.parameters.add(
                                assertPriliminaryType(arg.inferredType, "functionInvocation arg")
                            );
                        }
                        f.return_ = assertPriliminaryType(n.inferredType, "functionInvocation return");
                    }),
                    t
                );
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

    class PreliminaryTypeSetter extends Visitor {
        final Queue<ExpressionNode> deferredVisits = new LinkedList<>();
        final HashMap<Identifier, IdentifierDeclarationNode> idMap;
        final TypeVarGenerator typeGen;

        public PreliminaryTypeSetter(HashMap<Identifier, IdentifierDeclarationNode> idMap) {
            this.idMap = idMap;
            this.typeGen = new TypeVarGenerator();
        }
        PreliminaryTypeSetter(HashMap<Identifier, IdentifierDeclarationNode> idMap, TypeVarGenerator typeGen) {
            this.idMap = idMap;
            this.typeGen = typeGen;
        }

        public void run(ProgramNode n) {
            // ensure all the let declarations have their preliminary type so that 
            // when we visit a reference to a declaration, we can use the declaration's
            // type.
            idMap.forEach((t, x) -> {
                visit(x);
            });
            scoped(v -> {
                v.visit(n);
            });
        }

        void scoped(Consumer<PreliminaryTypeSetter> f) {
            var v = new PreliminaryTypeSetter(idMap, typeGen);
            f.accept(v);
            while (!v.deferredVisits.isEmpty()) {
                var next = v.deferredVisits.remove();
                v.visit(next);
            }
        }

        @Override
        protected void visitBool(BoolNode n) {
            n.inferredType = AST.boolType();
        }
    
        @Override
        protected void visitNumber(NumberNode n) {
            n.inferredType = AST.numberType();
        }
    
        @Override
        protected void visitString(StringNode n) {
            n.inferredType = AST.stringType();
        }
    
        @Override
        protected void visitIdentifier(IdentifierNode n) {
            var decl = idMap.get(n.value);
            if (decl != null) {
                n.inferredType = decl.identifier.inferredType;
            } else {
                throw new Error("Identifier has no definition: " + n.value);
            }
        }
    
        @Override
        protected void visitExpression(ExpressionNode n) {
            n.inferredType = typeGen.next();
            super.visitExpression(n);
        }
    
        @Override
        protected void visitOperator(OperatorNode n) {
            visit(n.getLeft());
            n.identifier.inferredType = Utility.opType(n.operator);
            visit(n.getRight());
        }
        
        @Override
        protected void visitLetBinding(LetBindingNode n) {
            visit(n.declaration);
            deferredVisits.add(n.expr);
        }
        
        @Override
        protected void visitFunction(FunctionNode n) {
            scoped(v -> {
                n.parameters.stream().forEach((p) -> v.visit(p));
                n.body.stream().forEach((p) -> v.visit(p));
                v.deferredVisits.add(n.return_);
            });

            n.inferredType = AST.funcType(f -> {
                n.parameters.forEach(param -> {
                    f.parameters.add(param.identifier.inferredType);
                });
                f.return_ = n.inferredType;
            });
        }

        @Override
        protected void visitFunctionInvocation(FunctionInvocationNode n) {
            super.visitFunctionInvocation(n);
            n.identifier.inferredType = AST.funcType(f -> {
                n.arguments.forEach(arg -> {
                    f.parameters.add(arg.inferredType);
                });
                f.return_ = n.inferredType;
            });
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