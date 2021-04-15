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

    public static void check(ProgramNode ast) throws VisitorException, VisitorExceptionAggregate {
        var idMap = new ScopeResolver().run(ast);
        // new TypeInferencer(idMap).run(ast);
        new TypeChecker(idMap).run(ast);
    }

    public static void print(ProgramNode ast) throws VisitorException {
        new PrettyPrinter(System.out).run(ast);
        System.out.println("\n\n-------- Haskel Code Generated  --------\n\n");
        System.out.println();
        new CodeGenPretty(System.out).run(ast);
    }

    public static void main(String[] args) {
        try {
            var ast = readAndParse("./examples/example1.bg");
            System.out.println("\n\n-------- Parsed --------\n\n");
            print(ast);
            check(ast);
            System.out.println("\n\n-------- Types inferenced --------\n\n");
            print(ast);
        } catch (VisitorExceptionAggregate exAggr) {
            System.out.println("--------------------------------------");
            System.out.println("Compilation aborted because of errors:");
            for (var ex : exAggr.exceptions) {
                printError(ex);
            }
        } catch (VisitorException ex) {
            System.out.println("-------------------------------------");
            System.out.println("Compilation aborted because of error:");
            printError(ex);
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        } catch (Error ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        }
    }
    static void printError(VisitorException ex) {
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