package compiler.ast;

import java.util.*;

public class Utility {
    public static HashMap<Identifier, TypeNode> createPrelude() {
        var map = new HashMap<Identifier, TypeNode>();

        var n = new SimpleTypeNode(null, SimpleType.Number);
        var b = new SimpleTypeNode(null, SimpleType.Bool);

        var nnn = new FunctionTypeNode(null);
        nnn.parameters.add(n);
        nnn.parameters.add(n);
        nnn.return_ = n;

        var bbb = new FunctionTypeNode(null);
        bbb.parameters.add(b);
        bbb.parameters.add(b);
        bbb.return_ = b;

        var nnb = new FunctionTypeNode(null);
        nnb.parameters.add(n);
        nnb.parameters.add(n);
        nnb.return_ = b;

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
