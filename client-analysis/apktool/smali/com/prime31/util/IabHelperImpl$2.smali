.class Lcom/prime31/util/IabHelperImpl$2;
.super Ljava/lang/Object;
.source "IabHelperImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/prime31/util/IabHelperImpl;->queryInventoryAsync(ZLjava/util/List;Ljava/util/List;Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/prime31/util/IabHelperImpl;

.field private final synthetic val$handler:Landroid/os/Handler;

.field private final synthetic val$listener:Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;

.field private final synthetic val$moreItemSkus:Ljava/util/List;

.field private final synthetic val$moreSubsSkus:Ljava/util/List;

.field private final synthetic val$querySkuDetails:Z


# direct methods
.method constructor <init>(Lcom/prime31/util/IabHelperImpl;ZLjava/util/List;Ljava/util/List;Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;Landroid/os/Handler;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/prime31/util/IabHelperImpl$2;->this$0:Lcom/prime31/util/IabHelperImpl;

    iput-boolean p2, p0, Lcom/prime31/util/IabHelperImpl$2;->val$querySkuDetails:Z

    iput-object p3, p0, Lcom/prime31/util/IabHelperImpl$2;->val$moreItemSkus:Ljava/util/List;

    iput-object p4, p0, Lcom/prime31/util/IabHelperImpl$2;->val$moreSubsSkus:Ljava/util/List;

    iput-object p5, p0, Lcom/prime31/util/IabHelperImpl$2;->val$listener:Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;

    iput-object p6, p0, Lcom/prime31/util/IabHelperImpl$2;->val$handler:Landroid/os/Handler;

    .line 833
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 837
    new-instance v3, Lcom/prime31/util/IabResult;

    const/4 v5, 0x0

    const-string v6, "Inventory refresh successful."

    invoke-direct {v3, v5, v6}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 838
    .local v3, "result":Lcom/prime31/util/IabResult;
    const/4 v1, 0x0

    .line 841
    .local v1, "inv":Lcom/prime31/util/Inventory;
    :try_start_0
    iget-object v5, p0, Lcom/prime31/util/IabHelperImpl$2;->this$0:Lcom/prime31/util/IabHelperImpl;

    iget-boolean v6, p0, Lcom/prime31/util/IabHelperImpl$2;->val$querySkuDetails:Z

    iget-object v7, p0, Lcom/prime31/util/IabHelperImpl$2;->val$moreItemSkus:Ljava/util/List;

    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl$2;->val$moreSubsSkus:Ljava/util/List;

    invoke-virtual {v5, v6, v7, v8}, Lcom/prime31/util/IabHelperImpl;->queryInventory(ZLjava/util/List;Ljava/util/List;)Lcom/prime31/util/Inventory;
    :try_end_0
    .catch Lcom/prime31/util/IabException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 848
    :goto_0
    iget-object v5, p0, Lcom/prime31/util/IabHelperImpl$2;->this$0:Lcom/prime31/util/IabHelperImpl;

    invoke-virtual {v5}, Lcom/prime31/util/IabHelperImpl;->flagEndAsync()V

    .line 850
    move-object v4, v3

    .line 851
    .local v4, "result_f":Lcom/prime31/util/IabResult;
    move-object v2, v1

    .line 852
    .local v2, "inv_f":Lcom/prime31/util/Inventory;
    iget-object v5, p0, Lcom/prime31/util/IabHelperImpl$2;->this$0:Lcom/prime31/util/IabHelperImpl;

    iget-boolean v5, v5, Lcom/prime31/util/IabHelperImpl;->mDisposed:Z

    if-nez v5, :cond_0

    iget-object v5, p0, Lcom/prime31/util/IabHelperImpl$2;->val$listener:Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;

    if-eqz v5, :cond_0

    .line 854
    iget-object v5, p0, Lcom/prime31/util/IabHelperImpl$2;->val$handler:Landroid/os/Handler;

    new-instance v6, Lcom/prime31/util/IabHelperImpl$2$1;

    iget-object v7, p0, Lcom/prime31/util/IabHelperImpl$2;->val$listener:Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;

    invoke-direct {v6, p0, v7, v4, v2}, Lcom/prime31/util/IabHelperImpl$2$1;-><init>(Lcom/prime31/util/IabHelperImpl$2;Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;Lcom/prime31/util/IabResult;Lcom/prime31/util/Inventory;)V

    invoke-virtual {v5, v6}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 862
    :cond_0
    return-void

    .line 843
    .end local v2    # "inv_f":Lcom/prime31/util/Inventory;
    .end local v4    # "result_f":Lcom/prime31/util/IabResult;
    :catch_0
    move-exception v0

    .line 845
    .local v0, "ex":Lcom/prime31/util/IabException;
    invoke-virtual {v0}, Lcom/prime31/util/IabException;->getResult()Lcom/prime31/util/IabResult;

    move-result-object v3

    goto :goto_0
.end method
