package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class GetFdForAssetResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetFdForAssetResponse> CREATOR = new zzas();
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzbsK;

    GetFdForAssetResponse(int versionCode, int statusCode, ParcelFileDescriptor pfd) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsK = pfd;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzas.zza(this, dest, flags | 1);
    }
}
