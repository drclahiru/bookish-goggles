package compiler.visitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import compiler.ast.BoolNode;
import compiler.ast.FunctionInvocationNode;
import compiler.ast.FunctionNode;
import compiler.ast.IdentifierDeclarationNode;
import compiler.ast.IdentifierNode;
import compiler.ast.IfElseNode;
import compiler.ast.LetBindingNode;
import compiler.ast.NumberNode;
import compiler.ast.ProgramNode;
import compiler.ast.RangeNode;
import compiler.ast.StringNode;
import compiler.ast.TypeNode;

public class CodeGen  extends VisitorT<TypeNode>  {

	
	private File file;
	private FileWriter fr;
	private BufferedWriter br;
	public CodeGen() throws IOException{
		this.file = new File("append.hs");
		this.fr = new FileWriter(file, true);
		this.br = new BufferedWriter(fr);
	}
	@Override
	TypeNode visitLetBinding(LetBindingNode n) throws VisitorException {
		try {
			visit(n.declaration);
			br.append("=");
            visitExpression(n.expr);
            
            br.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	TypeNode visitBool(BoolNode n) throws VisitorException {
		if(n.value) {
			try {
				br.append("True");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				br.append("False");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	TypeNode visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
		try {
			br.append("(");
			br.append(n.identifier.value.name);
			
			for(var i:n.arguments) {
				br.append(" ");
				visit(i);
				
			}
			br.append(")");
		 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	TypeNode visitFunction(FunctionNode n) throws VisitorException {
		try {
			
			br.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	TypeNode visitIdentifier(IdentifierNode n) throws VisitorException {
		try {
			br.append(n.value.name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	TypeNode visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
		visit(n.type);
        try {
			br.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		visitIdentifier(n.identifier);
		
		return null;
	}

	@Override
	TypeNode visitIfElse(IfElseNode n) throws VisitorException {
		try {
			br.append(" if ");
			visit(n.boolExpr);
			br.append(" then ");
			visit(n.trueCase);
			br.append(" else ");
			visit(n.elseCase);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	TypeNode visitNumber(NumberNode n) throws VisitorException {
		try {
			br.append(String.valueOf(n.value));
			br.append("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	TypeNode visitProgram(ProgramNode n) throws VisitorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	TypeNode visitString(StringNode n) throws VisitorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	TypeNode visitRange(RangeNode n) throws VisitorException {
		// TODO Auto-generated method stub
		return null;
	}

}
