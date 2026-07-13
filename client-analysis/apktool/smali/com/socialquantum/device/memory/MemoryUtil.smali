.class public Lcom/socialquantum/device/memory/MemoryUtil;
.super Ljava/lang/Object;
.source "MemoryUtil.java"


# static fields
.field private static _instance:Lcom/socialquantum/device/memory/MemoryUtil;


# instance fields
.field private final CHUNK_ARRAY_SIZE:I

.field private final TAG:Ljava/lang/String;

.field private memoryList:Ljava/util/ArrayList;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    const-string v0, "MemoryUtil"

    iput-object v0, p0, Lcom/socialquantum/device/memory/MemoryUtil;->TAG:Ljava/lang/String;

    .line 13
    const v0, 0xf4240

    iput v0, p0, Lcom/socialquantum/device/memory/MemoryUtil;->CHUNK_ARRAY_SIZE:I

    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/socialquantum/device/memory/MemoryUtil;->memoryList:Ljava/util/ArrayList;

    .line 18
    return-void
.end method

.method public static Instance()Lcom/socialquantum/device/memory/MemoryUtil;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/socialquantum/device/memory/MemoryUtil;->_instance:Lcom/socialquantum/device/memory/MemoryUtil;

    if-nez v0, :cond_0

    new-instance v0, Lcom/socialquantum/device/memory/MemoryUtil;

    invoke-direct {v0}, Lcom/socialquantum/device/memory/MemoryUtil;-><init>()V

    sput-object v0, Lcom/socialquantum/device/memory/MemoryUtil;->_instance:Lcom/socialquantum/device/memory/MemoryUtil;

    .line 22
    :cond_0
    sget-object v0, Lcom/socialquantum/device/memory/MemoryUtil;->_instance:Lcom/socialquantum/device/memory/MemoryUtil;

    return-object v0
.end method


# virtual methods
.method public createMemoryChunk()V
    .locals 2

    .prologue
    .line 26
    const-string v0, "MemoryUtil"

    const-string v1, "Created memory chunk of size 4MB"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 27
    iget-object v0, p0, Lcom/socialquantum/device/memory/MemoryUtil;->memoryList:Ljava/util/ArrayList;

    const v1, 0xf4240

    new-array v1, v1, [I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 28
    return-void
.end method

.method public reportMemory(I)V
    .locals 4
    .param p1, "level"    # I

    .prologue
    .line 32
    :try_start_0
    const-string v1, "DeviceBridge"

    const-string v2, "HandleMemoryWarning"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 38
    :goto_0
    return-void

    .line 35
    :catch_0
    move-exception v0

    .line 36
    .local v0, "er":Ljava/lang/Throwable;
    :goto_1
    const-string v1, "MemoryUtil"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "LowMemoryWarning : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 35
    .end local v0    # "er":Ljava/lang/Throwable;
    :catch_1
    move-exception v0

    goto :goto_1
.end method
