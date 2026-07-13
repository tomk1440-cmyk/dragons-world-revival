.class public Lcom/chartboost/sdk/impl/p;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/chartboost/sdk/impl/p$a;,
        Lcom/chartboost/sdk/impl/p$b;
    }
.end annotation


# static fields
.field private static synthetic a:[I

.field private static synthetic b:[I


# direct methods
.method public static a(Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;)V
    .locals 1

    .prologue
    .line 47
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/chartboost/sdk/impl/p;->a(Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;Lcom/chartboost/sdk/impl/p$a;)V

    .line 48
    return-void
.end method

.method public static a(Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;Lcom/chartboost/sdk/impl/p$a;)V
    .locals 1

    .prologue
    .line 51
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/chartboost/sdk/impl/p;->b(Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;Lcom/chartboost/sdk/impl/p$a;Ljava/lang/Boolean;)V

    .line 52
    return-void
.end method

.method static synthetic a(Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;Lcom/chartboost/sdk/impl/p$a;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 95
    invoke-static {p0, p1, p2, p3}, Lcom/chartboost/sdk/impl/p;->c(Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;Lcom/chartboost/sdk/impl/p$a;Ljava/lang/Boolean;)V

    return-void
.end method

.method static synthetic a()[I
    .locals 3

    .prologue
    .line 19
    sget-object v0, Lcom/chartboost/sdk/impl/p;->a:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->values()[Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ANGLE_0:Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;

    invoke-virtual {v1}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_3

    :goto_1
    :try_start_1
    sget-object v1, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ANGLE_180:Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;

    invoke-virtual {v1}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_2

    :goto_2
    :try_start_2
    sget-object v1, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ANGLE_270:Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;

    invoke-virtual {v1}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_1

    :goto_3
    :try_start_3
    sget-object v1, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ANGLE_90:Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;

    invoke-virtual {v1}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_0

    :goto_4
    sput-object v0, Lcom/chartboost/sdk/impl/p;->a:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_4

    :catch_1
    move-exception v1

    goto :goto_3

    :catch_2
    move-exception v1

    goto :goto_2

    :catch_3
    move-exception v1

    goto :goto_1
.end method

.method public static b(Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;Lcom/chartboost/sdk/impl/p$a;)V
    .locals 1

    .prologue
    .line 60
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/chartboost/sdk/impl/p;->c(Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;Lcom/chartboost/sdk/impl/p$a;Ljava/lang/Boolean;)V

    .line 61
    return-void
.end method

.method private static b(Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;Lcom/chartboost/sdk/impl/p$a;Ljava/lang/Boolean;)V
    .locals 7

    .prologue
    .line 66
    sget-object v0, Lcom/chartboost/sdk/impl/p$b;->f:Lcom/chartboost/sdk/impl/p$b;

    if-ne p0, v0, :cond_1

    .line 67
    if-eqz p2, :cond_0

    invoke-interface {p2, p1}, Lcom/chartboost/sdk/impl/p$a;->a(Lcom/chartboost/sdk/impl/a;)V

    .line 93
    :cond_0
    :goto_0
    return-void

    .line 72
    :cond_1
    if-eqz p1, :cond_0

    iget-object v0, p1, Lcom/chartboost/sdk/impl/a;->h:Lcom/chartboost/sdk/impl/u;

    if-eqz v0, :cond_0

    .line 77
    iget-object v0, p1, Lcom/chartboost/sdk/impl/a;->h:Lcom/chartboost/sdk/impl/u;

    invoke-virtual {v0}, Lcom/chartboost/sdk/impl/u;->c()Landroid/view/View;

    move-result-object v1

    .line 78
    if-eqz v1, :cond_0

    .line 83
    invoke-virtual {v1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v6

    .line 84
    invoke-virtual {v6}, Landroid/view/ViewTreeObserver;->isAlive()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 85
    new-instance v0, Lcom/chartboost/sdk/impl/p$1;

    move-object v2, p0

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/chartboost/sdk/impl/p$1;-><init>(Landroid/view/View;Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;Lcom/chartboost/sdk/impl/p$a;Ljava/lang/Boolean;)V

    invoke-virtual {v6, v0}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_0
.end method

.method static synthetic b()[I
    .locals 3

    .prologue
    .line 19
    sget-object v0, Lcom/chartboost/sdk/impl/p;->b:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/chartboost/sdk/impl/p$b;->values()[Lcom/chartboost/sdk/impl/p$b;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/chartboost/sdk/impl/p$b;->b:Lcom/chartboost/sdk/impl/p$b;

    invoke-virtual {v1}, Lcom/chartboost/sdk/impl/p$b;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_5

    :goto_1
    :try_start_1
    sget-object v1, Lcom/chartboost/sdk/impl/p$b;->f:Lcom/chartboost/sdk/impl/p$b;

    invoke-virtual {v1}, Lcom/chartboost/sdk/impl/p$b;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_4

    :goto_2
    :try_start_2
    sget-object v1, Lcom/chartboost/sdk/impl/p$b;->a:Lcom/chartboost/sdk/impl/p$b;

    invoke-virtual {v1}, Lcom/chartboost/sdk/impl/p$b;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_3

    :goto_3
    :try_start_3
    sget-object v1, Lcom/chartboost/sdk/impl/p$b;->c:Lcom/chartboost/sdk/impl/p$b;

    invoke-virtual {v1}, Lcom/chartboost/sdk/impl/p$b;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_2

    :goto_4
    :try_start_4
    sget-object v1, Lcom/chartboost/sdk/impl/p$b;->d:Lcom/chartboost/sdk/impl/p$b;

    invoke-virtual {v1}, Lcom/chartboost/sdk/impl/p$b;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_1

    :goto_5
    :try_start_5
    sget-object v1, Lcom/chartboost/sdk/impl/p$b;->e:Lcom/chartboost/sdk/impl/p$b;

    invoke-virtual {v1}, Lcom/chartboost/sdk/impl/p$b;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_0

    :goto_6
    sput-object v0, Lcom/chartboost/sdk/impl/p;->b:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_6

    :catch_1
    move-exception v1

    goto :goto_5

    :catch_2
    move-exception v1

    goto :goto_4

    :catch_3
    move-exception v1

    goto :goto_3

    :catch_4
    move-exception v1

    goto :goto_2

    :catch_5
    move-exception v1

    goto :goto_1
.end method

.method private static c(Lcom/chartboost/sdk/impl/p$b;Lcom/chartboost/sdk/impl/a;Lcom/chartboost/sdk/impl/p$a;Ljava/lang/Boolean;)V
    .locals 18

    .prologue
    .line 97
    const-wide/16 v12, 0x258

    .line 98
    new-instance v11, Landroid/view/animation/AnimationSet;

    const/4 v2, 0x1

    invoke-direct {v11, v2}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 99
    new-instance v2, Landroid/view/animation/AlphaAnimation;

    const/high16 v3, 0x3f800000    # 1.0f

    const/high16 v4, 0x3f800000    # 1.0f

    invoke-direct {v2, v3, v4}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 102
    if-eqz p1, :cond_0

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/chartboost/sdk/impl/a;->h:Lcom/chartboost/sdk/impl/u;

    if-nez v2, :cond_1

    .line 338
    :cond_0
    :goto_0
    return-void

    .line 107
    :cond_1
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/chartboost/sdk/impl/a;->h:Lcom/chartboost/sdk/impl/u;

    invoke-virtual {v2}, Lcom/chartboost/sdk/impl/u;->c()Landroid/view/View;

    move-result-object v14

    .line 108
    if-eqz v14, :cond_0

    .line 114
    invoke-virtual {v14}, Landroid/view/View;->getWidth()I

    move-result v2

    int-to-float v10, v2

    .line 115
    invoke-virtual {v14}, Landroid/view/View;->getHeight()I

    move-result v2

    int-to-float v9, v2

    .line 116
    const/high16 v4, 0x42700000    # 60.0f

    .line 117
    const v15, 0x3ecccccd    # 0.4f

    .line 118
    const/high16 v2, 0x3f800000    # 1.0f

    sub-float/2addr v2, v15

    const/high16 v3, 0x40000000    # 2.0f

    div-float v16, v2, v3

    .line 125
    invoke-static {}, Lcom/chartboost/sdk/Chartboost;->sharedChartboost()Lcom/chartboost/sdk/Chartboost;

    move-result-object v2

    invoke-virtual {v2}, Lcom/chartboost/sdk/Chartboost;->getForcedOrientationDifference()Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;

    move-result-object v17

    .line 127
    invoke-static {}, Lcom/chartboost/sdk/impl/p;->b()[I

    move-result-object v2

    invoke-virtual/range {p0 .. p0}, Lcom/chartboost/sdk/impl/p$b;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 326
    :goto_1
    sget-object v2, Lcom/chartboost/sdk/impl/p$b;->f:Lcom/chartboost/sdk/impl/p$b;

    move-object/from16 v0, p0

    if-ne v0, v2, :cond_25

    .line 327
    if-eqz p2, :cond_0

    move-object/from16 v0, p2

    move-object/from16 v1, p1

    invoke-interface {v0, v1}, Lcom/chartboost/sdk/impl/p$a;->a(Lcom/chartboost/sdk/impl/a;)V

    goto :goto_0

    .line 129
    :pswitch_0
    invoke-static {}, Lcom/chartboost/sdk/impl/p;->a()[I

    move-result-object v2

    invoke-virtual/range {v17 .. v17}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_1

    .line 144
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_5

    new-instance v2, Lcom/chartboost/sdk/impl/r;

    neg-float v3, v4

    const/4 v4, 0x0

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x0

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    .line 148
    :goto_2
    invoke-virtual {v2, v12, v13}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 149
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 150
    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 152
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_6

    new-instance v2, Landroid/view/animation/ScaleAnimation;

    const/high16 v3, 0x3f800000    # 1.0f

    const/high16 v4, 0x3f800000    # 1.0f

    invoke-direct {v2, v15, v3, v15, v4}, Landroid/view/animation/ScaleAnimation;-><init>(FFFF)V

    .line 154
    :goto_3
    invoke-virtual {v2, v12, v13}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 155
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 156
    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 158
    invoke-static {}, Lcom/chartboost/sdk/impl/p;->a()[I

    move-result-object v2

    invoke-virtual/range {v17 .. v17}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_2

    .line 173
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_a

    new-instance v2, Landroid/view/animation/TranslateAnimation;

    mul-float v3, v10, v16

    const/4 v4, 0x0

    neg-float v5, v9

    mul-float/2addr v5, v15

    const/4 v6, 0x0

    invoke-direct {v2, v3, v4, v5, v6}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    .line 177
    :goto_4
    invoke-virtual {v2, v12, v13}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 178
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 179
    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    goto :goto_1

    .line 131
    :pswitch_1
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_2

    new-instance v2, Lcom/chartboost/sdk/impl/r;

    neg-float v3, v4

    const/4 v4, 0x0

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x1

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    goto :goto_2

    .line 132
    :cond_2
    new-instance v2, Lcom/chartboost/sdk/impl/r;

    const/4 v3, 0x0

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x1

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    goto :goto_2

    .line 135
    :pswitch_2
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_3

    new-instance v3, Lcom/chartboost/sdk/impl/r;

    const/4 v5, 0x0

    const/high16 v2, 0x40000000    # 2.0f

    div-float v6, v10, v2

    const/high16 v2, 0x40000000    # 2.0f

    div-float v7, v9, v2

    const/4 v8, 0x0

    invoke-direct/range {v3 .. v8}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    move-object v2, v3

    goto/16 :goto_2

    .line 136
    :cond_3
    new-instance v2, Lcom/chartboost/sdk/impl/r;

    const/4 v3, 0x0

    neg-float v4, v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x0

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    goto/16 :goto_2

    .line 139
    :pswitch_3
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_4

    new-instance v3, Lcom/chartboost/sdk/impl/r;

    const/4 v5, 0x0

    const/high16 v2, 0x40000000    # 2.0f

    div-float v6, v10, v2

    const/high16 v2, 0x40000000    # 2.0f

    div-float v7, v9, v2

    const/4 v8, 0x1

    invoke-direct/range {v3 .. v8}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    move-object v2, v3

    goto/16 :goto_2

    .line 140
    :cond_4
    new-instance v2, Lcom/chartboost/sdk/impl/r;

    const/4 v3, 0x0

    neg-float v4, v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x1

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    goto/16 :goto_2

    .line 145
    :cond_5
    new-instance v2, Lcom/chartboost/sdk/impl/r;

    const/4 v3, 0x0

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x0

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    goto/16 :goto_2

    .line 153
    :cond_6
    new-instance v2, Landroid/view/animation/ScaleAnimation;

    const/high16 v3, 0x3f800000    # 1.0f

    const/high16 v4, 0x3f800000    # 1.0f

    invoke-direct {v2, v3, v15, v4, v15}, Landroid/view/animation/ScaleAnimation;-><init>(FFFF)V

    goto/16 :goto_3

    .line 160
    :pswitch_4
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_7

    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v3, 0x0

    mul-float v4, v9, v16

    const/4 v5, 0x0

    invoke-direct {v2, v10, v3, v4, v5}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_4

    .line 161
    :cond_7
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v3, 0x0

    neg-float v4, v10

    mul-float/2addr v4, v15

    const/4 v5, 0x0

    mul-float v6, v9, v16

    invoke-direct {v2, v3, v4, v5, v6}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_4

    .line 164
    :pswitch_5
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_8

    new-instance v2, Landroid/view/animation/TranslateAnimation;

    mul-float v3, v10, v16

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-direct {v2, v3, v4, v9, v5}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_4

    .line 165
    :cond_8
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v3, 0x0

    mul-float v4, v10, v16

    const/4 v5, 0x0

    neg-float v6, v9

    mul-float/2addr v6, v15

    invoke-direct {v2, v3, v4, v5, v6}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_4

    .line 168
    :pswitch_6
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_9

    new-instance v2, Landroid/view/animation/TranslateAnimation;

    neg-float v3, v10

    mul-float/2addr v3, v15

    const/4 v4, 0x0

    mul-float v5, v9, v16

    const/4 v6, 0x0

    invoke-direct {v2, v3, v4, v5, v6}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_4

    .line 169
    :cond_9
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v3, 0x0

    const/4 v4, 0x0

    mul-float v5, v9, v16

    invoke-direct {v2, v3, v10, v4, v5}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_4

    .line 174
    :cond_a
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v3, 0x0

    mul-float v4, v10, v16

    const/4 v5, 0x0

    invoke-direct {v2, v3, v4, v5, v9}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_4

    .line 184
    :pswitch_7
    invoke-static {}, Lcom/chartboost/sdk/impl/p;->a()[I

    move-result-object v2

    invoke-virtual/range {v17 .. v17}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_3

    .line 199
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_e

    new-instance v2, Lcom/chartboost/sdk/impl/r;

    neg-float v3, v4

    const/4 v4, 0x0

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x1

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    .line 203
    :goto_5
    invoke-virtual {v2, v12, v13}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 204
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 205
    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 207
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_f

    new-instance v2, Landroid/view/animation/ScaleAnimation;

    const/high16 v3, 0x3f800000    # 1.0f

    const/high16 v4, 0x3f800000    # 1.0f

    invoke-direct {v2, v15, v3, v15, v4}, Landroid/view/animation/ScaleAnimation;-><init>(FFFF)V

    .line 209
    :goto_6
    invoke-virtual {v2, v12, v13}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 210
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 211
    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 213
    invoke-static {}, Lcom/chartboost/sdk/impl/p;->a()[I

    move-result-object v2

    invoke-virtual/range {v17 .. v17}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_4

    .line 228
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_13

    new-instance v2, Landroid/view/animation/TranslateAnimation;

    neg-float v3, v10

    mul-float/2addr v3, v15

    const/4 v4, 0x0

    mul-float v5, v9, v16

    const/4 v6, 0x0

    invoke-direct {v2, v3, v4, v5, v6}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    .line 232
    :goto_7
    invoke-virtual {v2, v12, v13}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 233
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 234
    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_1

    .line 186
    :pswitch_8
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_b

    new-instance v3, Lcom/chartboost/sdk/impl/r;

    const/4 v5, 0x0

    const/high16 v2, 0x40000000    # 2.0f

    div-float v6, v10, v2

    const/high16 v2, 0x40000000    # 2.0f

    div-float v7, v9, v2

    const/4 v8, 0x0

    invoke-direct/range {v3 .. v8}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    move-object v2, v3

    goto :goto_5

    .line 187
    :cond_b
    new-instance v2, Lcom/chartboost/sdk/impl/r;

    const/4 v3, 0x0

    neg-float v4, v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x0

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    goto :goto_5

    .line 190
    :pswitch_9
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_c

    new-instance v3, Lcom/chartboost/sdk/impl/r;

    const/4 v5, 0x0

    const/high16 v2, 0x40000000    # 2.0f

    div-float v6, v10, v2

    const/high16 v2, 0x40000000    # 2.0f

    div-float v7, v9, v2

    const/4 v8, 0x1

    invoke-direct/range {v3 .. v8}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    move-object v2, v3

    goto/16 :goto_5

    .line 191
    :cond_c
    new-instance v2, Lcom/chartboost/sdk/impl/r;

    const/4 v3, 0x0

    neg-float v4, v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x1

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    goto/16 :goto_5

    .line 194
    :pswitch_a
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_d

    new-instance v2, Lcom/chartboost/sdk/impl/r;

    neg-float v3, v4

    const/4 v4, 0x0

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x0

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    goto/16 :goto_5

    .line 195
    :cond_d
    new-instance v2, Lcom/chartboost/sdk/impl/r;

    const/4 v3, 0x0

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x0

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    goto/16 :goto_5

    .line 200
    :cond_e
    new-instance v2, Lcom/chartboost/sdk/impl/r;

    const/4 v3, 0x0

    const/high16 v5, 0x40000000    # 2.0f

    div-float v5, v10, v5

    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v9, v6

    const/4 v7, 0x1

    invoke-direct/range {v2 .. v7}, Lcom/chartboost/sdk/impl/r;-><init>(FFFFZ)V

    goto/16 :goto_5

    .line 208
    :cond_f
    new-instance v2, Landroid/view/animation/ScaleAnimation;

    const/high16 v3, 0x3f800000    # 1.0f

    const/high16 v4, 0x3f800000    # 1.0f

    invoke-direct {v2, v3, v15, v4, v15}, Landroid/view/animation/ScaleAnimation;-><init>(FFFF)V

    goto/16 :goto_6

    .line 215
    :pswitch_b
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_10

    new-instance v2, Landroid/view/animation/TranslateAnimation;

    mul-float v3, v10, v16

    const/4 v4, 0x0

    neg-float v5, v9

    mul-float/2addr v5, v15

    const/4 v6, 0x0

    invoke-direct {v2, v3, v4, v5, v6}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_7

    .line 216
    :cond_10
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v3, 0x0

    mul-float v4, v10, v16

    const/4 v5, 0x0

    invoke-direct {v2, v3, v4, v5, v9}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_7

    .line 219
    :pswitch_c
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_11

    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v3, 0x0

    mul-float v4, v9, v16

    const/4 v5, 0x0

    invoke-direct {v2, v10, v3, v4, v5}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_7

    .line 220
    :cond_11
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v3, 0x0

    neg-float v4, v10

    mul-float/2addr v4, v15

    const/4 v5, 0x0

    mul-float v6, v9, v16

    invoke-direct {v2, v3, v4, v5, v6}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_7

    .line 223
    :pswitch_d
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_12

    new-instance v2, Landroid/view/animation/TranslateAnimation;

    mul-float v3, v10, v16

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-direct {v2, v3, v4, v9, v5}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_7

    .line 224
    :cond_12
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v3, 0x0

    mul-float v4, v10, v16

    const/4 v5, 0x0

    neg-float v6, v9

    mul-float/2addr v6, v15

    invoke-direct {v2, v3, v4, v5, v6}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_7

    .line 229
    :cond_13
    new-instance v2, Landroid/view/animation/TranslateAnimation;

    const/4 v3, 0x0

    const/4 v4, 0x0

    mul-float v5, v9, v16

    invoke-direct {v2, v3, v10, v4, v5}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    goto/16 :goto_7

    .line 239
    :pswitch_e
    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 240
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 241
    invoke-static {}, Lcom/chartboost/sdk/impl/p;->a()[I

    move-result-object v2

    invoke-virtual/range {v17 .. v17}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_5

    move v9, v4

    move v2, v5

    move v3, v6

    move v4, v7

    .line 259
    :goto_8
    new-instance v5, Landroid/view/animation/TranslateAnimation;

    invoke-direct {v5, v4, v3, v2, v9}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    .line 260
    invoke-virtual {v5, v12, v13}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 261
    const/4 v2, 0x1

    invoke-virtual {v5, v2}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 262
    invoke-virtual {v11, v5}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_1

    .line 243
    :pswitch_f
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_15

    move v2, v9

    .line 244
    :goto_9
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_14

    const/4 v9, 0x0

    :cond_14
    move v3, v6

    move v4, v7

    .line 245
    goto :goto_8

    .line 243
    :cond_15
    const/4 v2, 0x0

    goto :goto_9

    .line 247
    :pswitch_10
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_16

    neg-float v2, v10

    .line 248
    :goto_a
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_17

    const/4 v3, 0x0

    :goto_b
    move v9, v4

    move v4, v2

    move v2, v5

    .line 249
    goto :goto_8

    .line 247
    :cond_16
    const/4 v2, 0x0

    goto :goto_a

    .line 248
    :cond_17
    neg-float v3, v10

    goto :goto_b

    .line 251
    :pswitch_11
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_18

    neg-float v2, v9

    .line 252
    :goto_c
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_19

    const/4 v3, 0x0

    :goto_d
    move v9, v3

    move v4, v7

    move v3, v6

    .line 253
    goto :goto_8

    .line 251
    :cond_18
    const/4 v2, 0x0

    goto :goto_c

    .line 252
    :cond_19
    neg-float v3, v9

    goto :goto_d

    .line 255
    :pswitch_12
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1b

    move v2, v10

    .line 256
    :goto_e
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_1a

    const/4 v10, 0x0

    :cond_1a
    move v9, v4

    move v3, v10

    move v4, v2

    move v2, v5

    goto :goto_8

    .line 255
    :cond_1b
    const/4 v2, 0x0

    goto :goto_e

    .line 267
    :pswitch_13
    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 268
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 269
    invoke-static {}, Lcom/chartboost/sdk/impl/p;->a()[I

    move-result-object v2

    invoke-virtual/range {v17 .. v17}, Lcom/chartboost/sdk/Libraries/CBOrientation$Difference;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_6

    move v3, v4

    move v2, v5

    move v10, v6

    move v4, v7

    .line 287
    :goto_f
    new-instance v5, Landroid/view/animation/TranslateAnimation;

    invoke-direct {v5, v4, v10, v2, v3}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    .line 288
    invoke-virtual {v5, v12, v13}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 289
    const/4 v2, 0x1

    invoke-virtual {v5, v2}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 290
    invoke-virtual {v11, v5}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_1

    .line 271
    :pswitch_14
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1c

    neg-float v2, v9

    .line 272
    :goto_10
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_1d

    const/4 v3, 0x0

    :goto_11
    move v10, v6

    move v4, v7

    .line 273
    goto :goto_f

    .line 271
    :cond_1c
    const/4 v2, 0x0

    goto :goto_10

    .line 272
    :cond_1d
    neg-float v3, v9

    goto :goto_11

    .line 275
    :pswitch_15
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1f

    move v2, v10

    .line 276
    :goto_12
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_1e

    const/4 v10, 0x0

    :cond_1e
    move v3, v4

    move v4, v2

    move v2, v5

    .line 277
    goto :goto_f

    .line 275
    :cond_1f
    const/4 v2, 0x0

    goto :goto_12

    .line 279
    :pswitch_16
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_21

    move v2, v9

    .line 280
    :goto_13
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_20

    const/4 v9, 0x0

    :cond_20
    move v3, v9

    move v10, v6

    move v4, v7

    .line 281
    goto :goto_f

    .line 279
    :cond_21
    const/4 v2, 0x0

    goto :goto_13

    .line 283
    :pswitch_17
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_22

    neg-float v2, v10

    .line 284
    :goto_14
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_23

    const/4 v3, 0x0

    :goto_15
    move v10, v3

    move v3, v4

    move v4, v2

    move v2, v5

    goto :goto_f

    .line 283
    :cond_22
    const/4 v2, 0x0

    goto :goto_14

    .line 284
    :cond_23
    neg-float v3, v10

    goto :goto_15

    .line 294
    :pswitch_18
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_24

    .line 295
    new-instance v2, Landroid/view/animation/ScaleAnimation;

    const v3, 0x3f19999a    # 0.6f

    const v4, 0x3f8ccccd    # 1.1f

    const v5, 0x3f19999a    # 0.6f

    const v6, 0x3f8ccccd    # 1.1f

    const/4 v7, 0x1

    const/high16 v8, 0x3f000000    # 0.5f

    const/4 v9, 0x1

    const/high16 v10, 0x3f000000    # 0.5f

    invoke-direct/range {v2 .. v10}, Landroid/view/animation/ScaleAnimation;-><init>(FFFFIFIF)V

    .line 296
    long-to-float v3, v12

    const v4, 0x3f19999a    # 0.6f

    mul-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    int-to-long v4, v3

    invoke-virtual {v2, v4, v5}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 297
    const-wide/16 v4, 0x0

    invoke-virtual {v2, v4, v5}, Landroid/view/animation/Animation;->setStartOffset(J)V

    .line 298
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 299
    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 301
    new-instance v2, Landroid/view/animation/ScaleAnimation;

    const/high16 v3, 0x3f800000    # 1.0f

    const v4, 0x3f51745c

    const/high16 v5, 0x3f800000    # 1.0f

    const v6, 0x3f51745c

    const/4 v7, 0x1

    const/high16 v8, 0x3f000000    # 0.5f

    const/4 v9, 0x1

    const/high16 v10, 0x3f000000    # 0.5f

    invoke-direct/range {v2 .. v10}, Landroid/view/animation/ScaleAnimation;-><init>(FFFFIFIF)V

    .line 302
    long-to-float v3, v12

    const v4, 0x3e4ccccc    # 0.19999999f

    mul-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    int-to-long v4, v3

    invoke-virtual {v2, v4, v5}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 304
    long-to-float v3, v12

    const v4, 0x3f19999a    # 0.6f

    mul-float/2addr v3, v4

    .line 303
    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    int-to-long v4, v3

    invoke-virtual {v2, v4, v5}, Landroid/view/animation/Animation;->setStartOffset(J)V

    .line 305
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 306
    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 308
    new-instance v2, Landroid/view/animation/ScaleAnimation;

    const/high16 v3, 0x3f800000    # 1.0f

    const v4, 0x3f8e38e4

    const/high16 v5, 0x3f800000    # 1.0f

    const v6, 0x3f8e38e4

    const/4 v7, 0x1

    const/high16 v8, 0x3f000000    # 0.5f

    const/4 v9, 0x1

    const/high16 v10, 0x3f000000    # 0.5f

    invoke-direct/range {v2 .. v10}, Landroid/view/animation/ScaleAnimation;-><init>(FFFFIFIF)V

    .line 309
    long-to-float v3, v12

    const v4, 0x3dccccc8    # 0.099999964f

    mul-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    int-to-long v4, v3

    invoke-virtual {v2, v4, v5}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 310
    long-to-float v3, v12

    const v4, 0x3f4ccccd    # 0.8f

    mul-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    int-to-long v4, v3

    invoke-virtual {v2, v4, v5}, Landroid/view/animation/Animation;->setStartOffset(J)V

    .line 311
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 312
    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_1

    .line 315
    :cond_24
    new-instance v2, Landroid/view/animation/ScaleAnimation;

    const/high16 v3, 0x3f800000    # 1.0f

    const/4 v4, 0x0

    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v6, 0x0

    const/4 v7, 0x1

    const/high16 v8, 0x3f000000    # 0.5f

    const/4 v9, 0x1

    const/high16 v10, 0x3f000000    # 0.5f

    invoke-direct/range {v2 .. v10}, Landroid/view/animation/ScaleAnimation;-><init>(FFFFIFIF)V

    .line 316
    invoke-virtual {v2, v12, v13}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 317
    const-wide/16 v4, 0x0

    invoke-virtual {v2, v4, v5}, Landroid/view/animation/Animation;->setStartOffset(J)V

    .line 318
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 319
    invoke-virtual {v11, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_1

    .line 331
    :cond_25
    invoke-static {}, Lcom/chartboost/sdk/Chartboost;->sharedChartboost()Lcom/chartboost/sdk/Chartboost;

    move-result-object v2

    invoke-virtual {v2}, Lcom/chartboost/sdk/Chartboost;->getHandler()Landroid/os/Handler;

    move-result-object v2

    new-instance v3, Lcom/chartboost/sdk/impl/p$2;

    move-object/from16 v0, p2

    move-object/from16 v1, p1

    invoke-direct {v3, v0, v1}, Lcom/chartboost/sdk/impl/p$2;-><init>(Lcom/chartboost/sdk/impl/p$a;Lcom/chartboost/sdk/impl/a;)V

    invoke-virtual {v2, v3, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 336
    invoke-virtual {v14, v11}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_0

    .line 127
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_7
        :pswitch_18
        :pswitch_0
        :pswitch_e
        :pswitch_13
    .end packed-switch

    .line 129
    :pswitch_data_1
    .packed-switch 0x2
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch

    .line 158
    :pswitch_data_2
    .packed-switch 0x2
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch

    .line 184
    :pswitch_data_3
    .packed-switch 0x2
        :pswitch_8
        :pswitch_9
        :pswitch_a
    .end packed-switch

    .line 213
    :pswitch_data_4
    .packed-switch 0x2
        :pswitch_b
        :pswitch_c
        :pswitch_d
    .end packed-switch

    .line 241
    :pswitch_data_5
    .packed-switch 0x1
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
    .end packed-switch

    .line 269
    :pswitch_data_6
    .packed-switch 0x1
        :pswitch_14
        :pswitch_15
        :pswitch_16
        :pswitch_17
    .end packed-switch
.end method
