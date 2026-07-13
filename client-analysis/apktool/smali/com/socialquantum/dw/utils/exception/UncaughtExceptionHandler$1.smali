.class Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler$1;
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
    .line 33
    iput-object p1, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler$1;->this$0:Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 39
    iget-object v4, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler$1;->this$0:Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;

    invoke-static {v4}, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->access$100(Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;)Landroid/content/Context;

    move-result-object v4

    iget-object v5, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler$1;->this$0:Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;

    invoke-static {v5}, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->access$000(Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 41
    .local v2, "prefs":Landroid/content/SharedPreferences;
    const-string v4, "flag_crash_with_unhandled_exception"

    invoke-interface {v2, v4, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 43
    .local v0, "crashFlag":I
    const/4 v4, 0x1

    if-ne v0, v4, :cond_0

    .line 45
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 46
    .local v3, "prefsEditor":Landroid/content/SharedPreferences$Editor;
    const-string v4, "flag_crash_with_unhandled_exception"

    invoke-interface {v3, v4, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 47
    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 50
    const/4 v1, 0x0

    .line 51
    .local v1, "obj":Ljava/lang/Object;
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 54
    .end local v1    # "obj":Ljava/lang/Object;
    .end local v3    # "prefsEditor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    return-void
.end method
