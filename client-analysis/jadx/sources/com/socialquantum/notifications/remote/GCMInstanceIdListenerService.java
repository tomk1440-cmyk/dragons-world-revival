package com.socialquantum.notifications.remote;

import android.content.Intent;
import com.google.android.gms.iid.InstanceIDListenerService;

/* JADX INFO: loaded from: classes.dex */
public class GCMInstanceIdListenerService extends InstanceIDListenerService {

    public class MyInstanceIdListenerService extends InstanceIDListenerService {
        public MyInstanceIdListenerService() {
        }

        @Override // com.google.android.gms.iid.InstanceIDListenerService
        public void onTokenRefresh() {
            Intent intent = new Intent(this, (Class<?>) GCMRegistrationService.class);
            startService(intent);
        }
    }
}
