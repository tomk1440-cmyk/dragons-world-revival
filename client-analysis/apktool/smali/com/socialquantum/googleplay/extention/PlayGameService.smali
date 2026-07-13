.class public Lcom/socialquantum/googleplay/extention/PlayGameService;
.super Ljava/lang/Object;
.source "PlayGameService.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation


# static fields
.field private static TAG:Ljava/lang/String;

.field private static _instance:Lcom/socialquantum/googleplay/extention/PlayGameService;

.field private static objName:Ljava/lang/String;

.field private static onFriendsRecieved:Ljava/lang/String;

.field private static onFriendsRecievedError:Ljava/lang/String;


# instance fields
.field friendsJsonObject:Lorg/json/JSONObject;

.field private helper:Lcom/prime31/GameHelper;

.field mFriendCounter:I

.field private playStatus:I

.field private plusStatus:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-string v0, "PlayGameService"

    sput-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    .line 39
    const-string v0, "GooglePlusReceiver"

    sput-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->objName:Ljava/lang/String;

    .line 40
    const-string v0, "OnFriendsReceived"

    sput-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->onFriendsRecieved:Ljava/lang/String;

    .line 41
    const-string v0, "OnFriendsReceivedError"

    sput-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->onFriendsRecievedError:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->plusStatus:I

    .line 48
    iput v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->playStatus:I

    .line 51
    invoke-static {}, Lcom/prime31/PlayGameServicesPlugin;->instance()Lcom/prime31/PlayGameServicesPlugin;

    move-result-object v0

    iget-object v0, v0, Lcom/prime31/PlayGameServicesPlugin;->helper:Lcom/prime31/GameHelper;

    iput-object v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    .line 52
    return-void
.end method

.method static synthetic access$000(Lcom/socialquantum/googleplay/extention/PlayGameService;)Lcom/prime31/GameHelper;
    .locals 1
    .param p0, "x0"    # Lcom/socialquantum/googleplay/extention/PlayGameService;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    return-object v0
.end method

.method static synthetic access$102(Lcom/socialquantum/googleplay/extention/PlayGameService;I)I
    .locals 0
    .param p0, "x0"    # Lcom/socialquantum/googleplay/extention/PlayGameService;
    .param p1, "x1"    # I

    .prologue
    .line 35
    iput p1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->plusStatus:I

    return p1
.end method

.method static synthetic access$200(Lcom/socialquantum/googleplay/extention/PlayGameService;Ljava/util/ArrayList;)V
    .locals 0
    .param p0, "x0"    # Lcom/socialquantum/googleplay/extention/PlayGameService;
    .param p1, "x1"    # Ljava/util/ArrayList;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/socialquantum/googleplay/extention/PlayGameService;->mergeLoadedFriends(Ljava/util/ArrayList;)V

    return-void
.end method

.method static synthetic access$302(Lcom/socialquantum/googleplay/extention/PlayGameService;I)I
    .locals 0
    .param p0, "x0"    # Lcom/socialquantum/googleplay/extention/PlayGameService;
    .param p1, "x1"    # I

    .prologue
    .line 35
    iput p1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->playStatus:I

    return p1
.end method

.method static synthetic access$400()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private clearLoadStatus()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 252
    iput v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->plusStatus:I

    .line 253
    iput v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->playStatus:I

    .line 254
    return-void
.end method

.method public static drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 6
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v5, 0x0

    .line 63
    instance-of v2, p0, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v2, :cond_0

    check-cast p0, Landroid/graphics/drawable/BitmapDrawable;

    .end local p0    # "drawable":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 70
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    .local v1, "canvas":Landroid/graphics/Canvas;
    .restart local p0    # "drawable":Landroid/graphics/drawable/Drawable;
    :goto_0
    return-object v0

    .line 65
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "canvas":Landroid/graphics/Canvas;
    :cond_0
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v3

    sget-object v4, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v2, v3, v4}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 66
    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 67
    .restart local v1    # "canvas":Landroid/graphics/Canvas;
    invoke-virtual {v1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v2

    invoke-virtual {v1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v3

    invoke-virtual {p0, v5, v5, v2, v3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 68
    invoke-virtual {p0, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_0
.end method

.method private handleRequests(Ljava/util/ArrayList;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/games/request/GameRequest;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 125
    .local p1, "requests":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/games/request/GameRequest;>;"
    if-nez p1, :cond_0

    .line 167
    :goto_0
    return-void

    .line 129
    :cond_0
    iget-object v5, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v5}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v0

    .line 131
    .local v0, "client":Lcom/google/android/gms/common/api/GoogleApiClient;
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 137
    .local v4, "requestIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 141
    .local v1, "gameRequestMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/google/android/gms/games/request/GameRequest;>;"
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/games/request/GameRequest;

    .line 142
    .local v2, "request":Lcom/google/android/gms/games/request/GameRequest;
    invoke-interface {v2}, Lcom/google/android/gms/games/request/GameRequest;->getRequestId()Ljava/lang/String;

    move-result-object v3

    .line 143
    .local v3, "requestId":Ljava/lang/String;
    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 144
    invoke-virtual {v1, v3, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 148
    .end local v2    # "request":Lcom/google/android/gms/games/request/GameRequest;
    .end local v3    # "requestId":Ljava/lang/String;
    :cond_1
    sget-object v5, Lcom/google/android/gms/games/Games;->Requests:Lcom/google/android/gms/games/request/Requests;

    invoke-interface {v5, v0, v4}, Lcom/google/android/gms/games/request/Requests;->acceptRequests(Lcom/google/android/gms/common/api/GoogleApiClient;Ljava/util/List;)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v5

    new-instance v6, Lcom/socialquantum/googleplay/extention/PlayGameService$2;

    invoke-direct {v6, p0, v1}, Lcom/socialquantum/googleplay/extention/PlayGameService$2;-><init>(Lcom/socialquantum/googleplay/extention/PlayGameService;Ljava/util/HashMap;)V

    invoke-virtual {v5, v6}, Lcom/google/android/gms/common/api/PendingResult;->setResultCallback(Lcom/google/android/gms/common/api/ResultCallback;)V

    goto :goto_0
.end method

.method public static instance()Lcom/socialquantum/googleplay/extention/PlayGameService;
    .locals 2

    .prologue
    .line 55
    sget-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->_instance:Lcom/socialquantum/googleplay/extention/PlayGameService;

    if-nez v0, :cond_0

    .line 56
    sget-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    const-string v1, "Create instance"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 57
    new-instance v0, Lcom/socialquantum/googleplay/extention/PlayGameService;

    invoke-direct {v0}, Lcom/socialquantum/googleplay/extention/PlayGameService;-><init>()V

    sput-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->_instance:Lcom/socialquantum/googleplay/extention/PlayGameService;

    .line 59
    :cond_0
    sget-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->_instance:Lcom/socialquantum/googleplay/extention/PlayGameService;

    return-object v0
.end method

.method private isSignedIn()Z
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v0}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

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

.method private loadPeopleComplete()V
    .locals 3

    .prologue
    .line 247
    sget-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "loadPeopleComplete: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->friendsJsonObject:Lorg/json/JSONObject;

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 248
    sget-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->objName:Ljava/lang/String;

    sget-object v1, Lcom/socialquantum/googleplay/extention/PlayGameService;->onFriendsRecieved:Ljava/lang/String;

    iget-object v2, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->friendsJsonObject:Lorg/json/JSONObject;

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 249
    return-void
.end method

.method private loadPeopleError()V
    .locals 3

    .prologue
    .line 239
    iget v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->mFriendCounter:I

    if-lez v0, :cond_0

    .line 240
    sget-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->objName:Ljava/lang/String;

    sget-object v1, Lcom/socialquantum/googleplay/extention/PlayGameService;->onFriendsRecieved:Ljava/lang/String;

    iget-object v2, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->friendsJsonObject:Lorg/json/JSONObject;

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 241
    sget-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    const-string v1, "[GooglePlayServices] WARNING!!! not load all friends"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 244
    :goto_0
    return-void

    .line 243
    :cond_0
    sget-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->objName:Ljava/lang/String;

    sget-object v1, Lcom/socialquantum/googleplay/extention/PlayGameService;->onFriendsRecievedError:Ljava/lang/String;

    iget-object v2, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->friendsJsonObject:Lorg/json/JSONObject;

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private mergeLoadedFriends(Ljava/util/ArrayList;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/json/JSONObject;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "friendsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/json/JSONObject;>;"
    const/4 v6, 0x2

    .line 220
    if-nez p1, :cond_1

    .line 236
    :cond_0
    :goto_0
    return-void

    .line 221
    :cond_1
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/json/JSONObject;

    .line 223
    .local v2, "key":Lorg/json/JSONObject;
    :try_start_0
    const-string v4, "id"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 224
    .local v1, "id":Ljava/lang/String;
    iget-object v4, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->friendsJsonObject:Lorg/json/JSONObject;

    invoke-virtual {v4, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 225
    .end local v1    # "id":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 226
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 229
    .end local v0    # "e":Lorg/json/JSONException;
    .end local v2    # "key":Lorg/json/JSONObject;
    :cond_2
    iget v3, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->plusStatus:I

    if-lez v3, :cond_3

    iget v3, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->playStatus:I

    if-lez v3, :cond_3

    .line 230
    sget-object v3, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "friendsJsonObject : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->friendsJsonObject:Lorg/json/JSONObject;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 231
    invoke-direct {p0}, Lcom/socialquantum/googleplay/extention/PlayGameService;->loadPeopleComplete()V

    .line 233
    :cond_3
    iget v3, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->plusStatus:I

    if-ne v3, v6, :cond_0

    iget v3, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->playStatus:I

    if-ne v3, v6, :cond_0

    .line 234
    invoke-direct {p0}, Lcom/socialquantum/googleplay/extention/PlayGameService;->loadPeopleError()V

    goto :goto_0
.end method


# virtual methods
.method public OpenGameSettings()V
    .locals 3

    .prologue
    .line 83
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.google.android.gms.games.SHOW_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 84
    .local v0, "settings":Landroid/content/Intent;
    const-string v1, "com.google.android.gms.games.GAME_PACKAGE_NAME"

    const-string v2, "com.socialquantum2.magiczoo"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 85
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 86
    sget-object v1, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    const v2, 0x15f94

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 87
    return-void
.end method

.method public OpenSettings()V
    .locals 3

    .prologue
    .line 74
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 75
    .local v0, "settings":Landroid/content/Intent;
    const-string v1, "com.google.android.gms"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 76
    const-string v1, "android.intent.category.LAUNCHER"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 77
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 79
    sget-object v1, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    const v2, 0x15f95

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 80
    return-void
.end method

.method protected SendPrime31Message(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 272
    const-string v0, "GPGManager"

    invoke-static {v0, p1, p2}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 273
    return-void
.end method

.method public clearGifts()V
    .locals 2

    .prologue
    .line 115
    iget-object v1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    if-eqz v1, :cond_0

    .line 116
    iget-object v1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v1}, Lcom/prime31/GameHelper;->getRequests()Ljava/util/ArrayList;

    move-result-object v0

    .line 117
    .local v0, "rqsts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/games/request/GameRequest;>;"
    if-eqz v0, :cond_0

    .line 118
    invoke-direct {p0, v0}, Lcom/socialquantum/googleplay/extention/PlayGameService;->handleRequests(Ljava/util/ArrayList;)V

    .line 119
    iget-object v1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v1}, Lcom/prime31/GameHelper;->clearRequests()V

    .line 122
    .end local v0    # "rqsts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/games/request/GameRequest;>;"
    :cond_0
    return-void
.end method

.method public forceDisconnect()V
    .locals 1

    .prologue
    .line 91
    new-instance v0, Lcom/socialquantum/googleplay/extention/PlayGameService$1;

    invoke-direct {v0, p0}, Lcom/socialquantum/googleplay/extention/PlayGameService$1;-><init>(Lcom/socialquantum/googleplay/extention/PlayGameService;)V

    invoke-virtual {p0, v0}, Lcom/socialquantum/googleplay/extention/PlayGameService;->runSafelyOnUiThread(Ljava/lang/Runnable;)V

    .line 97
    return-void
.end method

.method public getGiftSendersId()Ljava/lang/String;
    .locals 7

    .prologue
    .line 100
    const-string v2, ""

    .line 101
    .local v2, "result":Ljava/lang/String;
    iget-object v4, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    if-eqz v4, :cond_0

    .line 102
    iget-object v4, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v4}, Lcom/prime31/GameHelper;->getRequests()Ljava/util/ArrayList;

    move-result-object v3

    .line 103
    .local v3, "rqsts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/games/request/GameRequest;>;"
    if-eqz v3, :cond_0

    .line 104
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/games/request/GameRequest;

    .line 105
    .local v1, "request":Lcom/google/android/gms/games/request/GameRequest;
    new-instance v0, Ljava/lang/String;

    invoke-interface {v1}, Lcom/google/android/gms/games/request/GameRequest;->getData()[B

    move-result-object v5

    invoke-direct {v0, v5}, Ljava/lang/String;-><init>([B)V

    .line 106
    .local v0, "data":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v1}, Lcom/google/android/gms/games/request/GameRequest;->getSender()Lcom/google/android/gms/games/Player;

    move-result-object v6

    invoke-interface {v6}, Lcom/google/android/gms/games/Player;->getPlayerId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "*"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ";"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 107
    goto :goto_0

    .line 110
    .end local v0    # "data":Ljava/lang/String;
    .end local v1    # "request":Lcom/google/android/gms/games/request/GameRequest;
    .end local v3    # "rqsts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/games/request/GameRequest;>;"
    :cond_0
    sget-object v4, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "gift result "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 111
    return-object v2
.end method

.method public inviteFriend(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 11
    .param p1, "userId"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    const/4 v2, 0x1

    .line 170
    sget-object v1, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "invite friend "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 171
    if-nez p1, :cond_0

    .line 172
    sget-object v1, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    const-string v2, "User is is null"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v0

    .line 189
    :goto_0
    return v2

    .line 176
    :cond_0
    invoke-direct {p0}, Lcom/socialquantum/googleplay/extention/PlayGameService;->isSignedIn()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 177
    sget-object v0, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    const-string v1, "Inviting friends"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 178
    sget-object v0, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v10

    .line 179
    .local v10, "pm":Landroid/content/pm/PackageManager;
    sget-object v0, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    invoke-virtual {v10, v0}, Landroid/content/pm/PackageManager;->getApplicationIcon(Landroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    .line 180
    .local v8, "icon":Landroid/graphics/drawable/Drawable;
    invoke-static {v8}, Lcom/socialquantum/googleplay/extention/PlayGameService;->drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 181
    .local v5, "img":Landroid/graphics/Bitmap;
    sget-object v0, Lcom/google/android/gms/games/Games;->Requests:Lcom/google/android/gms/games/request/Requests;

    iget-object v1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v1}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    const-string v6, " "

    move v4, v2

    invoke-interface/range {v0 .. v6}, Lcom/google/android/gms/games/request/Requests;->getSendIntent(Lcom/google/android/gms/common/api/GoogleApiClient;I[BILandroid/graphics/Bitmap;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v9

    .line 182
    .local v9, "intent":Landroid/content/Intent;
    new-instance v7, Landroid/os/Bundle;

    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 183
    .local v7, "b":Landroid/os/Bundle;
    const-string v0, "key"

    const-string v1, "value"

    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    sget-object v0, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    const v1, 0x132c10cb

    invoke-virtual {v0, v9, v1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 187
    .end local v5    # "img":Landroid/graphics/Bitmap;
    .end local v7    # "b":Landroid/os/Bundle;
    .end local v8    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v9    # "intent":Landroid/content/Intent;
    .end local v10    # "pm":Landroid/content/pm/PackageManager;
    :cond_1
    sget-object v1, Lcom/socialquantum/googleplay/extention/PlayGameService;->TAG:Ljava/lang/String;

    const-string v2, "can\'t create invite environment"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v0

    .line 189
    goto :goto_0
.end method

.method public queryFriends()Z
    .locals 3

    .prologue
    .line 193
    invoke-direct {p0}, Lcom/socialquantum/googleplay/extention/PlayGameService;->clearLoadStatus()V

    .line 194
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    iput-object v2, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->friendsJsonObject:Lorg/json/JSONObject;

    .line 195
    new-instance v1, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;

    iget-object v2, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    invoke-direct {v1, v2}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;-><init>(Lcom/prime31/GameHelper;)V

    .line 196
    .local v1, "plusFriends":Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;
    new-instance v2, Lcom/socialquantum/googleplay/extention/PlayGameService$3;

    invoke-direct {v2, p0}, Lcom/socialquantum/googleplay/extention/PlayGameService$3;-><init>(Lcom/socialquantum/googleplay/extention/PlayGameService;)V

    invoke-virtual {v1, v2}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->addListener(Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;)V

    .line 204
    invoke-virtual {v1}, Lcom/socialquantum/googleplay/extention/PlusFriendsLoader;->quertyFriends()Z

    .line 207
    new-instance v0, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;

    iget-object v2, p0, Lcom/socialquantum/googleplay/extention/PlayGameService;->helper:Lcom/prime31/GameHelper;

    invoke-direct {v0, v2}, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;-><init>(Lcom/prime31/GameHelper;)V

    .line 208
    .local v0, "playFriends":Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;
    new-instance v2, Lcom/socialquantum/googleplay/extention/PlayGameService$4;

    invoke-direct {v2, p0}, Lcom/socialquantum/googleplay/extention/PlayGameService$4;-><init>(Lcom/socialquantum/googleplay/extention/PlayGameService;)V

    invoke-virtual {v0, v2}, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->addListener(Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;)V

    .line 216
    invoke-virtual {v0}, Lcom/socialquantum/googleplay/extention/PlayFriendsLoader;->quertyFriends()Z

    move-result v2

    return v2
.end method

.method protected runSafelyOnUiThread(Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "r"    # Ljava/lang/Runnable;

    .prologue
    .line 259
    sget-object v0, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    new-instance v1, Lcom/socialquantum/googleplay/extention/PlayGameService$5;

    invoke-direct {v1, p0, p1}, Lcom/socialquantum/googleplay/extention/PlayGameService$5;-><init>(Lcom/socialquantum/googleplay/extention/PlayGameService;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 268
    return-void
.end method
