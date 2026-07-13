package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GetConfigResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetConfigResponse> CREATOR = new zzao();
    public final int statusCode;
    public final int versionCode;
    public final ConnectionConfiguration zzbsG;

    GetConfigResponse(int versionCode, int statusCode, ConnectionConfiguration config) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsG = config;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzao.zza(this, dest, flags);
    }
}
