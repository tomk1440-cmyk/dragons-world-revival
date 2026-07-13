package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzmq;

/* JADX INFO: loaded from: classes.dex */
class zzbe implements zzcd {
    private final long zzSP;
    private final int zzSQ;
    private double zzSR;
    private long zzSS;
    private final Object zzST = new Object();
    private final String zzSU;
    private final long zzbjt;
    private final zzmq zzqW;

    public zzbe(int i, long j, long j2, String str, zzmq zzmqVar) {
        this.zzSQ = i;
        this.zzSR = this.zzSQ;
        this.zzSP = j;
        this.zzbjt = j2;
        this.zzSU = str;
        this.zzqW = zzmqVar;
    }

    @Override // com.google.android.gms.tagmanager.zzcd
    public boolean zzlw() {
        boolean z = false;
        synchronized (this.zzST) {
            long jCurrentTimeMillis = this.zzqW.currentTimeMillis();
            if (jCurrentTimeMillis - this.zzSS < this.zzbjt) {
                zzbg.zzaK("Excessive " + this.zzSU + " detected; call ignored.");
            } else {
                if (this.zzSR < this.zzSQ) {
                    double d = (jCurrentTimeMillis - this.zzSS) / this.zzSP;
                    if (d > 0.0d) {
                        this.zzSR = Math.min(this.zzSQ, d + this.zzSR);
                    }
                }
                this.zzSS = jCurrentTimeMillis;
                if (this.zzSR >= 1.0d) {
                    this.zzSR -= 1.0d;
                    z = true;
                } else {
                    zzbg.zzaK("Excessive " + this.zzSU + " detected; call ignored.");
                }
            }
        }
        return z;
    }
}
