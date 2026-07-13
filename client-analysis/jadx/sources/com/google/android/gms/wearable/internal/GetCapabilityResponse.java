package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class GetCapabilityResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCapabilityResponse> CREATOR = new zzai();
    public final int statusCode;
    public final int versionCode;
    public final CapabilityInfoParcelable zzbsB;

    GetCapabilityResponse(int versionCode, int statusCode, CapabilityInfoParcelable capability) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsB = capability;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzai.zza(this, dest, flags);
    }
}
