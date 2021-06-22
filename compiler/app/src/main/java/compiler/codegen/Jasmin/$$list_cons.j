.class public $$list_cons
.super java/lang/Object
.implements Eval2

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public eval(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .limit stack 4
    .limit locals 3
    new PuffinList
    dup
    aload_1
    aload_2
    checkcast PuffinList
    invokespecial PuffinList/<init>(Ljava/lang/Object;LPuffinList;)V
    areturn
.end method
