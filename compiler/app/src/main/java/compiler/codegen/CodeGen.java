package compiler.codegen;

import java.io.*;
import compiler.ast.*;
import compiler.visitor.*;

public class CodeGen  extends VisitorVoid  {
    public static String stringify(AbstractNode n) {
        try {
            var baos = new ByteArrayOutputStream();
            new CodeGen(baos).run(n);
            return new String(baos.toByteArray());
        } catch (VisitorException ex) {
            return "Error: " + ex.message;
        }
    }
    Integer indentLevel = 0;
    Boolean isNewline = true;
    OutputStream out;

    public boolean printScopeNumber = false;

    public CodeGen(OutputStream out) {
        super();
        this.out = out;
    }

    public void run(AbstractNode n) throws VisitorException {
        visit(n);
    }

    @Override
    protected void visitFunction(FunctionNode node) throws VisitorException {
        print("\\");
        for (var arg : (Iterable<IdentifierDeclarationNode>) node.parameters.stream().limit(1)::iterator) {
            visit(arg.identifier);
        }
        for (var arg : (Iterable<IdentifierDeclarationNode>) node.parameters.stream().skip(1)::iterator) {
            print(" ");
            visit(arg.identifier);
        }
        print("->");
        visit(node.return_);
    }

    @Override
    protected void visitLetBinding(LetBindingNode node) throws VisitorException {
       
        visit(node.declaration);
        print(" = ");
        visit(node.expr);
        println();
    }

    @Override
    protected void visitLetExpression(LetExpressionNode node) throws VisitorException {
    	print(" let ");
        visit(node.declaration);
        print(" = ");
        visit(node.expr);
        print(" in");
        println();
        visit(node.next);
    }

    @Override
    protected void visitBool(BoolNode node) {
        if(node.value)
        	print("True");
        else
        	print("False");
    }

    @Override
    protected void visitNumber(NumberNode node) {
        if (node.value == Math.round(node.value)) {
            print(Long.toString((long)node.value));
        } else {
            print(Double.toString(node.value));
        }
    }

    @Override
    protected void visitString(StringNode node) {
        print(node.value);
    }

    @Override
    protected void visitIdentifier(IdentifierNode node) {
        if (printScopeNumber) {
            print(node.value.toString().replace('$', 's'));
        } else {
            print(node.value.name.replace('$', 's'));
        }
    }
    
    @Override
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
        visit(n.identifier);
       
    };

    @Override
    protected void visitSimpleType(SimpleTypeNode node) {
         
    }

    @Override
    protected void visitFunctionType(FunctionTypeNode node) {
        
    }

    @Override
    protected void visitVariableType(VariableTypeNode node) {
         
    }

    @Override
    protected void visitFunctionInvocation(FunctionInvocationNode node) throws VisitorException {
        if (node.isOperator()) {
        	print("(");
            visit(node.arguments.get(0));
            print(" ");
            visit(node.identifier);
            print(" ");
            visit(node.arguments.get(1));
           	print(")");
        } else {
        	   print("(");
            visit(node.identifier);
            print(" ");

            for (var x : (Iterable<ExpressionNode>) node.arguments.stream().limit(1)::iterator) {
                visit(x);
            }
            for (var x : (Iterable<ExpressionNode>) node.arguments.stream().skip(1)::iterator) {
                print("  ");
                visit(x);
            }
            print(")");
        }
    }

    @Override
    protected void visitIfElse(IfElseNode node) throws VisitorException {
        print(" if ");
        visit(node.boolExpr);
        print(" ");
        
        visit(node.trueCase);
        
        print(" else  ");
   
        visit(node.elseCase);
       
    }

    @Override
    protected void visitProgram(ProgramNode node) throws VisitorException {
    	    	for (var x: node.bindings) {
    		visit(x);
    	}	
    	print("main::IO()");
    	println();
    	
    }

    @Override
    protected void visitRange(RangeNode node) {
        print(node.startCol);
        print(Integer.toString(node.startRow));
        print(":");
        print(node.endCol);
        print(Integer.toString(node.endRow));
    }

    protected void print(String text) {
        try {
            if (isNewline) {
                out.write(" ".repeat(this.indentLevel * 4).getBytes());
                isNewline = false;
            }
            out.write(text.getBytes());
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    protected void println() {
        try {
            out.write("\n".getBytes());
            isNewline = true;
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}