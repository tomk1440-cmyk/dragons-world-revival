.class public Lcom/prime31/GoogleIABProxyActivity;
.super Landroid/app/Activity;
.source "GoogleIABProxyActivity.java"


# static fields
.field private static final RC_REQUEST:I = 0x2711

.field private static final TAG:Ljava/lang/String; = "Prime31-Proxy"


# instance fields
.field private _created:Ljava/lang/Boolean;

.field private _didCompletePurcaseFlow:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 16
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 19
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GoogleIABProxyActivity;->_created:Ljava/lang/Boolean;

    .line 20
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GoogleIABProxyActivity;->_didCompletePurcaseFlow:Ljava/lang/Boolean;

    .line 16
    return-void
.end method


# virtual methods
.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 6
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v5, 0x1

    .line 69
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GoogleIABProxyActivity;->_didCompletePurcaseFlow:Ljava/lang/Boolean;

    .line 70
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "onActivityResult"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    const/4 v3, 0x2

    aput-object p3, v2, v3

    invoke-static {v0, v1, v2}, Lcom/prime31/IABConstants;->logEntering(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 72
    invoke-static {}, Lcom/prime31/GoogleIABPlugin;->instance()Lcom/prime31/GoogleIABPlugin;

    move-result-object v0

    iget-object v0, v0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    if-nez v0, :cond_0

    .line 74
    const-string v0, "Prime31-Proxy"

    const-string v1, "FATAL ERROR: Plugin singleton helper is null in onActivityResult. Attempting to abort operation to avoid a crash."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 75
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onActivityResult(IILandroid/content/Intent;)V

    .line 76
    invoke-virtual {p0}, Lcom/prime31/GoogleIABProxyActivity;->finish()V

    .line 93
    :goto_0
    return-void

    .line 81
    :cond_0
    invoke-static {}, Lcom/prime31/GoogleIABPlugin;->instance()Lcom/prime31/GoogleIABPlugin;

    move-result-object v0

    iget-object v0, v0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    invoke-virtual {v0, p1, p2, p3}, Lcom/prime31/util/IabHelperImpl;->handleActivityResult(IILandroid/content/Intent;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 84
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onActivityResult(IILandroid/content/Intent;)V

    .line 92
    :goto_1
    invoke-virtual {p0}, Lcom/prime31/GoogleIABProxyActivity;->finish()V

    goto :goto_0

    .line 88
    :cond_1
    const-string v0, "Prime31-Proxy"

    const-string v1, "onActivityResult handled by IABUtil. All done here."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 14
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v13, 0x0

    const/16 v12, 0x2711

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 26
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 28
    invoke-virtual {p0}, Lcom/prime31/GoogleIABProxyActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v1, v10}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 30
    iget-object v0, p0, Lcom/prime31/GoogleIABProxyActivity;->_created:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 32
    const-string v0, "Prime31"

    const-string v1, "activity created twice. stopping one instance"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 63
    :cond_0
    :goto_0
    return-void

    .line 36
    :cond_1
    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GoogleIABProxyActivity;->_created:Ljava/lang/Boolean;

    .line 40
    :try_start_0
    invoke-virtual {p0}, Lcom/prime31/GoogleIABProxyActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "sku"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 41
    .local v2, "sku":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/prime31/GoogleIABProxyActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "itemType"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 42
    .local v3, "itemType":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/prime31/GoogleIABProxyActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "developerPayload"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 44
    .local v7, "developerPayload":Ljava/lang/String;
    const-string v0, "Prime31-Proxy"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "proxy received action. sku: "

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 45
    invoke-static {}, Lcom/prime31/GoogleIABPlugin;->instance()Lcom/prime31/GoogleIABPlugin;

    move-result-object v0

    iget-object v0, v0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    const/4 v4, 0x0

    const/16 v5, 0x2711

    invoke-static {}, Lcom/prime31/GoogleIABPlugin;->instance()Lcom/prime31/GoogleIABPlugin;

    move-result-object v6

    move-object v1, p0

    invoke-virtual/range {v0 .. v7}, Lcom/prime31/util/IabHelperImpl;->launchPurchaseFlow(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;Ljava/lang/String;)Z

    move-result v9

    .line 46
    .local v9, "res":Z
    if-nez v9, :cond_0

    .line 47
    invoke-virtual {p0}, Lcom/prime31/GoogleIABProxyActivity;->finish()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 49
    .end local v2    # "sku":Ljava/lang/String;
    .end local v3    # "itemType":Ljava/lang/String;
    .end local v7    # "developerPayload":Ljava/lang/String;
    .end local v9    # "res":Z
    :catch_0
    move-exception v8

    .line 51
    .local v8, "e":Ljava/lang/Exception;
    const-string v0, "Prime31-Proxy"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "unhandled exception while attempting to purchase item: "

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 52
    const-string v0, "Prime31-Proxy"

    const-string v1, "going to end the async operation with null data to clear out the queue"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 54
    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GoogleIABProxyActivity;->_didCompletePurcaseFlow:Ljava/lang/Boolean;

    .line 55
    invoke-static {}, Lcom/prime31/GoogleIABPlugin;->instance()Lcom/prime31/GoogleIABPlugin;

    move-result-object v0

    iget-object v0, v0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    if-nez v0, :cond_2

    .line 56
    const-string v0, "Prime31-Proxy"

    const-string v1, "FATAL ERROR: Plugin singleton helper is null. Aborting operation."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 60
    :goto_1
    invoke-virtual {p0}, Lcom/prime31/GoogleIABProxyActivity;->finish()V

    goto/16 :goto_0

    .line 58
    :cond_2
    invoke-static {}, Lcom/prime31/GoogleIABPlugin;->instance()Lcom/prime31/GoogleIABPlugin;

    move-result-object v0

    iget-object v0, v0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    invoke-virtual {v0, v12, v10, v13}, Lcom/prime31/util/IabHelperImpl;->handleActivityResult(IILandroid/content/Intent;)Z

    goto :goto_1
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 111
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 112
    const-string v0, "Prime31-Proxy"

    const-string v1, "GoogleIABProxyActivity onDestroy"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 113
    return-void
.end method

.method public onStop()V
    .locals 4

    .prologue
    .line 98
    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    .line 100
    iget-object v0, p0, Lcom/prime31/GoogleIABProxyActivity;->_didCompletePurcaseFlow:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 102
    const-string v0, "Prime31-Proxy"

    const-string v1, "in onStop but we didnt complete the purchase flow. Canceling it now."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 103
    invoke-static {}, Lcom/prime31/GoogleIABPlugin;->instance()Lcom/prime31/GoogleIABPlugin;

    move-result-object v0

    iget-object v0, v0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    const/16 v1, 0x2711

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/prime31/util/IabHelperImpl;->handleActivityResult(IILandroid/content/Intent;)Z

    .line 105
    :cond_0
    const-string v0, "Prime31-Proxy"

    const-string v1, "GoogleIABProxyActivity onStop"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 106
    return-void
.end method
