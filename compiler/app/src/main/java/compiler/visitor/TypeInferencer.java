package compiler.visitor;

import compiler.ast.*;
import java.util.*;
import java.util.stream.Collectors;

// reference material:
//     https://www.cs.cornell.edu/courses/cs3110/2016fa/l/17-inference/notes.html

public class TypeInferencer {
    public void run(ProgramNode p) {
        // idTable might be unnecessary at this stage.
        // we can unify the inferred types with the annotated types
        // after type inferrence... or?
        var idTable = new CollectIdentifierDeclarations().run(p);
        new SetPreliminaryType(idTable).visit(p);
        new TypeReconstructor().run(p);
        new InferredTypePrinter(System.out).run(p);
    }

    class TypeConstraint {
        final TypeNode type1;
        final TypeNode type2;
        public TypeConstraint(TypeNode type1, TypeNode type2) {
            this.type1 = type1;
            this.type2 = type2;
        }
    }

    class TypeReconstructor extends Visitor {
        final Queue<ExpressionNode> deferredVisits = new LinkedList<>();
        final HashMap<Identifier, IdentifierDeclarationNode> idTable;
        final HashMap<TypeNode, TypeNode> substitutions;

        public TypeReconstructor(HashMap<Identifier, IdentifierDeclarationNode> idTable) {
            this.idTable = idTable;
            this.substitutions = new HashMap<>();
        }
        public TypeReconstructor(HashMap<Identifier, IdentifierDeclarationNode> idTable, HashMap<TypeNode, TypeNode> substitutions) {
            this.idTable = idTable;
            this.substitutions = substitutions;
        }

        public void run(ProgramNode n) {
            visit(n);
        }

        TypeNode sub(TypeNode t) {
            if (t instanceof FunctionTypeNode) {
                var tf = (FunctionTypeNode)t;
                return AST.funcType(f -> {
                    tf.parameters.forEach(p -> {
                        f.parameters.add(substitute(p));
                    });
                    f.return_ = substitute(tf.return_);
                });
            } else {
                // we need to ensure that this can't be circular
                while (substitutions.containsKey(t)) {
                    t = substitutions.get(t);
                }
                return t;
            }
        }

        TypeConstraint sub(TypeConstraint t) {
            return new TypeConstraint(sub(t.type1), sub(t.type2));
        }

        HashSet<TypeConstraint> sub(HashSet<TypeConstraint> ts) {
            var next = new HashSet<TypeConstraint>();
            for (var t : ts) {
                next.add(sub(t));
            }
            return next;
        }

        void scoped(Consumer<ScopeResolver> f) {
            var v = new TypeReconstructor(idTable, substitutions);
            f.accept(v);
            while (!v.deferredVisits.isEmpty()) {
                var next = v.deferredVisits.remove();
                v.visit(next);
            }
        }
    
        void enqueue(ExpressionNode n) {
            this.deferredVisits.add(n);
        }

        @Override
        protected void visitFunction(FunctionNode node) {
            scoped(v -> {
                node.parameters.stream().forEach((p) -> v.visit(p));
                node.body.stream().forEach((p) -> v.visit(p));
                v.enqueue(node.return_);
            });
        }

        @Override
        protected void visitLetBinding(LetBindingNode node) {
            visit(node.declaration);
            enqueue(node.expr);
        }
    

        @Override
        protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) {
            defaultVisit(n);
        }
    }

    class TypeUnifier {
        TypeNode unify(TypeNode l, TypeNode r) {
            if (l instanceof SimpleTypeNode) {
                return unifySimple((SimpleTypeNode)l, r);
            } else if (l instanceof GenericTypeNode) {
                return unifyGeneric((GenericTypeNode)l, r);
            } else if (l instanceof FunctionTypeNode){
                return unifyFunction((FunctionTypeNode)l, r);
            } else {
                throw new Error("Unexpected type: " + l);
            }
        }
        TypeNode unifySimple(SimpleTypeNode l, TypeNode r) {
            if (r instanceof GenericTypeNode || l.equals(r)) {
                return l;
            }
            return null;
        }

        TypeNode unifyGeneric(GenericTypeNode l, TypeNode r) {
            if (r instanceof GenericTypeNode) {
                return l;
            }
            return r;
        }

        TypeNode unifyFunction(FunctionTypeNode l, TypeNode r) {
            if (r instanceof GenericTypeNode || l == r) {
                return l;
            }
            if (!(r instanceof FunctionTypeNode)) {
                return null;
            }

            // attempt to recursively unify the function types

            var r2 = (FunctionTypeNode)r;
            if (l.parameters.size() != r2.parameters.size()) {
                return null;
            }
            var params = new ArrayList<TypeNode>();
            for (var i = 0; i < l.parameters.size(); i++) {
                var t = unify(l.parameters.get(i), r2.parameters.get(i));
                if (t == null) {
                    return null;
                }
                params.add(t);
            }
            var return_ = unify(l.return_, r2.return_);
            if (return_ == null) {
                return null;
            }
            return AST.funcType(ft2 -> {
                ft2.parameters.addAll(params);
                ft2.return_ = return_;
            });
        }
    }

    class CollectIdentifierDeclarations extends Visitor {
        HashMap<Identifier, IdentifierDeclarationNode> idTable = new HashMap<>();
    
        public HashMap<Identifier, IdentifierDeclarationNode> run(ProgramNode n) {
            visit(n);
            return idTable;
        }

        @Override
        protected void visitIdentifierDeclaration(IdentifierDeclarationNode node) {
            idTable.put(node.identifier.value, node);
        }
    }

    class SetPreliminaryType extends Visitor {
        HashMap<Identifier, IdentifierDeclarationNode> idTable;
        int nextTypeVarId = 1;

        public SetPreliminaryType(HashMap<Identifier, IdentifierDeclarationNode> idTable) {
            this.idTable = idTable;
        }

        public void run(ProgramNode n) {
            // ensure all the let declarations have their inferred type set before 
            // we visit any reference to them.
            idTable.forEach((t, x) -> {
                visit(x);
            });
            visit(n);
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
            var decl = idTable.get(n.value);
            if (decl != null) {
                n.inferredType = decl.identifier.inferredType;
            } else {
                // TODO: report error: identifier has no definition
            }
        }
    
        @Override
        protected void visitExpression(ExpressionNode n) {
            n.inferredType = AST.variableType(nextTypeVarId++);
            super.visitExpression(n);
        }
    
        @Override
        protected void visitOperator(OperatorNode n) {
            visit(n.getLeft());
            n.identifier.inferredType = Utility.opType(n.operator);
            visit(n.getRight());
        }

        // @Override
        // protected void visitFunction(FunctionNode n) {
        //     super.visitFunction(n);
        //     n.inferredType = AST.funcType(f -> {
        //         n.parameters.forEach(param -> {
        //             f.parameters.add(param.identifier.inferredType);
        //         });
        //         f.return_ = n.inferredType;
        //     });
        // }

        // @Override
        // protected void visitFunctionInvocation(FunctionInvocationNode n) {
        //     super.visitFunctionInvocation(n);
        //     n.identifier.inferredType = AST.funcType(f -> {
        //         n.arguments.forEach(arg -> {
        //             f.parameters.add(arg.inferredType);
        //         });
        //         f.return_ = n.inferredType;
        //     });
        // }
    }
}