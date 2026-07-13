.class public Lio/fabric/unity/android/FabricApplication;
.super Landroid/app/Application;
.source "FabricApplication.java"


# static fields
.field static final TAG:Ljava/lang/String; = "Fabric"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate()V
    .locals 1

    .prologue
    .line 10
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 12
    sget-object v0, Lio/fabric/unity/android/FabricInitializer$Caller;->Android:Lio/fabric/unity/android/FabricInitializer$Caller;

    invoke-static {p0, v0}, Lio/fabric/unity/android/FabricInitializer;->initializeFabric(Landroid/content/Context;Lio/fabric/unity/android/FabricInitializer$Caller;)Ljava/lang/String;

    .line 16
    return-void
.end method
