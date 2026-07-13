.class Lcom/prime31/GoogleIABPlugin$3;
.super Ljava/lang/Object;
.source "GoogleIABPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/prime31/GoogleIABPlugin;->purchaseProduct(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/prime31/GoogleIABPlugin;

.field private final synthetic val$developerPayload:Ljava/lang/String;

.field private final synthetic val$f_itemType:Ljava/lang/String;

.field private final synthetic val$sku:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/prime31/GoogleIABPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/prime31/GoogleIABPlugin$3;->this$0:Lcom/prime31/GoogleIABPlugin;

    iput-object p2, p0, Lcom/prime31/GoogleIABPlugin$3;->val$sku:Ljava/lang/String;

    iput-object p3, p0, Lcom/prime31/GoogleIABPlugin$3;->val$f_itemType:Ljava/lang/String;

    iput-object p4, p0, Lcom/prime31/GoogleIABPlugin$3;->val$developerPayload:Ljava/lang/String;

    .line 216
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 220
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/prime31/GoogleIABPlugin$3;->this$0:Lcom/prime31/GoogleIABPlugin;

    invoke-virtual {v1}, Lcom/prime31/GoogleIABPlugin;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-class v2, Lcom/prime31/GoogleIABProxyActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 221
    .local v0, "proxyStarter":Landroid/content/Intent;
    const-string v1, "sku"

    iget-object v2, p0, Lcom/prime31/GoogleIABPlugin$3;->val$sku:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 222
    const-string v1, "itemType"

    iget-object v2, p0, Lcom/prime31/GoogleIABPlugin$3;->val$f_itemType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 223
    const-string v1, "developerPayload"

    iget-object v2, p0, Lcom/prime31/GoogleIABPlugin$3;->val$developerPayload:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 224
    iget-object v1, p0, Lcom/prime31/GoogleIABPlugin$3;->this$0:Lcom/prime31/GoogleIABPlugin;

    invoke-virtual {v1}, Lcom/prime31/GoogleIABPlugin;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 225
    return-void
.end method
