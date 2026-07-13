.class public Lcom/socialquantum/notifications/remote/GCMInstanceIdListenerService;
.super Lcom/google/android/gms/iid/InstanceIDListenerService;
.source "GCMInstanceIdListenerService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/socialquantum/notifications/remote/GCMInstanceIdListenerService$MyInstanceIdListenerService;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Lcom/google/android/gms/iid/InstanceIDListenerService;-><init>()V

    return-void
.end method
