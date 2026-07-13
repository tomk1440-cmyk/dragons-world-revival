.class public Lcom/socialquantum/notifications/local/LocalNotification;
.super Ljava/lang/Object;
.source "LocalNotification.java"


# static fields
.field public static final PLUGIN_NAME:Ljava/lang/String; = "AndroidAlarmNotificationPlugin"

.field public static TAG:Ljava/lang/String;

.field private static activity:Landroid/app/Activity;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-string v0, "ALR"

    sput-object v0, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static CancelAlarm(Ljava/lang/String;)Z
    .locals 3
    .param p0, "alarmId"    # Ljava/lang/String;

    .prologue
    .line 51
    sget-object v0, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "CancelAlarm, alarmId="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 52
    invoke-static {p0}, Lcom/socialquantum/notifications/local/LocalNotification;->unpersistAlarm(Ljava/lang/String;)Z

    .line 53
    invoke-static {p0}, Lcom/socialquantum/notifications/local/LocalNotification;->cancelNotification(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static CancelAllAlarms()Z
    .locals 3

    .prologue
    .line 57
    sget-object v1, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    const-string v2, "CancelAllAlarms"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 58
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->cancelAllNotifications()Z

    move-result v0

    .line 59
    .local v0, "result":Z
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->unpersistAlarmAll()Z

    .line 60
    return v0
.end method

.method public static ClearOutdatedNotifications()V
    .locals 4

    .prologue
    .line 73
    sget-object v2, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    const-string v3, "ClearOutdatedNotifications"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 74
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->currentActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->prefs()Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/socialquantum/notifications/local/AlarmHelper;->clearOutdatedNotifications(Landroid/content/Context;Landroid/content/SharedPreferences;)Ljava/util/List;

    move-result-object v1

    .line 75
    .local v1, "removeList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 76
    .local v0, "id":Ljava/lang/String;
    invoke-static {v0}, Lcom/socialquantum/notifications/local/LocalNotification;->unpersistAlarm(Ljava/lang/String;)Z

    goto :goto_0

    .line 78
    .end local v0    # "id":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public static GetActiveNotifications()[Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 64
    sget-object v1, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    const-string v2, "GetActiveNotifications"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 65
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->prefs()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-static {v1}, Lcom/socialquantum/notifications/local/AlarmHelper;->getAllNotificationsIds(Landroid/content/SharedPreferences;)Ljava/util/Set;

    move-result-object v0

    .line 66
    .local v0, "allIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    .line 67
    new-array v1, v3, [Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;

    check-cast v1, [Ljava/lang/String;

    .line 69
    :goto_0
    return-object v1

    :cond_0
    new-array v1, v3, [Ljava/lang/String;

    goto :goto_0
.end method

.method public static ScheduleNotification(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)Z
    .locals 2
    .param p0, "context"    # Landroid/app/Activity;
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "timeDelay"    # J
    .param p6, "timeInterval"    # J
    .param p8, "removeDelay"    # J

    .prologue
    .line 46
    sput-object p0, Lcom/socialquantum/notifications/local/LocalNotification;->activity:Landroid/app/Activity;

    .line 47
    invoke-static/range {p1 .. p9}, Lcom/socialquantum/notifications/local/LocalNotification;->ScheduleNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)Z

    move-result v0

    return v0
.end method

.method public static ScheduleNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)Z
    .locals 17
    .param p0, "id"    # Ljava/lang/String;
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "timeDelay"    # J
    .param p5, "timeInterval"    # J
    .param p7, "removeDelay"    # J

    .prologue
    .line 20
    sget-object v7, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "ScheduleNotification, id="

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p0

    invoke-virtual {v14, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, ", subTitle="

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-virtual {v14, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v7, v14}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 21
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 22
    .local v2, "array":Lorg/json/JSONArray;
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 24
    .local v6, "jsonObject":Lorg/json/JSONObject;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 26
    .local v4, "currentTime":J
    add-long v12, v4, p3

    .line 27
    .local v12, "triggerTime":J
    move-wide/from16 v10, p5

    .line 28
    .local v10, "repeatInterval":J
    const-wide/16 v14, 0x0

    cmp-long v7, p7, v14

    if-lez v7, :cond_0

    add-long v8, v4, p7

    .line 30
    .local v8, "removalTime":J
    :goto_0
    :try_start_0
    const-string v7, "title"

    move-object/from16 v0, p1

    invoke-virtual {v6, v7, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 31
    const-string v7, "subTitle"

    move-object/from16 v0, p2

    invoke-virtual {v6, v7, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 32
    const-string v7, "triggerTime"

    invoke-virtual {v6, v7, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 33
    const-string v7, "repeatInterval"

    invoke-virtual {v6, v7, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 34
    const-string v7, "removalTime"

    invoke-virtual {v6, v7, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 35
    const-string v7, "id"

    move-object/from16 v0, p0

    invoke-virtual {v6, v7, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 39
    :goto_1
    invoke-virtual {v2, v6}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 41
    invoke-static {v2}, Lcom/socialquantum/notifications/local/LocalNotification;->ScheduleNotification(Lorg/json/JSONArray;)Z

    move-result v7

    return v7

    .line 28
    .end local v8    # "removalTime":J
    :cond_0
    const-wide/16 v8, 0x0

    goto :goto_0

    .line 36
    .restart local v8    # "removalTime":J
    :catch_0
    move-exception v3

    .line 37
    .local v3, "e":Lorg/json/JSONException;
    invoke-virtual {v3}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method

.method private static ScheduleNotification(Lorg/json/JSONArray;)Z
    .locals 13
    .param p0, "optionsArr"    # Lorg/json/JSONArray;

    .prologue
    .line 81
    sget-object v0, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    const-string v11, "ScheduleNotification"

    invoke-static {v0, v11}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    new-instance v10, Lcom/socialquantum/notifications/local/AlarmOptions;

    invoke-direct {v10}, Lcom/socialquantum/notifications/local/AlarmOptions;-><init>()V

    .line 83
    .local v10, "alarmOptions":Lcom/socialquantum/notifications/local/AlarmOptions;
    invoke-virtual {v10, p0}, Lcom/socialquantum/notifications/local/AlarmOptions;->parseOptions(Lorg/json/JSONArray;)V

    .line 85
    invoke-virtual {v10}, Lcom/socialquantum/notifications/local/AlarmOptions;->getNotificationId()Ljava/lang/String;

    move-result-object v3

    .line 87
    .local v3, "alarmId":Ljava/lang/String;
    invoke-virtual {v10}, Lcom/socialquantum/notifications/local/AlarmOptions;->getTriggerTime()J

    move-result-wide v4

    .line 88
    .local v4, "triggerTime":J
    invoke-virtual {v10}, Lcom/socialquantum/notifications/local/AlarmOptions;->getRemovalTime()J

    move-result-wide v8

    .line 89
    .local v8, "removeTime":J
    invoke-virtual {v10}, Lcom/socialquantum/notifications/local/AlarmOptions;->getTimeRepeatInterval()J

    move-result-wide v6

    .line 91
    .local v6, "periodTime":J
    invoke-virtual {v10}, Lcom/socialquantum/notifications/local/AlarmOptions;->getTitle()Ljava/lang/String;

    move-result-object v1

    .line 92
    .local v1, "title":Ljava/lang/String;
    invoke-virtual {v10}, Lcom/socialquantum/notifications/local/AlarmOptions;->getMessage()Ljava/lang/String;

    move-result-object v2

    .line 94
    .local v2, "subTitle":Ljava/lang/String;
    invoke-static {v3, p0}, Lcom/socialquantum/notifications/local/LocalNotification;->persistAlarm(Ljava/lang/String;Lorg/json/JSONArray;)Z

    .line 96
    sget-object v0, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "ScheduleNotification params : "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->currentActivity()Landroid/app/Activity;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "; "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "; "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "; "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "; "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "; "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "; "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v0, v11}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 97
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->currentActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static/range {v0 .. v9}, Lcom/socialquantum/notifications/local/AlarmHelper;->addAlarm(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)Z

    move-result v0

    return v0
.end method

.method private static cancelAllNotifications()Z
    .locals 2

    .prologue
    .line 107
    sget-object v0, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    const-string v1, "cancelAllNotifications"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 108
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->currentActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->prefs()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/socialquantum/notifications/local/AlarmHelper;->cancelAll(Landroid/content/Context;Landroid/content/SharedPreferences;)Z

    move-result v0

    return v0
.end method

.method private static cancelNotification(Ljava/lang/String;)Z
    .locals 2
    .param p0, "notificationId"    # Ljava/lang/String;

    .prologue
    .line 102
    sget-object v0, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    const-string v1, "cancelNotification"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 103
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->currentActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0, p0}, Lcom/socialquantum/notifications/local/AlarmHelper;->cancelAlarm(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private static currentActivity()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 133
    sget-object v0, Lcom/socialquantum/notifications/local/LocalNotification;->activity:Landroid/app/Activity;

    if-nez v0, :cond_0

    .line 134
    sget-object v0, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    sput-object v0, Lcom/socialquantum/notifications/local/LocalNotification;->activity:Landroid/app/Activity;

    .line 135
    :cond_0
    sget-object v0, Lcom/socialquantum/notifications/local/LocalNotification;->activity:Landroid/app/Activity;

    return-object v0
.end method

.method private static persistAlarm(Ljava/lang/String;Lorg/json/JSONArray;)Z
    .locals 3
    .param p0, "alarmId"    # Ljava/lang/String;
    .param p1, "optionsArr"    # Lorg/json/JSONArray;

    .prologue
    .line 112
    sget-object v1, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    const-string v2, "persistAlarm"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 113
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->prefs()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 114
    .local v0, "alarmSettingsEditor":Landroid/content/SharedPreferences$Editor;
    invoke-virtual {p1}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, p0, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 115
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method private static prefs()Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    .line 139
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->currentActivity()Landroid/app/Activity;

    move-result-object v0

    const-string v1, "AndroidAlarmNotificationPlugin"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method private static unpersistAlarm(Ljava/lang/String;)Z
    .locals 3
    .param p0, "alarmId"    # Ljava/lang/String;

    .prologue
    .line 119
    sget-object v1, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    const-string v2, "unpersistAlarm"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 120
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->prefs()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 121
    .local v0, "alarmSettingsEditor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p0}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 122
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method private static unpersistAlarmAll()Z
    .locals 3

    .prologue
    .line 126
    sget-object v1, Lcom/socialquantum/notifications/local/LocalNotification;->TAG:Ljava/lang/String;

    const-string v2, "unpersistAlarmAll"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 127
    invoke-static {}, Lcom/socialquantum/notifications/local/LocalNotification;->prefs()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 128
    .local v0, "alarmSettingsEditor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 129
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method
