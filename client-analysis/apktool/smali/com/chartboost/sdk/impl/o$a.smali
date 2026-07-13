.class Lcom/chartboost/sdk/impl/o$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/chartboost/sdk/impl/o;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "a"
.end annotation


# instance fields
.field final synthetic a:Lcom/chartboost/sdk/impl/o;

.field private b:Ljava/lang/String;

.field private final c:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/widget/ImageView;",
            ">;"
        }
    .end annotation
.end field

.field private d:Lcom/chartboost/sdk/impl/o$b;

.field private e:Ljava/lang/String;

.field private f:Landroid/os/Bundle;


# direct methods
.method public constructor <init>(Lcom/chartboost/sdk/impl/o;Landroid/widget/ImageView;Lcom/chartboost/sdk/impl/o$b;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 115
    iput-object p1, p0, Lcom/chartboost/sdk/impl/o$a;->a:Lcom/chartboost/sdk/impl/o;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 116
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/chartboost/sdk/impl/o$a;->c:Ljava/lang/ref/WeakReference;

    .line 117
    new-instance v0, Lcom/chartboost/sdk/impl/o$c;

    invoke-direct {v0, p0}, Lcom/chartboost/sdk/impl/o$c;-><init>(Lcom/chartboost/sdk/impl/o$a;)V

    .line 118
    if-eqz p2, :cond_0

    .line 119
    invoke-virtual {p2, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 120
    :cond_0
    iput-object p4, p0, Lcom/chartboost/sdk/impl/o$a;->e:Ljava/lang/String;

    .line 121
    iput-object p3, p0, Lcom/chartboost/sdk/impl/o$a;->d:Lcom/chartboost/sdk/impl/o$b;

    .line 122
    iput-object p5, p0, Lcom/chartboost/sdk/impl/o$a;->f:Landroid/os/Bundle;

    .line 123
    iput-object p6, p0, Lcom/chartboost/sdk/impl/o$a;->b:Ljava/lang/String;

    .line 124
    return-void
.end method

.method static synthetic a(Lcom/chartboost/sdk/impl/o$a;)Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/chartboost/sdk/impl/o$a;->f:Landroid/os/Bundle;

    return-object v0
.end method

.method static synthetic b(Lcom/chartboost/sdk/impl/o$a;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/chartboost/sdk/impl/o$a;->e:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Lcom/chartboost/sdk/impl/o$a;)Ljava/lang/ref/WeakReference;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/chartboost/sdk/impl/o$a;->c:Ljava/lang/ref/WeakReference;

    return-object v0
.end method

.method static synthetic d(Lcom/chartboost/sdk/impl/o$a;)Lcom/chartboost/sdk/impl/o$b;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/chartboost/sdk/impl/o$a;->d:Lcom/chartboost/sdk/impl/o$b;

    return-object v0
.end method

.method static synthetic e(Lcom/chartboost/sdk/impl/o$a;)Lcom/chartboost/sdk/impl/o;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/chartboost/sdk/impl/o$a;->a:Lcom/chartboost/sdk/impl/o;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/chartboost/sdk/Libraries/a$a;)V
    .locals 2

    .prologue
    .line 215
    invoke-static {}, Lcom/chartboost/sdk/Chartboost;->sharedChartboost()Lcom/chartboost/sdk/Chartboost;

    move-result-object v0

    invoke-virtual {v0}, Lcom/chartboost/sdk/Chartboost;->getHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/chartboost/sdk/impl/o$a$1;

    invoke-direct {v1, p0, p1}, Lcom/chartboost/sdk/impl/o$a$1;-><init>(Lcom/chartboost/sdk/impl/o$a;Lcom/chartboost/sdk/Libraries/a$a;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 245
    return-void
.end method

.method public run()V
    .locals 12

    .prologue
    const/4 v6, 0x1

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v1, 0x0

    const/4 v5, 0x0

    .line 131
    .line 132
    iget-object v0, p0, Lcom/chartboost/sdk/impl/o$a;->f:Landroid/os/Bundle;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/chartboost/sdk/impl/o$a;->f:Landroid/os/Bundle;

    const-string v3, "paramNoMemoryCache"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 133
    :goto_0
    iget-object v3, p0, Lcom/chartboost/sdk/impl/o$a;->f:Landroid/os/Bundle;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/chartboost/sdk/impl/o$a;->f:Landroid/os/Bundle;

    const-string v4, "paramAssetScale"

    invoke-virtual {v3, v4, v2}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;F)F

    move-result v2

    .line 135
    :cond_0
    :try_start_0
    iget-object v3, p0, Lcom/chartboost/sdk/impl/o$a;->a:Lcom/chartboost/sdk/impl/o;

    iget-object v4, p0, Lcom/chartboost/sdk/impl/o$a;->e:Ljava/lang/String;

    invoke-virtual {v3, v4, v2}, Lcom/chartboost/sdk/impl/o;->a(Ljava/lang/String;F)Lcom/chartboost/sdk/Libraries/a$a;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 136
    if-eqz v4, :cond_3

    .line 137
    if-eqz v0, :cond_2

    move v3, v1

    :goto_1
    :try_start_1
    invoke-virtual {v4, v3}, Lcom/chartboost/sdk/Libraries/a$a;->a(Z)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_b

    move-object v3, v4

    .line 144
    :goto_2
    if-eqz v3, :cond_4

    .line 145
    invoke-virtual {p0, v3}, Lcom/chartboost/sdk/impl/o$a;->a(Lcom/chartboost/sdk/Libraries/a$a;)V

    .line 209
    :goto_3
    return-void

    :cond_1
    move v0, v1

    .line 132
    goto :goto_0

    :cond_2
    move v3, v6

    .line 137
    goto :goto_1

    .line 139
    :catch_0
    move-exception v3

    move-object v4, v5

    .line 142
    :goto_4
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    :cond_3
    move-object v3, v4

    goto :goto_2

    .line 150
    :cond_4
    invoke-static {}, Lcom/chartboost/sdk/impl/l;->b()Lorg/apache/http/client/HttpClient;

    move-result-object v4

    .line 151
    new-instance v7, Lorg/apache/http/client/methods/HttpGet;

    iget-object v8, p0, Lcom/chartboost/sdk/impl/o$a;->b:Ljava/lang/String;

    invoke-direct {v7, v8}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 158
    :try_start_2
    invoke-interface {v4, v7}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_a
    .catch Ljava/lang/IllegalStateException; {:try_start_2 .. :try_end_2} :catch_9
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_7

    move-result-object v4

    .line 159
    :try_start_3
    invoke-interface {v4}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v8

    invoke-interface {v8}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v8

    .line 160
    const/16 v9, 0xc8

    if-eq v8, v9, :cond_5

    .line 161
    const-string v0, "ImageDownloader"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Error "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 162
    const-string v2, " while retrieving bitmap from "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/chartboost/sdk/impl/o$a;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 161
    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 163
    invoke-static {v4}, Lcom/chartboost/sdk/Libraries/d;->a(Lorg/apache/http/HttpResponse;)V

    .line 164
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/chartboost/sdk/impl/o$a;->a(Lcom/chartboost/sdk/Libraries/a$a;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/IllegalStateException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_5

    goto :goto_3

    .line 195
    :catch_1
    move-exception v0

    move-object v1, v0

    move-object v5, v4

    move-object v0, v3

    .line 196
    :goto_5
    invoke-virtual {v7}, Lorg/apache/http/client/methods/HttpGet;->abort()V

    .line 197
    invoke-static {v5}, Lcom/chartboost/sdk/Libraries/d;->a(Lorg/apache/http/HttpResponse;)V

    .line 198
    const-string v2, "CBWebImageCache"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "I/O error while retrieving bitmap from "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/chartboost/sdk/impl/o$a;->b:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 208
    :goto_6
    invoke-virtual {p0, v0}, Lcom/chartboost/sdk/impl/o$a;->a(Lcom/chartboost/sdk/Libraries/a$a;)V

    goto :goto_3

    .line 168
    :cond_5
    :try_start_4
    invoke-interface {v4}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/IllegalStateException; {:try_start_4 .. :try_end_4} :catch_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_5

    move-result-object v8

    .line 169
    if-eqz v8, :cond_a

    .line 172
    :try_start_5
    invoke-interface {v8}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v5

    .line 173
    iget-object v9, p0, Lcom/chartboost/sdk/impl/o$a;->a:Lcom/chartboost/sdk/impl/o;

    iget-object v10, p0, Lcom/chartboost/sdk/impl/o$a;->e:Ljava/lang/String;

    new-instance v11, Lcom/chartboost/sdk/impl/o$e;

    invoke-direct {v11, v5}, Lcom/chartboost/sdk/impl/o$e;-><init>(Ljava/io/InputStream;)V

    invoke-virtual {v9, v10, v11}, Lcom/chartboost/sdk/impl/o;->a(Ljava/lang/String;Lcom/chartboost/sdk/impl/o$e;)Z
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 175
    :try_start_6
    iget-object v9, p0, Lcom/chartboost/sdk/impl/o$a;->a:Lcom/chartboost/sdk/impl/o;

    iget-object v10, p0, Lcom/chartboost/sdk/impl/o$a;->e:Ljava/lang/String;

    invoke-virtual {v9, v10, v2}, Lcom/chartboost/sdk/impl/o;->a(Ljava/lang/String;F)Lcom/chartboost/sdk/Libraries/a$a;

    move-result-object v3

    .line 176
    if-eqz v3, :cond_9

    .line 177
    if-eqz v0, :cond_6

    :goto_7
    invoke-virtual {v3, v1}, Lcom/chartboost/sdk/Libraries/a$a;->a(Z)V

    .line 178
    if-nez v0, :cond_9

    .line 179
    iget-object v0, p0, Lcom/chartboost/sdk/impl/o$a;->a:Lcom/chartboost/sdk/impl/o;

    invoke-static {v0}, Lcom/chartboost/sdk/impl/o;->a(Lcom/chartboost/sdk/impl/o;)Lcom/chartboost/sdk/Libraries/a;

    move-result-object v0

    iget-object v1, p0, Lcom/chartboost/sdk/impl/o$a;->e:Ljava/lang/String;

    invoke-virtual {v0, v1, v3}, Lcom/chartboost/sdk/Libraries/a;->a(Ljava/lang/String;Lcom/chartboost/sdk/Libraries/a$a;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-object v0, v3

    .line 187
    :goto_8
    if-eqz v5, :cond_8

    .line 188
    :try_start_7
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_2
    .catch Ljava/lang/IllegalStateException; {:try_start_7 .. :try_end_7} :catch_6
    .catch Ljava/lang/Throwable; {:try_start_7 .. :try_end_7} :catch_8

    goto :goto_6

    .line 195
    :catch_2
    move-exception v1

    move-object v5, v4

    goto :goto_5

    :cond_6
    move v1, v6

    .line 177
    goto :goto_7

    .line 181
    :catch_3
    move-exception v0

    .line 184
    :try_start_8
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    move-object v0, v3

    goto :goto_8

    .line 186
    :catchall_0
    move-exception v0

    .line 187
    if-eqz v5, :cond_7

    .line 188
    :try_start_9
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V

    .line 193
    :goto_9
    throw v0
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_1
    .catch Ljava/lang/IllegalStateException; {:try_start_9 .. :try_end_9} :catch_4
    .catch Ljava/lang/Throwable; {:try_start_9 .. :try_end_9} :catch_5

    .line 199
    :catch_4
    move-exception v0

    move-object v0, v3

    .line 200
    :goto_a
    invoke-virtual {v7}, Lorg/apache/http/client/methods/HttpGet;->abort()V

    .line 201
    invoke-static {v4}, Lcom/chartboost/sdk/Libraries/d;->a(Lorg/apache/http/HttpResponse;)V

    .line 202
    const-string v1, "CBWebImageCache"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Incorrect URL: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/chartboost/sdk/impl/o$a;->b:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_6

    .line 191
    :cond_7
    :try_start_a
    invoke-static {v8}, Lcom/chartboost/sdk/Libraries/d;->a(Lorg/apache/http/HttpEntity;)V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_1
    .catch Ljava/lang/IllegalStateException; {:try_start_a .. :try_end_a} :catch_4
    .catch Ljava/lang/Throwable; {:try_start_a .. :try_end_a} :catch_5

    goto :goto_9

    .line 203
    :catch_5
    move-exception v0

    move-object v1, v0

    move-object v0, v3

    .line 204
    :goto_b
    invoke-virtual {v7}, Lorg/apache/http/client/methods/HttpGet;->abort()V

    .line 205
    invoke-static {v4}, Lcom/chartboost/sdk/Libraries/d;->a(Lorg/apache/http/HttpResponse;)V

    .line 206
    const-string v2, "CBWebImageCache"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Error while retrieving bitmap from "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/chartboost/sdk/impl/o$a;->b:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_6

    .line 191
    :cond_8
    :try_start_b
    invoke-static {v8}, Lcom/chartboost/sdk/Libraries/d;->a(Lorg/apache/http/HttpEntity;)V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_2
    .catch Ljava/lang/IllegalStateException; {:try_start_b .. :try_end_b} :catch_6
    .catch Ljava/lang/Throwable; {:try_start_b .. :try_end_b} :catch_8

    goto/16 :goto_6

    .line 199
    :catch_6
    move-exception v1

    goto :goto_a

    .line 203
    :catch_7
    move-exception v0

    move-object v1, v0

    move-object v4, v5

    move-object v0, v3

    goto :goto_b

    :catch_8
    move-exception v1

    goto :goto_b

    .line 199
    :catch_9
    move-exception v0

    move-object v4, v5

    move-object v0, v3

    goto :goto_a

    .line 195
    :catch_a
    move-exception v0

    move-object v1, v0

    move-object v0, v3

    goto/16 :goto_5

    .line 139
    :catch_b
    move-exception v3

    goto/16 :goto_4

    :cond_9
    move-object v0, v3

    goto :goto_8

    :cond_a
    move-object v0, v3

    goto/16 :goto_6
.end method
