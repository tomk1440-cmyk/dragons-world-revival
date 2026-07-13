.class Lio/fabric/unity/android/BundleKitDataProvider;
.super Ljava/lang/Object;
.source "BundleKitDataProvider.java"

# interfaces
.implements Lio/fabric/unity/android/KitDataProvider;


# static fields
.field static final INITIALIZATION_KITS_LIST:Ljava/lang/String; = "InitializationKitsList"

.field static final INITIALIZATION_TYPE:Ljava/lang/String; = "InitializationType"

.field static final KEY_PREFIX:Ljava/lang/String; = "io.fabric"

.field static final KITS_KEY:Ljava/lang/String; = "io.fabric.kits"

.field static final KITS_SUFFIX:Ljava/lang/String; = ".kits"

.field static final NAME_SUFFIX:Ljava/lang/String; = ".unqualified"

.field private static final NO_KEYS:[Ljava/lang/String;

.field static final QUALIFIED_SUFFIX:Ljava/lang/String; = ".qualified"


# instance fields
.field private final metadata:Landroid/os/Bundle;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    sput-object v0, Lio/fabric/unity/android/BundleKitDataProvider;->NO_KEYS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "metadata"    # Landroid/os/Bundle;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lio/fabric/unity/android/BundleKitDataProvider;->metadata:Landroid/os/Bundle;

    .line 30
    return-void
.end method

.method private getKitKeys()[Ljava/lang/String;
    .locals 3

    .prologue
    .line 70
    iget-object v1, p0, Lio/fabric/unity/android/BundleKitDataProvider;->metadata:Landroid/os/Bundle;

    const-string v2, "io.fabric.kits"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 71
    .local v0, "kitsString":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lio/fabric/unity/android/BundleKitDataProvider;->NO_KEYS:[Ljava/lang/String;

    :goto_0
    return-object v1

    :cond_0
    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method public getInitializationKitsList()Ljava/lang/String;
    .locals 2

    .prologue
    .line 66
    iget-object v0, p0, Lio/fabric/unity/android/BundleKitDataProvider;->metadata:Landroid/os/Bundle;

    const-string v1, "io.fabric.InitializationKitsList"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getInitializationType()Ljava/lang/String;
    .locals 2

    .prologue
    .line 61
    iget-object v0, p0, Lio/fabric/unity/android/BundleKitDataProvider;->metadata:Landroid/os/Bundle;

    const-string v1, "io.fabric.InitializationType"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getKitData()[Lio/fabric/unity/android/KitData;
    .locals 12

    .prologue
    .line 34
    new-instance v1, Ljava/util/LinkedList;

    invoke-direct {v1}, Ljava/util/LinkedList;-><init>()V

    .line 36
    .local v1, "kitDataList":Ljava/util/List;, "Ljava/util/List<Lio/fabric/unity/android/KitData;>;"
    invoke-direct {p0}, Lio/fabric/unity/android/BundleKitDataProvider;->getKitKeys()[Ljava/lang/String;

    move-result-object v2

    .line 40
    .local v2, "kitKeys":[Ljava/lang/String;
    array-length v8, v2

    const/4 v7, 0x0

    :goto_0
    if-ge v7, v8, :cond_1

    aget-object v0, v2, v7

    .line 41
    .local v0, "key":Ljava/lang/String;
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "io.fabric."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 42
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ".unqualified"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 43
    .local v4, "nameKey":Ljava/lang/String;
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ".qualified"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 45
    .local v5, "qualifiedKey":Ljava/lang/String;
    iget-object v9, p0, Lio/fabric/unity/android/BundleKitDataProvider;->metadata:Landroid/os/Bundle;

    invoke-virtual {v9, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 46
    const-string v9, "Fabric"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Could not find kit info for key "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 40
    :goto_1
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 50
    :cond_0
    iget-object v9, p0, Lio/fabric/unity/android/BundleKitDataProvider;->metadata:Landroid/os/Bundle;

    invoke-virtual {v9, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 51
    .local v3, "name":Ljava/lang/String;
    iget-object v9, p0, Lio/fabric/unity/android/BundleKitDataProvider;->metadata:Landroid/os/Bundle;

    invoke-virtual {v9, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 53
    .local v6, "qualifiedName":Ljava/lang/String;
    new-instance v9, Lio/fabric/unity/android/KitData;

    invoke-direct {v9, v3, v6}, Lio/fabric/unity/android/KitData;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 56
    .end local v0    # "key":Ljava/lang/String;
    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "nameKey":Ljava/lang/String;
    .end local v5    # "qualifiedKey":Ljava/lang/String;
    .end local v6    # "qualifiedName":Ljava/lang/String;
    :cond_1
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    new-array v7, v7, [Lio/fabric/unity/android/KitData;

    invoke-interface {v1, v7}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Lio/fabric/unity/android/KitData;

    return-object v7
.end method
