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

    public static void check(ProgramNode ast) throws Visitor.VisitorException, Visitor.VisitorExceptionAggregate {
        var idMap = new ScopeResolver().run(ast);
        // new TypeInferencer(idMap).run(ast);
        new TypeChecker(idMap).run(ast);
    }

    public static void print(ProgramNode ast) throws Visitor.VisitorException {
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
        } catch (Visitor.VisitorExceptionAggregate exAggr) {
            System.out.println("--------------------------------------");
            System.out.println("Compilation aborted because of errors:");
            for (var ex : exAggr.exceptions) {
                printError(ex);
            }
        } catch (Visitor.VisitorException ex) {
            System.out.println("-------------------------------------");
            System.out.println("Compilation aborted because of error:");
            printError(ex);
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        }
    }
    static void printError(Visitor.VisitorException ex) {
        var sourceNode = ex.source;
        var source = sourceNode.source;
        var start = source.getStart();
        var stop = source.getStop();
        System.out.print("[");
        System.out.print(start.getLine());
        System.out.print(":");
        System.out.print(start.getCharPositionInLine());
        System.out.print("..");
        System.out.print(stop.getLine());
        System.out.print(":");
        System.out.print(stop.getCharPositionInLine());
        System.out.print("] ");
        System.out.println(ex.message);
    }
}