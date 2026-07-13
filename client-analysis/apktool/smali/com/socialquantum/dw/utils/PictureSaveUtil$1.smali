.class final Lcom/socialquantum/dw/utils/PictureSaveUtil$1;
.super Ljava/lang/Object;
.source "PictureSaveUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/socialquantum/dw/utils/PictureSaveUtil;->savePictureFromResources(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$pictureUri:Ljava/lang/String;

.field final synthetic val$savePath:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/socialquantum/dw/utils/PictureSaveUtil$1;->val$pictureUri:Ljava/lang/String;

    iput-object p2, p0, Lcom/socialquantum/dw/utils/PictureSaveUtil$1;->val$savePath:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 28
    iget-object v0, p0, Lcom/socialquantum/dw/utils/PictureSaveUtil$1;->val$pictureUri:Ljava/lang/String;

    iget-object v1, p0, Lcom/socialquantum/dw/utils/PictureSaveUtil$1;->val$savePath:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/socialquantum/dw/utils/PictureSaveUtil;->access$000(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    return-void
.end method
