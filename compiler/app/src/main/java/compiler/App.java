package compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;

import compiler.ast.*;
import compiler.codegen.*;
import compiler.parser.CSTtoAST;
import compiler.parser.gLexer;
import compiler.parser.gParser;
import compiler.visitor.*;
import compiler.analysis.*;

import java.io.*;

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

    public static IdentifierContext infer(ProgramNode ast) throws VisitorException, VisitorExceptionAggregate {
        var idMap = new ScopeResolver().run(ast);
        var idCtx = new TypeInferencer(idMap).run(ast);
        return idCtx;
    }


    public static void main(String[] args) {
        try {
            var fileName = "factorial";
            var ast = readAndParse("./examples/" + fileName + ".puff");
            System.out.println("\n\n-------- Parsed --------\n\n");
            new PrettyPrinter(System.out).run(ast);
            var idMap = infer(ast);
            System.out.println("\n\n-------- Inferred --------\n\n");
            new PrettyPrinter(System.out, x -> x.printScopeNumber = false).run(ast);
            // new TypeChecker().run(ast);
            System.out.println("\n\n----------------------------------\n\n");
            var idGen = new IdentifierGenerator();
            new LetExpressionDesugarer(idMap, idGen).run(ast);
            new LambdaLifter(idMap, idGen).run(ast);
            new PrettyPrinter(System.out).run(ast);
            new JVM_CodeGen(idMap).run(ast);
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