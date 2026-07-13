package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;

/* JADX INFO: loaded from: classes.dex */
public class zzac extends com.google.android.gms.common.data.zzc implements DataItemAsset {
    public zzac(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String getDataItemKey() {
        return getString("asset_key");
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String getId() {
        return getString("asset_id");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzIL, reason: merged with bridge method [inline-methods] */
    public DataItemAsset freeze() {
        return new zzaa(this);
    }
}
