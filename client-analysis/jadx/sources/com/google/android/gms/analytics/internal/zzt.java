package com.google.android.gms.analytics.internal;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
abstract class zzt {
    private static volatile Handler zzRC;
    private final zzf zzQj;
    private volatile long zzRD;
    private boolean zzRE;
    private final Runnable zzx;

    zzt(zzf zzfVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzfVar);
        this.zzQj = zzfVar;
        this.zzx = new Runnable() { // from class: com.google.android.gms.analytics.internal.zzt.1
            @Override // java.lang.Runnable
            public void run() {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    zzt.this.zzQj.zzjo().zzf(this);
                    return;
                }
                boolean zZzbw = zzt.this.zzbw();
                zzt.this.zzRD = 0L;
                if (!zZzbw || zzt.this.zzRE) {
                    return;
                }
                zzt.this.run();
            }
        };
    }

    private Handler getHandler() {
        Handler handler;
        if (zzRC != null) {
            return zzRC;
        }
        synchronized (zzt.class) {
            if (zzRC == null) {
                zzRC = new Handler(this.zzQj.getContext().getMainLooper());
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

    public long zzkY() {
        if (this.zzRD == 0) {
            return 0L;
        }
        return Math.abs(this.zzQj.zzjl().currentTimeMillis() - this.zzRD);
    }

    public void zzt(long j) {
        cancel();
        if (j >= 0) {
            this.zzRD = this.zzQj.zzjl().currentTimeMillis();
            if (getHandler().postDelayed(this.zzx, j)) {
                return;
            }
            this.zzQj.zzjm().zze("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public void zzu(long j) {
        if (zzbw()) {
            if (j < 0) {
                cancel();
                return;
            }
            long jAbs = j - Math.abs(this.zzQj.zzjl().currentTimeMillis() - this.zzRD);
            long j2 = jAbs >= 0 ? jAbs : 0L;
            getHandler().removeCallbacks(this.zzx);
            if (getHandler().postDelayed(this.zzx, j2)) {
                return;
            }
            this.zzQj.zzjm().zze("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }
}
