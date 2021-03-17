package compiler.visitor;

import compiler.ast.*;
import java.util.*;

public class TypeChecker extends Visitor {
    HashMap<Identifier, IdentifierDeclarationNode> map = new HashMap<>(); 

    public TypeChecker(HashMap<Identifier, IdentifierDeclarationNode> hm) {
        this.map = hm;
    }

    public TypeNode typeOf(Identifier i) {
        if(map.get(i) == null) {
            throw new Error("Identifier not declared" + i);    
        }
        
        return map.get(i).type;
    }

    public void run(ProgramNode pn) {
        visit(pn);
    }
    
    @Override
    public void visitFunctionInvocation(FunctionInvocationNode fn) {
        var t = typeOf(fn.identifier.value);

        if (!(t instanceof FunctionTypeNode)) {
            throw new Error("Identifier is not a function" + t);
        }

        var tf = (FunctionTypeNode) t;

        if (tf.parameters.size() != fn.arguments.size()) {
            throw new Error("Arity mismatch");
        }
        for(int e = 0; e < tf.parameters.size(); e++) {
            if (!tf.parameters.get(e).equals(typeOf(fn.arguments.get(e)))) {
                throw new Error ("Type mismatch of the function and the arguments");
            }
         }
    }

    public TypeNode typeOf(ExpressionNode n) {
        if (n instanceof BoolNode) {
            return AST.boolType();
        } else if (n instanceof FunctionInvocationNode) {
            var x = (FunctionInvocationNode) n;
            var y = (FunctionTypeNode) typeOf(x.identifier);
            return y.return_;
        } else if (n instanceof FunctionNode) {
            throw new Error ("TODO");
        } else if (n instanceof IdentifierNode) {
            var x = (IdentifierNode) n;
            return typeOf(x.value);           
        } else if (n instanceof IfElseNode) {
            throw new Error ("TODO");
        } else if (n instanceof NumberNode) {
            return AST.numberType();
        } else if (n instanceof StringNode) {
            return AST.stringType();
        } else {
            throw new Error("Unexpected type: " + n);
        }
    }
}

