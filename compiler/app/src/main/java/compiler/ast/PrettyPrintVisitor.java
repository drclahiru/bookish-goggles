package compiler.ast;

import java.util.*;
import java.io.OutputStream;

public class PrettyPrintVisitor implements Visitor {
    Integer indentLevel = 0;
    Boolean isNewline = true;
    OutputStream out;

    public PrettyPrintVisitor(OutputStream out) {
        super();
        this.out = out;
    }

    public void visit(FunctionNode node) {
        print("(");
        node.parameters.stream().limit(1).forEach(arg -> {
            visit(arg.identifier);
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

    public void visit(LetBindingNode node) {
        print("let ");
        visit(node.identifier);
        print(" = ");
        visit(node.expr);
        println();
    }

    public void visit(BoolNode node) {
        print(Boolean.toString(node.value));
    }

    public void visit(NumberNode node) {
        if (node.value == Math.round(node.value)) {
            print(Long.toString((long)node.value));
        } else {
            print(Double.toString(node.value));
        }
    }

    public void visit(StringNode node) {
        print("\"");
        print(node.value.replace("\\", "\\\\").replace("\"", "\\\""));
        print("\"");
    }

    public void visit(IdentifierNode node) {
        print(node.value.scopedName());
    }
    
    public void visit(IdentifierDeclarationNode n) {
        visit(n.identifier);
        if (n.type != null) {
            print(": ");
            visit(n.type);
        }
    };

    public void visit(SimpleTypeNode node) {
        visit(node.identifier);
    }

    public void visit(FunctionTypeNode node) {
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

    public void visit(FunctionInvocationNode node) {
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

    public void visit(IfElseNode node) {
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

    public void visit(UnaryOperatorNode node) {
        print(Utility.operatorToString(node.operator));
        if (node.expr.getClass() == BinaryOperatorNode.class) {
            print("(");
            visit(node.expr);
            print(")");
        } else {
            visit(node.expr);
        }
    }

    public void visit(BinaryOperatorNode node) {
        visit(node.left);
        print(" ");
        print(Utility.operatorToString(node.operator));
        print(" ");
        visit(node.right);
    }

    public void visit(ProgramNode node) {
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