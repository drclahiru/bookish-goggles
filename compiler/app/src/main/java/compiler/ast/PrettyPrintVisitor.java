package compiler.ast;

import java.util.*;
import java.io.OutputStream;

public class PrettyPrintVisitor extends Visitor {
    Integer indentLevel = 0;
    Boolean isNewline = true;
    OutputStream out;

    public PrettyPrintVisitor(OutputStream out) {
        super();
        this.out = out;
    }

    public void run(AbstractNode n) {
        visit(n);
    }

    @Override
    protected void visitFunction(FunctionNode node) {
        print("(");
        node.parameters.stream().limit(1).forEach(arg -> {
            // visit(arg.identifier);
            visit(arg);
        });
        node.parameters.stream().skip(1).forEach(arg -> {
            print(", ");
            visit(arg);
        });
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
    protected void visitLetBinding(LetBindingNode node) {
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
        print(node.value.name);
    }
    
    @Override
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) {
        visit(n.identifier);
        if (n.type != null) {
            print(": ");
            visit(n.type);
        } else {
            print(": ?");
        }
    };

    @Override
    protected void visitSimpleType(SimpleTypeNode node) {
        print(Utility.simpleTypeToString(node.type));
    }

    @Override
    protected void visitFunctionType(FunctionTypeNode node) {
        print("(");
        node.parameters.stream().limit(1).forEach(arg -> {
            visit(arg);
        });
        node.parameters.stream().skip(1).forEach(arg -> {
            print(", ");
            visit(arg);
        });
        print(") -> ");
        visit(node.return_);
    }

    @Override
    protected void visitFunctionInvocation(FunctionInvocationNode node) {
        visit(node.identifier);
        print("(");
        node.arguments.stream().limit(1).forEach(arg -> {
            visit(arg);
        });
        node.arguments.stream().skip(1).forEach(arg -> {
            print(", ");
            visit(arg);
        });
        print(")");
    }

    @Override
    protected void visitIfElse(IfElseNode node) {
        print("if ");
        visit(node.boolExpr);
        print(" { ");
        indentLevel++;
        visit(node.trueCase);
        indentLevel--;
        print(" } else { ");
        indentLevel++;
        visit(node.elseCase);
        indentLevel--;
        print(" }");
    }

    @Override
    protected void visitOperator(OperatorNode node) {
        visit(node.getLeft());
        print(" ");
        print(Utility.opToString(node.operator));
        print(" ");
        visit(node.getRight());
    }

    @Override
    protected void visitProgram(ProgramNode node) {
        node.bindings.stream().limit(1).forEach(x -> {
            visit(x);
        });
        node.bindings.stream().skip(1).forEach(x -> {
            println();
            visit(x);
        });
    }

    void print(String text) {
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

    void println() {
        try {
            out.write("\n".getBytes());
            // System.out.println();
            isNewline = true;
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}