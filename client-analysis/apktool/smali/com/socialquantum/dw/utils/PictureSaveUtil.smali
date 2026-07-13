.class public Lcom/socialquantum/dw/utils/PictureSaveUtil;
.super Ljava/lang/Object;
.source "PictureSaveUtil.java"


# static fields
.field static final PROFILE_PICTURE_SAVED_KEY:Ljava/lang/String; = "profile_picture_saved"

.field private static final TAG:Ljava/lang/String; = "PictureSaveUtil"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ljava/lang/String;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-static {p0, p1}, Lcom/socialquantum/dw/utils/PictureSaveUtil;->savePictureFromResourcesPrivate(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static savePictureFromResources(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "pictureUri"    # Ljava/lang/String;
    .param p1, "savePath"    # Ljava/lang/String;

    .prologue
    .line 25
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v1, Lcom/socialquantum/dw/utils/PictureSaveUtil$1;

    invoke-direct {v1, p0, p1}, Lcom/socialquantum/dw/utils/PictureSaveUtil$1;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 31
    return-void
.end method

.method private static savePictureFromResourcesPrivate(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "pictureUri"    # Ljava/lang/String;
    .param p1, "savePath"    # Ljava/lang/String;

    .prologue
    .line 34
    sget-object v2, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gms/common/images/ImageManager;->create(Landroid/content/Context;)Lcom/google/android/gms/common/images/ImageManager;

    move-result-object v0

    .line 35
    .local v0, "manager":Lcom/google/android/gms/common/images/ImageManager;
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 38
    .local v1, "uri":Landroid/net/Uri;
    new-instance v2, Lcom/socialquantum/dw/utils/PictureSaveUtil$2;

    invoke-direct {v2, p1}, Lcom/socialquantum/dw/utils/PictureSaveUtil$2;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/images/ImageManager;->loadImage(Lcom/google/android/gms/common/images/ImageManager$OnImageLoadedListener;Landroid/net/Uri;)V

    .line 75
    return-void
.end method
