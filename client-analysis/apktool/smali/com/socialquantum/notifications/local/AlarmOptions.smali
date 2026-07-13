.class public Lcom/socialquantum/notifications/local/AlarmOptions;
.super Ljava/lang/Object;
.source "AlarmOptions.java"


# instance fields
.field private alarmTitle:Ljava/lang/String;

.field private message:Ljava/lang/String;

.field private notificationId:Ljava/lang/String;

.field private removalTime:J

.field private repeatInterval:J

.field private triggerTime:J


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    const-string v0, ""

    iput-object v0, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->notificationId:Ljava/lang/String;

    .line 9
    const-string v0, ""

    iput-object v0, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->alarmTitle:Ljava/lang/String;

    .line 10
    const-string v0, ""

    iput-object v0, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->message:Ljava/lang/String;

    .line 11
    iput-wide v2, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->triggerTime:J

    .line 12
    iput-wide v2, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->repeatInterval:J

    .line 13
    iput-wide v2, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->removalTime:J

    return-void
.end method


# virtual methods
.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->message:Ljava/lang/String;

    return-object v0
.end method

.method public getNotificationId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->notificationId:Ljava/lang/String;

    return-object v0
.end method

.method public getRemovalTime()J
    .locals 2

    .prologue
    .line 61
    iget-wide v0, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->removalTime:J

    return-wide v0
.end method

.method public getTimeRepeatInterval()J
    .locals 2

    .prologue
    .line 53
    iget-wide v0, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->repeatInterval:J

    return-wide v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->alarmTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getTriggerTime()J
    .locals 2

    .prologue
    .line 45
    iget-wide v0, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->triggerTime:J

    return-wide v0
.end method

.method public optionsToJson()Lorg/json/JSONArray;
    .locals 6

    .prologue
    .line 28
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    .line 29
    .local v0, "array":Lorg/json/JSONArray;
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 31
    .local v2, "jsonObject":Lorg/json/JSONObject;
    :try_start_0
    const-string v3, "title"

    iget-object v4, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->alarmTitle:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 32
    const-string v3, "subTitle"

    iget-object v4, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->message:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 33
    const-string v3, "triggerTime"

    iget-wide v4, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->triggerTime:J

    invoke-virtual {v2, v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 34
    const-string v3, "repeatInterval"

    iget-wide v4, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->repeatInterval:J

    invoke-virtual {v2, v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 35
    const-string v3, "removalTime"

    iget-wide v4, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->removalTime:J

    invoke-virtual {v2, v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 36
    const-string v3, "id"

    iget-object v4, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->notificationId:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 40
    :goto_0
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 41
    return-object v0

    .line 37
    :catch_0
    move-exception v1

    .line 38
    .local v1, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public parseOptions(Lorg/json/JSONArray;)V
    .locals 4
    .param p1, "optionsArr"    # Lorg/json/JSONArray;

    .prologue
    .line 16
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 17
    .local v0, "options":Lorg/json/JSONObject;
    if-eqz v0, :cond_0

    .line 18
    const-string v1, "title"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->alarmTitle:Ljava/lang/String;

    .line 19
    const-string v1, "subTitle"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->message:Ljava/lang/String;

    .line 20
    const-string v1, "triggerTime"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->triggerTime:J

    .line 21
    const-string v1, "repeatInterval"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->repeatInterval:J

    .line 22
    const-string v1, "removalTime"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->removalTime:J

    .line 23
    const-string v1, "id"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->notificationId:Ljava/lang/String;

    .line 25
    :cond_0
    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->message:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public setNotificationId(Ljava/lang/String;)V
    .locals 0
    .param p1, "notificationId"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->notificationId:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setRemovalTime(J)V
    .locals 1
    .param p1, "removalTime"    # J

    .prologue
    .line 65
    iput-wide p1, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->removalTime:J

    .line 66
    return-void
.end method

.method public setTimeRepeatInterval(J)V
    .locals 1
    .param p1, "repeatInterval"    # J

    .prologue
    .line 57
    iput-wide p1, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->repeatInterval:J

    .line 58
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "alarmTitle"    # Ljava/lang/String;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->alarmTitle:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public setTriggerTime(J)V
    .locals 1
    .param p1, "triggerTime"    # J

    .prologue
    .line 49
    iput-wide p1, p0, Lcom/socialquantum/notifications/local/AlarmOptions;->triggerTime:J

    .line 50
    return-void
.end method
