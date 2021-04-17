package compiler.analysis;

import compiler.*;
import compiler.ast.*;
import compiler.visitor.*;

import java.util.*;

public class TypeChecker extends VisitorT<TypeNode> {
    final IdentifierContext map; 
    public TypeChecker(IdentifierContext map) {
        this.map = map;
    }

    public void run(ProgramNode pn) throws VisitorExceptionAggregate {
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
    public TypeNode visitNumber(NumberNode n) {
    	return new SimpleTypeNode(n.source, SimpleType.Number);
    }
    @Override
    public TypeNode visitBool(BoolNode n) {
    	return new SimpleTypeNode(n.source, SimpleType.Bool);
    }
    @Override
    public TypeNode visitString(StringNode n) {
    	return new SimpleTypeNode(n.source, SimpleType.String);
    }
    @Override
    public TypeNode visitIdentifier(IdentifierNode n) {
    	return map.get(n.value).type;
    	
    }
    @Override 
    public TypeNode visitFunction(FunctionNode n) throws VisitorException {
        var t = new FunctionTypeNode(n.source);
        for (var k : n.parameters) {
            t.parameters.add(visit(k));
         }
        t.return_= visit(n.return_);

    	return t;
    }
    @Override 
    public TypeNode visitIfElse(IfElseNode n) throws VisitorException {
        var boolT = new SimpleTypeNode(null, SimpleType.Bool);
    	if (!typesUnify(boolT, visit(n.boolExpr))) {
            throw new VisitorException(n, "Not a boolean");
        }
    	var trueBranch = visit(n.trueCase);
    	var elseBranch = visit(n.elseCase);
    	if (!typesUnify(trueBranch, elseBranch)) {
            throw new VisitorException(n, "mismatching types");
        }
    	return trueBranch;
    }
    @Override
    public TypeNode visitLetBinding(LetBindingNode n) throws VisitorException {
    	if (!typesUnify(visit(n.declaration), visit(n.expr))) {
            throw new VisitorException(n, "type mismatch");
    	}
        return null;
    }
    @Override
    public TypeNode visitLetExpression(LetExpressionNode n) throws VisitorException {
    	if (!typesUnify(n.declaration.type.type, visit(n.expr))) {
            throw new VisitorException(n, "type mismatch");
    	}
        return visit(n.next);
    }
    @Override
    public TypeNode visitFunctionInvocation(FunctionInvocationNode fn) throws VisitorException {
    	var t = visit(fn.identifier);

        if (!(t instanceof FunctionTypeNode)) {
            throw new VisitorException(fn, "Expected function type, but found: " + t);
        }

        var tf = (FunctionTypeNode)t;

        if (tf.parameters.size() != fn.arguments.size()) {
            throw new VisitorException(fn, "Arity mismatch");
        }
        for (int e = 0; e < tf.parameters.size(); e++) {
            if (!typesUnify(tf.parameters.get(e), visit(fn.arguments.get(e)))) {
                throw new VisitorException(fn, "Type mismatch of the function and the arguments");
            }
         }
        return tf.return_;
    }

    @Override
    protected TypeNode visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
    	if (!typesUnify(visit(n.identifier), n.type.type)) {
            throw new VisitorException(n, "type mismatch");
    	}
        return visit(n.identifier);
    }

    @Override
    protected TypeNode visitProgram(ProgramNode n) throws VisitorException {
        throw new Error("should not be visited");
    }

    @Override
    protected TypeNode visitRange(RangeNode n) throws VisitorException {
        throw new Error("todo: implement");
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

