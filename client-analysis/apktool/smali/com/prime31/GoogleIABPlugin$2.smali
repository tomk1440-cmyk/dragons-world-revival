.class Lcom/prime31/GoogleIABPlugin$2;
.super Ljava/lang/Object;
.source "GoogleIABPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/prime31/GoogleIABPlugin;->queryInventory([Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/prime31/GoogleIABPlugin;

.field private final synthetic val$skus:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/prime31/GoogleIABPlugin;[Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/prime31/GoogleIABPlugin$2;->this$0:Lcom/prime31/GoogleIABPlugin;

    iput-object p2, p0, Lcom/prime31/GoogleIABPlugin$2;->val$skus:[Ljava/lang/String;

    .line 140
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 146
    :try_start_0
    iget-object v1, p0, Lcom/prime31/GoogleIABPlugin$2;->this$0:Lcom/prime31/GoogleIABPlugin;

    iget-object v1, v1, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/prime31/GoogleIABPlugin$2;->val$skus:[Ljava/lang/String;

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/prime31/GoogleIABPlugin$2;->this$0:Lcom/prime31/GoogleIABPlugin;

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/prime31/util/IabHelperImpl;->queryInventoryAsync(ZLjava/util/List;Ljava/util/List;Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;)V
    :try_end_0
    .catch Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException; {:try_start_0 .. :try_end_0} :catch_0

    .line 153
    :goto_0
    return-void

    .line 148
    :catch_0
    move-exception v0

    .line 150
    .local v0, "e":Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
    const-string v1, "Prime31"

    const-string v2, "queryInventoryAsync failed"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 151
    invoke-virtual {v0}, Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;->printStackTrace()V

    goto :goto_0
.end method
