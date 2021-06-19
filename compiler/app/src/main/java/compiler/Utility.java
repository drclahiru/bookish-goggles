package compiler;

import compiler.ast.*;

public class Utility {
    public static IdentifierContext createPrelude() {
        var map = new IdentifierContext();

        var n = new SimpleTypeNode(null, SimpleType.Number);
        var b = new SimpleTypeNode(null, SimpleType.Bool);
        var x = new VariableTypeNode("x");

        {
            var nnn = new FunctionTypeNode(null);
            nnn.parameters.add(n);
            nnn.parameters.add(n);
            nnn.return_ = n;

            var nnnTs = new TypeScheme(nnn);
            map.put(new Identifier("+"), nnnTs);
            map.put(new Identifier("-"), nnnTs);
            map.put(new Identifier("*"), nnnTs);
            map.put(new Identifier("/"), nnnTs);
            map.put(new Identifier("%"), nnnTs);
        }
        {
            var nnb = new FunctionTypeNode(null);
            nnb.parameters.add(n);
            nnb.parameters.add(n);
            nnb.return_ = b;
            var nnbTs = new TypeScheme(nnb);
            map.put(new Identifier("<"), nnbTs);
            map.put(new Identifier(">"), nnbTs);
            map.put(new Identifier("<="), nnbTs);
            map.put(new Identifier(">="), nnbTs);
        }
        {
            var xxb = new FunctionTypeNode(null);
            xxb.parameters.add(x);
            xxb.parameters.add(x);
            xxb.return_ = b;
            var xxbTs = new TypeScheme(xxb);
            map.put(new Identifier("!="), xxbTs);
            map.put(new Identifier("=="), xxbTs);
        }
        {
            var bbb = new FunctionTypeNode(null);
            bbb.parameters.add(b);
            bbb.parameters.add(b);
            bbb.return_ = b;
            var bbbTs = new TypeScheme(bbb);
            map.put(new Identifier("&&"), bbbTs);
            map.put(new Identifier("||"), bbbTs);
        }
        {
            var listX = new ListTypeNode(null, x);
            var cons = new FunctionTypeNode(null);
            cons.parameters.add(x);
            cons.parameters.add(listX);
            cons.return_ = listX;
            map.put(new Identifier("::"), new TypeScheme(cons));
        }

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
