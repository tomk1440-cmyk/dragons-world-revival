.class Lcom/prime31/util/IabHelperImpl$3$1;
.super Ljava/lang/Object;
.source "IabHelperImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/prime31/util/IabHelperImpl$3;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/prime31/util/IabHelperImpl$3;

.field private final synthetic val$purchases:Ljava/util/List;

.field private final synthetic val$results:Ljava/util/List;

.field private final synthetic val$singleListener:Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;


# direct methods
.method constructor <init>(Lcom/prime31/util/IabHelperImpl$3;Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;Ljava/util/List;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/prime31/util/IabHelperImpl$3$1;->this$1:Lcom/prime31/util/IabHelperImpl$3;

    iput-object p2, p0, Lcom/prime31/util/IabHelperImpl$3$1;->val$singleListener:Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;

    iput-object p3, p0, Lcom/prime31/util/IabHelperImpl$3$1;->val$purchases:Ljava/util/List;

    iput-object p4, p0, Lcom/prime31/util/IabHelperImpl$3$1;->val$results:Ljava/util/List;

    .line 1326
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1330
    iget-object v2, p0, Lcom/prime31/util/IabHelperImpl$3$1;->val$singleListener:Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;

    iget-object v0, p0, Lcom/prime31/util/IabHelperImpl$3$1;->val$purchases:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/prime31/util/Purchase;

    iget-object v1, p0, Lcom/prime31/util/IabHelperImpl$3$1;->val$results:Ljava/util/List;

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/prime31/util/IabResult;

    invoke-interface {v2, v0, v1}, Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;->onConsumeFinished(Lcom/prime31/util/Purchase;Lcom/prime31/util/IabResult;)V

    .line 1331
    return-void
.end method
