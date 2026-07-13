package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

/* JADX INFO: loaded from: classes.dex */
public class zzaa implements DataItemAsset {
    private final String zzvs;
    private final String zzyv;

    public zzaa(DataItemAsset dataItemAsset) {
        this.zzyv = dataItemAsset.getId();
        this.zzvs = dataItemAsset.getDataItemKey();
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String getDataItemKey() {
        return this.zzvs;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetEntity[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zzyv == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.zzyv);
        }
        sb.append(", key=");
        sb.append(this.zzvs);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzIL, reason: merged with bridge method [inline-methods] */
    public DataItemAsset freeze() {
        return this;
    }
}
