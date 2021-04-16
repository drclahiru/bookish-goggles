package compiler;

import compiler.ast.*;

public class Utility {
    public static IdentifierContext createPrelude() {
        var map = new IdentifierContext();

        var n = new SimpleTypeNode(null, SimpleType.Number);
        var b = new SimpleTypeNode(null, SimpleType.Bool);
        var x = new VariableTypeNode("x");

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

        var xxb = new FunctionTypeNode(null);
        xxb.parameters.add(x);
        xxb.parameters.add(x);
        xxb.return_ = b;

        var nnnTs = new TypeScheme(nnn);
        var nnbTs = new TypeScheme(nnb);
        var bbbTs = new TypeScheme(bbb);
        var xxbTs = new TypeScheme(xxb);
        xxbTs.vars.add(x);

        map.put(new Identifier("+"), nnnTs);
        map.put(new Identifier("-"), nnnTs);
        map.put(new Identifier("*"), nnnTs);
        map.put(new Identifier("/"), nnnTs);
        map.put(new Identifier("%"), nnnTs);
        map.put(new Identifier("<"), nnbTs);
        map.put(new Identifier(">"), nnbTs);
        map.put(new Identifier("<="), nnbTs);
        map.put(new Identifier(">="), nnbTs);
        map.put(new Identifier("!="), xxbTs);
        map.put(new Identifier("=="), xxbTs);
        map.put(new Identifier("&&"), bbbTs);
        map.put(new Identifier("||"), bbbTs);

        return map;
    }

    // 0=a, 1=b, ..., 26=z, 27=aa, 28=ab, ...
    public static String intToAlphabetic(int code) {
        var s = "";
        for (var n = code + 1; n > 0; n /= 26) {
            var c = (char)(96 + (n % 26));
            s += c;
            n /= 26;
        }
        return s;
    }
}
