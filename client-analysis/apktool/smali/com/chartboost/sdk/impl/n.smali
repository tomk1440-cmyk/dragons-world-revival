.class public Lcom/chartboost/sdk/impl/n;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/chartboost/sdk/impl/n$a;
    }
.end annotation


# instance fields
.field public a:Lcom/chartboost/sdk/impl/n$a;


# direct methods
.method public constructor <init>(Lcom/chartboost/sdk/impl/n$a;)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    .line 26
    return-void
.end method

.method static synthetic a(Lcom/chartboost/sdk/impl/n;Ljava/lang/String;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 97
    invoke-direct {p0, p1, p2}, Lcom/chartboost/sdk/impl/n;->a(Ljava/lang/String;Landroid/content/Context;)V

    return-void
.end method

.method private a(Ljava/lang/String;Landroid/content/Context;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 102
    if-nez p2, :cond_0

    .line 103
    invoke-static {}, Lcom/chartboost/sdk/Chartboost;->sharedChartboost()Lcom/chartboost/sdk/Chartboost;

    move-result-object v0

    invoke-virtual {v0}, Lcom/chartboost/sdk/Chartboost;->getContext()Landroid/content/Context;

    move-result-object p2

    .line 104
    :cond_0
    if-nez p2, :cond_2

    .line 105
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    if-eqz v0, :cond_1

    .line 106
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    invoke-interface {v0, v2, p1}, Lcom/chartboost/sdk/impl/n$a;->a(ZLjava/lang/String;)V

    .line 140
    :cond_1
    :goto_0
    return-void

    .line 111
    :cond_2
    :try_start_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 112
    instance-of v1, p2, Landroid/app/Activity;

    if-nez v1, :cond_3

    .line 113
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 114
    :cond_3
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 115
    invoke-virtual {p2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 138
    :cond_4
    :goto_1
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    if-eqz v0, :cond_1

    .line 139
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    const/4 v1, 0x1

    invoke-interface {v0, v1, p1}, Lcom/chartboost/sdk/impl/n$a;->a(ZLjava/lang/String;)V

    goto :goto_0

    .line 116
    :catch_0
    move-exception v0

    .line 117
    const-string v0, "market://"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 119
    :try_start_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://market.android.com/"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/16 v1, 0x9

    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 120
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 121
    instance-of v1, p2, Landroid/app/Activity;

    if-nez v1, :cond_5

    .line 122
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 123
    :cond_5
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 124
    invoke-virtual {p2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 125
    :catch_1
    move-exception v0

    .line 128
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    if-eqz v0, :cond_1

    .line 129
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    invoke-interface {v0, v2, p1}, Lcom/chartboost/sdk/impl/n$a;->a(ZLjava/lang/String;)V

    goto :goto_0

    .line 133
    :cond_6
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    if-eqz v0, :cond_4

    .line 134
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    invoke-interface {v0, v2, p1}, Lcom/chartboost/sdk/impl/n$a;->a(ZLjava/lang/String;)V

    goto :goto_1
.end method


# virtual methods
.method public a(Ljava/lang/String;Landroid/app/Activity;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 32
    .line 34
    :try_start_0
    new-instance v0, Ljava/net/URI;

    invoke-direct {v0, p1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 41
    invoke-virtual {v0}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    .line 42
    if-nez v0, :cond_1

    .line 43
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    invoke-interface {v0, v1, p1}, Lcom/chartboost/sdk/impl/n$a;->a(ZLjava/lang/String;)V

    .line 95
    :cond_0
    :goto_0
    return-void

    .line 35
    :catch_0
    move-exception v0

    .line 36
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    if-eqz v0, :cond_0

    .line 37
    iget-object v0, p0, Lcom/chartboost/sdk/impl/n;->a:Lcom/chartboost/sdk/impl/n$a;

    invoke-interface {v0, v1, p1}, Lcom/chartboost/sdk/impl/n$a;->a(ZLjava/lang/String;)V

    goto :goto_0

    .line 48
    :cond_1
    const-string v1, "http"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "https"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 49
    invoke-direct {p0, p1, p2}, Lcom/chartboost/sdk/impl/n;->a(Ljava/lang/String;Landroid/content/Context;)V

    goto :goto_0

    .line 53
    :cond_2
    new-instance v0, Lcom/chartboost/sdk/impl/n$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/chartboost/sdk/impl/n$1;-><init>(Lcom/chartboost/sdk/impl/n;Ljava/lang/String;Landroid/app/Activity;)V

    .line 94
    invoke-static {}, Lcom/chartboost/sdk/impl/l;->a()Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
