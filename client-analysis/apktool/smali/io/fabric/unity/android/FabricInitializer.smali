.class public Lio/fabric/unity/android/FabricInitializer;
.super Ljava/lang/Object;
.source "FabricInitializer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/fabric/unity/android/FabricInitializer$Caller;
    }
.end annotation


# static fields
.field private static AUTOMATIC:Ljava/lang/String;

.field private static MANUAL:Ljava/lang/String;

.field private static savedContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const/4 v0, 0x0

    sput-object v0, Lio/fabric/unity/android/FabricInitializer;->savedContext:Landroid/content/Context;

    .line 15
    const-string v0, "Automatic"

    sput-object v0, Lio/fabric/unity/android/FabricInitializer;->AUTOMATIC:Ljava/lang/String;

    .line 16
    const-string v0, "Manual"

    sput-object v0, Lio/fabric/unity/android/FabricInitializer;->MANUAL:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static JNI_InitializeFabric()Ljava/lang/String;
    .locals 2

    .prologue
    .line 26
    sget-object v0, Lio/fabric/unity/android/FabricInitializer;->savedContext:Landroid/content/Context;

    sget-object v1, Lio/fabric/unity/android/FabricInitializer$Caller;->Unity:Lio/fabric/unity/android/FabricInitializer$Caller;

    invoke-static {v0, v1}, Lio/fabric/unity/android/FabricInitializer;->initializeFabric(Landroid/content/Context;Lio/fabric/unity/android/FabricInitializer$Caller;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getManifestMetadata(Landroid/content/Context;)Landroid/os/Bundle;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 65
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 66
    .local v3, "packageManager":Landroid/content/pm/PackageManager;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 68
    .local v4, "packageName":Ljava/lang/String;
    const/4 v2, 0x0

    .line 70
    .local v2, "metaData":Landroid/os/Bundle;
    const/16 v5, 0x80

    .line 71
    :try_start_0
    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 72
    .local v0, "appInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v2, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 77
    .end local v0    # "appInfo":Landroid/content/pm/ApplicationInfo;
    :goto_0
    return-object v2

    .line 73
    :catch_0
    move-exception v1

    .line 74
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v5, "Fabric"

    const-string v6, "Could not retrieve application metadata"

    invoke-static {v5, v6, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public static initializeFabric(Landroid/content/Context;Lio/fabric/unity/android/FabricInitializer$Caller;)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "originator"    # Lio/fabric/unity/android/FabricInitializer$Caller;

    .prologue
    .line 30
    sput-object p0, Lio/fabric/unity/android/FabricInitializer;->savedContext:Landroid/content/Context;

    .line 32
    sget-object v6, Lio/fabric/unity/android/FabricInitializer;->savedContext:Landroid/content/Context;

    if-nez v6, :cond_0

    .line 33
    new-instance v6, Lio/fabric/unity/android/FabricInitializationException;

    const-string v7, "Fabric did not find a valid application context."

    invoke-direct {v6, v7}, Lio/fabric/unity/android/FabricInitializationException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 38
    :cond_0
    sget-object v6, Lio/fabric/unity/android/FabricInitializer;->savedContext:Landroid/content/Context;

    invoke-static {v6}, Lio/fabric/unity/android/FabricInitializer;->getManifestMetadata(Landroid/content/Context;)Landroid/os/Bundle;

    move-result-object v3

    .line 39
    .local v3, "metadata":Landroid/os/Bundle;
    if-nez v3, :cond_1

    .line 40
    const-string v4, "Fabric initialization metadata missing. Check your AndroidManifest.xml"

    .line 42
    .local v4, "msg":Ljava/lang/String;
    new-instance v6, Lio/fabric/unity/android/FabricInitializationException;

    const-string v7, "Fabric initialization metadata missing. Check your AndroidManifest.xml"

    invoke-direct {v6, v7}, Lio/fabric/unity/android/FabricInitializationException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 45
    .end local v4    # "msg":Ljava/lang/String;
    :cond_1
    new-instance v5, Lio/fabric/unity/android/BundleKitDataProvider;

    invoke-direct {v5, v3}, Lio/fabric/unity/android/BundleKitDataProvider;-><init>(Landroid/os/Bundle;)V

    .line 46
    .local v5, "provider":Lio/fabric/unity/android/BundleKitDataProvider;
    invoke-virtual {v5}, Lio/fabric/unity/android/BundleKitDataProvider;->getKitData()[Lio/fabric/unity/android/KitData;

    move-result-object v1

    .line 47
    .local v1, "kitDataArray":[Lio/fabric/unity/android/KitData;
    new-instance v6, Lio/fabric/unity/android/KitInstantiator;

    invoke-direct {v6, v3}, Lio/fabric/unity/android/KitInstantiator;-><init>(Landroid/os/Bundle;)V

    invoke-virtual {v6, v1}, Lio/fabric/unity/android/KitInstantiator;->createKitsFromKitData([Lio/fabric/unity/android/KitData;)[Lio/fabric/sdk/android/Kit;

    move-result-object v2

    .line 49
    .local v2, "kits":[Lio/fabric/sdk/android/Kit;
    if-eqz v2, :cond_2

    array-length v6, v2

    const/4 v7, 0x1

    if-ge v6, v7, :cond_3

    .line 50
    :cond_2
    const-string v6, "Fabric"

    const-string v7, "Fabric found no kits to initialize."

    invoke-static {v6, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 51
    const-string v6, ""

    .line 61
    :goto_0
    return-object v6

    .line 54
    :cond_3
    invoke-virtual {v5}, Lio/fabric/unity/android/BundleKitDataProvider;->getInitializationType()Ljava/lang/String;

    move-result-object v0

    .line 56
    .local v0, "initializationType":Ljava/lang/String;
    sget-object v6, Lio/fabric/unity/android/FabricInitializer;->AUTOMATIC:Ljava/lang/String;

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    sget-object v6, Lio/fabric/unity/android/FabricInitializer$Caller;->Android:Lio/fabric/unity/android/FabricInitializer$Caller;

    if-eq p1, v6, :cond_5

    :cond_4
    sget-object v6, Lio/fabric/unity/android/FabricInitializer;->MANUAL:Ljava/lang/String;

    .line 57
    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    sget-object v6, Lio/fabric/unity/android/FabricInitializer$Caller;->Unity:Lio/fabric/unity/android/FabricInitializer$Caller;

    if-ne p1, v6, :cond_6

    .line 58
    :cond_5
    sget-object v6, Lio/fabric/unity/android/FabricInitializer;->savedContext:Landroid/content/Context;

    invoke-static {v6, v2}, Lio/fabric/sdk/android/Fabric;->with(Landroid/content/Context;[Lio/fabric/sdk/android/Kit;)Lio/fabric/sdk/android/Fabric;

    .line 61
    :cond_6
    invoke-virtual {v5}, Lio/fabric/unity/android/BundleKitDataProvider;->getInitializationKitsList()Ljava/lang/String;

    move-result-object v6

    goto :goto_0
.end method
