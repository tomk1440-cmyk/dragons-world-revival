.class Lcom/socialquantum/googleplay/extention/PlayGameService$1;
.super Ljava/lang/Object;
.source "PlayGameService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/socialquantum/googleplay/extention/PlayGameService;->forceDisconnect()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;


# direct methods
.method constructor <init>(Lcom/socialquantum/googleplay/extention/PlayGameService;)V
    .locals 0
    .param p1, "this$0"    # Lcom/socialquantum/googleplay/extention/PlayGameService;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$1;->this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 93
    iget-object v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$1;->this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;

    invoke-static {v0}, Lcom/socialquantum/googleplay/extention/PlayGameService;->access$000(Lcom/socialquantum/googleplay/extention/PlayGameService;)Lcom/prime31/GameHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->disconnect()V

    .line 94
    iget-object v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$1;->this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;

    const-string v1, "userSignedOut"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lcom/socialquantum/googleplay/extention/PlayGameService;->SendPrime31Message(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    return-void
.end method
