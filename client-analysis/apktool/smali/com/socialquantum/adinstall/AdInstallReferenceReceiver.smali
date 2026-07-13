.class public Lcom/socialquantum/adinstall/AdInstallReferenceReceiver;
.super Landroid/content/BroadcastReceiver;
.source "AdInstallReferenceReceiver.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method private ReadUrlReference(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "logCaption"    # Ljava/lang/String;

    .prologue
    .line 21
    :try_start_0
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 22
    .local v2, "extras":Landroid/os/Bundle;
    if-nez v2, :cond_0

    .line 23
    const-string v4, "Ad reference url is not specified (extras == null)"

    invoke-static {p3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 38
    .end local v2    # "extras":Landroid/os/Bundle;
    :goto_0
    return-void

    .line 26
    .restart local v2    # "extras":Landroid/os/Bundle;
    :cond_0
    const-string v4, "referrer"

    invoke-virtual {v2, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 27
    .local v3, "referrerString":Ljava/lang/String;
    if-nez v3, :cond_1

    .line 28
    const-string v4, "Ad reference url is not specified (referrerString == null)"

    invoke-static {p3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 34
    .end local v2    # "extras":Landroid/os/Bundle;
    .end local v3    # "referrerString":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 35
    .local v1, "e":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Exception: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {p3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 36
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 31
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "extras":Landroid/os/Bundle;
    .restart local v3    # "referrerString":Ljava/lang/String;
    :cond_1
    :try_start_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "x://?referrer="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 33
    .local v0, "dummyUri":Ljava/lang/String;
    invoke-static {p1, v0, p3}, Lcom/socialquantum/dw/utils/storage/FileSystem;->SaveUrlReferenceToFile(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 15
    const-string v0, "AmazonADM"

    const-string v1, "Install notification"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 16
    const-string v0, "AdInstallReferenceReceiver"

    invoke-direct {p0, p1, p2, v0}, Lcom/socialquantum/adinstall/AdInstallReferenceReceiver;->ReadUrlReference(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V

    .line 17
    return-void
.end method
