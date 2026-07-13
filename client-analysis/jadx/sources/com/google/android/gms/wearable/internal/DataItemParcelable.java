package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DataItemParcelable implements SafeParcelable, DataItem {
    public static final Parcelable.Creator<DataItemParcelable> CREATOR = new zzae();
    private final Uri mUri;
    final int mVersionCode;
    private byte[] zzaKm;
    private final Map<String, DataItemAsset> zzbsy;

    DataItemParcelable(int versionCode, Uri uri, Bundle assetBundle, byte[] data) {
        this.mVersionCode = versionCode;
        this.mUri = uri;
        HashMap map = new HashMap();
        assetBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : assetBundle.keySet()) {
            map.put(str, (DataItemAssetParcelable) assetBundle.getParcelable(str));
        }
        this.zzbsy = map;
        this.zzaKm = data;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Map<String, DataItemAsset> getAssets() {
        return this.zzbsy;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public byte[] getData() {
        return this.zzaKm;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder sb = new StringBuilder("DataItemParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(",dataSz=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)));
        sb.append(", numAssets=" + this.zzbsy.size());
        sb.append(", uri=" + this.mUri);
        if (!verbose) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.zzbsy.keySet()) {
            sb.append("\n    " + str + ": " + this.zzbsy.get(str));
        }
        sb.append("\n  ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzae.zza(this, dest, flags);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzIN, reason: merged with bridge method [inline-methods] */
    public DataItemParcelable freeze() {
        return this;
    }

    public Bundle zzIv() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Map.Entry<String, DataItemAsset> entry : this.zzbsy.entrySet()) {
            bundle.putParcelable(entry.getKey(), new DataItemAssetParcelable(entry.getValue()));
        }
        return bundle;
    }

    @Override // com.google.android.gms.wearable.DataItem
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public DataItemParcelable setData(byte[] bArr) {
        this.zzaKm = bArr;
        return this;
    }
}
