package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class DeleteDataItemsResponse implements SafeParcelable {
    public static final Parcelable.Creator<DeleteDataItemsResponse> CREATOR = new zzag();
    public final int statusCode;
    public final int versionCode;
    public final int zzbsz;

    DeleteDataItemsResponse(int versionCode, int statusCode, int numDeleted) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsz = numDeleted;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzag.zza(this, dest, flags);
    }
}
