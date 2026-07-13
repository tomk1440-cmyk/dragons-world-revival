.class Lio/fabric/unity/android/KitInstantiator;
.super Ljava/lang/Object;
.source "KitInstantiator.java"


# static fields
.field static final TWITTERAUTH_KEY:Ljava/lang/String; = "io.fabric.twittercore.key"

.field static final TWITTERAUTH_SECRET:Ljava/lang/String; = "io.fabric.twittercore.secret"

.field private static final TWITTER_AUTH_CLASSNAME:Ljava/lang/String; = "com.twitter.sdk.android.core.TwitterAuthConfig"

.field static final TWITTER_CORE:Ljava/lang/String; = "TwitterCore"


# instance fields
.field private final manifestMetadata:Landroid/os/Bundle;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    invoke-direct {p0, v0}, Lio/fabric/unity/android/KitInstantiator;-><init>(Landroid/os/Bundle;)V

    .line 25
    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "manifestMetadata"    # Landroid/os/Bundle;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lio/fabric/unity/android/KitInstantiator;->manifestMetadata:Landroid/os/Bundle;

    .line 33
    return-void
.end method

.method private instantiateKit(Lio/fabric/unity/android/KitData;)Lio/fabric/sdk/android/Kit;
    .locals 7
    .param p1, "kitData"    # Lio/fabric/unity/android/KitData;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;,
            Ljava/lang/InstantiationException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 53
    iget-object v4, p1, Lio/fabric/unity/android/KitData;->fullyQualifiedClassName:Ljava/lang/String;

    .line 54
    invoke-static {v4}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v4

    const-class v5, Lio/fabric/sdk/android/Kit;

    invoke-virtual {v4, v5}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v1

    .line 56
    .local v1, "kitClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lio/fabric/sdk/android/Kit;>;"
    const-string v4, "TwitterCore"

    iget-object v5, p1, Lio/fabric/unity/android/KitData;->kitName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 57
    iget-object v4, p0, Lio/fabric/unity/android/KitInstantiator;->manifestMetadata:Landroid/os/Bundle;

    const-string v5, "io.fabric.twittercore.key"

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lio/fabric/unity/android/KitInstantiator;->manifestMetadata:Landroid/os/Bundle;

    const-string v5, "io.fabric.twittercore.secret"

    .line 58
    invoke-virtual {v4, v5}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 59
    :cond_0
    const-string v2, "Could not find Twitter key and secret."

    .line 60
    .local v2, "msg":Ljava/lang/String;
    new-instance v4, Lio/fabric/unity/android/FabricInitializationException;

    const-string v5, "Could not find Twitter key and secret."

    invoke-direct {v4, v5}, Lio/fabric/unity/android/FabricInitializationException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 63
    .end local v2    # "msg":Ljava/lang/String;
    :cond_1
    iget-object v4, p0, Lio/fabric/unity/android/KitInstantiator;->manifestMetadata:Landroid/os/Bundle;

    const-string v5, "io.fabric.twittercore.key"

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 64
    .local v0, "key":Ljava/lang/String;
    iget-object v4, p0, Lio/fabric/unity/android/KitInstantiator;->manifestMetadata:Landroid/os/Bundle;

    const-string v5, "io.fabric.twittercore.secret"

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 66
    .local v3, "secret":Ljava/lang/String;
    iget-object v4, p1, Lio/fabric/unity/android/KitData;->fullyQualifiedClassName:Ljava/lang/String;

    invoke-direct {p0, v4, v0, v3}, Lio/fabric/unity/android/KitInstantiator;->instantiateTwitterKit(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/Kit;

    move-result-object v4

    .line 69
    .end local v0    # "key":Ljava/lang/String;
    .end local v3    # "secret":Ljava/lang/String;
    :goto_0
    return-object v4

    :cond_2
    new-array v4, v6, [Ljava/lang/Class;

    invoke-virtual {v1, v4}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v4

    new-array v5, v6, [Ljava/lang/Object;

    invoke-virtual {v4, v5}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lio/fabric/sdk/android/Kit;

    goto :goto_0
.end method

.method private instantiateTwitterKit(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/Kit;
    .locals 8
    .param p1, "fullyQualifiedClassName"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "secret"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;,
            Ljava/lang/InstantiationException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 76
    .line 77
    invoke-static {p1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    const-class v4, Lio/fabric/sdk/android/Kit;

    invoke-virtual {v3, v4}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v2

    .line 78
    .local v2, "twitterKitClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lio/fabric/sdk/android/Kit;>;"
    const-string v3, "com.twitter.sdk.android.core.TwitterAuthConfig"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 80
    .local v0, "authClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-array v3, v7, [Ljava/lang/Class;

    const-class v4, Ljava/lang/String;

    aput-object v4, v3, v5

    const-class v4, Ljava/lang/String;

    aput-object v4, v3, v6

    invoke-virtual {v0, v3}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object p2, v4, v5

    aput-object p3, v4, v6

    .line 81
    invoke-virtual {v3, v4}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 83
    .local v1, "twitterAuthObj":Ljava/lang/Object;
    new-array v3, v6, [Ljava/lang/Class;

    aput-object v0, v3, v5

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v3

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v1, v4, v5

    .line 84
    invoke-virtual {v3, v4}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lio/fabric/sdk/android/Kit;

    return-object v3
.end method


# virtual methods
.method public createKitsFromKitData([Lio/fabric/unity/android/KitData;)[Lio/fabric/sdk/android/Kit;
    .locals 7
    .param p1, "kitDataArray"    # [Lio/fabric/unity/android/KitData;

    .prologue
    .line 36
    array-length v3, p1

    .line 37
    .local v3, "kitCount":I
    new-array v4, v3, [Lio/fabric/sdk/android/Kit;

    .line 39
    .local v4, "kits":[Lio/fabric/sdk/android/Kit;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v3, :cond_0

    .line 40
    :try_start_0
    aget-object v5, p1, v1

    invoke-direct {p0, v5}, Lio/fabric/unity/android/KitInstantiator;->instantiateKit(Lio/fabric/unity/android/KitData;)Lio/fabric/sdk/android/Kit;

    move-result-object v5

    aput-object v5, v4, v1
    :try_end_0
    .catch Lio/fabric/unity/android/FabricInitializationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 39
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 42
    :catch_0
    move-exception v2

    .line 43
    .local v2, "initEx":Lio/fabric/unity/android/FabricInitializationException;
    throw v2

    .line 44
    .end local v2    # "initEx":Lio/fabric/unity/android/FabricInitializationException;
    :catch_1
    move-exception v0

    .line 45
    .local v0, "e":Ljava/lang/Exception;
    new-instance v5, Lio/fabric/unity/android/FabricInitializationException;

    const-string v6, "Could not instantiate kits"

    invoke-direct {v5, v6, v0}, Lio/fabric/unity/android/FabricInitializationException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .line 47
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    return-object v4
.end method
