package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.zzmq;

/* JADX INFO: loaded from: classes.dex */
class zzaf {
    private long zzCv;
    private final zzmq zzqW;

    public zzaf(zzmq zzmqVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzmqVar);
        this.zzqW = zzmqVar;
    }

    public void clear() {
        this.zzCv = 0L;
    }

    public void start() {
        this.zzCv = this.zzqW.elapsedRealtime();
    }

    public boolean zzv(long j) {
        return this.zzCv == 0 || this.zzqW.elapsedRealtime() - this.zzCv >= j;
    }
}
