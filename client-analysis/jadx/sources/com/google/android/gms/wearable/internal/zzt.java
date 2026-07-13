package com.google.android.gms.wearable.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzt extends zzau.zza {
    private zzm zzbsk;
    private zzu zzbso;
    private final Object zzpV = new Object();

    public void zza(zzu zzuVar) {
        zzm zzmVar;
        synchronized (this.zzpV) {
            this.zzbso = (zzu) com.google.android.gms.common.internal.zzx.zzz(zzuVar);
            zzmVar = this.zzbsk;
        }
        if (zzmVar != null) {
            zzuVar.zzb(zzmVar);
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzau
    public void zzy(int i, int i2) {
        zzu zzuVar;
        zzm zzmVar;
        synchronized (this.zzpV) {
            zzuVar = this.zzbso;
            zzmVar = new zzm(i, i2);
            this.zzbsk = zzmVar;
        }
        if (zzuVar != null) {
            zzuVar.zzb(zzmVar);
        }
    }
}
