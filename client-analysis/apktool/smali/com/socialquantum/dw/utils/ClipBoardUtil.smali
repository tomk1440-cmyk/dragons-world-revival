.class public Lcom/socialquantum/dw/utils/ClipBoardUtil;
.super Ljava/lang/Object;
.source "ClipBoardUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/socialquantum/dw/utils/ClipBoardUtil$CopyExecutor;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public Copy(Ljava/lang/String;)V
    .locals 2
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 10
    sget-object v0, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    .line 11
    .local v0, "context":Landroid/app/Activity;
    new-instance v1, Lcom/socialquantum/dw/utils/ClipBoardUtil$CopyExecutor;

    invoke-direct {v1, p0, p1, v0}, Lcom/socialquantum/dw/utils/ClipBoardUtil$CopyExecutor;-><init>(Lcom/socialquantum/dw/utils/ClipBoardUtil;Ljava/lang/String;Landroid/app/Activity;)V

    .line 12
    .local v1, "executor":Lcom/socialquantum/dw/utils/ClipBoardUtil$CopyExecutor;
    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 13
    return-void
.end method
