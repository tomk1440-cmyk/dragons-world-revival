package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;

/* JADX INFO: loaded from: classes.dex */
public class zzf {
    private static zzf zzQn;
    private final Context mContext;
    private final zzu zzQA;
    private final Context zzQo;
    private final zzr zzQp;
    private final zzaf zzQq;
    private final com.google.android.gms.measurement.zzg zzQr;
    private final zzb zzQs;
    private final zzv zzQt;
    private final zzan zzQu;
    private final zzai zzQv;
    private final GoogleAnalytics zzQw;
    private final zzn zzQx;
    private final zza zzQy;
    private final zzk zzQz;
    private final zzmq zzqW;

    protected zzf(zzg zzgVar) {
        Context applicationContext = zzgVar.getApplicationContext();
        com.google.android.gms.common.internal.zzx.zzb(applicationContext, "Application context can't be null");
        com.google.android.gms.common.internal.zzx.zzb(applicationContext instanceof Application, "getApplicationContext didn't return the application");
        Context contextZzjx = zzgVar.zzjx();
        com.google.android.gms.common.internal.zzx.zzz(contextZzjx);
        this.mContext = applicationContext;
        this.zzQo = contextZzjx;
        this.zzqW = zzgVar.zzh(this);
        this.zzQp = zzgVar.zzg(this);
        zzaf zzafVarZzf = zzgVar.zzf(this);
        zzafVarZzf.zza();
        this.zzQq = zzafVarZzf;
        if (zzjn().zzkr()) {
            zzjm().zzbf("Google Analytics " + zze.VERSION + " is starting up.");
        } else {
            zzjm().zzbf("Google Analytics " + zze.VERSION + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        }
        zzai zzaiVarZzq = zzgVar.zzq(this);
        zzaiVarZzq.zza();
        this.zzQv = zzaiVarZzq;
        zzan zzanVarZze = zzgVar.zze(this);
        zzanVarZze.zza();
        this.zzQu = zzanVarZze;
        zzb zzbVarZzl = zzgVar.zzl(this);
        zzn zznVarZzd = zzgVar.zzd(this);
        zza zzaVarZzc = zzgVar.zzc(this);
        zzk zzkVarZzb = zzgVar.zzb(this);
        zzu zzuVarZza = zzgVar.zza(this);
        com.google.android.gms.measurement.zzg zzgVarZzab = zzgVar.zzab(applicationContext);
        zzgVarZzab.zza(zzjw());
        this.zzQr = zzgVarZzab;
        GoogleAnalytics googleAnalyticsZzi = zzgVar.zzi(this);
        zznVarZzd.zza();
        this.zzQx = zznVarZzd;
        zzaVarZzc.zza();
        this.zzQy = zzaVarZzc;
        zzkVarZzb.zza();
        this.zzQz = zzkVarZzb;
        zzuVarZza.zza();
        this.zzQA = zzuVarZza;
        zzv zzvVarZzp = zzgVar.zzp(this);
        zzvVarZzp.zza();
        this.zzQt = zzvVarZzp;
        zzbVarZzl.zza();
        this.zzQs = zzbVarZzl;
        if (zzjn().zzkr()) {
            zzjm().zzb("Device AnalyticsService version", zze.VERSION);
        }
        googleAnalyticsZzi.zza();
        this.zzQw = googleAnalyticsZzi;
        zzbVarZzl.start();
    }

    private void zza(zzd zzdVar) {
        com.google.android.gms.common.internal.zzx.zzb(zzdVar, "Analytics service not created/initialized");
        com.google.android.gms.common.internal.zzx.zzb(zzdVar.isInitialized(), "Analytics service not initialized");
    }

    public static zzf zzaa(Context context) {
        com.google.android.gms.common.internal.zzx.zzz(context);
        if (zzQn == null) {
            synchronized (zzf.class) {
                if (zzQn == null) {
                    zzmq zzmqVarZzsc = zzmt.zzsc();
                    long jElapsedRealtime = zzmqVarZzsc.elapsedRealtime();
                    zzf zzfVar = new zzf(new zzg(context.getApplicationContext()));
                    zzQn = zzfVar;
                    GoogleAnalytics.zziF();
                    long jElapsedRealtime2 = zzmqVarZzsc.elapsedRealtime() - jElapsedRealtime;
                    long jLongValue = zzy.zzSz.get().longValue();
                    if (jElapsedRealtime2 > jLongValue) {
                        zzfVar.zzjm().zzc("Slow initialization (ms)", Long.valueOf(jElapsedRealtime2), Long.valueOf(jLongValue));
                    }
                }
            }
        }
        return zzQn;
    }

    public Context getContext() {
        return this.mContext;
    }

    public zzb zziH() {
        zza(this.zzQs);
        return this.zzQs;
    }

    public zzan zziI() {
        zza(this.zzQu);
        return this.zzQu;
    }

    public zzai zzjA() {
        if (this.zzQv == null || !this.zzQv.isInitialized()) {
            return null;
        }
        return this.zzQv;
    }

    public zza zzjB() {
        zza(this.zzQy);
        return this.zzQy;
    }

    public zzn zzjC() {
        zza(this.zzQx);
        return this.zzQx;
    }

    public void zzjk() {
        com.google.android.gms.measurement.zzg.zzjk();
    }

    public zzmq zzjl() {
        return this.zzqW;
    }

    public zzaf zzjm() {
        zza(this.zzQq);
        return this.zzQq;
    }

    public zzr zzjn() {
        return this.zzQp;
    }

    public com.google.android.gms.measurement.zzg zzjo() {
        com.google.android.gms.common.internal.zzx.zzz(this.zzQr);
        return this.zzQr;
    }

    public zzv zzjp() {
        zza(this.zzQt);
        return this.zzQt;
    }

    public zzai zzjq() {
        zza(this.zzQv);
        return this.zzQv;
    }

    public zzk zzjt() {
        zza(this.zzQz);
        return this.zzQz;
    }

    public zzu zzju() {
        return this.zzQA;
    }

    protected Thread.UncaughtExceptionHandler zzjw() {
        return new Thread.UncaughtExceptionHandler() { // from class: com.google.android.gms.analytics.internal.zzf.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable error) {
                zzaf zzafVarZzjy = zzf.this.zzjy();
                if (zzafVarZzjy != null) {
                    zzafVarZzjy.zze("Job execution failed", error);
                }
            }
        };
    }

    public Context zzjx() {
        return this.zzQo;
    }

    public zzaf zzjy() {
        return this.zzQq;
    }

    public GoogleAnalytics zzjz() {
        com.google.android.gms.common.internal.zzx.zzz(this.zzQw);
        com.google.android.gms.common.internal.zzx.zzb(this.zzQw.isInitialized(), "Analytics instance not initialized");
        return this.zzQw;
    }
}
