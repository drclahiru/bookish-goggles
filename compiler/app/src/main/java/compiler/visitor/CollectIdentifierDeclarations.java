package compiler.visitor;

import java.util.*;
import compiler.ast.*;

public class CollectIdentifierDeclarations extends Visitor {        
    HashMap<Identifier, IdentifierDeclarationNode> idMap = new HashMap<>();            
    
    public HashMap<Identifier, IdentifierDeclarationNode> run(ProgramNode n) {            
        visit(n);            
        return idMap;        
    }        
    
    @Override        
    protected void visitIdentifierDeclaration(IdentifierDeclarationNode node) {            
        idMap.put(node.identifier.value, node);        
    } 
}