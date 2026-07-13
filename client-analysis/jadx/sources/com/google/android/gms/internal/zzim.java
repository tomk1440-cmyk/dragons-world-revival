package com.google.android.gms.internal;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class zzim implements zzit<Future> {
    private volatile Thread zzLM;
    private boolean zzLN;
    private final Runnable zzx;

    public zzim() {
        this.zzx = new Runnable() { // from class: com.google.android.gms.internal.zzim.1
            @Override // java.lang.Runnable
            public final void run() {
                zzim.this.zzLM = Thread.currentThread();
                zzim.this.zzbr();
            }
        };
        this.zzLN = false;
    }

    public zzim(boolean z) {
        this.zzx = new Runnable() { // from class: com.google.android.gms.internal.zzim.1
            @Override // java.lang.Runnable
            public final void run() {
                zzim.this.zzLM = Thread.currentThread();
                zzim.this.zzbr();
            }
        };
        this.zzLN = z;
    }

    @Override // com.google.android.gms.internal.zzit
    public final void cancel() {
        onStop();
        if (this.zzLM != null) {
            this.zzLM.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzbr();

    @Override // com.google.android.gms.internal.zzit
    /* JADX INFO: renamed from: zzhn, reason: merged with bridge method [inline-methods] */
    public final Future zzgd() {
        return this.zzLN ? zziq.zza(1, this.zzx) : zziq.zza(this.zzx);
    }
}
