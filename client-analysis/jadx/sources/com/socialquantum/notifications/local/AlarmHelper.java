package com.socialquantum.notifications.local;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class AlarmHelper {
    public static String TAG = "ALR";

    public static boolean addAlarm(Context ctx, String title, String message, String notificationId, long triggerTime, long timePeriodInterval, long removalTime) {
        Log.i(TAG, "addAlarm : " + ctx + "; id=" + notificationId + ", subTitle=" + message);
        cancelAlarm(ctx, notificationId);
        Intent intent = new Intent(ctx, (Class<?>) AlarmReceiver.class);
        intent.setAction(notificationId);
        intent.putExtra(AlarmReceiver.TITLE, title);
        intent.putExtra(AlarmReceiver.MESSAGE, message);
        intent.putExtra(AlarmReceiver.NOTIFICATION_ID, notificationId);
        intent.putExtra(AlarmReceiver.REMOVAL_TIME_MILLIS, removalTime);
        intent.putExtra("TIME_PERIOD_MILLIS", timePeriodInterval);
        intent.putExtra("TRIGGER_TIME_MILLIS", triggerTime);
        PendingIntent sender = PendingIntent.getBroadcast(ctx, 0, intent, 134217728);
        AlarmManager am = getAlarmManager(ctx);
        if (timePeriodInterval > 0) {
            am.setRepeating(0, triggerTime, timePeriodInterval, sender);
            return true;
        }
        am.set(0, triggerTime, sender);
        return true;
    }

    public static boolean cancelAlarm(Context ctx, String notificationId) {
        Log.i(TAG, "cancelAlarm, id=" + notificationId);
        Log.i(TAG, "ctx = " + ctx);
        Log.i(TAG, "ctx = " + AlarmReceiver.class);
        Intent intent = new Intent(ctx, (Class<?>) AlarmReceiver.class);
        intent.setAction(notificationId);
        intent.getAction();
        AlarmManager am = getAlarmManager(ctx);
        PendingIntent pi = PendingIntent.getBroadcast(ctx, 0, intent, 134217728);
        try {
            am.cancel(pi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean cancelAll(Context ctx, SharedPreferences alarmSettings) {
        Log.i(TAG, "cancelAll");
        Map<String, ?> allAlarms = alarmSettings.getAll();
        Set<String> alarmIds = allAlarms.keySet();
        for (String alarmId : alarmIds) {
            cancelAlarm(ctx, alarmId);
        }
        return true;
    }

    public static List<String> clearOutdatedNotifications(Context ctx, SharedPreferences alarmSettings) {
        Log.i(TAG, "clearOutdatedNotifications");
        Map<String, ?> allAlarms = alarmSettings.getAll();
        Set<String> alarmIds = allAlarms.keySet();
        List<String> removeList = new ArrayList<>();
        for (String alarmId : alarmIds) {
            Object alarmJson = allAlarms.get(alarmId);
            JSONArray alarmJsonArray = (JSONArray) alarmJson;
            if (alarmJsonArray != null) {
                try {
                    AlarmOptions options = new AlarmOptions();
                    options.parseOptions(alarmJsonArray);
                    if (options.getRemovalTime() > 0) {
                        if (System.currentTimeMillis() >= options.getRemovalTime()) {
                            cancelAlarm(ctx, alarmId);
                            removeList.add(alarmId);
                        }
                    } else if (options.getTimeRepeatInterval() == 0 && options.getTriggerTime() < System.currentTimeMillis()) {
                        cancelAlarm(ctx, alarmId);
                        removeList.add(alarmId);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return removeList;
    }

    public static Set<String> getAllNotificationsIds(SharedPreferences alarmSettings) {
        Log.i(TAG, "getAllNotificationsIds");
        Map<String, ?> allAlarms = alarmSettings.getAll();
        if (allAlarms != null) {
            return allAlarms.keySet();
        }
        return null;
    }

    private static AlarmManager getAlarmManager(Context ctx) {
        AlarmManager am = (AlarmManager) ctx.getSystemService("alarm");
        return am;
    }
}
