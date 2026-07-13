.class public Lcom/socialquantum/notifications/local/AlarmRestoreOnBoot;
.super Landroid/content/BroadcastReceiver;
.source "AlarmRestoreOnBoot.java"


# static fields
.field public static TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-string v0, "ALR"

    sput-object v0, Lcom/socialquantum/notifications/local/AlarmRestoreOnBoot;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 23
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 19
    sget-object v2, Lcom/socialquantum/notifications/local/AlarmRestoreOnBoot;->TAG:Ljava/lang/String;

    const-string v20, "AlarmRestoreOnBoot.onReceive"

    move-object/from16 v0, v20

    invoke-static {v2, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 20
    const-string v19, "AndroidAlarmNotificationPlugin"

    .line 22
    .local v19, "pluginName":Ljava/lang/String;
    const-string v2, "AndroidAlarmNotificationPlugin"

    const/16 v20, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v2, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v15

    .line 23
    .local v15, "alarmSettings":Landroid/content/SharedPreferences;
    invoke-interface {v15}, Landroid/content/SharedPreferences;->getAll()Ljava/util/Map;

    move-result-object v16

    .line 24
    .local v16, "allAlarms":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    invoke-interface/range {v16 .. v16}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v14

    .line 25
    .local v14, "alarmIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v14}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v20

    :goto_0
    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 26
    .local v13, "alarmId":Ljava/lang/String;
    sget-object v2, Lcom/socialquantum/notifications/local/AlarmRestoreOnBoot;->TAG:Ljava/lang/String;

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "AlarmRestoreOnBoot.onReceive, alarmId="

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-static {v2, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 28
    :try_start_0
    new-instance v12, Lorg/json/JSONArray;

    const-string v2, ""

    invoke-interface {v15, v13, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v12, v2}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 29
    .local v12, "alarmDetails":Lorg/json/JSONArray;
    new-instance v18, Lcom/socialquantum/notifications/local/AlarmOptions;

    invoke-direct/range {v18 .. v18}, Lcom/socialquantum/notifications/local/AlarmOptions;-><init>()V

    .line 31
    .local v18, "options":Lcom/socialquantum/notifications/local/AlarmOptions;
    move-object/from16 v0, v18

    invoke-virtual {v0, v12}, Lcom/socialquantum/notifications/local/AlarmOptions;->parseOptions(Lorg/json/JSONArray;)V

    .line 33
    invoke-virtual/range {v18 .. v18}, Lcom/socialquantum/notifications/local/AlarmOptions;->getTriggerTime()J

    move-result-wide v6

    .line 34
    .local v6, "triggerTime":J
    invoke-virtual/range {v18 .. v18}, Lcom/socialquantum/notifications/local/AlarmOptions;->getRemovalTime()J

    move-result-wide v8

    .line 35
    .local v8, "removeTime":J
    invoke-virtual/range {v18 .. v18}, Lcom/socialquantum/notifications/local/AlarmOptions;->getTimeRepeatInterval()J

    move-result-wide v10

    .line 37
    .local v10, "periodTime":J
    invoke-virtual/range {v18 .. v18}, Lcom/socialquantum/notifications/local/AlarmOptions;->getTitle()Ljava/lang/String;

    move-result-object v3

    .line 38
    .local v3, "title":Ljava/lang/String;
    invoke-virtual/range {v18 .. v18}, Lcom/socialquantum/notifications/local/AlarmOptions;->getMessage()Ljava/lang/String;

    move-result-object v4

    .line 39
    .local v4, "subTitle":Ljava/lang/String;
    invoke-virtual/range {v18 .. v18}, Lcom/socialquantum/notifications/local/AlarmOptions;->getNotificationId()Ljava/lang/String;

    move-result-object v5

    .line 40
    .local v5, "id":Ljava/lang/String;
    sget-object v2, Lcom/socialquantum/notifications/local/AlarmRestoreOnBoot;->TAG:Ljava/lang/String;

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "AlarmRestoreOnBoot.onReceive, id="

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, ", subTitle="

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-static {v2, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move-object/from16 v2, p1

    .line 42
    invoke-static/range {v2 .. v11}, Lcom/socialquantum/notifications/local/AlarmHelper;->addAlarm(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 46
    .end local v3    # "title":Ljava/lang/String;
    .end local v4    # "subTitle":Ljava/lang/String;
    .end local v5    # "id":Ljava/lang/String;
    .end local v6    # "triggerTime":J
    .end local v8    # "removeTime":J
    .end local v10    # "periodTime":J
    .end local v12    # "alarmDetails":Lorg/json/JSONArray;
    .end local v18    # "options":Lcom/socialquantum/notifications/local/AlarmOptions;
    :goto_1
    sget-object v2, Lcom/socialquantum/notifications/local/AlarmRestoreOnBoot;->TAG:Ljava/lang/String;

    const-string v21, "AlarmRestoreOnBoot: Successfully restored alarms upon reboot"

    move-object/from16 v0, v21

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 43
    :catch_0
    move-exception v17

    .line 44
    .local v17, "e":Lorg/json/JSONException;
    sget-object v2, Lcom/socialquantum/notifications/local/AlarmRestoreOnBoot;->TAG:Ljava/lang/String;

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "AlarmRestoreOnBoot: Error while restoring alarm details after reboot: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v17 .. v17}, Lorg/json/JSONException;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 48
    .end local v13    # "alarmId":Ljava/lang/String;
    .end local v17    # "e":Lorg/json/JSONException;
    :cond_0
    return-void
.end method
