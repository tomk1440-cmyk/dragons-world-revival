.class public Lio/fabric/unity/crashlytics/android/CrashlyticsAndroidWrapper;
.super Ljava/lang/Object;
.source "CrashlyticsAndroidWrapper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static crash()V
    .locals 2

    .prologue
    .line 9
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lio/fabric/unity/crashlytics/android/CrashlyticsAndroidWrapper$1;

    invoke-direct {v1}, Lio/fabric/unity/crashlytics/android/CrashlyticsAndroidWrapper$1;-><init>()V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 15
    return-void
.end method
