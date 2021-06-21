package compiler.codegen;

import java.io.OutputStream;
import java.util.*;

import compiler.*;
import compiler.analysis.ClosureResolver;
import compiler.ast.*;
import compiler.visitor.*;

public class JavaCodeGen {
    IdentifierContext idCtx;
    Integer indentLevel = 0;
    Boolean isNewline = true;
    OutputStream out;
    Set<Integer> arities = new HashSet<Integer>();
    Map<String, String> operatorNameMap = getOperatorNameMap();
    HashSet<Identifier> globalIds = new HashSet<>(Utility.createPrelude().keySet());

    public JavaCodeGen(OutputStream out, IdentifierContext idCtx) {
        super();
        this.idCtx = idCtx;
        this.out = out;
        arities.add(0);
        arities.add(2);
    }
    public void run(ProgramNode n) throws VisitorException {
        for (var b : n.bindings) {
            globalIds.add(b.declaration.identifier.value);
        }
        print("class Program ");
        startBlock();

        for (var b : n.bindings) {
            new ClassGenerator().visit(b);
            println();
        }
        println();
        printComment("=========== built-ins ===========");
        println();
        println();
        printPreludeOperators();
        printEvalInterfaces(arities);

        println();
        print("public static void main(String[] args) ");
        startBlock();
        println("new Program().run();");
        endBlock();
        println();
        print("public void run() ");
        startBlock();
        println("System.out.println(main);");
        endBlock();
        endBlock();
    }

    class EvalGenerator extends VisitorVoid {
        @Override
        protected void visitBool(BoolNode n) throws VisitorException {
            print(n.value ? "true" : "true");
        }
        @Override
        protected void visitNumber(NumberNode n) throws VisitorException {
            print(Double.toString(n.value));
        }
        @Override
        protected void visitString(StringNode n) throws VisitorException {
            print(n.value);
        }
        @Override
        protected void visitRange(RangeNode n) throws VisitorException {
            throw new Error("todo");
        }
        
        @Override
        protected void visitList(ListNode n) throws VisitorException {
         	   	
        		print("new ArrayList<Object>();");
        		println();	
        		
        		for (var arg : n.exprs) {
        			  print("((ArrayList)" + "x" + ").add(" );
        			  visit(arg);
        			  print(");");
        			  println();
        		  }
        }
        
    
        
        @Override
        protected void visitIdentifier(IdentifierNode n) throws VisitorException {
            var name = operatorNameMap.get(n.value.name);
            if (name == null) {
                name = n.value.name;
            }
            var type = idCtx.get(n.value).type;
            var construct = globalIds.contains(n.value) && type instanceof FunctionTypeNode;
            print("((");
            printJavaType(type);
            print(")");
            if (construct) {
                print("new ");
            }
            print(name);
            if (construct) {
                print("()");
            }
            print(")");
        }
        @Override
        protected void visitIfElse(IfElseNode n) throws VisitorException {
            visit(n.boolExpr);
            println();
            indentLevel++;
            print("? ");
            visit(n.trueCase);
            println();
            print(": ");
            visit(n.elseCase);
            indentLevel--;
        }
        HashSet<Identifier> parameters = new HashSet<>();
        @Override
        protected void visitFunction(FunctionNode n) throws VisitorException {
            for (var p : n.parameters) {
                parameters.add(p.identifier.value);
            }
            visit(n.return_);
        }
        @Override
        protected void visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
            visit(n.identifier);
            print(".eval(");
            if (n.arguments.size() > 0) {
                printFunctionInvocationArg(n.arguments.get(0));
            }
            for (var i = 1; i < n.arguments.size(); i++) {
                print(", ");
                printFunctionInvocationArg(n.arguments.get(i));
            }
            print(")");
        }

        void printFunctionInvocationArg(ExpressionNode n) throws VisitorException {
            if (n instanceof FunctionNode) {
                var fn = (FunctionNode)n;
                print("new ");
                visit(fn);
                print("(");
                for (var c : new ClosureResolver(globalIds).run(n)) {
                    print(c.name);
                }
                print(")");

            } else {
                visit(n);
            }
        }
    }
    
  

    class ClassGenerator extends VisitorVoid {
        void printLet(IdentifierDeclarationNode decl, ExpressionNode expr, ExpressionNode next) throws VisitorException {
            if (!(decl.typeScheme.type instanceof FunctionTypeNode)) {
                print("Object ");
                print(decl.identifier.value.name);
                print(" = ");
                new EvalGenerator().visit(expr);
                println(";");
            } else {
                var ty = (FunctionTypeNode)decl.typeScheme.type;
                var params = new ShallowParams().findParams(expr);
                print("class ");
                print(decl.identifier.value.name);
                print(String.format(" implements Eval%s ", ty.parameters.size()));
                startBlock();
                visit(expr);
                visit(next);
                print("public Object eval(");
                // parameters?
                if (params.size() > 0) {
                    print("Object ");
                    print(params.get(0).identifier.value.name);
                }
                for (var i = 1; i < params.size(); i++) {
                    print(", Object ");
                    print(params.get(i).identifier.value.name);
                }
                print(") ");
                startBlock();
                print("return ");
                new EvalGenerator().visit(expr);
                println(";");
                endBlock();
                endBlock();
            }
        }

        @Override
        protected void visitLetBinding(LetBindingNode n) throws VisitorException {
            printLet(n.declaration, n.expr, null);
        }
        @Override
        protected void visitLetExpression(LetExpressionNode n) throws VisitorException {
            printLet(n.declaration, n.expr, n.next);
        }
    }

    class ShallowParams extends VisitorVoid {
        List<IdentifierDeclarationNode> parameters = new ArrayList<>();
        public List<IdentifierDeclarationNode> findParams(AbstractNode n) throws VisitorException {
            visit(n);
            return parameters;
        }
        @Override
        protected void visitFunction(FunctionNode n) throws VisitorException {
            arities.add(n.parameters.size());
            parameters.addAll(n.parameters);
        }
        @Override
        protected void visitLetExpression(LetExpressionNode n) throws VisitorException {
        }
    }
    static TypeNode getReturnType(TypeNode t) {
        if (t instanceof FunctionTypeNode) {
            return ((FunctionTypeNode)t).return_;
        }
        return t;
    }
    static boolean isSimpleType(TypeNode t) {
        return t instanceof SimpleTypeNode;
    }

    void print(String text) {
        try {
            if (isNewline) {
                out.write(" ".repeat(this.indentLevel * 4).getBytes());
                isNewline = false;
            }
            out.write(text.getBytes());
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    void println() {
        println("");
    }
    void println(String text) {
        print(text);
        try {
            out.write("\n".getBytes());
            isNewline = true;
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    void startBlock() {
        print("{");
        indentLevel++;
        println();
    }

    void endBlock() {
        indentLevel--;
        println("}");
    }

    protected void printComment(String s) {
        print("/* ");
        print(s);
        print(" */");
    }

    void printJavaType(TypeNode ty) {
        if (ty instanceof SimpleTypeNode) {
            var t = (SimpleTypeNode)ty;
            switch (t.type) {
                case Bool:
                print("Boolean");
                break;
                case Number: 
                print("Double");
                break;
                case String:
                print("String");
                break;
            }
        } else if (ty instanceof FunctionTypeNode) {
            var t = (FunctionTypeNode)ty;
            print(String.format("Eval%s", t.parameters.size()));
        } else if (ty instanceof VariableTypeNode) {
            print("Object");
        } else {
            throw new Error("unexpected type: " + ty);
        }
    }

    void printEvalInterfaces(Set<Integer> ns) {
        for (var i : ns) {
            print("interface Eval");
            print(Integer.toString(i));
            print(" ");
            startBlock();
            print("Object eval(");
            if (i > 0) {
                print("Object a");
            }
            for (var t = 1; t < i; t++) {
                print(", Object ");
                print(Utility.intToAlphabetic(t).toLowerCase());
            }
            println(");");
            endBlock();
        }
    }

    Map<String, String> getOperatorNameMap() {
        var map = new HashMap<String, String>();
        map.put("+", "$eq");
        map.put("-", "$sub");
        map.put("*", "$mul");
        map.put("/", "$div");
        map.put("%", "$mod");
        map.put(">", "$gt");
        map.put(">=", "$gte");
        map.put("<", "$lt");
        map.put("<=", "$lte");
        map.put("==", "$eq");
        map.put("!=", "$neq");
        return map;
    }

    void printPreludeOperators() {
        printGenericOperator("$eq", "l.equals(r)");
        printGenericOperator("$neq", "!l.equals(r)");
        printOperator("$add", "Double", "Double", "l + r");
        printOperator("$sub", "Double", "Double", "l - r");
        printOperator("$mul", "Double", "Double", "l * r");
        printOperator("$div", "Double", "Double", "l / r");
        printOperator("$mod", "Double", "Double", "l % r");
        printOperator("$gt", "Double", "Boolean", "l > r");
        printOperator("$gte", "Double", "Boolean", "l >= r");
        printOperator("$lt", "Double", "Boolean", "l < r");
        printOperator("$lte", "Double", "Boolean", "l <= r");
    }

    void printOperator(String name, String argT, String retT, String expr) {
        print(String.format("class %s implements Eval2 ", name));
        startBlock();
        print("@Override public Object eval(Object l_, Object r_) ");
        startBlock();
        println(String.format("var l = (%s)l_;", argT));
        println(String.format("var r = (%s)r_;", argT));
        println(String.format("return %s;", expr));
        endBlock();
        endBlock();
    }

    void printGenericOperator(String name, String expr) {
        print(String.format("class %s implements Eval2 ", name));
        startBlock();
        print("@Override public Object eval(Object l, Object r) ");
        startBlock();
        println(String.format("return %s;", expr));
        endBlock();
        endBlock();
    }
}
