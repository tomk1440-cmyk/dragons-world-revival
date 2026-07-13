.class public Lcom/prime31/util/IabHelperImpl;
.super Ljava/lang/Object;
.source "IabHelperImpl.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;,
        Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;,
        Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;,
        Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;,
        Lcom/prime31/util/IabHelperImpl$OnIabSetupFinishedListener;,
        Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;
    }
.end annotation


# static fields
.field public static final BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE:I = 0x3

.field public static final BILLING_RESPONSE_RESULT_DEVELOPER_ERROR:I = 0x5

.field public static final BILLING_RESPONSE_RESULT_ERROR:I = 0x6

.field public static final BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED:I = 0x7

.field public static final BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED:I = 0x8

.field public static final BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE:I = 0x4

.field public static final BILLING_RESPONSE_RESULT_OK:I = 0x0

.field public static final BILLING_RESPONSE_RESULT_SERVICE_UNAVAILABLE:I = 0x2

.field public static final BILLING_RESPONSE_RESULT_USER_CANCELED:I = 0x1

.field public static final GET_SKU_DETAILS_ITEM_LIST:Ljava/lang/String; = "ITEM_ID_LIST"

.field public static final GET_SKU_DETAILS_ITEM_TYPE_LIST:Ljava/lang/String; = "ITEM_TYPE_LIST"

.field public static final IABHELPER_BAD_RESPONSE:I = -0x3ea

.field public static final IABHELPER_ERROR_BASE:I = -0x3e8

.field public static final IABHELPER_INVALID_CONSUMPTION:I = -0x3f2

.field public static final IABHELPER_MISSING_TOKEN:I = -0x3ef

.field public static final IABHELPER_REMOTE_EXCEPTION:I = -0x3e9

.field public static final IABHELPER_SEND_INTENT_FAILED:I = -0x3ec

.field public static final IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE:I = -0x3f1

.field public static final IABHELPER_SUBSCRIPTION_UPDATE_NOT_AVAILABLE:I = -0x3f3

.field public static final IABHELPER_UNKNOWN_ERROR:I = -0x3f0

.field public static final IABHELPER_UNKNOWN_PURCHASE_RESPONSE:I = -0x3ee

.field public static final IABHELPER_USER_CANCELLED:I = -0x3ed

.field public static final IABHELPER_VERIFICATION_FAILED:I = -0x3eb

.field public static final INAPP_CONTINUATION_TOKEN:Ljava/lang/String; = "INAPP_CONTINUATION_TOKEN"

.field public static final ITEM_TYPE_INAPP:Ljava/lang/String; = "inapp"

.field public static final ITEM_TYPE_SUBS:Ljava/lang/String; = "subs"

.field public static final RESPONSE_BUY_INTENT:Ljava/lang/String; = "BUY_INTENT"

.field public static final RESPONSE_CODE:Ljava/lang/String; = "RESPONSE_CODE"

.field public static final RESPONSE_GET_SKU_DETAILS_LIST:Ljava/lang/String; = "DETAILS_LIST"

.field public static final RESPONSE_INAPP_ITEM_LIST:Ljava/lang/String; = "INAPP_PURCHASE_ITEM_LIST"

.field public static final RESPONSE_INAPP_PURCHASE_DATA:Ljava/lang/String; = "INAPP_PURCHASE_DATA"

.field public static final RESPONSE_INAPP_PURCHASE_DATA_LIST:Ljava/lang/String; = "INAPP_PURCHASE_DATA_LIST"

.field public static final RESPONSE_INAPP_SIGNATURE:Ljava/lang/String; = "INAPP_DATA_SIGNATURE"

.field public static final RESPONSE_INAPP_SIGNATURE_LIST:Ljava/lang/String; = "INAPP_DATA_SIGNATURE_LIST"

.field public static autoVerifySignatures:Z


# instance fields
.field mAsyncInProgress:Z

.field private final mAsyncInProgressLock:Ljava/lang/Object;

.field mAsyncOperation:Ljava/lang/String;

.field mContext:Landroid/content/Context;

.field mDebugLog:Z

.field mDebugTag:Ljava/lang/String;

.field mDisposeAfterAsync:Z

.field mDisposed:Z

.field mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

.field mPurchasingItemType:Ljava/lang/String;

.field mRequestCode:I

.field mService:Lcom/android/vending/billing/IInAppBillingService;

.field mServiceConn:Landroid/content/ServiceConnection;

.field mSetupDone:Z

.field mSignatureBase64:Ljava/lang/String;

.field mSubscriptionUpdateSupported:Z

.field mSubscriptionsSupported:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x1

    sput-boolean v0, Lcom/prime31/util/IabHelperImpl;->autoVerifySignatures:Z

    .line 154
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "base64PublicKey"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 173
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    iput-boolean v1, p0, Lcom/prime31/util/IabHelperImpl;->mDebugLog:Z

    .line 64
    const-string v0, "Prime31-IABH"

    iput-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mDebugTag:Ljava/lang/String;

    .line 69
    iput-boolean v1, p0, Lcom/prime31/util/IabHelperImpl;->mSetupDone:Z

    .line 73
    iput-boolean v1, p0, Lcom/prime31/util/IabHelperImpl;->mDisposed:Z

    .line 77
    iput-boolean v1, p0, Lcom/prime31/util/IabHelperImpl;->mDisposeAfterAsync:Z

    .line 80
    iput-boolean v1, p0, Lcom/prime31/util/IabHelperImpl;->mSubscriptionsSupported:Z

    .line 83
    iput-boolean v1, p0, Lcom/prime31/util/IabHelperImpl;->mSubscriptionUpdateSupported:Z

    .line 87
    iput-boolean v1, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgress:Z

    .line 90
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgressLock:Ljava/lang/Object;

    .line 94
    const-string v0, ""

    iput-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncOperation:Ljava/lang/String;

    .line 110
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mSignatureBase64:Ljava/lang/String;

    .line 175
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    .line 176
    iput-object p2, p0, Lcom/prime31/util/IabHelperImpl;->mSignatureBase64:Ljava/lang/String;

    .line 177
    const-string v0, "IAB helper created."

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 178
    return-void
.end method

.method private checkNotDisposed()V
    .locals 2

    .prologue
    .line 411
    iget-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mDisposed:Z

    if-eqz v0, :cond_0

    .line 412
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "IabHelper was disposed of, so it cannot be used."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 413
    :cond_0
    return-void
.end method

.method public static getResponseDesc(I)Ljava/lang/String;
    .locals 5
    .param p0, "code"    # I

    .prologue
    .line 1008
    const-string v3, "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned"

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1009
    .local v0, "iab_msgs":[Ljava/lang/String;
    const-string v3, "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt"

    .line 1011
    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 1013
    .local v1, "iabhelper_msgs":[Ljava/lang/String;
    const/16 v3, -0x3e8

    if-gt p0, v3, :cond_1

    .line 1015
    rsub-int v2, p0, -0x3e8

    .line 1016
    .local v2, "index":I
    if-ltz v2, :cond_0

    array-length v3, v1

    if-ge v2, v3, :cond_0

    .line 1017
    aget-object v3, v1, v2

    .line 1024
    .end local v2    # "index":I
    :goto_0
    return-object v3

    .line 1019
    .restart local v2    # "index":I
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, ":Unknown IAB Helper Error"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 1021
    .end local v2    # "index":I
    :cond_1
    if-ltz p0, :cond_2

    array-length v3, v0

    if-lt p0, v3, :cond_3

    .line 1022
    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, ":Unknown"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 1024
    :cond_3
    aget-object v3, v0, p0

    goto :goto_0
.end method


# virtual methods
.method checkSetupDone(Ljava/lang/String;)V
    .locals 3
    .param p1, "operation"    # Ljava/lang/String;

    .prologue
    .line 1031
    iget-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mSetupDone:Z

    if-nez v0, :cond_0

    .line 1033
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Illegal state for operation ("

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "): IAB helper is not set up."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 1034
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "IAB helper is not set up. Can\'t perform operation: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1036
    :cond_0
    return-void
.end method

.method consume(Lcom/prime31/util/Purchase;)V
    .locals 8
    .param p1, "itemInfo"    # Lcom/prime31/util/Purchase;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabException;
        }
    .end annotation

    .prologue
    .line 886
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 887
    const-string v4, "consume"

    invoke-virtual {p0, v4}, Lcom/prime31/util/IabHelperImpl;->checkSetupDone(Ljava/lang/String;)V

    .line 889
    iget-object v4, p1, Lcom/prime31/util/Purchase;->_itemType:Ljava/lang/String;

    const-string v5, "inapp"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 891
    new-instance v4, Lcom/prime31/util/IabException;

    const/16 v5, -0x3f2

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Items of type \'"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p1, Lcom/prime31/util/Purchase;->_itemType:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\' can\'t be consumed."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/prime31/util/IabException;-><init>(ILjava/lang/String;)V

    throw v4

    .line 896
    :cond_0
    :try_start_0
    invoke-virtual {p1}, Lcom/prime31/util/Purchase;->getToken()Ljava/lang/String;

    move-result-object v3

    .line 897
    .local v3, "token":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/prime31/util/Purchase;->getSku()Ljava/lang/String;

    move-result-object v2

    .line 898
    .local v2, "sku":Ljava/lang/String;
    if-eqz v3, :cond_1

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 900
    :cond_1
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Can\'t consume "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ". No token."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 901
    new-instance v4, Lcom/prime31/util/IabException;

    const/16 v5, -0x3ef

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "PurchaseInfo is missing token for sku: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/prime31/util/IabException;-><init>(ILjava/lang/String;)V

    throw v4
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 916
    .end local v2    # "sku":Ljava/lang/String;
    .end local v3    # "token":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 918
    .local v0, "e":Landroid/os/RemoteException;
    new-instance v4, Lcom/prime31/util/IabException;

    const/16 v5, -0x3e9

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Remote exception while consuming. PurchaseInfo: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6, v0}, Lcom/prime31/util/IabException;-><init>(ILjava/lang/String;Ljava/lang/Exception;)V

    throw v4

    .line 904
    .end local v0    # "e":Landroid/os/RemoteException;
    .restart local v2    # "sku":Ljava/lang/String;
    .restart local v3    # "token":Ljava/lang/String;
    :cond_2
    :try_start_1
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Consuming sku: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", token: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 905
    iget-object v4, p0, Lcom/prime31/util/IabHelperImpl;->mService:Lcom/android/vending/billing/IInAppBillingService;

    const/4 v5, 0x3

    iget-object v6, p0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6, v3}, Lcom/android/vending/billing/IInAppBillingService;->consumePurchase(ILjava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 906
    .local v1, "response":I
    if-nez v1, :cond_3

    .line 908
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Successfully consumed sku: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 920
    return-void

    .line 912
    :cond_3
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Error consuming consuming sku "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ". "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v1}, Lcom/prime31/util/IabHelperImpl;->getResponseDesc(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 913
    new-instance v4, Lcom/prime31/util/IabException;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Error consuming sku "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v1, v5}, Lcom/prime31/util/IabException;-><init>(ILjava/lang/String;)V

    throw v4
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0
.end method

.method public consumeAsync(Lcom/prime31/util/Purchase;Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;)V
    .locals 2
    .param p1, "purchase"    # Lcom/prime31/util/Purchase;
    .param p2, "listener"    # Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    .line 972
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 973
    const-string v1, "consume"

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->checkSetupDone(Ljava/lang/String;)V

    .line 974
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 975
    .local v0, "purchases":Ljava/util/List;, "Ljava/util/List<Lcom/prime31/util/Purchase;>;"
    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 976
    const/4 v1, 0x0

    invoke-virtual {p0, v0, p2, v1}, Lcom/prime31/util/IabHelperImpl;->consumeAsyncInternal(Ljava/util/List;Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;)V

    .line 977
    return-void
.end method

.method public consumeAsync(Ljava/util/List;Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;)V
    .locals 1
    .param p2, "listener"    # Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/prime31/util/Purchase;",
            ">;",
            "Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    .line 992
    .local p1, "purchases":Ljava/util/List;, "Ljava/util/List<Lcom/prime31/util/Purchase;>;"
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 993
    const-string v0, "consume"

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->checkSetupDone(Ljava/lang/String;)V

    .line 994
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0, p2}, Lcom/prime31/util/IabHelperImpl;->consumeAsyncInternal(Ljava/util/List;Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;)V

    .line 995
    return-void
.end method

.method consumeAsyncInternal(Ljava/util/List;Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;)V
    .locals 7
    .param p2, "singleListener"    # Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;
    .param p3, "multiListener"    # Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/prime31/util/Purchase;",
            ">;",
            "Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;",
            "Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    .line 1303
    .local p1, "purchases":Ljava/util/List;, "Ljava/util/List<Lcom/prime31/util/Purchase;>;"
    new-instance v4, Landroid/os/Handler;

    invoke-direct {v4}, Landroid/os/Handler;-><init>()V

    .line 1304
    .local v4, "handler":Landroid/os/Handler;
    const-string v0, "consume"

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->flagStartAsync(Ljava/lang/String;)V

    .line 1305
    new-instance v6, Ljava/lang/Thread;

    new-instance v0, Lcom/prime31/util/IabHelperImpl$3;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/prime31/util/IabHelperImpl$3;-><init>(Lcom/prime31/util/IabHelperImpl;Ljava/util/List;Lcom/prime31/util/IabHelperImpl$OnConsumeFinishedListener;Landroid/os/Handler;Lcom/prime31/util/IabHelperImpl$OnConsumeMultiFinishedListener;)V

    invoke-direct {v6, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 1345
    invoke-virtual {v6}, Ljava/lang/Thread;->start()V

    .line 1346
    return-void
.end method

.method public dispose()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 355
    iget-object v1, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgressLock:Ljava/lang/Object;

    monitor-enter v1

    .line 357
    :try_start_0
    iget-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgress:Z

    if-eqz v0, :cond_0

    .line 359
    new-instance v0, Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Can\'t dispose because an async operation ("

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncOperation:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") is in progress."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 355
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 362
    const-string v0, "Disposing."

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 363
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mSetupDone:Z

    .line 364
    iget-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mServiceConn:Landroid/content/ServiceConnection;

    if-eqz v0, :cond_1

    .line 366
    const-string v0, "Unbinding from service."

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 367
    iget-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    if-eqz v0, :cond_1

    .line 368
    iget-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/prime31/util/IabHelperImpl;->mServiceConn:Landroid/content/ServiceConnection;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    .line 370
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mDisposed:Z

    .line 371
    iput-object v2, p0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    .line 372
    iput-object v2, p0, Lcom/prime31/util/IabHelperImpl;->mServiceConn:Landroid/content/ServiceConnection;

    .line 373
    iput-object v2, p0, Lcom/prime31/util/IabHelperImpl;->mService:Lcom/android/vending/billing/IInAppBillingService;

    .line 374
    iput-object v2, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    .line 375
    return-void
.end method

.method public disposeWhenFinished()V
    .locals 2

    .prologue
    .line 385
    iget-object v1, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgressLock:Ljava/lang/Object;

    monitor-enter v1

    .line 387
    :try_start_0
    iget-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgress:Z

    if-eqz v0, :cond_0

    .line 389
    const-string v0, "Will dispose after async operation finishes."

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 390
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mDisposeAfterAsync:Z

    .line 385
    :goto_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 406
    return-void

    .line 396
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lcom/prime31/util/IabHelperImpl;->dispose()V
    :try_end_1
    .catch Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 398
    :catch_0
    move-exception v0

    goto :goto_0

    .line 385
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0
.end method

.method public enableDebugLogging(Z)V
    .locals 0
    .param p1, "enable"    # Z

    .prologue
    .line 194
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 195
    iput-boolean p1, p0, Lcom/prime31/util/IabHelperImpl;->mDebugLog:Z

    .line 196
    return-void
.end method

.method public enableDebugLogging(ZLjava/lang/String;)V
    .locals 0
    .param p1, "enable"    # Z
    .param p2, "tag"    # Ljava/lang/String;

    .prologue
    .line 186
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 187
    iput-boolean p1, p0, Lcom/prime31/util/IabHelperImpl;->mDebugLog:Z

    .line 188
    iput-object p2, p0, Lcom/prime31/util/IabHelperImpl;->mDebugTag:Ljava/lang/String;

    .line 189
    return-void
.end method

.method flagEndAsync()V
    .locals 3

    .prologue
    .line 1102
    iget-object v1, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgressLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1104
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "Ending async operation: "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncOperation:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1105
    const-string v0, ""

    iput-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncOperation:Ljava/lang/String;

    .line 1106
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgress:Z

    .line 1107
    iget-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mDisposeAfterAsync:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 1111
    :try_start_1
    invoke-virtual {p0}, Lcom/prime31/util/IabHelperImpl;->dispose()V
    :try_end_1
    .catch Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1102
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v1

    .line 1121
    return-void

    .line 1102
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 1113
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method flagStartAsync(Ljava/lang/String;)V
    .locals 4
    .param p1, "operation"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    .line 1087
    iget-object v1, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgressLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1089
    :try_start_0
    iget-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgress:Z

    if-eqz v0, :cond_0

    .line 1091
    new-instance v0, Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Can\'t start async operation ("

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") because another async operation ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncOperation:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") is in progress."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1087
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 1093
    :cond_0
    :try_start_1
    iput-object p1, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncOperation:Ljava/lang/String;

    .line 1094
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mAsyncInProgress:Z

    .line 1095
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "Starting async operation: "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1087
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1097
    return-void
.end method

.method getResponseCodeFromBundle(Landroid/os/Bundle;)I
    .locals 4
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    .line 1043
    const-string v1, "RESPONSE_CODE"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 1044
    .local v0, "o":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 1046
    const-string v1, "Bundle with null response code, assuming OK (known issue)"

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1047
    const/4 v1, 0x0

    .line 1052
    .end local v0    # "o":Ljava/lang/Object;
    :goto_0
    return v1

    .line 1049
    .restart local v0    # "o":Ljava/lang/Object;
    :cond_0
    instance-of v1, v0, Ljava/lang/Integer;

    if-eqz v1, :cond_1

    .line 1050
    check-cast v0, Ljava/lang/Integer;

    .end local v0    # "o":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_0

    .line 1051
    .restart local v0    # "o":Ljava/lang/Object;
    :cond_1
    instance-of v1, v0, Ljava/lang/Long;

    if-eqz v1, :cond_2

    .line 1052
    check-cast v0, Ljava/lang/Long;

    .end local v0    # "o":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    long-to-int v1, v2

    goto :goto_0

    .line 1055
    .restart local v0    # "o":Ljava/lang/Object;
    :cond_2
    const-string v1, "Unexpected type for bundle response code."

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 1056
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 1057
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unexpected type for bundle response code: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method getResponseCodeFromIntent(Landroid/content/Intent;)I
    .locals 4
    .param p1, "i"    # Landroid/content/Intent;

    .prologue
    .line 1066
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "RESPONSE_CODE"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 1067
    .local v0, "o":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 1069
    const-string v1, "Intent with no response code, assuming OK (known issue)"

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 1070
    const/4 v1, 0x0

    .line 1075
    .end local v0    # "o":Ljava/lang/Object;
    :goto_0
    return v1

    .line 1072
    .restart local v0    # "o":Ljava/lang/Object;
    :cond_0
    instance-of v1, v0, Ljava/lang/Integer;

    if-eqz v1, :cond_1

    .line 1073
    check-cast v0, Ljava/lang/Integer;

    .end local v0    # "o":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_0

    .line 1074
    .restart local v0    # "o":Ljava/lang/Object;
    :cond_1
    instance-of v1, v0, Ljava/lang/Long;

    if-eqz v1, :cond_2

    .line 1075
    check-cast v0, Ljava/lang/Long;

    .end local v0    # "o":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    long-to-int v1, v2

    goto :goto_0

    .line 1078
    .restart local v0    # "o":Ljava/lang/Object;
    :cond_2
    const-string v1, "Unexpected type for intent response code."

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 1079
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 1080
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unexpected type for intent response code: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public handleActivityResult(IILandroid/content/Intent;)Z
    .locals 12
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 613
    iget v8, p0, Lcom/prime31/util/IabHelperImpl;->mRequestCode:I

    if-eq p1, v8, :cond_0

    .line 614
    const/4 v8, 0x0

    .line 712
    :goto_0
    return v8

    .line 616
    :cond_0
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 617
    const-string v8, "handleActivityResult"

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->checkSetupDone(Ljava/lang/String;)V

    .line 620
    invoke-virtual {p0}, Lcom/prime31/util/IabHelperImpl;->flagEndAsync()V

    .line 622
    if-nez p3, :cond_2

    .line 624
    const-string v8, "Null data in IAB activity result."

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 625
    new-instance v6, Lcom/prime31/util/IabResult;

    const/16 v8, -0x3ea

    const-string v9, "Null data in IAB result"

    invoke-direct {v6, v8, v9}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 626
    .local v6, "result":Lcom/prime31/util/IabResult;
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    if-eqz v8, :cond_1

    .line 627
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    const/4 v9, 0x0

    invoke-interface {v8, v6, v9}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    .line 628
    :cond_1
    const/4 v8, 0x1

    goto :goto_0

    .line 631
    .end local v6    # "result":Lcom/prime31/util/IabResult;
    :cond_2
    invoke-virtual {p0, p3}, Lcom/prime31/util/IabHelperImpl;->getResponseCodeFromIntent(Landroid/content/Intent;)I

    move-result v5

    .line 632
    .local v5, "responseCode":I
    const-string v8, "INAPP_PURCHASE_DATA"

    invoke-virtual {p3, v8}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 633
    .local v4, "purchaseData":Ljava/lang/String;
    const-string v8, "INAPP_DATA_SIGNATURE"

    invoke-virtual {p3, v8}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 635
    .local v0, "dataSignature":Ljava/lang/String;
    const/4 v8, -0x1

    if-ne p2, v8, :cond_b

    if-nez v5, :cond_b

    .line 637
    const-string v8, "Successful resultcode from purchase activity."

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 638
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Purchase data: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 639
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Data signature: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 640
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Extras: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 641
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Expected item type: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/prime31/util/IabHelperImpl;->mPurchasingItemType:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 643
    if-eqz v4, :cond_3

    if-nez v0, :cond_5

    .line 645
    :cond_3
    const-string v8, "BUG: either purchaseData or dataSignature is null."

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 646
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Extras: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v9

    invoke-virtual {v9}, Landroid/os/Bundle;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 647
    new-instance v6, Lcom/prime31/util/IabResult;

    const/16 v8, -0x3f0

    const-string v9, "IAB returned null purchaseData or dataSignature"

    invoke-direct {v6, v8, v9}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 648
    .restart local v6    # "result":Lcom/prime31/util/IabResult;
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    if-eqz v8, :cond_4

    .line 649
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    const/4 v9, 0x0

    invoke-interface {v8, v6, v9}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    .line 650
    :cond_4
    const/4 v8, 0x1

    goto/16 :goto_0

    .line 653
    .end local v6    # "result":Lcom/prime31/util/IabResult;
    :cond_5
    const/4 v2, 0x0

    .line 656
    .local v2, "purchase":Lcom/prime31/util/Purchase;
    :try_start_0
    new-instance v3, Lcom/prime31/util/Purchase;

    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchasingItemType:Ljava/lang/String;

    invoke-direct {v3, v8, v4, v0}, Lcom/prime31/util/Purchase;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 657
    .end local v2    # "purchase":Lcom/prime31/util/Purchase;
    .local v3, "purchase":Lcom/prime31/util/Purchase;
    :try_start_1
    invoke-virtual {v3}, Lcom/prime31/util/Purchase;->getSku()Ljava/lang/String;

    move-result-object v7

    .line 659
    .local v7, "sku":Ljava/lang/String;
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    if-eqz v8, :cond_6

    .line 660
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    invoke-interface {v8, v4, v0}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseCompleteAwaitingVerification(Ljava/lang/String;Ljava/lang/String;)V

    .line 663
    :cond_6
    sget-boolean v8, Lcom/prime31/util/IabHelperImpl;->autoVerifySignatures:Z

    if-eqz v8, :cond_8

    invoke-virtual {v3}, Lcom/prime31/util/Purchase;->isTestSku()Z

    move-result v8

    if-nez v8, :cond_8

    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mSignatureBase64:Ljava/lang/String;

    invoke-static {v8, v4, v0}, Lcom/prime31/util/Security;->verifyPurchase(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_8

    .line 665
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Purchase signature verification FAILED for sku "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 666
    new-instance v6, Lcom/prime31/util/IabResult;

    const/16 v8, -0x3eb

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "Signature verification failed for sku "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v6, v8, v9}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 667
    .restart local v6    # "result":Lcom/prime31/util/IabResult;
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    if-eqz v8, :cond_7

    .line 668
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    invoke-interface {v8, v6, v3}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    .line 669
    :cond_7
    const/4 v8, 0x1

    goto/16 :goto_0

    .line 671
    .end local v6    # "result":Lcom/prime31/util/IabResult;
    :cond_8
    const-string v8, "Purchase signature successfully verified."

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 683
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    if-eqz v8, :cond_9

    .line 685
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    new-instance v9, Lcom/prime31/util/IabResult;

    const/4 v10, 0x0

    const-string v11, "Success"

    invoke-direct {v9, v10, v11}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    invoke-interface {v8, v9, v3}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    .line 712
    .end local v3    # "purchase":Lcom/prime31/util/Purchase;
    .end local v7    # "sku":Ljava/lang/String;
    :cond_9
    :goto_1
    const/4 v8, 0x1

    goto/16 :goto_0

    .line 673
    .restart local v2    # "purchase":Lcom/prime31/util/Purchase;
    :catch_0
    move-exception v1

    .line 675
    .local v1, "e":Lorg/json/JSONException;
    :goto_2
    const-string v8, "Failed to parse purchase data."

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 676
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    .line 677
    new-instance v6, Lcom/prime31/util/IabResult;

    const/16 v8, -0x3ea

    const-string v9, "Failed to parse purchase data."

    invoke-direct {v6, v8, v9}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 678
    .restart local v6    # "result":Lcom/prime31/util/IabResult;
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    if-eqz v8, :cond_a

    .line 679
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    const/4 v9, 0x0

    invoke-interface {v8, v6, v9}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    .line 680
    :cond_a
    const/4 v8, 0x1

    goto/16 :goto_0

    .line 688
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v2    # "purchase":Lcom/prime31/util/Purchase;
    .end local v6    # "result":Lcom/prime31/util/IabResult;
    :cond_b
    const/4 v8, -0x1

    if-ne p2, v8, :cond_c

    .line 691
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Result code was OK but in-app billing response was not OK: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v5}, Lcom/prime31/util/IabHelperImpl;->getResponseDesc(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 692
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    if-eqz v8, :cond_9

    .line 694
    new-instance v6, Lcom/prime31/util/IabResult;

    const-string v8, "Problem purchashing item."

    invoke-direct {v6, v5, v8}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 695
    .restart local v6    # "result":Lcom/prime31/util/IabResult;
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    const/4 v9, 0x0

    invoke-interface {v8, v6, v9}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    goto :goto_1

    .line 698
    .end local v6    # "result":Lcom/prime31/util/IabResult;
    :cond_c
    if-nez p2, :cond_d

    .line 700
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Purchase canceled - Response: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v5}, Lcom/prime31/util/IabHelperImpl;->getResponseDesc(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 701
    new-instance v6, Lcom/prime31/util/IabResult;

    const/16 v8, -0x3ed

    const-string v9, "User canceled."

    invoke-direct {v6, v8, v9}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 702
    .restart local v6    # "result":Lcom/prime31/util/IabResult;
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    if-eqz v8, :cond_9

    .line 703
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    const/4 v9, 0x0

    invoke-interface {v8, v6, v9}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    goto :goto_1

    .line 707
    .end local v6    # "result":Lcom/prime31/util/IabResult;
    :cond_d
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Purchase failed. Result code: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ". Response: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-static {v5}, Lcom/prime31/util/IabHelperImpl;->getResponseDesc(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 708
    new-instance v6, Lcom/prime31/util/IabResult;

    const/16 v8, -0x3ee

    const-string v9, "Unknown purchase response."

    invoke-direct {v6, v8, v9}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 709
    .restart local v6    # "result":Lcom/prime31/util/IabResult;
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    if-eqz v8, :cond_9

    .line 710
    iget-object v8, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    const/4 v9, 0x0

    invoke-interface {v8, v6, v9}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    goto/16 :goto_1

    .line 673
    .end local v6    # "result":Lcom/prime31/util/IabResult;
    .restart local v3    # "purchase":Lcom/prime31/util/Purchase;
    :catch_1
    move-exception v1

    move-object v2, v3

    .end local v3    # "purchase":Lcom/prime31/util/Purchase;
    .restart local v2    # "purchase":Lcom/prime31/util/Purchase;
    goto/16 :goto_2
.end method

.method public launchPurchaseFlow(Landroid/app/Activity;Ljava/lang/String;ILcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;)V
    .locals 6
    .param p1, "act"    # Landroid/app/Activity;
    .param p2, "sku"    # Ljava/lang/String;
    .param p3, "requestCode"    # I
    .param p4, "listener"    # Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    .line 460
    const-string v5, ""

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/prime31/util/IabHelperImpl;->launchPurchaseFlow(Landroid/app/Activity;Ljava/lang/String;ILcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;Ljava/lang/String;)V

    .line 461
    return-void
.end method

.method public launchPurchaseFlow(Landroid/app/Activity;Ljava/lang/String;ILcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;Ljava/lang/String;)V
    .locals 8
    .param p1, "act"    # Landroid/app/Activity;
    .param p2, "sku"    # Ljava/lang/String;
    .param p3, "requestCode"    # I
    .param p4, "listener"    # Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;
    .param p5, "extraData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    .line 466
    const-string v3, "inapp"

    const/4 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v5, p3

    move-object v6, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Lcom/prime31/util/IabHelperImpl;->launchPurchaseFlow(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;Ljava/lang/String;)Z

    .line 467
    return-void
.end method

.method public launchPurchaseFlow(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;Ljava/lang/String;)Z
    .locals 14
    .param p1, "act"    # Landroid/app/Activity;
    .param p2, "sku"    # Ljava/lang/String;
    .param p3, "itemType"    # Ljava/lang/String;
    .param p5, "requestCode"    # I
    .param p6, "listener"    # Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;
    .param p7, "extraData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;I",
            "Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    .line 515
    .local p4, "oldSkus":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 516
    const-string v1, "launchPurchaseFlow"

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->checkSetupDone(Ljava/lang/String;)V

    .line 517
    const-string v1, "launchPurchaseFlow"

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->flagStartAsync(Ljava/lang/String;)V

    .line 520
    const-string v1, "subs"

    move-object/from16 v0, p3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-boolean v1, p0, Lcom/prime31/util/IabHelperImpl;->mSubscriptionsSupported:Z

    if-nez v1, :cond_1

    .line 522
    new-instance v11, Lcom/prime31/util/IabResult;

    const/16 v1, -0x3f1

    const-string v2, "Subscriptions are not available."

    invoke-direct {v11, v1, v2}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 523
    .local v11, "r":Lcom/prime31/util/IabResult;
    invoke-virtual {p0}, Lcom/prime31/util/IabHelperImpl;->flagEndAsync()V

    .line 524
    if-eqz p6, :cond_0

    .line 525
    const/4 v1, 0x0

    move-object/from16 v0, p6

    invoke-interface {v0, v11, v1}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    .line 526
    :cond_0
    const/4 v1, 0x0

    .line 589
    .end local v11    # "r":Lcom/prime31/util/IabResult;
    :goto_0
    return v1

    .line 531
    :cond_1
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Constructing buy intent for "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", item type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p3

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 533
    if-eqz p4, :cond_2

    invoke-interface/range {p4 .. p4}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 536
    :cond_2
    iget-object v1, p0, Lcom/prime31/util/IabHelperImpl;->mService:Lcom/android/vending/billing/IInAppBillingService;

    const/4 v2, 0x3

    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move-object/from16 v6, p7

    invoke-interface/range {v1 .. v6}, Lcom/android/vending/billing/IInAppBillingService;->getBuyIntent(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v8

    .line 551
    .local v8, "buyIntentBundle":Landroid/os/Bundle;
    :goto_1
    invoke-virtual {p0, v8}, Lcom/prime31/util/IabHelperImpl;->getResponseCodeFromBundle(Landroid/os/Bundle;)I

    move-result v12

    .line 552
    .local v12, "response":I
    if-eqz v12, :cond_7

    .line 554
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unable to buy item, Error response: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v12}, Lcom/prime31/util/IabHelperImpl;->getResponseDesc(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 555
    invoke-virtual {p0}, Lcom/prime31/util/IabHelperImpl;->flagEndAsync()V

    .line 556
    new-instance v13, Lcom/prime31/util/IabResult;

    const-string v1, "Unable to buy item"

    invoke-direct {v13, v12, v1}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 557
    .local v13, "result":Lcom/prime31/util/IabResult;
    if-eqz p6, :cond_3

    .line 558
    const/4 v1, 0x0

    move-object/from16 v0, p6

    invoke-interface {v0, v13, v1}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    .line 559
    :cond_3
    const/4 v1, 0x0

    goto :goto_0

    .line 541
    .end local v8    # "buyIntentBundle":Landroid/os/Bundle;
    .end local v12    # "response":I
    .end local v13    # "result":Lcom/prime31/util/IabResult;
    :cond_4
    iget-boolean v1, p0, Lcom/prime31/util/IabHelperImpl;->mSubscriptionUpdateSupported:Z

    if-nez v1, :cond_6

    .line 543
    new-instance v11, Lcom/prime31/util/IabResult;

    const/16 v1, -0x3f3

    const-string v2, "Subscription updates are not available."

    invoke-direct {v11, v1, v2}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 544
    .restart local v11    # "r":Lcom/prime31/util/IabResult;
    invoke-virtual {p0}, Lcom/prime31/util/IabHelperImpl;->flagEndAsync()V

    .line 545
    if-eqz p6, :cond_5

    .line 546
    const/4 v1, 0x0

    move-object/from16 v0, p6

    invoke-interface {v0, v11, v1}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    .line 547
    :cond_5
    const/4 v1, 0x0

    goto/16 :goto_0

    .line 549
    .end local v11    # "r":Lcom/prime31/util/IabResult;
    :cond_6
    iget-object v1, p0, Lcom/prime31/util/IabHelperImpl;->mService:Lcom/android/vending/billing/IInAppBillingService;

    const/4 v2, 0x5

    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v4, p4

    move-object/from16 v5, p2

    move-object/from16 v6, p3

    move-object/from16 v7, p7

    invoke-interface/range {v1 .. v7}, Lcom/android/vending/billing/IInAppBillingService;->getBuyIntentToReplaceSkus(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v8

    .restart local v8    # "buyIntentBundle":Landroid/os/Bundle;
    goto :goto_1

    .line 562
    .restart local v12    # "response":I
    :cond_7
    const-string v1, "BUY_INTENT"

    invoke-virtual {v8, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v10

    check-cast v10, Landroid/app/PendingIntent;

    .line 563
    .local v10, "pendingIntent":Landroid/app/PendingIntent;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Launching buy intent for "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ". Request code: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move/from16 v0, p5

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 564
    move/from16 v0, p5

    iput v0, p0, Lcom/prime31/util/IabHelperImpl;->mRequestCode:I

    .line 565
    move-object/from16 v0, p6

    iput-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mPurchaseListener:Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;

    .line 566
    move-object/from16 v0, p3

    iput-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mPurchasingItemType:Ljava/lang/String;

    .line 567
    invoke-virtual {v10}, Landroid/app/PendingIntent;->getIntentSender()Landroid/content/IntentSender;

    move-result-object v2

    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4}, Landroid/content/Intent;-><init>()V

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v5

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v6

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v7

    move-object v1, p1

    move/from16 v3, p5

    invoke-virtual/range {v1 .. v7}, Landroid/app/Activity;->startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;III)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_1

    .line 589
    .end local v8    # "buyIntentBundle":Landroid/os/Bundle;
    .end local v10    # "pendingIntent":Landroid/app/PendingIntent;
    .end local v12    # "response":I
    :cond_8
    :goto_2
    const/4 v1, 0x1

    goto/16 :goto_0

    .line 569
    :catch_0
    move-exception v9

    .line 571
    .local v9, "e":Landroid/content/IntentSender$SendIntentException;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "SendIntentException while launching purchase flow for sku "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 572
    invoke-virtual {v9}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    .line 573
    invoke-virtual {p0}, Lcom/prime31/util/IabHelperImpl;->flagEndAsync()V

    .line 575
    new-instance v13, Lcom/prime31/util/IabResult;

    const/16 v1, -0x3ec

    const-string v2, "Failed to send intent."

    invoke-direct {v13, v1, v2}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 576
    .restart local v13    # "result":Lcom/prime31/util/IabResult;
    if-eqz p6, :cond_8

    .line 577
    const/4 v1, 0x0

    move-object/from16 v0, p6

    invoke-interface {v0, v13, v1}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    goto :goto_2

    .line 579
    .end local v9    # "e":Landroid/content/IntentSender$SendIntentException;
    .end local v13    # "result":Lcom/prime31/util/IabResult;
    :catch_1
    move-exception v9

    .line 581
    .local v9, "e":Landroid/os/RemoteException;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "RemoteException while launching purchase flow for sku "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 582
    invoke-virtual {v9}, Landroid/os/RemoteException;->printStackTrace()V

    .line 583
    invoke-virtual {p0}, Lcom/prime31/util/IabHelperImpl;->flagEndAsync()V

    .line 585
    new-instance v13, Lcom/prime31/util/IabResult;

    const/16 v1, -0x3e9

    const-string v2, "Remote exception while starting purchase flow"

    invoke-direct {v13, v1, v2}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    .line 586
    .restart local v13    # "result":Lcom/prime31/util/IabResult;
    if-eqz p6, :cond_8

    .line 587
    const/4 v1, 0x0

    move-object/from16 v0, p6

    invoke-interface {v0, v13, v1}, Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;->onIabPurchaseFinished(Lcom/prime31/util/IabResult;Lcom/prime31/util/Purchase;)V

    goto :goto_2
.end method

.method public launchSubscriptionPurchaseFlow(Landroid/app/Activity;Ljava/lang/String;ILcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;)V
    .locals 6
    .param p1, "act"    # Landroid/app/Activity;
    .param p2, "sku"    # Ljava/lang/String;
    .param p3, "requestCode"    # I
    .param p4, "listener"    # Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    .line 472
    const-string v5, ""

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/prime31/util/IabHelperImpl;->launchSubscriptionPurchaseFlow(Landroid/app/Activity;Ljava/lang/String;ILcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;Ljava/lang/String;)V

    .line 473
    return-void
.end method

.method public launchSubscriptionPurchaseFlow(Landroid/app/Activity;Ljava/lang/String;ILcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;Ljava/lang/String;)V
    .locals 8
    .param p1, "act"    # Landroid/app/Activity;
    .param p2, "sku"    # Ljava/lang/String;
    .param p3, "requestCode"    # I
    .param p4, "listener"    # Lcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;
    .param p5, "extraData"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    .line 478
    const-string v3, "subs"

    const/4 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v5, p3

    move-object v6, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Lcom/prime31/util/IabHelperImpl;->launchPurchaseFlow(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILcom/prime31/util/IabHelperImpl$OnIabPurchaseFinishedListener;Ljava/lang/String;)Z

    .line 479
    return-void
.end method

.method logDebug(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 1351
    iget-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mDebugLog:Z

    if-eqz v0, :cond_0

    .line 1352
    iget-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mDebugTag:Ljava/lang/String;

    invoke-static {v0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1353
    :cond_0
    return-void
.end method

.method logError(Ljava/lang/String;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 1358
    iget-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mDebugTag:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "In-app billing error: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1359
    return-void
.end method

.method logWarn(Ljava/lang/String;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 1364
    iget-object v0, p0, Lcom/prime31/util/IabHelperImpl;->mDebugTag:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "In-app billing warning: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1365
    return-void
.end method

.method public queryInventory()Lcom/prime31/util/Inventory;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 718
    const/4 v0, 0x0

    invoke-virtual {p0, v0, v1, v1}, Lcom/prime31/util/IabHelperImpl;->queryInventory(ZLjava/util/List;Ljava/util/List;)Lcom/prime31/util/Inventory;

    move-result-object v0

    return-object v0
.end method

.method public queryInventory(ZLjava/util/List;Ljava/util/List;)Lcom/prime31/util/Inventory;
    .locals 6
    .param p1, "querySkuDetails"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/prime31/util/Inventory;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabException;
        }
    .end annotation

    .prologue
    .line 743
    .local p2, "moreItemSkus":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p3, "moreSubsSkus":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 744
    const-string v3, "queryInventory"

    invoke-virtual {p0, v3}, Lcom/prime31/util/IabHelperImpl;->checkSetupDone(Ljava/lang/String;)V

    .line 747
    :try_start_0
    new-instance v1, Lcom/prime31/util/Inventory;

    invoke-direct {v1}, Lcom/prime31/util/Inventory;-><init>()V

    .line 748
    .local v1, "inv":Lcom/prime31/util/Inventory;
    const-string v3, "inapp"

    invoke-virtual {p0, v1, v3}, Lcom/prime31/util/IabHelperImpl;->queryPurchases(Lcom/prime31/util/Inventory;Ljava/lang/String;)I

    move-result v2

    .line 749
    .local v2, "r":I
    if-eqz v2, :cond_0

    .line 751
    new-instance v3, Lcom/prime31/util/IabException;

    const-string v4, "Error refreshing inventory (querying owned items)."

    invoke-direct {v3, v2, v4}, Lcom/prime31/util/IabException;-><init>(ILjava/lang/String;)V

    throw v3
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 784
    .end local v1    # "inv":Lcom/prime31/util/Inventory;
    .end local v2    # "r":I
    :catch_0
    move-exception v0

    .line 786
    .local v0, "e":Landroid/os/RemoteException;
    new-instance v3, Lcom/prime31/util/IabException;

    const/16 v4, -0x3e9

    const-string v5, "Remote exception while refreshing inventory."

    invoke-direct {v3, v4, v5, v0}, Lcom/prime31/util/IabException;-><init>(ILjava/lang/String;Ljava/lang/Exception;)V

    throw v3

    .line 754
    .end local v0    # "e":Landroid/os/RemoteException;
    .restart local v1    # "inv":Lcom/prime31/util/Inventory;
    .restart local v2    # "r":I
    :cond_0
    if-eqz p1, :cond_1

    .line 756
    :try_start_1
    const-string v3, "inapp"

    invoke-virtual {p0, v3, v1, p2}, Lcom/prime31/util/IabHelperImpl;->querySkuDetails(Ljava/lang/String;Lcom/prime31/util/Inventory;Ljava/util/List;)I

    move-result v2

    .line 757
    if-eqz v2, :cond_1

    .line 759
    new-instance v3, Lcom/prime31/util/IabException;

    const-string v4, "Error refreshing inventory (querying prices of items)."

    invoke-direct {v3, v2, v4}, Lcom/prime31/util/IabException;-><init>(ILjava/lang/String;)V

    throw v3
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 788
    .end local v1    # "inv":Lcom/prime31/util/Inventory;
    .end local v2    # "r":I
    :catch_1
    move-exception v0

    .line 790
    .local v0, "e":Lorg/json/JSONException;
    new-instance v3, Lcom/prime31/util/IabException;

    const/16 v4, -0x3ea

    const-string v5, "Error parsing JSON response while refreshing inventory."

    invoke-direct {v3, v4, v5, v0}, Lcom/prime31/util/IabException;-><init>(ILjava/lang/String;Ljava/lang/Exception;)V

    throw v3

    .line 764
    .end local v0    # "e":Lorg/json/JSONException;
    .restart local v1    # "inv":Lcom/prime31/util/Inventory;
    .restart local v2    # "r":I
    :cond_1
    :try_start_2
    iget-boolean v3, p0, Lcom/prime31/util/IabHelperImpl;->mSubscriptionsSupported:Z

    if-eqz v3, :cond_3

    .line 766
    const-string v3, "subs"

    invoke-virtual {p0, v1, v3}, Lcom/prime31/util/IabHelperImpl;->queryPurchases(Lcom/prime31/util/Inventory;Ljava/lang/String;)I

    move-result v2

    .line 767
    if-eqz v2, :cond_2

    .line 769
    new-instance v3, Lcom/prime31/util/IabException;

    const-string v4, "Error refreshing inventory (querying owned subscriptions)."

    invoke-direct {v3, v2, v4}, Lcom/prime31/util/IabException;-><init>(ILjava/lang/String;)V

    throw v3

    .line 772
    :cond_2
    if-eqz p1, :cond_3

    .line 774
    const-string v3, "subs"

    invoke-virtual {p0, v3, v1, p3}, Lcom/prime31/util/IabHelperImpl;->querySkuDetails(Ljava/lang/String;Lcom/prime31/util/Inventory;Ljava/util/List;)I

    move-result v2

    .line 775
    if-eqz v2, :cond_3

    .line 777
    new-instance v3, Lcom/prime31/util/IabException;

    const-string v4, "Error refreshing inventory (querying prices of subscriptions)."

    invoke-direct {v3, v2, v4}, Lcom/prime31/util/IabException;-><init>(ILjava/lang/String;)V

    throw v3
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    .line 782
    :cond_3
    return-object v1
.end method

.method public queryInventoryAsync(Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 869
    const/4 v0, 0x0

    invoke-virtual {p0, v0, v1, v1, p1}, Lcom/prime31/util/IabHelperImpl;->queryInventoryAsync(ZLjava/util/List;Ljava/util/List;Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;)V

    .line 870
    return-void
.end method

.method public queryInventoryAsync(ZLjava/util/List;Ljava/util/List;Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;)V
    .locals 8
    .param p1, "querySkuDetails"    # Z
    .param p4, "listener"    # Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/prime31/util/IabHelperImpl$IabAsyncInProgressException;
        }
    .end annotation

    .prologue
    .line 829
    .local p2, "moreItemSkus":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p3, "moreSubsSkus":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v6, Landroid/os/Handler;

    invoke-direct {v6}, Landroid/os/Handler;-><init>()V

    .line 830
    .local v6, "handler":Landroid/os/Handler;
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 831
    const-string v0, "queryInventory"

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->checkSetupDone(Ljava/lang/String;)V

    .line 832
    const-string v0, "refresh inventory"

    invoke-virtual {p0, v0}, Lcom/prime31/util/IabHelperImpl;->flagStartAsync(Ljava/lang/String;)V

    .line 833
    new-instance v7, Ljava/lang/Thread;

    new-instance v0, Lcom/prime31/util/IabHelperImpl$2;

    move-object v1, p0

    move v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v6}, Lcom/prime31/util/IabHelperImpl$2;-><init>(Lcom/prime31/util/IabHelperImpl;ZLjava/util/List;Ljava/util/List;Lcom/prime31/util/IabHelperImpl$QueryInventoryFinishedListener;Landroid/os/Handler;)V

    invoke-direct {v7, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 863
    invoke-virtual {v7}, Ljava/lang/Thread;->start()V

    .line 864
    return-void
.end method

.method queryPurchases(Lcom/prime31/util/Inventory;Ljava/lang/String;)I
    .locals 20
    .param p1, "inv"    # Lcom/prime31/util/Inventory;
    .param p2, "itemType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 1140
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Querying owned items, item type: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1141
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Package name: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1142
    const/16 v16, 0x0

    .line 1143
    .local v16, "verificationFailed":Z
    const/4 v4, 0x0

    .line 1147
    .local v4, "continueToken":Ljava/lang/String;
    :cond_0
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Calling getPurchases with continuation token: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1148
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/prime31/util/IabHelperImpl;->mService:Lcom/android/vending/billing/IInAppBillingService;

    move-object/from16 v17, v0

    const/16 v18, 0x3

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v17

    move/from16 v1, v18

    move-object/from16 v2, v19

    move-object/from16 v3, p2

    invoke-interface {v0, v1, v2, v3, v4}, Lcom/android/vending/billing/IInAppBillingService;->getPurchases(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v6

    .line 1150
    .local v6, "ownedItems":Landroid/os/Bundle;
    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lcom/prime31/util/IabHelperImpl;->getResponseCodeFromBundle(Landroid/os/Bundle;)I

    move-result v12

    .line 1151
    .local v12, "response":I
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Owned items response: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v12}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1152
    if-eqz v12, :cond_1

    .line 1154
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "getPurchases() failed: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v12}, Lcom/prime31/util/IabHelperImpl;->getResponseDesc(I)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1216
    .end local v12    # "response":I
    :goto_0
    return v12

    .line 1157
    .restart local v12    # "response":I
    :cond_1
    const-string v17, "INAPP_PURCHASE_ITEM_LIST"

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_2

    const-string v17, "INAPP_PURCHASE_DATA_LIST"

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_2

    const-string v17, "INAPP_DATA_SIGNATURE_LIST"

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v17

    if-nez v17, :cond_3

    .line 1159
    :cond_2
    const-string v17, "Bundle returned from getPurchases() doesn\'t contain required fields."

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 1160
    const/16 v12, -0x3ea

    goto :goto_0

    .line 1163
    :cond_3
    const-string v17, "INAPP_PURCHASE_ITEM_LIST"

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v7

    .line 1164
    .local v7, "ownedSkus":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v17, "INAPP_PURCHASE_DATA_LIST"

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v10

    .line 1165
    .local v10, "purchaseDataList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v17, "INAPP_DATA_SIGNATURE_LIST"

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v14

    .line 1167
    .local v14, "signatureList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_1
    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v17

    move/from16 v0, v17

    if-lt v5, v0, :cond_4

    .line 1211
    const-string v17, "INAPP_CONTINUATION_TOKEN"

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1212
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Continuation token: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1214
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-eqz v17, :cond_0

    .line 1216
    if-eqz v16, :cond_9

    const/16 v17, -0x3eb

    :goto_2
    move/from16 v12, v17

    goto :goto_0

    .line 1169
    :cond_4
    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 1170
    .local v9, "purchaseData":Ljava/lang/String;
    invoke-virtual {v14, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 1171
    .local v13, "signature":Ljava/lang/String;
    invoke-virtual {v7, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 1175
    .local v15, "sku":Ljava/lang/String;
    const/4 v11, 0x1

    .line 1176
    .local v11, "purchaseIsVerified":Z
    sget-boolean v17, Lcom/prime31/util/IabHelperImpl;->autoVerifySignatures:Z

    if-eqz v17, :cond_5

    .line 1178
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "verified sku: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1179
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/prime31/util/IabHelperImpl;->mSignatureBase64:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-static {v0, v9, v13}, Lcom/prime31/util/Security;->verifyPurchase(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v11

    .line 1182
    :cond_5
    new-instance v8, Lcom/prime31/util/Purchase;

    move-object/from16 v0, p2

    invoke-direct {v8, v0, v9, v13}, Lcom/prime31/util/Purchase;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1183
    .local v8, "purchase":Lcom/prime31/util/Purchase;
    invoke-virtual {v8}, Lcom/prime31/util/Purchase;->isTestSku()Z

    move-result v17

    if-eqz v17, :cond_6

    .line 1185
    const/4 v11, 0x1

    .line 1186
    const-string v17, "skipping signature verification because this is a test product"

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1190
    :cond_6
    if-eqz v11, :cond_8

    .line 1192
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Sku is owned: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1193
    invoke-virtual {v8}, Lcom/prime31/util/Purchase;->getToken()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-eqz v17, :cond_7

    .line 1195
    const-string v17, "BUG: empty/null token!"

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logWarn(Ljava/lang/String;)V

    .line 1196
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Purchase data: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1200
    :cond_7
    move-object/from16 v0, p1

    invoke-virtual {v0, v8}, Lcom/prime31/util/Inventory;->addPurchase(Lcom/prime31/util/Purchase;)V

    .line 1167
    :goto_3
    add-int/lit8 v5, v5, 0x1

    goto/16 :goto_1

    .line 1204
    :cond_8
    const-string v17, "Purchase signature verification **FAILED**. Not adding item."

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logWarn(Ljava/lang/String;)V

    .line 1205
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "   Purchase data: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1206
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "   Signature: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1207
    const/16 v16, 0x1

    goto :goto_3

    .line 1216
    .end local v8    # "purchase":Lcom/prime31/util/Purchase;
    .end local v9    # "purchaseData":Ljava/lang/String;
    .end local v11    # "purchaseIsVerified":Z
    .end local v13    # "signature":Ljava/lang/String;
    .end local v15    # "sku":Ljava/lang/String;
    :cond_9
    const/16 v17, 0x0

    goto/16 :goto_2
.end method

.method querySkuDetails(Ljava/lang/String;Lcom/prime31/util/Inventory;Ljava/util/List;)I
    .locals 23
    .param p1, "itemType"    # Ljava/lang/String;
    .param p2, "inv"    # Lcom/prime31/util/Inventory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/prime31/util/Inventory;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;,
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 1222
    .local p3, "moreSkus":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v19, "Querying SKU details."

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1223
    new-instance v15, Ljava/util/ArrayList;

    invoke-direct {v15}, Ljava/util/ArrayList;-><init>()V

    .line 1224
    .local v15, "skuList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    move-object/from16 v0, p2

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Lcom/prime31/util/Inventory;->getAllOwnedSkus(Ljava/lang/String;)Ljava/util/List;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 1225
    if-eqz p3, :cond_1

    .line 1227
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v19

    :cond_0
    :goto_0
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-nez v20, :cond_2

    .line 1236
    :cond_1
    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v19

    if-nez v19, :cond_3

    .line 1238
    const-string v19, "queryPrices: nothing to do because there are no SKUs."

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1239
    const/4 v10, 0x0

    .line 1297
    :goto_1
    return v10

    .line 1227
    :cond_2
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 1229
    .local v13, "sku":Ljava/lang/String;
    invoke-virtual {v15, v13}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v20

    if-nez v20, :cond_0

    .line 1231
    invoke-virtual {v15, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1243
    .end local v13    # "sku":Ljava/lang/String;
    :cond_3
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 1245
    .local v8, "packs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Ljava/lang/String;>;>;"
    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v19

    div-int/lit8 v7, v19, 0x14

    .line 1246
    .local v7, "n":I
    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v19

    rem-int/lit8 v6, v19, 0x14

    .line 1247
    .local v6, "mod":I
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_2
    if-lt v5, v7, :cond_6

    .line 1256
    if-eqz v6, :cond_4

    .line 1258
    new-instance v17, Ljava/util/ArrayList;

    invoke-direct/range {v17 .. v17}, Ljava/util/ArrayList;-><init>()V

    .line 1259
    .local v17, "tempList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    mul-int/lit8 v19, v7, 0x14

    mul-int/lit8 v20, v7, 0x14

    add-int v20, v20, v6

    move/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v15, v0, v1}, Ljava/util/ArrayList;->subList(II)Ljava/util/List;

    move-result-object v19

    invoke-interface/range {v19 .. v19}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v19

    :goto_3
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-nez v20, :cond_8

    .line 1263
    move-object/from16 v0, v17

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1266
    .end local v17    # "tempList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_4
    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v19

    :cond_5
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-nez v20, :cond_9

    .line 1297
    const/4 v10, 0x0

    goto :goto_1

    .line 1249
    :cond_6
    new-instance v17, Ljava/util/ArrayList;

    invoke-direct/range {v17 .. v17}, Ljava/util/ArrayList;-><init>()V

    .line 1250
    .restart local v17    # "tempList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    mul-int/lit8 v19, v5, 0x14

    mul-int/lit8 v20, v5, 0x14

    add-int/lit8 v20, v20, 0x14

    move/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v15, v0, v1}, Ljava/util/ArrayList;->subList(II)Ljava/util/List;

    move-result-object v19

    invoke-interface/range {v19 .. v19}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v19

    :goto_4
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-nez v20, :cond_7

    .line 1254
    move-object/from16 v0, v17

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1247
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 1250
    :cond_7
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 1252
    .local v12, "s":Ljava/lang/String;
    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 1259
    .end local v12    # "s":Ljava/lang/String;
    :cond_8
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 1261
    .restart local v12    # "s":Ljava/lang/String;
    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 1266
    .end local v12    # "s":Ljava/lang/String;
    .end local v17    # "tempList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_9
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/util/ArrayList;

    .line 1268
    .local v16, "skuPartList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v9, Landroid/os/Bundle;

    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    .line 1269
    .local v9, "querySkus":Landroid/os/Bundle;
    const-string v20, "ITEM_ID_LIST"

    move-object/from16 v0, v20

    move-object/from16 v1, v16

    invoke-virtual {v9, v0, v1}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1270
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/prime31/util/IabHelperImpl;->mService:Lcom/android/vending/billing/IInAppBillingService;

    move-object/from16 v20, v0

    const/16 v21, 0x3

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v20

    move/from16 v1, v21

    move-object/from16 v2, v22

    move-object/from16 v3, p1

    invoke-interface {v0, v1, v2, v3, v9}, Lcom/android/vending/billing/IInAppBillingService;->getSkuDetails(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v14

    .line 1272
    .local v14, "skuDetails":Landroid/os/Bundle;
    const-string v20, "DETAILS_LIST"

    move-object/from16 v0, v20

    invoke-virtual {v14, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v20

    if-nez v20, :cond_b

    .line 1274
    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/prime31/util/IabHelperImpl;->getResponseCodeFromBundle(Landroid/os/Bundle;)I

    move-result v10

    .line 1275
    .local v10, "response":I
    if-eqz v10, :cond_a

    .line 1277
    new-instance v19, Ljava/lang/StringBuilder;

    const-string v20, "getSkuDetails() failed: "

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v10}, Lcom/prime31/util/IabHelperImpl;->getResponseDesc(I)Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 1282
    :cond_a
    const-string v19, "getSkuDetails() returned a bundle with neither an error nor a detail list."

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logError(Ljava/lang/String;)V

    .line 1283
    const/16 v10, -0x3ea

    goto/16 :goto_1

    .line 1287
    .end local v10    # "response":I
    :cond_b
    const-string v20, "DETAILS_LIST"

    move-object/from16 v0, v20

    invoke-virtual {v14, v0}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v11

    .line 1289
    .local v11, "responseList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v11}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v20

    :goto_5
    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_5

    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/String;

    .line 1291
    .local v18, "thisResponse":Ljava/lang/String;
    new-instance v4, Lcom/prime31/util/SkuDetails;

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-direct {v4, v0, v1}, Lcom/prime31/util/SkuDetails;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1292
    .local v4, "d":Lcom/prime31/util/SkuDetails;
    new-instance v21, Ljava/lang/StringBuilder;

    const-string v22, "Got sku details: "

    invoke-direct/range {v21 .. v22}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v21

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 1293
    move-object/from16 v0, p2

    invoke-virtual {v0, v4}, Lcom/prime31/util/Inventory;->addSkuDetails(Lcom/prime31/util/SkuDetails;)V

    goto :goto_5
.end method

.method public startSetup(Lcom/prime31/util/IabHelperImpl$OnIabSetupFinishedListener;)V
    .locals 5
    .param p1, "listener"    # Lcom/prime31/util/IabHelperImpl$OnIabSetupFinishedListener;

    .prologue
    .line 226
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 227
    iget-boolean v2, p0, Lcom/prime31/util/IabHelperImpl;->mSetupDone:Z

    if-eqz v2, :cond_0

    .line 228
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "IAB helper is already set up."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 231
    :cond_0
    const-string v2, "Starting in-app billing setup."

    invoke-virtual {p0, v2}, Lcom/prime31/util/IabHelperImpl;->logDebug(Ljava/lang/String;)V

    .line 232
    new-instance v2, Lcom/prime31/util/IabHelperImpl$1;

    invoke-direct {v2, p0, p1}, Lcom/prime31/util/IabHelperImpl$1;-><init>(Lcom/prime31/util/IabHelperImpl;Lcom/prime31/util/IabHelperImpl$OnIabSetupFinishedListener;)V

    iput-object v2, p0, Lcom/prime31/util/IabHelperImpl;->mServiceConn:Landroid/content/ServiceConnection;

    .line 327
    iget-object v2, p0, Lcom/prime31/util/IabHelperImpl;->mDebugTag:Ljava/lang/String;

    const-string v3, "setting Intent package to com.android.vending"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 328
    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.android.vending.billing.InAppBillingService.BIND"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 329
    .local v1, "serviceIntent":Landroid/content/Intent;
    const-string v2, "com.android.vending"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 330
    iget-object v2, p0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 331
    .local v0, "intentServices":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v0, :cond_2

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 334
    iget-object v2, p0, Lcom/prime31/util/IabHelperImpl;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/prime31/util/IabHelperImpl;->mServiceConn:Landroid/content/ServiceConnection;

    const/4 v4, 0x1

    invoke-virtual {v2, v1, v3, v4}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 344
    :cond_1
    :goto_0
    return-void

    .line 339
    :cond_2
    if-eqz p1, :cond_1

    .line 341
    new-instance v2, Lcom/prime31/util/IabResult;

    const/4 v3, 0x3

    const-string v4, "Billing service unavailable on device."

    invoke-direct {v2, v3, v4}, Lcom/prime31/util/IabResult;-><init>(ILjava/lang/String;)V

    invoke-interface {p1, v2}, Lcom/prime31/util/IabHelperImpl$OnIabSetupFinishedListener;->onIabSetupFinished(Lcom/prime31/util/IabResult;)V

    goto :goto_0
.end method

.method public subscriptionsSupported()Z
    .locals 1

    .prologue
    .line 419
    invoke-direct {p0}, Lcom/prime31/util/IabHelperImpl;->checkNotDisposed()V

    .line 420
    iget-boolean v0, p0, Lcom/prime31/util/IabHelperImpl;->mSubscriptionsSupported:Z

    return v0
.end method
