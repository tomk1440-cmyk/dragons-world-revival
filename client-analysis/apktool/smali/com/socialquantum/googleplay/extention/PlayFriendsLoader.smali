.class Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;
.super Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;
.source "PlayGameService.java"

# interfaces
.implements Lcom/google/android/gms/common/api/ResultCallback;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;",
        "Lcom/google/android/gms/common/api/ResultCallback",
        "<",
        "Lcom/google/android/gms/games/Players$LoadPlayersResult;",
        ">;"
    }
.end annotation


# static fields
.field private static TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 441
    const-string v0, "PlayGameService_Play"

    sput-object v0, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/prime31/GameHelper;)V
    .locals 0
    .param p1, "helper"    # Lcom/prime31/GameHelper;

    .prologue
    .line 444
    invoke-direct {p0, p1}, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;-><init>(Lcom/prime31/GameHelper;)V

    .line 445
    return-void
.end method


# virtual methods
.method createFriendsQuery()V
    .locals 4

    .prologue
    .line 512
    sget-object v1, Lcom/google/android/gms/games/Games;->Players:Lcom/google/android/gms/games/Players;

    iget-object v2, p0, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v2}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Lcom/google/android/gms/games/Players;->loadConnectedPlayers(Lcom/google/android/gms/common/api/GoogleApiClient;Z)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v0

    .line 513
    .local v0, "res":Lcom/google/android/gms/common/api/PendingResult;, "Lcom/google/android/gms/common/api/PendingResult<Lcom/google/android/gms/games/Players$LoadPlayersResult;>;"
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/PendingResult;->setResultCallback(Lcom/google/android/gms/common/api/ResultCallback;)V

    .line 514
    return-void
.end method

.method createFriendsQuery(Ljava/lang/String;)V
    .locals 4
    .param p1, "nextPageToken"    # Ljava/lang/String;

    .prologue
    .line 506
    sget-object v1, Lcom/google/android/gms/games/Games;->Players:Lcom/google/android/gms/games/Players;

    iget-object v2, p0, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v2}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Lcom/google/android/gms/games/Players;->loadConnectedPlayers(Lcom/google/android/gms/common/api/GoogleApiClient;Z)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v0

    .line 507
    .local v0, "res":Lcom/google/android/gms/common/api/PendingResult;, "Lcom/google/android/gms/common/api/PendingResult<Lcom/google/android/gms/games/Players$LoadPlayersResult;>;"
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/PendingResult;->setResultCallback(Lcom/google/android/gms/common/api/ResultCallback;)V

    .line 508
    return-void
.end method

.method public bridge synthetic onResult(Lcom/google/android/gms/common/api/Result;)V
    .locals 0

    .prologue
    .line 439
    check-cast p1, Lcom/google/android/gms/games/Players$LoadPlayersResult;

    invoke-virtual {p0, p1}, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->onResult(Lcom/google/android/gms/games/Players$LoadPlayersResult;)V

    return-void
.end method

.method public onResult(Lcom/google/android/gms/games/Players$LoadPlayersResult;)V
    .locals 12
    .param p1, "loadPeopleResult"    # Lcom/google/android/gms/games/Players$LoadPlayersResult;

    .prologue
    .line 449
    sget-object v8, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->TAG:Ljava/lang/String;

    const-string v9, "friend result..."

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 450
    invoke-interface {p1}, Lcom/google/android/gms/games/Players$LoadPlayersResult;->getStatus()Lcom/google/android/gms/common/api/Status;

    move-result-object v8

    invoke-virtual {v8}, Lcom/google/android/gms/common/api/Status;->getStatusCode()I

    move-result v8

    if-nez v8, :cond_3

    .line 451
    sget-object v8, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->TAG:Ljava/lang/String;

    const-string v9, "StatusCodes.SUCCESS"

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 452
    invoke-interface {p1}, Lcom/google/android/gms/games/Players$LoadPlayersResult;->getPlayers()Lcom/google/android/gms/games/PlayerBuffer;

    move-result-object v6

    .line 454
    .local v6, "personBuffer":Lcom/google/android/gms/games/PlayerBuffer;
    :try_start_0
    iget-object v8, p0, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->friends:Ljava/util/ArrayList;

    if-nez v8, :cond_0

    .line 455
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    iput-object v8, p0, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->friends:Ljava/util/ArrayList;

    .line 456
    const/4 v8, 0x0

    iput v8, p0, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->mFriendCounter:I

    .line 458
    :cond_0
    invoke-virtual {v6}, Lcom/google/android/gms/games/PlayerBuffer;->getCount()I

    move-result v0

    .line 459
    .local v0, "count":I
    sget-object v8, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "person count: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 460
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v0, :cond_2

    .line 461
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    .line 462
    .local v5, "o":Lorg/json/JSONObject;
    const/4 v4, 0x0

    .line 464
    .local v4, "id":Ljava/lang/String;
    invoke-virtual {v6, v3}, Lcom/google/android/gms/games/PlayerBuffer;->get(I)Lcom/google/android/gms/games/Player;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v7

    .line 467
    .local v7, "profile":Lcom/google/android/gms/games/Player;
    :try_start_1
    invoke-interface {v7}, Lcom/google/android/gms/games/Player;->getPlayerId()Ljava/lang/String;

    move-result-object v4

    .line 468
    if-nez v4, :cond_1

    .line 460
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 470
    :cond_1
    const-string v8, "id"

    invoke-virtual {v5, v8, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 471
    const-string v8, "first_name"

    invoke-interface {v7}, Lcom/google/android/gms/games/Player;->getDisplayName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 472
    const-string v8, "last_play_time"

    invoke-interface {v7}, Lcom/google/android/gms/games/Player;->getLastPlayedWithTimestamp()J

    move-result-wide v10

    invoke-virtual {v5, v8, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 473
    const-string v8, "level"

    invoke-interface {v7}, Lcom/google/android/gms/games/Player;->getLevelInfo()Lcom/google/android/gms/games/PlayerLevelInfo;

    move-result-object v9

    invoke-virtual {v5, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 474
    const-string v8, "name"

    invoke-interface {v7}, Lcom/google/android/gms/games/Player;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 475
    const-string v8, "ret_time"

    invoke-interface {v7}, Lcom/google/android/gms/games/Player;->getRetrievedTimestamp()J

    move-result-wide v10

    invoke-virtual {v5, v8, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 476
    const-string v8, "title"

    invoke-interface {v7}, Lcom/google/android/gms/games/Player;->getTitle()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 477
    const-string v8, "has_icon"

    invoke-interface {v7}, Lcom/google/android/gms/games/Player;->hasIconImage()Z

    move-result v9

    invoke-virtual {v5, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 478
    iget-object v8, p0, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->friends:Ljava/util/ArrayList;

    invoke-virtual {v8, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 479
    iget v8, p0, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->mFriendCounter:I

    add-int/lit8 v8, v8, 0x1

    iput v8, p0, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->mFriendCounter:I

    .line 480
    sget-object v8, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "friend loaded "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " : "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-interface {v7}, Lcom/google/android/gms/games/Player;->getDisplayName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 481
    :catch_0
    move-exception v1

    .line 483
    .local v1, "e":Lorg/json/JSONException;
    :try_start_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 491
    .end local v0    # "count":I
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v3    # "i":I
    .end local v4    # "id":Ljava/lang/String;
    .end local v5    # "o":Lorg/json/JSONObject;
    .end local v7    # "profile":Lcom/google/android/gms/games/Player;
    :catch_1
    move-exception v2

    .line 492
    .local v2, "ex":Ljava/lang/Exception;
    :try_start_3
    sget-object v8, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "[GooglePlayServices] onPeopleLoaded exception: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 493
    invoke-virtual {v6}, Lcom/google/android/gms/games/PlayerBuffer;->release()V

    .line 494
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->loadPeopleError()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 496
    invoke-virtual {v6}, Lcom/google/android/gms/games/PlayerBuffer;->release()V

    .line 502
    .end local v2    # "ex":Ljava/lang/Exception;
    .end local v6    # "personBuffer":Lcom/google/android/gms/games/PlayerBuffer;
    :goto_2
    return-void

    .line 486
    .restart local v0    # "count":I
    .restart local v3    # "i":I
    .restart local v6    # "personBuffer":Lcom/google/android/gms/games/PlayerBuffer;
    :cond_2
    :try_start_4
    sget-object v8, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->TAG:Ljava/lang/String;

    const-string v9, "PreEx"

    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 487
    invoke-virtual {v6}, Lcom/google/android/gms/games/PlayerBuffer;->release()V

    .line 488
    sget-object v8, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->TAG:Ljava/lang/String;

    const-string v9, "AfterRelease"

    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 489
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->loadPeopleComplete()V

    .line 490
    sget-object v8, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->TAG:Ljava/lang/String;

    const-string v9, "AfterRelease2"

    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 496
    invoke-virtual {v6}, Lcom/google/android/gms/games/PlayerBuffer;->release()V

    goto :goto_2

    .end local v0    # "count":I
    .end local v3    # "i":I
    :catchall_0
    move-exception v8

    invoke-virtual {v6}, Lcom/google/android/gms/games/PlayerBuffer;->release()V

    throw v8

    .line 499
    .end local v6    # "personBuffer":Lcom/google/android/gms/games/PlayerBuffer;
    :cond_3
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->loadPeopleError()V

    .line 500
    sget-object v8, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Error requesting visible circles: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-interface {p1}, Lcom/google/android/gms/games/Players$LoadPlayersResult;->getStatus()Lcom/google/android/gms/common/api/Status;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2
.end method
