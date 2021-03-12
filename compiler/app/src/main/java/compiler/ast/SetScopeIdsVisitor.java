package compiler.ast;

import java.util.*;

/* 
 This visitor disambiguates identifiers of the same name by annotating every identifier with a scopeId.

 For every new scope it enters it will first visit the identifier-declarations of the let-bindings and function-parameters before visiting any expressions.
 */
public class SetScopeIdsVisitor implements Visitor {
    Queue<Expression> deferredVisits = new LinkedList<>();
    IdentifierTable idTable = new IdentifierTable();

    void enterScope() {
        this.idTable.enterScope();
    }

    void exitScope() {
        while (!this.deferredVisits.isEmpty()) {
            var next = this.deferredVisits.remove();
            visit(next);
        }
        this.idTable.exitScope();
    }

    void enqueue(Expression n) {
        this.deferredVisits.add(n);
    }

    public void visit(FunctionNode node) {
        enterScope();
        node.parameters.stream().forEach((p) -> visit(p));
        node.body.stream().forEach((p) -> visit(p));
        enqueue(node.return_);
        exitScope();
    }

    public void visit(LetBindingNode node) {
        visit(node.identifier);
        enqueue(node.expr);
    }

    public void visit(IdentifierNode node) {
        var decl = idTable.get(node.value.name);
        // TODO: error if decl is null
        node.value = decl.identifier.value;
    }
    public void visit(IdentifierDeclarationNode node) {
        idTable.declare(node);
        node.identifier.value = new Identifier(node.identifier.value.name, idTable.scopeId());
    }

    public void visit(ProgramNode node) {
        enterScope();
        node.bindings.stream().forEach(x -> visit(x));
        exitScope();
    }

    class IdentifierTable {
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