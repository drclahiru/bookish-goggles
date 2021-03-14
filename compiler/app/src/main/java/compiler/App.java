package compiler;

import compiler.ast.*;
import java.io.OutputStream;
import java.util.*;

class App {
    public void printExampleProgram(OutputStream out) {
        var f = AST.function(fa -> {
            fa.parameter(AST.ident("a"));
            fa.let(AST.let("b", e -> {
                e.expression(AST.op(Operator.Add, op -> {
                    op.left(AST.ident("y"));
                    op.right(AST.number(2));
                }));
            }));
            fa.let(AST.let("x", e -> {
                e.expression(AST.op(Operator.Multiply, op -> {
                    op.left(AST.ident("a"));
                    op.right(AST.ident("b"));
                }));
            }));
            fa.returns(AST.invoke(i -> {
                i.identifier(AST.ident("f"));
                i.argument(AST.ident("x"));
            }));
        });
        var fBind = AST.let("f", x -> {
            x.expression(f);
        });
        var xBind = AST.let("x", x -> {
            x.type(AST.numberType());
            x.expression(AST.invoke(i -> {
                i.identifier(AST.ident("f"));
                i.argument(AST.number(4.5));
            }));
        });
        var gBind = AST.let("g", x -> {
            x.type(AST.funcType(t -> {
                t.parameter(AST.numberType());
                t.returns(AST.numberType());
            }));
            x.expression(AST.ident("f"));
        });
        var a = AST.ifElse(x -> {
            x.expression(AST.bool(false));
            x.caseTrue(AST.string("A"));
            x.caseElse(AST.string("B"));
        });
        var aBind = AST.let("a", e -> e.expression(a));
        var b = AST.op(Operator.Or, op -> {
            op.left(AST.bool(false));
            op.right(AST.bool(false));
        });
        var bBind = AST.let("b", e -> e.expression(b));

        var globalScope = AST.program(p -> {
            p.let(fBind);
            p.let(xBind);
            p.let(gBind);
            p.let(aBind);
            p.let(bBind);
        });
            
        new SetScopeIdsVisitor().run(globalScope);
        new PrettyPrintVisitor(out).run(globalScope);
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