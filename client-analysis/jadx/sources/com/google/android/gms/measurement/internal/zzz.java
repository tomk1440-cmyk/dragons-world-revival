package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class zzz extends zzy {
    private boolean zzQk;
    private boolean zzQl;
    private boolean zzaYC;

    zzz(zzw zzwVar) {
        super(zzwVar);
        this.zzaTV.zzb(this);
    }

    boolean isInitialized() {
        return this.zzQk && !this.zzQl;
    }

    boolean zzDi() {
        return this.zzaYC;
    }

    public final void zza() {
        if (this.zzQk) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zziJ();
        this.zzaTV.zzDg();
        this.zzQk = true;
    }

    protected abstract void zziJ();

    protected void zzjv() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
