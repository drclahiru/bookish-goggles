.class public not
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
    checkcast java/lang/Boolean
    invokevirtual java/lang/Boolean.booleanValue()Z
    ifeq True
    iconst_0
    goto End
True:
    iconst_1
End:
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    areturn
.end method
