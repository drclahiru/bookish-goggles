package compiler.visitor;

import compiler.ast.*;
import java.io.OutputStream;

public class PrettyPrinter extends VisitorVoid {
    Integer indentLevel = 0;
    Boolean isNewline = true;
    OutputStream out;

    public PrettyPrinter(OutputStream out) {
        super();
        this.out = out;
    }

    public void run(AbstractNode n) throws VisitorException {
        visit(n);
    }

    @Override
    protected void visitFunction(FunctionNode node) throws VisitorException {
        print("(");
        for (var arg : (Iterable<IdentifierDeclarationNode>) node.parameters.stream().limit(1)::iterator) {
            visit(arg.identifier);
        }
        for (var arg : (Iterable<IdentifierDeclarationNode>) node.parameters.stream().skip(1)::iterator) {
            print(", ");
            visit(arg.identifier);
        }
        print(") {");
        println();
        indentLevel++;
        for (var binding : node.body) {
            visit(binding);
        }
        visit(node.return_);
        println();
        indentLevel--;
        print("}");
    }

    @Override
    protected void visitLetBinding(LetBindingNode node) throws VisitorException {
        print("let ");
        visit(node.declaration);
        print(" = ");
        visit(node.expr);
        println();
    }

    @Override
    protected void visitBool(BoolNode node) {
        print(Boolean.toString(node.value));
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
        print("\"");
        print(node.value.replace("\\", "\\\\").replace("\"", "\\\""));
        print("\"");
    }

    @Override
    protected void visitIdentifier(IdentifierNode node) {
        // if (node.value.scopeId != null) {
        //     print(Integer.toString(node.value.scopeId));
        //     print("_");
        // }
        print(node.value.name);
    }
    
    @Override
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
        visit(n.identifier);
        if (n.type != null) {
            print(" ");
            visit(n.type);
        }
    };

    @Override
    protected void visitSimpleType(SimpleTypeNode node) {
        print(node.toString());
    }

    @Override
    protected void visitFunctionType(FunctionTypeNode node) {
        print(node.toString());
    }

    @Override
    protected void visitVariableType(VariableTypeNode node) {
        print(node.toString());
    }

    @Override
    protected void visitFunctionInvocation(FunctionInvocationNode node) throws VisitorException {
        if (node.isOperator()) {
            visit(node.arguments.get(0));
            print(" ");
            visit(node.identifier);
            print(" ");
            visit(node.arguments.get(1));
        } else {
            visit(node.identifier);
            print("(");
            for (var x : (Iterable<ExpressionNode>) node.arguments.stream().limit(1)::iterator) {
                visit(x);
            }
            for (var x : (Iterable<ExpressionNode>) node.arguments.stream().skip(1)::iterator) {
                print(", ");
                visit(x);
            }
            print(")");
        }
    }

    @Override
    protected void visitIfElse(IfElseNode node) throws VisitorException {
        print("if ");
        visit(node.boolExpr);
        print(" { ");
        println();
        indentLevel++;
        visit(node.trueCase);
        indentLevel--;
        println();
        print(" } else { ");
        println();
        indentLevel++;
        visit(node.elseCase);
        indentLevel--;
        println();
        print(" }");
    }

    @Override
    protected void visitProgram(ProgramNode node) throws VisitorException {
        for (var x : (Iterable<LetBindingNode>) node.bindings.stream().limit(1)::iterator) {
            visit(x);
        }
        for (var x : (Iterable<LetBindingNode>) node.bindings.stream().skip(1)::iterator) {
            println();
            visit(x);
        }
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
            // System.out.println();
            isNewline = true;
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}