.class public Lcom/chartboost/sdk/impl/h$a$a;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/chartboost/sdk/impl/h$a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lorg/json/JSONObject;",
        ">;"
    }
.end annotation


# instance fields
.field a:Landroid/content/Context;

.field final synthetic b:Lcom/chartboost/sdk/impl/h$a;


# direct methods
.method public constructor <init>(Lcom/chartboost/sdk/impl/h$a;Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 266
    iput-object p1, p0, Lcom/chartboost/sdk/impl/h$a$a;->b:Lcom/chartboost/sdk/impl/h$a;

    .line 267
    const/4 v0, 0x0

    invoke-static {p1}, Lcom/chartboost/sdk/impl/h$a;->b(Lcom/chartboost/sdk/impl/h$a;)Lcom/chartboost/sdk/impl/h;

    move-result-object v1

    invoke-static {v1}, Lcom/chartboost/sdk/impl/h;->a(Lcom/chartboost/sdk/impl/h;)Ljava/util/List;

    move-result-object v1

    invoke-direct {p0, p2, v0, v1}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 268
    iput-object p2, p0, Lcom/chartboost/sdk/impl/h$a$a;->a:Landroid/content/Context;

    .line 269
    return-void
.end method

.method static synthetic a(Lcom/chartboost/sdk/impl/h$a$a;)Lcom/chartboost/sdk/impl/h$a;
    .locals 1

    .prologue
    .line 262
    iget-object v0, p0, Lcom/chartboost/sdk/impl/h$a$a;->b:Lcom/chartboost/sdk/impl/h$a;

    return-object v0
.end method


# virtual methods
.method public a(I)Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 336
    iget-object v0, p0, Lcom/chartboost/sdk/impl/h$a$a;->b:Lcom/chartboost/sdk/impl/h$a;

    invoke-static {v0}, Lcom/chartboost/sdk/impl/h$a;->b(Lcom/chartboost/sdk/impl/h$a;)Lcom/chartboost/sdk/impl/h;

    move-result-object v0

    invoke-static {v0}, Lcom/chartboost/sdk/impl/h;->a(Lcom/chartboost/sdk/impl/h;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 328
    iget-object v0, p0, Lcom/chartboost/sdk/impl/h$a$a;->b:Lcom/chartboost/sdk/impl/h$a;

    invoke-static {v0}, Lcom/chartboost/sdk/impl/h$a;->b(Lcom/chartboost/sdk/impl/h$a;)Lcom/chartboost/sdk/impl/h;

    move-result-object v0

    invoke-static {v0}, Lcom/chartboost/sdk/impl/h;->a(Lcom/chartboost/sdk/impl/h;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 329
    return v0
.end method

.method public synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/chartboost/sdk/impl/h$a$a;->a(I)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, -0x1

    .line 273
    invoke-static {}, Lcom/chartboost/sdk/Chartboost;->sharedChartboost()Lcom/chartboost/sdk/Chartboost;

    move-result-object v0

    invoke-virtual {v0}, Lcom/chartboost/sdk/Chartboost;->getForcedOrientationDifference()Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;

    move-result-object v2

    .line 274
    invoke-virtual {v2}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->isReverse()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 275
    invoke-virtual {p0}, Lcom/chartboost/sdk/impl/h$a$a;->getCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    sub-int p1, v0, p1

    .line 277
    :cond_0
    invoke-virtual {p0, p1}, Lcom/chartboost/sdk/impl/h$a$a;->a(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 278
    const-string v0, "type"

    const-string v1, ""

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 279
    const/4 v1, 0x0

    .line 282
    if-nez p2, :cond_5

    .line 283
    const-string v4, "featured"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 284
    new-instance v1, Lcom/chartboost/sdk/impl/d;

    iget-object v0, p0, Lcom/chartboost/sdk/impl/h$a$a;->a:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/chartboost/sdk/impl/d;-><init>(Landroid/content/Context;)V

    .line 290
    :cond_1
    :goto_0
    new-instance p2, Lcom/chartboost/sdk/impl/v;

    .end local p2    # "convertView":Landroid/view/View;
    iget-object v4, p0, Lcom/chartboost/sdk/impl/h$a$a;->a:Landroid/content/Context;

    move-object v0, v1

    check-cast v0, Landroid/view/View;

    invoke-direct {p2, v4, v0}, Lcom/chartboost/sdk/impl/v;-><init>(Landroid/content/Context;Landroid/view/View;)V

    .line 296
    :goto_1
    invoke-interface {v1, v3, p1}, Lcom/chartboost/sdk/impl/h$b;->a(Lorg/json/JSONObject;I)V

    move-object v0, v1

    .line 297
    check-cast v0, Lcom/chartboost/sdk/impl/c;

    .line 299
    invoke-virtual {v2}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->isOdd()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 300
    new-instance v2, Landroid/widget/AbsListView$LayoutParams;

    .line 301
    invoke-interface {v1}, Lcom/chartboost/sdk/impl/h$b;->a()I

    move-result v4

    invoke-direct {v2, v4, v5}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    .line 300
    invoke-virtual {p2, v2}, Lcom/chartboost/sdk/impl/v;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 306
    :goto_2
    new-instance v2, Lcom/chartboost/sdk/impl/h$a$a$1;

    invoke-direct {v2, p0, v3}, Lcom/chartboost/sdk/impl/h$a$a$1;-><init>(Lcom/chartboost/sdk/impl/h$a$a;Lorg/json/JSONObject;)V

    .line 314
    iput-object v2, v0, Lcom/chartboost/sdk/impl/c;->a:Landroid/view/View$OnClickListener;

    .line 316
    invoke-virtual {v0, v2}, Lcom/chartboost/sdk/impl/c;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 317
    instance-of v0, v1, Lcom/chartboost/sdk/impl/e;

    if-eqz v0, :cond_2

    .line 319
    check-cast v1, Lcom/chartboost/sdk/impl/e;

    iget-object v0, v1, Lcom/chartboost/sdk/impl/e;->b:Lcom/chartboost/sdk/impl/f;

    invoke-virtual {v0, v2}, Lcom/chartboost/sdk/impl/f;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 322
    :cond_2
    return-object p2

    .line 285
    .restart local p2    # "convertView":Landroid/view/View;
    :cond_3
    const-string v4, "regular"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 286
    new-instance v1, Lcom/chartboost/sdk/impl/e;

    iget-object v0, p0, Lcom/chartboost/sdk/impl/h$a$a;->a:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/chartboost/sdk/impl/e;-><init>(Landroid/content/Context;)V

    goto :goto_0

    .line 287
    :cond_4
    const-string v4, "webview"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 288
    new-instance v1, Lcom/chartboost/sdk/impl/i;

    iget-object v0, p0, Lcom/chartboost/sdk/impl/h$a$a;->a:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/chartboost/sdk/impl/i;-><init>(Landroid/content/Context;)V

    goto :goto_0

    .line 292
    :cond_5
    check-cast p2, Lcom/chartboost/sdk/impl/v;

    .line 293
    .end local p2    # "convertView":Landroid/view/View;
    invoke-virtual {p2}, Lcom/chartboost/sdk/impl/v;->a()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/chartboost/sdk/impl/h$b;

    move-object v1, v0

    goto :goto_1

    .line 303
    :cond_6
    new-instance v2, Landroid/widget/AbsListView$LayoutParams;

    .line 304
    invoke-interface {v1}, Lcom/chartboost/sdk/impl/h$b;->a()I

    move-result v4

    invoke-direct {v2, v5, v4}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    .line 303
    invoke-virtual {p2, v2}, Lcom/chartboost/sdk/impl/v;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_2
.end method
