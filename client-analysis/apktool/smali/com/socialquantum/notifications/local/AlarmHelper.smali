.class public Lcom/socialquantum/notifications/local/AlarmHelper;
.super Ljava/lang/Object;
.source "AlarmHelper.java"


# static fields
.field public static TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-string v0, "ALR"

    sput-object v0, Lcom/socialquantum/notifications/local/AlarmHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addAlarm(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)Z
    .locals 10
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "notificationId"    # Ljava/lang/String;
    .param p4, "triggerTime"    # J
    .param p6, "timePeriodInterval"    # J
    .param p8, "removalTime"    # J

    .prologue
    .line 21
    sget-object v3, Lcom/socialquantum/notifications/local/AlarmHelper;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "addAlarm : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "; id="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", subTitle="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 22
    invoke-static {p0, p3}, Lcom/socialquantum/notifications/local/AlarmHelper;->cancelAlarm(Landroid/content/Context;Ljava/lang/String;)Z

    .line 24
    new-instance v9, Landroid/content/Intent;

    const-class v3, Lcom/socialquantum/notifications/local/AlarmReceiver;

    invoke-direct {v9, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 26
    .local v9, "intent":Landroid/content/Intent;
    invoke-virtual {v9, p3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 27
    const-string v3, "ALARM_TITLE"

    invoke-virtual {v9, v3, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 28
    const-string v3, "ALARM_SUBTITLE"

    invoke-virtual {v9, v3, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 29
    const-string v3, "NOTIFICATION_ID"

    invoke-virtual {v9, v3, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 30
    const-string v3, "REMOVAL_TIME_MILLIS"

    move-wide/from16 v0, p8

    invoke-virtual {v9, v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 31
    const-string v3, "TIME_PERIOD_MILLIS"

    move-wide/from16 v0, p6

    invoke-virtual {v9, v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 32
    const-string v3, "TRIGGER_TIME_MILLIS"

    invoke-virtual {v9, v3, p4, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 34
    const/4 v3, 0x0

    const/high16 v4, 0x8000000

    invoke-static {p0, v3, v9, v4}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v8

    .line 35
    .local v8, "sender":Landroid/app/PendingIntent;
    invoke-static {p0}, Lcom/socialquantum/notifications/local/AlarmHelper;->getAlarmManager(Landroid/content/Context;)Landroid/app/AlarmManager;

    move-result-object v2

    .line 36
    .local v2, "am":Landroid/app/AlarmManager;
    const-wide/16 v4, 0x0

    cmp-long v3, p6, v4

    if-lez v3, :cond_0

    .line 37
    const/4 v3, 0x0

    move-wide v4, p4

    move-wide/from16 v6, p6

    invoke-virtual/range {v2 .. v8}, Landroid/app/AlarmManager;->setRepeating(IJJLandroid/app/PendingIntent;)V

    .line 41
    :goto_0
    const/4 v3, 0x1

    return v3

    .line 39
    :cond_0
    const/4 v3, 0x0

    invoke-virtual {v2, v3, p4, p5, v8}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    goto :goto_0
.end method

.method public static cancelAlarm(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 8
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "notificationId"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 45
    sget-object v5, Lcom/socialquantum/notifications/local/AlarmHelper;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "cancelAlarm, id="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 46
    sget-object v5, Lcom/socialquantum/notifications/local/AlarmHelper;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "ctx = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 47
    sget-object v5, Lcom/socialquantum/notifications/local/AlarmHelper;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "ctx = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-class v7, Lcom/socialquantum/notifications/local/AlarmReceiver;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    new-instance v2, Landroid/content/Intent;

    const-class v5, Lcom/socialquantum/notifications/local/AlarmReceiver;

    invoke-direct {v2, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 50
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {v2, p1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 51
    invoke-virtual {v2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    .line 53
    invoke-static {p0}, Lcom/socialquantum/notifications/local/AlarmHelper;->getAlarmManager(Landroid/content/Context;)Landroid/app/AlarmManager;

    move-result-object v0

    .line 54
    .local v0, "am":Landroid/app/AlarmManager;
    const/high16 v5, 0x8000000

    invoke-static {p0, v4, v2, v5}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v3

    .line 56
    .local v3, "pi":Landroid/app/PendingIntent;
    :try_start_0
    invoke-virtual {v0, v3}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 60
    const/4 v4, 0x1

    :goto_0
    return v4

    .line 57
    :catch_0
    move-exception v1

    .line 58
    .local v1, "e":Ljava/lang/Exception;
    goto :goto_0
.end method

.method public static cancelAll(Landroid/content/Context;Landroid/content/SharedPreferences;)Z
    .locals 6
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "alarmSettings"    # Landroid/content/SharedPreferences;

    .prologue
    .line 64
    sget-object v4, Lcom/socialquantum/notifications/local/AlarmHelper;->TAG:Ljava/lang/String;

    const-string v5, "cancelAll"

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 65
    invoke-interface {p1}, Landroid/content/SharedPreferences;->getAll()Ljava/util/Map;

    move-result-object v3

    .line 66
    .local v3, "allAlarms":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 67
    .local v1, "alarmIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 68
    .local v0, "alarmId":Ljava/lang/String;
    move-object v2, v0

    .line 69
    .local v2, "alarmInt":Ljava/lang/String;
    invoke-static {p0, v2}, Lcom/socialquantum/notifications/local/AlarmHelper;->cancelAlarm(Landroid/content/Context;Ljava/lang/String;)Z

    goto :goto_0

    .line 71
    .end local v0    # "alarmId":Ljava/lang/String;
    .end local v2    # "alarmInt":Ljava/lang/String;
    :cond_0
    const/4 v4, 0x1

    return v4
.end method

.method public static clearOutdatedNotifications(Landroid/content/Context;Landroid/content/SharedPreferences;)Ljava/util/List;
    .locals 14
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "alarmSettings"    # Landroid/content/SharedPreferences;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/content/SharedPreferences;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 75
    sget-object v8, Lcom/socialquantum/notifications/local/AlarmHelper;->TAG:Ljava/lang/String;

    const-string v9, "clearOutdatedNotifications"

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 76
    invoke-interface {p1}, Landroid/content/SharedPreferences;->getAll()Ljava/util/Map;

    move-result-object v4

    .line 77
    .local v4, "allAlarms":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 79
    .local v1, "alarmIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 80
    .local v7, "removeList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_0
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_2

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 81
    .local v0, "alarmId":Ljava/lang/String;
    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, "alarmJson":Ljava/lang/Object;
    move-object v3, v2

    .line 82
    check-cast v3, Lorg/json/JSONArray;

    .line 83
    .local v3, "alarmJsonArray":Lorg/json/JSONArray;
    if-eqz v3, :cond_0

    .line 85
    :try_start_0
    new-instance v6, Lcom/socialquantum/notifications/local/AlarmOptions;

    invoke-direct {v6}, Lcom/socialquantum/notifications/local/AlarmOptions;-><init>()V

    .line 86
    .local v6, "options":Lcom/socialquantum/notifications/local/AlarmOptions;
    invoke-virtual {v6, v3}, Lcom/socialquantum/notifications/local/AlarmOptions;->parseOptions(Lorg/json/JSONArray;)V

    .line 87
    invoke-virtual {v6}, Lcom/socialquantum/notifications/local/AlarmOptions;->getRemovalTime()J

    move-result-wide v10

    const-wide/16 v12, 0x0

    cmp-long v9, v10, v12

    if-lez v9, :cond_1

    .line 88
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    invoke-virtual {v6}, Lcom/socialquantum/notifications/local/AlarmOptions;->getRemovalTime()J

    move-result-wide v12

    cmp-long v9, v10, v12

    if-ltz v9, :cond_0

    .line 89
    invoke-static {p0, v0}, Lcom/socialquantum/notifications/local/AlarmHelper;->cancelAlarm(Landroid/content/Context;Ljava/lang/String;)Z

    .line 90
    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 97
    .end local v6    # "options":Lcom/socialquantum/notifications/local/AlarmOptions;
    :catch_0
    move-exception v5

    .line 98
    .local v5, "e":Ljava/lang/Exception;
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 92
    .end local v5    # "e":Ljava/lang/Exception;
    .restart local v6    # "options":Lcom/socialquantum/notifications/local/AlarmOptions;
    :cond_1
    :try_start_1
    invoke-virtual {v6}, Lcom/socialquantum/notifications/local/AlarmOptions;->getTimeRepeatInterval()J

    move-result-wide v10

    const-wide/16 v12, 0x0

    cmp-long v9, v10, v12

    if-nez v9, :cond_0

    .line 93
    invoke-virtual {v6}, Lcom/socialquantum/notifications/local/AlarmOptions;->getTriggerTime()J

    move-result-wide v10

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    cmp-long v9, v10, v12

    if-gez v9, :cond_0

    .line 94
    invoke-static {p0, v0}, Lcom/socialquantum/notifications/local/AlarmHelper;->cancelAlarm(Landroid/content/Context;Ljava/lang/String;)Z

    .line 95
    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 102
    .end local v0    # "alarmId":Ljava/lang/String;
    .end local v2    # "alarmJson":Ljava/lang/Object;
    .end local v3    # "alarmJsonArray":Lorg/json/JSONArray;
    .end local v6    # "options":Lcom/socialquantum/notifications/local/AlarmOptions;
    :cond_2
    return-object v7
.end method

.method private static getAlarmManager(Landroid/content/Context;)Landroid/app/AlarmManager;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;

    .prologue
    .line 115
    const-string v1, "alarm"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 116
    .local v0, "am":Landroid/app/AlarmManager;
    return-object v0
.end method

.method public static getAllNotificationsIds(Landroid/content/SharedPreferences;)Ljava/util/Set;
    .locals 3
    .param p0, "alarmSettings"    # Landroid/content/SharedPreferences;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/SharedPreferences;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 106
    sget-object v1, Lcom/socialquantum/notifications/local/AlarmHelper;->TAG:Ljava/lang/String;

    const-string v2, "getAllNotificationsIds"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 107
    invoke-interface {p0}, Landroid/content/SharedPreferences;->getAll()Ljava/util/Map;

    move-result-object v0

    .line 108
    .local v0, "allAlarms":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    if-eqz v0, :cond_0

    .line 109
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 111
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
