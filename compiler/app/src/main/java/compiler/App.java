package compiler;

import compiler.ast.*;
import compiler.visitor.*;
import java.io.OutputStream;
import java.util.*;

class App {
    public void printExampleProgram(OutputStream out) {
        var f = AST.function(fa -> {
            fa.parameters.add(AST.identDecl("a"));
            fa.body.add(AST.let("b", e -> {
                e.expr = AST.op(Operator.Add, op -> {
                    op.left(AST.ident("y"));
                    op.right(AST.number(2));
                });
            }));
            fa.body.add(AST.let("x", e -> {
                e.expr = AST.op(Operator.Multiply, op -> {
                    op.left(AST.ident("a"));
                    op.right(AST.ident("b"));
                });
            }));
            fa.return_ = AST.invoke(i -> {
                i.identifier = AST.ident("f");
                i.arguments.add(AST.ident("x"));
            });
        });
        var fBind = AST.let("f", x -> {
            x.expr = f;
        });
        var xBind = AST.let("x", x -> {
            x.declaration.type = AST.numberType();
            x.expr = AST.invoke(i -> {
                i.identifier = AST.ident("f");
                i.arguments.add(AST.number(4.5));
            });
        });
        var gBind = AST.let("g", x -> {
            x.declaration.type = AST.funcType(t -> {
                t.parameters.add(AST.numberType());
                t.return_ = AST.numberType();
            });
            x.expr = AST.ident("f");
        });
        var a = AST.ifElse(x -> {
            x.boolExpr = AST.bool(false);
            x.trueCase = AST.string("A");
            x.elseCase = AST.string("B");
        });
        var aBind = AST.let("a", e -> {
            e.expr = a;
        });
        var bBind = AST.let("b", e -> {
            e.expr = new RangeNode("A", 1, "A", 3);
        });

        var globalScope = AST.program(p -> {
            p.bindings.add(fBind);
            p.bindings.add(xBind);
            p.bindings.add(gBind);
            p.bindings.add(aBind);
            p.bindings.add(bBind);
        });
            
        new ScopeResolver().run(globalScope);
        new PrettyPrinter(out).run(globalScope);
    }

    public void typeCheckingExample(OutputStream out) {
        var fBind = AST.let("f", x -> {
            x.expr = AST.function(fa -> {
                fa.parameters.add(AST.identDecl("a"));
                fa.return_ = AST.ident("a");
            });
            x.declaration.type = AST.funcType(y -> {
                y.return_ = AST.numberType();
                y.parameters.add(AST.numberType());
            });
        });

        var kBind = AST.let("k", x -> {
            x.expr = AST.invoke(fa -> {
                fa.identifier = (AST.ident("f"));
                fa.arguments.add(AST.number(2.2));
            });
            x.declaration.type = AST.numberType();
        });
        
        var globalScope = AST.program(p -> {
            p.bindings.add(fBind);
            p.bindings.add(kBind);
        });
            
        new ScopeResolver().run(globalScope);
        var cls = new CollectIdentifierDeclarations().run(globalScope);
        new PrettyPrinter(out).run(globalScope);

        new TypeChecker(cls).run(globalScope);
    }

    public static void main(String[] args) {
        try {
            var app = new App();
            //app.printExampleProgram(System.out);
            app.typeCheckingExample(System.out);
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        }
    }
}