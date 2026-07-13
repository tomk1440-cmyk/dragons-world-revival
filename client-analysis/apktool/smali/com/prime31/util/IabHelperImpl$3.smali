.class Lcom/prime31/util/IabHelperImpl$3;
.super Ljava/lang/Object;
.source "IabHelperImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/prime31/util/IabHelperImpl;->consumeAsyncInternal(Ljava/util/List;Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/prime31/util/IabHelperImpl;

.field private final synthetic val$handler:Landroid/os/Handler;

.field private final synthetic val$multiListener:Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;

.field private final synthetic val$purchases:Ljava/util/List;

.field private final synthetic val$singleListener:Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;


# direct methods
.method constructor <init>(Lcom/prime31/util/IabHelperImpl;Ljava/util/List;Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;Landroid/os/Handler;Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/prime31/util/IabHelperImpl$3;->this$0:Lcom/prime31/util/IabHelperImpl;

    iput-object p2, p0, Lcom/prime31/util/IabHelperImpl$3;->val$purchases:Ljava/util/List;

    iput-object p3, p0, Lcom/prime31/util/IabHelperImpl$3;->val$singleListener:Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;

    iput-object p4, p0, Lcom/prime31/util/IabHelperImpl$3;->val$handler:Landroid/os/Handler;

    iput-object p5, p0, Lcom/prime31/util/IabHelperImpl$3;->val$multiListener:Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;

    .line 1305
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 1309
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 1310
    .local v2, "results":Ljava/util/List;, "Ljava/util/List<Lcom/prime31/util/IabResult;>;"
    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl$3;->val$purchases:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_2

    .line 1323
    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl$3;->this$0:Lcom/prime31/util/IabHelperImpl;

    invoke-virtual {v3}, Lcom/prime31/util/IabHelperImpl;->flagEndAsync()V

    .line 1324
    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl$3;->this$0:Lcom/prime31/util/IabHelperImpl;

    iget-boolean v3, v3, Lcom/prime31/util/IabHelperImpl;->mDisposed:Z

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl$3;->val$singleListener:Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;

    if-eqz v3, :cond_0

    .line 1326
    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl$3;->val$handler:Landroid/os/Handler;

    new-instance v4, Lcom/prime31/util/IabHelperImpl$3$1;

    iget-object v5, p0, Lcom/prime31/util/IabHelperImpl$3;->val$singleListener:Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;

    iget-object v6, p0, Lcom/prime31/util/IabHelperImpl$3;->val$purchases:Ljava/util/List;

    invoke-direct {v4, p0, v5, v6, v2}, Lcom/prime31/util/IabHelperImpl$3$1;-><init>(Lcom/prime31/util/IabHelperImpl$3;Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;Ljava/util/List;Ljava/util/List;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1334
    :cond_0
    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl$3;->this$0:Lcom/prime31/util/IabHelperImpl;

    iget-boolean v3, v3, Lcom/prime31/util/IabHelperImpl;->mDisposed:Z

    if-nez v3, :cond_1

    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl$3;->val$multiListener:Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;

    if-eqz v3, :cond_1

    .line 1336
    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl$3;->val$handler:Landroid/os/Handler;

    new-instance v4, Lcom/prime31/util/IabHelperImpl$3$2;

    iget-object v5, p0, Lcom/prime31/util/IabHelperImpl$3;->val$multiListener:Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;

    iget-object v6, p0, Lcom/prime31/util/IabHelperImpl$3;->val$purchases:Ljava/util/List;

    invoke-direct {v4, p0, v5, v6, v2}, Lcom/prime31/util/IabHelperImpl$3$2;-><init>(Lcom/prime31/util/IabHelperImpl$3;Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;Ljava/util/List;Ljava/util/List;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1344
    :cond_1
    return-void

    .line 1310
    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/prime31/util/Purchase;

    .line 1314
    .local v1, "purchase":Lcom/prime31/util/Purchase;
    :try_start_0
    iget-object v4, p0, Lcom/prime31/util/IabHelperImpl$3;->this$0:Lcom/prime31/util/IabHelperImpl;

    invoke-virtual {v4, v1}, Lcom/prime31/util/IabHelperImpl;->consume(Lcom/prime31/util/Purchase;)V

    .line 1315
    new-instance v4, Lcom/prime31/util/IabResult;

    const/4 v5, 0x0

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Successful consume of sku "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/prime31/util/Purchase;->getSku()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lcom/prime31/util/IabException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1317
    :catch_0
    move-exception v0

    .line 1319
    .local v0, "ex":Lcom/prime31/util/IabException;
    invoke-virtual {v0}, Lcom/prime31/util/IabException;->getResult()Lcom/prime31/util/IabResult;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method
