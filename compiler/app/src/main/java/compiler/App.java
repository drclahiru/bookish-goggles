package compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;
import compiler.parser.gLexer;
import compiler.parser.gParser;
import compiler.visitor.*;

import java.io.IOException;

class App {
    public void cstTestCase(String source) throws IOException {
        var cs = CharStreams.fromFileName(source);
        var lexer = new gLexer(cs);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new gParser(tokenStream);
        var ast = new CSTtoAST().visitGlobal_scope(parser.global_scope());
        System.out.println("\n\n-------- Parsed --------\n\n");
        new PrettyPrinter(System.out).run(ast);
        var idMap = new ScopeResolver().run(ast);
        new TypeInferencer(idMap).run(ast);
        new TypeChecker(idMap).run(ast);
        System.out.println("\n\n-------- Types inferenced --------\n\n");
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