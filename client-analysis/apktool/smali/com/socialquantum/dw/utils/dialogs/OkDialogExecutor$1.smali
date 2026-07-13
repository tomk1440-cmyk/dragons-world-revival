.class Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor$1;
.super Ljava/lang/Object;
.source "OkDialogExecutor.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;


# direct methods
.method constructor <init>(Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;)V
    .locals 0
    .param p1, "this$0"    # Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor$1;->this$0:Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 32
    const-string v0, "AndroidListener"

    const-string v1, "OkClicked"

    const-string v2, "Message to send"

    invoke-static {v0, v1, v2}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 36
    return-void
.end method
