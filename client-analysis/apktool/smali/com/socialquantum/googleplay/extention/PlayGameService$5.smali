.class Lcom/socialquantum/googleplay/extention/PlayGameService$5;
.super Ljava/lang/Object;
.source "PlayGameService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/socialquantum/googleplay/extention/PlayGameService;->runSafelyOnUiThread(Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;

.field final synthetic val$r:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Lcom/socialquantum/googleplay/extention/PlayGameService;Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "this$0"    # Lcom/socialquantum/googleplay/extention/PlayGameService;

    .prologue
    .line 259
    iput-object p1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$5;->this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;

    iput-object p2, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$5;->val$r:Ljava/lang/Runnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 262
    :try_start_0
    iget-object v1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$5;->val$r:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 266
    :goto_0
    return-void

    .line 263
    :catch_0
    move-exception v0

    .line 264
    .local v0, "var2":Ljava/lang/Exception;
    invoke-static {}, Lcom/socialquantum/googleplay/extention/PlayGameService;->access$400()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Exception running command on UI thread: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
