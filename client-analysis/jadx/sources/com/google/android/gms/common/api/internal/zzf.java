package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzf implements Releasable, Result {
    protected final Status zzUX;
    protected final DataHolder zzahi;

    protected zzf(DataHolder dataHolder, Status status) {
        this.zzUX = status;
        this.zzahi = dataHolder;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
        if (this.zzahi != null) {
            this.zzahi.close();
        }
    }
}
