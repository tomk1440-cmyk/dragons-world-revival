.class public Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;
.super Ljava/lang/Object;
.source "OkDialogExecutor.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private mButtonTitle:Ljava/lang/String;

.field private mContext:Landroid/app/Activity;

.field private mMessage:Ljava/lang/String;

.field private mTitle:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "_context"    # Landroid/app/Activity;
    .param p2, "_title"    # Ljava/lang/String;
    .param p3, "_message"    # Ljava/lang/String;
    .param p4, "_buttonTitle"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;->mContext:Landroid/app/Activity;

    .line 17
    iput-object p2, p0, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;->mTitle:Ljava/lang/String;

    .line 18
    iput-object p3, p0, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;->mMessage:Ljava/lang/String;

    .line 19
    iput-object p4, p0, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;->mButtonTitle:Ljava/lang/String;

    .line 20
    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 23
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;->mContext:Landroid/app/Activity;

    invoke-direct {v0, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 25
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 26
    iget-object v2, p0, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;->mTitle:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 27
    iget-object v2, p0, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;->mMessage:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 28
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setInverseBackgroundForced(Z)Landroid/app/AlertDialog$Builder;

    .line 29
    iget-object v2, p0, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;->mButtonTitle:Ljava/lang/String;

    new-instance v3, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor$1;

    invoke-direct {v3, p0}, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor$1;-><init>(Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;)V

    invoke-virtual {v0, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 38
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    .line 39
    .local v1, "dialog":Landroid/app/AlertDialog;
    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 40
    return-void
.end method
