package compiler.visitor;

import compiler.ast.*;
import java.util.*;

public class TypeChecker extends Visitor {
    final HashMap<Identifier, TypeNode> map = Utility.createPrelude(); 
    private TypeNode previousType;
    public TypeChecker(HashMap<Identifier, IdentifierDeclarationNode> hm) {
        hm.forEach((i,id)-> {
            map.put(i,id.type);
        });
    }

    public void run(ProgramNode pn) throws VisitorException, Visitor.VisitorExceptionAggregate {
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
    }
    @Override
    public void visitNumber(NumberNode n) {
    	previousType = new SimpleTypeNode(n.source, SimpleType.Number);
    }
    @Override
    public void visitBool(BoolNode n) {
    	previousType = new SimpleTypeNode(n.source, SimpleType.Bool);
    }
    @Override
    public void visitString(StringNode n) {
    	previousType = new SimpleTypeNode(n.source, SimpleType.String);
    }
    @Override
    public void visitIdentifier(IdentifierNode n) {
    	previousType=map.get(n.value);
    	
    }
    @Override 
    public void visitFunction(FunctionNode n) throws VisitorException {
    	for(var x : n.body) {
            visit(x);
        }
    	
        var t = new FunctionTypeNode(n.source);
        for (var k : n.parameters) {
            visit(k);
            t.parameters.add(previousType);
         }
        visit(n.return_);
        t.return_= previousType;

    	previousType = t;
    }
    @Override 
    public void visitIfElse(IfElseNode n) throws VisitorException {
    	visit(n.boolExpr);
    	if (!(new SimpleTypeNode(null, SimpleType.Bool)).equals(previousType)) {
            throw new VisitorException(n, "Not a boolean");
        }
    	visit(n.trueCase);
    	var t = previousType;
    	visit(n.elseCase);
    	if (!t.equals(previousType)) {
            throw new VisitorException(n, "mismatching types");
        }
    	
    }
    @Override
    public void visitLetBinding(LetBindingNode n) throws VisitorException {
    	visit(n.expr);
    	if (!n.declaration.type.equals(previousType)) {
            throw new VisitorException(n, "type mismatch");
    	}
    }
    @Override
    public void visitFunctionInvocation(FunctionInvocationNode fn) throws VisitorException {
       visit(fn.identifier);
    	var t = previousType;

        if (!(t instanceof FunctionTypeNode)) {
            throw new Error("Identifier is not a function" + t);
        }

        var tf = (FunctionTypeNode) t;

        if (tf.parameters.size() != fn.arguments.size()) {
            throw new Error("Arity mismatch");
        }
        for (int e = 0; e < tf.parameters.size(); e++) {
        	visit(fn.arguments.get(e));
            if (!tf.parameters.get(e).equals(previousType)) {
                throw new Error ("Type mismatch of the function and the arguments");
            }
         }
        previousType = tf.return_;
    }
}  

