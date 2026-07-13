.class Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler$2;
.super Ljava/lang/Object;
.source "UncaughtExceptionHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->testCrash()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;


# direct methods
.method constructor <init>(Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;)V
    .locals 0
    .param p1, "this$0"    # Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler$2;->this$0:Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 67
    const/4 v0, 0x0

    .line 68
    .local v0, "obj":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 70
    return-void
.end method
