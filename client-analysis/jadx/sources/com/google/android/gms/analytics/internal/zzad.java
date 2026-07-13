package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzmq;

/* JADX INFO: loaded from: classes.dex */
public class zzad {
    private final long zzSP;
    private final int zzSQ;
    private double zzSR;
    private long zzSS;
    private final Object zzST;
    private final String zzSU;
    private final zzmq zzqW;

    public zzad(int i, long j, String str, zzmq zzmqVar) {
        this.zzST = new Object();
        this.zzSQ = i;
        this.zzSR = this.zzSQ;
        this.zzSP = j;
        this.zzSU = str;
        this.zzqW = zzmqVar;
    }

    public zzad(String str, zzmq zzmqVar) {
        this(60, 2000L, str, zzmqVar);
    }

    public boolean zzlw() {
        boolean z;
        synchronized (this.zzST) {
            long jCurrentTimeMillis = this.zzqW.currentTimeMillis();
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
                zzae.zzaK("Excessive " + this.zzSU + " detected; call ignored.");
                z = false;
            }
        }
        return z;
    }
}
