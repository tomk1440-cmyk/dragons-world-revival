package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementReceiver extends BroadcastReceiver {
    static zzrp zzOM;
    static Boolean zzON;
    static final Object zzqy = new Object();

    public static boolean zzY(Context context) {
        zzx.zzz(context);
        if (zzON != null) {
            return zzON.booleanValue();
        }
        boolean zZza = zzaj.zza(context, (Class<? extends BroadcastReceiver>) AppMeasurementReceiver.class, false);
        zzON = Boolean.valueOf(zZza);
        return zZza;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        zzw zzwVarZzaT = zzw.zzaT(context);
        zzp zzpVarZzAo = zzwVarZzaT.zzAo();
        String action = intent.getAction();
        if (zzwVarZzaT.zzCp().zzkr()) {
            zzpVarZzAo.zzCK().zzj("Device AppMeasurementReceiver got", action);
        } else {
            zzpVarZzAo.zzCK().zzj("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean zZzZ = AppMeasurementService.zzZ(context);
            Intent intent2 = new Intent(context, (Class<?>) AppMeasurementService.class);
            intent2.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (zzqy) {
                context.startService(intent2);
                if (zZzZ) {
                    try {
                        if (zzOM == null) {
                            zzOM = new zzrp(context, 1, "AppMeasurement WakeLock");
                            zzOM.setReferenceCounted(false);
                        }
                        zzOM.acquire(1000L);
                    } catch (SecurityException e) {
                        zzpVarZzAo.zzCF().zzfg("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                }
            }
        }
    }
}
