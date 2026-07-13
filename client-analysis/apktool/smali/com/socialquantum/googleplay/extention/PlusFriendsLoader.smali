.class Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;
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
        "Lcom/google/android/gms/plus/People$LoadPeopleResult;",
        ">;"
    }
.end annotation


# static fields
.field private static TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 341
    const-string v0, "PlayGameService_Plus"

    sput-object v0, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/prime31/GameHelper;)V
    .locals 0
    .param p1, "helper"    # Lcom/prime31/GameHelper;

    .prologue
    .line 344
    invoke-direct {p0, p1}, Lcom/socialquantum/googleplay/extention/BaseFriendsLoader;-><init>(Lcom/prime31/GameHelper;)V

    .line 345
    return-void
.end method

.method private loadNextPage(Ljava/lang/String;)V
    .locals 5
    .param p1, "nextPageToken"    # Ljava/lang/String;

    .prologue
    .line 416
    if-eqz p1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_1

    .line 417
    :cond_0
    sget-object v2, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    const-string v3, "Precomplete"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 418
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->loadPeopleComplete()V

    .line 419
    sget-object v2, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    const-string v3, "[GooglePlayServices] friends are loaded"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 434
    :goto_0
    return-void

    .line 421
    :cond_1
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->isSignedIn()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 422
    sget-object v2, Lcom/google/android/gms/plus/Plus;->PeopleApi:Lcom/google/android/gms/plus/People;

    iget-object v3, p0, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v3}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v3

    const/4 v4, 0x1

    invoke-interface {v2, v3, v4, p1}, Lcom/google/android/gms/plus/People;->loadVisible(Lcom/google/android/gms/common/api/GoogleApiClient;ILjava/lang/String;)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v1

    .line 423
    .local v1, "mPeopleResult":Lcom/google/android/gms/common/api/PendingResult;, "Lcom/google/android/gms/common/api/PendingResult<Lcom/google/android/gms/plus/People$LoadPeopleResult;>;"
    invoke-virtual {v1, p0}, Lcom/google/android/gms/common/api/PendingResult;->setResultCallback(Lcom/google/android/gms/common/api/ResultCallback;)V

    .line 424
    sget-object v2, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[GooglePlayServices] continue loading friends from plus client page token: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 430
    .end local v1    # "mPeopleResult":Lcom/google/android/gms/common/api/PendingResult;, "Lcom/google/android/gms/common/api/PendingResult<Lcom/google/android/gms/plus/People$LoadPeopleResult;>;"
    :catch_0
    move-exception v0

    .line 431
    .local v0, "ex":Ljava/lang/Exception;
    sget-object v2, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[GooglePlayServices] loading friends from next page exception: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 432
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->loadPeopleError()V

    goto :goto_0

    .line 426
    .end local v0    # "ex":Ljava/lang/Exception;
    :cond_2
    :try_start_1
    sget-object v2, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    const-string v3, "[GooglePlayServices] loading friends from next page error: plus client is null or not connected"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 427
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->loadPeopleError()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method


# virtual methods
.method createFriendsQuery()V
    .locals 1

    .prologue
    .line 411
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->createFriendsQuery(Ljava/lang/String;)V

    .line 412
    return-void
.end method

.method createFriendsQuery(Ljava/lang/String;)V
    .locals 4
    .param p1, "nextPageToken"    # Ljava/lang/String;

    .prologue
    .line 405
    sget-object v1, Lcom/google/android/gms/plus/Plus;->PeopleApi:Lcom/google/android/gms/plus/People;

    iget-object v2, p0, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v2}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3, p1}, Lcom/google/android/gms/plus/People;->loadVisible(Lcom/google/android/gms/common/api/GoogleApiClient;ILjava/lang/String;)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v0

    .line 406
    .local v0, "mPeopleResult":Lcom/google/android/gms/common/api/PendingResult;, "Lcom/google/android/gms/common/api/PendingResult<Lcom/google/android/gms/plus/People$LoadPeopleResult;>;"
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/PendingResult;->setResultCallback(Lcom/google/android/gms/common/api/ResultCallback;)V

    .line 407
    return-void
.end method

.method public bridge synthetic onResult(Lcom/google/android/gms/common/api/Result;)V
    .locals 0

    .prologue
    .line 339
    check-cast p1, Lcom/google/android/gms/plus/People$LoadPeopleResult;

    invoke-virtual {p0, p1}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->onResult(Lcom/google/android/gms/plus/People$LoadPeopleResult;)V

    return-void
.end method

.method public onResult(Lcom/google/android/gms/plus/People$LoadPeopleResult;)V
    .locals 12
    .param p1, "loadPeopleResult"    # Lcom/google/android/gms/plus/People$LoadPeopleResult;

    .prologue
    .line 350
    sget-object v9, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    const-string v10, "friend result..."

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 351
    invoke-interface {p1}, Lcom/google/android/gms/plus/People$LoadPeopleResult;->getStatus()Lcom/google/android/gms/common/api/Status;

    move-result-object v9

    invoke-virtual {v9}, Lcom/google/android/gms/common/api/Status;->getStatusCode()I

    move-result v9

    if-nez v9, :cond_5

    .line 353
    invoke-interface {p1}, Lcom/google/android/gms/plus/People$LoadPeopleResult;->getPersonBuffer()Lcom/google/android/gms/plus/model/people/PersonBuffer;

    move-result-object v7

    .line 355
    .local v7, "personBuffer":Lcom/google/android/gms/plus/model/people/PersonBuffer;
    :try_start_0
    iget-object v9, p0, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->friends:Ljava/util/ArrayList;

    if-nez v9, :cond_0

    .line 356
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    iput-object v9, p0, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->friends:Ljava/util/ArrayList;

    .line 357
    const/4 v9, 0x0

    iput v9, p0, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->mFriendCounter:I

    .line 359
    :cond_0
    invoke-virtual {v7}, Lcom/google/android/gms/plus/model/people/PersonBuffer;->getCount()I

    move-result v0

    .line 360
    .local v0, "count":I
    sget-object v9, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "person count: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 361
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v0, :cond_4

    .line 362
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 363
    .local v6, "o":Lorg/json/JSONObject;
    const/4 v4, 0x0

    .line 365
    .local v4, "id":Ljava/lang/String;
    invoke-virtual {v7, v3}, Lcom/google/android/gms/plus/model/people/PersonBuffer;->get(I)Lcom/google/android/gms/plus/model/people/Person;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v8

    .line 368
    .local v8, "profile":Lcom/google/android/gms/plus/model/people/Person;
    :try_start_1
    invoke-interface {v8}, Lcom/google/android/gms/plus/model/people/Person;->hasId()Z

    move-result v9

    if-nez v9, :cond_2

    .line 361
    :cond_1
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 370
    :cond_2
    invoke-interface {v8}, Lcom/google/android/gms/plus/model/people/Person;->getId()Ljava/lang/String;

    move-result-object v4

    .line 371
    if-eqz v4, :cond_1

    .line 373
    const-string v9, "id"

    invoke-virtual {v6, v9, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 374
    invoke-interface {v8}, Lcom/google/android/gms/plus/model/people/Person;->hasDisplayName()Z

    move-result v9

    if-eqz v9, :cond_3

    .line 375
    const-string v9, "first_name"

    invoke-interface {v8}, Lcom/google/android/gms/plus/model/people/Person;->getDisplayName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v9, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 376
    :cond_3
    const-string v9, "name"

    invoke-interface {v8}, Lcom/google/android/gms/plus/model/people/Person;->getName()Lcom/google/android/gms/plus/model/people/Person$Name;

    move-result-object v10

    invoke-virtual {v6, v9, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 377
    const-string v9, "nickname"

    invoke-interface {v8}, Lcom/google/android/gms/plus/model/people/Person;->getNickname()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v9, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 378
    iget-object v9, p0, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->friends:Ljava/util/ArrayList;

    invoke-virtual {v9, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 379
    iget v9, p0, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->mFriendCounter:I

    add-int/lit8 v9, v9, 0x1

    iput v9, p0, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->mFriendCounter:I

    .line 380
    sget-object v9, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "friend loaded "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-interface {v8}, Lcom/google/android/gms/plus/model/people/Person;->getDisplayName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 381
    :catch_0
    move-exception v1

    .line 383
    .local v1, "e":Lorg/json/JSONException;
    :try_start_2
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 390
    .end local v0    # "count":I
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v3    # "i":I
    .end local v4    # "id":Ljava/lang/String;
    .end local v6    # "o":Lorg/json/JSONObject;
    .end local v8    # "profile":Lcom/google/android/gms/plus/model/people/Person;
    :catch_1
    move-exception v2

    .line 391
    .local v2, "ex":Ljava/lang/Exception;
    :try_start_3
    sget-object v9, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "[GooglePlayServices] onPeopleLoaded exception: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 392
    invoke-virtual {v7}, Lcom/google/android/gms/plus/model/people/PersonBuffer;->release()V

    .line 393
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->loadPeopleError()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 395
    invoke-virtual {v7}, Lcom/google/android/gms/plus/model/people/PersonBuffer;->release()V

    .line 401
    .end local v2    # "ex":Ljava/lang/Exception;
    .end local v7    # "personBuffer":Lcom/google/android/gms/plus/model/people/PersonBuffer;
    :goto_2
    return-void

    .line 386
    .restart local v0    # "count":I
    .restart local v3    # "i":I
    .restart local v7    # "personBuffer":Lcom/google/android/gms/plus/model/people/PersonBuffer;
    :cond_4
    :try_start_4
    invoke-interface {p1}, Lcom/google/android/gms/plus/People$LoadPeopleResult;->getNextPageToken()Ljava/lang/String;

    move-result-object v5

    .line 387
    .local v5, "nextPageToken":Ljava/lang/String;
    sget-object v9, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "nextPageToken : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 388
    invoke-direct {p0, v5}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->loadNextPage(Ljava/lang/String;)V

    .line 389
    invoke-virtual {v7}, Lcom/google/android/gms/plus/model/people/PersonBuffer;->release()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 395
    invoke-virtual {v7}, Lcom/google/android/gms/plus/model/people/PersonBuffer;->release()V

    goto :goto_2

    .end local v0    # "count":I
    .end local v3    # "i":I
    .end local v5    # "nextPageToken":Ljava/lang/String;
    :catchall_0
    move-exception v9

    invoke-virtual {v7}, Lcom/google/android/gms/plus/model/people/PersonBuffer;->release()V

    throw v9

    .line 398
    .end local v7    # "personBuffer":Lcom/google/android/gms/plus/model/people/PersonBuffer;
    :cond_5
    invoke-virtual {p0}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->loadPeopleError()V

    .line 399
    sget-object v9, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Error requesting visible circles: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-interface {p1}, Lcom/google/android/gms/plus/People$LoadPeopleResult;->getStatus()Lcom/google/android/gms/common/api/Status;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2
.end method
