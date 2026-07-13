.class abstract Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;
.super Ljava/lang/Object;
.source "UnityPlayerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x400
    name = "Extender"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;


# direct methods
.method constructor <init>(Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;

    .prologue
    .line 262
    iput-object p1, p0, Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity$Extender;->this$0:Lcom/socialquantum/dw/mainactivity/UnityPlayerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract onCreate(Landroid/app/Activity;)V
.end method

.method public abstract onDestroy()V
.end method

.method public abstract onStart()V
.end method

.method public abstract onStop()V
.end method
