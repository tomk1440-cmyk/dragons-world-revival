.class public Lcom/socialquantum/dw/utils/CurrentActivity;
.super Ljava/lang/Object;
.source "CurrentActivity.java"


# static fields
.field public static value:Landroid/app/Activity;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    sput-object v0, Lcom/socialquantum/dw/utils/CurrentActivity;->value:Landroid/app/Activity;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
