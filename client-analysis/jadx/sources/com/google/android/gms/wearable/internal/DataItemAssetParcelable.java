package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItemAsset;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzab();
    final int mVersionCode;
    private final String zzvs;
    private final String zzyv;

    DataItemAssetParcelable(int versionCode, String id, String key) {
        this.mVersionCode = versionCode;
        this.zzyv = id;
        this.zzvs = key;
    }

    public DataItemAssetParcelable(DataItemAsset value) {
        this.mVersionCode = 1;
        this.zzyv = (String) com.google.android.gms.common.internal.zzx.zzz(value.getId());
        this.zzvs = (String) com.google.android.gms.common.internal.zzx.zzz(value.getDataItemKey());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        sb.append("DataItemAssetParcelable[");
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzab.zza(this, dest, flags);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzIL, reason: merged with bridge method [inline-methods] */
    public DataItemAsset freeze() {
        return this;
    }
}
