.class public Lcom/socialquantum/dw/utils/mail/SendMailExecutor;
.super Ljava/lang/Object;
.source "SendMailExecutor.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private attachmentFile:Ljava/lang/String;

.field private email:Ljava/lang/String;

.field private mActivity:Landroid/app/Activity;

.field private mIsHtml:Ljava/lang/Boolean;

.field private text:Ljava/lang/String;

.field private theme:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "_context"    # Landroid/app/Activity;
    .param p2, "_email"    # Ljava/lang/String;
    .param p3, "_theme"    # Ljava/lang/String;
    .param p4, "_text"    # Ljava/lang/String;
    .param p5, "_isHtml"    # Ljava/lang/Boolean;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->mActivity:Landroid/app/Activity;

    .line 30
    iput-object p2, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->email:Ljava/lang/String;

    .line 31
    iput-object p3, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->theme:Ljava/lang/String;

    .line 32
    iput-object p4, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->text:Ljava/lang/String;

    .line 33
    iput-object p5, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->mIsHtml:Ljava/lang/Boolean;

    .line 34
    return-void
.end method

.method constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V
    .locals 0
    .param p1, "_context"    # Landroid/app/Activity;
    .param p2, "_email"    # Ljava/lang/String;
    .param p3, "_theme"    # Ljava/lang/String;
    .param p4, "_text"    # Ljava/lang/String;
    .param p5, "_isHtml"    # Ljava/lang/Boolean;
    .param p6, "_attachmentFile"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->mActivity:Landroid/app/Activity;

    .line 21
    iput-object p2, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->email:Ljava/lang/String;

    .line 22
    iput-object p3, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->theme:Ljava/lang/String;

    .line 23
    iput-object p4, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->text:Ljava/lang/String;

    .line 24
    iput-object p5, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->mIsHtml:Ljava/lang/Boolean;

    .line 25
    iput-object p6, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->attachmentFile:Ljava/lang/String;

    .line 26
    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 37
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 39
    .local v0, "emailIntent":Landroid/content/Intent;
    const-string v2, "plain/text"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 40
    const-string v2, "android.intent.extra.EMAIL"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->email:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 41
    const-string v2, "android.intent.extra.SUBJECT"

    iget-object v3, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->theme:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 42
    iget-object v2, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->mIsHtml:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 43
    const-string v2, "android.intent.extra.TEXT"

    iget-object v3, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->text:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 47
    :goto_0
    iget-object v2, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->attachmentFile:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->attachmentFile:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 48
    new-instance v2, Ljava/io/File;

    iget-object v3, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->attachmentFile:Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v1

    .line 49
    .local v1, "uri":Landroid/net/Uri;
    const-string v2, "android.intent.extra.STREAM"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 51
    .end local v1    # "uri":Landroid/net/Uri;
    :cond_0
    iget-object v2, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->mActivity:Landroid/app/Activity;

    const-string v3, "Select application..."

    invoke-static {v0, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 52
    return-void

    .line 45
    :cond_1
    const-string v2, "android.intent.extra.TEXT"

    iget-object v3, p0, Lcom/socialquantum/dw/utils/mail/SendMailExecutor;->text:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method
