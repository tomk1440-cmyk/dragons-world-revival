package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;

/* JADX INFO: loaded from: classes.dex */
public class zzag extends zzz {
    private boolean zzRH;
    private final AlarmManager zzRI;

    protected zzag(zzw zzwVar) {
        super(zzwVar);
        this.zzRI = (AlarmManager) getContext().getSystemService("alarm");
    }

    private PendingIntent zzld() {
        Intent intent = new Intent(getContext(), (Class<?>) AppMeasurementReceiver.class);
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, intent, 0);
    }

    public void cancel() {
        zzjv();
        this.zzRH = false;
        this.zzRI.cancel(zzld());
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzCd() {
        super.zzCd();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzc zzCe() {
        return super.zzCe();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzab zzCf() {
        return super.zzCf();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzn zzCg() {
        return super.zzCg();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzg zzCh() {
        return super.zzCh();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzac zzCi() {
        return super.zzCi();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zze zzCj() {
        return super.zzCj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzaj zzCk() {
        return super.zzCk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzu zzCl() {
        return super.zzCl();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzad zzCm() {
        return super.zzCm();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzv zzCn() {
        return super.zzCn();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzt zzCo() {
        return super.zzCo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzd zzCp() {
        return super.zzCp();
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
        this.zzRI.cancel(zzld());
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjj() {
        super.zzjj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjk() {
        super.zzjk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzmq zzjl() {
        return super.zzjl();
    }

    public void zzt(long j) {
        zzjv();
        com.google.android.gms.common.internal.zzx.zzac(j > 0);
        com.google.android.gms.common.internal.zzx.zza(AppMeasurementReceiver.zzY(getContext()), "Receiver not registered/enabled");
        com.google.android.gms.common.internal.zzx.zza(AppMeasurementService.zzZ(getContext()), "Service not registered/enabled");
        cancel();
        long jElapsedRealtime = zzjl().elapsedRealtime() + j;
        this.zzRH = true;
        this.zzRI.setInexactRepeating(2, jElapsedRealtime, Math.max(zzCp().zzBZ(), j), zzld());
    }
}
