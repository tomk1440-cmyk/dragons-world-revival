.class public Lcom/prime31/GoogleIABPlugin;
.super Lcom/prime31/GoogleIABPluginBase;
.source "GoogleIABPlugin.java"

# interfaces
.implements Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;
.implements Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;
.implements Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;
.implements Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;


# static fields
.field private static BILLING_NOT_RUNNING_ERROR:Ljava/lang/String; = null

.field static final RC_REQUEST:I = 0x2711


# instance fields
.field private _hasQueriedInventory:Z

.field private _purchases:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/prime31/util/Purchase;",
            ">;"
        }
    .end annotation
.end field

.field private _skus:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/prime31/util/SkuDetails;",
            ">;"
        }
    .end annotation
.end field

.field public helper:Lcom/prime31/util/IabHelperImpl;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-string v0, "The billing service is not running or billing is not supported. Aborting."

    sput-object v0, Lcom/prime31/GoogleIABPlugin;->BILLING_NOT_RUNNING_ERROR:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/prime31/GoogleIABPluginBase;-><init>()V

    .line 28
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    .line 30
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/prime31/GoogleIABPlugin;->_hasQueriedInventory:Z

    .line 24
    return-void
.end method

.method private getPurchasedProductForSku(Ljava/lang/String;)Lcom/prime31/util/Purchase;
    .locals 3
    .param p1, "sku"    # Ljava/lang/String;

    .prologue
    .line 40
    iget-object v1, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 46
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 40
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/prime31/util/Purchase;

    .line 42
    .local v0, "p":Lcom/prime31/util/Purchase;
    invoke-virtual {v0}, Lcom/prime31/util/Purchase;->getSku()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    goto :goto_0
.end method


# virtual methods
.method public areSubscriptionsSupported()Z
    .locals 2

    .prologue
    .line 110
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "areSubscriptionsSupported"

    invoke-static {v0, v1}, Lcom/prime31/IABConstants;->logEntering(Ljava/lang/String;Ljava/lang/String;)V

    .line 112
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    if-nez v0, :cond_0

    .line 113
    const/4 v0, 0x0

    .line 115
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    invoke-virtual {v0}, Lcom/prime31/util/IabHelperImpl;->subscriptionsSupported()Z

    move-result v0

    goto :goto_0
.end method

.method public consumeProduct(Ljava/lang/String;)V
    .locals 4
    .param p1, "sku"    # Ljava/lang/String;

    .prologue
    .line 232
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "consumeProduct"

    invoke-static {v1, v2, p1}, Lcom/prime31/IABConstants;->logEntering(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 234
    iget-object v1, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    if-nez v1, :cond_0

    .line 236
    const-string v1, "Prime31"

    sget-object v2, Lcom/prime31/GoogleIABPlugin;->BILLING_NOT_RUNNING_ERROR:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 268
    :goto_0
    return-void

    .line 240
    :cond_0
    iget-boolean v1, p0, Lcom/prime31/GoogleIABPlugin;->_hasQueriedInventory:Z

    if-nez v1, :cond_1

    .line 241
    const-string v1, "Prime31"

    const-string v2, "You have not queried your inventory yet so the plugin does not have the required information to protect you from coding errors."

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 245
    :cond_1
    invoke-direct {p0, p1}, Lcom/prime31/GoogleIABPlugin;->getPurchasedProductForSku(Ljava/lang/String;)Lcom/prime31/util/Purchase;

    move-result-object v0

    .line 246
    .local v0, "p":Lcom/prime31/util/Purchase;
    if-nez v0, :cond_2

    .line 248
    const-string v1, "Prime31"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Attempting to consume an item that has not been purchased. Aborting to avoid exception. sku: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 249
    const-string v1, "consumePurchaseFailed"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, ": you cannot consume a project that has not been purchased or if you have not first queried your inventory to retreive the purchases."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/prime31/GoogleIABPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 253
    :cond_2
    new-instance v1, Lcom/prime31/GoogleIABPlugin$4;

    invoke-direct {v1, p0, v0}, Lcom/prime31/GoogleIABPlugin$4;-><init>(Lcom/prime31/GoogleIABPlugin;Lcom/prime31/util/Purchase;)V

    .line 267
    const-string v2, "consumePurchaseFailed"

    .line 253
    invoke-virtual {p0, v1, v2}, Lcom/prime31/GoogleIABPlugin;->runSafelyOnUiThread(Ljava/lang/Runnable;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public consumeProducts([Ljava/lang/String;)V
    .locals 6
    .param p1, "skus"    # [Ljava/lang/String;

    .prologue
    .line 273
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    const-string v4, "consumeProducts"

    invoke-static {v3, v4, p1}, Lcom/prime31/IABConstants;->logEntering(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 275
    iget-object v3, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    if-nez v3, :cond_0

    .line 277
    const-string v3, "Prime31"

    sget-object v4, Lcom/prime31/GoogleIABPlugin;->BILLING_NOT_RUNNING_ERROR:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 318
    :goto_0
    return-void

    .line 282
    :cond_0
    iget-object v3, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-nez v3, :cond_2

    .line 284
    :cond_1
    const-string v3, "Prime31"

    const-string v4, "there are no purchases available to consume"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 289
    :cond_2
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 290
    .local v0, "confirmedPurchases":Ljava/util/List;, "Ljava/util/List<Lcom/prime31/util/Purchase;>;"
    array-length v4, p1

    const/4 v3, 0x0

    :goto_1
    if-lt v3, v4, :cond_3

    .line 297
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    array-length v4, p1

    if-eq v3, v4, :cond_5

    .line 299
    const-string v3, "Prime31"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Attempting to consume "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    array-length v5, p1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " item(s) but only "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " item(s) were found to be purchased. Aborting."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 290
    :cond_3
    aget-object v2, p1, v3

    .line 292
    .local v2, "sku":Ljava/lang/String;
    invoke-direct {p0, v2}, Lcom/prime31/GoogleIABPlugin;->getPurchasedProductForSku(Ljava/lang/String;)Lcom/prime31/util/Purchase;

    move-result-object v1

    .line 293
    .local v1, "p":Lcom/prime31/util/Purchase;
    if-eqz v1, :cond_4

    .line 294
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 290
    :cond_4
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 303
    .end local v1    # "p":Lcom/prime31/util/Purchase;
    .end local v2    # "sku":Ljava/lang/String;
    :cond_5
    new-instance v3, Lcom/prime31/GoogleIABPlugin$5;

    invoke-direct {v3, p0, v0}, Lcom/prime31/GoogleIABPlugin$5;-><init>(Lcom/prime31/GoogleIABPlugin;Ljava/util/List;)V

    .line 317
    const-string v4, "consumePurchaseFailed"

    .line 303
    invoke-virtual {p0, v3, v4}, Lcom/prime31/GoogleIABPlugin;->runSafelyOnUiThread(Ljava/lang/Runnable;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public enableLogging(Z)V
    .locals 1
    .param p1, "shouldEnable"    # Z

    .prologue
    .line 57
    sput-boolean p1, Lcom/prime31/IABConstants;->DEBUG:Z

    .line 58
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    invoke-virtual {v0, p1}, Lcom/prime31/util/IabHelperImpl;->enableDebugLogging(Z)V

    .line 60
    :cond_0
    return-void
.end method

.method public init(Ljava/lang/String;)V
    .locals 3
    .param p1, "publicKey"    # Ljava/lang/String;

    .prologue
    .line 71
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "init"

    invoke-static {v0, v1, p1}, Lcom/prime31/IABConstants;->logEntering(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 73
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    .line 74
    new-instance v0, Lcom/prime31/util/IabHelperImpl;

    invoke-virtual {p0}, Lcom/prime31/GoogleIABPlugin;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lcom/prime31/util/IabHelperImpl;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    .line 75
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    sget-boolean v1, Lcom/prime31/IABConstants;->DEBUG:Z

    const-string v2, "Prime31-IABH"

    invoke-virtual {v0, v1, v2}, Lcom/prime31/util/IabHelperImpl;->enableDebugLogging(ZLjava/lang/String;)V

    .line 76
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    new-instance v1, Lcom/prime31/GoogleIABPlugin$1;

    invoke-direct {v1, p0}, Lcom/prime31/GoogleIABPlugin$1;-><init>(Lcom/prime31/GoogleIABPlugin;)V

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->startSetup(Lcom/prime31/util/IabHelperImpl$OnIabSetupFinishedListener;)V

    .line 93
    return-void
.end method

.method public onConsumeFinished(Lcom/prime31/util/Purchase;Lcom/prime31/util/IabResult;)V
    .locals 3
    .param p1, "purchase"    # Lcom/prime31/util/Purchase;
    .param p2, "result"    # Lcom/prime31/util/IabResult;

    .prologue
    .line 407
    invoke-virtual {p2}, Lcom/prime31/util/IabResult;->isSuccess()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 409
    iget-object v1, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 410
    iget-object v1, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 411
    :cond_0
    const-string v1, "consumePurchaseSucceeded"

    invoke-virtual {p1}, Lcom/prime31/util/Purchase;->toJson()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/prime31/GoogleIABPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 418
    :goto_0
    return-void

    .line 415
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lcom/prime31/util/Purchase;->getSku()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Lcom/prime31/util/IabResult;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 416
    .local v0, "res":Ljava/lang/String;
    const-string v1, "consumePurchaseFailed"

    invoke-virtual {p0, v1, v0}, Lcom/prime31/GoogleIABPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onConsumeMultiFinished(Ljava/util/List;Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/prime31/util/Purchase;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/prime31/util/IabResult;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 428
    .local p1, "purchases":Ljava/util/List;, "Ljava/util/List<Lcom/prime31/util/Purchase;>;"
    .local p2, "results":Ljava/util/List;, "Ljava/util/List<Lcom/prime31/util/IabResult;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v4

    if-lt v0, v4, :cond_0

    .line 445
    return-void

    .line 430
    :cond_0
    invoke-interface {p2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/prime31/util/IabResult;

    .line 431
    .local v3, "result":Lcom/prime31/util/IabResult;
    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/prime31/util/Purchase;

    .line 433
    .local v1, "purchase":Lcom/prime31/util/Purchase;
    invoke-virtual {v3}, Lcom/prime31/util/IabResult;->isSuccess()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 435
    iget-object v4, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 436
    iget-object v4, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 437
    :cond_1
    const-string v4, "consumePurchaseSucceeded"

    invoke-virtual {v1}, Lcom/prime31/util/Purchase;->toJson()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v4, v5}, Lcom/prime31/GoogleIABPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 428
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 441
    :cond_2
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Lcom/prime31/util/Purchase;->getSku()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, ": "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Lcom/prime31/util/IabResult;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 442
    .local v2, "res":Ljava/lang/String;
    const-string v4, "consumePurchaseFailed"

    invoke-virtual {p0, v4, v2}, Lcom/prime31/GoogleIABPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onIabPurchaseCompleteAwaitingVerification(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "purchaseData"    # Ljava/lang/String;
    .param p2, "signature"    # Ljava/lang/String;

    .prologue
    .line 358
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 359
    .local v1, "json":Lorg/json/JSONObject;
    const-string v2, "purchaseData"

    invoke-virtual {v1, v2, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 360
    const-string v2, "signature"

    invoke-virtual {v1, v2, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 362
    const-string v2, "purchaseCompleteAwaitingVerification"

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lcom/prime31/GoogleIABPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 368
    .end local v1    # "json":Lorg/json/JSONObject;
    :goto_0
    return-void

    .line 364
    :catch_0
    move-exception v0

    .line 366
    .local v0, "e":Lorg/json/JSONException;
    const-string v2, "Prime31"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "failed to create JSON packet: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V
    .locals 5
    .param p1, "result"    # Lcom/prime31/util/IabResult;
    .param p2, "info"    # Lcom/prime31/util/Purchase;

    .prologue
    .line 374
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "onIabPurchaseFinished. result: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/prime31/util/IabResult;->getResponse()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/prime31/IABConstants;->logDebug(Ljava/lang/String;)V

    .line 376
    invoke-virtual {p1}, Lcom/prime31/util/IabResult;->isSuccess()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 378
    iget-object v2, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    invoke-interface {v2, p2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 379
    iget-object v2, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    invoke-interface {v2, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 380
    :cond_0
    const-string v2, "purchaseSucceeded"

    invoke-virtual {p2}, Lcom/prime31/util/Purchase;->toJson()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lcom/prime31/GoogleIABPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 397
    :goto_0
    return-void

    .line 386
    :cond_1
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 387
    .local v1, "json":Lorg/json/JSONObject;
    const-string v2, "result"

    invoke-virtual {p1}, Lcom/prime31/util/IabResult;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 388
    const-string v2, "response"

    invoke-virtual {p1}, Lcom/prime31/util/IabResult;->getResponse()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 390
    const-string v2, "purchaseFailed"

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lcom/prime31/GoogleIABPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 392
    .end local v1    # "json":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 394
    .local v0, "e":Lorg/json/JSONException;
    const-string v2, "Prime31"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "failed to create JSON packet: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onQueryInventoryFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Inventory;)V
    .locals 2
    .param p1, "result"    # Lcom/prime31/util/IabResult;
    .param p2, "inv"    # Lcom/prime31/util/Inventory;

    .prologue
    .line 328
    invoke-virtual {p1}, Lcom/prime31/util/IabResult;->isSuccess()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 331
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/prime31/GoogleIABPlugin;->_hasQueriedInventory:Z

    .line 333
    invoke-virtual {p2}, Lcom/prime31/util/Inventory;->getAllPurchases()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    .line 335
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->_skus:Ljava/util/List;

    if-nez v0, :cond_0

    .line 336
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/prime31/GoogleIABPlugin;->_skus:Ljava/util/List;

    .line 337
    :cond_0
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->_skus:Ljava/util/List;

    invoke-virtual {p2}, Lcom/prime31/util/Inventory;->getAllSkuDetails()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 338
    invoke-virtual {p2}, Lcom/prime31/util/Inventory;->getAllSkuDetails()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GoogleIABPlugin;->_skus:Ljava/util/List;

    .line 340
    const-string v0, "queryInventorySucceeded"

    invoke-virtual {p2}, Lcom/prime31/util/Inventory;->getAllSkusAndPurchasesAsJson()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/prime31/GoogleIABPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 346
    :goto_0
    return-void

    .line 344
    :cond_1
    const-string v0, "queryInventoryFailed"

    invoke-virtual {p1}, Lcom/prime31/util/IabResult;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/prime31/GoogleIABPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public purchaseProduct(Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "sku"    # Ljava/lang/String;
    .param p2, "developerPayload"    # Ljava/lang/String;

    .prologue
    .line 160
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "purchaseProduct"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    const/4 v7, 0x1

    aput-object p2, v6, v7

    invoke-static {v4, v5, v6}, Lcom/prime31/IABConstants;->logEntering(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 162
    iget-object v4, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    if-nez v4, :cond_0

    .line 164
    const-string v4, "Prime31"

    sget-object v5, Lcom/prime31/GoogleIABPlugin;->BILLING_NOT_RUNNING_ERROR:Ljava/lang/String;

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 227
    :goto_0
    return-void

    .line 168
    :cond_0
    iget-boolean v4, p0, Lcom/prime31/GoogleIABPlugin;->_hasQueriedInventory:Z

    if-nez v4, :cond_1

    .line 169
    const-string v4, "Prime31"

    const-string v5, "You have not queried your inventory yet so the plugin does not have the required information to protect you from coding errors."

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 172
    :cond_1
    iget-object v4, p0, Lcom/prime31/GoogleIABPlugin;->_purchases:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_7

    .line 182
    const-string v1, "inapp"

    .line 184
    .local v1, "itemType":Ljava/lang/String;
    iget-boolean v4, p0, Lcom/prime31/GoogleIABPlugin;->_hasQueriedInventory:Z

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/prime31/GoogleIABPlugin;->_skus:Ljava/util/List;

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/prime31/GoogleIABPlugin;->_skus:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-nez v4, :cond_8

    .line 186
    :cond_3
    const-string v4, "Prime31"

    const-string v5, "CANNOT fetch sku type due to either inventory not being queried or it returned no valid skus."

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 202
    :cond_4
    :goto_2
    const-string v4, "android.test.purchased"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 204
    const-string v4, "Prime31"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "fixing Google bug where they think the sku "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " is a subscription. resetting to type inapp"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 205
    const-string v1, "inapp"

    .line 209
    :cond_5
    if-nez v1, :cond_6

    .line 211
    const-string v4, "Prime31"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, ": you have attempted to purchase a sku that was not returned when querying the inventory. We will still let the product go through but it will be defaulted to an inapp type and may not work."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 212
    const-string v1, "inapp"

    .line 215
    :cond_6
    move-object v0, v1

    .line 216
    .local v0, "f_itemType":Ljava/lang/String;
    new-instance v4, Lcom/prime31/GoogleIABPlugin$3;

    invoke-direct {v4, p0, p1, v0, p2}, Lcom/prime31/GoogleIABPlugin$3;-><init>(Lcom/prime31/GoogleIABPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    const-string v5, "purchaseFailed"

    .line 216
    invoke-virtual {p0, v4, v5}, Lcom/prime31/GoogleIABPlugin;->runSafelyOnUiThread(Ljava/lang/Runnable;Ljava/lang/String;)V

    goto :goto_0

    .line 172
    .end local v0    # "f_itemType":Ljava/lang/String;
    .end local v1    # "itemType":Ljava/lang/String;
    :cond_7
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/prime31/util/Purchase;

    .line 174
    .local v2, "p":Lcom/prime31/util/Purchase;
    invoke-virtual {v2}, Lcom/prime31/util/Purchase;->getSku()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 177
    const-string v5, "Prime31"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Attempting to purchase an item that has already been purchased. That is probably not a good idea: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    .line 191
    .end local v2    # "p":Lcom/prime31/util/Purchase;
    .restart local v1    # "itemType":Ljava/lang/String;
    :cond_8
    iget-object v4, p0, Lcom/prime31/GoogleIABPlugin;->_skus:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_9
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/prime31/util/SkuDetails;

    .line 193
    .local v3, "s":Lcom/prime31/util/SkuDetails;
    invoke-virtual {v3}, Lcom/prime31/util/SkuDetails;->getSku()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 195
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "found sku "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " in retrieved skus. setting item type to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Lcom/prime31/util/SkuDetails;->getItemType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/prime31/IABConstants;->logDebug(Ljava/lang/String;)V

    .line 196
    invoke-virtual {v3}, Lcom/prime31/util/SkuDetails;->getItemType()Ljava/lang/String;

    move-result-object v1

    .line 197
    goto/16 :goto_2
.end method

.method public queryInventory([Ljava/lang/Object;)V
    .locals 3
    .param p1, "skus"    # [Ljava/lang/Object;

    .prologue
    .line 121
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "queryInventory"

    invoke-static {v1, v2, p1}, Lcom/prime31/IABConstants;->logEntering(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 122
    const-string v1, "in queryInventory with Object[] parameter. Converting to String[] now."

    invoke-static {v1}, Lcom/prime31/IABConstants;->logDebug(Ljava/lang/String;)V

    .line 124
    invoke-static {p1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    array-length v2, p1

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    .line 125
    .local v0, "skuStringArray":[Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/prime31/GoogleIABPlugin;->queryInventory([Ljava/lang/String;)V

    .line 126
    return-void
.end method

.method public queryInventory([Ljava/lang/String;)V
    .locals 2
    .param p1, "skus"    # [Ljava/lang/String;

    .prologue
    .line 131
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "queryInventory"

    invoke-static {v0, v1, p1}, Lcom/prime31/IABConstants;->logEntering(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 133
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    if-nez v0, :cond_0

    .line 135
    const-string v0, "Prime31"

    sget-object v1, Lcom/prime31/GoogleIABPlugin;->BILLING_NOT_RUNNING_ERROR:Ljava/lang/String;

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 155
    :goto_0
    return-void

    .line 140
    :cond_0
    new-instance v0, Lcom/prime31/GoogleIABPlugin$2;

    invoke-direct {v0, p0, p1}, Lcom/prime31/GoogleIABPlugin$2;-><init>(Lcom/prime31/GoogleIABPlugin;[Ljava/lang/String;)V

    .line 154
    const-string v1, "queryInventoryFailed"

    .line 140
    invoke-virtual {p0, v0, v1}, Lcom/prime31/GoogleIABPlugin;->runSafelyOnUiThread(Ljava/lang/Runnable;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setAutoVerifySignatures(Z)V
    .locals 0
    .param p1, "shouldVerify"    # Z

    .prologue
    .line 65
    sput-boolean p1, Lcom/prime31/util/IabHelperImpl;->autoVerifySignatures:Z

    .line 66
    return-void
.end method

.method public unbindService()V
    .locals 2

    .prologue
    .line 98
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "unbindService"

    invoke-static {v0, v1}, Lcom/prime31/IABConstants;->logEntering(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    if-eqz v0, :cond_0

    .line 102
    iget-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    invoke-virtual {v0}, Lcom/prime31/util/IabHelperImpl;->disposeWhenFinished()V

    .line 103
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/prime31/GoogleIABPlugin;->helper:Lcom/prime31/util/IabHelperImpl;

    .line 105
    :cond_0
    return-void
.end method
