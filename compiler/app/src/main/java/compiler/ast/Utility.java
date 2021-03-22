package compiler.ast;

import java.util.*;

public class Utility {
    public static HashMap<Identifier, TypeNode> createPrelude() {
        var map = new HashMap<Identifier, TypeNode>();

        var nnn = AST.funcType(t -> {
            t.parameters.add(AST.numberType());
            t.parameters.add(AST.numberType());
            t.return_ = AST.numberType();
        });
        var bbb = AST.funcType(t -> {
            t.parameters.add(AST.boolType());
            t.parameters.add(AST.boolType());
            t.return_ = AST.boolType();
        });
        var nnb = AST.funcType(t -> {
            t.parameters.add(AST.numberType());
            t.parameters.add(AST.numberType());
            t.return_ = AST.boolType();
        });

        map.put(new Identifier("+"), nnn);
        map.put(new Identifier("-"), nnn);
        map.put(new Identifier("*"), nnn);
        map.put(new Identifier("/"), nnn);
        map.put(new Identifier("%"), nnn);
        map.put(new Identifier("<"), nnb);
        map.put(new Identifier(">"), nnb);
        map.put(new Identifier("<="), nnb);
        map.put(new Identifier(">="), nnb);
        map.put(new Identifier("=="), nnb);
        map.put(new Identifier("&&"), bbb);
        map.put(new Identifier("||"), bbb);

        return map;
    }

    public static String intToAlphabetic(int code) {
        var s = "";
        for (var n = code; n > 0; n /= 26) {
            var c = (char)(97 + (n % 26));
            s += c;
            n /= 26;
        }
        return s;
    }
}
