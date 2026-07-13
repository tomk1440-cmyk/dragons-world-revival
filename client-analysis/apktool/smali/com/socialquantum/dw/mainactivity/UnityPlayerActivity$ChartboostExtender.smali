.class Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;
.super Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;
.source "UnityPlayerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ChartboostExtender"
.end annotation


# instance fields
.field private activity:Landroid/app/Activity;

.field private cb:Lcom/chartboost/sdk/Chartboost;

.field final synthetic this$0:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;


# direct methods
.method public constructor <init>(Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;)V
    .locals 2
    .param p1, "this$0"    # Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;

    .prologue
    .line 276
    iput-object p1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;->this$0:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;

    invoke-direct {p0, p1}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;-><init>(Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;)V

    .line 277
    const-string v0, "ChartboostExt"

    const-string v1, "Creating extener"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 278
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/app/Activity;)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 282
    const-string v3, "ChartboostExt"

    const-string v4, "Creating chartboost"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 284
    :try_start_0
    invoke-static {}, Lcom/chartboost/sdk/Chartboost;->sharedChartboost()Lcom/chartboost/sdk/Chartboost;

    move-result-object v3

    iput-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;->cb:Lcom/chartboost/sdk/Chartboost;

    .line 285
    const-string v0, "529c52e49ddc353eba2187a8"

    .line 286
    .local v0, "appId":Ljava/lang/String;
    const-string v1, "af7a6dc16fba5b6a2acc89d1c0dac1436663e8d8"

    .line 287
    .local v1, "appSignature":Ljava/lang/String;
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;->cb:Lcom/chartboost/sdk/Chartboost;

    const/4 v4, 0x0

    invoke-virtual {v3, p1, v0, v1, v4}, Lcom/chartboost/sdk/Chartboost;->onCreate(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/ChartboostDelegate;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 291
    .end local v0    # "appId":Ljava/lang/String;
    .end local v1    # "appSignature":Ljava/lang/String;
    :goto_0
    return-void

    .line 288
    :catch_0
    move-exception v2

    .line 289
    .local v2, "e":Ljava/lang/Exception;
    const-string v3, "ChartboostExt"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to create Chartboost: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 307
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;->cb:Lcom/chartboost/sdk/Chartboost;

    iget-object v1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;->activity:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/chartboost/sdk/Chartboost;->onDestroy(Landroid/app/Activity;)V

    .line 308
    return-void
.end method

.method public onStart()V
    .locals 2

    .prologue
    .line 295
    const-string v0, "ChartboostExt"

    const-string v1, "Starting chartboost"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 296
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;->cb:Lcom/chartboost/sdk/Chartboost;

    iget-object v1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;->activity:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/chartboost/sdk/Chartboost;->onStart(Landroid/app/Activity;)V

    .line 297
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;->cb:Lcom/chartboost/sdk/Chartboost;

    invoke-virtual {v0}, Lcom/chartboost/sdk/Chartboost;->startSession()V

    .line 298
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 302
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;->cb:Lcom/chartboost/sdk/Chartboost;

    iget-object v1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;->activity:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/chartboost/sdk/Chartboost;->onStop(Landroid/app/Activity;)V

    .line 303
    return-void
.end method
