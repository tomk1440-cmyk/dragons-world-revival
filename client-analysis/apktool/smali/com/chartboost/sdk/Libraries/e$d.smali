.class Lcom/chartboost/sdk/Libraries/e$d;
.super Lcom/chartboost/sdk/Libraries/e$a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/chartboost/sdk/Libraries/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "d"
.end annotation


# instance fields
.field protected a:[Lcom/chartboost/sdk/Libraries/e$g;

.field protected b:Ljava/lang/String;


# direct methods
.method public constructor <init>([Lcom/chartboost/sdk/Libraries/e$g;)V
    .locals 1

    .prologue
    .line 382
    invoke-direct {p0}, Lcom/chartboost/sdk/Libraries/e$a;-><init>()V

    .line 381
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->b:Ljava/lang/String;

    .line 383
    iput-object p1, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    .line 384
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 3

    .prologue
    .line 438
    iget-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->b:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 439
    iget-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->b:Ljava/lang/String;

    .line 452
    :goto_0
    return-object v0

    .line 440
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 441
    const-string v0, "object must contain the following key-value schema: {\n"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 442
    const/4 v0, 0x0

    :goto_1
    iget-object v2, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    array-length v2, v2

    if-lt v0, v2, :cond_1

    .line 451
    const-string v0, "}"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 452
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 443
    :cond_1
    const-string v2, "<"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 444
    iget-object v2, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    aget-object v2, v2, v0

    invoke-static {v2}, Lcom/chartboost/sdk/Libraries/e$g;->a(Lcom/chartboost/sdk/Libraries/e$g;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 445
    const-string v2, ": ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 446
    iget-object v2, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    aget-object v2, v2, v0

    invoke-static {v2}, Lcom/chartboost/sdk/Libraries/e$g;->b(Lcom/chartboost/sdk/Libraries/e$g;)Lcom/chartboost/sdk/Libraries/e$a;

    move-result-object v2

    invoke-virtual {v2}, Lcom/chartboost/sdk/Libraries/e$a;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 447
    const-string v2, "]>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 448
    iget-object v2, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    array-length v2, v2

    add-int/lit8 v2, v2, -0x1

    if-ge v0, v2, :cond_2

    .line 449
    const-string v2, ",\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 442
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public a(Ljava/lang/Object;)Z
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 386
    instance-of v0, p1, Ljava/util/Map;

    if-eqz v0, :cond_7

    .line 387
    check-cast p1, Ljava/util/Map;

    .line 388
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_3

    .line 394
    iget-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    array-length v0, v0

    if-lt v0, v2, :cond_1

    move v0, v1

    .line 395
    :goto_0
    iget-object v3, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    array-length v3, v3

    if-lt v0, v3, :cond_4

    :cond_1
    move v1, v2

    .line 434
    :cond_2
    :goto_1
    return v1

    .line 388
    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 389
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Ljava/lang/String;

    if-nez v4, :cond_0

    .line 390
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "key \'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\' is not a string"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->b:Ljava/lang/String;

    goto :goto_1

    .line 396
    :cond_4
    iget-object v3, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    aget-object v3, v3, v0

    invoke-static {v3}, Lcom/chartboost/sdk/Libraries/e$g;->a(Lcom/chartboost/sdk/Libraries/e$g;)Ljava/lang/String;

    move-result-object v3

    .line 397
    iget-object v4, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    aget-object v4, v4, v0

    invoke-static {v4}, Lcom/chartboost/sdk/Libraries/e$g;->b(Lcom/chartboost/sdk/Libraries/e$g;)Lcom/chartboost/sdk/Libraries/e$a;

    move-result-object v4

    .line 398
    invoke-interface {p1, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 399
    invoke-virtual {v4, v7}, Lcom/chartboost/sdk/Libraries/e$a;->a(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 400
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "no key for required mapping \'"

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\' : <"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v4}, Lcom/chartboost/sdk/Libraries/e$a;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ">"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->b:Ljava/lang/String;

    goto :goto_1

    .line 404
    :cond_5
    invoke-interface {p1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/chartboost/sdk/Libraries/e$a;->a(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 405
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "key \'"

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\' fails to match: <"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v4}, Lcom/chartboost/sdk/Libraries/e$a;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ">"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->b:Ljava/lang/String;

    goto/16 :goto_1

    .line 395
    :cond_6
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 412
    :cond_7
    instance-of v0, p1, Lorg/json/JSONObject;

    if-eqz v0, :cond_2

    .line 413
    check-cast p1, Lorg/json/JSONObject;

    .line 414
    iget-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    array-length v0, v0

    if-lt v0, v2, :cond_8

    move v0, v1

    .line 415
    :goto_2
    iget-object v3, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    array-length v3, v3

    if-lt v0, v3, :cond_9

    :cond_8
    move v1, v2

    .line 432
    goto/16 :goto_1

    .line 416
    :cond_9
    iget-object v3, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    aget-object v3, v3, v0

    invoke-static {v3}, Lcom/chartboost/sdk/Libraries/e$g;->a(Lcom/chartboost/sdk/Libraries/e$g;)Ljava/lang/String;

    move-result-object v3

    .line 417
    iget-object v4, p0, Lcom/chartboost/sdk/Libraries/e$d;->a:[Lcom/chartboost/sdk/Libraries/e$g;

    aget-object v4, v4, v0

    invoke-static {v4}, Lcom/chartboost/sdk/Libraries/e$g;->b(Lcom/chartboost/sdk/Libraries/e$g;)Lcom/chartboost/sdk/Libraries/e$a;

    move-result-object v4

    .line 419
    :try_start_0
    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    .line 420
    invoke-virtual {v4, v5}, Lcom/chartboost/sdk/Libraries/e$a;->a(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_a

    .line 421
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "key \'"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\' fails to match: <"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v4}, Lcom/chartboost/sdk/Libraries/e$a;->a()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ">"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/chartboost/sdk/Libraries/e$d;->b:Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_1

    .line 424
    :catch_0
    move-exception v5

    .line 425
    invoke-virtual {v4, v7}, Lcom/chartboost/sdk/Libraries/e$a;->a(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_a

    .line 426
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "no key for required mapping \'"

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\' : <"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v4}, Lcom/chartboost/sdk/Libraries/e$a;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ">"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/chartboost/sdk/Libraries/e$d;->b:Ljava/lang/String;

    goto/16 :goto_1

    .line 415
    :cond_a
    add-int/lit8 v0, v0, 0x1

    goto :goto_2
.end method
