package com.socialquantum.dw.utils.android;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class NotificationBuilder {
    @TargetApi(14)
    public static void Build(Context context, Bundle bundle, String logTag) {
        try {
            String tag = bundle.getString("tag");
            Log.i(logTag, "generateNotification, tag=" + tag);
            String customTag = bundle.getString("custom");
            Log.i(logTag, "generateNotification, customTag=" + customTag);
            int icon = context.getApplicationInfo().icon;
            long when = System.currentTimeMillis();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            int stringId = context.getApplicationInfo().labelRes;
            String title = context.getString(stringId);
            String text = bundle.getString("message");
            String packageName = context.getPackageName();
            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
            String className = launchIntent.getComponent().getClassName();
            Class<?> ref = Class.forName(className);
            Intent notificationIntent = new Intent(context, ref);
            notificationIntent.setFlags(603979776);
            if (bundle != null) {
                notificationIntent.putExtras(bundle);
            }
            PendingIntent intent = PendingIntent.getActivity(context, 0, notificationIntent, 1207959552);
            Log.d(logTag, "Params : intent " + intent + "; icon - " + icon + "; title - " + title + "; text - " + text + "; className - " + className);
            Log.d(logTag, "Android version : " + String.valueOf(Build.VERSION.SDK_INT) + "::" + Build.VERSION.CODENAME);
            Notification notification = builder.setContentIntent(intent).setSmallIcon(icon).setTicker(title).setWhen(when).setContentTitle(title).setContentText(text).setAutoCancel(true).build();
            notificationManager.notify(0, notification);
        } catch (ClassNotFoundException e) {
            Log.e(logTag, "Error parsing remote notification: ClassNotFoundException");
        }
    }
}
