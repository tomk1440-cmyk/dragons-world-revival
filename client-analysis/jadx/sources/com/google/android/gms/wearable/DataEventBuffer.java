package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.zzz;

/* JADX INFO: loaded from: classes.dex */
public class DataEventBuffer extends com.google.android.gms.common.data.zzf<DataEvent> implements Result {
    private final Status zzUX;

    public DataEventBuffer(DataHolder dataHolder) {
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
    /* JADX INFO: renamed from: zzw, reason: merged with bridge method [inline-methods] */
    public DataEvent zzk(int i, int i2) {
        return new zzz(this.zzahi, i, i2);
    }
}
