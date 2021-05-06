package compiler.codegen;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.function.Consumer;

import compiler.IdentifierContext;
import compiler.Utility;
import compiler.ast.*;
import compiler.visitor.*;

public class JVM_CodeGen {
	IdentifierContext idCtx;
	HashSet<Identifier> globalIds = new HashSet<Identifier>(Utility.createPrelude().keySet());
	HelperClasses helper;
	int labelCount = 1;

	public JVM_CodeGen(IdentifierContext idCtx) {
		super();
		this.idCtx = idCtx;
		var file = new File("./examples/jvmInstructions/Program.j");
		try {
			this.helper = new HelperClasses(new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new Error("failed to create file");
		}
	}

	public void run(ProgramNode node) throws VisitorException {
		for (var b : node.bindings) {
			globalIds.add(b.declaration.identifier.value);
		}
		//how to get the main class name?
		println(".class public Program");
		println(".super java/lang/Object");
		println();
		for (var x : node.bindings) {
			if (!(x.expr instanceof FunctionNode)) {
				println(".field public " + x.declaration.identifier.value.name + " Ljava/lang/Object;");
			}
		}
		println();
		println(".method public <init>()V");
		helper.indentLevel++;
		stackAndLocals();
		println("aload_0");
		println("invokenonvirtual java/lang/Object/<init>()V");
		for (var x : node.bindings) {
			var ident = x.declaration.identifier.value;
			if (!(x.expr instanceof FunctionNode)) {
				println("aload_0");
				new ExpressionGenerator(new HashMap<>()).visit(x.expr);
				println("putfield Program/" + ident.name + " Ljava/lang/Object;");
			}
		}
		println("return");
		helper.indentLevel--;
		println(".end method");
		println();
		
		for (var x : node.bindings) {
			if (x.expr instanceof FunctionNode) {				
				var file = new File("./examples/jvmInstructions/" + x.declaration.identifier.value.name + ".j");
				try {
					var out = helper.out;
					helper.out = new FileOutputStream(file);
					classGeneratorFunction(x.declaration, (FunctionNode)x.expr);
					helper.out = out;
				} catch (FileNotFoundException e) {
					throw new Error("failed to create file");
				}
			}
		}

		println(".method public static main([Ljava/lang/String;)V");
		helper.indentLevel++;
		
		stackAndLocals();
		println("getstatic java/lang/System/out Ljava/io/PrintStream;");
		println("new Program");
		println("dup");
		println("invokespecial Program/<init>()V");
		println("getfield Program/main Ljava/lang/Object;");
		println("invokevirtual java/lang/Object/toString()Ljava/lang/String;");
		println("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
		println("return");
		helper.indentLevel--;
		println(".end method");
		
		classNumberNumber("$add", a -> {
			println("dadd");
			println("invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;");
		});
		classNumberNumber("$mod", a -> {
			println("drem");
			println("invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;");
		});
		classNumberNumber("$div", a -> {
			println("ddiv");
			println("invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;");
		});
		classNumberNumber("$mul", a -> {
			println("dmul");
			println("invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;");
		});
		classNumberNumber("$sub", a -> {
			println("dsub");
			println("invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;");
		});
		classNumberNumber("$lt", a -> {
			println("dsub");
			println("invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;");
		});
		classBoolBool("$lt", "iflt");
		classBoolBool("$gt", "ifgt");
		classBoolBool("$gte", "ifge");
		classBoolBool("$lte", "ifle");
		newFile("$eq", a->helper.eq());
		newFile("$neq", a->helper.neq());
		evalInterface(0);
		evalInterface(1);
		evalInterface(2);
	}

	protected void print(String text) {
		helper.print(text);
	}

	protected void println() {
		helper.println();
	}
	protected void println(String text) {
		print(text);
		println();
	}

	protected void printComment(String s) {
		print("; " + s);
	}


	protected void skip(int num) {
		for (int i = 0; i < num; ++i)
			println();
	}

	void newFile(String name, Consumer<Object> f) {
		var file = new File("./examples/jvmInstructions/" + name + ".j");
		try {
			var out = helper.out;
			helper.out = new FileOutputStream(file);
			f.accept(null);
			helper.out = out;
		} catch (FileNotFoundException e) {
			throw new Error("failed to create new file");
		}
	}
		

	void classGeneratorFunction(IdentifierDeclarationNode decl, FunctionNode f) throws VisitorException {
		println(".class public " + decl.identifier.value.name);
		println(".super java/lang/Object");
		println(".implements Eval" + f.parameters.size());
		println();
		println(".method public <init>()V");
		helper.indentLevel++;
		println("aload_0");
		println("invokenonvirtual java/lang/Object/<init>()V");  
		println("return");
		helper.indentLevel--;
		println(".end method");
		println();
		print(".method public eval(");
		helper.indentLevel++;
		for (var i = 0; i < f.parameters.size(); i++) {
			print("Ljava/lang/Object;");
		}
		println(")Ljava/lang/Object;");
		stackAndLocals();
		var argMap  = new HashMap<Identifier, Integer>();
		for (var i = 0; i < f.parameters.size(); i++) {
			argMap.put(f.parameters.get(i).identifier.value, i+1);
		} 
		new ExpressionGenerator(argMap).visit(f.return_);
		println("areturn");
		helper.indentLevel--;
		println(".end method");
	}

	class ExpressionGenerator extends VisitorVoid {
		HashMap<Identifier, Integer> map;
		
		public ExpressionGenerator(HashMap<Identifier, Integer> map) {
			this.map = map;
		}

		@Override
		protected void visitBool(BoolNode n) throws VisitorException {
			if (n.value) {
				println("iconst_1");
			} else {
				println("iconst_0");
			}
			println("invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;");
		}
		
		@Override
		protected void visitNumber(NumberNode n) throws VisitorException { 	
			println("ldc2_w " + n.value);
			println("invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;");
		}
		@Override
		protected void visitString(StringNode n) throws VisitorException {   	 
			println("ldc " + n.value);
		}
		@Override
		protected void visitRange(RangeNode n) throws VisitorException {
			throw new Error("todo");
		}
		@Override
		protected void visitIdentifier(IdentifierNode n) throws VisitorException {
			var type = idCtx.get(n.value).type;
			var construct = globalIds.contains(n.value) && type instanceof FunctionTypeNode;
			
			if(construct) {
				var name = getOperatorNameMap().get(n.value.name);
				if (name == null) {
					name = n.value.name;
				}
				println("new " + name);
				println("dup");
				println("invokespecial " +  name + "/<init>()V");
			} else { 	  
				println("aload_" + map.get(n.value));
				print("checkcast ");
				if (type instanceof SimpleTypeNode) {
					var t = (SimpleTypeNode)type;
					switch (t.type) {
					case Bool:
					println("java/lang/Boolean");
					break;
					case Number:
					println("java/lang/Double");
					break;
					case String:
					println("java/lang/String");
					break;
					}
				} else if (type instanceof FunctionTypeNode) {
					var t = (FunctionTypeNode)type;
					print("Eval" + t.parameters.size() + "(");
					for (var i = 0; i < t.parameters.size(); i++) {
						print("Ljava/lang/Object;");
					}
					println(")Ljava/lang/Object;");
				} else {
					println("java/lang/Object");
				}
			}        
		}	
		
		@Override
		protected void visitIfElse(IfElseNode n) throws VisitorException {
			var labelFalse = "LabelFalse" + labelCount++;
			var labelEnd = "LabelEnd" + labelCount++;
			visit(n.boolExpr);
			println("checkcast java/lang/Boolean");
			println("invokevirtual java/lang/Boolean.booleanValue()Z");
			// TODO: is this correct?
			println("ifeq " + labelFalse);
			helper.indentLevel++;
			visit(n.trueCase);
			println("goto " + labelEnd);
			helper.indentLevel--;
			println(labelFalse + ":");
			helper.indentLevel++;
			visit(n.elseCase);
			helper.indentLevel--;
			println(labelEnd + ":");
		}
		
		
		@Override
		protected void visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
			visit(n.identifier);

			var args = n.arguments.size(); 
			for (var x:n.arguments ) {
				visit(x);
			}
							
			print("invokeinterface Eval" + args + "/eval(");
			for (var i = 0; i < args; i++) {
				print("Ljava/lang/Object;");
			}
			// the interface takes an instance of itself as the implicit first argument, hence +1
			println(")Ljava/lang/Object; " + (args + 1));
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

	void evalInterface(int n) {
		newFile("Eval" + n, a -> {
			println(".interface Eval" + n);
			println(".super java/lang/Object");
			println();
			print(".method public abstract eval(");
			for (var i = 0; i < n; i++) {
				print("Ljava/lang/Object;");
			}
			println(")Ljava/lang/Object;");
			println(".end method");
		});	
	}

	void classNumberNumber(String opName, Consumer<Object> op)  {
		newFile(opName, a -> {
			println(".class public " + opName);
			println(".super java/lang/Object");
			println(".implements Eval2");
			println();
			println(".method public <init>()V");
			helper.indentLevel++;
			println("aload_0");
			println("invokenonvirtual java/lang/Object/<init>()V");
			println("return");
			helper.indentLevel--;
			println(".end method");
			println();
			println(".method public eval(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
			helper.indentLevel++;
			stackAndLocals();
			println("aload_1");
			println("checkcast java/lang/Double");
			println("invokevirtual java/lang/Double.doubleValue()D");
			println("aload_2");
			println("checkcast java/lang/Double");
			println("invokevirtual java/lang/Double.doubleValue()D");
			op.accept(null);
			println("areturn"); 
			helper.indentLevel--;
			println(".end method");
		});
	}

	void classBoolBool(String opName, String eqType) {
		newFile(opName, a -> {
			println(".class public " + opName);
			println(".super java/lang/Object");
			println(".implements Eval2");
			println();
			println(".method public <init>()V");
			helper.indentLevel++;
			println("aload_0");
			println("invokenonvirtual java/lang/Object/<init>()V");
			println("return");
			helper.indentLevel--;
			println(".end method");
			println();
			println(".method public eval(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
			helper.indentLevel++;
			stackAndLocals();
			println("aload_1");
			println("checkcast java/lang/Boolean");
			println("invokevirtual java/lang/Boolean.booleanValue()Z");
			println("aload_2");
			println("checkcast java/lang/Boolean");
			println("invokevirtual java/lang/Boolean.booleanValue()Z");
			println("dcmpl");
			println(eqType + " LabelFalse");
			println("iconst_1");
			println("goto LabelEnd");
			println("LabelFalse:");
			println("iconst_0");
			println("LabelEnd:");
			println("invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;");
			println("areturn"); 
			helper.indentLevel--;
			println(".end method");
		});
	}

	void stackAndLocals() {
		// TODO: we should dynamically calculate what the maximum stack size and local count would be for any given expression
		println(".limit locals 10");
		println(".limit stack 10");
	}
}
