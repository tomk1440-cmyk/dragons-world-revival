package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;

/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsReceiver extends BroadcastReceiver {
    static zzrp zzOM;
    static Boolean zzON;
    static Object zzqy = new Object();

    public static boolean zzY(Context context) {
        zzx.zzz(context);
        if (zzON != null) {
            return zzON.booleanValue();
        }
        boolean zZza = zzam.zza(context, (Class<? extends BroadcastReceiver>) AnalyticsReceiver.class, false);
        zzON = Boolean.valueOf(zZza);
        return zZza;
    }

    @Override // android.content.BroadcastReceiver
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onReceive(Context context, Intent intent) {
        zzf zzfVarZzaa = zzf.zzaa(context);
        zzaf zzafVarZzjm = zzfVarZzaa.zzjm();
        String action = intent.getAction();
        if (zzfVarZzaa.zzjn().zzkr()) {
            zzafVarZzjm.zza("Device AnalyticsReceiver got", action);
        } else {
            zzafVarZzjm.zza("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zZzZ = AnalyticsService.zzZ(context);
            Intent intent2 = new Intent(context, (Class<?>) AnalyticsService.class);
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (zzqy) {
                context.startService(intent2);
                if (zZzZ) {
                    try {
                        if (zzOM == null) {
                            zzOM = new zzrp(context, 1, "Analytics WakeLock");
                            zzOM.setReferenceCounted(false);
                        }
                        zzOM.acquire(1000L);
                    } catch (SecurityException e) {
                        zzafVarZzjm.zzbg("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }
}
