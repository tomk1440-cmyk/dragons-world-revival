package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* JADX INFO: loaded from: classes.dex */
public final class zzz extends com.google.android.gms.common.data.zzc implements DataEvent {
    private final int zzaDQ;

    public zzz(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaDQ = i2;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public DataItem getDataItem() {
        return new zzaf(this.zzahi, this.zzaje, this.zzaDQ);
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public int getType() {
        return getInteger("event_type");
    }

    public String toString() {
        String str;
        if (getType() == 1) {
            str = "changed";
        } else {
            str = getType() == 2 ? "deleted" : "unknown";
        }
        return "DataEventRef{ type=" + str + ", dataitem=" + getDataItem() + " }";
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzIK, reason: merged with bridge method [inline-methods] */
    public DataEvent freeze() {
        return new zzy(this);
    }
}
