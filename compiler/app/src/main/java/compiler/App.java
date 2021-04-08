package compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;

import compiler.ast.ProgramNode;
import compiler.parser.gLexer;
import compiler.parser.gParser;
import compiler.visitor.*;

import java.io.IOException;

class App {
    public static ProgramNode readAndParse(String path) throws IOException {
        var cs = CharStreams.fromFileName(path);
        return parse(cs);
    }

    public static ProgramNode parse(CharStream cs) throws IOException {
        var lexer = new gLexer(cs);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new gParser(tokenStream);
        var ast = new CSTtoAST().visitGlobal_scope(parser.global_scope());
        return ast;
    }

    public static void check(ProgramNode ast) {
        var idMap = new ScopeResolver().run(ast);
        // new TypeInferencer(idMap).run(ast);
        new TypeChecker(idMap).run(ast);
    }

    public static void print(ProgramNode ast) {
        new PrettyPrinter(System.out).run(ast);
    }

    public static void main(String[] args) {
        try {
            var ast = readAndParse("./examples/error.bg");
            System.out.println("\n\n-------- Parsed --------\n\n");
            print(ast);
            check(ast);
            System.out.println("\n\n-------- Types inferenced --------\n\n");
            print(ast);
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        }
    }
}