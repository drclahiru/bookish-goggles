package compiler.visitor;

import compiler.ast.*;
import java.util.*;

public class TypeChecker extends Visitor {
    HashMap<Identifier, TypeNode> map = Utility.createPrelude(); 
    private TypeNode previousType;
    public TypeChecker(HashMap<Identifier, IdentifierDeclarationNode> hm) {
        
        hm.forEach((i,id)-> {map.put(i,id.type);  } );
    }


    public void run(ProgramNode pn) {
        visit(pn);
    }
    @Override
    public void visitNumber(NumberNode n) {
    	previousType = AST.numberType();
    }
    @Override
    public void visitBool(BoolNode n) {
    	previousType = AST.boolType();
    }
    @Override
    public void visitString(StringNode n) {
    	previousType = AST.stringType();
    }
    @Override
    public void visitIdentifier(IdentifierNode n) {
    	previousType=map.get(n.value);
    	
    }
    @Override 
    public void visitFunction(FunctionNode n) {
    	for(var x:n.body) {visit(x);}
    	
    	 previousType=AST.funcType((t) -> {
    		 for(var k:n.parameters) 
    	 	{
    		 visit(k);
    		 t.parameters.add(previousType);
    	 	}
    		 visit(n.return_);
    		 t.return_= previousType;
    	 }
    	 );
    }
    @Override 
    public void visitIfElse(IfElseNode n) {
    	visit(n.boolExpr);
    	if(!AST.boolType().equals(previousType)) { throw new Error("Not a boolean");}
    	visit(n.trueCase);
    	var t = previousType;
    	visit(n.elseCase);
    	if(!t.equals(previousType)) {throw new Error ("mismatching types");}
    	
    }
    @Override
    public void visitLetBinding(LetBindingNode n) {
    	visit(n.expr);
    	if(!n.declaration.type.equals(previousType)) {
    		throw new Error ("type mismatch" + previousType.toString() + "opa");
    	}
    }
    @Override
    public void visitFunctionInvocation(FunctionInvocationNode fn) {
       visit(fn.identifier);
    	var t = previousType;

        if (!(t instanceof FunctionTypeNode)) {
            throw new Error("Identifier is not a function" + t);
        }

        var tf = (FunctionTypeNode) t;

        if (tf.parameters.size() != fn.arguments.size()) {
            throw new Error("Arity mismatch");
        }
        for(int e = 0; e < tf.parameters.size(); e++) {
        	visit(fn.arguments.get(e));
            if (!tf.parameters.get(e).equals(previousType)) {
                throw new Error ("Type mismatch of the function and the arguments");
            }
         }
        previousType = tf.return_;
        
    }

  
   

}  

