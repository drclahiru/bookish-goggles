package compiler.ast;

public enum SimpleType {
    Bool(1),
    Number(2),
    String(3);

    public final int value;
    private SimpleType(int value) {
        this.value = value;
    }
}