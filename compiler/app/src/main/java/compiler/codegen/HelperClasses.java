package compiler.codegen;

import java.io.ByteArrayOutputStream;
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

protected void printComment(String s) {
	print("; " + s);
}


protected void skip(int num) {
	for (int i = 0; i < num; ++i)
		println();
}


public void eval0Interface() {
	print(".interface Program$Eval0");
	println();
	print(".super java/lang/Object");    //interface should inherit from Object, if not from another interface
	println();
	print(".method abstract eval()a");   //not sure if java.lang.Object should be repeated here
	println();
	print(".end method");	
	println();
}

public void eval1Interface() {
	print(".interface Program$Eval1");
	println();
	print(".super java/lang/Object");    //interface should inherit from Object, if not from another interface
	println();
	print(".method abstract eval(Ljava/lang/Object)a");    //not sure if this is valid way to add parameters 
	println();
	print(".end method");	
	println();
}

public void eval2Interface() {
	print(".interface Program$Eval2");
	println();
	print(".super java/lang/Object");    //interface should inherit from Object, if not from another interface
	println();
	print(".method abstract eval(Ljava/lang/Object;Ljava/lang/Object)a");    //should be added limit stack,.., or only in implementor?
	println();
	print(".end method");	
	println();
}



//String newLine = System.getProperty("line.separator");

public void add(){								//should these classes have public static main methods?
	 print(".class public Program$$add");
	 operatorInit();
	 loadVar();
	 print("dadd");
	 returnResult();
	 indentLevel--;
	 print(".end method");
	 println();
	  }


 public void sub(){
	 print(".class public Program$$sub");
	 operatorInit();
	 loadVar();
	 print("dsub");
	 returnResult();
	 indentLevel--;
	 print(".end method");
	 println();
 }


 
public void mul(){
	 print(".class public Program$$mul");
	 operatorInit();
	 loadVar();
	 print("dmul");
	 returnResult();
	 indentLevel--;
	 print(".end method");
	 println();
 }

public void returnResult() {
	println();
	 print("invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double");
	 println();
	 print("areturn"); 
	 println();
}
 
public void div(){
	 print(".class public Program$$div");
	 operatorInit();
	 loadVar();
	 print("ddiv");
	 returnResult();
	 indentLevel--;
	 print(".end method");
	 println();
 }
 
public void mod(){
	 print(".class public Program$$mod");
	 implementsInterface();   
	 standardInitializer();
	 print("");
	 print(".method public eval(Ljava/lang/Object;Ljava/lang/Object)a");
	 println();
	 indentLevel++;
	 loadVar();
	 print("drem");
	 returnResult();
	 indentLevel--;
	 print(".end method");
	 println();
 }
 
public void gt(){
	 print(".class public Program$$gt");
	 operatorInit();
	 
	 loadVar();
	 print("dcmpl");
	 println();
	 print("ifle Label1");
	 println();
	 print("iconst_1");
	 println();
	 print("goto Label2");
	 println();
	 indentLevel--;
	 print("Label1:");
	 indentLevel++;
	 println();
	 print("iconst_0");
	 println();
	 indentLevel--;
	 print("Label2:");
	 indentLevel++;
	 println();
	 print("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean");
	 println();
	 print("areturn");
	 
	 println();
	 indentLevel--;
	 print(".end method");
	 println();
 }
 
 
public void lt(){
	 print(".class public Program$$lt");
	 operatorInit();
	 
	 loadVar();
	 print("dcmpl");
	 println();
	 print("ifge Label1");
	 println();
	 print("iconst_1");
	 println();
	 print("goto Label2");
	 println();
	 indentLevel--;
	 print("Label1:");
	 indentLevel++;
	 println();
	 print("iconst_0");
	 println();
	 indentLevel--;
	 print("Label2:");
	 indentLevel++;
	 println();
	 print("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean");
	 println();
	 print("areturn");
	 
	 println();
	 indentLevel--;
	 print(".end method");
	 println();
 }
 
public void lte(){
	 print(".class public Program$$lte");
	 operatorInit();
	 
	 loadVar();
	 print("dcmpg");
	 println();
	 print("ifgt Label1");
	 println();
	 print("iconst_1");
	 println();
	 print("goto Label2");
	 println();
	 indentLevel--;
	 print("Label1:");
	 indentLevel++;
	 println();
	 print("iconst_0");
	 println();
	 indentLevel--;
	 print("Label2:");
	 indentLevel++;
	 println();
	 print("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean");
	 println();
	 print("areturn");
	 
	 println();
	 indentLevel--;
	 print(".end method");
	 println();
 }
 
 
public void gte(){
	 print(".class public Program$$gte");
	 operatorInit();
	 
	 loadVar();
	 print("dcmpl");
	 println();
	 print("iflt Label1");
	 println();
	 print("iconst_1");
	 println();
	 print("goto Label2");
	 println();
	 indentLevel--;
	 print("Label1:");
	 indentLevel++;
	 println();
	 print("iconst_0");
	 println();
	 indentLevel--;
	 print("Label2:");
	 indentLevel++;
	 println();
	 print("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean");
	 println();
	 print("areturn");
	 
	 
	 println();
	 indentLevel--;
	 print(".end method");
	 println();
 }
 
public void eq(){
	 print(".class public Program$$eq");
	 operatorInit();
	 
	 print("aload_1");
	 println();
	 print("aload_2");
	 println();
	 print("invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z");
	 println();
	 print("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean");
	 println();
	 print("areturn");
	 
	 println();
	 indentLevel--;
	 print(".end method");
	 println();
 }
 
public void neq(){
	 print(".class public Program$$neq");
	 operatorInit();
	 
	 print("aload_1");
	 println();
	 print("aload_2");
	 println();
	 print("invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z");
	 println();
	 print("ifne Label1");
	 println();
	 print("iconst_1");
	 println();
	 print("goto Label2");
	 println();
	 indentLevel--;	        
	 print("Label1:");
	 println();
	 indentLevel++;
	 print("iconst_0");
	 println();
	 indentLevel--;
	 print("Label2:");
	 println();
	 indentLevel++;
	 print("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean");
	 println();
	 print("areturn");
		 
	 println();
	 indentLevel--;
	 print(".end method");
	 println();
 }
 
public void standardInitializer() {    
		println();
		print(".method public <init>()V");
		println();
		indentLevel++;
		print("aload_0");
		skip(1);
		print("invokenonvirtual java/lang/Object/<init>()V");  
		println();
		print("return");
		println();
		indentLevel--;
		print(".end method");
		println();
		skip(2);
	}

public void loadVar() {
		print("aload_1");
		 println();
		 print("checkcast java/lang/Double");
		 println();
		 print("astore_3");
		 println();
		 print("aload_2");
		 println();
		 print("checkcast java/lang/Double");
		 println();
		 print("astore 4");   //not sure what the "4" is representing
		 println();
		 print("aload_3");
		 println();
		 print("invokevirtual java/lang/Double/doubleValue()D");
		 println();
		 print("aload 4");    //not sure what the "4" is representing
		 println();
		 print("invokevirtual java/lang/Double/doubleValue()D");
		 println();
	}

public void implementsInterface() {
		println();
		 print(".super java/lang/Object");    
		 println();
		 print(".implements Program$Eval2");   //each class written to a fixed file and then just call that file location?
	}

public void operatorInit() {
		implementsInterface();   
		 standardInitializer();
		 print(".method public eval(Ljava/lang/Object;Ljava/lang/Object)a");
		 println();
		 indentLevel++;
	}
}



