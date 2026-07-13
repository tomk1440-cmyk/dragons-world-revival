package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;

/* JADX INFO: loaded from: classes.dex */
public class zzg {
    private final Context zzQC;
    private final Context zzsa;

    public zzg(Context context) {
        com.google.android.gms.common.internal.zzx.zzz(context);
        Context applicationContext = context.getApplicationContext();
        com.google.android.gms.common.internal.zzx.zzb(applicationContext, "Application context can't be null");
        this.zzsa = applicationContext;
        this.zzQC = applicationContext;
    }

    public Context getApplicationContext() {
        return this.zzsa;
    }

    protected zzu zza(zzf zzfVar) {
        return new zzu(zzfVar);
    }

    protected com.google.android.gms.measurement.zzg zzab(Context context) {
        return com.google.android.gms.measurement.zzg.zzaS(context);
    }

    protected zzk zzb(zzf zzfVar) {
        return new zzk(zzfVar);
    }

    protected zza zzc(zzf zzfVar) {
        return new zza(zzfVar);
    }

    protected zzn zzd(zzf zzfVar) {
        return new zzn(zzfVar);
    }

    protected zzan zze(zzf zzfVar) {
        return new zzan(zzfVar);
    }

    protected zzaf zzf(zzf zzfVar) {
        return new zzaf(zzfVar);
    }

    protected zzr zzg(zzf zzfVar) {
        return new zzr(zzfVar);
    }

    protected zzmq zzh(zzf zzfVar) {
        return zzmt.zzsc();
    }

    protected GoogleAnalytics zzi(zzf zzfVar) {
        return new GoogleAnalytics(zzfVar);
    }

    zzl zzj(zzf zzfVar) {
        return new zzl(zzfVar, this);
    }

    public Context zzjx() {
        return this.zzQC;
    }

    zzag zzk(zzf zzfVar) {
        return new zzag(zzfVar);
    }

    protected zzb zzl(zzf zzfVar) {
        return new zzb(zzfVar, this);
    }

    public zzj zzm(zzf zzfVar) {
        return new zzj(zzfVar);
    }

    public zzah zzn(zzf zzfVar) {
        return new zzah(zzfVar);
    }

    public zzi zzo(zzf zzfVar) {
        return new zzi(zzfVar);
    }

    public zzv zzp(zzf zzfVar) {
        return new zzv(zzfVar);
    }

    public zzai zzq(zzf zzfVar) {
        return new zzai(zzfVar);
    }
}
