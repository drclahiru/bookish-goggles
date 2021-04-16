package compiler.visitor;

import compiler.ast.*;
import java.util.*;

public class TypecheckerT extends VisitorT<TypeNode> {
    final HashMap<Identifier, TypeNode> map = Utility.createPrelude(); 
    private TypeNode previousType;
    public TypecheckerT(HashMap<Identifier, IdentifierDeclarationNode> hm) {
        hm.forEach((i,id)-> {
            map.put(i,id.type);
        });
    }

    
    @Override
    public TypeNode visitNumber(NumberNode n) {
    	 return  new SimpleTypeNode(n.source, SimpleType.Number);
    }
    @Override
    public TypeNode visitBool(BoolNode n) {
    	return new SimpleTypeNode(n.source, SimpleType.Bool);
    }
    @Override
    public TypeNode visitString(StringNode n) {
    	return  new SimpleTypeNode(n.source, SimpleType.String);
    }
    @Override
    public TypeNode visitIdentifier(IdentifierNode n) {
    	return map.get(n.value);
    	
    }
    @Override 
    public TypeNode visitFunction(FunctionNode n) throws VisitorException {
    	for(var x : n.body) {
            visit(x);
        }
    	
        var t = new FunctionTypeNode(n.source);
        for (var k : n.parameters) {
            
            t.parameters.add((TypeNode) visit(k));
         }
        
        t.return_= (TypeNode) visit(n.return_);

    	return  t;
    }
    @Override 
    public TypeNode visitIfElse(IfElseNode n) throws VisitorException {
    	
    	if (!(new SimpleTypeNode(null, SimpleType.Bool)).equals(visit(n.boolExpr))) {
            throw new VisitorException(n, "Not a boolean");
        }
    	
    	var t = visit(n.trueCase);
    	
    	if (!t.equals(visit(n.elseCase))) {
            throw new VisitorException(n, "mismatching types");
        }
    	return null;
    }
    @Override
    public TypeNode visitLetBinding(LetBindingNode n) throws VisitorException {
    	
    	if (!n.declaration.type.equals(visit(n.expr))) {
            throw new VisitorException(n, "type mismatch");
    	}
    	return null;
    }
    @Override
    public TypeNode visitFunctionInvocation(FunctionInvocationNode fn) throws VisitorException {
       visit(fn.identifier);
    	var t = previousType;

        if (!(t instanceof FunctionTypeNode)) {
            throw new VisitorException(fn, "Identifier is not a function" + t);
        }

        var tf = (FunctionTypeNode) t;

        if (tf.parameters.size() != fn.arguments.size()) {
            throw new VisitorException(fn, "Arity mismatch");
        }
        for (int e = 0; e < tf.parameters.size(); e++) {
        	visit(fn.arguments.get(e));
            if (!tf.parameters.get(e).equals(previousType)) {
                throw new VisitorException(fn, "Type mismatch of the function and the arguments");
            }
         }
        return tf.return_;
    }

	@Override
	TypeNode visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	TypeNode visitProgram(ProgramNode pn) throws VisitorException {
		 var exceptions = new ArrayList<VisitorException>();
	        for (var bind : pn.bindings) {
	            try {
	                visit(bind);
	            } catch (VisitorException ex) {
	                exceptions.add(ex);
	            }
	        }
	        if (exceptions.size() > 0) {
	            throw new Error("opa");
	        }

		return null;
	}

	@Override
	TypeNode visitRange(RangeNode n) throws VisitorException {
		// TODO Auto-generated method stub
		return null;
	}
}  

