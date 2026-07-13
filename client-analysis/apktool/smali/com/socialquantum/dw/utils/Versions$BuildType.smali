.class public final enum Lcom/socialquantum/dw/utils/Versions$BuildType;
.super Ljava/lang/Enum;
.source "Versions.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/socialquantum/dw/utils/Versions;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "BuildType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/socialquantum/dw/utils/Versions$BuildType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/socialquantum/dw/utils/Versions$BuildType;

.field public static final enum INT:Lcom/socialquantum/dw/utils/Versions$BuildType;

.field public static final enum RU:Lcom/socialquantum/dw/utils/Versions$BuildType;

.field public static final enum UNKNOWN:Lcom/socialquantum/dw/utils/Versions$BuildType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 52
    new-instance v0, Lcom/socialquantum/dw/utils/Versions$BuildType;

    const-string v1, "INT"

    invoke-direct {v0, v1, v2}, Lcom/socialquantum/dw/utils/Versions$BuildType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/socialquantum/dw/utils/Versions$BuildType;->INT:Lcom/socialquantum/dw/utils/Versions$BuildType;

    new-instance v0, Lcom/socialquantum/dw/utils/Versions$BuildType;

    const-string v1, "RU"

    invoke-direct {v0, v1, v3}, Lcom/socialquantum/dw/utils/Versions$BuildType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/socialquantum/dw/utils/Versions$BuildType;->RU:Lcom/socialquantum/dw/utils/Versions$BuildType;

    new-instance v0, Lcom/socialquantum/dw/utils/Versions$BuildType;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v4}, Lcom/socialquantum/dw/utils/Versions$BuildType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/socialquantum/dw/utils/Versions$BuildType;->UNKNOWN:Lcom/socialquantum/dw/utils/Versions$BuildType;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/socialquantum/dw/utils/Versions$BuildType;

    sget-object v1, Lcom/socialquantum/dw/utils/Versions$BuildType;->INT:Lcom/socialquantum/dw/utils/Versions$BuildType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/socialquantum/dw/utils/Versions$BuildType;->RU:Lcom/socialquantum/dw/utils/Versions$BuildType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/socialquantum/dw/utils/Versions$BuildType;->UNKNOWN:Lcom/socialquantum/dw/utils/Versions$BuildType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/socialquantum/dw/utils/Versions$BuildType;->$VALUES:[Lcom/socialquantum/dw/utils/Versions$BuildType;

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
    .line 52
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/socialquantum/dw/utils/Versions$BuildType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 52
    const-class v0, Lcom/socialquantum/dw/utils/Versions$BuildType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/socialquantum/dw/utils/Versions$BuildType;

    return-object v0
.end method

.method public static values()[Lcom/socialquantum/dw/utils/Versions$BuildType;
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lcom/socialquantum/dw/utils/Versions$BuildType;->$VALUES:[Lcom/socialquantum/dw/utils/Versions$BuildType;

    invoke-virtual {v0}, [Lcom/socialquantum/dw/utils/Versions$BuildType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/socialquantum/dw/utils/Versions$BuildType;

    return-object v0
.end method
