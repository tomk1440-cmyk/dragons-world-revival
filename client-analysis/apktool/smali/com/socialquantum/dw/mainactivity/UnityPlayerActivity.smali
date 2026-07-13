.class public Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;
.super Lcom/unity3d/player/UnityPlayerActivity;
.source "UnityPlayerActivity.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$EmptyExtender;,
        Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;,
        Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;
    }
.end annotation


# instance fields
.field private APP_CRASHED:Ljava/lang/String;

.field private APP_PAUSED:Ljava/lang/String;

.field private TAG:Ljava/lang/String;

.field private _proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

.field private deviceMemoryActivity:Lcom/socialquantum/device/memory/DeviceMemoryActivity;

.field private extender:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;

.field private mPackagePrefs:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/unity3d/player/UnityPlayerActivity;-><init>()V

    .line 23
    const-string v0, "UnityPlayerActivity"

    iput-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    .line 25
    const-string v0, "appWasPaused"

    iput-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->APP_PAUSED:Ljava/lang/String;

    .line 26
    const-string v0, "crashed_with_uncaught_exception"

    iput-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->APP_CRASHED:Ljava/lang/String;

    return-void
.end method

.method private GetExtender()Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;
    .locals 2

    .prologue
    .line 257
    invoke-static {}, Lcom/socialquantum/dw/utils/Versions;->type()Lcom/socialquantum/dw/utils/Versions$BuildType;

    move-result-object v0

    sget-object v1, Lcom/socialquantum/dw/utils/Versions$BuildType;->INT:Lcom/socialquantum/dw/utils/Versions$BuildType;

    if-ne v0, v1, :cond_0

    .line 258
    new-instance v0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;

    invoke-direct {v0, p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$ChartboostExtender;-><init>(Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;)V

    .line 259
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$EmptyExtender;

    invoke-direct {v0, p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$EmptyExtender;-><init>(Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;)V

    goto :goto_0
.end method

.method private SavePushInfo(Landroid/content/SharedPreferences$Editor;Landroid/os/Bundle;)V
    .locals 7
    .param p1, "editor"    # Landroid/content/SharedPreferences$Editor;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 243
    iget-object v5, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "SavePushInfo"

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    if-nez p1, :cond_2

    move v2, v3

    :goto_0
    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v6, " - "

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    if-nez p2, :cond_3

    :goto_1
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v5, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 244
    if-eqz p1, :cond_1

    if-eqz p2, :cond_1

    .line 245
    iget-object v2, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "LaunchNotificationId SavePushInfo: nId="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "NOTIFICATION_ID"

    invoke-virtual {p2, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", tag="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "tag"

    .line 246
    invoke-virtual {p2, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 245
    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 247
    const-string v2, "NOTIFICATION_ID"

    invoke-virtual {p2, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 248
    .local v0, "nId":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 249
    const-string v2, "LaunchNotificationId"

    const-string v3, "NOTIFICATION_ID"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 250
    :cond_0
    const-string v2, "tag"

    invoke-virtual {p2, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 251
    .local v1, "tag":Ljava/lang/String;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 252
    const-string v2, "LaunchNotificationTag"

    const-string v3, "tag"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 254
    .end local v0    # "nId":Ljava/lang/String;
    .end local v1    # "tag":Ljava/lang/String;
    :cond_1
    return-void

    :cond_2
    move v2, v4

    .line 243
    goto :goto_0

    :cond_3
    move v3, v4

    goto :goto_1
.end method

.method private initDeviceMemoryActivity()V
    .locals 3

    .prologue
    .line 56
    new-instance v1, Lcom/socialquantum/device/memory/DeviceMemoryActivity;

    invoke-direct {v1}, Lcom/socialquantum/device/memory/DeviceMemoryActivity;-><init>()V

    iput-object v1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->deviceMemoryActivity:Lcom/socialquantum/device/memory/DeviceMemoryActivity;

    .line 57
    invoke-virtual {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->getApplication()Landroid/app/Application;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/app/Application;->registerComponentCallbacks(Landroid/content/ComponentCallbacks;)V

    .line 59
    iget-object v1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v2, "Installing uncaught exception handler"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 60
    new-instance v0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;

    invoke-virtual {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 61
    .local v0, "handler":Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;
    invoke-static {v0}, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 63
    invoke-virtual {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->getApplication()Landroid/app/Application;

    move-result-object v1

    iget-object v2, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->deviceMemoryActivity:Lcom/socialquantum/device/memory/DeviceMemoryActivity;

    invoke-virtual {v1, v2}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    .line 65
    return-void
.end method

.method private tryToKillApplication()V
    .locals 2

    .prologue
    .line 184
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "Maybe kill app ?"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 185
    invoke-static {}, Lcom/socialquantum/dw/utils/android/AndroidIdUtil;->sceneLoaded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 186
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "FINISHING APP!"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 187
    invoke-virtual {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->finish()V

    .line 188
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "SYS EXIT APP!"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 189
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    .line 191
    :cond_0
    return-void
.end method


# virtual methods
.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "request"    # I
    .param p2, "response"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 103
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Activity resulg : req : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ; res : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ; d : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 105
    sparse-switch p1, :sswitch_data_0

    .line 118
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onActivityResult request:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " responce:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " data:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 120
    invoke-super {p0, p1, p2, p3}, Lcom/unity3d/player/UnityPlayerActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 121
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    invoke-virtual {v0, p1, p2, p3}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->onActivityResult(IILandroid/content/Intent;)V

    .line 128
    return-void

    .line 107
    :sswitch_0
    const/16 v0, 0x2711

    if-ne p2, v0, :cond_0

    .line 108
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "Sign out response was received."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 109
    invoke-static {}, Lcom/socialquantum/googleplay/extention/PlayGameService;->instance()Lcom/socialquantum/googleplay/extention/PlayGameService;

    move-result-object v0

    invoke-virtual {v0}, Lcom/socialquantum/googleplay/extention/PlayGameService;->forceDisconnect()V

    goto :goto_0

    .line 113
    :sswitch_1
    const/16 v0, 0x2717

    if-ne p1, v0, :cond_0

    .line 114
    const-string v0, "FAILED TO SEND REQUEST!"

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 105
    :sswitch_data_0
    .sparse-switch
        0x15f94 -> :sswitch_0
        0x132c10cb -> :sswitch_1
    .end sparse-switch
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 210
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onBackPressed()V

    .line 211
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    const-string v1, "onBackPressed"

    invoke-virtual {v0, v1}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->invokeZeroParameterMethod(Ljava/lang/String;)V

    .line 212
    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 228
    invoke-super {p0, p1}, Lcom/unity3d/player/UnityPlayerActivity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 229
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    invoke-virtual {v0, p1}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 230
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 68
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v4, "onCreate"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 69
    invoke-direct {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->initDeviceMemoryActivity()V

    .line 70
    invoke-virtual {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/socialquantum/dw/utils/Versions;->loadMetadata(Landroid/content/Context;)V

    .line 71
    invoke-direct {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->GetExtender()Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;

    move-result-object v3

    iput-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->extender:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;

    .line 72
    invoke-super {p0, p1}, Lcom/unity3d/player/UnityPlayerActivity;->onCreate(Landroid/os/Bundle;)V

    .line 74
    invoke-virtual {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 76
    .local v0, "data":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3, v5}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    iput-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->mPackagePrefs:Landroid/content/SharedPreferences;

    .line 77
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->mPackagePrefs:Landroid/content/SharedPreferences;

    if-eqz v3, :cond_1

    .line 78
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v4, "prefs not null"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 79
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->mPackagePrefs:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 80
    .local v2, "editor":Landroid/content/SharedPreferences$Editor;
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->mPackagePrefs:Landroid/content/SharedPreferences;

    iget-object v4, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->APP_PAUSED:Ljava/lang/String;

    invoke-interface {v3, v4}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 81
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v4, "containspause"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->mPackagePrefs:Landroid/content/SharedPreferences;

    iget-object v4, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->APP_PAUSED:Ljava/lang/String;

    invoke-interface {v3, v4, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v3

    if-nez v3, :cond_0

    .line 83
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v4, "set crash to 1"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 84
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->APP_CRASHED:Ljava/lang/String;

    invoke-interface {v2, v3, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 87
    :cond_0
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v4, "clear pause"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 88
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->APP_PAUSED:Ljava/lang/String;

    invoke-interface {v2, v3, v5}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 90
    invoke-direct {p0, v2, v0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->SavePushInfo(Landroid/content/SharedPreferences$Editor;Landroid/os/Bundle;)V

    .line 91
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 94
    .end local v2    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_1
    :try_start_0
    new-instance v3, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    invoke-direct {v3, p0}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;-><init>(Landroid/app/Activity;)V

    iput-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    .line 95
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    invoke-virtual {v3, p1}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->onCreate(Landroid/os/Bundle;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    :goto_0
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->extender:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;

    invoke-virtual {v3, p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;->onCreate(Landroid/app/Activity;)V

    .line 100
    return-void

    .line 96
    :catch_0
    move-exception v1

    .line 97
    .local v1, "e":Ljava/lang/Exception;
    iget-object v3, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to create proxyHelper: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 154
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "onDestroy"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 155
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onDestroy()V

    .line 156
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->extender:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;

    invoke-virtual {v0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;->onDestroy()V

    .line 157
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    const-string v1, "onDestroy"

    invoke-virtual {v0, v1}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->invokeZeroParameterMethod(Ljava/lang/String;)V

    .line 158
    invoke-static {}, Lcom/socialquantum/dw/utils/android/AndroidIdUtil;->sceneLoaded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "KILLING PROCESS : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 160
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v0

    invoke-static {v0}, Landroid/os/Process;->killProcess(I)V

    .line 162
    :cond_0
    return-void
.end method

.method public onLowMemory()V
    .locals 2

    .prologue
    .line 47
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onLowMemory()V

    .line 48
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "Low memory warning received"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->deviceMemoryActivity:Lcom/socialquantum/device/memory/DeviceMemoryActivity;

    const/16 v1, 0x3e8

    invoke-virtual {v0, v1}, Lcom/socialquantum/device/memory/DeviceMemoryActivity;->onLowMemory(I)V

    .line 50
    return-void
.end method

.method public onNewIntent(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 140
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "onNewIntent"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 141
    invoke-super {p0, p1}, Lcom/unity3d/player/UnityPlayerActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 142
    invoke-virtual {p0, p1}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->setIntent(Landroid/content/Intent;)V

    .line 143
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    invoke-virtual {v0, p1}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->onNewIntent(Landroid/content/Intent;)V

    .line 144
    return-void
.end method

.method public onPause()V
    .locals 3

    .prologue
    .line 171
    iget-object v1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v2, "onPause"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 172
    invoke-direct {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->tryToKillApplication()V

    .line 173
    iget-object v1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->mPackagePrefs:Landroid/content/SharedPreferences;

    if-eqz v1, :cond_0

    .line 174
    iget-object v1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->mPackagePrefs:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 175
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    iget-object v1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->APP_PAUSED:Ljava/lang/String;

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 176
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 178
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onPause()V

    .line 179
    iget-object v1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    const-string v2, "onPause"

    invoke-virtual {v1, v2}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->invokeZeroParameterMethod(Ljava/lang/String;)V

    .line 180
    return-void
.end method

.method public onRestart()V
    .locals 2

    .prologue
    .line 165
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "Unstopable activity was restarted!"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 166
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onRestart()V

    .line 167
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    const-string v1, "onRestart"

    invoke-virtual {v0, v1}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->invokeZeroParameterMethod(Ljava/lang/String;)V

    .line 168
    return-void
.end method

.method public onRestoreInstanceState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 222
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onRestoreInstanceState savedInstanceState:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 223
    invoke-super {p0, p1}, Lcom/unity3d/player/UnityPlayerActivity;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 224
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    invoke-virtual {v0, p1}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 225
    return-void
.end method

.method public onResume()V
    .locals 5

    .prologue
    .line 194
    iget-object v2, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v3, "onResume"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 195
    invoke-virtual {p0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 196
    .local v0, "bundle":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->mPackagePrefs:Landroid/content/SharedPreferences;

    if-eqz v2, :cond_0

    .line 197
    iget-object v2, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->mPackagePrefs:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 198
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    iget-object v2, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->APP_PAUSED:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 199
    invoke-direct {p0, v1, v0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->SavePushInfo(Landroid/content/SharedPreferences$Editor;Landroid/os/Bundle;)V

    .line 200
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 202
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onResume()V

    .line 204
    iget-object v2, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Settings.getApplicationId() = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/socialquantum/dw/utils/Versions;->appId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 206
    iget-object v2, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    const-string v3, "onResume"

    invoke-virtual {v2, v3}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->invokeZeroParameterMethod(Ljava/lang/String;)V

    .line 207
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 215
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onSaveInstanceState savedInstanceState:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 216
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    invoke-virtual {v0, p1}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 218
    invoke-super {p0, p1}, Lcom/unity3d/player/UnityPlayerActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 219
    return-void
.end method

.method public onSignInFailed()V
    .locals 2

    .prologue
    .line 234
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "onSignInFailed"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 235
    return-void
.end method

.method public onSignInSucceeded()V
    .locals 2

    .prologue
    .line 239
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "onSignInSucceeded"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 240
    return-void
.end method

.method public onStart()V
    .locals 2

    .prologue
    .line 131
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "onStart"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 132
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onStart()V

    .line 134
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->extender:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;

    invoke-virtual {v0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;->onStart()V

    .line 135
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "Proxy helper start..."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 136
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    const-string v1, "onStart"

    invoke-virtual {v0, v1}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->invokeZeroParameterMethod(Ljava/lang/String;)V

    .line 137
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    const-string v1, "Unstopable activity was stopped!"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 148
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onStop()V

    .line 149
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->extender:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;

    invoke-virtual {v0}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;->onStop()V

    .line 150
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->_proxyHelper:Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;

    const-string v1, "onStop"

    invoke-virtual {v0, v1}, Lcom/socialquantum/dw/mainactivity/ActivityProxyObjectHelper;->invokeZeroParameterMethod(Ljava/lang/String;)V

    .line 151
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 3
    .param p1, "level"    # I

    .prologue
    .line 35
    invoke-super {p0, p1}, Lcom/unity3d/player/UnityPlayerActivity;->onTrimMemory(I)V

    .line 36
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->deviceMemoryActivity:Lcom/socialquantum/device/memory/DeviceMemoryActivity;

    invoke-virtual {v0, p1}, Lcom/socialquantum/device/memory/DeviceMemoryActivity;->onLowMemory(I)V

    .line 37
    const/16 v0, 0xf

    if-gt p1, v0, :cond_0

    .line 38
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Trim memory warning received"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 42
    :goto_0
    return-void

    .line 40
    :cond_0
    iget-object v0, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Trim memory received"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
