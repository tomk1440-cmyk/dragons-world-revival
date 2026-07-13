.class public Lcom/socialquantum/notifications/remote/GCMRegistrationService;
.super Landroid/app/IntentService;
.source "GCMRegistrationService.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "GCMRegistrationService"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    const-string v0, "GCMRegistrationService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 18
    return-void
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 8
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 23
    :try_start_0
    const-string v5, "GCMRegistrationService"

    monitor-enter v5
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 25
    :try_start_1
    invoke-static {p0}, Lcom/google/android/gms/iid/InstanceID;->getInstance(Landroid/content/Context;)Lcom/google/android/gms/iid/InstanceID;

    move-result-object v2

    .line 26
    .local v2, "instanceID":Lcom/google/android/gms/iid/InstanceID;
    const-string v0, "1058217148123"

    .line 31
    .local v0, "appId":Ljava/lang/String;
    const-string v4, "GCM"

    const/4 v6, 0x0

    invoke-virtual {v2, v0, v4, v6}, Lcom/google/android/gms/iid/InstanceID;->getToken(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v3

    .line 33
    .local v3, "token":Ljava/lang/String;
    const-string v4, "GCMRegistrationService"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "GCMRegistrationService.onHandleIntent, token="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 34
    const-string v4, "DeviceBridge"

    const-string v6, "WriteDeviceToken"

    invoke-static {v4, v6, v3}, Lcom/socialquantum/notifications/local/ActivityUtil;->UnitySend(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    monitor-exit v5

    .line 39
    .end local v0    # "appId":Ljava/lang/String;
    .end local v2    # "instanceID":Lcom/google/android/gms/iid/InstanceID;
    .end local v3    # "token":Ljava/lang/String;
    :goto_0
    return-void

    .line 35
    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v4
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 36
    :catch_0
    move-exception v1

    .line 37
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method
