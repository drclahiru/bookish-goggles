package compiler.codegen;


import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;
import compiler.Utility;
import compiler.ast.*;
import compiler.visitor.*;

public class JVM_CodeGen extends VisitorVoid {
	    Integer indentLevel = 0;
	    Boolean isNewline = true;   
	    Set<Integer> arities = new HashSet<Integer>();
	 //   Map<String, String> operatorNameMap = getOperatorNameMap();
	    HashSet<Identifier> globalIds = new HashSet<>(Utility.createPrelude().keySet());
	    
	// OutputStream out;
	// Boolean isNewline = true;
	// Integer indentLevel = 0;
	   HelperClasses helper;

public JVM_CodeGen(OutputStream out) {
    super();
    arities.add(0);
    arities.add(2);
    this.helper = new HelperClasses(out);
	 }

public void run(AbstractNode n) throws VisitorException {
	        visit(n);
	    }

protected void print(String text) {
	        helper.print(text);
	    }

protected void println() {
	        helper.println();
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
	helper.mod();
	skip(2);
	helper.div();
	skip(2);
	helper.mul();
	skip(2);
	helper.sub();
	skip(2);
	helper.lt();
	skip(2);
	helper.gt();
	skip(2);
	helper.lte();
	skip(2);
	helper.gte();
	skip(2);
	helper.eq();
	skip(2);
	helper.neq();
	skip(2);
	helper.add();
	skip(2);
	helper.eval0Interface();
	skip(2);
	helper.eval1Interface();
	skip(2);
	helper.eval2Interface();
	skip(2);
	println();
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



