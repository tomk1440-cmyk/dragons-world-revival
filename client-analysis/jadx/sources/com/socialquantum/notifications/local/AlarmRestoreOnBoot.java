package com.socialquantum.notifications.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class AlarmRestoreOnBoot extends BroadcastReceiver {
    public static String TAG = "ALR";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "AlarmRestoreOnBoot.onReceive");
        SharedPreferences alarmSettings = context.getSharedPreferences(LocalNotification.PLUGIN_NAME, 0);
        Map<String, ?> allAlarms = alarmSettings.getAll();
        Set<String> alarmIds = allAlarms.keySet();
        for (String alarmId : alarmIds) {
            Log.i(TAG, "AlarmRestoreOnBoot.onReceive, alarmId=" + alarmId);
            try {
                JSONArray alarmDetails = new JSONArray(alarmSettings.getString(alarmId, ""));
                AlarmOptions options = new AlarmOptions();
                options.parseOptions(alarmDetails);
                long triggerTime = options.getTriggerTime();
                long removeTime = options.getRemovalTime();
                long periodTime = options.getTimeRepeatInterval();
                String title = options.getTitle();
                String subTitle = options.getMessage();
                String id = options.getNotificationId();
                Log.i(TAG, "AlarmRestoreOnBoot.onReceive, id=" + id + ", subTitle=" + subTitle);
                AlarmHelper.addAlarm(context, title, subTitle, id, triggerTime, removeTime, periodTime);
            } catch (JSONException e) {
                Log.d(TAG, "AlarmRestoreOnBoot: Error while restoring alarm details after reboot: " + e.toString());
            }
            Log.d(TAG, "AlarmRestoreOnBoot: Successfully restored alarms upon reboot");
        }
    }
}
