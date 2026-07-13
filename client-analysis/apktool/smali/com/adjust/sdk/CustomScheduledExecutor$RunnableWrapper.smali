.class Lcom/adjust/sdk/CustomScheduledExecutor$RunnableWrapper;
.super Ljava/lang/Object;
.source "CustomScheduledExecutor.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adjust/sdk/CustomScheduledExecutor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RunnableWrapper"
.end annotation


# instance fields
.field private runnable:Ljava/lang/Runnable;

.field final synthetic this$0:Lcom/adjust/sdk/CustomScheduledExecutor;


# direct methods
.method public constructor <init>(Lcom/adjust/sdk/CustomScheduledExecutor;Ljava/lang/Runnable;)V
    .locals 0
    .param p2, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/adjust/sdk/CustomScheduledExecutor$RunnableWrapper;->this$0:Lcom/adjust/sdk/CustomScheduledExecutor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    iput-object p2, p0, Lcom/adjust/sdk/CustomScheduledExecutor$RunnableWrapper;->runnable:Ljava/lang/Runnable;

    .line 80
    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 87
    :try_start_0
    iget-object v1, p0, Lcom/adjust/sdk/CustomScheduledExecutor$RunnableWrapper;->runnable:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 93
    :goto_0
    return-void

    .line 90
    :catch_0
    move-exception v0

    .line 91
    .local v0, "t":Ljava/lang/Throwable;
    invoke-static {}, Lcom/adjust/sdk/AdjustFactory;->getLogger()Lcom/adjust/sdk/ILogger;

    move-result-object v1

    const-string v2, "Runnable error %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/adjust/sdk/ILogger;->error(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method
