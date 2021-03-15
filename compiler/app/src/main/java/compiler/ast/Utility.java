package compiler.ast;

import java.util.*;

public class Utility {
    public static String simpleTypeToString(SimpleType type) {
        return "" + type;
    }

    public static String opToString(Operator op) {
        switch (op) {
            case Add: return "+";
            case Subtract: return "-";
            case Multiply: return "*";
            case Divide: return "/";
            case Modulo: return "%";
            case LessThan: return "<";
            case LessThanEq: return "<=";
            case GreaterThan: return ">";
            case GreaterThanEq: return ">=";
            case Eq: return "==";
            case And: return "&&";
            case Or: return "||";
            default:
                throw new Error("Missing operator string definition for " + op);
        }
    }

    public static FunctionTypeNode opType(Operator op) {
        switch (op) {
            case Add:
            case Subtract:
            case Multiply:
            case Divide:
            case Modulo:
            return AST.funcType(t -> {
                t.parameters.add(AST.numberType());
                t.parameters.add(AST.numberType());
                t.return_ = AST.numberType();
            });
            case LessThan:
            case LessThanEq:
            case GreaterThan:
            case GreaterThanEq:
            case Eq:
            return AST.funcType(t -> {
                t.parameters.add(AST.numberType());
                t.parameters.add(AST.numberType());
                t.return_ = AST.boolType();
            });
            case And:
            case Or:
            return AST.funcType(t -> {
                t.parameters.add(AST.boolType());
                t.parameters.add(AST.boolType());
                t.return_ = AST.boolType();
            });
            default:
                throw new Error("Missing operator type definition for " + op);
        }
    }

    public static String intToAlphabetic(int code) {
        var s = "";
        for (var n = code; n > 0; n /= 26)
        {
            var c = (char)(96 + (n % 26));
            s += c;
            n /= 26;
        }
        return s;
    }
}
