.class public final Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;
.super Ljava/lang/Object;
.source "UncaughtExceptionHandler.java"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# instance fields
.field private final CrashTimeout:I

.field private final CrashWithUnhandledExceptionFlagKey:Ljava/lang/String;

.field private final UncaughtExceptionAndroidFlagKey:Ljava/lang/String;

.field private final UncaughtExceptionAndroidReasonKey:Ljava/lang/String;

.field private final UncaughtExceptionAndroidTraceKey:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private final defaultHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

.field private packageName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "packageName"    # Ljava/lang/String;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    const-string v0, "uncaught_exception_android_flag"

    iput-object v0, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->UncaughtExceptionAndroidFlagKey:Ljava/lang/String;

    .line 14
    const-string v0, "uncaught_exception_android_reason"

    iput-object v0, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->UncaughtExceptionAndroidReasonKey:Ljava/lang/String;

    .line 15
    const-string v0, "uncaught_exception_android_trace"

    iput-object v0, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->UncaughtExceptionAndroidTraceKey:Ljava/lang/String;

    .line 16
    const-string v0, "flag_crash_with_unhandled_exception"

    iput-object v0, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->CrashWithUnhandledExceptionFlagKey:Ljava/lang/String;

    .line 17
    const/16 v0, 0x7530

    iput v0, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->CrashTimeout:I

    .line 23
    iput-object p1, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->context:Landroid/content/Context;

    .line 24
    iput-object p2, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->packageName:Ljava/lang/String;

    .line 25
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v0

    iput-object v0, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->defaultHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 27
    invoke-virtual {p0}, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->testCrash()V

    .line 28
    return-void
.end method

.method static synthetic access$000(Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;

    .prologue
    .line 12
    iget-object v0, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->packageName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;

    .prologue
    .line 12
    iget-object v0, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->context:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public testCrash()V
    .locals 6

    .prologue
    .line 31
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 33
    .local v0, "crashHandler":Landroid/os/Handler;
    new-instance v3, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler$1;

    invoke-direct {v3, p0}, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler$1;-><init>(Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;)V

    const-wide/16 v4, 0x7530

    invoke-virtual {v0, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 57
    new-instance v1, Ljava/io/File;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    const-string v4, "javacrash"

    invoke-direct {v1, v3, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 59
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 60
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    .line 62
    .local v2, "handler":Landroid/os/Handler;
    new-instance v3, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler$2;

    invoke-direct {v3, p0}, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler$2;-><init>(Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;)V

    const-wide/16 v4, 0x1388

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 73
    .end local v2    # "handler":Landroid/os/Handler;
    :cond_0
    return-void
.end method

.method public uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 7
    .param p1, "thread"    # Ljava/lang/Thread;
    .param p2, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 78
    iget-object v4, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->context:Landroid/content/Context;

    iget-object v5, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->packageName:Ljava/lang/String;

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 79
    .local v1, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 81
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v4, "uncaught_exception_android_flag"

    const/4 v5, 0x1

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 82
    const-string v4, "uncaught_exception_android_reason"

    invoke-virtual {p2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 84
    new-instance v3, Ljava/io/StringWriter;

    invoke-direct {v3}, Ljava/io/StringWriter;-><init>()V

    .line 85
    .local v3, "sw":Ljava/io/StringWriter;
    new-instance v2, Ljava/io/PrintWriter;

    invoke-direct {v2, v3}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    .line 86
    .local v2, "pw":Ljava/io/PrintWriter;
    invoke-virtual {p2, v2}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 87
    const-string v4, "uncaught_exception_android_trace"

    invoke-virtual {v3}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 89
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 91
    iget-object v4, p0, Lcom/socialquantum/dw/utils/exception/UncaughtExceptionHandler;->defaultHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v4, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 92
    return-void
.end method
