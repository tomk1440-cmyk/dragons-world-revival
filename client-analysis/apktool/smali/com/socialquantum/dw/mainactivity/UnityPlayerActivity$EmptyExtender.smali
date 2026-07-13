.class Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$EmptyExtender;
.super Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;
.source "UnityPlayerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "EmptyExtender"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;


# direct methods
.method constructor <init>(Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;

    .prologue
    .line 311
    iput-object p1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$EmptyExtender;->this$0:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;

    invoke-direct {p0, p1}, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;-><init>(Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;)V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 314
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 326
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 318
    return-void
.end method

.method public onStop()V
    .locals 0

    .prologue
    .line 322
    return-void
.end method
