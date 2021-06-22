.class public $$list_head
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
    getfield PuffinList/head Ljava/lang/Object;
    areturn
.end method
