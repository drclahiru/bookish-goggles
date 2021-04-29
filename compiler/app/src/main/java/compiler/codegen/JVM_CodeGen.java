package compiler.codegen;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import compiler.ast.*;
import compiler.visitor.*;

public class JVM_CodeGen extends VisitorVoid {

	 OutputStream out;
	 Boolean isNewline = true;
	 Integer indentLevel = 0;

public JVM_CodeGen(OutputStream out) {
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

@Override
protected void visitProgram(ProgramNode node) throws VisitorException {
	printComment("test");
	println();
	
	//how to get the main class name?
	print(".class public Test/Program");
	println();
	print(".super java/lang/Object");
	skip(2);
	print("; standard initializer" );
	println();
	print(".method public <init>()V");
	println();
	indentLevel++;
	print("aload_0");
	skip(1);
	print("invokenonvirtual java/lang/Object/<init>()V");   //or invokespecial?
	println();
	print("return");
	println();
	indentLevel--;
	print(".end method");
	println();
	
	for (var x: node.bindings) {
		visit(x);
	}	
	
	//skip(2);
//	indentLevel++;
//	println();
//	print("return");
//	indentLevel--;
//	println();
//	print(".end method");
	skip(2);
	mod();
	skip(2);
	div();
	skip(2);
	mul();
	skip(2);
	sub();
	skip(2);
	lt();
	skip(2);
	gt();
	skip(2);
	lte();
	skip(2);
	gte();
	skip(2);
	eq();
	skip(2);
	neq();
	skip(2);
	add();
	skip(2);
	eval0Interface();
	skip(2);
	eval1Interface();
	skip(2);
	eval2Interface();
	skip(2);
	println();
}

void eval0Interface() {
	print(".interface Program$Eval0");
	println();
	print(".super java/lang/Object");    //interface should inherit from Object, if not from another interface
	println();
	print(".method abstract eval()a");   //not sure if java.lang.Object should be repeated here
	println();
	print(".end method");	
	println();
}

void eval1Interface() {
	print(".interface Program$Eval1");
	println();
	print(".super java/lang/Object");    //interface should inherit from Object, if not from another interface
	println();
	print(".method abstract eval(Ljava/lang/Object)a");    //not sure if this is valid way to add parameters 
	println();
	print(".end method");	
	println();
}

void eval2Interface() {
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

 void add(){								//should these classes have public static main methods?
	 print(".class public Program$$add");
	 operatorInit();
	 loadVar();
	 print("dadd");
	 returnResult();
	 indentLevel--;
	 print(".end method");
	 println();
	  }


 void sub(){
	 print(".class public Program$$sub");
	 operatorInit();
	 loadVar();
	 print("dsub");
	 returnResult();
	 indentLevel--;
	 print(".end method");
	 println();
 }


 
 void mul(){
	 print(".class public Program$$mul");
	 operatorInit();
	 loadVar();
	 print("dmul");
	 returnResult();
	 indentLevel--;
	 print(".end method");
	 println();
 }

private void returnResult() {
	println();
	 print("invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double");
	 println();
	 print("areturn"); 
	 println();
}
 
 void div(){
	 print(".class public Program$$div");
	 operatorInit();
	 loadVar();
	 print("ddiv");
	 returnResult();
	 indentLevel--;
	 print(".end method");
	 println();
 }
 
 void mod(){
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
 
 void gt(){
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
 
 
 void lt(){
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
 
 void lte(){
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
 
 
 void gte(){
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
 
 void eq(){
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
 
 void neq(){
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
 
 void standardInitializer() {    
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

	private void loadVar() {
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

	private void implementsInterface() {
		println();
		 print(".super java/lang/Object");    
		 println();
		 print(".implements Program$Eval2");   //each class written to a fixed file and then just call that file location?
	}

	private void operatorInit() {
		implementsInterface();   
		 standardInitializer();
		 print(".method public eval(Ljava.lang.Object;Ljava.lang.Object)a");
		 println();
		 indentLevel++;
	}

//@Override
//protected void visitLetBinding(LetBindingNode node) throws VisitorException {
//
//    print(toJavaType(node.declaration.type.type));
//    print(" ");
//    visit(node.declaration.identifier);
//    print(" = ");
//
//    visit(node.expr);
//    print(";");
//
//    println();
//}
//
//@Override
//protected void visitIdentifier(IdentifierNode node) throws VisitorException {
//	//print(node.value.name);
//
//}
//
//
//@Override
//protected void visitNumber(NumberNode node) throws VisitorException {
//	  print(Double.toString(node.value));
//
//}
//
//
//
//@Override
//protected void visitFunction(FunctionNode node) throws VisitorException {	 
//      for (var arg : node.parameters) {
//          visit(arg.identifier);
//          print(" -> ");
//      }
//	  visit(node.return_);	
//}
//
//
//@Override
//protected void visitFunctionInvocation(FunctionInvocationNode node) throws VisitorException {
//	  if (node.isOperator()) {
//          visit(node.arguments.get(0));
//          print(" ");
//          visit(node.identifier);
//          print(" ");
//          visit(node.arguments.get(1));
//      } else {
//          visit(node.identifier);
//          for (var x : (Iterable<ExpressionNode>) node.arguments) {
//              print("(");
//              visit(x);
//              print(")");
//          }        
//      }
//}
//
//
//static String toJavaType(TypeNode ty) {        
//		if (ty instanceof SimpleTypeNode) {            
//			var t = (SimpleTypeNode)ty;            
//			switch (t.type) {                
//			case Bool: return "Bool";                
//			case Number: return "Double";                
//			case String: return "String";            
//			}        
//		}        
//		if (ty instanceof FunctionTypeNode) {            
//			var t = (FunctionTypeNode)ty;            
//			var s = toJavaType(t.parameters.get(t.parameters.size() - 1));            
//			for (var p : (Iterable<TypeNode>)t.parameters.stream().limit(t.parameters.size() - 1)::iterator) {                
//				s = "Function<" + toJavaType(p) + ", " + s + ">";            }            
//			s = "Function<" + s + ", " + toJavaType(t.return_) + ">";
//			return s;        }        
//		if (ty instanceof VariableTypeNode) {            // what to do?        
//
//		}
//		throw new Error("unexpected type: " + ty);    }
//
//
//@Override
//protected void visitIfElse(IfElseNode node) throws VisitorException {
//		    visit(node.boolExpr);
//		    print(" ? ");
//		    visit(node.trueCase);
//		    print(" : ");
//		    visit(node.elseCase);
//		}
//
//
//@Override
//protected void visitBool(BoolNode node) {
//    print(Boolean.toString(node.value));
//}
//



}



