package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class GetConfigsResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetConfigsResponse> CREATOR = new zzap();
    public final int statusCode;
    public final int versionCode;
    public final ConnectionConfiguration[] zzbsH;

    GetConfigsResponse(int versionCode, int statusCode, ConnectionConfiguration[] configs) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsH = configs;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzap.zza(this, dest, flags);
    }
}
