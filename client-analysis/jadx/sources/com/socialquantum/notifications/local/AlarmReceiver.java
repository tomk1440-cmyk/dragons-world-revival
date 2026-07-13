package com.socialquantum.notifications.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    public static final String MESSAGE = "ALARM_SUBTITLE";
    public static final String NOTIFICATION_ID = "NOTIFICATION_ID";
    public static final String REMOVAL_TIME_MILLIS = "REMOVAL_TIME_MILLIS";
    public static final String TAG = "AlarmReceiver";
    public static final String TITLE = "ALARM_TITLE";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "AlarmReceiver.onReceive" + intent);
        long currentTime = System.currentTimeMillis();
        Bundle bundle = intent.getExtras();
        String message = bundle.getString(MESSAGE);
        long removalTime = bundle.getLong(REMOVAL_TIME_MILLIS);
        String notificationId = bundle.getString(NOTIFICATION_ID);
        if (removalTime <= 0 || currentTime < removalTime) {
            ActivityUtil.CreateNotification(context, message, notificationId, bundle);
        }
    }
}
