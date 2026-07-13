package com.google.android.gms.cast.internal;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzp {
    private static final zzl zzaaf = new zzl("RequestTracker");
    public static final Object zzaeB = new Object();
    private zzo zzaeA;
    private long zzaey;
    private long zzacY = -1;
    private long zzaez = 0;

    public zzp(long j) {
        this.zzaey = j;
    }

    private void zzoz() {
        this.zzacY = -1L;
        this.zzaeA = null;
        this.zzaez = 0L;
    }

    public void clear() {
        synchronized (zzaeB) {
            if (this.zzacY != -1) {
                zzoz();
            }
        }
    }

    public boolean zzB(long j) {
        boolean z;
        synchronized (zzaeB) {
            z = this.zzacY != -1 && this.zzacY == j;
        }
        return z;
    }

    public void zza(long j, zzo zzoVar) {
        zzo zzoVar2;
        long j2;
        synchronized (zzaeB) {
            zzoVar2 = this.zzaeA;
            j2 = this.zzacY;
            this.zzacY = j;
            this.zzaeA = zzoVar;
            this.zzaez = SystemClock.elapsedRealtime();
        }
        if (zzoVar2 != null) {
            zzoVar2.zzy(j2);
        }
    }

    public boolean zzc(long j, int i) {
        return zzc(j, i, null);
    }

    public boolean zzc(long j, int i, Object obj) {
        boolean z = true;
        zzo zzoVar = null;
        synchronized (zzaeB) {
            if (this.zzacY == -1 || this.zzacY != j) {
                z = false;
            } else {
                zzaaf.zzb("request %d completed", Long.valueOf(this.zzacY));
                zzoVar = this.zzaeA;
                zzoz();
            }
        }
        if (zzoVar != null) {
            zzoVar.zza(j, i, obj);
        }
        return z;
    }

    public boolean zzd(long j, int i) {
        zzo zzoVar;
        boolean z = true;
        long j2 = 0;
        synchronized (zzaeB) {
            if (this.zzacY == -1 || j - this.zzaez < this.zzaey) {
                z = false;
                zzoVar = null;
            } else {
                zzaaf.zzb("request %d timed out", Long.valueOf(this.zzacY));
                j2 = this.zzacY;
                zzoVar = this.zzaeA;
                zzoz();
            }
        }
        if (zzoVar != null) {
            zzoVar.zza(j2, i, null);
        }
        return z;
    }

    public boolean zzoA() {
        boolean z;
        synchronized (zzaeB) {
            z = this.zzacY != -1;
        }
        return z;
    }
}
