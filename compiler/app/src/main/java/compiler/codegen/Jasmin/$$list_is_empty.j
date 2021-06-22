.class public $$list_is_empty
.super java/lang/Object
.implements Eval1

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public eval(Ljava/lang/Object;)Ljava/lang/Object;
    .limit stack 2
    .limit locals 2
    aload_1
    checkcast PuffinList
    getfield PuffinList/head Ljava/lang/Object;
    ifnonnull False
    iconst_1
    goto End
False:
    iconst_0
End:
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    areturn
.end method
