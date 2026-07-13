package com.socialquantum.notifications.local;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;
import com.example.local_notifications.R;
import com.google.android.gms.drive.DriveFile;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class ActivityUtil {
    private static final String TAG = "sq.ActivityUtil";
    private static Activity activity = UnityPlayer.currentActivity;

    public static void Init(Activity activity2) {
        activity = activity2;
    }

    public static Activity getActivity() {
        return activity;
    }

    public static void UnitySend(String recieverName, String method, String message) {
        UnityPlayer.UnitySendMessage(recieverName, method, message);
    }

    public static void CreateNotification(Context context, String message, String notificationId, Bundle extras) {
        int icon = context.getApplicationInfo().icon;
        int stringId = context.getApplicationInfo().labelRes;
        String title = context.getString(stringId);
        Log.i(TAG, "CreateNotification : ctx:" + context + "; icon:" + icon + "; titile" + title + "; message:" + message + "; id:" + notificationId + "; extras:" + extras);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(icon);
        builder.setContentTitle(title);
        builder.setContentText(message);
        String packageName = context.getPackageName();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        intent.addFlags(DriveFile.MODE_WRITE_ONLY);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 134217728);
        builder.setContentIntent(pendingIntent);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setDefaults(7);
        builder.setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(title).bigText(message));
        if (Build.VERSION.SDK_INT >= 15) {
            RemoteViews content = new RemoteViews(context.getPackageName(), R.layout.notification);
            content.setTextViewText(R.id.textTitle, title);
            content.setTextViewText(R.id.textMessage, message);
            builder.setContent(content);
        }
        Notification notification = builder.build();
        if (Build.VERSION.SDK_INT >= 16) {
            RemoteViews bigContent = new RemoteViews(context.getPackageName(), R.layout.big_notification);
            bigContent.setTextViewText(R.id.textTitle, title);
            bigContent.setTextViewText(R.id.textMessage, message);
            notification.bigContentView = bigContent;
        }
        ((NotificationManager) context.getSystemService("notification")).notify(0, notification);
        Log.i(TAG, "CreateNotification : donne");
    }
}
