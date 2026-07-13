package com.socialquantum.notifications.remote;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.socialquantum.notifications.local.ActivityUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class GCMRegistrationService extends IntentService {
    private static final String TAG = "GCMRegistrationService";

    public GCMRegistrationService() {
        super(TAG);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        try {
            synchronized (TAG) {
                try {
                    InstanceID instanceID = InstanceID.getInstance(this);
                    String token = instanceID.getToken("1058217148123", GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
                    Log.i(TAG, "GCMRegistrationService.onHandleIntent, token=" + token);
                    ActivityUtil.UnitySend("DeviceBridge", "WriteDeviceToken", token);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
