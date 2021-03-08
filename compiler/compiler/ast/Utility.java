package compiler.ast;

public class Utility {
    public static String operatorToString(Operator op) {
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
            case Not: return "!";
            case Negate: return "-";
            case And: return "&&";
            case Or: return "||";
            default:
                System.out.println("Missing operator string definition for " + op);
                return "";
        }
    }
}
