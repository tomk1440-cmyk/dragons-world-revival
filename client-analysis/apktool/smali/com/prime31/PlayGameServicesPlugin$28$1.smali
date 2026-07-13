.class Lcom/prime31/PlayGameServicesPlugin$28$1;
.super Landroid/os/AsyncTask;
.source "PlayGameServicesPlugin.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/prime31/PlayGameServicesPlugin$28;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/prime31/PlayGameServicesPlugin$28;

.field private final synthetic val$conflictPolicy:I

.field private final synthetic val$createIfMissing:Z

.field private final synthetic val$data:[B

.field private final synthetic val$description:Ljava/lang/String;

.field private final synthetic val$snapshotName:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/prime31/PlayGameServicesPlugin$28;Ljava/lang/String;ZILjava/lang/String;[B)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->this$1:Lcom/prime31/PlayGameServicesPlugin$28;

    iput-object p2, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$snapshotName:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$createIfMissing:Z

    iput p4, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$conflictPolicy:I

    iput-object p5, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$description:Ljava/lang/String;

    iput-object p6, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$data:[B

    .line 1358
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Integer;
    .locals 10
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 1363
    iget-object v6, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->this$1:Lcom/prime31/PlayGameServicesPlugin$28;

    invoke-static {v6}, Lcom/prime31/PlayGameServicesPlugin$28;->access$0(Lcom/prime31/PlayGameServicesPlugin$28;)Lcom/prime31/PlayGameServicesPlugin;

    move-result-object v6

    iget-object v6, v6, Lcom/prime31/PlayGameServicesPlugin;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v6}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v6

    if-nez v6, :cond_0

    .line 1365
    const-string v6, "Prime31"

    const-string v7, "Aborting operation due to a null API client. This usually occurs when your game is backgrounded while attempting to access any Play SDK features."

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1366
    const/16 v6, 0xe

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    .line 1424
    :goto_0
    return-object v6

    .line 1371
    :cond_0
    const/4 v4, 0x0

    .line 1372
    .local v4, "snapshot":Lcom/google/android/gms/games/snapshot/Snapshot;
    :try_start_0
    sget-object v6, Lcom/google/android/gms/games/Games;->Snapshots:Lcom/google/android/gms/games/snapshot/Snapshots;

    iget-object v7, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->this$1:Lcom/prime31/PlayGameServicesPlugin$28;

    invoke-static {v7}, Lcom/prime31/PlayGameServicesPlugin$28;->access$0(Lcom/prime31/PlayGameServicesPlugin$28;)Lcom/prime31/PlayGameServicesPlugin;

    move-result-object v7

    iget-object v7, v7, Lcom/prime31/PlayGameServicesPlugin;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v7}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v7

    iget-object v8, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$snapshotName:Ljava/lang/String;

    iget-boolean v9, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$createIfMissing:Z

    invoke-interface {v6, v7, v8, v9}, Lcom/google/android/gms/games/snapshot/Snapshots;->open(Lcom/google/android/gms/common/api/GoogleApiClient;Ljava/lang/String;Z)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v6

    invoke-virtual {v6}, Lcom/google/android/gms/common/api/PendingResult;->await()Lcom/google/android/gms/common/api/Result;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/games/snapshot/Snapshots$OpenSnapshotResult;

    .line 1374
    .local v3, "openResult":Lcom/google/android/gms/games/snapshot/Snapshots$OpenSnapshotResult;
    invoke-interface {v3}, Lcom/google/android/gms/games/snapshot/Snapshots$OpenSnapshotResult;->getStatus()Lcom/google/android/gms/common/api/Status;

    move-result-object v6

    invoke-virtual {v6}, Lcom/google/android/gms/common/api/Status;->getStatusCode()I

    move-result v5

    .line 1375
    .local v5, "status":I
    const-string v6, "Prime31"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "snapshots.open result: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1376
    const/16 v6, 0xfa4

    if-ne v5, v6, :cond_2

    .line 1378
    const-string v6, "Prime31"

    const-string v7, "conflict found. handling now"

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1379
    iget-object v6, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->this$1:Lcom/prime31/PlayGameServicesPlugin$28;

    invoke-static {v6}, Lcom/prime31/PlayGameServicesPlugin$28;->access$0(Lcom/prime31/PlayGameServicesPlugin$28;)Lcom/prime31/PlayGameServicesPlugin;

    move-result-object v6

    const/4 v7, 0x0

    iget v8, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$conflictPolicy:I

    invoke-static {v6, v3, v7, v8}, Lcom/prime31/PlayGameServicesPlugin;->access$15(Lcom/prime31/PlayGameServicesPlugin;Lcom/google/android/gms/games/snapshot/Snapshots$OpenSnapshotResult;II)Lcom/google/android/gms/games/snapshot/Snapshot;

    move-result-object v4

    .line 1382
    if-eqz v4, :cond_1

    .line 1383
    const/4 v5, 0x0

    .line 1396
    :cond_1
    :goto_1
    if-nez v4, :cond_4

    .line 1398
    const-string v6, "Prime31"

    const-string v7, "snapshot is null so we cant write the data to it. bailing out."

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1399
    const/16 v6, 0xfa1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    goto :goto_0

    .line 1385
    :cond_2
    invoke-interface {v3}, Lcom/google/android/gms/games/snapshot/Snapshots$OpenSnapshotResult;->getStatus()Lcom/google/android/gms/common/api/Status;

    move-result-object v6

    invoke-virtual {v6}, Lcom/google/android/gms/common/api/Status;->isSuccess()Z

    move-result v6

    if-nez v6, :cond_3

    .line 1387
    const-string v6, "Prime31"

    const-string v7, "Could not open Snapshot for update."

    invoke-static {v6, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1388
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    goto :goto_0

    .line 1392
    :cond_3
    const-string v6, "Prime31"

    const-string v7, "should be all good opening snapshot. fetching from result now"

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1393
    invoke-interface {v3}, Lcom/google/android/gms/games/snapshot/Snapshots$OpenSnapshotResult;->getSnapshot()Lcom/google/android/gms/games/snapshot/Snapshot;

    move-result-object v4

    goto :goto_1

    .line 1403
    :cond_4
    new-instance v6, Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange$Builder;

    invoke-direct {v6}, Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange$Builder;-><init>()V

    .line 1404
    iget-object v7, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$description:Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange$Builder;->setDescription(Ljava/lang/String;)Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange$Builder;

    move-result-object v6

    .line 1405
    invoke-virtual {v6}, Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange$Builder;->build()Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange;

    move-result-object v2

    .line 1409
    .local v2, "metadataChange":Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange;
    const-string v6, "Prime31"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "writing "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$data:[B

    array-length v8, v8

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " bytes into snapshot contents"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1410
    invoke-interface {v4}, Lcom/google/android/gms/games/snapshot/Snapshot;->getSnapshotContents()Lcom/google/android/gms/games/snapshot/SnapshotContents;

    move-result-object v6

    iget-object v7, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->val$data:[B

    invoke-interface {v6, v7}, Lcom/google/android/gms/games/snapshot/SnapshotContents;->writeBytes([B)Z

    .line 1412
    sget-object v6, Lcom/google/android/gms/games/Games;->Snapshots:Lcom/google/android/gms/games/snapshot/Snapshots;

    iget-object v7, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->this$1:Lcom/prime31/PlayGameServicesPlugin$28;

    invoke-static {v7}, Lcom/prime31/PlayGameServicesPlugin$28;->access$0(Lcom/prime31/PlayGameServicesPlugin$28;)Lcom/prime31/PlayGameServicesPlugin;

    move-result-object v7

    iget-object v7, v7, Lcom/prime31/PlayGameServicesPlugin;->helper:Lcom/prime31/GameHelper;

    invoke-virtual {v7}, Lcom/prime31/GameHelper;->getApiClient()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v7

    invoke-interface {v6, v7, v4, v2}, Lcom/google/android/gms/games/snapshot/Snapshots;->commitAndClose(Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/games/snapshot/Snapshot;Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange;)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v6

    invoke-virtual {v6}, Lcom/google/android/gms/common/api/PendingResult;->await()Lcom/google/android/gms/common/api/Result;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/games/snapshot/Snapshots$CommitSnapshotResult;

    .line 1413
    .local v0, "commit":Lcom/google/android/gms/games/snapshot/Snapshots$CommitSnapshotResult;
    invoke-interface {v0}, Lcom/google/android/gms/games/snapshot/Snapshots$CommitSnapshotResult;->getStatus()Lcom/google/android/gms/common/api/Status;

    move-result-object v6

    invoke-virtual {v6}, Lcom/google/android/gms/common/api/Status;->isSuccess()Z

    move-result v6

    if-nez v6, :cond_5

    .line 1415
    const-string v6, "Prime31"

    const-string v7, "Failed to commit Snapshot."

    invoke-static {v6, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1416
    invoke-interface {v0}, Lcom/google/android/gms/games/snapshot/Snapshots$CommitSnapshotResult;->getStatus()Lcom/google/android/gms/common/api/Status;

    move-result-object v6

    invoke-virtual {v6}, Lcom/google/android/gms/common/api/Status;->getStatusCode()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    goto/16 :goto_0

    .line 1419
    :cond_5
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    goto/16 :goto_0

    .line 1421
    .end local v0    # "commit":Lcom/google/android/gms/games/snapshot/Snapshots$CommitSnapshotResult;
    .end local v2    # "metadataChange":Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange;
    .end local v3    # "openResult":Lcom/google/android/gms/games/snapshot/Snapshots$OpenSnapshotResult;
    .end local v5    # "status":I
    :catch_0
    move-exception v1

    .line 1423
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 1424
    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    goto/16 :goto_0
.end method

.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/prime31/PlayGameServicesPlugin$28$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method protected onPostExecute(Ljava/lang/Integer;)V
    .locals 4
    .param p1, "status"    # Ljava/lang/Integer;

    .prologue
    .line 1431
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-nez v1, :cond_0

    .line 1433
    iget-object v1, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->this$1:Lcom/prime31/PlayGameServicesPlugin$28;

    invoke-static {v1}, Lcom/prime31/PlayGameServicesPlugin$28;->access$0(Lcom/prime31/PlayGameServicesPlugin$28;)Lcom/prime31/PlayGameServicesPlugin;

    move-result-object v1

    const-string v2, "saveSnapshotSucceeded"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lcom/prime31/PlayGameServicesPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 1440
    :goto_0
    return-void

    .line 1437
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-static {v1}, Lcom/prime31/PlayGameServicesPlugin;->gamesStatusErrorCodeToString(I)Ljava/lang/String;

    move-result-object v0

    .line 1438
    .local v0, "statusString":Ljava/lang/String;
    iget-object v1, p0, Lcom/prime31/PlayGameServicesPlugin$28$1;->this$1:Lcom/prime31/PlayGameServicesPlugin$28;

    invoke-static {v1}, Lcom/prime31/PlayGameServicesPlugin$28;->access$0(Lcom/prime31/PlayGameServicesPlugin$28;)Lcom/prime31/PlayGameServicesPlugin;

    move-result-object v1

    const-string v2, "saveSnapshotFailed"

    invoke-virtual {v1, v2, v0}, Lcom/prime31/PlayGameServicesPlugin;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p0, p1}, Lcom/prime31/PlayGameServicesPlugin$28$1;->onPostExecute(Ljava/lang/Integer;)V

    return-void
.end method
