.class Lcom/chartboost/sdk/impl/x$c;
.super Landroid/webkit/WebViewClient;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/chartboost/sdk/impl/x;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "c"
.end annotation


# instance fields
.field final synthetic a:Lcom/chartboost/sdk/impl/x;

.field private b:Lcom/chartboost/sdk/impl/x;


# direct methods
.method public constructor <init>(Lcom/chartboost/sdk/impl/x;Lcom/chartboost/sdk/impl/x;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/chartboost/sdk/impl/x$c;->a:Lcom/chartboost/sdk/impl/x;

    .line 89
    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    .line 91
    iput-object p2, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    .line 92
    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 96
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 97
    iget-object v0, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v0, v0, Lcom/chartboost/sdk/impl/x;->c:Lcom/chartboost/sdk/c$a;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v0, v0, Lcom/chartboost/sdk/impl/x;->c:Lcom/chartboost/sdk/c$a;

    invoke-interface {v0}, Lcom/chartboost/sdk/c$a;->a()V

    .line 98
    :cond_0
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 103
    iget-object v0, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v0, v0, Lcom/chartboost/sdk/impl/x;->d:Lcom/chartboost/sdk/c$a;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v0, v0, Lcom/chartboost/sdk/impl/x;->d:Lcom/chartboost/sdk/c$a;

    invoke-interface {v0}, Lcom/chartboost/sdk/c$a;->a()V

    .line 104
    :cond_0
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 7
    .param p1, "webView"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    const/4 v5, 0x3

    const/4 v6, 0x4

    const/4 v0, 0x0

    .line 112
    const-string v1, ""

    .line 114
    :try_start_0
    new-instance v1, Ljava/net/URI;

    invoke-direct {v1, p2}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 115
    invoke-virtual {v1}, Ljava/net/URI;->getScheme()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 122
    const-string v3, "chartboost"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 124
    const-string v1, "/"

    invoke-virtual {p2, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 125
    array-length v3, v1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    .line 126
    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-ge v4, v5, :cond_1

    .line 128
    iget-object v1, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v1, v1, Lcom/chartboost/sdk/impl/x;->a:Lcom/chartboost/sdk/c$a;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v1, v1, Lcom/chartboost/sdk/impl/x;->a:Lcom/chartboost/sdk/c$a;

    invoke-interface {v1}, Lcom/chartboost/sdk/c$a;->a()V

    .line 164
    :cond_0
    :goto_0
    return v0

    .line 117
    :catch_0
    move-exception v1

    .line 118
    iget-object v1, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v1, v1, Lcom/chartboost/sdk/impl/x;->a:Lcom/chartboost/sdk/c$a;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v1, v1, Lcom/chartboost/sdk/impl/x;->a:Lcom/chartboost/sdk/c$a;

    invoke-interface {v1}, Lcom/chartboost/sdk/c$a;->a()V

    goto :goto_0

    .line 131
    :cond_1
    const/4 v4, 0x2

    aget-object v4, v1, v4

    .line 133
    const-string v5, "close"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 135
    iget-object v0, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v0, v0, Lcom/chartboost/sdk/impl/x;->a:Lcom/chartboost/sdk/c$a;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v0, v0, Lcom/chartboost/sdk/impl/x;->a:Lcom/chartboost/sdk/c$a;

    invoke-interface {v0}, Lcom/chartboost/sdk/c$a;->a()V

    .line 164
    :cond_2
    :goto_1
    const/4 v0, 0x1

    goto :goto_0

    .line 137
    :cond_3
    const-string v5, "link"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 139
    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-ge v4, v6, :cond_4

    .line 141
    iget-object v1, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v1, v1, Lcom/chartboost/sdk/impl/x;->a:Lcom/chartboost/sdk/c$a;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v1, v1, Lcom/chartboost/sdk/impl/x;->a:Lcom/chartboost/sdk/c$a;

    invoke-interface {v1}, Lcom/chartboost/sdk/c$a;->a()V

    goto :goto_0

    .line 149
    :cond_4
    const/4 v0, 0x3

    :try_start_1
    aget-object v0, v1, v0

    const-string v4, "UTF-8"

    invoke-static {v0, v4}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 150
    :try_start_2
    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-le v3, v6, :cond_5

    .line 152
    new-instance v3, Lorg/json/JSONTokener;

    const/4 v4, 0x4

    aget-object v1, v1, v4

    const-string v4, "UTF-8"

    invoke-static {v1, v4}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v3, v1}, Lorg/json/JSONTokener;-><init>(Ljava/lang/String;)V

    .line 153
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v3}, Lorg/json/JSONObject;-><init>(Lorg/json/JSONTokener;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 159
    :goto_2
    iget-object v2, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v2, v2, Lcom/chartboost/sdk/impl/x;->b:Lcom/chartboost/sdk/c$c;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/chartboost/sdk/impl/x$c;->b:Lcom/chartboost/sdk/impl/x;

    iget-object v2, v2, Lcom/chartboost/sdk/impl/x;->b:Lcom/chartboost/sdk/c$c;

    invoke-interface {v2, v0, v1}, Lcom/chartboost/sdk/c$c;->a(Ljava/lang/String;Lorg/json/JSONObject;)V

    goto :goto_1

    .line 155
    :catch_1
    move-exception v0

    move-object v1, v0

    move-object v0, v2

    .line 156
    :goto_3
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    :cond_5
    move-object v1, v2

    goto :goto_2

    .line 155
    :catch_2
    move-exception v1

    goto :goto_3
.end method
