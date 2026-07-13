.class public Lcom/socialquantum/dw/utils/dialogs/DialogViewer;
.super Ljava/lang/Object;
.source "DialogViewer.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public ShowOkDialog(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "_title"    # Ljava/lang/String;
    .param p2, "_message"    # Ljava/lang/String;
    .param p3, "_buttonName"    # Ljava/lang/String;

    .prologue
    .line 7
    new-instance v0, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;

    sget-object v1, Lcom/socialquantum/dw/utils/CurrentActivity;->value:Landroid/app/Activity;

    invoke-direct {v0, v1, p1, p2, p3}, Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 8
    .local v0, "executor":Lcom/socialquantum/dw/utils/dialogs/OkDialogExecutor;
    sget-object v1, Lcom/socialquantum/dw/utils/CurrentActivity;->value:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 9
    const-string v1, "dialog OK"

    return-object v1
.end method

.method public ShowRateUsdDialog(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "_title"    # Ljava/lang/String;
    .param p2, "_message"    # Ljava/lang/String;
    .param p3, "_yesTitle"    # Ljava/lang/String;
    .param p4, "_noTitle"    # Ljava/lang/String;
    .param p5, "_laterButton"    # Ljava/lang/String;

    .prologue
    .line 20
    new-instance v0, Lcom/socialquantum/dw/utils/dialogs/RateUsDialogExecutor;

    sget-object v1, Lcom/socialquantum/dw/utils/CurrentActivity;->value:Landroid/app/Activity;

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/socialquantum/dw/utils/dialogs/RateUsDialogExecutor;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    .local v0, "executor":Lcom/socialquantum/dw/utils/dialogs/RateUsDialogExecutor;
    sget-object v1, Lcom/socialquantum/dw/utils/CurrentActivity;->value:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 23
    const-string v1, "dialog RateUs"

    return-object v1
.end method

.method public ShowYesNoDialog(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "_title"    # Ljava/lang/String;
    .param p2, "_message"    # Ljava/lang/String;
    .param p3, "_yesTitle"    # Ljava/lang/String;
    .param p4, "_noTitle"    # Ljava/lang/String;

    .prologue
    .line 13
    new-instance v0, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;

    sget-object v1, Lcom/socialquantum/dw/utils/CurrentActivity;->value:Landroid/app/Activity;

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 15
    .local v0, "executor":Lcom/socialquantum/dw/utils/dialogs/YesNoDialogExecutor;
    sget-object v1, Lcom/socialquantum/dw/utils/CurrentActivity;->value:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 16
    const-string v1, "dialog YesNo"

    return-object v1
.end method
