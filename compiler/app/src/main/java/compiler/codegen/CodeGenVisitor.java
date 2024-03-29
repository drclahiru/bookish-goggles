package compiler.codegen;

import java.io.OutputStream;
import compiler.ast.*;
import compiler.visitor.*;

public class CodeGenVisitor extends VisitorVoid {
	 OutputStream out;
	 Boolean isNewline = true;
	 Integer indentLevel = 0;
	 
	public CodeGenVisitor(OutputStream out) {
		super();
		this.out = out;
	 }

	public void run(AbstractNode n) throws VisitorException {
		visit(n);
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
		try {
			out.write("\n".getBytes());
			isNewline = true;
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	void startBlock() {
		indentLevel++;
		print("{");
		println();
	}

	void endBlock() {
		indentLevel--;
		print("}");
		println();
	}

	@Override
	protected void visitLetBinding(LetBindingNode node) throws VisitorException {
		print(toJavaType(node.declaration.typeScheme.type));
		print(" ");
		visit(node.declaration.identifier);
		print(" = ");
		visit(node.expr);
		print(";");
		println();
	}
	   
	@Override
	protected void visitIdentifier(IdentifierNode node) throws VisitorException {
		print(node.value.name);
	}

	@Override
	protected void visitNumber(NumberNode node) throws VisitorException {
		print(Double.toString(node.value));
	}

	@Override
	protected void visitProgram(ProgramNode node) throws VisitorException {
		print("class Program ");
		startBlock();
		for (var x: node.bindings) {
			visit(x);
		}	
		print("public static void main(String[] args) ");
		startBlock();
		
		endBlock();
		endBlock();
	}

	@Override
	protected void visitFunction(FunctionNode node) throws VisitorException {	 
		for (var arg : node.parameters) {
			visit(arg.identifier);
			print(" -> ");
		}
		visit(node.return_);	
	}


	@Override
	protected void visitFunctionInvocation(FunctionInvocationNode node) throws VisitorException {
	  	if (node.isOperator()) {
			print("(");
			visit(node.arguments.get(0));
			print(" ");
			visit(node.identifier);
			print(" ");
			visit(node.arguments.get(1));
			print(")");
      	} else {
			visit(node.identifier);
			for (var x : (Iterable<ExpressionNode>) node.arguments) {
				print("(");
				visit(x);
				print(")");
			}        
		}
	}

	static String toJavaType(TypeNode ty) {
		if (ty instanceof SimpleTypeNode) {
			var t = (SimpleTypeNode)ty;
			switch (t.type) {
			case Bool: return "Bool";
			case Number: return "Double";
			case String: return "String";
			}
		}
		if (ty instanceof FunctionTypeNode) {
			var t = (FunctionTypeNode)ty;
			var s = toJavaType(t.return_);
			for (var p : t.parameters) {
				s = "Function<" + toJavaType(p) + ", " + s + ">";
			}
			return s;
		}
		if (ty instanceof VariableTypeNode) {
			return ((VariableTypeNode)ty).id;
		}
		throw new Error("unexpected type: " + ty);
	}

	@Override
	protected void visitIfElse(IfElseNode node) throws VisitorException {
		visit(node.boolExpr);
		print(" ? ");
		visit(node.trueCase);
		print(" : ");
		visit(node.elseCase);
	}

	@Override
	protected void visitBool(BoolNode node) {
		print(Boolean.toString(node.value));
	}

	@Override
	protected void visitString(StringNode node) {
		print(node.value);
	}
}