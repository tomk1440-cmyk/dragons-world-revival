package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GetAllCapabilitiesResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetAllCapabilitiesResponse> CREATOR = new zzah();
    public final int statusCode;
    public final int versionCode;
    final List<CapabilityInfoParcelable> zzbsA;

    GetAllCapabilitiesResponse(int versionCode, int statusCode, List<CapabilityInfoParcelable> capabilities) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsA = capabilities;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzah.zza(this, dest, flags);
    }
}
