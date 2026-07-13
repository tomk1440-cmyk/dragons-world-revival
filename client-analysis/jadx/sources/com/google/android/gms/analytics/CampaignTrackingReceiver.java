package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;

/* JADX INFO: loaded from: classes.dex */
public class CampaignTrackingReceiver extends BroadcastReceiver {
    static zzrp zzOM;
    static Boolean zzON;
    static Object zzqy = new Object();

    public static boolean zzY(Context context) {
        zzx.zzz(context);
        if (zzON != null) {
            return zzON.booleanValue();
        }
        boolean zZza = zzam.zza(context, (Class<? extends BroadcastReceiver>) CampaignTrackingReceiver.class, true);
        zzON = Boolean.valueOf(zZza);
        return zZza;
    }

    @Override // android.content.BroadcastReceiver
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onReceive(Context context, Intent intent) {
        zzf zzfVarZzaa = zzf.zzaa(context);
        zzaf zzafVarZzjm = zzfVarZzaa.zzjm();
        String stringExtra = intent.getStringExtra(Constants.REFERRER);
        String action = intent.getAction();
        zzafVarZzjm.zza("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            zzafVarZzjm.zzbg("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean zZzZ = CampaignTrackingService.zzZ(context);
        if (!zZzZ) {
            zzafVarZzjm.zzbg("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzaV(stringExtra);
        if (zzfVarZzaa.zzjn().zzkr()) {
            zzafVarZzjm.zzbh("Received unexpected installation campaign on package side");
            return;
        }
        Class<? extends CampaignTrackingService> clsZziB = zziB();
        zzx.zzz(clsZziB);
        Intent intent2 = new Intent(context, clsZziB);
        intent2.putExtra(Constants.REFERRER, stringExtra);
        synchronized (zzqy) {
            context.startService(intent2);
            if (zZzZ) {
                try {
                    if (zzOM == null) {
                        zzOM = new zzrp(context, 1, "Analytics campaign WakeLock");
                        zzOM.setReferenceCounted(false);
                    }
                    zzOM.acquire(1000L);
                } catch (SecurityException e) {
                    zzafVarZzjm.zzbg("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
            }
        }
    }

    protected void zzaV(String str) {
    }

    protected Class<? extends CampaignTrackingService> zziB() {
        return CampaignTrackingService.class;
    }
}
