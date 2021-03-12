package compiler;

import compiler.ast.*;
import java.io.OutputStream;

class App {

    public void printExampleProgram(OutputStream out) {
        var f = AST.function()
            .parameter(AST.ident("a"))
            .let(AST
                .let("b")
                .expression(AST
                    .binOp()
                    .left(AST.ident("x"))
                    .operator(Operator.Add)
                    .right(AST.number(2))))
            .let(AST
                .let("x")
                .expression(AST
                    .binOp()
                    .left(AST.ident("a"))
                    .operator(Operator.Multiply)
                    .right(AST.ident("b"))))
            .returns(AST.invoke("f").argument(AST.ident("x")));
        var fBind = AST.let("f").expression(f);
        var xBind = AST
            .let("x")
            .type(AST.type("Number"))
            .expression(AST
                .invoke("f")
                .argument(AST.number(4.5)));
        var gBind = AST.let("g")
            .type(AST.funcType()
                .parameter(AST.type("Number"))
                .returns(AST.type("Number")))
            .expression(AST.ident("f"));
        var a = AST.ifElse()
            .expression(AST.unOp()
                .operator(Operator.Not)
                .expression(AST.bool(false)))
            .caseTrue(AST.string("A"))
            .caseElse(AST.string("B"));
        var aBind = AST.let("a").expression(a);
        var b = AST.unOp()
            .operator(Operator.Not)
            .expression(AST.binOp()
                .left(AST.bool(false))
                .operator(Operator.Or)
                .right(AST.bool(true)));
        var bBind = AST.let("b").expression(b);

        var globalScope = AST.program()
            .let(fBind)
            .let(xBind)
            .let(gBind)
            .let(aBind)
            .let(bBind);
            
        (new PrettyPrintVisitor(out)).visit(globalScope);
    }

    public static void main(String[] args) {
        try {
            var app = new App();
            app.printExampleProgram(System.out);
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        }
    }
}