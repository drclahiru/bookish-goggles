package compiler;

import compiler.ast.*;
import compiler.visitor.VisitorException;
import compiler.visitor.VisitorVoid;

import java.util.function.Consumer;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class PrettyPrinter extends VisitorVoid {
    public class Options {
        public boolean printScopeNumber = false;
        public boolean printTypes = true;
        public boolean useNewLine = true;
    }
    public static String stringify(AbstractNode n) {
        return stringify(n, x -> {});
    }
    public static String stringify(AbstractNode n, Consumer<Options> f) {
        try {
            var baos = new ByteArrayOutputStream();
            new PrettyPrinter(baos, f).run(n);
            return new String(baos.toByteArray());
        } catch (VisitorException ex) {
            return "Error: " + ex.message;
        }
    }
    TypeVariableRenamer typeRenamer = TypeVariableRenamer.empty();
    Integer indentLevel = 0;
    Boolean isNewline = true;
    Options opts = new Options();
    OutputStream out;

    public PrettyPrinter(OutputStream out) {
        super();
        this.out = out;
    }
    public PrettyPrinter(OutputStream out, Consumer<Options> f) {
        super();
        this.out = out;
        f.accept(opts);
    }

    public void run(AbstractNode n) throws VisitorException {
        visit(n);
    }

    @Override
    protected void visitFunction(FunctionNode node) throws VisitorException {
        print("(");
        for (var arg : (Iterable<IdentifierDeclarationNode>) node.parameters.stream().limit(1)::iterator) {
            visit(arg);
        }
        for (var arg : (Iterable<IdentifierDeclarationNode>) node.parameters.stream().skip(1)::iterator) {
            print(", ");
            visit(arg);
        }
        print(") {");
        println();
        indentLevel++;
        visit(node.return_);
        indentLevel--;
        println();
        print("}");
    }

    @Override
    protected void visitLetBinding(LetBindingNode node) throws VisitorException {
        var prevRenamer = typeRenamer;
        if (node.declaration.typeScheme != null) {
            typeRenamer = node.declaration.typeScheme.createRenamer();
        }
        print("let ");
        visit(node.declaration);
        println();
        indentLevel++;
        print("= ");
        visit(node.expr);
        indentLevel--;
        println();
        typeRenamer = prevRenamer;
    }

    @Override
    protected void visitLetExpression(LetExpressionNode node) throws VisitorException {
        print("let ");
        visit(node.declaration);
        println();
        indentLevel++;
        print("= ");
        visit(node.expr);
        indentLevel--;
        println();
        print("in ");
        visit(node.next);
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
        print(node.value);
    }

    @Override
    protected void visitIdentifier(IdentifierNode node) {
        if (opts.printScopeNumber) {
            print(node.value.toString());
        } else {
            print(node.value.name);
        }
    }
    
    @Override
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
        visit(n.identifier);
        if (opts.printTypes && n.typeScheme != null) {
            print(" ");
            print(typeRenamer.rename(n.typeScheme.type).toString());
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
        print(" {");
        println();
        indentLevel++;
        visit(node.trueCase);
        indentLevel--;
        println();
        print("else");
        println();
        indentLevel++;
        visit(node.elseCase);
        indentLevel--;
        println();
        print("}");
    }

    @Override
    protected void visitProgram(ProgramNode node) throws VisitorException {
        for (var x : (Iterable<LetBindingNode>) node.bindings.stream().limit(1)::iterator) {
            visit(x);
        }
        for (var x : (Iterable<LetBindingNode>) node.bindings.stream().skip(1)::iterator) {
            print("\n");
            isNewline = true;
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
        if (opts.useNewLine) {
            print("\n");
            isNewline = true;
        }
    }
}