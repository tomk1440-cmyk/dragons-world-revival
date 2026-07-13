.class public Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;
.super Ljava/lang/Object;
.source "YesNoDialogExecutor.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private mContext:Landroid/app/Activity;

.field private mMessage:Ljava/lang/String;

.field private mNoTitle:Ljava/lang/String;

.field private mTitle:Ljava/lang/String;

.field private mYesTitle:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "_context"    # Landroid/app/Activity;
    .param p2, "_title"    # Ljava/lang/String;
    .param p3, "_message"    # Ljava/lang/String;
    .param p4, "_yesTitle"    # Ljava/lang/String;
    .param p5, "_noTitle"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;->mContext:Landroid/app/Activity;

    .line 18
    iput-object p2, p0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;->mTitle:Ljava/lang/String;

    .line 19
    iput-object p3, p0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;->mMessage:Ljava/lang/String;

    .line 20
    iput-object p4, p0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;->mYesTitle:Ljava/lang/String;

    .line 21
    iput-object p5, p0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;->mNoTitle:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 25
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;->mContext:Landroid/app/Activity;

    invoke-direct {v0, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 27
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 28
    iget-object v2, p0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;->mTitle:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 29
    iget-object v2, p0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;->mMessage:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 30
    iget-object v2, p0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;->mYesTitle:Ljava/lang/String;

    new-instance v3, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor$1;

    invoke-direct {v3, p0}, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor$1;-><init>(Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;)V

    invoke-virtual {v0, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 38
    iget-object v2, p0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;->mNoTitle:Ljava/lang/String;

    new-instance v3, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor$2;

    invoke-direct {v3, p0}, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor$2;-><init>(Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;)V

    invoke-virtual {v0, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 46
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    .line 47
    .local v1, "dialog":Landroid/app/AlertDialog;
    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 48
    return-void
.end method
