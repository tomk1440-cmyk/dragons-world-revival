package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
abstract class zzf {
    private static volatile Handler zzRC;
    private volatile long zzRD;
    private final zzw zzaTV;
    private boolean zzaVI;
    private final Runnable zzx;

    zzf(zzw zzwVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzwVar);
        this.zzaTV = zzwVar;
        this.zzaVI = true;
        this.zzx = new Runnable() { // from class: com.google.android.gms.measurement.internal.zzf.1
            @Override // java.lang.Runnable
            public void run() {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    zzf.this.zzaTV.zzCn().zzg(this);
                    return;
                }
                boolean zZzbw = zzf.this.zzbw();
                zzf.this.zzRD = 0L;
                if (zZzbw && zzf.this.zzaVI) {
                    zzf.this.run();
                }
            }
        };
    }

    private Handler getHandler() {
        Handler handler;
        if (zzRC != null) {
            return zzRC;
        }
        synchronized (zzf.class) {
            if (zzRC == null) {
                zzRC = new Handler(this.zzaTV.getContext().getMainLooper());
            }
            handler = zzRC;
        }
        return handler;
    }

    public void cancel() {
        this.zzRD = 0L;
        getHandler().removeCallbacks(this.zzx);
    }

    public abstract void run();

    public boolean zzbw() {
        return this.zzRD != 0;
    }

    public void zzt(long j) {
        cancel();
        if (j >= 0) {
            this.zzRD = this.zzaTV.zzjl().currentTimeMillis();
            if (getHandler().postDelayed(this.zzx, j)) {
                return;
            }
            this.zzaTV.zzAo().zzCE().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }
}
