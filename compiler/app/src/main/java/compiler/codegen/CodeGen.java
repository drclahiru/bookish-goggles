package compiler.codegen;

import java.io.*;
import compiler.ast.*;
import compiler.visitor.*;

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
	protected TypeNode visitLetBinding(LetBindingNode n) throws VisitorException {
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
	protected TypeNode visitBool(BoolNode n) throws VisitorException {
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
	protected TypeNode visitFunctionInvocation(FunctionInvocationNode n) throws VisitorException {
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
	protected TypeNode visitFunction(FunctionNode n) throws VisitorException {
		try {
			
			br.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected TypeNode visitIdentifier(IdentifierNode n) throws VisitorException {
		try {
			br.append(n.value.name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected TypeNode visitIdentifierDeclaration(IdentifierDeclarationNode n) throws VisitorException {
		visit(n.type.type);
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
	protected TypeNode visitIfElse(IfElseNode n) throws VisitorException {
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
	protected TypeNode visitNumber(NumberNode n) throws VisitorException {
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
	protected TypeNode visitProgram(ProgramNode n) throws VisitorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected TypeNode visitString(StringNode n) throws VisitorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected TypeNode visitRange(RangeNode n) throws VisitorException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected TypeNode visitLetExpression(LetExpressionNode n) throws VisitorException {
		// TODO Auto-generated method stub
		return null;
	}

}
