.class Lio/fabric/unity/android/KitData;
.super Ljava/lang/Object;
.source "KitData.java"


# instance fields
.field public final fullyQualifiedClassName:Ljava/lang/String;

.field public final kitName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "kitName"    # Ljava/lang/String;
    .param p2, "fullyQualifiedClassName"    # Ljava/lang/String;

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    iput-object p1, p0, Lio/fabric/unity/android/KitData;->kitName:Ljava/lang/String;

    .line 9
    iput-object p2, p0, Lio/fabric/unity/android/KitData;->fullyQualifiedClassName:Ljava/lang/String;

    .line 10
    return-void
.end method
