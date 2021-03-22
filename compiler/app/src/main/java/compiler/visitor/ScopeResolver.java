package compiler.visitor;

import compiler.ast.*;
import java.util.*;
import java.util.function.Consumer;

/* 
 This visitor disambiguates identifiers of the same name by annotating every identifier with a scopeId.

 For every new scope it enters it will first visit the identifier-declarations of the let-bindings and function-parameters before visiting any expressions.
 */
public class ScopeResolver extends Visitor {
    final Queue<ExpressionNode> deferredVisits = new LinkedList<>();
    final IdentifierMap idTable;
    final HashMap<Identifier, IdentifierDeclarationNode> flatIdTable;      
    final HashMap<Identifier, TypeNode> prelude;

    public ScopeResolver() {
        this.prelude = Utility.createPrelude();
        this.idTable = new IdentifierMap();
        flatIdTable = new HashMap<>();
    }
    ScopeResolver(
        HashMap<Identifier, TypeNode> prelude,
        IdentifierMap idTable,
        HashMap<Identifier, IdentifierDeclarationNode> flatIdTable
    ) {
        this.prelude = prelude;
        this.idTable = idTable;
        this.flatIdTable = flatIdTable;
    }

    public HashMap<Identifier, IdentifierDeclarationNode> run(ProgramNode n) {
        visit(n);
        return flatIdTable;
    }

    void scoped(Consumer<ScopeResolver> f) {
        idTable.enterScope();
        var v = new ScopeResolver(prelude, idTable, flatIdTable);
        f.accept(v);
        while (!v.deferredVisits.isEmpty()) {
            var next = v.deferredVisits.remove();
            v.visit(next);
        }
        idTable.exitScope();
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
    protected void visitIdentifier(IdentifierNode node) {
        var decl = idTable.get(node.value.name);
        if (decl != null) {
            node.value = decl.identifier.value;
        } else if (!prelude.containsKey(node.value)) {
            throw new Error("Use of undeclared identifier: " + node.value.name);
        }
    }

    @Override
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode node) {
        idTable.declare(node);
        node.identifier.value = new Identifier(node.identifier.value.name, idTable.scopeId());
        flatIdTable.put(node.identifier.value, node);
    }

    @Override
    protected void visitProgram(ProgramNode node) {
        scoped(v -> {
            node.bindings.stream().forEach(x -> v.visit(x));
        });
    }

    class IdentifierMap {
        final ArrayList<HashMap<String, IdentifierDeclarationNode>> idMapStack = new ArrayList<>();
        Stack<Integer> scopeId = new Stack<>();
        int nextScopeId = 1;
        
        void declare(IdentifierDeclarationNode node) {
            idMapStack.get(idMapStack.size() - 1).put(node.identifier.value.name, node);
        }

        IdentifierDeclarationNode get(String value) {
            IdentifierDeclarationNode id = null;
            for (var i = idMapStack.size() - 1; id == null && i >= 0; i--) {
                id = idMapStack.get(i).get(value);
            }
            return id;
        }

        void enterScope() {
            idMapStack.add(new HashMap<>());
            scopeId.push(nextScopeId);
            nextScopeId += 1;
        }
        
        void exitScope() {
            idMapStack.remove(idMapStack.size() - 1);
            scopeId.pop();
        }

        Integer scopeId() {
            return scopeId.peek();
        }
    }
}