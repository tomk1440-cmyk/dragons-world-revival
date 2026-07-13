package com.socialquantum.notifications.remote;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.gcm.GcmListenerService;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.socialquantum.notifications.local.ActivityUtil;

/* JADX INFO: loaded from: classes.dex */
public class GCMListenerService extends GcmListenerService {
    public static String TAG = GoogleCloudMessaging.INSTANCE_ID_SCOPE;

    @Override // com.google.android.gms.gcm.GcmListenerService
    @TargetApi(4)
    public void onMessageReceived(String message, Bundle bundle) {
        Context context = getApplicationContext();
        Log.i(TAG, "Мessage for " + message + "; running in context : " + context + "; content : " + bundle);
        ActivityUtil.CreateNotification(context, bundle.getString("message"), "remote_notification", bundle);
    }
}
