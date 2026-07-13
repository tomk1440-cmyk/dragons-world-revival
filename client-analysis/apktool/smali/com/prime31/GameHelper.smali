.class public Lcom/prime31/GameHelper;
.super Ljava/lang/Object;
.source "GameHelper.java"

# interfaces
.implements Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;
.implements Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/prime31/GameHelper$GameHelperListener;,
        Lcom/prime31/GameHelper$SignInFailureReason;
    }
.end annotation


# static fields
.field public static final CLIENT_ALL:I = 0xb

.field public static final CLIENT_GAMES:I = 0x1

.field public static final CLIENT_NONE:I = 0x0

.field public static final CLIENT_PLUS:I = 0x2

.field public static final CLIENT_SNAPSHOT:I = 0x8

.field static final DEFAULT_MAX_SIGN_IN_ATTEMPTS:I = 0x3

.field static final RC_RESOLVE:I = 0x2329

.field static final RC_UNUSED:I = 0x232a

.field static final TAG:Ljava/lang/String; = "Prime31-GH"


# instance fields
.field private final GAMEHELPER_SHARED_PREFS:Ljava/lang/String;

.field private final KEY_SIGN_IN_CANCELLATIONS:Ljava/lang/String;

.field mActivity:Landroid/app/Activity;

.field mAppContext:Landroid/content/Context;

.field mConnectOnStart:Z

.field private mConnecting:Z

.field mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

.field mDebugLog:Z

.field mExpectingResolution:Z

.field mGamesApiOptions:Lcom/google/android/gms/games/Games$GamesOptions;

.field mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

.field mGoogleApiClientBuilder:Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

.field mHandler:Landroid/os/Handler;

.field mInvitation:Lcom/google/android/gms/games/multiplayer/Invitation;

.field mListener:Lcom/prime31/GameHelper$GameHelperListener;

.field mMaxAutoSignInAttempts:I

.field mPlusApiOptions:Lcom/google/android/gms/plus/Plus$PlusOptions;

.field mRequestedClients:I

.field mRequests:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/games/request/GameRequest;",
            ">;"
        }
    .end annotation
.end field

.field private mSetupDone:Z

.field mShowErrorDialogs:Z

.field public mSignInCancelled:Z

.field mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

.field mTurnBasedMatch:Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;

.field mUserInitiatedSignIn:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;I)V
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "clientsToUse"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 193
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mSetupDone:Z

    .line 84
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 87
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mExpectingResolution:Z

    .line 91
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mSignInCancelled:Z

    .line 98
    iput-object v2, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    .line 101
    iput-object v2, p0, Lcom/prime31/GameHelper;->mAppContext:Landroid/content/Context;

    .line 111
    iput-object v2, p0, Lcom/prime31/GameHelper;->mGoogleApiClientBuilder:Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 114
    invoke-static {}, Lcom/google/android/gms/games/Games$GamesOptions;->builder()Lcom/google/android/gms/games/Games$GamesOptions$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/games/Games$GamesOptions$Builder;->build()Lcom/google/android/gms/games/Games$GamesOptions;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GameHelper;->mGamesApiOptions:Lcom/google/android/gms/games/Games$GamesOptions;

    .line 115
    invoke-static {}, Lcom/google/android/gms/plus/Plus$PlusOptions;->builder()Lcom/google/android/gms/plus/Plus$PlusOptions$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/plus/Plus$PlusOptions$Builder;->build()Lcom/google/android/gms/plus/Plus$PlusOptions;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GameHelper;->mPlusApiOptions:Lcom/google/android/gms/plus/Plus$PlusOptions;

    .line 118
    iput-object v2, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 128
    iput v1, p0, Lcom/prime31/GameHelper;->mRequestedClients:I

    .line 133
    iput-boolean v3, p0, Lcom/prime31/GameHelper;->mConnectOnStart:Z

    .line 141
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mUserInitiatedSignIn:Z

    .line 144
    iput-object v2, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    .line 147
    iput-object v2, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    .line 150
    iput-boolean v3, p0, Lcom/prime31/GameHelper;->mShowErrorDialogs:Z

    .line 153
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mDebugLog:Z

    .line 176
    iput-object v2, p0, Lcom/prime31/GameHelper;->mListener:Lcom/prime31/GameHelper$GameHelperListener;

    .line 182
    const/4 v0, 0x3

    iput v0, p0, Lcom/prime31/GameHelper;->mMaxAutoSignInAttempts:I

    .line 740
    const-string v0, "GAMEHELPER_SHARED_PREFS"

    iput-object v0, p0, Lcom/prime31/GameHelper;->GAMEHELPER_SHARED_PREFS:Ljava/lang/String;

    .line 741
    const-string v0, "KEY_SIGN_IN_CANCELLATIONS"

    iput-object v0, p0, Lcom/prime31/GameHelper;->KEY_SIGN_IN_CANCELLATIONS:Ljava/lang/String;

    .line 194
    iput-object p1, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    .line 195
    invoke-virtual {p1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GameHelper;->mAppContext:Landroid/content/Context;

    .line 196
    iput p2, p0, Lcom/prime31/GameHelper;->mRequestedClients:I

    .line 197
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/prime31/GameHelper;->mHandler:Landroid/os/Handler;

    .line 198
    return-void
.end method

.method private doApiOptionsPreCheck()V
    .locals 2

    .prologue
    .line 225
    iget-object v1, p0, Lcom/prime31/GameHelper;->mGoogleApiClientBuilder:Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    if-eqz v1, :cond_0

    .line 226
    const-string v0, "GameHelper: you cannot call set*ApiOptions after the client builder has been created. Call it before calling createApiClientBuilder() or setup()."

    .line 229
    .local v0, "error":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->logError(Ljava/lang/String;)V

    .line 230
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 232
    .end local v0    # "error":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method static makeSimpleDialog(Landroid/app/Activity;Ljava/lang/String;)Landroid/app/Dialog;
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 970
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 971
    const v1, 0x104000a

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 970
    return-object v0
.end method

.method static makeSimpleDialog(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)Landroid/app/Dialog;
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;

    .prologue
    .line 976
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, p2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 977
    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x104000a

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 978
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 976
    return-object v0
.end method

.method public static showFailureDialog(Landroid/app/Activity;II)V
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "actResp"    # I
    .param p2, "errorCode"    # I

    .prologue
    .line 929
    if-nez p0, :cond_0

    .line 930
    const-string v1, "GameHelper"

    const-string v2, "*** No Activity. Can\'t show failure dialog!"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 967
    :goto_0
    return-void

    .line 933
    :cond_0
    const/4 v0, 0x0

    .line 935
    .local v0, "errorDialog":Landroid/app/Dialog;
    packed-switch p1, :pswitch_data_0

    .line 952
    const/16 v1, 0x232a

    const/4 v2, 0x0

    .line 951
    invoke-static {p2, p0, v1, v2}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->getErrorDialog(ILandroid/app/Activity;ILandroid/content/DialogInterface$OnCancelListener;)Landroid/app/Dialog;

    move-result-object v0

    .line 953
    if-nez v0, :cond_1

    .line 955
    const-string v1, "GameHelper"

    .line 956
    const-string v2, "No standard error dialog available. Making fallback dialog."

    .line 955
    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 959
    new-instance v1, Ljava/lang/StringBuilder;

    .line 960
    const/4 v2, 0x0

    invoke-static {p0, v2}, Lcom/prime31/GameHelperUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 961
    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 962
    invoke-static {p2}, Lcom/prime31/GameHelperUtils;->errorCodeToString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 959
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 957
    invoke-static {p0, v1}, Lcom/prime31/GameHelper;->makeSimpleDialog(Landroid/app/Activity;Ljava/lang/String;)Landroid/app/Dialog;

    move-result-object v0

    .line 966
    :cond_1
    :goto_1
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    goto :goto_0

    .line 938
    :pswitch_0
    const/4 v1, 0x2

    .line 937
    invoke-static {p0, v1}, Lcom/prime31/GameHelperUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/prime31/GameHelper;->makeSimpleDialog(Landroid/app/Activity;Ljava/lang/String;)Landroid/app/Dialog;

    move-result-object v0

    .line 939
    goto :goto_1

    .line 942
    :pswitch_1
    const/4 v1, 0x1

    .line 941
    invoke-static {p0, v1}, Lcom/prime31/GameHelperUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/prime31/GameHelper;->makeSimpleDialog(Landroid/app/Activity;Ljava/lang/String;)Landroid/app/Dialog;

    move-result-object v0

    .line 943
    goto :goto_1

    .line 946
    :pswitch_2
    const/4 v1, 0x3

    .line 945
    invoke-static {p0, v1}, Lcom/prime31/GameHelperUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/prime31/GameHelper;->makeSimpleDialog(Landroid/app/Activity;Ljava/lang/String;)Landroid/app/Dialog;

    move-result-object v0

    .line 947
    goto :goto_1

    .line 935
    :pswitch_data_0
    .packed-switch 0x2712
        :pswitch_1
        :pswitch_2
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method assertConfigured(Ljava/lang/String;)V
    .locals 3
    .param p1, "operation"    # Ljava/lang/String;

    .prologue
    .line 215
    iget-boolean v1, p0, Lcom/prime31/GameHelper;->mSetupDone:Z

    if-nez v1, :cond_0

    .line 216
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "GameHelper error: Operation attempted without setup: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 217
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 218
    const-string v2, ". The setup() method must be called before attempting any other operation."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 216
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 219
    .local v0, "error":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->logError(Ljava/lang/String;)V

    .line 220
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 222
    .end local v0    # "error":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public beginUserInitiatedSignIn()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 628
    const-string v0, "beginUserInitiatedSignIn: resetting attempt count."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 629
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->resetSignInCancellations()V

    .line 630
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/prime31/GameHelper;->mSignInCancelled:Z

    .line 631
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mConnectOnStart:Z

    .line 633
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 635
    const-string v0, "beginUserInitiatedSignIn() called when already connected. Calling listener directly to notify of success."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->logWarn(Ljava/lang/String;)V

    .line 637
    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->notifyListener(Z)V

    .line 669
    :goto_0
    return-void

    .line 639
    :cond_0
    iget-boolean v0, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    if-eqz v0, :cond_1

    .line 640
    const-string v0, "beginUserInitiatedSignIn() called when already connecting. Be patient! You can only call this method after you get an onSignInSucceeded() or onSignInFailed() callback. Suggestion: disable the sign-in button on startup and also when it\'s clicked, and re-enable when you get the callback."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->logWarn(Ljava/lang/String;)V

    goto :goto_0

    .line 650
    :cond_1
    const-string v0, "Starting USER-INITIATED sign-in flow."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 655
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mUserInitiatedSignIn:Z

    .line 657
    iget-object v0, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    if-eqz v0, :cond_2

    .line 660
    const-string v0, "beginUserInitiatedSignIn: continuing pending sign-in flow."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 661
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 662
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->resolveConnectionResult()V

    goto :goto_0

    .line 665
    :cond_2
    const-string v0, "beginUserInitiatedSignIn: starting new sign-in flow."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 666
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 667
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->connect()V

    goto :goto_0
.end method

.method public clearInvitation()V
    .locals 1

    .prologue
    .line 455
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/prime31/GameHelper;->mInvitation:Lcom/google/android/gms/games/multiplayer/Invitation;

    .line 456
    return-void
.end method

.method public clearRequests()V
    .locals 1

    .prologue
    .line 463
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/prime31/GameHelper;->mRequests:Ljava/util/ArrayList;

    .line 464
    return-void
.end method

.method public clearTurnBasedMatch()V
    .locals 1

    .prologue
    .line 459
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/prime31/GameHelper;->mTurnBasedMatch:Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;

    .line 460
    return-void
.end method

.method connect()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 672
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 673
    const-string v0, "Already connected."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 681
    :goto_0
    return-void

    .line 676
    :cond_0
    const-string v0, "Starting connection."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 677
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 678
    iput-object v1, p0, Lcom/prime31/GameHelper;->mInvitation:Lcom/google/android/gms/games/multiplayer/Invitation;

    .line 679
    iput-object v1, p0, Lcom/prime31/GameHelper;->mTurnBasedMatch:Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;

    .line 680
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->connect()V

    goto :goto_0
.end method

.method public createApiClientBuilder()Lcom/google/android/gms/common/api/GoogleApiClient$Builder;
    .locals 4

    .prologue
    .line 260
    iget-boolean v2, p0, Lcom/prime31/GameHelper;->mSetupDone:Z

    if-eqz v2, :cond_0

    .line 261
    const-string v1, "GameHelper: you called GameHelper.createApiClientBuilder() after calling setup. You can only get a client builder BEFORE performing setup."

    .line 263
    .local v1, "error":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->logError(Ljava/lang/String;)V

    .line 264
    new-instance v2, Ljava/lang/IllegalStateException;

    invoke-direct {v2, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 267
    .end local v1    # "error":Ljava/lang/String;
    :cond_0
    new-instance v0, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 268
    iget-object v2, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    .line 267
    invoke-direct {v0, v2, p0, p0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)V

    .line 270
    .local v0, "builder":Lcom/google/android/gms/common/api/GoogleApiClient$Builder;
    iget v2, p0, Lcom/prime31/GameHelper;->mRequestedClients:I

    and-int/lit8 v2, v2, 0x1

    if-eqz v2, :cond_1

    .line 271
    sget-object v2, Lcom/google/android/gms/games/Games;->API:Lcom/google/android/gms/common/api/Api;

    iget-object v3, p0, Lcom/prime31/GameHelper;->mGamesApiOptions:Lcom/google/android/gms/games/Games$GamesOptions;

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addApi(Lcom/google/android/gms/common/api/Api;Lcom/google/android/gms/common/api/Api$ApiOptions$HasOptions;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 272
    sget-object v2, Lcom/google/android/gms/games/Games;->SCOPE_GAMES:Lcom/google/android/gms/common/api/Scope;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addScope(Lcom/google/android/gms/common/api/Scope;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 275
    :cond_1
    iget v2, p0, Lcom/prime31/GameHelper;->mRequestedClients:I

    and-int/lit8 v2, v2, 0x2

    if-eqz v2, :cond_2

    .line 276
    sget-object v2, Lcom/google/android/gms/plus/Plus;->API:Lcom/google/android/gms/common/api/Api;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addApi(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 277
    sget-object v2, Lcom/google/android/gms/plus/Plus;->SCOPE_PLUS_LOGIN:Lcom/google/android/gms/common/api/Scope;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addScope(Lcom/google/android/gms/common/api/Scope;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 280
    :cond_2
    iget v2, p0, Lcom/prime31/GameHelper;->mRequestedClients:I

    and-int/lit8 v2, v2, 0x8

    if-eqz v2, :cond_3

    .line 281
    sget-object v2, Lcom/google/android/gms/drive/Drive;->SCOPE_APPFOLDER:Lcom/google/android/gms/common/api/Scope;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addScope(Lcom/google/android/gms/common/api/Scope;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 282
    sget-object v2, Lcom/google/android/gms/drive/Drive;->API:Lcom/google/android/gms/common/api/Api;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addApi(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 285
    :cond_3
    iput-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClientBuilder:Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 286
    return-object v0
.end method

.method debugLog(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 998
    iget-boolean v0, p0, Lcom/prime31/GameHelper;->mDebugLog:Z

    if-eqz v0, :cond_0

    .line 999
    const-string v0, "Prime31-GH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "GameHelper: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1001
    :cond_0
    return-void
.end method

.method public disconnect()V
    .locals 2

    .prologue
    .line 870
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 871
    const-string v0, "Disconnecting client."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 872
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->disconnect()V

    .line 877
    :goto_0
    return-void

    .line 874
    :cond_0
    const-string v0, "Prime31-GH"

    .line 875
    const-string v1, "disconnect() called when client was already disconnected."

    .line 874
    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public enableDebugLog(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 503
    iput-boolean p1, p0, Lcom/prime31/GameHelper;->mDebugLog:Z

    .line 504
    if-eqz p1, :cond_0

    .line 505
    const-string v0, "Debug log enabled."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 507
    :cond_0
    return-void
.end method

.method public enableDebugLog(ZLjava/lang/String;)V
    .locals 2
    .param p1, "enabled"    # Z
    .param p2, "tag"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 511
    const-string v0, "Prime31-GH"

    const-string v1, "GameHelper.enableDebugLog(boolean,String) is deprecated. Use GameHelper.enableDebugLog(boolean)"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 513
    invoke-virtual {p0, p1}, Lcom/prime31/GameHelper;->enableDebugLog(Z)V

    .line 514
    return-void
.end method

.method public getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;
    .locals 2

    .prologue
    .line 322
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-nez v0, :cond_0

    .line 323
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 324
    const-string v1, "No GoogleApiClient. Did you call setup()?"

    .line 323
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 326
    :cond_0
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    return-object v0
.end method

.method public getInvitation()Lcom/google/android/gms/games/multiplayer/Invitation;
    .locals 2

    .prologue
    .line 434
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-nez v0, :cond_0

    .line 435
    const-string v0, "Prime31-GH"

    .line 436
    const-string v1, "Warning: getInvitation() should only be called when signed in, that is, after getting onSignInSuceeded()"

    .line 435
    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 439
    :cond_0
    iget-object v0, p0, Lcom/prime31/GameHelper;->mInvitation:Lcom/google/android/gms/games/multiplayer/Invitation;

    return-object v0
.end method

.method public getInvitationId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 416
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-nez v0, :cond_0

    .line 417
    const-string v0, "Prime31-GH"

    .line 418
    const-string v1, "Warning: getInvitationId() should only be called when signed in, that is, after getting onSignInSuceeded()"

    .line 417
    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 421
    :cond_0
    iget-object v0, p0, Lcom/prime31/GameHelper;->mInvitation:Lcom/google/android/gms/games/multiplayer/Invitation;

    if-nez v0, :cond_1

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/prime31/GameHelper;->mInvitation:Lcom/google/android/gms/games/multiplayer/Invitation;

    invoke-interface {v0}, Lcom/google/android/gms/games/multiplayer/Invitation;->getInvitationId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getRequests()Ljava/util/ArrayList;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/games/request/GameRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 493
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-nez v0, :cond_0

    .line 494
    const-string v0, "Prime31-GH"

    const-string v1, "Warning: getRequests() should only be called when signed in, that is, after getting onSignInSuceeded()"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 498
    :cond_0
    iget-object v0, p0, Lcom/prime31/GameHelper;->mRequests:Ljava/util/ArrayList;

    return-object v0
.end method

.method getSignInCancellations()I
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 746
    iget-object v1, p0, Lcom/prime31/GameHelper;->mAppContext:Landroid/content/Context;

    .line 747
    const-string v2, "GAMEHELPER_SHARED_PREFS"

    .line 746
    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 748
    .local v0, "sp":Landroid/content/SharedPreferences;
    const-string v1, "KEY_SIGN_IN_CANCELLATIONS"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    return v1
.end method

.method public getSignInError()Lcom/prime31/GameHelper$SignInFailureReason;
    .locals 1

    .prologue
    .line 352
    iget-object v0, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    return-object v0
.end method

.method public getTurnBasedMatch()Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
    .locals 2

    .prologue
    .line 475
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-nez v0, :cond_0

    .line 476
    const-string v0, "Prime31-GH"

    .line 477
    const-string v1, "Warning: getTurnBasedMatch() should only be called when signed in, that is, after getting onSignInSuceeded()"

    .line 476
    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 480
    :cond_0
    iget-object v0, p0, Lcom/prime31/GameHelper;->mTurnBasedMatch:Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;

    return-object v0
.end method

.method giveUp(Lcom/prime31/GameHelper$SignInFailureReason;)V
    .locals 3
    .param p1, "reason"    # Lcom/prime31/GameHelper$SignInFailureReason;

    .prologue
    const/4 v2, 0x0

    .line 887
    iput-boolean v2, p0, Lcom/prime31/GameHelper;->mConnectOnStart:Z

    .line 888
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->disconnect()V

    .line 889
    iput-object p1, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    .line 891
    iget v0, p1, Lcom/prime31/GameHelper$SignInFailureReason;->mActivityResultCode:I

    const/16 v1, 0x2714

    if-ne v0, v1, :cond_0

    .line 893
    iget-object v0, p0, Lcom/prime31/GameHelper;->mAppContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/prime31/GameHelperUtils;->printMisconfiguredDebugInfo(Landroid/content/Context;)V

    .line 896
    :cond_0
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->showFailureDialog()V

    .line 897
    iput-boolean v2, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 898
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->notifyListener(Z)V

    .line 899
    return-void
.end method

.method public hasInvitation()Z
    .locals 1

    .prologue
    .line 443
    iget-object v0, p0, Lcom/prime31/GameHelper;->mInvitation:Lcom/google/android/gms/games/multiplayer/Invitation;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasRequests()Z
    .locals 1

    .prologue
    .line 451
    iget-object v0, p0, Lcom/prime31/GameHelper;->mRequests:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasSignInError()Z
    .locals 1

    .prologue
    .line 344
    iget-object v0, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasTurnBasedMatch()Z
    .locals 1

    .prologue
    .line 447
    iget-object v0, p0, Lcom/prime31/GameHelper;->mTurnBasedMatch:Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method incrementSignInCancellations()I
    .locals 5

    .prologue
    .line 755
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->getSignInCancellations()I

    move-result v0

    .line 756
    .local v0, "cancellations":I
    iget-object v2, p0, Lcom/prime31/GameHelper;->mAppContext:Landroid/content/Context;

    .line 757
    const-string v3, "GAMEHELPER_SHARED_PREFS"

    const/4 v4, 0x0

    .line 756
    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 757
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 758
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "KEY_SIGN_IN_CANCELLATIONS"

    add-int/lit8 v3, v0, 0x1

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 759
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 760
    add-int/lit8 v2, v0, 0x1

    return v2
.end method

.method public isConnecting()Z
    .locals 1

    .prologue
    .line 336
    iget-boolean v0, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    return v0
.end method

.method public isSignedIn()Z
    .locals 1

    .prologue
    .line 331
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

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

.method logError(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 1008
    const-string v0, "Prime31-GH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "*** GameHelper ERROR: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1009
    return-void
.end method

.method logWarn(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 1004
    const-string v0, "Prime31-GH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "!!! GameHelper WARNING: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1005
    return-void
.end method

.method public makeSimpleDialog(Ljava/lang/String;)Landroid/app/Dialog;
    .locals 1
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 982
    iget-object v0, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    if-nez v0, :cond_0

    .line 983
    const-string v0, "*** makeSimpleDialog failed: no current Activity!"

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->logError(Ljava/lang/String;)V

    .line 984
    const/4 v0, 0x0

    .line 986
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    invoke-static {v0, p1}, Lcom/prime31/GameHelper;->makeSimpleDialog(Landroid/app/Activity;Ljava/lang/String;)Landroid/app/Dialog;

    move-result-object v0

    goto :goto_0
.end method

.method public makeSimpleDialog(Ljava/lang/String;Ljava/lang/String;)Landroid/app/Dialog;
    .locals 1
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;

    .prologue
    .line 990
    iget-object v0, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    if-nez v0, :cond_0

    .line 991
    const-string v0, "*** makeSimpleDialog failed: no current Activity!"

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->logError(Ljava/lang/String;)V

    .line 992
    const/4 v0, 0x0

    .line 994
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    invoke-static {v0, p1, p2}, Lcom/prime31/GameHelper;->makeSimpleDialog(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)Landroid/app/Dialog;

    move-result-object v0

    goto :goto_0
.end method

.method notifyListener(Z)V
    .locals 2
    .param p1, "success"    # Z

    .prologue
    .line 608
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v0, "Notifying LISTENER of sign-in "

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 609
    if-eqz p1, :cond_1

    const-string v0, "SUCCESS"

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 608
    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 612
    iget-object v0, p0, Lcom/prime31/GameHelper;->mListener:Lcom/prime31/GameHelper$GameHelperListener;

    if-eqz v0, :cond_0

    .line 613
    if-eqz p1, :cond_3

    .line 614
    iget-object v0, p0, Lcom/prime31/GameHelper;->mListener:Lcom/prime31/GameHelper$GameHelperListener;

    invoke-interface {v0}, Lcom/prime31/GameHelper$GameHelperListener;->onSignInSucceeded()V

    .line 619
    :cond_0
    :goto_1
    return-void

    .line 610
    :cond_1
    iget-object v0, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    if-eqz v0, :cond_2

    const-string v0, "FAILURE (error)"

    goto :goto_0

    .line 611
    :cond_2
    const-string v0, "FAILURE (no error)"

    goto :goto_0

    .line 616
    :cond_3
    iget-object v0, p0, Lcom/prime31/GameHelper;->mListener:Lcom/prime31/GameHelper$GameHelperListener;

    invoke-interface {v0}, Lcom/prime31/GameHelper$GameHelperListener;->onSignInFailed()V

    goto :goto_1
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 6
    .param p1, "requestCode"    # I
    .param p2, "responseCode"    # I
    .param p3, "intent"    # Landroid/content/Intent;

    .prologue
    const/16 v5, 0x2329

    const/4 v4, 0x0

    .line 552
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "onActivityResult: req="

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 553
    if-ne p1, v5, :cond_0

    const-string v2, "RC_RESOLVE"

    :goto_0
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 554
    const-string v3, ", resp="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 555
    invoke-static {p2}, Lcom/prime31/GameHelperUtils;->activityResponseCodeToString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 552
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 556
    if-eq p1, v5, :cond_1

    .line 557
    const-string v2, "onActivityResult: request code not meant for us. Ignoring."

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 605
    :goto_1
    return-void

    .line 554
    :cond_0
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 562
    :cond_1
    iput-boolean v4, p0, Lcom/prime31/GameHelper;->mExpectingResolution:Z

    .line 564
    iget-boolean v2, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    if-nez v2, :cond_2

    .line 565
    const-string v2, "onActivityResult: ignoring because we are not connecting."

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    goto :goto_1

    .line 571
    :cond_2
    const/4 v2, -0x1

    if-ne p2, v2, :cond_3

    .line 573
    const-string v2, "onAR: Resolution was RESULT_OK, so connecting current client again."

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 574
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->connect()V

    goto :goto_1

    .line 575
    :cond_3
    const/16 v2, 0x2711

    if-ne p2, v2, :cond_4

    .line 576
    const-string v2, "onAR: Resolution was RECONNECT_REQUIRED, so reconnecting."

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 577
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->connect()V

    goto :goto_1

    .line 578
    :cond_4
    if-nez p2, :cond_5

    .line 580
    const-string v2, "onAR: Got a cancellation result, so disconnecting."

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 581
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/prime31/GameHelper;->mSignInCancelled:Z

    .line 582
    iput-boolean v4, p0, Lcom/prime31/GameHelper;->mConnectOnStart:Z

    .line 583
    iput-boolean v4, p0, Lcom/prime31/GameHelper;->mUserInitiatedSignIn:Z

    .line 584
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    .line 585
    iput-boolean v4, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 586
    iget-object v2, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v2}, Lcom/google/android/gms/common/api/GoogleApiClient;->disconnect()V

    .line 589
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->getSignInCancellations()I

    move-result v1

    .line 590
    .local v1, "prevCancellations":I
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->incrementSignInCancellations()I

    move-result v0

    .line 591
    .local v0, "newCancellations":I
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "onAR: # of cancellations "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " --> "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 592
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", max "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/prime31/GameHelper;->mMaxAutoSignInAttempts:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 591
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 594
    invoke-virtual {p0, v4}, Lcom/prime31/GameHelper;->notifyListener(Z)V

    goto :goto_1

    .line 598
    .end local v0    # "newCancellations":I
    .end local v1    # "prevCancellations":I
    :cond_5
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "onAR: responseCode="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 600
    invoke-static {p2}, Lcom/prime31/GameHelperUtils;->activityResponseCodeToString(I)Ljava/lang/String;

    move-result-object v3

    .line 599
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 601
    const-string v3, ", so giving up."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 598
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 602
    new-instance v2, Lcom/prime31/GameHelper$SignInFailureReason;

    iget-object v3, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    invoke-virtual {v3}, Lcom/google/android/gms/common/ConnectionResult;->getErrorCode()I

    move-result v3

    .line 603
    invoke-direct {v2, v3, p2}, Lcom/prime31/GameHelper$SignInFailureReason;-><init>(II)V

    .line 602
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->giveUp(Lcom/prime31/GameHelper$SignInFailureReason;)V

    goto/16 :goto_1
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "connectionHint"    # Landroid/os/Bundle;

    .prologue
    .line 700
    const-string v1, "onConnected: connected!"

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 702
    if-eqz p1, :cond_2

    .line 703
    const-string v1, "onConnected: connection hint provided. Checking for invite."

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 705
    const-string v1, "invitation"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/games/multiplayer/Invitation;

    .line 706
    .local v0, "inv":Lcom/google/android/gms/games/multiplayer/Invitation;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lcom/google/android/gms/games/multiplayer/Invitation;->getInvitationId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 708
    const-string v1, "onConnected: connection hint has a room invite!"

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 709
    iput-object v0, p0, Lcom/prime31/GameHelper;->mInvitation:Lcom/google/android/gms/games/multiplayer/Invitation;

    .line 710
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Invitation ID: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/prime31/GameHelper;->mInvitation:Lcom/google/android/gms/games/multiplayer/Invitation;

    invoke-interface {v2}, Lcom/google/android/gms/games/multiplayer/Invitation;->getInvitationId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 714
    :cond_0
    sget-object v1, Lcom/google/android/gms/games/Games;->Requests:Lcom/google/android/gms/games/request/Requests;

    .line 715
    invoke-interface {v1, p1}, Lcom/google/android/gms/games/request/Requests;->getGameRequestsFromBundle(Landroid/os/Bundle;)Ljava/util/ArrayList;

    move-result-object v1

    .line 714
    iput-object v1, p0, Lcom/prime31/GameHelper;->mRequests:Ljava/util/ArrayList;

    .line 716
    iget-object v1, p0, Lcom/prime31/GameHelper;->mRequests:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 718
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "onConnected: connection hint has "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/prime31/GameHelper;->mRequests:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 719
    const-string v2, " request(s)"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 718
    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 722
    :cond_1
    const-string v1, "onConnected: connection hint provided. Checking for TBMP game."

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 724
    const-string v1, "turn_based_match"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;

    .line 723
    iput-object v1, p0, Lcom/prime31/GameHelper;->mTurnBasedMatch:Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;

    .line 728
    .end local v0    # "inv":Lcom/google/android/gms/games/multiplayer/Invitation;
    :cond_2
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->succeedSignIn()V

    .line 729
    return-void
.end method

.method public onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V
    .locals 5
    .param p1, "result"    # Lcom/google/android/gms/common/ConnectionResult;

    .prologue
    const/4 v4, 0x0

    .line 776
    const-string v2, "onConnectionFailed"

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 778
    iput-object p1, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    .line 779
    const-string v2, "Connection failure:"

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 780
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "   - code: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 781
    iget-object v3, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    .line 782
    invoke-virtual {v3}, Lcom/google/android/gms/common/ConnectionResult;->getErrorCode()I

    move-result v3

    .line 781
    invoke-static {v3}, Lcom/prime31/GameHelperUtils;->errorCodeToString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 780
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 783
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "   - resolvable: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    invoke-virtual {v3}, Lcom/google/android/gms/common/ConnectionResult;->hasResolution()Z

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 784
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "   - details: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    invoke-virtual {v3}, Lcom/google/android/gms/common/ConnectionResult;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 786
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->getSignInCancellations()I

    move-result v0

    .line 787
    .local v0, "cancellations":I
    const/4 v1, 0x0

    .line 789
    .local v1, "shouldResolve":Z
    iget-boolean v2, p0, Lcom/prime31/GameHelper;->mUserInitiatedSignIn:Z

    if-eqz v2, :cond_0

    .line 790
    const-string v2, "onConnectionFailed: WILL resolve because user initiated sign-in."

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 791
    const/4 v1, 0x1

    .line 811
    :goto_0
    if-nez v1, :cond_3

    .line 813
    const-string v2, "onConnectionFailed: since we won\'t resolve, failing now."

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 814
    iput-object p1, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    .line 815
    iput-boolean v4, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 816
    invoke-virtual {p0, v4}, Lcom/prime31/GameHelper;->notifyListener(Z)V

    .line 826
    :goto_1
    return-void

    .line 792
    :cond_0
    iget-boolean v2, p0, Lcom/prime31/GameHelper;->mSignInCancelled:Z

    if-eqz v2, :cond_1

    .line 793
    const-string v2, "onConnectionFailed WILL NOT resolve (user already cancelled once)."

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 794
    const/4 v1, 0x0

    .line 795
    goto :goto_0

    :cond_1
    iget v2, p0, Lcom/prime31/GameHelper;->mMaxAutoSignInAttempts:I

    if-ge v0, v2, :cond_2

    .line 796
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "onConnectionFailed: WILL resolve because we have below the max# of attempts, "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 798
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 799
    const-string v3, " < "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 800
    iget v3, p0, Lcom/prime31/GameHelper;->mMaxAutoSignInAttempts:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 796
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 801
    const/4 v1, 0x1

    .line 802
    goto :goto_0

    .line 803
    :cond_2
    const/4 v1, 0x0

    .line 804
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "onConnectionFailed: Will NOT resolve; not user-initiated and max attempts reached: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 806
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 807
    const-string v3, " >= "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 808
    iget v3, p0, Lcom/prime31/GameHelper;->mMaxAutoSignInAttempts:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 804
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    goto :goto_0

    .line 820
    :cond_3
    const-string v2, "onConnectionFailed: resolving problem..."

    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 825
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->resolveConnectionResult()V

    goto :goto_1
.end method

.method public onConnectionSuspended(I)V
    .locals 3
    .param p1, "cause"    # I

    .prologue
    const/4 v2, 0x0

    .line 904
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "onConnectionSuspended, cause="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 905
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->disconnect()V

    .line 906
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    .line 907
    const-string v0, "Making extraordinary call to onSignInFailed callback"

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 908
    iput-boolean v2, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 909
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->notifyListener(Z)V

    .line 910
    return-void
.end method

.method public onStart(Landroid/app/Activity;)V
    .locals 4
    .param p1, "act"    # Landroid/app/Activity;

    .prologue
    .line 362
    iput-object p1, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    .line 363
    invoke-virtual {p1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/GameHelper;->mAppContext:Landroid/content/Context;

    .line 365
    const-string v0, "onStart"

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 366
    const-string v0, "onStart"

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->assertConfigured(Ljava/lang/String;)V

    .line 368
    iget-boolean v0, p0, Lcom/prime31/GameHelper;->mConnectOnStart:Z

    if-eqz v0, :cond_1

    .line 369
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 370
    const-string v0, "Prime31-GH"

    .line 371
    const-string v1, "GameHelper: client was already connected on onStart()"

    .line 370
    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 387
    :goto_0
    return-void

    .line 373
    :cond_0
    const-string v0, "Connecting client."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 374
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 375
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->connect()V

    goto :goto_0

    .line 378
    :cond_1
    const-string v0, "Not attempting to connect becase mConnectOnStart=false"

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 379
    const-string v0, "Instead, reporting a sign-in failure."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 380
    iget-object v0, p0, Lcom/prime31/GameHelper;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/prime31/GameHelper$1;

    invoke-direct {v1, p0}, Lcom/prime31/GameHelper$1;-><init>(Lcom/prime31/GameHelper;)V

    .line 385
    const-wide/16 v2, 0x3e8

    .line 380
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method public onStop()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 391
    const-string v0, "onStop"

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 392
    const-string v0, "onStop"

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->assertConfigured(Ljava/lang/String;)V

    .line 393
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 394
    const-string v0, "Disconnecting client due to onStop"

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 395
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->disconnect()V

    .line 399
    :goto_0
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 400
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mExpectingResolution:Z

    .line 403
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    .line 404
    return-void

    .line 397
    :cond_0
    const-string v0, "Client already disconnected when we got onStop."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public reconnectClient()V
    .locals 2

    .prologue
    .line 687
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-nez v0, :cond_0

    .line 688
    const-string v0, "Prime31-GH"

    const-string v1, "reconnectClient() called when client is not connected."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 690
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->connect()V

    .line 695
    :goto_0
    return-void

    .line 692
    :cond_0
    const-string v0, "Reconnecting client."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 693
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->reconnect()V

    goto :goto_0
.end method

.method resetSignInCancellations()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 766
    iget-object v1, p0, Lcom/prime31/GameHelper;->mAppContext:Landroid/content/Context;

    .line 767
    const-string v2, "GAMEHELPER_SHARED_PREFS"

    .line 766
    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 767
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 768
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "KEY_SIGN_IN_CANCELLATIONS"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 769
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 770
    return-void
.end method

.method resolveConnectionResult()V
    .locals 4

    .prologue
    .line 835
    iget-boolean v1, p0, Lcom/prime31/GameHelper;->mExpectingResolution:Z

    if-eqz v1, :cond_0

    .line 836
    const-string v1, "We\'re already expecting the result of a previous resolution."

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 867
    :goto_0
    return-void

    .line 840
    :cond_0
    iget-object v1, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    if-nez v1, :cond_1

    .line 841
    const-string v1, "Prime31-GH"

    const-string v2, "Ignoring attempt to resolve connection result without an active Activity."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 845
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "resolveConnectionResult: trying to resolve result: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 846
    iget-object v2, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 845
    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 847
    iget-object v1, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    invoke-virtual {v1}, Lcom/google/android/gms/common/ConnectionResult;->hasResolution()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 849
    const-string v1, "Result has resolution. Starting it."

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 853
    const/4 v1, 0x1

    :try_start_0
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mExpectingResolution:Z

    .line 854
    iget-object v1, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    iget-object v2, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    .line 855
    const/16 v3, 0x2329

    .line 854
    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/common/ConnectionResult;->startResolutionForResult(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 856
    :catch_0
    move-exception v0

    .line 858
    .local v0, "e":Landroid/content/IntentSender$SendIntentException;
    const-string v1, "SendIntentException, so connecting again."

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 859
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->connect()V

    goto :goto_0

    .line 864
    .end local v0    # "e":Landroid/content/IntentSender$SendIntentException;
    :cond_2
    const-string v1, "resolveConnectionResult: result has no resolution. Giving up."

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 865
    new-instance v1, Lcom/prime31/GameHelper$SignInFailureReason;

    iget-object v2, p0, Lcom/prime31/GameHelper;->mConnectionResult:Lcom/google/android/gms/common/ConnectionResult;

    invoke-virtual {v2}, Lcom/google/android/gms/common/ConnectionResult;->getErrorCode()I

    move-result v2

    invoke-direct {v1, v2}, Lcom/prime31/GameHelper$SignInFailureReason;-><init>(I)V

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->giveUp(Lcom/prime31/GameHelper$SignInFailureReason;)V

    goto :goto_0
.end method

.method public setConnectOnStart(Z)V
    .locals 2
    .param p1, "connectOnStart"    # Z

    .prologue
    .line 1051
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Forcing mConnectOnStart="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 1052
    iput-boolean p1, p0, Lcom/prime31/GameHelper;->mConnectOnStart:Z

    .line 1053
    return-void
.end method

.method public setGamesApiOptions(Lcom/google/android/gms/games/Games$GamesOptions;)V
    .locals 0
    .param p1, "options"    # Lcom/google/android/gms/games/Games$GamesOptions;

    .prologue
    .line 239
    invoke-direct {p0}, Lcom/prime31/GameHelper;->doApiOptionsPreCheck()V

    .line 240
    iput-object p1, p0, Lcom/prime31/GameHelper;->mGamesApiOptions:Lcom/google/android/gms/games/Games$GamesOptions;

    .line 241
    return-void
.end method

.method public setMaxAutoSignInAttempts(I)V
    .locals 0
    .param p1, "max"    # I

    .prologue
    .line 211
    iput p1, p0, Lcom/prime31/GameHelper;->mMaxAutoSignInAttempts:I

    .line 212
    return-void
.end method

.method public setPlusApiOptions(Lcom/google/android/gms/plus/Plus$PlusOptions;)V
    .locals 0
    .param p1, "options"    # Lcom/google/android/gms/plus/Plus$PlusOptions;

    .prologue
    .line 249
    invoke-direct {p0}, Lcom/prime31/GameHelper;->doApiOptionsPreCheck()V

    .line 250
    iput-object p1, p0, Lcom/prime31/GameHelper;->mPlusApiOptions:Lcom/google/android/gms/plus/Plus$PlusOptions;

    .line 251
    return-void
.end method

.method public setShowErrorDialogs(Z)V
    .locals 0
    .param p1, "show"    # Z

    .prologue
    .line 357
    iput-boolean p1, p0, Lcom/prime31/GameHelper;->mShowErrorDialogs:Z

    .line 358
    return-void
.end method

.method public setup(Lcom/prime31/GameHelper$GameHelperListener;)V
    .locals 3
    .param p1, "listener"    # Lcom/prime31/GameHelper$GameHelperListener;

    .prologue
    .line 299
    iget-boolean v1, p0, Lcom/prime31/GameHelper;->mSetupDone:Z

    if-eqz v1, :cond_0

    .line 300
    const-string v0, "GameHelper: you cannot call GameHelper.setup() more than once!"

    .line 301
    .local v0, "error":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->logError(Ljava/lang/String;)V

    .line 302
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 304
    .end local v0    # "error":Ljava/lang/String;
    :cond_0
    iput-object p1, p0, Lcom/prime31/GameHelper;->mListener:Lcom/prime31/GameHelper$GameHelperListener;

    .line 305
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Setup: requested clients: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcom/prime31/GameHelper;->mRequestedClients:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 307
    iget-object v1, p0, Lcom/prime31/GameHelper;->mGoogleApiClientBuilder:Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    if-nez v1, :cond_1

    .line 309
    invoke-virtual {p0}, Lcom/prime31/GameHelper;->createApiClientBuilder()Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 312
    :cond_1
    iget-object v1, p0, Lcom/prime31/GameHelper;->mGoogleApiClientBuilder:Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    invoke-virtual {v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->build()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v1

    iput-object v1, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 313
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/prime31/GameHelper;->mGoogleApiClientBuilder:Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    .line 314
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mSetupDone:Z

    .line 315
    return-void
.end method

.method public showFailureDialog()V
    .locals 4

    .prologue
    .line 913
    iget-object v2, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    if-eqz v2, :cond_0

    .line 914
    iget-object v2, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    invoke-virtual {v2}, Lcom/prime31/GameHelper$SignInFailureReason;->getServiceErrorCode()I

    move-result v1

    .line 915
    .local v1, "errorCode":I
    iget-object v2, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    invoke-virtual {v2}, Lcom/prime31/GameHelper$SignInFailureReason;->getActivityResultCode()I

    move-result v0

    .line 917
    .local v0, "actResp":I
    iget-boolean v2, p0, Lcom/prime31/GameHelper;->mShowErrorDialogs:Z

    if-eqz v2, :cond_1

    .line 918
    iget-object v2, p0, Lcom/prime31/GameHelper;->mActivity:Landroid/app/Activity;

    invoke-static {v2, v0, v1}, Lcom/prime31/GameHelper;->showFailureDialog(Landroid/app/Activity;II)V

    .line 924
    .end local v0    # "actResp":I
    .end local v1    # "errorCode":I
    :cond_0
    :goto_0
    return-void

    .line 920
    .restart local v0    # "actResp":I
    .restart local v1    # "errorCode":I
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Not showing error dialog because mShowErrorDialogs==false. Error was: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 921
    iget-object v3, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 920
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public signOut()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 518
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v0

    if-nez v0, :cond_0

    .line 520
    const-string v0, "signOut: was already disconnected, ignoring."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 543
    :goto_0
    return-void

    .line 526
    :cond_0
    iget v0, p0, Lcom/prime31/GameHelper;->mRequestedClients:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_1

    .line 527
    const-string v0, "Clearing default account on PlusClient."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 528
    sget-object v0, Lcom/google/android/gms/plus/Plus;->AccountApi:Lcom/google/android/gms/plus/Account;

    iget-object v1, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v0, v1}, Lcom/google/android/gms/plus/Account;->clearDefaultAccount(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    .line 533
    :cond_1
    iget v0, p0, Lcom/prime31/GameHelper;->mRequestedClients:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_2

    .line 534
    const-string v0, "Signing out from the Google API Client."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 535
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-static {v0}, Lcom/google/android/gms/games/Games;->signOut(Lcom/google/android/gms/common/api/GoogleApiClient;)Lcom/google/android/gms/common/api/PendingResult;

    .line 539
    :cond_2
    const-string v0, "Disconnecting client."

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 540
    iput-boolean v2, p0, Lcom/prime31/GameHelper;->mConnectOnStart:Z

    .line 541
    iput-boolean v2, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 542
    iget-object v0, p0, Lcom/prime31/GameHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->disconnect()V

    goto :goto_0
.end method

.method succeedSignIn()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 732
    const-string v0, "succeedSignIn"

    invoke-virtual {p0, v0}, Lcom/prime31/GameHelper;->debugLog(Ljava/lang/String;)V

    .line 733
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/prime31/GameHelper;->mSignInFailureReason:Lcom/prime31/GameHelper$SignInFailureReason;

    .line 734
    iput-boolean v2, p0, Lcom/prime31/GameHelper;->mConnectOnStart:Z

    .line 735
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mUserInitiatedSignIn:Z

    .line 736
    iput-boolean v1, p0, Lcom/prime31/GameHelper;->mConnecting:Z

    .line 737
    invoke-virtual {p0, v2}, Lcom/prime31/GameHelper;->notifyListener(Z)V

    .line 738
    return-void
.end method
