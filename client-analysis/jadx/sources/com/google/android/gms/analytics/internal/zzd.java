package com.google.android.gms.analytics.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzd extends zzc {
    private boolean zzQk;
    private boolean zzQl;

    protected zzd(zzf zzfVar) {
        super(zzfVar);
    }

    public boolean isInitialized() {
        return this.zzQk && !this.zzQl;
    }

    public void zza() {
        zziJ();
        this.zzQk = true;
    }

    protected abstract void zziJ();

    protected void zzjv() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
