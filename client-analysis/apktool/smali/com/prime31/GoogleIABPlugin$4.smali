.class Lcom/prime31/GoogleIABPlugin$4;
.super Ljava/lang/Object;
.source "GoogleIABPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/prime31/GoogleIABPlugin;->consumeProduct(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/prime31/GoogleIABPlugin;

.field private final synthetic val$p:Lcom/prime31/util/Purchase;


# direct methods
.method constructor <init>(Lcom/prime31/GoogleIABPlugin;Lcom/prime31/util/Purchase;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/prime31/GoogleIABPlugin$4;->this$0:Lcom/prime31/GoogleIABPlugin;

    iput-object p2, p0, Lcom/prime31/GoogleIABPlugin$4;->val$p:Lcom/prime31/util/Purchase;

    .line 253
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 259
    :try_start_0
    iget-object v1, p0, Lcom/prime31/GoogleIABPlugin$4;->this$0:Lcom/prime31/GoogleIABPlugin;

    iget-object v1, v1, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    iget-object v2, p0, Lcom/prime31/GoogleIABPlugin$4;->val$p:Lcom/prime31/util/Purchase;

    iget-object v3, p0, Lcom/prime31/GoogleIABPlugin$4;->this$0:Lcom/prime31/GoogleIABPlugin;

    invoke-virtual {v1, v2, v3}, Lcom/prime31/util/IabHelperImpl;->consumeAsync(Lcom/prime31/util/Purchase;Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;)V
    :try_end_0
    .catch Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException; {:try_start_0 .. :try_end_0} :catch_0

    .line 266
    :goto_0
    return-void

    .line 261
    :catch_0
    move-exception v0

    .line 263
    .local v0, "e":Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
    const-string v1, "Prime31"

    const-string v2, "consumeAsync failed"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 264
    invoke-virtual {v0}, Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;->printStackTrace()V

    goto :goto_0
.end method
