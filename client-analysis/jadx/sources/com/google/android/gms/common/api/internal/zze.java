package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zze<L> implements zzq.zzb<L> {
    private final DataHolder zzahi;

    protected zze(DataHolder dataHolder) {
        this.zzahi = dataHolder;
    }

    protected abstract void zza(L l, DataHolder dataHolder);

    @Override // com.google.android.gms.common.api.internal.zzq.zzb
    public void zzpr() {
        if (this.zzahi != null) {
            this.zzahi.close();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzq.zzb
    public final void zzt(L l) {
        zza(l, this.zzahi);
    }
}
