package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class NearbyDeviceFilter implements SafeParcelable {
    public static final Parcelable.Creator<NearbyDeviceFilter> CREATOR = new zzg();
    final int mVersionCode;
    final int zzbci;
    final byte[] zzbcj;
    final boolean zzbck;

    NearbyDeviceFilter(int versionCode, int idPrefixType, byte[] idPrefix, boolean shouldMatchUrls) {
        this.mVersionCode = versionCode;
        this.zzbci = idPrefixType;
        this.zzbcj = idPrefix;
        this.zzbck = shouldMatchUrls;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
