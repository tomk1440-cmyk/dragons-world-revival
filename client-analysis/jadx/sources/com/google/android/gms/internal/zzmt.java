package com.google.android.gms.internal;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzmt implements zzmq {
    private static zzmt zzaoa;

    public static synchronized zzmq zzsc() {
        if (zzaoa == null) {
            zzaoa = new zzmt();
        }
        return zzaoa;
    }

    @Override // com.google.android.gms.internal.zzmq
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.internal.zzmq
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.internal.zzmq
    public long nanoTime() {
        return System.nanoTime();
    }
}
