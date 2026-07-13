.class Lcom/prime31/GoogleIABPlugin$5;
.super Ljava/lang/Object;
.source "GoogleIABPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/prime31/GoogleIABPlugin;->consumeProducts([Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/prime31/GoogleIABPlugin;

.field private final synthetic val$confirmedPurchases:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/prime31/GoogleIABPlugin;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/prime31/GoogleIABPlugin$5;->this$0:Lcom/prime31/GoogleIABPlugin;

    iput-object p2, p0, Lcom/prime31/GoogleIABPlugin$5;->val$confirmedPurchases:Ljava/util/List;

    .line 303
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 309
    :try_start_0
    iget-object v1, p0, Lcom/prime31/GoogleIABPlugin$5;->this$0:Lcom/prime31/GoogleIABPlugin;

    iget-object v1, v1, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    iget-object v2, p0, Lcom/prime31/GoogleIABPlugin$5;->val$confirmedPurchases:Ljava/util/List;

    iget-object v3, p0, Lcom/prime31/GoogleIABPlugin$5;->this$0:Lcom/prime31/GoogleIABPlugin;

    invoke-virtual {v1, v2, v3}, Lcom/prime31/util/IabHelperImpl;->consumeAsync(Ljava/util/List;Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;)V
    :try_end_0
    .catch Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException; {:try_start_0 .. :try_end_0} :catch_0

    .line 316
    :goto_0
    return-void

    .line 311
    :catch_0
    move-exception v0

    .line 313
    .local v0, "e":Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
    const-string v1, "Prime31"

    const-string v2, "consumeAsync failed"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 314
    invoke-virtual {v0}, Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;->printStackTrace()V

    goto :goto_0
.end method
