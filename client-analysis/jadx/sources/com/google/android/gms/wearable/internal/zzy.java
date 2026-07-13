package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* JADX INFO: loaded from: classes.dex */
public class zzy implements DataEvent {
    private int zzabB;
    private DataItem zzbsv;

    public zzy(DataEvent dataEvent) {
        this.zzabB = dataEvent.getType();
        this.zzbsv = dataEvent.getDataItem().freeze();
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public DataItem getDataItem() {
        return this.zzbsv;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public int getType() {
        return this.zzabB;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        String str;
        if (getType() == 1) {
            str = "changed";
        } else {
            str = getType() == 2 ? "deleted" : "unknown";
        }
        return "DataEventEntity{ type=" + str + ", dataitem=" + getDataItem() + " }";
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzIK, reason: merged with bridge method [inline-methods] */
    public DataEvent freeze() {
        return this;
    }
}
