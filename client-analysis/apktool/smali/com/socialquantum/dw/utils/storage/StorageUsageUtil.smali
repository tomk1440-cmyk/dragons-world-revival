.class public Lcom/socialquantum/dw/utils/storage/StorageUsageUtil;
.super Ljava/lang/Object;
.source "StorageUsageUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getFreeSpace()J
    .locals 8

    .prologue
    .line 15
    invoke-static {}, Lcom/socialquantum/dw/utils/storage/StorageUsageUtil;->getStatFs()Landroid/os/StatFs;

    move-result-object v4

    .line 16
    .local v4, "fs":Landroid/os/StatFs;
    invoke-virtual {v4}, Landroid/os/StatFs;->getAvailableBlocks()I

    move-result v5

    int-to-long v2, v5

    .line 17
    .local v2, "blocks":J
    invoke-virtual {v4}, Landroid/os/StatFs;->getBlockSize()I

    move-result v5

    int-to-long v0, v5

    .line 18
    .local v0, "blockSize":J
    mul-long v6, v0, v2

    return-wide v6
.end method

.method private static getStatFs()Landroid/os/StatFs;
    .locals 2

    .prologue
    .line 26
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 28
    .local v0, "path":Ljava/lang/String;
    new-instance v1, Landroid/os/StatFs;

    invoke-direct {v1, v0}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    return-object v1
.end method

.method public static getTotalSpace()J
    .locals 8

    .prologue
    .line 8
    invoke-static {}, Lcom/socialquantum/dw/utils/storage/StorageUsageUtil;->getStatFs()Landroid/os/StatFs;

    move-result-object v4

    .line 9
    .local v4, "fs":Landroid/os/StatFs;
    invoke-virtual {v4}, Landroid/os/StatFs;->getBlockCount()I

    move-result v5

    int-to-long v2, v5

    .line 10
    .local v2, "blocks":J
    invoke-virtual {v4}, Landroid/os/StatFs;->getBlockSize()I

    move-result v5

    int-to-long v0, v5

    .line 11
    .local v0, "blockSize":J
    mul-long v6, v0, v2

    return-wide v6
.end method

.method public static isStorageAvailable()Z
    .locals 2

    .prologue
    .line 22
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v0

    const-string v1, "mounted"

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
