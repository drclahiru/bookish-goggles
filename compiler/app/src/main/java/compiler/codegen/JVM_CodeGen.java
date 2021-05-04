package compiler.codegen;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import compiler.IdentifierContext;
import compiler.Utility;
import compiler.ast.*;
import compiler.visitor.*;

public class JVM_CodeGen extends VisitorVoid {
	IdentifierContext idCtx;
	    Boolean isNewline = true;   
	    Set<Integer> arities = new HashSet<Integer>();
	    //Map<String, String> operatorNameMap = getOperatorNameMap();
	    HashSet<Identifier> globalIds = new HashSet<Identifier>(Utility.createPrelude().keySet());
	    
	// OutputStream out;
	// Boolean isNewline = true;
	// Integer indentLevel = 0;
	   HelperClasses helper;

public JVM_CodeGen(IdentifierContext idCtx) {
    super();
	this.idCtx = idCtx;
    arities.add(0);
    arities.add(2);
	var file = new File("./examples/jvmInstructions/Program.j");
    try {
		this.helper = new HelperClasses(new FileOutputStream(file));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
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
public void visitProgram(ProgramNode node) throws VisitorException {
	  for (var b : node.bindings) {
          globalIds.add(b.declaration.identifier.value);
      }
	printComment("test");
	println();
	String className = ".class public Test/Program";
	//how to get the main class name?
	print(className);
	println();
	print(".super java/lang/Object");
	skip(2);
	print("; standard initializer" );
	println();
	print(".method public <init>()V");
	println();
	helper.indentLevel++;
	print("aload_0");
	skip(1);
	print("invokenonvirtual java/lang/Object/<init>()V");   //or invokespecial?
	println();
	print("return");
	println();
	helper.indentLevel--;
	print(".end method");
	println();
	
	for (var x: node.bindings) {
		if (x.expr instanceof FunctionNode) {					
			var file = new File("./examples/jvmInstructions/" + x.declaration.identifier.value.name + ".j");
	          try {
				var out = helper.out;
				helper.out = new FileOutputStream(file);
				ClassGeneratorFunction(x.declaration, (FunctionNode)x.expr);
				helper.out = out;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		else {
			visit(x);
		}	
	}	
	
	//skip(2);
//	indentLevel++;
//	println();
//	print("return");
//	indentLevel--;
//	println();
//	print(".end method");
	newFile("$mod", a->helper.mod());
	newFile("$div", a->helper.div());
	newFile("$mul", a->helper.mul());
	newFile("$sub", a->helper.sub());
	newFile("$lt", a->helper.lt());
	newFile("$gt", a->helper.gt());
	newFile("$lte", a->helper.lte());
	newFile("$gte", a->helper.gte());
	newFile("$eq", a->helper.eq());
	newFile("$neq", a->helper.neq());
	newFile("$add", a->helper.add());
	newFile("$Eval0", a->helper.eval0Interface());
	newFile("$Eval1", a->helper.eval1Interface());
	newFile("$Eval2", a->helper.eval2Interface());
//	helper.mod();
//	skip(2);
//	helper.div();
//	skip(2);
//	helper.mul();
//	skip(2);
//	helper.sub();
//	skip(2);
//	helper.lt();
//	skip(2);
//	helper.gt();
//	skip(2);
//	helper.lte();
//	skip(2);
//	helper.gte();
//	skip(2);
//	helper.eq();
//	skip(2);
//	helper.neq();
//	skip(2);
//	helper.add();
//	skip(2);
//	helper.eval0Interface();
//	skip(2);
//	helper.eval1Interface();
//	skip(2);
//	helper.eval2Interface();
//	skip(2);
	println();
}

public void newFile(String name, Consumer<Object> f) throws VisitorException {
	 var file = new File("./examples/jvmInstructions/" + name + ".j");
     try {
		var out = helper.out;
		helper.out = new FileOutputStream(file);
		f.accept(null);
		helper.out = out;
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void ClassGenerator(IdentifierDeclarationNode decl, ExpressionNode expr) throws VisitorException {
	if (!(decl.typeScheme.type instanceof FunctionTypeNode)) {
		ClassGeneratorFunction(decl, (FunctionNode)expr);
	} else {
		
	}
	}
	

public void ClassGeneratorFunction(IdentifierDeclarationNode decl, FunctionNode f) throws VisitorException {
	print(".class public " + decl.identifier.value.name);
	println();
	print(".super java/lang/Object");
	println();
	print(".method public <init>()V");
	println();
	helper.indentLevel++;
	print("aload_0");
	skip(1);
	print("invokenonvirtual java/lang/Object/<init>()V");  
	println();
	print("return");
	println();
	helper.indentLevel--;
	print(".end method");
	println();
	print(".method public eval(");
	helper.indentLevel++;
	
	 if (f.parameters.size() > 0) {
         print("Ljava/lang/Object");
     }
     for (var i = 1; i < f.parameters.size(); i++) {
         print(";Ljava/lang/Object");
     }
    
	
	print(")a");
	println();
	var argMap  = new HashMap<Identifier, Integer>();
	for (var i = 0; i < f.parameters.size(); i++) {
		argMap.put(f.parameters.get(i).identifier.value, i+1);
	} 
	new ExpressionGenerator(argMap).visit(f.return_);
	print("areturn");
	println();
	helper.indentLevel--;
	print(".end method");
}

class ExpressionGenerator extends VisitorVoid {
	HashMap<Identifier, Integer> map;
	
	public ExpressionGenerator(HashMap<Identifier, Integer> map) {
		this.map = map;
	}

	 @Override
     protected void visitBool(BoolNode n) throws VisitorException {
		
		 if (n.value) {
			 print("iconst_1");
			 println();
		 } else {
			 print("iconst_0");
			 println();
		 }
		 print("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean");
		 }
	 
     @Override
     protected void visitNumber(NumberNode n) throws VisitorException { 	
    	 print("ldc_w " + n.value);
         println();
         print("invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double");
         println();
     }
     @Override
     protected void visitString(StringNode n) throws VisitorException {   	 
    	 print("ldc " + n.value);
         println();      
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
			  if (name != null) {
				print("new " + name);
				println();
				print("dup");
				println();
				print("invokespecial " +  name + "/<init>()V");
				println();
			  } else {
				print("new " + n.value.name);
				println();
				print("dup");
				println();
				print("invokespecial " +  n.value.name + "/<init>()V");
				println();
			  }
    	  } else {
    		//  print("aload_" + n.value);   	  
    	    	 print("aload_" + map.get(n.value));  
    	          println();
    		      print("checkcast ");
    	    	 if (type instanceof SimpleTypeNode) {
    	 			var t = (SimpleTypeNode)type;
    	 			switch (t.type) {
    	 			case Bool:
    	 			print("java/lang/Boolean");
    	 			break;
    	 			case Number:
    	 			print("java/lang/Double");
    	 			break;
    	 			case String:
    	 			print("java/lang/String");
    	 			break;
    	 			}
    	 		} else if (type instanceof FunctionTypeNode) {
    	 			var t = (FunctionTypeNode)type;
    	 			var s = "Eval" + t.parameters.size() + "(";
    	 			if (t.parameters.size() > 0) {
    	 				s += "Ljava/lang/Object";
    	 			}
    	 			for (var i = 1; i < t.parameters.size(); i++) {
    	 				s += ";Ljava/lang/Object";
    	 			}
    	 			s += ")a";
    	 			print(s);
    	 		} else {
    	 			print("java/lang/Object");
    	 		} 
    		  println();
    	  }        
     }	
     
     @Override
     protected void visitIfElse(IfElseNode n) throws VisitorException {
         print("aload_1");
         println();
         print("checkcast java/lang/Boolean");
         println();
         print("invokevirtual java/lang/Boolean/booleanValue()Z");
         println();
         print("ifne LabelFalse");
         println();
         visit(n.trueCase);
         print("goto LabelEnd");
         println();
         print("LabelFalse:");
         println();
         visit(n.elseCase);
         print("LabelEnd:");
         println();
         
     }
     
     
     @Override
     protected void visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
		visit(n.identifier);

    	 var args = n.arguments.size(); 
    	 for (var x:n.arguments ) {
    		 visit(x);
    	 }
    	  		  	   	
    	 print("invokeinterface Eval" + args + "/eval(");
    	 if (args > 0) {
             print("Ljava/lang/Object");
         }
         for (var i = 1; i < args; i++) {
             print(";Ljava/lang/Object");
         }
         print(")a " + args);
         println();
     }
     
}
public class RenameOperators extends VisitorVoid {
	
	protected void visitIdentifier(IdentifierNode n) {
		var m =  getOperatorNameMap();
		var name = m.get(n.value.name);
		if (name != null) {
			n.value = new Identifier(name);
			
		}
		
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
//	  print("");

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



