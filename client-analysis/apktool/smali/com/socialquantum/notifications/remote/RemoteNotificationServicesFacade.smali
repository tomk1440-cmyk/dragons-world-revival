.class public Lcom/socialquantum/notifications/remote/RemoteNotificationServicesFacade;
.super Ljava/lang/Object;
.source "RemoteNotificationServicesFacade.java"


# static fields
.field private static final PLAY_SERVICES_RESOLUTION_REQUEST:I = 0x2328

.field public static TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-string v0, "GCM"

    sput-object v0, Lcom/socialquantum/notifications/remote/RemoteNotificationServicesFacade;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static GetRegistrationId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 40
    sget-object v0, Lcom/socialquantum/notifications/remote/RemoteNotificationServicesFacade;->TAG:Ljava/lang/String;

    const-string v1, "GetRegistrationId"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 41
    const-string v0, ""

    return-object v0
.end method

.method public static Init(Ljava/lang/String;)V
    .locals 3
    .param p0, "gameObjectName"    # Ljava/lang/String;

    .prologue
    .line 16
    sget-object v0, Lcom/socialquantum/notifications/remote/RemoteNotificationServicesFacade;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Init, gameObjectName="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 17
    return-void
.end method

.method public static RegisterForRemoteNotifications()V
    .locals 5

    .prologue
    .line 21
    sget-object v3, Lcom/socialquantum/notifications/remote/RemoteNotificationServicesFacade;->TAG:Ljava/lang/String;

    const-string v4, "RegisterForRemoteNotifications"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 24
    :try_start_0
    sget-object v3, Lcom/socialquantum/notifications/remote/RemoteNotificationServicesFacade;->TAG:Ljava/lang/String;

    const-string v4, "GooglePlayService available"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 25
    invoke-static {}, Lcom/socialquantum/notifications/local/ActivityUtil;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 26
    .local v0, "activity":Landroid/app/Activity;
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lcom/socialquantum/notifications/remote/GCMRegistrationService;

    invoke-direct {v2, v0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 27
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {v0, v2}, Landroid/app/Activity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 31
    .end local v2    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 28
    :catch_0
    move-exception v1

    .line 29
    .local v1, "ex":Ljava/lang/Exception;
    sget-object v3, Lcom/socialquantum/notifications/remote/RemoteNotificationServicesFacade;->TAG:Ljava/lang/String;

    const-string v4, "RegisterForRemoteNotifications"

    invoke-static {v3, v4, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public static UnregisterForRemoteNotifications()V
    .locals 2

    .prologue
    .line 35
    sget-object v0, Lcom/socialquantum/notifications/remote/RemoteNotificationServicesFacade;->TAG:Ljava/lang/String;

    const-string v1, "UnregisterForRemoteNotifications"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 36
    return-void
.end method

.method private static checkPlayServices()Z
    .locals 4

    .prologue
    .line 51
    invoke-static {}, Lcom/socialquantum/notifications/local/ActivityUtil;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 52
    .local v0, "activity":Landroid/app/Activity;
    invoke-static {v0}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isGooglePlayServicesAvailable(Landroid/content/Context;)I

    move-result v1

    .line 53
    .local v1, "resultCode":I
    if-eqz v1, :cond_1

    .line 54
    invoke-static {v1}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isUserRecoverableError(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 55
    const/16 v2, 0x2328

    invoke-static {v1, v0, v2}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->getErrorDialog(ILandroid/app/Activity;I)Landroid/app/Dialog;

    move-result-object v2

    .line 56
    invoke-virtual {v2}, Landroid/app/Dialog;->show()V

    .line 60
    :goto_0
    const/4 v2, 0x0

    .line 62
    :goto_1
    return v2

    .line 58
    :cond_0
    sget-object v2, Lcom/socialquantum/notifications/remote/RemoteNotificationServicesFacade;->TAG:Ljava/lang/String;

    const-string v3, "This device is not supported."

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 62
    :cond_1
    const/4 v2, 0x1

    goto :goto_1
.end method
