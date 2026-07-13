.class public Lcom/chartboost/sdk/impl/w;
.super Landroid/view/View;
.source "SourceFile"


# instance fields
.field private a:Landroid/os/Handler;

.field private b:F

.field private c:J

.field private d:Landroid/graphics/Paint;

.field private e:Landroid/graphics/Paint;

.field private f:Landroid/graphics/Path;

.field private g:Landroid/graphics/Path;

.field private h:Landroid/graphics/RectF;

.field private i:Landroid/graphics/RectF;

.field private j:Landroid/graphics/Bitmap;

.field private k:Landroid/graphics/Canvas;

.field private l:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 56
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 35
    iput-object v0, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    .line 36
    iput-object v0, p0, Lcom/chartboost/sdk/impl/w;->k:Landroid/graphics/Canvas;

    .line 38
    new-instance v0, Lcom/chartboost/sdk/impl/w$1;

    invoke-direct {v0, p0}, Lcom/chartboost/sdk/impl/w$1;-><init>(Lcom/chartboost/sdk/impl/w;)V

    iput-object v0, p0, Lcom/chartboost/sdk/impl/w;->l:Ljava/lang/Runnable;

    .line 57
    invoke-direct {p0, p1}, Lcom/chartboost/sdk/impl/w;->a(Landroid/content/Context;)V

    .line 58
    return-void
.end method

.method static synthetic a(Lcom/chartboost/sdk/impl/w;)F
    .locals 1

    .prologue
    .line 28
    iget v0, p0, Lcom/chartboost/sdk/impl/w;->b:F

    return v0
.end method

.method private a(Landroid/content/Context;)V
    .locals 8

    .prologue
    const/4 v7, -0x1

    const/4 v6, 0x1

    .line 73
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    .line 74
    const/4 v1, 0x0

    iput v1, p0, Lcom/chartboost/sdk/impl/w;->b:F

    .line 75
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    iput-object v1, p0, Lcom/chartboost/sdk/impl/w;->a:Landroid/os/Handler;

    .line 76
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    long-to-double v2, v2

    const-wide v4, 0x412e848000000000L    # 1000000.0

    div-double/2addr v2, v4

    double-to-long v2, v2

    iput-wide v2, p0, Lcom/chartboost/sdk/impl/w;->c:J

    .line 78
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/chartboost/sdk/impl/w;->d:Landroid/graphics/Paint;

    .line 79
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->d:Landroid/graphics/Paint;

    invoke-virtual {v1, v7}, Landroid/graphics/Paint;->setColor(I)V

    .line 80
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->d:Landroid/graphics/Paint;

    sget-object v2, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 81
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->d:Landroid/graphics/Paint;

    const/high16 v2, 0x40400000    # 3.0f

    mul-float/2addr v0, v2

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 82
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->d:Landroid/graphics/Paint;

    invoke-virtual {v0, v6}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 84
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/chartboost/sdk/impl/w;->e:Landroid/graphics/Paint;

    .line 85
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->e:Landroid/graphics/Paint;

    invoke-virtual {v0, v7}, Landroid/graphics/Paint;->setColor(I)V

    .line 86
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->e:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 87
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->e:Landroid/graphics/Paint;

    invoke-virtual {v0, v6}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 89
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iput-object v0, p0, Lcom/chartboost/sdk/impl/w;->f:Landroid/graphics/Path;

    .line 90
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iput-object v0, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    .line 92
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    .line 93
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/chartboost/sdk/impl/w;->h:Landroid/graphics/RectF;

    .line 97
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-string v1, "setLayerType"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    sget-object v4, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-class v4, Landroid/graphics/Paint;

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 98
    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, p0, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 102
    :goto_0
    return-void

    .line 99
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic a(Lcom/chartboost/sdk/impl/w;F)V
    .locals 0

    .prologue
    .line 28
    iput p1, p0, Lcom/chartboost/sdk/impl/w;->b:F

    return-void
.end method

.method private a(Landroid/graphics/Canvas;)Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 106
    :try_start_0
    const-class v0, Landroid/graphics/Canvas;

    const-string v2, "isHardwareAccelerated"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Class;

    invoke-virtual {v0, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 107
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0, p1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 109
    :goto_0
    return v0

    .line 108
    :catch_0
    move-exception v0

    move v0, v1

    .line 109
    goto :goto_0
.end method


# virtual methods
.method protected onAttachedToWindow()V
    .locals 2

    .prologue
    .line 239
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->a:Landroid/os/Handler;

    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->l:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 240
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->a:Landroid/os/Handler;

    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->l:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 241
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 245
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->a:Landroid/os/Handler;

    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->l:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 246
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 247
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 248
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    .line 249
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 13
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v3, 0x0

    const/high16 v11, 0x40400000    # 3.0f

    const/high16 v10, 0x3fc00000    # 1.5f

    const/high16 v9, 0x40000000    # 2.0f

    const/4 v8, 0x0

    .line 115
    invoke-virtual {p0}, Lcom/chartboost/sdk/impl/w;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v2, v1, Landroid/util/DisplayMetrics;->density:F

    .line 116
    invoke-direct {p0, p1}, Lcom/chartboost/sdk/impl/w;->a(Landroid/graphics/Canvas;)Z

    move-result v4

    .line 118
    const/4 v0, 0x0

    .line 119
    if-eqz v4, :cond_3

    .line 122
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v5

    if-ne v1, v5, :cond_0

    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v5

    if-eq v1, v5, :cond_2

    .line 123
    :cond_0
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v1

    if-nez v1, :cond_1

    .line 124
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->recycle()V

    .line 126
    :cond_1
    :try_start_0
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v1

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v5

    sget-object v6, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v5, v6}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    .line 127
    new-instance v1, Landroid/graphics/Canvas;

    iget-object v5, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    invoke-direct {v1, v5}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    iput-object v1, p0, Lcom/chartboost/sdk/impl/w;->k:Landroid/graphics/Canvas;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    .line 134
    :cond_2
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    invoke-virtual {v1, v3}, Landroid/graphics/Bitmap;->eraseColor(I)V

    .line 136
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->k:Landroid/graphics/Canvas;

    .end local p1    # "canvas":Landroid/graphics/Canvas;
    .local v0, "canvas":Landroid/graphics/Canvas;
    move-object v12, p1

    move-object p1, v0

    .end local v0    # "canvas":Landroid/graphics/Canvas;
    .restart local p1    # "canvas":Landroid/graphics/Canvas;
    move-object v0, v12

    .line 140
    :cond_3
    invoke-static {}, Lcom/chartboost/sdk/Chartboost;->sharedChartboost()Lcom/chartboost/sdk/Chartboost;

    move-result-object v1

    invoke-virtual {v1}, Lcom/chartboost/sdk/Chartboost;->getForcedOrientationDifference()Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;

    move-result-object v5

    .line 141
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 142
    invoke-virtual {v5}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->isReverse()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 143
    const/high16 v1, 0x43340000    # 180.0f

    invoke-virtual {p0}, Lcom/chartboost/sdk/impl/w;->getWidth()I

    move-result v6

    int-to-float v6, v6

    div-float/2addr v6, v9

    invoke-virtual {p0}, Lcom/chartboost/sdk/impl/w;->getHeight()I

    move-result v7

    int-to-float v7, v7

    div-float/2addr v7, v9

    invoke-virtual {p1, v1, v6, v7}, Landroid/graphics/Canvas;->rotate(FFF)V

    .line 146
    :cond_4
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->h:Landroid/graphics/RectF;

    invoke-virtual {p0}, Lcom/chartboost/sdk/impl/w;->getWidth()I

    move-result v6

    int-to-float v6, v6

    invoke-virtual {p0}, Lcom/chartboost/sdk/impl/w;->getHeight()I

    move-result v7

    int-to-float v7, v7

    invoke-virtual {v1, v8, v8, v6, v7}, Landroid/graphics/RectF;->set(FFFF)V

    .line 147
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->h:Landroid/graphics/RectF;

    mul-float v6, v10, v2

    mul-float v7, v10, v2

    invoke-virtual {v1, v6, v7}, Landroid/graphics/RectF;->inset(FF)V

    .line 148
    invoke-virtual {v5}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->isOdd()Z

    move-result v1

    if-eqz v1, :cond_7

    invoke-virtual {p0}, Lcom/chartboost/sdk/impl/w;->getWidth()I

    move-result v1

    :goto_0
    int-to-float v1, v1

    div-float/2addr v1, v9

    .line 149
    iget-object v6, p0, Lcom/chartboost/sdk/impl/w;->h:Landroid/graphics/RectF;

    iget-object v7, p0, Lcom/chartboost/sdk/impl/w;->d:Landroid/graphics/Paint;

    invoke-virtual {p1, v6, v1, v1, v7}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 152
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    iget-object v6, p0, Lcom/chartboost/sdk/impl/w;->h:Landroid/graphics/RectF;

    invoke-virtual {v1, v6}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 153
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    mul-float v6, v11, v2

    mul-float/2addr v2, v11

    invoke-virtual {v1, v6, v2}, Landroid/graphics/RectF;->inset(FF)V

    .line 154
    invoke-virtual {v5}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->isOdd()Z

    move-result v1

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->width()F

    move-result v1

    :goto_1
    div-float/2addr v1, v9

    .line 155
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->f:Landroid/graphics/Path;

    invoke-virtual {v2}, Landroid/graphics/Path;->reset()V

    .line 156
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->f:Landroid/graphics/Path;

    iget-object v6, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    sget-object v7, Landroid/graphics/Path$Direction;->CW:Landroid/graphics/Path$Direction;

    invoke-virtual {v2, v6, v1, v1, v7}, Landroid/graphics/Path;->addRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Path$Direction;)V

    .line 159
    invoke-virtual {v5}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->isOdd()Z

    move-result v1

    if-eqz v1, :cond_9

    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->width()F

    move-result v1

    .line 160
    :goto_2
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    invoke-virtual {v2}, Landroid/graphics/Path;->reset()V

    .line 161
    invoke-virtual {v5}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->isOdd()Z

    move-result v2

    if-eqz v2, :cond_a

    .line 162
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    invoke-virtual {v2, v1, v8}, Landroid/graphics/Path;->moveTo(FF)V

    .line 163
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    invoke-virtual {v2, v1, v1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 164
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    mul-float v6, v1, v9

    invoke-virtual {v2, v8, v6}, Landroid/graphics/Path;->lineTo(FF)V

    .line 165
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    invoke-virtual {v2, v8, v1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 172
    :goto_3
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    invoke-virtual {v2}, Landroid/graphics/Path;->close()V

    .line 175
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 176
    const/4 v2, 0x1

    .line 178
    :try_start_1
    iget-object v6, p0, Lcom/chartboost/sdk/impl/w;->f:Landroid/graphics/Path;

    invoke-virtual {p1, v6}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;)Z
    :try_end_1
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_1 .. :try_end_1} :catch_0

    .line 184
    :goto_4
    if-eqz v2, :cond_5

    .line 186
    neg-float v2, v1

    iget v3, p0, Lcom/chartboost/sdk/impl/w;->b:F

    add-float/2addr v2, v3

    :goto_5
    invoke-virtual {v5}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->isOdd()Z

    move-result v3

    if-eqz v3, :cond_e

    iget-object v3, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->height()F

    move-result v3

    :goto_6
    add-float/2addr v3, v1

    cmpg-float v3, v2, v3

    if-ltz v3, :cond_b

    .line 204
    :cond_5
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 207
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 209
    if-eqz v4, :cond_6

    .line 211
    if-eqz v0, :cond_6

    .line 212
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->j:Landroid/graphics/Bitmap;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v8, v8, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .end local p1    # "canvas":Landroid/graphics/Canvas;
    .restart local v0    # "canvas":Landroid/graphics/Canvas;
    move-object p1, v0

    .line 218
    .end local v0    # "canvas":Landroid/graphics/Canvas;
    .restart local p1    # "canvas":Landroid/graphics/Canvas;
    :cond_6
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    long-to-double v2, v2

    const-wide v4, 0x412e848000000000L    # 1000000.0

    div-double/2addr v2, v4

    double-to-long v2, v2

    .line 219
    iget-wide v4, p0, Lcom/chartboost/sdk/impl/w;->c:J

    sub-long/2addr v2, v4

    .line 220
    const-wide/16 v4, 0x0

    const-wide/16 v6, 0x10

    sub-long v2, v6, v2

    invoke-static {v4, v5, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    .line 222
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->a:Landroid/os/Handler;

    iget-object v4, p0, Lcom/chartboost/sdk/impl/w;->l:Ljava/lang/Runnable;

    invoke-virtual {v1, v4}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 223
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->a:Landroid/os/Handler;

    iget-object v4, p0, Lcom/chartboost/sdk/impl/w;->l:Ljava/lang/Runnable;

    invoke-virtual {v1, v4, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 224
    :goto_7
    return-void

    .line 148
    :cond_7
    invoke-virtual {p0}, Lcom/chartboost/sdk/impl/w;->getHeight()I

    move-result v1

    goto/16 :goto_0

    .line 154
    :cond_8
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->height()F

    move-result v1

    goto/16 :goto_1

    .line 159
    :cond_9
    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->height()F

    move-result v1

    goto/16 :goto_2

    .line 167
    :cond_a
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    invoke-virtual {v2, v8, v1}, Landroid/graphics/Path;->moveTo(FF)V

    .line 168
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    invoke-virtual {v2, v1, v1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 169
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    mul-float v6, v1, v9

    invoke-virtual {v2, v6, v8}, Landroid/graphics/Path;->lineTo(FF)V

    .line 170
    iget-object v2, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    invoke-virtual {v2, v1, v8}, Landroid/graphics/Path;->lineTo(FF)V

    goto/16 :goto_3

    .line 179
    :catch_0
    move-exception v2

    move v2, v3

    .line 182
    goto :goto_4

    .line 187
    :cond_b
    invoke-virtual {v5}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->isOdd()Z

    move-result v3

    if-eqz v3, :cond_c

    iget-object v3, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    iget v3, v3, Landroid/graphics/RectF;->top:F

    .line 188
    :goto_8
    add-float/2addr v3, v2

    .line 191
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 192
    invoke-virtual {v5}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->isOdd()Z

    move-result v6

    if-eqz v6, :cond_d

    .line 193
    iget-object v6, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    iget v6, v6, Landroid/graphics/RectF;->left:F

    invoke-virtual {p1, v6, v3}, Landroid/graphics/Canvas;->translate(FF)V

    .line 198
    :goto_9
    iget-object v3, p0, Lcom/chartboost/sdk/impl/w;->g:Landroid/graphics/Path;

    iget-object v6, p0, Lcom/chartboost/sdk/impl/w;->e:Landroid/graphics/Paint;

    invoke-virtual {p1, v3, v6}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 201
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 186
    mul-float v3, v9, v1

    add-float/2addr v2, v3

    goto/16 :goto_5

    .line 187
    :cond_c
    iget-object v3, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    iget v3, v3, Landroid/graphics/RectF;->left:F

    goto :goto_8

    .line 195
    :cond_d
    iget-object v6, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    iget v6, v6, Landroid/graphics/RectF;->top:F

    invoke-virtual {p1, v3, v6}, Landroid/graphics/Canvas;->translate(FF)V

    goto :goto_9

    .line 186
    :cond_e
    iget-object v3, p0, Lcom/chartboost/sdk/impl/w;->i:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->width()F

    move-result v3

    goto/16 :goto_6

    .line 128
    :catch_1
    move-exception v1

    goto :goto_7
.end method

.method protected onWindowVisibilityChanged(I)V
    .locals 2
    .param p1, "visibility"    # I

    .prologue
    .line 230
    invoke-super {p0, p1}, Landroid/view/View;->onWindowVisibilityChanged(I)V

    .line 231
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->a:Landroid/os/Handler;

    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->l:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 233
    if-nez p1, :cond_0

    .line 234
    iget-object v0, p0, Lcom/chartboost/sdk/impl/w;->a:Landroid/os/Handler;

    iget-object v1, p0, Lcom/chartboost/sdk/impl/w;->l:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 235
    :cond_0
    return-void
.end method
