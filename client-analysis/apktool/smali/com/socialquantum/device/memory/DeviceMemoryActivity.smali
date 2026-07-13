.class public Lcom/socialquantum/device/memory/DeviceMemoryActivity;
.super Ljava/lang/Object;
.source "DeviceMemoryActivity.java"

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation


# static fields
.field static final APPLICATION_PAUSED_KEY:Ljava/lang/String; = "application_paused"

.field static final TAG:Ljava/lang/String; = "DeviceMemoryActivity"

.field private static isEnabled:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/socialquantum/device/memory/DeviceMemoryActivity;->isEnabled:Ljava/lang/Boolean;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createMemoryChunk()V
    .locals 1

    .prologue
    .line 32
    invoke-static {}, Lcom/socialquantum/device/memory/MemoryUtil;->Instance()Lcom/socialquantum/device/memory/MemoryUtil;

    move-result-object v0

    invoke-virtual {v0}, Lcom/socialquantum/device/memory/MemoryUtil;->createMemoryChunk()V

    .line 33
    return-void
.end method

.method public static disable()V
    .locals 2

    .prologue
    .line 26
    const-string v0, "DeviceMemoryActivity"

    const-string v1, "enable"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 27
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/socialquantum/device/memory/DeviceMemoryActivity;->isEnabled:Ljava/lang/Boolean;

    .line 28
    return-void
.end method

.method public static enable()V
    .locals 2

    .prologue
    .line 21
    const-string v0, "DeviceMemoryActivity"

    const-string v1, "enable"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 22
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/socialquantum/device/memory/DeviceMemoryActivity;->isEnabled:Ljava/lang/Boolean;

    .line 23
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 56
    const-string v0, "DeviceMemoryActivity"

    const-string v1, "Activity onActivityCreated"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 58
    return-void
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 94
    const-string v0, "DeviceMemoryActivity"

    const-string v1, "Activity onActivityDestroyed"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 95
    return-void
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 72
    const-string v3, "DeviceMemoryActivity"

    const-string v4, "Activity onActivityPaused"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 73
    invoke-virtual {p1}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    .line 74
    .local v0, "app":Landroid/app/Application;
    invoke-virtual {v0}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 75
    .local v2, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 77
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v3, "application_paused"

    const/4 v4, 0x1

    invoke-interface {v1, v3, v4}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 78
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 79
    invoke-static {}, Lcom/socialquantum/device/memory/DeviceMemoryActivity;->disable()V

    .line 80
    return-void
.end method

.method public onActivityResumed(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 67
    const-string v0, "DeviceMemoryActivity"

    const-string v1, "Activity onActivityResumed"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    return-void
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 89
    const-string v0, "DeviceMemoryActivity"

    const-string v1, "Activity onActivitySaveInstanceState"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 90
    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 62
    const-string v0, "DeviceMemoryActivity"

    const-string v1, "Activity onActivityStarted"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 63
    return-void
.end method

.method public onActivityStopped(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 84
    const-string v0, "DeviceMemoryActivity"

    const-string v1, "Activity onActivityStopped"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 85
    return-void
.end method

.method public onLowMemory(I)V
    .locals 2
    .param p1, "level"    # I

    .prologue
    .line 36
    const-string v0, "DeviceMemoryActivity"

    const-string v1, "Low memory warning received"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 37
    sget-object v0, Lcom/socialquantum/device/memory/DeviceMemoryActivity;->isEnabled:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 39
    :goto_0
    return-void

    .line 38
    :cond_0
    invoke-static {}, Lcom/socialquantum/device/memory/MemoryUtil;->Instance()Lcom/socialquantum/device/memory/MemoryUtil;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/socialquantum/device/memory/MemoryUtil;->reportMemory(I)V

    goto :goto_0
.end method
