package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.internal.zzmq;

/* JADX INFO: loaded from: classes.dex */
public class zzad extends zzz {
    private Handler mHandler;
    private long zzaZa;
    private final Runnable zzaZb;
    private final zzf zzaZc;
    private final zzf zzaZd;

    zzad(zzw zzwVar) {
        super(zzwVar);
        this.zzaZb = new Runnable() { // from class: com.google.android.gms.measurement.internal.zzad.1
            @Override // java.lang.Runnable
            @MainThread
            public void run() {
                zzad.this.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzad.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzad.this.zzDx();
                    }
                });
            }
        };
        this.zzaZc = new zzf(this.zzaTV) { // from class: com.google.android.gms.measurement.internal.zzad.2
            @Override // com.google.android.gms.measurement.internal.zzf
            @WorkerThread
            public void run() {
                zzad.this.zzDy();
            }
        };
        this.zzaZd = new zzf(this.zzaTV) { // from class: com.google.android.gms.measurement.internal.zzad.3
            @Override // com.google.android.gms.measurement.internal.zzf
            @WorkerThread
            public void run() {
                zzad.this.zzDz();
            }
        };
    }

    private void zzDv() {
        synchronized (this) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zzDy() {
        zzjk();
        zzAo().zzCK().zzj("Session started, time", Long.valueOf(zzjl().elapsedRealtime()));
        zzCo().zzaXu.set(false);
        zzCf().zze("auto", "_s", new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zzDz() {
        zzjk();
        long jElapsedRealtime = zzjl().elapsedRealtime();
        if (this.zzaZa == 0) {
            this.zzaZa = jElapsedRealtime - 3600000;
        }
        long j = zzCo().zzaXw.get() + (jElapsedRealtime - this.zzaZa);
        zzCo().zzaXw.set(j);
        zzAo().zzCK().zzj("Recording user engagement, ms", Long.valueOf(j));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j);
        zzCf().zze("auto", "_e", bundle);
        zzCo().zzaXw.set(0L);
        this.zzaZa = jElapsedRealtime;
        this.zzaZd.zzt(Math.max(0L, 3600000 - zzCo().zzaXw.get()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zzae(long j) {
        zzjk();
        zzDv();
        this.zzaZc.cancel();
        this.zzaZd.cancel();
        zzAo().zzCK().zzj("Activity resumed, time", Long.valueOf(j));
        this.zzaZa = j;
        if (zzjl().currentTimeMillis() - zzCo().zzaXt.get() > zzCo().zzaXv.get()) {
            zzCo().zzaXu.set(true);
            zzCo().zzaXw.set(0L);
        }
        if (zzCo().zzaXu.get()) {
            this.zzaZc.zzt(Math.max(0L, zzCo().zzaXs.get() - zzCo().zzaXw.get()));
        } else {
            this.zzaZd.zzt(Math.max(0L, 3600000 - zzCo().zzaXw.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zzaf(long j) {
        zzjk();
        zzDv();
        this.zzaZc.cancel();
        this.zzaZd.cancel();
        zzAo().zzCK().zzj("Activity paused, time", Long.valueOf(j));
        if (this.zzaZa != 0) {
            zzCo().zzaXw.set(zzCo().zzaXw.get() + (j - this.zzaZa));
        }
        zzCo().zzaXv.set(zzjl().currentTimeMillis());
        synchronized (this) {
            if (!zzCo().zzaXu.get()) {
                this.mHandler.postDelayed(this.zzaZb, 1000L);
            }
        }
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

    @MainThread
    protected void zzDu() {
        synchronized (this) {
            zzDv();
            this.mHandler.removeCallbacks(this.zzaZb);
        }
        final long jElapsedRealtime = zzjl().elapsedRealtime();
        zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzad.4
            @Override // java.lang.Runnable
            public void run() {
                zzad.this.zzae(jElapsedRealtime);
            }
        });
    }

    @MainThread
    protected void zzDw() {
        final long jElapsedRealtime = zzjl().elapsedRealtime();
        zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzad.5
            @Override // java.lang.Runnable
            public void run() {
                zzad.this.zzaf(jElapsedRealtime);
            }
        });
    }

    @WorkerThread
    public void zzDx() {
        zzjk();
        zzAo().zzCJ().zzfg("Application backgrounded. Logging engagement");
        long j = zzCo().zzaXw.get();
        if (j <= 0) {
            zzAo().zzCF().zzj("Not logging non-positive engagement time", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j);
        zzCf().zze("auto", "_e", bundle);
        zzCo().zzaXw.set(0L);
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
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
}
