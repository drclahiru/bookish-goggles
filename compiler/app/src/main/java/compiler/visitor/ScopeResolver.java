package compiler.visitor;

import compiler.ast.*;
import java.util.*;

/* 
 This visitor disambiguates identifiers of the same name by annotating every identifier with a scopeId.

 For every new scope it enters it will first visit the identifier-declarations of the let-bindings and function-parameters before visiting any expressions.
 */
public class ScopeResolver extends Visitor {
    final IdentifierMap idTable;
    final HashMap<Identifier, IdentifierDeclarationNode> flatIdTable;      
    final HashMap<Identifier, TypeNode> prelude;
    public ScopeResolver() {
        this.prelude = Utility.createPrelude();
        this.idTable = new IdentifierMap();
        flatIdTable = new HashMap<>();
    }
    public HashMap<Identifier, IdentifierDeclarationNode> run(ProgramNode n) throws VisitorException {
        visit(n);
        return flatIdTable;
    }
    @Override
    protected void visitFunction(FunctionNode node) throws VisitorException {
        idTable.enterScope();
        for (var p : node.parameters) {
            visit(p);
        }
        for (var b : node.body) {
            visit(b.declaration);
        }
        for (var b : node.body) {
            visit(b.expr);
        }
        visit(node.return_);
        idTable.exitScope();
    }
    @Override
    protected void visitIdentifier(IdentifierNode node) {
        var decl = idTable.get(node.value.name);
        if (decl != null) {
            node.value = decl.identifier.value;
        } else if (!prelude.containsKey(node.value)) {
            var ctx = node.source;
            while (ctx.depth() > 2) {
                ctx = ctx.getParent();
            }
            throw new Error("Use of undeclared identifier: \"" + node.value.name + "\" at " + node.source.getParent().getSourceInterval() + " in the token stream");
        }
    }
    @Override
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode node) {
        idTable.declare(node);
        node.identifier.value = new Identifier(node.identifier.value.name, idTable.scopeId());
        flatIdTable.put(node.identifier.value, node);
    }
    @Override
    protected void visitProgram(ProgramNode node) throws VisitorException {
        idTable.enterScope();
        for (var b : node.bindings) {
            visit(b.declaration);
        }
        for (var b : node.bindings) {
            visit(b.expr);
        }
        idTable.exitScope();
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