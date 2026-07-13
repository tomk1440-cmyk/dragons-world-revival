package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzmq;

/* JADX INFO: loaded from: classes.dex */
class zzaj {
    private long zzCv;
    private final zzmq zzqW;

    public zzaj(zzmq zzmqVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzmqVar);
        this.zzqW = zzmqVar;
    }

    public zzaj(zzmq zzmqVar, long j) {
        com.google.android.gms.common.internal.zzx.zzz(zzmqVar);
        this.zzqW = zzmqVar;
        this.zzCv = j;
    }

    public void clear() {
        this.zzCv = 0L;
    }

    public void start() {
        this.zzCv = this.zzqW.elapsedRealtime();
    }

    public boolean zzv(long j) {
        return this.zzCv == 0 || this.zzqW.elapsedRealtime() - this.zzCv > j;
    }
}
