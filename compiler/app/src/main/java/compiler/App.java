package compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;
import compiler.ast.*;
import compiler.parser.gLexer;
import compiler.parser.gParser;
import compiler.visitor.*;

import java.io.IOException;
import java.io.OutputStream;

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
                square.return_ = AST.invoke("*", op -> {
                    op.arguments.add(AST.ident("x"));
                    op.arguments.add(AST.ident("x"));
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
                    i.boolExpr = AST.invoke("==", x -> {
                        x.arguments.add(AST.ident("n"));
                        x.arguments.add(AST.number(0));
                    });
                    i.trueCase = AST.number(1);
                    i.elseCase = AST.invoke("*", x -> {
                        x.arguments.add(AST.ident("n"));
                        x.arguments.add(AST.invoke("fact", i2 -> {
                            i2.arguments.add(AST.invoke("-", x2 -> {
                                x2.arguments.add(AST.ident("n"));
                                x2.arguments.add(AST.number(1));
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
    public void cstTestCase(String source) throws IOException {
        var cs = CharStreams.fromFileName(source);
        var lexer = new gLexer(cs);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new gParser(tokenStream);
        var ast = new CSTtoAST().visitGlobal_scope(parser.global_scope());
        new PrettyPrinter(System.out).run(ast);
    }

    public static void main(String[] args) {
        try {
            var app = new App();
            app.cstTestCase("D:\\dev\\bookish-goggles\\compiler\\app\\examples\\example1.bg");
            //app.printExampleProgram(System.out);
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        }
    }
}