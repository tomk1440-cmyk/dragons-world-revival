.class public final enum Lio/fabric/unity/android/FabricInitializer$Caller;
.super Ljava/lang/Enum;
.source "FabricInitializer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/fabric/unity/android/FabricInitializer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Caller"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lio/fabric/unity/android/FabricInitializer$Caller;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lio/fabric/unity/android/FabricInitializer$Caller;

.field public static final enum Android:Lio/fabric/unity/android/FabricInitializer$Caller;

.field public static final enum Unity:Lio/fabric/unity/android/FabricInitializer$Caller;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 21
    new-instance v0, Lio/fabric/unity/android/FabricInitializer$Caller;

    const-string v1, "Android"

    invoke-direct {v0, v1, v2}, Lio/fabric/unity/android/FabricInitializer$Caller;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/fabric/unity/android/FabricInitializer$Caller;->Android:Lio/fabric/unity/android/FabricInitializer$Caller;

    .line 22
    new-instance v0, Lio/fabric/unity/android/FabricInitializer$Caller;

    const-string v1, "Unity"

    invoke-direct {v0, v1, v3}, Lio/fabric/unity/android/FabricInitializer$Caller;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/fabric/unity/android/FabricInitializer$Caller;->Unity:Lio/fabric/unity/android/FabricInitializer$Caller;

    .line 20
    const/4 v0, 0x2

    new-array v0, v0, [Lio/fabric/unity/android/FabricInitializer$Caller;

    sget-object v1, Lio/fabric/unity/android/FabricInitializer$Caller;->Android:Lio/fabric/unity/android/FabricInitializer$Caller;

    aput-object v1, v0, v2

    sget-object v1, Lio/fabric/unity/android/FabricInitializer$Caller;->Unity:Lio/fabric/unity/android/FabricInitializer$Caller;

    aput-object v1, v0, v3

    sput-object v0, Lio/fabric/unity/android/FabricInitializer$Caller;->$VALUES:[Lio/fabric/unity/android/FabricInitializer$Caller;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lio/fabric/unity/android/FabricInitializer$Caller;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 20
    const-class v0, Lio/fabric/unity/android/FabricInitializer$Caller;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lio/fabric/unity/android/FabricInitializer$Caller;

    return-object v0
.end method

.method public static values()[Lio/fabric/unity/android/FabricInitializer$Caller;
    .locals 1

    .prologue
    .line 20
    sget-object v0, Lio/fabric/unity/android/FabricInitializer$Caller;->$VALUES:[Lio/fabric/unity/android/FabricInitializer$Caller;

    invoke-virtual {v0}, [Lio/fabric/unity/android/FabricInitializer$Caller;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/fabric/unity/android/FabricInitializer$Caller;

    return-object v0
.end method
