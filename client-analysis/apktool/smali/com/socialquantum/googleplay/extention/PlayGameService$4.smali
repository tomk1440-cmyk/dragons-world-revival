.class Lcom/socialquantum/googleplay/extention/PlayGameService$4;
.super Ljava/lang/Object;
.source "PlayGameService.java"

# interfaces
.implements Lcom/socialquantum/googleplay/extention/IFriendsLoaderListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/socialquantum/googleplay/extention/PlayGameService;->queryFriends()Z
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
    .line 208
    iput-object p1, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$4;->this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public LoadFriends(ILjava/util/ArrayList;)V
    .locals 1
    .param p1, "status"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/json/JSONObject;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 211
    .local p2, "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/json/JSONObject;>;"
    iget-object v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$4;->this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;

    invoke-static {v0, p1}, Lcom/socialquantum/googleplay/extention/PlayGameService;->access$302(Lcom/socialquantum/googleplay/extention/PlayGameService;I)I

    .line 212
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 213
    iget-object v0, p0, Lcom/socialquantum/googleplay/extention/PlayGameService$4;->this$0:Lcom/socialquantum/googleplay/extention/PlayGameService;

    invoke-static {v0, p2}, Lcom/socialquantum/googleplay/extention/PlayGameService;->access$200(Lcom/socialquantum/googleplay/extention/PlayGameService;Ljava/util/ArrayList;)V

    .line 214
    :cond_0
    return-void
.end method
