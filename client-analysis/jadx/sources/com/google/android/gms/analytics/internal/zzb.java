package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class zzb extends zzd {
    private final zzl zzQb;

    public zzb(zzf zzfVar, zzg zzgVar) {
        super(zzfVar);
        com.google.android.gms.common.internal.zzx.zzz(zzgVar);
        this.zzQb = zzgVar.zzj(zzfVar);
    }

    void onServiceConnected() {
        zzjk();
        this.zzQb.onServiceConnected();
    }

    public void setLocalDispatchPeriod(final int dispatchPeriodInSeconds) {
        zzjv();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(dispatchPeriodInSeconds));
        zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzb.1
            @Override // java.lang.Runnable
            public void run() {
                zzb.this.zzQb.zzs(((long) dispatchPeriodInSeconds) * 1000);
            }
        });
    }

    public void start() {
        this.zzQb.start();
    }

    public void zzJ(final boolean z) {
        zza("Network connectivity status changed", Boolean.valueOf(z));
        zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzb.2
            @Override // java.lang.Runnable
            public void run() {
                zzb.this.zzQb.zzJ(z);
            }
        });
    }

    public long zza(zzh zzhVar) {
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(zzhVar);
        zzjk();
        long jZza = this.zzQb.zza(zzhVar, true);
        if (jZza == 0) {
            this.zzQb.zzc(zzhVar);
        }
        return jZza;
    }

    public void zza(final zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzabVar);
        zzjv();
        zzb("Hit delivery requested", zzabVar);
        zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzb.4
            @Override // java.lang.Runnable
            public void run() {
                zzb.this.zzQb.zza(zzabVar);
            }
        });
    }

    public void zza(final zzw zzwVar) {
        zzjv();
        zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzb.6
            @Override // java.lang.Runnable
            public void run() {
                zzb.this.zzQb.zzb(zzwVar);
            }
        });
    }

    public void zza(final String str, final Runnable runnable) {
        com.google.android.gms.common.internal.zzx.zzh(str, "campaign param can't be empty");
        zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzb.3
            @Override // java.lang.Runnable
            public void run() {
                zzb.this.zzQb.zzbl(str);
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        this.zzQb.zza();
    }

    public void zzjc() {
        zzjv();
        zzjj();
        zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzb.5
            @Override // java.lang.Runnable
            public void run() {
                zzb.this.zzQb.zzjc();
            }
        });
    }

    public void zzjd() {
        zzjv();
        Context context = getContext();
        if (!AnalyticsReceiver.zzY(context) || !AnalyticsService.zzZ(context)) {
            zza((zzw) null);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AnalyticsService.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        context.startService(intent);
    }

    public boolean zzje() {
        zzjv();
        try {
            zzjo().zzc(new Callable<Void>() { // from class: com.google.android.gms.analytics.internal.zzb.7
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: zzdt, reason: merged with bridge method [inline-methods] */
                public Void call() throws Exception {
                    zzb.this.zzQb.zzka();
                    return null;
                }
            }).get(4L, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzd("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public void zzjf() {
        zzjv();
        com.google.android.gms.measurement.zzg.zzjk();
        this.zzQb.zzjf();
    }

    public void zzjg() {
        zzbd("Radio powered up");
        zzjd();
    }

    void zzjh() {
        zzjk();
        this.zzQb.zzjh();
    }
}
