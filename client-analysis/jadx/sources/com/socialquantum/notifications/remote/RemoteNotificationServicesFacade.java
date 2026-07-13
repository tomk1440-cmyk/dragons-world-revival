package com.socialquantum.notifications.remote;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.socialquantum.notifications.local.ActivityUtil;

/* JADX INFO: loaded from: classes.dex */
public class RemoteNotificationServicesFacade {
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    public static String TAG = GoogleCloudMessaging.INSTANCE_ID_SCOPE;

    public static void Init(String gameObjectName) {
        Log.i(TAG, "Init, gameObjectName=" + gameObjectName);
    }

    public static void RegisterForRemoteNotifications() {
        Log.i(TAG, "RegisterForRemoteNotifications");
        try {
            Log.i(TAG, "GooglePlayService available");
            Activity activity = ActivityUtil.getActivity();
            Intent intent = new Intent(activity, (Class<?>) GCMRegistrationService.class);
            activity.startService(intent);
        } catch (Exception ex) {
            Log.e(TAG, "RegisterForRemoteNotifications", ex);
        }
    }

    public static void UnregisterForRemoteNotifications() {
        Log.i(TAG, "UnregisterForRemoteNotifications");
    }

    public static String GetRegistrationId() {
        Log.i(TAG, "GetRegistrationId");
        return "";
    }

    private static boolean checkPlayServices() {
        Activity activity = ActivityUtil.getActivity();
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (resultCode != 0) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, activity, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i(TAG, "This device is not supported.");
            }
            return false;
        }
        return true;
    }
}
