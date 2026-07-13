.class abstract Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;
.super Ljava/lang/Object;
.source "PlayGameService.java"


# static fields
.field public static final ERROR:I = 0x2

.field public static final OK:I = 0x1

.field private static TAG:Ljava/lang/String;


# instance fields
.field protected friends:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lorg/json/JSONObject;",
            ">;"
        }
    .end annotation
.end field

.field protected helper:Lcom/prime31/GameHelper;

.field private listeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;",
            ">;"
        }
    .end annotation
.end field

.field protected mFriendCounter:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 290
    const-string v0, "PlayGameService_Base"

    sput-object v0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/prime31/GameHelper;)V
    .locals 1
    .param p1, "helper"    # Lcom/prime31/GameHelper;

    .prologue
    .line 297
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 294
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->listeners:Ljava/util/List;

    .line 298
    iput-object p1, p0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->helper:Lcom/prime31/GameHelper;

    .line 299
    return-void
.end method


# virtual methods
.method public addListener(Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;)V
    .locals 1
    .param p1, "toAdd"    # Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;

    .prologue
    .line 306
    iget-object v0, p0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->listeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 307
    return-void
.end method

.method abstract createFriendsQuery()V
.end method

.method abstract createFriendsQuery(Ljava/lang/String;)V
.end method

.method protected isSignedIn()Z
    .locals 1

    .prologue
    .line 302
    iget-object v0, p0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v0}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v0}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected loadPeopleComplete()V
    .locals 4

    .prologue
    .line 315
    iget-object v1, p0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->listeners:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;

    .line 316
    .local v0, "listener":Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;
    const/4 v2, 0x1

    iget-object v3, p0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->friends:Ljava/util/ArrayList;

    invoke-interface {v0, v2, v3}, Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;->LoadFriends(ILjava/util/ArrayList;)V

    goto :goto_0

    .line 317
    .end local v0    # "listener":Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;
    :cond_0
    return-void
.end method

.method protected loadPeopleError()V
    .locals 4

    .prologue
    .line 310
    iget-object v1, p0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->listeners:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;

    .line 311
    .local v0, "listener":Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;
    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-interface {v0, v2, v3}, Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;->LoadFriends(ILjava/util/ArrayList;)V

    goto :goto_0

    .line 312
    .end local v0    # "listener":Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;
    :cond_0
    return-void
.end method

.method public quertyFriends()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 321
    sget-object v1, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->TAG:Ljava/lang/String;

    const-string v2, "start friend request"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 322
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->isSignedIn()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 323
    sget-object v1, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->TAG:Ljava/lang/String;

    const-string v2, "is signed in"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 324
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->friends:Ljava/util/ArrayList;

    .line 325
    iput v0, p0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->mFriendCounter:I

    .line 326
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->createFriendsQuery()V

    .line 331
    sget-object v1, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->TAG:Ljava/lang/String;

    const-string v2, "can\'t query friends. No connected clients"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 332
    :goto_0
    return v0

    .line 328
    :cond_0
    sget-object v0, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;->TAG:Ljava/lang/String;

    const-string v1, "querying friends from plus client"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 329
    const/4 v0, 0x1

    goto :goto_0
.end method
