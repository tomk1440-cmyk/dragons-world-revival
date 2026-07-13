package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.zzaf;

/* JADX INFO: loaded from: classes.dex */
public class DataItemBuffer extends com.google.android.gms.common.data.zzf<DataItem> implements Result {
    private final Status zzUX;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzUX = new Status(dataHolder.getStatusCode());
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String zzqg() {
        return "path";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* JADX INFO: renamed from: zzx, reason: merged with bridge method [inline-methods] */
    public DataItem zzk(int i, int i2) {
        return new zzaf(this.zzahi, i, i2);
    }
}
