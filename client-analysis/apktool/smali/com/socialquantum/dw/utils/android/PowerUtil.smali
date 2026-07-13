.class public Lcom/socialquantum/dw/utils/android/PowerUtil;
.super Ljava/lang/Object;
.source "PowerUtil.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "PowerUtil"

.field private static mWakeLock:Landroid/os/PowerManager$WakeLock;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static WakeLock()V
    .locals 4

    .prologue
    .line 13
    const-string v2, "PowerUtil"

    const-string v3, "WakeLock"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 15
    :try_start_0
    sget-object v2, Lcom/socialquantum/dw/utils/android/PowerUtil;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    if-eqz v2, :cond_0

    .line 16
    const-string v2, "PWR"

    const-string v3, "WakeLock release"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 17
    sget-object v2, Lcom/socialquantum/dw/utils/android/PowerUtil;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v2}, Landroid/os/PowerManager$WakeLock;->release()V

    .line 18
    const/4 v2, 0x0

    sput-object v2, Lcom/socialquantum/dw/utils/android/PowerUtil;->mWakeLock:Landroid/os/PowerManager$WakeLock;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 25
    .local v0, "ex":Ljava/lang/Exception;
    :cond_0
    :goto_0
    :try_start_1
    const-string v2, "PowerUtil"

    const-string v3, "WakeLock acquire"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 26
    sget-object v2, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    const-string v3, "power"

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/PowerManager;

    .line 27
    .local v1, "pm":Landroid/os/PowerManager;
    const v2, 0x20000006

    const-string v3, "My Tag"

    .end local v0    # "ex":Ljava/lang/Exception;
    invoke-virtual {v1, v2, v3}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v2

    sput-object v2, Lcom/socialquantum/dw/utils/android/PowerUtil;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    .line 28
    sget-object v2, Lcom/socialquantum/dw/utils/android/PowerUtil;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v2}, Landroid/os/PowerManager$WakeLock;->acquire()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 32
    .end local v1    # "pm":Landroid/os/PowerManager;
    :goto_1
    return-void

    .line 20
    :catch_0
    move-exception v0

    .line 21
    .restart local v0    # "ex":Ljava/lang/Exception;
    const-string v2, "PowerUtil"

    const-string v3, "Close exist WakeLock"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 29
    :catch_1
    move-exception v0

    .line 30
    const-string v2, "PowerUtil"

    const-string v3, "WakeLock"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method

.method public static WakeUnlock()V
    .locals 3

    .prologue
    .line 35
    const-string v1, "PowerUtil"

    const-string v2, "WakeUnlock"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 37
    :try_start_0
    sget-object v1, Lcom/socialquantum/dw/utils/android/PowerUtil;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    if-eqz v1, :cond_0

    .line 38
    const-string v1, "PowerUtil"

    const-string v2, "WakeUnlock release"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 39
    sget-object v1, Lcom/socialquantum/dw/utils/android/PowerUtil;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v1}, Landroid/os/PowerManager$WakeLock;->release()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 44
    .local v0, "ex":Ljava/lang/Exception;
    :cond_0
    :goto_0
    return-void

    .line 41
    .end local v0    # "ex":Ljava/lang/Exception;
    :catch_0
    move-exception v0

    .line 42
    .restart local v0    # "ex":Ljava/lang/Exception;
    const-string v1, "PowerUtil"

    const-string v2, "WakeUnlock"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
