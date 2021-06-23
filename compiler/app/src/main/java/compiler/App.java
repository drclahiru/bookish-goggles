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
import java.util.ArrayList;
import java.util.stream.Collectors;

class App {
    static String JASMIN_OUTPUT_PATH = "jasmin";
    static String CLASS_OUTPUT_PATH = "output";

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

    public static void runJasmin() throws IOException, InterruptedException {
        var rt = Runtime.getRuntime();
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        var jasminOutput = new File(JASMIN_OUTPUT_PATH).getAbsoluteFile().toPath().normalize().toFile();
        var processes = new ArrayList<Process>();
        var jasminJar = new File("..\\libs\\jasmin.jar").getAbsoluteFile().toPath().normalize().toFile();
        var programOutput = new File(CLASS_OUTPUT_PATH).getAbsoluteFile();
        for (var f : jasminOutput.listFiles()) {
            var process = rt.exec("java -jar " + jasminJar + " " + f.getAbsolutePath(), new String[0], programOutput);
            processes.add(process);
        }

        var input = new ArrayList<String>();
        var error = new ArrayList<String>();
        for (var p : processes) {
            p.waitFor();
            input.add(new BufferedReader(new InputStreamReader(p.getInputStream())).lines().collect(Collectors.joining("\n")));
            error.add(new BufferedReader(new InputStreamReader(p.getErrorStream())).lines().collect(Collectors.joining("\n")));
        }
        var inputs = input.stream().filter(x -> x != "").collect(Collectors.toList());
        if (inputs.size() > 0) {
            System.out.println("Output:");
            input.stream().filter(x -> x != "").forEach(x -> {
                System.out.println(x);
            });
        }
        var errors = error.stream().filter(x -> x != "").collect(Collectors.toList());
        if (errors.size() > 0) {
            System.out.println("Error:");
            for (var x : errors) {
                System.out.println(x);
            }
        }
    }

    public static void main(String[] args) {
        try {
            var fileName = "list_stuff";
            var ast = readAndParse("./examples/" + fileName + ".puff");
            System.out.println("\n\n-------- Parsed --------\n\n");
            new PrettyPrinter(System.out).run(ast);
            var idMap = infer(ast);
            System.out.println("\n\n-------- Inferred --------\n\n");
            new PrettyPrinter(System.out).run(ast);
            // new TypeChecker().run(ast);
            System.out.println("\n\n----------------------------------\n\n");
            var idGen = new IdentifierGenerator();
            new MatchToIfElse(idGen).visit(ast);
            // new PrettyPrinter(System.out).run(ast);
            new LetExpressionDesugarer(idMap, idGen).run(ast);
            new LambdaLifter(idMap, idGen).run(ast);
            //new PrettyPrinter(System.out).run(ast);
            new JVM_CodeGen(idMap, JASMIN_OUTPUT_PATH).run(ast);
            runJasmin();
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