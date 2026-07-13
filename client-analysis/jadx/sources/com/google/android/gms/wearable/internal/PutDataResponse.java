package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class PutDataResponse implements SafeParcelable {
    public static final Parcelable.Creator<PutDataResponse> CREATOR = new zzbf();
    public final int statusCode;
    public final int versionCode;
    public final DataItemParcelable zzbsJ;

    PutDataResponse(int versionCode, int statusCode, DataItemParcelable dataItem) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsJ = dataItem;
    }

    public PutDataResponse(int statusCode, DataItemParcelable dataItem) {
        this(1, statusCode, dataItem);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbf.zza(this, dest, flags);
    }
}
