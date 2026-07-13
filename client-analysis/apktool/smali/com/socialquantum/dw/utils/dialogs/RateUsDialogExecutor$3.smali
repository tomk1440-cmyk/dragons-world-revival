.class Lcom/socialquantum/dw/utils/dialogs/RateUsDialogExecutor$3;
.super Ljava/lang/Object;
.source "RateUsDialogExecutor.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/socialquantum/dw/utils/dialogs/RateUsDialogExecutor;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/socialquantum/dw/utils/dialogs/RateUsDialogExecutor;


# direct methods
.method constructor <init>(Lcom/socialquantum/dw/utils/dialogs/RateUsDialogExecutor;)V
    .locals 0
    .param p1, "this$0"    # Lcom/socialquantum/dw/utils/dialogs/RateUsDialogExecutor;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/socialquantum/dw/utils/dialogs/RateUsDialogExecutor$3;->this$0:Lcom/socialquantum/dw/utils/dialogs/RateUsDialogExecutor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 51
    const-string v0, "AndroidListener"

    const-string v1, "HandleRateUsResult"

    const-string v2, "2"

    invoke-static {v0, v1, v2}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 54
    return-void
.end method
