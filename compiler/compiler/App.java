package compiler;

import compiler.ast.*;

class App {

    public void printExampleProgram() {
        var f = AST.function()
            .addParameter(AST.ident("a"))
            .addBinding(AST.binding("b", AST.number(2)))
            .addBinding(AST.binding("c", AST.add(AST.ident("a"), AST.ident("b"))))
            .setReturn(AST.ident("c"));
        var fBind = AST.binding("f", f);
        var xBind = AST.binding("x", "Number", AST.invoke("f").addArgument(AST.number(4.5)));
        var gBind = AST.binding("g", AST.funcType("Number").addParameter(AST.ident("Number")), AST.ident("f"));
        var a = AST.ifElse(AST.unOp(Operator.Not, AST.bool(false)))
            .setTrueCase(AST.string("A"))
            .setElseCase(AST.string("B"));
        var aBind = AST.binding("a", a);
        var b = AST.ifElse(AST.unOp(Operator.Not, AST.binOp(AST.bool(false), Operator.Or, AST.bool(true))))
            .setTrueCase(AST.number(1))
            .setElseCase(AST.number(-1.4));
        var bBind = AST.binding("b", b);

        var globalScope = AST.program()
            .addBinding(fBind)
            .addBinding(xBind)
            .addBinding(gBind)
            .addBinding(aBind)
            .addBinding(bBind);

        (new PrettyPrintVisitor()).visit(globalScope);
    }

    public static void main(String[] args) {
        try {
            var app = new App();
            app.printExampleProgram();
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        }
    }
}