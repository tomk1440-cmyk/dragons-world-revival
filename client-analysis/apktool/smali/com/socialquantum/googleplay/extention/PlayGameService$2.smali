.class Lcom/socialquantum/googleplay/extention/PlayGameService$2;
.super Ljava/lang/Object;
.source "PlayGameService.java"

# interfaces
.implements Lcom/google/android/gms/common/api/ResultCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/socialquantum/googleplay/extention/PlayGameService;->handleRequests(Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/common/api/ResultCallback",
        "<",
        "Lcom/google/android/gms/games/request/Requests$UpdateRequestsResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;

.field final synthetic val$gameRequestMap:Ljava/util/HashMap;


# direct methods
.method constructor <init>(Lcom/socialquantum/googleplay/extention/PlayGameService;Ljava/util/HashMap;)V
    .locals 0
    .param p1, "this$0"    # Lcom/socialquantum/googleplay/extention/PlayGameService;

    .prologue
    .line 149
    iput-object p1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$2;->this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;

    iput-object p2, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$2;->val$gameRequestMap:Ljava/util/HashMap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic onResult(Lcom/google/android/gms/common/api/Result;)V
    .locals 0

    .prologue
    .line 149
    check-cast p1, Lcom/google/android/gms/games/request/Requests$UpdateRequestsResult;

    invoke-virtual {p0, p1}, Lcom/socialquantum/googleplay/extention/PlayGameService$2;->onResult(Lcom/google/android/gms/games/request/Requests$UpdateRequestsResult;)V

    return-void
.end method

.method public onResult(Lcom/google/android/gms/games/request/Requests$UpdateRequestsResult;)V
    .locals 3
    .param p1, "result"    # Lcom/google/android/gms/games/request/Requests$UpdateRequestsResult;

    .prologue
    .line 152
    invoke-interface {p1}, Lcom/google/android/gms/games/request/Requests$UpdateRequestsResult;->getRequestIds()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    :pswitch_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 153
    .local v0, "requestId":Ljava/lang/String;
    iget-object v1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$2;->val$gameRequestMap:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 154
    invoke-interface {p1, v0}, Lcom/google/android/gms/games/request/Requests$UpdateRequestsResult;->getRequestOutcome(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_0

    .line 158
    iget-object v1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$2;->val$gameRequestMap:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/games/request/GameRequest;

    invoke-interface {v1}, Lcom/google/android/gms/games/request/GameRequest;->getType()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 165
    .end local v0    # "requestId":Ljava/lang/String;
    :cond_1
    return-void

    .line 158
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
