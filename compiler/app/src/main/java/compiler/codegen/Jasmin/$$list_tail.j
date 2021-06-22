.class public $$list_tail
.super java/lang/Object
.implements Eval1

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public eval(Ljava/lang/Object;)Ljava/lang/Object;
    .limit stack 1
    .limit locals 2
    aload_1
    checkcast PuffinList
    getfield PuffinList/tail LPuffinList;
    areturn
.end method
