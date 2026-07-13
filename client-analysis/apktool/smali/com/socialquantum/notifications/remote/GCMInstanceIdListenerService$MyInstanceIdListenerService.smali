.class public Lcom/socialquantum/notifications/remote/GCMInstanceIdListenerService$MyInstanceIdListenerService;
.super Lcom/google/android/gms/iid/InstanceIDListenerService;
.source "GCMInstanceIdListenerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/socialquantum/notifications/remote/GCMInstanceIdListenerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MyInstanceIdListenerService"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/socialquantum/notifications/remote/GCMInstanceIdListenerService;


# direct methods
.method public constructor <init>(Lcom/socialquantum/notifications/remote/GCMInstanceIdListenerService;)V
    .locals 0
    .param p1, "this$0"    # Lcom/socialquantum/notifications/remote/GCMInstanceIdListenerService;

    .prologue
    .line 8
    iput-object p1, p0, Lcom/socialquantum/notifications/remote/GCMInstanceIdListenerService$MyInstanceIdListenerService;->this$0:Lcom/socialquantum/notifications/remote/GCMInstanceIdListenerService;

    invoke-direct {p0}, Lcom/google/android/gms/iid/InstanceIDListenerService;-><init>()V

    return-void
.end method


# virtual methods
.method public onTokenRefresh()V
    .locals 2

    .prologue
    .line 10
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/socialquantum/notifications/remote/GCMRegistrationService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 11
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/socialquantum/notifications/remote/GCMInstanceIdListenerService$MyInstanceIdListenerService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 12
    return-void
.end method
