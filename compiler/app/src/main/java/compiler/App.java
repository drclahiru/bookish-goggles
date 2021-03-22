package compiler;

import compiler.ast.*;
import compiler.visitor.*;
import java.io.OutputStream;
import java.util.*;

class App {
    public void printExampleProgram(OutputStream out) {
        // let apply = (f, x) { f(x) }
        var applyBind = AST.let("apply", e -> {
            e.expr = AST.function(apply -> {
                apply.parameters.add(AST.identDecl("f"));
                apply.parameters.add(AST.identDecl("x"));
                apply.return_ = AST.invoke("f", asdf -> {
                    asdf.arguments.add(AST.ident("x"));
                });
            });
        });
        // let apply2 = (f, x) { f(x) }
        var apply2Bind = AST.let("apply2", e -> {
            e.expr = AST.function(apply -> {
                apply.parameters.add(AST.identDecl("f"));
                apply.parameters.add(AST.identDecl("x"));
                apply.return_ = AST.invoke("f", asdf -> {
                    asdf.arguments.add(AST.ident("x"));
                });
            });
        });

        // let square = (x) { x * x }
        var squareBind = AST.let("square", e -> {
            e.expr = AST.function(square -> {
                square.parameters.add(AST.identDecl("x"));
                square.return_ = AST.op(Operator.Multiply, op -> {
                    op.left(AST.ident("x"));
                    op.right(AST.ident("x"));
                });
            });
        });

        // let id = (x) { x }
        var idBind = AST.let("id", e -> {
            e.expr = AST.function(f -> {
                f.parameters.add(AST.identDecl("x"));
                f.return_ = AST.ident("x");
            });
        });

        // let a = 2
        var aBind = AST.let("a", e -> {
            e.expr = AST.number(2);
        });

        // let b = apply(square, a)
        var bBind = AST.let("b", e -> {
            e.expr = AST.invoke("apply", i -> {
                i.arguments.add(AST.ident("square"));
                i.arguments.add(AST.ident("a"));
            });
        });

        // let c = apply(id, id)
        var cBind = AST.let("c", e -> {
            e.expr = AST.invoke("apply2", i -> {
                i.arguments.add(AST.ident("id"));
                i.arguments.add(AST.ident("square"));
            });
        });

        // let fact = (n) { if n == 0 { 1 } else { n * fact(n - 1) } }
        var factBind = AST.let("fact", e -> {
            e.expr = AST.function(f -> {
                f.parameters.add(AST.identDecl("n"));
                f.return_ = AST.ifElse(i -> {
                    i.boolExpr = AST.op(Operator.Eq, x -> {
                        x.left(AST.ident("n"));
                        x.right(AST.number(0));
                    });
                    i.trueCase = AST.number(1);
                    i.elseCase = AST.op(Operator.Multiply, x -> {
                        x.left(AST.ident("n"));
                        x.right(AST.invoke("fact", i2 -> {
                            i2.arguments.add(AST.op(Operator.Subtract, x2 -> {
                                x2.left(AST.ident("n"));
                                x2.right(AST.number(1));
                            }));
                        }));
                    });
                });
            });
        });

        var globalScope = AST.program(p -> {
            p.bindings.add(idBind);
            p.bindings.add(applyBind);
            p.bindings.add(apply2Bind);
            p.bindings.add(aBind);
            p.bindings.add(bBind);
            p.bindings.add(cBind);
            p.bindings.add(squareBind);
            p.bindings.add(factBind);
        });
            
        var idMap = new ScopeResolver().run(globalScope);
        new TypeInferencer(idMap).run(globalScope);
        new PrettyPrinter(out).run(globalScope);
        new TypeChecker(idMap).run(globalScope);

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
            x.expr = AST.invoke("f", fa -> {
                fa.arguments.add(AST.number(2.2));
            });
            x.declaration.type = AST.numberType();
        });
        
        var globalScope = AST.program(p -> {
            p.bindings.add(fBind);
            p.bindings.add(kBind);
        });
        
        var idMap = new ScopeResolver().run(globalScope);
        new PrettyPrinter(out).run(globalScope);
        new TypeInferencer(idMap).run(globalScope);
        new TypeChecker(idMap).run(globalScope);
    }

    public static void main(String[] args) {
        try {
            var app = new App();
            app.printExampleProgram(System.out);
            //app.typeCheckingExample(System.out);
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        }
    }
}