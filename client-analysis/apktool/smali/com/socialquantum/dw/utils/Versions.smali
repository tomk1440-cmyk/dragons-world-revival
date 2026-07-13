.class public Lcom/socialquantum/dw/utils/Versions;
.super Ljava/lang/Object;
.source "Versions.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/socialquantum/dw/utils/Versions$BuildType;
    }
.end annotation


# static fields
.field private static final FB_INT:Ljava/lang/String; = "567932989917303"

.field private static final FB_RU:Ljava/lang/String; = "352155171562610"

.field private static applicationId:Ljava/lang/String;

.field private static buildType:Lcom/socialquantum/dw/utils/Versions$BuildType;

.field private static gmsId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/socialquantum/dw/utils/Versions$BuildType;->UNKNOWN:Lcom/socialquantum/dw/utils/Versions$BuildType;

    sput-object v0, Lcom/socialquantum/dw/utils/Versions;->buildType:Lcom/socialquantum/dw/utils/Versions$BuildType;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static appId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/socialquantum/dw/utils/Versions;->applicationId:Ljava/lang/String;

    return-object v0
.end method

.method public static gmsId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/socialquantum/dw/utils/Versions;->gmsId:Ljava/lang/String;

    return-object v0
.end method

.method public static loadMetadata(Landroid/content/Context;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 29
    const-string v2, "DW Utils"

    const-string v3, "Loading metadata"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 30
    if-eqz p0, :cond_1

    .line 31
    const/4 v0, 0x0

    .line 34
    .local v0, "ai":Landroid/content/pm/ApplicationInfo;
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x80

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 39
    const-string v2, "352155171562610"

    sput-object v2, Lcom/socialquantum/dw/utils/Versions;->applicationId:Ljava/lang/String;

    .line 40
    if-eqz v0, :cond_0

    iget-object v2, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    if-eqz v2, :cond_0

    .line 44
    sget-object v2, Lcom/socialquantum/dw/utils/Versions;->gmsId:Ljava/lang/String;

    if-nez v2, :cond_0

    .line 45
    iget-object v2, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string v3, "com.google.android.gms.appstate.APP_ID"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/socialquantum/dw/utils/Versions;->gmsId:Ljava/lang/String;

    .line 48
    :cond_0
    sget-object v2, Lcom/socialquantum/dw/utils/Versions;->applicationId:Ljava/lang/String;

    if-nez v2, :cond_2

    sget-object v2, Lcom/socialquantum/dw/utils/Versions$BuildType;->UNKNOWN:Lcom/socialquantum/dw/utils/Versions$BuildType;

    :goto_0
    sput-object v2, Lcom/socialquantum/dw/utils/Versions;->buildType:Lcom/socialquantum/dw/utils/Versions$BuildType;

    .line 50
    .end local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    :cond_1
    :goto_1
    return-void

    .line 35
    .restart local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    :catch_0
    move-exception v1

    .line 36
    .local v1, "var3":Landroid/content/pm/PackageManager$NameNotFoundException;
    goto :goto_1

    .line 48
    .end local v1    # "var3":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_2
    sget-object v2, Lcom/socialquantum/dw/utils/Versions;->applicationId:Ljava/lang/String;

    const-string v3, "567932989917303"

    if-ne v2, v3, :cond_3

    sget-object v2, Lcom/socialquantum/dw/utils/Versions$BuildType;->INT:Lcom/socialquantum/dw/utils/Versions$BuildType;

    goto :goto_0

    :cond_3
    sget-object v2, Lcom/socialquantum/dw/utils/Versions$BuildType;->RU:Lcom/socialquantum/dw/utils/Versions$BuildType;

    goto :goto_0
.end method

.method public static type()Lcom/socialquantum/dw/utils/Versions$BuildType;
    .locals 1

    .prologue
    .line 17
    sget-object v0, Lcom/socialquantum/dw/utils/Versions;->buildType:Lcom/socialquantum/dw/utils/Versions$BuildType;

    return-object v0
.end method
