package compiler.ast;

import java.util.*;

public class PrettyPrintVisitor extends ReflectiveVisitor {
    Integer indentLevel = 0;
    Boolean isNewline = true;

    public void visit(FunctionNode node) {
        print("(");
        node.parameters.stream().limit(1).forEach(arg -> {
            visit(arg);
        });
        node.parameters.stream().skip(1).forEach(arg -> {
            print(", ");
            visit(arg);
        });
        print(") ");
        print("{");
        println();
        indentLevel++;
        for (var binding : node.body) {
            visit(binding);
        }
        print("return ");
        visit(node.return_);
        print(";");
        println();
        indentLevel--;
        print("}");
    }

    public void visit(BindingNode node) {
        print("let ");
        visit(node.identifier);
        if (node.type != null) {
            print(": ");
            visit(node.type);
        }
        print(" = ");
        visit(node.expr);
        print(";");
        println();
    }

    public void visit(BoolNode node) {
        print("" + node.value);
    }

    public void visit(NumberNode node) {
        if (node.value == Math.round(node.value)) {
            print("" + (long)node.value);
        } else {
            print("" + node.value);
        }
    }

    public void visit(StringNode node) {
        print("\"");
        print(node.value.replace("\\", "\\\\").replace("\"", "\\\""));
        print("\"");
    }

    public void visit(IdentifierNode node) {
        print("" + node.value);
    }

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
        print(")");
        print(" -> ");
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
        if (isNewline) {
            System.out.print(" ".repeat(this.indentLevel * 4));
            isNewline = false;
        }
        System.out.print(text);
    }

    void println() {
        System.out.println();
        isNewline = true;
    }
}