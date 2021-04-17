package compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;

import compiler.ast.ProgramNode;
import compiler.codegen.CodeGenVisitor;
import compiler.parser.CSTtoAST;
import compiler.parser.gLexer;
import compiler.parser.gParser;
import compiler.visitor.*;
import compiler.analysis.*;

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

    public static IdentifierContext infer(ProgramNode ast) throws VisitorExceptionAggregate {
        var idMap = new ScopeResolver().run(ast);
        var idCtx = new TypeInferencer(idMap).run(ast);
        return idCtx;
    }

    public static void check(
        IdentifierContext idCtx,
        ProgramNode ast
    ) throws VisitorExceptionAggregate {
        new TypeChecker(idCtx).run(ast);
    }

    public static void codeGen(ProgramNode ast) throws VisitorException {
        new CodeGenVisitor(System.out).run(ast);
    }

    public static void main(String[] args) {
        try {
            var ast = readAndParse("./examples/example2.bg");
            System.out.println("\n\n-------- Parsed --------\n\n");
            new PrettyPrinter(System.out).run(ast);
            var idMap = infer(ast);
            System.out.println("\n\n-------- Types inferenced --------\n\n");
            new PrettyPrinter(System.out).run(ast);
            new ClosureResolver().run(ast);
            // check(idMap, ast);
            System.out.println("\n\n----------------------------------\n\n");
            codeGen(ast);
        } catch (VisitorExceptionAggregate ex) {
            System.out.println("--------------------------------------");
            System.out.println("Compilation aborted because of errors:");
            System.out.println(ex);
        } catch (VisitorException ex) {
            System.out.println("-------------------------------------");
            System.out.println("Compilation aborted because of error:");
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        } catch (Error ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        }
    }
}