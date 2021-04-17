package compiler.analysis;

import compiler.IdentifierContext;
import compiler.Utility;
import compiler.ast.*;
import compiler.visitor.*;

import java.util.*;

/* 
 This visitor disambiguates identifiers of the same name by annotating every identifier with a scopeId.

 For every new scope it enters it will first visit the identifier-declarations of the let-bindings and function-parameters before visiting any expressions.
 */
public class ScopeResolver extends VisitorVoid {
    final IdentifierMap idTable;
    final HashMap<Identifier, IdentifierDeclarationNode> flatIdTable;      
    final IdentifierContext prelude;
    public ScopeResolver() {
        this.prelude = Utility.createPrelude();
        this.idTable = new IdentifierMap();
        flatIdTable = new HashMap<>();
    }
    public HashMap<Identifier, IdentifierDeclarationNode> run(ProgramNode pn) throws VisitorExceptionAggregate {
        idTable.enterScope();
        var exceptions = new ArrayList<VisitorException>();
        for (var bind : pn.bindings) {
            try {
                visit(bind);
            } catch (VisitorException ex) {
                exceptions.add(ex);
            }
        }
        if (exceptions.size() > 0) {
            throw new VisitorExceptionAggregate(exceptions);
        }
        idTable.exitScope();
        return flatIdTable;
    }
    @Override
    protected void visitLetExpression(LetExpressionNode n) throws VisitorException {
        idTable.enterScope();
        super.visitLetExpression(n);
        idTable.exitScope();
    }
    @Override
    protected void visitFunction(FunctionNode n) throws VisitorException {
        idTable.enterScope();
        super.visitFunction(n);
        idTable.exitScope();
    }
    @Override
    protected void visitIdentifier(IdentifierNode node) throws VisitorException {
        var decl = idTable.get(node.value.name);
        if (decl != null) {
            node.value = decl.identifier.value;
        } else if (!prelude.containsKey(node.value)) {
            var ctx = node.source;
            while (ctx.depth() > 2) {
                ctx = ctx.getParent();
            }
            throw new VisitorException(node, "Use of undeclared identifier: \"" + node.value.name);
        }
    }
    @Override
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode node) {
        idTable.declare(node);
        node.identifier.value = new Identifier(node.identifier.value.name, idTable.scopeId());
        flatIdTable.put(node.identifier.value, node);
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