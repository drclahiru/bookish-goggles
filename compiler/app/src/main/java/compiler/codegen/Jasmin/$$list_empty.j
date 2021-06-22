.class public $$list_empty
.super java/lang/Object
.implements Eval0

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public eval()Ljava/lang/Object;
    .limit stack 4
    .limit locals 2
    new PuffinList
    dup
    aconst_null
    aconst_null
    invokespecial PuffinList/<init>(Ljava/lang/Object;LPuffinList;)V
    areturn
.end method
