.class public interface abstract Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;
.super Ljava/lang/Object;
.source "IabHelperImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/prime31/util/IabHelperImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "OnConsumeMultiFinishedListener"
.end annotation


# virtual methods
.method public abstract onConsumeMultiFinished(Ljava/util/List;Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/prime31/util/Purchase;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/prime31/util/IabResult;",
            ">;)V"
        }
    .end annotation
.end method
