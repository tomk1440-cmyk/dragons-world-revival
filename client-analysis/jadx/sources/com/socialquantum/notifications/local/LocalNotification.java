package com.socialquantum.notifications.local;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.unity3d.player.UnityPlayer;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocalNotification {
    public static final String PLUGIN_NAME = "AndroidAlarmNotificationPlugin";
    public static String TAG = "ALR";
    private static Activity activity;

    public static boolean ScheduleNotification(String id, String title, String message, long timeDelay, long timeInterval, long removeDelay) {
        Log.i(TAG, "ScheduleNotification, id=" + id + ", subTitle=" + title);
        JSONArray array = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        long currentTime = System.currentTimeMillis();
        long triggerTime = currentTime + timeDelay;
        long removalTime = removeDelay > 0 ? currentTime + removeDelay : 0L;
        try {
            jsonObject.put("title", title);
            jsonObject.put("subTitle", message);
            jsonObject.put("triggerTime", triggerTime);
            jsonObject.put("repeatInterval", timeInterval);
            jsonObject.put("removalTime", removalTime);
            jsonObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        array.put(jsonObject);
        return ScheduleNotification(array);
    }

    public static boolean ScheduleNotification(Activity context, String id, String title, String message, long timeDelay, long timeInterval, long removeDelay) {
        activity = context;
        return ScheduleNotification(id, title, message, timeDelay, timeInterval, removeDelay);
    }

    public static boolean CancelAlarm(String alarmId) {
        Log.i(TAG, "CancelAlarm, alarmId=" + alarmId);
        unpersistAlarm(alarmId);
        return cancelNotification(alarmId);
    }

    public static boolean CancelAllAlarms() {
        Log.i(TAG, "CancelAllAlarms");
        boolean result = cancelAllNotifications();
        unpersistAlarmAll();
        return result;
    }

    public static String[] GetActiveNotifications() {
        Log.i(TAG, "GetActiveNotifications");
        Set<String> allIds = AlarmHelper.getAllNotificationsIds(prefs());
        return allIds != null ? (String[]) allIds.toArray(new String[0]) : new String[0];
    }

    public static void ClearOutdatedNotifications() {
        Log.i(TAG, "ClearOutdatedNotifications");
        List<String> removeList = AlarmHelper.clearOutdatedNotifications(currentActivity(), prefs());
        for (String id : removeList) {
            unpersistAlarm(id);
        }
    }

    private static boolean ScheduleNotification(JSONArray optionsArr) {
        Log.i(TAG, "ScheduleNotification");
        AlarmOptions alarmOptions = new AlarmOptions();
        alarmOptions.parseOptions(optionsArr);
        String alarmId = alarmOptions.getNotificationId();
        long triggerTime = alarmOptions.getTriggerTime();
        long removeTime = alarmOptions.getRemovalTime();
        long periodTime = alarmOptions.getTimeRepeatInterval();
        String title = alarmOptions.getTitle();
        String subTitle = alarmOptions.getMessage();
        persistAlarm(alarmId, optionsArr);
        Log.i(TAG, "ScheduleNotification params : " + currentActivity() + "; " + title + "; " + subTitle + "; " + alarmId + "; " + triggerTime + "; " + periodTime + "; " + removeTime);
        return AlarmHelper.addAlarm(currentActivity(), title, subTitle, alarmId, triggerTime, periodTime, removeTime);
    }

    private static boolean cancelNotification(String notificationId) {
        Log.i(TAG, "cancelNotification");
        return AlarmHelper.cancelAlarm(currentActivity(), notificationId);
    }

    private static boolean cancelAllNotifications() {
        Log.i(TAG, "cancelAllNotifications");
        return AlarmHelper.cancelAll(currentActivity(), prefs());
    }

    private static boolean persistAlarm(String alarmId, JSONArray optionsArr) {
        Log.i(TAG, "persistAlarm");
        SharedPreferences.Editor alarmSettingsEditor = prefs().edit();
        alarmSettingsEditor.putString(alarmId, optionsArr.toString());
        return alarmSettingsEditor.commit();
    }

    private static boolean unpersistAlarm(String alarmId) {
        Log.i(TAG, "unpersistAlarm");
        SharedPreferences.Editor alarmSettingsEditor = prefs().edit();
        alarmSettingsEditor.remove(alarmId);
        return alarmSettingsEditor.commit();
    }

    private static boolean unpersistAlarmAll() {
        Log.i(TAG, "unpersistAlarmAll");
        SharedPreferences.Editor alarmSettingsEditor = prefs().edit();
        alarmSettingsEditor.clear();
        return alarmSettingsEditor.commit();
    }

    private static Activity currentActivity() {
        if (activity == null) {
            activity = UnityPlayer.currentActivity;
        }
        return activity;
    }

    private static SharedPreferences prefs() {
        return currentActivity().getSharedPreferences(PLUGIN_NAME, 0);
    }
}
