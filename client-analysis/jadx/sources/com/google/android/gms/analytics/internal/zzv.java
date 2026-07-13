package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.analytics.AnalyticsReceiver;

/* JADX INFO: loaded from: classes.dex */
public class zzv extends zzd {
    private boolean zzRG;
    private boolean zzRH;
    private AlarmManager zzRI;

    protected zzv(zzf zzfVar) {
        super(zzfVar);
        this.zzRI = (AlarmManager) getContext().getSystemService("alarm");
    }

    private PendingIntent zzld() {
        Intent intent = new Intent(getContext(), (Class<?>) AnalyticsReceiver.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(getContext(), 0, intent, 0);
    }

    public void cancel() {
        zzjv();
        this.zzRH = false;
        this.zzRI.cancel(zzld());
    }

    public boolean zzbw() {
        return this.zzRH;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        ActivityInfo receiverInfo;
        try {
            this.zzRI.cancel(zzld());
            if (zzjn().zzkA() <= 0 || (receiverInfo = getContext().getPackageManager().getReceiverInfo(new ComponentName(getContext(), (Class<?>) AnalyticsReceiver.class), 2)) == null || !receiverInfo.enabled) {
                return;
            }
            zzbd("Receiver registered. Using alarm for local dispatch.");
            this.zzRG = true;
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public boolean zzlb() {
        return this.zzRG;
    }

    public void zzlc() {
        zzjv();
        com.google.android.gms.common.internal.zzx.zza(zzlb(), "Receiver not registered");
        long jZzkA = zzjn().zzkA();
        if (jZzkA > 0) {
            cancel();
            long jElapsedRealtime = zzjl().elapsedRealtime() + jZzkA;
            this.zzRH = true;
            this.zzRI.setInexactRepeating(2, jElapsedRealtime, 0L, zzld());
        }
    }
}
