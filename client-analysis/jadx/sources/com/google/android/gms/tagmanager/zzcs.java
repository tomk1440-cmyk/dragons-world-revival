package com.google.android.gms.tagmanager;

/* JADX INFO: loaded from: classes.dex */
class zzcs implements zzcd {
    private final long zzSP;
    private final int zzSQ;
    private double zzSR;
    private final Object zzST;
    private long zzbkO;

    public zzcs() {
        this(60, 2000L);
    }

    public zzcs(int i, long j) {
        this.zzST = new Object();
        this.zzSQ = i;
        this.zzSR = this.zzSQ;
        this.zzSP = j;
    }

    @Override // com.google.android.gms.tagmanager.zzcd
    public boolean zzlw() {
        boolean z;
        synchronized (this.zzST) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.zzSR < this.zzSQ) {
                double d = (jCurrentTimeMillis - this.zzbkO) / this.zzSP;
                if (d > 0.0d) {
                    this.zzSR = Math.min(this.zzSQ, d + this.zzSR);
                }
            }
            this.zzbkO = jCurrentTimeMillis;
            if (this.zzSR >= 1.0d) {
                this.zzSR -= 1.0d;
                z = true;
            } else {
                zzbg.zzaK("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
