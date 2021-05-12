package compiler.analysis;

import compiler.ast.*;
import compiler.visitor.*;

import java.util.*;

public class TypeChecker extends VisitorVoid {
    public void run(ProgramNode pn) throws VisitorExceptionAggregate {
        var exceptions = new ArrayList<VisitorException>();
        for (var bind : pn.bindings) {
            try {
                visit(bind);
            } catch (VisitorException ex) {
                exceptions.add(ex);
            }
            
            
        }
        for (var bind : pn.rangeBindings) {
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
    public void visitIfElse(IfElseNode n) throws VisitorException {
        super.visitIfElse(n);
        var boolT = new SimpleTypeNode(null, SimpleType.Bool);
    	if (!typesUnify(boolT, n.boolExpr.type)) {
            throw new VisitorException(n, "Not a boolean");
        }
    	var trueBranch = n.trueCase.type;
    	var elseBranch = n.elseCase.type;
    	if (!typesUnify(trueBranch, elseBranch)) {
            throw new VisitorException(n, "mismatching types");
        }
    }
    @Override
    public void visitLetBinding(LetBindingNode n) throws VisitorException {
        super.visitLetBinding(n);
    	if (!typesUnify(n.declaration.typeScheme.type, n.expr.type)) {
            throw new VisitorException(n, "type mismatch");
    	}
    }
    @Override
    public void visitLetExpression(LetExpressionNode n) throws VisitorException {
        super.visitLetExpression(n);
    	if (!typesUnify(n.declaration.typeScheme.type, n.expr.type)) {
            throw new VisitorException(n, "type mismatch");
    	}
    }
    @Override
    public void visitFunctionInvocation(FunctionInvocationNode fn) throws VisitorException {
    	super.visitFunctionInvocation(fn);

        var fnType = fn.identifier.type;

        if (!(fnType instanceof FunctionTypeNode)) {
            throw new VisitorException(fn, "Expected function type, but found: " + fnType);
        }

        var tf = (FunctionTypeNode)fnType;

        if (tf.parameters.size() != fn.arguments.size()) {
            throw new VisitorException(fn, "Arity mismatch");
        }
        for (int e = 0; e < tf.parameters.size(); e++) {
            if (!typesUnify(tf.parameters.get(e), fn.arguments.get(e).type)) {
                throw new VisitorException(fn, "Type mismatch of the function and the arguments");
            }
        }
    }

    @Override
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
    	if (!typesUnify(n.identifier.type, n.typeScheme.type)) {
            throw new VisitorException(n, "type mismatch");
    	}
    }

    @Override
    protected void visitProgram(ProgramNode n) throws VisitorException {
        throw new Error("should not be visited");
    }

    @Override
    protected void visitRange(RangeNode n) throws VisitorException {
        throw new Error("shouldn't be visited");
    }
	@Override
    protected void visitRangeBinding(RangeBindingNode n) throws VisitorException {
		if(!n.validate()) {throw new Error("length mismatch");}
		System.out.print("go");
    	visitRangeNodeExpression(n.expr);    
    }
    @Override
    protected void visitRangeNodeExpression(RangeNodeExpression n) throws VisitorException {
       // super.visitRangeNodeExpression(n);
    	var z = n.type;
    	//ssSystem.out.print("OPAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    	for(var arg:n.value) {
    		
    		if(!typesUnify(z, arg.type)) {throw new VisitorException(n, "type mismatch");}
        	
        }
    }
    boolean typesUnify(TypeNode t1, TypeNode t2) {
        // TODO: type variables need to be tracked. if there is a type 
        //   (a, a) -> b
        // then we should ensure that both instances of 'a' are equal.
        if (t1 instanceof VariableTypeNode || t2 instanceof VariableTypeNode) {
            return true;
        }
        if (t1 instanceof FunctionTypeNode && t2 instanceof FunctionTypeNode) {
            var tf1 = (FunctionTypeNode)t1;
            var tf2 = (FunctionTypeNode)t2;
            if (tf1.parameters.size() != tf2.parameters.size()) {
                return false;
            }
            for (var i = 0; i < tf1.parameters.size(); i++) {
                if (!typesUnify(tf1.parameters.get(i), tf2.parameters.get(i))) {
                    return false;
                }
            }
            return typesUnify(tf1.return_, tf2.return_);
        }
        return t1.equals(t2);
    }
}  

