.class Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;
.super Lcom/prime31/PlayGameServicesPlugin$ListenerBase;
.source "PlayGameServicesPlugin.java"

# interfaces
.implements Lcom/google/android/gms/common/api/ResultCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/prime31/PlayGameServicesPlugin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ScoreLoadListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/prime31/PlayGameServicesPlugin$ListenerBase;",
        "Lcom/google/android/gms/common/api/ResultCallback",
        "<",
        "Lcom/google/android/gms/games/leaderboard/Leaderboards$LoadScoresResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/prime31/PlayGameServicesPlugin;


# direct methods
.method public constructor <init>(Lcom/prime31/PlayGameServicesPlugin;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "successMethod"    # Ljava/lang/String;
    .param p3, "failedMethod"    # Ljava/lang/String;

    .prologue
    .line 1747
    iput-object p1, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->this$0:Lcom/prime31/PlayGameServicesPlugin;

    .line 1746
    invoke-direct {p0, p1}, Lcom/prime31/PlayGameServicesPlugin$ListenerBase;-><init>(Lcom/prime31/PlayGameServicesPlugin;)V

    .line 1748
    iput-object p3, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->_failedMethod:Ljava/lang/String;

    .line 1749
    iput-object p2, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->_successMethod:Ljava/lang/String;

    .line 1750
    return-void
.end method

.method public constructor <init>(Lcom/prime31/PlayGameServicesPlugin;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 2
    .param p2, "successMethod"    # Ljava/lang/String;
    .param p3, "failedMethod"    # Ljava/lang/String;
    .param p4, "reportedScore"    # J

    .prologue
    .line 1762
    invoke-direct {p0, p1, p2, p3}, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;-><init>(Lcom/prime31/PlayGameServicesPlugin;Ljava/lang/String;Ljava/lang/String;)V

    .line 1763
    invoke-static {p4, p5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->_reportedScoreString:Ljava/lang/String;

    .line 1764
    return-void
.end method

.method public constructor <init>(Lcom/prime31/PlayGameServicesPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "successMethod"    # Ljava/lang/String;
    .param p3, "failedMethod"    # Ljava/lang/String;
    .param p4, "id"    # Ljava/lang/String;

    .prologue
    .line 1755
    invoke-direct {p0, p1, p2, p3}, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;-><init>(Lcom/prime31/PlayGameServicesPlugin;Ljava/lang/String;Ljava/lang/String;)V

    .line 1756
    iput-object p4, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->_id:Ljava/lang/String;

    .line 1757
    return-void
.end method


# virtual methods
.method public bridge synthetic onResult(Lcom/google/android/gms/common/api/Result;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lcom/google/android/gms/games/leaderboard/Leaderboards$LoadScoresResult;

    invoke-virtual {p0, p1}, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->onResult(Lcom/google/android/gms/games/leaderboard/Leaderboards$LoadScoresResult;)V

    return-void
.end method

.method public onResult(Lcom/google/android/gms/games/leaderboard/Leaderboards$LoadScoresResult;)V
    .locals 7
    .param p1, "res"    # Lcom/google/android/gms/games/leaderboard/Leaderboards$LoadScoresResult;

    .prologue
    .line 1770
    invoke-interface {p1}, Lcom/google/android/gms/games/leaderboard/Leaderboards$LoadScoresResult;->getStatus()Lcom/google/android/gms/common/api/Status;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/common/api/Status;->getStatusCode()I

    move-result v2

    .line 1771
    .local v2, "statusCode":I
    const/4 v0, 0x0

    .line 1773
    .local v0, "error":Ljava/lang/String;
    packed-switch v2, :pswitch_data_0

    .line 1795
    :pswitch_0
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Unknown error: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1798
    :goto_0
    if-eqz v0, :cond_0

    .line 1799
    iget-object v3, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->this$0:Lcom/prime31/PlayGameServicesPlugin;

    iget-object v4, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->_failedMethod:Ljava/lang/String;

    iget-object v5, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->this$0:Lcom/prime31/PlayGameServicesPlugin;

    iget-object v6, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->_id:Ljava/lang/String;

    invoke-virtual {v5, v6, v0}, Lcom/prime31/PlayGameServicesPlugin;->jsonizeIdentiferAndError(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/prime31/PlayGameServicesPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 1800
    :cond_0
    return-void

    .line 1776
    :pswitch_1
    const-string v3, "Prime31"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "total scores loaded: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p1}, Lcom/google/android/gms/games/leaderboard/Leaderboards$LoadScoresResult;->getScores()Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;->getCount()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1777
    iget-object v3, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->this$0:Lcom/prime31/PlayGameServicesPlugin;

    invoke-interface {p1}, Lcom/google/android/gms/games/leaderboard/Leaderboards$LoadScoresResult;->getScores()Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;

    move-result-object v4

    iget-object v5, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->_id:Ljava/lang/String;

    invoke-static {v3, v4, v5}, Lcom/prime31/PlayGameServicesPlugin;->access$0(Lcom/prime31/PlayGameServicesPlugin;Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1778
    .local v1, "json":Ljava/lang/String;
    iget-object v3, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->this$0:Lcom/prime31/PlayGameServicesPlugin;

    iget-object v4, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->_successMethod:Ljava/lang/String;

    invoke-virtual {v3, v4, v1}, Lcom/prime31/PlayGameServicesPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1783
    .end local v1    # "json":Ljava/lang/String;
    :pswitch_2
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Network or unknown error: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1784
    goto :goto_0

    .line 1786
    :pswitch_3
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "License check failed: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1787
    goto :goto_0

    .line 1789
    :pswitch_4
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Reconnect required: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1790
    iget-object v3, p0, Lcom/prime31/PlayGameServicesPlugin$ScoreLoadListener;->this$0:Lcom/prime31/PlayGameServicesPlugin;

    iget-object v3, v3, Lcom/prime31/PlayGameServicesPlugin;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v3}, Lcom/prime31/GameHelper;->reconnectClient()V

    goto/16 :goto_0

    .line 1773
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_4
        :pswitch_2
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method
