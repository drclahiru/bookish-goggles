package compiler;

import compiler.ast.*;
import compiler.visitor.*;
import java.io.OutputStream;
import java.util.*;

class App {
    public void printExampleProgram(OutputStream out) {
        var applyBind = AST.let("apply", e -> {
            e.expr = AST.function(apply -> {
                apply.parameters.add(AST.identDecl("f"));
                apply.parameters.add(AST.identDecl("x"));
                apply.return_ = AST.invoke(asdf -> {
                    asdf.identifier = AST.ident("f");
                    asdf.arguments.add(AST.ident("x"));
                });
            });
        });

        var squareBind = AST.let("square", e -> {
            e.expr = AST.function(square -> {
                square.parameters.add(AST.identDecl("x"));
                square.return_ = AST.op(Operator.Multiply, op -> {
                    op.left(AST.ident("x"));
                    op.right(AST.ident("x"));
                });
            });
        });

        var aBind = AST.let("a", e -> {
            e.expr = AST.number(2);
        });

        var bBind = AST.let("b", e -> {
            e.expr = AST.invoke(i -> {
                i.identifier = AST.ident("apply");
                i.arguments.add(AST.ident("square"));
                i.arguments.add(AST.ident("x"));
            });
        });

        var cBind = AST.let("c", e -> {
            e.expr = AST.invoke(i -> {
                i.identifier = AST.ident("apply");
                i.arguments.add(AST.ident("square"));
                i.arguments.add(AST.number(4));
            });
        });

        var globalScope = AST.program(p -> {
            p.bindings.add(applyBind);
            p.bindings.add(squareBind);
            p.bindings.add(aBind);
            p.bindings.add(bBind);
            p.bindings.add(cBind);
        });
            
        new ScopeResolver().run(globalScope);
        new TypeInferencer().run(globalScope);
        // new PrettyPrinter(out).run(globalScope);
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