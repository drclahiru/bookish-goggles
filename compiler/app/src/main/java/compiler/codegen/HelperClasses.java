package compiler.codegen;

import java.io.OutputStream;
import compiler.ast.*;
import compiler.visitor.*;

public class HelperClasses extends VisitorVoid {
	 public OutputStream out;
	 Boolean isNewline = true;
	 Integer indentLevel = 0;

	public HelperClasses(OutputStream out) {
		super();
		this.out = out;
	}

	public void run(AbstractNode n) throws VisitorException {
		visit(n);
	}

	protected void print(String text) {
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

	protected void println() {
		try {
			out.write("\n".getBytes());
			isNewline = true;
		} catch (Exception e) {
			throw new Error(e);
		}
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

	public void eq(){
		println(".class public $eq");
		operatorInit();
		
		println("aload_1");
		println("aload_2");
		println("invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z");
		println("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean");
		println("areturn");
		indentLevel--;
		println(".end method");
	}
	
	public void neq(){
		println(".class public $neq");
		operatorInit();
		
		println("aload_1");
		println("aload_2");
		println("invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z");
		println("ifne Label1");
		println("iconst_1");
		println("goto Label2");
		indentLevel--;	        
		println("Label1:");
		indentLevel++;
		println("iconst_0");
		indentLevel--;
		println("Label2:");
		indentLevel++;
		println("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean");
		println("areturn");
		indentLevel--;
		println(".end method");
	}
	

	public void operatorInit() {
		println(".super java/lang/Object");
		println(".implements Eval2");   //each class written to a fixed file and then just call that file location?
		println(".method public <init>()V");
		indentLevel++;
		println("aload_0");
		println("invokenonvirtual java/lang/Object/<init>()V");
		println("return");
		indentLevel--;
		println(".end method");
		skip(2);
		println(".method public eval(Ljava/lang/Object;Ljava/lang/Object)a");
		indentLevel++;
	}
}



