.class Lcom/socialquantum/dw/utils/ClipBoardUtil$CopyExecutor;
.super Ljava/lang/Object;
.source "ClipBoardUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/socialquantum/dw/utils/ClipBoardUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "CopyExecutor"
.end annotation


# instance fields
.field private mActivity:Landroid/app/Activity;

.field private mText:Ljava/lang/String;

.field final synthetic this$0:Lcom/socialquantum/dw/utils/ClipBoardUtil;


# direct methods
.method constructor <init>(Lcom/socialquantum/dw/utils/ClipBoardUtil;Ljava/lang/String;Landroid/app/Activity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/socialquantum/dw/utils/ClipBoardUtil;
    .param p2, "copyText"    # Ljava/lang/String;
    .param p3, "context"    # Landroid/app/Activity;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/socialquantum/dw/utils/ClipBoardUtil$CopyExecutor;->this$0:Lcom/socialquantum/dw/utils/ClipBoardUtil;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p3, p0, Lcom/socialquantum/dw/utils/ClipBoardUtil$CopyExecutor;->mActivity:Landroid/app/Activity;

    .line 22
    iput-object p2, p0, Lcom/socialquantum/dw/utils/ClipBoardUtil$CopyExecutor;->mText:Ljava/lang/String;

    .line 23
    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 26
    iget-object v2, p0, Lcom/socialquantum/dw/utils/ClipBoardUtil$CopyExecutor;->mActivity:Landroid/app/Activity;

    const-string v3, "clipboard"

    .line 27
    invoke-virtual {v2, v3}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/ClipboardManager;

    .line 28
    .local v1, "mClipBoard":Landroid/content/ClipboardManager;
    const-string v2, "Text to copy"

    iget-object v3, p0, Lcom/socialquantum/dw/utils/ClipBoardUtil$CopyExecutor;->mText:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v0

    .line 30
    .local v0, "currentClip":Landroid/content/ClipData;
    if-eqz v0, :cond_0

    .line 31
    invoke-virtual {v1, v0}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 33
    :cond_0
    return-void
.end method
