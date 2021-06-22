.class public PuffinList
.super java/lang/Object
.field public final head Ljava/lang/Object;
.field public final tail LPuffinList;

.method public <init>(Ljava/lang/Object;LPuffinList;)V
    .limit stack 2
    .limit locals 3
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    aload_0
    aload_1
    putfield PuffinList/head Ljava/lang/Object;
    aload_0
    aload_2
    checkcast PuffinList
    putfield PuffinList/tail LPuffinList;
    return
.end method

.method public toString()Ljava/lang/String;
    .limit stack 10
    .limit locals 2
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
    astore_1
    aload_1
    ldc "{"
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    aload_0
    getfield PuffinList/head Ljava/lang/Object;
    ifnull End
    aload_1
    aload_0
    getfield PuffinList/head Ljava/lang/Object;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    pop
    aload_0
    getfield PuffinList/tail LPuffinList;
    aload_1
    invokevirtual PuffinList/toStringInner(Ljava/lang/StringBuilder;)V
End:
    aload_1
    ldc "}"
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    areturn
.end method

.method private toStringInner(Ljava/lang/StringBuilder;)V
    .limit stack 10
    .limit locals 2
    aload_0
    getfield PuffinList/head Ljava/lang/Object;
    ifnull End
    aload_1
    ldc ", "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload_0
    getfield PuffinList/head Ljava/lang/Object;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    aload_0
    getfield PuffinList/tail LPuffinList;
    swap
    invokevirtual PuffinList/toStringInner(Ljava/lang/StringBuilder;)V
End:
    return
.end method
